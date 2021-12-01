package edu.unifacef.inventoryapi.usecases;

import static edu.unifacef.inventoryapi.exceptions.MessageKey.INVENTORY_ALREADY_EXISTS;

import edu.unifacef.inventoryapi.configurations.ff4j.Features;
import edu.unifacef.inventoryapi.domains.Inventory;
import edu.unifacef.inventoryapi.gateways.outputs.InventoryDataGateway;
import edu.unifacef.inventoryapi.gateways.outputs.StoreGateway;
import edu.unifacef.inventoryapi.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ff4j.FF4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateInventory {

  private final InventoryDataGateway inventoryDataGateway;
  private final MessageUtils messageUtils;
  private final StoreGateway storeGateway;
  private final FF4j ff4j;

  public Inventory execute(final Inventory inventory) {
    log.info("Create inventory. Product code: {}", inventory.getProductCode());
    if(inventoryDataGateway.findByCode(inventory.getProductCode()).isPresent()) {
      throw new IllegalArgumentException(
          messageUtils.getMessage(INVENTORY_ALREADY_EXISTS, inventory.getProductCode()));
    }

    Inventory saved = inventoryDataGateway.save(inventory);
    if(ff4j.check(Features.SEND_TO_STORE.getKey())) {
      storeGateway.send(saved);
    }

    return saved;
  }
}

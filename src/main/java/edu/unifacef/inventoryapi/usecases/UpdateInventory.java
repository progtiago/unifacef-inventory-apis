package edu.unifacef.inventoryapi.usecases;

import static edu.unifacef.inventoryapi.exceptions.MessageKey.INVENTORY_NOT_FOUND;

import edu.unifacef.inventoryapi.configurations.ff4j.Features;
import edu.unifacef.inventoryapi.domains.Inventory;
import edu.unifacef.inventoryapi.exceptions.NotFoundException;
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
public class UpdateInventory {

  private final InventoryDataGateway inventoryDataGateway;
  private final StoreGateway storeGateway;
  private final MessageUtils messageUtils;
  private final FF4j ff4j;

  public Inventory execute(final Inventory inventory) {
    log.info("Update inventory. Product code: {}", inventory.getProductCode());
    Inventory oldInventory = inventoryDataGateway.findByCode(inventory.getProductCode()).orElseThrow(() ->
        new NotFoundException(messageUtils.getMessage(INVENTORY_NOT_FOUND, inventory.getProductCode())));
    inventory.setCreatedDate(oldInventory.getCreatedDate());

    Inventory saved = inventoryDataGateway.save(inventory);
    if(ff4j.check(Features.SEND_TO_STORE.getKey())) {
      storeGateway.send(saved);
    }
    return saved;
  }
}

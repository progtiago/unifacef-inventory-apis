package edu.unifacef.inventoryapi.usecases;

import static edu.unifacef.inventoryapi.exceptions.MessageKey.INVENTORY_NOT_FOUND;

import edu.unifacef.inventoryapi.domains.Inventory;
import edu.unifacef.inventoryapi.exceptions.NotFoundException;
import edu.unifacef.inventoryapi.gateways.outputs.InventoryDataGateway;
import edu.unifacef.inventoryapi.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindByProductCode {

  private final InventoryDataGateway inventoryDataGateway;
  private final MessageUtils messageUtils;

  public Inventory execute(final String productCode) {
    log.info("Find inventory. Product code: {}", productCode);
    return inventoryDataGateway.findByCode(productCode).orElseThrow(
        () -> new NotFoundException(messageUtils.getMessage(INVENTORY_NOT_FOUND, productCode)));
  }
}

package edu.unifacef.inventoryapi.gateways.outputs.http;

import edu.unifacef.inventoryapi.domains.Inventory;
import edu.unifacef.inventoryapi.gateways.outputs.StoreGateway;
import edu.unifacef.inventoryapi.gateways.outputs.http.resources.InventoryResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class StoreGatewayHttpImpl implements StoreGateway {

  private final StoreFeignIntegration storeFeignIntegration;

  @Override
  public void send(final Inventory inventory) {
    log.info("Sending inventory to Store. Product code: {}", inventory.getProductCode());
    InventoryResource inventoryResource = new InventoryResource(inventory);
    storeFeignIntegration.send(inventory.getProductCode(), inventoryResource);
  }
}

package edu.unifacef.inventoryapi.gateways.outputs;

import edu.unifacef.inventoryapi.domains.Inventory;
import java.util.Optional;

public interface InventoryDataGateway {

  Inventory save(Inventory inventory);

  Optional<Inventory> findByCode(String code);

}

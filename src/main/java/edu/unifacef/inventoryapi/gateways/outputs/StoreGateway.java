package edu.unifacef.inventoryapi.gateways.outputs;

import edu.unifacef.inventoryapi.domains.Inventory;

public interface StoreGateway {

  void send(Inventory inventory);

}

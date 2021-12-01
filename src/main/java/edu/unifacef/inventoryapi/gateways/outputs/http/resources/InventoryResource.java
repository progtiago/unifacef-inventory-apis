package edu.unifacef.inventoryapi.gateways.outputs.http.resources;

import edu.unifacef.inventoryapi.domains.Inventory;
import java.io.Serializable;
import lombok.Data;

@Data
public class InventoryResource implements Serializable {

  private Integer position;

  public InventoryResource(final Inventory inventory) {
    this.position = inventory.getPosition();
  }
}

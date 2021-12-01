package edu.unifacef.inventoryapi.gateways.inputs.http.requests;

import edu.unifacef.inventoryapi.domains.Inventory;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InventoryRequest implements Serializable {

  private static final long serialVersionUID = -5715907715579164139L;

  @NotNull(message = "{required.field}")
  private Integer position;

  public Inventory toDomain(final String productCode) {
    return Inventory.builder()
        .productCode(productCode)
        .position(this.position)
        .build();
  }
}

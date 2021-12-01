package edu.unifacef.inventoryapi.gateways.inputs.http.responses;

import edu.unifacef.inventoryapi.domains.Inventory;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class InventoryResponse implements Serializable {

  private static final long serialVersionUID = -2593748047129260046L;

  @ApiModelProperty(position = 0)
  private String productCode;

  @ApiModelProperty(position = 1)
  private Integer position;

  @ApiModelProperty(position = 2)
  private LocalDateTime createdDate;

  @ApiModelProperty(position = 3)
  private LocalDateTime lastModifiedDate;

  public InventoryResponse(final Inventory inventory) {
    this.productCode = inventory.getProductCode();
    this.position = inventory.getPosition();
    this.createdDate = inventory.getCreatedDate();
    this.lastModifiedDate = inventory.getLastModifiedDate();
  }

}

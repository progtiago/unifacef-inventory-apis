package edu.unifacef.inventoryapi.gateways.outputs.mongodb.documents;

import edu.unifacef.inventoryapi.domains.Inventory;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("inventories")
public class InventoryDocument {

  @Id
  private String id;
  private Integer position;
  private LocalDateTime createdDate;
  @LastModifiedDate
  private LocalDateTime lastModifiedDate;

  public InventoryDocument(final Inventory inventory) {
    this.id = inventory.getProductCode();
    this.position = inventory.getPosition();
    this.createdDate = inventory.getCreatedDate();
    this.lastModifiedDate = inventory.getLastModifiedDate();
  }

  public Inventory toDomain() {
    return Inventory.builder()
        .productCode(this.id)
        .position(this.position)
        .createdDate(this.createdDate)
        .lastModifiedDate(this.lastModifiedDate)
        .build();
  }
}

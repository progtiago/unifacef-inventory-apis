package edu.unifacef.inventoryapi.domains;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Inventory {

  private String productCode;
  private Integer position;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;

}

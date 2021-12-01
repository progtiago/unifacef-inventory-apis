package edu.unifacef.inventoryapi.gateways.outputs.mongodb;

import edu.unifacef.inventoryapi.domains.Inventory;
import edu.unifacef.inventoryapi.gateways.outputs.InventoryDataGateway;
import edu.unifacef.inventoryapi.gateways.outputs.mongodb.documents.InventoryDocument;
import edu.unifacef.inventoryapi.gateways.outputs.mongodb.repositories.InventoryRepository;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InventoryDataGatewayMongoImpl implements InventoryDataGateway {

  private final InventoryRepository inventoryRepository;

  @Override
  public Inventory save(final Inventory inventory) {
    if(Objects.isNull(inventory.getCreatedDate())) {
      inventory.setCreatedDate(LocalDateTime.now());
    }
    return inventoryRepository.save(new InventoryDocument(inventory)).toDomain();
  }

  @Override
  public Optional<Inventory> findByCode(final String code) {
    return inventoryRepository.findById(code).map(InventoryDocument::toDomain);
  }

}

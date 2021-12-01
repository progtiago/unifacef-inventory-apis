package edu.unifacef.inventoryapi.gateways.outputs.mongodb.repositories;

import edu.unifacef.inventoryapi.gateways.outputs.mongodb.documents.InventoryDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepository extends MongoRepository<InventoryDocument, String> {
}

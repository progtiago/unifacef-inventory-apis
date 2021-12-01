package edu.unifacef.inventoryapi.gateways.outputs.http;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import edu.unifacef.inventoryapi.gateways.outputs.http.resources.InventoryResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "store", url = "${integration.store.url}")
public interface StoreFeignIntegration {

  @PostMapping(path = "/api/v1/products/{productCode}/inventories", consumes = APPLICATION_JSON_VALUE)
  void send(@PathVariable("productCode") final String productCode, final InventoryResource inventoryResource);
}

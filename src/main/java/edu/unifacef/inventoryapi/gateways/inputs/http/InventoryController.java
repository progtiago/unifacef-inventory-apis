package edu.unifacef.inventoryapi.gateways.inputs.http;

import edu.unifacef.inventoryapi.domains.Inventory;
import edu.unifacef.inventoryapi.gateways.inputs.http.requests.InventoryRequest;
import edu.unifacef.inventoryapi.gateways.inputs.http.responses.InventoryResponse;
import edu.unifacef.inventoryapi.usecases.CreateInventory;
import edu.unifacef.inventoryapi.usecases.FindByProductCode;
import edu.unifacef.inventoryapi.usecases.UpdateInventory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/products/{productCode}/inventories")
public class InventoryController {

  private final CreateInventory createInventory;
  private final UpdateInventory updateInventory;
  private final FindByProductCode findByProductCode;

  @PostMapping
  public InventoryResponse create(@PathVariable final String productCode,
                                  @RequestBody @Validated final InventoryRequest request) {
    Inventory inventory = createInventory.execute(request.toDomain(productCode));
    return new InventoryResponse(inventory);
  }

  @PutMapping
  public InventoryResponse update(@PathVariable final String productCode,
                              @RequestBody @Validated final InventoryRequest request) {
    Inventory inventory = updateInventory.execute(request.toDomain(productCode));
    return new InventoryResponse(inventory);
  }

  @GetMapping
  public InventoryResponse find(@PathVariable final String productCode) {
    Inventory inventory = findByProductCode.execute(productCode);
    return new InventoryResponse(inventory);
  }
}

package edu.unifacef.inventoryapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageKey {

  INVENTORY_NOT_FOUND("inventory.not.found"),
  INVENTORY_ALREADY_EXISTS("inventory.already.exists");

  private String key;

}

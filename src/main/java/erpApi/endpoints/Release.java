package erpApi.endpoints;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Release {

  RELEASE_POST("/erp/erpApi/v2/release");

  private final String endpoint;
}

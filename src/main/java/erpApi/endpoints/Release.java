package erpApi.endpoints;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Release {

  RELEASE_POST("/erp/erpApi/v2/release"),
  RELEASE_PUT("/erp/erpApi/v2/release/cancel");

  private final String endpoint;
}

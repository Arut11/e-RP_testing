package erpApiAdmin.endpoints;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Organizations {

  ORGANIZATION_POST("/erp/admin/erpAdminApi/organizations"),
  ORGANIZATION_ID("/erp/admin/erpAdminApi/organizations/{organizationId}");

  private final String endpoint;

}

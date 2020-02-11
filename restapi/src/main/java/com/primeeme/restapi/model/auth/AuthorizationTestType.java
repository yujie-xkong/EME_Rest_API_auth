package com.primeeme.restapi.model.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorizationTestType {
  private int AuthorizationTestTypeID;
  private int    AuthorizationID;
  private int TestTypeID;
  private boolean Active;
  private Date Created;
  private int CreatedByUserAccountID;
}

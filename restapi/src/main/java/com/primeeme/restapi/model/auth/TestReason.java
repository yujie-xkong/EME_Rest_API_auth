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
public class TestReason {
  private int TestReasonID;
  private String   TestReasonCode;
  private String   TestReasonName;
  private String       TestReasonDescription;
  private boolean   Active;
  private boolean      UserCreatable;
  private boolean  HasCaseManagement;
  private Date Created;
  private int CreatedByUserAccountID;
  private Date LastEdited;
  private int LastEditedByUserAccountID;
}

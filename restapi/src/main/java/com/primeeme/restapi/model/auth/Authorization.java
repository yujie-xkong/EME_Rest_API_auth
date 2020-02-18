package com.primeeme.restapi.model.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class Authorization {

  private int AuthorizationID;
  private int ProjectCompanyJobID ;
  private int CreatedByUserAccountID ;
  private UUID AuthorizationCode ;
  private Date Created ;
  private int TestReasonID ;
  private String AuthorizationComment;
  private Date LastEdited;
  private int LastEditedByUserAccountID;

//  public virtual ProjectCompanyJob ProjectCompanyJob { get; set; }
//  public virtual UserAccount UserAccount { get; set; }
  private ArrayList<AuthorizationPatient> AuthorizationPatients ;
  private ArrayList<AuthorizationTestType> AuthorizationTestTypes ;
  private TestReason ReasonForTest;

  public Authorization() {

    this.AuthorizationPatients = new ArrayList<AuthorizationPatient>();
    this.AuthorizationTestTypes = new ArrayList<AuthorizationTestType>();
  }
}

package com.primeeme.restapi.model.auth;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import microsoft.sql.DateTimeOffset;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorizationPatient {

  private int AuthorizationPatientID;
  private int AuthorizationID;
  private int PatientID;
  private int ClinicCompanyID;
  private int ProviderID;
  private Date DateOfVisit;
  private String NonBillableExplanation;
  private boolean Active;
  private Date Created;
  private int CreatedByUserAccountID;
  private Date LastEdited;
  private int LastEditedByUserAccountID;
  private String PurchaseOrder;
  private String  QuestionnaireFromURL;
  private short AuthorizationPatientStatusID;
  private Date StatusDate;
  private int BillingGroupID;
  private boolean NotesClosed;
  private int NotesClosedSignedByUserAccountID;
  private DateTimeOffset NotesClosedSignedByUserDateTime;
  private String ReviewerFinalComment;
  private String ReasonIsNotBillable;


  private boolean IsLocked;
  private int LockedByUserAccountID;
  private DateTimeOffset LockedTime;

}

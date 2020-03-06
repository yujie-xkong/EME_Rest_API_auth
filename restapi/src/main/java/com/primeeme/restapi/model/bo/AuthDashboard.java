package com.primeeme.restapi.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AuthDashboard {

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("dob")
  private String dob;

  @JsonProperty("jobNumber")
  private String jobNumber;

  @JsonProperty("reason")
  private String reason;

  @JsonProperty("facility")
  private String facility;

  @JsonProperty("status")
  private String status;

  @JsonProperty("lastUpdate")
  private Date lastUpdate;

}

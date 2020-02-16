package com.primeeme.restapi.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class JobInfo implements Serializable {
  @JsonProperty("company")
  private String company;

  @JsonProperty("jobNumber")
  private String jobNumber;

  @JsonProperty("facility")
  private String facility;

  @JsonProperty("testReason")
  private String testReason;


}

package com.primeeme.restapi.model.bo;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AuthCreateRequest implements Serializable {

  @JsonProperty("jobInfo")
  private JobInfo jobInfo;
  @JsonProperty("services")
  private List<String> services;
  @JsonProperty("additionalInfo")
  private AdditionalInfo additionalInfo;
  @JsonProperty("employees")
  private Employees employees;

}


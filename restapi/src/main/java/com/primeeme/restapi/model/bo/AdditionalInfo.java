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
public class AdditionalInfo implements Serializable {

  @JsonProperty("notes")
  private String notes;

  @JsonProperty("purchaseOrder")
  private String purchaseOrder;

}

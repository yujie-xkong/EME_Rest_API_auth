package com.primeeme.restapi.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Patient {
    private  Integer patientId;
    private  Integer contactId;
    private  String ssn;
    private  String address1;
    private  String address2;
    private  String city;
    private  String state;
    private  String postal;
    private  String contactPhone;
    private  boolean active_status = false;

    public Patient(@JsonProperty("ssn") String ssn,
                   @JsonProperty("address1") String address1,
                   @JsonProperty("address2") String address2,
                   @JsonProperty("city") String city,
                   @JsonProperty("state") String state,
                   @JsonProperty("postal") String postal,
                   @JsonProperty("contactPhone") String contactPhone, boolean active) {
        this.ssn = ssn;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.postal = postal;
        this.contactPhone = contactPhone;
        this.active_status = active;
    }

    //For HTTP GET
    public Patient(@JsonProperty("ssn") String ssn,
                   @JsonProperty("contactId") Integer contactId,
                   @JsonProperty("address1") String address1,
                   @JsonProperty("address2") String address2,
                   @JsonProperty("city") String city,
                   @JsonProperty("state") String state,
                   @JsonProperty("postal") String postal,
                   @JsonProperty("contactPhone") String contactPhone,
                   boolean active){
        this.ssn = ssn;
        this.contactId = contactId;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.postal = postal;
        this.contactPhone = contactPhone;
        this.active_status = active;
    }

    //For Wrapper
    public Patient(@JsonProperty("ssn") String ssn,
                   @JsonProperty("contactId") Integer contactId,
                   @JsonProperty("address1") String address1,
                   @JsonProperty("address2") String address2,
                   @JsonProperty("city") String city,
                   @JsonProperty("state") String state,
                   @JsonProperty("postal") String postal,
                   @JsonProperty("contactPhone") String contactPhone){
        this.ssn = ssn;
        this.contactId = contactId;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.postal = postal;
        this.contactPhone = contactPhone;
    }
}

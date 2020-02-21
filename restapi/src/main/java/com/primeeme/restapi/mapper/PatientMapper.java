package com.primeeme.restapi.mapper;

import com.primeeme.restapi.model.Patient;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PatientMapper {

    @Select("select ssn, contactId, address1, address2, city, state, postalCode, contactPhone, active from EME.Patient " +
            "where patientID = #{id};")
    Patient getPatientById(@Param("id") Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "patientId")
    @Insert("insert into EME.Patient (ssn, contactId, address1, address2, city, state, postalCode, contactPhone, active) " +
            "VALUES (#{ssn}, #{contactId}, #{address1}, #{address2}, #{city}, #{state}, #{postal}, #{contactPhone}, '0');")
    int addPatient(Patient patient);
}

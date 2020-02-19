package com.primeeme.restapi.mapper;

import com.primeeme.restapi.model.Contact;
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
    @Select("select ssn, firstName, middleName, lastName, suffix, address1, address2, city, state, " +
            "postalCode, dateOfBirth, gender, contactPhone from EME.Contact, EME.Patient " +
            "where patientID = #{id} " +
            "and EME.Patient.contactID = EME.Contact.contactID")
    Patient getPatientById(@Param("id") Integer id);
}

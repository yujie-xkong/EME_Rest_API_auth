package com.primeeme.restapi.mapper;

import com.primeeme.restapi.model.PatientIdentifier;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PatientIdentifierMapper {
    @Select("select patientId, identifierTypeId, identifierValue, active from EME.PatientIdentifier where patientIdentifierId = #{id}")
    PatientIdentifier getPatientIdentifierById(@Param("id") Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "patientIdentifierId")
    @Insert("insert into EME.PatientIdentifier (patientId, identifierTypeId, identifierValue, active)" +
             "VALUES (#{patientId}, #{identifierTypeId}, #{identifierValue}, '0');")
    int addPatientIdentifier(PatientIdentifier patientIdentifier);
}

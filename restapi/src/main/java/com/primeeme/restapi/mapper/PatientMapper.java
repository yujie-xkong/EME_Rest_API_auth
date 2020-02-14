package com.primeeme.restapi.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PatientMapper {
    //@Select("select ssn, address1, address2, city, state, postalCode, ContactPhone")
}

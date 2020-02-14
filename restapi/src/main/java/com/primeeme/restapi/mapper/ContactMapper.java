package com.primeeme.restapi.mapper;

import com.primeeme.restapi.model.Contact;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ContactMapper {
    @Select("select firstName, middleName, lastName, suffix, gender, dateOfBirth from EME.Contact where ContactID = #{id}")
    Contact getContactById(@Param("id") Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "contactID")
    @Insert("insert into EME.Contact (firstName, middleName, lastName, suffix, gender, dateOfBirth) VALUES (" +
            "#{firstName}, #{middleName}, #{lastName}, #{suffix}, #{gender}, #{dateOfBirth});")
    int addContact(Contact contact);
}
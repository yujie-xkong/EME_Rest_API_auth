package com.primeeme.restapi.mapper;

import com.primeeme.restapi.model.Contact;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ContactMapper {
    @Select("select * from EME.Contact where ContactID = #{id}")
    Contact getContactById(@Param("id") Integer id);
}

package com.hngy.mapper;


import com.hngy.model.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {

	int changePassword(@Param("username") String username,@Param("password") String password,@Param("newPassword") String newPassword);

}

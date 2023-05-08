package com.hngy.mapper;


import com.hngy.model.Admin;

public interface AdminMapper {
 
	Admin findAdminByUserName(String username) throws Exception;
	
	void changePassword(Admin admin) throws Exception;

}

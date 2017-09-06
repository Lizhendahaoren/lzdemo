package com.ch.lz.base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ch.lz.base.entity.XaCmsUserRole;

/**
 * 
 * 用户角色持久层
 * 
 * @author lz
 *
 */
public interface MyCmsUserRoleRepository
		extends PagingAndSortingRepository<XaCmsUserRole, Long>, JpaSpecificationExecutor<XaCmsUserRole> {

	/**
	 * @Description 根据userName查找权限list
	 * @param userName
	 * @return
	 * @author lz
	 */
	@Query("select ro.roleName from XaCmsUser us,XaCmsUserRole ur,XaCmsRole ro where us.userName=?1 "
			+ " and us.userId = ur.userId and ro.roleId=ur.roleId ")
	List<String> findRoleByUserName(String userName);
}

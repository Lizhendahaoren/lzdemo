package com.ch.lz.base.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ch.lz.base.entity.XaCmsRole;

/**
 * 
 * 角色持久层
 * 
 * @author lz
 *
 */
public interface MyCmsRoleRepository
		extends PagingAndSortingRepository<XaCmsRole, Long>, JpaSpecificationExecutor<XaCmsRole> {

	/**
	 * @Description 查找所有权限
	 * @param status
	 * @return
	 * @author lz
	 */
	@Query("from XaCmsRole xac where xac.status = ?1 ")
	List<XaCmsRole> findAllRole(Integer status);

}

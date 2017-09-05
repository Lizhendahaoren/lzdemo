package com.ch.lz.base.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ch.lz.base.entity.XaCmsUser;
import com.ch.lz.base.entity.XaCmsUserRole;
/**
 * 
 * 用户角色持久层
 * @author lz
 *
 */
public interface MyCmsUserRoleRepository
		extends PagingAndSortingRepository<XaCmsUserRole, Long>, JpaSpecificationExecutor<XaCmsUserRole> {

}

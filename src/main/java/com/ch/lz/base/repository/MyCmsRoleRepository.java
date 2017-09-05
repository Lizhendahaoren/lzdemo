package com.ch.lz.base.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ch.lz.base.entity.XaCmsRole;
import com.ch.lz.base.entity.XaCmsUser;
/**
 * 
 * 角色持久层
 * @author lz
 *
 */
public interface MyCmsRoleRepository
		extends PagingAndSortingRepository<XaCmsRole, Long>, JpaSpecificationExecutor<XaCmsRole> {

}

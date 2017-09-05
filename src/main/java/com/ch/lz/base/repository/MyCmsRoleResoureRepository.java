package com.ch.lz.base.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ch.lz.base.entity.XaCmsRoleResource;

/**
 * 
 * 角色资源持久层
 * @author lz
 *
 */
public interface MyCmsRoleResoureRepository
		extends PagingAndSortingRepository<XaCmsRoleResource, Long>, JpaSpecificationExecutor<XaCmsRoleResource> {

}

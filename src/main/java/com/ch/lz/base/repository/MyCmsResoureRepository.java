package com.ch.lz.base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ch.lz.base.entity.XaCmsResource;

/**
 * 
 * 资源持久层
 * 
 * @author lz
 *
 */
public interface MyCmsResoureRepository
		extends PagingAndSortingRepository<XaCmsResource, Long>, JpaSpecificationExecutor<XaCmsResource> {

	/**
	 * @Description 查找url根据权限id
	 * @param roleId
	 * @return
	 * @author lz
	 */
	@Query("select mr.resourceUrl from XaCmsRoleResource rr, XaCmsResource mr "
			+ " where rr.roleId=?1 and rr.resourceId=mr.resourceId")
	List<String> findResoureUrlByRoleId(Long roleId);
}

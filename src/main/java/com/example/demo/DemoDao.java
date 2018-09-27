package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author xuchao
 * 2018年9月27日
 */
public interface DemoDao extends JpaRepository<DemoUser, String>,PagingAndSortingRepository<DemoUser, String>{

	@Query(value="select * from tbl_user u where u.name like %:name%",nativeQuery=true)
	List<DemoUser> findByName(@Param("name") String name);
	
}

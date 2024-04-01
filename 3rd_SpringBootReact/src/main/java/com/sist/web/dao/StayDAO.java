package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.FoodEntity;
import com.sist.web.entity.StayDetail;


public interface StayDAO extends JpaRepository<StayDetail, Integer>{
	
	 @Query(value="SELECT * FROM stay "
			 +"ORDER BY sno ASC LIMIT :start,12",nativeQuery = true)
	   public List<StayDetail> stayListData(@Param("start") Integer start);
	 
	 @Query(value="SELECT CEIL(COUNT(*)/12.0) FROM stay "
			 ,nativeQuery = true)
	   public int stayListTotalPage();
	 
	 public StayDetail findBySno(int sno);
	 
	 
	 @Query(value="SELECT * FROM stay "
			 +"WHERE detail_address LIKE CONCAT('%',:detail_address,'%') "
			 +"ORDER BY sno ASC LIMIT :start,12",nativeQuery = true)
	   public List<StayDetail> stayFindData(@Param("start") Integer start,@Param("detail_address") String detail_address);
	 
	 @Query(value="SELECT CEIL(COUNT(*)/12.0) FROM stay "
			 +"WHERE detail_address LIKE CONCAT('%',:detail_address,'%')",nativeQuery = true)
	   public int stayFindTotalPage(@Param("detail_address") String detail_address);
	 
	 
	 @Query(value="SELECT * FROM stay "
			 +"ORDER BY hit DESC LIMIT 0,12",nativeQuery = true)
	   public List<StayDetail> stayMainData();
}

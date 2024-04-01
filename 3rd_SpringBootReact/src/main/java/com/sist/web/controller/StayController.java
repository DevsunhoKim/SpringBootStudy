package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.StayDAO;
import com.sist.web.entity.FoodEntity;
import com.sist.web.entity.StayDetail;


@RestController
@CrossOrigin(origins = "*")
public class StayController {
	
	@Autowired
	private StayDAO dao;
	
	@GetMapping("/stay/list_react")
	   public Map stay_list(int page)
	   {
		   int rowSize=12;
		   int start=(rowSize*page)-rowSize;
		   List<StayDetail> list=dao.stayListData(start);
		   Map map=new HashMap(); 
		   int totalpage=dao.stayListTotalPage();
		   final int BLOCK=10; 
		   int startPage=((page-1)/BLOCK*BLOCK)+1; 
		   int endPage=((page-1)/BLOCK*BLOCK)+BLOCK; 
		   if(endPage>totalpage) 
			  endPage=totalpage;
			  
			  map.put("curpage",page);
			  map.put("totalpage",totalpage);
			  map.put("startPage",startPage);
			  map.put("endPage", endPage); 
			  map.put("list", list);
			 
		   
		   return map;
		   
	   }
	
	 @GetMapping("stay/stay_detail_react")
	   public StayDetail stay_detail_data(int sno)
	   {
		  StayDetail vo=  dao.findBySno(sno);
		  return vo;
	   }
	 @RequestMapping("/stay/find_react")
	   public Map stay_find(int page,String detail_address)
	   {
		   int rowSize=12;
		   int start=(rowSize*page)-rowSize;
		   List<StayDetail> list=dao.stayFindData(page, detail_address);
		   Map map=new HashMap();
		   int totalpage=dao.stayFindTotalPage(detail_address);
		   final int BLOCK=10;
		   int startPage=((page-1)/BLOCK*BLOCK)+1;
		   int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		   if(endPage>totalpage)
			   endPage=totalpage;
		   
		   map.put("curpage",page);
		   map.put("totalpage",totalpage);
		   map.put("startPage",startPage);
		   map.put("endPage", endPage);
		   map.put("list", list);
		   return map;
	   }
	 
	 
	 @GetMapping("stay/main_react")
	 public List<StayDetail> stayMain()
	 {
		 List<StayDetail> list=dao.stayMainData();
		 return list;
	 }
}

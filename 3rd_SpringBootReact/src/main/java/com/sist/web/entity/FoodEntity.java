package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/*
 *  FNO int 
POSTER text 
NAME text 
TYPE text 
ADDRESS text 
PHONE text 
SCORE double 
THEME text 
PRICE text 
TIME text 
SEAT text 
CONTENT text 
LINK text 
HIT int 
JJIMCOUNT int 
LIKECOUNT int
      => JPA 
         클래스 객체 <===> 테이블 Mapping ==> 클래스 객체 => Entity 
         ========= JOIN / SubQuery
         MyBatis 
 */
@Entity(name="food")
@Getter
@Setter
public class FoodEntity {
  @Id
  private int fno;
  private String poster,title,address,menu,phone,restday,bhour,tag;
  
}

package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="stay")
@Getter
@Setter
@NoArgsConstructor
public class StayDetail {
	@Id
	private int sno;
	private String sname,stype,address,detail_address,staymsg,mainimage,sub1,sub2,sub3,sub4,around,basic,other;
	private int price,hit;
}

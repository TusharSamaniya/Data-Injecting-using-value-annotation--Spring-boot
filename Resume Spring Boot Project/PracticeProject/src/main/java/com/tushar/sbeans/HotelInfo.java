package com.tushar.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component("info")
@Getter
public class HotelInfo {
	
	@Value("${hotel.name}")
	private String name;
	
	@Value("${hotel.id}")
	private Integer id;
	
	@Value("${hotel.location}")
	private String location;
	
	@Value("${customer.name}")
	private String customerName;
	
	@Value("${customer.discount}")
	private Float discount;
	
	@Value("#{menu.dosaPrice+menu.idlyPrice+menu.pohaPrice+menu.vadapavPrice}")
	private Float billAmount;
	
	private Float fianlBillAmount;
	
	public Float calculateFinalAmount() {
		fianlBillAmount = billAmount - (billAmount*discount/100);
		return fianlBillAmount;
	}

	@Override
	public String toString() {
		return "HotelInfo [name=" + name + ", id=" + id + ", location=" + location + ", customerName=" + customerName
				+ ", discount=" + discount + ", billAmount=" + billAmount + ", fianlBillAmount=" + fianlBillAmount
				+ "]";
	}
	
	

}

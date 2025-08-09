package com.tushar.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component("menu")
@Getter
public class HotelMenu {
	@Value("${menu.dosaPrice}")
	private Float dosaPrice;
	@Value("${menu.idlyPrice}")
	private Float idlyPrice;
	@Value("${menu.pohaPrice}")
	private Float pohaPrice;
	@Value("${menu.dosaPrice}")
	private Float vadapavPrice;

}

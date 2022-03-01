package com.yocar.base.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response implements Serializable{

	@JsonProperty
	private int statusCode;
	@JsonProperty
	private String msg;
	@JsonProperty
	private String discription;
	
	private CarDetails carDetails;
	private List<CarDetails> allCars;
	
}

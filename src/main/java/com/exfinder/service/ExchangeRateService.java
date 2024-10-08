package com.exfinder.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.exfinder.dto.ExchangeRateDto;
import com.exfinder.dto.ExchangeRate_ComparisonValueDto;

public interface ExchangeRateService {
	public ArrayList<ExchangeRateDto> exchangeRateSelect(String c_code,String start_date,String end_date) throws Exception;
	public int exchangeRateInsert(ExchangeRateDto dto) throws Exception;
	public ArrayList<ExchangeRateDto> checkExchange(String[] curreny,String startDate,String endDate) throws Exception;
	public double exchangeRateSelect_base_r(String c_code, String rate_date);
	public String[] currSelect() throws Exception;
	
	public int exchangeRate_column_checkValue(String c_code);
	
	public ExchangeRateDto exchangeRateSelect_today(String c_code, String rate_date) throws Exception;
	public ArrayList<ExchangeRateDto> yesterDayRate(String[] curr) throws Exception;
	
	public ArrayList<ExchangeRate_ComparisonValueDto> today_ComparisonValue() throws Exception;
	public ExchangeRate_ComparisonValueDto today_ComparisonValue_code(String c_code) throws Exception;
	public int deleteAllCurr() throws Exception;
}

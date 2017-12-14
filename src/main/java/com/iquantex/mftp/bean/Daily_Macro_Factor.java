package com.iquantex.mftp.bean;

import java.io.Serializable;

/**
 * CREATE TABLE `daily_marco_factor` (
  `date` datetime DEFAULT NULL,
  `p2p_pop_index` bigint(20) DEFAULT NULL,
  `p2p_interest_index` double DEFAULT NULL,
  `p2p_develop_index` double DEFAULT NULL,
  `p2p_term_index` double DEFAULT NULL,
  `bond204_closePrice` double DEFAULT NULL,
  `bond204_turnoverValue` bigint(20) DEFAULT NULL,
  `cpi_cpi` double DEFAULT NULL,
  `GDP_dataValue` double DEFAULT NULL,
  `get_gdp_month_gdp_yoy` double DEFAULT NULL,
  `hs300_close` double DEFAULT NULL,
  `hs300_volume` double DEFAULT NULL,
  `hs300_price_change` double DEFAULT NULL,
  `hs300_p_change` double DEFAULT NULL,
  `hs300_ma5` double DEFAULT NULL,
  `hs300_ma10` double DEFAULT NULL,
  `hs300_ma20` double DEFAULT NULL,
  `hs300_v_ma5` double DEFAULT NULL,
  `hs300_v_ma10` double DEFAULT NULL,
  `hs300_v_ma20` double DEFAULT NULL,
  `money_supply_m2` double DEFAULT NULL,
  `money_supply_m2_yoy` double DEFAULT NULL,
  `money_supply_cd` double DEFAULT NULL,
  `money_supply_qm` double DEFAULT NULL,
  `ppi_food` double DEFAULT NULL,
  `Shibor_rate` double DEFAULT NULL,
  `real_estate_invest_dataValue` double DEFAULT NULL,
  `domestic_ fiscal_expenditure_dataValue` double DEFAULT NULL,
  `domestic_ fiscal_income_dataValue` double DEFAULT NULL,
  `economic_climate_index_dataValue` double DEFAULT NULL,
  `consume_climate_index_dataValue` double DEFAULT NULL,
  `base_loan_rate_1year` double DEFAULT NULL,
  `Inter_bank_lending_day_preCloseRate` double DEFAULT NULL,
  `Inter_bank_lending_day_bpChg` double DEFAULT NULL,
  `Inter_bank_lending_day_turnoverValue` double DEFAULT NULL,
  `Inter_bank_lending_day_turnoverChg` double DEFAULT NULL,
  `daily_buy_amounts` double DEFAULT NULL,
  `daily_redeem_amounts` double DEFAULT NULL,
  `money_fund_7day_rate` double DEFAULT NULL,
  KEY `ix_daily_marco_factor_date` (`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

 * @author Administrator
 *
 */
public class Daily_Macro_Factor implements Serializable{

	private String date;
	private String p2p_pop_index;
	private String p2p_interest_index;
	private String p2p_develop_index;
	private String p2p_term_index;
	private String bond204_closePrice;
	private String bond204_turnoverValue;
	private String cpi_cpi;
	private String GDP_dataValue;
	private String get_gdp_month_gdp_yoy;
	private String hs300_close;
	private String hs300_volume;
	private String hs300_price_change;
	private String hs300_ma5;
	private String hs300_ma10;
	private String hs300_ma20;
	private String hs300_v_ma5;
	private String hs300_v_ma10;
	private String hs300_v_ma20;
	private String money_supply_m2;
	private String money_supply_m2_yoy;
	private String money_supply_cd;
	private String money_supply_qm;
	private String ppi_food;
	private String Shibor_rate;
	private String real_estate_invest_dataValue;
	private String domestic_fiscal_expenditure_dataValue;
	private String domestic_fiscal_income_dataValue;
	private String economic_climate_index_dataValue;
	private String consume_climate_index_dataValue;
	private String base_loan_rate_1year;
	private String Inter_bank_lending_day_preCloseRate;
	private String Inter_bank_lending_day_bpChg;
	private String Inter_bank_lending_day_turnoverValue;
	private String Inter_bank_lending_day_turnoverChg;
	private String daily_buy_amounts;
	private String daily_redeem_amounts;
	private String money_fund_7day_rate;
	
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getP2p_pop_index() {
		return p2p_pop_index;
	}
	public void setP2p_pop_index(String p2p_pop_index) {
		this.p2p_pop_index = p2p_pop_index;
	}
	public String getP2p_interest_index() {
		return p2p_interest_index;
	}
	public void setP2p_interest_index(String p2p_interest_index) {
		this.p2p_interest_index = p2p_interest_index;
	}
	public String getP2p_develop_index() {
		return p2p_develop_index;
	}
	public void setP2p_develop_index(String p2p_develop_index) {
		this.p2p_develop_index = p2p_develop_index;
	}
	public String getP2p_term_index() {
		return p2p_term_index;
	}
	public void setP2p_term_index(String p2p_term_index) {
		this.p2p_term_index = p2p_term_index;
	}
	public String getBond204_closePrice() {
		return bond204_closePrice;
	}
	public void setBond204_closePrice(String bond204_closePrice) {
		this.bond204_closePrice = bond204_closePrice;
	}
	public String getBond204_turnoverValue() {
		return bond204_turnoverValue;
	}
	public void setBond204_turnoverValue(String bond204_turnoverValue) {
		this.bond204_turnoverValue = bond204_turnoverValue;
	}
	public String getCpi_cpi() {
		return cpi_cpi;
	}
	public void setCpi_cpi(String cpi_cpi) {
		this.cpi_cpi = cpi_cpi;
	}
	public String getGDP_dataValue() {
		return GDP_dataValue;
	}
	public void setGDP_dataValue(String gDP_dataValue) {
		GDP_dataValue = gDP_dataValue;
	}
	public String getGet_gdp_month_gdp_yoy() {
		return get_gdp_month_gdp_yoy;
	}
	public void setGet_gdp_month_gdp_yoy(String get_gdp_month_gdp_yoy) {
		this.get_gdp_month_gdp_yoy = get_gdp_month_gdp_yoy;
	}
	public String getHs300_close() {
		return hs300_close;
	}
	public void setHs300_close(String hs300_close) {
		this.hs300_close = hs300_close;
	}
	public String getHs300_volume() {
		return hs300_volume;
	}
	public void setHs300_volume(String hs300_volume) {
		this.hs300_volume = hs300_volume;
	}
	public String getHs300_price_change() {
		return hs300_price_change;
	}
	public void setHs300_price_change(String hs300_price_change) {
		this.hs300_price_change = hs300_price_change;
	}
	public String getHs300_ma5() {
		return hs300_ma5;
	}
	public void setHs300_ma5(String hs300_ma5) {
		this.hs300_ma5 = hs300_ma5;
	}
	public String getHs300_ma10() {
		return hs300_ma10;
	}
	public void setHs300_ma10(String hs300_ma10) {
		this.hs300_ma10 = hs300_ma10;
	}
	public String getHs300_ma20() {
		return hs300_ma20;
	}
	public void setHs300_ma20(String hs300_ma20) {
		this.hs300_ma20 = hs300_ma20;
	}
	public String getHs300_v_ma5() {
		return hs300_v_ma5;
	}
	public void setHs300_v_ma5(String hs300_v_ma5) {
		this.hs300_v_ma5 = hs300_v_ma5;
	}
	public String getHs300_v_ma10() {
		return hs300_v_ma10;
	}
	public void setHs300_v_ma10(String hs300_v_ma10) {
		this.hs300_v_ma10 = hs300_v_ma10;
	}
	public String getHs300_v_ma20() {
		return hs300_v_ma20;
	}
	public void setHs300_v_ma20(String hs300_v_ma20) {
		this.hs300_v_ma20 = hs300_v_ma20;
	}
	public String getMoney_supply_m2() {
		return money_supply_m2;
	}
	public void setMoney_supply_m2(String money_supply_m2) {
		this.money_supply_m2 = money_supply_m2;
	}
	public String getMoney_supply_m2_yoy() {
		return money_supply_m2_yoy;
	}
	public void setMoney_supply_m2_yoy(String money_supply_m2_yoy) {
		this.money_supply_m2_yoy = money_supply_m2_yoy;
	}
	public String getMoney_supply_cd() {
		return money_supply_cd;
	}
	public void setMoney_supply_cd(String money_supply_cd) {
		this.money_supply_cd = money_supply_cd;
	}
	public String getMoney_supply_qm() {
		return money_supply_qm;
	}
	public void setMoney_supply_qm(String money_supply_qm) {
		this.money_supply_qm = money_supply_qm;
	}
	public String getPpi_food() {
		return ppi_food;
	}
	public void setPpi_food(String ppi_food) {
		this.ppi_food = ppi_food;
	}
	public String getShibor_rate() {
		return Shibor_rate;
	}
	public void setShibor_rate(String shibor_rate) {
		Shibor_rate = shibor_rate;
	}
	public String getReal_estate_invest_dataValue() {
		return real_estate_invest_dataValue;
	}
	public void setReal_estate_invest_dataValue(String real_estate_invest_dataValue) {
		this.real_estate_invest_dataValue = real_estate_invest_dataValue;
	}
	public String getDomestic_fiscal_expenditure_dataValue() {
		return domestic_fiscal_expenditure_dataValue;
	}
	public void setDomestic_fiscal_expenditure_dataValue(String domestic_fiscal_expenditure_dataValue) {
		this.domestic_fiscal_expenditure_dataValue = domestic_fiscal_expenditure_dataValue;
	}
	public String getDomestic_fiscal_income_dataValue() {
		return domestic_fiscal_income_dataValue;
	}
	public void setDomestic_fiscal_income_dataValue(String domestic_fiscal_income_dataValue) {
		this.domestic_fiscal_income_dataValue = domestic_fiscal_income_dataValue;
	}
	public String getEconomic_climate_index_dataValue() {
		return economic_climate_index_dataValue;
	}
	public void setEconomic_climate_index_dataValue(String economic_climate_index_dataValue) {
		this.economic_climate_index_dataValue = economic_climate_index_dataValue;
	}
	public String getConsume_climate_index_dataValue() {
		return consume_climate_index_dataValue;
	}
	public void setConsume_climate_index_dataValue(String consume_climate_index_dataValue) {
		this.consume_climate_index_dataValue = consume_climate_index_dataValue;
	}
	public String getBase_loan_rate_1year() {
		return base_loan_rate_1year;
	}
	public void setBase_loan_rate_1year(String base_loan_rate_1year) {
		this.base_loan_rate_1year = base_loan_rate_1year;
	}
	public String getInter_bank_lending_day_preCloseRate() {
		return Inter_bank_lending_day_preCloseRate;
	}
	public void setInter_bank_lending_day_preCloseRate(String inter_bank_lending_day_preCloseRate) {
		Inter_bank_lending_day_preCloseRate = inter_bank_lending_day_preCloseRate;
	}
	public String getInter_bank_lending_day_bpChg() {
		return Inter_bank_lending_day_bpChg;
	}
	public void setInter_bank_lending_day_bpChg(String inter_bank_lending_day_bpChg) {
		Inter_bank_lending_day_bpChg = inter_bank_lending_day_bpChg;
	}
	public String getInter_bank_lending_day_turnoverValue() {
		return Inter_bank_lending_day_turnoverValue;
	}
	public void setInter_bank_lending_day_turnoverValue(String inter_bank_lending_day_turnoverValue) {
		Inter_bank_lending_day_turnoverValue = inter_bank_lending_day_turnoverValue;
	}
	public String getInter_bank_lending_day_turnoverChg() {
		return Inter_bank_lending_day_turnoverChg;
	}
	public void setInter_bank_lending_day_turnoverChg(String inter_bank_lending_day_turnoverChg) {
		Inter_bank_lending_day_turnoverChg = inter_bank_lending_day_turnoverChg;
	}
	public String getDaily_buy_amounts() {
		return daily_buy_amounts;
	}
	public void setDaily_buy_amounts(String daily_buy_amounts) {
		this.daily_buy_amounts = daily_buy_amounts;
	}
	public String getDaily_redeem_amounts() {
		return daily_redeem_amounts;
	}
	public void setDaily_redeem_amounts(String daily_redeem_amounts) {
		this.daily_redeem_amounts = daily_redeem_amounts;
	}
	public String getMoney_fund_7day_rate() {
		return money_fund_7day_rate;
	}
	public void setMoney_fund_7day_rate(String money_fund_7day_rate) {
		this.money_fund_7day_rate = money_fund_7day_rate;
	}
	
	
	
	
	
	
	
	
}

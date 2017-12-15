package com.iquantex.mftp.bean;

import java.util.Date;

/**
 * 
Create Table

CREATE TABLE model_result (
  index 
  
  date text;
  
  day_buy 
  day_redeem 
  month 
  week 
  money_fund_7day_rate ;
  p2p_develop_index ;
  
  buy_times 
  buy_amounts ;
  
  redeem_times 
  redeem_amounts ;
  
  buy_times_predict ;
  redeem_times_predict ;
  buy_amounts_predict ;
  redeem_amounts_predict ;
  
  buy_error ;
  redeem_error ;
  
  buy_precision ;
  redeem_precision ;
  
  net ;
  net_pred ;
  net_error ;
  net_precision ;
  
  
  
   KEY ix_model_result_index (index)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
 * @author shengwen.qin
 * @date 2017年12月14日
 */
public class ModelFitData {
		
	 private Date date;
	 
	 private Double buy_times ;
	 private Double buy_amounts ;
	 private Double redeem_times ;
	 private Double redeem_amounts ;
	 
	 private Double buy_times_fit ;
	 private Double redeem_times_fit ;
	 private Double buy_amounts_fit ;
	 private Double redeem_amounts_fit ;
	 
	 private Double buy_error ;
	 private Double redeem_error ;
	 private Double buy_precision ;
	 private Double redeem_precision ;
	 
	 private Double net ;
	 private Double net_pred ;
	 private Double net_error ;
	 private Double net_precision ;
	 
	 
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getBuy_times() {
		return buy_times;
	}
	public void setBuy_times(Double buy_times) {
		this.buy_times = buy_times;
	}
	public Double getBuy_amounts() {
		return buy_amounts;
	}
	public void setBuy_amounts(Double buy_amounts) {
		this.buy_amounts = buy_amounts;
	}
	public Double getRedeem_times() {
		return redeem_times;
	}
	public void setRedeem_times(Double redeem_times) {
		this.redeem_times = redeem_times;
	}
	public Double getRedeem_amounts() {
		return redeem_amounts;
	}
	public void setRedeem_amounts(Double redeem_amounts) {
		this.redeem_amounts = redeem_amounts;
	}
	public Double getBuy_times_fit() {
		return buy_times_fit;
	}
	public void setBuy_times_fit(Double buy_times_fit) {
		this.buy_times_fit = buy_times_fit;
	}
	public Double getRedeem_times_fit() {
		return redeem_times_fit;
	}
	public void setRedeem_times_fit(Double redeem_times_fit) {
		this.redeem_times_fit = redeem_times_fit;
	}
	public Double getBuy_amounts_fit() {
		return buy_amounts_fit;
	}
	public void setBuy_amounts_fit(Double buy_amounts_fit) {
		this.buy_amounts_fit = buy_amounts_fit;
	}
	public Double getRedeem_amounts_fit() {
		return redeem_amounts_fit;
	}
	public void setRedeem_amounts_fit(Double redeem_amounts_fit) {
		this.redeem_amounts_fit = redeem_amounts_fit;
	}
	public Double getBuy_error() {
		return buy_error;
	}
	public void setBuy_error(Double buy_error) {
		this.buy_error = buy_error;
	}
	public Double getRedeem_error() {
		return redeem_error;
	}
	public void setRedeem_error(Double redeem_error) {
		this.redeem_error = redeem_error;
	}
	public Double getBuy_precision() {
		return buy_precision;
	}
	public void setBuy_precision(Double buy_precision) {
		this.buy_precision = buy_precision;
	}
	public Double getRedeem_precision() {
		return redeem_precision;
	}
	public void setRedeem_precision(Double redeem_precision) {
		this.redeem_precision = redeem_precision;
	}
	public Double getNet() {
		return net;
	}
	public void setNet(Double net) {
		this.net = net;
	}
	public Double getNet_pred() {
		return net_pred;
	}
	public void setNet_pred(Double net_pred) {
		this.net_pred = net_pred;
	}
	public Double getNet_error() {
		return net_error;
	}
	public void setNet_error(Double net_error) {
		this.net_error = net_error;
	}
	public Double getNet_precision() {
		return net_precision;
	}
	public void setNet_precision(Double net_precision) {
		this.net_precision = net_precision;
	}
	
	 
	
}

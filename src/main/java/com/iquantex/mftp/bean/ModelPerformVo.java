package com.iquantex.mftp.bean;

import java.util.Date;

/**
 * 
 * @author shengwen.qin
 * @date 2017年12月20日
 */
public class ModelPerformVo extends ModelPerform{
	
	
	private String predict_buy_amounts;
	private String predict_redeem_amounts;
	private Date date;
	private String delta;
	
	
	public String getPredict_buy_amounts() {
		return predict_buy_amounts;
	}
	public void setPredict_buy_amounts(String predict_buy_amounts) {
		this.predict_buy_amounts = predict_buy_amounts;
	}
	public String getPredict_redeem_amounts() {
		return predict_redeem_amounts;
	}
	public void setPredict_redeem_amounts(String predict_redeem_amounts) {
		this.predict_redeem_amounts = predict_redeem_amounts;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDelta() {
		return delta;
	}
	public void setDelta(String delta) {
		this.delta = delta;
	}
	
	
	
	
}

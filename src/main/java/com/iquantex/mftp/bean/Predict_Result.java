package com.iquantex.mftp.bean;

import java.io.Serializable;
import java.util.Date;

/*CREATE TABLE predict_result(
 * 
		  DATE VARCHAR(20) ,
		  actual_buy_amounts VARCHAR(20),
		  actual_redeem_amounts VARCHAR(20),
		  
		  predict_buy_amounts VARCHAR(20),
		  predict_redeem_amounts VARCHAR(20),
		  buy_accuracy VARCHAR(20),
		  redeem_accuracy VARCHAR(20),
		  PRIMARY KEY (`date`)
)*/

/**
 * 说明：这个类是决定模型需要返回到前端所需要展现的模型结果和模型表现
 * @author shengwen.qin
 * @date 2017年12月14日
 */
public class Predict_Result implements Serializable {
	private String date;
	
	private String actual_buy_amounts;
	private String actual_redeem_amounts;
	
	
	private Long predict_buy_amounts;
	private String predict_redeem_amounts;
	
	private String buy_accuracy;
	private String redeem_accuracy;
	
	private String buy_redeem_offset;
	
	private String buy_redeem_offset_accuracy;
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getActual_buy_amounts() {
		return actual_buy_amounts;
	}
	public void setActual_buy_amounts(String actual_buy_amounts) {
		this.actual_buy_amounts = actual_buy_amounts;
	}
	
	public String getActual_redeem_amounts() {
		return actual_redeem_amounts;
	}
	public void setActual_redeem_amounts(String actual_redeem_amounts) {
		this.actual_redeem_amounts = actual_redeem_amounts;
	}
	public Long getPredict_buy_amounts() {
		return predict_buy_amounts;
	}
	public void setPredict_buy_amounts(Long predict_buy_amounts) {
		this.predict_buy_amounts = predict_buy_amounts;
	}
	public String getPredict_redeem_amounts() {
		return predict_redeem_amounts;
	}
	public void setPredict_redeem_amounts(String predict_redeem_amounts) {
		this.predict_redeem_amounts = predict_redeem_amounts;
	}
	public String getBuy_accuracy() {
		return buy_accuracy;
	}
	public void setBuy_accuracy(String buy_accuracy) {
		this.buy_accuracy = buy_accuracy;
	}
	public String getRedeem_accuracy() {
		return redeem_accuracy;
	}
	public void setRedeem_accuracy(String redeem_accuracy) {
		this.redeem_accuracy = redeem_accuracy;
	}
	public String getBuy_redeem_offset() {
		return buy_redeem_offset;
	}
	public void setBuy_redeem_offset(String buy_redeem_offset) {
		this.buy_redeem_offset = buy_redeem_offset;
	}
	public String getBuy_redeem_offset_accuracy() {
		return buy_redeem_offset_accuracy;
	}
	public void setBuy_redeem_offset_accuracy(String buy_redeem_offset_accuracy) {
		this.buy_redeem_offset_accuracy = buy_redeem_offset_accuracy;
	}
	
	
	
	
}
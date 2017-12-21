package com.iquantex.mftp.bean;

import java.util.Date;

/**
 * CREATE TABLE model_perform(
 generate_time TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '每次运行模型的时间',
 
 current_day_actual_buy_amounts  COMMENT '当天申购金额',
 current_day_actual_redeem_amounts  COMMENT '当天赎回金额',
 
 pd_next_1_day_buy_amounts  COMMENT '预测第1天的申购金额',
 pd_next_2_day_buy_amounts  COMMENT '预测第2天的申购金额',
 pd_next_3_day_buy_amounts  COMMENT '预测第3天的申购金额',
 pd_next_4_day_buy_amounts  COMMENT '预测第4天的申购金额',
 pd_next_5_day_buy_amounts  COMMENT '预测第5天的申购金额',
 pd_next_6_day_buy_amounts  COMMENT '预测第6天的申购金额',
 pd_next_7_day_buy_amounts  COMMENT '预测第7天的申购金额',
 
 pd_next_1_day_redeem_amounts  COMMENT '预测下1天的赎回金额',
 pd_next_2_day_redeem_amounts  COMMENT '预测下2天的赎回金额',
  pd_next_3_day_redeem_amounts  COMMENT '预测下3天的赎回金额',
 pd_next_4_day_redeem_amounts  COMMENT '预测下4天的赎回金额',
  pd_next_5_day_redeem_amounts  COMMENT '预测下5天的赎回金额',
 pd_next_6_day_redeem_amounts  COMMENT '预测下6天的赎回金额',
  pd_next_7_day_redeem_amounts  COMMENT '预测下7天的赎回金额'
);

 * @author shengwen.qin
 * @date 2017年12月14日
 */
public class ModelPerform {
	
	private Date generate_time ;  
	 
	private Double current_day_actual_buy_amounts ;
	private Double current_day_actual_redeem_amounts ;
	
	private Double pd_next_1_day_buy_amounts  ;
	private Double pd_next_2_day_buy_amounts  ;
	private Double pd_next_3_day_buy_amounts  ;
	private Double pd_next_4_day_buy_amounts  ;
	private Double pd_next_5_day_buy_amounts  ;
	private Double pd_next_6_day_buy_amounts  ;
	private Double pd_next_7_day_buy_amounts  ;
	
	private Double pd_next_1_day_redeem_amounts  ;
	private Double pd_next_2_day_redeem_amounts  ;
	private Double  pd_next_3_day_redeem_amounts  ;
	private Double pd_next_4_day_redeem_amounts  ;
	private Double  pd_next_5_day_redeem_amounts ; 
	private Double pd_next_6_day_redeem_amounts  ;
	private Double  pd_next_7_day_redeem_amounts ;
	
	
	
	public Date getGenerate_time() {
		return generate_time;
	}
	public void setGenerate_time(Date generate_time) {
		this.generate_time = generate_time;
	}
	public Double getCurrent_day_actual_buy_amounts() {
		return current_day_actual_buy_amounts;
	}
	public void setCurrent_day_actual_buy_amounts(Double current_day_actual_buy_amounts) {
		this.current_day_actual_buy_amounts = current_day_actual_buy_amounts;
	}
	public Double getCurrent_day_actual_redeem_amounts() {
		return current_day_actual_redeem_amounts;
	}
	public void setCurrent_day_actual_redeem_amounts(Double current_day_actual_redeem_amounts) {
		this.current_day_actual_redeem_amounts = current_day_actual_redeem_amounts;
	}
	public Double getPd_next_1_day_buy_amounts() {
		return pd_next_1_day_buy_amounts;
	}
	public void setPd_next_1_day_buy_amounts(Double pd_next_1_day_buy_amounts) {
		this.pd_next_1_day_buy_amounts = pd_next_1_day_buy_amounts;
	}
	public Double getPd_next_2_day_buy_amounts() {
		return pd_next_2_day_buy_amounts;
	}
	public void setPd_next_2_day_buy_amounts(Double pd_next_2_day_buy_amounts) {
		this.pd_next_2_day_buy_amounts = pd_next_2_day_buy_amounts;
	}
	public Double getPd_next_3_day_buy_amounts() {
		return pd_next_3_day_buy_amounts;
	}
	public void setPd_next_3_day_buy_amounts(Double pd_next_3_day_buy_amounts) {
		this.pd_next_3_day_buy_amounts = pd_next_3_day_buy_amounts;
	}
	public Double getPd_next_4_day_buy_amounts() {
		return pd_next_4_day_buy_amounts;
	}
	public void setPd_next_4_day_buy_amounts(Double pd_next_4_day_buy_amounts) {
		this.pd_next_4_day_buy_amounts = pd_next_4_day_buy_amounts;
	}
	public Double getPd_next_5_day_buy_amounts() {
		return pd_next_5_day_buy_amounts;
	}
	public void setPd_next_5_day_buy_amounts(Double pd_next_5_day_buy_amounts) {
		this.pd_next_5_day_buy_amounts = pd_next_5_day_buy_amounts;
	}
	public Double getPd_next_6_day_buy_amounts() {
		return pd_next_6_day_buy_amounts;
	}
	public void setPd_next_6_day_buy_amounts(Double pd_next_6_day_buy_amounts) {
		this.pd_next_6_day_buy_amounts = pd_next_6_day_buy_amounts;
	}
	public Double getPd_next_7_day_buy_amounts() {
		return pd_next_7_day_buy_amounts;
	}
	public void setPd_next_7_day_buy_amounts(Double pd_next_7_day_buy_amounts) {
		this.pd_next_7_day_buy_amounts = pd_next_7_day_buy_amounts;
	}
	public Double getPd_next_1_day_redeem_amounts() {
		return pd_next_1_day_redeem_amounts;
	}
	public void setPd_next_1_day_redeem_amounts(Double pd_next_1_day_redeem_amounts) {
		this.pd_next_1_day_redeem_amounts = pd_next_1_day_redeem_amounts;
	}
	public Double getPd_next_2_day_redeem_amounts() {
		return pd_next_2_day_redeem_amounts;
	}
	public void setPd_next_2_day_redeem_amounts(Double pd_next_2_day_redeem_amounts) {
		this.pd_next_2_day_redeem_amounts = pd_next_2_day_redeem_amounts;
	}
	public Double getPd_next_3_day_redeem_amounts() {
		return pd_next_3_day_redeem_amounts;
	}
	public void setPd_next_3_day_redeem_amounts(Double pd_next_3_day_redeem_amounts) {
		this.pd_next_3_day_redeem_amounts = pd_next_3_day_redeem_amounts;
	}
	public Double getPd_next_4_day_redeem_amounts() {
		return pd_next_4_day_redeem_amounts;
	}
	public void setPd_next_4_day_redeem_amounts(Double pd_next_4_day_redeem_amounts) {
		this.pd_next_4_day_redeem_amounts = pd_next_4_day_redeem_amounts;
	}
	public Double getPd_next_5_day_redeem_amounts() {
		return pd_next_5_day_redeem_amounts;
	}
	public void setPd_next_5_day_redeem_amounts(Double pd_next_5_day_redeem_amounts) {
		this.pd_next_5_day_redeem_amounts = pd_next_5_day_redeem_amounts;
	}
	public Double getPd_next_6_day_redeem_amounts() {
		return pd_next_6_day_redeem_amounts;
	}
	public void setPd_next_6_day_redeem_amounts(Double pd_next_6_day_redeem_amounts) {
		this.pd_next_6_day_redeem_amounts = pd_next_6_day_redeem_amounts;
	}
	public Double getPd_next_7_day_redeem_amounts() {
		return pd_next_7_day_redeem_amounts;
	}
	public void setPd_next_7_day_redeem_amounts(Double pd_next_7_day_redeem_amounts) {
		this.pd_next_7_day_redeem_amounts = pd_next_7_day_redeem_amounts;
	}
	@Override
	public String toString() {
		return "ModelPerform [generate_time=" + generate_time + ", current_day_actual_buy_amounts="
				+ current_day_actual_buy_amounts + ", current_day_actual_redeem_amounts="
				+ current_day_actual_redeem_amounts + ", pd_next_1_day_buy_amounts=" + pd_next_1_day_buy_amounts
				+ ", pd_next_2_day_buy_amounts=" + pd_next_2_day_buy_amounts + ", pd_next_3_day_buy_amounts="
				+ pd_next_3_day_buy_amounts + ", pd_next_4_day_buy_amounts=" + pd_next_4_day_buy_amounts
				+ ", pd_next_5_day_buy_amounts=" + pd_next_5_day_buy_amounts + ", pd_next_6_day_buy_amounts="
				+ pd_next_6_day_buy_amounts + ", pd_next_7_day_buy_amounts=" + pd_next_7_day_buy_amounts
				+ ", pd_next_1_day_redeem_amounts=" + pd_next_1_day_redeem_amounts + ", pd_next_2_day_redeem_amounts="
				+ pd_next_2_day_redeem_amounts + ", pd_next_3_day_redeem_amounts=" + pd_next_3_day_redeem_amounts
				+ ", pd_next_4_day_redeem_amounts=" + pd_next_4_day_redeem_amounts + ", pd_next_5_day_redeem_amounts="
				+ pd_next_5_day_redeem_amounts + ", pd_next_6_day_redeem_amounts=" + pd_next_6_day_redeem_amounts
				+ ", pd_next_7_day_redeem_amounts=" + pd_next_7_day_redeem_amounts + "]";
	} 
	
	
	
}

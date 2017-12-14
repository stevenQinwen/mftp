package com.iquantex.mftp.bean;

import java.io.Serializable;
/**
 * CREATE TABLE `t_person_info` (
  `index` bigint(20) DEFAULT NULL,
  `buy_total_counts` bigint(20) DEFAULT NULL,
  `redeem_total_counts` bigint(20) DEFAULT NULL,
  `buy_amounts` double DEFAULT NULL,
  `redeem_amounts` double DEFAULT NULL,
  `cust_no` text,
  `age` bigint(20) DEFAULT NULL,
  `sex` bigint(20) DEFAULT NULL,
  KEY `ix_t_person_info_index` (`index`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

 * @author Administrator
 *
 */
public class CustInfo implements Serializable{
	
	private String cust_no;
	private String age;
	private String sex;
	private String buy_total_counts;
	private String redeem_total_counts;
	private String buy_amounts;
	private String redeem_amounts;
	
	
	public String getCust_no() {
		return cust_no;
	}
	public void setCust_no(String cust_no) {
		this.cust_no = cust_no;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBuy_total_counts() {
		return buy_total_counts;
	}
	public void setBuy_total_counts(String buy_total_counts) {
		this.buy_total_counts = buy_total_counts;
	}
	public String getRedeem_total_counts() {
		return redeem_total_counts;
	}
	public void setRedeem_total_counts(String redeem_total_counts) {
		this.redeem_total_counts = redeem_total_counts;
	}
	public String getBuy_amounts() {
		return buy_amounts;
	}
	public void setBuy_amounts(String buy_amounts) {
		this.buy_amounts = buy_amounts;
	}
	public String getRedeem_amounts() {
		return redeem_amounts;
	}
	public void setRedeem_amounts(String redeem_amounts) {
		this.redeem_amounts = redeem_amounts;
	}
	
	
	

}

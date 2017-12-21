package com.iquantex.mftp.dao;

import java.util.List;
import java.util.Map;

import com.iquantex.mftp.bean.CustInfo;
import com.iquantex.mftp.bean.SQLBean;

public interface CustInfoDao {

	List<CustInfo> selectCustInfoList();

	Map<String,Double> selectCustAgeDistributed(SQLBean sqlBean);

	Map<String, Double> selectCustSexDistributed(SQLBean sqlBean);
	
	
}
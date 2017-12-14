package com.iquantex.mftp.dao;

import java.util.List;

import com.iquantex.mftp.bean.CustInfo;
import com.iquantex.mftp.bean.Predict_Result;

@SuppressWarnings("unused")
public interface CustInfoDao {

	List<CustInfo> selectCustInfoList();
	
	
}
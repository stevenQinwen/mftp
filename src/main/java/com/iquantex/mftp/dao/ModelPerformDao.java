package com.iquantex.mftp.dao;

import java.util.List;
import java.util.Map;

import com.iquantex.mftp.bean.ModelPerform;
import com.iquantex.mftp.bean.SQLBean;

public interface ModelPerformDao {

	List<ModelPerform> selectModelPerformList();

	Map<String, Double> selectModel_performByDate(SQLBean sqlBean);
	List<ModelPerform> selectModel_performRecent_Nday(SQLBean sqlBean);
	
	
}
package com.iquantex.mftp.dao;

import java.util.List;
import java.util.Map;

import com.iquantex.mftp.bean.ModelPerform;
import com.iquantex.mftp.bean.ModelPerformVo;
import com.iquantex.mftp.bean.SQLBean;

public interface ModelPerformDao {

	List<ModelPerform> selectModelPerformList();

	List<ModelPerformVo> select_next7day_predicted(SQLBean sqlBean);
	List<ModelPerform> selectModel_performRecent_Nday(SQLBean sqlBean);
	
	
}
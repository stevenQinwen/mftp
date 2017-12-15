package com.iquantex.mftp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iquantex.mftp.bean.ModelFitParam;
import com.iquantex.mftp.bean.SQLBean;

public interface ModelFitParamDao {

	
	List<ModelFitParam> selectModelFitParamList(SQLBean sql);
	
	
}
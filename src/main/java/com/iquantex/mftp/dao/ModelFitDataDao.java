package com.iquantex.mftp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iquantex.mftp.bean.ModelFitData;
import com.iquantex.mftp.bean.ModelFitParam;

public interface ModelFitDataDao {

	List<ModelFitData> selectModelFitDataBuyList();
	List<ModelFitData> selectModelFitDataRedeemList();
	
	
}
package com.iquantex.mftp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iquantex.mftp.bean.ModelParam;
import com.iquantex.mftp.bean.ModelParamTmp;

public interface ModelParamDao {

	List<ModelParam> selectModelParamList();

	List<ModelParam> selectModelParamList(@Param("p1") String buy_or_redeem);
	
	
}
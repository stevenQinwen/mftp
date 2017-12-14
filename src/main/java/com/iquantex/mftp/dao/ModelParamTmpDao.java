package com.iquantex.mftp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iquantex.mftp.bean.ModelParamTmp;

public interface ModelParamTmpDao {

	List<ModelParamTmp> selectModelParamTmpList();

	List<ModelParamTmp> selectModelParamTmpList(@Param("p1") String buy_or_redeem);
	
	
}
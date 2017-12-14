package com.iquantex.mftp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iquantex.mftp.bean.Daily_Macro_Factor;



public interface DailyMacrofactorDao {

//	List<Daily_Macro_Factor> selectDailyMacroFactorList();

	List<Daily_Macro_Factor> selectDailyMacroFactorList(@Param("p1") String targetName,@Param("p2") String featureName);
	
	
}
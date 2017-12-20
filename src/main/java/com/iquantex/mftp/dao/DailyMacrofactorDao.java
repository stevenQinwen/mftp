package com.iquantex.mftp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iquantex.mftp.bean.Daily_Macro_Factor;
import com.iquantex.mftp.bean.SQLBean;



public interface DailyMacrofactorDao {

//	List<Daily_Macro_Factor> DailyMacroFactorList();;

	List<Daily_Macro_Factor> selectDailyMacroFactorList(@Param("p1") String targetName,@Param("p2") String featureName);
	
	 public List<Daily_Macro_Factor> selectBuyAmounts_p2p_interest_indexList();
	 public List<Daily_Macro_Factor> selectBuyAmounts_hs300_closeList ();
	 public List<Daily_Macro_Factor>  selectBuyAmounts_bond204_turnoverValueList ();
	 public List<Daily_Macro_Factor>  selectBuyAmounts_Shibor_rateList ();
	 public List<Daily_Macro_Factor>  selectBuyAmounts_Inter_bank_lending_day_turnoverValueList ();
	 public List<Daily_Macro_Factor>  selectRedeemAmounts_p2p_interest_indexList ();
	 public List<Daily_Macro_Factor>  selectRedeemAmounts_hs300_closeList ();
	 public List<Daily_Macro_Factor>  selectRedeemAmounts_bond204_turnoverValueList ();
	 public List<Daily_Macro_Factor>  selectRedeemAmounts_Shibor_rateList ();
	 public List<Daily_Macro_Factor>  selectRedeemAmounts_Inter_bank_lending_day_turnoverValueList ();
	 
	 public List<Daily_Macro_Factor>  selectHistory_Trends (SQLBean sqlBean);

	 
	 
	 
}
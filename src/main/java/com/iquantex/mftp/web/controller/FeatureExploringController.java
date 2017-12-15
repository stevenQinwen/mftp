package com.iquantex.mftp.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iquantex.mftp.bean.Bean1;
import com.iquantex.mftp.bean.Bean2;
import com.iquantex.mftp.bean.Daily_Macro_Factor;
import com.iquantex.mftp.common.utils.ColumnsNameMapingUtils;
import com.iquantex.mftp.common.utils.ResultObj;
import com.iquantex.mftp.dao.DailyMacrofactorDao;


@Controller

@RequestMapping("/feature_exploring")
public class FeatureExploringController extends BaseController{
	
	@Autowired
	private DailyMacrofactorDao dailyMacrofactorDao;
	
	/**
	 * 根据传递进来的列名字，我们返回相应的列
	 * @param targetName接收的是预测的目标
	 * @param featureName接收的是要检验的特征的名字
	 * @return  
	 */
	
	@RequestMapping(method = RequestMethod.GET, value = "/select_target_and_feature/{targetName}/{featureName}",produces = "application/json; charset=utf-8")
	public @ResponseBody ResultObj featureExploring(@PathVariable String targetName,@PathVariable String featureName) {
		
		//List<Predict_Result> predict_ResultList = showModelResultService.findPredict_ResultList(feature1,feature2); //但是这样的话我们就每次都是从数据库里面查询出同样的数据
		//List<Daily_Macro_Factor> predict_ResultList = dailyMacrofactorDao.selectDailyMacroFactorList(targetName,featureName); //但是这样的话我们就每次都是从数据库里面查询出同样的数据
		
		ArrayList<Bean1> data = null;
		
		if("daily_buy_amounts".equals(targetName)) {
    		if("p2p_pop_index".equals(featureName)) {
    			
    		}else if("p2p_interest_index".equals(featureName)) {
    			List<Daily_Macro_Factor> list = dailyMacrofactorDao.selectBuyAmounts_p2p_interest_indexList();

    			 data = new ArrayList<Bean1>();
    		    for (Daily_Macro_Factor daily_Macro_Factor : list) {
    		    	List<Bean2> bean2_list =new ArrayList<Bean2>(2);
    		    	Bean2 bean3 = new Bean2();
    		    	Bean2 bean2 = new Bean2();
    		    		
    		    	
    					bean2.setValue(Double.parseDouble(daily_Macro_Factor.getDaily_buy_amounts()));
    					bean3.setValue(Double.parseDouble(daily_Macro_Factor.getP2p_interest_index()));
    					
//    					读取properties然后将数据转成前端可以显示的中文
    					String targetName_CN = ColumnsNameMapingUtils.transform2ChineseName(targetName);
    					String featureName_CN = ColumnsNameMapingUtils.transform2ChineseName(featureName);
    					
    					bean2.setName(targetName_CN);
    					bean3.setName(featureName_CN);
    					
    				
    				bean2_list.add(bean2);
    				bean2_list.add(bean3);
    				Bean1 bean1 = new Bean1();
    				bean1.setName(daily_Macro_Factor.getDate().substring(0, 10).replace("-", "/"));
    				bean1.setValue(bean2_list);
    				data.add(bean1);
    			}
    		}else if("p2p_develop_index".equals(featureName)) {
    			
    		}else if("p2p_term_index".equals(featureName)) {
    			
    		}else if("bond204_closePrice".equals(featureName)) {
    			
    		}
    		else if("bond204_turnoverValue".equals(featureName)) {
    			List<Daily_Macro_Factor> list = dailyMacrofactorDao.selectBuyAmounts_bond204_turnoverValueList();
    			 data = new ArrayList<Bean1>();
     		    for (Daily_Macro_Factor daily_Macro_Factor : list) {
     		    	List<Bean2> bean2_list =new ArrayList<Bean2>(2);
     		    	Bean2 bean3 = new Bean2();
     		    	Bean2 bean2 = new Bean2();
     		    		
     		    	
     					bean2.setValue(Double.parseDouble(daily_Macro_Factor.getDaily_buy_amounts()));
     					bean3.setValue(Double.parseDouble(daily_Macro_Factor.getBond204_turnoverValue()));
     					
//     					读取properties然后将数据转成前端可以显示的中文
     					String targetName_CN = ColumnsNameMapingUtils.transform2ChineseName(targetName);
     					String featureName_CN = ColumnsNameMapingUtils.transform2ChineseName(featureName);
     					
     					bean2.setName(targetName_CN);
     					bean3.setName(featureName_CN);
     					
     				
     				bean2_list.add(bean2);
     				bean2_list.add(bean3);
     				Bean1 bean1 = new Bean1();
     				bean1.setName(daily_Macro_Factor.getDate().substring(0, 10).replace("-", "/"));
     				bean1.setValue(bean2_list);
     				data.add(bean1);
     			}
    		}
    		else if("cpi_cpi".equals(featureName)) {
    			
    		}else if("GDP_dataValue".equals(featureName)) {
    			
    		}else if("get_gdp_month_gdp_yoy".equals(featureName)) {
    			
    		}else if("hs300_close".equals(featureName)) {
    			List<Daily_Macro_Factor> list = dailyMacrofactorDao.selectBuyAmounts_hs300_closeList();
    			 data = new ArrayList<Bean1>();
     		    for (Daily_Macro_Factor daily_Macro_Factor : list) {
     		    	List<Bean2> bean2_list =new ArrayList<Bean2>(2);
     		    	Bean2 bean3 = new Bean2();
     		    	Bean2 bean2 = new Bean2();
     		    		
     		    	
     					bean2.setValue(Double.parseDouble(daily_Macro_Factor.getDaily_buy_amounts()));
     					bean3.setValue(Double.parseDouble(daily_Macro_Factor.getHs300_close()));
     					
//     					读取properties然后将数据转成前端可以显示的中文
     					String targetName_CN = ColumnsNameMapingUtils.transform2ChineseName(targetName);
     					String featureName_CN = ColumnsNameMapingUtils.transform2ChineseName(featureName);
     					
     					bean2.setName(targetName_CN);
     					bean3.setName(featureName_CN);
     					
     				
     				bean2_list.add(bean2);
     				bean2_list.add(bean3);
     				Bean1 bean1 = new Bean1();
     				bean1.setName(daily_Macro_Factor.getDate().substring(0, 10).replace("-", "/"));
     				bean1.setValue(bean2_list);
     				data.add(bean1);
     			}
    		}else if("hs300_volume".equals(featureName)) {
    			
    		}else if("hs300_p_change".equals(featureName)) {
    			
    		}else if("hs300_ma5".equals(featureName)) {
    			
    		}else if("hs300_ma10".equals(featureName)) {
    			
    		}else if("hs300_ma20".equals(featureName)) {
    			
    		}else if("hs300_v_ma5".equals(featureName)) {
    			
    		}else if("hs300_v_ma10".equals(featureName)) {
    			
    		}else if("hs300_v_ma20".equals(featureName)) {
    			
    		}else if("money_supply_m2".equals(featureName)) {
    			
    		}else if("money_supply_m2_yoy".equals(featureName)) {
    			
    		}else if("money_supply_cd".equals(featureName)) {
    			
    		}else if("money_supply_qm".equals(featureName)) {
    			
    		}else if("ppi_food".equals(featureName)) {
    			
    		}else if("Shibor_rate".equals(featureName)) {
    			List<Daily_Macro_Factor> list = dailyMacrofactorDao.selectBuyAmounts_Shibor_rateList();
    			 data = new ArrayList<Bean1>();
     		    for (Daily_Macro_Factor daily_Macro_Factor : list) {
     		    	List<Bean2> bean2_list =new ArrayList<Bean2>(2);
     		    	Bean2 bean3 = new Bean2();
     		    	Bean2 bean2 = new Bean2();
     		    		
     		    	
     					bean2.setValue(Double.parseDouble(daily_Macro_Factor.getDaily_buy_amounts()));
     					bean3.setValue(Double.parseDouble(daily_Macro_Factor.getShibor_rate()));
     					
//     					读取properties然后将数据转成前端可以显示的中文
     					String targetName_CN = ColumnsNameMapingUtils.transform2ChineseName(targetName);
     					String featureName_CN = ColumnsNameMapingUtils.transform2ChineseName(featureName);
     					
     					bean2.setName(targetName_CN);
     					bean3.setName(featureName_CN);
     					
     				
     				bean2_list.add(bean2);
     				bean2_list.add(bean3);
     				Bean1 bean1 = new Bean1();
     				bean1.setName(daily_Macro_Factor.getDate().substring(0, 10).replace("-", "/"));
     				bean1.setValue(bean2_list);
     				data.add(bean1);
     			}
    		}else if("real_estate_invest_dataValue".equals(featureName)) {
    			
    		}else if("domestic_fiscal_expenditure_dataValue".equals(featureName)) {
    			
    		}else if("domestic_fiscal_income_dataValue".equals(featureName)) {
    			
    		}else if("economic_climate_index_dataValue".equals(featureName)) {
    			
    		}else if("consume_climate_index_dataValue".equals(featureName)) {
    			
    		}else if("base_loan_rate_1year".equals(featureName)) {
    			
    		}else if("Inter_bank_lending_day_preCloseRate".equals(featureName)) {
    			
    		}else if("Inter_bank_lending_day_bpChg".equals(featureName)) {
    			
    		}else if("Inter_bank_lending_day_turnoverValue".equals(featureName)) {
    			List<Daily_Macro_Factor> list = dailyMacrofactorDao.selectBuyAmounts_Inter_bank_lending_day_turnoverValueList();
    			 data = new ArrayList<Bean1>();
     		    for (Daily_Macro_Factor daily_Macro_Factor : list) {
     		    	List<Bean2> bean2_list =new ArrayList<Bean2>(2);
     		    	Bean2 bean3 = new Bean2();
     		    	Bean2 bean2 = new Bean2();
     		    		
     		    	
     					bean2.setValue(Double.parseDouble(daily_Macro_Factor.getDaily_buy_amounts()));
     					bean3.setValue(Double.parseDouble(daily_Macro_Factor.getInter_bank_lending_day_turnoverValue()));
     					
//     					读取properties然后将数据转成前端可以显示的中文
     					String targetName_CN = ColumnsNameMapingUtils.transform2ChineseName(targetName);
     					String featureName_CN = ColumnsNameMapingUtils.transform2ChineseName(featureName);
     					
     					bean2.setName(targetName_CN);
     					bean3.setName(featureName_CN);
     					
     				
     				bean2_list.add(bean2);
     				bean2_list.add(bean3);
     				Bean1 bean1 = new Bean1();
     				bean1.setName(daily_Macro_Factor.getDate().substring(0, 10).replace("-", "/"));
     				bean1.setValue(bean2_list);
     				data.add(bean1);
     			}
    		}else if("Inter_bank_lending_day_turnoverChg".equals(featureName)) {
    			
    		}else if("money_fund_7day_rate".equals(featureName)) {
    			
    		}
    		else {
    			//bean3.setValue(Double.parseDouble(daily_Macro_Factor.getP2p_pop_index()));
    			
    		}
 //------------------------------------------------------------------------------------------------------
    	}else if("daily_redeem_amounts".equals(targetName)) {
    		if("p2p_pop_index".equals(featureName)) {
    			
    		}else if("p2p_interest_index".equals(featureName)) {
    			List<Daily_Macro_Factor> list = dailyMacrofactorDao.selectRedeemAmounts_p2p_interest_indexList();
    			 data = new ArrayList<Bean1>();
     		    for (Daily_Macro_Factor daily_Macro_Factor : list) {
     		    	List<Bean2> bean2_list =new ArrayList<Bean2>(2);
     		    	Bean2 bean3 = new Bean2();
     		    	Bean2 bean2 = new Bean2();
     		    		
     		    	
     					bean2.setValue(Double.parseDouble(daily_Macro_Factor.getDaily_redeem_amounts()));
     					bean3.setValue(Double.parseDouble(daily_Macro_Factor.getP2p_interest_index()));
     					
//     					读取properties然后将数据转成前端可以显示的中文
     					String targetName_CN = ColumnsNameMapingUtils.transform2ChineseName(targetName);
     					String featureName_CN = ColumnsNameMapingUtils.transform2ChineseName(featureName);
     					
     					bean2.setName(targetName_CN);
     					bean3.setName(featureName_CN);
     					
     				
     				bean2_list.add(bean2);
     				bean2_list.add(bean3);
     				Bean1 bean1 = new Bean1();
     				bean1.setName(daily_Macro_Factor.getDate().substring(0, 10).replace("-", "/"));
     				bean1.setValue(bean2_list);
     				data.add(bean1);
     			}
    		}else if("p2p_develop_index".equals(featureName)) {
    			
    		}else if("p2p_term_index".equals(featureName)) {
    			
    		}else if("bond204_closePrice".equals(featureName)) {
    			
    		}
    		else if("bond204_turnoverValue".equals(featureName)) {
    			
    		}
    		else if("cpi_cpi".equals(featureName)) {
    			
    		}else if("GDP_dataValue".equals(featureName)) {
    			
    		}else if("get_gdp_month_gdp_yoy".equals(featureName)) {
    			
    		}else if("hs300_close".equals(featureName)) {
    			List<Daily_Macro_Factor> list = dailyMacrofactorDao.selectRedeemAmounts_hs300_closeList();
    			 data = new ArrayList<Bean1>();
     		    for (Daily_Macro_Factor daily_Macro_Factor : list) {
     		    	List<Bean2> bean2_list =new ArrayList<Bean2>(2);
     		    	Bean2 bean3 = new Bean2();
     		    	Bean2 bean2 = new Bean2();
     		    		
     		    	
     					bean2.setValue(Double.parseDouble(daily_Macro_Factor.getDaily_redeem_amounts()));
     					bean3.setValue(Double.parseDouble(daily_Macro_Factor.getHs300_close()));
     					
//     					读取properties然后将数据转成前端可以显示的中文
     					String targetName_CN = ColumnsNameMapingUtils.transform2ChineseName(targetName);
     					String featureName_CN = ColumnsNameMapingUtils.transform2ChineseName(featureName);
     					
     					bean2.setName(targetName_CN);
     					bean3.setName(featureName_CN);
     					
     				
     				bean2_list.add(bean2);
     				bean2_list.add(bean3);
     				Bean1 bean1 = new Bean1();
     				bean1.setName(daily_Macro_Factor.getDate().substring(0, 10).replace("-", "/"));
     				bean1.setValue(bean2_list);
     				data.add(bean1);
     			}
    		}else if("hs300_volume".equals(featureName)) {
    			
    		}else if("hs300_p_change".equals(featureName)) {
    			
    		}else if("hs300_ma5".equals(featureName)) {
    			
    		}else if("hs300_ma10".equals(featureName)) {
    			
    		}else if("hs300_ma20".equals(featureName)) {
    			
    		}else if("hs300_v_ma5".equals(featureName)) {
    			
    		}else if("hs300_v_ma10".equals(featureName)) {
    			
    		}else if("hs300_v_ma20".equals(featureName)) {
    			
    		}else if("money_supply_m2".equals(featureName)) {
    			
    		}else if("money_supply_m2_yoy".equals(featureName)) {
    			
    		}else if("money_supply_cd".equals(featureName)) {
    			
    		}else if("money_supply_qm".equals(featureName)) {
    			
    		}else if("ppi_food".equals(featureName)) {
    			
    		}else if("Shibor_rate".equals(featureName)) {
    			List<Daily_Macro_Factor> list = dailyMacrofactorDao.selectRedeemAmounts_Shibor_rateList();
    			 data = new ArrayList<Bean1>();
     		    for (Daily_Macro_Factor daily_Macro_Factor : list) {
     		    	List<Bean2> bean2_list =new ArrayList<Bean2>(2);
     		    	Bean2 bean3 = new Bean2();
     		    	Bean2 bean2 = new Bean2();
     		    		
     		    	
     					bean2.setValue(Double.parseDouble(daily_Macro_Factor.getDaily_redeem_amounts()));
     					bean3.setValue(Double.parseDouble(daily_Macro_Factor.getShibor_rate()));
     					
//     					读取properties然后将数据转成前端可以显示的中文
     					String targetName_CN = ColumnsNameMapingUtils.transform2ChineseName(targetName);
     					String featureName_CN = ColumnsNameMapingUtils.transform2ChineseName(featureName);
     					
     					bean2.setName(targetName_CN);
     					bean3.setName(featureName_CN);
     					
     				
     				bean2_list.add(bean2);
     				bean2_list.add(bean3);
     				Bean1 bean1 = new Bean1();
     				bean1.setName(daily_Macro_Factor.getDate().substring(0, 10).replace("-", "/"));
     				bean1.setValue(bean2_list);
     				data.add(bean1);
     			}
    		}else if("real_estate_invest_dataValue".equals(featureName)) {
    			
    		}else if("domestic_fiscal_expenditure_dataValue".equals(featureName)) {
    			
    		}else if("domestic_fiscal_income_dataValue".equals(featureName)) {
    			
    		}else if("economic_climate_index_dataValue".equals(featureName)) {
    			
    		}else if("consume_climate_index_dataValue".equals(featureName)) {
    			
    		}else if("base_loan_rate_1year".equals(featureName)) {
    			
    		}else if("Inter_bank_lending_day_preCloseRate".equals(featureName)) {
    			
    		}else if("Inter_bank_lending_day_bpChg".equals(featureName)) {
    			
    		}else if("Inter_bank_lending_day_turnoverValue".equals(featureName)) {
    			List<Daily_Macro_Factor> list = dailyMacrofactorDao.selectRedeemAmounts_Inter_bank_lending_day_turnoverValueList();
    			 data = new ArrayList<Bean1>();
     		    for (Daily_Macro_Factor daily_Macro_Factor : list) {
     		    	List<Bean2> bean2_list =new ArrayList<Bean2>(2);
     		    	Bean2 bean3 = new Bean2();
     		    	Bean2 bean2 = new Bean2();
     		    		
     		    	
     					bean2.setValue(Double.parseDouble(daily_Macro_Factor.getDaily_redeem_amounts()));
     					bean3.setValue(Double.parseDouble(daily_Macro_Factor.getInter_bank_lending_day_turnoverValue()));
     					
//     					读取properties然后将数据转成前端可以显示的中文
     					String targetName_CN = ColumnsNameMapingUtils.transform2ChineseName(targetName);
     					String featureName_CN = ColumnsNameMapingUtils.transform2ChineseName(featureName);
     					
     					bean2.setName(targetName_CN);
     					bean3.setName(featureName_CN);
     					
     				
     				bean2_list.add(bean2);
     				bean2_list.add(bean3);
     				Bean1 bean1 = new Bean1();
     				bean1.setName(daily_Macro_Factor.getDate().substring(0, 10).replace("-", "/"));
     				bean1.setValue(bean2_list);
     				data.add(bean1);
     			}
    		}else if("Inter_bank_lending_day_turnoverChg".equals(featureName)) {
    			
    		}else if("money_fund_7day_rate".equals(featureName)) {
    			
    		}
    		else {
    			//bean3.setValue(Double.parseDouble(daily_Macro_Factor.getP2p_pop_index()));
    			
    		}
    		
    	}else if("".equals(targetName)){
    		
    	}
		
		ResultObj resultObj=null;
		
		if(true) { //如果是成功就返回正常的数据
			resultObj = successReturn().setData("list", data);
		}else {
			
		}
		resultObj.setMsg("成功");
	    return resultObj;
		
		
	}
	
	
}






package com.iquantex.mftp.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iquantex.mftp.bean.Bean1;
import com.iquantex.mftp.bean.Bean2;
import com.iquantex.mftp.bean.Daily_Macro_Factor;
import com.iquantex.mftp.bean.SQLBean;
import com.iquantex.mftp.common.exception.ErrorCode;
import com.iquantex.mftp.common.utils.ColumnsNameMapingUtils;
import com.iquantex.mftp.common.utils.ResultObj;
import com.iquantex.mftp.dao.DailyMacrofactorDao;


@Controller

@RequestMapping("/feature_exploring")
public class FeatureExploringController extends BaseController{
	
	@Autowired
	private DailyMacrofactorDao dailyMacrofactorDao;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/select_his_trends",produces = "application/json; charset=utf-8")
	public @ResponseBody ResultObj getHistory_Trends() {
		
		  String sql="select date, d.daily_buy_times,d.daily_redeem_times,d.daily_buy_amounts,d.daily_redeem_amounts from daily_marco_factor d";
		    
		  //使用SQLBean的方式去拼接sql，然后使用map集合返回我们需要的东西
			SQLBean sqlBean = new SQLBean(sql);
			//如何返回一个map,这是我们需要解决的问题
			 List<Daily_Macro_Factor> history_Trends = dailyMacrofactorDao.selectHistory_Trends(sqlBean);
			 
		   System.out.println(history_Trends);
		

		   ArrayList<Bean1> data = new ArrayList<Bean1>();
		    for (Daily_Macro_Factor daily_Macro_Factor : history_Trends) {
		    	List<Bean2> bean2_list =new ArrayList<Bean2>();
		    	
		    	Bean2 b4 = new Bean2();
		    	Bean2 b3 = new Bean2();
		    	Bean2 b2 = new Bean2();
		    	Bean2 b1 = new Bean2();
		    		
		    	
					b1.setValue(Double.parseDouble(daily_Macro_Factor.getDaily_buy_times()));
					b2.setValue(Double.parseDouble(daily_Macro_Factor.getDaily_buy_amounts()));
					b3.setValue(Double.parseDouble(daily_Macro_Factor.getDaily_redeem_times()));
					b4.setValue(Double.parseDouble(daily_Macro_Factor.getDaily_redeem_amounts()));
					
//					读取properties然后将数据转成前端可以显示的中文
					
					b1.setName("申购次数");
					b2.setName("申购金额");
					b3.setName("赎回次数");
					b4.setName("赎回金额");
					
				
				bean2_list.add(b1);
				bean2_list.add(b2);
				bean2_list.add(b3);
				bean2_list.add(b4);
				
				Bean1 bean1 = new Bean1();
				bean1.setName(daily_Macro_Factor.getDate().substring(0, 10).replace("-", "/"));
				bean1.setValue(bean2_list);
				data.add(bean1);
		    }
		    
		    ResultObj resultObj=null;
		    
		    if(true) { //如果是成功就返回正常的数据
		    	resultObj = successReturn().setData("list", data);
		    }else {
		    	
		    }
		    resultObj.setMsg("成功");
		    return resultObj ;
		
	}
	
	
	
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
		
		ResultObj resultObj=null;
		ArrayList<Bean1> data = null;
		
		if("daily_buy_amounts".equals(targetName)) {
    		if("p2p_pop_index".equals(featureName)) {
    			
    		}else if("p2p_interest_index".equals(featureName)) {
    			List<Daily_Macro_Factor> list = dailyMacrofactorDao.selectBuyAmounts_p2p_interest_indexList();
    			if(list!=null&&list.size()!=0) { 
    				
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
    		    resultObj = successReturn().setData("list", data);
	   			   resultObj.setMsg("成功");  
			}else {
				resultObj = errorReturn(ErrorCode.OK, "所请求的数据不存在，请检查！");
			}
    		}else if("p2p_develop_index".equals(featureName)) {
    			
    		}else if("p2p_term_index".equals(featureName)) {
    			
    		}else if("bond204_closePrice".equals(featureName)) {
    			
    		}
    		else if("bond204_turnoverValue".equals(featureName)) {
    			List<Daily_Macro_Factor> list = dailyMacrofactorDao.selectBuyAmounts_bond204_turnoverValueList();
    			
    			
    			 if(list!=null&&list.size()!=0) { 
    				 data = new ArrayList<Bean1>();
    	     		    for (Daily_Macro_Factor daily_Macro_Factor : list) {
    	     		    	List<Bean2> bean2_list =new ArrayList<Bean2>(2);
    	     		    	Bean2 bean3 = new Bean2();
    	     		    	Bean2 bean2 = new Bean2();
    	     		    		
    	     		    	
    	     					bean2.setValue(Double.parseDouble(daily_Macro_Factor.getDaily_buy_amounts()));
    	     					bean3.setValue(Double.parseDouble(daily_Macro_Factor.getBond204_turnoverValue()));
    	     					
//    	     					读取properties然后将数据转成前端可以显示的中文
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
    	     		   resultObj = successReturn().setData("list", data);
    	   			   resultObj.setMsg("成功");  
    			}else {
    				resultObj = errorReturn(ErrorCode.OK, "所请求的数据不存在，请检查！");
    			}
    			
    		}
    		else if("cpi_cpi".equals(featureName)) {
    			
    		}else if("GDP_dataValue".equals(featureName)) {
    			
    		}else if("get_gdp_month_gdp_yoy".equals(featureName)) {
    			
    		}else if("hs300_close".equals(featureName)) {
    			List<Daily_Macro_Factor> list = dailyMacrofactorDao.selectBuyAmounts_hs300_closeList();
    			
    			if(list!=null&&list.size()!=0) { 
    				
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
    				 resultObj = successReturn().setData("list", data);
  	   			    resultObj.setMsg("成功");
    			}else {
    				resultObj = errorReturn(ErrorCode.OK, "所请求的数据不存在，请检查！");
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
    			
    			
    			if(list!=null&&list.size()!=0) { 
    				
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
    				
    				 resultObj = successReturn().setData("list", data);
   	   			    resultObj.setMsg("成功");
     			}else {
     				resultObj = errorReturn(ErrorCode.OK, "所请求的数据不存在，请检查！");
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
    			 
    			if(list!=null&&list.size()!=0) { 
    				
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
    				resultObj = successReturn().setData("list", data);
   	   			    resultObj.setMsg("成功");
     			}else {
     				resultObj = errorReturn(ErrorCode.OK, "所请求的数据不存在，请检查！");
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
    			
    			if(list!=null&&list.size()!=0) {
    				
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
    				resultObj = successReturn().setData("list", data);
   	   			    resultObj.setMsg("成功");
     			}else {
     				resultObj = errorReturn(ErrorCode.OK, "所请求的数据不存在，请检查！");
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
    			if(list!=null&&list.size()!=0) {
    				
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
    				
    				resultObj = successReturn().setData("list", data);
   	   			    resultObj.setMsg("成功");
     			}else {
     				resultObj = errorReturn(ErrorCode.OK, "所请求的数据不存在，请检查！");
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
    			
    			if(list!=null&&list.size()!=0) {
    				
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
    				resultObj = successReturn().setData("list", data);
   	   			    resultObj.setMsg("成功");
     			}else {
     				resultObj = errorReturn(ErrorCode.OK, "所请求的数据不存在，请检查！");
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
    			 if(list!=null&&list.size()!=0) {
    				 
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
    				resultObj = successReturn().setData("list", data);
   	   			    resultObj.setMsg("成功");
     			}else {
     				resultObj = errorReturn(ErrorCode.OK, "所请求的数据不存在，请检查！");
     			}
    			 
    		}else if("Inter_bank_lending_day_turnoverChg".equals(featureName)) {
    			
    		}else if("money_fund_7day_rate".equals(featureName)) {
    			
    		}
    		else {
    			//bean3.setValue(Double.parseDouble(daily_Macro_Factor.getP2p_pop_index()));
    			
    		}
    		
    	}else if("".equals(targetName)){
    		resultObj = errorReturn(ErrorCode.OK, "所请求的数据不存在，请检查！");
    	}
		
		
			
			
			
	    return resultObj;
		
		
	}
	
	
}






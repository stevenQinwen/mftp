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
import com.iquantex.mftp.bean.CustInfo;
import com.iquantex.mftp.bean.Daily_Macro_Factor;
import com.iquantex.mftp.common.utils.ResultObj;
import com.iquantex.mftp.dao.CustInfoDao;
import com.iquantex.mftp.dao.DailyMacrofactorDao;


@Controller

@RequestMapping("/user_analysis")
public class UserAnalysisController extends BaseController{
	
	@Autowired
	private CustInfoDao custInfoDao;
	
	@RequestMapping(method = RequestMethod.GET, value = "/age_distributed/{targetName}/{featureName}")//待定
	public @ResponseBody ResultObj getAgeDistribute(@PathVariable String targetName,@PathVariable String featureName) {
		
		List<CustInfo> custInfoList = custInfoDao.selectCustInfoList(); //但是这样的话我们就每次都是从数据库里面查询出同样的数据
		//我们的目的是为了封装成这个数据
		/*"list": [
		            {
		                "name": "18-25岁",
		                "value": [
		                    {
		                        "name": "人数",
		                        "value": 3247342
		                    }
		                ]
		            },
		            {
		                "name": "26-35岁",
		                "value": [
		                    {
		                        "name": "人数",
		                        "value": 2752199
		                    }
		                ]
		            },
		            {
		                "name": "36-45岁",
		                "value": [
		                    {
		                        "name": "人数",
		                        "value": 3119816
		                    }
		                ]
		            },
		            {
		                "name": "46-55岁",
		                "value": [
		                    {
		                        "name": "人数",
		                        "value": 3111133
		                    }
		                ]
		            },
		            {
		                "name": "55岁以上",
		                "value": [
		                    {
		                        "name": "人数",
		                        "value": 2757762
		                    }
		                    
		                ]
		            }
					]*/
		//list:data
		ArrayList<Bean1> data = new ArrayList<Bean1>();
	    for (CustInfo daily_Macro_Factor : custInfoList) {
	    	List<Bean2> bean2_list =new ArrayList<Bean2>(2);
	    	Bean2 bean3 = new Bean2();
	    	Bean2 bean2 = new Bean2();
	    	if("buy_times".equals(targetName)&&"redeem_times".equals(featureName)) {
	    		//这里是写用户分析图，到底是我要查询出什么样的数据返回去呢
	    		
				bean2.setName("申购金额");
//				bean2.setValue(Double.parseDouble(daily_Macro_Factor.getDaily_buy_amounts()));
				
				bean3.setName("p2p发展指数");
//				bean3.setValue(Double.parseDouble(daily_Macro_Factor.getP2p_develop_index()));
	    	
	    	}	
				if("buy_times".equals(targetName)&&"redeem_times".equals(featureName)) {				
				
				
			
				
				
			}
			else {
				
			}
			bean2_list.add(bean2);
			bean2_list.add(bean3);
			Bean1 bean1 = new Bean1();
//			bean1.setName(daily_Macro_Factor.getDate().substring(0, 10).replace("-", "/"));
			bean1.setValue(bean2_list);
			data.add(bean1);
		}
		ResultObj resultObj=null;
		
		if(true) { //如果是成功就返回正常的数据
			resultObj = successReturn().setData("list", data);
		}else {
			
		}
		resultObj.setMsg("成功");
	    return resultObj;
		
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/sex_distributed/{targetName}/{featureName}")//待定
	public @ResponseBody ResultObj getSexDistribute(@PathVariable String targetName,@PathVariable String featureName) {
		
		List<CustInfo> custInfoList = custInfoDao.selectCustInfoList(); //但是这样的话我们就每次都是从数据库里面查询出同样的数据
		
		
		
		ArrayList<Bean1> data = new ArrayList<Bean1>();
		
	    for (CustInfo daily_Macro_Factor : custInfoList) {
	    	List<Bean2> bean2_list =new ArrayList<Bean2>(2);
	    	Bean2 bean3 = new Bean2();
	    	Bean2 bean2 = new Bean2();
	    	if("buy_times".equals(targetName)&&"redeem_times".equals(featureName)) {
	    		//这里是写用户分析图，到底是我要查询出什么样的数据返回去呢
	    		
				bean2.setName("申购金额");
//				bean2.setValue(Double.parseDouble(daily_Macro_Factor.getDaily_buy_amounts()));
				
				bean3.setName("p2p发展指数");
//				bean3.setValue(Double.parseDouble(daily_Macro_Factor.getP2p_develop_index()));
	    	
	    	}	
				if("buy_times".equals(targetName)&&"redeem_times".equals(featureName)) {				
				
				
			
				
				
			}
			else {
				
			}
			bean2_list.add(bean2);
			bean2_list.add(bean3);
			Bean1 bean1 = new Bean1();
//			bean1.setName(daily_Macro_Factor.getDate().substring(0, 10).replace("-", "/"));
			bean1.setValue(bean2_list);
			data.add(bean1);
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






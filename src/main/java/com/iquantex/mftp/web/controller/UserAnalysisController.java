package com.iquantex.mftp.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.iquantex.mftp.bean.Bean1;
import com.iquantex.mftp.bean.Bean2;
import com.iquantex.mftp.bean.CustInfo;
import com.iquantex.mftp.bean.SQLBean;
import com.iquantex.mftp.common.utils.ResultObj;
import com.iquantex.mftp.dao.CustInfoDao;


@Controller
@RequestMapping("/user_analysis")
public class UserAnalysisController extends BaseController{
	
	@Autowired
	private CustInfoDao custInfoDao;
	
	/**
	 * 因为json的数据格式是固定的，所以使用这种方式比较便捷
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "sex_distributed/{buyOrRedeem}")//待定
	@ResponseBody
	public JSONObject getSexDistributed(@PathVariable String buyOrRedeem) {
		
		 String sql="SELECT COUNT(CASE u.sex WHEN '0' THEN u.sex END) AS \"female\" ,\r\n" + 
		 		"   COUNT(CASE u.sex WHEN '1' THEN u.sex END) AS \"male\",\r\n" + 
		 		"   COUNT(CASE u.sex WHEN '9' THEN u.sex END) AS \"unknown\"\r\n" + 
		 		"    FROM (SELECT t.sex AS sex FROM t_person_info t)  u";
			//使用SQLBean的方式去拼接sql，然后使用map集合返回我们需要的东西
			SQLBean sqlBean = new SQLBean(sql);
			//如何返回一个map,这是我们需要解决的问题
			Map<String,Double> map = custInfoDao.selectCustSexDistributed(sqlBean);
			System.out.println(map);
			
			String json="{\r\n" + 
					"    \"list\": [\r\n" + 
					"        {\r\n" + 
					"            \"name\": \"性别\",\r\n" + 
					"            \"value\": [\r\n" + 
					"                {\r\n" + 
					"                    \"name\": \"男\",\r\n" + 
					"                    \"value\": "+map.get("male")+"\r\n" + 
					"                }\r\n" + 
					"            ]\r\n" + 
					"        },\r\n" + 
					"        {\r\n" + 
					"            \"name\": \"女\",\r\n" + 
					"            \"value\": [\r\n" + 
					"                {\r\n" + 
					"                    \"name\": \"女\",\r\n" + 
					"                    \"value\": "+map.get("female")+"\r\n" + 
					"                }\r\n" + 
					"            ]\r\n" + 
					"        },\r\n" + 
					"        {\r\n" + 
					"            \"name\": \"性别\",\r\n" + 
					"            \"value\": [\r\n" + 
					"                {\r\n" + 
					"                    \"name\": \"男\",\r\n" + 
					"                    \"value\": "+map.get("unknown")+"\r\n" + 
					"                }\r\n" + 
					"            ]\r\n" + 
					"        }\r\n" + 
					"    ]\r\n" + 
					"}";
			
			JSONObject parseObject = JSON.parseObject(json);
			return parseObject;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/age_distributed/{buyOrRedeem}")//待定
	public  JSONObject getAgeDistribute(@PathVariable String buyOrRedeem) {
		
		
	    String sql="SELECT \r\n" + 
	    		"   COUNT(CASE u.age WHEN  u.age<'15'  THEN u.age END) AS \"<15\" ,\r\n" + 
	    		"   COUNT(CASE u.age WHEN (u.age>'15' AND u.age<'25')  THEN u.age END) AS \"15-25\" ,\r\n" + 
	    		"   COUNT(CASE u.age WHEN (u.age>'25' AND u.age<'35') THEN u.age END) AS \"25-35\",\r\n" + 
	    		"   COUNT(CASE u.age WHEN (u.age>'35' AND u.age<'45') THEN u.age END) AS \"35-45\",\r\n" + 
	    		"   COUNT(CASE u.age WHEN u.age>'55'  THEN u.age END) AS \">55\"\r\n" + 
	    		"FROM (SELECT t.age AS age FROM t_person_info t)  u";
	    
		//使用SQLBean的方式去拼接sql，然后使用map集合返回我们需要的东西
		SQLBean sqlBean = new SQLBean(sql);
		//如何返回一个map,这是我们需要解决的问题
		Map<String,Double> map = custInfoDao.selectCustAgeDistributed(sqlBean);
		System.out.println(map);
		
		
		String json="{\r\n" + 
				"    \"list\": [\r\n" + 
				"        {\r\n" + 
				"            \"name\": \"18-25岁\",\r\n" + 
				"            \"value\": [\r\n" + 
				"                {\r\n" + 
				"                    \"name\": \"人数\",\r\n" + 
				"                    \"value\": "+map.get("<15")+"\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"name\": \"26-35岁\",\r\n" + 
				"            \"value\": [\r\n" + 
				"                {\r\n" + 
				"                    \"name\": \"人数\",\r\n" + 
				"                    \"value\": "+map.get("15-25")+"\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"name\": \"36-45岁\",\r\n" + 
				"            \"value\": [\r\n" + 
				"                {\r\n" + 
				"                    \"name\": \"人数\",\r\n" + 
				"                    \"value\": "+map.get("25-35")+"\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"name\": \"46-55岁\",\r\n" + 
				"            \"value\": [\r\n" + 
				"                {\r\n" + 
				"                    \"name\": \"人数\",\r\n" + 
				"                    \"value\": "+map.get("35-45")+"\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				
				"        {\r\n" + 
				"            \"name\": \"55岁以上\",\r\n" + 
				"            \"value\": [\r\n" + 
				"                {\r\n" + 
				"                    \"name\": \"人数\",\r\n" + 
				"                    \"value\": "+map.get("45-55")+"\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
					"            \"name\": \"55岁以上\",\r\n" + 
					"            \"value\": [\r\n" + 
					"                {\r\n" + 
					"                    \"name\": \"人数\",\r\n" + 
					"                    \"value\": "+map.get(">55")+"\r\n" + 
					"                }\r\n" + 
					"            ]\r\n" + 
					"     }\r\n" + 
				
				"    ]\r\n" + 
				"}";
		
		JSONObject parseObject = JSON.parseObject(json);
		return parseObject;
		
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






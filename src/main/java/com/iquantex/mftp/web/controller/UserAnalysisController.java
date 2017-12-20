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
	
	public @ResponseBody ResultObj getSexDistributed(@PathVariable String buyOrRedeem) {
		
		 String sql="SELECT COUNT(CASE u.sex WHEN '0' THEN u.sex END) AS \"female\" ,\r\n" + 
		 		"   COUNT(CASE u.sex WHEN '1' THEN u.sex END) AS \"male\",\r\n" + 
		 		"   COUNT(CASE u.sex WHEN '9' THEN u.sex END) AS \"unknown\"\r\n" + 
		 		"    FROM (SELECT t.sex AS sex FROM t_person_info t)  u";
			//使用SQLBean的方式去拼接sql，然后使用map集合返回我们需要的东西
			SQLBean sqlBean = new SQLBean(sql);
			//如何返回一个map,这是我们需要解决的问题
			Map<String,Double> map = custInfoDao.selectCustSexDistributed(sqlBean);
			System.out.println(map);
			
			String data="{\r\n" + 
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
			
             JSONObject parseObject = JSON.parseObject(data);
			
			 ResultObj resultObj=null;
				
				if(true) { //如果是成功就返回正常的数据
					resultObj = successReturn().setData("list", parseObject);
				}else {
					
				}
				resultObj.setMsg("成功");
			    return resultObj;
			
			
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/age_distributed/{buyOrRedeem}")//待定
	public  @ResponseBody ResultObj getAgeDistribute(@PathVariable String buyOrRedeem) {
		
		
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
		
				 ResultObj resultObj=null;
					
					if(true) { //如果是成功就返回正常的数据
						resultObj = successReturn().setData("list", parseObject);
					}else {
						
					}
					resultObj.setMsg("成功");
	    return resultObj;
		
	}
	
	
}






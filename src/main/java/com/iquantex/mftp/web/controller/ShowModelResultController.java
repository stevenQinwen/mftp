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
import com.iquantex.mftp.bean.Predict_Result;
import com.iquantex.mftp.common.utils.ResultObj;
import com.iquantex.mftp.service.ShowModelResultService;



@Controller
public class ShowModelResultController extends BaseController{
	// 依赖注入
	@Autowired
	private ShowModelResultService showModelResultService;
	
	@RequestMapping(value = "/showModelResult")
	public  @ResponseBody List<Predict_Result>   showModelResult() {
		
		System.out.println("获取Json数据");
		List<Predict_Result> predict_ResultList = showModelResultService.findPredict_ResultList();
		return predict_ResultList;
	}
	
	@RequestMapping(value = "/userAnalysis")
	public String showCumtomer() {
		return "userAnalysis";
	}
	
	
/**
 * 这里的参数应该是不需要指定时间区间了吧!
	
 * @param feature1
 * @param feature2
 * @return
 */
	@RequestMapping(method = RequestMethod.GET, value = "/featureExploring2/{feature1}/{feature2}")
	public @ResponseBody ResultObj featureExploring(@PathVariable String feature1,@PathVariable String feature2) {
		
		
		//List<Predict_Result> predict_ResultList = showModelResultService.findPredict_ResultList(feature1,feature2); //但是这样的话我们就每次都是从数据库里面查询出同样的数据
		List<Predict_Result> predict_ResultList = showModelResultService.findPredict_ResultList(); //但是这样的话我们就每次都是从数据库里面查询出同样的数据
		
		ArrayList<Bean1> data = new ArrayList<Bean1>();
	    for (Predict_Result predict_Result : predict_ResultList) {
	    	List<Bean2> bean2_list =new ArrayList<Bean2>(2);
	    	Bean2 bean3 = new Bean2();
	    	Bean2 bean2 = new Bean2();
	    	if("buy_times".equals(feature1)&&"redeem_times".equals(feature2)) {
	    		
				bean2.setName("实际申购金额");
				bean2.setValue(Double.parseDouble(predict_Result.getActual_buy_amounts()));
				
				bean3.setName("预测申购金额");
				bean3.setValue(Double.parseDouble(predict_Result.getPredict_redeem_amounts()));
				
			}if("buy_amount".equals(feature1)&&"redeem_amount".equals(feature2)) {
				bean2.setName("实际赎回金额");
				bean2.setValue(Double.parseDouble(predict_Result.getActual_buy_amounts()));
				
				bean3.setName("预测赎回金额");
				bean3.setValue(Double.parseDouble(predict_Result.getPredict_redeem_amounts()));
				
				
			}if("".equals(feature1)&&"".equals(feature2)) {
				
				
			}if("".equals(feature1)&&"".equals(feature2)) {
				
				
				
			}
			else {
				
			}
			bean2_list.add(bean2);
			bean2_list.add(bean3);
			Bean1 bean1 = new Bean1();
			bean1.setName(predict_Result.getDate());
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

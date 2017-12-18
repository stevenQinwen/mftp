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
import com.iquantex.mftp.bean.ModelFitData;
import com.iquantex.mftp.bean.ModelFitParam;
import com.iquantex.mftp.bean.SQLBean;
import com.iquantex.mftp.common.utils.ColumnsNameMapingUtils;
import com.iquantex.mftp.common.utils.ResultObj;
import com.iquantex.mftp.dao.ModelFitDataDao;
import com.iquantex.mftp.dao.ModelFitParamDao;

@Controller
@RequestMapping("/model_param")
public class ModelParamController extends BaseController{
	
	@Autowired
	private ModelFitParamDao modelFitParamDao;
	@Autowired
	private ModelFitDataDao modelFitDataDao;
	/**
	 * 这是训练集上的参数
	 * @param buy_or_redeem
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/model_fit_data/{buy_or_redeem}")//待定
	public @ResponseBody ResultObj getModelFitData(@PathVariable String buy_or_redeem) {
		
		ArrayList<Bean1> data = new ArrayList<Bean1>();
		if("buy".equals(buy_or_redeem)) {
			List<ModelFitData> buyparamList = modelFitDataDao.selectModelFitDataBuyList(); //但是这样的话我们就每次都是从数据库里面查询出同样的数据
			for (ModelFitData modelParam : buyparamList) {
		    	List<Bean2> bean2_list =new ArrayList<Bean2>(2);
		    	Bean2 bean3 = new Bean2();
		    	Bean2 bean2 = new Bean2();
		    	
		    		
		    			bean3.setValue(modelParam.getBuy_amounts());
						bean2.setValue(modelParam.getBuy_amounts_fit());
						
//						读取properties然后将数据转成前端可以显示的中文
						//String targetName_CN = ColumnsNameMapingUtils.transform2ChineseName(targetName);
						//String featureName_CN = ColumnsNameMapingUtils.transform2ChineseName(featureName);
						
						bean2.setName("实际申购金额");
						bean3.setName("fit申购金额");
		    		
		    	
				
				bean2_list.add(bean2);
				bean2_list.add(bean3);
				Bean1 bean1 = new Bean1();
				bean1.setValue(bean2_list);
				data.add(bean1);
			}
			
		}else if("redeem".equals(buy_or_redeem)) {
			
			List<ModelFitData> redeemparamList = modelFitDataDao.selectModelFitDataRedeemList(); //但是这样的话我们就每次都是从数据库里面查询出同样的数据
			for (ModelFitData modelParam : redeemparamList) {
		    	List<Bean2> bean2_list =new ArrayList<Bean2>(2);
		    	Bean2 bean3 = new Bean2();
		    	Bean2 bean2 = new Bean2();
		    	
		    			bean3.setValue(modelParam.getRedeem_amounts());
						bean2.setValue(modelParam.getRedeem_amounts_fit());
//						读取properties然后将数据转成前端可以显示的中文
						//String targetName_CN = ColumnsNameMapingUtils.transform2ChineseName(targetName);
						//String featureName_CN = ColumnsNameMapingUtils.transform2ChineseName(featureName);
						
						bean2.setName("实际赎回金额");
						bean3.setName("fit赎回金额");
		    		
		    	
				
				bean2_list.add(bean2);
				bean2_list.add(bean3);
				Bean1 bean1 = new Bean1();
				bean1.setValue(bean2_list);
				data.add(bean1);
			}
		}else {
			
			
		}
	    
		ResultObj resultObj=null;
		
		if(true) { //如果是成功就返回正常的数据
			resultObj = successReturn().setData("list", data);
		}else {
			
		}
		resultObj.setMsg("成功");
	    return resultObj;
		
		
	}
	
	/**
	 * 这是测试集上的参数
	 * @param buy_or_redeem
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/model_fit_param/{buy_or_redeem}")//待定
	public @ResponseBody ResultObj getModelFitParam(@PathVariable String buy_or_redeem) { //申购是01 赎回是02
		
		//使用字符串拼接的方式进行执行，这样比较灵活，注入就注入，无所谓，我们不需要防范注入
		SQLBean sqlBean = new SQLBean("SELECT \r\n" + 
				"      \r\n" + 
				"      t.One_intercept,\r\n" + 
				"      t.R2,\r\n" + 
				"      t.X0_2,\r\n" + 
				"      t.X0_times,\r\n" + 
				"      t.X0_x1,\r\n" + 
				"      t.X0_x2,\r\n" + 
				"      t.X0_x3,\r\n" + 
				"      t.X1_2,\r\n" + 
				"      t.X1_day,\r\n" + 
				"      t.X1_x2,\r\n" + 
				"      t.X1_x3,\r\n" + 
				"      t.X2_2,\r\n" + 
				"      t.X2_p2p_develop,\r\n" + 
				"      t.X2_x3,\r\n" + 
				"      t.X3_2,\r\n" + 
				"      t.X3_fund_7day_rate\r\n" + 
				"      \r\n" + 
				"      FROM \r\n" + 
				"      model_param_tmp t\r\n" + 
				"      WHERE t.flag ='"+buy_or_redeem+"' ORDER BY t.generate_time  DESC LIMIT 1");
		
		List<ModelFitParam> modelFitParamList = modelFitParamDao.selectModelFitParamList(sqlBean);
		//但是这样的话我们就每次都是从数据库里面查询出同样的数据
		ModelFitParam modelFitParam=modelFitParamList.get(0);
		
		//这里不了循环 如果是pandas就好说了
		ArrayList<Bean2> data = new ArrayList<Bean2>();
	    	
	    	Bean2 b1 = new Bean2();
	    	Bean2 b2 = new Bean2();
	    	Bean2 b3 = new Bean2();
	    	Bean2 b4 = new Bean2();
	    	Bean2 b5 = new Bean2();
	    	Bean2 b6 = new Bean2();
	    	Bean2 b7 = new Bean2();
	    	Bean2 b8 = new Bean2();
	    	Bean2 b9 = new Bean2();
	    	Bean2 b10 = new Bean2();
	    	Bean2 b11 = new Bean2();
	    	Bean2 b12 = new Bean2();
	    	Bean2 b13 = new Bean2();
	    	Bean2 b14 = new Bean2();
	    	Bean2 b15 = new Bean2();
	    	Bean2 b16 = new Bean2();
	    	
	    	b1.setName("One_intercept");
	    	b1.setValue(modelFitParam.getOne_intercept());
	    	
	    	b2.setName("R2");
	    	b2.setValue(modelFitParam.getR2());
	    	
	    	b3.setName("X0_2");
	    	b3.setValue(modelFitParam.getX0_2());
	    	
	    	b4.setName("X0_times");
	    	b4.setValue(modelFitParam.getX0_times());
	    	
	    	b5.setName("X0_x1");
	    	b5.setValue(modelFitParam.getX0_x1());
	    	
	    	b6.setName("X0_x2");
	    	b6.setValue(modelFitParam.getX0_x2());
	    	
	    	b7.setName("X0_x3");
	    	b7.setValue(modelFitParam.getX0_x3());
	    	
	    	b8.setName("X1_2");
	    	b8.setValue(modelFitParam.getX1_2());
	    	
	    	b9.setName("X1_day");
	    	b9.setValue(modelFitParam.getX1_day());
	    	
	    	b10.setName("X1_x2");
	    	b10.setValue(modelFitParam.getX1_x2());
	    	
	    	b11.setName("X1_x3");
	    	b11.setValue(modelFitParam.getX1_x3());
	    	
	    	b12.setName("X2_2");
	    	b12.setValue(modelFitParam.getX2_2());
	    	
	    	b13.setName("X2_p2p_develop");
	    	b13.setValue(modelFitParam.getX2_p2p_develop());
	    	
	    	b14.setName("X2_x3");
	    	b14.setValue(modelFitParam.getX2_x3());
	    	
	    	b15.setName("X3_2");
	    	b15.setValue(modelFitParam.getX3_2());
	    	
	    	b16.setName("X3_fund_7day_rate");
	    	b16.setValue(modelFitParam.getX3_fund_7day_rate());
	    	
			data.add(b1);
			data.add(b2);
			data.add(b3);
			data.add(b4);
			data.add(b5);
			data.add(b6);
			data.add(b7);
			data.add(b8);
			data.add(b9);
			data.add(b10);
			data.add(b11);
			data.add(b12);
			data.add(b13);
			data.add(b14);
			data.add(b15);
			data.add(b16);
			
			
			
		ResultObj resultObj=null;
		
		if(true) { //如果是成功就返回正常的数据
			resultObj = successReturn().setData("list", data);
		}else {
			
		}
		resultObj.setMsg("成功");
	    return resultObj;
	    
	}
	
}






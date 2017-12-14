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
import com.iquantex.mftp.bean.ModelParam;
import com.iquantex.mftp.bean.ModelParamTmp;
import com.iquantex.mftp.common.utils.ColumnsNameMapingUtils;
import com.iquantex.mftp.common.utils.ResultObj;
import com.iquantex.mftp.dao.ModelParamDao;
import com.iquantex.mftp.dao.ModelParamTmpDao;


@Controller

@RequestMapping("/model_param")
public class ModelParamTmpController extends BaseController{
	
	@Autowired
	private ModelParamTmpDao modelParamTmpDao;
	@Autowired
	private ModelParamDao modelParamDao;
	
	@RequestMapping(method = RequestMethod.GET, value = "/model_train_param/{buy_or_redeem}")//待定
	public @ResponseBody ResultObj getModelParam(@PathVariable String buy_or_redeem) {
		
		List<ModelParam> custInfoList = modelParamDao.selectModelParamList(buy_or_redeem); //但是这样的话我们就每次都是从数据库里面查询出同样的数据
		System.out.println(custInfoList);
		
		ArrayList<Bean1> data = new ArrayList<Bean1>();
	    for (ModelParam modelParam : custInfoList) {
	    	List<Bean2> bean2_list =new ArrayList<Bean2>(2);
	    	Bean2 bean3 = new Bean2();
	    	Bean2 bean2 = new Bean2();
	    	
	    	
	    	if("buy".equals(buy_or_redeem)) {
	    		
	    			bean3.setValue(modelParam.getBuy_amounts());
					bean2.setValue(modelParam.getBuy_times_predict());
					
//					读取properties然后将数据转成前端可以显示的中文
					//String targetName_CN = ColumnsNameMapingUtils.transform2ChineseName(targetName);
					//String featureName_CN = ColumnsNameMapingUtils.transform2ChineseName(featureName);
					
					bean2.setName("实际申购金额");
					bean3.setName("申购预测金额");
	    		
	    	} else if("redeem".equals(buy_or_redeem)){
	    		
	    			bean3.setValue(modelParam.getRedeem_amounts());
					bean2.setValue(modelParam.getRedeem_amounts_predict());
					
//					读取properties然后将数据转成前端可以显示的中文
					//String targetName_CN = ColumnsNameMapingUtils.transform2ChineseName(targetName);
					//String featureName_CN = ColumnsNameMapingUtils.transform2ChineseName(featureName);
					bean2.setName("实际赎回金额");
					bean3.setName("赎回预测金额");
	    	}
	    	
	    	
			
			bean2_list.add(bean2);
			bean2_list.add(bean3);
			Bean1 bean1 = new Bean1();
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






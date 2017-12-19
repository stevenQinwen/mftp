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
import com.iquantex.mftp.bean.CustInfo;
import com.iquantex.mftp.bean.Daily_Macro_Factor;
import com.iquantex.mftp.bean.ModelPerform;
import com.iquantex.mftp.bean.SQLBean;
import com.iquantex.mftp.common.utils.ColumnsNameMapingUtils;
import com.iquantex.mftp.common.utils.ResultObj;
import com.iquantex.mftp.dao.CustInfoDao;
import com.iquantex.mftp.dao.DailyMacrofactorDao;
import com.iquantex.mftp.dao.ModelFitParamDao;
import com.iquantex.mftp.dao.ModelPerformDao;


@Controller

@RequestMapping("/model_perform")
public class ModelPerformController extends BaseController{
	
	@Autowired
	private ModelPerformDao modelPerformDao;
	@Autowired
	private ModelFitParamDao modelFitParamDao;
	
	@RequestMapping(method = RequestMethod.GET, value = "/model_predict/{begindate}/{enddate}")//待定
	public @ResponseBody ResultObj getModel_perform(@PathVariable String begindate,@PathVariable String enddate) {
		
		
		//这里是返回当天模型最后一次预测结果，未来7天的预测情况
		//这里是按照日期进来然后取出对应的预测时间
	    String sql="SELECT * FROM model_perform WHERE DATE_FORMAT(generate_time, \"%Y%m%d\")='"+begindate+"'   ORDER BY generate_time DESC LIMIT 1";
	    
	    //这里是选取某人时间段内的预测情况(就是使用这条sql就行了)
	    String sql2="SELECT * FROM (SELECT * FROM model_perform  ORDER BY generate_time DESC) AS tt GROUP BY DATE_FORMAT(generate_time, \"%Y%m%d\") ORDER BY generate_time DESC  LIMIT 1";
	    
		//使用SQLBean的方式去拼接sql，然后使用map集合返回我们需要的东西
		SQLBean sqlBean = new SQLBean(sql2);
		//如何返回一个map,这是我们需要解决的问题
//		Map<String,Double> map = modelPerformDao.selectModel_performByDate(sqlBean);
		 List<ModelPerform> list = modelPerformDao.selectModel_performRecent_Nday(sqlBean);
		
		
		ArrayList<Bean1> data = new ArrayList<Bean1>();
		
		 data = new ArrayList<Bean1>();
		    for (ModelPerform modelPerform : list) {
		    	List<Bean2> bean2_list =new ArrayList<Bean2>(2);
		    	Bean2 b3 = new Bean2();
		    	Bean2 b2 = new Bean2();
		    	Bean2 b1 = new Bean2();
		    		
		    		
		    		b1.setName("预测申购");
		    		b1.setValue(modelPerform.getPd_next_1_day_buy_amounts());
					
					
				
				bean2_list.add(b3);
				bean2_list.add(b2);
				bean2_list.add(b1);
				
				Bean1 bean1 = new Bean1();
				
				bean1.setName(modelPerform.getGenerate_time().toString().substring(0, 10).replace("-", "/"));
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






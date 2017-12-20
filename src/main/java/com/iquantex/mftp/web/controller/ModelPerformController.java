package com.iquantex.mftp.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import com.iquantex.mftp.bean.ModelPerform;
import com.iquantex.mftp.bean.ModelPerformVo;
import com.iquantex.mftp.bean.SQLBean;
import com.iquantex.mftp.common.utils.ResultObj;
import com.iquantex.mftp.dao.ModelFitParamDao;
import com.iquantex.mftp.dao.ModelPerformDao;
import com.iquantex.mftp.service.ModelPerformService;

import javax.script.*;

import org.junit.Test;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;  

@Controller
@RequestMapping("/model_perform")
public class ModelPerformController extends BaseController{
	
	@Autowired
	private ModelPerformDao modelPerformDao;
	@Autowired
	private ModelFitParamDao modelFitParamDao;
	
	@Autowired
	private ModelPerformService modelPerformService;
	
	/**
	     这个方法是查询历史的预测情况
	 * @param begindate
	 * @param enddate
	 * @return
	 * 
	 */
	@Test
	@RequestMapping(method = RequestMethod.GET, value = "/get_his_perform/{begindate}/{enddate}")//待定
	public @ResponseBody ResultObj getModel_HistoryPerform(@PathVariable String begindate,@PathVariable String enddate) {
		
		 String sql="SELECT t.generate_time as 'generate_time',t.current_day_actual_buy_amounts,t.current_day_actual_redeem_amounts,t.current_day_actual_redeem_amounts,t.pd_next_1_day_buy_amounts FROM (SELECT * FROM model_perform  ORDER BY generate_time DESC) t GROUP BY DATE_FORMAT(t.generate_time, \"%Y%m%d\") LIMIT 15" ;//选出最早一条数据
		 
		 SQLBean sqlBean = new SQLBean(sql);
		 
		 List<ModelPerform> list = modelPerformService.selectModel_performRecent_Nday(sqlBean);
		 
//		 Map<String, Double> select_next7day_predicted = modelPerformService.selectModel_performRecent_Nday(next7sqlBean);
		 
		 
		 ArrayList<Bean1> data = new ArrayList<Bean1>();
		    for (ModelPerform modelPerform : list) {
		    	List<Bean2> bean2_list =new ArrayList<Bean2>(2);
		    	Bean2 b3 = new Bean2();
		    	Bean2 b2 = new Bean2();
		    	Bean2 b1 = new Bean2();
		    	Bean2 b4 = new Bean2();
		    		
		    	
		    	    b1.setValue(modelPerform.getCurrent_day_actual_redeem_amounts());
					b2.setValue(modelPerform.getCurrent_day_actual_buy_amounts());
					
					b3.setValue(modelPerform.getPd_next_1_day_buy_amounts());
					b4.setValue(modelPerform.getPd_next_1_day_redeem_amounts());
					
//					读取properties然后将数据转成前端可以显示的中文
//						String targetName_CN = ColumnsNameMapingUtils.transform2ChineseName(targetName);
//						String featureName_CN = ColumnsNameMapingUtils.transform2ChineseName(featureName);
					
					b1.setName("实际申购金额");
					b2.setName("实际赎回金额");
					b3.setName("预测申购金额");
					b4.setName("预测赎回金额");
					
				
				bean2_list.add(b1);
				bean2_list.add(b2);
				bean2_list.add(b3);
				bean2_list.add(b4);
				
				Bean1 bean1 = new Bean1();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
				String dateString = formatter.format(modelPerform.getGenerate_time());
				bean1.setName(dateString);
				
				
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
	
	/**
	 * 
	 * @param begindate
	 * @param enddate
	 * @return Json
	 * 
	 * 这里要自动赋上时间  除了节假日之外的  ：如何去除节假日
	 * 这里先不做吧
	 * 
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/model_predict/{begindate}/{enddate}")//待定
	public @ResponseBody ResultObj getModel_perform(@PathVariable String begindate,@PathVariable String enddate) {
		
		//这里是返回当天模型最后一次预测结果，未来7天的预测情况
		//这里是按照日期进来然后取出对应的预测时间
	    String sql="SELECT * FROM model_perform ORDER BY generate_time DESC LIMIT 1";//选出最早一条数据
	    
	    //这里是选取某人时间段内的预测情况(就是使用这条sql就行了)
	    //取出来的7天之后，我们还有对应上工作日
	    String sql2="SELECT * FROM (SELECT * FROM model_perform  ORDER BY generate_time DESC) AS tt GROUP BY DATE_FORMAT(generate_time, \"%Y%m%d\") ORDER BY generate_time DESC  LIMIT 1";
	    
	    String sql3="SELECT generate_time AS \"date\" ,1 AS delta,t.pd_next_1_day_buy_amounts,t.pd_next_1_day_redeem_amounts AS \"amounts\" FROM  (SELECT * FROM model_perform  ORDER BY generate_time DESC LIMIT 1 ) t\r\n" + 
	    		"UNION \r\n" + 
	    		"SELECT generate_time AS \"date\" ,2 AS delta, t.pd_next_2_day_buy_amounts ,t.pd_next_2_day_redeem_amounts AS \"amounts\" FROM  (SELECT * FROM model_perform  ORDER BY generate_time DESC LIMIT 1 ) t\r\n" + 
	    		"UNION \r\n" + 
	    		"SELECT generate_time AS \"date\" ,3 AS delta, t.pd_next_3_day_buy_amounts,t.pd_next_3_day_redeem_amounts AS \"amounts\" FROM  (SELECT * FROM model_perform  ORDER BY generate_time DESC LIMIT 1 ) t\r\n" + 
	    		"UNION \r\n" + 
	    		"SELECT generate_time AS \"date\" ,4 AS delta, t.pd_next_4_day_buy_amounts,t.pd_next_4_day_redeem_amounts AS \"amounts\" FROM  (SELECT * FROM model_perform  ORDER BY generate_time DESC LIMIT 1 ) t\r\n" + 
	    		"UNION \r\n" + 
	    		"SELECT generate_time AS \"date\" ,5 AS delta, t.pd_next_5_day_buy_amounts,t.pd_next_5_day_redeem_amounts AS \"amounts\" FROM  (SELECT * FROM model_perform  ORDER BY generate_time DESC LIMIT 1 ) t\r\n" + 
	    		"UNION \r\n" + 
	    		"SELECT generate_time AS \"date\" ,6 AS delta, t.pd_next_6_day_buy_amounts,t.pd_next_6_day_redeem_amounts AS \"amounts\" FROM  (SELECT * FROM model_perform  ORDER BY generate_time DESC LIMIT 1 ) t\r\n" + 
	    		"UNION \r\n" + 
	    		"SELECT generate_time AS \"date\" ,7 AS delta, t.pd_next_7_day_buy_amounts,t.pd_next_7_day_redeem_amounts AS \"amounts\" FROM  (SELECT * FROM model_perform  ORDER BY generate_time DESC LIMIT 1 ) t";
	    
		//使用SQLBean的方式去拼接sql，然后使用map集合返回我们需要的东西
		SQLBean sqlBean = new SQLBean(sql3);
		//如何返回一个map,这是我们需要解决的问题
//		Map<String,Double> map = modelPerformDao.selectModel_performByDate(sqlBean);
		 List<ModelPerformVo> list = modelPerformService.select_next7day_predicted(sqlBean);
		
		ArrayList<Bean1> data = new ArrayList<Bean1>();
		
		 for (ModelPerformVo modelPerformVo : list) {
		    	List<Bean2> bean2_list =new ArrayList<Bean2>(2);
		    	Bean2 bean3 = new Bean2();
		    	Bean2 bean2 = new Bean2();
		    		
		    	
					bean2.setValue(modelPerformVo.getPd_next_1_day_buy_amounts());
					bean3.setValue(modelPerformVo.getPd_next_1_day_redeem_amounts());
					bean2.setName("申购金额预测");
					bean3.setName("赎回金额预测");
				
				bean2_list.add(bean2);
				bean2_list.add(bean3);
				Bean1 bean1 = new Bean1();
				
				//------------将时间向后偏移---------------
				Date date = modelPerformVo.getDate();
				Calendar calendar = new     GregorianCalendar();
				calendar.setTime(date); 
				calendar.add(Calendar.DATE,Integer.parseInt(modelPerformVo.getDelta()));
				date=calendar.getTime();
				//------------------------------
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
				String dateString = formatter.format(date);
				bean1.setName(dateString);
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






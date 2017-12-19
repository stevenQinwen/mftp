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
	
	/**
	 * 这是历史回测的东西,历史数据和当天的预测未来7天的数据统一一并出查询；
	 * 
	 * 1.这里的借口定义应该是说输入起始日期和终止日期，然后去
	 * 2.这里是很难的，我们只能是通过python脚本去计算
	 * @param begindate
	 * @param enddate
	 * @return
	 */
	@Test
	@RequestMapping(method = RequestMethod.GET, value = "/get_his_perform/{begindate}/{enddate}")//待定
	public @ResponseBody ResultObj getModel_HistoryPerform(@PathVariable String begindate,@PathVariable String enddate) {
		
		try {
			
			PythonInterpreter interpreter = new PythonInterpreter();  
			interpreter.execfile("D:\\java_related\\fund_predict_workspace\\mftp\\src\\main\\resources\\pyscript\\my_util.py");  
			PyFunction func = (PyFunction) interpreter.get("adder", PyFunction.class);  
			int a = 2010, b = 6;  
			PyObject pyobj = func.__call__(new PyInteger(a), new PyInteger(b));  
			System.out.println("anwser = " + pyobj.toString());  
		}catch(Exception e) {
		  System.out.println(e);	
		}
	        
		System.out.println("执行python完毕");
		return null;
	}
	
	/**
	 * 
	 * @param begindate
	 * @param enddate
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/model_predict/{begindate}/{enddate}")//待定
	public @ResponseBody ResultObj getModel_perform(@PathVariable String begindate,@PathVariable String enddate) {
		
		//这里是返回当天模型最后一次预测结果，未来7天的预测情况
		//这里是按照日期进来然后取出对应的预测时间
	    String sql="SELECT * FROM model_perform ORDER BY generate_time DESC LIMIT 1";//选出最早一条数据
	    
	    //这里是选取某人时间段内的预测情况(就是使用这条sql就行了)
	    //取出来的7天之后，我们还有对应上工作日
	    String sql2="SELECT * FROM (SELECT * FROM model_perform  ORDER BY generate_time DESC) AS tt GROUP BY DATE_FORMAT(generate_time, \"%Y%m%d\") ORDER BY generate_time DESC  LIMIT 1";
	    
		//使用SQLBean的方式去拼接sql，然后使用map集合返回我们需要的东西
		SQLBean sqlBean = new SQLBean(sql);
		//如何返回一个map,这是我们需要解决的问题
//		Map<String,Double> map = modelPerformDao.selectModel_performByDate(sqlBean);
		  Map<String, Double> select_next7day_predicted = modelPerformDao.select_next7day_predicted(sqlBean);
		
		
		 ArrayList<Bean1> data = new ArrayList<Bean1>();
		
		 
		
		
		
		
		ResultObj resultObj=null;
		
		if(true) { //如果是成功就返回正常的数据
			resultObj = successReturn().setData("list", data);
		}else {
			
		}
		resultObj.setMsg("成功");
	    return resultObj;
	}
}






package com.iquantex.mftp.bean;

import java.util.ArrayList;
import java.util.List;

import com.iquantex.mftp.common.utils.ColumnsNameMapingUtils;

public class JsonWrapperUtils {

	public ArrayList<Bean1> toLineChartJson(List<Daily_Macro_Factor> list){
		
		ArrayList<Bean1> data = new ArrayList<Bean1>();
	    for (Daily_Macro_Factor daily_Macro_Factor : list) {
	    	List<Bean2> bean2_list =new ArrayList<Bean2>(2);
	    	Bean2 bean3 = new Bean2();
	    	Bean2 bean2 = new Bean2();
	    		
	    	
	    	
	    	
				bean2.setValue(Double.parseDouble(daily_Macro_Factor.getDaily_buy_amounts()));
				bean3.setValue(Double.parseDouble(daily_Macro_Factor.getP2p_develop_index()));
				
//				读取properties然后将数据转成前端可以显示的中文
//				String targetName_CN = ColumnsNameMapingUtils.transform2ChineseName(targetName);
//				String featureName_CN = ColumnsNameMapingUtils.transform2ChineseName(featureName);
				
				//bean2.setName(targetName_CN);
				//bean3.setName(featureName_CN);
				
			
			bean2_list.add(bean2);
			bean2_list.add(bean3);
			Bean1 bean1 = new Bean1();
			bean1.setName(daily_Macro_Factor.getDate().substring(0, 10).replace("-", "/"));
			bean1.setValue(bean2_list);
			data.add(bean1);
		}
	    
		return data;
	}
	
	
	
	
}

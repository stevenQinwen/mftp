package com.iquantex.mftp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iquantex.mftp.bean.ModelPerform;
import com.iquantex.mftp.bean.ModelPerformVo;
import com.iquantex.mftp.bean.Predict_Result;
import com.iquantex.mftp.bean.SQLBean;
import com.iquantex.mftp.dao.ModelFitParamDao;
import com.iquantex.mftp.dao.ModelPerformDao;
import com.iquantex.mftp.dao.PredictResultDao;
import com.iquantex.mftp.service.ModelPerformService;
import com.iquantex.mftp.service.ShowModelResultService;


@Service("modelPerformService")
@Transactional
public class ModelPerformServiceImpl implements ModelPerformService {

	@Autowired
	private ModelPerformDao modelPerformDao;
	@Autowired
	private ModelFitParamDao modelFitParamDao;
	@Override
	public List<ModelPerform> selectModel_performRecent_Nday(SQLBean sqlBean) {
		 List<ModelPerform> list = modelPerformDao.selectModel_performRecent_Nday(sqlBean);
		return list;
	}
	
	@Override
	public 	List<ModelPerformVo> select_next7day_predicted(SQLBean sqlBean) {
		List<ModelPerformVo> select_next7day_predicted = modelPerformDao.select_next7day_predicted(sqlBean);
		return select_next7day_predicted;
	}
	
	
	

}





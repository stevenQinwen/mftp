package com.iquantex.mftp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iquantex.mftp.bean.Predict_Result;
import com.iquantex.mftp.dao.PredictResultDao;
import com.iquantex.mftp.service.ShowModelResultService;


@Service("showModelResultService")
@Transactional
public class ShowModelResultServiceImpl implements ShowModelResultService {

	// 定义dao属性
	@Autowired
	private PredictResultDao predictResultDao;

	@Override
	public List<Predict_Result> findPredict_ResultList() {
		
		 List<Predict_Result> predictResultList = predictResultDao.selectPredictResultList();

		return predictResultList;

	}

	@Override
	public List<Predict_Result> findPredict_ResultList(String feature1, String feature2) {
		//这里是条件查询，查询出
		return null;
	}

}





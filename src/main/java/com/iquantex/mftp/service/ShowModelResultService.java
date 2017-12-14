package com.iquantex.mftp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.iquantex.mftp.bean.Predict_Result;




public interface ShowModelResultService {

	// 查询客户列表
	public List<Predict_Result> findPredict_ResultList();

	public List<Predict_Result> findPredict_ResultList(String feature1, String feature2);

}

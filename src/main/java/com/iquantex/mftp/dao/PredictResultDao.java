package com.iquantex.mftp.dao;

import java.util.List;

import com.iquantex.mftp.bean.Predict_Result;

public interface PredictResultDao {

	List<Predict_Result> selectPredictResultList();
	
	
}
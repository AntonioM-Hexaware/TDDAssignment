package com.antonio.Logic;

import com.antonio.util.Diseases;
import com.antonio.model.Person;

public class RiskAnalyzer {
	public int getRiskBaseOnAge(int age){
		int riskPoints = 0;
		if (age >= 60 && age <= 69){
			riskPoints = 1;
		} else if (age >= 70 && age <= 79){
			riskPoints = 3;
		} else if (age >= 80){
			riskPoints = 5;
		}

		return  riskPoints;
	}

	public int getRiskPointBasedOnDisease(Diseases disease){
		switch (disease){
		case Diabetes:
			return 2;
		case Heart:
			return 3;
		default:
			return 0;
		}
	}

	public int getRiskPoints(Person patient){
		int riskPoint = 0;

		riskPoint = getRiskBaseOnAge(patient.getAge());
		riskPoint += patient.getDiseases().stream().mapToInt(this::getRiskPointBasedOnDisease).sum();

		return riskPoint;
	}
}

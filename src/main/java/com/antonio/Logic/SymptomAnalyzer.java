package com.antonio.Logic;

import com.antonio.util.Symptoms;
import com.antonio.model.Person;

public class SymptomAnalyzer {

	public int getRiskPointBySympton(Symptoms symptoms){
		int riskPoints = 0;
		switch (symptoms){
			// Dry cough
			case Cough:
			riskPoints = 2;
			break;
		case Fever:
			riskPoints = 3;
			break;
		case Fatigue:
			riskPoints = 1;
			break;
		case ShortnessOfBreath:
			riskPoints = 4;
			break;
		default:
			riskPoints = 0;
			break;
		}

		return  riskPoints;
	}

	public int getRiskPoint(Person patient){
		return patient.getSymptoms().stream().mapToInt(this::getRiskPointBySympton).sum();
	}
}

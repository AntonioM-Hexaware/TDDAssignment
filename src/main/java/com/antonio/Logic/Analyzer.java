package com.antonio.Logic;

import com.antonio.model.Person;

public class Analyzer {

	private RiskAnalyzer riskAnalyzer;
	private SymptomAnalyzer symptomAnalyzer;
	private Person patient;

	public Analyzer(Person person) {
		riskAnalyzer = new RiskAnalyzer();
		symptomAnalyzer = new SymptomAnalyzer();
		this.patient = person;
	}

	public String measureToTake(){
		String measuresToTake = "";
		if (isolate(this.patient) && test(this.patient))
			measuresToTake = "Isolate and test patient";
		else if (isolate(this.patient)) {
			measuresToTake = "Isolate patient";
		} else if (test(patient)){
			measuresToTake = "Test patient";
		} else {
			measuresToTake = "Not measures required for this patient";
		}

		return measuresToTake;
	}

	public boolean isolate(Person patient){
		return riskAnalyzer.getRiskPoints(patient) >= 5 || (riskAnalyzer.getRiskPoints(patient) + symptomAnalyzer.getRiskPoint(patient) >= 7);
	}

	public boolean test(Person patient){
		return  symptomAnalyzer.getRiskPoint(patient) >= 5;

	}
}

package com.antonio.util;

public enum Symptoms {
	Cough("dry cough"),
	Fever("fever"),
	Fatigue("fatigue"),
	ShortnessOfBreath ("shortness of breath");

	public String symptom;
	Symptoms(String s) {
		this.symptom = s;
	}
}

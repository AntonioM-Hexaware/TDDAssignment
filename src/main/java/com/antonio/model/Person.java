package com.antonio.model;

import com.antonio.util.Diseases;
import com.antonio.util.Symptoms;

import java.util.ArrayList;
import java.util.List;

public class Person {
	public int age;
	public List<Diseases> diseases;
	public List<Symptoms> symptoms;

	public Person(int age) {
		this.age = age;
		this.diseases = new ArrayList<Diseases>();
		this.symptoms = new ArrayList<Symptoms>();
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Diseases> getDiseases() {
		return diseases;
	}

	public void setDisease(Diseases disease) {
		diseases.add(disease);
	}

	public void setDisease(String d){
		diseases.add(Diseases.valueOf(d));
	}

	public List<Symptoms> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(Symptoms symptom) {
		symptoms.add(symptom);
	}

	public void setSymptom(String symptom) {
		symptoms.add(Symptoms.valueOf(symptom));
	}
}

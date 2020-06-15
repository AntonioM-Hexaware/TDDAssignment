package com.test;

import com.antonio.model.Person;
import com.antonio.Logic.SymptomAnalyzer;
import com.antonio.util.Symptoms;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestSymptonAnalyzer {
	private SymptomAnalyzer symptonAnalyzer;

	@BeforeAll
	public void setup() {
		symptonAnalyzer = new SymptomAnalyzer();
	}

	@Test
	public void getRiskPointDyCough(){
		assertEquals(symptonAnalyzer.getRiskPointBySympton(Symptoms.Cough), 2);
	}

	@Test
	public void getRiskPointFever(){
		assertEquals(symptonAnalyzer.getRiskPointBySympton(Symptoms.Fever), 3);
	}

	@Test
	public void getRiskPointFatigue(){
		assertEquals(symptonAnalyzer.getRiskPointBySympton(Symptoms.Fatigue), 1);
	}

	@Test
	public void getRiskPointShortnessOfBreath(){
		assertEquals(symptonAnalyzer.getRiskPointBySympton(Symptoms.ShortnessOfBreath), 4);
	}

	@Test
	public void getRiskPointsPatient_1(){
		Person patient = new Person(23);
		patient.setSymptoms(Symptoms.Cough);
		patient.setSymptoms(Symptoms.Fever);

		assertEquals(symptonAnalyzer.getRiskPoint(patient), 5);
	}

	@Test
	public void getRiskPointsPatient_2(){
		Person patient = new Person(53);
		patient.setSymptoms(Symptoms.Cough);
		patient.setSymptoms(Symptoms.Fever);
		patient.setSymptoms(Symptoms.ShortnessOfBreath);

		assertEquals(symptonAnalyzer.getRiskPoint(patient), 9);
	}
}

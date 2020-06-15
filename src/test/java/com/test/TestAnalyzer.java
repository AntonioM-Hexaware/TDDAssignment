package com.test;

import com.antonio.Logic.Analyzer;
import com.antonio.util.Diseases;
import com.antonio.model.Person;
import com.antonio.util.Symptoms;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestAnalyzer {

	@Test
	public void measures4Patient1(){
		Person patient = new Person(23);
		Analyzer analyzer = new Analyzer(patient);
		assertEquals(analyzer.measureToTake(), "Not measures required for this patient");
	}

	@Test
	public void measures4Patient2(){
		Person patient = new Person(70);
		patient.setDisease(Diseases.Heart);
		Analyzer analyzer = new Analyzer(patient);
		assertEquals(analyzer.measureToTake(), "Isolate patient");
	}

	@Test
	public void measures4Patient3(){
		Person patient = new Person(60);
		patient.setDisease(Diseases.Heart);
		patient.setSymptoms(Symptoms.Cough);
		patient.setSymptoms(Symptoms.Fever);
		Analyzer analyzer = new Analyzer(patient);
		assertEquals(analyzer.measureToTake(), "Isolate and test patient");
	}

	@Test
	public void measures4Patient4(){
		Person patient = new Person(45);
		patient.setSymptoms(Symptoms.Cough);
		patient.setSymptoms(Symptoms.Fever);
		Analyzer analyzer = new Analyzer(patient);
		assertEquals(analyzer.measureToTake(), "Test patient");
	}
}

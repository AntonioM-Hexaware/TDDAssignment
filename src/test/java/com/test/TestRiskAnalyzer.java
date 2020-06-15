package com.test;

import com.antonio.util.Diseases;
import com.antonio.model.Person;
import com.antonio.Logic.RiskAnalyzer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.antonio.util.Diseases.Diabetes;
import static com.antonio.util.Diseases.Heart;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestRiskAnalyzer {

	private RiskAnalyzer riskAnalyzer;

	@BeforeAll
	public void setup(){
		riskAnalyzer = new RiskAnalyzer();
	}

	@Test
	public void getRisk_AgeBelow60(){
		int age = 59;
		assertEquals(riskAnalyzer.getRiskBaseOnAge(age), 0);
	}

	@Test
	public void getRisk_AgeUp60(){
		int age = 65;
		assertEquals(riskAnalyzer.getRiskBaseOnAge(age), 1);
	}

	@Test
	public void getRisk_Age70(){
		int age = 70;
		assertEquals(riskAnalyzer.getRiskBaseOnAge(age), 3);
	}

	@Test
	public void getRisk_Age79(){
		int age = 79;
		assertEquals(riskAnalyzer.getRiskBaseOnAge(age), 3);
	}

	@Test
	public void getRisk_Age80(){
		int age = 80;
		assertEquals(riskAnalyzer.getRiskBaseOnAge(age), 5);
	}

	@Test
	public void getRisk_AgeUp80(){
		int age = 85;
		assertEquals(riskAnalyzer.getRiskBaseOnAge(age), 5);
	}

	@Test
	public void getRiskPointDiabetes(){
		Diseases diabetes = Diabetes;
		assertEquals(riskAnalyzer.getRiskPointBasedOnDisease(diabetes), 2);
	}

	@Test
	public void getRiskPointHeartDisease(){
		Diseases heartDisease = Diseases.Heart;
		assertEquals(riskAnalyzer.getRiskPointBasedOnDisease(heartDisease), 3);
	}

	@Test
	public void getRiksPoints(){
		Person patient = new Person(59);
		patient.setDisease(Diabetes);
		assertEquals(riskAnalyzer.getRiskPoints(patient), 2);
	}

	@Test
	public void getRiksPointsPatient2(){
		Person patient = new Person(60);
		patient.setDisease(Diabetes);
		patient.setDisease(Heart);
		assertEquals(riskAnalyzer.getRiskPoints(patient), 6);
	}
}

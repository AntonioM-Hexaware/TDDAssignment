package com.antonio.main;

import com.antonio.Logic.Analyzer;
import com.antonio.model.Person;
import com.antonio.util.Symptoms;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Person patient = new Person(45);
	    patient.setSymptoms(Symptoms.Cough);
	    patient.setSymptoms(Symptoms.Fever);
        Analyzer analyzer = new Analyzer(patient);
        System.out.println(analyzer.measureToTake());
    }
}

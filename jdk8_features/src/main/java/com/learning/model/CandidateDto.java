package com.learning.model;

import java.util.List;

public class CandidateDto {

	public static List<Candidate> findCandidates() {
		Candidate c1 = new Candidate("Alina", "Finance");
		Candidate c2 = new Candidate("Babita", "Finance");
		Candidate c3 = new Candidate("Celina", "Human Resource");
		Candidate c4 = new Candidate("Denis", "Human Resource");
		Candidate c5 = new Candidate("Elizabeth", "Information Technology");
		Candidate c6 = new Candidate("Fedrick", "Information Technology");
		Candidate c7 = new Candidate("Gagan", "Science");
		Candidate c8 = new Candidate("Henry", "Science");

		return List.of(c1, c2, c3, c4, c5, c6, c7, c8);
	}

	public static void printCandidates() {
		List<Candidate> candidates = findCandidates();
		System.out.println(candidates);
	}
}

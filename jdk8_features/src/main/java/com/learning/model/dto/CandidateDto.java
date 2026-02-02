package com.learning.model.dto;

import java.util.List;
import com.learning.model.Candidate;

public class CandidateDto {

	public static List<Candidate> findCandidates() {
		Candidate c1 = new Candidate("Alina", "Finance");
		Candidate c2 = new Candidate("Babita", "Finance");
		Candidate c3 = new Candidate("Celina", "Human Resource");
		Candidate c4 = new Candidate("Denis", "Human Resource");
		Candidate c5 = new Candidate("Elizabeth", "Information Technology");
		Candidate c6 = new Candidate("Fedrick", "Information Technology");
		Candidate c7 = new Candidate("Gagan", "Information Technology");
		Candidate c8 = new Candidate("Hamid", "Science");
		Candidate c9 = new Candidate("Henry", "Science");
		Candidate c10 = new Candidate("Ilyas", "Science");
		Candidate c11 = new Candidate("Jack", "Science");

		return List.of(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11);
	}

	public static void printCandidates() {
		List<Candidate> candidates = findCandidates();
		System.out.println(candidates);
	}
}

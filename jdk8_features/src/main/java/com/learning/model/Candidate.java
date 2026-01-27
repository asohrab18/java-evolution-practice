package com.learning.model;

import java.util.List;

public class Candidate {
	private String name;
	private String department;
	private List<String> skills;

	public Candidate() {
	}

	public Candidate(String name, String department) {
		this.name = name;
		this.department = department;
	}

	public Candidate(String name, String department, List<String> skills) {
		this.name = name;
		this.department = department;
		this.skills = skills;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "'" + name + " from " + department + " department'";
	}

}
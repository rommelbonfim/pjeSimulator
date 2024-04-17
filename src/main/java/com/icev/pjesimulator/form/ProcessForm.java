package com.icev.pjesimulator.form;

import java.util.List;

public class ProcessForm {

	private Long id;
	private Long competence;
	private List<Long> subjects;

	public ProcessForm() {
	}

	public ProcessForm(Long id, Long competence, List<Long> subjects) {
		this.id = id;
		this.competence = competence;
		this.subjects = subjects;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCompetence() {
		return competence;
	}

	public void setCompetence(Long competence) {
		this.competence = competence;
	}
	public List<Long> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Long> subjects) {
		this.subjects = subjects;
	}
}

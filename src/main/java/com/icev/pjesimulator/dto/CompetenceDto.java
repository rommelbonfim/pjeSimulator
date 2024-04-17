package com.icev.pjesimulator.dto;

import com.icev.pjesimulator.models.Competence;

public class CompetenceDto {
	
	private Long id;

	public CompetenceDto() {

	}

	public CompetenceDto(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static CompetenceDto fromCompetence(Competence competence) {
		CompetenceDto dto = new CompetenceDto();
		dto.setId(competence.getId());
		return dto;
	}
}

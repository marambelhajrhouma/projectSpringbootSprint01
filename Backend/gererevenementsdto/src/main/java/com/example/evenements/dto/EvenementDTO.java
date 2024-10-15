package com.example.evenements.dto;

import java.util.Date;

import com.example.evenements.entities.Theme;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvenementDTO {
	private Long idEvenement;
	private String nomEvenement;
	private String description;
	private double prixEvenement;
	private Date dateEvenement;

	private Theme theme;
	//private String nomTheme;
}

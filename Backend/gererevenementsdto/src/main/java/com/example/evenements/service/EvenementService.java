package com.example.evenements.service;

import com.example.evenements.dto.EvenementDTO;
import com.example.evenements.entities.Evenement;
import com.example.evenements.entities.Theme;

import java.util.List;

public interface EvenementService {
	/*Evenement saveEvenemet(Evenement ev);
	Evenement getEvenement(Long id);
	List<Evenement> getAllEvenements();*/
	/******DTO*****/
	
	EvenementDTO getEvenement(Long id);
	List<EvenementDTO> getAllEvenements();
	
	EvenementDTO saveEvenemet(EvenementDTO ev);
	EvenementDTO upadteEvenement(EvenementDTO ev);
	///////////
	
	/*Evenement upadteEvenement(Evenement ev);*/
	void deleteEvenement(Evenement ev);
	void deleteEvenementById(Long id);
	
	
	
	List<Evenement> findByNomEvenement(String nom);
	List<Evenement> findByNomEvenementContains(String nom);
	List<Evenement> findByNomPrix (String nom, Double prix);
	List<Evenement> findByTheme (Theme th);
	List<Evenement> findByThemeIdTheme(Long id);
	List<Evenement> findByOrderByNomEvenementAsc();
	List<Evenement> trierEvenementsNomsPrix();
	
	//DTO Part
	EvenementDTO convertEntityToDto(Evenement ev);
	Evenement convertDtoToEntity(EvenementDTO evDto);
	
}

package com.example.evenements.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.evenements.dto.EvenementDTO;
import com.example.evenements.entities.Evenement;
import com.example.evenements.entities.Theme;
import com.example.evenements.repos.EvenementRepository;

@Service
public class EvenementServiceImpl implements EvenementService{

	@Autowired
	EvenementRepository evenementRepository;
	
	@Autowired
	ModelMapper modelMapper;
	/*
	@Override
	public Evenement saveEvenemet(Evenement ev) {
		
		return evenementRepository.save(ev) ;
	}*/
	//DTO
	@Override
	public EvenementDTO saveEvenemet(EvenementDTO ev) {
		
		return convertEntityToDto(evenementRepository.save(convertDtoToEntity(ev))) ;
	}
	

	@Override
	public EvenementDTO upadteEvenement(EvenementDTO ev) {
		return convertEntityToDto(evenementRepository.save(convertDtoToEntity(ev))) ;
	}

	@Override
	public void deleteEvenement(Evenement ev) {
		evenementRepository.delete(ev) ;	
	}

	@Override
	public void deleteEvenementById(Long id) {
		evenementRepository.deleteById(id) ;
	}

	/*
	@Override
	public Evenement getEvenement(Long id) {
		return evenementRepository.findById(id).get() ;
	}*/
	//dto
	@Override
	public EvenementDTO getEvenement(Long id) {
		return convertEntityToDto(evenementRepository.findById(id).get()) ;
	}
	
	/*
	@Override
	public List<Evenement> getAllEvenements() {
		return evenementRepository.findAll() ;
	}*/
	//dto
	@Override
	public List<EvenementDTO> getAllEvenements() {
		return evenementRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
		
		//methode 2 classique
		/*List<Evenement> evs = evenementRepository.findAll();
		List<EvenementDTO> listevDto = new ArrayList<>(evs.size());
		for (Evenement p : evs)
			listevDto.add(convertEntityToDto(p));
		
		return listevDto;*/
	}

	
	//new
	@Override
	public List<Evenement> findByNomEvenement(String nom) {
		
		return evenementRepository.findByNomEvenement(nom);
	}

	@Override
	public List<Evenement> findByNomEvenementContains(String nom) {
		// TODO Auto-generated method stub
		return evenementRepository.findByNomEvenementContains(nom);
	}

	@Override
	public List<Evenement> findByNomPrix(String nom, Double prix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Evenement> findByTheme(Theme th) {
		// TODO Auto-generated method stub
		return evenementRepository.findByTheme(th);
	}

	@Override
	public List<Evenement> findByThemeIdTheme(Long id) {
		// TODO Auto-generated method stub
		return evenementRepository.findByThemeIdTheme(id);
	}

	@Override
	public List<Evenement> findByOrderByNomEvenementAsc() {
		// TODO Auto-generated method stub
		return evenementRepository.findByOrderByNomEvenementAsc();
	}

	@Override
	public List<Evenement> trierEvenementsNomsPrix() {
		// TODO Auto-generated method stub
		return evenementRepository.trierEvenementNomPrix();
	}

	@Override
	public EvenementDTO convertEntityToDto(Evenement ev) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		
		
		//model mapperdto=> modelMapper ellle va prendre les attributs de la classe et les affecté 
		EvenementDTO evenementDTO =modelMapper.map(ev, EvenementDTO.class);
		return evenementDTO;
		
		
		
		/*EvenementDTO evenementDTO = new EvenementDTO();
		
		evenementDTO.setIdEvenement(ev.getIdEvenement());
		evenementDTO.setNomEvenement(ev.getNomEvenement());
		evenementDTO.setPrixEvenement(ev.getPrixEvenement());
		evenementDTO.setTheme(ev.getTheme());
		
		return evenementDTO;*/
		
		//methode 2
		/*return EvenementDTO.builder()
				.idEvenement(ev.getIdEvenement())
				.nomEvenement(ev.getNomEvenement())
				.prixEvenement(ev.getPrixEvenement())
				.dateEvenement(ev.getDateEvenement())
				.theme(ev.getTheme())
				//.nomTheme(ev.getTheme().getNomTheme())
				.build();*/
	}


	@Override
	public Evenement convertDtoToEntity(EvenementDTO evDto) {
		Evenement ev = new Evenement();
		ev= modelMapper.map(evDto, Evenement.class);
		return ev;
		/* Evenement ev = new Evenement();
	    ev.setIdEvenement(evDto.getIdEvenement());
	    ev.setNomEvenement(evDto.getNomEvenement());
	    ev.setPrixEvenement(evDto.getPrixEvenement()); // Corrected this line
	    ev.setDateEvenement(evDto.getDateEvenement());
	    ev.setTheme(evDto.getTheme());
	    return ev;*/
	}

}

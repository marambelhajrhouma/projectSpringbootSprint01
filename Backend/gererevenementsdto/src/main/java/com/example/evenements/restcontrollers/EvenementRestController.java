package com.example.evenements.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.evenements.dto.EvenementDTO;
import com.example.evenements.entities.Evenement;
import com.example.evenements.service.EvenementService;
import org.springframework.web.bind.annotation.PutMapping;

// Annotation des web services
@RestController
// Pour accéder au web services de cette classe on va taper l'URL
@RequestMapping("/api")
// Sécurité
@CrossOrigin
public class EvenementRestController {

    @Autowired
    EvenementService evenementService; 

    // Get all events
    @RequestMapping(method=RequestMethod.GET)
    public List<EvenementDTO> getAllEvenement() {
        return evenementService.getAllEvenements();
    }

    // Get event by ID
    @RequestMapping(value="/{idEvenement}", method=RequestMethod.GET)
    public EvenementDTO getEvenementById(@PathVariable("idEvenement") Long id) {
        return evenementService.getEvenement(id);
    }

    // Create new event
    @RequestMapping(method=RequestMethod.POST)
    public EvenementDTO createEvenement(@RequestBody EvenementDTO evenementdto) {
        return evenementService.saveEvenemet(evenementdto);
    }

    // Update existing event
    @PutMapping("/{idEvenement}") // Use PUT and specify the ID in the path
    public EvenementDTO updateEvenement(@PathVariable("idEvenement") Long idEvenement, @RequestBody EvenementDTO evenementdto) {
        evenementdto.setIdEvenement(idEvenement); // Set the ID to ensure the correct event is updated
        return evenementService.upadteEvenement(evenementdto);
    }

    // Delete event by ID
    @DeleteMapping("/{idEvenement}") // Corrected path variable
    public void deleteEvenement(@PathVariable("idEvenement") Long idEvenement) {
        evenementService.deleteEvenementById(idEvenement);
    }
    
    
    //ne fonctionne pas 
    @RequestMapping(value="/evstheme/{idtheme}", method=RequestMethod.GET)
    public List<Evenement> getEvenementByThemeId(@PathVariable("idTheme") Long idTheme) {
        return evenementService.findByThemeIdTheme(idTheme);
    }
    
   
    
}

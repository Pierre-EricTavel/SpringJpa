/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.itta.springjpa.entites;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

@Service
@Repository
public class PersonnesService {
    
    @Autowired
    private PersonnesRepository repository;
    
        
    @Autowired
    private  VoitureRepository voitureRepository;
    
    
    @Transactional
    public Personne save(Personne personne){
        return repository.save(personne);
    }
    
    public List<Personne> getByNom(String nom){
        return repository.litPersonParNom(nom);
    }
    public List<Personne> LitPersonneParNom(String name){
        return repository.findPersonneByNom(name);
    }
    
   public  List<Personne> LitPersonneParNomAndPrenom(String nom, String prenom){
       return repository.findPersonneByNomAndPrenom(nom, prenom);
   }
    
   public  List<Personne> LitPersonneParNomIgnoreCaseOrderParPrenomDesc(String nom){
       return repository.findPersonneByNomIgnoreCaseOrderByPrenomDesc(nom);
   }
     
    public List<Personne> LitPersonneDistinctParNomIgnoreCase(String nom){
        return repository.findPersonneDistinctByNomIgnoreCase(nom);
    }
    
    public Page<Personne> getPersonnesByPage(int nopage, int taillepage, Sort.Direction direction, String... champs){
         return repository.findAll(PageRequest.of(nopage,taillepage,direction, champs));
    }
    
     public List<Personne> getPersonnesTrie(Sort.Direction direction, String... champs){
         return repository.findAll(Sort.by(direction, champs));
    }
     

   
   
    public  Personne getById(Integer id) {
        return repository.findById(id).orElse(null);
    }
    
      @Transactional
    public  void deleteVoitureFromPersonnel( int PersonnelId ,int Voitureid) {
       Voiture v = voitureRepository.findById(Voitureid).orElse(null);
       if(v.getProprietaire().getId()==PersonnelId)
            v.proprietaire=null;
       voitureRepository.save(v);
    }

    public void addVoiture(Personne p1, Voiture voiture) {
        voiture.setProprietaire(p1);
        voitureRepository.save(voiture);
    }

    public void deleById(Integer id) {
        repository.deleteById(id);
        
    }



}

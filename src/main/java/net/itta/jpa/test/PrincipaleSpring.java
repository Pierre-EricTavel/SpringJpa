/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.itta.jpa.test;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import net.itta.springjpa.entites.JpaSpringConfig;
import net.itta.springjpa.entites.Personne;
import net.itta.springjpa.entites.PersonnesService;
import net.itta.springjpa.entites.Voiture;
import net.itta.springjpa.entites.VoitureService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class PrincipaleSpring {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(JpaSpringConfig.class);
        EntityManagerFactory entityManagerFactory = context.getBean(EntityManagerFactory.class);
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Personne p = new Personne(1, "albert", "duschmoll", new Date());

        Voiture v1 = new Voiture(1, "porsche", p);
        transaction.begin();
        //em.persist(p);
        em.persist(v1);
        transaction.commit();
        
        transaction.begin();
        p.getVoitures().add(new Voiture(2, "BMW"));
        transaction.commit();
        
        transaction.begin();
        em.remove(p);
        transaction.commit();
        System.out.println(em.find(Voiture.class, 1));

        em.close();

    }

    static void repositories() throws BeansException {
        ApplicationContext context = new AnnotationConfigApplicationContext(JpaSpringConfig.class);
        PersonnesService personneservice = context.getBean(PersonnesService.class);
        VoitureService voitureservice = context.getBean(VoitureService.class);
        Personne p = new Personne(1, "albert", "duschmoll", new Date());
        Personne p1 = new Personne(2, "al", "einstein", new Date());
        Personne p2 = new Personne(3, "albert", "jean", new Date());
        Personne p3 = new Personne(4, "albert", "dupont", new Date());
        Personne p4 = new Personne(5, "al", "einstein", new Date());
        Personne p5 = new Personne(6, "albert", "jean", new Date());
        personneservice.save(p);
        personneservice.save(p1);
        personneservice.save(p2);
        personneservice.save(p3);
        personneservice.save(p4);
        personneservice.save(p5);
        //personneservice.getByNom("al").forEach( System.out::println );
        // personneservice.LitPersonneDistinctParNomIgnoreCase("ALBERT").forEach( System.out::println );
        //  personneservice.LitPersonneParNomAndPrenom("albert","jean").forEach( System.out::println );
        //  personneservice.LitPersonneParNomIgnoreCaseOrderParPrenomDesc("ALBERT").forEach( System.out::println );
        //   personneservice.getPersonnesByPage(1,4, Sort.Direction.DESC, "prenom").forEach( System.out::println );
        //personneservice.getPersonnesTrie(Sort.Direction.DESC, "prenom").forEach(System.out::println);
        personneservice.addVoiture(p1, new Voiture(1, "porsche"));

        // personneservice.deleteVoitureFromPersonnel(p1.getId(),1);
        //voitureservice.removeById(1);
        // personneservice.deleById(p1.getId());
    }
}

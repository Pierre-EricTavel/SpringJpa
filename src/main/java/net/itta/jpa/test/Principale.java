/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.itta.jpa.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import net.itta.jpa.entites.Animal;
import net.itta.jpa.entites.Cage;
import net.itta.jpa.entites.Lion;
import net.itta.jpa.entites.Singe;

/**
 *
 * @author Administrator
 */
public class Principale {

    public static void main(String[] args) {
         List<Lion> lions = new ArrayList<>();
        lions.add(new Lion("leon", new Date(), "leo",50));
        lions.add(new Lion("clarence", new Date(), "clarence",60));
        Cage auxlions = new Cage(1, "aux lions", 0, lions, null);
        List<Singe> singes = new ArrayList<>();
        singes.add(new Singe("cheetah", new Date(), "cheetah",true));
        singes.add(new Singe("judy", new Date(), "judy",false));
        Cage auxsinges = new Cage(2, "aux singes",40,null, singes);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("net.itta_ittaJPA");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(auxlions);
        em.persist(auxsinges);
        em.getTransaction().commit();
        em.close();
    }

    static void CreateCageAnimal() {
//        List<Animal> animaux = new ArrayList<>();
//        animaux.add(new Animal("leon", new Date(), "leo"));
//        animaux.add(new Animal("clarence", new Date(), "clarence"));
//        Cage auxlions = new Cage(1, "aux lions", 30, null);
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("net.itta_ittaJPA");
//        EntityManager em = factory.createEntityManager();
//        em.getTransaction().begin();
//        em.persist(auxlions);
//        em.getTransaction().commit();
//        em.close();
//
////        em = factory.createEntityManager();
////        Animal at = em.find(Animal.class, 1);
////        em.refresh(at);
////        Cage c = at.getCage();
////        System.out.println(c);
////        em.close();
////        
////        em = factory.createEntityManager();
////        Cage c1 = em.find(Cage.class, 1);
////        c1.getAnimaux().forEach(System.out::println);
//em = factory.createEntityManager();
//Cage c1 = em.find(Cage.class, 1);
//em.getTransaction().begin();
//c1.getAnimaux().removeIf(a->a.getId()==1);
//em.getTransaction().commit();
//
//em.close();
    }

    static void AnimalSimple() {
////        Animal a1 = new Animal("simba", new Date(), "commentaires");
////        EntityManagerFactory factory = Persistence.createEntityManagerFactory("net.itta_ittaJPA");
////        EntityManager em = factory.createEntityManager();
////
////        em.getTransaction().begin();
////        em.persist(a1);
////        em.getTransaction().commit();
////        em.close();
////        em = factory.createEntityManager();
////        Animal at = em.find(Animal.class, a1.getId());
////        System.out.println(at);
////          em.remove(at);
////
////        em.getTransaction().begin();
////em.remove(at);
////        Query delanimal = em.createQuery("DELETE FROM Animal a WHERE a.id = :idanimal");
////        delanimal
////                .setParameter("idanimal", a1.getId())
////                .executeUpdate();
////
////        em.getTransaction().commit();
////
////        Query q1 = em.createNamedQuery("Animal.byName");
////        q1.setParameter("nom", "simba");
////        q1.setMaxResults(10);
////        q1.getResultList().forEach(System.out::println);
////
////        CriteriaBuilder cb = em.getCriteriaBuilder();
////        CriteriaQuery<Animal> cq = cb.createQuery(Animal.class);
////        Root<Animal> a = cq.from(Animal.class);
////        Predicate condition = cq.where(cb.like(a.get("nom"), "simba")).getRestriction();
////        cq.select(a).where(condition);
////        Order o = cb.asc(a.get("dateNaissance"));
////        cq.orderBy(o);
////        Query q = em.createQuery(cq);
////        q.setMaxResults(10);
////        q.getResultList().forEach(System.out::println);
////
////        Animal at1 = em.find(Animal.class, 2);
////        System.out.println(em.contains(at1));
////
////        em.getTransaction().begin();
////        at.setNom("Toto");
////        em.getTransaction().commit();
////
////        Animal tutu = new Animal("tutu", new Date(), "merge");
////        tutu.setId(2);
////        em.getTransaction().begin();
////        em.merge(tutu);
////        em.getTransaction().commit();
////        
////        
////        
////        em.close();
////  System.out.println(a1.equals(at));
    }

}

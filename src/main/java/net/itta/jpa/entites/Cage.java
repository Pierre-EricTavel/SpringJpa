/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.itta.jpa.entites;

import java.io.Serializable;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity()
@Table(name = "cages")
public class Cage implements Serializable {
    @Id
    @Column
    Integer no;
    @Column
    String nom;
    @Column
    Integer surfaceEnM2;

    public Cage(Integer no,String nom, Integer surfaceEnM2, Collection<Lion> lions, Collection<Singe> singes) {
        this(no);
        this.nom = nom;
        this.surfaceEnM2 = surfaceEnM2;
        this.lions = lions;
        this.singes = singes;
    }
    public Cage(Integer no) {
        this.no = no;
    }
   

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "cageNo")
    Collection<Lion> lions;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "cageNo")
    Collection<Singe> singes;
    
  

    public Cage() {
    }

  
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.no);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cage other = (Cage) obj;
        if (!Objects.equals(this.no, other.no)) {
            return false;
        }
        return true;
    }
    
    
}

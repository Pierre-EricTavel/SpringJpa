
package net.itta.jpa.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import lombok.*;


@Setter
@Getter
@ToString
//if no @Entity
//@MappedSuperclass

//@Entity(name="Animal")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

//@Entity(name="Animal")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "TYPE_ANIMAL")
//@DiscriminatorValue("ANIMAL")

@Entity(name="Animal")
@Inheritance(strategy = InheritanceType.JOINED)

//Table("animals")
//@NamedQueries({
//    @NamedQuery(name = "Animal.byName",query = "SELECT a FROM Animal a  WHERE a.nom = :nom ORDER BY a.dateNaissance")
//})
public abstract class Animal implements Serializable{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "name",nullable = false,length = 50)
    private String nom;
    @Column(name="birthdate")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    
    @Transient
    private String comment;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "cageNo")
    private Cage cage;
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Animal other = (Animal) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Animal(String nom, Date dateNaissance, String comment) {
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.comment = comment;
    }
    


    public Animal() {
    }
}

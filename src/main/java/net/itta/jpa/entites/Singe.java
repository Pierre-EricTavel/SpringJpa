/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.itta.jpa.entites;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name="Singe")
@Table(name = "singes")
//@DiscriminatorValue("SINGE")
public class Singe extends Animal{

    @Column
    boolean canTalk;

    public Singe( String nom, Date dateNaissance, String comment,boolean canTalk) {
        super(nom, dateNaissance, comment);
        this.canTalk = canTalk;
    }

    public Singe() {
        
    }

   
}

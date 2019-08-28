/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.itta.jpa.entites;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.EmbeddedId;
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
@Entity(name="Lion")
@Table(name = "lions")
//@DiscriminatorValue("LION")
public class Lion extends Animal{


    @Column
    private int tailleCriniereCm;

    @Override
    public void setId(Integer id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }



    public Lion( String nom, Date dateNaissance, String comment,int tailleCriniereCm) {
        super(nom, dateNaissance, comment);
        this.tailleCriniereCm = tailleCriniereCm;
    }

    public Lion() {
        
    }

   
}

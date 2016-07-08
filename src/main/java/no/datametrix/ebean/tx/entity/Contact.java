/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.datametrix.ebean.tx.entity;

import no.datametrix.ebean.tx.entity.finder.ContactFinder;
import com.avaje.ebean.annotation.Cache;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author helge
 */
@Entity
@Table(name = "t_contact")
@Data
@Cache
@NoArgsConstructor
public class Contact extends BaseModel implements Serializable {

  public static final ContactFinder find = new ContactFinder();
    private static final long serialVersionUID = -1661921153316536346L;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(length = 200,unique = true)
    private String email;

    @Column(length = 20)
    private String phone;

    @ManyToOne(optional = false)
    @Column(nullable = true,name = "customer_id")
    private Customer customer;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Sport> sports;
    
    public Contact(String email) {
        this.email = email;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.datametrix.ebean.tx.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author helge
 */
@Entity
@Table(name = "t_contact")
@Data
public class Contact extends BaseModel implements Serializable {

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(length = 200)
    private String email;

    @Column(length = 20)
    private String phone;

    @ManyToOne(optional = false)
    @Column(nullable = true)
    private Customer customer;

    public Contact(String email) {
        this.email = email;
    }
}
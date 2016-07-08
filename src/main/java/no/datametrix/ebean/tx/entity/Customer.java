/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.datametrix.ebean.tx.entity;

import no.datametrix.ebean.tx.entity.finder.CustomerFinder;
import com.avaje.ebean.annotation.Cache;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author helge
 */
@Data
@NoArgsConstructor
@Table(name = "t_customer")
@Entity
@Cache()
public class Customer extends BaseModel implements Serializable {

    public static final CustomerFinder find = new CustomerFinder();
    private static final long serialVersionUID = -51148103803100611L;

    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private List<Contact> contacts;

    public Customer(String name) {
        this.name = name;
    }

}

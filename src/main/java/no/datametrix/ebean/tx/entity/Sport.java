/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.datametrix.ebean.tx.entity;

import no.datametrix.ebean.tx.entity.finder.SportFinder;
import com.avaje.ebean.annotation.Cache;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author helge
 */
@Entity
@Table(name = "t_sport")
@Data
@Cache
@NoArgsConstructor
public class Sport extends BaseModel implements Serializable {

    public static final SportFinder find = new SportFinder();

    private static final long serialVersionUID = 3008541552481686793L;

    @Column()
    private String name;

    @ManyToOne(optional = false)
    @Column(nullable = true)
    private Contact contact;

    public Sport(String name) {
        this.name = name;
    }

}

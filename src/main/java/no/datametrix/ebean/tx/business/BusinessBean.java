/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.datametrix.ebean.tx.business;

import com.avaje.ebean.EbeanServer;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author helge
 */
@Stateless
public class BusinessBean {

    @Inject
    private EbeanServer ebeanServer;
    @Inject
    private TxBean txBean;

    public void doStuff() {

    }
}

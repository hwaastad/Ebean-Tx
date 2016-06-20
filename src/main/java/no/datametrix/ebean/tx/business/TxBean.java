/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.datametrix.ebean.tx.business;

import com.avaje.ebean.EbeanServer;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import no.datametrix.ebean.tx.entity.Customer;

/**
 *
 * @author helge
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class TxBean {

    @Inject
    private EbeanServer ebeanServer;

    public Customer saveCustomer(Customer customer) {
        ebeanServer.save(customer);
        return customer;
    }
}

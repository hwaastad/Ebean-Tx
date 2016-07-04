/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.datametrix.ebean.tx.business;

import com.avaje.ebean.EbeanServer;
import javax.ejb.Stateless;
import javax.inject.Inject;
import no.datametrix.ebean.tx.entity.Contact;
import no.datametrix.ebean.tx.entity.Customer;

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

    public void doStuff(String name) {
        Customer customer = new Customer(name);
        Customer saveCustomer = txBean.saveCustomer(customer);
        Contact contact = new Contact("asdf@wer.re");
        contact.setCustomer(customer);
        txBean.saveContact(contact);
    }

    public Customer lookUp(String name) {
        Customer findUnique = Customer.find.where().name.eq(name).findUnique();
        //Customer findUnique = ebeanServer.find(Customer.class).where().eq("name", name).findUnique();
       // Customer.find.where().name.eq(name).contacts.fetch().findUnique();
        for(Contact c : findUnique.getContacts()){
            c.getEmail();
        }
        return findUnique;
//        return new QCustomer(ebeanServer).name.eq(name).findUnique();
    }
}

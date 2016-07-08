/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.datametrix.ebean.tx.business;

import com.avaje.ebean.EbeanServer;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import no.datametrix.ebean.tx.entity.Contact;
import no.datametrix.ebean.tx.entity.Customer;
import no.datametrix.ebean.tx.entity.Sport;
import no.datametrix.ebean.tx.entity.query.QContact;

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
        Customer findUnique = Customer.find.where().name.eq(name).contacts.fetchAll().contacts.sports.fetchAll().findUnique();
        //List<Customer> list = ebeanServer.find(Customer.class).findList();
        //Customer findUnique = ebeanServer.find(Customer.class).where().eq("name", name).findUnique();
        //List<Customer> list = Customer.find.where().contacts.fetchAll().findList();
       
        // Customer.find.where().name.eq(name).contacts.fetch().findUnique();
        return findUnique;
//        return new QCustomer(ebeanServer).name.eq(name).findUnique();
    }

    public Customer createCustomer(String name) {
        Customer c = new Customer(name);
        txBean.saveCustomer(c);
        return c;
    }

    public Contact createContact(String name, Customer cc) {
        Customer ref = Customer.find.ref(cc.getId());
        Contact c = new Contact(name);
        c.setCustomer(ref);
        cc.getContacts().add(c);
        txBean.saveContact(c);
        return c;
    }

    public Sport createSport(String name, Contact contact) {
        Sport s = new Sport(name);
        s.setContact(contact);
        contact.getSports().add(s);
        txBean.saveContact(contact);
        return s;
    }
}

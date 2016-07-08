/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.datametrix.ebean.tx.business;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.text.json.EJson;
import java.util.Properties;
import javax.inject.Inject;
import no.datametrix.ebean.tx.entity.Contact;
import no.datametrix.ebean.tx.entity.Customer;
import no.datametrix.ebean.tx.producer.EbeansProducer;
import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.Configuration;
import org.apache.openejb.testing.Module;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author helge
 */
@RunWith(ApplicationComposer.class)
public class BusinessBeanIT {

    private static final String CUSTOMER = "customer";
    private static final String CONTACT = "contact@datametrix.no";

    public BusinessBeanIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Module
    @Classes(value = {BusinessBean.class, TxBean.class, EbeansProducer.class}, cdi = true)
    public EjbJar jar() {
        return new EjbJar();
    }

    @Configuration
    public Properties properties() {
        Properties p = new Properties();
        p.put("TestDS", "new://Resource?type=DataSource");
        p.put("TestDS.JdbcDriver", "org.hsqldb.jdbcDriver");
        p.put("TestDS.JdbcUrl", "jdbc:hsqldb:mem:Test");
        p.put("TestDS.logSql", "true");
        p.put("TestDS.jtaManaged", "true");
        p.put("openejb.log.factory", "slf4j");
        return p;
    }

    /**
     * Test of doStuff method, of class BusinessBean.
     */
    @Inject
    private BusinessBean businessBean;

    @Before
    public void before() {
        System.out.println("testCreateCustomer");
        Customer createCustomer = businessBean.createCustomer(CUSTOMER);
        Contact createContact = businessBean.createContact(CONTACT, createCustomer);
        businessBean.createSport("Soccer", createContact);
        businessBean.createSport("Hockey", createContact);
    }

    @Test
    public void testDoStuff() throws Exception {
        System.out.println("doStuff");
        businessBean.doStuff("bof");
        businessBean.lookUp("bof");
        businessBean.lookUp("bof");
    }

    @Test
    public void testCreateCustomer() throws Exception {
        System.out.println("sadasdads");
        Customer lookUp = businessBean.lookUp(CUSTOMER);
        System.out.println("asdad");
        
        System.out.println(Ebean.json().toJson(lookUp));
    }

}

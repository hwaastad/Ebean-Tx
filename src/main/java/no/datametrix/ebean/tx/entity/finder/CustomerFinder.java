package no.datametrix.ebean.tx.entity.finder;

import com.avaje.ebean.Finder;
import no.datametrix.ebean.tx.entity.Customer;
import no.datametrix.ebean.tx.entity.query.QCustomer;

public class CustomerFinder extends Finder<Long,Customer> {

  /**
   * Construct using the default EbeanServer.
   */
  public CustomerFinder() {
    super(Customer.class);
  }

  /**
   * Construct with a given EbeanServer.
   */
  public CustomerFinder(String serverName) {
    super(Customer.class, serverName);
  }

  /**
   * Start a new typed query.
   */
  public QCustomer where() {
     return new QCustomer(db());
  }

  /**
   * Start a new document store query.
   */
  public QCustomer text() {
     return new QCustomer(db()).text();
  }
}

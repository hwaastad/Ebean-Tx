package no.datametrix.ebean.tx.entity.finder;

import com.avaje.ebean.Finder;
import no.datametrix.ebean.tx.entity.Sport;
import no.datametrix.ebean.tx.entity.query.QSport;

public class SportFinder extends Finder<Long,Sport> {

  /**
   * Construct using the default EbeanServer.
   */
  public SportFinder() {
    super(Sport.class);
  }

  /**
   * Construct with a given EbeanServer.
   */
  public SportFinder(String serverName) {
    super(Sport.class, serverName);
  }

  /**
   * Start a new typed query.
   */
  public QSport where() {
     return new QSport(db());
  }

  /**
   * Start a new document store query.
   */
  public QSport text() {
     return new QSport(db()).text();
  }
}

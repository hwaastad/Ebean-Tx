/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.datametrix.ebean.tx.producer;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.ContainerConfig;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.dbplatform.HsqldbPlatform;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author helge
 */
@Slf4j
public class EbeansProducer {

    @Resource(name = "TestDS")
    private DataSource datasource;

    private EbeanServer server;

    @Produces
    @ApplicationScoped
    public EbeanServer getEbeansServer() {
        if (this.server == null) {
            initEserver();
        }
        return this.server;
    }

    public void closeEbeansServer(@Disposes EbeanServer ebeanServer) {
        ebeanServer.shutdown(true, true);
    }

    private void initEserver() {
        ServerConfig config = new ServerConfig();
        config.setDataSource(datasource);
        config.setName("TestDsServer");
        config.setDefaultServer(true);
        config.setDdlGenerate(true);
        config.setDdlRun(true);
        config.setUseJtaTransactionManager(true);
        config.setAutoCommitMode(true);
        config.setDatabasePlatform(new HsqldbPlatform());
        config.setRegister(true);
        config.setDefaultServer(true);
        
        this.server = EbeanServerFactory.create(config);
        Ebean.json();
    }
}

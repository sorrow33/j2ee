package fr.iut.rm.web;

import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;
import fr.iut.rm.web.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fred on 08/03/15.
 */
public class WebModule extends ServletModule {
    /**
     * Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(WebModule.class);

    @Override
    protected final void configureServlets() {
        super.configureServlets();

        logger.info("WebModule configureServlets started...");
        serve("/init").with(InitServlet.class);
        serve("/rooms").with(ListServlet.class);
        serve("/demo").with(BootFreeServlet.class);
        serve("/admin/home").with(AdminServlet.class);
        serve("/tests").with(ListServlet2.class);
        serve("/qrcode/in").with(QrinServlet.class);


        logger.info("   install JpaPersistModule room-manager");
        install(new JpaPersistModule("room-manager"));

        logger.info("   install servlet filter");
        filter("/*").through(PersistFilter.class);

        logger.info("WebModule configureServlets ended.");
    }
}

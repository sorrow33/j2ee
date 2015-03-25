package fr.iut.rm.web;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import fr.iut.rm.persistence.CoreModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;

/**
 * Created by fred on 08/03/15.
 */
@WebListener
public class RoomManagerContextListener extends GuiceServletContextListener {
    /**
     * Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(RoomManagerContextListener.class);

    @Override
    protected final Injector getInjector() {
        logger.info("Injector creation asked");
        return Guice.createInjector(new CoreModule(), new WebModule());
    }

}

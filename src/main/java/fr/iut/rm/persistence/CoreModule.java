package fr.iut.rm.persistence;

import com.google.inject.AbstractModule;
import fr.iut.rm.persistence.dao.RoomDao;
import fr.iut.rm.persistence.dao.impl.RoomDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fred on 08/03/15.
 */
public class CoreModule extends AbstractModule {
    /**
     * Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(CoreModule.class);

    @Override
    protected void configure() {
        logger.info("CoreModule configuration started...");
        logger.info("   bind RoomDao on RoomDaoImpl");
        bind(RoomDao.class).to(RoomDaoImpl.class);
        logger.info("CoreModule configuration ended.");
    }
}

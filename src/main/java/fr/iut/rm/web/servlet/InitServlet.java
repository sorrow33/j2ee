package fr.iut.rm.web.servlet;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import fr.iut.rm.persistence.dao.RoomDao;
import fr.iut.rm.persistence.domain.Room;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This servlet simply
 */
@Singleton
public class InitServlet extends HttpServlet {
    /**
     * the dao used to access room persisted data
     */
    @Inject
    RoomDao roomDao;

    /**
     * HTTP GET access
     * @param req use an optional nb parameter to make evidence of transactionnal behavior volontary triggering an exception
     * @param resp response to sent
     * @throws ServletException by container
     * @throws IOException by container
     */
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        int quantity = 1;
        String param = req.getParameter("nb");
        if (param != null) {
            quantity = Integer.parseInt(param);
        }
        if (quantity == 1) {
            Room room = new Room();
            room.setName("201");
            room.setCapacity(3);
            roomDao.saveOrUpdate(room);

            Room room1 = new Room();
            room1.setName("202");
            room1.setCapacity(15);
            roomDao.saveOrUpdate(room1);

            Room room2 = new Room();
            room2.setName("203");
            room2.setCapacity(29);
            roomDao.saveOrUpdate(room2);

        } else {
            Room room1 = new Room();
            room1.setName("301");
            roomDao.saveOrUpdate(room1);

            Room room2 = new Room();
            room2.setName("200");
            roomDao.saveOrUpdate(room2);

        }

        resp.getOutputStream().print("done");
    }
}

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
import java.util.List;

/**
 * Dumb servlet to output room list
 */
@Singleton
public class ListServlet extends HttpServlet {
    /**
     * the dao to access rooms stored in DB *
     */
    @Inject
    RoomDao roomDao;

    /**
     * GET access
     * @param req nothing specified
     * @param resp nothing specified, must be HTML format
     * @throws ServletException by container
     * @throws IOException by container
     */
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        List<Room> rooms = roomDao.findAll();
        resp.getOutputStream().println("Rooms are :");
        for (Room room : rooms) {
            resp.getOutputStream().println("  " + room.getName());
            resp.getOutputStream().println("  " + room.getCapacity());
        }
    }
}

package fr.iut.rm.web.servlet;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import fr.iut.rm.persistence.dao.RoomDao;
import fr.iut.rm.persistence.domain.Room;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Dumb servlet to output room list
 */       //public class CreateServlet extends HttpServlet {
@Singleton
public class ListServlet2 extends HttpServlet {
    /**
     * the dao to access rooms stored in DB *
     */
    @Inject
    RoomDao roomDao;

    /**
     * constant for template location
     */
    private static final String ROOM_LIST = "templates/room-list.ftl";
    /**
     * constant for UTF-8 *
     */
    private static final String TEMPLATE_ENCODING = "UTF-8";
    /**
     * Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ListServlet.class);


    /**
     * GET access
     * @param req nothing specified
     * @param resp nothing specified, must be HTML format
     * @throws ServletException by container
     * @throws IOException by container
     */
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Template freemarkerTemplate = null;
        freemarker.template.Configuration freemarkerConfiguration = new freemarker.template.Configuration();
        freemarkerConfiguration.setClassForTemplateLoading(this.getClass(), "/");
        freemarkerConfiguration.setObjectWrapper(new DefaultObjectWrapper());
        try {
            freemarkerTemplate = freemarkerConfiguration.getTemplate(ROOM_LIST, TEMPLATE_ENCODING);

        } catch (IOException e) {
            logger.error("Unable to process request, error during freemarker template retrieval.", e);

        }

        Map<String, Object> root = new HashMap<String, Object>();

        List<Room> rooms = roomDao.findAll();

        // navigation data and links
        root.put("title", "Room List");
        root.put("rooms",rooms);

        PrintWriter out = resp.getWriter();
        assert freemarkerTemplate != null;
        try {
            freemarkerTemplate.process(root, out);
            out.close();
        } catch (TemplateException e) {
            logger.error("Error during template processing", e);
        }

        // set mime type
        resp.setContentType("text/html");
    }
}
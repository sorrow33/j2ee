package fr.iut.rm.web.servlet;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
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

@Singleton
public class QroutServlet extends HttpServlet {
    /**
     * the dao to access rooms stored in DB *
     */
    @Inject
    RoomDao roomDao;

    /**
     * constant for template location
     */
    private static final String ROOM_NEW = "templates/room-list.ftl";
    /**
     * constant for UTF-8 *
     */
    private static final String TEMPLATE_ENCODING = "UTF-8";
    /**
     * Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(QroutServlet.class);


    /**
     * GET access
     *
     * @param req  nothing specified
     * @param resp nothing specified, must be HTML format
     * @throws ServletException by container
     * @throws IOException      by container
     */
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String aa = req.getQueryString().toString();
        System.out.println(aa);
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix bitMatrix = null;
        try {
            String url = "Goodbye";
            bitMatrix = writer.encode(url, BarcodeFormat.QR_CODE, 300, 300);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        resp.setContentType("image/png");
        MatrixToImageWriter.writeToStream(bitMatrix, "png", resp.getOutputStream());
    }
}
package fr.iut.rm.web.servlet;

import com.google.inject.Singleton;
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
import java.util.Map;

/**
 * Demonstration servlet for bootstrap and freemarker usage.
 */
@Singleton
public class BootFreeServlet extends HttpServlet {
    /**
     * constant for template location
     */
    private static final String BOOTFREE_TEMPLATE = "templates/boot-free.ftl";
    /**
     * constant for UTF-8 *
     */
    private static final String TEMPLATE_ENCODING = "UTF-8";
    /**
     * Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(BootFreeServlet.class);


    /**
     * HTTP GET access
     *
     * @param request  nothing required
     * @param response response to sent
     * @throws ServletException by container
     * @throws IOException      by container
     */
    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        Template freemarkerTemplate = null;
        freemarker.template.Configuration freemarkerConfiguration = new freemarker.template.Configuration();
        freemarkerConfiguration.setClassForTemplateLoading(this.getClass(), "/");
        freemarkerConfiguration.setObjectWrapper(new DefaultObjectWrapper());
        try {
            freemarkerTemplate = freemarkerConfiguration.getTemplate(BOOTFREE_TEMPLATE, TEMPLATE_ENCODING);

        } catch (IOException e) {
            logger.error("Unable to process request, error during freemarker template retrieval.", e);

        }

        Map<String, Object> root = new HashMap<String, Object>();
        // navigation data and links
        root.put("title", "Bootstrap 101 Template");

        PrintWriter out = response.getWriter();
        assert freemarkerTemplate != null;
        try {
            freemarkerTemplate.process(root, out);
            out.close();
        } catch (TemplateException e) {
            logger.error("Error during template processing", e);
        }

        // set mime type
        response.setContentType("text/html");
    }
}

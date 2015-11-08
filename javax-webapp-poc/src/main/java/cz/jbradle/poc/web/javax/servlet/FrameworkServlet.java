package cz.jbradle.poc.web.javax.servlet;

import cz.jbradle.poc.web.javax.service.FrameworkServiceRemote;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Add framework servlet
 * <p/>
 * Created by George on 7.11.2015.
 */
public class FrameworkServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(FrameworkServlet.class);

    @EJB
    private FrameworkServiceRemote frameworkService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Received get request in FrameworkServlet. Resolving action.");
        String action = request.getParameter("action");
        if (action != null) {
            if (action.compareTo("list") == 0) {
                logger.info("Action resolved as [list]. Loading framework list.");
                request.setAttribute("frameworks", frameworkService.getAllFrameworks());
                request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
                return;
            } else if (action.compareTo("add") == 0) {
                logger.info("Action resolved as [add]. Forwarding to form.");
                request.getRequestDispatcher("/WEB-INF/add.jsp").forward(request, response);
                return;
            } else if (action.compareTo("edit") == 0 || action.compareTo("detail") == 0) {
                loadFrameworkAndSetMapping(request, response, action);
                return;
            } else if (action.compareTo("remove") == 0) {
                logger.info("Action resolved as [remove]. Forwarding to form.");
                int id = Integer.parseInt(request.getParameter("id"));
                frameworkService.removeFramework(id);
                request.setAttribute("frameworks", frameworkService.getAllFrameworks());
                request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
                return;
            }else if (action.compareTo("search") == 0) {
                logger.info("Action resolved as [search]. Loading framework list.");
                String searchParam = request.getParameter("searchParam");
                if(searchParam == null) {
                    request.setAttribute("frameworks", frameworkService.getAllFrameworks());
                }else {
                    request.setAttribute("frameworks", frameworkService.searchFrameworks(searchParam));
                }
                request.getRequestDispatcher("/WEB-INF/search.jsp").forward(request, response);
                return;
            }
        }
        logger.info("Action not resolved. Forward to about");
        request.getRequestDispatcher("/WEB-INF/about.jsp").forward(request, response);
    }

    private void loadFrameworkAndSetMapping(HttpServletRequest request, HttpServletResponse response, String action)
            throws ServletException, IOException {
        logger.info("Action resolved as [" + action + "]. Forwarding to detail.");
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("framework", frameworkService.getFrameworkById(id));
        request.getRequestDispatcher("/WEB-INF/" + action + ".jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Received post request in AddFrameworkServlet. Resolving action.");
        String action = request.getParameter("action");
        if (action != null) {
            if (action.compareTo("add") == 0) {
                frameworkService.addFramework(
                        request.getParameter("name"),
                        request.getParameter("description"),
                        request.getParameter("categorySelect"),
                        request.getParameter("docLink")
                );
            } else if (action.compareTo("edit") == 0) {
                logger.info("Action resolved as [edit]. Updating framework.");
                int id = Integer.parseInt(request.getParameter("id"));
                frameworkService.updateFramework(id,
                        request.getParameter("name"),
                        request.getParameter("description"),
                        request.getParameter("categorySelect"),
                        request.getParameter("docLink")
                );
            }else if (action.compareTo("search") == 0) {

                return;
            }
        }
        request.setAttribute("frameworks", frameworkService.getAllFrameworks());
        request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
    }
}

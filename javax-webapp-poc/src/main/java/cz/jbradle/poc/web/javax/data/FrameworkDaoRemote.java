package cz.jbradle.poc.web.javax.data;

import cz.jbradle.poc.web.javax.model.Framework;

import javax.ejb.Remote;
import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Implementation of data access object for work with frameworks data
 *
 * Created by George on 7.11.2015.
 */
@Remote
public interface FrameworkDaoRemote {


    List<Framework> getAllFrameworks();

    void addFramework(Framework framework);

    void updateFramework(Framework framework);

    Framework getById(int id);

    void deleteFramework(int id);

    List<Framework> searchFrameworksByName(String searchParam);
}

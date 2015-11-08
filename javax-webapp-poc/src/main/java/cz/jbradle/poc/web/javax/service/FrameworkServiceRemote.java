package cz.jbradle.poc.web.javax.service;

import cz.jbradle.poc.web.javax.model.Framework;

import javax.ejb.Remote;
import java.util.List;

/**
 * Remote interface for Framework service
 * <p/>
 * Created by George on 8.11.2015.
 */
@Remote
public interface FrameworkServiceRemote {

    List<Framework> getAllFrameworks();

    Framework getFrameworkById(int id);

    void updateFramework(int id, String name, String description, String category, String docLink);

    void removeFramework(int id);

    void addFramework(String name, String description, String category, String documentationLink);

    List<Framework> searchFrameworks(String searchParam);
}

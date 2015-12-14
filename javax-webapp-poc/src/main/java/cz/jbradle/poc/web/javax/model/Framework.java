package cz.jbradle.poc.web.javax.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Framework model object
 *
 * Created by George on 7.11.2015.
 */
@Entity
@Table( name = "FRAMEWORK" )
public class Framework implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FRAMEWORK_ID_GENERATOR")
    @SequenceGenerator(name = "FRAMEWORK_ID_GENERATOR", sequenceName = "SEQ_FRAMEWORK_ID")
    @Column(name = "FRAMEWORK_ID", unique = true, nullable = false)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "DOC_LINK")
    private String documentationLink;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ADDED_ON")
    private Date addedOn;

    public Framework(String name, String description, String category, String documentationLink, Date addedOn) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.documentationLink = documentationLink;
        this.addedOn = addedOn;
    }

    public Framework(int id, String name, String description, String category, String documentationLink, Date addedOn) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.documentationLink = documentationLink;
        this.addedOn = addedOn;
    }

    public Framework() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDocumentationLink() {
        return documentationLink;
    }

    public void setDocumentationLink(String documentationLink) {
        this.documentationLink = documentationLink;
    }

    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }
}

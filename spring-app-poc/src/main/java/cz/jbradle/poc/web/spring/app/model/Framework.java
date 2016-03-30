package cz.jbradle.poc.web.spring.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Framework model object
 * <p>
 * Created by JBradle on 7.11.2015.
 */
@Entity
@Table(name = "FRAMEWORK")
public class Framework {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FRAMEWORK_ID_GENERATOR")
    @SequenceGenerator(name = "FRAMEWORK_ID_GENERATOR", sequenceName = "SEQ_FRAMEWORK_ID")
    @Column(name = "FRAMEWORK_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DOC_LINK")
    private String documentationLink;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ADDED_ON")
    private Date addedOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Framework{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", documentationLink='" + documentationLink + '\'' +
                ", addedOn=" + addedOn +
                ", category=" + category +
                '}';
    }
}

package cz.jbradle.poc.web.spring.app.model;

import java.util.Date;

/**
 * Framework data transfer object
 * <p>
 * Created by George on 27.2.2016.
 */
public class FrameworkDTO {

    private Integer id;
    private String name;
    private String description;
    private String documentationLink;
    private Date addedOn;
    private CategoryDTO category;
    private int categoryId;


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

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "FrameworkDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", documentationLink='" + documentationLink + '\'' +
                ", addedOn=" + addedOn +
                ", category=" + category +
                '}';
    }
}

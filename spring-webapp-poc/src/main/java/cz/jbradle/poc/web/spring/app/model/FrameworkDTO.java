package cz.jbradle.poc.web.spring.app.model;

import java.util.Date;

/**
 * Framework data transfer object
 * <p>
 * Created by JBradle on 27.2.2016.
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FrameworkDTO that = (FrameworkDTO) o;

        if (categoryId != that.categoryId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (documentationLink != null ? !documentationLink.equals(that.documentationLink) : that.documentationLink != null)
            return false;
        if (addedOn != null ? !addedOn.equals(that.addedOn) : that.addedOn != null) return false;
        return !(category != null ? !category.equals(that.category) : that.category != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (documentationLink != null ? documentationLink.hashCode() : 0);
        result = 31 * result + (addedOn != null ? addedOn.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + categoryId;
        return result;
    }
}

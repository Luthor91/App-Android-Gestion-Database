package com.example.myapp.dta;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.example.tp03.entities.Category}
 */
public class CategoryDto implements Serializable {
    private final Integer id;
    private final String title;
    private final String webTitle;
    private final Integer leval;

    public CategoryDto(Integer id, String title, String webTitle,  Integer leval) {
        this.id = id;
        this.title = title;
        this.webTitle = webTitle;
        this.leval = leval;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public Integer getLeval() {
        return leval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDto entity = (CategoryDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.webTitle, entity.webTitle) &&
                Objects.equals(this.leval, entity.leval);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, webTitle, leval);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "title = " + title + ", " +
                "webTitle = " + webTitle + ", " +
                "leval = " + leval + ")";
    }
}
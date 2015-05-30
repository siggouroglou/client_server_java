package gr.papei.mainpackage.server.service;

import gr.papei.mainpackage.server.data.*;

/**
 *
 * @author siggouroglou@gmail.com
 */
public class FilmService {
    private int id;
    private String title;
    private String category;
    private String description;

    public FilmService() {
        this.id = -1;
        this.title = "";
        this.category = "";
        this.description = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

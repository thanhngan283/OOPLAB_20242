package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitle();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCost();

    public Media(String title) {
        this.title = title;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // generate getter and setter
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getCost() {
        return cost;
    }

    public boolean isMatchByTitle(String title) {
        boolean titleMatch = getTitle().toLowerCase().contains(title.toLowerCase());
        return titleMatch;
    }

    public boolean isMatch(String title) {
        boolean titleMatch = getTitle().toLowerCase().contains(title.toLowerCase());
        boolean categoryMatch = getCategory().toLowerCase().contains(title.toLowerCase());
        return titleMatch || categoryMatch;
    }

    public boolean isMatch(float maxCost) {
        return getCost() <= maxCost;
    }

    public boolean isMatch(float minCost, float maxCost) {
        return getCost() >= minCost && getCost() <= maxCost;
    }

    public boolean equals(Object obj) {
        Media media = (Media) obj;
        return title == media.getTitle();
    }
}

package by.library.galkina.entity;


public abstract class Edition {
    private String name;
    private int pagesCount;
    private String publishingHouse;

    public Edition(String name, int pagesCount, String publishingHouse) {
        this.name = name;
        this.pagesCount = pagesCount;
        this.publishingHouse = publishingHouse;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edition)) return false;

        Edition edition = (Edition) o;

        if (pagesCount != edition.pagesCount) return false;
        if (name != null ? !name.equals(edition.name) : edition.name != null) return false;
        if (publishingHouse != null ? !publishingHouse.equals(edition.publishingHouse) : edition.publishingHouse != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + pagesCount;
        result = 31 * result + (publishingHouse != null ? publishingHouse.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", pagesCount=" + pagesCount +
                ", publishingHouse='" + publishingHouse + '\''+", ";
    }
}

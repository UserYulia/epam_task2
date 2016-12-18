package by.library.galkina.entity;


public class Magazine extends Edition{
    private int number;

    public Magazine(String name, int pagesCount, String publishingHouse, int number) {
        super(name, pagesCount, publishingHouse);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Magazine)) return false;
        if (!super.equals(o)) return false;

        Magazine magazine = (Magazine) o;

        if (number != magazine.number) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + number;
        return result;
    }

    @Override
    public String toString() {
        return "Magazine{" +super.toString()+
                "number=" + number +
                '}';
    }
}

package domain;

public class Person {
    public  int id;
    public String name;
    public  int agr;

    public Person(int id, String name, int agr) {
        this.id = id;
        this.name = name;
        this.agr = agr;
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

    public int getAgr() {
        return agr;
    }

    public void setAgr(int agr) {
        this.agr = agr;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", agr=" + agr +
                '}';
    }
}

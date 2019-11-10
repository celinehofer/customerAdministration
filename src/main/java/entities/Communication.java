package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Communication {

    @Id
    private Enum typ;
    private String name;
    private String input;
    private Enum sort;

    public Enum getTyp() {
        return typ;
    }

    public void setTyp(Enum typ) {
        this.typ = typ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Enum getSort() {
        return sort;
    }

    public void setSort(Enum sort) {
        this.sort = sort;
    }
}

package ua.koss.binarytree.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
public class Person implements Comparable<Person>{
    private String uuid;
    private String name;
    private Date birth_data;

    @Override
    public int compareTo(Person o) {
        return getBirth_data().compareTo(o.getBirth_data());
    }

    @Override
    public String toString() {
        return "Person{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", birth_data=" + birth_data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && birth_data.equals(person.birth_data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birth_data);
    }
}

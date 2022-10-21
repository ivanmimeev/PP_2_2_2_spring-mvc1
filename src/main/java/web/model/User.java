package web.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table (name = "user")
public class User {
    @Id
    @GeneratedValue (generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
    @Column (name = "name", nullable = false)
    private String name;
    @Column (name = "lastName", nullable = false)
    private String lastName;

    public User() {
    }

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
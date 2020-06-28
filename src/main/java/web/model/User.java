package web.model;

import javax.persistence.*;

@Entity
@Table(name = "users231")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String Name;

    @Column(name = "adress")
    private String Adress;

    @Column(name = "email")
    private String Email;

    public User() {}

    public User(String Name, String Adress, String Email) {
        this.Name = Name;
        this.Adress = Adress;
        this.Email = Email;
    }

    public User(long id, String Name, String Adress, String Email) {
        this.id = id;
        this.Name = Name;
        this.Adress = Adress;
        this.Email = Email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = Email;
    }

}

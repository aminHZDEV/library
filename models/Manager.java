package models;

public class Manager{
    private String password;
    private String username;
    private String lastname;
    private String firstname;

    public Manager() {
    }

    public Manager(String password, String username, String lastname, String firstname) {
        this.password = password;
        this.username = username;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Manager password(String password) {
        setPassword(password);
        return this;
    }

    public Manager username(String username) {
        setUsername(username);
        return this;
    }

    public Manager lastname(String lastname) {
        setLastname(lastname);
        return this;
    }

    public Manager firstname(String firstname) {
        setFirstname(firstname);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " password='" + getPassword() + "'" +
            ", username='" + getUsername() + "'" +
            ", lastname='" + getLastname() + "'" +
            ", firstname='" + getFirstname() + "'" +
            "}";
    }

}
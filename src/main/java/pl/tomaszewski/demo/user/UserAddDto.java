package pl.tomaszewski.demo.user;

public class UserAddDto {
    private String firstName;

    private String lastName;

    private String password;

    private String nick;

    public UserAddDto(String firstName, String lastName, String password, String nick) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.nick = nick;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}

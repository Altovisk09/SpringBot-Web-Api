package dio.web.api.model;

public class User {
    private int id;
    private String login;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(){};
    public User(String login, String password){
        this.login = login;
        this.password = password;
    }
    @Override
    public String toString(){
        return "User: {" +
                "login='" + login + '\'' +
                ",password='" + password + '\'' +
                '}';
    }
}

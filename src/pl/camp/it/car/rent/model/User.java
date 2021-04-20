package pl.camp.it.car.rent.model;

public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String convertToDbRecord(){
        StringBuilder sb = new StringBuilder();
        sb.append("User;")
                .append(this.login)
                .append(";")
                .append(this.password);

              return  sb.toString();
    }
}

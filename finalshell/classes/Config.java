package finalshell.classes;

public class Config {

    int index;
    String host;
    String name;
    String user;
    String password;

    public Config(int index, String host, String name, String user, String password) {
        this.index = index;
        this.host = host;
        this.name = name;
        this.user = user;
        this.password = password;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIndex() {
        return index;
    }

    public String getHost() {
        return host;
    }

    public String getName() {
        return name;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}

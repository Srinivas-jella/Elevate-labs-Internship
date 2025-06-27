public class User {
    private int userId;
    private String name;

    public String getName() {
        return name;
    }
    public int getUserId() {
        return userId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    @Override
    public String toString() {
        return "User [ID=" + userId + ", Name=" + name + "]";
    }
}

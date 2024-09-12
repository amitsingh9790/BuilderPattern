package BuilderPattern;
//Abstract Factory Method — A creational design pattern that lets you produce families of related objects without specifying their concrete classes.

//Builder — A creational design pattern that lets you construct complex objects step by step.
//The pattern allows you to produce different types and representations of an object using the same construction
// code.
class User{
    // I will give attribute in any sequence, but you need to give
    private final String userId;
    private final String userName;
    private final String userEmail;

    //initially we need to do private constructor
    public User(UserBuilder builder) {
        this.userId = builder.userId;
        this.userEmail = builder.userEmail;
        this.userName = builder.userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }


    public String getUserEmail() {
        return userEmail;
    }

    //inner class to create an object / kind of jugad
    static class UserBuilder{
        private  String userId;
        private  String userName;
        private  String userEmail;

        public UserBuilder(){
        }

        public UserBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserBuilder setUserEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public User bulid(){
            User u = new User(this);
            return u;
        }

        @Override
        public String toString() {
            return "UserBuilder{" +"userId='" + userId + '\'' +", userName='" + userName + '\'' +", userEmail='" + userEmail + '\'' +'}';
        }
    }
}

public class BuilderPatternDemo {
    public static void main(String[] args) {
        User user1 = new User.UserBuilder()
                .setUserName("Pawan")
                .setUserEmail("pawan@gmail.com")
                .setUserId("122")
                .bulid();
        System.out.println(user1.getUserEmail());
    }
}
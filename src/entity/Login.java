package entity;

public class Login {
    private String UserName;
    private String PassWord;

    public Login() {
    }

    public Login(String userName, String passWord) {
        setUserName(userName);
        setPassWord(passWord);
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    @Override
    public String toString() {
        return "Login{" +
                "UserName='" + UserName + '\'' +
                ", PassWord='" + PassWord + '\'' +
                '}';
    }
}

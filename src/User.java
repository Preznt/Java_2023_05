
// 생성자에서 넣어준 값을 리턴해주는 기능만 갖고있는 이런 객체를 불변객체라고 한다
public class User {
    private String email;
    private String password;
    private String name;

    // 생성자를 하나라도 만들게 되면, 기본생성자는 자동으로 만들어지지 않는다
    public User(String name, String email) {
//        this.email = email;
//        this.name = name;
        this(name, email, null);
    }

    // 생성자 오버로딩
    public User(String name, String email, String password) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}

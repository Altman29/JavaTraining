package phase01.po;

/**
 * @author csy
 * @createTime 2021-11-25
 * @Description pojo
 */
public class User {
    private Long id;
    private String name;
    private String sex;
    private String address;
    private String birthday;

    public User() {
    }

    public User(Long id, String name, String sex, String address, String birthday) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", sex='" + sex + '\'' + ", address='" + address + '\''
                        + ", birthday='" + birthday + '\'' + '}';
    }
}

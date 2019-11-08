package labSession05;

public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Integer mark;

    public User() {    }

    public User(Integer id, String name, Integer age, Integer mark) {
        setId(id);
        setName(name);
        setAge(age);
        setMark(mark);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}

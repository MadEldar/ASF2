package labSession07;

public class Account {
    private Integer id;
    private String name;
    private String workplace;
    private String address;

    public Account(Integer id, String name, String workplace, String address) {
        setId(id);
        setName(name);
        setWorkplace(workplace);
        setAddress(address);
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

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return this.getName();
    }
}

package labSession08;

public class PhoneNumber {
    private Integer number;
    private String type;
    private Integer owner;

    public PhoneNumber(Integer number, String type, Integer owner) {
        this.number = number;
        this.type = type;
        this.owner = owner;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public String getTableName() {
        return "phone_list";
    }
}

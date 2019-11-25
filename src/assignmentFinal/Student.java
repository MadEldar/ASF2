package assignmentFinal;

public class Student {
    private String studentId;
    private String name;
    private String address;
    private String phone;

    public Student(String studentId, String name, String address, String phone) {
        setStudentId(studentId);
        setName(name);
        setAddress(address);
        setPhone(phone);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

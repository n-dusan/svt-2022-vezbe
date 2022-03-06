package rs.ac.uns.ftn.svtvezbe03.primer05;

public class Teacher {

    private int teacherId;
    private String firstName;
    private String lastName;
    private String position;

    public Teacher() {
    }

    public Teacher(int teacherId, String firstName, String lastName, String position) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

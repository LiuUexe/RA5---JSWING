package Class;

public class Student {

    private String name;
    private String surname;
    private int age;
    private String grade;
    private String dni;

    public Student(String name, String surname, int age, String grade, String dni) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.grade = grade;
        this.dni = dni;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return name + ", " + surname + ", " + age + ", " + grade + ", " + dni;
    }
    
    

}

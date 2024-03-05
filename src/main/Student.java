package main;

public class Student extends Human {
    int id;
    float grade;

    public Student(int age, String name, String nationality,int id,float grade) {
        super(age, name, nationality);
        this.id = id;
        this.grade = grade;
    }
      static int hhah(){
        return 69;
    }

    public int getId(){
        return id;
    }
    public float getGrade(){
        return grade;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setGrade(float grade){
        this.grade = grade;
    }
}
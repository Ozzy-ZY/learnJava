package main;

public class Human {
    private int age;
    private String name;
    private String nationality;
    public int getAge(){
        return age;
    }
    public String getName() {
        return name;
    }
    public String getNationality(){
        return nationality;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public Human(int age,String name,String nationality){
        this.age= age;
        this.name = name;
        this.nationality = nationality;
    }
}

package javaxvalidation.bean;

import javax.validation.constraints.*;

public class User {

    @NotNull
    private String name;

    @Min(value = 18)
    private int age;

    @Email(message = "Email must be valid")
    private String email;

    @AssertTrue(message = "Must be true")
    private boolean working;

    @Size(min = 10, max = 200, message = "Size must be between 10 and 200 characters")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", working=" + working +
                ", aboutMe='" + description + '\'' +
                '}';
    }
}

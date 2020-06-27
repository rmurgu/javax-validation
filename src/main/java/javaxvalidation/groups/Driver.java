package javaxvalidation.groups;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Driver {

    @NotNull
    private String name;

    @Min(
            value = 18,
            message = "You hav eto be 18 to drive a car",
            groups = DriverChecks.class
    )
    private int age;

    @AssertTrue(
            message = "You first have to pass the driving test",
            groups = DriverChecks.class
    )
    private boolean hasDrivingLicense;

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

    public boolean hasDrivingLicense() {
        return hasDrivingLicense;
    }

    public void setHasDrivingLicense(boolean hasDrivingLicense) {
        this.hasDrivingLicense = hasDrivingLicense;
    }
}

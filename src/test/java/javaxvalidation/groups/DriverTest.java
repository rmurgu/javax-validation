package javaxvalidation.groups;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.Assert.*;

public class DriverTest {

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    private Driver validDriver() {
        Driver driver = new Driver();
        driver.setName("John Doe");
        driver.setAge(20);
        driver.setHasDrivingLicense(true);
        return driver;
    }

    @Test
    public void underAgeDriverDefaultChecks() {
        // given
        Driver driver = validDriver();
        driver.setAge(10);

        // when
        Set<ConstraintViolation<Driver>> violations = validator.validate(driver);

        // then
        assertEquals(0, violations.size());
    }

    @Test
    public void underAgeDriverDriverChecks() {
        // given
        Driver driver = validDriver();
        driver.setAge(10);

        // when
        Set<ConstraintViolation<Driver>> violations = validator.validate(driver, DriverChecks.class);

        // then
        assertEquals(1, violations.size());
    }

    @Test
    public void noLicenseDefaultChecks() {
        // given
        Driver driver = validDriver();
        driver.setHasDrivingLicense(false);

        // when
        Set<ConstraintViolation<Driver>> violations = validator.validate(driver);

        // then
        assertEquals(0, violations.size());
    }

    @Test
    public void noLicenseDriverChecks() {
        // given
        Driver driver = validDriver();
        driver.setHasDrivingLicense(false);

        // when
        Set<ConstraintViolation<Driver>> violations = validator.validate(driver, DriverChecks.class);

        // then
        assertEquals(1, violations.size());
    }
}
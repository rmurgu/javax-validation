package javaxvalidation.bean;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    private User createValidUser() {
        User user = new User();
        user.setName("John Doe");
        user.setAge(20);
        user.setWorking(true);
        user.setDescription("lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum ");
        List<String> preferences = Arrays.asList("ice cream");
        return user;
    }

    @Test
    public void validUser() {
        // given
        User user = createValidUser();

        // when
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        // then
        assertTrue(violations.isEmpty());
    }

    @Test
    public void invalidName() {
        // given
        User user = createValidUser();
        user.setName(null);

        // when
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        // then
        assertEquals(1, violations.size());
        assertEquals("Name must not be null", violations.iterator().next().getMessage());
    }

    @Test
    public void invalidAge() {
        // given
        User user = createValidUser();
        user.setAge(10);

        // when
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        // then
        assertEquals(1, violations.size());
    }

    @Test
    public void invalidEmail() {
        // given
        User user = createValidUser();
        user.setEmail("incorrectEmailPattern");

        // when
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        // then
        assertEquals(1, violations.size());
        assertEquals("Email must be valid", violations.iterator().next().getMessage());
    }

    @Test
    public void invalidWorker() {
        // given
        User user = createValidUser();
        user.setWorking(false);

        // when
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        // then
        assertEquals(1, violations.size());
        assertEquals("Must be true", violations.iterator().next().getMessage());
    }

    @Test
    public void invalidAboutMeDescriptionSize() {
        // given
        User user = createValidUser();
        user.setDescription("lorem");

        // when
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        // then
        assertEquals(1, violations.size());
        assertEquals("Size must be between 10 and 200 characters", violations.iterator().next().getMessage());
    }
}
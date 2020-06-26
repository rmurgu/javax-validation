package javaxvalidation.container;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.*;

import static org.junit.Assert.*;

public class ZooTest {

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    private Zoo createValidZoo() {
        Zoo zoo = new Zoo();
        zoo.setAnimals(Arrays.asList("penguin"));
        zoo.setEmployees(Collections.singletonMap(new Name(), new Job()));
        return zoo;
    }

    @Test
    public void validZoo() {
        // given
        Zoo zoo = createValidZoo();

        // when
        Set<ConstraintViolation<Zoo>> violations = validator.validate(zoo);

        // then
        assertTrue(violations.isEmpty());
    }

    @Test
    public void invalidListElements() {
        // given
        Zoo zoo = createValidZoo();
        zoo.setAnimals(Arrays.asList(""));

        // when
        Set<ConstraintViolation<Zoo>> violations = validator.validate(zoo);

        // then
        assertEquals(2, violations.size());
    }

    @Test
    public void invalidEmployee() {
        // given
        Zoo zoo = createValidZoo();
        zoo.setEmployees(Collections.singletonMap(null, null));

        // when
        Set<ConstraintViolation<Zoo>> violations = validator.validate(zoo);

        // then
        assertEquals(2, violations.size());
    }
}
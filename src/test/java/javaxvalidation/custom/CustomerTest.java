package javaxvalidation.custom;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.Assert.*;

public class CustomerTest {

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    private Customer validCustomer() {
        Customer customer = new Customer();
        customer.setName("John Doe");
        customer.setEmail("test@endava.com");
        return customer;
    }

    @Test
    public void validEndavaEmail() {
        // given
        Customer customer = validCustomer();

        // when
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);

        // then
        assertEquals(0, violations.size());
    }

    @Test
    public void nullEndavaEmail() {
        // given
        Customer customer = validCustomer();
        customer.setEmail(null);

        // when
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);

        // then
        assertEquals(0, violations.size());
    }

    @Test
    public void invalidEndavaEmail() {
        // given
        Customer customer = validCustomer();
        customer.setEmail("invalid@email.com");

        // when
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);

        // then
        assertEquals(1, violations.size());
    }
}
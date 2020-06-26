package javaxvalidation.container;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

public class Zoo {

    private List<@NotEmpty @NotBlank String> animals;

    private Map<@NotNull Name, @NotNull Job> employees;

    public List<String> getAnimals() {
        return animals;
    }

    public void setAnimals(List<String> animals) {
        this.animals = animals;
    }

    public Map<Name, Job> getEmployees() {
        return employees;
    }

    public void setEmployees(Map<Name, Job> employees) {
        this.employees = employees;
    }
}

import entities.Storage;
import entities.Users;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@RunWith(JUnit4.class)
public class test {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void nazwiskoNull() {
        Users user = new Users("Bartek", null, "admin", "admin");

        Set<ConstraintViolation<Users>> constraintViolations = validator.validate(user);
        Assert.assertEquals(1, constraintViolations.size());
        Assert.assertEquals(
                "wymagane",
                constraintViolations.iterator().next().getMessage()
        );
    }

    @Test
    public void hasloMniejniz5() {
        Users user = new Users("Mateusz", "Szuwarowski", "magazynier", "adm");

        Set<ConstraintViolation<Users>> constraintViolations = validator.validate(user);

        Assert.assertEquals(1, constraintViolations.size());
        Assert.assertEquals(
                "size must be between 5 and 255",
                constraintViolations.iterator().next().getMessage()
        );
    }

    @Test
    public void pusteHaslo() {
        Users user = new Users("lukasz", "Kowalczyk", "admin", "");

        Set<ConstraintViolation<Users>> constraintViolations = validator.validate(user);

        Assert.assertEquals(1, constraintViolations.size());
        Assert.assertEquals(
                "size must be between 5 and 255",
                constraintViolations.iterator().next().getMessage()
        );

    }
    @Test
    public void stanmniejszy0() {
       Storage storage = new Storage(-1);

        Set<ConstraintViolation<Storage>> constraintViolations = validator.validate(storage);

        Assert.assertEquals(1, constraintViolations.size());
        Assert.assertEquals(
                "must be between 1 and 100",
                constraintViolations.iterator().next().getMessage()
        );

    }

}

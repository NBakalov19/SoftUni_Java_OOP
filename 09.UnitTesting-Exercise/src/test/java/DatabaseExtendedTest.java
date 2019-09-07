import org.junit.Before;
import org.junit.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;

public class DatabaseExtendedTest {
    private static final Person[] PEOPLE = new Person[]{new Person(1, "Name")};
    private Database db;

    @Before
    public void createDatabase() throws OperationNotSupportedException {
        this.db = new Database(PEOPLE);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUserNameWithNullParam() throws OperationNotSupportedException {
        this.db.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUserNameCantFindPersonWithGivenUserName() throws OperationNotSupportedException {
        this.db.findByUsername("");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUserFindMoreThanUserName() throws OperationNotSupportedException {
        this.db.add(new Person(12, "Name"));
        db.findByUsername("Name");
    }

    @Test()
    public void findByUserNameReturnCorrectPerson() throws OperationNotSupportedException {
        Person p = this.db.findByUsername("Name");

        assertEquals("Name", p.getUsername());
    }
}

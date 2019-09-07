import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    private static final Integer[] INITIAL_ELEMENTS = new Integer[]{1, 2, 3};

    private Database database;

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionWithLessThanOneElement() throws OperationNotSupportedException {
        this.database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionWithMoreThanSixteenElements() throws OperationNotSupportedException {
        this.database = new Database(new Integer[17]);
    }

    @Before
    public void beforeEach() throws OperationNotSupportedException {
        this.database = new Database(INITIAL_ELEMENTS);
    }

    @Test
    public void constructingShouldIncreaseElementsCount() throws NoSuchFieldException, IllegalAccessException {

        Field elementsCount = this.database.getClass().getDeclaredField("elementsCount");
        elementsCount.setAccessible(true);
        int currValue = elementsCount.getInt(this.database);

        assertEquals(DatabaseTest.INITIAL_ELEMENTS.length, currValue);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingNullElementShouldThrowException() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test
    public void addingElementShouldIncreaseElementCount() throws OperationNotSupportedException {

        this.database.add(12);

        assertEquals(this.database.getElements().length, INITIAL_ELEMENTS.length + 1);
    }

    @Test
    public void removeShouldOnlyLastElement() throws OperationNotSupportedException {
        this.database.remove();

        int length = this.database.getElements().length;
        Assert.assertEquals(length, INITIAL_ELEMENTS.length - 1);
    }
}

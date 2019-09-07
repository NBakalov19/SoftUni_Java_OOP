import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p03_IteratorTest.ListIterator;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {
    private static final String[] INITIAL_DATA = new String[]{"one", "two", "three"};
    private ListIterator listIterator;

    @Before
    public void createListIterator() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(INITIAL_DATA);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void ConstructorShouldThrowExceptionWithNullParam() throws OperationNotSupportedException {
        ListIterator li = new ListIterator(null);
    }

    @Test
    public void constructorShouldSetElementsCorrectly() {
        assertEquals(INITIAL_DATA[0], this.listIterator.print());
    }

    @Test
    public void printerShouldReturnCorrectElement() {
        assertEquals(INITIAL_DATA[0], this.listIterator.print());
    }

    @Test(expected = IllegalStateException.class)
    public void printShouldThrowExceptionWhenPrintEmptyCollection() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();

        listIterator.print();
    }

    @Test
    public void hasNextShouldReturnFalseOnEmptyList() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();

        assertFalse(listIterator.hasNext());
    }

    @Test
    public void hasNextShouldReturnTrueIfThereAreNextElements() {
        assertTrue(this.listIterator.hasNext());
    }

    @Test
    public void moveShouldMoveCorrectlyToNextElement() {
        assertTrue(this.listIterator.move());
    }

    @Test
    public void moveShouldReturnFalseOnLastElement() {
        for (int i = 0; i < 2; i++) {
            this.listIterator.move();
        }

        assertFalse(this.listIterator.move());
    }

}
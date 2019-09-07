import org.junit.Before;
import org.junit.Test;
import p05_CustomLinkedList.CustomLinkedList;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    private CustomLinkedList<Integer> customLinkedList;

    @Before
    public void createCustomLinkedList() {
        this.customLinkedList = new CustomLinkedList<>();
    }

    @Test
    public void containsShouldReturnTrueIfElementIsPresentInCollection() {
        this.customLinkedList.add(10);
        this.customLinkedList.add(12);
        this.customLinkedList.add(14);

        assertTrue(this.customLinkedList.contains(14));
    }


    @Test
    public void containsShouldReturnFalseOnEmptyCollection() {
        assertFalse(this.customLinkedList.contains(14));
    }

    @Test
    public void containsShouldReturnFalseIfElementIsNotPresentInCollection() {
        this.customLinkedList.add(10);
        this.customLinkedList.add(12);
        this.customLinkedList.add(14);

        assertFalse(this.customLinkedList.contains(15));
    }


    @Test
    public void addingElementShouldAddCorrectly() {
        this.customLinkedList.add(12);

        assertTrue(this.customLinkedList.contains(12));
    }


    @Test
    public void indexOfShouldReturnCorrectValue() {
        for (int i = 0; i < 100; i++) {
            this.customLinkedList.add(i);
        }

        assertEquals(99, this.customLinkedList.indexOf(99));
    }

    @Test
    public void indexOfShouldReturnMinusOneIfElementIsNotPresent() {
        assertEquals(-1, this.customLinkedList.indexOf(-5));
    }
}
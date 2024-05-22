import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    @Test
    public void EveryBranchMethod(){
        //first test case
        RuntimeException ex;
        List<Item> items = null;
        ex = assertThrows(RuntimeException.class,()->SILab2.checkCart(items,0));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));
        //second test case
        List<Item> items1= Arrays.asList(new Item("Kniga", "C3-4", 450, 25.5f));
        ex = assertThrows(RuntimeException.class,()->SILab2.checkCart(items1,50));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));
        //third test case
        List<Item> items2= Arrays.asList(new Item("Platno", null, 490, 10.0f));
        ex = assertThrows(RuntimeException.class,()->SILab2.checkCart(items2,45));
        assertTrue(ex.getMessage().contains("No barcode!"));
        //fourth test case
        List<Item> items3 = Arrays.asList(new Item("Guma","0712",40,0.0f));
        assertTrue(SILab2.checkCart(items3,45));
        //fifth test case
        List<Item> items4 = Arrays.asList(new Item("","0512",500,0.0f));
        assertFalse(SILab2.checkCart(items4,30));
        //sixt test case
        List<Item> items5 = Arrays.asList(new Item("Atlas","4209",400,29.9f));
        assertFalse(SILab2.checkCart(items5,120));
    }
}
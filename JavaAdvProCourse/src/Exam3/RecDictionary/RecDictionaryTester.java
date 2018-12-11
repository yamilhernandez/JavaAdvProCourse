package Exam3.RecDictionary;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class RecDictionaryTester {

    RecDictionary d1 = new RecDictionary();
    RecDictionary d2 = new RecDictionary();
    RecDictionary d3 = new RecDictionary();
    RecDictionary d4 = new RecDictionary();
    RecDictionary d5 = new RecDictionary();


    public void addWords1() {
        d1.getDictionary().add("for");
        d1.getDictionary().add("nand");
        d1.getDictionary().add("queue");
        d1.getDictionary().add("for");
        d1.getDictionary().add("polymorphism");
        d1.getDictionary().add("while");
        d1.getDictionary().add("for");
        d1.getDictionary().add("superclass");
        d1.getDictionary().add("protected");
    }

    public void addWords2() {
        d2.getDictionary().add("nand");
        d2.getDictionary().add("IndexOutOfBoundsException");
        d2.getDictionary().add("queue");
        d2.getDictionary().add("polymorphism");
        d2.getDictionary().add("IndexOutOfBoundsException");
        d2.getDictionary().add("IndexOutOfBoundsException");
        d2.getDictionary().add("IndexOutOfBoundsException");
        d2.getDictionary().add("while");
        d2.getDictionary().add("for");
        d2.getDictionary().add("superclass");
        d2.getDictionary().add("protected");
        d2.getDictionary().add("IndexOutOfBoundsException");
    }

    public void addWords3(){
        d3.getDictionary().add("protected");
        d3.getDictionary().add("superclass");
        d3.getDictionary().add("for");
        d3.getDictionary().add("while");
        d3.getDictionary().add("polymorphism");
        d3.getDictionary().add("for");
        d3.getDictionary().add("queue");
        d3.getDictionary().add("nand");
        d3.getDictionary().add("for");
    }

    public void addWords4() {
        d4.getDictionary().add("for");
        d4.getDictionary().add("nand");
        d4.getDictionary().add("queue");
        d4.getDictionary().add("for");
        d4.getDictionary().add("polymorphism");
        d4.getDictionary().add("while");
        d4.getDictionary().add("for");
        d4.getDictionary().add("superclass");
        d4.getDictionary().add("protected");
    }

    public void addWords5() {
        d5.getDictionary().add("nand");
        d5.getDictionary().add("queue");
        d5.getDictionary().add("polymorphism");
        d5.getDictionary().add("while");
        d5.getDictionary().add("for");
        d5.getDictionary().add("superclass");
        d5.getDictionary().add("protected");
    }


    @Test
    public void testRecursivePageSearch() {
        addWords1();
        addWords2();

        assertTrue("Must return -1", d3.pageSearch("") == -1);
        assertTrue("Doesn't exist", d1.pageSearch("exception") == -1);
        assertTrue("Returns incorrect page", d1.pageSearch("while") == 5);
        assertTrue("Returns incorrect page", d2.pageSearch("polymorphism") == 3);
        assertNotEquals(d2.pageSearch("protected"), 5);
        assertEquals(d2.pageSearch("superclass"), 9);

    }

    @Test
    public void testReverseDictionary() {
        addWords1();
        addWords3();
        addWords4();

        d5.reverseDictionary();
        d1.reverseDictionary();
        d4.reverseDictionary();

        assertTrue("Dictionary is Empty", d5.reverseDictionary() == null);
        assertTrue("Dictionary is not Empty", d1.reverseDictionary() != null);
        assertTrue(d3.equals(d4));
        assertNotEquals(d3 , d1);    
    }

    @Test
    public void testRecursiveRemoveAllTargets() {
        addWords1();
        addWords3();
        addWords2();
        addWords4();
        assertTrue("Dictionary did not eliminated duplicates", d3.removeAllTargets("for") == 3);
        assertFalse("Dictionary eliminated duplicates", d3.removeAllTargets("for") == 1);
        assertNotEquals(d5.removeAllTargets("nand"), 20); //list is still empty
        assertTrue("Dictionary did not eliminate duplicates", d4.removeAllTargets("polymorphism") == 1);
        assertEquals(d2.removeAllTargets("IndexOutOfBoundsException"), 5);
    }
    
    @Test
    public void testRemoveCharAT() {
        addWords1();
        
        assertTrue(d1.removeCharAt(d1.getDictionary().get(0), 'o').equals("fr"));
        assertTrue(d1.removeCharAt(d1.getDictionary().get(2), 'u').equals("qee"));
        assertFalse(d1.removeCharAt(d1.getDictionary().get(5), 'w').equals("wile"));
        assertTrue(d1.removeCharAt(d1.getDictionary().get(4), 'm').equals("polyorphis"));
        assertEquals(d1.removeCharAt(d1.getDictionary().get(7), 's'), "upercla" );
        assertNotEquals(d1.removeCharAt(d1.getDictionary().get(8), 'o'), "protctd");

    }
}

package Exam3.RecDictionary;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Dictionary.java is a special dictionary with coding words which you'll
 *  use your whole career as a programmer. 
 * The following class gives you access to the dictionary in many 
 * different ways for information such as the page where the word's 
 * at (index), if the word exist, etc.
 * The objective is to complete the tasks so the dictionary works perfectly. 
 * 
 * Important: If you've never worked with ArrayLists before, it's 
 * recommended to study the API of ArrayList before
 * And remember, most of these (if not all) can be solved iteratively 
 * but should be solved recursively for practice. 
 * 
 * @author Maria Novoa
 * @author Luis Rivera
 *
 */

public class RecDictionary {

    private ArrayList<String> dictionary;

    public RecDictionary(ArrayList<String> dictionary) {
        this.dictionary = dictionary;
    }

    public RecDictionary() {
        this.dictionary = new ArrayList<String>();
    }

    public ArrayList<String> getDictionary(){
        return dictionary;
    }

    /**
     * Overrides from the class Object to check if the dictionary sent 
     * and the this are actually the same.
     *
     * @param other
     * 
     * Note that instanceOf makes sure that the object sent is an 
     * instance of the class (You'll see this later on class)
     */

    @Override
    public boolean equals(Object other) {
        if(other == null) 
            return false;
        if(!(other instanceof RecDictionary))
            return false;

        RecDictionary dother = (RecDictionary) other;

        if(this.dictionary.size() != dother.dictionary.size())
            return false;
        for (int i = 0; i < this.dictionary.size(); i++) {
            if(!(this.dictionary.get(i).equals(dother.dictionary.get(i))))
                return false;
        }
        return true;
    }

    /*
     * This method takes a given string and a given character 
     * and removes all occurrences of the character
     * from the string. 
     * 
     * Returns the modified string. 
     * 
     * Note: Must be recursive! 
     * Hint: No helper method needed. 
     */
    
    public String removeCharAt(String word, char ch) {
    	return null;    
	}

    /**
     * PageSeach method search for the page (index) where the first
     * occurrence of a word is at. It should return -1 if the 
     * dictionary is empty or the word doesn't exist.
     * Else return the page number.
     * 
     * Note: Must be recursive!
     * 
     * Hint: A helper method might be useful.
     * 
     * @param target
     * @return the page where the target is found
     */

    public int pageSearch(String target){
        return 0; 
    }


    /**
     * Reverse Dictionary method returns a new dictionary 
     * almost the same as the original except that it has 
     * to be in a different order. The word at end now has
     * to be the first position and the first must go 
     * to the last position and successively.
     * 
     * Return null if the dictionary is empty.
     * 
     * Note: Must be recursive and no new data structure can be created!
     * 
     * Hint: A helper method can be useful.
     * 
     * @return the reversed dictionary
     */ 
    
    public ArrayList<String> reverseDictionary(){
        return dictionary;
    }

    /** 
     * Removes the target string(s) from the list. 
     * Note: Must be recursive and new data structures can't be created!
     * Hint: May need a helper method. 
     * 
     * @param the string to find and remove
     * @return the amount of targets removed, if any.
     */
    public int removeAllTargets(String target) {
        return 0;
    }
    
    /**
     * Compares two strings and returns the appropriate result
     * @param strings to compare
     * @return 0 iff string 1 == string 2
     *            >1 iff string 1 > string 2
     *            <1 iff string 1 < string 2
     */
    public static class StringComparator implements Comparator<String> { 
        public int compare(String s1, String s2) { 
            return s1.compareTo(s2); 
        } 
    }
}
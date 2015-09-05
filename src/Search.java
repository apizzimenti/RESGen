
import java.util.regex.*;
import java.util.ArrayList;
// import javafx.scene.text.TextFlow;

/**
 * 
 * @author Anthony Pizzimenti
 */

public class Search {
    
    private final String location;
    private final String context;
    private final ArrayList<Integer> indices = new ArrayList<>();
    
    public Search(String init, String initContext) {
        location = init;
        context = initContext;
    }
    
    public void findLocations() {
        // takes out chunks of the context in lengths of 6 characters
        String currentLocation;
        String matcher;
        
        for (int i = 0; i < context.length() / 6; i += 6) {
            currentLocation = context.substring(i, i + 6);
            
            for (int j = 0; j < 3; j++) {
                // generates a String for regex testing
                char[] matchgenerator= location.toCharArray();
                matchgenerator[j] = '.';
                matchgenerator[j + 3] = '.';
                
                matcher = new String(matchgenerator);
                
                if (Pattern.matches(matcher, currentLocation)) {
                    indices.add(i);
                }
            }
        }
    }
    
    @Override
    public String toString() {
        String e = "";
        for (int x : indices) {
            e += x + ", ";
        }
        return e;
    }
}
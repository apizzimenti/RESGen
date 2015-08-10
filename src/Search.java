
import java.util.regex.*;
import java.util.ArrayList;
import javafx.scene.text.Text;
// import javafx.scene.text.TextFlow;

/**
 * 
 * @author Anthony Pizzimenti
 */

public class Search {
    
    /**
     * @param initacids list of acids as transcribed by the Codon class
     * @param indexList list of indices at which the function finds a positive match
     * @param origBases String of original base pairs used for comparison
     * @param location String literal of base pair insertion locations
     * @param length length of location
     */
	
	private final String[] initacids;
    private final ArrayList<Integer> indexList = new ArrayList<>();
    private final Text origBases;
	private final String location;
	
	public Search(String[] arr, String initlocation, String orig) {
		initacids = arr;
		location = initlocation;
        origBases = new Text(orig);                         
  	}
	
	public void searchforLocations() {
        
        // Searches through base pairs to find potential cutting spots
		
		for (int i = 0; i < 3; i++) {
            char[] local = location.toCharArray();
			local[i] = '.';
			local[i + 3] = '.';

            String matcher = new String(local);
                
            for (int j = 0; j < origBases.toString().length() / 6; j++) {
                String acidforMatch = origBases.toString().substring(j, j + 6);
                if (Pattern.matches(matcher, acidforMatch)) {
                    indexList.add(j);
                }
            }
        }
	}

    @Override
    public String toString() {
        String returner = "";
        
        for(int x : indexList) {
            returner += x + "\n";
        }
        
        return returner;
    }
}

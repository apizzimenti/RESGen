
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Driver for Codon objects and associated Search functions
 * @author Anthony Pizzimenti
 * @version 0.0.7 July 28, 2015
 */

public class Skin extends Application {
	
	/**
     * @param sqn inputted DNA sequence
	 * @param initialText TextArea for outputted text
	 */
    
	private String sqn;
	private final TextArea initialText = new TextArea();
    
    @Override
	public void start(Stage primaryStage) {
		
		// text area for pasting big sequence
		initialText.setPrefColumnCount(75);
		initialText.setPrefRowCount(10);
		initialText.setWrapText(true);
		initialText.setId("initialText");
		initialText.getStyleClass().add("textarea");
		initialText.setPromptText("base pair sequence");
        initialText.setText(randomBases());
        
		// create area for inputting frame
		TextField framearea = new TextField();
		framearea.setId("framearea");
		framearea.getStyleClass().add("textarea");
		framearea.setAlignment(Pos.TOP_CENTER);
		framearea.setPromptText("frame (1, 2, or 3)");
		
		// create area for inputting location length
		TextField locationarea = new TextField();
		locationarea.setId("locationarea");
		locationarea.getStyleClass().add("textarea");
		locationarea.setAlignment(Pos.TOP_CENTER);
		locationarea.setPromptText("restriction site base pair sequence");
		
		// button for initializing search/transposing text
		Button begin = new Button("Find Insertion Points");
		begin.setId("begin");
		
		// text area for indicating matching sequences
		TextArea solutions = new TextArea();
		solutions.setId("solutions");
		solutions.getStyleClass().add("textarea");
		solutions.setEditable(false);
		solutions.setWrapText(true);
		
		// button event handler
		begin.setOnAction((ActionEvent event) -> {
            sqn = initialText.getText();
            int frame = Integer.parseInt(framearea.getText());
            Codon x = new Codon(sqn.length(), sqn, frame);
            x.read();
            
            /* Search y = new Search(x.getAcids(), locationarea.getText(), sqn);
            y.searchforLocations(); */
            
            //solutions.setText(y.toString());
            
            solutions.setText(x.toString());
        });
		
		// create layout
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_LEFT);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setId("layout");
		grid.add(initialText, 1, 1);
		grid.add(framearea, 1, 2);
		grid.add(locationarea, 1, 3);
		grid.add(begin, 1, 4);
		grid.add(solutions, 1, 5);
		
		// create scene
		Scene scene = new Scene(grid, 400, 500);
		scene.getStylesheets().add("styles.css");
		primaryStage.setTitle("ResGen build 0.0.6");
		primaryStage.getIcons().add(new Image("icon.png"));
		primaryStage.setScene(scene);
		primaryStage.show();
	}
    
    public String randomBases() {
        String[] bases = {"A", "C", "T", "G"};
        String returner = "";
        
        for (int i = 0; i < 100; i++) {
            int t = (int)(Math.random() * 4);
            returner += bases[t];
        }
        return returner;
    }
	
	public static void main(String[]args) {
		launch(args);
	}
}
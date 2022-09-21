/**
 * The Purpose of this project is to create a periodic table for fun i guess
 * @author Porter Youngman
 * Date Last Modified 9/21/22
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PeriodicTable extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	private Button[] btns = new Button[10];
	private String[] symbols = {"H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne"};
	private BorderPane table = new BorderPane();
	
	private void createButtons() {
		for (int x=0; x<symbols.length; x++) {
			btns[x] = new Button(symbols[x]);
			btns[x].setPrefSize(50, 50);
		}
	}
	
	private int buildTable(BorderPane row, int index, int rowNum) {
		HBox tempLeft = new HBox();
		HBox tempCenter = new HBox();
		HBox tempRight = new HBox();
		if (rowNum == 1) {
			row.setLeft(btns[index]);
			index++;
			row.setRight(btns[index]);
			return index;
		}
		else if (rowNum >= 2 && rowNum <= 3) {
			for(int x=index; x<index+8; x++) {
				if (x<(2+index))
					tempLeft.getChildren().add(btns[x]);
				else
					tempRight.getChildren().add(btns[x]);
			}
			row.setLeft(tempLeft);
			row.setRight(tempRight);
			return index+8;
		}
		else if (rowNum >=4 && rowNum <= 5) {
			for(int x=index; x<index+18; x++) {
				if (x<2)
					row.setLeft(btns[x]);
				else if (x<12)
					row.setCenter(btns[x]);
				else
					row.setRight(btns[x]);
			}
		}
		return index;
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane lmao = new BorderPane();
		createButtons();
		//Label text = new Label("Test");
		VBox pTable = new VBox();
		BorderPane row1 = new BorderPane();
		BorderPane row2 = new BorderPane();
		BorderPane row3 = new BorderPane();
		//BorderPane row4 = new BorderPane();
		
		buildTable(row1, 0, 1);
		buildTable(row2, 2, 2);
		
		

		pTable.getChildren().addAll(row1, row2);
		
		

//		Button h = new Button("H");
//		Button li = new Button("Li");
//		Button na = new Button("Na");
//		h.resize(100, 100);
		
		
		
		
//		col1.getChildren().add(h);
//		col1.getChildren().add(text);
//		col1.getChildren().add(new Label("d"));
//		col1.getChildren().add(new Label("f"));
//		pTable.getChildren().add(col1);
//		pTable.getChildren().add(new VBox(new Label("g")));
		lmao.setCenter(pTable);
		
		
		Scene scene = new Scene(lmao,400,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Periodic Table");
		primaryStage.show();
	}

}

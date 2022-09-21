/**
 * The Purpose of this project is to create a periodic table for fun i guess
 * @author Porter Youngman
 * Date Last Modified 9/21/22
 */
import javafx.application.Application;
import javafx.geometry.Pos;
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
	
	private Button[] btns = new Button[36];
	private String[] symbols = {"H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na","Mg","Al","Si","P","S","Cl","Ar","K","Ca","Sc","Ti","V","Cr","Mn","Fe","Co","Ni","Cu","Zn","Ga","Ge","As","Se","Br","Kr"};
	private BorderPane table = new BorderPane();
	private VBox leftTable = new VBox();
	private VBox centerTable = new VBox();
	private VBox rightTable = new VBox();

	
	
	private void createButtons() {
		for (int x=0; x<symbols.length; x++) {
			btns[x] = new Button(symbols[x]);
			btns[x].setPrefSize(50, 50);
		}
	}
	
	private int buildTable(int index, int rowNum) {
		HBox tempLeft = new HBox();
		HBox tempCenter = new HBox();
		HBox tempRight = new HBox();
		if (rowNum == 1) {
			leftTable.getChildren().add(btns[index]);
			index++;
			rightTable.getChildren().add(btns[index]);
			return index;
		}
		else if (rowNum >= 2 && rowNum <= 3) {
			for(int x=index; x<index+8; x++) {
				if (x<(2+index))
					tempLeft.getChildren().add(btns[x]);
				else
					tempRight.getChildren().add(btns[x]);
			}
			leftTable.getChildren().add(tempLeft);
			rightTable.getChildren().add(tempRight);
			return index+8;
		}
		else if (rowNum >=4 && rowNum <= 5) {
			for(int x=index; x<index+18; x++) {
				if (x<2+index)
					tempLeft.getChildren().add(btns[x]);
				else if (x<12+index)
					tempCenter.getChildren().add(btns[x]);
				else
					tempRight.getChildren().add(btns[x]);
			}
			leftTable.getChildren().add(tempLeft);
			centerTable.getChildren().add(tempCenter);
			rightTable.getChildren().add(tempRight);
			return index+18;
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
		
		buildTable(0, 1);
		buildTable(2, 2);
		buildTable(10,3);
		buildTable(18,4);
		
		

//		pTable.getChildren().addAll(row1, row2);
		
		

//		lmao.setCenter(pTable);
		
		table.setLeft(leftTable);
		table.setCenter(centerTable);
		table.setRight(rightTable);
		leftTable.setAlignment(Pos.BOTTOM_LEFT);
		centerTable.setAlignment(Pos.BOTTOM_CENTER);
		rightTable.setAlignment(Pos.BOTTOM_RIGHT);
		
		Scene scene = new Scene(table,900,500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Periodic Table");
		primaryStage.show();
	}

}

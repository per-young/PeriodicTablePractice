/**
 * The Purpose of this project is to create a periodic table for fun i guess
 * @author Porter Youngman
 * Date Last Modified 9/21/22
 */
import java.io.File;
//import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PeriodicTable extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	private Button[] btns = new Button[54]; // so far only added buttons up to Xe
	private String[] symbols = new String[118];
	private BorderPane table = new BorderPane();
	private VBox leftTable = new VBox();
	private VBox centerTable = new VBox();
	private VBox rightTable = new VBox();

	
	
	private void createButtons() {
		// Creates array from csv file
		try {
			Scanner input = new Scanner(new File("Elements.csv"));
			for (int x=0; input.hasNext(); x++) {
				symbols[x] = input.next();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for (int x=0; x<btns.length; x++) {
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
			index++;
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
		
		createButtons();
		int temp = 0;
		for (int x=1; x<=5; x++) {
			temp = buildTable(temp,x);
		}
		
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

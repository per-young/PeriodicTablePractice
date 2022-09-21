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
	private Button[] btns = new Button[4];
	private String[] symbols = {"H", "He", "Li", "Be",};
	private void createTable() {
		for (int x=0; x<symbols.length; x++) {
			btns[x] = new Button(symbols[x]);
			btns[x].setPrefSize(50, 50);
		}
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane lmao = new BorderPane();
		createTable();
		Label text = new Label("Test");
		VBox pTable = new VBox();
		HBox row1 = new HBox();
		HBox row2 = new HBox();
		HBox row3 = new HBox();
		
		row1.getChildren().add(btns[0]);
		row1.getChildren().add(btns[1]);
		pTable.getChildren().add(row1);
		
		
//		for(int x=2; x<10; x++) {
//			pTable.getChildren().add(btns[x]);
//		}
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

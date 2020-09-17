package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class main extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<model.team> teamsList = new ArrayList<model.team>();
		ArrayList<model.player> playersList = new ArrayList<model.player>();
		ArrayList<model.manager> managersList = new ArrayList<model.manager>();
		
		Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        
        Label firstname = new Label("First Name:");
        TextField firstnameBox = new TextField();
        Label middlename = new Label("Middle Name:");
        TextField middlenameBox = new TextField();
        Label lastname = new Label("Last Name:");
        TextField lastnameBox = new TextField();
        
        Label phone = new Label("Phone:");
        TextField phoneBox = new TextField();
        
        Label email = new Label("e-Mail:");
        TextField emailBox = new TextField();
        
        Label team = new Label("Team:");
        ComboBox teamBox = new ComboBox();
        teamBox.getItems().addAll(teamsList);
        
        Label role = new Label("Role:");
        ComboBox roleBox = new ComboBox();
        roleBox.getItems().addAll("player", "manager");
        
        Label output = new Label("Output");
        TextArea outputField = new TextArea();
         
        TabPane tabPane = new TabPane();
        BorderPane mainPane = new BorderPane();
		
		primaryStage.setTitle("Teams App");
		Group root = new Group();
		Scene scene = new Scene(root, 750, 500);
		
		Button btnAdd = new Button("Add");
        HBox hBtnAdd = new HBox(10);
        hBtnAdd.setAlignment(Pos.BOTTOM_RIGHT);
        hBtnAdd.getChildren().add(btnAdd);
        
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				String readFirstName = firstnameBox.getText();
				String readMiddleName = middlenameBox.getText();
				String readLastName = lastnameBox.getText();
				model.name newName = new model.name(readFirstName, readMiddleName, readLastName);
				String readPhone = phoneBox.getText();
				String readMail = emailBox.getText();
				String readRole = roleBox.getPromptText();
				Object readTeam = teamBox.getValue();
				
				if (readRole == "manager") {
					String dob = null;
					int stars = 0;
					TextInputDialog dobDialog = new TextInputDialog();
					dobDialog.setContentText("Enter the manager's date of birth");
					Optional<String> result = dobDialog.showAndWait();
					if (result.isPresent()) {
						dob = result.get();
					}
					TextInputDialog starsDialog = new TextInputDialog();
					starsDialog.setContentText("Enter star rating");
					Optional<String> starsResult = starsDialog.showAndWait();
					if (starsResult.isPresent()){
					   String getStars = starsResult.get();
					   stars = Integer.parseInt(getStars);
					}
					
					model.manager newManager = new model.manager(newName, readPhone, readMail);
					newManager.setTeam((model.team) readTeam);
					((model.team) readTeam).setManager(newManager);
					newManager.setDob(dob);
					newManager.setStars(stars);
					managersList.add(newManager);
					System.out.println(newManager.starsToString());
				}
				else {
					boolean isGoalie = false;
					int goals = 0;
					ChoiceDialog<String> isGoalieDialog = new ChoiceDialog<>("Yes", "No");
					isGoalieDialog.setContentText("Is the player a goalie?");
					Optional<String> result = isGoalieDialog.showAndWait();
					if (result.toString() == "Yes") {
						isGoalie = true;
					}
					TextInputDialog goalsDialog = new TextInputDialog();
					goalsDialog.setContentText("Enter number of goals");
					Optional<String> goalsResult = goalsDialog.showAndWait();
					if (goalsResult.isPresent()){
					   String getGoals = goalsResult.get();
					   goals = Integer.parseInt(getGoals);
					}
					model.player newPlayer = new model.player(newName, readPhone, readMail, goals, isGoalie, readTeam);
					((model.team) readTeam).setPlayer(newPlayer);
					playersList.add(newPlayer);
					System.out.println(newPlayer.toString());
				}
				
			}
        	
        });
        
        Button btnRemove = new Button("Remove");
        HBox hBtnRemove = new HBox(10);
        hBtnRemove.setAlignment(Pos.BOTTOM_LEFT);
        hBtnRemove.getChildren().add(btnRemove);
        
        btnRemove.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				ChoiceDialog<String> chooseDialog = new ChoiceDialog<>("Player", "Manager");
				chooseDialog.setContentText("Player or manager?");
				
			}
        	
        });
        
        Label database = new Label ("Database");
        Label datadash = new Label ("========");
        
        Button btnSave = new Button("Export");
        HBox hBtnSave = new HBox(10);
        hBtnSave.setAlignment(Pos.BOTTOM_LEFT);
        hBtnSave.getChildren().add(btnSave);
        
        btnSave.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        
        Button btnLoad = new Button("Import");
        HBox hBtnLoad = new HBox(10);
        hBtnLoad.setAlignment(Pos.BOTTOM_LEFT);
        hBtnLoad.getChildren().add(btnLoad);
        
        btnLoad.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        
        
        Tab manageTab = new Tab();
        manageTab.setText("Manage");
        GridPane grid = new GridPane();
		grid.setAlignment(Pos.BASELINE_LEFT);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
	    grid.add(firstname, 0, 1);
	    grid.add(firstnameBox, 1, 1);
	    grid.add(middlename, 0, 2);
	    grid.add(middlenameBox, 1, 2);
	    grid.add(lastname, 0, 3);
	    grid.add(lastnameBox, 1, 3);
	    grid.add(phone, 2, 1);
	    grid.add(phoneBox, 3, 1);
	    grid.add(email, 2, 2);
	    grid.add(emailBox, 3, 2);
	    grid.add(team, 4, 1);
	    grid.add(teamBox, 5, 1);
		grid.add(role, 4, 2);
		grid.add(roleBox, 5, 2);
		grid.add(hBtnAdd, 2, 3);
		grid.add(hBtnRemove, 3, 3);
		grid.add(database, 0, 5);
		grid.add(datadash, 0, 6);
		grid.add(hBtnSave, 0, 7);
		grid.add(hBtnLoad, 1, 7);
		VBox manageBox = new VBox();
	    manageBox.getChildren().add(grid);
	    manageTab.setContent(manageBox);
	    tabPane.getTabs().add(manageTab);
	    
	    Tab sumTab = new Tab();
	    sumTab.setText("Summary");
	    VBox sumBox = new VBox();
	    GridPane sumGrid = new GridPane();
	    sumGrid.setAlignment(Pos.BASELINE_LEFT);
	    sumGrid.setHgap(10);
	    sumGrid.setVgap(10);
	    sumGrid.setPadding(new Insets(25, 25, 25, 25));
	    sumGrid.add(output, 0, 1);
		sumGrid.add(outputField, 0, 2);
		sumBox.getChildren().add(sumGrid);
	    sumTab.setContent(sumBox);
	    tabPane.getTabs().add(sumTab);
	    
	    mainPane.setCenter(tabPane);
	    
	    mainPane.prefHeightProperty().bind(scene.heightProperty());
	    mainPane.prefWidthProperty().bind(scene.widthProperty());
	    
	    root.getChildren().add(mainPane);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}

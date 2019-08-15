
package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class CreateProfilePane extends BorderPane {

	CreateProfilePane() {
	
		
		//styling
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(30, 30, 30, 30));
		grid.setVgap(15);
		grid.setHgap(15);
		grid.setAlignment(Pos.CENTER);
		grid.setStyle("-fx-background-color: #91a0b8;");


		//create labels
		Label lblCourse = new Label ("Course");
		Label lblPNumber = new Label ("P Number");
		Label lblTitle = new Label("Title");
		Label lblStudentFName = new Label("First Name");
		Label lblStudentSName = new Label("Surname");
		Label lblEmail = new Label("Email");

		// setup combobox
		ObservableList<String> courseTitle = FXCollections.observableArrayList("Computer Science", "Software Engineering");
		ComboBox<String> course = new ComboBox<>(courseTitle);
		course.getSelectionModel().select(0);
		course.setVisibleRowCount(2);
		
		ObservableList<String> titles = FXCollections.observableArrayList("Mr", "Mrs", "Miss", "Ms", "Dr");
		ComboBox<String> title = new ComboBox<>(titles);
		title.getSelectionModel().select(0);
		title.setVisibleRowCount(4);

		
		// setup text fields
		TextField pNumber = new TextField();
		TextField studentFName = new TextField();
		TextField studentSName = new TextField();
		TextField studentEmail = new TextField();
		
		//add button

//		Button submit = new Button("Submit");
//		submit.setActionCommand(e -> SelectModulesPane());
		

		//add controls and labels to container
		grid.add(lblCourse, 0, 0);
		grid.add(course, 1, 0);

		grid.add(lblPNumber, 0, 1);
		grid.add(pNumber, 1 , 1);
		
		grid.add(lblTitle, 0, 2);
		grid.add(title, 1, 2);
		
		grid.add(lblStudentFName, 0, 3);
		grid.add(studentFName, 1, 3);
		
		grid.add(lblStudentSName, 0, 4);
		grid.add(studentSName, 1, 4);
		
		grid.add(lblEmail, 0, 5);
		grid.add(studentEmail, 1, 5);
		
//		grid.add(submit, 1, 6);
		
		this.setCenter(grid);
	}

}

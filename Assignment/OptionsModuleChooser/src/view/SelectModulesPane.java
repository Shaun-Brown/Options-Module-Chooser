package view;

import com.sun.javafx.geom.Rectangle;
import controller.OptionsModuleChooserController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.GridPane;
import java.util.List;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.FXCollections;



public class SelectModulesPane extends BorderPane {
//	ListView<String> listView;
	private TextArea moduleSpace1,moduleSpace2, moduleSpace11, moduleSpace22;

	SelectModulesPane() {

		moduleSpace1 = new TextArea();
		moduleSpace2 = new TextArea();
		moduleSpace11 = new TextArea();
		moduleSpace22 = new TextArea();

//		List<String> modules = new ArrayList<String>();


//		ObservableList<String> observableList = FXCollections.observableList(modules);

		VBox mod1 = new VBox();
		mod1.getChildren().set(0, moduleSpace1);
		mod1.getChildren().set(1, moduleSpace11);

		VBox mod2 = new VBox();
		mod2.getChildren().set(0, moduleSpace2);
		mod2.getChildren().set(1,moduleSpace22);

		TitledPane t1 = new TitledPane("Module 1", mod1);
		TitledPane t2 = new TitledPane("Module 2", mod2);
		Accordion accordion = new Accordion();
		accordion.getPanes().addAll(t1, t2);

		this.setCenter(accordion);
	}

	public void removeModuleHandler() {
	}

//	public retrieveCources setupAndRetrieveCourses(){
//		return (e-> controller.OptionsModuleChooserController());
//	}
}



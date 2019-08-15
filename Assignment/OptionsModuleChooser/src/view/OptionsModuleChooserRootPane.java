package view;

import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;


//You may change this class to extend another type if you wish
public class OptionsModuleChooserRootPane extends BorderPane {
	
	private ButtonPane bp;
	private CreateProfilePane cp;
	private ModuleMenuBar mmb;
	private SelectModulesPane sm;

	
	public OptionsModuleChooserRootPane() {
		
		this.setStyle("-fx-background-color: #11163a;");
		
		bp = new ButtonPane();
		cp = new CreateProfilePane();
		mmb = new ModuleMenuBar();
		sm = new SelectModulesPane();
		
		TabPane tab = new TabPane();
		Tab tab1 = new Tab("Input");
		Tab tab2 = new Tab("Modules");
		Tab tab3 = new Tab("Output");
		tab.getTabs().addAll(tab1, tab2, tab3);	

		tab1.setContent(cp);
		tab2.setContent(sm);
		
		
		BorderPane rootContainer = new BorderPane();
		rootContainer.setTop(tab);
		rootContainer.setCenter(cp);
		//padding around the entire root container
		rootContainer.setPadding(new Insets(50,50,50,50));
		
		this.setTop(mmb);
		this.setCenter(rootContainer);
		
	}
	
	public ModuleMenuBar getModuleMenuBar() {
		return mmb;
	}
	
	public ButtonPane getButtonPane() {
		return bp;
	}
	
	public CreateProfilePane getCreateProfilePane() {
		return cp;
	}

	public SelectModulesPane getSelectModulesPane() {
		return sm;
	}
}

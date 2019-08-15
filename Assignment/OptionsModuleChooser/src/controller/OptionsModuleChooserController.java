package controller;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Course;
import model.Delivery;
import model.Module;
//import model.Name;
import model.StudentProfile;
import view.ButtonPane;
import view.CreateProfilePane;
import view.ModuleMenuBar;
import view.OptionsModuleChooserRootPane;
import view.SelectModulesPane;


public class OptionsModuleChooserController {

    //fields to be used throughout the class
    private CreateProfilePane cp;
    private SelectModulesPane sm;
    private ButtonPane bp;
    private ModuleMenuBar mmb;
    private OptionsModuleChooserRootPane view;
    private StudentProfile model;

    public OptionsModuleChooserController(OptionsModuleChooserRootPane view, StudentProfile model) {
        //initialise model and view fields
        this.model = model;
        this.view = view;

        mmb = view.getModuleMenuBar();
        bp = view.getButtonPane();
        sm = view.getSelectModulesPane();
        cp = view.getCreateProfilePane();


        //populate combobox in create profile pane, e.g. if profilePane represented your create profile pane you could invoke the line below
//        SelectModulesPane.populateComboBoxWithCourses(setupAndRetrieveCourses());

        //attach event handlers to view using private helper method
        this.attachEventHandlers();

    }

    	private void attachEventHandlers() {
        	bp.addSubmitHandler(e -> new SubmitHandler());
        	bp.addClearHandler(new ClearHandler());
        	bp.addRestoreHandler(new RestoreHandler());
       	 	bp.addAddHandler(new AddHandler());
       	 	bp.addRemoveHandler(e -> sm.removeModuleHandler());

        	mmb.addLoadHandler(new LoadMenuHandler());
        	mmb.addSaveHandler(new SaveMenuHandler());
       	 	mmb.addExitHandler(e -> System.exit(0)); //example of lambda expression event handler
       	 	mmb.addAboutHandler(e -> this.alertDialogBuilder("Information Dialog", "Option Modules", "Module Chooser app v2.0")); //lambda uses internal dialog method - see end of class

//            sm.addsetupAndRetrieveCources(new setupAndRetrieveCources());
       		 //example of adding a change listener to a property in the view - the lambda uses the private helper method below
//			bp.addSelectionChangeListener((observable, oldValue, newValue) -> selectionChangeHandler(newValue));
    	}
        private class LoadMenuHandler implements EventHandler<ActionEvent> {
            public void handle(ActionEvent e) {
                //load in the data model
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(""));) {

                    model = (StudentProfile) ois.readObject(); //reads the model object back from a file

                    alertDialogBuilder("Information Dialog", "Load success", "");
                } catch (IOException ioExcep) {
                    System.out.println("Error loading");
                } catch (ClassNotFoundException c) {
                    System.out.println("Class Not found");
                }

                //refresh the view
                model.setCourseOfStudy(model.getCourseOfStudy());
            }
        }

        private class SaveMenuHandler implements EventHandler<ActionEvent> {
            public void handle(ActionEvent e) {
                //save the data model
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(""));) {

                    oos.writeObject(model); //writes the model object to a file
                    oos.flush();

                    alertDialogBuilder("Information Dialog", "Save success", "");
                } catch (IOException ioExcep) {
                    System.out.println("Error saving");
                }
            }
        }
            //helper method to build dialogs
        private void alertDialogBuilder(String title, String header, String content) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle(title);
            alert.setHeaderText(header);
            alert.setContentText(content);
            alert.showAndWait();
        }

        private class AddHandler implements EventHandler<ActionEvent> {
            public void handle(ActionEvent e) {
                //retrieves name from view

            }
        }
        private class SubmitHandler implements EventHandler<ActionEvent> {
                public void handle(ActionEvent e) {
                    model.setCourseOfStudy(model.getCourseOfStudy());
                }
            }

        private class ClearHandler implements EventHandler<ActionEvent> {
            public void handle(ActionEvent e) {
                if (bp.getSelectedChoice().equals("Computer Science")) {
                } else if (bp.getSelectedChoice().equals("Software Engineering")) {
                }
            }
        }


        private class RestoreHandler implements EventHandler<ActionEvent> {
                public void handle(ActionEvent e) {
                    if (bp.getSelectedChoice().equals("Computer Science")) {
                        model.setCourseOfStudy(model.getCourseOfStudy());

                    }
                }
        }

        private Course[] setupAndRetrieveCourses() {
            Module imat3423 = new Module("IMAT3423", "Systems Building: Methods", 15, true, Delivery.TERM_1);
            Module imat3451 = new Module("IMAT3451", "Computing Project", 30, true, Delivery.YEAR_LONG);
            Module ctec3902_SoftEng = new Module("CTEC3902", "Rigorous Systems", 15, true, Delivery.TERM_2);
            Module ctec3902_CompSci = new Module("CTEC3902", "Rigorous Systems", 15, false, Delivery.TERM_2);
            Module ctec3110 = new Module("CTEC3110", "Secure Web Application Development", 15, false, Delivery.TERM_1);
            Module ctec3426 = new Module("CTEC3426", "Telematics", 15, false, Delivery.TERM_1);
            Module ctec3605 = new Module("CTEC3605", "Multi-service Networks 1", 15, false, Delivery.TERM_1);
            Module ctec3606 = new Module("CTEC3606", "Multi-service Networks 2", 15, false, Delivery.TERM_2);
            Module ctec3410 = new Module("CTEC3410", "Web Application Penetration Testing", 15, false, Delivery.TERM_2);
            Module ctec3904 = new Module("CTEC3904", "Functional Software Development", 15, false, Delivery.TERM_2);
            Module ctec3905 = new Module("CTEC3905", "Front-End Web Development", 15, false, Delivery.TERM_2);
            Module ctec3906 = new Module("CTEC3906", "Interaction Design", 15, false, Delivery.TERM_1);
            Module imat3410 = new Module("IMAT3104", "Database Management and Programming", 15, false, Delivery.TERM_2);
            Module imat3406 = new Module("IMAT3406", "Fuzzy Logic and Knowledge Based Systems", 15, false, Delivery.TERM_1);
            Module imat3611 = new Module("IMAT3611", "Popular Technology Ethics", 15, false, Delivery.TERM_1);
            Module imat3613 = new Module("IMAT3613", "Data Mining", 15, false, Delivery.TERM_1);
            Module imat3614 = new Module("IMAT3614", "Big Data and Business Models", 15, false, Delivery.TERM_2);
            Module imat3428_CompSci = new Module("IMAT3428", "Information Technology Services Practice", 15, false, Delivery.TERM_2);

            Course compSci = new Course("Computer Science");
            compSci.addModuleToCourse(imat3423);
            compSci.addModuleToCourse(imat3451);
            compSci.addModuleToCourse(ctec3902_CompSci);
            compSci.addModuleToCourse(ctec3110);
            compSci.addModuleToCourse(ctec3426);
            compSci.addModuleToCourse(ctec3605);
            compSci.addModuleToCourse(ctec3606);
            compSci.addModuleToCourse(ctec3410);
            compSci.addModuleToCourse(ctec3904);
            compSci.addModuleToCourse(ctec3905);
            compSci.addModuleToCourse(ctec3906);
            compSci.addModuleToCourse(imat3410);
            compSci.addModuleToCourse(imat3406);
            compSci.addModuleToCourse(imat3611);
            compSci.addModuleToCourse(imat3613);
            compSci.addModuleToCourse(imat3614);
            compSci.addModuleToCourse(imat3428_CompSci);

            Course softEng = new Course("Software Engineering");
            softEng.addModuleToCourse(imat3423);
            softEng.addModuleToCourse(imat3451);
            softEng.addModuleToCourse(ctec3902_SoftEng);
            softEng.addModuleToCourse(ctec3110);
            softEng.addModuleToCourse(ctec3426);
            softEng.addModuleToCourse(ctec3605);
            softEng.addModuleToCourse(ctec3606);
            softEng.addModuleToCourse(ctec3410);
            softEng.addModuleToCourse(ctec3904);
            softEng.addModuleToCourse(ctec3905);
            softEng.addModuleToCourse(ctec3906);
            softEng.addModuleToCourse(imat3410);
            softEng.addModuleToCourse(imat3406);
            softEng.addModuleToCourse(imat3611);
            softEng.addModuleToCourse(imat3613);
            softEng.addModuleToCourse(imat3614);

            Course[] courses = new Course[2];
            courses[0] = compSci;
            courses[1] = softEng;

            return courses;
        }


}

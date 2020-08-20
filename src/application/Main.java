package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.MainViewController;
import view.SampleViewController;
import java.lang.UnsupportedOperationException;

import controller.VirtualKanbanController;



public class Main extends Application {

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param primaryStage
 	 */
    @Override
    public void start(Stage primaryStage) {
        try {
        	VirtualKanbanController virtualKanbanController = new VirtualKanbanController();
        	
            MainViewController mainViewController = new MainViewController(virtualKanbanController);
            Scene scene = new Scene(mainViewController, 1600, 800);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();

            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    try {
                        virtualKanbanController.getIOController().save();
                    }
                    catch (Exception exception) {
                        System.out.println("Speichern fehlgeschlagen!");
                        System.out.println(exception.toString());
                    }
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param args
 	 */
    public static void main(String[] args) {
        launch(args);
    }
}

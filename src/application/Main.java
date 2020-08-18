package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.SampleViewController;
import java.lang.UnsupportedOperationException;

public class Main extends Application {

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param primaryStage
 	 */
    @Override
    public void start(Stage primaryStage) {
        try {
            SampleViewController sampleViewController = new SampleViewController();
            Scene scene = new Scene(sampleViewController, 400, 200);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
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

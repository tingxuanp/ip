package bestie;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * A GUI for bestie using FXML.
 */
public class Main extends Application {

    private Bestie bestie = new Bestie("bestie.txt");

    /**
     * Initialised the main stage of the Bestie application, loads the FXML layout for the main window.
     * Injects the Bestie instance into the controller to enable functionality.
     *
     * @param stage primary stage for this application, onto which the application scene can be set.
     */
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            assert fxmlLoader.getLocation() != null : "FXML file could not be found";

            AnchorPane ap = fxmlLoader.load();
            assert ap != null : "Loaded AnchorPane is null";

            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.setTitle("Bestie: Your personal assistant chatbot");
            stage.setMinHeight(400);
            stage.setMinWidth(450);
            // inject the Bestie instance
            fxmlLoader.<MainWindow>getController().setBestie(bestie);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

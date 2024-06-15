package MVC;

import Utils.ImageActionUtil;
import Utils.ImageSaveUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.nio.file.Paths;
import java.util.Objects;

/**
 *
 *
 * <p> This class defines the entrypoint of the program. It loads the main menu
 * FXML to give the main menu in the
 * JavaFX framework
 * </p>
 * @author Brandon
 * **/
public class MainMenu extends Application {

    /**
     * <p> This public override function allows the program to setup its first
     * scene and keep the model from the MVC
     * across all interfaces and so the data in the model is not reset for
     * every scene change
     * </p>
     * @param primaryStage Takes in needed Stage to construct window -
     *                     Type Stage
     *
     * **/

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainMenu.class.getResource("MainMenu.fxml").
                toURI().toURL());
        loader.setControllerFactory(Class->new SwitchController(
                new SnakeModel()));

        primaryStage.getIcons().add(new Image(Objects.requireNonNull(MainMenu.
                class.getResourceAsStream("snakeHeadlogo.png"))));
        primaryStage.setScene(new Scene(loader.load()));

        primaryStage.getScene().getRoot().requestFocus();
        primaryStage.setResizable(false);
        primaryStage.show();

    }
    /**
     * <p> The main function found in every java program. This launches the
     * program
     * </p>
     * @param args Takes String[] args, useless for this program - Type String
     * **/
    public static void Main(String[] args){

        launch(args);

    }
}

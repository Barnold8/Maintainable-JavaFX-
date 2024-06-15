package MVC;

import Mechanics.Tree;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Mechanics.State;
import Utils.FileIO;
import Utils.Json_Game;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * <p> This class is the controller for the GUI. This controls all the stuff
 * that happens out of the game on the UI
 * level.
 * </p>
 *@author Brandon
 * **/
public class SwitchController implements Initializable {
    // Used souly for switching scenes and
    // handling utility GUI operations

    // FXML bloat
    @FXML
    private Label m_score_1;
    @FXML
    private Label m_score_2;
    @FXML
    private Label m_score_3;
    @FXML
    private Label m_score_4;
    @FXML
    private Label m_score_5;
    @FXML
    private ImageView m_theme_forward;
    @FXML
    private ImageView m_theme_backward;
    @FXML
    private ImageView m_snake_Head;
    @FXML
    private Text m_score_text;
    @FXML
    private AnchorPane m_game_anchor;
    @FXML
    private ImageView m_game_background;
    @FXML
    private Canvas m_game_canvas;
    @FXML
    private Text m_game_OVER;
    @FXML
    private Button m_end_Button;
    @FXML
    private Text m_Theme_Info;
    @FXML
    private Text m_HS_info;
    @FXML
    private TextField m_USER_NAME;
    @FXML
    private ImageView m_Level_Preview;
    @FXML
    private CheckBox m_Dasher;
    @FXML
    private  CheckBox m_Enemy_Attack;

    @FXML
    private ToggleGroup m_SnakeCols;

    // FXML bloat
    private Stage m_stage;
    private Scene m_scene;
    private int m_themeSelect;
    private int m_levelSelect;
    private final SnakeModel m_model;
    private String m_themePath;
    private String m_levelPath;


    /**
     * <p>   This function sets the colour of the snake, this is dependant on
     * the radio buttons on the theme select screen
     * </p>
     *
     * **/
    public void SetCols(){
        m_model.SetM_Selected((RadioButton) m_SnakeCols.getSelectedToggle());
    }
    /**
     * <p>   This function applies the color to the snake grabbing the
     * relevant information from the model
     * </p>
     *
     * **/
    public void ApplyCols(){
        ColorAdjust cols = new ColorAdjust();
        switch (m_model.GetM_Selected().getText()){

            case "Silhouette" -> {
                cols.setContrast(-10);
                cols.setBrightness(-10);
                m_snake_Head.setEffect(cols);
            }

            case "Skeleton" ->{
                cols.setContrast(-10);
                m_snake_Head.setEffect(cols);
            }
            case "Sunburnt" -> {
                cols.setHue(-10);
                m_snake_Head.setEffect(cols);

            }
            default -> {

            }
        }
    }

    /**
     * <p>    This is the
     * the game loop. This ensures that all relevant functions are called and
     * the correct logic is ran
     * </p>
     *
     * **/

    public void GameLoop(){
        int WIDTH_ONE = 300;
        int HEIGHT_ONE = 100;
        int WIDTH_TWO = 40;
        int HEIGHT_TWO = 110;
        int DIVISOR = 2;
        GraphicsContext g = m_game_canvas.getGraphicsContext2D();
        if(m_model.GetGameState().GetgState() ==
                State.GameState.Running ){
            m_model.GetGameState().UpDateState(
                    m_model.GetM_snake());
            m_model.GetSController().RenderSnake(g,
                    m_snake_Head);
            m_score_text.setText("Score: "+String.valueOf(
                    m_model.GetM_snake().GetLength()));
            m_model.GetM_powerUp().Draw(g);
            if(m_model.GetGameState().IsM_Enemy()){
                m_model.GetM_enemy().Draw(g);}
            for (Tree t: m_model.GetM_Trees()) {
                m_model.GetM_powerUp().Eaten(
                        m_model.GetM_snake(),g,t);
                m_model.GetM_food().Draw(g);
                m_model.GetM_food().Eaten(
                        m_model.GetM_snake(),g,t,
                        m_model);
                if(m_model.GetGameState().IsM_Enemy()){
                    m_model.GetM_enemy().InTree(t);
                    m_model.GetM_enemy().Collide(
                            m_model.GetM_snake());}
                t.Draw(g);
                t.Collide(m_model.GetM_snake());}
        }else if(m_model.GetGameState().GetgState() ==
                State.GameState.GameOver ){
            m_game_OVER.setText("GAME OVER Your Score: " +
                    m_model.GetM_snake().GetLength());
            m_game_OVER.setX(m_game_canvas.getWidth()/DIVISOR
                    - WIDTH_ONE);
            m_game_OVER.setY(m_game_canvas.getHeight()/DIVISOR
                    + HEIGHT_ONE);
            m_end_Button.setLayoutX(
                    m_game_canvas.getHeight()/DIVISOR
                            +WIDTH_TWO);
            m_end_Button.setLayoutY(
                    m_game_canvas.getHeight()/DIVISOR
                            + HEIGHT_TWO);}
    }
    /**
     * <p>
     *     This function renders the high scores to the screen
     * </p>
     *
     * **/
    public void DisplayScores(){
        List<Json_Game> scores = Json_Game.GetSorted();
        Label[] labels = {m_score_1,m_score_2,m_score_3,
                m_score_4,m_score_5};
        for(int i = 0 ; i < scores.size();i++){
            if(i < labels.length -1){
                String f = i + 1 +"\t   "+ scores.get(i).
                        GetM_name() + "         " +
                        scores.get(i).GetM_score();
                labels[i].setText(f);}
        }
    }

    /**
     *
     * <p> This default constructor enforces that a model is instantiated
     * in the controller so data can be accessed
     * </p>
     * @param snakeModel  Takes in a snakemodel so data can be accessed
     *                    - Type SnakeModel
     * **/
    public SwitchController(SnakeModel snakeModel) {
        m_model = snakeModel;
    }
    /**
     * <p> This function handles the initalisation event that happens when a
     * scene switches. This ensures that
     * correct data is set asnd that relevant functions are called when a
     * scene changes. This contains the animation
     * timer that truly only runs when the game starts.
     * </p>
     *
     * @param location - Takes in a URL, part of the default params, so it
     *                is needec - Type URL
     * @param resources - Takes in a ResourceNundle, part of the default
     *                 params - Type ResourceBundle
     * **/


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try{
            m_game_anchor.setOnKeyPressed(e->
                    m_model.GetSController().keyPressed(e, m_snake_Head));
        }catch(Exception e){
            System.out.println("Cannot load key-listener");
        }
        try{
            m_game_background.setImage(new Image(m_model.GetM_themePath()));
        }catch(Exception e){System.out.println("Cannot load theme");}
        try {
            new AnimationTimer() {
                public void handle(long now) {
                    try {// Runs snake logic on new thread
                        GameLoop();
                    } catch (Exception ignored) {}
                }
            }.start();
        }catch(Exception ignored){}
        try {
            DisplayScores();
        }
        catch(Exception e){
            System.out.println("Cannot parse highscore information");
        }
        try {
            ApplyCols();
        }catch(Exception e){
            System.out.println("Couldnt parse radio button information");
        }
    }

    /**
     * <p> Switches the GUI screen to the level select
     * </p>
     *
     * @param event Takes in event, it is needed for the FXML communication to
     *              work with the program code - Type ActionEvent
     * @throws IOException needed throws implementation
     * **/
    public void SwitchToLvlSel(ActionEvent event) throws IOException {
        int TRACK = 3;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(
                SwitchController.class.getResource("LevelSelect.fxml"));
        loader.setControllerFactory(
                Class->new SwitchController(this.m_model));

        m_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        m_scene = new Scene(loader.load());
        m_scene.getRoot().requestFocus();
        m_stage.setScene(m_scene);
        m_stage.show();
        m_model.getMusic().SetTrack(TRACK);
    }
    /**
     * <p> Switches the GUI screen to the main menu
     * </p>
     *
     * @param event Takes in event, it is needed for the FXML communication
     *              to work with the program code - Type ActionEvent
     * @throws IOException needed throws implementation
     * **/

    public void SwitchToMenu(ActionEvent event) throws IOException {
        m_model.GetGameState().SetgState(State.GameState.Preload);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(
                SwitchController.class.getResource("MainMenu.fxml"));
        loader.setControllerFactory(
                Class->new SwitchController(this.m_model));

        m_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        m_scene = new Scene(loader.load());
        m_stage.setScene(m_scene);
        m_stage.show();
        m_model.getMusic().SetTrack(0);

    }
    /**
     * <p> Switches the GUI screen to the High score screen
     * </p>
     *
     * @param event Takes in event, it is needed for the FXML communication
     *             to work with the program code - Type ActionEvent
     * @throws IOException needed throws implementation
     * **/

    public void SwitchToHS(ActionEvent event) throws IOException {
        int TRACK = 2;
        m_model.GetGameState().SetgState(State.GameState.Preload);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(
                SwitchController.class.getResource("HighScores.fxml"));
        loader.setControllerFactory(
                Class->new SwitchController(this.m_model));
        m_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        m_scene = new Scene(loader.load());
        m_stage.setScene(m_scene);
        m_stage.show();
        m_model.getMusic().SetTrack(TRACK);

    }
    /**
     * <p> Switches the GUI screen to the theme select
     * </p>
     *
     * @param event Takes in event, it is needed for the FXML communication
     *             to work with the program code - Type ActionEvent
     * @throws IOException needed throws implementation
     * **/
    public void SwitchToTS(ActionEvent event) throws IOException {
        int TRACK = 3;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(
                SwitchController.class.getResource("Theme.fxml"));
        loader.setControllerFactory(
                Class->new SwitchController(this.m_model));
        m_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        m_scene = new Scene(loader.load());

        m_stage.setScene(m_scene);
        m_stage.show();
        m_model.getMusic().SetTrack(TRACK);

    }
    /**
     * <p> Switches the GUI screen to the end screen
     * </p>
     *
     * @param event Takes in event, it is needed for the FXML communication
     *              to work with the program code - Type ActionEvent
     *  @throws IOException needed throws implementation
     * **/

    public void SwitchToEnd(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(
                SwitchController.class.getResource("EndScreen.fxml"));
        loader.setControllerFactory(
                Class->new SwitchController(this.m_model));

        m_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        m_scene = new Scene(loader.load());
        m_scene.getRoot().requestFocus();

        m_stage.setScene(m_scene);
        m_stage.show();

    }
    /**
     * <p> Switches the theme in the right direction through the array of
     * themes. This allows for carousel
     * functionality. The theme is needed so the background image can be
     * dynamic in the program
     * </p>
     *
     * @param event Takes in event, it is needed for the FXML communication
     *             to work with the program code - Type ActionEvent
     * @throws IOException needed throws implementation
     * **/
    public void ChangeThemeRight(ActionEvent event) throws IOException {

        String path =  "src/main/resources/Themes/";
        String[] files = {"Theme1.png","Theme2.png","Theme3.png","Theme4.png",
                "Theme5.png"};

        if(m_themeSelect >= files.length-1){
            m_themeSelect = 0;
        }else{
            m_themeSelect++;
        }
        String endPath = Paths.get(
                path+files[m_themeSelect]).toUri().toString();

        m_theme_forward.setImage(new Image(endPath));
        m_theme_backward.setImage(new Image(endPath));
        m_themePath = endPath;
    }
    /**
     * <p> Switches the theme in the left direction through the array of
     * themes. This allows for carousel
     * functionality. The theme is needed so the background image can be
     * dynamic in the program
     * </p>
     *
     * @param event Takes in event, it is needed for the FXML
     *             communication to work with the program code -
     *             Type ActionEvent
     * @throws IOException needed throws implementation
     * **/
    public void ChangeThemeLeft(ActionEvent event) throws IOException {

        String path =  "src/main/resources/Themes/";
        String[] files = {"Theme1.png","Theme2.png","Theme3.png"};

        if(m_themeSelect <= 0 ){
            m_themeSelect = files.length-1;
        }else{
            m_themeSelect--;
        }

        String endPath = Paths.get(
                path+files[m_themeSelect]).toUri().toString();

        m_theme_forward.setImage(new Image(endPath));
        m_theme_backward.setImage(new Image(endPath));
        m_themePath = endPath;
    }
    /**
     * <p> This function sets the theme based on the global class variable
     * (global to the class) which is of type int
     * This integer is changed in the change theme left and change theme
     * right functions
     * </p>
     *
     * @param event Takes in event, it is needed for the FXML
     *              communication to work with the program code -
     *              Type ActionEvent
     *
     * **/
    public void SetTheme(ActionEvent event){

        m_model.SetM_themePath(m_themePath);
        m_Theme_Info.setText("Theme selected!");
        SetCols();

    }
    /**
     * <p> Switches the level in the right direction through the array of
     * levels. This allows for carousel
     * functionality. The level is needed so the background image can be
     * dynamic in the program
     * </p>
     *
     * @param event Takes in event, it is needed for the FXML communication
     *             to work with the program code - Type ActionEvent
     * @throws IOException needed throws implementation
     * **/
    public void ChangeLevelRight(ActionEvent event) throws IOException {

        String pathPrev =  "src/main/resources/LevelPreviews/";
        String pathJson =  "src/main/resources/Levels/";

        String[] filesPrev = {"Level1.png","Level2.png","Level3.png","Level4" +
                ".png",
                "Level5.png"};
        String[] files = {"Level1.json","Level2.json","Level3.json",
                "Level4.json",
                "Level5.json"};

        if(m_levelSelect >= files.length-1){
            m_levelSelect = 0;
        }else{
            m_levelSelect++;
        }
        String endPathPrev = Paths.get(
                pathPrev+filesPrev[m_levelSelect]).toUri().toString();
        m_levelPath = pathJson+files[m_levelSelect];
        m_Level_Preview.setImage(new Image(endPathPrev));

    }
    /**
     * <p> Switches the level in the left direction through the array of levels.
     * This allows for carousel
     * functionality. The level is needed so the background image can be dynamic
     * in the program
     * </p>
     *
     * @param event Takes in event, it is needed for the FXML communication
     *             to work with the program code - Type ActionEvent
     * @throws IOException needed throws implementation
     * **/
    public void ChangeLevelLeft(ActionEvent event) throws IOException {

        String pathPrev =  "src/main/resources/LevelPreviews/";
        String pathJson =  "src/main/resources/Levels/";

        String[] filesPrev = {"Level1.png","Level2.png","Level3.png","Level4" +
                ".png", "Level5.png"};
        String[] files = {"Level1.json","Level2.json","Level3.json",
                "Level4.json", "Level5.json"};

        if(m_levelSelect <= 0 ){
            m_levelSelect = files.length-1;
        }else{
            m_levelSelect--;
        }

        String endPathPrev = Paths.get(
                pathPrev+filesPrev[m_levelSelect]).toUri().toString();
        m_levelPath = pathJson+files[m_levelSelect];
        m_Level_Preview.setImage(new Image(endPathPrev));

    }
    /**
     * <p> This function sets the level based on the global class variable
     * global to the class) which is of type int
     * This integer is changed in the change level left and change level
     * right functions
     * </p>
     *
     * @param event Takes in event, it is needed for the FXML communication
     *              to work with the program code - Type ActionEvent
     * @throws IOException needed throws implementation
     * **/
    public void SetLevel(ActionEvent event) throws IOException {
        int TRACK = 4;
        int X_POS = 1;
        int Y_POS = 2;
        if(!(m_levelPath == null)){ // only sets level if user has changed
            // context
            m_model.SetM_levelPath(m_levelPath);
        }
        Json_Game[] Trees = Json_Game.GrabData(m_model);
        for (String[] s: Json_Game.ConstLvlDat(Trees)) {
            int tree = Integer.parseInt(s[0]);
            int x_pos = Integer.parseInt(s[X_POS]);
            int y_pos = Integer.parseInt(s[Y_POS]);
            if(tree != -1){
                m_model.AddTree((Tree)
                        m_model.GetM_factory().CreateOBJ("tree",
                                x_pos,y_pos, tree));
            }else{
                m_model.AddTree((Tree)
                        m_model.GetM_factory().CreateOBJ("tree",
                                x_pos,y_pos));}
        }
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(
                SwitchController.class.getResource("Game.fxml"));
        loader.setControllerFactory(
                Class->new SwitchController(this.m_model));

        m_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        m_scene = new Scene(loader.load());
        m_scene.getRoot().requestFocus();
        m_stage.setTitle(
                (m_model.GetM_levelPath().split("/")
                        [(m_model.GetM_levelPath().split("/").length-1)])
                        .split("\\.")[0]
        );
        m_stage.setScene(m_scene);
        m_stage.show();
        m_model.getMusic().SetTrack(TRACK);
        //Set states
        m_model.GetGameState().SetgState(State.GameState.Running);
        m_model.GetGameState().SetM_Dasher(m_Dasher.selectedProperty()
                .getValue());
        m_model.GetGameState().SetM_Enemy(
                m_Enemy_Attack.selectedProperty().getValue());
        //Set states

    }
    /**
     * <p> This function is ran when the submit button is clicked on the end
     * screen after the player dies.
     * This only allows 4 characters for the name so the width of the names
     * is uniform for the GUI. This function ONLY
     * sets the score if the name convention is met.
     * </p>
     *
     * @param event Takes in event, it is needed for the FXML communication
     *             to work with the program code - Type ActionEvent
     * @throws IOException needed throws implementation
     * **/

    public void EndScore(ActionEvent event) throws IOException {

        final int MAX = 4;

        String name = m_USER_NAME.getText();
        if(name.length() > MAX){
            m_HS_info.setText("You cannot use that name! It's too many " +
                    "characters.");
            return;
        }else if(name.length() == 0){
            m_HS_info.setText("You need a name to submit silly :)");
            return;
        }

        FileIO.AddScore(new Json_Game(m_USER_NAME.getText(),
                m_model.GetM_snake().GetLength()));

        End(event);
    }

    /**
     * <p> This function ends the program.
     * </p>
     *
     * @param event Takes in event, it is needed for the FXML communication
     *             to work with the program code - Type ActionEvent
     * @throws IOException needed throws implementation
     * **/
    public void End(ActionEvent event) throws IOException {

        Platform.exit();

    }

}

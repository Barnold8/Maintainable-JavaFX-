package MVC;

import Mechanics.*;
import javafx.scene.control.RadioButton;
import Mechanics.*;
import Utils.Music;
import Utils.ObjectFactory;


import java.nio.file.Paths;
import java.util.ArrayList;
/**
 *
 * <p> This class is like a massive struct as in its holding and managing all
 * the data for the program.
 * This ensures that the data is in one place and and is explicitally
 * accessible through the model object only,
 * </p>
 *@author Brandon
 * **/
public class SnakeModel {

    /**
     * <p>
     *     This function gets the current model "selected" variable for setting
     *     the colour attribute of the snake head
     * </p>
     *
     * **/
    public RadioButton GetM_Selected(){return this.m_Selected;}
    /**
     * <p>
     *     This function sets the current model "selected" variable so the
     *     colour itself can be changed when needed and the data can persist
     *     across the whole program
     * </p>
     *
     * **/
    public void SetM_Selected(RadioButton r){ this.m_Selected = r;}

    /**
     * <p> This public SetM_themePath function sets the path for the theme
     * being used in the game.
     * </p>
     * @param themePath  Takes in a string to the file location of the theme
     *                  to be used - Type String
     * **/
    public void SetM_themePath(String themePath) {
        this.m_themePath = themePath;
    }
     /**
     * <p> This public GetM_themePath function gets the path for the theme
      * being used in the game.
     * </p>
     * @return m_themePath Returns the path to the theme file.  - Type String
     * **/
    public String GetM_themePath(){return this.m_themePath;}
    /**
     * <p> This public SetM_levelPath function sets the path for the level
     * being used in the game.
     * </p>
     * @param LevelPath Takes in a string to the file location of the leve to
     *                 be used
     * **/
    public void SetM_levelPath(String LevelPath) {
        // System.out.println("Setting model path to "+LevelPath);
        this.m_levelPath =
                Paths.get(LevelPath).toUri().toString();
    }
    /**
     * <p> This public AddTree function adds a tree to the arrayList of trees
     * </p>
     * @param t Takes in a tree object to add it to the arrayList of trees
     *             - Type Tree
     * **/
    public void AddTree(Tree t){
        m_Trees.add(t);
    }
    /**
     * <p> This public GetM_Trees function gets the arrayList of trees
     * </p>
     * @return m_trees Returns an arraylist of the trees - Type ArrayList
     * &lt;Tree&gt;
     * **/
    public ArrayList<Tree> GetM_Trees(){return m_Trees;}
    /**
     * <p> This public GetM_levelPath function gets the file path to the
     * levelpath
     * </p>
     * @return m_levelPath Returns a string which contains the file path of the
     * level path - Type String
     * **/
    public String GetM_levelPath(){return this.m_levelPath;}
    /**
     * <p> This public GetM_snake function returns the snake object
     * </p>
     * @return m_snake Returns the snake - Type Snake
     * **/

    public Snake GetM_snake(){return (Snake) m_snake;}
    /**
     * <p> This public GetM_food function gets the food object
     * </p>
     * @return m_food Returns the food - Type food
     * **/

    public Food GetM_food(){return (Food) m_food;}
    /**
     * <p> This public GetGameState function gets the game state object
     * </p>
     * @return m_gameState Returns a game state object - Type GameState
     * **/
    public State GetGameState() {
        return this.m_gamestate;
    }
    /**
     * <p> This function returns the music object so the program can change
     * the current track playing if need be.
     * </p>
     * @return m_music - Returns the music object from the model
     * **/
    public Music getMusic(){
        return this.m_music;
    }
    /**
     * <p> This public GetSContoller function returns the snake
     * controller object.
     * </p>
     * @return m_snakeController Returns a SnakeController object - Type
     * SnakeController
     * **/
    public SnakeController GetSController() {
        return m_snakeController;
    }
    /**
     * <p> This public GetM_factory function returns the factory object.
     * </p>
     * @return m_factory Returns a Factory object - Type Factory
     * **/
    public ObjectFactory GetM_factory(){return this.m_factory;}
    /**
     * <p> This public GetM_powerUp function returns the powerup object.
     * </p>
     * @return m_powerUp Returns a Powerup object - Type PowerUp
     * **/
    public PowerUp GetM_powerUp() {return this.m_powerUp;}
    /**
     * <p> This public GetM_enemy function returns the enemy object.
     * </p>
     * @return m_enemy Returns an Enemy object - Type Enemy
     * **/
    public Enemy GetM_enemy(){return this.m_enemy;}


    private RadioButton m_Selected;
    private final ObjectFactory m_factory = new ObjectFactory();
    private final SnakeObj m_snake;
    private Enemy m_enemy;
    private final Food m_food;
    private final PowerUp m_powerUp;

    private String m_themePath;
    private String m_levelPath;
    private String m_levelPrev;
    private State m_gamestate;
    private Music m_music;
    private final SnakeController m_snakeController;
    private ArrayList<Tree> m_Trees = new ArrayList<>();

    /**
     * <p> This public default constructor for the snakeModel enforces needed
     * data to be set on the construction
     * of the object. This is the epicenter of all the data for the program.
     * Everything we need for the program is
     * in this object, ensuring that the data is in one place and safe from
     * confusion i.e. the snake only has access
     * to its data and now other objects dont have access to this.
     * The snakemodel stops this entirely.
     * </p>
     * **/
    public SnakeModel(){
        int X_POS = 50;
        int Y_POS = 300;

        this.m_snake = this.m_factory.CreateOBJ("snake");
        this.m_food = (Food) this.m_factory.CreateOBJ("food");
        this.m_gamestate = new State(State.GameState.Preload);
        this.m_enemy = (Enemy) this.m_factory.CreateOBJ(
                "enemy",X_POS,Y_POS);
        this.m_powerUp = (PowerUp) this.m_factory.CreateOBJ(
                "PUP",1);
        this.m_themePath = Paths.get("src/main/resources/Themes"
                + "/Theme3.png").toUri().toString();
        this.m_levelPath = Paths.get("src/main/resources/Levels"
                + "/Level1.json").toUri().toString();
        this.m_music = new Music();
        this.m_music.PlayAudio();
        this.m_levelPrev = Paths.get("src/main/resources" +
                "/LevelPreviews" + "/Level1.png").toUri().toString();
        this.m_snakeController = new SnakeController(this);
    }
    /**
     * <p> This public constructor is like the default constructor but
     * allows for configuration of the music player.
     * </p>
     * **/
    public SnakeModel(boolean music){
        int X_POS = 50;
        int Y_POS = 300;

        this.m_snake = this.m_factory.CreateOBJ("snake");
        this.m_food = (Food) this.m_factory.CreateOBJ("food");
        this.m_gamestate = new State(State.GameState.Preload);
        this.m_enemy = (Enemy) this.m_factory.CreateOBJ(
                "enemy",X_POS,Y_POS);
        this.m_powerUp = (PowerUp) this.m_factory.CreateOBJ(
                "PUP",1);
        this.m_themePath = Paths.get("src/main/resources/Themes"
                + "/Theme3.png").toUri().toString();
        this.m_levelPath = Paths.get("src/main/resources/Levels"
                + "/Level1.json").toUri().toString();
        if(music){
            this.m_music = new Music();
            this.m_music.PlayAudio();
        }

        this.m_levelPrev = Paths.get("src/main/resources" +
                "/LevelPreviews" + "/Level1.png").toUri().toString();
        this.m_snakeController = new SnakeController(this);
    }

}

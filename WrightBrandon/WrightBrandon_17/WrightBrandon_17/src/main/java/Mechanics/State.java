package Mechanics;
/**
 *
 * This class provides a state design pattern so the game can program can
 * easily discern what is happening at any given time, aiding events and
 * functionality of the code base
 * @author Brandon
 * **/
public class State {
    /**
     * <p>
     *     gets the current game state
     * </p>
     * @return gState returns the current game state of the program - type
     * GameState
     * @see GameState
     * **/
    public GameState GetgState() {
        return gState;
    }
    /**
     * <p>
     *     Gets the current game state
     * </p>
     * @param gState returns the current game state of the program -
     *              type GameState
     * @see GameState
     * **/
    public void SetgState(GameState gState) {
        this.gState = gState;
    }
    /**
     * <p>
     *     Sets the boolean flag Dasher to either true or false depending on
     *     the input boolean. If this is true, the snake will get faster for
     *     each fruit it has eaten
     * </p>
     * @param m_Dasher sets the Dasher flag - type boolean
     * **/
    public void SetM_Dasher(boolean m_Dasher){this.m_Dasher = m_Dasher;}
    /**
     * <p>
     *     Sets the boolean flag Enemy to either true or false depending on
     *     the input boolean. If this is true, an enemy will spawn in the
     *     level. This enemy is like a moving obstacle.
     * </p>
     * @param m_Enemy  sets the Enemy flag - type boolean
     * **/
    public void SetM_Enemy(boolean m_Enemy){this.m_Enemy = m_Enemy;}
    /**
     * <p>
     *     Returns the dasher flag
     * </p>
     * @return m_Dasher returns the Dasher flag - Type boolean
     * **/
    public boolean IsM_Dasher() {
        return m_Dasher;
    }
    /**
     * <p>
     *      Returns the enemy flag
     * </p>
     * @return m_Enemy returns the Enemy flag - Type boolean
     * **/
    public boolean IsM_Enemy() {
        return m_Enemy;
    }
    /**
     * <p>
     *      This enum makes the state class easy to maintain and add to if
     *      needed. It also allows for objects and non objects to use states
     *      if need be since its not bound to the object rather the class.
     *      The purpose of this enum is to keep track of the programs state
     *      at any given time. Preload means the program is in the menu
     *      phase. Running means the game is ongoing. GameOver means the
     *      player has met the gameover screen.
     * </p>
     *
     * **/
    public enum GameState{
        Preload,
        Running,
        GameOver,

    }

    private boolean m_Dasher;
    private boolean m_Enemy;

    private GameState gState;
    /**
     * <p>
     *      This constructor enforces a default state to be set on object
     *      creation as its important to know the state of the program at all
     *      times so the default state has to be set.
     * </p>
     * @param state Takes in GameState state to set the state of the program
     *              - Type GameState
     * **/
    public State(GameState state){
        this.gState = state;
    }
    /**
     * <p>
     *      This public function UpDateState is there to ensure that when the
     *      snake dies, the game stops and sets the state to gameover so the
     *      program can continue further than the game loop.
     * </p>
     * @param snake Takes in Snake object to detect if snake is dead to
     *              change state to the GameOver state
     * @return updatedState - Returns true if state updated via snake else
     * returns false
     * **/
    public boolean UpDateState(Snake snake){
        if(!snake.GetM_IsLiving()){
            this.gState = GameState.GameOver;
            return true;
        }
        return false;
    }


}

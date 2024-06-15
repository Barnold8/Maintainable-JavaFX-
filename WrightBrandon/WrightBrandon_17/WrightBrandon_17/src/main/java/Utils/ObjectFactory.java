package Utils;


import Mechanics.*;

/**
 *
 * <p>
 *     This class provides the factory design pattern returning the objects as
 *     needed
 * </p>
 * @author Brandon
 * **/
public class ObjectFactory{

    private final int X_POS = 100;
    private final int Y_POS = 100;

    /**
     *
     * <p>
     *     This constructor enforces the switch be ran to return the object
     *     shared by the abstract class
     * </p>
     * @param entity - Takes in a string to run the switch with - Type String
     * @return new SnakeObj - Returns a new snake object where said object is
     * implementing SnakeObj - Type Variable
     * **/
    public SnakeObj CreateOBJ(String entity){

        switch(entity){

            case "snake":
                return new Snake(X_POS,Y_POS);

            case "food":
                return new Food();

            case "tree":
                return new Tree();

            case "enemy":
                return new Enemy();

            default:
                throw new IllegalArgumentException("Unknown entity "+ entity);
        }

    }
    /**
     *
     * <p>
     *     This constructor enforces the switch to the ran and the x and
     *     y position  of the object to be set
     * </p>
     * @param entity - Takes in a string to run the switch with - Type String
     * @param x - Takes in position x - Type int
     * @param y - Takes in position y - Type int
     * @return new SnakeObj - Returns a new snake object where said object is
     * implementing SnakeObj - Type Variable
     * **/
    public SnakeObj CreateOBJ(String entity, int x, int y){

        switch(entity){

            case "snake":
                return new Snake(x,y);

            case "food":
                return new Food(x,y);

            case "tree":
                return new Tree(x, y);

            case "PUP":
                return new PowerUp(x,y);

            case "enemy":
                return new Enemy(x,y);

            default:
                throw new IllegalArgumentException("Unknown entity "+ entity);
        }

    }
    /**
     *
     * <p>
     *     This constructor enforces the switch to be ran, the x and y position
     *     to be set and the texture to be set
     * </p>
     * @param entity - Takes in a string to run the switch with - Type String
     * @param x - Takes in position x - Type int
     * @param y - Takes in position y - Type int
     * @param texture - Takes in a texture position to set the texture of the
     *               object accordingly - Type int
     * @return new SnakeObj - Returns a new snake object where said object is
     * implementing SnakeObj - Type Variable
     * **/
    public SnakeObj CreateOBJ(String entity, int x, int y, int texture) {

        switch (entity) {

            case "snake":
                return new Snake(x, y);

            case "food":
                return new Food();

            case "tree":
                return new Tree(x, y, texture);

            case "PUP":
                return new PowerUp(x,y,texture);

            case "enemy":
                return new Enemy(x,y);

            default:
                throw new IllegalArgumentException("Unknown entity " + entity);
        }
    }

    /**
     * <p>
     *     This constructor enforces the switch to be ran, and the texture to
     *     be ran
     * </p>
     * @param entity - Takes in a string to run the switch with - Type String
     * @param texture - Takes in a texture position to set the texture of the
     *                object accordingly - Type int
     * @return new SnakeObj - Returns a new snake object where said object is
     * implementing SnakeObj - Type Variable
     * **/
    public SnakeObj CreateOBJ(String entity, int texture) {
        switch (entity) {

            case "snake":
                return new Snake(X_POS, Y_POS);

            case "food":
                return new Food();

            case "tree":
                return new Tree();

            case "PUP":
                return new PowerUp(texture);

            case "enemy":
                return new Enemy();

            default:
                throw new IllegalArgumentException("Unknown entity " + entity);
        }
    }

}

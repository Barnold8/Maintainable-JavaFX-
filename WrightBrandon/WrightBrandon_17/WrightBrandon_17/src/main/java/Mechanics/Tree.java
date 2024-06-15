package Mechanics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import Utils.ImageSaveUtil;

import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * This class provides an obstacle for the game to provide more variety to
 * the gameplay.
 * @author Brandon
 * **/
public class Tree extends SnakeObj{
    /**
     * This default constructor sets the texture of the tree to a random
     * image in its relative directory boundary. It then sets the x and y
     * position of the tree to hardcoded values.
     * **/
    public Tree(){ // need new box image
        int X_POS = 300;
        int Y_POS = 300;
        SetM_IsLiving(true);

        SetM_i(ImageSaveUtil.GetM_images().get(String.valueOf(
                ThreadLocalRandom.current().nextInt(16, 22+1))));

        SetM_w((int) GetM_i().getWidth());
        SetM_h((int) GetM_i().getHeight());

        SetM_x(X_POS);
        SetM_y(Y_POS);

    }
     /**
     * This constructor is like the default one whereas the x and y positions
      * are specified
      * @param x Takes in an x position - Type int
      * @param y Takes in an y position - Type int
     * **/
    public Tree(int x, int y){ // need new box image
        int LOWERBOUND = 16;
        int HIGHERBOUND = 22;
        SetM_IsLiving(true);

        SetM_i(ImageSaveUtil.GetM_images().get(String.valueOf(
                ThreadLocalRandom.current().nextInt(LOWERBOUND,
                        HIGHERBOUND+1))));

        SetM_w((int) GetM_i().getWidth());
        SetM_h((int) GetM_i().getHeight());

        SetM_x(x);
        SetM_y(y);

    }
    /**
     * This constructor enforces an x and y position and the image position
     * of the tree in its directory. 16 is the base number for the trees,
     * texture is the tree number itself using a human-readable format,
     * starting from 1 rather than 0 and then the -1 aligns the image
     * location in its proper position. So picking tree 1, gives you tree 1
     * and not tree 0 which doesn't exist.
     *
     * @param x takes in an int to set the x position - Type int
     * @param y takes in an int to set the y position - Type int
     * @param texture takes in an int to set the texture - Type int
     * **/
    public Tree(int x, int y, int texture){ // need new box image
        int BASE = 16;
        SetM_IsLiving(true);

        SetM_i(ImageSaveUtil.GetM_images().get(String.valueOf(
                (BASE + texture -1))));

        SetM_w((int) GetM_i().getWidth());
        SetM_h((int) GetM_i().getHeight());

        SetM_x(x);
        SetM_y(y);

    }
    /**
     * The public collide function checks if the snake has collided with a tree
     *
     * @param mySnake Takes in a Snake object to use its rectangle data. -
     *                Type Snake
     * @return
     **/
    public boolean Collide(Snake mySnake){

        if (mySnake.GetRectangle().intersects(
                this.GetRectangle().getBoundsInLocal()) && GetM_IsLiving()
                && mySnake.GetM_IsLiving()){

            mySnake.SetM_IsLiving(false);
            return true;
        }
        return false;
    }

    @Override
    public void Draw(GraphicsContext g, ImageView img) {

    }
    /**
     * This function draws the tree
     * @param g Takes in a graphics context to draw to the canvas - Type
     *          GraphicsContext
     * **/
    @Override
    public void Draw(GraphicsContext g) {
        g.drawImage(GetM_i(), GetM_x(), GetM_y());
    }
}


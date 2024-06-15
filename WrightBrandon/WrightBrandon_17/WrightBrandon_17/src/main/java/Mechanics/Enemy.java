package Mechanics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import Utils.ImageSaveUtil;

import java.util.concurrent.ThreadLocalRandom;
/**
 * <p>This class creates the Enemy object. The enemy is a game addition
 * specific object that aims to make the game more challenging for the player
 * if they so choose to enable the "Enemy attack" game mode. This class
 * extends the SnakeObj abstract class
 * </p>
 * @author Brandon
 * **/
public class Enemy extends SnakeObj { // Moves diagonal across the screen

    /**
     * <p>Sets the speed of the Enemy object on the X axis</p>
     * @param speed The speed the enemy moves at. - Type int
     * **/
    public void SetXSpeed(int speed){this.m_xSpeed = speed;}
    /**
     * <p>Sets the speed of the Enemy object on the Y axis</p>
     * @param speed The speed the enemy moves at. - Type int
     * **/
    public void SetYSpeed(int speed){this.m_ySpeed = speed;}
    /**
     * <p>Sets the speed of the Enemy object on the Y axis</p>
     * @return m_xSpeed - Type int
     * **/
    public int GetXSpeed(){return this.m_xSpeed;}
    /**
     * <p>Gets the speed of the Enemy object on the Y axis</p>
     * @return m_ySpeed - Type int
     * **/
    public int GetYSpeed(){return this.m_ySpeed;}

    private int m_xSpeed = 0;
    private int m_ySpeed = 0;
    /**
     * <p>This default constructor sets the enemy to default positions,
     * default speed and a default texture.</p>

     * @see SnakeObj
     * **/
    public Enemy(){
        int XPOS = 300;
        int YPOS = 300;
        int IMAGE = 28;
        SetM_IsLiving(true);

        SetM_i(ImageSaveUtil.GetM_images().get(String.valueOf(IMAGE)));

        this.m_xSpeed = 1;
        this.m_ySpeed = 1;

        SetM_w((int) GetM_i().getWidth());
        SetM_h((int) GetM_i().getHeight());

        SetM_x(XPOS);
        SetM_y(YPOS);

    }
    /**
     * <p>This constructor allows for the configuration of an x and y
     * position for the enemy object. This constructor grabs a random image
     * from the enemy directory and bases its x speed on said image.</p>
     *
     * @param x The x position of the enemy on spawn - Type int
     * @param y The y position of the enemy on spawn - Type int
     * @see SnakeObj
     * **/
    public Enemy(int x, int y){
        int random = ThreadLocalRandom.current().nextInt(27, 28);
        this.m_xSpeed = -1;

        this.SetM_i(ImageSaveUtil.GetM_images().get(String.valueOf(27)));

        SetM_w((int) GetM_i().getWidth());
        SetM_h((int) GetM_i().getHeight());

        if(random > 27){
            this.m_xSpeed = 1;
        }
        this.m_ySpeed = 1;

        SetM_IsLiving(true);
        SetM_x(x);
        SetM_y(y);

    }
    /**
     * <p>This constructor allows for the configuration of an x and y
     * position for the enemy object and the texture being used for the
     * enemy.  </p>
     * @param x The x position of the enemy on spawn - Type int
     * @param y The y position of the enemy on spawn - Type int
     * @param texture The texture in the relative file space for the enemy -
     *                Type int
     * @see SnakeObj
     * **/
    public Enemy(int x, int y, int texture){

        SetM_IsLiving(true);

        SetM_i(ImageSaveUtil.GetM_images().get(String.valueOf(
                ThreadLocalRandom.current().nextInt(texture))));

        SetM_w((int) GetM_i().getWidth());
        SetM_h((int) GetM_i().getHeight());

        SetM_x(x);
        SetM_y(y);

    }
    /**
     * <p>The InTree public method changes the x and/or y speed of the
     * enemy object when a collision with a Tree object is detected.</p>
     * @param t Takes in a tree for detecting enemy collisions with the tree
     *          - Type Tree
     * @return intersect - Returns true if intersect happens, else false -
     * type boolean
     * **/
    public boolean InTree(Tree t){
        int LOWERBOUND = 50;
        int HIGHERBOUND = 350;
        if(this.GetRectangle().intersects(
                t.GetRectangle().getBoundsInLocal())) {

            if(GetM_x() < LOWERBOUND || GetM_x() > HIGHERBOUND){
                SetXSpeed(-GetXSpeed());
            }
            SetYSpeed(-GetYSpeed());
            return true;
        }
        return false;
    }
    /**
     * <p>The Collide public method changes the Snake object's living
     * variable if a collision is detected between the current object and the
     * passed in Snake object </p>
     * @param snake Takes in a snake object to detect collisions with the
     *              enemy - Type Snake
     * @return intersect - Returns true if intersect happens, else false -
     * type boolean
     * **/
    public boolean Collide(Snake snake){
        if(this.GetRectangle().intersects(
                snake.GetRectangle().getBoundsInLocal())) {
            snake.SetM_IsLiving(false);
            return true;
        }
        return false;
    }

    @Override
    public void Draw(GraphicsContext g, ImageView img) {}
    /**
     * <p> This function not only renders the image on the game canvas
     * but also takes processing overhead for basic border collisions. </p>
     * @param g Takes in GraphicsContext to get the canvas to draw to it -
     *          Type GraphicsContext
     * **/
    @Override
    public void Draw(GraphicsContext g) {
        int NONSPEED = 0;
        int LEFT = 27;
        int RIGHT = 28;
        int LOWERBOUND = 0;
        int HIGHERBOUND_X = 500;
        int HIGHERBOUND_Y = 370;

        if(GetXSpeed() < NONSPEED){
            SetM_i(
                ImageSaveUtil.GetM_images().get(String.valueOf(LEFT)));}
        else{ SetM_i(
                ImageSaveUtil.GetM_images().get(String.valueOf(RIGHT)));}

        if(GetM_x() <= LOWERBOUND || GetM_x() >= HIGHERBOUND_X){
            SetXSpeed(-GetXSpeed());}
        if(GetM_y() <= LOWERBOUND || GetM_y() >= HIGHERBOUND_Y){
            SetYSpeed(-GetYSpeed());}


        g.drawImage(GetM_i(), GetM_x(), GetM_y());
        SetM_x(GetM_x()+this.m_xSpeed);
        SetM_y(GetM_y()+this.m_ySpeed);
    }
}

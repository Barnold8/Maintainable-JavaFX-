package Mechanics;

import Utils.ImageSaveUtil;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;

import java.util.Random;
/**
 * This class provides a powerup object to give the game more variety in
 * difficulty and aids in gameplay.
 * @author Brandon
 * **/
public class PowerUp extends SnakeObj{

    private int m_powerType;
    /**
     *<p>This constructor grabs a relative image
     * from the powerup directory and sets it accordingly
     * </p>
     * @param texture This takes in a texture - Type int
     * **/
    public PowerUp(int texture){
        SetM_IsLiving(true);
        int X_POS = 300;
        int Y_POS = 300;
        int DEFAULTIMG = 23;
        this.m_powerType = texture; // ties texture to powerup
        SetM_i(ImageSaveUtil.GetM_images().get(String.valueOf(
                (DEFAULTIMG + texture))));

        SetM_w((int) GetM_i().getWidth());
        SetM_h((int) GetM_i().getHeight());

        SetM_x(X_POS);
        SetM_y(Y_POS);

    }
    /**
     * <p>This constructor sets the x and y position of the powerup
     * object and picks a random image
     * </p>
     * @param x Takes in an int to set the x position - Type int
     * @param y Takes in an int to set the y position - Type int
     * **/
    public PowerUp(int x,int y){
        SetM_IsLiving(true);
        int LOWER = 23;
        this.m_powerType = 1; // ties texture to powerup
        SetM_i(ImageSaveUtil.GetM_images().get(String.valueOf(
                (LOWER + 1))));

        SetM_w((int) GetM_i().getWidth());
        SetM_h((int) GetM_i().getHeight());

        SetM_x(x);
        SetM_y(y);

    }
    /**
     * <p>This constructor sets the x and y position of the powerup
     * object and sets the powerup texture
     * </p>
     * @param x Takes in an int to set the x position - Type int
     * @param y Takes in an int to set the y position - Type int
     * @param texture Takes in an int to set the texture - Type int
     * **/
    public PowerUp(int x,int y, int texture){
        SetM_IsLiving(true);
        this.m_powerType = texture; // ties texture to powerup
        SetM_i(ImageSaveUtil.GetM_images().get(String.valueOf(
                (23 + texture))));

        SetM_w((int) GetM_i().getWidth());
        SetM_h((int) GetM_i().getHeight());

        SetM_x(x);
        SetM_y(y);

    }
    /**
     *<p>This function resets the powerup location and image
     * </p>
     * @param g Takes in a graphics context to get the width and height of
     *          the canvas - type GraphicsContext
     * **/
    private void resetPU(GraphicsContext g){
        int LOWER = 24;
        int HIGHER = 27;
        SetM_x((int) (Math.random() * (g.getCanvas().getWidth()
                - GetM_w())));
        SetM_y((int) (Math.random() * (g.getCanvas().getHeight()
                - GetM_h())));

        int num = new Random().nextInt(LOWER,HIGHER);

        this.SetM_i(ImageSaveUtil.GetM_images().get(String.valueOf(num)));
        this.m_powerType = num;
    }
    /**
     * <p>This function resets the powerup location and image. It also
     * ensures that the powerup doesnt spawn within a tree. It does lead to
     * the weird graphical glitch but doesnt inhibit gameplay. </p>
     *
     * @param mySnake Takes in the snake object to detect if the snake has
     *                collided with the powerup and apply the effect to the
     *                snake accordingly  - Type Snake
     * @param g       Takes in a graphics context to get the width and height of
     *                the canvas - Type GraphicsContext
     * @param tree    Takes in a tree so the resetPU function can use it. - Type
     *                Tree
     * @return eatenStatus - Returns true if eaten, false if not - Type boolean
     **/

    public boolean Eaten(Snake mySnake, GraphicsContext g, Tree tree) {

        while (InTree(this, tree)) {
            resetPU(g);
        }

        if (mySnake.GetRectangle().intersects(
                this.GetRectangle().getBoundsInLocal()) && GetM_IsLiving()
                && mySnake.GetM_IsLiving()) {

                // Switch doesn't accept symbolic constants
                switch(this.m_powerType){
                    case 24-> {
                        mySnake.SetM_speed_XY(mySnake.GetM_speed_XY() - 1);
                    }
                    case 25 -> {
                        mySnake.SetM_speed_XY(mySnake.GetM_speed_XY() + 1);
                    }
                    case 26 ->{
                        //Powerup can be really powerful or really dangerous
                        double random = Math.random();
                        if(random >= 0.9) {
                            mySnake.SetLength(mySnake.GetLength() + 64);
                        } else if(random >= 0.8){
                            mySnake.RandSpot(g);
                        }else if(random >= 0.5){
                            mySnake.SetM_speed_XY((int) (Math.random() * 10));
                        }
                    }
                }
            resetPU(g);
            return true;
        }
        return false;
    }


    @Override
    public void Draw(GraphicsContext g, ImageView img) {

    }
    /**
     *<p>This function checks if a Tree and a PowerUp are intersecting </p>
     *
     * @param p Takes in a powerup object to detect if a powerup is
     *          intersecting with a tree - Type PowerUp
     * @param tree Takes in a powerup object to detect if a powerup is
     *               intersecting with a tree - Type Tree
     * @return boolean - Returns a boolean depending on the intersection
     * between a tree and a powerup
     * **/
    public boolean InTree(PowerUp p, Tree tree){
        return tree.GetRectangle().intersects(
                p.GetRectangle().getBoundsInLocal());
    }
    /**
     *<p>This function resets the powerup location and image. It also
     * ensures that the powerup doesnt spawn within a tree. It does lead to
     * the weird graphical glitch but doesnt inhibit gameplay. </p>
     *
     * @param g Takes in a graphics context to draw the powerup to the screen -
     *          Type GraphicsContext
     * **/
    @Override
    public void Draw(GraphicsContext g) {
        g.drawImage(GetM_i(), GetM_x(), GetM_y());
    }
}

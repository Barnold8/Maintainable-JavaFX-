package Mechanics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import Utils.ImageSaveUtil;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
/**
 * This class provides a snake object to allow the player to interact with
 * the game
 * @author Brandon
 * **/
public class Snake extends SnakeObj {
    /**
     * <p>The SetLength public function sets the snake objects length
     * variable to It's passed in argument
     * </p>
     * @param length Takes in an int to set the m_length variable - Type int
     * **/
    public void SetLength(int length) // function is fine as is
    {
        this.m_length = length;
    }
    /**
     * <p>The SetM_up public function sets the snake objects boolean
     * variable to It's passed in argument
     * </p>
     * @param m_up Takes in a boolean to set the m_up variable - Type boolean
     * **/
    public void SetM_up(boolean m_up) {
        this.m_up = m_up;
    }
    /**
     * <p>The SetM_down public function sets the snake objects boolean
     * variable to It's passed in argument
     * </p>
     * @param m_down Takes in a boolean to set the m_down variable - Type
     *        boolean
     * **/
    public void SetM_down(boolean m_down) {
        this.m_down = m_down;
    }
    /**
     * <p>The SetM_left public function sets the snake objects boolean
     * variable to It's passed in argument
     * </p>
     * @param m_left Takes in a boolean to set the m_left variable - Type
     *               boolean
     * **/
    public void SetM_left(boolean m_left) {
        this.m_left = m_left;
    }
    /**
     *<p>The SetM_right public function sets the snake objects boolean
     * variable to It's passed in argument
     * </p>
     * @param m_right Takes in a boolean to set the m_right variable - Type
     *                boolean
     * **/
    public void SetM_right(boolean m_right) {
        this.m_right = m_right;
    }
    /**
     * <p>The Get_up public function returns the boolean variable m_up. This
     * is used to know what direction the snake is moving in.
     * </p>
     * @return m_up - Type boolean
     * **/
    public boolean Get_up() {
        return m_up;
    }
    /**
     * <p>The Get_down public function returns the boolean variable m_down.
     * This is used to know what direction the snake is moving in.
     * </p>
     * @return m_down - Type boolean
     * **/
    public boolean Get_down() {
        return m_down;
    }
    /**
     * <p>The Get_left public function returns the boolean variable m_left.
     * This
     * is used to know what direction the snake is moving in.
     * </p>
     * @return m_left - Type boolean
     * **/
    public boolean Get_left() {
        return m_left;
    }
    /**
     * <p>The Get_up public function returns the boolean variable m_right. This
     * is used to know what direction the snake is moving in.
     * </p>
     * @return m_right - Type boolean
     * **/
    public boolean Get_right() {
        return m_right;
    }
    /**
     * <p>The GetLength public function returns the length of the snake in
     * the current moment.
     * </p>
     * @return m_length - Type int
     * **/
    public int GetLength(){ // function is fine as is
        return m_length;
    }
    /**
     * <p>The GetM_speed_XY public function gets the snake objects speed
     * variable.
     * </p>
     * @return m_speed_XY - Type int
     * **/
    public int GetM_speed_XY() {
        return m_speed_XY;
    }
    /**
     * <p>The SetM_speed_XY public function sets the snake objects speed
     * variable.
     * </p>
     * @param m_speed_XY - Type int
     * **/
    public void SetM_speed_XY(int m_speed_XY) {
        this.m_speed_XY = m_speed_XY;
    }
    /**
     * <p>This function sets the body points of the snake
     * </p>
     * @param points Takes in a paramter of a prexisting List to set as the
     *               objects list
     *             - Type List&lt;Point&gt;
     * **/
    public void SetM_bodyPoints(List<Point> points){m_bodyPoints = points;}
    /**
     * <p>This function sets the body points of the snake
     * </p>
     * @return m_bodyPoints - Returns the objects body points -
     *  Type List&lt;Point&gt;
     * **/
    public List<Point> GetM_bodyPoints(){return m_bodyPoints;}
    private int m_speed_XY;
    private int m_length;
    private int m_num;              // pixels between body

    private static List<Point> m_bodyPoints = new LinkedList<>();

    boolean m_up, m_down, m_left, m_right = true;
    /**
     * <p>This constructor allows for the configuration of an x and y
     * position for the snake object. This constructor sets the speed,length
     * and distance between body nodes automatically </p>
     *
     * @param x The x position of the snake on spawn - Type int
     * @param y The y position of the snake on spawn - Type int
     * @see SnakeObj
     * **/
    public Snake(int x, int y) {
        SetM_IsLiving(true);
        SetM_x(x);
        SetM_y(y);
        SetM_i(ImageSaveUtil.GetM_images().get("snake-body"));
        SetM_w((int) GetM_i().getWidth());
        SetM_h((int) GetM_i().getHeight());

        this.m_speed_XY = 3;
        this.m_length = 1;


        this.m_num = GetM_w() / m_speed_XY;

    }
    /**
     * <p>This public Move function changes the x and y position of the snake
     * in accordance with its current speed. It will only change one movement
     * vector at any given time to enforce the classic snake movement  </p>
     *
     * **/
    public void Move()
    {
        // let the swarm move
        if (m_up)
        {
            SetM_y(GetM_y()-m_speed_XY);

        } else if (m_down)
        {
            SetM_y(GetM_y()+m_speed_XY);
        } else if (m_left)
        {
            SetM_x(GetM_x()-m_speed_XY);
        } else if (m_right)
        {
            SetM_x(GetM_x()+m_speed_XY);
        }

    }
    /**
     * <p>This public RandSpot function is used to randomly place the snake
     * head in random position on the screen, the body parts follow suit after.
     * </p>
     *
     * @param g Takes in graphics context to get the width and height of the
     *          canvas - Type GraphicsContext
     * **/
    public void RandSpot(GraphicsContext g){
        SetM_x((int) (Math.random() * (g.getCanvas().getWidth()
                - GetM_w())));
        SetM_y((int) (Math.random() * (g.getCanvas().getHeight()
                - GetM_h())));

    }
    /**
     * <p>This public Draw function is used draw the snake head and the body
     * parts of the snake accordingly while also checking if the snake is out
     * of bounds and/or it has collided with its own body. Since the snake is
     * being rendered every frame its position will change every frame so its
     * adequate that the function does checks for collisions to avoid making
     * more stack frames than is necessary.
     * </p>
     *
     * @param g Takes in a graphics context to pass it into the outofBounds
     *          function - Type GraphicsContext
     * @param img Takes in a ImageView to set the FXML snake head
     *            accordingly since the head isn't set programatically
     * **/
    @Override
    public void Draw(GraphicsContext g, ImageView img)
    {
        int xOff = 105;
        int yOff = 138;
        outofBounds(g);
        EatBody();

        m_bodyPoints.add(new Point(GetM_x(), GetM_y()));
        if (m_bodyPoints.size() == (this.m_length + 1) * m_num)
        {
            m_bodyPoints.remove(0);
        }
        img.setX(GetM_x()-xOff);
        img.setY(GetM_y()-yOff);

        DrawBody(g);

        Move();
    }

    @Override
    public void Draw(GraphicsContext g) {

    }

    /**
     * <p> This public EatBody function checks if the snake head has collided
     * with any of its own body parts.
     * </p>
     *
     * **/
    public boolean EatBody() // detects if the snake is eating its own body
    {
        for (Point point : m_bodyPoints)
        {
            for (Point point2 : m_bodyPoints)
            {
                if (point.equals(point2) && point != point2) {
                    SetM_IsLiving(false);
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * <p> This public DrawBody function draws the snakes body to the canvas
     * </p>
     *
     * @param g Takes in graphics context, so it can draw the body to the canvas
     * **/
    public void DrawBody(GraphicsContext g) // Draws the snake obj
    {
        int length = m_bodyPoints.size() - 1 - m_num;

        for (int i = length; i >= m_num; i -= m_num ){
            //System.out.println(m_num);

            Point point = m_bodyPoints.get(i);
            g.drawImage(GetM_i(), point.x, point.y);
        }
    }
    /**
     * <p> This public outofBounds checks if the snake is out rendered canvas
     * by getting the canvas width and height
     * </p>
     *
     * @param g Takes in graphics context, so it can get the canvas width and
     *         height - Type GraphicsContext
     * **/
    private void outofBounds(GraphicsContext g) {// detects if the snake is out
        // of bounds :

        int width = (int) g.getCanvas().getWidth();
        int height = (int) g.getCanvas().getHeight();

        boolean xOut =
                (GetM_x() <= 0 || GetM_x() >= (width - GetM_w()));
        boolean yOut =
                (GetM_y() <= 0 || GetM_y() >= (height - GetM_h()));

        if (xOut || yOut)
        {
            System.out.println("Out of bounds");
            SetM_IsLiving(false);
        }
    }

}



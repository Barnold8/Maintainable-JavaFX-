package Mechanics;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 *
 * This class provides functionality to multiple classes without the code
 * needing to be duplicated
 * @author Brandon
 * **/
public abstract class SnakeObj {
    /**
     * <p>
     *     Sets the x position of the object
     * </p>
     * @param m_x Takes in an int to set the x position of the object - Type int
     * **/
    public void SetM_x(int m_x) {
        this.m_x = m_x;
    }
    /**
     * <p>
     *     Sets the y position of the object
     * </p>
     * @param m_y Takes in an int to set the y position of the object - Type int
     * **/
    public void SetM_y(int m_y) {
        this.m_y = m_y;
    }
    /**
     * <p>
     *     Sets the image of the object
     * </p>
     * @param m_i Takes in an int to set the image of the object - Type int
     * **/
    public void SetM_i(Image m_i) {
        this.m_i = m_i;
    }
    /**
     * <p>
     *     Sets the width of the object
     * </p>
     * @param m_w Takes in an int to set the width of the object - Type Image
     * **/
    public void SetM_w(int m_w) {
        this.m_w = m_w;
    }
    /**
     * <p>
     *     Sets the height of the object
     * </p>
     * @param m_h Takes in an int to set the height of the object - Type int
     * **/
    public void SetM_h(int m_h) {
        this.m_h = m_h;
    }
    /**
     * <p>
     *     Sets the is living boolean variable of the object
     * </p>
     * @param m_IsLiving Takes in a boolean to set the living status of the
     *                   object - Type boolean
     * **/
    public void SetM_IsLiving(boolean m_IsLiving) {
        this.m_IsLiving = m_IsLiving;
    }
    /**
     * <p>
     *     gets the x position of the object
     * </p>
     * @return m_x returns the x position of the object - Type int
     * **/
    public int GetM_x() {
        return m_x;
    }
    /**
     * <p>
     *     gets the y position of the object
     * </p>
     * @return m_y returns the y position of the object - Type int
     * **/
    public int GetM_y() {
        return m_y;
    }
    /**
     * <p>
     *     gets the image of the object
     * </p>
     * @return m_i returns the x image of the object - Type Image
     * **/
    public Image GetM_i() {
        return m_i;
    }
    /**
     * <p>
     *     gets the width of the object
     * </p>
     * @return m_w returns the width of the object - Type int
     * **/
    public int GetM_w() {
        return m_w;
    }
    /**
     * <p>
     *     gets the height of the object
     * </p>
     * @return m_h returns the height of the object - Type int
     * **/
    public int GetM_h() {
        return m_h;
    }
    /**
     * <p>
     *     gets the living status of the object
     * </p>
     * @return m_IsLiving returns the height of the object - Type boolean
     * **/
    public boolean GetM_IsLiving() {
        return m_IsLiving;
    }
    /**
     * <p>
     *     gets the rectangle of the object
     * </p>
     * @return new Rectangle returns a new rectangle based on the x y width
     * and height variables in the object - Type Rectangle
     * **/
    public Rectangle GetRectangle()
    {
        return new Rectangle(m_x, m_y, m_w, m_h);
    }
    private int m_x;
    private int m_y;
    private Image m_i;
    private int m_w;
    private int m_h;
    private boolean m_IsLiving;

    /**
     * <p>
     *     Draws an imageView to the canvas
     * </p>
     * @param g - Takes graphics context to draw to - Type GraphicsContext
     * @param img - Takes ImageView to draw specific Image to canvas - Type
     *            ImageView
     * **/
    public abstract void Draw(GraphicsContext g, ImageView img);
    /**
     * <p>
     *     Draws anything to the canvas
     * </p>
     * @param g - Takes graphics context to draw to - Type GraphicsContext
     * **/
    public abstract void Draw(GraphicsContext g);


}

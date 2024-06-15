package MVC;

import javafx.scene.canvas.GraphicsContext;


import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

/**
 *
 *
 * <p> This class controls the snake game loop
 * </p>
 *@author Brandon
 * **/
public class SnakeController {

    private SnakeModel m_model;


    /**

     * <p> This constructor enforces a model to be set by default so the data
     * can be consistent through the MVC
     * </p>
     * @param model - Takes in model to keep data consistant - Type
     *              SnakeModel model
     * **/
    public SnakeController(SnakeModel model) {
        this.m_model = model;
    }

    /**
     * <p> This public keyPressed function listens to the WASD keys to control
     * the movement of the snake. This is done
     * by gettting the snake from the model and then calling the snake functions
     * </p>
     *
     *
     * @param e - Takes in a keyevent so the program can actually listen to the
     *          keycalls - Type KeyEvent
     * @param sHead - Takes in an ImageView to rotate the head image - Type
     *              ImageView
     *
     * **/
    public void keyPressed(KeyEvent e, ImageView sHead) {
        int UP = -90;
        int DOWN = 90;
        int RIGHT = 0;
        int LEFT = 180;
        try {
            switch (e.getCode()) {
                case W:
                    if (!m_model.GetM_snake().Get_down()) {
                        m_model.GetM_snake().SetM_up(true);
                        m_model.GetM_snake().SetM_left(false);
                        m_model.GetM_snake().SetM_right(false);
                        sHead.setRotate(UP);
                    }
                    break;
                case S:
                    if (!m_model.GetM_snake().Get_up()) {
                        m_model.GetM_snake().SetM_left(false);
                        m_model.GetM_snake().SetM_right(false);
                        m_model.GetM_snake().SetM_down(true);
                        sHead.setRotate(DOWN);
                    }
                    break;

                case D:
                    if (!m_model.GetM_snake().Get_left()) {
                        m_model.GetM_snake().SetM_up(false);
                        m_model.GetM_snake().SetM_left(false);
                        m_model.GetM_snake().SetM_right(true);
                        m_model.GetM_snake().SetM_down(false);
                        sHead.setRotate(RIGHT);
                    }
                    break;
                case A:
                    if (!m_model.GetM_snake().Get_right()) {
                        m_model.GetM_snake().SetM_up(false);
                        m_model.GetM_snake().SetM_left(true);
                        m_model.GetM_snake().SetM_right(false);
                        m_model.GetM_snake().SetM_down(false);
                        sHead.setRotate(LEFT);
                    }
                    break;
            }
        }
        catch (Exception ignored){}
    }

    /**
     * <p> This class defines the entrypoint of the program.
     * It loads the main menu FXML to give the main menu in the
     * JavaFX framework
     * </p>
     *
     *
     * @param g  - Takes in a graphics context object so the snakehead
     *          can be rendered accordingly. - Type
     *          GraphicsContext
     * @param img - Takes in the snake head via an image view since it is on
     *            the fxml rather than being made
     *           programatically. This is passed into the snake's draw
     *            function and the canvas is clared beforehand to
     *           avoid any artifacts - Type ImageView
     * **/
    public void RenderSnake(GraphicsContext g, ImageView img){
        int WIDTH = 1000;
        int HEIGHT = WIDTH;
        g.clearRect(0,0,HEIGHT,WIDTH);
        m_model.GetM_snake().Draw(g,img);
    }

}




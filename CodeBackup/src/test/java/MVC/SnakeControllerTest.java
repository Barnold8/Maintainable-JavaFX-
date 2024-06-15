package MVC;

import Mechanics.Snake;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import org.junit.jupiter.api.Test;

import static javafx.scene.input.KeyCode.*;
import static org.junit.jupiter.api.Assertions.*;
import javafx.scene.input.KeyCode;
class SnakeControllerTest {

    void AllFalse(Snake snake){

        snake.SetM_right(false);
        snake.SetM_left(false);
        snake.SetM_down(false);
        snake.SetM_up(false);
    }

    @Test
    void keyPressedTest1() {
        SnakeModel snakeModel = new SnakeModel(false);
        AllFalse(snakeModel.GetM_snake());
        SnakeController snakeController =
                new SnakeController(snakeModel);
        KeyEvent e = new KeyEvent(null,null,null,
                W,false,false,false,false);
        snakeController.keyPressed(e,new ImageView());
        assertTrue(!snakeModel.GetM_snake().Get_down()
                && snakeModel.GetM_snake().Get_up());

    }

    @Test
    void keyPressedTest2() {
        SnakeModel snakeModel = new SnakeModel(false);
        AllFalse(snakeModel.GetM_snake());
        SnakeController snakeController =
                new SnakeController(snakeModel);
        KeyEvent e = new KeyEvent(null,null,null,
                W,false,false,false,false);
        snakeController.keyPressed(e,new ImageView());
        assertFalse(snakeModel.GetM_snake().Get_down()
                && snakeModel.GetM_snake().Get_up());
    }

    @Test
    void keyPressedTest3() {
        SnakeModel snakeModel = new SnakeModel(false);
        AllFalse(snakeModel.GetM_snake());
        SnakeController snakeController =
                new SnakeController(snakeModel);
        KeyEvent e = new KeyEvent(null,null,null,
                A,false,false,false,false);
        snakeModel.GetM_snake().SetM_right(false);
        snakeController.keyPressed(e,new ImageView());

        assertTrue(!snakeModel.GetM_snake().Get_right()
                && snakeModel.GetM_snake().Get_left());

    }

    @Test
    void keyPressedTest4() {
        SnakeModel snakeModel = new SnakeModel(false);
        AllFalse(snakeModel.GetM_snake());
        SnakeController snakeController =
                new SnakeController(snakeModel);
        KeyEvent e = new KeyEvent(null,null,null,
                A,false,false,false,false);
        snakeModel.GetM_snake().SetM_right(false);
        snakeController.keyPressed(e,new ImageView());

        assertFalse(snakeModel.GetM_snake().Get_right()
                && snakeModel.GetM_snake().Get_left());

    }
    @Test
    void keyPressedTest5() {
        SnakeModel snakeModel = new SnakeModel(false);
        AllFalse(snakeModel.GetM_snake());
        SnakeController snakeController =
                new SnakeController(snakeModel);
        KeyEvent e = new KeyEvent(null,null,null,
                S,false,false,false,false);

        snakeController.keyPressed(e,new ImageView());

        assertTrue(!snakeModel.GetM_snake().Get_up()
                && snakeModel.GetM_snake().Get_down());

    }

    @Test
    void keyPressedTest6() {
        SnakeModel snakeModel = new SnakeModel(false);
        AllFalse(snakeModel.GetM_snake());
        SnakeController snakeController =
                new SnakeController(snakeModel);
        KeyEvent e = new KeyEvent(null,null,null,
                S,false,false,false,false);

        snakeController.keyPressed(e,new ImageView());

        assertFalse(snakeModel.GetM_snake().Get_up()
                && snakeModel.GetM_snake().Get_down());

    }

    @Test
    void keyPressedTest7() {
        SnakeModel snakeModel = new SnakeModel(false);
        AllFalse(snakeModel.GetM_snake());
        SnakeController snakeController =
                new SnakeController(snakeModel);
        KeyEvent e = new KeyEvent(null,null,null,
                D,false,false,false,false);

        snakeController.keyPressed(e,new ImageView());

        assertTrue(!snakeModel.GetM_snake().Get_left()
                && snakeModel.GetM_snake().Get_right());

    }

    @Test
    void keyPressedTest8() {
        SnakeModel snakeModel = new SnakeModel(false);
        AllFalse(snakeModel.GetM_snake());
        SnakeController snakeController =
                new SnakeController(snakeModel);
        KeyEvent e = new KeyEvent(null,null,null,
                D,false,false,false,false);

        snakeController.keyPressed(e,new ImageView());

        assertFalse(snakeModel.GetM_snake().Get_left()
                && snakeModel.GetM_snake().Get_right());

    }
}
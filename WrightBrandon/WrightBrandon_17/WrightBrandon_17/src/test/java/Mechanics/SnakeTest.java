package Mechanics;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SnakeTest {

    @Test
    void moveTest1() {
        Snake snake = new Snake(100,100);
        int x = snake.GetM_x();
        snake.Move();
        assertNotEquals(x,snake.GetM_x());
    }

    @Test
    void moveTest2() {
        Snake snake = new Snake(100,100);
        int y = snake.GetM_y();
        snake.Move();
        assertEquals(y,snake.GetM_y());
    }

    @Test
    void moveTest3() {
        Snake snake = new Snake(100,100);
        int x = snake.GetM_x();
        snake.SetM_speed_XY(-1);
        snake.Move();
        assertNotEquals(x,snake.GetM_x());
    }

    @Test
    void moveTest4() {
        Snake snake = new Snake(100,100);
        int y = snake.GetM_y();
        snake.SetM_down(true);
        snake.Move();
        assertNotEquals(y,snake.GetM_y());
    }

    @Test
    void randSpotTest1() {
        GraphicsContext graphicsContext = new Canvas().getGraphicsContext2D();
        Snake snake = new Snake(10,10);
        int x = snake.GetM_x();
        snake.RandSpot(graphicsContext);
        assertNotEquals(x,snake.GetM_x());
    }

    @Test
    void randSpotTest2() {
        GraphicsContext graphicsContext = new Canvas().getGraphicsContext2D();
        Snake snake = new Snake(10,10);
        int y = snake.GetM_y();
        snake.RandSpot(graphicsContext);
        assertNotEquals(y,snake.GetM_y());
    }


    @Test
    void eatBodyTest1() {
        Snake snake = new Snake(10,10);
        assertFalse(snake.EatBody());
    }
    @Test
    void eatBodyTest2() {
        Snake snake = new Snake(10,10);
        snake.Move();
        assertFalse(snake.EatBody());
    }

    @Test
    void eatBodyTest3() {
        Snake snake = new Snake(10,10);
        snake.SetLength(10);
        snake.Move();
        assertFalse(snake.EatBody());
    }


    @Test
    void eatBodyTest4() {
        GraphicsContext graphicsContext = new Canvas().getGraphicsContext2D();
        ImageView img = new ImageView();
        Snake snake = new Snake(100,10);
        List<Point> body = new LinkedList<>();
        body.add(new Point(100,10));
        body.add(new Point(100,10));
        snake.SetM_bodyPoints(body);
        assertTrue(snake.EatBody());
    }

}
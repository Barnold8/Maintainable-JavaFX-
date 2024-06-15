package Mechanics;

import MVC.SnakeModel;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerUpTest {

    @Test
    void eatenTest1() {
        PowerUp powerUp = new PowerUp(10,10);
        SnakeModel snakeModel = new SnakeModel(false);
        GraphicsContext graphicsContext = new Canvas().getGraphicsContext2D();

        assertTrue(powerUp.Eaten(
                new Snake(1, 1), graphicsContext, new Tree()
        ));
    }

    @Test
    void eatenTest2() {
        PowerUp powerUp = new PowerUp(100,10);
        SnakeModel snakeModel = new SnakeModel(false);
        GraphicsContext graphicsContext = new Canvas().getGraphicsContext2D();
        assertFalse(powerUp.Eaten(
                new Snake(1, 1), graphicsContext, new Tree()
        ));
    }
    @Test
    void eatenTest3() {
        PowerUp powerUp = new PowerUp(10,10);
        SnakeModel snakeModel = new SnakeModel(false);
        GraphicsContext graphicsContext = new Canvas().getGraphicsContext2D();
        int powerX = powerUp.GetM_x();
        powerUp.Eaten(
                new Snake(1, 1), graphicsContext, new Tree());
        assertTrue(powerX != powerUp.GetM_x());
    }
    @Test
    void eatenTest4() {
        PowerUp powerUp = new PowerUp(10,10);
        SnakeModel snakeModel = new SnakeModel(false);
        GraphicsContext graphicsContext = new Canvas().getGraphicsContext2D();
        int powerY = powerUp.GetM_x();
        powerUp.Eaten(
                new Snake(1, 1), graphicsContext, new Tree());
        assertTrue(powerY != powerUp.GetM_y());
    }
    @Test
    void eatenTest5() {
        PowerUp powerUp = new PowerUp(100,100);
        SnakeModel snakeModel = new SnakeModel(false);
        GraphicsContext graphicsContext = new Canvas().getGraphicsContext2D();
        int powerX = powerUp.GetM_x();
        powerUp.Eaten(
                new Snake(1, 1), graphicsContext, new Tree());
        assertFalse(powerX != powerUp.GetM_x());
    }
    @Test
    void eatenTest6() {
        PowerUp powerUp = new PowerUp(100,100);
        SnakeModel snakeModel = new SnakeModel(false);
        GraphicsContext graphicsContext = new Canvas().getGraphicsContext2D();
        int powerY = powerUp.GetM_x();
        powerUp.Eaten(
                new Snake(1, 1), graphicsContext, new Tree());
        assertFalse(powerY != powerUp.GetM_y());
    }


    @Test
    void inTreeTest1() {
        PowerUp powerUp = new PowerUp(300,300);
        Tree tree = new Tree();
        assertTrue(powerUp.InTree(powerUp,tree));
    }
    @Test
    void inTreeTest2() {
        PowerUp powerUp = new PowerUp(10,20);
        Tree tree = new Tree();
        assertFalse(powerUp.InTree(powerUp,tree));
    }

    @Test
    void inTreeTest3() {
        PowerUp powerUp = new PowerUp(10,20);
        Tree tree = new Tree(10,60,1);
        assertTrue(powerUp.InTree(powerUp,tree));
    }
    @Test
    void inTreeTest4() {
        PowerUp powerUp = new PowerUp(10,20);
        Tree tree = new Tree(230,100,1);
        assertFalse(powerUp.InTree(powerUp,tree));
    }

    @Test
    void inTreeTest5() {
        PowerUp powerUp = new PowerUp(10,20);
        Tree tree = new Tree(40,10,2);
        assertTrue(powerUp.InTree(powerUp,tree));
    }
    @Test
    void inTreeTest6() {
        PowerUp powerUp = new PowerUp(10,20);
        Tree tree = new Tree(230,100,2);
        assertFalse(powerUp.InTree(powerUp,tree));
    }

    @Test
    void inTreeTest7() {
        PowerUp powerUp = new PowerUp(10,20);
        Tree tree = new Tree(40,10,3);
        assertTrue(powerUp.InTree(powerUp,tree));
    }
    @Test
    void inTreeTest8() {
        PowerUp powerUp = new PowerUp(10,20);
        Tree tree = new Tree(230,100,3);
        assertFalse(powerUp.InTree(powerUp,tree));
    }

    @Test
    void inTreeTest9() {
        PowerUp powerUp = new PowerUp(10,20);
        Tree tree = new Tree(40,10,4);
        assertTrue(powerUp.InTree(powerUp,tree));
    }
    @Test
    void inTreeTest10() {
        PowerUp powerUp = new PowerUp(10,20);
        Tree tree = new Tree(230,100,4);
        assertFalse(powerUp.InTree(powerUp,tree));
    }

    @Test
    void inTreeTest11() {
        PowerUp powerUp = new PowerUp(10,20);
        Tree tree = new Tree(40,10,5);
        assertTrue(powerUp.InTree(powerUp,tree));
    }
    @Test
    void inTreeTest12() {
        PowerUp powerUp = new PowerUp(10,20);
        Tree tree = new Tree(230,100,5);
        assertFalse(powerUp.InTree(powerUp,tree));
    }
    @Test
    void inTreeTest13() {
        PowerUp powerUp = new PowerUp(10,20);
        Tree tree = new Tree(40,10,6);
        assertTrue(powerUp.InTree(powerUp,tree));
    }
    @Test
    void inTreeTest14() {
        PowerUp powerUp = new PowerUp(10,20);
        Tree tree = new Tree(230,100,6);
        assertFalse(powerUp.InTree(powerUp,tree));
    }
    @Test
    void inTreeTest15() {
        PowerUp powerUp = new PowerUp(10,20);
        Tree tree = new Tree(40,10,7);
        assertTrue(powerUp.InTree(powerUp,tree));
    }
    @Test
    void inTreeTest16() {
        PowerUp powerUp = new PowerUp(10,20);
        Tree tree = new Tree(230,100,7);
        assertFalse(powerUp.InTree(powerUp,tree));
    }

    @Test
    void PowerUpConsTest1(){
        PowerUp powerUp = new PowerUp(10,10);
        assertNotNull(powerUp);
    }

    @Test
    void PowerUpConsTest2(){
        PowerUp powerUp = new PowerUp(10,10);
        assertNotNull(powerUp.GetM_i());
    }

    @Test
    void PowerUpConsTest3(){
        PowerUp powerUp = new PowerUp(10,10);
        assertTrue(powerUp.GetM_IsLiving());
    }


}
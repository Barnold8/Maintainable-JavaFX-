package Mechanics;


import MVC.SnakeModel;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import org.junit.Rule;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class FoodTest {


    @Test
    void eatenTest1() {
        Food food = new Food();
        SnakeModel snakeModel = new SnakeModel(false);
        GraphicsContext graphicsContext = new Canvas().getGraphicsContext2D();

        assertFalse(food.Eaten(
                new Snake(1, 1), graphicsContext, new Tree(700,100),
                snakeModel
        ));
    }

    @Test
    void eatenTest2() {
        Food food = new Food();
        SnakeModel snakeModel = new SnakeModel(false);
        GraphicsContext graphicsContext = new Canvas().getGraphicsContext2D();

        assertTrue(food.Eaten(
                new Snake(1, 1), graphicsContext, new Tree(),
                snakeModel
        ));
    }
    @Test
    void eatenTest3() {
        Food food = new Food();
        SnakeModel snakeModel = new SnakeModel(false);
        GraphicsContext graphicsContext = new Canvas().getGraphicsContext2D();
        int foodX = food.GetM_x();
        food.Eaten(
                new Snake(1, 1), graphicsContext, new Tree(),
                snakeModel);
        assertNotEquals(foodX, food.GetM_x());
    }
    @Test
    void eatenTest4() {
        Food food = new Food();
        SnakeModel snakeModel = new SnakeModel(false);
        GraphicsContext graphicsContext = new Canvas().getGraphicsContext2D();
        int foodY = food.GetM_y();
        food.Eaten(
                new Snake(1, 1), graphicsContext, new Tree(),
                snakeModel);
        assertNotEquals(foodY, food.GetM_y());
    }
    @Test
    void eatenTest6() {
        Food food = new Food(100,100);
        SnakeModel snakeModel = new SnakeModel(false);
        GraphicsContext graphicsContext = new Canvas().getGraphicsContext2D();
        int foodX = food.GetM_x();
        food.Eaten(
                new Snake(1, 1), graphicsContext, new Tree(),
                snakeModel);
        assertEquals(foodX, food.GetM_x());
    }
    @Test
    void eatenTest7() {
        Food food = new Food(100,100);
        SnakeModel snakeModel = new SnakeModel(false);
        GraphicsContext graphicsContext = new Canvas().getGraphicsContext2D();
        int foodY = food.GetM_y();
        food.Eaten(
                new Snake(1, 1), graphicsContext, new Tree(),
                snakeModel);
        assertEquals(foodY, food.GetM_y());
    }

    @Test
    void inTreeTest1() {
        Food food = new Food();
        Tree tree = new Tree();
        assertTrue(food.InTree(food,tree));
    }
    @Test
    void inTreeTest2() {
        Food food = new Food(10,20);
        Tree tree = new Tree();
        assertFalse(food.InTree(food,tree));
    }

    @Test
    void inTreeTest3() {
        Food food = new Food(10,20);
        Tree tree = new Tree(40,10,1);
        assertTrue(food.InTree(food,tree));
    }
    @Test
    void inTreeTest4() {
        Food food = new Food(10,20);
        Tree tree = new Tree(10,60,1);
        assertFalse(food.InTree(food,tree));
    }

    @Test
    void inTreeTest5() {
        Food food = new Food(10,20);
        Tree tree = new Tree(40,10,2);
        assertTrue(food.InTree(food,tree));
    }
    @Test
    void inTreeTest6() {
        Food food = new Food(10,20);
        Tree tree = new Tree(10,60,2);
        assertFalse(food.InTree(food,tree));
    }

    @Test
    void inTreeTest7() {
        Food food = new Food(10,20);
        Tree tree = new Tree(40,10,3);
        assertTrue(food.InTree(food,tree));
    }
    @Test
    void inTreeTest8() {
        Food food = new Food(10,20);
        Tree tree = new Tree(10,60,3);
        assertFalse(food.InTree(food,tree));
    }

    @Test
    void inTreeTest9() {
        Food food = new Food(10,20);
        Tree tree = new Tree(40,10,4);
        assertTrue(food.InTree(food,tree));
    }
    @Test
    void inTreeTest10() {
        Food food = new Food(10,20);
        Tree tree = new Tree(10,60,4);
        assertFalse(food.InTree(food,tree));
    }

    @Test
    void inTreeTest11() {
        Food food = new Food(10,20);
        Tree tree = new Tree(40,10,5);
        assertTrue(food.InTree(food,tree));
    }
    @Test
    void inTreeTest12() {
        Food food = new Food(10,20);
        Tree tree = new Tree(10,60,5);
        assertFalse(food.InTree(food,tree));
    }
    @Test
    void inTreeTest13() {
        Food food = new Food(10,20);
        Tree tree = new Tree(40,10,6);
        assertTrue(food.InTree(food,tree));
    }
    @Test
    void inTreeTest14() {
        Food food = new Food(10,20);
        Tree tree = new Tree(10,60,6);
        assertFalse(food.InTree(food,tree));
    }
    @Test
    void inTreeTest15() {
        Food food = new Food(10,20);
        Tree tree = new Tree(40,10,7);
        assertTrue(food.InTree(food,tree));
    }
    @Test
    void inTreeTest16() {
        Food food = new Food(10,20);
        Tree tree = new Tree(10,60,7);
        assertFalse(food.InTree(food,tree));
    }

    @Test
    void FoodConsTest1(){
        Food food = new Food();
        assertTrue(food.GetM_IsLiving());
    }

    @Test
    void FoodConsTest2(){
        Food food = new Food();
        assertEquals(300,food.GetM_x());
    }
    @Test
    void FoodConsTest3(){
        Food food = new Food();
        assertEquals(300,food.GetM_y());
    }
    @Test
    void FoodConsTest4(){
        Food food = new Food();
        assertNotNull(food.GetM_i());
    }

    @Test
    void FoodConsTest5(){
        Food food = new Food();
        assertNotNull(food);
    }

    @Test
    void FoodConsTest6(){
        Food food = new Food(100,0);
        assertEquals(100,food.GetM_x());
    }
    @Test
    void FoodConsTest7(){
        Food food = new Food(0,100);
        assertEquals(100,food.GetM_y());
    }

    @Test
    void FoodSetX(){
        Food food = new Food();
        food.SetM_x(100);
        assertEquals(100,food.GetM_x());
    }
    @Test
    void FoodSetY(){
        Food food = new Food();
        food.SetM_y(100);
        assertEquals(100,food.GetM_y());
    }


}
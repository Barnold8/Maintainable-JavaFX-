package Mechanics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @Test
    void collideTest1() {
        Tree tree = new Tree();
        Snake snake = new Snake(300,300);
        assertTrue(tree.Collide(snake));
    }
    @Test
    void collideTest2() {
        Tree tree = new Tree();
        Snake snake = new Snake(1,2);
        assertFalse(tree.Collide(snake));
    }
    @Test
    void collideTest3() {
        Tree tree = new Tree(300,300,1);
        Snake snake = new Snake(300,300);
        assertTrue(tree.Collide(snake));
    }
    @Test
    void collideTest4() {
        Tree tree = new Tree(300,300,1);
        Snake snake = new Snake(1,2);
        assertFalse(tree.Collide(snake));
    }
    @Test
    void collideTest5() {
        Tree tree = new Tree(300,300,2);
        Snake snake = new Snake(300,300);
        assertTrue(tree.Collide(snake));
    }
    @Test
    void collideTest6() {
        Tree tree = new Tree(300,300,2);
        Snake snake = new Snake(1,2);
        assertFalse(tree.Collide(snake));
    }
    @Test
    void collideTest7() {
        Tree tree = new Tree(300,300,3);
        Snake snake = new Snake(300,300);
        assertTrue(tree.Collide(snake));
    }
    @Test
    void collideTest8() {
        Tree tree = new Tree(300,300,3);
        Snake snake = new Snake(1,2);
        assertFalse(tree.Collide(snake));
    }
    @Test
    void collideTest9() {
        Tree tree = new Tree(300,300,4);
        Snake snake = new Snake(300,300);
        assertTrue(tree.Collide(snake));
    }
    @Test
    void collideTest10() {
        Tree tree = new Tree(300,300,4);
        Snake snake = new Snake(1,2);
        assertFalse(tree.Collide(snake));
    }
    @Test
    void collideTest11() {
        Tree tree = new Tree(300,300,5);
        Snake snake = new Snake(300,300);
        assertTrue(tree.Collide(snake));
    }
    @Test
    void collideTest12() {
        Tree tree = new Tree(300,300,5);
        Snake snake = new Snake(1,2);
        assertFalse(tree.Collide(snake));
    }
    @Test
    void collideTest13() {
        Tree tree = new Tree(300,300,6);
        Snake snake = new Snake(300,300);
        assertTrue(tree.Collide(snake));
    }
    @Test
    void collideTest14() {
        Tree tree = new Tree(300,300,6);
        Snake snake = new Snake(1,2);
        assertFalse(tree.Collide(snake));
    }
    @Test
    void collideTest15() {
        Tree tree = new Tree(300,300,7);
        Snake snake = new Snake(300,300);
        assertTrue(tree.Collide(snake));
    }
    @Test
    void collideTest16() {
        Tree tree = new Tree(300,300,7);
        Snake snake = new Snake(1,2);
        assertFalse(tree.Collide(snake));
    }

    @Test
    void TreeConsTest1(){
        Tree tree = new Tree();
        assertNotNull(tree);
    }
    @Test
    void TreeConsTest2(){
        Tree tree = new Tree();
        int x = tree.GetM_x();
        assertEquals(x,300);
    }
    @Test
    void TreeConsTest3(){
        Tree tree = new Tree();
        int y = tree.GetM_y();
        assertEquals(y,300);
    }

}
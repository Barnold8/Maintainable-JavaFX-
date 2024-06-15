package Mechanics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
class EnemyTest {


    @Test
    void inTreeTest1() {
        Tree tree = new Tree();
        Enemy enemy = new Enemy();
        assertTrue(enemy.InTree(tree));
    }

    @Test
    void inTreeTest2() {
        Tree tree = new Tree(100, 100);
        Enemy enemy = new Enemy();
        assertFalse(enemy.InTree(tree));
    }

    @Test
    void inTreeTest3() {
        Tree tree = new Tree(100, 200, 0);
        Enemy enemy = new Enemy(100, 300);
        assertFalse(enemy.InTree(tree));
    }

    @Test
    void inTreeTest4() {
        Tree tree = new Tree(100, 200);
        Enemy enemy = new Enemy(105, 200);
        assertTrue(enemy.InTree(tree));
    }

    @Test
    void inTreeTest5() {
        Tree tree = new Tree(100, 200, 1);
        Enemy enemy = new Enemy(120, 200);
        assertTrue(enemy.InTree(tree));
    }

    @Test
    void inTreeTest6() {
        Tree tree = new Tree(100, 200, 2);
        Enemy enemy = new Enemy(120, 200);
        assertTrue(enemy.InTree(tree));
    }

    @Test
    void inTreeTest7() {
        Tree tree = new Tree(100, 200, 2);
        Enemy enemy = new Enemy(120, 400);
        assertFalse(enemy.InTree(tree));
    }

    @Test
    void inTreeTest8() {
        Tree tree = new Tree(100, 200, 3);
        Enemy enemy = new Enemy(160, 200);
        assertTrue(enemy.InTree(tree));
    }

    @Test
    void inTreeTest9() {
        Tree tree = new Tree(100, 200, 3);
        Enemy enemy = new Enemy(400, 200);
        assertFalse(enemy.InTree(tree));
    }

    @Test
    void inTreeTest10() {
        Tree tree = new Tree(100, 200, 4);
        Enemy enemy = new Enemy(100, 200);
        assertTrue(enemy.InTree(tree));
    }

    @Test
    void inTreeTest11() {
        Tree tree = new Tree(250, 200, 4);
        Enemy enemy = new Enemy(450, 250);
        assertFalse(enemy.InTree(tree));
    }

    @Test
    void inTreeTest12() {
        Tree tree = new Tree(100, 200, 5);
        Enemy enemy = new Enemy(100, 200);
        assertTrue(enemy.InTree(tree));
    }

    @Test
    void inTreeTest13() {
        Tree tree = new Tree(250, 200, 5);
        Enemy enemy = new Enemy(450, 250);
        assertFalse(enemy.InTree(tree));
    }

    @Test
    void inTreeTest14() {
        Tree tree = new Tree(100, 200, 6);
        Enemy enemy = new Enemy(100, 200);
        assertTrue(enemy.InTree(tree));
    }

    @Test
    void inTreeTest15() {
        Tree tree = new Tree(250, 200, 6);
        Enemy enemy = new Enemy(450, 250);
        assertFalse(enemy.InTree(tree));
    }

    @Test
    void inTreeTest17() {
        Tree tree = new Tree(100, 200, 7);
        Enemy enemy = new Enemy(100, 200);
        assertTrue(enemy.InTree(tree));
    }

    @Test
    void inTreeTest18() {
        Tree tree = new Tree(250, 200, 7);
        Enemy enemy = new Enemy(450, 250);
        assertFalse(enemy.InTree(tree));
    }

    @Test
    void inTreeTest20() {
        Tree tree = new Tree(100, 200, 7);
        Enemy enemy = new Enemy(100, 200);
        assertTrue(enemy.InTree(tree));
    }

    @Test
    void inTreeTest21() {
        Tree tree = new Tree(250, 200, 7);
        Enemy enemy = new Enemy(450, 250);
        assertFalse(enemy.InTree(tree));
    }

    @Test
    void collideTest1() {
        Enemy enemy = new Enemy(0, 0);
        assertTrue(enemy.Collide(new Snake(0, 0)));
    }

    @Test
    void collideTest2() {
        Enemy enemy = new Enemy();
        assertTrue(enemy.Collide(new Snake(300, 300)));
    }

    @Test
    void collideTest3() {
        Enemy enemy = new Enemy(1000, 1000);
        assertFalse(enemy.Collide(new Snake(300, 300)));
    }

    @Test
    void collideTest4() {
        Enemy enemy = new Enemy(1000, 1000);
        assertTrue(enemy.Collide(new Snake(1000, 1000)));
    }

    @Test
    void collideTest5() {
        Enemy enemy = new Enemy(105, 1000);
        assertTrue(enemy.Collide(new Snake(105, 1000)));
    }

    @Test
    void collideTest6() {
        Enemy enemy = new Enemy(1000, 1005);
        assertTrue(enemy.Collide(new Snake(1000, 1005)));
    }
    @Test
    void collideTest7() {
        Enemy enemy = new Enemy(0,1000);
        assertFalse(enemy.Collide(new Snake(1000,1000)));
    }
    @Test
    void collideTest8() {
        Enemy enemy = new Enemy(10,1000);
        assertFalse(enemy.Collide(new Snake(105,1000)));
    }
    @Test
    void collideTest9() {
        Enemy enemy = new Enemy(1,13);
        assertFalse(enemy.Collide(new Snake(1000,1005)));
    }

    @Test
    void EnemyConsDefXSpeedTest(){
        Enemy e = new Enemy();
        assertEquals(e.GetXSpeed(), 1);
    }

    @Test
    void EnemyConsDefYSpeedTest(){
        Enemy e = new Enemy();
        assertEquals(e.GetYSpeed(), 1);
    }

    @Test
    void EnemyObjTest1(){
        Enemy e = new Enemy();
        assertNotNull(e);
    }

    @Test
    void EnemyObjTest2(){
        Enemy e = new Enemy();
        assertNotNull(e.GetM_i());
    }

}
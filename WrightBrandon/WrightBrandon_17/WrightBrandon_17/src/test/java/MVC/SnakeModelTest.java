package MVC;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakeModelTest {

    @Test
    void SnakeModelTest1(){

        SnakeModel snakeModel = new SnakeModel(false);
        assertNotNull(snakeModel);

    }

    @Test
    void SnakeModelTest2(){

        SnakeModel snakeModel = new SnakeModel(false);
        assertNotNull(snakeModel.GetM_snake());

    }

    @Test
    void SnakeModelTest3(){

        SnakeModel snakeModel = new SnakeModel(false);
        assertNotNull(snakeModel.GetGameState());

    }

    @Test
    void SnakeModelTest4(){

        SnakeModel snakeModel = new SnakeModel(false);
        assertNotNull(snakeModel.GetM_enemy());

    }
    @Test
    void SnakeModelTest5(){

        SnakeModel snakeModel = new SnakeModel(false);
        assertNotNull(snakeModel.GetM_levelPath());

    }

    @Test
    void SnakeModelTest6(){

        SnakeModel snakeModel = new SnakeModel(false);
        assertNotNull(snakeModel.GetM_food());

    }
    @Test
    void SnakeModelTest7(){

        SnakeModel snakeModel = new SnakeModel(false);
        assertNotNull(snakeModel.GetM_factory());

    }
    @Test
    void SnakeModelTest8(){

        SnakeModel snakeModel = new SnakeModel(false);
        assertNotNull(snakeModel.GetM_powerUp());

    }
    @Test
    void SnakeModelTest9(){

        SnakeModel snakeModel = new SnakeModel(false);
        assertNotNull(snakeModel.GetM_themePath());

    }

    @Test
    void SnakeModelTest10(){

        SnakeModel snakeModel = new SnakeModel(false);
        assertNotNull(snakeModel.GetM_Trees());

    }

}
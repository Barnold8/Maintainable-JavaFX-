package Mechanics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateTest {

    @Test
    void upDateStateTest1() {
        Snake snake = new Snake(10,10);
        State state = new State(State.GameState.Preload);
        boolean updated = state.UpDateState(snake);
        assertFalse(updated);
    }
    @Test
    void upDateStateTest2() {
        Snake snake = new Snake(10,10);
        State state = new State(State.GameState.Preload);
        snake.SetM_IsLiving(false);
        boolean updated = state.UpDateState(snake);
        assertTrue(updated);
    }



}
package com.akocakaya.supermario.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class StateManager {

    private Stack<State> states;

    public StateManager() {
        states = new Stack<State>();
    }

    public void render(SpriteBatch spriteBatch) {
        states.peek().render(spriteBatch);
    }

    public void update(float delta) {
        states.peek().update(delta);
    }

    public void pushState(State state) {
        states.push(state);
    }

    public void popState() {
        states.pop();
    }
}

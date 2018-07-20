package com.akocakaya.supermario.inputhandler;

import com.akocakaya.supermario.gameObject.GameWorld;
import com.akocakaya.supermario.gameObject.mario.Mario;
import com.akocakaya.supermario.states.MenuState;
import com.akocakaya.supermario.states.StageState;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public class StageStateInput implements InputProcessor {

    private StageState stageState;

    private Mario moving;

    public StageStateInput(StageState stageState, GameWorld gameWorld) {
        this.stageState = stageState;

        moving = gameWorld.getMario();
    }

    @Override
    public boolean keyDown(int keycode) {
        Body body = stageState.getGameWorld().getMario().getBody();

        if (Input.Keys.ESCAPE == keycode)
            stageState.getStateManager().pushState(new MenuState(stageState.getStateManager()));

        if (Input.Keys.W == keycode)
            body.applyLinearImpulse(new Vector2(0, 4f), body.getWorldCenter(), true);
        if (Input.Keys.D == keycode)
            moving.setRight(true);
        if (Input.Keys.A == keycode)
            moving.setLeft(true);

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {

        if (Input.Keys.D == keycode)
            moving.setRight(false);
        if (Input.Keys.A == keycode)
            moving.setLeft(false);

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}

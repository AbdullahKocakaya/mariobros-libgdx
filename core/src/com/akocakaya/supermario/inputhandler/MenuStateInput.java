package com.akocakaya.supermario.inputhandler;

import com.akocakaya.supermario.states.MenuState;
import com.akocakaya.supermario.states.StageState;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

import static com.badlogic.gdx.Input.Keys.*;

public class MenuStateInput implements InputProcessor {

    private MenuState menuState;

    public MenuStateInput(MenuState menuState) {
        this.menuState = menuState;
    }

    @Override
    public boolean keyDown(int keycode) {

        switch (keycode) {
            case W:
                if (menuState.getyCord() < 300)
                    menuState.setyCord(menuState.getyCord() + 24);
                break;
            case S:
                if (menuState.getyCord() > 290)
                    menuState.setyCord(menuState.getyCord() - 24);
                break;
            case A:
                if (menuState.getxCord() > 200)
                    menuState.setxCord(menuState.getxCord() - 333);
                break;
            case D:
                if (menuState.getxCord() < 600)
                    menuState.setxCord(menuState.getxCord() + 333);
                break;
            case ENTER:
                if (menuState.getxCord() == 117.0 && menuState.getyCord() == 307.0)
                    menuState.getStateManager().pushState(new StageState(menuState.getStateManager()));
            default:
                break;
        }

        Gdx.app.log("Position", " " + menuState.getxCord() + " ," + menuState.getyCord());

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
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

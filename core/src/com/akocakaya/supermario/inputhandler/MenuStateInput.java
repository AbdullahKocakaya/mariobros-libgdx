package com.akocakaya.supermario.inputhandler;

import com.akocakaya.supermario.states.MenuState;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class MenuStateInput implements InputProcessor {

    private MenuState menuState;

    public MenuStateInput(MenuState menuState) {
        this.menuState = menuState;
    }

    @Override
    public boolean keyDown(int keycode) {

        switch (keycode) {
            case Input.Keys.W:
                if (menuState.getyCord() < 300)
                    menuState.setyCord(menuState.getyCord() + 29);
                break;
            case Input.Keys.S:
                if (menuState.getyCord() > 290)
                    menuState.setyCord(menuState.getyCord() - 29);
                break;
            case Input.Keys.A:
                if (menuState.getxCord() > 200)
                    menuState.setxCord(menuState.getxCord() - 333);
                break;
            case Input.Keys.D:
                if (menuState.getxCord() < 600)
                    menuState.setxCord(menuState.getxCord() + 333);
                break;
            default:
                break;
        }

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

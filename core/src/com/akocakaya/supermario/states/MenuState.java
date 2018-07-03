package com.akocakaya.supermario.states;

import com.akocakaya.supermario.ImageLoader.ImageLoader;
import com.akocakaya.supermario.inputhandler.MenuStateInput;
import com.akocakaya.supermario.stageobject.TableWriter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MenuState extends State {

    private Stage stage;

    private float yCord = 307;
    private float xCord = 117;

    public MenuState(StateManager stateManager) {
        super(stateManager);


        Viewport viewport = new ScreenViewport(camera);
        camera.setToOrtho(false);       //flip
        stage = new Stage(viewport);

        Gdx.input.setInputProcessor(new MenuStateInput(this));

        TableWriter tableWriter = new TableWriter(3, 2, "Stage1", "Stage2", "Stage3", "Stage4", "Stage5", "Stage6");

        stage.addActor(tableWriter.getTable());

        Gdx.app.log("Table", "Stages written");
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(ImageLoader.stagePointerRegion, xCord, yCord, 15, 15);
        spriteBatch.end();
        stage.draw();
    }

    @Override
    public void update(float delta) {

    }

    public void setyCord(float yCord) {
        this.yCord = yCord;
    }

    public void setxCord(float xCord) {
        this.xCord = xCord;
    }

    public float getyCord() {
        return yCord;
    }

    public float getxCord() {
        return xCord;
    }
}

package com.akocakaya.supermario.states;

import com.akocakaya.supermario.ImageLoader.ImageLoader;
import com.akocakaya.supermario.inputhandler.MenuStateInput;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MenuState extends State {

    private Stage stage;

    private float yCord = 312;
    private float xCord = 117;

    public MenuState(StateManager stateManager) {
        super(stateManager);


        Viewport viewport = new ScreenViewport(camera);
        camera.setToOrtho(false);       //flip
        stage = new Stage(viewport);

        Gdx.input.setInputProcessor(new MenuStateInput(this));

        Table table = new Table();
        table.setFillParent(true);

        String stage1 = "State 1";
        String stage2 = "State 2";
        String stage3 = "State 3";
        String stage4 = "State 4";
        String stage5 = "State 5";
        String stage6 = "State 6";

        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);

        Label label1 = new Label(stage1, font);
        Label label2 = new Label(stage2, font);
        Label label3 = new Label(stage3, font);
        Label label4 = new Label(stage4, font);
        Label label5 = new Label(stage5, font);
        Label label6 = new Label(stage6, font);

        label1.getFontScaleX();

        table.padBottom(10);

        table.add(label1).expandX().padBottom(5);
        table.add(label2).expandX().padBottom(5);
        table.add(label3).expandX().padBottom(5);
        table.row();
        table.add(label4).expandX().padTop(5);
        table.add(label5).expandX().padTop(5);
        table.add(label6).expandX().padTop(5);

        stage.addActor(table);

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

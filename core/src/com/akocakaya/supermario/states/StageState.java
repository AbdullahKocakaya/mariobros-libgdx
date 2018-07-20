package com.akocakaya.supermario.states;

import com.akocakaya.supermario.gameObject.GameWorld;
import com.akocakaya.supermario.inputhandler.StageStateInput;
import com.akocakaya.supermario.supermario.SuperMario;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class StageState extends State {

    private StateManager stateManager;
    private GameWorld gameWorld;
    private Viewport viewport;

    public StageState(StateManager stateManager) {
        super(stateManager);

        this.stateManager = stateManager;

        viewport = new FitViewport((SuperMario.WIDTH) / SuperMario.PPM, (SuperMario.HEIGHT) / SuperMario.PPM, camera);

        camera.zoom = 0.34f / SuperMario.PPM;

        camera.setToOrtho(false);

        gameWorld = new GameWorld();

        Gdx.input.setInputProcessor(new StageStateInput(this, gameWorld));
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        gameWorld.render(spriteBatch);
        gameWorld.getBox2DDebugRenderer().render(gameWorld.getWorld(), camera.combined);
        gameWorld.getWorld().step(1/60f,6,2);
    }

    @Override
    public void update(float delta) {
        camera.update();
        gameWorld.update(delta);
        gameWorld.getRenderer().setView(camera);
      //  camera.position.x += 1 / SuperMario.PPM;
    }

    public StateManager getStateManager() {
        return stateManager;
    }

    public GameWorld getGameWorld() {
        return gameWorld;
    }
}

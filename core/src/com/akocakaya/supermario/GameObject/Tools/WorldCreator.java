package com.akocakaya.supermario.GameObject.Tools;

import com.akocakaya.supermario.GameObject.Enemy.Goomba;
import com.akocakaya.supermario.GameObject.Enemy.Turtle;
import com.akocakaya.supermario.GameObject.GameWorld;
import com.akocakaya.supermario.GameObject.InteractiveTileObject.Brick;
import com.akocakaya.supermario.GameObject.InteractiveTileObject.Coin;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;

public class WorldCreator {

    private TiledMap tiledMap;
    private BodyDef bodyDef;
    private World world;
    private PolygonShape polygonShape;
    private FixtureDef fixtureDef;
    private GameWorld gameWorld;

    public WorldCreator(GameWorld gameWorld) {
        world = gameWorld.getWorld();
        tiledMap = gameWorld.getMap().getTiledMap();
        bodyDef = new BodyDef();
        polygonShape = new PolygonShape();
        fixtureDef = new FixtureDef();
        this.gameWorld = gameWorld;

        //for ground
        tileObjectBuilder(2);
        Gdx.app.log("Tile Object","Ground created");

        //for pipes
        tileObjectBuilder(3);
        Gdx.app.log("Tile Object","Pipes created");

        //for bricks and coins
        interactiveTileObjectBuilder();

        //for goombas and turtles
        enemyBuilder();
    }

    private void tileObjectBuilder(int index) {
        for (MapObject object : tiledMap.getLayers().get(index).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rectangle = ((RectangleMapObject) object).getRectangle();

            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set((rectangle.getX() + rectangle.getWidth() / 2), (rectangle.getY() + rectangle.getHeight() / 2));

            Body body = world.createBody(bodyDef);

            polygonShape.setAsBox((rectangle.getWidth() / 2), (rectangle.getHeight() / 2));
            fixtureDef.shape = polygonShape;
            body.createFixture(fixtureDef);
        }
    }

    private void interactiveTileObjectBuilder() {
        //for coins
        for (MapObject object : tiledMap.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)) {
            new Coin(gameWorld, object);
        }
        Gdx.app.log("Interactive Tile Object","Coins created");

        //for bricks
        for (MapObject object : tiledMap.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)) {
            new Brick(gameWorld, object);
        }
        Gdx.app.log("Interactive Tile Object","Bricks created");
    }

    private void enemyBuilder() {
        //for goombas
        for (MapObject object : tiledMap.getLayers().get(6).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rectangle = ((RectangleMapObject) object).getRectangle();

            new Goomba(gameWorld, rectangle.getX(), rectangle.getY() + 7);
        }
        Gdx.app.log("Enemy","Goombas created");

        //for turtles
        for (MapObject object : tiledMap.getLayers().get(7).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rectangle = ((RectangleMapObject) object).getRectangle();

            new Turtle(gameWorld, rectangle.getX(), rectangle.getY() + 7);
        }
        Gdx.app.log("Enemy","Turtles created");
    }
}

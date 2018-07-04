package com.akocakaya.supermario.GameObject.Tools;

import com.akocakaya.supermario.GameObject.GameWorld;
import com.akocakaya.supermario.GameObject.TileObject.Brick;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;

public class WorldCreator {

    private TiledMap tiledMap;
    private BodyDef bodyDef;
    private Body body;
    private World world;
    private PolygonShape polygonShape;
    private FixtureDef fixtureDef;

    public WorldCreator(GameWorld gameWorld) {
        world = gameWorld.getWorld();
        tiledMap = gameWorld.getMap().getTiledMap();
        bodyDef = new BodyDef();
        polygonShape = new PolygonShape();
        fixtureDef = new FixtureDef();

        builder(2);
        builder(3);

        for (MapObject object : tiledMap.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)) {
            new Brick(gameWorld, object);
        }
    }

    private void builder(int index) {
        for (MapObject object : tiledMap.getLayers().get(index).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rectangle = ((RectangleMapObject) object).getRectangle();

            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set((rectangle.getX() + rectangle.getWidth() / 2), (rectangle.getY() + rectangle.getHeight() / 2));

            body = world.createBody(bodyDef);

            polygonShape.setAsBox((rectangle.getWidth() / 2), (rectangle.getHeight() / 2));
            fixtureDef.shape = polygonShape;
            body.createFixture(fixtureDef);
        }
    }
}

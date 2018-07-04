package com.akocakaya.supermario.GameObject.Tools;

import com.akocakaya.supermario.GameObject.GameWorld;
import com.akocakaya.supermario.GameObject.TileObject.Brick;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;

public class WorldCreator {

    public WorldCreator(GameWorld gameWorld) {
        World world = gameWorld.getWorld();
        TiledMap tiledMap = gameWorld.getMap().getTiledMap();
        BodyDef bodyDef = new BodyDef();
        PolygonShape polygonShape = new PolygonShape();
        FixtureDef fixtureDef = new FixtureDef();
        Body body;

        for (MapObject object : tiledMap.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rectangle = ((RectangleMapObject) object).getRectangle();

            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set((rectangle.getX() + rectangle.getWidth() / 2), (rectangle.getY() + rectangle.getHeight()) / 2);

            body = world.createBody(bodyDef);

            polygonShape.setAsBox((rectangle.getWidth() / 2), (rectangle.getHeight() / 2));
            fixtureDef.shape = polygonShape;
            body.createFixture(fixtureDef);
        }

        for (MapObject object : tiledMap.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)) {
            new Brick(gameWorld, object);
        }
    }
}

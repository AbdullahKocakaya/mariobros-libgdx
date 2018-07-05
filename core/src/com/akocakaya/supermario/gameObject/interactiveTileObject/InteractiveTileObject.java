package com.akocakaya.supermario.gameObject.interactiveTileObject;

import com.akocakaya.supermario.gameObject.GameWorld;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;

public abstract class InteractiveTileObject {

    protected World world;
    protected TiledMap tiledMap;
    protected Rectangle bounds;
    protected Body body;
    protected GameWorld gameWorld;
    protected MapObject mapObject;

    protected Fixture fixture;

    public InteractiveTileObject(GameWorld gameWorld, MapObject mapObject) {
        this.mapObject = mapObject;
        this.gameWorld = gameWorld;
        this.world = gameWorld.getWorld();
        this.tiledMap = gameWorld.getMap().getTiledMap();
        this.bounds = ((RectangleMapObject) mapObject).getRectangle();

        BodyDef bodyDef = new BodyDef();
        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape polygonShape = new PolygonShape();

        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set((bounds.getX() + bounds.getWidth() / 2), (bounds.getY() + bounds.getHeight() / 2));

        body = world.createBody(bodyDef);

        polygonShape.setAsBox(bounds.getWidth() / 2, bounds.getHeight() / 2);
        fixtureDef.shape = polygonShape;
        fixture = body.createFixture(fixtureDef);
    }
}
package com.akocakaya.supermario.GameObject.TileObject;

import com.akocakaya.supermario.GameObject.GameWorld;
import com.badlogic.gdx.maps.MapObject;

public class Brick extends InteractiveTileObject {

    public Brick(GameWorld gameWorld, MapObject mapObject) {
        super(gameWorld, mapObject);
        fixture.setUserData(this);
    }
}

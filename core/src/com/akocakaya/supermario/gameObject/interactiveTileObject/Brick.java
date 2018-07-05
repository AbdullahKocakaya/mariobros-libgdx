package com.akocakaya.supermario.gameObject.interactiveTileObject;

import com.akocakaya.supermario.gameObject.GameWorld;
import com.badlogic.gdx.maps.MapObject;

public class Brick extends InteractiveTileObject {

    public Brick(GameWorld gameWorld, MapObject mapObject) {
        super(gameWorld, mapObject);
        fixture.setUserData(this);
    }
}

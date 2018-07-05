package com.akocakaya.supermario.gameObject.interactiveTileObject;

import com.akocakaya.supermario.gameObject.GameWorld;
import com.badlogic.gdx.maps.MapObject;

public class Coin extends InteractiveTileObject {

    public Coin(GameWorld gameWorld, MapObject mapObject) {
        super(gameWorld, mapObject);
        fixture.setUserData(this);
    }
}

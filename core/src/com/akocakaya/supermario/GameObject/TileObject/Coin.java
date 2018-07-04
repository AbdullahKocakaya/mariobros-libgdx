package com.akocakaya.supermario.GameObject.TileObject;

import com.akocakaya.supermario.GameObject.GameWorld;
import com.badlogic.gdx.maps.MapObject;

public class Coin extends InteractiveTileObject {

    public Coin(GameWorld gameWorld, MapObject mapObject) {
        super(gameWorld, mapObject);
        fixture.setUserData(this);
    }
}

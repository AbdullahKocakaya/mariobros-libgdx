package com.akocakaya.supermario.stageobject;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class TableWriter {

    private Table table;

    /**
     * @param x      table column
     * @param y      table row
     * @param stages names of fields
     */
    public TableWriter(int x, int y, String... stages) {
        table = new Table();
        table.setFillParent(true);

        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);

        int k = 0;
        for (int i = 0; i < y; i++) {

            for (int j = 0; j < x; j++) {
                Label label = new Label(stages[k + j], font);
                table.add(label).expandX().padBottom(5);
            }
            table.row();
            k += 3;
        }
    }

    public Table getTable() {
        return table;
    }
}

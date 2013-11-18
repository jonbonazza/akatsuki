package akatsuki.test;

import akatsuki.Time;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Game implements ApplicationListener  {

    private int scale;

    public Game(int scale) {
        this.scale = scale;
    }

    @Override
    public void create() {

    }

    @Override
    public void resize(int i, int i2) {

    }

    @Override
    public void render() {
        ShapeRenderer renderer = new ShapeRenderer();

        Time time = Time.getTime(scale);
        Color tint = time.getTint();
        Color color = tint.mul(1.0f, 0.0f, 0.0f, 1.0f);
        System.out.println("game time: " + time.getHour() + ":" + time.getMin());
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(color);
        renderer.rect(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        renderer.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}

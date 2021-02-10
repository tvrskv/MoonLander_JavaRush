package com.javarush.games.moonlander;
import com.javarush.engine.cell.*;
import java.util.List;

/* создаем реактивную тягу ракеты */
public class RocketFire extends GameObject {

    private List<int[][]> frames;
    private int frameIndex;
    private boolean isVisible;

    @Override
    public void draw(Game game) {
        if (isVisible) {
            nextFrame();
            super.draw(game);
        }
    }

    public RocketFire(List<int[][]> frameList) {
        super(0, 0, frameList.get(0));
        this.frames = frameList;
        this.frameIndex = 0;
        this.isVisible = false;
    }

    private void nextFrame() {
        frameIndex++;
        if (frameIndex >= frames.size()) {
            frameIndex = 0;
        }

        matrix = frames.get(frameIndex);
    }

    public void show() {
        isVisible = true;
    }

    public void hide() {
        isVisible = false;
    }
}

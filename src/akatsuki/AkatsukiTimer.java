package akatsuki;

import com.badlogic.gdx.graphics.Color;

public class AkatsukiTimer extends Thread {

    private static AkatsukiTimer instance;

    /**
     * the scale used to calculate the in game time. For example,
     * If 1 real world hour == 3 in game hours, then the scale would be 3.
     * A time scale of 1 means that the game time is equivalent to the real world time.
     */
    private int scale;

    /**
     * The tint that should be used for 2d rendering based on the current time of day in game.
     */
    private Color tint;

    /**
     * The amount to adjust the game time by (in hours) to get the correct daylight value.
     * This value will need to be tweaked in order to get an acceptable tint for a game time.
     */
    private int offset;

    /**
     * The current time of day in game.
     */
    private Time currentTime;

    private AkatsukiTimer() {
        this.scale = 1;
        this.offset = 0;
    }

    public static synchronized AkatsukiTimer getInstance() {
        if (instance == null)
            instance = new AkatsukiTimer();

        return instance;
    }

    /**
     * Calculates the tint to be used in 2d rendering based on the current time of day.
     */
    private void calculateColor() {
        float rgb = 1.0f - (currentTime.getHour() + offset) * 0.043f;
        tint = new Color(rgb, rgb, rgb, 1.0f);
    }

    @Override
    public void run() {

        while (true) {
            currentTime = Time.getTime(scale);
            calculateColor();
        }
    }

    /**
     * Start the timer with the default scale (1) and default offset(0)
     */
    @Override
    public void start() {
        currentTime = Time.getTime(scale);
        calculateColor();
        super.start();
    }

    /**
     * Start the timer with the given scale and offset
     * @param scale  the scale used to calculate the in game time. For example,
     * If 1 real world hour == 3 in game hours, then the scale would be 3.
     * A time scale of 1 means that the game time is equivalent to the real world time.
     * @param offset
     */
    public void start(int scale, int offset) {
        this.scale = scale;
        this.offset = offset;

        start();
    }

    public void start(int scale) {
        this.scale = scale;
        start();
    }
    //region accessors
    public Time getCurrentTime() {
        return currentTime;
    }

    public Color getTint() {
        return  tint;
    }
    //endregion
}

package akatsuki.test;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tester {

    public static void main(String[] args) {

        System.out.println("Enter a time scale: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int scale = Integer.parseInt(br.readLine());
            new LwjglApplication(new Game(scale), "Test", 800, 600, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

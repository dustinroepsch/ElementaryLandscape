import processing.core.PApplet;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by dustin on 12/25/16.
 */
public class Landscape extends PApplet {

    @Override
    public void settings() {
        size(500, 300);
    }

    @Override
    public void setup() {
        //noLoop();
        frameRate(3);

    }

    @Override
    public void draw() {
        clear();
        background(color(176, 196, 206));
        drawMountain(150, color(112, 125, 124));
        drawMountain(120, color(97, 99, 88));
        drawMountain(50, color(22, 18, 9));
        drawSun();

    }

    private void drawSun() {
        fill(192, 203, 199);
        stroke(250);
        ellipseMode(CENTER);
        ellipse(45, 45, 60, 60);
    }

    private void drawMountain(int range, int color) {
        double featureRange = range;
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(0, (int) (height - Math.random() * featureRange)));
        points.add(new Point(width, (int) (height - Math.random() * featureRange)));
        for (int i = 0; i < 7; i++) {
            ArrayList<Point> newPoints = new ArrayList<Point>();
            for (int p = 0; p + 1 < points.size(); p++) {
                int x = (points.get(p).x + points.get(p + 1).x) / 2;
                if (x == points.get(p).x) {
                    continue;
                }
                int y = (int) (-Math.random() * featureRange) + (points.get(p).y + points.get(p + 1).y) / 2;
                newPoints.add(points.get(p));
                newPoints.add(new Point(x, y));
                newPoints.add(points.get(p + 1));

            }
            points = newPoints;
            featureRange = featureRange * .3;
        }
        stroke(color);
        fill(color);
        points.add(0, new Point(0, height));
        points.add(new Point(width, height));
        beginShape();
        for (Point point : points) {
            vertex(point.x, point.y);
        }
        endShape();

    }

    public static void main(String[] args) {
        PApplet.main("Landscape");
    }
}
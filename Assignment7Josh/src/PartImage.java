//Writte by Joshua Harris
//April 4,2018
import javafx.geometry.Point2D;
import java.awt.*;
import java.util.ArrayList;

public class PartImage {
    private boolean[][] pixels;
    private boolean[][] visited;
    private int rows;
    private int cols;
    int perimeter = 0;

    public PartImage(int r, int c) {
        rows = r;
        cols = c;
        visited = new boolean[r][c];
        pixels = new boolean[r][c];
    }

    public PartImage(int rw, int cl, byte[][] data) {
        this(rw, cl);
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (data[r][c] == 1)
                    pixels[r][c] = true;
                else
                    pixels[r][c] = false;
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public boolean getPixel(int r, int c) {
        return pixels[r][c];
    }


    public void print() {
        for (boolean[] b: pixels){
            ArrayList<String> a= new ArrayList<String>();
            for (boolean k: b){
                if (k == true){
                    a.add("*");
                }else {
                    a.add("-");
                }
            }
            System.out.println(String.format("%-1s%-1s%-1s%-1s%-1s%-1s%-1s%-1s%-1s%-1s",a.get(0), a.get(1),a.get(2),a.get(3),a.get(4),a.get(5),a.get(6),a.get(7),a.get(8),a.get(9)));
        }
    }

    public Point2D findStart() {
        Point2D p;
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (pixels[r][c] == true){
                    p = new Point2D(r,c);
                    return p;
                }
            }

        }
        return null;
    }

    public int partSize() {
        int total = 0;
        for (boolean[] b : pixels) {
            for (boolean k : b) {
                if (k == true) {
                    total++;
                }
            }
        }
        return total;
    }


    private void expandFrom(int r, int c) {
        if (r<10&&c<10&&r>=0&&c>=0) {
            if (!(pixels[r][c]))
                return;
            pixels[r][c] = false;
            expandFrom(r + 1, c);
            expandFrom(r - 1, c);
            expandFrom(r, c + 1);
            expandFrom(r, c - 1);
        }

    }

    private int perimeterOf(int r, int c) {
        if(r>9||c>9||r<0||c<0){
            return 1;
        }

        if((r<10&&c<10&&r>=0&&c>=0)&&visited[r][c] == false){
            if (pixels[r][c] == false){
                return 1;
            }
            visited[r][c] = true;
              return  perimeterOf(r-1,c)+ perimeterOf(r+1,c)+ perimeterOf(r,c-1)+ perimeterOf(r,c+1);
        }
        return 0;
    }

    public boolean isBroken() {
        Point2D p = findStart();
        expandFrom((int) p.getX(), (int) p.getY());
        return (partSize() != 0);
    }

    public int perimeter() {
        Point2D p = findStart();
        return perimeterOf((int) p.getX(), (int) p.getY());
    }

    public static PartImage exampleA() {
        byte[][] pix = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        return new PartImage(10, 10, pix);
    }

    public static PartImage exampleB() {
        byte[][] pix = {{1, 0, 1, 0, 1, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 1, 0, 1, 1, 1, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 1, 0, 1, 1, 1, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 1, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 1, 0, 0, 0}};
        return new PartImage(10, 10, pix);
    }

    public static PartImage exampleC() {
        byte[][] pix = {{1, 1, 1, 0, 0, 0, 1, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 0, 1, 1, 1, 1, 1},
                {0, 0, 1, 0, 0, 0, 1, 1, 0, 0}};
        return new PartImage(10, 10, pix);
    }

    public static PartImage exampleD() {
        byte[][] pix = {{1, 0, 1, 0, 1, 0, 1, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0}};
        return new PartImage(10, 10, pix);
    }

}
public class ImageProgram {

    public static void main(String args[]) {
        int rannum;
        boolean grid[][] = new boolean[11][11];
        int horizontal = 0;
        int vertical = 0;
        int maxH = 0;
        int maxV = 0;
        int colum, row;


        for (colum = 0; colum < 10; colum++) {
            System.out.println();
            for ( row = 0; row < 10; row++) {
                rannum = (int) ((2) * Math.random() + 0);
                if (rannum == 0) {
                    grid[colum][row] = true;
                    System.out.print(".");
                } else {
                    grid[colum][row] = false;
                    System.out.print("O");
                }
            }
        }
        for (colum = 0; colum < grid.length; colum++) {
            for (row = 0; row < grid[colum].length; row++) {
                if (grid[colum][row] = false) {
                    horizontal += 1;
                } else if (grid[colum][row] = true) {
                    if (maxH < horizontal) {
                        maxH = horizontal;
                        horizontal = 0;
                    } else {
                        horizontal = 0;
                    }
                }
            }
        }
        for (row = 0; row < grid.length; row++) {
            for (colum = 0; colum < grid[row].length; colum++) {
                if (grid[row][colum] = false) {
                    vertical += 1;
                } else if (grid[row][colum] = true) {
                    if (maxV < vertical) {
                        maxV = vertical;
                        vertical = 0;
                    } else {
                        vertical = 0;
                    }

                }
            }
        }
        System.out.println();
        System.out.println("The longest horizontal sequence is: " + horizontal);
        System.out.println("The longest vertical sequence is : " + vertical);
    }
}

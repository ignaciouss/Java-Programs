public class HistogramProgram {
    public static void main(String args[]){
        int rannum;


        int grid[] = new int[100];

        for( int j = 0; j<10; j++){
            System.out.print(j + " |\t");
            for (int i = 0; i< 100; i ++){
                rannum = (int) ((10 ) * Math.random() + 0);
                grid[i]= rannum;
                if (grid[i] == j){
                    System.out.print("*");
                }
            }
            System.out.println();
        }





    }


}

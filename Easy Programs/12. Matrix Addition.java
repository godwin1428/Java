/*	Write a program for matrix addition?
Sample Input:
Mat1 = 	1  2
        5  3
Mat2 = 	2   3
        4   1
Sample Output:
Mat Sum = 3    5
          9    4 */


class Main{
    public static void main(String[] args) {
        int[][] mat1={{1,2},{5,3}};
        int[][] mat2={{2,3},{4,1}};
        int[][] res=new int[2][2];
        for (int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                res[i][j]=mat1[i][j]+mat2[i][j];
            }
        } 
        System.out.println("Mat Mul:");
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}


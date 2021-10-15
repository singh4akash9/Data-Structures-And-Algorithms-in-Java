import java.io.IOException;

public class ArraysAndMatrix_3
{

    public static int[][] inputSquareMatrix(int m)throws IOException
    {
        System.out.println("Input matrix");
        int[][] matrix=new int[m][m];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<m;j++)
            {
                matrix[i][j]=Reader.nextInt();
            }
        }
        return matrix;
    }

    public static int[][] rotateMatrix(int[][] matrix,int m)
    {
//        [1 2 3]     [3 6 9]
//        [4 5 6] --> [2 5 8]
//        [7 8 9]     [1 4 7]
//
//        [1  2  3  4  5 ]        [5  10  15 20 25]
//        [6  7  8  9  10]        [4   9  14 19 24]
//        [11 12 13 14 15] -->    [3   8  13 18 23]
//        [16 17 18 19 20]        [2   7  12 17 22]
//        [21 22 23 24 25]        [1   6  11 16 21]


//        Using extra space
//        int[][] matrix2=new int[m][m];
//        for(int i=0;i<m;i++)
//        {
//            for(int j=0;j<m;j++)
//            {
//                matrix2[m-j-1][i]=matrix[i][j];
//            }
//        }
        /*
        * i=0  j=0  (0,0)->(4,0) (4,0)->(4,4) (4,4)->(0,4) (0,4)->(0,0)
        *      j=1  (0,1)->(3,0) (3,0)->(4,3) (4,3)->(1,4) (1,4)->(0,1)
        *      j=2  (0,2)->(2,0) (2,0)->(4,2) (4,2)->(2,4) (2,4)->(0,2)
        *
        *           (i,j)->(n-1-j,i) (n-1-j,i)->(n-1-i,n-1-j) (n-1-i,n-1-j)->(j,n-1-i) (i,n-1-i)->(i,j)
        *
        * */

        for(int i=0;i<=m/2;i++)
        {
            for(int j=i;j<m-i-1;j++)
            {
                int temp=matrix[m-1-j][i];
                matrix[m-1-j][i]=matrix[i][j];
                int temp2=matrix[m-1-i][m-1-j];
                matrix[m-1-i][m-1-j]=temp;
                temp=matrix[j][m-1-i];
                matrix[j][m-1-i]=temp2;
                matrix[i][j]=temp;

            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix,int m)
    {
        System.out.println("Printing matrix");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(matrix[i][j]+" ");

            }
            System.out.println();
        }
    }

    public static void main(String[] args)throws IOException
    {
        Reader.init(System.in);

        System.out.println("This program rotates a matrix by 'n' degrees (anticlockwise) where n is a multiple of 90");
        int m;
        System.out.println("Enter the size of matrix square");
        m=Reader.nextInt();
        int[][] matrix=inputSquareMatrix(m);
        System.out.println("Enter the angle by which the matrix will be rotated (anticlockwise). The angle should be a multiple of 90");
        int angle=Reader.nextInt();
        int times=((angle)/90)%4;
        for(int i=0;i<times;i++)
        {
            matrix=rotateMatrix(matrix,m);
        }
        printMatrix(matrix,m);
    }

}

import java.io.IOException;

public class ArraysAndMatrix_4
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

    public static int[][] transposeMatrix(int[][] matrix,int m)
    {
//        [1 2 3]     [1 4 7]
//        [4 5 6] ->  [2 5 8]
//        [7 8 9]     [3 6 9]

        for(int i=0;i<m;i++)
        {
            for(int j=i;j<m;j++)
            {
               int temp=matrix[i][j];
               matrix[i][j]=matrix[j][i];
               matrix[j][i]=temp;
            }
        }
        return matrix;
    }

    public static void main(String[] args)throws IOException
    {
        Reader.init(System.in);

        System.out.println("This program transposes a matrix");
        int m;
        System.out.println("Enter the size of matrix square");
        m=Reader.nextInt();
        int[][] matrix=inputSquareMatrix(m);
        matrix=transposeMatrix(matrix,m);
        printMatrix(matrix,m);
    }

}

import java.io.IOException;

public class ArraysAndMatrix_2
{

    static int[] inputArray(int n)throws IOException
    {
        System.out.println("Enter the array of size "+n);
        int[] array=new int[n];
        for(int i=0;i<n;i++)
        {
            array[i]=Reader.nextInt();

        }
        return array;
    }
    private static int largestSumContiguousArray(int[] array)
    {
        int max_so_far=Integer.MIN_VALUE;
        int max_ending_here=0;
        for (int a:array)
        {
                max_ending_here=max_ending_here+a;
                if(max_so_far<max_ending_here)
                    max_so_far=max_ending_here;
                if(max_ending_here<0)
                    max_ending_here=0;
        }
        return max_so_far;
    }

    public static void main(String[] args)throws IOException
    {
        Reader.init(System.in);
        System.out.println("Largest Sum contiguous array");
        System.out.println("Enter the size of Array");
        int N=Reader.nextInt();
        int[] array=inputArray(N);
        int ans=largestSumContiguousArray(array);
        System.out.println(ans);
    }


}

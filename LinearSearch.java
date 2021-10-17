import java.io.*;
import java.lang.*;
public class LinearSearch {

    static int linearSearch(int[] array , int target)
    {
        for(int i=0;i<array.length;i++)
        {
            if(array[i]==target)
                return i;
        }
        return -1;
    }
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

    static void printArray(int[] array)
    {
        for(int i=0 ;i<array.length;i++)
        {
            System.out.println(array[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args)throws IOException
    {
        Reader.init(System.in);
        System.out.println("Enter the size of array");
        int n=Reader.nextInt();
        int[] array=new int[n];
        array=inputArray(n);
        System.out.println("Enter the element to be searched");
        int target=Reader.nextInt();
        System.out.println(linearSearch(array,target));
    }
}

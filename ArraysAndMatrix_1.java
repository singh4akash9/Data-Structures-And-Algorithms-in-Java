import java.io.IOException;

public class ArraysAndMatrix_1
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

    static void printArray(int[] array)
    {
        for(int i=0 ;i<array.length;i++)
        {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    static int[] leftRotateBy1(int[] arr)
    {
        int temp=arr[0];
        for(int i=0;i<arr.length-1;i++)
        {
            arr[i]=arr[i+1];
        }
        arr[arr.length-1]=temp;
        return arr;
    }

    static int[] rotateArray(int[] array,int d)
    {
        d=d%array.length;
        for(int i=0;i<d;i++)
        {
            array=leftRotateBy1(array);
        }
        return array;
    }

    public static void main(String[] args)throws IOException {
        Reader.init(System.in);
        System.out.println("This program rotates array by 'd' ");
        System.out.println("Enter the size of Array");
        int n=Reader.nextInt();
        int[] array=inputArray(n);
        System.out.println("Enter the value of 'd'");
        int d=Reader.nextInt();
        array=rotateArray(array,d);
        printArray(array);
    }
}

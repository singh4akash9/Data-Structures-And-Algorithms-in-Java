import java.io.IOException;

public class BubbleSort
{
    static int[] bubbleSort(int[] array)
    {
        for(int i=0;i<array.length;i++)
        {
            for(int j=0;j<=i;j++)
            {
                if(array[j]>array[i])

                {
                    int temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;

                }
            }
        }
        return array;
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
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }


    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);
        // Checks the function linear Search for random arrays
        System.out.println("Enter the size of array");
        int n=Reader.nextInt();
        int[] array=new int[n];
        array=inputArray(n);
        array=bubbleSort(array);
        printArray(array);
    }
}

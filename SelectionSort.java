import java.io.IOException;

public class SelectionSort
{
    static int select(int[] array,int i,int j)
    {
        int index=i;
        int small=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++)
        {
            if(array[k]<small)
            {
                small=array[k];
                index=k;
            }
        }
        return index;
    }

    static void makeInAscendingOrder(int[] array, int i,int j)
    {
        if(array[i]>array[j])
        {   int temp=array[i];
            array[i]=array[j];
            array[j]=temp;
        }
    }

    static int[] selectionSort(int[] array)
    {
        for(int i=0;i<array.length-1;i++)
        {
            makeInAscendingOrder(array,i,select(array,i,array.length-1));
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
        array=selectionSort(array);
        printArray(array);;
    }
}

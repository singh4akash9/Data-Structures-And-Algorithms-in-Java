import java.io.IOException;

public class InsertionSort
{

    public static void move(int[] array,int i,int j)
    {
        // move elements from [i to j-1] to [i+1 to j]
        for(int k=i+1;k<=j;k++)
        {
            array[k]=array[k-1];
        }
    }
    public static void insert(int[] array,int i)
    {
        int x=array[i];
        for(int j=0;j<i;j++)
        {
            if(array[i]<array[j])
            {
                move(array,j,i);
                array[j]=x;
            }
        }
    }

    public static void insertionSort(int[] array)
    {
        for(int i=1;i<array.length;i++)
        {
            insert(array,i);
        }
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
        System.out.println("Enter the size of array");
        int n=Reader.nextInt();
        int[] array=new int[n];
        array=inputArray(n);
        insertionSort(array);
        printArray(array);;
    }
}

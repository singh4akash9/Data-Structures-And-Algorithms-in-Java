import java.io.IOException;

public class QuickSort
{

    static void swap(int[] array,int i,int j)
    {
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    static int partition(int[] array,int start,int end)
    {
        int i=start;
        int j=start+1;
        int temp=array[start];
        while(j<=end)
        {
            if(i==j)
            {
                j++;
                continue;
            }
            if(array[j]>=temp)
            {
                j++;
            }
            else
            {
                i++;
                swap(array,i,j);
            }
        }
        swap(array,i,start);
        return i;
    }

    static void quickSort(int[] array,int start,int end)
    {
        if(start==end)
            return;
        if(start==end-1)
            swap(array,start,end);
        if(start<end)
        {
            int pivot=partition(array,start,end);
            quickSort(array,start,pivot-1);
            quickSort(array,pivot+1,end);
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
        quickSort(array,0,array.length-1);
        printArray(array);
    }
}

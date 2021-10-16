import java.io.IOException;

public class MergeSort
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

    public static int[] merge(int[] array,int start, int mid, int end)
    {
        int[] aux=new int[array.length];
        int i=start;
        int j=mid+1;
        int curr=start;
        while(i>=start&&i<=mid&&j<=end)
        {
            if(array[i]>array[j])
            {
                aux[curr]=array[j];
                curr++;
                j++;
            }
            else
            {
                aux[curr]=array[i];
                curr++;
                i++;
            }
        }
        while(i<=mid)
        {
            aux[curr]=array[i];
            i++;
            curr++;
        }

        while(j<=end)
        {
            aux[curr]=array[j];
            j++;
            curr++;
        }
        for(i=start;i<=end;i++)
        {
            array[i]=aux[i];
        }
        return array;
    }

    public static int[]  mergeSort(int[] array,int start,int end)
    {
        if(start==end)
        {
            return array;
        }
        int mid=(start+end)/2;
        array=mergeSort(array,start,mid);
        array=mergeSort(array,mid+1,end);
        array=merge(array,start,mid,end);
        return array;
    }

    public static void main(String[] args)throws IOException
    {
        Reader.init(System.in);
        // Checks the function linear Search for random arrays
        System.out.println("Enter the size of array");
        int n=Reader.nextInt();
        int[] array=new int[n];
        array=inputArray(n);
        array=mergeSort(array,0,array.length-1);
        printArray(array);

    }


}

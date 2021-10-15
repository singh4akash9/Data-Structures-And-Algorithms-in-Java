import java.io.IOException;

public class BinarySearch
{
    static int[] inputArray(int n)throws IOException
    {
        System.out.println("Enter the sorted array of size "+n);
        int[] array=new int[n];
        for(int i=0;i<n;i++)
        {
            array[i]=Reader.nextInt();

        }
        return array;
    }

    static int binarySearch(int[] array,int target,int low,int high)
    {
        if(low>high)
        {
         return -1;
        }
        int mid=(low+high)/2;
        if(array[mid]==target)
            return mid;
        else if(array[mid]>target)
        {
            return binarySearch(array,target,low,mid-1);
        }
        else
        {
            return binarySearch(array,target,mid+1,high);
        }

    }
    public static void main(String[] args)throws IOException {
        Reader.init(System.in);
        // Checks the function linear Search for random arrays
        System.out.println("Enter the size of array");
        int n=Reader.nextInt();
        int[] array=new int[n];
        array=inputArray(n);
        System.out.println("Enter the element to be searched");
        int target=Reader.nextInt();
        System.out.println(binarySearch(array,target,0, array.length-1));
    }
}

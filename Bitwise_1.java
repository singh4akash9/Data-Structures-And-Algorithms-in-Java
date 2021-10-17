import java.io.IOException;

public class Bitwise_1
{
    public static int elementThatAppearsOnce(int[] array)
    {
        int ans=array[0];
        for(int i=1;i<array.length;i++)
        {
            ans=ans^array[i];
        }
        return ans;
    }

    public static void main(String[] args)throws IOException
    {
        Reader.init(System.in);
        System.out.println("Given an array of integers. All numbers occur twice except one number which occurs once. Find the number in O(n) time & constant extra space.");
        System.out.println("Enter the array size");
        int n=Reader.nextInt();
        int[] array=new int[n];
        System.out.println("Enter the array");
        for(int i=0;i<n;i++)
        {
            array[i]=Reader.nextInt();
        }
        System.out.println(elementThatAppearsOnce(array));
    }

}

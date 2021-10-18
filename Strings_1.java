import java.io.IOException;

public class Strings_1
{
    public static char appearsOnce(String s)
    {
        int[] array=new int[26];
        for(int i=0;i<s.length();i++)
        {
            array[(int)(s.charAt(i))-(int)('a')]++;
        }
        int ans=-1;
        for(int i=0;i<26;i++)
        {
            if(array[i]==1)
                return (char)(i+(int)('a'));
        }
        return 'a';
    }

    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);
        System.out.println("Displays the character from a string that appears once.");
        String s=Reader.next();
        char c=appearsOnce(s);
        System.out.println(c);
    }

}

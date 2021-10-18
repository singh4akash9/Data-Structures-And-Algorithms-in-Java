import java.io.IOException;
import java.util.Scanner;

public class Strings_8
{
    public static int countWords(String string)
    {
        int wordEnded=0;
        int wordCount=0;
        for(int i=0;i<string.length();i++)
        {
            System.out.println("here");
            if(string.charAt(i)==' ')
            {
                System.out.println("here");
                if(wordEnded==1)
                {
                    continue;
                }
                wordEnded=1;
                wordCount++;
                System.out.println("Incrementing wordcount");
            }
            else
                wordEnded=0;
        }
        if(string.charAt(string.length()-1)!=' ')
            wordCount++;
        return wordCount;
    }

    public static void main(String[] args) throws IOException
    {
        System.out.println("This program takes a string and returns the words in it");
        Reader.init(System.in);
        System.out.println("Enter the string");
        String s=new Scanner(System.in).nextLine();
        System.out.println(countWords(s));
    }

}

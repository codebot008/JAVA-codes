# JAVA-codes
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class binop
{
	static int strdiff(String s1, String s2)
	{
		int count = 0;
		for(int i = 0; i < s1.length(); i++)
		{
			if(s1.charAt(i) != s2.charAt(i))
			{
				count++;
			}
		}
		return count;
	}

	static int xorpair(String s1, String s2)
	{
		int one_zero = 0;
		int zero_one = 0;
		for(int i = 0; i < s1.length(); i++)
		{
			if(s1.charAt(i) == '1' && s2.charAt(i) == '0')
			{
				one_zero++;
			}
			else if(s1.charAt(i) == '0' && s2.charAt(i) == '1')
			{
				zero_one++;
			}
		}
		if(one_zero < zero_one)
		{
			return one_zero;
		}
		else
		{
			return zero_one;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		int t;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		while(t != 0)
		{
			String s1 = br.readLine();
			String s2 = br.readLine();
			if(!s1.contains("0") || !s1.contains("1"))
			{
				System.out.println("Unlucky Chef");
			}
			else
			{
				System.out.println("Lucky Chef");
				System.out.println( xorpair(s1,s2) + (strdiff(s1,s2) - 2 * xorpair(s1,s2)));
			}
			t--;
		}
	}

}

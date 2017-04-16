
public class Question5 {
	public static void main(String[] args) {
	//for (int i=1;i<=7;i++)	
	//{
	//for (int j=1;j<=i; j++)
	//	System.out.print(j);
	//System.out.println("");
	//}
int ary[]=new int [4];

ary[0]=0;
ary[1]=1;
ary[2]=2;
ary[3]=3;
 int len=ary.length;
 System.out.println("Length of the arr is " + len);
 for (int i=len-1;i>=0;i--)
 {
System.out.println(ary[i]);
 }
 
 for (int j=len-1;j>=0;j=j-2)
	 System.out.println(ary[j]);
 int grt= ary[0];
 for (int k=0;k<len;k++)
 {
	 if(ary[k]>grt)
		 grt=ary[k];
 }
 System.out.println("the Greatest number in the array is " + grt);
 int sml= ary[0];
 for (int l=0; l < len;l++)
 {	 if (ary[l]<sml)
		 sml=ary[l];
 }
 System.out.println("Smallest number in the array is " + sml);
 
 }
}
	

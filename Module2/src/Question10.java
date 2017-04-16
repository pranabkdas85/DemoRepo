
public class Question10 {
	public static void main(String[] args) {
int ary[]= new int[32];
ary[0]=1;
ary[1]=3;
ary[2]=4;
ary[3]=5;
ary[4]=6;
ary[5]=3;
ary[6]=2;
ary[7]=4;
ary[8]=6;
ary[9]=7;
ary[10]=9;
ary[11]=4;
ary[12]=12;
ary[13]=3;
ary[14]=4;
ary[15]=6;
ary[16]=8;
ary[17]=9;
ary[18]=7;
ary[19]=6;
ary[20]=43;
ary[21]=2;
ary[22]=4;
ary[23]=7;
ary[24]=7;
ary[25]=5;
ary[26]=2;
ary[27]=1;
ary[28]=3;
ary[29]=4;
ary[30]=6;
ary[31]=311;
int len= ary.length;
System.out.println("Length of the array is "+len);
for (int i=0;i<len;i++)
	{
	int rep=0;
		for (int j=0;j<len;j++)
		{	
			if (ary[i]==ary[j])
				rep++;
		}
		System.out.println("The number "+ ary[i]+ " is repeated by "+ rep+" times");
			}

}
	}

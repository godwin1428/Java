class SI {
    public static void main(String[] args)
    {   int f1=0,f2=1,f3,n=8,sum=0;
        for(int i=0;i<n;i++)
        {
           f3=f1+f2;
           if(i%2==0)
           {
           sum=sum+f3;
           }
           f1=f2;
           f2=f3;
        }
         System.out.print("sum: "+sum);
    }
}

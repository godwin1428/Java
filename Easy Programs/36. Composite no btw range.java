class SI {
    public static void main(String[] args)
    {   int a=12,b=19,count;
        for(int i=a+1;i<19;i++)
        {count=0;
        for(int j=2;j<i;j++)
        {
          if(i%j==0)
          {
            count++;
          }
        }
         if(count>0)
         {System.out.print(i+" ");}
        }
        
    }
}

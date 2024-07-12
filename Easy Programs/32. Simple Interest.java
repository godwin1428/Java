class SI {
    public static void main(String[] args)
    {    int principle=200000,year=3,age='n',si;
         if(age=='y')
         {
             si=(principle*year*12)/100;
         }
         else if(age=='n')
         {
             si=(principle*year*10)/100;
         }
        System.out.println("Simple Interest:"+si);
    }
}

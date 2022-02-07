package Test;

class InOut{
    String s= new String("Between");
    public void amethod(final int iArgs){
        int iam;
        class Bicycle{
            public void sayHello(){
                //Here
                System.out.println(s);
//                System.out.println(iam);
                System.out.println(iArgs);

            }
        }
    }
    public void another(){
        int iOther;
    }
}

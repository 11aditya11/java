
class Parent
{
    int a;
    public Parent()
    {
        //a = x;
        System.out.println("A");
    }
}
class Child extends Parent
{
    int b;
    
    public Child()
    {
        super();
        System.out.println("B");
    }
}

class Example
{
    public static void main(String[] args)
    {

        Child ch = new Child();
        
    }
}

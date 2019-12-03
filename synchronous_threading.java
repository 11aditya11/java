import java.util.Scanner;

class Account
{
    private int bal;
    public Account(int bal)
    {
        this.bal = bal;
    }
    public boolean issuffbal(int w)
    {
        if(bal>w)
        {
            return true;
        }
        else
            return false;
    }
    public void withdraw(int amt)
    {
        bal = bal-amt;
        System.out.println("Withdrawn " + amt + " and now left " + bal);
    }
}
class Customer implements Runnable
{
    private Account account; 
    private String name;
    public Customer(Account account, String name)
    {
        this.account = account;
        this.name = name;
    }

    public void run()
    {

        synchronized(account)
        {
            Scanner kb = new Scanner(System.in);
            System.out.println("Enter amount:" + name);
            int amt = kb.nextInt();
        if(account.issuffbal(amt))
        {
            account.withdraw(amt);
        }
        else
        {
            System.out.println("Insufficiant balance Fuckin" + name);
        }
    }}
}   

public class synchronous_threading
{
    public static void main(String args[])
    {
        Account a1 = new Account(1000);
        Customer c1 = new Customer(a1, "rich");
        Customer c2 = new Customer(a1, "poor");
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        t1.start();
        t2.start();
    }
}
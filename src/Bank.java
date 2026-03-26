public class Bank {
    String account_number;
    String name;
    String password;
    double balance;
    public  Bank(String account_number,String password,String name,double balance){
        this.account_number=account_number;
        this.password=password;
        this.name=name;
        this.balance=balance;
    }
    public  void deposit(double amount) {
        if(amount>0)
            balance+=amount;
        System.out.println("Deposit Successfully your Balance is: "+balance);
    }
    public  void withdraw(double amount) {
        if(amount>0)
            balance-=amount;
        System.out.println("Withdraw Successfully Your Balance is :"+balance);
    }
    public  void DisplayBalance(){
        System.out.println("Holder name {"+name+"} ,Has Balance ["+balance+"]");
    }
}

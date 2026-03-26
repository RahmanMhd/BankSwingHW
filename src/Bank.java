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
    }
    public void withdraw(double amount) {
        if(amount>0)
            balance-=amount;
    }
    public String DisplayBalance(){
        return "Holder name {"+name+"} ,Has Balance ["+balance+"]");
    }
}

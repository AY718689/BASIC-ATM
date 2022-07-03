import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

interface AtmInterFace {
    public void checkBal();
    public void depoAmt(double depo);
    public void withdrawAmt(double withdrawn);
    public void transAmt();
}

class ATM {
    private double balance;
    private double depo;
    private double withdrawn;
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getDepo() {
        return depo;
    }
    public void setDepo(double depo) {
        this.depo = depo;
    }
    public double getWithdrawn() {
        return withdrawn;
    }
    public void setWithdrawn(double withdrawn) {
        this.withdrawn = withdrawn;
    }

}

class AtmFunc implements AtmInterFace {
    ATM atm = new ATM();
    Map<Double,String> t = new HashMap<>();
    @Override
    public void checkBal()
    {
        System.out.println("Available Balance is :"+atm.getBalance());
    }
    public void depoAmt(double depo)
    {
        t.put(depo,"Rupees Credited to your account");
        System.out.println("x-x-x-x-x "+depo+" Rupees Credited Successfully x-x-x-x-x\n");
        atm.setBalance(atm.getBalance()+depo);
        checkBal();
    }
    public void withdrawAmt(double withdrawn)
    {
        if(withdrawn%10==0 && withdrawn<=10000)
        {
            if(withdrawn<=atm.getBalance())
            {
                t.put(withdrawn,"Rupees Debited from your account");
                System.out.println("x-x-x-x-x Collect Rupees"+withdrawn+" x-x-x-x-x\n");
                atm.setBalance(atm.getBalance()-withdrawn);
                checkBal();
            }
            else
            {
                System.out.println("x-x-x-x-x Not sufficient Balance in your account x-x-x-x-x\n");
            }
        }
        else
        {
            System.out.println("x-x-x-x-x Please Enter a Valid Value x-x-x-x-x\n");
        }
    }
    public void transAmt()
    {

        for(Entry<Double,String> entry: t.entrySet())
        {
            System.out.println("## "+entry.getKey()+" "+entry.getValue());
        }
    }

}

public class User {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        AtmInterFace f1 = new AtmFunc();
        HashMap<String,String> login = new HashMap<>();
        login.put("123456","7745");
        login.put("122334","2926");
        login.put("121434","7894");
        login.put("166534","8942");
        login.put("100134","0486");
        System.out.println("Please Enter Your Card :");
        String id = sc.nextLine();
        System.out.println("Please Enter Your Password :");
        String pin = sc.nextLine();
        for(Entry<String,String> entry: login.entrySet())
        {
            if(id.equals(entry.getKey()) && pin.equals(entry.getValue()))
            {
                System.out.println("\n\t\tx-x-x-x-x Login success x-x-x-x-x\n\n");
                System.out.println("1.Press 1 for Check Balance\n2.Press 2 for WithDraw Amount\n3.Press 3 for Deposit Amount\n4.Press 4 for View Transaction History\n5.Exit\n\n");
                while(true)
                {
                    System.out.println("Enter Choice : ");
                    int n = sc.nextInt();
                    System.out.println("-------------------------------------------------------\n");
                    switch(n)
                    {
                        case 1:
                        f1.checkBal();
                        break;

                        case 2:
                        System.out.println("Enter Withdrawn Amount :");
                        double withdrawn = sc.nextDouble();
                        f1.withdrawAmt(withdrawn);
                        break;

                        case 3:
                        System.out.println("Enter Amount to be Deposited:");
                        double depo  =sc.nextDouble();
                        f1.depoAmt(depo);
                        break;

                        case 4:
                        f1.transAmt();
                        break;

                        case 5:
                        System.out.println("Thank You for Banking with us.Please Collect your ATM card\n\n");
                        System.exit(0);
                        
                        default : System.out.println("x-x-x-x Invalid Choice x-x-x-x-x\n");
                    }
                }
            }
            
        }
    }    
}   
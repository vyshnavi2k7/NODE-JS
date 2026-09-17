package javalab1;

class Bank {
    int getBalance() {
        return 0;    }
    }
class BankA extends Bank {
    int getBalance() {
        return 1000;  }
   }
class BankB extends Bank {
    int getBalance() {
        return 1500;  }
     }
class BankC extends Bank {
    int getBalance() {
        return 2000; }
    }
public class BankDemo {
    public static void main(String[] args) {
        BankA a = new BankA();
        BankB b = new BankB();
        BankC c = new BankC();
        System.out.println("Money deposited in Bank A: ”+ a.getBalance());
        System.out.println("Money deposited in Bank B: ” + b.getBalance());
        System.out.println("Money deposited in Bank C: " + c.getBalance());       }
      }


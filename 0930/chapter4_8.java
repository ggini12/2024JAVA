package report3;

class Account{
	int balance;
	
	public Account(int sbalance) {
		this.balance = sbalance;
	}
	public void deposit(int amount) {
		if(amount>0)
			balance += amount;
	}
	public void deposit(int[] amounts) {
	        
	       for (int i = 0; i < amounts.length; i++) {
	           int amount = amounts[i]; 
	           deposit(amount);
	       }
	}
	public int withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount; 
            return amount; 
        } else {
            int withdrawnAmount = balance; 
            balance = 0; 
            return withdrawnAmount; 
        }
    }

    
    public int getBalance() {
        return balance; 
    }
	       
}

public class chapter4_8 {
	public static void main(String[] args) {
		Account a = new Account(100);  // 100원 예금하면서 계좌 생성
		a.deposit(5000);  // 5000원 예금
		System.out.println("잔금은 "+a.getBalance()+"원입니다.");
		
		int bulk[] = {100,500,200,700};
		a.deposit(bulk);  // bulk[] 배열에 있는 모든 돈 예금
		System.out.println("잔금은 "+ a.getBalance()+ "원입니다.");
		
		int money = 1000;
		int wMoney = a.withdraw(money);  // 1000원 인출 시도. wMoney는 실제 인출한 금액
		if(wMoney<money)
			System.out.println(wMoney + "원만 인출");
		else
			System.out.println(wMoney+"원 인출");  // 잔금이 1000원보다 큰 경우
		System.out.println("잔금은 "+a.getBalance()+"원입니다.");
	}
}

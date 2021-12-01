package guide.core;

public class InterfaceEx {
	public static void main(String[] args) {
System.out.println("BANKACCOUNT CLASS");
BankAccount bankAccount = new BankAccount();
bankAccount.transferFunds();
bankAccount.withdrawCash();
System.out.println("DEBITCARD INTERFACE");
//	Reference can be created
 DebitCard debitCard = null;
// No instance can be created
// debitCard = new DebitCard();
debitCard = new BankAccount();
debitCard.withdrawCash();
//debitCard.transferFunds();
System.out.println("NETBANKING INTERFACE");
NetBanking netBanking = new BankAccount();
netBanking.transferFunds();
netBanking.checkBalance();
//netBanking.withdraw();
System.out.println("NETMOBILE BANKING INTERFACE");
MobileBanking mobileBanking = new BankAccount();
mobileBanking.addLoad();
mobileBanking.checkBalance();
	}
}


interface DebitCard {
	public abstract void checkBalance();
	public abstract void withdrawCash();
	
}

interface NetBanking{
	public abstract void transferFunds();
	public abstract void checkBalance();	
	
}

interface MobileBanking {
	public abstract void checkBalance();
	public abstract void transferFunds();
	public abstract void addLoad();
}



class BankAccount implements NetBanking, DebitCard, MobileBanking {
	public void transferFunds() {
		System.out.println("\tTransfer funds in BDO Bank");
	}
	public void withdrawCash() {
		System.out.println("\tWithdraw Cash");
	}
	public void checkBalance() {
		System.out.println("\tCheck Balance");
	}
	public void addLoad() {
		System.out.println("\tAdd load to your account");
	}
}
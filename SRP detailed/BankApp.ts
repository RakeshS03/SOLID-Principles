class BankApp {
  static main() {
    const accountRepo = new AccountRepository();
    const notificationService = new NotificationService();
    const auditLogger = new AuditLogger();

    const transactionService = new TransactionService(accountRepo,notificationService,auditLogger);

    transactionService.transferMoney("ACC123", 5000);
  }
}
 //BUSINESS RESPONSIBILITY
   
class TransactionService {
  constructor(
    private accountRepo: AccountRepository,private notificationService: NotificationService,private auditLogger: AuditLogger) {}

  transferMoney(accountNumber: string, amount: number) {
    console.log("Processing transaction");

    this.accountRepo.debit(accountNumber, amount);
    this.notificationService.sendAlert(accountNumber, amount);
    this.auditLogger.log("Transaction successful");
  }
}
//PERSISTENCE RESPONSIBILITY
class AccountRepository {
  debit(accountNumber: string, amount: number) {
    console.log(
      `₹${amount} debited from account ${accountNumber}`
    );
  }
}
// COMMUNICATION RESPONSIBILITY
class NotificationService {
  sendAlert(accountNumber: string, amount: number) {
    console.log(
      `SMS sent for ₹${amount} debit on ${accountNumber}`);
  }
}
//LOGGING RESPONSIBILITY
class AuditLogger {
  log(message: string) {
    console.log(`AuditLogger: ${message}`);
  }
}

BankApp.main();

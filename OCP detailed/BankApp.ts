class BankApp {
  static main() {
    const accountRepo = new AccountRepository();
    const logger = new AuditLogger();

    const debitTransaction = new DebitTransaction();
    const creditTransaction = new CreditTransaction();

    const transactionService = new TransactionService(
      accountRepo,
      debitTransaction,
      logger
    );

    transactionService.process("ACC101", 3000);

    // Switching behavior OCP
    const transactionService2 = new TransactionService(
      accountRepo,
      creditTransaction,
      logger
    );

    transactionService2.process("ACC101", 5000);
  }
}

   //BUSINESS RESPONSIBILITY
   
class TransactionService {
  constructor(
    private accountRepo: AccountRepository,
    private transactionType: TransactionType,
    private logger: AuditLogger
  ) {}

  process(accountNumber: string, amount: number) {
    this.transactionType.execute(this.accountRepo, accountNumber, amount);
    this.logger.log("Transaction completed");
  }
}

   //ABSTRACTION (OCP)
interface TransactionType {
  execute(
    repo: AccountRepository,
    accountNumber: string,
    amount: number
  ): void;
}

   //EXTENSIONS (OCP)
class DebitTransaction implements TransactionType {
  execute(repo: AccountRepository, accountNumber: string, amount: number) {
    repo.debit(accountNumber, amount);
    console.log("Debit successful");
  }
}

class CreditTransaction implements TransactionType {
  execute(repo: AccountRepository, accountNumber: string, amount: number) {
    repo.credit(accountNumber, amount);
    console.log("Credit successful");
  }
}

   //PERSISTENCE RESPONSIBILITY
class AccountRepository {
  debit(accountNumber: string, amount: number) {
    console.log(`₹${amount} debited from ${accountNumber}`);
  }

  credit(accountNumber: string, amount: number) {
    console.log(`₹${amount} credited to ${accountNumber}`);
  }
}

   //LOGGING RESPONSIBILITY
class AuditLogger {
  log(message: string) {
    console.log(`AuditLogger: ${message}`);
  }
}

// Execution
BankApp.main();

// Abstractions
interface AccountRepository {
  saveAccount(name: string): void;
}

interface TransactionProcessor {
  process(amount: number): void;
}

interface AlertService {
  sendAlert(message: string): void;
}

// low level modules
class PostgreSQL implements AccountRepository {
  saveAccount(name: string): void {
    console.log("Account saved:", name);
  }
}

class UPITransaction implements TransactionProcessor {
  process(amount: number): void {
    console.log("UPI transaction:", amount);
  }
}

class EmailAlertService implements AlertService {
  sendAlert(message: string): void {
    console.log("mail alert sent:", message);
  }
}
// High level module
class BankingService {
  constructor(
    private repository: AccountRepository,
    private processor: TransactionProcessor,
    private alert: AlertService
  ) {}

  openAccount(name: string) {
    this.repository.saveAccount(name);
    this.alert.sendAlert("Account opened" + name);
  }

  makeTransaction(amount: number) {
    this.processor.process(amount);
    this.alert.sendAlert("Transaction successful" + amount);
  }
}

// Application bootstrap
const bankingService = new BankingService(
  new PostgreSQL(),
  new UPITransaction(),
  new EmailAlertService()
);

bankingService.openAccount("rakesh");
bankingService.makeTransaction(2000);

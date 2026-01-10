interface MessageService {
  send(message: string): void;
}

class EmailService implements MessageService {
  send(message: string): void {
    console.log("Email sent:", message);
  }
}

class SmsService implements MessageService {
  send(message: string): void {
    console.log("SMS sent:", message);
  }
}

class NotificationManager {
  constructor(private service: MessageService) {}

  notify(message: string): void {
    this.service.send(message);
  }
}

const emailNotifier = new NotificationManager(new EmailService());
emailNotifier.notify("Welcome via Email");

const smsNotifier = new NotificationManager(new SmsService());
smsNotifier.notify("Welcome via SMS");

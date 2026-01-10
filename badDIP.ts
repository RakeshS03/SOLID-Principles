class EmailService {
  sendEmail(message: string): void {
    console.log("Email sent:", message);
  }
}

class NotificationManager {
  private emailService = new EmailService();

  notify(message: string): void {
    this.emailService.sendEmail(message);
  }
}

const manager = new NotificationManager();
manager.notify("Welcome User");

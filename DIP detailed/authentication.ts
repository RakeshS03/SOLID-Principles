interface AuthProvider {
  authenticate(): boolean;
}
class OAuth implements AuthProvider {
  authenticate(): boolean {
    return true;
  }
}
class LoginService {
  constructor(private auth: AuthProvider) {}

  login() {
    console.log(this.auth.authenticate() ? "Login success" : "Login failed");
  }
}
const loginService = new LoginService(new OAuth());
loginService.login();

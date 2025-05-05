public class Admin extends User { //inheritance (yg extends tu)
    private String username;
    private String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim); //s-key
        this.username = username;
        this.password = password;
    }

    @Override
    public void login(String inputUsername, String inputPassword) {
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login sebagai admin berhasil!");
        } else {
            System.out.println("Login Gagal, coba lagi.");
        }
    }

    @Override
    public void displayInfo() { super.displayInfo();
    }
}

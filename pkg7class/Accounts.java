package pkg7class;

public class Accounts {
    String id;
    String fname;
    String lname;
    String email;
    String user;
    String pass;

    public void storage(String id, String fname, String lname, String email, String user, String pass) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.user = user;
        this.pass = pass;
    }

    public void display() {
        System.out.printf(" %-10s %-10s %-10s %-10s %-10s %-10s\n",
                this.id, this.fname, this.lname, this.email, this.user, this.pass);
    }
}
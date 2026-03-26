import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
void main()
{
    ArrayList<Bank>Accounts=new ArrayList<>();
    Accounts.add(new Bank("A101","R123","rahman Mohammed",1200));
    Accounts.add(new Bank("A301","M123","Mustafa Mohammed",1500));
    Accounts.add(new Bank("A202","A123","Ali Mohammed",900));

    JFrame LoginFrame=new JFrame("Log In");

    JLabel lblAccountNumber=new JLabel("Account Number : ");
    JLabel lblpassword=new JLabel("Password :");
    JTextField txtAcc=new JTextField();
    JPasswordField txtpass=new JPasswordField();
    JButton btnlog=new JButton("Log In");


    lblAccountNumber.setBounds(20,20,130,20);
    lblpassword.setBounds(20,60,130,20);
    txtAcc.setBounds(130,20,130,25);
    txtpass.setBounds(130,60,130,25);
    btnlog.setBounds(130,110,130,40);

    LoginFrame.add(lblAccountNumber );
    LoginFrame.add(lblpassword);
    LoginFrame.add(txtpass);
    LoginFrame.add(txtAcc);
    LoginFrame.add(btnlog);

    LoginFrame.setSize(400,250);
    LoginFrame.setLayout(null);
    LoginFrame.setVisible(true);

    btnlog.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Boolean Accfound = false;
            Bank AccountFound = null;
            for (Bank acc : Accounts) {
                if (acc.account_number.equals(txtAcc.getText()) && acc.password.equals(txtpass.getText())) {
                    Accfound = true;
                    AccountFound = acc;
                    break;
                }
            }
            if (Accfound) {

                LoginFrame.setVisible(false);

                JFrame MainScreen = new JFrame("Main Screen");

                JLabel lblAmount = new JLabel("Amount :");
                JButton btnDeposit = new JButton("Deposit");
                JButton btnWithdraw = new JButton("Withdraw");
                JTextField txtAmount = new JTextField();

                lblAmount.setBounds(30, 40, 150, 20);
                txtAmount.setBounds(90, 40, 150, 25);
                btnDeposit.setBounds(50, 90, 90, 20);
                btnWithdraw.setBounds(150, 90, 90, 20);

                MainScreen.add(lblAmount);
                MainScreen.add(txtAmount);
                MainScreen.add(btnDeposit);
                MainScreen.add(btnWithdraw);

                MainScreen.setSize(500, 500);
                MainScreen.setLayout(null);
                MainScreen.setVisible(true);

                Bank finalAccount = AccountFound;

                btnDeposit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        double Amount = Double.parseDouble(txtAmount.getText());

                        if (Amount < 0) {
                            JOptionPane.showMessageDialog(MainScreen, "Amount Invalid");
                        } else {
                            finalAccount.deposit(Amount);
                            JOptionPane.showMessageDialog(MainScreen,
                                    "New Balance : " + finalAccount.balance);
                        }
                    }
                });

                btnWithdraw.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        double Amount = Double.parseDouble(txtAmount.getText());

                        if (Amount > finalAccount.balance) {
                            JOptionPane.showMessageDialog(MainScreen, "Amount Exceed tge Balance");
                        } else if (Amount < 0) {
                            JOptionPane.showMessageDialog(MainScreen, "Amount Invalid");
                        } else {
                            finalAccount.withdraw(Amount);
                            JOptionPane.showMessageDialog(MainScreen,
                                    "New Balance : " + finalAccount.balance);
                        }
                    }
                });
            }
        }
    });
}
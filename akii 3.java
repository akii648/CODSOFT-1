import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BankAccount{
    private double balance;
    public BankAccount(double initialBalance){
        balance = initialBalance;
    }
    public double getBalance(){
        return balance;
    
    }
    public void deposit(double amount){
        balance += amount;
    }
    public boolean withdraw(double amount){
        if(amount<=balance){
            balance -= amount;
            return true;
        }
        else{
            return false;
        }
    }
}
class ATMGUI extends JFrame implements ActionListener {
    private BankAccount account;
    private JTextField balanceField;
    private JTextField amountField;
    private JTextArea outputArea;

    public ATMGUI(BankAccount account){
        this.account =  account;
        setTitle(title:"ATM Machine");
        setSize(width:400,height:300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel =new JPanel();
    panel.setLayout(new GridLayout(rows 4,column 2));

    JLabel balanceLabel= new JLabel(text:"Balance");
    balanceField = new JTextField(Double.toString(account.getBalance()));
    balanceField.setEditable(b:false);

    JLabel amountLabel= new JLabel(text:"Amount");
    amountField= new JTextField();

    JButton checkBalanceButton = new JButton(text:"Check Balance") ;
    checkBalanceButton.addActionListener(this);

    JButton depositButton = new JButton(text:"deposit");
    depositButton.addActionListener(this);

    JButton withdrawButton = new JButton(text:"Withdraw");
    withdrawButton.addActionListener(this);

    outputArea = new JTextArea();
    outputArea.setEditable(b:false);

    panel.add(balanceLabel);
    panel.add(balanceField);
    panel.add(amountLabel);
    panel.add(amountField);
    panel.add(checkBalanceButton);
    panel.add(depositButton);
    panel.add(withdrawButton);
    panel.add(outputArea);

    add(panel);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals(anObject:"Check Balance")){
            outputArea.setText("Your balance is:Rs"+account.getBalance());
        }
        else if (e.getActionCommand().equals(anObject:"Deposit")){
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount>0){
                    account.deposit(amount);
                    balanceField.setText(t:"Deposit successful");

                }
                else{
                    outputArea.setText(t:"Invalid deposit amount");
                }
            }
            catch (NumberFormatException ex){
                outputArea.setText(t:"Invalid input. Please enter a valid amount. ")
            }

        }else if (e.getActionCommand().equals(anObject:"Withdraw")){
            try{
                double amount = Double.parseDouble(amountField.getText());
                if (amount > 0 && account.withdraw(amount)){
                    balanceField.setText(t:"Withdrawal successful.";)
                }
                else{
                    outputArea.setText(t:"Invalid withdrawal amount or unsufficient balance");
                }

            } catch(NumberFormatException ex){
                outputArea.setText(t:"Invalid input.Please enter a valid amount");
            }
        }
    }
}

public class akii3_GUI {
    public static void main(Strings[] args){
        BankAccount userAccount = new BankAccount(initialBalance:1000.0);
        ATMGUI atmGUI = new ATMGUI(userAccount);
        atmGUI.setVisible(b:true);
    }
}
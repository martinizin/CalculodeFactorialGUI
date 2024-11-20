import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Factorial {
    private JTable tbResult;
    private JButton CALCULARButton;
    private JTextField txtNum;
    private JPanel pGeneral;

    public Factorial() {

        CALCULARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inp=txtNum.getText();
                try {
                    int n=Integer.parseInt(inp);
                    long f =calcularFact(n);
                    DefaultTableModel model=new DefaultTableModel(new Object[]{"Número", "Factorial"},0);
                    model.addRow(new Object[]{"Número", "Factorial"});
                    model.addRow(new Object[]{n,f});
                    tbResult.setModel(model);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Ingrese un número válido!");

                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Factorial");
        frame.setContentPane(new Factorial().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public long calcularFact(int n){
        if(n==1){
            return 1;
        }else{
            return n*calcularFact(n-1);
        }

    }
}

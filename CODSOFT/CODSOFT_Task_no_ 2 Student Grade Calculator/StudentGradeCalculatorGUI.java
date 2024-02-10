import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeCalculatorGUI extends JFrame {
   
    private JTextField MathematicsField, DataStructureField, ComputerNetworkField, DBMSField;
    private JLabel resultLabel;

    public StudentGradeCalculatorGUI() {
        setTitle("Student Grade Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        setLayout(new GridLayout(8, 10));    
       
        JLabel MathematicsLabel = new JLabel("Mathematics:");
        MathematicsField = new JTextField();

        JLabel DataStructureLabel = new JLabel("DataStructure:");
        DataStructureField = new JTextField();

        JLabel ComputerNetworkLabel = new JLabel("ComputerNetwork:");
        ComputerNetworkField = new JTextField();  

        JLabel DBMSLabel = new JLabel("DBMS:");
        DBMSField = new JTextField();

        

        JButton calculateButton = new JButton("Calculate Grade");
        resultLabel = new JLabel("");

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });

        add(MathematicsLabel);
        add(MathematicsField);
        add(DataStructureLabel);
        add(DataStructureField);
        add(ComputerNetworkLabel);
        add(ComputerNetworkField);
        add(DBMSLabel);
        add(DBMSField);
        add(new JLabel()); // Empty label for spacing
        add(calculateButton);
        add(new JLabel()); // Empty label for spacing
        add(resultLabel);
    }

    private void calculateGrade() {
        try {
            double Mathematics = Double.parseDouble(MathematicsField.getText());
            double DataStructure = Double.parseDouble(DataStructureField.getText());
            double ComputerNetwork = Double.parseDouble(ComputerNetworkField.getText());
            double DBMS = Double.parseDouble(DBMSField.getText());
            

            double totalMarks = Mathematics + DataStructure + ComputerNetwork + DBMS;
            double averagePercentage = totalMarks / 4;

            String grade;

            if (averagePercentage >= 90) {
                grade = "A";
            } else if (averagePercentage >= 80) {
                grade = "B";
            } else if (averagePercentage >= 70) {
                grade = "C";
            } else if (averagePercentage >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }

            resultLabel.setText("Total Marks: " + totalMarks +
                    "   Average Percentage: " + averagePercentage + "%" +
                    "   Grade: " + grade);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid numeric values.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run()  {
                new StudentGradeCalculatorGUI().setVisible(true);
            }
        });
    }
}

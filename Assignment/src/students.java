import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class students {
    private JPanel panel1;
    private JTextField textID;
    private JTextField textName;
    private JTextField textCourse;
    private JTextArea textArea1;
    private JButton saveButton;
    private JButton readButton;

   stud S01;

    public students() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String Student_ID = textID.getText();
                String Student_Name = textName.getText();
                String Course = textCourse.getText();
                String Grades = textArea1.getText();

                S01 = new stud();
                S01.connect();
                S01.saveData(Student_ID, Student_Name, Course, Grades);

            }
        });
        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stude S03 = new stude();
                S03.init(false);


            }
        });
    }
    public static void main(String[] args) {
        students S02 = new students();
        S02.init();
    }

    public void init() {

        JFrame frame = new JFrame("students");
        frame.setContentPane(new students().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class stude {
    private JTable t1;
    private JPanel panel2;
    private JScrollPane spane;

    public static void main(String[] args) {
        stude S03 = new stude();
        S03.init(true);
    }

    public void init(boolean closeOnExit) {
        stud S01 = new stud();
        S01.connect();

        Vector<String> studentTitles = new Vector<String>();
        studentTitles.add("Student_ID");
        studentTitles.add("Student_Name");
        studentTitles.add("Course");
        Vector<Vector<String>> vData = S01.readStudent();

        panel2 = new JPanel(new BorderLayout());
        t1 = new JTable(vData, studentTitles);
        spane = new JScrollPane(t1);

        JLabel lb1Title = new JLabel("Student List");
        panel2.add(lb1Title, BorderLayout.PAGE_START);
        panel2.add(spane, BorderLayout.CENTER);

        JFrame frame = new JFrame("students");
        frame.add(panel2, BorderLayout.CENTER);
        if(closeOnExit) frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

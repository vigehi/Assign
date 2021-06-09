import javax.swing.*;
import java.util.Vector;

public class studens {
    private JTable t1;
    private JScrollPane spane;
    private JPanel panel2;

    public static void main(String[] args) {
        studens S04 = new studens();
        S04.init();
    }

    public void init() {
        stud S01 = new stud();
        S01.connect();

        Vector<String> studentTitles = new Vector<String>();
        studentTitles.add("Student_ID");
        studentTitles.add("Student_Name");
        studentTitles.add("Course");
        Vector<Vector<String>> vData = S01.readStudent();

        t1 = new JTable(vData, studentTitles);
        spane.setViewportView(t1);

        JFrame frame = new JFrame("studens");
        frame.setContentPane(new studens().panel2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.security.Key;

public class MyFrame extends JFrame {
    static final int W_FRAME = 800;
    static final int H_FRAME = 600;

    public MyFrame() throws HeadlessException{
        setTitle("Dictionary");
        setSize(W_FRAME, H_FRAME);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        // add panel
        MyPanel panel = new MyPanel();
        Container ctn = getContentPane();
        ctn.add(panel);

        // add menubar
        MenuBar menuBar = new MenuBar();
        setJMenuBar(menuBar);

        // add management
        DictionaryManager managerment = new DictionaryManager(panel, menuBar);


    }

}

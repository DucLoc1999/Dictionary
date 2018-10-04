import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MenuBar extends JMenuBar {
    ImageIcon newIcon = new ImageIcon(getClass().getResource("/image/new.png"));
    public MenuBar(){
        init();
    }
    public void init(){

        JMenu fileMenu = new JMenu("File");
        JMenu viewMenu = new JMenu("View");
        JMenu toolMenu = new JMenu("Tool");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem newMenuItem = new JMenuItem("New", newIcon);
        newMenuItem.setMnemonic(KeyEvent.VK_N);
        JMenuItem openMenuItem = new JMenuItem("Open", new ImageIcon(getClass().getResource("/image/open.png")));
        openMenuItem.setMnemonic(KeyEvent.VK_O);
        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Test NewMenuItem !");
            }
        });
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        this.add(fileMenu);
        this.add(viewMenu);
        this.add(toolMenu);

    }
}

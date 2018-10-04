
import javax.swing.*;
import javax.swing.border.Border;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel {

    Image mouseIcon = new ImageIcon(getClass().getResource("/image/mouseIcon.png")).getImage();
    Image bg = new ImageIcon(getClass().getResource("/image/bg1.jpg")).getImage();

    public MyPanel(){

        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                mouseIcon,
                new Point(0, 0),
                "Cursor"
                )
        );
        setFocusable(true);
        this.setLayout(null);
    }


    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2D = (Graphics2D) graphics;
        super.paintComponent(g2D);
        g2D.drawImage(bg, 0, 0, MyFrame.W_FRAME, MyFrame.H_FRAME, null);
        g2D.setFont(new Font(null, Font.BOLD, 10));
        g2D.drawString("D I C T I O N A R Y  A P L I C A T I O N" , 580, 20);
        g2D.setColor(Color.darkGray);
    }

    MouseMotionListener motionListener = new MouseMotionListener() {
        @Override
        public void mouseDragged(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseMoved(MouseEvent mouseEvent) {

        }
    };

    MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
            super.mouseReleased(mouseEvent);
        }
    };
}





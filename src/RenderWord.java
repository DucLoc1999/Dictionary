import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class RenderWord {
    private int x_;
    private int y_;
    private int width_;
    private int height_;
    private Border bd_;
    private JEditorPane txtWord_;
    private JPanel panelBd_;
    private JScrollPane scp_;

    public RenderWord(){
        this.x_ = 280;
        this.y_ = 80;
        this.width_ = 480;
        this.height_ = 450;
        bd_ = BorderFactory.createLoweredBevelBorder();
        txtWord_ = new JEditorPane();
        txtWord_.setContentType("text/html");
        txtWord_.setEditable(false);
        panelBd_ = new JPanel(new BorderLayout());
        panelBd_.setBorder(bd_);
        scp_ = new JScrollPane(txtWord_);
        addRW();
    }
    public JPanel addRW(){
        panelBd_.add(scp_);
        panelBd_.setBounds(x_, y_, width_, height_);
        return  panelBd_;
    }
    public  void printInfo(Map<Integer, String> wordInfo, int i){
        txtWord_.setText(wordInfo.get(i));

    }

}

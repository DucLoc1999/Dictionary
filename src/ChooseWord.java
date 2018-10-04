import javax.swing.*;

public class ChooseWord {
    private String word_;
    private int x_;
    private int y_;
    private int width_;
    private int height_;
    private JTextField txtChW_;

    public  ChooseWord(){
        this.x_ = 150;
        this.y_ = 35;
        this.width_ = 500;
        this.height_ = 25;
        txtChW_ = new JTextField(20);
        txtChW_.setBounds(x_, y_, width_, height_);

    }
    public JTextField addCW(){
       return  txtChW_;
    }
}

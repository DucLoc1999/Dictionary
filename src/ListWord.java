import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class ListWord {
    private String word_;
    private String[] listWord_;
    private int index_;
    private int row_;
    private int colum_;
    private int x_;
    private int y_;
    private int width_;
    private int height_;
    private DefaultListModel<String> model;
    public JList<String> myList_;
    private JScrollPane scroll_;
    private Map<Integer, String> mapData_;

    public ListWord() {
        this.row_ = 500;
        this.colum_ = 200;
        this.x_ = 20;
        this.y_ = 80;
        this.width_ = 250;
        this.height_ = 450;
        model = new DefaultListModel<>();
        myList_ = new JList<>(model);
        scroll_ = new JScrollPane(myList_);
        scroll_.setBounds(x_, y_, width_, height_);

        mapData_ = new HashMap();
    }

    public int getIndex_() {
        return index_;
    }

    public void setIndex_(int index_) {
        this.index_ = index_;
    }

    public JScrollPane addLW() {
        return scroll_;
    }

    public void putData(Map dict) {
        mapData_.putAll(dict);

    }

    public void printWord() {
        for (int i = 0; i < 1000; i++) {
            model.addElement(mapData_.get(i));
        }
    }

    public int getCount(){

        ListSelectionListener lsl = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                JList list = (JList) e.getSource();
            }
        };
        myList_.addListSelectionListener(lsl);

        int count = myList_.getSelectedIndex();
        return count;
    }


}


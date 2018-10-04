import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DictionaryManager {
    private final String FILE_PATH = "E_V.txt";
    private JLabel lb;
    private ChooseWord chooseWord;
    private ListWord listWords;
    private RenderWord renderWord;
    private DataBase dict;

    public DictionaryManager(JPanel panel, JMenuBar menuBar){
        init();
        add(panel);
        doNothing();
    }
    public void init(){
        lb = new JLabel("Nhập từ");
        chooseWord = new ChooseWord();
        listWords = new ListWord();
        renderWord = new RenderWord();
        dict = new DataBase();
    }
    public void add(JPanel panel) {
        //add label
        panel.add(lb);

        //add choose word
        panel.add(chooseWord.addCW());

        //add list word
        panel.add(listWords.addLW());

        //add render word
        panel.add(renderWord.addRW());
    }
    public void doNothing(){
        dict.readFile(FILE_PATH);
        listWords.putData(dict.getWordTarget_());
        listWords.printWord();
        // connect listword and renderword
        listWords.myList_.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                if(listSelectionEvent.getValueIsAdjusting()){
                    renderWord.printInfo(dict.getWordInfo_(), listWords.myList_.getSelectedIndex());
                }
            }
        });

    }
}

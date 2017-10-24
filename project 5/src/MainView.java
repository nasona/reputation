import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The main window for dealing from a deck of cards.
 * @author lambertk
 *
 */
public class MainView extends JFrame{

    private Deck deck;
    private WarGame model;

    public MainView(Deck deck){
        this.deck = deck;
        this.setTitle("The Game of War");
        
        JLabel player1Label = new JLabel("Player 1");
        JLabel statusLabel = new JLabel("Game Status");
        JLabel player2Label = new JLabel("Player 2");
        
        CardPanel panel1 = new CardPanel();
        JTextField statusField = new JTextField(1);
        statusField.setEditable(false);
        statusField.setHorizontalAlignment(JTextField.CENTER);
        statusField.setText(model.toString());
        CardPanel panel2 = new CardPanel();
        JButton moveButton = new JButton("Move");
        JButton newButton = new JButton("New Game");
        
        moveButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (! deck.isEmpty()){
                    Card card = deck.deal();
                    card.turn();
                    panel1.setCard(card);
                    panel2.setCard(card);
                }
            }});
        
        newButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (! deck.isEmpty()){
                    Card card = deck.deal();
                    card.turn();
                    panel1.setCard(card);
                    panel2.setCard(card);
                }
            }});
        
        Container c = getContentPane();
        c.setLayout(new GridLayout(3, 3));
        c.add(player1Label);
        c.add(statusLabel);
        c.add(player2Label);
        c.add(panel1);
        c.add(statusField);
        c.add(panel2);
    }
}

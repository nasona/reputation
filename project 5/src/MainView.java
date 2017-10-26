import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The main window for dealing from a deck of cards.
 * 
 * @author nasona
 * @author lefkowitza
 * @author delosreyesa
 * @author greenleafm
 * @author lambertk
 * @version 1.1
 *
 */
public class MainView extends JFrame{

    private Deck deck;
    protected WarGame model = new WarGame();

    public MainView(Deck deck){
        this.deck = this.model.getDeck();
        model.dealAll();
        this.setTitle("The Game of War");
        
        JLabel player1Label = new JLabel("Player 1");
        JLabel statusLabel = new JLabel("Game Status");
        JLabel player2Label = new JLabel("Player 2");
        
        CardPanel panel1 = new CardPanel();
        
        JTextArea statusField = new JTextArea();
        statusField.setEditable(false);
        statusField.setText(model.toString());
        
        CardPanel panel2 = new CardPanel();
        JButton moveButton = new JButton("Move");
        JButton newButton = new JButton("New Game");
        
        moveButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (! deck.isEmpty()){
                    Card card1 = MainView.this.model.getPlayer1Card();
                    Card card2 = MainView.this.model.getPlayer2Card();
                    MainView.this.model.step();
                    card1.turn();
                    card2.turn();
                    statusField.setText(model.toString());
                    panel1.setCard(card1);
                    panel2.setCard(card2);
                    //model.winner();
                }
            }});
        
        newButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	MainView.this.model = new WarGame();
            	panel1.setCard(null);
            	panel2.setCard(null);
            	statusField.setText("");
                	//not this
            }});
        
        Container c = getContentPane();
        c.setLayout(new GridLayout(3, 3));
        c.add(player1Label);
        c.add(statusLabel);
        c.add(player2Label);
        c.add(panel1);
        c.add(statusField);
        c.add(panel2);
        c.add(moveButton);
        c.add(newButton);
    }
}

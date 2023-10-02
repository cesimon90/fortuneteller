import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private int lastIndex = -1;
    private final JTextArea textArea;
    private final ArrayList<String> fortunes;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // Top Panel
        JPanel topPanel = new JPanel();
        ImageIcon imageIcon = new ImageIcon("path/to/your/image.png");
        JLabel label = new JLabel("Fortune Teller", imageIcon, JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 36));
        topPanel.add(label);
        add(topPanel, BorderLayout.NORTH);

        // Middle Panel
        textArea = new JTextArea(10, 40);
        textArea.setFont(new Font("Verdana", Font.PLAIN, 24));
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel
        JPanel bottomPanel = new JPanel();
        JButton readButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");
        readButton.setFont(new Font("Arial", Font.PLAIN, 24));
        quitButton.setFont(new Font("Arial", Font.PLAIN, 24));
        bottomPanel.add(readButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Fortunes
        //I just found these fortunes online
        fortunes = new ArrayList<>();
        fortunes.add("Your smile is a passport to countless hearts. Share it generously.");
        fortunes.add("Embrace change, for it is the only constant in life. And maybe buy an umbrella, just in case.");
        fortunes.add("Adventure awaits you at the next corner. Remember to pack your curiosity.");
        fortunes.add("Your creativity knows no bounds. It's time to let your imagination run wild.");
        fortunes.add("A good laugh is sunshine in the house. Seek out the sunshine, share the laughter.");
        fortunes.add("Every exit is an entry somewhere else. Unless it's a closed door, then it's just an obstacle. Try the window.");
        fortunes.add("A bird in the hand is worth two in the bush. But if you have a net, you might just catch the whole flock.");
        fortunes.add("Success is a journey, not a destination. So, pack light and enjoy the ride.");
        fortunes.add("The best way to predict the future is to create it. Or, you know, buy a crystal ball and give it a shot.");
        fortunes.add("Your kindness will turn a stranger into a friend. Or at least a friendly acquaintance. Baby steps.");
        fortunes.add("The best is yet to come. But remember, the present is a gift, that’s why it’s called present!");
        fortunes.add("You are never too old to set another goal or to dream a new dream. Unless your dream is to be a child again. In that case, you might be out of luck.");

        readButton.addActionListener((ActionEvent e) -> readFortune());
        quitButton.addActionListener((ActionEvent e) -> System.exit(0));
    }

    private void readFortune() {
        Random random = new Random();
        int index;
        do {
            index = random.nextInt(fortunes.size());
        } while (index == lastIndex);
        lastIndex = index;
        String fortune = fortunes.get(index);
        textArea.append(fortune + "\n");
    }
}
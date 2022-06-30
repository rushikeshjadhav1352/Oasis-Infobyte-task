//Task 2 complete game based



import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

    class main extends JFrame
    {
        public static void main(String[] args)
        {
            new main();
        }
        private static final long serialVersionUID = 1L;
        JTextField guess, tg;
        ButtonListener Listener;
        ButtonListener2 Listener2;
        ButtonListener3 Listener3;
        JLabel inputL,GuessL,tryL,bestScrorL,TotalgL,imglabel;

        int Rnumber=(int) (Math.random()*100);
        int count=10;
        public main()
        {

            Container c = getContentPane();
            c.setLayout(null);
            c.setBackground(Color.orange);

            tryL = new JLabel("Try and guess it !");
            tryL.setFont(new Font("Arial",Font.PLAIN,15));
            tryL.setSize(270,20);
            tryL.setLocation(110,160);
            guess = new JTextField(30);
            guess.setSize(50,30);
            guess.setLocation(140,120);
            tg = new JTextField(10);
            tg.setSize(20,20);
            tg.setLocation(150,40);
            GuessL = new JLabel("Guess the Number ?");
            GuessL.setForeground(Color.white);
            GuessL.setFont(new Font("blue",Font.BOLD,24));
            GuessL.setSize(270,20);
            GuessL.setLocation(70,70);
            TotalgL = new JLabel("Turn Left !");
            TotalgL .setFont(new Font("Comic Sans MS",Font.PLAIN,12));
            TotalgL.setSize(270,20);
            TotalgL.setLocation(130,20);
            inputL=new JLabel("Enter a number between 1-100");
            inputL.setFont(new Font("Arial",Font.PLAIN,15));
            inputL.setSize(270,20);
            inputL.setLocation(70,90);
            imglabel = new JLabel("");
            imglabel.setIcon(new ImageIcon());
            imglabel.setBounds(80,10,300,350);

            Icon i=new ImageIcon();
            JButton guessbutton =new JButton(i);
            guessbutton.setText("Guess");
            guessbutton.setSize(100,30);
            guessbutton.setLocation(110,190);
            Listener = new ButtonListener();
            guessbutton.addActionListener(Listener);


            JButton playagainbutton = new JButton("Play Again!");
            playagainbutton.setSize(100,30);
            playagainbutton.setLocation(110,240);
            playagainbutton.setBackground(Color.green);
            Listener3 = new ButtonListener3();
            playagainbutton.addActionListener(Listener3);

            c.add(TotalgL);
            c.add(tryL);
            c.add(imglabel);
            c.add(GuessL);
            c.add(inputL);
            c.add(guess);
            c.add(tg);
            c.add(guessbutton);

            c.add(playagainbutton);

            tg.setEditable(false);
            setTitle("GUESS THE NUMBER");
            setSize(500,350);
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

        private class ButtonListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                int a = Integer.parseInt(guess.getText());
                count=count-1;
                if( count<0)
                {
                    tryL.setText("you Lost"+" The correct answer is "+Rnumber+"!!");
                    count = 0;
                }
                else if(a<Rnumber)
                {
                    tryL.setText(a+" is low,\n try again!!");
                }
                else if(a>Rnumber)
                {
                    tryL.setText(a+" is high, try again!!");
                }
                else
                {
                    tryL.setText("Your guess is correct, You win!!");
                    guess.setEditable(false);

                }

                guess.requestFocus();
                guess.selectAll();
                tg.setText(count+"");
            }
        }

        private class ButtonListener2 implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                tg.setText("");
                tryL.setText("The correct answer is "+Rnumber+"!!");
                guess.setText("");
                guess.setEditable(false);
            }
        }

        private class ButtonListener3 implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                Rnumber=(int) (Math.random()*100);
                guess.setText("");
                tg.setText("");
                tryL.setText("Try and guess it !");
                tg.setText("");
                count=10;
                guess.setEditable(true);
                guess.requestFocus();
            }
        }


    }


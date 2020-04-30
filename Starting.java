package app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Starting extends GameScreen {
    private JButton nextButton,chooseButton;
    private int i=1;
    private JTextField inputName;
    private String playerName,pokemonChoice,pokemonName="Not Naming";
    private ActionListener Action1,Action2,Action3,TextAction1,TextAction2,ChooseAction1;
    private JComboBox<String> pokemonChoose;
    public Starting(Container c){
        super(c);
        String[] introduction = { "Welcome to Pokemon World!" ,"Why don't you tell me a little bit about yourself?",
                                "What's your name?"};
        nextButton = new JButton(">");
        nextButton.setBounds(400,500,170,100);
        nextButton.setFont(normalFont);
        nextButton.setBackground(Color.black);
        nextButton.setForeground(Color.white);
        mainTextArea.setText(introduction[0]);
        //add a nextbutton's ActionListener 1
        Action1 = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //when all text is played
                if(i>=introduction.length-1){
                    //create textfield
                    nextButton.setVisible(false);
                    inputName = new JTextField(250);
                    inputName.setBounds(200,500,600,50);
                    inputName.setFont(normalFont);
                    //add a TextField's Action Listener 1
                    TextAction1 = new ActionListener(){
                        public void actionPerformed(ActionEvent e){  
                            playerName = e.getActionCommand();
                            nextButton.setVisible(true);
                            inputName.setVisible(false);
                            inputName.setText("");
                            partTwo(c);
                        }
                    };
                    //TextField action for 
                    inputName.addActionListener(TextAction1);
                    c.add(inputName);
                }
                //playing text (even if is triggered it's continue to do)
                mainTextArea.setText(introduction[i]);
                i++;
            }
        };
        nextButton.addActionListener(Action1);
        c.add(nextButton);
    }
    private void partTwo(Container c){
        String[] introduction2 = {playerName+" Huh...\nWhat a wonderful name!" , "I have 3 of these pokemon. I'll let you choose 1 of them!",
                                "First is Charlizard.\nSecond is Squirtle\nThird is Pikachu.","Who do you want to be your first Pokemon?"};
        i = 1;
        String[] pokemonList = {"Charlizard","Squirtle","Pikachu"};
        mainTextArea.setText(introduction2[0]);
        nextButton.removeActionListener(Action1);
        //Add a new Action for nextbutton
        Action2 = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //when all text is played
                if(i>=introduction2.length-1){
                    nextButton.setVisible(false);
                    //creating combobox for choosing pokemon
                    pokemonChoose = new JComboBox<String>(pokemonList);
                    pokemonChoose.setBounds(200,500,400,50); 
                    pokemonChoose.setFont(normalFont);
                    pokemonChoose.setBackground(Color.black);
                    pokemonChoose.setForeground(Color.white);
                    //creating button for submit
                    chooseButton = new JButton("Choose!");
                    chooseButton.setBounds(650,500,250,50);
                    chooseButton.setFont(normalFont);
                    chooseButton.setBackground(Color.black);
                    chooseButton.setForeground(Color.white);
                    c.add(pokemonChoose);
                    c.add(chooseButton);
                    //when pokemon is selected
                    ChooseAction1 = new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            pokemonChoice = (String)pokemonChoose.getSelectedItem();
                            chooseButton.setVisible(false);
                            pokemonChoose.setVisible(false);
                            //proceed to part 3
                            partThree(c);  
                        }
                    };
                    chooseButton.addActionListener(ChooseAction1);
                }
                //playing text (even if is triggered it's continue to do)
                mainTextArea.setText(introduction2[i]);
                i++;
            }
        };
        nextButton.addActionListener(Action2);
    }
    
    private void partThree(Container c){
        String[] introduction3 = {"Remember this.\nPokemon has 4 stats in total.",
                                "ATK. Attack Power \nDEF. Defense \nHP. your Pokemon lose the battle if HP reach 0.\nSPD. Which side have more speed will be decided to attack first",
                                "And your Pokemon can be strenghen furthur by items!","- HP Booster is used to increase Pokemon's MaxHP\n- ATK Booster is used to increase Pokemon ATK.\n- DEF Booster is used to increase Pokemon's DEF\n- SPD Booster is used to increase Pokemon's SPD\n- Elixir can be use either outside or inside battle. Use it to restore HP to max",
                                "Now go to explore this Vast and Beautiful world together with your Pokemon!!!"};
        i=1;
        mainTextArea.setText("Naming your first Pokemon");
        inputName.setVisible(true);
        TextAction2 = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pokemonName = e.getActionCommand();
                nextButton.setVisible(true);
                inputName.setVisible(false);
                mainTextArea.setText( playerName + " and " + pokemonName + "...\nWhat a wonderful Pokemon");
            }
        };
        inputName.removeActionListener(TextAction1);
        inputName.addActionListener(TextAction2);
        Action3 = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if( i >= introduction3.length){
                    //at this point now introduction part is finished 
                    //starting real game
                    nextButton.setVisible(false);
                    c.removeAll();
                    new GameMenu(c,pokemonChoice,playerName,pokemonName);
                }
                else{
                    mainTextArea.setText(introduction3[i]);
                    i++;
                }
                
            }
        };
        nextButton.removeActionListener(Action2);
        nextButton.addActionListener(Action3);   
    }
}
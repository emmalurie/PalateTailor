/*TodaysChoicePanel.java
 *Last updated: 7 May 2016
 *Author: Emma Lurie
 *About: TodaysChoice contains both lunch panel and dinner panel for user to click on the 
 * lunch/ dinner button to see the corresponding results generated through the program. The 
 * results are calculated based on comparing today's menu to the hashtable we have in the data
 * base. The program will genenrate two best dinning halls for each meal. 
 */


import java.awt.*;
import java.awt.event.*; 
import javax.swing.*; 

public class TodaysChoicePanel extends JPanel{
  
  private JButton lunchButton, dinnerButton;
  private JPanel lunchButtonPanel, dinnerButtonPanel, lunchPanel, dinnerPanel, instructionsPanel, resultsPanel;
  private String meal; 
  private PalateTailor selector;
  private JLabel lunchFirst, lunchSecond, lunchRec, dinnerFirst, dinnerSecond, dinnerRec, instructions;

  public TodaysChoicePanel(){
    //panels 
    instructionsPanel = new JPanel();
    resultsPanel = new JPanel();
    
    lunchButtonPanel = new JPanel();
    dinnerButtonPanel = new JPanel();
    
    lunchPanel = new JPanel();
    dinnerPanel = new JPanel();
    
    //buttons 
    lunchButton = new JButton("See My Lunch");
    dinnerButton = new JButton("See My Dinner");
    
    //listener 
    ButtonListener listener = new ButtonListener();
    lunchButton.addActionListener(listener);
    dinnerButton.addActionListener(listener);
    
    
    //labels 
    lunchFirst = new JLabel();
    lunchSecond = new JLabel();
    lunchRec = new JLabel();
    
    dinnerFirst = new JLabel();
    dinnerSecond = new JLabel();
    dinnerRec = new JLabel();
    
    instructions = new JLabel("A good meal is just a click away!", JLabel.CENTER);
    

    
    //layout
    setLayout(new BorderLayout());
    lunchPanel.setLayout(new GridLayout(4,1));
    dinnerPanel.setLayout(new GridLayout(4,1));
    
    //border 
    instructionsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    lunchButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    lunchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    dinnerButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    dinnerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    
    //background color 
    Color lightBlue = new Color(135, 206, 250);
    Color lightPurple = new Color(216,191,216);
    
    instructionsPanel.setBackground(lightBlue);
    lunchButtonPanel.setBackground(lightPurple);
    lunchPanel.setBackground(lightBlue);
    dinnerButtonPanel.setBackground(lightPurple);
    dinnerPanel.setBackground(lightBlue);
    
    //center text
    lunchFirst.setHorizontalAlignment(JLabel.CENTER);
    lunchSecond.setHorizontalAlignment(JLabel.CENTER);
    lunchRec.setHorizontalAlignment(JLabel.CENTER);
    
    dinnerFirst.setHorizontalAlignment(JLabel.CENTER);
    dinnerSecond.setHorizontalAlignment(JLabel.CENTER);
    dinnerRec.setHorizontalAlignment(JLabel.CENTER);
    
    //set font 
    Font titleFont = new Font ("Marker Felt" , Font.BOLD, 54);
    Font buttonFont = new Font ("Marker Felt" , Font.PLAIN, 48);
    Font textFont = new Font ("Marker Felt" , Font.PLAIN, 36);

    
    lunchButton.setFont(buttonFont);
    dinnerButton.setFont(buttonFont);
    
    lunchFirst.setFont(textFont);
    lunchSecond.setFont(textFont);
    lunchRec.setFont(textFont);
    
    dinnerFirst.setFont(textFont);
    dinnerSecond.setFont(textFont);
    dinnerRec.setFont(textFont);

    instructions.setFont(titleFont);
   
    //add buttons and result text
    lunchButtonPanel.add(lunchButton);

    lunchPanel.add(lunchButtonPanel);
    lunchPanel.add(lunchFirst);
    lunchPanel.add(lunchRec);
    lunchPanel.add(lunchSecond);
    
    dinnerButtonPanel.add(dinnerButton);
    dinnerPanel.add(dinnerButtonPanel);
    dinnerPanel.add(dinnerFirst);
    dinnerPanel.add(dinnerRec);
    dinnerPanel.add(dinnerSecond);


    //add instructions to instruction panel
    instructionsPanel.add(instructions);
    
    
    //set results panel layout and add lunch and dinner panel
    resultsPanel.setLayout(new GridLayout(2, 1));
    resultsPanel.add(lunchPanel);
    resultsPanel.add(dinnerPanel);
    
    add(instructionsPanel, BorderLayout.NORTH);
    add(resultsPanel, BorderLayout.CENTER);
    
  }
  
  
  /*
   * ButtonListener is a private class for responding to button push events, in this
   * case, the lunch and dinner buttons
   */ 
  private class ButtonListener implements ActionListener {
    
    public void actionPerformed (ActionEvent event){
       String topChoice;
      if (event.getSource() == lunchButton){
        meal = "lunch"; 
      }else {
        meal = "dinner";
      }
      //creates new selector on each button press
      PalateTailor selector = new PalateTailor();
      
      selector.initializeAll(meal);
      DiningHall[] topTwo = selector.getTopTwoDiningHalls();
      topChoice = topTwo[0].getName();
      
      if (meal.equals("lunch")){
        lunchFirst.setText("The best dining hall for lunch today is " + topChoice + "!!!"); //prints the top-rated dining hall
        lunchRec.setText("At " + topChoice + ", we recommend you try " + topTwo[0].getTop().shortenName());//prints the top-rated rated dining hall's top-rated dish
        lunchSecond.setText("If you can't make it to " + topChoice +", another great choice is " + topTwo[1].getName()+"!"); 

      }else {
        //prints in same format as lunch
        dinnerFirst.setText("The best dining hall for dinner today is " + topChoice + "!!!"); 
        dinnerRec.setText("At " + topChoice + ", we recommend you try " + topTwo[0].getTop().shortenName());
        dinnerSecond.setText("If you can't make it to " + topChoice +", another great choice is " + topTwo[1].getName() +"!"); 

      
    }
  }
}
}
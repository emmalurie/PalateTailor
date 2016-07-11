/*PalateTailorGUI.java
 *Last updated: 7 May 2016
 *Author: Emma Lurie
 *About: Driver class that establishes JFrame with 3 Tabbed Panels: 
 * InstructionsPanel, TodaysChoice, JustForYouPanel. 
 */

import javax.swing.*; 
import java.awt.*; 

public class PalateTailorGUI{
  
  public static void main(String[] args){
    JFrame frame = new JFrame("Palate Tailor"); //new frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    JTabbedPane tp = new JTabbedPane(); 
  
    //three tabs 
    tp.addTab("Instructions", new InstructionsPanel()); 
    tp.addTab("Today�s Choice", new TodaysChoicePanel()); 
    tp.addTab("Just for You", new JustForYouPanel()); 
    
    frame.getContentPane().add(tp); //add tabbed pane to frame
    frame.setPreferredSize(new Dimension(1450,800)); //set size
    frame.pack(); 
    frame.setVisible(true); 
  }
  
  
}

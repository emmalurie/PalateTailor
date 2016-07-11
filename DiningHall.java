/*DiningHall.java
 *Last updated: 7 May 2016
 *Authors: Emma Lurie and Dorothy Sun
 *About: Each dining hall is reprented by a DiningHall object. DiningHall objects have a name (ie "Tower") an averageScore,
 *and a menu (a PriorityQueue<Dish>) that holds Dish objects that represent what is being
 *at a given meal at that dining hall. Besides the three instance variables mentioned previously the class contains getters, a createMenu() method that adds all
 *Dishes that appear in the hashtable to the menu. There is also a toString() method.
 */


import javafoundations.*;
import java.util.Hashtable;
import java.util.LinkedList;

public class DiningHall implements Comparable<DiningHall>{
  
  private PriorityQueue<Dish> menu; 
  private String name; 
  private double averageScore; //average score of dishes
  
  //constructor
  public DiningHall(String name){
    menu = new PriorityQueue<Dish>();
    this.name = name; 
    averageScore = 0.0; 
  }
  
  //getters and setters
  public String getName(){
    return name;  
  }
  
  public PriorityQueue<Dish> getMenu(){
    return menu;  
  }
  
  public double getAverageScore(){
    return averageScore;  
  }
  
  /*this method is useful for the JustForYou Panel because 
   * it allows us to change the score of the dining hall 
   * based on the user's preferences*/
  public void setAverageScore(double score){
    averageScore = score;
  }
  
  /*helper method that adds a Dish to the menu 
   * @param d is a dish to be added to the PriorityQueue<Dish> menu
   */
  private void addToMenu(Dish d){
    try {
      menu.enqueue(d);
    } catch (NullPointerException n){
      System.out.println(d.getName() + " is throwing a null pointer"); 
    }
  }
  
  /*copies the menu 
   * @return PriorityQueue<Dish> copy of the menu
   */
  private PriorityQueue<Dish> copyMenu(){
    PriorityQueue<Dish> temp = new PriorityQueue<Dish>(); 
    PriorityQueue<Dish> copy = new PriorityQueue<Dish>();
    
    while(!menu.isEmpty()){
      Dish element = menu.dequeue();
      temp.enqueue(element);
      copy.enqueue(element);
    }
    menu = temp; 
    return copy; 
  }
  
  /* Return the highest rated dish from the menu
   * @return Dish the highest rated dish on the menu*/
  public Dish getTop(){
    try{
      return menu.first(); 
    }catch(NullPointerException ex){
      System.out.println("There is no food here!!!");
      return null; 
    }
  }
  
  
  /*creates a menu of Dish objects by comparing the items in today's menu to keys in the hashtable. 
   * If the hashtable contains the name of the dish, the value, is a Dish object representing that meal option.
   * That dish object is added to that DiningHall's menu
   * 
   @param todaysMenufile is the .txt file of the Wellelsey Fresh menu, a parameter for readWellesleyFresh()
   @param dataFile is the .tsv file that holds all of the recent Wellesley Fresh menu items and their scores, a parameter for createHahashTable
   @param mealName is either "lunch" or "dinner", a parameter for readWellesleyFresh()
   */
  private void createMenu(String todaysMenuFile, String dataFile, String mealName){
    
    Hashtable<String, Dish> data = PalateTailor.createHashtable(dataFile); 
    LinkedList<String> optionsToday = PalateTailor.readWellesleyFresh(todaysMenuFile, mealName); 
    
    //System.out.println(optionsToday);
    
    while(!optionsToday.isEmpty()){
      
      String dishName = optionsToday.remove();
      
      if(data.containsKey(dishName)){ //if name of dish is in hashtable
        this.addToMenu(data.get(dishName)); //add dish to menu
      }else {
        if (dishName.length() > 30){
          System.out.println(dishName.substring(0,30) + "... could not addded to menu "); //formatting line
        } else {
          //System.out.println(dishName + "... could not addded to menu "); this line was used for testing
        }
      }
    }
    
  }
  
  
  
   /*calculates the average score (stored in averageScore instance variable) of the DiningHall by calculating the average score of all of the menu items */
  private double calcScore(){
    PriorityQueue<Dish> menuClone = copyMenu(); //clone of menu
    double score = 0.0;
    try{
      
      if(menu.size() == 0){
        return 0.0; 
      }
      
      for (int i = 0; i < menu.size(); i++){
        try {
          score += menuClone.dequeue().getScore(); //keep adding all dishes to menu
        }catch(Exception ex){
          System.out.println("No objects are in the menu"); 
        }
      }
      averageScore = score/(double)menu.size(); 
      return averageScore;
    }catch(Exception e){
      return -1;
    }
  }
  
  /*toString method to print out name of dishes and averageScore at a given meal*/
  public String toString(){
    String result = ""; 
    result += "DINING HALL NAME: " + name + "\n"; 
    result += "DINING HALL MENU: " + menu;
    result += "\nAVERAGE SCORE: " + averageScore +"\n";
    
    return result; 
  }
  
  /*compareTo method compares the averageScore of dininghalls*/
  public int compareTo (DiningHall d){
    if (this.averageScore > d.averageScore)  return 1;  
    if (this.averageScore == d.averageScore) return 0; 
    return -1;
  }
  
  /*creates the menu for a DiningHall and the calculates the DiningHall's average score. This cannot be done in the constructor because the meal "lunch"
   * or "dinner" must be known"  
   * 
   @param todaysMenufile is the .txt file of the Wellelsey Fresh menu, a parameter for createMenu()
   @param dataFile is the .tsv file that holds all of the recent Wellesley Fresh menu items and their scores, a parameter for createMenu()
   @param mealName is either "lunch" or "dinner", a parameter for createMenu()
   */
  public void initializeDiningHall(String todaysMenuFile, String dataFile, String mealName){
    createMenu(todaysMenuFile, dataFile, mealName);
    calcScore();
  }
  
  
  
  /*testing version
   * the same header as the previous method but an extra paramter of "day" to test on any date
   * 
   * @param day input a date that is not "today" so we could test the program on any given date
   */
  public void createMenu(String todaysMenuFile, String dataFile, String mealName, int day){
    
    Hashtable<String, Dish> data = PalateTailor.createHashtable(dataFile); 
    LinkedList<String> optionsToday = PalateTailor.readWellesleyFresh(todaysMenuFile, mealName,day); 
    
    //System.out.println(optionsToday);
    
    while(!optionsToday.isEmpty()){
      
      String dishName = optionsToday.remove();
      
      if(data.containsKey(dishName)){
        this.addToMenu(data.get(dishName));
      }else {
        if (dishName.length() > 30){
          System.out.println(dishName.substring(0,30) + "... could not addded to menu ");
        } else {
          System.out.println(dishName + "... could not addded to menu ");
        }
      }
    }
    
  }
  
  /*testing version for initializeDiningHall overloaded version with day of the week parameter*/
  public void initializeDiningHall(String todaysMenuFile, String dataFile, String mealName, int day){
    createMenu(todaysMenuFile, dataFile, mealName, day);
    calcScore();
  }
}
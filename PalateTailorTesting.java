/*PalateTailorTesting.java
 *7 May 2016
 *by Emma Lurie
 *Tests all (important/slightly difficult) methods used in the program */

public class PalateTailorTesting{
  
  public static void main (String[] args){
    /*Dish class testing*/
    
    System.out.println("Dish class Testing:\n");
    Dish a = new Dish("Mushroom, Spinach and Goat Cheese Frittata (V), and Vidalia Onion and Sweet Potato Hash (VE)");
    a.setScore(6);
    System.out.println("Dish a's name is Mushroom, Spinach and Goat Cheese Frittata (V), and Vidalia Onion and Sweet Potato Hash (VE) and I set the score in setScore to 6"); 
    System.out.println("toString(): \n"+ a);
    
    Dish s = new Dish ("Loaded Baked Potato Soup (V)", 7);
    System.out.println("Dish s" + " new Dish (Loaded Baked Potato Soup (V), 7)");
    System.out.println("toString(): \n" + s);
    
    System.out.println("Test shortenName(): it should only shorten Dish a's name not Dish b");
    System.out.println("Dish a: " + a.shortenName());
    System.out.println("Dish s: " + s.shortenName() +"\n");
    
    System.out.println("compareTo() a to s: " + a.compareTo(s));
    System.out.println("compareTo() s to a: " + s.compareTo(a));
    
    
    /*Dining Hall testing*/
    System.out.println("\nDiningHall class testing:\n");
    DiningHall b = new DiningHall("Bates");
    DiningHall l = new DiningHall("Lulu");
    DiningHall p = new DiningHall("Pom");
    
    System.out.println("getTop() testing: Testing Dining Hall object before menu is added. Average score MUST be 0.0\n");
    System.out.println(b);
    System.out.println("adding Sunday lunch menu for Bates....");
    b.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "lunch", 1);
    System.out.println(b);
    System.out.println("getTop() testing: The highest ranked Dish at Bates(could be either dish): "+ b.getTop().shortenName());
    
    System.out.println("adding Sunday lunch menu for Lulu and Pom....");
    l.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "lunch", 1);
    p.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "lunch", 1);
    System.out.println(l);
    System.out.println("getTop() testing: The highest ranked Dish at Lulu(could be either vegetable fritatta or omelet bar): "+ l.getTop().shortenName());
    System.out.println(p);
    System.out.println("The highest ranked Dish at Pom(Cinnamon Apple Pancake (V)): "+ p.getTop().shortenName());
    
    System.out.println("\ncompareTo testing for DiningHall");
    System.out.println("Bates compared to Lulu (-1): " + b.compareTo(l));
    System.out.println("Lulu compared to Bates (1): " + l.compareTo(b));
    System.out.println("Lulu compared to Pom (1): " + l.compareTo(p));
    System.out.println("Pom compared to Bates (-1): " + p.compareTo(b));
    
    
    System.out.println("Start date and End date testing... is a helper method to readWellesleyFresh() in DiningHall class");
    System.out.println("getStartDow(1) (Sunday): " + PalateTailor.getStartDow(1));
    System.out.println("getEndDow(1) (Monday): " + PalateTailor.getEndDow(1) +"\n");
    
    System.out.println("getStartDow(2) (Monday): " + PalateTailor.getStartDow(2));
    System.out.println("getEndDow(2) (Tuesday): " + PalateTailor.getEndDow(2)+"\n");
    
    System.out.println("getStartDow(7) (Saturday): " + PalateTailor.getStartDow(7));
    System.out.println("getStartDow(7) (Sunday): " + PalateTailor.getEndDow(7)+"\n");
    
    System.out.println("PalateTailor testing readWellesleyFresh() reads from txt file to create LinkedList<String> of Dish names");
    System.out.println("Bates Menus:");
    System.out.println("Sunday Lunch :\n" + PalateTailor.readWellesleyFresh("menus/bates.txt","lunch", 1)+"\n");
    System.out.println("Sunday Dinner :\n" + PalateTailor.readWellesleyFresh("menus/bates.txt","dinner", 1)+"\n");
    
    System.out.println("Monday Lunch:\n" +PalateTailor.readWellesleyFresh("menus/bates.txt","lunch", 2) +"\n");
    System.out.println("Monday Dinner:\n" +PalateTailor.readWellesleyFresh("menus/bates.txt","dinner", 2) +"\n");
    
    System.out.println("Tuesday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/bates.txt","lunch", 3) +"\n");
    System.out.println("Tuesday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/bates.txt","dinner", 3) +"\n");
    
    System.out.println("Wednesday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/bates.txt","lunch", 4) +"\n");
    System.out.println("Wednesday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/bates.txt","dinner", 4) +"\n");
    
    System.out.println("Thursday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/bates.txt","lunch", 5) +"\n");   
    System.out.println("Thursday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/bates.txt","dinner", 5) +"\n");
    
    System.out.println("Friday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/bates.txt","lunch", 6) +"\n");
    System.out.println("Friday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/bates.txt","dinner", 6) +"\n");
    
    System.out.println("Saturday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/bates.txt","lunch", 7) +"\n");
    System.out.println("Saturday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/bates.txt","dinner", 7) +"\n");
    
    
    System.out.println("Lulu Menus:");
    System.out.println("Sunday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/bplc.txt","lunch", 1)+"\n");
    System.out.println("Sunday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/bplc.txt","dinner", 1)+"\n");
    
    System.out.println("Monday Lunch:\n" +PalateTailor.readWellesleyFresh("menus/bplc.txt","lunch", 2) +"\n");
    System.out.println("Monday Dinner:\n" +PalateTailor.readWellesleyFresh("menus/bplc.txt","dinner", 2) +"\n");
    
    System.out.println("Tuesday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/bplc.txt","lunch", 3) +"\n");
    System.out.println("Tuesday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/bplc.txt","dinner", 3) +"\n");
    
    System.out.println("Wednesday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/bplc.txt","lunch", 4) +"\n");
    System.out.println("Wednesday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/bplc.txt","dinner", 4) +"\n");
    
    System.out.println("Thursday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/bplc.txt","lunch", 5) +"\n");   
    System.out.println("Thursday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/bplc.txt","dinner", 5) +"\n");
    
    System.out.println("Friday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/bplc.txt","lunch", 6) +"\n");
    System.out.println("Friday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/bplc.txt","dinner", 6) +"\n");
    
    System.out.println("Saturday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/bplc.txt","lunch", 7) +"\n");
    System.out.println("Saturday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/bplc.txt","dinner", 7) +"\n");
    
    
    System.out.println("Pom Menus:");
    System.out.println("Sunday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/pomeroy.txt","lunch", 1)+"\n");
    System.out.println("Sunday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/pomeroy.txt","dinner", 1)+"\n");
    
    System.out.println("Monday Lunch:\n" +PalateTailor.readWellesleyFresh("menus/pomeroy.txt","lunch", 2) +"\n");
    System.out.println("Monday Dinner:\n" +PalateTailor.readWellesleyFresh("menus/pomeroy.txt","dinner", 2) +"\n");
    
    System.out.println("Tuesday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/pomeroy.txt","lunch", 3) +"\n");
    System.out.println("Tuesday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/pomeroy.txt","dinner", 3) +"\n");
    
    System.out.println("Wednesday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/pomeroy.txt","lunch", 4) +"\n");
    System.out.println("Wednesday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/pomeroy.txt","dinner", 4) +"\n");
    
    System.out.println("Thursday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/pomeroy.txt","lunch", 5) +"\n");   
    System.out.println("Thursday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/pomeroy.txt","dinner", 5) +"\n");
    
    System.out.println("Friday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/pomeroy.txt","lunch", 6) +"\n");
    System.out.println("Friday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/pomeroy.txt","dinner", 6) +"\n");
    
    System.out.println("Saturday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/pomeroy.txt","lunch", 7) +"\n");
    System.out.println("Saturday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/pomeroy.txt","dinner", 7) +"\n");
    
    
    System.out.println("StoneD Menus:");
    System.out.println("Sunday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/stonedavis.txt","lunch", 1)+"\n");
    System.out.println("Sunday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/stonedavis.txt","dinner", 1)+"\n");
    
    System.out.println("Monday Lunch:\n" +PalateTailor.readWellesleyFresh("menus/stonedavis.txt","lunch", 2) +"\n");
    System.out.println("Monday Dinner:\n" +PalateTailor.readWellesleyFresh("menus/stonedavis.txt","dinner", 2) +"\n");
    
    System.out.println("Tuesday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/stonedavis.txt","lunch", 3) +"\n");
    System.out.println("Tuesday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/stonedavis.txt","dinner", 3) +"\n");
    
    System.out.println("Wednesday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/stonedavis.txt","lunch", 4) +"\n");
    System.out.println("Wednesday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/stonedavis.txt","dinner", 4) +"\n");
    
    System.out.println("Thursday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/stonedavis.txt","lunch", 5) +"\n");   
    System.out.println("Thursday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/stonedavis.txt","dinner", 5) +"\n");
    
    System.out.println("Friday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/stonedavis.txt","lunch", 6) +"\n");
    System.out.println("Friday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/stonedavis.txt","dinner", 6) +"\n");
    
    System.out.println("Saturday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/stonedavis.txt","lunch", 7) +"\n");
    System.out.println("Saturday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/stonedavis.txt","dinner", 7) +"\n");
    
    
    System.out.println("Tower Menus:");
    System.out.println("Sunday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/tower.txt","lunch", 1)+"\n");
    System.out.println("Sunday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/tower.txt","dinner", 1)+"\n");
    
    System.out.println("Monday Lunch:\n" +PalateTailor.readWellesleyFresh("menus/tower.txt","lunch", 2) +"\n");
    System.out.println("Monday Dinner:\n" +PalateTailor.readWellesleyFresh("menus/tower.txt","dinner", 2) +"\n");
    
    System.out.println("Tuesday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/tower.txt","lunch", 3) +"\n");
    System.out.println("Tuesday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/tower.txt","dinner", 3) +"\n");
    
    System.out.println("Wednesday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/tower.txt","lunch", 4) +"\n");
    System.out.println("Wednesday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/tower.txt","dinner", 4) +"\n");
    
    System.out.println("Thursday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/tower.txt","lunch", 5) +"\n");   
    System.out.println("Thursday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/tower.txt","dinner", 5) +"\n");
    
    System.out.println("Friday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/tower.txt","lunch", 6) +"\n");
    System.out.println("Friday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/tower.txt","dinner", 6) +"\n");
    
    System.out.println("Saturday Lunch:\n" + PalateTailor.readWellesleyFresh("menus/tower.txt","lunch", 7) +"\n");
    System.out.println("Saturday Dinner:\n" + PalateTailor.readWellesleyFresh("menus/tower.txt","dinner", 7) +"\n");
    
    
    
    System.out.println("Dining Hall Class testing continued...");
    System.out.println("Bates Menu Scored (tests initializeDiningHall()... which is comprised of two methods: createMenu(), and calcScore()");
    
    DiningHall bates = new DiningHall("Bates");
    bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "lunch", 1);
    System.out.println("Sunday Lunch:\n" +bates +"\n");
    bates = new DiningHall("Bates");
    bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "dinner", 1);
    System.out.println("Sunday Dinner:\n" + bates+"\n");
    
    bates = new DiningHall("Bates");
    bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "lunch", 2);
    System.out.println("Monday Lunch:\n" +bates+"\n");
    bates = new DiningHall("Bates");
    bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "dinner", 2);
    System.out.println("Monday Dinner:\n" + bates+"\n");
    
    bates = new DiningHall("Bates");
    bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "lunch", 3);
    System.out.println("Tuesday Lunch:\n" +bates+"\n");
    bates = new DiningHall("Bates");
    bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "dinner", 3);
    System.out.println("Tuesday Dinner:\n" + bates+"\n");
    
    bates = new DiningHall("Bates");
    bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "lunch", 4);
    System.out.println("Wednesday Lunch:\n" +bates+"\n");
    bates = new DiningHall("Bates");
    bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "dinner", 4);
    System.out.println("Wednesday Dinner:\n" + bates+"\n");
    
    bates = new DiningHall("Bates");
    bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "lunch", 5);
    System.out.println("Thursday Lunch:\n" +bates +"\n");
    bates = new DiningHall("Bates");
    bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "dinner", 5);
    System.out.println("Thursday Dinner:\n" + bates+"\n");
    
    bates = new DiningHall("Bates");
    bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "lunch", 6);
    System.out.println("Friday Lunch:\n" +bates+"\n");
    bates = new DiningHall("Bates");
    bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "dinner", 6);
    System.out.println("Friday Dinner:\n" + bates+"\n");
    
    bates = new DiningHall("Bates");
    bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "lunch", 7);
    System.out.println("Saturday Lunch:\n" +bates+"\n");
    bates = new DiningHall("Bates");
    bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "dinner", 7);
    System.out.println("Saturday Dinner:\n" + bates+"\n");
    
    System.out.println("Lulu Menu Scored");
    DiningHall lulu = new DiningHall("Lulu");
    lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "lunch", 1);
    System.out.println("Sunday Lunch:\n" +lulu +"\n");
    lulu = new DiningHall("Lulu");
    lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "dinner", 1);
    System.out.println("Sunday Dinner:\n" + lulu+"\n");
    
    
    lulu = new DiningHall("Lulu");
    lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "lunch", 2);
    System.out.println("Monday Lunch:\n" +lulu +"\n");
    lulu = new DiningHall("Lulu");
    lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "dinner", 2);
    System.out.println("Monday Dinner:\n" + lulu+"\n");
    
    lulu = new DiningHall("Lulu");
    lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "lunch", 3);
    System.out.println("Tuesday Lunch:\n" +lulu +"\n");
    lulu = new DiningHall("Lulu");
    lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "dinner", 3);
    System.out.println("Tuesday Dinner:\n" + lulu+"\n");
    
    lulu = new DiningHall("Lulu");
    lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "lunch", 4);
    System.out.println("Wednesday Lunch:\n" +lulu +"\n");
    lulu = new DiningHall("Lulu");
    lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "dinner", 4);
    System.out.println("Wednesday Dinner:\n" + lulu+"\n");
    
    lulu = new DiningHall("Lulu");
    lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "lunch", 5);
    System.out.println("Thursday Lunch:\n" +lulu +"\n");
    lulu = new DiningHall("Lulu");
    lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "dinner", 5);
    System.out.println("Thursday Dinner:\n" + lulu+"\n");
    
    lulu = new DiningHall("Lulu");
    lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "lunch", 4);
    System.out.println("Friday Lunch:\n" +lulu +"\n");
    lulu = new DiningHall("Lulu");
    lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "dinner", 4);
    System.out.println("Friday Dinner:\n" + lulu+"\n");
    
    lulu = new DiningHall("Lulu");
    lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "lunch", 7);
    System.out.println("Saturday Lunch:\n" +lulu +"\n");
    lulu = new DiningHall("Lulu");
    lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "dinner", 7);
    System.out.println("Saturday Dinner:\n" + lulu+"\n");
    
    
    System.out.println("Pom Menu Scored");
    DiningHall pom = new DiningHall("Pomeroy");
    pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "lunch", 1);
    System.out.println("Sunday Lunch:\n" +pom +"\n");
    pom = new DiningHall("Pomeroy");
    pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "dinner", 1);
    System.out.println("Sunday Dinner:\n" + pom +"\n");
    
    pom = new DiningHall("Pomeroy");
    pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "lunch", 2);
    System.out.println("Monday Lunch:\n" +pom +"\n");
    pom = new DiningHall("Pomeroy");
    pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "dinner", 2);
    System.out.println("Monday Dinner:\n" + pom+"\n");
    
    pom = new DiningHall("Pomeroy");
    pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "lunch", 3);
    System.out.println("Tuesday Lunch:\n" +pom +"\n");
    pom = new DiningHall("Pomeroy");
    pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "dinner", 3);
    System.out.println("Tuesday Dinner:\n" + pom+"\n");
    
    pom = new DiningHall("Pomeroy");
    pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "lunch", 4);
    System.out.println("Wednesday Lunch:\n" +pom +"\n");
    pom = new DiningHall("Pomeroy");
    pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "dinner", 4);
    System.out.println("Wednesday Dinner:\n" + pom+"\n");
    
    pom = new DiningHall("Pomeroy");
    pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "lunch", 5);
    System.out.println("Thursday Lunch:\n" +pom +"\n");
    pom = new DiningHall("Pomeroy");
    pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "dinner", 5);
    System.out.println("Thursday Dinner:\n" + pom+"\n");
    
    pom = new DiningHall("Pomeroy");
    pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "lunch", 6);
    System.out.println("Friday Lunch:\n" +pom +"\n");
    pom = new DiningHall("Pomeroy");
    pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "dinner", 6);
    System.out.println("Friday Dinner:\n" + pom+"\n");
    
    pom = new DiningHall("Pomeroy");
    pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "lunch", 7);
    System.out.println("Saturday Lunch:\n" +pom +"\n");
    pom = new DiningHall("Pomeroy");
    
    pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "dinner", 7);
    System.out.println("Saturday Dinner:\n" + pom+"\n");
    
    System.out.println("Stone Davis Menu Scored");
    DiningHall stoned = new DiningHall("Stone Davis");
    stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "lunch", 1);
    System.out.println("Sunday Lunch:\n" +stoned +"\n");
    stoned = new DiningHall("Stone Davis");
    stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "dinner", 1);
    System.out.println("Sunday Dinner:\n" + stoned +"\n");
    
    stoned = new DiningHall("Stone Davis");
    stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "lunch", 2);
    System.out.println("Monday Lunch:\n" +stoned +"\n");
    stoned = new DiningHall("Stone Davis");
    stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "dinner", 2);
    System.out.println("Monday Dinner:\n" + stoned+"\n");
    
    stoned = new DiningHall("Stone Davis");
    stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "lunch", 3);
    System.out.println("Tuesday Lunch:\n" +stoned +"\n");
    stoned = new DiningHall("Stone Davis");
    stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "dinner", 3);
    System.out.println("Tuesday Dinner:\n" + stoned+"\n");
    
    stoned = new DiningHall("Stone Davis");
    stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "lunch", 4);
    System.out.println("Wednesday Lunch:\n" +stoned +"\n");
    stoned = new DiningHall("Stone Davis");
    stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "dinner", 4);
    System.out.println("Wednesday Dinner:\n" + stoned+"\n");
    
    stoned = new DiningHall("Stone Davis");
    stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "lunch", 5);
    System.out.println("Thursday Lunch:\n" +stoned +"\n");
    stoned = new DiningHall("Stone Davis");
    stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "dinner", 5);
    System.out.println("Thursday Dinner:\n" + stoned+"\n");
    
    stoned = new DiningHall("Stone Davis");
    stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "lunch", 4);
    System.out.println("Friday Lunch:\n" +stoned +"\n");
    stoned = new DiningHall("Stone Davis");
    stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "dinner", 4);
    System.out.println("Friday Dinner:\n" + stoned+"\n");
    
    stoned = new DiningHall("Stone Davis");
    stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "lunch", 7);
    System.out.println("Saturday Lunch:\n" +stoned +"\n");
    stoned = new DiningHall("Stone Davis");
    stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "dinner", 7);
    System.out.println("Saturday Dinner:\n" + stoned+"\n");
    
    
    System.out.println("Tower Menu Scored:");
    DiningHall tower = new DiningHall("Tower");
    tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "lunch", 1);
    System.out.println("Sunday Lunch:\n" +tower +"\n");
    tower = new DiningHall("Tower");
    tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "dinner", 1);
    System.out.println("Sunday Dinner:\n" + tower +"\n");
    
    tower = new DiningHall("Tower");
    tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "lunch", 2);
    System.out.println("Monday Lunch:\n" +tower +"\n");
    tower = new DiningHall("Tower");
    tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "dinner", 2);
    System.out.println("Monday Dinner:\n" + tower+"\n");
    
    tower = new DiningHall("Tower");
    tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "lunch", 3);
    System.out.println("Tuesday Lunch:\n" +tower +"\n");
    tower = new DiningHall("Tower");
    tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "dinner", 3);
    System.out.println("Tuesday Dinner:\n" + tower+"\n");
    
    tower = new DiningHall("Tower");
    tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "lunch", 4);
    System.out.println("Wednesday Lunch:\n" +tower +"\n");
    tower = new DiningHall("Tower");
    tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "dinner", 4);
    System.out.println("Wednesday Dinner:\n" + tower+"\n");
    
    tower = new DiningHall("Tower");
    tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "lunch", 5);
    System.out.println("Thursday Lunch:\n" +tower +"\n");
    tower = new DiningHall("Tower");
    tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "dinner", 5);
    System.out.println("Thursday Dinner:\n" + tower+"\n");
    
    tower = new DiningHall("Tower");
    tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "lunch", 4);
    System.out.println("Friday Lunch:\n" +tower +"\n");
    tower = new DiningHall("Tower");
    tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "dinner", 4);
    System.out.println("Friday Dinner:\n" + tower+"\n");
    
    tower = new DiningHall("Tower");
    tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "lunch", 7);
    System.out.println("Saturday Lunch:\n" +tower +"\n");
    tower = new DiningHall("Stone Davis");
    tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "dinner", 7);
    System.out.println("Saturday Dinner:\n" + tower+"\n");
    
    
    PalateTailor selector = new PalateTailor();
    
    System.out.println("Tests PalateTailor algorithm");
    selector.initializeAll("lunch", 1);
    System.out.println("*** Top two choices should be: Lulu and Tower");
    System.out.println(selector);
    System.out.println("-------------------------------------------------------------");
    
    selector = new PalateTailor();
    selector.initializeAll("dinner", 1);
    System.out.println("*** Top two choices should be: Bates and Tower");
    System.out.println(selector);
    System.out.println("-------------------------------------------------------------");
    
    selector = new PalateTailor();
    selector.initializeAll("lunch", 2);
    System.out.println("*** Top two choices should be: Stone Davis and Lulu ");
    System.out.println(selector);
    System.out.println("-------------------------------------------------------------");
    
    selector = new PalateTailor();
    selector.initializeAll("dinner", 2);
    System.out.println("*** Top two choices should be: Tower and Lulu (Stone D is also tied)");
    System.out.println(selector);
    System.out.println("-------------------------------------------------------------");
    
    selector = new PalateTailor();
    selector.initializeAll("lunch", 3);
    System.out.println("*** Top two choices should be: Lulu and Stone Davis ");
    System.out.println(selector);
    System.out.println("-------------------------------------------------------------");
    
    selector = new PalateTailor();
    selector.initializeAll("dinner", 3);
    System.out.println("*** Top two choices should be: Pom and Lulu (Pom and Lulu are tied)");
    System.out.println(selector);
    
    selector = new PalateTailor();
    selector.initializeAll("lunch", 4);
    System.out.println("*** Top two choices should be: Lulu and Stone Davis ");
    System.out.println(selector);
    
    selector = new PalateTailor();
    selector.initializeAll("dinner", 4);
    System.out.println("*** Top two choices should be: Lulu and Tower (tied with Pom and Bates)");
    System.out.println(selector);
    System.out.println("-------------------------------------------------------------");
    
    selector = new PalateTailor();
    selector.initializeAll("lunch", 5);
    System.out.println("*** Top two choices should be: Bates and Lulu ");
    System.out.println(selector);
    System.out.println("-------------------------------------------------------------");
    
    selector = new PalateTailor();
    selector.initializeAll("dinner", 5);
    System.out.println("*** Top two choices should be: Tower and Lulu (tied with Pom and Bates)");
    System.out.println(selector);
    System.out.println("-------------------------------------------------------------");
    
    selector = new PalateTailor();
    selector.initializeAll("lunch", 6);
    System.out.println("*** Top two choices should be: Bates and Pom (also tied with Stone Davis)");
    System.out.println(selector);
    System.out.println("-------------------------------------------------------------");
    
    selector = new PalateTailor();
    selector.initializeAll("dinner", 6);
    System.out.println("*** Top two choices should be: Bates and Tower (tie)");
    System.out.println(selector);
    System.out.println("-------------------------------------------------------------");
    
    selector = new PalateTailor();
    selector.initializeAll("lunch", 7);
    System.out.println("*** Top two choices should be: Tower and Lulu");
    System.out.println(selector);
    System.out.println("-------------------------------------------------------------");
    
    selector = new PalateTailor();
    selector.initializeAll("dinner", 7);
    System.out.println("*** Top two choices should be: Pom and Tower");
    System.out.println(selector);
    System.out.println("-------------------------------------------------------------");
  }
  
  
  
}
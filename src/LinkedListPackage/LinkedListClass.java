package LinkedListPackage;
/*
 * Sorted List Program
 * CPT 307: Data Structures & Algorithms
 * Professor: Joshua Reichard
 * Week 3 - Assignment
 * 
 * Original Release - Steven On 20191001
 * 
 * References: 
 * http://www.tutorialspoint.com/java/java_linkedlist_class.htm
 * 
 * */

import java.util.LinkedList;
import java.util.Random;

public class LinkedListClass {
	
	public static LinkedList<TheWalkingDead> TWD;
	
	public static void main(String[] args) {
		System.out.println("Hello Linked Lists!");
		
		//Creating Linked List object
		TWD = new LinkedList<TheWalkingDead>();
		
		//Adding TWD members
		TWD.add(new TheWalkingDead("Rick", "45 Hand Cannon", "Machete"));
		TWD.add(new TheWalkingDead("Carl", "9mm", "Hunting Knife"));
		TWD.add(new TheWalkingDead("Carol", "30-6 Hunting Rifle", "Pocket Knife"));
		TWD.add(new TheWalkingDead("Mishonne", "Samarai Sword", null));
		TWD.add(new TheWalkingDead("Maggie", "9mm", "Knuckle Dagger"));
		
		//print members
		printMembers("Status");
		
		//Added new member
		System.out.println();
		System.out.println("Daryl joined the party");
		TWD.add(2, new TheWalkingDead("Daryl", "Crossbow", "Hunting Knife"));
		
		//print members
		printMembers("Status");
		
		//Remove a member
		System.out.println();
		System.out.println(TWD.get(4).Name + " left the party.");
		TWD.remove(4);
		printMembers("Status");
		
		//Item Found
		System.out.println();
		System.out.println("Rick finds a rope that could be useful later");
		TWD.get(0).Backpack.add(new Item("Rope","1\" thick rope",1));
		printMembers("Inventory");
	}
	
	public static void printMembers(String detail){
		switch(detail) {
			case "Inventory":
				System.out.println();
				System.out.println("TWD Inventory: ");
				//Loop through each member and show contents
				for(int i=0;i<TWD.size();i++) {
					System.out.println(" " + TWD.get(i).Name + "'s Backpack Inventory: " + TWD.get(i).Backpack.size());
					if(TWD.get(i).Backpack.size() > 0) {
						for(int j=0;j<TWD.get(i).Backpack.size();j++) {
							System.out.println("	" + TWD.get(i).Backpack.get(j).Name 
									+ " | " + TWD.get(i).Backpack.get(j).Description + " | Qty: " + TWD.get(i).Backpack.get(j).Count);
							System.out.println();
						}
					}
				}
				break;
			case "Status":
				System.out.println();
				System.out.println("Group Count: " + TWD.size() + " TWD Status: ");
				//Loop through each member and show contents				
				for(int i=0;i<TWD.size();i++) {
					System.out.println((TWD.get(i).Name));
					System.out.println(("	Courage: " + TWD.get(i).Courage));
					System.out.println(("	Strength: " + TWD.get(i).Strength));
					System.out.println(("	Accuracy: " + TWD.get(i).Accuracy));
					System.out.println(("	Stamina: " + TWD.get(i).Stamina));
					System.out.println(("	Health: " + TWD.get(i).Health));
					System.out.println(("	Alive: " + TWD.get(i).Alive));
				}				
				break;
		}
	}
	
	public static class TheWalkingDead{
		public String Name;
		public String Primary;
		public String Secondary;
		public String Courage;
		public int Strength;
		public int Accuracy;
		public int Stamina;
		public int Health;
		public Boolean Alive;
		public LinkedList<Item> Backpack = new LinkedList<Item>();
		
		public TheWalkingDead(String name, String primary, String secondary) {
			Name = name;
			Primary = primary;
			Secondary = secondary;
			Courage = assignRandomCourage();
			Alive = (Courage == "DEAD") ? false : true;
			Strength = (Courage == "DEAD") ? 0 : assignRandomNumber(100);
			Accuracy = (Courage == "DEAD") ? 0 : assignRandomNumber(100);
			Stamina = (Courage == "DEAD") ? 0 : assignRandomNumber(100);
			Health = (Courage == "DEAD") ? 0 : assignRandomNumber(2000);			
		}
	}
	
	public static int assignRandomNumber(int range) {
		//Using Java's random library
		Random rand = new Random();
		return rand.nextInt(range);
	}
	
	public static String assignRandomCourage() {
		String courage = null; 
		Random rand = new Random();
		
		switch(rand.nextInt(5)) {
			case 0:
				courage = "DEAD";
				break;
			case 1:
				courage = "WEAK"; //-20%
				break;
			case 2:
				courage = "LOW"; //-10%
				break;
			case 3:
				courage = "MID"; //0
				break;
			case 4:
				courage = "HIGH"; //15%
				break;
			case 5:
				courage = "FEARLESS"; //30%
				break;
		}
		
		return courage;
	}
	
	public static class Item{
		public String Name;
		public String Description;
		public int Count;
		
		public Item(String name, String description, int count) {
			Name = name;
			Description = description;
			Count = count;
		}
	}
	
}

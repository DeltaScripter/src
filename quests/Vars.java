package quests;

import java.util.ArrayList;

import org.powerbot.script.wrappers.Tile;



public class Vars {


	public enum TeleportLode{
		
		VARROCK(new Tile(3214,3378,0)),FALADOR(new Tile(2965,3402, 0)), LUMMBRIDGE(new Tile(3200,3231, 0)),
		BURTHORPE(new Tile(2899,3543, 0)),CATHERBY(new Tile(2831,3451,0)),PORTSARIM(new Tile(3011,3217,0)),
		DRAYNOR(new Tile(3107,3298,0)),ARDOUGNE(new Tile(2634,3348,0)), YANILLE(new Tile(2530,3095,0)),
		SEERS( new Tile(2689,3482,0)),TAVERLY(new Tile(2877,3441,0));
		Tile tile;
		TeleportLode(Tile tile){
			this.tile = tile;
		}
		public Tile getTile(){
			return tile;
		}
	}
	public enum TeleportType{
		ARDOUGNE(41,"Ardougne"),BURTHHORPE(42,"Burthorpe"),CATHERBY(43,"Catherby"),DRAYNOR(44,"Draynor"),
		FALADOR(46,"Falador"),LUMBRIDGE(47,"Lumbridge"),PORTSARIM(48,"Port Sarim"),
		SEERS(49,"Seers"),TAVERLY(50,"Taverly"),VARROCK(51,"Varrock"),YANILLE(52,"Yanille");
		int type;
		String name;
		int numMatch[] = {40,41,42,43,44,45,46,47,48,49,50,51,52,53};
		
		TeleportType(int type, String name){
			this.type = type;
			this.name = name;
		}
		 public int getTeleport(){
			 return type;
		 }
		 public String getName(){
			 return name;
		 }
		
	}
	
	public static ArrayList<Integer> bankItems = new ArrayList<Integer>();
	public static final int[] CHATWIDGETS = {1191,1184,1188};
	public  final int OPTIONVALUE[] = {11,19,24,29,34};
	public boolean DYNAMICV = false;
	public boolean DYNAMICV2 = false;
	public boolean DYNAMICV3 = false;
	public boolean DYNAMICV4 = false;
	
	public static boolean ranOnce = false;
	
	public static boolean useBank;
	public boolean hasFood;
	public int bankDecide;
	
	//Wolf Whsitle
	public  boolean hasBeenInMS1 = false;
	public  boolean hasBeenPT = false;
	public  boolean enchantA = false;
	
	//Restless Ghost
	public boolean gAmuEquip = false;
	
	//Pirate's Treasure
	public boolean startJob = false;
	public boolean hasB = false;//Has bananas
	public boolean boughtWine = false;
	public boolean finishedJ = false;
	public boolean r = false;//Initialization, put on an apron
	//Clock Tower
	public boolean ratPoison = false;
	//MonksFriend
	public boolean hasBlanket = false;
	public boolean hasPaint = false;
	public boolean doneTasks = false;
	
	
	public enum foodtype {
		LOBSTER(379),SWORDFISH(373),BREAD(2309),MEAT(2142),CHICKEN(2140),
		MONKFISH(7946);
		private int food;
		private foodtype(int c){
			food = c;
		}
		public int getFood(){
			return food;
		}
	}
}

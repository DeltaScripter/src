package quests;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Timer;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Player;
import org.powerbot.script.wrappers.Tile;

import quests.Vars.TeleportLode;
import quests.Vars.TeleportType;


public class SweptAway extends Node {



	public SweptAway(MethodContext ctx) {
		super(ctx);
	}

	Tile[] pathToMaggie = new Tile[] {
			new Tile(3201,3236,0), new Tile(3199,3243,0), new Tile(3204,3247,0),
			new Tile(3205,3253,0), new Tile(3202,3259,0), new  Tile(3197,3268,0),
			new Tile(3194,3276,0), new Tile(3188,3283,0), new Tile(3177,3286,0),
			new Tile(3169,3287,0), new Tile(3158,3289,0), new Tile(3144,3293,0),
			new Tile(3131,3294,0), new Tile(3122,3297,0), new Tile(3111,3299,0),
			
			new Tile(3101,3296,0), new Tile(3095,3293,0), new Tile(3090,3290,0),
			new Tile(3085,3287,0), new Tile(3081,3283,0),new Tile(3077,3278,0),
			new Tile(3078,3268,0), new Tile(3080,3257,0), new Tile(3081,3252),
			new Tile(3087,3248,0), new Tile(3099,3247,0), new Tile(3103,3236,0),
			new Tile(3103,3227,0), new Tile(3111,3221,0), new Tile(3118,3218,0),
			new Tile(3124,3215,0),new Tile(3127,3215,0)};
	
	Tile[] pathToAggie = new Tile[] { 
			new Tile(3201,3236,0), new Tile(3199,3243,0), new Tile(3204,3247,0),
			new Tile(3205,3253,0), new Tile(3202,3259,0), new  Tile(3197,3268,0),
			new Tile(3194,3276,0), new Tile(3188,3283,0), new Tile(3177,3286,0),
			new Tile(3169,3287,0), new Tile(3158,3289,0), new Tile(3144,3293,0),
			new Tile(3131,3294,0), new Tile(3122,3297,0), new Tile(3111,3299,0),
			
			new Tile(3107, 3294, 0), new Tile(3107, 3289, 0), new Tile(3105, 3284, 0), 
			new Tile(3104, 3279, 0), new Tile(3104, 3274, 0), new Tile(3104, 3269, 0), 
			new Tile(3104, 3264, 0), new Tile(3099, 3263, 0), new Tile(3094, 3262, 0), 
			new Tile(3090, 3259, 0), new Tile(3087, 3259, 0) };
	
	public final Tile[] pathToHetty = new Tile[] {
			new Tile(3201,3236,0), new Tile(3199,3243,0), new Tile(3204,3247,0),
			new Tile(3205,3253,0), new Tile(3202,3259,0), new  Tile(3197,3268,0),
			new Tile(3194,3276,0), new Tile(3188,3283,0), new Tile(3177,3286,0),
			new Tile(3169,3287,0), new Tile(3158,3289,0), new Tile(3144,3293,0),
			new Tile(3131,3294,0), new Tile(3122,3297,0), new Tile(3111,3299,0),
			
			new Tile(3099, 3295, 0), new Tile(3094, 3293, 0), new Tile(3089, 3291, 0), 
			new Tile(3084, 3290, 0), new Tile(3080, 3287, 0), new Tile(3076, 3284, 0), 
			new Tile(3073, 3280, 0), new Tile(3069, 3277, 0), new Tile(3064, 3277, 0), 
			new Tile(3059, 3277, 0), new Tile(3054, 3277, 0), new Tile(3049, 3275, 0), 
			new Tile(3044, 3274, 0), new Tile(3039, 3273, 0), new Tile(3034, 3271, 0), 
			new Tile(3029, 3270, 0), new Tile(3024, 3269, 0), new Tile(3019, 3267, 0), 
			new Tile(3014, 3265, 0), new Tile(3010, 3262, 0), new Tile(3005, 3261, 0), 
			new Tile(3002, 3257, 0), new Tile(2997, 3256, 0), new Tile(2999, 3251, 0), 
			new Tile(3002, 3247, 0), new Tile(3005, 3243, 0), new Tile(3006, 3238, 0), 
			new Tile(3006, 3233, 0), new Tile(3006, 3228, 0), new Tile(3006, 3223, 0), 
			new Tile(3007, 3218, 0), new Tile(3010, 3214, 0), new Tile(3007, 3218, 0), 
			new Tile(3004, 3223, 0), new Tile(3003, 3228, 0), new Tile(3001, 3233, 0), 
			new Tile(3001, 3238, 0), new Tile(3001, 3243, 0), new Tile(2999, 3248, 0), 
			new Tile(2997, 3253, 0), new Tile(2992, 3255, 0), new Tile(2988, 3252, 0), 
			new Tile(2983, 3250, 0), new Tile(2978, 3250, 0), new Tile(2973, 3250, 0), 
			new Tile(2968, 3250, 0), new Tile(2963, 3249, 0), new Tile(2959, 3246, 0), 
			new Tile(2956, 3242, 0), new Tile(2955, 3237, 0), new Tile(2955, 3232, 0), 
			new Tile(2956, 3227, 0), new Tile(2958, 3222, 0), new Tile(2959, 3217, 0), 
			new Tile(2959, 3212, 0), new Tile(2961, 3207, 0), new Tile(2963, 3205, 0) };
	
	public final Tile[] pathToBetty = new Tile[] { 
			new Tile(3201,3236,0), new Tile(3199,3243,0), new Tile(3204,3247,0),
			new Tile(3205,3253,0), new Tile(3202,3259,0), new  Tile(3197,3268,0),
			new Tile(3194,3276,0), new Tile(3188,3283,0), new Tile(3177,3286,0),
			new Tile(3169,3287,0), new Tile(3158,3289,0), new Tile(3144,3293,0),
			new Tile(3131,3294,0), new Tile(3122,3297,0), new Tile(3111,3299,0),
			
			new Tile(3103, 3298, 0), 
			new Tile(3102, 3293, 0), new Tile(3105, 3289, 0), new Tile(3105, 3284, 0), 
			new Tile(3100, 3284, 0), new Tile(3095, 3283, 0), new Tile(3091, 3286, 0), 
			new Tile(3086, 3287, 0), new Tile(3083, 3283, 0), new Tile(3079, 3280, 0), 
			new Tile(3075, 3277, 0), new Tile(3070, 3274, 0), new Tile(3065, 3272, 0), 
			new Tile(3064, 3267, 0), new Tile(3065, 3262, 0), new Tile(3064, 3257, 0), 
			new Tile(3061, 3253, 0), new Tile(3056, 3251, 0), new Tile(3052, 3252, 0), 
			new Tile(3047, 3253, 0), new Tile(3042, 3253, 0), new Tile(3037, 3254, 0), 
			new Tile(3032, 3256, 0), new Tile(3027, 3256, 0), new Tile(3022, 3255, 0), 
			new Tile(3017, 3255, 0), new Tile(3017, 3258, 0), new Tile(3019, 3253, 0), 
			new Tile(3020, 3248, 0), new Tile(3020, 3243, 0), new Tile(3020, 3238, 0), 
			new Tile(3020, 3233, 0), new Tile(3019, 3228, 0), new Tile(3017, 3223, 0), 
			new Tile(3015, 3218, 0), new Tile(3011, 3214, 0), new Tile(3015, 3217, 0), 
			new Tile(3018, 3221, 0), new Tile(3021, 3225, 0), new Tile(3021, 3230, 0), 
			new Tile(3021, 3235, 0), new Tile(3021, 3240, 0), new Tile(3021, 3245, 0), 
			new Tile(3019, 3250, 0), new Tile(3019, 3255, 0), new Tile(3017, 3258, 0) };

	public final Area AggieArea = new Area(new Tile[] { 
			new Tile(3080, 3262, 0), new Tile(3086, 3262, 0), new Tile(3086, 3258, 0), 
			new Tile(3080, 3258, 0) });
	
	public final Area AggieDoor = new Area(new Tile[] { 
			new Tile(3084, 3260, 0), new Tile(3084, 3256, 0), new Tile(3089, 3256, 0), 
			new Tile(3089, 3260, 0) });
	
	public final Area HettyArea = new Area(new Tile[] { 
			new Tile(2964, 3208, 0), new Tile(2964, 3203, 0), new Tile(2969, 3203, 0), 
			new Tile(2969, 3208, 0) });
	
	public final Area HettyDoor = new Area(new Tile[] { 
			new Tile(2961, 3207, 0), new Tile(2961, 3204, 0), new Tile(2966, 3204, 0), 
			new Tile(2966, 3207, 0) });
	
	public final Area BettyArea = new Area(new Tile[] { 
			new Tile(3010, 3261, 0), new Tile(3010, 3256, 0), new Tile(3015, 3256, 0), 
			new Tile(3015, 3261, 0) });
	
	public final Area BettyDoor = new Area(new Tile[] { 
			new Tile(3013, 3260, 0), new Tile(3013, 3256, 0), new Tile(3019, 3256, 0), 
			new Tile(3019, 3260, 0) });
	//--------------------------------
	public boolean hasLabel = false;//Crates
	public boolean ready =false;//
	public boolean hasNewt = false;
	public boolean hasOintment = false;
	public boolean hasWand = false;
	public Timer triTimer = new Timer(0);//Triangle sweeping puzzle
	public Timer wait = new Timer(0);
	Method Method = new Method(ctx);
	Vars Vars = new Vars();
	
	
	public int bankItems[] = {14062,14057,14064,14068};
	public int bankItemAmount[] = {1,1,1,1};
	
	public void execute() {
		Method.resetTeleporting();
		Method.foodSupport();
		DeltaQuester.numSteps = 10;
		
		
		if(DeltaQuester.checkedBank && (ctx.settings.get(2198) & 0x1F) !=18)
			Method.determineBank(bankItems);
		
			if(!DeltaQuester.checkedBank){
			Method.checkBank();
		}else
	    if(Vars.useBank && (ctx.settings.get(2198) & 0x1F) !=18){
			Method.useBank(bankItems, bankItemAmount);
		}else
		if((ctx.settings.get(2198) & 0x1F) ==18){
			DeltaQuester.progress = 10;
			Method.state("The Swept Away quest has been completed.");
			Method.sleep(2000);
			DeltaQuester.e = true;
		}else
		if((ctx.settings.get(2198)>>25 & 0x7) ==5||(ctx.settings.get(2198) & 0x7) ==6||(ctx.settings.get(2198) & 0xF) ==8){
			DeltaQuester.progress = 9;
			cs1();//Speak to Maggie for the last time.
		}else
		if((ctx.settings.get(2198)>>23 & 0x1) ==1||(ctx.settings.get(2198)>>24 & 0x1) ==1||(ctx.settings.get(2198)>>25 & 0x1) ==1){
			DeltaQuester.progress = 8;
			cs6();//Bring Betty her wand after completing the puzzle
		}else
		if((ctx.settings.get(2198)>>8 & 0x7) ==6){
			DeltaQuester.progress = 7;
			cs5();//Speak to Betty about the wand
		}else
		if((ctx.settings.get(2198)>>8 & 0x7) ==4||(ctx.settings.get(2198)>>8 & 0x1) ==1){
				if(hasOintment){
					if(!Method.teleporting){
						DeltaQuester.progress = 6;
						Method.combineItems(14057, 14062);//use broom with ointment
					}
				}else if(!Method.teleporting && Method.inventoryContains(14062)){
					hasOintment = true;
				}else if(hasNewt){
					DeltaQuester.progress = 5;
					cs3();//Speak to Hetty
				}else if(!Method.teleporting &&Method.inventoryContains(14064)){
					hasNewt =true;
				}else cs4();//Gather the newt from the crate.
			
		}else
		if((ctx.settings.get(2198)>>8 & 0x1) ==1 || (ctx.settings.get(2198)>>9 & 0x1) ==1){
			DeltaQuester.progress = 4;
			cs4();//Solve the crate puzzle Hetty needed us to do.
		}else
		if((ctx.settings.get(2198)>>11 & 0x1) ==1){
			DeltaQuester.progress = 3;
			cs3();//Speak to Hetty about the broom situation
		}else
		if((ctx.settings.get(2198)&0x1F) == 20){
			DeltaQuester.progress = 2;
			cs2();//Speak to Aggie and solve her puzzle with the brooms
		}else
		if((ctx.settings.get(2198)&0xFF) == 0||(ctx.settings.get(2198)&0xFF) == 5||(ctx.settings.get(2198)&0xFF) == 10){
			DeltaQuester.progress = 1;
			cs1();//Start the quest by speaking to Maggie
		}
	}
	

private void cs6() {
	final String opt[]  ={"I need to retrieve"};
	Player local = ctx.players.local();
	
	  if(hasWand){
		  cs5();
	  }else if(!Method.teleporting && Method.inventoryContains(14068)){
		  hasWand = true;
	  }else
	if(Method.objIsNotNull(39321)){//If inside betty's basement
		if((ctx.settings.get(2198)>>25 & 0x1) ==1){
			if((ctx.settings.get(2199)>>4 & 0x1) ==1){//If finished the puzzle
				if(!Method.teleporting && Method.inventoryContains(14068)){//Betty' wand
					for(GameObject o : ctx.objects.select().id(39273).nearest().first()){
						if(o.getLocation().distanceTo(local.getLocation())<5){
							Method.interactO(39273, "Climb", "Ladder");
						}else Method.clickOnMap(new Tile(3221,4522,0));
					}
				}else for(GameObject o : ctx.objects.select().id(39443).nearest().first()){
					if(o.getLocation().distanceTo(local.getLocation())<5){
						if((ctx.settings.get(2198) >>26 & 0x7) == 5){
							Method.interactO(39443, "Search", "Chest");
						}else Method.interactO(39443, "Open", "Chest");
					}else Method.clickOnMap(new Tile(3220,4524,0));
				}
			}else //Below completes the puzzle
				for(int step = 1; step !=7;){
				if((ctx.settings.get(2199)>>4 & 0x1) ==1){
				break;
				}else{
					Method.sleep(1500);//due to lag
				if (step==1){
					if (Method.playerText("You put the blackbird")){
						step = 2;
						Method.sleep(2000);
					}else{
						doPuzzleStep(14071,39281,39314, new Tile(3231,4515,0), new Tile(3231,4521,0));
					}
				}else if(step==2){
					if (Method.playerText("You put the rat")){
						step = 3;
						Method.sleep(2000);
					}else{
						doPuzzleStep(14074,39297,39281, new Tile(3231,4506,0), new Tile(3231,4511,0));
					}
				}else if(step==3){
					if (Method.playerText("You put the spider")){
						step = 4;
						Method.sleep(2000);
					}else{
						doPuzzleStep(14073,39303,39297, new Tile(3238,4504,0), new Tile(3233,4504,0));
					}
				}else if(step==4){
					if (Method.playerText("You put the reptile")){
						step = 5;
						Method.sleep(2000);
					}else{
						doPuzzleStep(14070,39309,39303, new Tile(3240,4511,0), new Tile(3240,4506,0));
					}
				}else if (step==5){
					if (Method.playerText("You put the rat")){
						step = 6;
						Method.sleep(2000);
					}else{
						doPuzzleStep(14074,39281,39309, new Tile(3233,4513,0), new Tile(3238,4513,0));
					}
				}else if (step==6){
					if (Method.playerText("You put the blackbird")){
						step = 8;
						Method.sleep(2000);
					}else{
						doPuzzleStep(14071,39314,39281, new Tile(3231,4521,0), new Tile(3231,4515,0));
							}
						}
					}
				}
			
			
			
		}else if(!Method.findOption(opt)){
			if(!Method.isChatting("Lottie")){
				Method.speakTo(8206, "Lottie");
			}
		}
		} else if (new Tile(3015, 3258, 0).distanceTo(local.getLocation()) < 10 && BettyArea.contains(local.getLocation())) {
			if ((ctx.settings.get(2198) >> 28 & 0x1) == 1) {
				Method.interactO(39442, "Climb", "Trap door");
			} else 	Method.interactO(39442, "Open", "Trap door");
		} else cs5();// Get to Betty's shop

	}
private void cs5() {
	final String opt[]  ={"Talk to Betty about Swept"};
	Player local = ctx.players.local();
	//SceneObject bettyDoor = SceneEntities.getNearest(40108);
	
	if(Method.objIsNotNull(39321)){
		Method.interactO(39273, "Climb", "Ladder");
	}else
		if( new Tile(3017, 3258, 0).distanceTo(local.getLocation())<7){
			if(Method.isInCombat()){
				Method.basicFightNPC(175);
			}else
			if(BettyArea.contains(local.getLocation())){
				Vars.DYNAMICV = false;
				if(!Method.findOption(opt)){
					if(!Method.isChatting("Betty")){
						Method.speakTo(583, "Betty");
					}
				}
			}else if(Method.objIsNotNull(40108) && BettyDoor.contains(Method.getObject(40108).getLocation())){
				Method.interactO(40108, "Open", "Door");
			}else Method.clickOnMap( new Tile(3012,3258,0));
			
		}else if(Vars.DYNAMICV){
			if(!Method.interference())
			Method.walking(pathToBetty, "Walking to Betty", false);
		}else if(TeleportLode.LUMMBRIDGE.getTile().distanceTo(local.getLocation())<10 || TeleportLode.DRAYNOR.getTile().distanceTo(local.getLocation())<10 || TeleportLode.PORTSARIM.getTile().distanceTo(local.getLocation())<10){
			Vars.DYNAMICV = true;
		}else if(Method.isPortSarimLodeAct()){
			Method.teleportTo(TeleportType.PORTSARIM.getTeleport(),TeleportType.PORTSARIM.getName());
		}else if(Method.DraynorLodeIsActive()){
			Method.teleportTo(TeleportType.DRAYNOR.getTeleport(),TeleportType.DRAYNOR.getName());
		}else Method.teleportTo(TeleportType.LUMBRIDGE.getTeleport(),TeleportType.LUMBRIDGE.getName());
	
	}

	private void cs4() {
		final String opt[]  ={"Can you give me some","It's a deal"};
		final int crates[] = {39445,39446,39447};
		Player local = ctx.players.local();
		//SceneObject hettyDoor = SceneEntities.getNearest(72004);
		
		if(Method.objIsNotNull(39321)){
			Vars.DYNAMICV = false;
			if((ctx.settings.get(2198)>>10 & 0x1) ==1){//after placing the labels
				for(int g = 0;g< crates.length;){
					
					if(!Method.teleporting && Method.inventoryContains(14064)){
						break;
					}
					for(GameObject crate : ctx.objects.select().id(crates[g]).nearest().first()){
						if(crate.getLocation().distanceTo(local.getLocation())<3){
						System.out.println("Extractingfrom the crate");
						Method.interactO(crates[g], "Extract", "Crate : ");
						Method.sleep(3000);
						g++;
						}else {
							Method.clickOnMap(crate.getLocation());
							System.out.println("Clicking on map: " + crate.getLocation());
						}
					}
				}
			}else//Solve the puzzle
			if((ctx.settings.get(2198)>>9 & 0x1) ==1){
				if(hasLabel){
					
					if ((ctx.settings.get(2198) >> 22 & 0x1) == 1) {
						solveCrates(14067,14065,14066);
					} else if ((ctx.settings.get(2198) >> 6 & 0x3) == 3) {
						solveCrates(14066,14067,14065);
					}else {
						if(Method.objIsNotNull(39447) && Method.getObject(39447).getLocation().distanceTo(local.getLocation())<7){
						Method.interactO(39447, "Extract", "Crate");
						}else Method.clickOnMap(Method.getObject(39447).getLocation());
					}
				}else if(!Method.teleporting && Method.inventoryContains(14065) && Method.inventoryContains(14066) && Method.inventoryContains(14067)){
						hasLabel = true;
					}else if(!Method.findOption(opt)){
						if(!Method.isChatting("Gus")){
							Method.speakTo(8205, "Gus");
						}
					}
				
			}else
			if(!Method.findOption(opt)){
				if(!Method.isChatting("Gus")){
					Method.speakTo(8205, "Gus");
				}
			}
		}else if (new Tile(2967,3201,0).distanceTo(local.getLocation())<7){
			if(new Tile(2967,3201,0).distanceTo(local.getLocation())<3&& !HettyArea.contains(local.getLocation())){
				if((ctx.settings.get(2199) >>3 &0x1) ==1){
					Method.interactO(39444, "Climb", "Trapdoor");
				}else Method.interactO(39444, "Open", "Trapdoor");
				
			}else if(Method.objIsNotNull(72004) && HettyDoor.contains(Method.getObject(72004).getLocation())){
					Method.interactO(72004, "Open", "Door");
				}else Method.clickOnMap(new Tile(2968,3198,0));
			
		}else if(Vars.DYNAMICV){
			if(!Method.interference())
			Method.walking(pathToHetty, "Walking to Hetty", false);
		}else if(TeleportLode.LUMMBRIDGE.getTile().distanceTo(local.getLocation())<10 || TeleportLode.DRAYNOR.getTile().distanceTo(local.getLocation())<10 || TeleportLode.PORTSARIM.getTile().distanceTo(local.getLocation())<10){
			Vars.DYNAMICV = true;
		}else if(Method.isPortSarimLodeAct()){
			Method.teleportTo(TeleportType.PORTSARIM.getTeleport(),TeleportType.PORTSARIM.getName());
		}else if(Method.DraynorLodeIsActive()){
			Method.teleportTo(TeleportType.DRAYNOR.getTeleport(),TeleportType.DRAYNOR.getName());
		}else Method.teleportTo(TeleportType.LUMBRIDGE.getTeleport(),TeleportType.LUMBRIDGE.getName());
		
	}

	private void solveCrates(int i, int j, int k) {
		Player local  = ctx.players.local();
		//SceneObject crate1 =SceneEntities.getNearest(39445);
		//SceneObject crate2 =SceneEntities.getNearest(39446);
	//	SceneObject crate3 =SceneEntities.getNearest(39447);
		if(!Method.teleporting &&Method.inventoryContains(i)){
				for(GameObject crate1 : ctx.objects.select().id(39445).nearest().first()){
				if(crate1.getLocation().distanceTo(local.getLocation())<6){
					Method.useItemOn(i, crate1.getId(), "Crate");
				}else Method.clickOnMap(crate1.getLocation());
				}
			
		}else if(!Method.teleporting &&Method.inventoryContains(j)){
				for(GameObject crate2 : ctx.objects.select().id(39446).nearest().first()){
				if(crate2.getLocation().distanceTo(local.getLocation())<6){
					Method.useItemOn(j, crate2.getId(), "Crate");
				}else Method.clickOnMap(crate2.getLocation());
				}
		}else if(!Method.teleporting && Method.inventoryContains(k)){
				for(GameObject crate3 : ctx.objects.select().id(39447).nearest().first()){
				if(crate3.getLocation().distanceTo(local.getLocation())<6){
					Method.useItemOn(k, crate3.getId(), "Crate");
				}else Method.clickOnMap(crate3.getLocation());
				}
		}
		
	}

	private void cs3() {
		final String opt[] = {"Talk about Swept Away"};
		Player local = ctx.players.local();
		//SceneObject hettyDoor = SceneEntities.getNearest(72004);
		
		if(new Tile(2963, 3205, 0).distanceTo(local.getLocation())<7){
			System.out.println("here1");
			if(Method.npcIsNotNull(307)){
				System.out.println("here");
				if(Method.getNPC(307).getLocation().distanceTo(local.getLocation())<3){
					System.out.println("here3");
					Vars.DYNAMICV = false;
					Vars.DYNAMICV2 = true;
					if(!Method.findOption(opt)){
						if(!Method.isChatting("Hetty")){
							Method.speakTo(307, "Hetty");
						}
					}
				}else if(Method.objIsByTile(new Tile(2965,3206,0), 72004, 3)){
					System.out.println("here4");
					Method.interactO(72004, "Open", "Door");
				}else Method.clickOnMap(Method.getNPC(307).getLocation());
			}
			
		}else if(Vars.DYNAMICV){
			if(!Method.interference())
			Method.walking(pathToHetty, "Walking to Hetty", false);
		}else if(TeleportLode.LUMMBRIDGE.getTile().distanceTo(local.getLocation())<10 || TeleportLode.DRAYNOR.getTile().distanceTo(local.getLocation())<10 || TeleportLode.PORTSARIM.getTile().distanceTo(local.getLocation())<10){
			Vars.DYNAMICV = true;
		}else if(Method.isPortSarimLodeAct()){
			Method.teleportTo(TeleportType.PORTSARIM.getTeleport(),TeleportType.PORTSARIM.getName());
		}else if(Method.DraynorLodeIsActive()){
			Method.teleportTo(TeleportType.DRAYNOR.getTeleport(),TeleportType.DRAYNOR.getName());
		}else Method.teleportTo(TeleportType.LUMBRIDGE.getTeleport(),TeleportType.LUMBRIDGE.getName());
		}
		
	private void doPuzzleStep(int animal, int fCage, int sCage, Tile tile, Tile tile2) {
		Player local = ctx.players.local();
		if (!Method.teleporting && Method.inventoryContains(animal)){
			if (tile2.distanceTo(local.getLocation()) > 3){
				Method.state("Walking closer");
				Method.clickOnMap(tile2.getLocation());
			}else{
				if (!local.isInMotion()){
				Method.state("Altering animal location");
				Method.interactO(sCage, "Move",null);
				Method.sleep(2000,2400);
				}
			}
		}else{
			if (tile.distanceTo(local.getLocation()) > 5){
				Method.state("Walking to next destination");
				Method.clickOnMap(tile.getLocation());
			}else{
				if (!local.isInMotion()){
				Method.state("Altering animal location");
				Method.interactO(fCage, "Move", null);
				Method.sleep(2000,2400);
				}
			}
		}
		
	}

	private void cs2() {//Speak to Aggie
		final String opt[] = {"Yes, I","Talk about Swept"};
	    final int[] triID = {39408, 39392, 39387,39373};
	    Player local = ctx.players.local();
	  //  SceneObject aggieDoor = SceneEntities.getNearest(1239);
		
		if(Method.objIsNotNull(39396)){
		Vars.DYNAMICV = false;
			if(ready){
				for(int i = 0; i< triID.length;){
					while(triTimer.isRunning()){
						Method.state("Sleeping");
						Method.sleep(20);
					}
					if(local.getAnimation()!=-1){
						Method.state("  : " + i);
						i++;
						triTimer = new Timer(6000);
					}else {
						if(Method.objIsNotNull(triID[i])){
							if(Method.getObject(triID[i]).getLocation().distanceTo(local.getLocation())<7){
								if(Method.getObject(triID[i]).isOnScreen()){
							Method.interactO(triID[i], "Sweep", "Dust");
								}else Method.clickOnMap(Method.getObject(triID[i]).getLocation());
							}else Method.clickOnMap(Method.getObject(triID[i]).getLocation());
						}else i++;
					}
				}
			}else
			if(ctx.widgets.get(1184).isValid() && ctx.widgets.get(1184,11).getText().contains("How are you")){
				ready = true;
			}else
			if(!Method.isChatting("Aggie")){
				if(Method.npcIsNotNull(8207)){
					if(Method.getNPC(8207).getLocation().distanceTo(local.getLocation())<6){
				Method.speakTo(8207, "Aggie");
					}else Method.clickOnMap(Method.getNPC(8207).getLocation());
				}
			}
		}else
		if(new Tile(3087, 3259, 0).distanceTo(local.getLocation())<8){
			if(AggieArea.contains(local.getLocation())){
				if(!Method.findOption(opt)){
					if(!Method.isChatting("Aggie")){
						Method.speakTo(922, "Aggie");
					}
				}
			}else if(AggieDoor.contains(Method.getObject(1239).getLocation())){
				Method.interactO(1239, "Open", "Door");
			}else Method.clickOnMap(new Tile(3084,3260,0));//inside Aggie house
			
		}else if(Vars.DYNAMICV){
			Method.walking(pathToAggie, "Walking to Aggie", false);
		}else if(TeleportLode.DRAYNOR.getTile().distanceTo(local.getLocation())<10 || TeleportLode.LUMMBRIDGE.getTile().distanceTo(local.getLocation())<10){
			Vars.DYNAMICV = true;
		}else if(Method.DraynorLodeIsActive()){
			Method.teleportTo(TeleportType.DRAYNOR.getTeleport(),TeleportType.DRAYNOR.getName());
		}else Method.teleportTo(TeleportType.LUMBRIDGE.getTeleport(),TeleportType.LUMBRIDGE.getName());
	}


	private void cs1() {
		 final String opt[] = {"I've stirred the","Of course I could.","I have good news","I can do","Oo,","What do you need","So,", "Is there any"};
		 Player local = ctx.players.local();
		 if(new Tile(3127, 3212, 0).distanceTo(local.getLocation())<8){
			 if((ctx.settings.get(2198) & 0x7) ==6){
				 Method.interactO(39228, "Stir", "Cauldron");
			 }else
			 if(!Method.startQuestOpen()){
				 if (!Method.findOption(opt)){
					 Vars.DYNAMICV = false;
					 if(!Method.isChatting("Maggie")){
						 Method.speakTo(8078, "Maggie");
					 }
				 }
			 }
		 }else if(Vars.DYNAMICV){
			Method.walking(pathToMaggie, "Walking to Maggie", false); 
		 }else if(TeleportLode.LUMMBRIDGE.getTile().distanceTo(local.getLocation())<10||
				 TeleportLode.DRAYNOR.getTile().distanceTo(local.getLocation())<10){
			 Vars.DYNAMICV = true;
		 }else if(Method.DraynorLodeIsActive()){
			 Method.teleportTo(TeleportType.DRAYNOR.getTeleport(),TeleportType.DRAYNOR.getName());
		 }else Method.teleportTo(TeleportType.LUMBRIDGE.getTeleport(),TeleportType.LUMBRIDGE.getName());
	}

	public boolean activate() {
		return (DeltaQuester.scriptToStart == 5);
	}

}

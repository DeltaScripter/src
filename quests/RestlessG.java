package quests;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Npc;
import org.powerbot.script.wrappers.Tile;

import quests.Vars.TeleportLode;
import quests.Vars.TeleportType;


public class RestlessG extends Node{



	public final Tile[] to_Fath_PathFL = new Tile[] {
			new Tile(3208,3234,0),new Tile(3213,3233,0), new Tile(3219,3225,0),
			new Tile(3229,3218,0), new Tile(3233,3214,0), new Tile(3236,3210,0),
			new Tile(3242,3206,0)};


	public final Tile[] to_GhostShack = new Tile[] {
			new Tile(3208,3234,0),new Tile(3213,3233,0), new Tile(3219,3225,0),
			new Tile(3229,3218,0), new Tile(3233,3214,0), new Tile(3236,3210,0),
			new Tile(3235, 3214, 0), new Tile(3236, 3205, 0),
			new Tile(3240, 3199, 0), new Tile(3248, 3194, 0) };

	public final Tile[] to_Rock = new Tile[] { 
			new Tile(3208,3234,0),new Tile(3213,3233,0), new Tile(3219,3225,0),
			new Tile(3229,3218,0), new Tile(3233,3214,0), new Tile(3236,3210,0),
			new Tile(3232, 3221, 0), new Tile(3234, 3216, 0), new Tile(3234, 3211, 0), 
			new Tile(3234, 3206, 0), new Tile(3236, 3201, 0), new Tile(3240, 3198, 0), 
			new Tile(3243, 3194, 0), new Tile(3248, 3193, 0), new Tile(3249, 3193, 0), 
			new Tile(3244, 3194, 0), new Tile(3243, 3194, 0), new Tile(3243, 3189, 0), 
			new Tile(3241, 3184, 0), new Tile(3238, 3180, 0), new Tile(3239, 3175, 0), 
			new Tile(3239, 3170, 0), new Tile(3238, 3165, 0), new Tile(3237, 3160, 0), 
			new Tile(3236, 3155, 0), new Tile(3235, 3152, 0), new Tile(3234, 3147, 0) };

	public final Tile[] pathToLonePriest = new Tile[] { 
			new Tile(3208,3234,0),new Tile(3213,3233,0), new Tile(3219,3225,0),
			new Tile(3229,3218,0), new Tile(3233,3214,0), new Tile(3236,3210,0),
			new Tile(3232, 3221, 0), new Tile(3234, 3216, 0), new Tile(3235, 3211, 0), 
			new Tile(3238, 3209, 0), new Tile(3242, 3206, 0), new Tile(3235, 3210, 0), 
			new Tile(3236, 3205, 0), new Tile(3238, 3200, 0), new Tile(3241, 3196, 0), 
			new Tile(3243, 3191, 0), new Tile(3241, 3186, 0), new Tile(3240, 3181, 0), 
			new Tile(3239, 3176, 0), new Tile(3238, 3171, 0), new Tile(3239, 3166, 0), 
			new Tile(3239, 3161, 0), new Tile(3235, 3158, 0), new Tile(3230, 3157, 0), 
			new Tile(3225, 3157, 0), new Tile(3220, 3156, 0), new Tile(3215, 3155, 0), 
			new Tile(3210, 3155, 0), new Tile(3206, 3153, 0) };
	
	final Tile[] PathToGhostFromRock = new Tile[] { new Tile(3233, 3148, 0), new Tile(3236, 3152, 0), new Tile(3240, 3155, 0), 
			new Tile(3242, 3160, 0), new Tile(3242, 3165, 0), new Tile(3241, 3170, 0), 
			new Tile(3240, 3175, 0), new Tile(3240, 3180, 0), new Tile(3242, 3185, 0), 
			new Tile(3243, 3190, 0), new Tile(3246, 3195, 0), new Tile(3249, 3196, 0) };
	
	public final Area swampInsideHut = new Area(
			new Tile[] { new Tile(3202, 3151, 0), new Tile(3210, 3151, 0), new Tile(3210, 3146, 0), 
					new Tile(3201, 3146, 0) });
	
	public final int bankItems[] = {553,552};
	public final int bankItemAmount[] = {1,1};
	public Vars Vars = new Vars();
	public Method Method = new Method(ctx);
	
	public RestlessG(MethodContext ctx) {
		super(ctx);
	}

	public void execute() {
		Method.resetTeleporting();
		
		DeltaQuester.numSteps = 6;
		Method.foodSupport();
		
		
		if(DeltaQuester.checkedBank &&(ctx.settings.get(2324)&0x7) !=5)
			Method.determineBank(bankItems);
		
			if(!DeltaQuester.checkedBank && (ctx.settings.get(2324)&0x7) !=5){
			Method.checkBank();
		}else
	    if(Vars.useBank && (ctx.settings.get(2324)&0x7) !=5){
			Method.useBank(bankItems, bankItemAmount);
		}else
		if((ctx.settings.get(2324)&0x7) ==5){
			DeltaQuester.progress = 6;
			Method.state("The Restless Ghost quest has been completed.");
			Method.sleep(2000);
			DeltaQuester.e = true;
			Thread.currentThread().interrupt();
		}else
		if((ctx.settings.get(2324)&0x7) ==4){
			DeltaQuester.progress = 5;
			cs4();//go back to the ghost and place the skull in his grave
		}else
		if((ctx.settings.get(2324)&0x3) ==3){
			DeltaQuester.progress = 4;
			cs3();//Take the skull from the rock
		}else
		if((ctx.settings.get(2324)&0x3) ==2){
			DeltaQuester.progress = 3;
			cs2();//Speak to the ghost
		}else
		if((ctx.settings.get(2324)&0x1) ==1){
			DeltaQuester.progress =2;
			cs1();//Speak to the crazy priest in the swamp.
		}else
		if((ctx.settings.get(2324)&0x1) ==0){
			DeltaQuester.progress = 1;
			cs0();//Start the quest
		}
	}


	private void cs4() {
		Method m = new Method(ctx);
		if(new Tile(3248,3193,0).distanceTo(ctx.players.local().getLocation())<5){
			if(!ctx.objects.select().nearest().id(15061).first().isEmpty()){
				m.useItemOn(553, 15061, "Skull");
			}else m.interactO(2145, "Open", "Coffin");
		}else cs2();//get to the ghost
		
	}

	private void cs3() {//Take the skull from the rock
		Method m = new Method(ctx);
		if(new Tile(3236,3147,0).distanceTo(ctx.players.local().getLocation())<7){
			Vars.DYNAMICV = false;
			Vars.DYNAMICV2 = true;
			m.interactO(47713, "Search", "Rock");
		}else if(Vars.DYNAMICV){
			m.walking(to_Rock, "Walking to ghost remains", false);
		}else if(TeleportLode.LUMMBRIDGE.getTile().distanceTo(ctx.players.local().getLocation())<10){
			Vars.DYNAMICV = true;
		}else m.teleportTo(TeleportType.LUMBRIDGE.getTeleport(),TeleportType.LUMBRIDGE.getName());
		
	}
	private void cs2() {//Speak to the ghost initially
		
		Method m = new Method(ctx);
		String opt[] = {"Yep."};
		if(Vars.gAmuEquip){
			if(new Tile(3248,3193,0).distanceTo(ctx.players.local().getLocation())<5){
				Vars.DYNAMICV = false;
				for(Npc n : ctx.npcs.select().nearest().id(457).first()){
					if(!m.findOption(opt))
						if(!m.isChatting("Ghost")){
							m.speakTo(n.getId(), "Ghost");
							break;
						}
				}
				if(!ctx.players.local().isInMotion()){
					m.interactO(2145, "Open", "Coffin");
				}
				
				
			}else if(Vars.DYNAMICV2){
				m.walking(PathToGhostFromRock, "Walking back to ghost", false);
			}else if(Vars.DYNAMICV){
				m.walking(to_GhostShack, "Walking to the ghost", false);
			}else if(TeleportLode.LUMMBRIDGE.getTile().distanceTo(ctx.players.local().getLocation())<10){
				Vars.DYNAMICV = true;
			}else m.teleportTo(TeleportType.LUMBRIDGE.getTeleport(),TeleportType.LUMBRIDGE.getName());
			
		} else if(m.EquipmentContains(552)){
			Vars.gAmuEquip = true;
			Method.state("Found item in equipment" + Vars.gAmuEquip);
		}else if(m.inventoryContains(552)){
					m.interactInventory(552, "Wear", "Ghostspeak Amulet");
		}
	}
	private void cs1() {//Speak to the crazy priest
		
		Method Method = new Method(ctx);
		final String opt[] = {"A ghost","sent me to talk"};
		if(new Tile(3206, 3153, 0).distanceTo(ctx.players.local().getLocation())<6){
			if(swampInsideHut.contains(ctx.players.local().getLocation())){
				Vars.DYNAMICV = false;
				if(!Method.findOption(opt))
					if(!Method.isChatting("Aereck")){
						Method.speakTo(458, "Aereck");
					}
			}else if(Method.objIsByTile(new Tile(3207,3152,0),45539, 5)){
				Method.interactO(45539, "Open", "Door");
			}else ctx.movement.newTilePath(new Tile(3206,3149,0)).traverse();
		}else if(Vars.DYNAMICV){
			Method.walking(pathToLonePriest, "Walking to the swamp priest", false);
		}else if(TeleportLode.LUMMBRIDGE.getTile().distanceTo(ctx.players.local().getLocation())<10){
			Vars.DYNAMICV = true;
		}else Method.teleportTo(TeleportType.LUMBRIDGE.getTeleport(),TeleportType.LUMBRIDGE.getName());
	}
		
	private void cs0() {//Speaks to the first priest
		final String opt[] = {"I'm looking for"};
		Method Method = new Method(ctx);
		
		if(new Tile(3243,3205,0).distanceTo(ctx.players.local().getLocation())<5){
			Vars.DYNAMICV = false;
			if(!Method.startQuestOpen())
			if(!Method.findOption(opt))
			if(!Method.isChatting("Aereck")){
				Method.speakTo(456, "Aereck");
			}
		}else if(Vars.DYNAMICV){
			Method.walking(to_Fath_PathFL, "Walking to Aereck", false);
		}else if(TeleportLode.LUMMBRIDGE.getTile().distanceTo(ctx.players.local().getLocation())<10){
			Vars.DYNAMICV = true;
		}else Method.teleportTo(TeleportType.LUMBRIDGE.getTeleport(),TeleportType.LUMBRIDGE.getName());
		
		
	}

	public boolean activate() {
		return (DeltaQuester.scriptToStart == 1);
	}





}
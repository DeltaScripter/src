package quests;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Npc;
import org.powerbot.script.wrappers.Tile;

import quests.Vars.TeleportLode;
import quests.Vars.TeleportType;

public class WolfWhistle extends Node{



	public final int RAREITEMS_ID = 23069;
	public final int WHITEHAIRMEAT_ID = 23067;
	public final int ANCIENTWOLFAMULET_ID = 23066;
	public final int EMBRIOEDPOUCH_ID = 23068;
	public final int RARESUMMONINGITEMS_ID = 23069;
	public final int PIKKUPSTIX_ID = 6988;
	public final int GIANTWOLFPOUCH_ID = 23070;
	public final int SCALECTRIX_ID = 15055;
	public final int STIXSTAIRSBOTTOM_ID = 66637;
	public final int STIXSTAIRSTOP_ID = 66638;
	public final int CLUTTEREDDRAWERS_ID = 28641;
	public final int PETSHOPOWNER_ID = 6893;
	public final int DEADBODY_ID = 67488;
	public final int OBELISK_ID = 67036;
	public final int WOLFPOUCH_ID = 23070;
	



	public final Area bonesArea = new Area(new Tile[] {
			new Tile(2847, 3475, 0), new Tile(2860, 3475, 0),
			new Tile(2860, 3483, 0), new Tile(2845, 3483, 0) });

	public final Tile[] pathToPetFT = new Tile[] { new Tile(2899, 3544, 0),
			new Tile(2899, 3536, 0), new Tile(2899, 3524, 0),
			new Tile(2898, 3514, 0), new Tile(2896, 3508, 0),
			new Tile(2892, 3500, 0), new Tile(2892, 3494, 0),
			new Tile(2893, 3484, 0), new Tile(2893, 3477, 0),
			new Tile(2894, 3468, 0), new Tile(2894, 3463, 0),
			new Tile(2888, 3452, 0), new Tile(2881, 3444, 0),
			new Tile(2883, 3436, 0), new Tile(2882, 3430, 0),
			new Tile(2886, 3417, 0), new Tile(2895, 3415, 0),
			new Tile(2907, 3417, 0), new Tile(2913, 3423, 0),
			new Tile(2920, 3425, 0), new Tile(2922, 3431, 0),
			new Tile(2931, 3433, 0) };

	public final Tile[] pathToBonesFPS = new Tile[] {
			new Tile(2932, 3433, 0), new Tile(2923, 3432, 0),
			new Tile(2920, 3425, 0), new Tile(2913, 3422, 0),
			new Tile(2907, 3417, 0), new Tile(2894, 3416, 0),
			new Tile(2887, 3418, 0), new Tile(2880, 3423, 0),
			new Tile(2871, 3433, 0), new Tile(2866, 3440, 0),
			new Tile(2863, 3445, 0), new Tile(2864, 3450, 0),
			new Tile(2864, 3455, 0), new Tile(2859, 3462, 0),
			new Tile(2856, 3467, 0), new Tile(2853, 3472, 0),
			new Tile(2853, 3479, 0) };

	public final Tile[] pathToBonesFTA = new Tile[] {
			new Tile(2899, 3532, 0), new Tile(2898, 3523, 0),
			new Tile(2898, 3515, 0), new Tile(2896, 3507, 0),
			new Tile(2891, 3499, 0), new Tile(2892, 3490, 0),
			new Tile(2891, 3479, 0), new Tile(2893, 3467, 0),
			new Tile(2892, 3460, 0), new Tile(2886, 3452, 0),
			new Tile(2882, 3440, 0), new Tile(2883, 3431, 0),
			new Tile(2872, 3436, 0), new Tile(2866, 3439, 0),
			new Tile(2864, 3445, 0), new Tile(2865, 3452, 0),
			new Tile(2863, 3458, 0), new Tile(2858, 3465, 0),
			new Tile(2855, 3470, 0), new Tile(2852, 3477, 0) };
	

	public final Tile[] pathToMrStix = new Tile[] {
			new Tile(2899, 3544, 0), new Tile(2899, 3536, 0),
			new Tile(2899, 3524, 0), new Tile(2898, 3514, 0),
			new Tile(2896, 3508, 0), new Tile(2892, 3500, 0),
			new Tile(2892, 3494, 0), new Tile(2893, 3484, 0),
			new Tile(2893, 3477, 0), new Tile(2894, 3468, 0),
			new Tile(2894, 3463, 0), new Tile(2888, 3452, 0),
			new Tile(2881, 3444, 0), new Tile(2883, 3436, 0),
			new Tile(2882, 3430, 0), new Tile(2886, 3417, 0),
			new Tile(2895, 3415, 0), new Tile(2907, 3417, 0),
			new Tile(2913, 3423, 0), new Tile(2922, 3435, 0),
			new Tile(2923, 3446, 0), new Tile(2929, 3449, 0) };

	public final Tile[] pathToPetShopFMS = new Tile[] {
			new Tile(2927, 3448, 0), new Tile(2923,3438, 0),
			new Tile(2932, 3433, 0) };

	
	public int bankItems[] = {23069,23067, 23066,23068, 23069,23070,};
	public int bankItemAmount[] = {1,1,1,1,1,1};
	Vars Vars = new Vars();
	Method Method = new Method(ctx);
	
	public WolfWhistle(MethodContext ctx) {
		super(ctx);
	}
	public void execute() {
			Method.foodSupport();
			DeltaQuester.numSteps = 12;
			failsafe();
			
			if(DeltaQuester.checkedBank && (ctx.settings.get(2506)&0x3F)!=35)
				Method.determineBank(bankItems);
			
			if(!DeltaQuester.checkedBank && (ctx.settings.get(2506)&0x3F)!=35){
				Method.checkBank();
			}else
		    if(Vars.useBank && (ctx.settings.get(2506)&0x3F)!=35){
				Method.useBank(bankItems, bankItemAmount);
			}else
			if((ctx.settings.get(2506)&0x3F)==35){
				DeltaQuester.progress = 12;
				Method.state("The Wolf Whistle quest has been completed.");
				Method.sleep(2000);
				DeltaQuester.e = true;
			}else
			if((ctx.settings.get(2506)&0x1F)==30){
				DeltaQuester.progress = 11;
				cs11();
			}else
			if((ctx.settings.get(2506)&0x1F)==25){
				DeltaQuester.progress = 10;
				cs10();
			}else
			if((ctx.settings.get(2506)&0x1F)==20){
				DeltaQuester.progress = 9;
				cs9();
			}else
			if((ctx.settings.get(2506)>>12&0x1)==1){
				DeltaQuester.progress = 8;
				cs8();
			}else
			if((ctx.settings.get(2506)>>8&0x1)==1){
				DeltaQuester.progress = 7;
				cs7();
			}else
			if((ctx.settings.get(2506)>>9&0x1)==1){
				DeltaQuester.progress = 6;
				cs6();
			}else
			if((ctx.settings.get(2506)>>10&0x1)==1){
				DeltaQuester.progress = 5;
				cs5();
			}else
			if((ctx.settings.get(2506)&0xF)==15){
				DeltaQuester.progress = 4;
				cs4();
			}else
			if((ctx.settings.get(2506)&0xF)==10){
				DeltaQuester.progress = 3;
				cs3();
			}else
			if((ctx.settings.get(2506)&0x7)==5){
				DeltaQuester.progress = 2;
				cs2();
			}else
			if(ctx.settings.get(2506)>>15==1 || ctx.settings.get(2506)==0){
				DeltaQuester.progress = 1;
				cs1();
			}
	}

	private void failsafe() {
		while(ctx.widgets.get(1370,31).isVisible()){//If the obelisk infusing area is selected.(pop-up screen appears)
			Method.state("Closing interface");
			Method.clickOnMap(ctx.players.local().getLocation());
		}
	}
	private void cs11() {
		Method Method = new Method(ctx);
		if(ctx.settings.get(1114)==1){
			Method.isChatting("People");
		}else
		if (new Tile(2881,3430,0).distanceTo(ctx.players.local().getLocation())<6) {//Mrs stix region.
			Vars.DYNAMICV = false;
			if (!Method.isChatting("Scaletrix")) {
				if(ctx.settings.get(1241)!=1)
				Method.speakTo(15055, "Scaletrix");
			}
		} else if (Vars.DYNAMICV) {
			Method.walking(pathToMrStix,"Walking to Scaletrix.",false);
		} else if(TeleportLode.BURTHORPE.getTile().distanceTo(ctx.players.local().getLocation())<6||
				TeleportLode.TAVERLY.getTile().distanceTo(ctx.players.local().getLocation())<6){
			Vars.DYNAMICV=true;
		}else if(Method.TaverlyLodeAct()){
			Method.teleportTo(TeleportType.TAVERLY.getTeleport(),TeleportType.TAVERLY.getName());
		}else Method.teleportTo(TeleportType.BURTHHORPE.getTeleport(),TeleportType.BURTHHORPE.getName());
	}

	private void cs10() {
		Method Method = new Method(ctx);
		final String opt[] = {"I need to ask","I made the giant"};
		if (new Tile(2932,3446,0).distanceTo(ctx.players.local().getLocation())<6) {
			Vars.DYNAMICV = false;
			if(!Method.findOption(opt))
				if (!Method.isChatting("Pikkupstix")) {
					Method.speakTo(6988, "Pikkupstix");
				}
			
		} else if(Vars.DYNAMICV){
			Method.walking(pathToMrStix,"Walking to Pikkupstix",false);
		}else if(TeleportLode.BURTHORPE.getTile().distanceTo(ctx.players.local().getLocation())<6||
				TeleportLode.TAVERLY.getTile().distanceTo(ctx.players.local().getLocation())<6){
			Vars.DYNAMICV=true;
		}else if(Method.TaverlyLodeAct()){
			Method.teleportTo(TeleportType.TAVERLY.getTeleport(),TeleportType.TAVERLY.getName());
		}else Method.teleportTo(TeleportType.BURTHHORPE.getTeleport(),TeleportType.BURTHHORPE.getName());
	
	}

	private void cs9() {
		Method Method = new Method(ctx);
		
		if (new Tile(2932,3446,0).distanceTo(ctx.players.local().getLocation())<6) {
				Method.state("Seraching for item in inventory");
				if(Method.inventoryContains(RAREITEMS_ID)){
					if(ctx.backpack.isItemSelected()){
						Method.interactO(OBELISK_ID, "Use","Obelisk");
					}else Method.interactInventory(RAREITEMS_ID, "Use", "Rare items");
					
				}
			
		} else if(Vars.DYNAMICV){
			Method.walking(pathToMrStix,"Walking to Pikkupstix.",false);
		}else if(TeleportLode.BURTHORPE.getTile().distanceTo(ctx.players.local().getLocation())<6||
				TeleportLode.TAVERLY.getTile().distanceTo(ctx.players.local().getLocation())<6){
			Vars.DYNAMICV=true;
		}else if(Method.TaverlyLodeAct()){
			Method.teleportTo(TeleportType.TAVERLY.getTeleport(),TeleportType.TAVERLY.getName());
		}else Method.teleportTo(TeleportType.BURTHHORPE.getTeleport(),TeleportType.BURTHHORPE.getName());
	
		
	}

	private void cs8() {
		Method Method = new Method(ctx);
		final String opt[] = {"I need to ask"};
		if (new Tile(2932,3446,0).distanceTo(ctx.players.local().getLocation())<6) {//stix region.
				Vars.DYNAMICV = false;
				for(Npc stix : ctx.npcs.select().id(6988).nearest().first()){
					if(stix.getAnimation()!=15924){
						if(!Method.findOption(opt))
							if (!Method.isChatting("Pikkupstix")) {
								Method.state("Temp-sleep");
								Method.sleep(4000);
								Method.speakTo(6988, "Pikkupstix");
								break;
							}
					}
				}
		} else if(Vars.DYNAMICV){
			Method.walking(pathToMrStix,"Walking to Pikkupstix",false);
		}else if(TeleportLode.BURTHORPE.getTile().distanceTo(ctx.players.local().getLocation())<6||
				TeleportLode.TAVERLY.getTile().distanceTo(ctx.players.local().getLocation())<6){
			Vars.DYNAMICV=true;
		}else if(Method.TaverlyLodeAct()){
			Method.teleportTo(TeleportType.TAVERLY.getTeleport(),TeleportType.TAVERLY.getName());
		}else Method.teleportTo(TeleportType.BURTHHORPE.getTeleport(),TeleportType.BURTHHORPE.getName());
	}

	private void cs7() {
		final String opt[] = {"I need to ask"};
		
		if (new Tile(2932,3446,0).distanceTo(ctx.players.local().getLocation())<6) {//stix region.
			
			Vars.DYNAMICV = false;
			if(!Method.findOption(opt))
				if (!Method.isChatting("Pikkupstix")) {
					Method.speakTo(6988, "Pikkupstix");
				}
			
		} else if(Vars.DYNAMICV){
			Method.walking(pathToMrStix,"Walking to Pikkupstix",false);
		}else if(TeleportLode.BURTHORPE.getTile().distanceTo(ctx.players.local().getLocation())<6||
				TeleportLode.TAVERLY.getTile().distanceTo(ctx.players.local().getLocation())<6){
			Vars.DYNAMICV=true;
		}else if(Method.TaverlyLodeAct()){
			Method.teleportTo(TeleportType.TAVERLY.getTeleport(),TeleportType.TAVERLY.getName());
		}else Method.teleportTo(TeleportType.BURTHHORPE.getTeleport(),TeleportType.BURTHHORPE.getName());
		
	}

	private void cs6() {
		Method Method = new Method(ctx);
		if (bonesArea.contains(ctx.players.local().getLocation())) {
			Vars.DYNAMICV = false;
			Method.interactO(DEADBODY_ID, "Search","Body");
		} else {
			if (Vars.hasBeenPT) {
				Method.walking(pathToBonesFPS,"Walking to bones location.",false);
			} else {
				if (new Tile(2931,3434,0).distanceTo(ctx.players.local().getLocation())<6) {
					Vars.hasBeenPT = true;
				} else if(Vars.DYNAMICV){
					Method.walking(pathToBonesFTA,"Walking to bones location.",false);
				}else if(TeleportLode.BURTHORPE.getTile().distanceTo(ctx.players.local().getLocation())<6||
						TeleportLode.TAVERLY.getTile().distanceTo(ctx.players.local().getLocation())<6){
					Vars.DYNAMICV=true;
				}else if(Method.TaverlyLodeAct()){
					Method.teleportTo(TeleportType.TAVERLY.getTeleport(),TeleportType.TAVERLY.getName());
				}else Method.teleportTo(TeleportType.BURTHHORPE.getTeleport(),TeleportType.BURTHHORPE.getName());
			}
		}
		
	}

	private void cs5() {
		Method Method = new Method(ctx);
		final String opt[] = {"hare meat."};
		
		if (new Tile(2931,3434,0).distanceTo(ctx.players.local().getLocation())<6) {
			Vars.hasBeenInMS1 = false;
			Vars.DYNAMICV = false;
			if(!Method.findOption(opt))
				if (!Method.isChatting("Pet shop owner")) {
					Method.speakTo(6893, "Pet shop owner");
				}
			
			
		} else {
			if (Vars.hasBeenInMS1) {
				if (ctx.game.getPlane()==1) {
					Method.interactO(STIXSTAIRSTOP_ID, "Climb","Stairs");
				}else 
				Method.walking(pathToPetShopFMS,"Walking to the pet shop.",false);
			} else {
				if (new Tile(2929,3447,0).distanceTo(ctx.players.local().getLocation())<6  && ctx.game.getPlane()==0) {
					Vars.hasBeenInMS1 = true;
				} else {
					if (ctx.game.getPlane()==1) {
						Method.interactO(STIXSTAIRSTOP_ID, "Climb","Stairs");
					} else if(Vars.DYNAMICV){
						Method.walking(pathToPetFT,"Walking to the pet shop.",false);
					}else if(TeleportLode.BURTHORPE.getTile().distanceTo(ctx.players.local().getLocation())<6||
							TeleportLode.TAVERLY.getTile().distanceTo(ctx.players.local().getLocation())<6){
						Vars.DYNAMICV=true;
					}else if(Method.TaverlyLodeAct()){
						Method.teleportTo(TeleportType.TAVERLY.getTeleport(),TeleportType.TAVERLY.getName());
					}else Method.teleportTo(TeleportType.BURTHHORPE.getTeleport(),TeleportType.BURTHHORPE.getName());
				}
			}
		}
		
	}

	private void cs4() {
		Method Method = new Method(ctx);
		if (ctx.game.getPlane()==1) {
				Method.interactO(CLUTTEREDDRAWERS_ID, "Search","Drawer");
		} else {
			if (new Tile(2928,3448,0).distanceTo(ctx.players.local().getLocation())<5) {
				Method.interactO(STIXSTAIRSBOTTOM_ID, "Climb","Climbing device");
			} else if(Vars.DYNAMICV){
				Method.walking(pathToMrStix,"Walking to Pikkupstix",false);
			}else if(TeleportLode.BURTHORPE.getTile().distanceTo(ctx.players.local().getLocation())<6||
					TeleportLode.TAVERLY.getTile().distanceTo(ctx.players.local().getLocation())<6){
				Vars.DYNAMICV=true;
			}else if(Method.TaverlyLodeAct()){
				Method.teleportTo(TeleportType.TAVERLY.getTeleport(),TeleportType.TAVERLY.getName());
			}else Method.teleportTo(TeleportType.BURTHHORPE.getTeleport(),TeleportType.BURTHHORPE.getName());
		}

	}

	private void cs3() {
		Method Method = new Method(ctx);
		final String opt[] = {"has been kidnapped"};
		
		if (new Tile(2932,3446,0).distanceTo(ctx.players.local().getLocation())<6) {//stix region.
			Vars.DYNAMICV = false;
			if(!Method.findOption(opt))
			if(ctx.widgets.get(1243).isValid()){
				ctx.widgets.get(1243,50).click(true);
			}else
			if (!Method.isChatting("Pikkupstix")) {
				Method.speakTo(6988, "Pikkupstix");
			}

			
		} else if(Vars.DYNAMICV){
			Method.walking(pathToMrStix,"Walking to Pikkupstix",false);
		}else if(TeleportLode.BURTHORPE.getTile().distanceTo(ctx.players.local().getLocation())<6||
				TeleportLode.TAVERLY.getTile().distanceTo(ctx.players.local().getLocation())<6){
			Vars.DYNAMICV=true;
		}else if(Method.TaverlyLodeAct()){
			Method.teleportTo(TeleportType.TAVERLY.getTeleport(),TeleportType.TAVERLY.getName());
		}else Method.teleportTo(TeleportType.BURTHHORPE.getTeleport(),TeleportType.BURTHHORPE.getName());
	}

	private void cs2() {

		if (new Tile(2881,3430,0).distanceTo(ctx.players.local().getLocation())<6) {//Mrs stix region.
				Vars.DYNAMICV = false;
					if (!Method.isChatting("Scaletrix")) {
						Method.speakTo(15055, "Scaletrix");
					}
		} else if (Vars.DYNAMICV) {
			Method.walking(pathToMrStix,"Walking to Scaletrix.",false);
		} else if(TeleportLode.BURTHORPE.getTile().distanceTo(ctx.players.local().getLocation())<6||
				TeleportLode.TAVERLY.getTile().distanceTo(ctx.players.local().getLocation())<6){
			Vars.DYNAMICV=true;
		}else if(Method.TaverlyLodeAct()){
			Method.teleportTo(TeleportType.TAVERLY.getTeleport(),TeleportType.TAVERLY.getName());
		}else Method.teleportTo(TeleportType.BURTHHORPE.getTeleport(),TeleportType.BURTHHORPE.getName());

	}

	private void cs1() {
		Method Method = new Method(ctx);
		 final String opt[] = {"Do you have"};
		if (new Tile(2932,3446,0).distanceTo(ctx.players.local().getLocation())<7) {//stix region.
			
			if (!Method.startQuestOpen())
				if (!Method.findOption(opt))
					if (!Method.isChatting("Pikkipstix")) {
						Vars.DYNAMICV = false;
						Method.speakTo(6988, "Pikkupstix");
					}
		} else if(Vars.DYNAMICV){
			Method.walking(pathToMrStix,"Walking to Pikkupstix",false);
		}else if(TeleportLode.BURTHORPE.getTile().distanceTo(ctx.players.local().getLocation())<6||
				TeleportLode.TAVERLY.getTile().distanceTo(ctx.players.local().getLocation())<6){
			Vars.DYNAMICV=true;
		}else if(Method.TaverlyLodeAct()){
			Method.teleportTo(TeleportType.TAVERLY.getTeleport(),TeleportType.TAVERLY.getName());
		}else Method.teleportTo(TeleportType.BURTHHORPE.getTeleport(),TeleportType.BURTHHORPE.getName());

	}

	public boolean activate() {
		return (DeltaQuester.scriptToStart == 2);
	}
}
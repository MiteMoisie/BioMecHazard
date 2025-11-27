package biomechazard.content;

import arc.*;
import arc.struct.*;
import arc.struct.Seq;
import mindustry.content.*;
import mindustry.content.SectorPresets;
import mindustry.game.Objectives.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.TechTree.*;
//import static mindustry.content.SectorPresets.*;
import static mindustry.game.Objectives.*;
import static biomechazard.content.blocks.BMHGates.*;
import static biomechazard.content.BMHBlocks.*;
import static biomechazard.content.BMHUnits.*;

public class BMHTechtree {
    public static void load(){
        //nodeRoot("BioMecHazard", coreShard, false, () -> {
			//node(BMHBlocks.coreNethrax/*, Seq.with(new SectorComplete(biomassFacility))*/);
		//});
		
		nodeRoot("BioMecHazard", gateMain, () -> {
			
			// Secteurs
			node(gateSector);
			
			// Noyau  
			node(gateCore, () -> {
				node(coreNethrax, Seq.with(new Research(coreNucleus)), () -> {
				});
			});
			
			// Unités de noyau
			node(gateCoreUnit, () -> {
				node(mokuge);
			});
			
			// Objets
			node(gateItem);
			
			// Récolteurs d'objets
			node(gateDrill);
			
			// Distributions d'objets
			node(gateDistribution);
			
			// Conduits de fluides
			node(gateDuct);
			
			// Usines de fabrication
			node(gateCrafter);
			
			// Génération d'énergie
			node(gatePower);
			
			// Utilitaires
			node(gateUtil);
			
			// Systèmes logiques
			node(gateLogic);
			
			// Murs
			node(gateWall);
			
			// Tourelles de défense
			node(gateTurret);
			
			// Usines de fabrication d'unités
			node(gateUnitFactory);
			
			// Unités terrestres
			node(gateGroundUnit);
			
			// Unités aériennes
			node(gateAirUnit);
			
			// Unités navales
			node(gateNavalUnit);
		});
	}
}

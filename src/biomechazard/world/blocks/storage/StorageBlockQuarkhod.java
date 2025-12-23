package biomechazard.world.blocks.storage;

import arc.Core;
import arc.func.Func;
import arc.util.*;
import mindustry.world.blocks.liquid.*;
import mindustry.game.*;
import mindustry.gen.Building;
import mindustry.graphics.Pal;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.meta.*;

/**
* Les stockages Quarkhod sont différents des stockages originaux : 
* - Ils peuvent être construit n'importe où, y compris sur l'eau. 
* - Ils sont conducteurs d'énergie, alimentant les blocs adjacents. 
* - Ils peuvent stocker les fluides et les redistribuer comme les réservoirs. 
* - Toute capacité additionnelle spécifique sera traitée dans sa propre classe. 
*/
public class StorageBlockQuarkhod extends StorageBlock {
	
	public StorageBlockQuarkhod(String name) {
		super(name);
		floating = true;
		placeableLiquid = true;
		update = true;
		
		consumesPower = false;
		outputsPower = true;
		conductivePower = true; // /!\ Ne fonctionne pas. 
		
		hasLiquids = true;
		liquidCapacity = 700; //Même capacité de base que le petit réservoir basique.
		liquidPressure = liquidCapacity / 2;
		isDuct = true;
		outputsLiquid = true;
	}
	
	/**
     * Cette méthode indique si le bloc est constructible sur l'emplacement indiqué, y compris les liquides. 
     * Peut causer des erreurs. 
     */
	/*@Override
	public boolean canPlaceOn(Tile tile, Team team, int rotation){
		if(tile == null) return false;
		return true;
	}*/
	
	public class StorageBlockQuarkhodBuild extends StorageBuild {

		@Override
        public void updateTile(){
            dumpLiquid(liquids.current());
        }
		
		@Override
        public boolean acceptLiquid(Building source, Liquid liquid){
            return (liquids.current() == liquid || liquids.currentAmount() < 0.2f);
        }
	}

}



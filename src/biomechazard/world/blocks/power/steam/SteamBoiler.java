/**
* @author Eschatologue 
* mod "Unlimited Armament Works"
*/

package biomechazard.world.blocks.power.steam;

import mindustry.content.Fx;
import mindustry.world.consumers.ConsumeItemExplode;
import mindustry.world.meta.Stat;
import biomechazard.world.blocks.production.FilterGenericCrafter;
import biomechazard.world.consumers.ConsumeItemFuelFlammable;

import static biomechazard.Vars.tick;

public class SteamBoiler extends FilterGenericCrafter {

	public SteamBoiler(String name) {
		super(name);
		warmupSpeed = 0.0025f;
		craftTime = 2f * tick;
		hasItems = true;
		hasLiquids = true;
		updateEffect = Fx.steam;
		consume(new ConsumeItemFuelFlammable());
		consume(new ConsumeItemExplode());
	}

	@Override
	public void setStats() {
		super.setStats();
		stats.remove(Stat.productionTime);
	}

}

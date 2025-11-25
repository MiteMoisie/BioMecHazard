package biomechazard.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.effect.MultiEffect;
import mindustry.graphics.*;
import mindustry.graphics.Pal;
import mindustry.type.StatusEffect;

import biomechazard.audiovisual.*;
import biomechazard.audiovisual.Outliner;
//import biomechazard.type.BMHStatusEffect;

import static biomechazard.Vars.tick;
import static mindustry.content.StatusEffects.*;

/**
* États issus du mod "Unlimited Armament Works" : concussion breached cryoBurn EMP thermalShock superConduct
* États issus du mod "Fading Revelations" : 
*  
*/
public class BMHStatus {
	public static StatusEffect 

	// Basic
	concussion, breached, 
	// Thermal / Elemental
	cryoBurn, EMP, thermalShock, 
	// Reactions
	superConduct;

	public static void load() {
		concussion = new BMHStatusEffect("concussion") {{
			color = Pal.lightishGray;
			reloadMultiplier = 0.7f;
			speedMultiplier = 0.5f;
		}};
		breached = new BMHStatusEffect("breached") {{
			color = UAWPal.titaniumMiddle;
			healthMultiplier = 0.75f;
		}};
		cryoBurn = new BMHStatusEffect("cryoburn") {{
			color = UAWPal.cryoMiddle;
			effect = BMHEffects.statusEffectSquare.wrap(color);
			reloadMultiplier = 0.6f;
			speedMultiplier = 0.45f;
			healthMultiplier = 0.8f;
			damage = 0.55f;
			transitionDamage = 25;

			init(() -> {
				affinity(burning, (unit, result, time) -> {
					result.set(thermalShock, 2 * tick);
					unit.damagePierce(transitionDamage * 2f);
				});
				affinity(melting, (unit, result, time) -> {
					result.set(thermalShock, 5 * tick);
					unit.damagePierce(transitionDamage * 3f);
				});
				affinity(EMP, (unit, result, time) -> {
					result.set(superConduct, 15 * tick);
					unit.damagePierce(transitionDamage * 0.5f);
				});
			});
		}};
		EMP = new BMHStatusEffect("emp") {{
			color = UAWPal.surgeBack;
			effect = new MultiEffect(
				BMHEffects.statusEffectSquare.wrap(color),
				Fx.hitLancer,
				Fx.smoke
			);
			buildSpeedMultiplier = speedMultiplier = 0.3f;
			reloadMultiplier = 0.2f;
			init(() -> {
				affinity(cryoBurn, (unit, result, time) -> {
					result.set(superConduct, 15 * tick);
					unit.damagePierce(transitionDamage * 0.5f);
				});
			});
		}};

		superConduct = new BMHStatusEffect("superconduct") {{
			dragMultiplier = 1.5f;
			healthMultiplier = 0.7f;
			color = Pal.surge.lerp(UAWPal.cryoMiddle, 0.5f);
			effect = new MultiEffect(
				BMHEffects.statusEffectSquare.wrap(Pal.surge.lerp(UAWPal.cryoMiddle, 0.5f)),
				Fx.hitLancer
			);
		}};
		thermalShock = new BMHStatusEffect("thermalshock") {{
			healthMultiplier = 0.4f;
			speedMultiplier = 0.8f;
			reloadMultiplier = 0.4f;
			color = Pal.lightPyraFlame;
			effect = new MultiEffect(
				BMHEffects.statusEffectSquare.wrap(Pal.lightPyraFlame),
				Fx.burning,
				Fx.smoke
			);
		}};
	}
	public static class BMHStatusEffect extends StatusEffect {
		public Color outlineColor = Pal.darkerMetal;
		public int outlineThickness = 3;
		public float affinityResultTime = 60f;
		
		public BMHStatusEffect(String name) {
			super(name);
		}
		
		@Override
		public void createIcons(MultiPacker packer) {
			Outliner.outlineRegion(packer, fullIcon, outlineColor, name, outlineThickness);
			
			super.createIcons(packer);
		}
	}
}

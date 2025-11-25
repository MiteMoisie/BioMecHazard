package biomechazard.content;

import arc.graphics.Color;
import arc.math.*;
import mindustry.content.Fx;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.graphics.*;
import mindustry.graphics.Pal;
import mindustry.type.StatusEffect;

import biomechazard.audiovisual.*;
import biomechazard.audiovisual.Outliner;
//import biomechazard.type.BMHStatusEffect;

import static arc.math.Interp.*;
import static mindustry.content.StatusEffects.*;
import static biomechazard.Vars.tick;

/**
* États issus du mod "Unlimited Armament Works" : concussion breached cryoBurn EMP thermalShock superConduct
* États issus du mod "Fading Revelations" : acidicBurn constructionShock empAffected hastened highEnergyBurn japonicaWeakened 
*  neutronFrozen polymorphousBuilding radiated shockSlowed superHastened
*/
public class BMHStatus {
	public static StatusEffect 

	// Basic
	concussion, breached, 
	// Thermal / Elemental
	cryoBurn, EMP, thermalShock, 
	// Reactions
	superConduct, 
	
	acidicBurn, constructionShock, empAffected, hastened, highEnergyBurn, japonicaWeakened, neutronFrozen, polymorphousBuilding, 
	radiated, shockSlowed, superHastened;

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
		
		acidicBurn = new BMHStatusEffect("acidic-burn") {{
			damage = 0.1f;
			speedMultiplier = 0.9f;
			effectChance = 0.2f;
			effect = new ParticleEffect(){{
				particles = 20;
				colorFrom = Color.valueOf("f8f854");
				colorTo = Color.valueOf("b0bf1a");
				interp = circleOut;
				length = 4;
				baseLength = 6;
				line = true;
				strokeFrom = 1.1f;
				strokeTo = 0.3f;
				lifetime = 120f;
			}};
		}};
		constructionShock = new BMHStatusEffect("construction-shock") {{
			buildSpeedMultiplier = 0.8f;
			speedMultiplier = 0.8f;
		}};
		empAffected = new BMHStatusEffect("emp-affected") {{
			speedMultiplier = 0.4f;
			damageMultiplier = 0.6f;
			healthMultiplier = 0.8f;
			reloadMultiplier = 0.7f;
		}};
		hastened = new BMHStatusEffect("hastened") {{
			reloadMultiplier = 1.6f;
			alwaysUnlocked = true;
		}};
		highEnergyBurn = new BMHStatusEffect("high-energy-burn") {{
			reloadMultiplier = 0.85f;
			damage = 0.4f;
			applyColor = Color.valueOf("e8d174");
			color = Color.valueOf("e8d174");
			alwaysUnlocked = true;
			effect = new ParticleEffect(){{
				particles = 8;
				sizeFrom = 1f;
				sizeTo = 2.7f;
				line = true;
				strokeFrom = 0.6f;
				strokeTo = 1f;
				colorFrom = Color.valueOf("e8d174");
				colorTo = Color.valueOf("fffab8");
				interp = pow2Out;
				sizeInterp = pow2Out;
			}};
			init(() -> {
				//Rien n'est indiqué dans le json sur les résultats de l'affinité.
                affinity(wet, (unit, result, time) -> {});
                opposite(tarred, freezing);
            });
		}};
		japonicaWeakened = new BMHStatusEffect("japonica-weakened") {{
			buildSpeedMultiplier = 0.8f;
			damageMultiplier = 0.8f;
			reloadMultiplier = 0.8f;
			speedMultiplier = 0.8f;
			alwaysUnlocked = true;
		}};
		neutronFrozen = new BMHStatusEffect("neutron-frozen") {{
			speedMultiplier = 0.4f;
			alwaysUnlocked = true;
			reloadMultiplier = 0.7f;
			damage = 0.1f;
		}};
		polymorphousBuilding = new BMHStatusEffect("polymorphous-building") {{
			buildSpeedMultiplier = 1.2f;
		}};
		radiated = new BMHStatusEffect("radiated") {{
			damage = 0.125f;
			speedMultiplier = 0.9f;
			reloadMultiplier = 0.9f;
			healthMultiplier = 0.9f;
			permanent = true;
			alwaysUnlocked = true;
			effect = new ParticleEffect(){{
				particles = 8;
				colorFrom = Color.valueOf("30af1f");
				colorTo = Color.valueOf("328926");
				interp = circleOut;
			}};
		}};
		shockSlowed = new BMHStatusEffect("shock-slowed") {{
			speedMultiplier = 0.3f;
			alwaysUnlocked = true;
		}};
		superHastened = new BMHStatusEffect("super-hastened") {{
			reloadMultiplier = 2.2f;
			alwaysUnlocked = true;
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

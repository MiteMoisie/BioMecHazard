package biomechazard.content.blocks;

import mindustry.content.*;
import mindustry.entities.effect.*;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.*;
import mindustry.entities.part.RegionPart;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.draw.DrawTurret;
import biomechazard.entities.bullet.*;

import static mindustry.content.Items.*;
import static mindustry.content.Liquids.*;
import static mindustry.content.Fx.*;
import static mindustry.content.StatusEffects.*;
import static mindustry.graphics.Pal.*;
import static mindustry.type.Category.*;
import static mindustry.type.ItemStack.with;
import static mindustry.Vars.tilesize;
import static biomechazard.Vars.*;
import static biomechazard.audiovisual.UAWPal.*;
import static biomechazard.audiovisual.BMHEffects.*;
import static biomechazard.content.BMHItems.*;
import static biomechazard.content.BMHLiquids.*;

/**
* Tourrelles issues du mod "Unlimited Armament Works" : quadra ashlock buckshot skeeter spitfire longbow tempest strikeforce zounderkite redeemer 
* 	deadeye skyhammer hellseeker heavylight reticence trailblazer sundouser
* 	
* Tourrelles issues du mod "Fading Revelations" : 
*  
*/

public class BMHBlocksTurret {
	
	public static Block 
		// Tier 2
		quadra, ashlock, buckshot, skeeter, 
		// Tier 3
		spitfire, longbow, tempest, strikeforce, zounderkite, redeemer, 
		// Tier 4
		deadeye, skyhammer, hellseeker, 
		// Tier 5
		// Energy
		heavylight, reticence, trailblazer, sundouser;
		
	public static void load() {
		quadra = new ItemTurret("quadra") {{
			requirements(turret, with(
				copper, 115,
				lead, 120,
				graphite, 80
			));
			size = 2;
			scaledHealth = 160;

			reload = 6f;
			recoil = 1f;
			recoilTime = reload * 4;
			maxAmmo = 30;

			range = 20 * tilesize;
			shootCone = 15f;
			inaccuracy = 7.5f;
			rotateSpeed = 10f;

			ammoUseEffect = casing2Double;

			shoot = new ShootAlternate() {{
				barrels = 2;
				shots = 2;
				barrelOffset = 5;
				spread = 4f;
			}};

			ammo(
				copper, new BasicBulletType(5f, 9) {{
					height = 9f;
					width = 7f;
					lifetime = 60f;
					shootEffect = shootSmall;
					smokeEffect = shootSmallSmoke;
					ammoMultiplier = 2;
				}},
				graphite, new BasicBulletType(6f, 18) {{
					height = 12f;
					width = 9f;
					hitColor = frontColor = graphiteFront;
					backColor = graphiteBack;
					hitEffect = hitBulletColor;
					reloadMultiplier = 0.6f;
					ammoMultiplier = 4;
					lifetime = 60f;
				}},
				titanium, new TrailBulletType(10f, 10f) {{
					height = 12f;
					width = 5f;
					frontColor = titaniumFront;
					backColor = titaniumBack;
					pierceArmor = true;
					shootEffect = shootSmallColor;
					smokeEffect = shootBigSmoke;
					ammoMultiplier = 3;
					trailInterval = 0.4f;
					trailEffect = disperseTrail;
					trailLengthScale = 0.6f;
				}},
				pyratite, new BasicBulletType(5f, 15) {{
					height = 12f;
					width = 8f;
					frontColor = lightishOrange;
					backColor = lightOrange;
					status = StatusEffects.burning;
					hitEffect = new MultiEffect(hitBulletSmall, fireHit);
					ammoMultiplier = 5;
					splashDamage = 10f;
					splashDamageRadius = 22f;
					makeFire = true;
					lifetime = 60f;
				}},
				cryogel, new BasicBulletType(5f, 15) {{
					height = 12f;
					width = 8f;
					frontColor = cryoFront;
					hitColor = backColor = cryoBack;
					status = StatusEffects.freezing;
					hitEffect = new MultiEffect(hitBulletColor, cryoHit);
					ammoMultiplier = 5;
					splashDamage = 10f;
					splashDamageRadius = 22f;
					lifetime = 60f;
				}}
			);
			limitRange();

			squareSprite = false;
			cooldownTime = reload * 0.6f;
			drawer = new DrawTurret(modTurretBase) {{
				parts.addAll(
					new RegionPart("-barrel") {{
						progress = PartProgress.recoil;
						moveY = -5f * px;

					}},
					new RegionPart("-body"),
					new RegionPart("-back") {{
						progress = PartProgress.reload;
						moveY = -6f * px;
					}}
				);
			}};
		}};
	}
}

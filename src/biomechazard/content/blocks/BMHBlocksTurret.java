package biomechazard.content.blocks;

import arc.graphics.Color;
import mindustry.content.*;
import mindustry.entities.effect.*;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.*;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Sounds;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.draw.DrawTurret;
import biomechazard.entities.bullet.*;
import biomechazard.audiovisual.*;
import biomechazard.entities.UAWUnitSorts;

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
* Tourrelles issues du mod "Unlimited Armament Works" : quadra ashlock buckshot skeeter spitfire longsword tempest strikeforce zounderkite redeemer 
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
		spitfire, longsword, tempest, strikeforce, zounderkite, redeemer, 
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
		}};;
		
		spitfire = new ItemTurret("spitfire") {{
			requirements(turret, with(
				lead, 350,
				titanium, 280,
				thorium, 250,
				Items.plastanium, 250,
				silicon, 150
			));
			size = 3;
			scaledHealth = 250;

			reload = 2.5f;
			recoil = 1f;
			recoilTime = 60f;
			maxAmmo = 200;
			minWarmup = 0.95f;
			shootWarmupSpeed = 0.025f;

			range = 35 * tilesize;
			inaccuracy = 7.5f;
			rotateSpeed = 7f;
			targetAir = false;

			shootSound = Sounds.shootBig;

			ammoUseEffect = casing2Double;

			shoot = new ShootBarrel() {{
				barrels = new float[]{
					0f, 2f, 0f,
					3f, 1f, 0f,
					-3f, 1f, 0f,
				};
			}};

			ammo(
				graphite, new BasicBulletType(8, 20) {{
					pierceCap = 2;
					height = 22;
					width = 10;
					knockback = 1.2f;
					hitEffect = hitBulletBig;
					smokeEffect = shootBigSmoke2;
					shootEffect = shootBig2;
					trailChance = 0.4f;
					trailColor = Color.lightGray;

					status = StatusEffects.slow;
					collidesAir = false;
				}},
				stoutsteel, new TrailBulletType(12, 22) {{
					height = 20;
					width = 5;
					pierce = true;
					pierceArmor = true;
					despawnHit = true;
					frontColor = titaniumFront;
					backColor = titaniumBack;
					hitEffect = new MultiEffect(hitBulletColor, generatespark);
					smokeEffect = new MultiEffect(shootBigSmoke2, fireSmoke);
					shootEffect = shootBigColor;
					trailEffect = disperseTrail;
					trailChance = 0.7f;
					collidesAir = false;
				}},
				pyratite, new BasicBulletType(7, 15) {{
					height = 25;
					width = 10;
					knockback = 1.2f;
					hitEffect = hitBulletBig;
					smokeEffect = shootBigSmoke2;
					shootEffect = new MultiEffect(shootPyraFlame, shootBig2);
					hitEffect = new MultiEffect(hitBulletBig, fireHit);
					despawnEffect = fireHit;
					frontColor = lightishOrange;
					backColor = lightOrange;
					status = StatusEffects.burning;
					makeFire = true;
					trailChance = 0.4f;
					trailColor = Color.lightGray;
					collidesAir = false;
				}},
				cryogel, new BasicBulletType(7, 15) {{
					height = 25;
					width = 10;
					knockback = 1.2f;
					hitEffect = hitBulletBig;
					despawnEffect = Fx.freezing;
					smokeEffect = shootBigSmoke2;
					shootEffect = new MultiEffect(shootSmoke, shootBig2);
					hitEffect = new MultiEffect(hitBulletBig, cryoHit);
					despawnEffect = cryoHit;
					frontColor = cryoFront;
					backColor = cryoBack;
					status = StatusEffects.freezing;
					trailChance = 0.4f;
					trailColor = Color.lightGray;
					collidesAir = false;
				}},
				surgeAlloy, new BasicBulletType(8, 15) {{
					height = 25;
					width = 8;
					hitEffect = despawnEffect = new MultiEffect(Fx.hitBulletBig, Fx.lightning);
					smokeEffect = new MultiEffect(shootBigSmoke2, fireSmoke);
					shootEffect = new MultiEffect(shootBig, sparkShoot);
					status = StatusEffects.electrified;
					trailChance = 0.4f;
					trailColor = Color.lightGray;

					lightning = 3;
					lightningAngle = 360;
					lightningDamage = 1.5f;
					lightningLength = 12;
					collidesAir = false;
				}}
			);
			limitRange(2 * tilesize);

			squareSprite = false;
			cooldownTime = 2 * tick;
			drawer = new DrawTurret(modTurretBase) {{
				parts.addAll(
					new RegionPart("-barrel") {{
						heatProgress = PartProgress.heat.add(PartProgress.heat);
						progress = PartProgress.warmup.add(PartProgress.reload.add(-2.5f));
						moveY = 4 * px;
					}},
					new RegionPart("-side") {{
						progress = PartProgress.warmup;
						mirror = true;
						moveX = 2f * px;
						moveY = -4 * px;
						moveRot = -22f;
					}},
					new RegionPart("-blade") {{
						progress = PartProgress.warmup;
						mirror = true;
						moveX = -4 * px;
						moveY = 8 * px;
					}},
					new RegionPart("-back") {{
						progress = PartProgress.warmup;
						moveY = -2.5f;
					}},
					new RegionPart("-top")
				);
			}};
		}};

		ashlock = new ItemTurret("ashlock") {{
			requirements(Category.turret, with(
				Items.copper, 150,
				Items.graphite, 100,
				Items.titanium, 50
			));
			size = 2;
			scaledHealth = 250;

			reload = 1.75f * tick;
			recoil = 3f;
			ammoPerShot = 3;
			maxAmmo = 30;

			range = 30 * tilesize;
			inaccuracy = 0f;
			rotateSpeed = 5f;
			shake = 3.5f;

			shootSound = BMHSoundEffects.cannonShoot1;
			soundPitchMin = 1.5f;
			soundPitchMax = 2f;

			ammoUseEffect = Fx.casing3;

			unitSort = UAWUnitSorts.mostHitPoints;

			ammoEjectBack = 9f;
			shootY = 10f;

			ammo(
				Items.graphite, new TrailBulletType(10f, 90f) {{
					hitSize = 6;
					height = 24f;
					width = 10f;
					frontColor = UAWPal.graphiteFront;
					backColor = UAWPal.graphiteMiddle;
					trailEffect = Fx.disperseTrail;
					trailChance = 0.8f;
					shootEffect = Fx.shootBigColor;
					hitEffect = Fx.hitBulletColor;
					trailColor = hitColor = backColor;
					despawnHit = true;
					smokeEffect = Fx.shootBigSmoke;
					reloadMultiplier = 0.5f;
					ammoMultiplier = 2;
					knockback = 1.2f;
				}},
				Items.silicon, new TrailBulletType(8f, 80f) {{
					hitSize = 5;
					height = 30f;
					width = 10f;
					homingPower = 0.2f;
					trailEffect = Fx.disperseTrail;
					trailChance = 0.8f;
					shootEffect = Fx.shootBigColor;
					hitEffect = Fx.hitBulletColor;
					trailColor = hitColor = backColor;
					despawnHit = true;
					ammoMultiplier = 2;
					pierceCap = 2;
				}},
				Items.thorium, new TrailBulletType(10f, 120f) {{
					hitSize = 5;
					height = 30f;
					width = 12f;
					frontColor = Pal.missileYellow;
					backColor = Pal.missileYellowBack;
					trailEffect = Fx.disperseTrail;
					trailChance = 0.8f;
					shootEffect = Fx.shootBigColor;
					hitEffect = Fx.hitBulletColor;
					trailColor = hitColor = backColor;
					despawnHit = true;
					knockback = 0.7f;
				}},
				Items.titanium, new TrailBulletType(11f, 70f) {{
					hitSize = 6f;
					height = 20f;
					width = 8f;
					despawnHit = true;
					pierceArmor = true;
					frontColor = UAWPal.titaniumFront;
					backColor = UAWPal.titaniumBack;
					trailEffect = Fx.disperseTrail;
					trailChance = 0.8f;
					shootEffect = Fx.shootBigColor;
					hitEffect = Fx.hitBulletColor;
					trailColor = hitColor = backColor;
					smokeEffect = Fx.shootBigSmoke;
					ammoMultiplier = 2;
					pierce = true;
				}}
			);
			limitRange();

			squareSprite = false;
			cooldownTime = reload * 0.5f;
			drawer = new DrawTurret(modTurretBase) {{
				parts.addAll(
					new RegionPart("-barrel") {{
						progress = PartProgress.recoil;
						moveY = -9 * px;
					}},
					new RegionPart("-breach") {{
						progress = PartProgress.reload;
						moveY = -12 * px;
						heatProgress = PartProgress.reload.add(1.5f);
					}},
					new RegionPart("-body")
				);
			}};
		}};

		longsword = new ItemTurret("longsword") {{
			requirements(Category.turret, with(
				Items.thorium, 400,
				Items.titanium, 275,
				Items.graphite, 250,
				Items.silicon, 200,
				Items.plastanium, 150
			));
			size = 3;
			scaledHealth = 250;

			reload = 2 * tick;
			recoil = 3f;
			ammoPerShot = 6;
			maxAmmo = 30;

			range = 65 * tilesize;
			shootCone = 1f;
			shake = 3f;
			rotateSpeed = 2.5f;
			
			shootSound = BMHSoundEffects.cannonShoot2;
			soundPitchMin = 2.2f;
			soundPitchMax = 2.8f;

			ammoUseEffect = Fx.casing4;

			unitSort = UAWUnitSorts.mostHitPoints;

			ammo(
				Items.surgeAlloy, new TrailBulletType(15f, 400) {{
					hitSize = 8f;
					height = 28f;
					width = 12f;
					despawnHit = true;
					frontColor = UAWPal.surgeFront;
					backColor = UAWPal.surgeBack;
					trailEffect = new MultiEffect(
						Fx.disperseTrail,
						Fx.disperseTrail,
						Fx.disperseTrail
					);
					trailInterval = 0.05f;
					trailChance = 0.8f;
					shootEffect = new MultiEffect(
						BMHEffects.railShoot(35, UAWPal.surgeBack),
						Fx.shootBigColor
					);
					hitEffect = new MultiEffect(
						BMHEffects.railHit(35, UAWPal.surgeBack),
						Fx.hitBulletColor
					);
					trailColor = hitColor = backColor;
					smokeEffect = Fx.shootBigSmoke;
					pierceCap = 3;
				}},
				stoutsteel, new TrailBulletType(18f, 350) {{
					hitSize = 8f;
					height = 28f;
					width = 12f;
					despawnHit = true;
					pierceArmor = true;
					frontColor = UAWPal.graphiteFront;
					backColor = UAWPal.graphiteMiddle;
					trailEffect = new MultiEffect(
						Fx.disperseTrail,
						Fx.disperseTrail,
						Fx.disperseTrail
					);
					trailInterval = 0.05f;
					trailChance = 0.8f;
					shootEffect = new MultiEffect(
						BMHEffects.railShoot(85, backColor),
						Fx.shootBigColor
					);
					hitEffect = new MultiEffect(
						BMHEffects.railHit(40, hitColor),
						BMHEffects.hitBulletBigColor
					);
					trailColor = hitColor = backColor;
					smokeEffect = Fx.shootBigSmoke;
					pierce = true;
				}}
			);
			limitRange();

			squareSprite = false;
			drawer = new DrawTurret(modTurretBase) {{
				parts.addAll(
					new RegionPart("-body"),
					new RegionPart("-barrel") {{
						progress = PartProgress.recoil.curve(Interp.pow2In);
						moveY = -9 * px;
						heatProgress = PartProgress.recoil;
					}}
				);
			}};
		}};


		
	}
}

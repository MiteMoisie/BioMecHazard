package biomechazard.content;

import arc.audio.*;
import arc.graphics.*;
import mindustry.content.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.gen.*;
import mindustry.type.*;

import static mindustry.content.StatusEffects.*;
import static mindustry.Vars.*;

public class FRUnitTypes{
	
	public static UnitType deltaFR, epsilonFR, mainCoreUnit;
	
	public static void load(){
		
		deltaFR = new UnitType("deltaFR"){{
			this.constructor = UnitEntity::create;
			drag = 0.15f;
			speed = 4f;
			buildSpeed = 2.5f;
			mineSpeed = 14f;
			mineTier = 3;
			armor = 10;
			coreUnitDock = true;
			health = 260;
			flying = true;
			itemCapacity = 80;
			weapons.add(new Weapon("biomechazard-core-units-weapons-fr"){{
				x = 0f;
				y = 2f;
				reload = 7f;
				shootSound = Sounds.lasershoot;
				bullet = new LaserBoltBulletType(6f, 11f){{
					buildingDamageMultiplier = 0.01f;
					pierce = true;
					pierceCap = 10;
					splashDamage = 6f;
					mixColorFrom = Color.valueOf("d4816b");
					mixColorTo = Color.valueOf("ffd37f");
					splashDamageRadius = 4f;
					homingRange = 170f;
					homingPower = 0.18f;
					healPercent = 1f;
					collidesTeam = true;
					hitEffect = new MultiEffect(
						new WaveEffect(){{
							colorFrom = Color.valueOf("d4816b");
							colorTo = Color.valueOf("ffd37f");
							rotation = 3f;
							sizeFrom = 0f;
							sizeTo = 4f;
						}}, 
						new WaveEffect(){{
							colorFrom = Color.valueOf("ffd37f");
							colorTo = Color.valueOf("d4816b");
							rotation = 3f;
							sizeFrom = 4f;
							sizeTo = 0f;
						}}
					);
				}};
			}});
			//ForceFieldAbility(float radius, float regen, float max, float cooldown, int sides, float rotation)
			abilities.add(new ForceFieldAbility(10f, 1f, 140f, 480f));
			hitSize = 7f;
		}};
		
		epsilonFR = new UnitType("epsilonFR"){{
			this.constructor = UnitEntity::create;
			drag = 0.15f;
			speed = 4.25f;
			buildSpeed = 3f;
			mineSpeed = 16f;
			mineTier = 3;
			armor = 10;
			coreUnitDock = true;
			health = 310;
			flying = true;
			itemCapacity = 100;
			weapons.add(new Weapon("biomechazard-core-units-weapons-fr"){{
				x = 3f;
				y = 2f;
				reload = 5f;
				mirror = true;
				alternate = true;
				shootSound = Sounds.lasershoot;
				bullet = new LaserBoltBulletType(6f, 11f){{
					buildingDamageMultiplier = 0.01f;
					pierce = true;
					pierceCap = 10;
					splashDamage = 6f;
					mixColorFrom = Color.valueOf("d4816b");
					mixColorTo = Color.valueOf("ffd37f");
					splashDamageRadius = 5f;
					homingRange = 170f;
					homingPower = 0.18f;
					healPercent = 2f;
					collidesTeam = true;
					hitEffect = new MultiEffect(
						new WaveEffect(){{
							colorFrom = Color.valueOf("ffd37f");
							colorTo = Color.valueOf("d4816b");
							rotation = 3f;
							sizeFrom = 0f;
							sizeTo = 5f;
						}}, 
						new WaveEffect(){{
							colorFrom = Color.valueOf("d4816b");
							colorTo = Color.valueOf("ffd37f");
							rotation = 3f;
							sizeFrom = 5f;
							sizeTo = 0f;
						}}
					);
				}};
			}});
			//ForceFieldAbility(float radius, float regen, float max, float cooldown, int sides, float rotation)
			abilities.add(new ForceFieldAbility(10f, 2f, 240f, 480f));
			hitSize = 10f;
		}};
		
		mainCoreUnit = new UnitType("main-core-unit"){{
			this.constructor = UnitEntity::create;
			hidden = true;
			flying = true;
			hittable = false;
			hitSize = 1f;
			killable = false;
			targetable = false;
			immunities = ObjectSet.with(burning, freezing, unmoving, melting, wet, sapped, tarred, overdrive, overclock, boss, shocked, blasted);
			healFlash = false;
			canBoost = false;
			canAttack = true;
			canDrown = false;
			canHeal = false;
			speed = 0f;
			rotateSpeed = 0f;
			buildRange = 999999999999f;
			buildSpeed = 3.5f;
			drawBuildBeam = true;
			buildBeamOffset = -2f;
			drawCell = false;
			drawItems = false;
			itemCapacity = 0;
			drawShields = false;
			drawMinimap = false;
			engineSize = 0f;
			coreUnitDock = false;
			createWreck = false;
			createScorch = false;
			lightColor = Color.valueOf("ffffff");
			lightRadius = 0f;
			lowAltitude = true;
			mineFloor = true;
			mineWalls = true;
			mineRange = 999999999999f;
			mineHardnessScaling = true;
			mineSpeed = 20f;
			mineTier = 10;
			physics = false;
			playerControllable = true;
			useUnitCap = false;
			bounded = true;
			weapons.add(new Weapon("biomechazard-main-core-hail"){{
				x = 23f;
				y = 20f;
				reload = 60f;
				mirror = false;
				alternate = true;
				shootSound = Sounds.bang;
				rotate = true;
				inaccuracy = 1f;
				bullet = new ArtilleryBulletType(){{
					splashDamage = 10f;
					splashDamageRadius = 20f;
					speed = 3f;
					lifetime = 80f;
					knockback = 0.8f;
					hitEffect = Fx.blastExplosion;
					width = 13f;
					height = 13f;
					collidesTiles = false;
					frontColor = Color.valueOf("f8ad42");
					backColor = Color.valueOf("f68021");
				}};
			}});
			weapons.add(new Weapon("biomechazard-main-core-hail"){{
				x = -23f;
				y = 20f;
				reload = 60f;
				mirror = false;
				alternate = true;
				shootSound = Sounds.bang;
				rotate = true;
				inaccuracy = 1f;
				bullet = new ArtilleryBulletType(){{
					splashDamage = 10f;
					splashDamageRadius = 20f;
					speed = 3f;
					lifetime = 80f;
					knockback = 0.8f;
					hitEffect = Fx.blastExplosion;
					width = 13f;
					height = 13f;
					collidesTiles = false;
					frontColor = Color.valueOf("f8ad42");
					backColor = Color.valueOf("f68021");
				}};
			}});
			weapons.add(new Weapon("biomechazard-main-core-hail"){{
				x = 23f;
				y = -27f;
				reload = 60f;
				mirror = false;
				alternate = true;
				shootSound = Sounds.bang;
				rotate = true;
				inaccuracy = 1f;
				bullet = new ArtilleryBulletType(){{
					splashDamage = 10f;
					splashDamageRadius = 20f;
					speed = 3f;
					lifetime = 80f;
					knockback = 0.8f;
					hitEffect = Fx.blastExplosion;
					width = 13f;
					height = 13f;
					collidesTiles = false;
					frontColor = Color.valueOf("f8ad42");
					backColor = Color.valueOf("f68021");
				}};
			}});
			weapons.add(new Weapon("biomechazard-main-core-hail"){{
				x = -23f;
				y = -27f;
				reload = 60f;
				mirror = false;
				alternate = true;
				shootSound = Sounds.bang;
				rotate = true;
				inaccuracy = 1f;
				bullet = new ArtilleryBulletType(){{
					splashDamage = 10f;
					splashDamageRadius = 20f;
					speed = 3f;
					lifetime = 80f;
					knockback = 0.8f;
					hitEffect = Fx.blastExplosion;
					width = 13f;
					height = 13f;
					collidesTiles = false;
					frontColor = Color.valueOf("f8ad42");
					backColor = Color.valueOf("f68021");
				}};
			}});
			weapons.add(new Weapon("biomechazard-main-core-shotgun"){{
				x = 0f;
				y = 29f;
				reload = 35f;
				mirror = false;
				rotate = false;
				shootSound = Sounds.shotgun;
				baseRotation = 0f;
				shootCone = 20f;
				shoot = new ShootSpread(3, 20f);
				bullet = new ShrapnelBulletType(){{
					damage = 20f;
					shootEffect = Fx.thoriumShoot;
					smokeEffect = Fx.thoriumShoot;
					toColor = Color.valueOf("f9a3c7");
				}};
			}});
			weapons.add(new Weapon("biomechazard-main-core-shotgun"){{
				x = 29f;
				y = -2f;
				reload = 35f;
				mirror = false;
				rotate = false;
				shootSound = Sounds.shotgun;
				baseRotation = 0f;
				shootCone = 20f;
				shoot = new ShootSpread(3, 20f);
				bullet = new ShrapnelBulletType(){{
					damage = 20f;
					shootEffect = Fx.thoriumShoot;
					smokeEffect = Fx.thoriumShoot;
					toColor = Color.valueOf("f9a3c7");
				}};
			}});
			weapons.add(new Weapon("biomechazard-main-core-shotgun"){{
				x = -29f;
				y = -2f;
				reload = 35f;
				mirror = false;
				rotate = false;
				shootSound = Sounds.shotgun;
				baseRotation = 0f;
				shootCone = 20f;
				shoot = new ShootSpread(3, 20f);
				bullet = new ShrapnelBulletType(){{
					damage = 20f;
					shootEffect = Fx.thoriumShoot;
					smokeEffect = Fx.thoriumShoot;
					toColor = Color.valueOf("f9a3c7");
				}};
			}});
			weapons.add(new Weapon("biomechazard-main-core-shotgun"){{
				x = 0f;
				y = -29f;
				reload = 35f;
				mirror = false;
				rotate = false;
				shootSound = Sounds.shotgun;
				baseRotation = 0f;
				shootCone = 20f;
				shoot = new ShootSpread(3, 20f);
				bullet = new ShrapnelBulletType(){{
					damage = 20f;
					shootEffect = Fx.thoriumShoot;
					smokeEffect = Fx.thoriumShoot;
					toColor = Color.valueOf("f9a3c7");
				}};
			}});
			weapons.add(new Weapon("biomechazard-main-core-immobilizer-gun"){{
				x = 0f;
				y = -1f;
				reload = 360f;
				mirror = false;
				rotate = true;
				controllable = false;
				autoTarget = true;
				bullet = new BasicBulletType(){{
					damage = 0f;
					splashDamage = 1f;
					splashDamageRadius = 80f;
					status = StatusEffects.sporeSlowed;
					statusDuration = 180f;
					instantDisappear = true;
					width = 0.001f;
					height = 0.001f;
					despawnHit = true;
					hitEffect = new WaveEffect(){{
						sizeFrom = 0f;
						sizeTo = 120f;
						lifetime = 60f;
						colorFrom = Color.valueOf("b0bac0");
						colorTo = Color.valueOf("818181");
					}};
				}};
			}});
			//UnitSpawnAbility(UnitType unit, float spawnTime, float spawnX, float spawnY)
			abilities.add(new UnitSpawnAbility(UnitTypes.mono, 600f, 0f, -2f));
			//EnergyFieldAbility(float damage, float reload, float range)
			abilities.add(new EnergyFieldAbility(20f, 20f, 120f){{
				color = Color.valueOf("dcc6c6");
				healPercent = 4f;
				hitBuildings = false;
				hitUnits = true;
				maxTargets = 8;
				sectors = 4;
				shootSound = Sounds.spark;
				status = StatusEffects.electrified;
				statusDuration = 60f;
				targetAir = true;
				targetGround = true;
				x = 0f;
				y = -2f;
			}});
			//ForceFieldAbility(float radius, float regen, float max, float cooldown)
			//ForceFieldAbility(float radius, float regen, float max, float cooldown, int sides, float rotation)			
			abilities.add(new ForceFieldAbility(100f, 1f, 2000f, 720f){{alpha = 0.1f;}});
		}};
		
	}
}













































package biomechazard.content;

import arc.func.Prov;
import arc.graphics.*;
import arc.struct.*;
import mindustry.Vars;
import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.part.DrawPart.PartProgress;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.content.*;
import mindustry.content.StatusEffects;
import mindustry.type.unit.*;
import mindustry.world.meta.*;
import biomechazard.content.*;
import biomechazard.audiovisual.*;

import static mindustry.content.StatusEffects.*;
import static mindustry.Vars.*;

public class BMHUnits{
    public static UnitType mokuge;

        public static void load(){
        
        mokuge = new UnitType("mokuge"){{
			//Plantage au démarrage : apparemment, ce constructeur est nécessaire
			this.constructor = UnitEntity::create;
			
			outlineColor = Color.valueOf("000000"); //Original 303A45
			health = 2280;
            armor = 25;
			flying = true;
			immunities = ObjectSet.with(disarmed, sapped, slow, sporeSlowed, unmoving, shocked, freezing, overdrive);
			
			lightRadius = 35f;
			lightOpacity = 0.1f;
			fogRadius = 50f;
			outlineRadius = 2;
			
			buildRange = 300f;
            buildSpeed = 5.8f;
			
			mineRange = 300f;
            mineSpeed = 10f;
			mineTier = 10;
			mineWalls = true;
			mineFloor = true;
			mineHardnessScaling = false;
			
			itemCapacity = 150;
            payloadCapacity = (3 * 3) * tilePayload;
			
            speed = 6.7f;
			rotateSpeed = 6.1f;
			accel = 0.4f;
			drag /= 5f;
			strafePenalty = 0.3f;
			
			weapons.add(new Weapon("-mouth"){{
                reload = 40f; //75f;
                shootY = 8f;
                x = 0f;
                y = 0f;
                continuous = true;
                shoot.firstShotDelay = BMHEffects.purpleBigLaserBeam.lifetime -1f;
                chargeSound = Sounds.lasercharge2;
                shootSound = Sounds.beam;
                shootStatus = StatusEffects.slow;
                shootStatusDuration = 60f * 3;
                mirror = false;
                bullet = new ContinuousLaserBulletType(45f){{
                    width = 4f;
                    length = 293.5f;
                    drawSize = 100f;
                    lifetime = 300f;
                    healPercent = 0.5f;
                    collidesTeam = true;
                    buildingDamageMultiplier = 0.10f;
                    colors = new Color[]{Color.valueOf("FF0000"), Color.valueOf("7665C9"), Color.valueOf("BD8BD6"), Color.valueOf("000000")};
					//, Color.valueOf("00FFFF")
                    chargeEffect = BMHEffects.purpleBigLaserBeam;
                }};
            }});
			
            hitSize = 17f;
			range = 125f;  
            
			abilities.add(new RegenAbility(){{percentAmount = 0.034f;}});
			//RepairFieldAbility(float amount, float reload, float range)
			abilities.add(new RepairFieldAbility(20f, 10f, 200f));
			//StatusFieldAbility(StatusEffect effect, float duration, float reload, float range)
			abilities.add(new StatusFieldAbility(overdrive, 90f, 100f, 120f));
			
            engineSize = 3f;
			engineOffset = 12f;
			engineColor = Color.valueOf("B40059");
			engineColorInner = Color.valueOf("00E673");
        }};
}}



/**
* @author Yuria 
* mod "New Horizon" v0.5.3
*/
package biomechazard.lib.newhorizon;

import arc.func.Cons;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Mathf;
import arc.math.Rand;
import arc.math.geom.Geometry;
import arc.math.geom.Position;
import arc.math.geom.Rect;
import arc.math.geom.Vec2;
import arc.struct.FloatSeq;
import arc.struct.Seq;
import arc.util.Tmp;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.core.World;
import mindustry.entities.Effect;
import mindustry.entities.Lightning;
import mindustry.entities.Units;
import mindustry.entities.bullet.BulletType;
import mindustry.game.Team;
import mindustry.gen.Building;
import mindustry.gen.Bullet;
import mindustry.gen.Entityc;
import mindustry.gen.Healthc;
import mindustry.graphics.Layer;
import biomechazard.content.BMHSettings;
import biomechazard.lib.newhorizon.NHFx;
import biomechazard.lib.newhorizon.Vec2Seq;

/**
 * Provide methods that can generate Position to Position Lightning.<p>
 * {@code Tmp} <b>var</b> is available.<p>
 * Completely independent class.<p>
 *
 * @implNote The method implements the generation of random lightning effect <b>from point to point</b> and complete certain action at <b>target point</b> through {@link Cons}.<p>
 * @apiNote
 * <li> {@code hitPointMovement} {@link Cons} used to run specific action at the target point.
 * <li> {@code WIDTH}: {@value WIDTH} used to control the stroke of the lightning.
 * <li> {@code RANGE_RAND}: {@value RANGE_RAND} used to control the base xRand range of every part of the lightning.
 * <li> {@code ROT_DST}: {@value ROT_DST} used to control the length of every part of the lightning.<p>
 *
 * @see Position
 * @see Vec2
 * @see Geometry
 * @see Cons
 *
 * @author Yuria
 */
public class PosLightning {
	
	/**Spawns Nothing at the hit point.*/
	public static final Cons<Position> none = p -> {};
	/**Lighting Effect Lifetime.*/
	public static final float lifetime = Fx.chainLightning.lifetime;
	/**Lighting Effect Default Width, apply it manually.*/
	public static final float WIDTH = 2.5f;
	/**Lighting Effect X-Rand.*/
	public static final float RANGE_RAND = 5f;
	/**Lighting Effect Length Between Nodes.*/
	public static final float ROT_DST = Vars.tilesize * 0.6f;
	/**Used for range spawn, make the lightning more random and has smoother spacing.*/
	public static float trueHitChance = 1;
	
	
	/**(0, 1]*/
	public static void setHitChance(float f){
		trueHitChance = f;
	}
	
	/**Must Hit*/
	public static void setHitChanceDef(){
		trueHitChance = 1;
	}
	
	//Lightning's randX. Modify it if needed.
	private static float getBoltRandomRange() {return Mathf.random(1f, 7f); }
	
	
	public static void createEffect(Position from, float length, float angle, Color color, int lightningNum, float width){
		if(Vars.headless)return;
		createEffect(from, tmp2.trns(angle, length).add(from), color, lightningNum, width);
	}
	
	public static void createEffect(Position from, Position to, Color color, int lightningNum, float width){
		if(Vars.headless)return;
		
		if(lightningNum < 1){
			Fx.chainLightning.at(from.getX(), from.getY(), 0, color, new Vec2().set(to));
		}else{
			float dst = from.dst(to);
			
			for(int i = 0; i < lightningNum; i++){
				float len = getBoltRandomRange();
				float randRange = len * RANGE_RAND;
				
				floatSeq.clear();
				FloatSeq randomArray = floatSeq;
				for(int num = 0; num < dst / (ROT_DST * len) + 1; num++){
					randomArray.add(Mathf.range(randRange) / (num * 0.025f + 1));
				}
				createBoltEffect(color, width, computeVectors(randomArray, from, to));
			}
		}
		
	}

	//create lightning effect.
	public static void createBoltEffect(Color color, float width, Vec2Seq vets) {
		if(BMHSettings.enableDetails()){
			vets.each(((x, y) -> {
				if(Mathf.chance(0.0855))NHFx.lightningSpark.at(x, y, rand.random(2f + width, 4f + width), color);
			}));
		}
		posLightning.at((vets.firstTmp().x + vets.peekTmp().x) / 2f, (vets.firstTmp().y + vets.peekTmp().y) / 2f, width, color, vets);
	}
	
	private static Vec2Seq computeVectors(FloatSeq randomVec, Position from, Position to){
		int param = randomVec.size;
		float angle = from.angleTo(to);
		
		Vec2Seq lines = new Vec2Seq(param);
		tmp1.trns(angle, from.dst(to) / (param - 1));
		
		lines.add(from);
		for (int i = 1; i < param - 2; i ++)lines.add(tmp3.trns(angle - 90, randomVec.get(i)).add(tmp1, i).add(from.getX(), from.getY()));
		lines.add(to);
		
		return lines;
	}
}

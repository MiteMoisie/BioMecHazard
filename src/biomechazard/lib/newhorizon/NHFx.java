/**
* @author Yuria 
* mod "New Horizon" v0.5.3
*/
package biomechazard.lib.newhorizon;

import arc.Core;
import arc.graphics.Blending;
import arc.graphics.Color;
import arc.graphics.g2d.*;
import arc.math.Angles;
import arc.math.Interp;
import arc.math.Mathf;
import arc.math.Rand;
import arc.math.geom.Position;
import arc.math.geom.Vec2;
import arc.scene.ui.layout.Scl;
import arc.struct.IntMap;
import arc.util.Time;
import arc.util.Tmp;
import arc.util.pooling.Pools;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.entities.effect.MultiEffect;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.graphics.Trail;
import mindustry.type.UnitType;
import mindustry.ui.Fonts;

import java.util.Arrays;

import static arc.graphics.g2d.Draw.rect;
import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.randLenVectors;
import static mindustry.Vars.state;
import static mindustry.Vars.tilesize;

public class NHFx{
	public static final float EFFECT_MASK = Layer.effect + 0.0001f;
	public static final float EFFECT_BOTTOM = Layer.bullet - 0.11f;
	public static final IntMap<Effect> same = new IntMap<>();
	private static final Rand rand = new Rand();
	private static final Rand rand2 = new Rand();
	private static final Vec2 v = new Vec2();
	private static final int[] oneArr = {1};
	
	public static final float lightningAlign = 0.5f;
	
	public static Effect lightningSpark = new Effect(Fx.chainLightning.lifetime, e -> {
		color(Color.white, e.color, e.fin() + 0.25f);
		stroke(0.65f + e.fout());
		randLenVectors(e.id, 3, e.fin() * e.rotation + 6f, (x, y) -> lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), e.fout() * 4 + 2f));
		Fill.circle(e.x, e.y, 2.5f * e.fout());
	});

}















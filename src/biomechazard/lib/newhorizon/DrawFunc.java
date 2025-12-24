/**
* @author Yuria 
* mod "New Horizon" v0.5.3
*/
package biomechazard.lib.newhorizon;

import arc.Core;
import arc.func.Cons;
import arc.func.Floatc2;
import arc.graphics.Color;
import arc.graphics.g2d.*;
import arc.math.Angles;
import arc.math.Interp;
import arc.math.Mathf;
import arc.math.Rand;
import arc.math.geom.Position;
import arc.math.geom.Vec2;
import arc.scene.ui.layout.Scl;
import arc.struct.Seq;
import arc.util.Time;
import arc.util.Tmp;
import arc.util.pooling.Pools;
import mindustry.Vars;
import mindustry.game.Team;
import mindustry.gen.Building;
import mindustry.gen.Groups;
import mindustry.gen.Teamc;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.ui.Fonts;

import static mindustry.Vars.tilesize;

public class DrawFunc{
    private static float[] vertices = new float[24];
    
    public static final Color bottomColor = Pal.gray;
    public static final float sinScl = 1f;
    public static float NOR_DISTANCE = 600f;
    
    private static final Vec2
        vec21 = new Vec2(),
        vec22 = new Vec2(),
        vec23 = new Vec2();
    
    public static final int[] oneArr = {1};
    
    private static final Seq<Position> pointPos = new Seq<>(Position.class);
    private static final Rand rand = new Rand();
	
	public static final Interp.Pow pow10 = new Interp.Pow(10);
    
    public static void link(Building from, Building to, Color color) {
        float
                sin = Mathf.absin(Time.time * sinScl, 6f, 1f),
                r1 = from.block.size / 2f * tilesize + sin,
                x1 = from.getX(), x2 = to.getX(), y1 = from.getY(), y2 = to.getY(),
                r2 = to.block.size / 2f * tilesize + sin;

        Draw.color(color);

        Lines.square(x2, y2, to.block.size * tilesize / 2f + 1.0f);

        Tmp.v1.trns(from.angleTo(to), r1);
        Tmp.v2.trns(to.angleTo(from), r2);
        int signs = (int) (from.dst(to) / tilesize);

        Lines.stroke(4, Pal.gray);
        Lines.dashLine(x1 + Tmp.v1.x, y1 + Tmp.v1.y, x2 + Tmp.v2.x, y2 + Tmp.v2.y, signs);
        Lines.stroke(2, color);
        Lines.dashLine(x1 + Tmp.v1.x, y1 + Tmp.v1.y, x2 + Tmp.v2.x, y2 + Tmp.v2.y, signs);

        Drawf.arrow(x1, y1, x2, y2, from.block.size * tilesize / 2f + sin, 4 + sin, color);

        Drawf.circles(x2, y2, r2, color);
    }

    public static void posSquareLinkArr(Color color, float stroke, float size, boolean drawBottom, boolean linkLine, Position... pos){
        if(pos.length < 2 || (!linkLine && pos[0] == null))return;
        
        for (int c : drawBottom ? Mathf.signs : oneArr) {
            for (int i = 1; i < pos.length; i++) {
                if (pos[i] == null)continue;
                Position p1 = pos[i - 1], p2 = pos[i];
                Lines.stroke(stroke + 1 - c, c == 1 ? color : bottomColor);
                if(linkLine) {
                    if(p1 == null)continue;
                    Lines.line(p2.getX(), p2.getY(), p1.getX(), p1.getY());
                }else{
                    Lines.line(p2.getX(), p2.getY(), pos[0].getX(), pos[0].getY());
                }
                Draw.reset();
            }

            for (Position p : pos) {
                if (p == null)continue;
                Draw.color(c == 1 ? color : bottomColor);
                Fill.square(p.getX(), p.getY(), size + 1 -c / 1.5f, 45);
                Draw.reset();
            }
        }
    }
    
    public static void posSquareLink(Color color, float stroke, float size, boolean drawBottom, float x, float y, float x2, float y2){
        posSquareLink(color, stroke, size, drawBottom, vec21.set(x, y), vec22.set(x2, y2));
    }

    public static void posSquareLink(Color color, float stroke, float size, boolean drawBottom, Position from, Position to){
        posSquareLinkArr(color, stroke, size, drawBottom, false, from, to);
    }
    
    public static float rotator_90(float in /*(0, 1)*/, float margin){
        return 90 * pow10.apply(Mathf.curve(in, margin, 1 - margin));
    }
    
    public static float rotator_90(){return 90 * Interp.pow5.apply(Mathf.curve(cycle_100(), 0.15f, 0.85f));}
    
    public static float cycle_100(){return Time.time % 100 / 100;}
}

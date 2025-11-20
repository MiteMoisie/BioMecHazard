package biomechazard.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import mindustry.entities.*;
import mindustry.graphics.*;
import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;


public class BMHVisualEffects {
	public static Effect
	
	purpleLaserChargeBig = new Effect(40f, 100f, e -> {
        color(Color.valueOf("8B73C7"));
        stroke(e.fin() * 2f);
        Lines.circle(e.x, e.y, e.fout() * 50f);
    }).followParent(true).rotWithParent(true);
}

package biomechazard.content;

import arc.*;
import arc.struct.*;
import mindustry.content.SectorPresets;
import mindustry.game.Objectives.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.TechTree.*;
import static mindustry.content.SectorPresets.*;

public class BMHTechtree {
    public static void load(){
        nodeRoot("BioMecHazard", coreShard, false, () -> {
			node(BMHBlocks.coreNethrax, Seq.with(new SectorComplete(biomassFacility)));
		});
	};
};

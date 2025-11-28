package biomechazard.content.blocks;

import mindustry.world.*;

public class BMHTechtreeNode extends Block{
	public BMHTechtreeNode(String name){
        super(name);
        buildVisibility = hidden;
		alwaysUnlocked = true;
		hideDatabase = true;
		health = 0;
		size = 1;
    }
}
package biomechazard.content.blocks;

import arc.struct.Seq;
import mindustry.content.*;
import mindustry.type.*;
import mindustry.type.Category;
import mindustry.world.*;
import mindustry.world.blocks.units.*;
//import mindustry.world.blocks.units.UnitFactory.UnitPlan;
import biomechazard.content.*;

import static mindustry.type.ItemStack.*;

public class FRBlocksAttack{
	public static Block 
		unitRepairField, primaryFactory, basicReassemblyChamber, advancedReassemblyChamber, progressiveReassemblyChamber;
	
	public static void load(){
		
		unitRepairField = new RepairTower("unit-repair-field"){{
            requirements(Category.units, with(Items.graphite, 110, Items.silicon, 110, Items.titanium, 100));
            size = 2;
            range = 100f;
            healAmount = 1.5f;
            consumePower(7f);
            consumeLiquid(Liquids.cryofluid, 0.18f);
        }};
		
		primaryFactory = new UnitFactory("primary-factory"){{
            requirements(Category.units, with(Items.copper, 90, Items.lead, 110, Items.silicon, 40, Items.metaglass, 60));
            plans = Seq.with(
                new UnitPlan(FRUnitTypes.seed, 2400f, with(Items.silicon, 30, Items.lead, 30)),
                new UnitPlan(FRUnitTypes.lancerDrone, 1200f, with(Items.silicon, 15, Items.lead, 15)),
                new UnitPlan(FRUnitTypes.mela, 3000f, with(Items.silicon, 30, Items.metaglass, 45)),
                new UnitPlan(FRUnitTypes.apis, 1200f, with(Items.silicon, 15, Items.lead, 15)),
                new UnitPlan(FRUnitTypes.alba, 3600f, with(Items.silicon, 25, Items.metaglass, 30, Items.titanium, 25)),
                new UnitPlan(FRUnitTypes.annax, 2400f, with(Items.silicon, 30, Items.lead, 20, Items.scrap, 40)),
                new UnitPlan(FRUnitTypes.sambuca, 3000f, with(Items.silicon, 40, Items.lead, 30, Items.titanium, 20)),
                new UnitPlan(FRUnitTypes.aedes, 1600f, with(Items.silicon, 30, Items.lead, 20, Items.graphite, 20))
            );
            size = 3;
            consumePower(1.2f);
        }};

        basicReassemblyChamber = new Reconstructor("basic-reassembly-chamber"){{
            requirements(Category.units, with(Items.copper, 500, Items.lead, 800, Items.silicon, 700, Items.titanium, 800));
            size = 5;
			health = 1550;
            consumePower(0.8f);
            consumeItems(with(Items.silicon, 300, Items.graphite, 120, Items.titanium, 180, Items.metaglass, 100));
            constructTime = 3600f;
            upgrades.addAll(
                new UnitType[]{FRUnitTypes.seed, FRUnitTypes.sapling},
                new UnitType[]{FRUnitTypes.lancerDrone, FRUnitTypes.closeRange},
                new UnitType[]{FRUnitTypes.mela, FRUnitTypes.cromis},
                new UnitType[]{FRUnitTypes.apis, FRUnitTypes.procer},
                new UnitType[]{FRUnitTypes.alba, FRUnitTypes.arvens},
                new UnitType[]{FRUnitTypes.annax, FRUnitTypes.scofra},
                new UnitType[]{FRUnitTypes.sambuca, FRUnitTypes.scorpio},
                new UnitType[]{FRUnitTypes.aedes, FRUnitTypes.armiger}
            );
        }};

        advancedReassemblyChamber = new Reconstructor("advanced-reassembly-chamber"){{
            requirements(Category.units, with(Items.copper, 500, Items.lead, 800, Items.silicon, 700, Items.titanium, 800));
            size = 9;
			health = 3400;
            consumePower(13.3333333333333f);
            consumeItems(with(Items.silicon, 1000, Items.titanium, 900, Items.plastanium, 720));
            consumeLiquid(BMHLiquids.neutronFluid, 0.4f);
            constructTime = 6000f;
            upgrades.addAll(
                new UnitType[]{FRUnitTypes.sapling, FRUnitTypes.plant},
                new UnitType[]{FRUnitTypes.closeRange, FRUnitTypes.kestrel},
                new UnitType[]{FRUnitTypes.cromis, FRUnitTypes.arnux},
                new UnitType[]{FRUnitTypes.procer, FRUnitTypes.ducalis},
                new UnitType[]{FRUnitTypes.arvens, FRUnitTypes.aestiva},
                new UnitType[]{FRUnitTypes.scofra, FRUnitTypes.auratus},
                new UnitType[]{FRUnitTypes.scorpio, FRUnitTypes.springald},
                new UnitType[]{FRUnitTypes.armiger, FRUnitTypes.onirion}
            );
        }};

        progressiveReassemblyChamber = new Reconstructor("progressive-reassembly-chamber"){{
            requirements(Category.units, with(Items.copper, 500, Items.lead, 800, Items.silicon, 700, Items.titanium, 800));
            size = 13;
			health = 7200;
            consumePower(30f);
            consumeItems(with(Items.silicon, 800, BMHItems.livingSteel, 600, Items.plastanium, 660, Items.surgeAlloy, 550, Items.phaseFabric, 450));
            consumeLiquid(BMHLiquids.neutronFluid, 0.8f);
            constructTime = 21600f;
            upgrades.addAll(
                new UnitType[]{FRUnitTypes.plant, FRUnitTypes.corax},
                new UnitType[]{FRUnitTypes.kestrel, FRUnitTypes.sps},
                new UnitType[]{FRUnitTypes.arnux, FRUnitTypes.japonica},
                new UnitType[]{FRUnitTypes.ducalis, FRUnitTypes.hive},
                new UnitType[]{FRUnitTypes.aestiva, FRUnitTypes.altaic},
                new UnitType[]{FRUnitTypes.auratus, FRUnitTypes.test},
                new UnitType[]{FRUnitTypes.springald, FRUnitTypes.onager},
                new UnitType[]{FRUnitTypes.onirion, FRUnitTypes.culiseta}
            );
        }};
		
	}
}
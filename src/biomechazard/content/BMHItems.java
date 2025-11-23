package biomechazard.content;

import arc.graphics.Color;
import mindustry.type.Item;
import biomechazard.audiovisual.UAWPal;

/*
** Objets issus du mod "Unlimited Armament Works" : cryogel dieselCore stoutsteel anthracite phlogistonCrystal sulphur
** 	emptyBulletCasing standardBullet incendiaryBullet cryoBullet armourPiercingBullet spreadShotBullet explosiveBullet arcBullet
** 	emptyMineCanister standardMineCanister incendiaryMineCanister cryoMineCanister antiAirMineCanister sporeMineCanister empMineCanister nukeMineCanister
** Objets issus du mod "Fading Revelations" : gold steelAmalgam uraniumRod livingSteel hardenedLivingSteel cryogenicAlloy cryogenicAlloy cryogenicGel igneousAlloy
**  copperAmmo titaniumAmmo explosiveAmmo healingAmmo homingAmmo nanoAmmo nuke
*/
public class BMHItems {
	public static Item 
		// Manufacturé
		cryogel, dieselCore, steelAmalgam, cryogenicAlloy, cryogenicAlloy, cryogenicGel, igneousAlloy, 
		// Métal
		stoutsteel, titaniumCarbide, gold, livingSteel, hardenedLivingSteel, 
		// Cristal
		anthracite, phlogistonCrystal,
		// Naturel
		sulphur,
		// Douille vide
		emptyBulletCasing, emptyMineCanister,

		// Munition
		standardBullet, incendiaryBullet, cryoBullet, armourPiercingBullet, spreadShotBullet, explosiveBullet, arcBullet, 
		copperAmmo, titaniumAmmo, explosiveAmmo, healingAmmo, homingAmmo, nanoAmmo, nuke, 

		// Mine Canister
		standardMineCanister, incendiaryMineCanister, cryoMineCanister, antiAirMineCanister, sporeMineCanister, empMineCanister, nukeMineCanister;
	
	public static void load() {
		cryogel = new Item("cryogel", UAWPal.cryoMiddle) {{
			flammability = -10f;
			explosiveness = 0f;
		}};
		stoutsteel = new Item("stoutsteel", UAWPal.stoutSteelMiddle) {{
			cost = 2.5f;
		}};
		anthracite = new Item("anthracite", Color.valueOf("272727")) {{
			flammability = Items.coal.flammability * 1.8f;
			explosiveness = Items.coal.explosiveness / 2;
			hardness = 4;
		}};
		gold = new Item("gold", Color.valueOf("FFD700")) {{
			cost = 2.5f;
			hardness = 3;
		}};
		steelAmalgam = new Item("steel-alloy", Color.valueOf("ba6a83")) {{
			flammability = 0.6;
			explosiveness = 0.2;
			charge = 0.9;
		}};
		uraniumRod = new Item("uranium-rod", Color.valueOf("22b400")) {{
			cost = 2.5f;
			flammability = 0.1;
			explosiveness = 0.2;
			radioactivity = 2;
		}};
		livingSteel = new Item("living-steel", Color.valueOf("88299f")) {{
			cost = 2.5f;
			hardness = 3;
			flammability = 0.5;
			frames = 5;
			frameTime = 0.5;
		}};
		hardenedLivingSteel = new Item("living-steel-hard", Color.valueOf("6d59c6")) {{
			cost = 2.5f;
			hardness = 4;
			flammability = 0.3;
			radioactivity = 0.2;
		}};
		cryogenicAlloy = new Item("cryogenic-alloy", Color.valueOf("2cbcc9")) {{
			cost = 1.4;
			hardness = 5;
			charge = 0.45;
		}};
		cryogenicGel = new Item("cryogenic-gel", Color.valueOf("4fa4c0")) {{
			hardness = 0.4;
		}};
		igneousAlloy = new Item("igneous-alloy", Color.valueOf("e48c57")) {{
			cost = 1.3;
			hardness = 3.5;
			charge = 0.55;
		}};
		
		copperAmmo = new Item("ammo-level-1", Color.valueOf("9d7600")) {{
			cost = 2.5f;
			hardness = 4;
			flammability = 0.1;
			explosiveness = 0.1;
		}};
		titaniumAmmo = new Item("ammo-level-2", Color.valueOf("002b92")) {{
			cost = 2.5f;
			hardness = 6;
			flammability = 0.1;
			explosiveness = 0.3;
		}};
		explosiveAmmo = new Item("ammo-level-3", Color.valueOf("df0505")) {{
			cost = 2.5f;
			hardness = 3;
			flammability = 0.3;
			explosiveness = 0.6;
		}};
		healingAmmo = new Item("heal-ammo", Color.valueOf("77df05")) {{
			cost = 2.5f;
			hardness = 0.1;
			flammability = 0.2;
			explosiveness = 0.05;
		}};
		homingAmmo = new Item("homing-ammo", Color.valueOf("df21fa")) {{
			cost = 2.5f;
			hardness = 1;
			flammability = 0.2;
			explosiveness = 1.2;
			radioactivity = 0.3;
		}};
		nanoAmmo = new Item("nano-ammo", Color.valueOf("6e0268")) {{
			cost = 2.5f;
			hardness = 0.5;
			flammability = 0.6;
			explosiveness = 0.1;
		}};
		nuke = new Item("nuke", Color.valueOf("22b400")) {{
			hardness = 5;
			flammability = 0.5;
			explosiveness = 2;
			radioactivity = 2;
		}};
		
		sulphur = new Item("sulphur", Color.valueOf("e28654")) {{}};
		titaniumCarbide = new Item("titanium-carbide", Color.valueOf("919fe7")) {{}};
		
		emptyBulletCasing = new Item("bullet-empty", Color.valueOf("989aa4")) {{}};
		emptyMineCanister = new Item("mine-empty", Color.valueOf("989aa4")) {{}};

		standardBullet = new Item("bullet-basic", Color.valueOf("eab678")) {{}};
		incendiaryBullet = new Item("bullet-incendiary", Color.valueOf("e48c57")) {{}};
		cryoBullet = new Item("bullet-cryo", UAWPal.cryoMiddle) {{}};
		armourPiercingBullet = new Item("bullet-ap", Color.valueOf("ebeef5")) {{}};
		spreadShotBullet = new Item("bullet-spreadshot", Color.valueOf("646469")) {{}};
		explosiveBullet = new Item("bullet-explosive", Color.valueOf("e46b58")) {{}};
		arcBullet = new Item("bullet-arc", UAWPal.lancerLaser) {{}};

		standardMineCanister = new Item("mine-basic", Color.valueOf("eab678")) {{}};
		incendiaryMineCanister = new Item("mine-incendiary", Color.valueOf("e48c57")) {{}};
		cryoMineCanister = new Item("mine-cryo", UAWPal.cryoMiddle) {{}};
		antiAirMineCanister = new Item("mine-aa", Color.valueOf("cbd97f")) {{}};
		sporeMineCanister = new Item("mine-spore", Color.valueOf("7457ce")) {{}};
		empMineCanister = new Item("mine-emp", Color.valueOf("6974c4")) {{}};
		nukeMineCanister = new Item("mine-nuke", Color.valueOf("706f74")) {{}};
	}
	

}

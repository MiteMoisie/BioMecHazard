/**
* @author Anuken
* Ce code a été retiré dans les dernières versions de Mindustry. Il est réintégré car utilisé par le mod "Unlimited Armament Works"
*/

package mindustry.ui;

import arc.graphics.g2d.*;
import arc.scene.ui.*;
import arc.scene.ui.layout.*;
import arc.util.*;
import mindustry.core.*;
import mindustry.type.*;

public class ItemImage extends Stack{

    public ItemImage(TextureRegion region, int amount){

        add(new Table(o -> {
            o.left();
            o.add(new Image(region)).size(32f).scaling(Scaling.fit);
        }));

        if(amount != 0){
            add(new Table(t -> {
                t.left().bottom();
                t.add(amount >= 1000 ? UI.formatAmount(amount) : amount + "").style(Styles.outlineLabel);
                t.pack();
            }));
        }
    }

    public ItemImage(ItemStack stack){
        this(stack.item.uiIcon, stack.amount);
    }

    public ItemImage(PayloadStack stack){
        this(stack.item.uiIcon, stack.amount);
    }
}

package tilegame.inventory;

import gfx.Assets;
import gfx.Text;
import tilegame.Handler;
import tilegame.items.Item;

import java.awt.*;
import java.util.ArrayList;

public class Inventory {

    private Handler handler;
    private boolean active = false;
    private ArrayList<Item> inventoryItems;

    private int invX = 64, invY = 48,
        invWight = 1000, invHeight = 700,
        invListcentX = invX + 380,
        invListcentY = invY + 318,
        invListSpacing = 25;

    private int invImageX = 590, invImageY = 230,
            invImageWidth = 50, invImageHeight = 50;

    private int invCountX = 615, invCountY = 308;

    private int selectedItem = 0;

    public Inventory(Handler handler){
        this.handler = handler;
        inventoryItems = new ArrayList<Item>();
        //aici pot adauga lucruri initiale in inventory


    }
    public void tick()
    {
        if(handler.getKeyManager().e)
            active = !active;
        if(!active)
            return;

        if(handler.getKeyManager().up)
            selectedItem--;
        if(handler.getKeyManager().down)
            selectedItem++;

        if(selectedItem<0)
            selectedItem = inventoryItems.size() -1;
        else if(selectedItem>=inventoryItems.size())
            selectedItem = 0;
    }
    public void render(Graphics g){
        if(!active)
            return;
        g.drawImage(Assets.inventoryscreen, invX,invY,invWight,invHeight,null);

        int len = inventoryItems.size();
        if(len == 0)
            return;

        for(int i = -5 ;i<6; ++i)
        {
            if(selectedItem +i <0 || selectedItem +i>=len)
                continue;
            if(i == 0){
                Text.drawString(g,">" + inventoryItems.get(selectedItem +i ).getName() +" <",invListcentX,invListcentY +i*invListSpacing,true,Color.yellow,Assets.font30);

            }else{
                Text.drawString(g,inventoryItems.get(selectedItem +i ).getName() ,invListcentX,invListcentY +i*invListSpacing,true,Color.white,Assets.font30);

            }

        }
        Item item = inventoryItems.get(selectedItem);
        g.drawImage(item.getTexture(),invImageX,invImageY,invImageWidth,invImageHeight,null);
        Text.drawString(g,Integer.toString(item.getCount()),invCountX,invCountY,true,Color.white,Assets.font30);
    }
    //metoda cu care adaug cehstii in inventory

    public void adderItem(Item item) {
        for(Item i:inventoryItems)
            if(i.getId() == item.getId()){
                i.setCount(i.getCount() + item.getCount());
                return;
            }
        inventoryItems.add(item);
    }
        //Getters and setters
    public Handler getHandler() {
        return handler;

    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

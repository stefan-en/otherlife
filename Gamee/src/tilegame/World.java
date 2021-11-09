package tilegame;

import creatures.Enemy_b;
import creatures.Enemy_f;
import creatures.Player;
import entities.EntityManager;
import tilegame.items.ItemManager;
import tilegame.tile.Tile;
import tilegame.utils.Utils;

import java.awt.*;
import java.util.Random;

public class World {

    private Handler handler;
    private int width, height;
    private int spwnX,spwnY;

    private int [][] tiles;

    //Entities

    private final EntityManager entityManager;

    //Items
    private ItemManager itemManager;

    public World(Handler handler, String path)
    {
        //adaug playerul si entitatatile inamice
        //1
        int tip = new Random().nextInt(2);//0 fata //1 baiat
        this.handler = handler;
        Player.setInstance(handler,100,100);
        entityManager = new EntityManager(handler,Player.getInstance());
        if(tip == 0)

            entityManager.addEntity(new Enemy_b(handler, 700, 776));
        else
            entityManager.addEntity(new Enemy_f(handler, 700, 776));

        tip = new Random().nextInt(2);//0 fata //1 baiat
        if(tip == 0)

            entityManager.addEntity(new Enemy_b(handler, 1000, 776));
        else
            entityManager.addEntity(new Enemy_f(handler, 1000, 776));

        //2
        if(tip == 0)

            entityManager.addEntity(new Enemy_b(handler, 730, 480));
        else
            entityManager.addEntity(new Enemy_f(handler, 730, 480));

        tip = new Random().nextInt(2);//0 fata //1 baiat



        //3
        if(tip == 0)

            entityManager.addEntity(new Enemy_b(handler, 700, 180));
        else
            entityManager.addEntity(new Enemy_f(handler, 700, 180));

        tip = new Random().nextInt(2);//0 fata //1 baiat
        if(tip == 0)

            entityManager.addEntity(new Enemy_b(handler, 330, 180));
        else
            entityManager.addEntity(new Enemy_f(handler, 330, 180));


        itemManager = new ItemManager(handler);

        loadWorld(path);//aici apelez funcatia care incarca niveleul
        //aici setez locul unde apare jucatorul
        setSpwnX(100);
        setSpwnY(800);
        entityManager.getPlayer().setX(spwnX);
        entityManager.getPlayer().setY(spwnY);

    }

    public void tick()//metoda  de update
    {
        entityManager.tick();
        itemManager.tick();
    }
    public void render(Graphics g) {

        //metoda de ranndare a hartii de
        // practic un dreptunghi pe  care il parcurg s populez cu tile uri
        //desenez si entitatile si itmem
        int xstart = (int) Math.max(0,handler.getGameCamera().getxOffset()/Tile.TILEWIDTH);
        int xend = (int)Math.min(width,(handler.getGameCamera().getyOffset()+ handler.getWidth())/Tile.TILEWIDTH+1);
        int ystart = (int) Math.max(0,handler.getGameCamera().getyOffset()/Tile.TILEHEIGHT);
        int yend = (int)Math.min(height,(handler.getGameCamera().getyOffset()+ handler.getHeight())/Tile.TILEHEIGHT+1);

        for (int y = ystart; y < yend; ++y) {
            for (int x= xstart; x < xend; ++x)
            {
                getTile(x,y).render(g,(int)(x* Tile.TILEWIDTH-handler.getGameCamera().getxOffset()),(int)(y*Tile.TILEHEIGHT-handler.getGameCamera().getyOffset()));
            }
        }
        //items
        itemManager.render(g);
        //entities

        entityManager.render(g);
    }
    public Tile getTile(int x, int y)
    {
        if(x<0|| y<0|| x>=width||y>=height)
            return Tile.bgrTile;
        Tile t = Tile.tiles[tiles[x][y]];
        if(t ==null)
            return Tile.ConturTile;
        return  t;
    }
    private void loadWorld(String path)
    {
        //citesc niveleul din fisier, locul de unde incepe randarea si dimensiunile
        String file = Utils.loadFile(path);
        String[] tokens = file.split("\\s+");

        width = Utils.goInt(tokens[0]);
        height = Utils.goInt(tokens[1]);
        spwnX = Utils.goInt(tokens[2]);
        spwnY = Utils.goInt(tokens[3]);

        tiles = new int[width][height];

        for(int y = 0;y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                tiles[x][y] = Utils.goInt(tokens[(x + y * width) + 4]);
            }
        }
    }
    //diferite settere si gettere ptr atributele din clasa
    public int getWidth()
    {
        return this.width;
    }
    public int getHeight()
    {
        return this.height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setSpwnX(int spwnX) {
        this.spwnX = spwnX;
    }

    public void setSpwnY(int spwnY) {
        this.spwnY = spwnY;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }
}

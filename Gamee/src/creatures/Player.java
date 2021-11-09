package creatures;

import entities.Entity;
import gfx.Assets;
import states.MeniuState;
import states.State;
import tilegame.Animation;
import tilegame.Handler;
import tilegame.inventory.Inventory;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {
    //Animatie ptr erou
    private final Animation animWalk_r, animAtk_r, animSt_r, animWalk_l, anim_jump_left,animAtk_l,animSt_l,anim_jump_right;
    //1 spre stanga 0 spre dreapta
    private boolean directie;
    //Attack time
    private long lastAttackTime, atkColldown = 30,atkime = atkColldown;
    //Inventariu
    private Inventory inventory;
    //for jump jump
    private int timer = 0;
    final int max_h = 20;
    //false daca nu sar
    private boolean salt = false;
    //end jump
    private int score;
    //scor

    //singleton
    private static Player instance = null;

    public static void setInstance(Handler handler, float x, float y) {
        instance = new Player(handler,x,y);
    }

    public static Player getInstance() {
        return instance;
    }

    private Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.handler = handler;

        //scor
        score = 0;

        //dreptunghiul care imi produce coliziunea cu obiectele din jur
        bounds.x = 10;
        bounds.y = 10;
        bounds.width = 55;
        bounds.height = 110;

        //Animatiile
        animWalk_r = new Animation(50, Assets.player_walk);
        animWalk_l = new Animation(50, Assets.player_left);
        animAtk_r = new Animation(50, Assets.player_atk);
        animSt_r = new Animation(50, Assets.player_state);
        anim_jump_left = new Animation(50, Assets.player_jump_l);
        animAtk_l = new Animation(50,Assets.player_atk_l);
        animSt_l = new Animation(50,Assets.player_state_right);
        anim_jump_right = new Animation(50,Assets.player_jump_r);

        inventory = new Inventory(handler);
    }

    @Override//actualizare
    public void tick() {
        //Animation
        animWalk_r.tick();
        animWalk_l.tick();
        animAtk_r.tick();
        animSt_r.tick();
        anim_jump_left.tick();
        anim_jump_right.tick();
        animAtk_l.tick();
        animSt_l.tick();
        //Miscarea de la tastatura
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        //apelul metodei de verificare atack
        checkAttacks();
        //metoda inventori
        inventory.tick();
        if(getInstance().health <3){
            State.setState(new MeniuState(handler));
            health = 3;

            setX(100);
            setY(800);
        }
        if(getInstance().score>=5)
            State.setState(new MeniuState(handler));
        if(getInstance().y>900)
            State.setState(new MeniuState(handler));

    }
    private void checkAttacks()
    {
        //liniteaza un anumit numar de atacuri
        atkime +=System.currentTimeMillis() - lastAttackTime;
        lastAttackTime = System.currentTimeMillis();
        if(atkime<atkColldown)
            return;

        if(inventory.isActive())
            return;
        //in functie de coliziunea playerului cu obiectele pot sa atac in sensul ultimei directii
        Rectangle cb = getCollisionBounds(0,0);
        Rectangle ar = new Rectangle();
        int arSize = 50;
        ar.width = arSize;
        ar.height = arSize;

        if(handler.getKeyManager().k && directie) {
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height/2 - arSize/2;
        }else if(handler.getKeyManager().k&& !directie)
        {
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height/2 - arSize/2;
        }
        atkime = 0;
        //verific daca am coliziune si daca am, obiectului ii scade health
        for(Entity e:handler.getWorld().getEntityManager().getEntities())
        {
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0,0).intersects(ar))
                e.hurt(3);

        }

    }
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    @Override
    public void die()
    {
        if(getInstance().health < 3)
        System.out.println("You lose");
        //System.exit(0);
    }
    // intrarea de la tastatura si ce se intampla la apasarea diferitor taste
    private void getInput() {
        if(inventory.isActive())
            return;
        xMove = 0;
        yMove = 2*speed;

        if (handler.getKeyManager().space && !salt) {
            salt = true;
            timer = 0;
            yMove = -2*speed;

        }
        if (handler.getKeyManager().down)
            yMove = 2*speed;
        if (handler.getKeyManager().left) {
            xMove = -speed;
            directie = true;
        }
        if (handler.getKeyManager().right) {
            xMove = speed;
            directie = false;
        }
        if(salt  && timer < max_h) {
            ++timer;
            yMove = -2*speed;
        }
        else if(salt  && timer>=max_h) {
            salt = false;
            yMove = 2*speed;


        }
    }

    @Override
    public void render(Graphics g) {
        //ajutor pentru coliziuni
        // g.setColor(Color.BLACK);
       // g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),(int)(y + bounds.y - handler.getGameCamera().getyOffset()),bounds.width, bounds.height);

        //imi deseneaza animatia returnata mai jos
        g.drawImage(getCurrentAnimationFrame(),(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()),width,height,null);
    }
    public void postRender(Graphics g)
    {
        inventory.render(g);


    }


    //metoda ce imi returenaza animatia ce ar trebui sa se incarce la apasarea unei taste
    private BufferedImage getCurrentAnimationFrame() {


        if (xMove < 0) {
            return animWalk_l.getCurrentFrames();
        }
        if (xMove > 0) {

            return animWalk_r.getCurrentFrames();
        }

        if (handler.getKeyManager().space)  {
            if(!directie)
                return anim_jump_left.getCurrentFrames();
            else
                return anim_jump_right.getCurrentFrames();

        }

        if (handler.getKeyManager().k) {
            if (!directie)
                return animAtk_r.getCurrentFrames();
            else
                return animAtk_l.getCurrentFrames();
        }
        if (!directie) {
            return animSt_r.getCurrentFrames();
        } else {
            return animSt_l.getCurrentFrames();
        }


    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

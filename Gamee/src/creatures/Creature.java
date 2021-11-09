package creatures;

import entities.Entity;
import tilegame.Handler;
import tilegame.tile.Tile;



public abstract class Creature extends Entity {

        public static final float DEFAULT_SPEED = 2.5f;
        public static final int DEFAULT_CREATURE_WIDTH = 85;
        public static final int DEFAULT_CREATURE_HEIGHT = 120;


    protected  float speed;
    protected  float xMove, yMove;

        public Creature(Handler handler, float x, float y, int width, int height){
            super(handler,x,y,width,height);
            speed = DEFAULT_SPEED;
            xMove = 0;
            yMove = 0;
        }
        // coliziunea cu obiectele din jur
        //Verificare coliziune alte entitati
        public void move()
        {
            if(!checkEntityCollision(xMove,0f))
            moveX();
            if(!checkEntityCollision(0f,yMove))
            moveY();


        }
        //coliziune erou cu obiecte pe axa x
        public void moveX(){
            if(xMove > 0){//muta dreapta
                int tx = (int) (x + xMove + bounds.x + bounds.width)/ Tile.TILEWIDTH;
                if((collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) ||
                        collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) && handler.getWorld().getTile((int)x,(int)y).doesDamage()) {
                    health--;
                    x+= xMove;
                }
                else if(!collisionWithTile(tx,(int)(y+bounds.y)/Tile.TILEHEIGHT) &&
                        !collisionWithTile(tx, (int)(y+bounds.y +bounds.height)/Tile.TILEHEIGHT) && !handler.getWorld().getTile((int)x,(int)y).doesDamage()){
                    x+= xMove;
                }else
                {
                    x = tx *Tile.TILEWIDTH - bounds.x - bounds.width -1;
                }

            }else if(xMove < 0) {//muta stanga
                int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
                 if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                        !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)&& !handler.getWorld().getTile((int)x,(int)y).doesDamage()) {
                    x += xMove;
                }else
                {
                    x = tx *Tile.TILEWIDTH - bounds.x +Tile.TILEWIDTH;
                }
            }

        }
    //coliziune erou cu obiecte pe axa y
        public void moveY() {
            if (yMove < 0) {//in sus
                int fx = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;

                 if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, fx) &&
                        (!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, fx))&& !handler.getWorld().getTile((int)x,(int)y).doesDamage())
                    y += yMove;
                else {
                    y = fx * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
                }
            } else if (yMove > 0) {//in jos
                int fx = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
                if((collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, fx) ||
                        (collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, fx))) && handler.getWorld().getTile((int)x,(int)y).doesDamage()) {
                    health--;
                    y+= yMove;
                }
                else if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, fx) &&
                        (!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, fx))&& !handler.getWorld().getTile((int)x,(int)y).doesDamage())
                    y += yMove;

                else {
                    y = fx * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
                }


            }
        }
        //coliziune cu diferite tile uri care sunt solid
        protected boolean collisionWithTile(int x, int y)
        {
            return handler.getWorld().getTile(x,y).isSolid();
        }


    //SETers and GEters

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}

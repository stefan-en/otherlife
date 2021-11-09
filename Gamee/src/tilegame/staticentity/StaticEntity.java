package tilegame.staticentity;

import entities.Entity;
import tilegame.Handler;
//creez itmeple care o sa fie drop
public abstract class StaticEntity extends Entity {
    public StaticEntity(Handler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);
    }


}

package tilegame.tile;

import gfx.Assets;

public class jigsaw extends Tile{
    public jigsaw(int id){super(Assets.jigsaw,id);}

    @Override
    public boolean isSolid() {
        return false;
    }
}

package tilegame.tile;

import gfx.Assets;

public class tepi extends Tile{
    public tepi(int id){super(Assets.tepi,id);}

    @Override
    public boolean isSolid() {
        return false;
    }
}

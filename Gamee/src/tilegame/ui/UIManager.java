package tilegame.ui;

import tilegame.Handler;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
// clasa pentru un buton si lista de buoane
public class UIManager {

    private Handler handler;
    private ArrayList<UIObject> objects;
    private static Font font;

    public UIManager(Handler handler)
    {
        this.handler = handler;
        objects = new ArrayList<UIObject>();
        font = new Font("Arial",Font.BOLD,24);
    }
    public void tick()
    {
        for(UIObject o: objects)
            o.tick();

    }
    public void render(Graphics g)
    {
        for(UIObject o: objects)
            o.render(g);

    }
    public void onMouseMove(MouseEvent e)
    {
        for(UIObject o: objects)
            o.onMouseMove(e);

    }
    public void onMouseRelease(MouseEvent e){
        for(UIObject o: objects)
            o.onMouseRelease(e);

    }
    public void addObject(UIObject o)
    {
        objects.add(o);

    }
    public void removeObject(UIObject o)
    {
        objects.remove(o);
    }


    //Getters and setters

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<UIObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<UIObject> objects) {
        this.objects = objects;
    }

    public static Font getFont() {
        return font;
    }
}

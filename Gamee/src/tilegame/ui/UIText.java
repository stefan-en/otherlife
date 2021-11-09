package tilegame.ui;

import java.awt.*;
//clasa cu ajutorul creia desenez pe ecran anumete chestii, in cazul meu vietile si scorul
public abstract class UIText extends UIObject{
    private int size;
    private String text;

    public UIText(float x, float y, String text, int size) {
         super(x, y,1,1);
         this.text = text;
         this.size = size;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(UIManager.getFont().deriveFont((float)size));
        g.drawString(text,(int)x,(int)y);
    }

    @Override
    public void onClick() {

    }

    public void setText(String text) {
        this.text = text;
    }
}

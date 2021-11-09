package tilegame;

import display.Display;
import gfx.Assets;
import gfx.GameCamera;
import states.GameState;
import states.MeniuState;
import states.State;
import tilegame.input.KeyManager;
import tilegame.input.MouseManager;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;

public class Game implements  Runnable {

    private Display display;
    private final int  width, height;
    public String title;

    private boolean running = false;
    private  Thread thread;

    private BufferStrategy bs;
    private Graphics g;


    //STATE GAME
    public State gameState;
    public State meniuState;

    //Intrarea de la tastatura+mouse
    private KeyManager keyManager;
    private MouseManager mouseManager;

    // Camera
    private GameCamera gameCamera;

    //Handler
    private Handler handler;


    public Game(String title, int width, int height)
    {
        this.width= width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();

    }
    //initiaza fereastra
    private void init() throws IOException, FontFormatException {
        display = new Display(title,width,height);//creez fereastra jocului

        //adaug intrarea de la  tastatura
        display.getFrame().addKeyListener(keyManager);
        //adaug intrarea de la  mouse
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);

        Assets.init();

        handler = new Handler(this);
        gameCamera = new GameCamera(handler,0,0);

        //creez stari?
        gameState = new GameState(handler);
        meniuState = new MeniuState(handler);

        //setez meniul jocului
        State.setState(meniuState);



    }
    private void tick()
    {
        keyManager.tick();

        if(State.getState() != null)
            State.getState().tick();
    }
    //utilizare la randarea imaginii
    private  void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null)
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        // ecran curat
        g.clearRect(0, 0 ,width, height);
        //aici incepe desenarea

        if(State.getState()!=null)
            State.getState().render(g);
        //aici se termina
        bs.show();
        g.dispose();
    }
    //folosit la fereasta
    public void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
    //pastrez aceeasi viteza de redare a frameurilor..
        int fps = 60;
        double tmT = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta = delta + (now - lastTime) / tmT;
            timer += now - lastTime;
            lastTime = now;
            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            if (timer >= 1000000000) {
               //System.out.println("Ticks and Frame:" + ticks);
                ticks = 0;
                timer = 0;

            }
        }
        stop();
    }
    //metodele ptr pornire si oprire joc
    public synchronized void start()
    {
        if(running)
            return;
        running =true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop()
    {
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    //getters and setters
    public KeyManager getKeyManager(){
        return keyManager;
    }

    public MouseManager getMouseManager(){return  mouseManager;}

    public GameCamera getGameCamera()
    {
        return gameCamera;
    }



    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }



}

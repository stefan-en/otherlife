package gfx;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Assets {

    private static final int width = 109, height = 109;
    public static Font font30;

    public static BufferedImage superpower,ciperca,door;

    public static BufferedImage baza,bgr,box,toxic,flame;
    public static BufferedImage acid,tepi,jigsaw;
    //left
    public  static BufferedImage[] player_state;
    public static BufferedImage[] player_left;
    public static BufferedImage[] player_atk_l;
    public  static BufferedImage[] player_jump_l;

    //right
    public static BufferedImage[] player_walk;
    public  static BufferedImage[] player_state_right;
    public static BufferedImage[] player_atk;
    public static BufferedImage[] player_jump_r;

    //poate
    public static BufferedImage[] player_jump_atk;
    //Butoane joc
    public static BufferedImage[] button_start;
    public static BufferedImage[] button_exit;
    public static BufferedImage[] button_sett;
    public static BufferedImage[] button_easy;
    public static BufferedImage[] button_hard;

    public static BufferedImage inventoryscreen;
    public static BufferedImage bkg;

    //ptr enemy
    public static BufferedImage[] walk_f_d,atk_f_d,idl_f_d,dead_f_d,walk_b_d, atk_b_d,idl_b_d,dead_b_d;
    public static BufferedImage[] walk_f_s,atk_f_s,idl_f_s,dead_f_s,walk_b_s, atk_b_s,idl_b_s,dead_b_s;

    public static void init() throws IOException, FontFormatException {
        font30 = FontLoader.loadFont("Resurse/fonts/amatic/AmaticSC-Regular.ttf",30);

        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("Resurse/texturi/f .png"));
        SpriteSheet sheet_erou_d = new SpriteSheet(ImageLoader.loadImage("Resurse/texturi/erou_demo_sprite_d.png"));
        SpriteSheet sheet_erou_s = new SpriteSheet(ImageLoader.loadImage("Resurse/texturi/erou_demo_sprite_s.png"));
        SpriteSheet sheet_butts = new SpriteSheet(ImageLoader.loadImage("Resurse/texturi/butoane.png"));
        inventoryscreen = ImageLoader.loadImage("Resurse/texturi/inventory.png");
        bkg = ImageLoader.loadImage("Resurse/texturi/bkg.jpg");

        //butoanele
        button_start = new BufferedImage[2];
        button_exit = new BufferedImage[2];
        button_sett = new BufferedImage[2];
        button_easy = new BufferedImage[2];
        button_hard = new BufferedImage[2];

        button_start[0] = sheet_butts.crop(0,0,188,83);
        button_start[1] = sheet_butts.crop(199,0,187,85);

        button_exit[0] = sheet_butts.crop(0,111,189,83);
        button_exit[1] = sheet_butts.crop(200,111,187,83);

        button_sett[0] = sheet_butts.crop(1,237,189,82);
        button_sett[1] = sheet_butts.crop(199,237,188,83);

        button_easy[0] = sheet_butts.crop(1,348,191,82);
        button_easy[1] = sheet_butts.crop(200,348,187,82);

        button_hard[0] = sheet_butts.crop(2,451,187,85);
        button_hard[1] = sheet_butts.crop(200,451,187,82);

        //spre dreapta
        //mersul
        player_walk = new BufferedImage[10];

        player_walk[0] = sheet_erou_d.crop(0, 105,68,108);
        player_walk[1] = sheet_erou_d.crop(69, 105,68,112);
        player_walk[2] = sheet_erou_d.crop(135, 105,66,111);
        player_walk[3] = sheet_erou_d.crop(202, 105,64,104);
        player_walk[4] = sheet_erou_d.crop(266, 105,68,108);
        player_walk[5] = sheet_erou_d.crop(333, 105,68,107);
        player_walk[6] = sheet_erou_d.crop(402, 105,66,109);
        player_walk[7] = sheet_erou_d.crop(468, 105,68,109);
        player_walk[8] = sheet_erou_d.crop(536, 105,69,107);
        player_walk[9] = sheet_erou_d.crop(605, 105,68,108);
        //Attack
        player_atk = new BufferedImage[10];

        player_atk[0] = sheet_erou_d.crop(0, 0,70,105);
        player_atk[1] = sheet_erou_d.crop(70, 0,71,105);
        player_atk[2] = sheet_erou_d.crop(140, 0,65,105);
        player_atk[3] = sheet_erou_d.crop(210, 0,65,105);
        player_atk[4] = sheet_erou_d.crop(280, 0,70,105);
        player_atk[5] = sheet_erou_d.crop(360, 0,76,105);
        player_atk[6] = sheet_erou_d.crop(440, 0,76,105);
        player_atk[7] = sheet_erou_d.crop(530, 0,76,105);
        player_atk[8] = sheet_erou_d.crop(610, 0,76,105);
        player_atk[9] = sheet_erou_d.crop(700, 0,78,105);


        //Stat pe loc
        player_state = new BufferedImage[10];
        player_state[0] = sheet_erou_d.crop(0, 320,77,109);
        player_state[1] = sheet_erou_d.crop(80, 320,77,109);
        player_state[2] = sheet_erou_d.crop(160, 320,77,109);
        player_state[3] = sheet_erou_d.crop(240, 320,77,109);
        player_state[4] = sheet_erou_d.crop(320, 320,77,109);
        player_state[5] = sheet_erou_d.crop(400, 320,77,109);
        player_state[6] = sheet_erou_d.crop(480, 320,77,109);
        player_state[7] = sheet_erou_d.crop(560, 320,77,109);
        player_state[8] = sheet_erou_d.crop(640, 320,77,109);
        player_state[9] = sheet_erou_d.crop(720, 320,77,109);



        player_jump_atk = new BufferedImage[10];
        player_jump_atk[0] = sheet_erou_d.crop(0, 550,85,110);
        player_jump_atk[1] = sheet_erou_d.crop(100, 550,85,110);
        player_jump_atk[2] = sheet_erou_d.crop(200, 550,85,110);
        player_jump_atk[3] = sheet_erou_d.crop(300, 550,85,110);
        player_jump_atk[4] = sheet_erou_d.crop(400, 550,85,110);
        player_jump_atk[5] = sheet_erou_d.crop(500, 550,85,110);
        player_jump_atk[6] = sheet_erou_d.crop(600, 550,85,110);
        player_jump_atk[7] = sheet_erou_d.crop(700, 550,85,110);
        player_jump_atk[8] = sheet_erou_d.crop(800, 550,85,110);
        player_jump_atk[9] = sheet_erou_d.crop(900, 550,85,110);

        //jump
        player_jump_l = new BufferedImage[10];
        player_jump_l [0] = sheet_erou_d.crop(0, 440,69,110);
        player_jump_l[1] = sheet_erou_d.crop(70, 440,69,110);
        player_jump_l[2] = sheet_erou_d.crop(140, 440,69,110);
        player_jump_l[3] = sheet_erou_d.crop(210, 440,69,110);
        player_jump_l[4] = sheet_erou_d.crop(280, 440,69,110);
        player_jump_l[5] = sheet_erou_d.crop(360, 440,69,110);
        player_jump_l[6] = sheet_erou_d.crop(440, 440,69,110);
        player_jump_l[7] = sheet_erou_d.crop(520, 440,69,110);
        player_jump_l[8] = sheet_erou_d.crop(600, 440,69,110);
        player_jump_l[9] = sheet_erou_d.crop(680, 440,69,110);


        //spre stanga
        player_left = new BufferedImage[10];
        player_left[0] = sheet_erou_s.crop(0, 112,69,110);
        player_left[1] = sheet_erou_s.crop(75, 112,69,110);
        player_left[2] = sheet_erou_s.crop(150, 112,69,110);
        player_left[3] = sheet_erou_s.crop(225, 112,69,110);
        player_left[4] = sheet_erou_s.crop(300, 112,69,110);
        player_left[5] = sheet_erou_s.crop(375, 112,69,110);
        player_left[6] = sheet_erou_s.crop(450, 112,69,110);
        player_left[7] = sheet_erou_s.crop(525, 112,69,110);
        player_left[8] = sheet_erou_s.crop(600, 112,69,110);
        player_left[9] = sheet_erou_s.crop(675, 112,69,110);

        player_atk_l = new BufferedImage[10];

        player_atk_l[0] = sheet_erou_s.crop(0, 0,80,105);
        player_atk_l[1] = sheet_erou_s.crop(83, 0,80,105);
        player_atk_l[2] = sheet_erou_s.crop(183, 0,80,105);
        player_atk_l[3] = sheet_erou_s.crop(281, 0,80,105);
        player_atk_l[4] = sheet_erou_s.crop(379, 0,80,105);
        player_atk_l[5] = sheet_erou_s.crop(477, 0,80,105);
        player_atk_l[6] = sheet_erou_s.crop(565, 0,80,105);
        player_atk_l[7] = sheet_erou_s.crop(643, 0,80,105);
        player_atk_l[8] = sheet_erou_s.crop(736, 0,80,105);
        player_atk_l[9] = sheet_erou_s.crop(831, 0,80,105);

        player_state_right = new BufferedImage[10];
        player_state_right[0] = sheet_erou_s.crop(0, 350,75,105);
        player_state_right[1] = sheet_erou_s.crop(80, 350,75,105);
        player_state_right[2] = sheet_erou_s.crop(160, 350,75,105);
        player_state_right[3] = sheet_erou_s.crop(240, 350,75,105);
        player_state_right[4] = sheet_erou_s.crop(320, 350,75,105);
        player_state_right[5] = sheet_erou_s.crop(400, 350,75,105);
        player_state_right[6] = sheet_erou_s.crop(480, 350,75,105);
        player_state_right[7] = sheet_erou_s.crop(560, 350,75,105);
        player_state_right[8] = sheet_erou_s.crop(640, 350,75,105);
        player_state_right[9] = sheet_erou_s.crop(720, 350,75,105);

        player_jump_r = new BufferedImage[10];
        player_jump_r[0] = sheet_erou_s.crop(865, 453,69,107);
        player_jump_r[1] = sheet_erou_s.crop(760, 467,71,112);
        player_jump_r[2] = sheet_erou_s.crop(668, 463,68,110);
        player_jump_r[3] = sheet_erou_s.crop(566, 467,68,106);
        player_jump_r[4] = sheet_erou_s.crop(469, 469,71,103);
        player_jump_r[5] = sheet_erou_s.crop(374, 469,71,104);
        player_jump_r[6] = sheet_erou_s.crop(278, 474,71,104);
        player_jump_r[7] = sheet_erou_s.crop(183, 476,73,105);
        player_jump_r[8] = sheet_erou_s.crop(92, 482,69,109);
        player_jump_r[9] = sheet_erou_s.crop(3, 482,70,109);

        //ptr zombie
        SpriteSheet zombie_dreapta = new SpriteSheet(ImageLoader.loadImage("Resurse/texturi/zombie_d.png"));
        SpriteSheet zombie_stanga = new SpriteSheet(ImageLoader.loadImage("Resurse/texturi/zombie_s.png"));
        walk_f_d = new BufferedImage[10];
        //dreapta
        walk_f_d[0] = zombie_dreapta.crop(0, 360,69,106);
        walk_f_d[1] = zombie_dreapta.crop(80, 360,69,106);
        walk_f_d[2] = zombie_dreapta.crop(160, 360,69,106);
        walk_f_d[3] = zombie_dreapta.crop(240, 360,69,106);
        walk_f_d[4] = zombie_dreapta.crop(320, 360,69,106);
        walk_f_d[5] = zombie_dreapta.crop(400, 360,69,106);
        walk_f_d[6] = zombie_dreapta.crop(480, 360,69,106);
        walk_f_d[7] = zombie_dreapta.crop(560, 360,69,106);
        walk_f_d[8] = zombie_dreapta.crop(640, 360,69,106);
        walk_f_d[9] = zombie_dreapta.crop(720, 360,69,106);

        atk_f_d = new BufferedImage[8];
        atk_f_d[0] = zombie_dreapta.crop(0, 0,69,106);
        atk_f_d[1] = zombie_dreapta.crop(80, 0,69,106);
        atk_f_d[2] = zombie_dreapta.crop(160, 0,69,106);
        atk_f_d[3] = zombie_dreapta.crop(240, 0,69,106);
        atk_f_d[4] = zombie_dreapta.crop(320, 0,69,106);
        atk_f_d[5] = zombie_dreapta.crop(400, 0,69,106);
        atk_f_d[6] = zombie_dreapta.crop(480, 0,69,106);
        atk_f_d[7] = zombie_dreapta.crop(560, 0,69,106);

        idl_f_d = new BufferedImage[10];
        idl_f_d[0] = zombie_dreapta.crop(0, 240,69,106);
        idl_f_d[1] = zombie_dreapta.crop(80, 240,69,106);
        idl_f_d[2] = zombie_dreapta.crop(160, 240,69,106);
        idl_f_d[3] = zombie_dreapta.crop(240, 240,69,106);
        idl_f_d[4] = zombie_dreapta.crop(320, 240,69,106);
        idl_f_d[5] = zombie_dreapta.crop(400, 240,69,106);
        idl_f_d[6] = zombie_dreapta.crop(480, 240,69,106);
        idl_f_d[7] = zombie_dreapta.crop(560, 240,69,106);
        idl_f_d[8] = zombie_dreapta.crop(640, 240,69,106);
        idl_f_d[9] = zombie_dreapta.crop(720, 240,69,106);

        dead_f_d = new BufferedImage[12];
        dead_f_d[0] = zombie_dreapta.crop(0, 120,72,98);
        dead_f_d[1] = zombie_dreapta.crop(82, 121,74,100);
        dead_f_d[2] = zombie_dreapta.crop(162, 121,73,97);
        dead_f_d[3] = zombie_dreapta.crop(239, 133,72,85);
        dead_f_d[4] = zombie_dreapta.crop(320, 143,75,74);
        dead_f_d[5] = zombie_dreapta.crop(400, 139,75,78);
        dead_f_d[6] = zombie_dreapta.crop(480, 133,72,82);
        dead_f_d[7] = zombie_dreapta.crop(560, 120,88,89);
        dead_f_d[8] = zombie_dreapta.crop(654, 130,105,85);
        dead_f_d[9] = zombie_dreapta.crop(777, 133,98,80);
        dead_f_d[10] = zombie_dreapta.crop(885, 138,102,85);
        dead_f_d[11] = zombie_dreapta.crop(985, 131,107,88);

        walk_b_d = new BufferedImage[9];
        walk_b_d[0] = zombie_dreapta.crop(2, 820,78,110);
        walk_b_d[1] = zombie_dreapta.crop(80, 820,78,110);
        walk_b_d[2] = zombie_dreapta.crop(152, 820,78,110);
        walk_b_d[3] = zombie_dreapta.crop(240, 820,78,110);
        walk_b_d[4] = zombie_dreapta.crop(320, 820,78,110);
        walk_b_d[5] = zombie_dreapta.crop(400, 820,78,110);
        walk_b_d[6] = zombie_dreapta.crop(483, 820,78,110);
        walk_b_d[7] = zombie_dreapta.crop(560, 820,78,110);
        walk_b_d[8] = zombie_dreapta.crop(638, 820,78,110);

        idl_b_d = new BufferedImage[10];
        idl_b_d[0] = zombie_dreapta.crop(0, 700,69,106);
        idl_b_d[1] = zombie_dreapta.crop(80, 700,69,106);
        idl_b_d[2] = zombie_dreapta.crop(158, 700,69,106);
        idl_b_d[3] = zombie_dreapta.crop(238, 700,69,106);
        idl_b_d[4] = zombie_dreapta.crop(319, 700,69,106);
        idl_b_d[5] = zombie_dreapta.crop(400, 700,69,106);
        idl_b_d[6] = zombie_dreapta.crop(479, 700,69,106);
        idl_b_d[7] = zombie_dreapta.crop(559, 700,69,106);
        idl_b_d[8] = zombie_dreapta.crop(639, 700,69,106);
        idl_b_d[9] = zombie_dreapta.crop(720, 700,69,106);

        atk_b_d = new BufferedImage[8];
        atk_b_d[0] = zombie_dreapta.crop(0, 0,69,101);
        atk_b_d[1] = zombie_dreapta.crop(80, 0,69,101);
        atk_b_d[2] = zombie_dreapta.crop(160, 0,69,101);
        atk_b_d[3] = zombie_dreapta.crop(240, 0,69,101);
        atk_b_d[4] = zombie_dreapta.crop(320, 0,69,101);
        atk_b_d[5] = zombie_dreapta.crop(400, 0,69,101);
        atk_b_d[6] = zombie_dreapta.crop(480, 0,69,101);
        atk_b_d[7] = zombie_dreapta.crop(560, 0,69,101);

        dead_b_d = new BufferedImage[12];
        dead_b_d[0] = zombie_dreapta.crop(0, 600,82,91);
        dead_b_d[1] = zombie_dreapta.crop(81, 600,85,95);
        dead_b_d[2] = zombie_dreapta.crop(161, 600,78,88);
        dead_b_d[3] = zombie_dreapta.crop(241, 604,71,80);
        dead_b_d[4] = zombie_dreapta.crop(320, 600,63,81);
        dead_b_d[5] = zombie_dreapta.crop(400, 600,69,83);
        dead_b_d[6] = zombie_dreapta.crop(481, 601,72,82);
        dead_b_d[7] = zombie_dreapta.crop(561, 601,88,75);
        dead_b_d[8] = zombie_dreapta.crop(654, 609,105,61);
        dead_b_d[9] = zombie_dreapta.crop(767, 609,109,61);
        dead_b_d[10] = zombie_dreapta.crop(890, 612,103,58);
        dead_b_d[11] = zombie_dreapta.crop(1007, 615,107,60);

        //Stanga
        walk_f_s = new BufferedImage[10];
        walk_f_s[0] = zombie_stanga.crop(0, 330,69,106);
        walk_f_s[1] = zombie_stanga.crop(80, 330,69,106);
        walk_f_s[2] = zombie_stanga.crop(160, 330,69,106);
        walk_f_s[3] = zombie_stanga.crop(240, 330,69,106);
        walk_f_s[4] = zombie_stanga.crop(320, 330,69,106);
        walk_f_s[5] = zombie_stanga.crop(400, 330,69,106);
        walk_f_s[6] = zombie_stanga.crop(480, 330,69,106);
        walk_f_s[7] = zombie_stanga.crop(560, 330,69,106);
        walk_f_s[8] = zombie_stanga.crop(640, 330,69,106);
        walk_f_s[9] = zombie_stanga.crop(720, 330,69,106);

        atk_f_s = new BufferedImage[8];
        atk_f_s[0] = zombie_stanga.crop(0, 480,73,106);
        atk_f_s[1] = zombie_stanga.crop(80, 480,73,106);
        atk_f_s[2] = zombie_stanga.crop(160, 480,73,106);
        atk_f_s[3] = zombie_stanga.crop(240, 480,73,106);
        atk_f_s[4] = zombie_stanga.crop(320, 480,73,106);
        atk_f_s[5] = zombie_stanga.crop(400, 480,73,106);
        atk_f_s[6] = zombie_stanga.crop(480, 480,73,106);
        atk_f_s[7] = zombie_stanga.crop(560, 480,73,106);

        idl_f_s = new BufferedImage[10];
        idl_f_s[0] = zombie_stanga.crop(720, 220,69,106);
        idl_f_s[1] = zombie_stanga.crop(640, 220,69,106);
        idl_f_s[2] = zombie_stanga.crop(560, 220,69,106);
        idl_f_s[3] = zombie_stanga.crop(480, 220,69,106);
        idl_f_s[4] = zombie_stanga.crop(400, 220,69,106);
        idl_f_s[5] = zombie_stanga.crop(320, 220,69,106);
        idl_f_s[6] = zombie_stanga.crop(240, 220,69,106);
        idl_f_s[7] = zombie_stanga.crop(160, 220,69,106);
        idl_f_s[8] = zombie_stanga.crop(80, 220,69,106);
        idl_f_s[9] = zombie_stanga.crop(0, 220,69,106);

        dead_f_s = new BufferedImage[12];
        dead_f_s[0] = zombie_stanga.crop(1200, 120,72,98);
        dead_f_s[1] = zombie_stanga.crop(1100, 120,74,100);
        dead_f_s[2] = zombie_stanga.crop(1000, 120,73,97);
        dead_f_s[3] = zombie_stanga.crop(900, 120,72,85);
        dead_f_s[4] = zombie_stanga.crop(800, 120,75,74);
        dead_f_s[5] = zombie_stanga.crop(700, 120,75,78);
        dead_f_s[6] = zombie_stanga.crop(600, 120,72,82);
        dead_f_s[7] = zombie_stanga.crop(480, 120,88,89);
        dead_f_s[8] = zombie_stanga.crop(360, 130,105,85);
        dead_f_s[9] = zombie_stanga.crop(240, 120,98,80);
        dead_f_s[10] = zombie_stanga.crop(120, 120,102,85);
        dead_f_s[11] = zombie_stanga.crop(0, 120,107,88);

        walk_b_s = new BufferedImage[9];
        walk_b_s[0] = zombie_stanga.crop(0, 770,66,107);
        walk_b_s[1] = zombie_stanga.crop(80, 770,75,113);
        walk_b_s[2] = zombie_stanga.crop(160, 770,80,112);
        walk_b_s[3] = zombie_stanga.crop(240, 770,81,114);
        walk_b_s[4] = zombie_stanga.crop(320, 770,72,105);
        walk_b_s[5] = zombie_stanga.crop(400, 770,76,112);
        walk_b_s[6] = zombie_stanga.crop(480, 770,63,110);
        walk_b_s[7] = zombie_stanga.crop(560, 770,69,118);
        walk_b_s[8] = zombie_stanga.crop(650, 770,69,114);

        idl_b_s = new BufferedImage[10];
        idl_b_s[0] = zombie_stanga.crop(0, 660,69,106);
        idl_b_s[1] = zombie_stanga.crop(80, 660,69,106);
        idl_b_s[2] = zombie_stanga.crop(160, 660,69,106);
        idl_b_s[3] = zombie_stanga.crop(240, 660,69,106);
        idl_b_s[4] = zombie_stanga.crop(320, 660,69,106);
        idl_b_s[5] = zombie_stanga.crop(400, 660,69,106);
        idl_b_s[6] = zombie_stanga.crop(480, 660,69,106);
        idl_b_s[7] = zombie_stanga.crop(560, 660,69,106);
        idl_b_s[8] = zombie_stanga.crop(640, 660,69,106);
        idl_b_s[9] = zombie_stanga.crop(720, 660,69,106);

        atk_b_s = new BufferedImage[8];
        atk_b_s[0] = zombie_stanga.crop(0, 440,69,101);
        atk_b_s[1] = zombie_stanga.crop(80, 440,69,101);
        atk_b_s[2] = zombie_stanga.crop(160, 440,69,101);
        atk_b_s[3] = zombie_stanga.crop(240, 440,69,101);
        atk_b_s[4] = zombie_stanga.crop(320, 440,69,101);
        atk_b_s[5] = zombie_stanga.crop(400, 440,69,101);
        atk_b_s[6] = zombie_stanga.crop(480, 440,69,101);
        atk_b_s[7] = zombie_stanga.crop(560, 440,69,101);

        dead_b_s = new BufferedImage[12];
        dead_b_s[0] = zombie_stanga.crop(0, 550,82,91);
        dead_b_s[1] = zombie_stanga.crop(81, 550,85,95);
        dead_b_s[2] = zombie_stanga.crop(161, 550,78,88);
        dead_b_s[3] = zombie_stanga.crop(241, 550,71,80);
        dead_b_s[4] = zombie_stanga.crop(340, 550,63,81);
        dead_b_s[5] = zombie_stanga.crop(417, 550,69,83);
        dead_b_s[6] = zombie_stanga.crop(500, 550,72,82);
        dead_b_s[7] = zombie_stanga.crop(600, 550,88,75);
        dead_b_s[8] = zombie_stanga.crop(700, 550,105,61);
        dead_b_s[9] = zombie_stanga.crop(800, 550,109,61);
        dead_b_s[10] = zombie_stanga.crop(900, 550,103,58);
        dead_b_s[11] = zombie_stanga.crop(1000, 550,107,60);


        baza = sheet.crop(479,0,width,height);
        bgr = sheet.crop(259,0,width,height);
        box = sheet.crop(370,0,width,height);
        flame = sheet.crop(5,109,90,121);
        toxic = sheet.crop(97,109,89,120);

        acid = sheet.crop(150,0, width,height);
        tepi = sheet.crop(0,500,109,109);
        jigsaw = sheet.crop(172,496,109,109);



        superpower = sheet.crop(749,29,60,60);
        ciperca = sheet.crop(618,20,84,69);
        door = sheet.crop(444,132,97,161);

    }
}

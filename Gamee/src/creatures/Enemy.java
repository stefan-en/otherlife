package creatures;

import creatures.states.EnemyState;
import creatures.states.Waiting;
import tilegame.Handler;

import java.awt.*;
public abstract class Enemy extends Creature {

    protected Handler handler;
    protected boolean facing;//false-stanga // dreapta-true
    protected int attackTimer;
    protected EnemyState state;
    protected boolean isAttacking;
    protected boolean isMoving;
    protected boolean isWaiting;

    public Enemy(Handler handler, float x, float y) {
        super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
        this.handler = handler;
        facing = false;
        state = new Waiting(this);
        isAttacking = false;
        isMoving = false;
        isWaiting = true;
    }

    @Override
    public void tick() {
        state = state.tick(Player.getInstance().getCollisionBounds(0,0));

        move();

        if(attackTimer > 0)
            attackTimer--;
    }
    @Override
    public void render(Graphics g) {

    }

    @Override
    public void die() {
        Player.getInstance().setScore(Player.getInstance().getScore() + 1);
    }

    public boolean isFacing() {
        return facing;
    }

    public void setFacing(boolean facing) {
        this.facing = facing;
    }

    public int getAttackTimer() {
        return attackTimer;
    }

    public void setAttackTimer(int attacktTimer) {
        this.attackTimer = attacktTimer;
    }

    public boolean isAttacking() {
        return isAttacking;
    }

    public void setAttacking(boolean attacking) {
        isAttacking = attacking;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public boolean isWaiting() {
        return isWaiting;
    }

    public void setWaiting(boolean waiting) {
        isWaiting = waiting;
    }
}

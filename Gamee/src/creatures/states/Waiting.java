package creatures.states;

import creatures.Enemy;

import java.awt.*;

public class Waiting extends EnemyState{

    public Waiting(Enemy enemy) {
        thisEnemy = enemy;
        init();
    }

    @Override
    public EnemyState tick(Rectangle playerBounds) {
        int x = (int) thisEnemy.getX();
        if(((playerBounds.x >= x - distanceToFollow && playerBounds.x < x) || (playerBounds.x < x + distanceToFollow && playerBounds.x > x)) && (Math.abs(playerBounds.y + playerBounds.height - (thisEnemy.getY() + thisEnemy.getHeight())) < 40) && (playerBounds.y < thisEnemy.getY() + thisEnemy.getHeight()))
            return new Follow(thisEnemy);
        return this;
    }

    @Override
    public void init() {
        thisEnemy.setWaiting(true);
        thisEnemy.setAttacking(false);
        thisEnemy.setMoving(false);
    }
}

package creatures.states;

import creatures.Enemy;

import java.awt.*;

public class Follow extends EnemyState{

    public Follow(Enemy enemy) {
        thisEnemy = enemy;
        init();
    }

    @Override
    public EnemyState tick(Rectangle playerBounds) {
        int x = (int) thisEnemy.getX();
        if((((playerBounds.x >= x - distanceToAttack && playerBounds.x < x) || (playerBounds.x < x + thisEnemy.getWidth() + distanceToAttack && playerBounds.x > x)) && (Math.abs(playerBounds.y + playerBounds.height - (thisEnemy.getY() + thisEnemy.getHeight())) < 40) && (playerBounds.y < thisEnemy.getY() + thisEnemy.getHeight())))
            return new Attack(thisEnemy);
            if (playerBounds.x < x) {
                thisEnemy.setFacing(false);
                thisEnemy.setxMove(-horizontalSpeed);
            } else {
                thisEnemy.setFacing(true);
                thisEnemy.setxMove(horizontalSpeed);
            }
        return this;
    }

    @Override
    public void init() {
        thisEnemy.setWaiting(false);
        thisEnemy.setAttacking(false);
        thisEnemy.setMoving(true);
    }
}

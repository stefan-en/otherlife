package creatures.states;

import creatures.Enemy;
import creatures.Player;

import java.awt.*;

public class Attack extends EnemyState{

    private boolean canAttack;

    public Attack(Enemy enemy) {
        thisEnemy = enemy;
        init();
    }

    @Override
    public EnemyState tick(Rectangle playerBounds) {
        //verific fistanta playerului cu cea a enemyului,iar daca sunt intr-o anumita raza o sa ma urmareasca
        int x = (int) thisEnemy.getX();
        if(!(((playerBounds.x >= x - distanceToAttack && playerBounds.x < x) || (playerBounds.x < x + thisEnemy.getWidth() + distanceToAttack && playerBounds.x > x)) && (Math.abs(playerBounds.y + playerBounds.height - (thisEnemy.getY() + thisEnemy.getHeight())) < 40) && (playerBounds.y < thisEnemy.getY() + thisEnemy.getHeight())))
        {
            return new Follow(thisEnemy);
        }
        //verific daca ma poate ataca
        if(thisEnemy.getAttackTimer() <= 0) {
            canAttack = true;
        }

        if(canAttack) {
            thisEnemy.setAttackTimer(30);
            canAttack = false;
            thisEnemy.setWaiting(false);
            thisEnemy.setAttacking(true);
            thisEnemy.setMoving(false);
            Player.getInstance().setHealth(Player.getInstance().getHealth() - 1);
            return  this;

        }

        return this;
    }

    @Override
    public void init() {
        thisEnemy.setxMove(0);
        canAttack = false;
        thisEnemy.setAttackTimer(40);
    }
}

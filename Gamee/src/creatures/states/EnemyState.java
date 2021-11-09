package creatures.states;

import creatures.Enemy;

import java.awt.*;
//diferite stateuri ptr enemy
public abstract class EnemyState {
    protected final float horizontalSpeed = 1.1f;
    protected static final int distanceToFollow = 100;
    protected static final int distanceToAttack = 20;
    protected Enemy thisEnemy;

    public abstract EnemyState tick(Rectangle playerBounds);
    public abstract void init();
}

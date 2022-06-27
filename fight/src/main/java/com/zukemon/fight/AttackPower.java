package com.zukemon.fight;

public class AttackPower {

    private int damage;
    private int criticalHitChance;

    public AttackPower(int damage, int criticalHitChance) {
        this.damage = damage;
        this.criticalHitChance = criticalHitChance;
    }

    public int getDamage() {
        return damage;
    }

    public int getCriticalHitChance() {
        return criticalHitChance;
    }
}

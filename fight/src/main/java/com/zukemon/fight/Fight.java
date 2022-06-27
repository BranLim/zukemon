package com.zukemon.fight;

import java.util.Map;

public class Fight {

    private final Map<Pokemon, AttackPower> pokemons;

    public Fight(Map<Pokemon, AttackPower> pokemons) {
        this.pokemons = pokemons;
    }

    CriticalHit criticalHit = new CriticalHit();

    /**
     * Blastoise #9 Water Damage 258
     * Mew #151 Psychic Damage 150 (10% chance of critical hit)
     * Wartortle #8 Water Damage 300
     * Mudkip #258 Water Damage 234
     * Pikachu #25 Electric Damage 135
     * Psyduck #54 Water Damage 127 (20% chance of critical hit)
     * Krookodile #553 Dark No Damage -> It is the team lead, so he can call his team members to arms. Add the
     * damage of all other Zukemons
     *
     * @param attackerType
     */
    public int hit(int attackerType) {
        var pokemon = Pokemon.findByKey(attackerType);
        var attackPower = pokemons.get(pokemon);
        int damage = 0;
        if (attackerType == Pokemon.Krookodile.getId()) {
            for (Map.Entry<Pokemon, AttackPower> entry : pokemons.entrySet()) {
                damage += entry.getValue().getDamage();
            }
            return damage;
        } else {
            damage = attackPower.getDamage();
            if (criticalHit.isCriticalHit(attackPower.getCriticalHitChance())) {
                damage *= 2;
            }
            return damage;
        }
    }
}

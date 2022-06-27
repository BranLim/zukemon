package com.zukemon.fight;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class FightTest {

    private Map<Pokemon, AttackPower> sampleTestData =
            Map.of(Pokemon.Blastoise, new AttackPower(258, 0),
                    Pokemon.Mew, new AttackPower(150, 0),
                    Pokemon.Wartortle, new AttackPower(300, 0),
                    Pokemon.Mudkip, new AttackPower(234, 0),
                    Pokemon.Pikachu, new AttackPower(135, 0),
                    Pokemon.Psyduck, new AttackPower(127, 0));

    private Map<Pokemon, AttackPower> sampleTestDataWithCriticalHit =
            Map.of(
                    Pokemon.Mew, new AttackPower(150, 100),
                    Pokemon.Psyduck, new AttackPower(127, 100));

    @Test
    void givenAttackerIsBlastoise_whenAttacking_thenDamageShouldBe258() {
        Fight fight = new Fight(sampleTestData);
        int damage = fight.hit(9);
        assertThat(damage).isEqualTo(258);
    }

    @Test
    void givenAttackerIsMew_whenAttacking_thenDamageShouldBe150() {
        Fight fight = new Fight(sampleTestData);
        int damage = fight.hit(151);
        assertThat(damage).isEqualTo(150);
    }

    @Test
    void givenAttackerIsMew_whenAttackingWithCriticalHit_thenDamageShouldBe300() {
        Fight fight = new Fight(sampleTestDataWithCriticalHit);
        int damage = fight.hit(151);
        assertThat(damage).isEqualTo(300);
    }

    @Test
    void givenAttackerIsPsyduck_whenAttackingWithCriticalHit_thenDamageShouldBe254() {
        Fight fight = new Fight(sampleTestDataWithCriticalHit);
        int damage = fight.hit(54);
        assertThat(damage).isEqualTo(254);
    }

    @Test
    void givenAttackerIsWartortle_whenAttacking_thenDamageShouldBe300() {
        Fight fight = new Fight(sampleTestData);
        int damage = fight.hit(8);
        assertThat(damage).isEqualTo(300);
    }

    @Test
    void givenAttackerIsKrookodile_whenAttacking_thenDamageShouldBeSumOfAllPokemonDamage() {
        Fight fight = new Fight(sampleTestData);
        int damage = fight.hit(553);
        assertThat(damage).isEqualTo(1204);
    }
}

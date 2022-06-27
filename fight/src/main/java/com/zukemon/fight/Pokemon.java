package com.zukemon.fight;

import java.util.HashMap;
import java.util.Map;

public enum Pokemon {
    Blastoise(9),
    Mew(151),
    Wartortle(8),
    Mudkip(258),
    Pikachu(25),
    Psyduck(54),
    Krookodile(553);
    private int id;

    Pokemon(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    private static final Map<Integer,Pokemon> map;
    static {
        map = new HashMap<Integer,Pokemon>();
        for (Pokemon v : Pokemon.values()) {
            map.put(v.id, v);
        }
    }
    public static Pokemon findByKey(int i) {
        return map.get(i);
    }
}

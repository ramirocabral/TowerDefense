package entregable.ataques;

import game.types.*;
import java.util.Arrays;
import java.util.Collections.*;
import java.util.HashMap;
import java.util.Map;


public enum Multipliers {
    //    SWORD(),
    DEMON (initialize( Type.FIRE, 1.5, Type.COLD, 1.5, Type.WATER, 1.5, Type.ELECTRIC, 1.5)),
    PSYCHIC(initialize(Type.SWORD, 1.5, Type.RADIANT, 1.5,Type.BEAST, 0.5)),
    FIRE(initialize(Type.COLD, 2.0, Type.BEAST, 2.0)),
    COLD(initialize(Type.WATER, 2.0)),
    BEAST(initialize(Type.ELECTRIC, 2.0)),
    WATER(initialize(Type.FIRE, 2.0, Type.VENOM, 2.0)),
    ELECTRIC(initialize(Type.COLD, 2.0, Type.WATER, 2.0)),
    VENOM(initialize(Type.SWORD, 2.0)),
    RADIANT(initialize(Type.DEMON, 2.5));

    private HashMap<Type, Double> mult;

    Multipliers(HashMap<Type, Double> typeDoubleHashMap) {
        this.mult = typeDoubleHashMap;
    }

    public static HashMap<Type, Double> initialize(Object... keyValuePairs) throws IllegalArgumentException{
        if (keyValuePairs.length % 2 != 0)
            throw new IllegalArgumentException("Invalid key value pair");
        HashMap<Type, Double> map = new HashMap<>();
        for (int i = 0; i < keyValuePairs.length; i+=2) {
            map.put((Type)keyValuePairs[i], (Double)keyValuePairs[i+1]);
        }
        return map;
    }

    public Double getMultiplier(Type type){
        if (!mult.containsKey(type))
            return 1.0;
        return mult.get(type);
    }
}
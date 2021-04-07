package io.github.jesypira.marvelapi.marveljavaapi.validator;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @autor Jéssica Cabral (jessica.cabral.a@gmail.com)
 * @since 07/04/2021
 */
public class ValidatorUtil {

    private ValidatorUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static final boolean isEmpty(String s) {
        return (s == null || s.equalsIgnoreCase("null") || s.trim().length() == 0);
    }

    public static final boolean isEmpty(Character c) {
        return (c == null || c.equals(' ') || c.toString().trim().length() == 0);
    }

    public static final boolean isEmpty(Object o) {
        if(o == null)
            return true;

        if(o instanceof String)
            return isEmpty( (String) o);

        if(o instanceof Character)
            return isEmpty( (Character) o);

        if(o instanceof Number){
            Number i = (Number) o;

            if(i instanceof Double || i instanceof Float)
                return (i.floatValue() == 0);

            return (i.intValue() == 0);
        }

        if(o instanceof Object[])
            return ((Object[]) o).length == 0;

        if(o instanceof int[])
            return ((int[]) o).length == 0;

        if(o instanceof long[])
            return ((long[]) o).length == 0;

        if(o instanceof Collection<?>)
            return ((Collection<?>) o).isEmpty();

        if(o instanceof Map<?, ?>)
            return ((Map<?, ?>) o).isEmpty();

        if(o instanceof List<?>)
            return ((List<?>) o).isEmpty();

        return false;
    }

    public static final boolean isNotEmpty(Object o){
        return !isEmpty(o);
    }

}

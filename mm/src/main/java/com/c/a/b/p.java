package com.c.a.b;

import com.c.a.a.b.j;
import java.util.Map;

public enum p {
    OBJECT(2, 0),
    BOOLEAN(4, 1),
    CHAR(5, 2),
    FLOAT(6, 4),
    DOUBLE(7, 8),
    BYTE(8, 1),
    SHORT(9, 2),
    INT(10, 4),
    LONG(11, 8);
    
    private static Map<Integer, p> cpY = j.JX();
    int mId;
    int mSize;

    static {
        p[] values = values();
        for (p pVar : values) {
            cpY.put(Integer.valueOf(pVar.mId), pVar);
        }
    }

    private p(int i2, int i3) {
        this.mId = i2;
        this.mSize = i3;
    }

    public static p hu(int i2) {
        return cpY.get(Integer.valueOf(i2));
    }

    public static String c(p pVar) {
        switch (pVar) {
            case BOOLEAN:
                return "boolean[]";
            case CHAR:
                return "char[]";
            case FLOAT:
                return "float[]";
            case DOUBLE:
                return "double[]";
            case BYTE:
                return "byte[]";
            case SHORT:
                return "short[]";
            case INT:
                return "int[]";
            case LONG:
                return "long[]";
            default:
                throw new IllegalArgumentException("OBJECT type is not a primitive type");
        }
    }
}

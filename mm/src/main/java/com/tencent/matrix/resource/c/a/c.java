package com.tencent.matrix.resource.c.a;

import java.util.HashMap;
import java.util.Map;

public enum c {
    OBJECT(2, 0),
    BOOLEAN(4, 1),
    CHAR(5, 2),
    FLOAT(6, 4),
    DOUBLE(7, 8),
    BYTE(8, 1),
    SHORT(9, 2),
    INT(10, 4),
    LONG(11, 8);
    
    private static Map<Integer, c> cpY = new HashMap();
    private int mId;
    private int mSize;

    static {
        c[] values = values();
        for (c cVar : values) {
            cpY.put(Integer.valueOf(cVar.mId), cVar);
        }
    }

    private c(int i2, int i3) {
        this.mId = i2;
        this.mSize = i3;
    }

    public static c iu(int i2) {
        return cpY.get(Integer.valueOf(i2));
    }

    public final int getSize(int i2) {
        return this.mSize != 0 ? this.mSize : i2;
    }
}

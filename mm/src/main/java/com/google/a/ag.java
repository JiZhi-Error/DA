package com.google.a;

public enum ag {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(g.class, g.class, g.bNg),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    private final Object bTf;
    private final Class<?> bWR;
    final Class<?> bXC;

    private ag(Class cls, Class cls2, Object obj) {
        this.bWR = cls;
        this.bXC = cls2;
        this.bTf = obj;
    }
}

package com.google.a;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class r {
    private static volatile boolean bUg = false;
    private static final Class<?> bUh = Gb();
    private static volatile r bUi;
    static final r bUj = new r((byte) 0);
    private final Map<Object, Object<?, ?>> bUk;

    private static Class<?> Gb() {
        try {
            return Class.forName("com.google.a.n");
        } catch (ClassNotFoundException e2) {
            return null;
        }
    }

    public static boolean Gc() {
        return bUg;
    }

    public static r Gd() {
        r rVar = bUi;
        if (rVar == null) {
            synchronized (r.class) {
                rVar = bUi;
                if (rVar == null) {
                    rVar = q.Ga();
                    bUi = rVar;
                }
            }
        }
        return rVar;
    }

    r() {
        this.bUk = new HashMap();
    }

    r(r rVar) {
        if (rVar == bUj) {
            this.bUk = Collections.emptyMap();
        } else {
            this.bUk = Collections.unmodifiableMap(rVar.bUk);
        }
    }

    private r(byte b2) {
        this.bUk = Collections.emptyMap();
    }
}

package com.google.a;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* access modifiers changed from: package-private */
public final class bm {
    private static final bm bYM = new bm();
    private final bs bYN = new am();
    private final ConcurrentMap<Class<?>, br<?>> bYO = new ConcurrentHashMap();

    public static bm Hl() {
        return bYM;
    }

    private <T> br<T> H(Class<T> cls) {
        ae.checkNotNull(cls, "messageType");
        br<T> brVar = (br<T>) this.bYO.get(cls);
        if (brVar != null) {
            return brVar;
        }
        br<T> G = this.bYN.G(cls);
        ae.checkNotNull(cls, "messageType");
        ae.checkNotNull(G, "schema");
        br<T> brVar2 = (br<T>) this.bYO.putIfAbsent(cls, G);
        return brVar2 != null ? brVar2 : G;
    }

    public final <T> br<T> av(T t) {
        return H(t.getClass());
    }

    private bm() {
    }
}

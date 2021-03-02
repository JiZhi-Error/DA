package com.tencent.f.g.a;

import com.tencent.f.g.g;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a implements b {
    private static final HashMap<String, g.a> RUn = new HashMap<>();

    @Override // com.tencent.f.g.a.b
    public final g bqs(String str) {
        g.a aVar;
        synchronized (RUn) {
            aVar = RUn.get(str);
            if (aVar == null) {
                aVar = new g.a(str, new AtomicInteger());
                RUn.put(str, aVar);
            }
        }
        return new g(aVar);
    }

    @Override // com.tencent.f.g.a.b
    public void b(g gVar) {
    }

    @Override // com.tencent.f.g.a.b
    public final void d(g gVar) {
        int i2;
        AtomicInteger atomicInteger = gVar.RUb.RUd;
        do {
            i2 = atomicInteger.get();
        } while (!atomicInteger.compareAndSet(i2, i2 + 1));
    }

    @Override // com.tencent.f.g.a.b
    public void a(g gVar) {
        int i2;
        AtomicInteger atomicInteger = gVar.RUb.RUd;
        do {
            i2 = atomicInteger.get();
        } while (!atomicInteger.compareAndSet(i2, i2 - 1));
    }

    @Override // com.tencent.f.g.a.b
    public final Map<String, Integer> hmv() {
        HashMap hashMap = new HashMap();
        synchronized (RUn) {
            for (g.a aVar : RUn.values()) {
                int i2 = aVar.RUd.get();
                if (i2 > 0) {
                    hashMap.put(aVar.key, Integer.valueOf(i2));
                }
            }
        }
        return hashMap;
    }
}

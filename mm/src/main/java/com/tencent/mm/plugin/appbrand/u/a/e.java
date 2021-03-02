package com.tencent.mm.plugin.appbrand.u.a;

import android.support.v4.e.b;
import com.tencent.mm.plugin.appbrand.s;
import java.util.Map;
import java.util.Set;

public abstract class e {
    public final s cAJ;
    private final a nkd;
    private final Set<Integer> nke = new b();

    public interface a {
        void f(int i2, Map<String, Object> map);
    }

    /* access modifiers changed from: protected */
    public abstract void bPV();

    public abstract int getType();

    /* access modifiers changed from: protected */
    public abstract void removeListener();

    public e(a aVar, s sVar) {
        this.nkd = aVar;
        this.cAJ = sVar;
    }

    public final void listen(int i2) {
        boolean z;
        synchronized (this) {
            z = !this.nke.isEmpty();
            this.nke.add(Integer.valueOf(i2));
        }
        if (!z) {
            bPV();
        }
    }

    public final void unListen(int i2) {
        synchronized (this) {
            if (this.nke.contains(Integer.valueOf(i2))) {
                this.nke.remove(Integer.valueOf(i2));
            }
            if (this.nke.isEmpty()) {
                removeListener();
            }
        }
    }

    public final void aa(Map<String, Object> map) {
        for (Integer num : this.nke) {
            this.nkd.f(num.intValue(), map);
        }
    }
}

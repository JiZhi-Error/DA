package com.tencent.soter.a.g;

import com.tencent.soter.a.b.e;
import com.tencent.soter.a.c.b;
import com.tencent.soter.core.c.d;

/* access modifiers changed from: package-private */
public abstract class c extends d {
    c() {
    }

    protected static void hx(String str, int i2) {
        d.d("Soter.BaseSoterPrepareKeyTask", "soter: marking preference. key: %s, status: %d", str, Integer.valueOf(i2));
        synchronized (b.class) {
            if (b.hlG().hlJ() != null) {
                b.hlG().hlJ().edit().putInt(str, i2).commit();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.soter.a.g.d
    public final void b(e eVar) {
    }
}

package com.tencent.mm.plugin.appbrand.u.a;

import com.tencent.mm.ab.g;
import com.tencent.mm.ab.i;

public abstract class b implements a {

    public interface a {
        void ap(int i2, String str);
    }

    /* access modifiers changed from: protected */
    public abstract void a(i iVar, c cVar);

    public final String a(String str, c cVar) {
        try {
            a(new i(str), cVar);
            return null;
        } catch (g e2) {
            return cVar.bPU();
        }
    }
}

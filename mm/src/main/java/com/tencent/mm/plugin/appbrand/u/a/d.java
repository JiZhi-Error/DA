package com.tencent.mm.plugin.appbrand.u.a;

import com.tencent.mm.ab.g;
import com.tencent.mm.ab.i;

public abstract class d implements a {
    /* access modifiers changed from: protected */
    public abstract String b(i iVar, c cVar);

    public final String a(String str, c cVar) {
        try {
            return b(new i(str), cVar);
        } catch (g e2) {
            return cVar.bPU();
        }
    }
}

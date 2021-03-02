package com.tencent.mm.storage;

import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storagebase.h;

public abstract class e {
    public static n NOM;
    protected i NOL;

    public abstract String avu(String str);

    /* access modifiers changed from: protected */
    public boolean a(ca caVar, bp.b bVar) {
        return true;
    }

    public e(i iVar) {
        this.NOL = iVar;
    }

    public final h getDB() {
        return this.NOL.getDB();
    }

    /* access modifiers changed from: protected */
    public final void e(h hVar, String str) {
        this.NOL.e(hVar, str);
    }

    /* access modifiers changed from: protected */
    public final void a(i.b bVar) {
        this.NOL.a(bVar);
    }

    /* access modifiers changed from: protected */
    public final String aEO(String str) {
        return this.NOL.aEO(str);
    }

    /* access modifiers changed from: protected */
    public final void a(i.c cVar) {
        this.NOL.a(cVar);
    }

    /* access modifiers changed from: protected */
    public final void mO(String str, String str2) {
        this.NOL.c(str, str2, null);
    }
}

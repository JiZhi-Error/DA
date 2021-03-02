package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public abstract class b implements k {
    private boolean dbG;

    /* access modifiers changed from: protected */
    public abstract boolean axa();

    /* access modifiers changed from: protected */
    public abstract boolean onCreate();

    public b() {
        Log.i("MicroMsg.FTS.BaseFTS5SearchLogic", "Create %s", getName());
    }

    @Override // com.tencent.mm.plugin.fts.a.k
    public final boolean isCreated() {
        return this.dbG;
    }

    @Override // com.tencent.mm.plugin.fts.a.k
    public final synchronized void create() {
        Log.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnCreate %s | isCreated =%b", getName(), Boolean.valueOf(this.dbG));
        if (!this.dbG && onCreate()) {
            Log.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetCreated");
            this.dbG = true;
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.k
    public final void destroy() {
        Log.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnDestroy %s | isCreated %b", getName(), Boolean.valueOf(this.dbG));
        if (this.dbG && axa()) {
            Log.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetDestroyed");
            this.dbG = false;
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.k
    public void a(String str, m mVar, int i2, HashMap<String, String> hashMap) {
    }

    @Override // com.tencent.mm.plugin.fts.a.k
    public void addSOSHistory(String str, String str2) {
    }

    @Override // com.tencent.mm.plugin.fts.a.k
    public void deleteSOSHistory(String str) {
    }

    @Override // com.tencent.mm.plugin.fts.a.k
    public void deleteSOSHistory() {
    }

    @Override // com.tencent.mm.plugin.fts.a.k
    public a a(j jVar) {
        return null;
    }
}

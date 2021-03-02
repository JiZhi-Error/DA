package com.tencent.mm.plugin.webview.model;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.sdk.platformtools.RWCache;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;

public final class g implements RWCache.IRWCacheAppender<Integer, Long> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(kLR, "JsLogBlockList")};
    private static final IAutoDBItem.MAutoDBInfo kLR = dy.ajs();
    public final RWCache<Integer, Long> IXB = new RWCache<>(this, com.tencent.mm.kernel.g.aAk().getLooper(), 100, 20, 300000, 1000);
    private long IXC;
    public final h iFy;

    static {
        AppMethodBeat.i(78860);
        AppMethodBeat.o(78860);
    }

    public g(h hVar) {
        AppMethodBeat.i(78855);
        this.iFy = hVar;
        AppMethodBeat.o(78855);
    }

    public final void gct() {
        AppMethodBeat.i(78856);
        this.IXB.appendAll(true);
        AppMethodBeat.o(78856);
    }

    @Override // com.tencent.mm.sdk.platformtools.RWCache.IRWCacheAppender
    public final boolean preAppend() {
        AppMethodBeat.i(78857);
        if (this.iFy.inTransaction()) {
            AppMethodBeat.o(78857);
            return false;
        }
        this.IXC = this.iFy.beginTransaction(Thread.currentThread().getId());
        if (this.IXC > 0) {
            AppMethodBeat.o(78857);
            return true;
        }
        AppMethodBeat.o(78857);
        return false;
    }

    @Override // com.tencent.mm.sdk.platformtools.RWCache.IRWCacheAppender
    public final void append(RWCache<Integer, Long> rWCache, RWCache.Holder<Integer, Long> holder) {
        AppMethodBeat.i(210972);
        switch (holder.funcType) {
            case 2:
                this.iFy.delete("JsLogBlockList", "logId=" + ((Object) holder.key), null);
                AppMethodBeat.o(210972);
                return;
            case 1:
                ContentValues contentValues = new ContentValues(2);
                contentValues.put("logId", (Integer) holder.key);
                contentValues.put("liftTime", (Long) holder.values);
                this.iFy.replace("JsLogBlockList", "logId", contentValues);
                break;
        }
        AppMethodBeat.o(210972);
    }

    @Override // com.tencent.mm.sdk.platformtools.RWCache.IRWCacheAppender
    public final void postAppend() {
        AppMethodBeat.i(78859);
        if (this.IXC > 0) {
            this.iFy.endTransaction(this.IXC);
        }
        AppMethodBeat.o(78859);
    }
}

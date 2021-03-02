package com.tencent.mm.plugin.downloader_app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.plugin.downloader_app.c.c;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class d implements a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.downloader_app.api.d {
    private c qKm;

    @Override // com.tencent.mm.plugin.downloader_app.api.d
    public final c cBU() {
        return this.qKm;
    }

    @Override // com.tencent.mm.kernel.api.a
    public final HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(8780);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("DOWNLOADTASKITEM_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.downloader_app.d.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return c.SQL_CREATE;
            }
        });
        AppMethodBeat.o(8780);
        return hashMap;
    }

    @Override // com.tencent.mm.kernel.api.e
    public final void onDataBaseOpened(h hVar, h hVar2) {
        AppMethodBeat.i(8781);
        this.qKm = new c(hVar);
        AppMethodBeat.o(8781);
    }

    @Override // com.tencent.mm.kernel.api.e
    public final void onDataBaseClosed(h hVar, h hVar2) {
    }
}

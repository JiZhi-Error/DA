package com.tencent.mm.plugin.cdndownloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.plugin.cdndownloader.f.c;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class a implements com.tencent.mm.kernel.api.bucket.a, d, com.tencent.mm.plugin.cdndownloader.b.a {
    private c qmm;

    @Override // com.tencent.mm.plugin.cdndownloader.b.a
    public final c cxT() {
        return this.qmm;
    }

    @Override // com.tencent.mm.kernel.api.a
    public final HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(120691);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("CdnDownloadInfo".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.cdndownloader.a.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return c.SQL_CREATE;
            }
        });
        AppMethodBeat.o(120691);
        return hashMap;
    }

    @Override // com.tencent.mm.kernel.api.e
    public final void onDataBaseOpened(h hVar, h hVar2) {
        AppMethodBeat.i(120692);
        this.qmm = new c(hVar);
        AppMethodBeat.o(120692);
    }

    @Override // com.tencent.mm.kernel.api.e
    public final void onDataBaseClosed(h hVar, h hVar2) {
    }
}

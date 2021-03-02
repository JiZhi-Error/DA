package com.tencent.mm.plugin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class a implements com.tencent.mm.kernel.api.bucket.a, d, com.tencent.mm.plugin.m.a.a {
    private bz zoA;

    @Override // com.tencent.mm.plugin.m.a.a
    public final bz aSV() {
        AppMethodBeat.i(151497);
        g.aAi();
        g.aAf().azk();
        bz bzVar = this.zoA;
        AppMethodBeat.o(151497);
        return bzVar;
    }

    @Override // com.tencent.mm.kernel.api.e
    public final void onDataBaseOpened(h hVar, h hVar2) {
        AppMethodBeat.i(151498);
        this.zoA = new bz(hVar);
        AppMethodBeat.o(151498);
    }

    @Override // com.tencent.mm.kernel.api.e
    public final void onDataBaseClosed(h hVar, h hVar2) {
    }

    @Override // com.tencent.mm.kernel.api.a
    public final HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(151499);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("MediaCheckDumplicationStorage".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.m.a.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return bz.SQL_CREATE;
            }
        });
        AppMethodBeat.o(151499);
        return hashMap;
    }
}

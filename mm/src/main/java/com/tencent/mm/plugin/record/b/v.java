package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class v implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    static {
        AppMethodBeat.i(27827);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("RECORD_MSG_INFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.record.b.v.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.record.a.h.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("RECORD_MSG_CDN_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.record.b.v.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return e.SQL_CREATE;
            }
        });
        AppMethodBeat.o(27827);
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(27826);
        g.b(com.tencent.mm.plugin.record.a.g.class, new m());
        AppMethodBeat.o(27826);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
    }
}

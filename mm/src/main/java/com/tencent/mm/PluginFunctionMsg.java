package com.tencent.mm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.api.y;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.z;
import com.tencent.mm.r.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class PluginFunctionMsg extends f implements y, a, c {
    private static HashMap<Integer, h.b> dgj = new HashMap<>();
    private b dgi = new b();

    public PluginFunctionMsg() {
        AppMethodBeat.i(114088);
        AppMethodBeat.o(114088);
    }

    @Override // com.tencent.mm.api.y
    public com.tencent.mm.u.a getReceiver() {
        return com.tencent.mm.u.a.heN;
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(114089);
        super.configure(gVar);
        com.tencent.mm.kernel.g.b(i.class, getReceiver());
        AppMethodBeat.o(114089);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(114090);
        if (gVar.aBb()) {
            ((k) com.tencent.mm.kernel.g.af(k.class)).addSyncDoCmdCallback(new z() {
                /* class com.tencent.mm.PluginFunctionMsg.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.messenger.foundation.a.z
                public final void aQ(Object obj) {
                    AppMethodBeat.i(114085);
                    PluginFunctionMsg.this.getReceiver();
                    if (com.tencent.mm.u.a.isInit) {
                        com.tencent.mm.u.a.awG();
                        com.tencent.mm.u.a.isInit = false;
                    }
                    Log.i("FunctionMsg.FunctionMsgEngine", "[beforeSyncDoCmd] isInit:" + com.tencent.mm.u.a.isInit);
                    AppMethodBeat.o(114085);
                }

                @Override // com.tencent.mm.plugin.messenger.foundation.a.z
                public final void aR(Object obj) {
                    AppMethodBeat.i(114086);
                    PluginFunctionMsg.this.getReceiver();
                    if (com.tencent.mm.u.a.awF()) {
                        com.tencent.mm.u.a.heK.awI();
                        com.tencent.mm.u.a.dfO = System.currentTimeMillis();
                        com.tencent.mm.u.a.heL = false;
                        Log.i("FunctionMsg.FunctionMsgEngine", "[afterSyncDoCmd] check time:%s", Long.valueOf(System.currentTimeMillis()));
                    }
                    AppMethodBeat.o(114086);
                }

                @Override // com.tencent.mm.plugin.messenger.foundation.a.z
                public final void aS(Object obj) {
                    AppMethodBeat.i(114087);
                    PluginFunctionMsg.this.getReceiver();
                    if (com.tencent.mm.u.a.awF()) {
                        com.tencent.mm.u.a.heK.awI();
                        com.tencent.mm.u.a.dfO = System.currentTimeMillis();
                        com.tencent.mm.u.a.heL = false;
                        Log.i("FunctionMsg.FunctionMsgEngine", "[finishSyncDoCmd] check time:%s", Long.valueOf(System.currentTimeMillis()));
                    }
                    AppMethodBeat.o(114087);
                }
            });
        }
        AppMethodBeat.o(114090);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(114091);
        g.a.a(this.dgi);
        AppMethodBeat.o(114091);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(114092);
        g.a.b(this.dgi);
        AppMethodBeat.o(114092);
    }

    static {
        AppMethodBeat.i(114094);
        final String[] strArr = {MAutoStorage.getCreateSQLs(com.tencent.mm.api.i.info, "FunctionMsgItem")};
        dgj.put(Integer.valueOf("FunctionMsgItem".hashCode()), new h.b() {
            /* class com.tencent.mm.PluginFunctionMsg.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return strArr;
            }
        });
        AppMethodBeat.o(114094);
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        return dgj;
    }
}

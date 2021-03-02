package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.plugin.game.c.d;
import com.tencent.mm.plugin.game.model.a.g;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class f implements a, d, com.tencent.mm.plugin.game.api.f {
    private s xtN;
    private w xtO;
    private g xtP;
    private com.tencent.mm.plugin.game.media.g xtQ;
    private com.tencent.mm.plugin.game.media.d xtR;
    private com.tencent.mm.plugin.game.c.d xtS;

    @Override // com.tencent.mm.kernel.api.e
    public final void onDataBaseOpened(h hVar, h hVar2) {
        AppMethodBeat.i(40846);
        Log.i("MicroMsg.GameStorage", "GameStorage onDataBaseOpened");
        this.xtN = new s(hVar);
        this.xtP = new g(hVar);
        this.xtQ = new com.tencent.mm.plugin.game.media.g(hVar);
        this.xtR = new com.tencent.mm.plugin.game.media.d(hVar);
        this.xtS = new com.tencent.mm.plugin.game.c.d(hVar);
        AppMethodBeat.o(40846);
    }

    @Override // com.tencent.mm.kernel.api.a
    public final HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(40847);
        Log.i("MicroMsg.GameStorage", "GameStorage collectDatabaseFactory");
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("GAME_CENTER_MSG_INFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.game.f.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return s.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("GAME_CENTER_PB_CACHE_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.game.f.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return w.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("GAME_CENTER_SILENT_DOWNLOAD_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.game.f.AnonymousClass3 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return g.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("GAME_HAOWAN_EDITION".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.game.f.AnonymousClass4 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.game.media.g.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("GAME_HAOWAN_MEDIA".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.game.f.AnonymousClass5 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.game.media.d.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("GAME_RESOURCE_DOWNLOAD".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.game.f.AnonymousClass6 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                AppMethodBeat.i(204094);
                d.a aVar = com.tencent.mm.plugin.game.c.d.xvT;
                String[] dax = com.tencent.mm.plugin.game.c.d.dax();
                AppMethodBeat.o(204094);
                return dax;
            }
        });
        AppMethodBeat.o(40847);
        return hashMap;
    }

    @Override // com.tencent.mm.kernel.api.e
    public final void onDataBaseClosed(h hVar, h hVar2) {
    }

    @Override // com.tencent.mm.plugin.game.api.f
    public final s dSK() {
        AppMethodBeat.i(40848);
        com.tencent.mm.kernel.g.aAf().azk();
        if (this.xtN == null) {
            com.tencent.mm.kernel.g.aAi();
            this.xtN = new s(com.tencent.mm.kernel.g.aAh().hqK);
        }
        s sVar = this.xtN;
        AppMethodBeat.o(40848);
        return sVar;
    }

    @Override // com.tencent.mm.plugin.game.api.f
    public final w dSL() {
        AppMethodBeat.i(40849);
        com.tencent.mm.kernel.g.aAf().azk();
        if (this.xtO == null) {
            com.tencent.mm.kernel.g.aAi();
            this.xtO = new w(com.tencent.mm.kernel.g.aAh().hqK);
        }
        w wVar = this.xtO;
        AppMethodBeat.o(40849);
        return wVar;
    }

    @Override // com.tencent.mm.plugin.game.api.f
    public final g dSM() {
        AppMethodBeat.i(40850);
        com.tencent.mm.kernel.g.aAf().azk();
        if (this.xtP == null) {
            com.tencent.mm.kernel.g.aAi();
            this.xtP = new g(com.tencent.mm.kernel.g.aAh().hqK);
        }
        g gVar = this.xtP;
        AppMethodBeat.o(40850);
        return gVar;
    }

    @Override // com.tencent.mm.plugin.game.api.f
    public final com.tencent.mm.plugin.game.media.g dSN() {
        AppMethodBeat.i(40851);
        com.tencent.mm.kernel.g.aAf().azk();
        if (this.xtQ == null) {
            com.tencent.mm.kernel.g.aAi();
            this.xtQ = new com.tencent.mm.plugin.game.media.g(com.tencent.mm.kernel.g.aAh().hqK);
        }
        com.tencent.mm.plugin.game.media.g gVar = this.xtQ;
        AppMethodBeat.o(40851);
        return gVar;
    }

    @Override // com.tencent.mm.plugin.game.api.f
    public final com.tencent.mm.plugin.game.media.d dSO() {
        AppMethodBeat.i(40852);
        com.tencent.mm.kernel.g.aAf().azk();
        if (this.xtR == null) {
            com.tencent.mm.kernel.g.aAi();
            this.xtR = new com.tencent.mm.plugin.game.media.d(com.tencent.mm.kernel.g.aAh().hqK);
        }
        com.tencent.mm.plugin.game.media.d dVar = this.xtR;
        AppMethodBeat.o(40852);
        return dVar;
    }

    @Override // com.tencent.mm.plugin.game.api.f
    public final com.tencent.mm.plugin.game.c.d dSP() {
        AppMethodBeat.i(204095);
        com.tencent.mm.kernel.g.aAf().azk();
        if (this.xtS == null) {
            com.tencent.mm.kernel.g.aAi();
            this.xtS = new com.tencent.mm.plugin.game.c.d(com.tencent.mm.kernel.g.aAh().hqK);
        }
        com.tencent.mm.plugin.game.c.d dVar = this.xtS;
        AppMethodBeat.o(204095);
        return dVar;
    }
}

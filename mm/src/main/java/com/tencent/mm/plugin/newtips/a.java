package com.tencent.mm.plugin.newtips;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.newtips.a.e;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.l;
import com.tencent.mm.plugin.newtips.b.b;
import com.tencent.mm.plugin.newtips.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class a extends y implements com.tencent.mm.kernel.api.bucket.a, c {
    private static a ACO;
    private static HashMap<Integer, h.b> baseDBFactories;
    private i ACP = null;
    private b ACQ = null;
    private d ACR = null;
    private e ACS = null;
    private l ACT = new l();

    private a() {
        super(c.class);
        AppMethodBeat.i(127199);
        AppMethodBeat.o(127199);
    }

    public static synchronized a exj() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(127200);
            if (ACO == null) {
                ACO = new a();
            }
            aVar = ACO;
            AppMethodBeat.o(127200);
        }
        return aVar;
    }

    static {
        AppMethodBeat.i(127207);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("NEWTIPSCOMPAT_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.newtips.a.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return b.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("NEWTIPS_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.newtips.a.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return d.SQL_CREATE;
            }
        });
        AppMethodBeat.o(127207);
    }

    @Override // com.tencent.mm.model.y, com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(127201);
        super.onAccountInitialized(cVar);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("newtips", this.ACT);
        exl();
        int i2 = com.tencent.mm.plugin.newtips.a.d.ADb;
        String str = com.tencent.mm.plugin.newtips.a.d.ADi;
        i.f(i2, com.tencent.mm.plugin.newtips.a.d.ADa, "", str);
        Log.i("MicroMsg.NewTips.NewTipsManager", "dancy register dynamic newtips, tipsId:%s, path:%s", Integer.valueOf(i2), str);
        AppMethodBeat.o(127201);
    }

    @Override // com.tencent.mm.model.y, com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(127202);
        super.onAccountRelease();
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("newtips", this.ACT);
        AppMethodBeat.o(127202);
    }

    public static l exk() {
        AppMethodBeat.i(188556);
        g.aAf().azk();
        if (exj().ACP == null) {
            exj().ACP = new i();
        }
        l lVar = exj().ACT;
        AppMethodBeat.o(188556);
        return lVar;
    }

    public static i exl() {
        AppMethodBeat.i(127203);
        g.aAf().azk();
        if (exj().ACP == null) {
            exj().ACP = new i();
        }
        i iVar = exj().ACP;
        AppMethodBeat.o(127203);
        return iVar;
    }

    public static b exm() {
        AppMethodBeat.i(127204);
        g.aAf().azk();
        if (exj().ACQ == null) {
            a exj = exj();
            g.aAi();
            exj.ACQ = new b(g.aAh().hqK);
        }
        b bVar = exj().ACQ;
        AppMethodBeat.o(127204);
        return bVar;
    }

    public static d exn() {
        AppMethodBeat.i(127205);
        g.aAf().azk();
        if (exj().ACR == null) {
            a exj = exj();
            g.aAi();
            exj.ACR = new d(g.aAh().hqK);
        }
        d dVar = exj().ACR;
        AppMethodBeat.o(127205);
        return dVar;
    }

    public static com.tencent.mm.plugin.newtips.a.e exo() {
        AppMethodBeat.i(127206);
        g.aAf().azk();
        if (exj().ACS == null) {
            exj().ACS = new com.tencent.mm.plugin.newtips.a.e();
        }
        com.tencent.mm.plugin.newtips.a.e eVar = exj().ACS;
        AppMethodBeat.o(127206);
        return eVar;
    }

    @Override // com.tencent.mm.model.y, com.tencent.mm.kernel.api.a
    public final HashMap<Integer, h.b> collectDatabaseFactory() {
        return baseDBFactories;
    }
}

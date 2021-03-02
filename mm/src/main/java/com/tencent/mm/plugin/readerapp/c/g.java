package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.List;

public class g implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private bw BBY;
    private c BBZ = new c();
    private a BCa = new a();
    private d BCb = new d();
    private f BCc = new f();

    public interface a {
        void eHF();
    }

    public g() {
        AppMethodBeat.i(102673);
        AppMethodBeat.o(102673);
    }

    static /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(102686);
        c(aVar);
        AppMethodBeat.o(102686);
    }

    private static g eHH() {
        AppMethodBeat.i(102674);
        g gVar = (g) y.at(g.class);
        AppMethodBeat.o(102674);
        return gVar;
    }

    public static bw eHI() {
        AppMethodBeat.i(102675);
        com.tencent.mm.kernel.g.aAf().azk();
        if (eHH().BBY == null) {
            eHH().BBY = new bw(com.tencent.mm.kernel.g.aAh().hqK);
        }
        bw bwVar = eHH().BBY;
        AppMethodBeat.o(102675);
        return bwVar;
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(102676);
        g.a.b(this.BBZ);
        EventCenter.instance.removeListener(this.BCa);
        EventCenter.instance.removeListener(this.BCb);
        EventCenter.instance.removeListener(this.BCc);
        e eVar = e.BBX;
        AppMethodBeat.o(102676);
    }

    static {
        AppMethodBeat.i(102687);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("READERAPPINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.readerapp.c.g.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return bw.SQL_CREATE;
            }
        });
        AppMethodBeat.o(102687);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
        AppMethodBeat.i(102677);
        if ((524288 & i2) != 0) {
            a(null);
        }
        if ((262144 & i2) != 0) {
            b(null);
        }
        AppMethodBeat.o(102677);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(102678);
        eHI().sh(20);
        ((l) com.tencent.mm.kernel.g.af(l.class)).aST().bjW("newsapp");
        a(20, aVar);
        AppMethodBeat.o(102678);
    }

    public static void b(a aVar) {
        AppMethodBeat.i(102679);
        eHI().sh(11);
        ((l) com.tencent.mm.kernel.g.af(l.class)).aST().bjW("blogapp");
        a(11, aVar);
        AppMethodBeat.o(102679);
    }

    public static void HP(long j2) {
        AppMethodBeat.i(102680);
        fZ(eHI().Ae(j2));
        AppMethodBeat.o(102680);
    }

    public static void fi(String str, int i2) {
        AppMethodBeat.i(102681);
        fZ(eHI().al(str, i2));
        AppMethodBeat.o(102681);
    }

    private static void fZ(List<bv> list) {
        AppMethodBeat.i(102682);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(102682);
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            Util.deleteFile(s.bdu(list.get(i2).aWd()));
        }
        AppMethodBeat.o(102682);
    }

    private static void c(final a aVar) {
        AppMethodBeat.i(102683);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.readerapp.c.g.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(102668);
                if (aVar != null) {
                    aVar.eHF();
                }
                AppMethodBeat.o(102668);
            }
        });
        AppMethodBeat.o(102683);
    }

    private static void a(final int i2, final a aVar) {
        AppMethodBeat.i(102684);
        if (!com.tencent.mm.kernel.g.aAc()) {
            c(aVar);
            AppMethodBeat.o(102684);
            return;
        }
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.readerapp.c.g.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(102669);
                o oVar = new o(d.aSY());
                if (!oVar.exists() || !oVar.isDirectory()) {
                    g.d(aVar);
                    AppMethodBeat.o(102669);
                    return;
                }
                o[] het = oVar.het();
                if (het == null || het.length <= 0) {
                    g.d(aVar);
                    AppMethodBeat.o(102669);
                    return;
                }
                String format = String.format("reader_%d_", Integer.valueOf(i2));
                String format2 = String.format("ReaderApp_%d", Integer.valueOf(i2));
                for (int i2 = 0; i2 < het.length; i2++) {
                    if (het[i2].getName().startsWith(format)) {
                        het[i2].delete();
                    }
                    if (het[i2].getName().startsWith(format2)) {
                        het[i2].delete();
                    }
                }
                g.d(aVar);
                AppMethodBeat.o(102669);
            }

            public final String toString() {
                AppMethodBeat.i(102670);
                String str = super.toString() + "|deleteAllPic";
                AppMethodBeat.o(102670);
                return str;
            }
        });
        AppMethodBeat.o(102684);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(102685);
        g.a.a(this.BBZ);
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.readerapp.c.g.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(102671);
                if (!com.tencent.mm.kernel.g.aAc()) {
                    AppMethodBeat.o(102671);
                    return;
                }
                Util.deleteOutOfDateFile(d.aSY(), "ReaderApp_", 604800000);
                AppMethodBeat.o(102671);
            }

            public final String toString() {
                AppMethodBeat.i(102672);
                String str = super.toString() + "|onAccountPostReset";
                AppMethodBeat.o(102672);
                return str;
            }
        });
        EventCenter.instance.addListener(this.BCa);
        EventCenter.instance.addListener(this.BCb);
        EventCenter.instance.addListener(this.BCc);
        e eVar = e.BBX;
        AppMethodBeat.o(102685);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }
}

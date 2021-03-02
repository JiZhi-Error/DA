package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.bh.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class b implements bd {
    private d FPA = new d();
    public c FPB = new c();
    private e FPC;
    f FPD;
    private p FPE = new p.a() {
        /* class com.tencent.mm.plugin.talkroom.model.b.AnonymousClass1 */

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(29438);
            if (i2 != 4) {
                AppMethodBeat.o(29438);
                return;
            }
            new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.tencent.mm.plugin.talkroom.model.b.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(29437);
                    if (b.this.FPz != null) {
                        b.this.FPz.wi(false);
                    }
                    AppMethodBeat.o(29437);
                }
            });
            AppMethodBeat.o(29438);
        }
    };
    g FPz;

    public b() {
        AppMethodBeat.i(29439);
        AppMethodBeat.o(29439);
    }

    public static b ftM() {
        AppMethodBeat.i(29440);
        bg.aVz();
        b bVar = (b) cg.KG("plugin.talkroom");
        if (bVar == null) {
            bVar = new b();
            bg.aVz().a("plugin.talkroom", bVar);
        }
        AppMethodBeat.o(29440);
        return bVar;
    }

    public static g ftN() {
        AppMethodBeat.i(29441);
        if (ftM().FPz == null) {
            ftM().FPz = new g();
        }
        g gVar = ftM().FPz;
        AppMethodBeat.o(29441);
        return gVar;
    }

    public static e ftO() {
        AppMethodBeat.i(29442);
        if (ftM().FPC == null) {
            ftM().FPC = new e();
        }
        e eVar = ftM().FPC;
        AppMethodBeat.o(29442);
        return eVar;
    }

    public static String ftP() {
        AppMethodBeat.i(29443);
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        String sb2 = sb.append(c.azM()).append("talkroom/").toString();
        AppMethodBeat.o(29443);
        return sb2;
    }

    public static f ftQ() {
        AppMethodBeat.i(29444);
        if (ftM().FPD == null) {
            ftM().FPD = new f();
        }
        f fVar = ftM().FPD;
        AppMethodBeat.o(29444);
        return fVar;
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(29445);
        h.d.a(56, this.FPA);
        bg.a(this.FPE);
        g.jpy = ftO();
        g.jpz = ftN();
        g.jpy.bgs();
        AppMethodBeat.o(29445);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(29446);
        h.d.b(56, this.FPA);
        bg.b(this.FPE);
        g.jpy = null;
        g.jpz = null;
        if (this.FPz != null) {
            this.FPz.fub();
            this.FPz = null;
        }
        AppMethodBeat.o(29446);
    }
}

package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.a;
import com.tencent.mm.ba.o;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cb;
import com.tencent.mm.storage.cj;
import com.tencent.mm.storage.cm;
import com.tencent.mm.storage.co;
import com.tencent.mm.storage.ct;
import com.tencent.smtt.sdk.TbsListener;
import java.util.HashMap;

public final class d implements c, l {
    ba zpA;
    o zpB;
    a zpC;
    cj zpD;
    bd zpE;
    bo zpF;
    bm zpG;
    by zpH;
    cm zpI;
    ct zpJ;
    ak zpK;
    bu zpL;
    ay zpw;
    co zpx;
    br zpy;
    cb zpz;

    @Override // com.tencent.mm.plugin.messenger.foundation.a.l
    public final h eis() {
        AppMethodBeat.i(116879);
        g.aAi();
        g.aAf().azk();
        a aVar = this.zpC;
        AppMethodBeat.o(116879);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.l
    public final b eit() {
        AppMethodBeat.i(116880);
        g.aAi();
        g.aAf().azk();
        ak akVar = this.zpK;
        AppMethodBeat.o(116880);
        return akVar;
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(116881);
        if (this.zpw != null) {
            ay ayVar = this.zpw;
            ayVar.OoH.clear();
            ayVar.OoI.clear();
        }
        if (this.zpB != null) {
            o oVar = this.zpB;
            oVar.bGH = new HashMap<>();
            g.aAi();
            g.aAg().hqi.b(com.tencent.mm.plugin.appbrand.jsapi.pay.d.CTRL_INDEX, oVar);
            g.aAi();
            g.aAg().hqi.b(TbsListener.ErrorCode.INFO_OPEN_FILE_MINIQB_INIT_FAILED, oVar);
        }
        AppMethodBeat.o(116881);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.l
    public final /* bridge */ /* synthetic */ com.tencent.mm.plugin.messenger.foundation.a.a.o bdR() {
        return this.zpL;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.l
    public final /* synthetic */ m eiu() {
        AppMethodBeat.i(116882);
        g.aAi();
        g.aAf().azk();
        cm cmVar = this.zpI;
        AppMethodBeat.o(116882);
        return cmVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.l
    public final /* synthetic */ com.tencent.mm.plugin.messenger.foundation.a.a.g eiv() {
        AppMethodBeat.i(116883);
        g.aAi();
        g.aAf().azk();
        by byVar = this.zpH;
        AppMethodBeat.o(116883);
        return byVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.l
    public final /* synthetic */ com.tencent.mm.plugin.messenger.foundation.a.a.d eiw() {
        AppMethodBeat.i(116884);
        g.aAi();
        g.aAf().azk();
        bm bmVar = this.zpG;
        AppMethodBeat.o(116884);
        return bmVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.l
    public final /* synthetic */ com.tencent.mm.plugin.messenger.foundation.a.a.e eix() {
        AppMethodBeat.i(116885);
        g.aAi();
        g.aAf().azk();
        bo boVar = this.zpF;
        AppMethodBeat.o(116885);
        return boVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.l
    public final /* synthetic */ com.tencent.mm.plugin.messenger.foundation.a.a.c aTq() {
        AppMethodBeat.i(116886);
        g.aAi();
        g.aAf().azk();
        bd bdVar = this.zpE;
        AppMethodBeat.o(116886);
        return bdVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.l
    public final /* synthetic */ com.tencent.mm.plugin.messenger.foundation.a.a.l aSW() {
        AppMethodBeat.i(116887);
        g.aAi();
        g.aAf().azk();
        cj cjVar = this.zpD;
        AppMethodBeat.o(116887);
        return cjVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.l
    public final /* synthetic */ bw aST() {
        AppMethodBeat.i(116888);
        g.aAi();
        g.aAf().azk();
        ba baVar = this.zpA;
        AppMethodBeat.o(116888);
        return baVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.l
    public final /* synthetic */ i eiy() {
        AppMethodBeat.i(116889);
        g.aAi();
        g.aAf().azk();
        cb cbVar = this.zpz;
        AppMethodBeat.o(116889);
        return cbVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.l
    public final /* synthetic */ f aSP() {
        AppMethodBeat.i(187479);
        g.aAi();
        g.aAf().azk();
        br brVar = this.zpy;
        AppMethodBeat.o(187479);
        return brVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.l
    public final /* synthetic */ n aSO() {
        AppMethodBeat.i(116890);
        g.aAi();
        g.aAf().azk();
        co coVar = this.zpx;
        AppMethodBeat.o(116890);
        return coVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.l
    public final /* synthetic */ bv aSN() {
        AppMethodBeat.i(116891);
        g.aAi();
        g.aAf().azk();
        ay ayVar = this.zpw;
        AppMethodBeat.o(116891);
        return ayVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.l
    public final /* synthetic */ j aSM() {
        AppMethodBeat.i(116892);
        g.aAi();
        g.aAf().azk();
        o oVar = this.zpB;
        AppMethodBeat.o(116892);
        return oVar;
    }
}

package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.b;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.ui.a.k;
import com.tencent.mm.plugin.fts.ui.a.s;
import com.tencent.mm.plugin.fts.ui.a.t;
import com.tencent.mm.plugin.fts.ui.c.d;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.dsy;
import com.tencent.mm.protocal.protobuf.dsz;
import com.tencent.mm.protocal.protobuf.fdw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.util.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class n extends b implements i {
    String query;
    private int wXD = Integer.MAX_VALUE;
    private int wXF = Integer.MAX_VALUE;
    public long wXS;
    long xaI;
    long xbf;
    private d xeM;
    private dsz xeN;
    private MMHandler xeO = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.fts.ui.d.n.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(112220);
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    if (message.obj.equals(Long.valueOf(n.this.xbf))) {
                        n.this.wXS = System.currentTimeMillis();
                        Log.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "cancel Time %d", Long.valueOf(n.this.wXS - n.this.xaI));
                        n.this.wXC.a(n.this, n.this.query);
                        n.this.dOG();
                        n.this.clearData();
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(112220);
        }
    };

    public n(Context context, e.b bVar, int i2) {
        super(context, bVar, i2);
        AppMethodBeat.i(112221);
        AppMethodBeat.o(112221);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final void a(String str, MMHandler mMHandler, HashSet<String> hashSet, long j2) {
        AppMethodBeat.i(112222);
        b.a aVar = b.a.clicfg_wanet_search;
        c cVar = c.QYz;
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(aVar, c.hdd()) == 0) {
            this.wXC.a(this, str);
            AppMethodBeat.o(112222);
            return;
        }
        this.query = str;
        if (this.xeM != null) {
            g.azz().a(this.xeM);
            g.azz().b(2599, this);
            this.xeM = null;
        }
        dsy dsy = new dsy();
        dsy.KXA = str;
        dsy.MRu = j2;
        dsy.MRz = com.tencent.mm.plugin.fts.a.e.wVm;
        dsy.MVb = true;
        dsy.MVa = 25;
        this.xbf = j2;
        chl clJ = ai.clJ();
        if (clJ != null) {
            dsy.MVc = new fdw();
            dsy.MVc.LbD = clJ.LbD;
            dsy.MVc.LbC = clJ.LbC;
        }
        this.xeM = new d(dsy);
        g.azz().a(2599, this);
        g.azz().a(this.xeM, 0);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_wanet_cgi_timeout, 500);
        this.xaI = System.currentTimeMillis();
        this.xeO.removeMessages(1);
        this.xeO.sendMessageDelayed(this.xeO.obtainMessage(1, Long.valueOf(j2)), (long) a2);
        AppMethodBeat.o(112222);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final void dOG() {
        AppMethodBeat.i(112223);
        if (this.xeM != null) {
            g.azz().a(this.xeM);
            g.azz().b(2599, this);
            this.xeM = null;
        }
        this.xeO.removeMessages(1);
        AppMethodBeat.o(112223);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final int Nn(int i2) {
        int i3;
        AppMethodBeat.i(112224);
        if (this.xeN == null || this.xeN.KKx.size() <= 0) {
            this.wXD = Integer.MAX_VALUE;
            this.wXF = Integer.MAX_VALUE;
            i3 = i2;
        } else {
            this.wXD = i2;
            i3 = i2 + 1 + this.xeN.KKx.size();
            if (this.xeN.LYI) {
                this.wXF = i3;
                i3++;
            } else {
                this.wXF = Integer.MAX_VALUE;
            }
        }
        Log.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "updateHeaderPosition curPos %d oriPos %d headerPosition %d morePosition %d", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(this.wXD), Integer.valueOf(this.wXF));
        AppMethodBeat.o(112224);
        return i3;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final LinkedList<Integer> dOH() {
        AppMethodBeat.i(112225);
        LinkedList<Integer> linkedList = new LinkedList<>();
        if (this.wXD != Integer.MAX_VALUE) {
            linkedList.add(Integer.valueOf(this.wXD));
        }
        AppMethodBeat.o(112225);
        return linkedList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: com.tencent.mm.plugin.fts.ui.a.t */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final a No(int i2) {
        k kVar;
        boolean z;
        AppMethodBeat.i(112226);
        if (i2 == this.wXD) {
            kVar = new k(i2);
        } else if (i2 == this.wXF) {
            t tVar = new t(i2);
            tVar.xdP = this.xeN.KKx.get(0);
            tVar.xee = this.xeN.MVd;
            tVar.wXT = true;
            tVar.wXM = 2;
            kVar = tVar;
        } else if (i2 == this.wXD + 1) {
            s sVar = new s(i2);
            sVar.xdP = this.xeN.KKx.get(0);
            sVar.wXT = true;
            sVar.wXM = 1;
            kVar = sVar;
        } else {
            kVar = null;
        }
        if (kVar != null) {
            kVar.rjr = -20;
            kVar.mve = this.mve;
            kVar.wXK = false;
            kVar.wWd = h.bE(this.query, false);
        }
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i2);
        if (kVar != null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(this.wXD);
        objArr[3] = Integer.valueOf(this.wXF);
        Log.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "createDataItem position %d %s %d %d", objArr);
        AppMethodBeat.o(112226);
        return kVar;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final void clearData() {
        this.xbf = 0;
        this.query = null;
        this.xeN = null;
        this.wXD = Integer.MAX_VALUE;
        this.wXF = Integer.MAX_VALUE;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final int getType() {
        return 256;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final int dOI() {
        int i2 = 0;
        AppMethodBeat.i(112227);
        if (this.xeN == null) {
            AppMethodBeat.o(112227);
            return 0;
        } else if (this.xeN.KKx.size() > 0) {
            if (this.xeN.LYI) {
                i2 = 1;
            }
            int i3 = i2 + 1;
            AppMethodBeat.o(112227);
            return i3;
        } else {
            AppMethodBeat.o(112227);
            return 0;
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e, com.tencent.mm.plugin.fts.a.d.b
    public final int dOF() {
        AppMethodBeat.i(112228);
        if (this.xeN != null && this.xeN.KKx.size() > 0) {
            try {
                if ("HOME".equals(new JSONObject(this.xeN.KKx.get(0).NzC).optString(FirebaseAnalytics.b.CONTENT_TYPE, ""))) {
                    AppMethodBeat.o(112228);
                    return 2;
                }
                AppMethodBeat.o(112228);
                return 1;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(112228);
        return 0;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(112229);
        if (qVar.equals(this.xeM)) {
            this.xeO.removeMessages(1);
            this.wXS = System.currentTimeMillis();
            g.azz().b(2599, this);
            dsz dsz = this.xeM.xeI;
            if (i2 == 0 && i3 == 0) {
                this.xeN = dsz;
                Log.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "onSceneEnd Count %d TotalCount %d ContinueFlag %s SearchTime %d", Integer.valueOf(this.xeN.oTz), Integer.valueOf(this.xeN.oTY), Boolean.valueOf(this.xeN.LYI), Long.valueOf(this.wXS - this.xaI));
            }
            this.wXC.a(this, this.query);
        }
        AppMethodBeat.o(112229);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final long dOJ() {
        return this.wXS;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e, com.tencent.mm.plugin.fts.a.d.b
    public final List<com.tencent.mm.plugin.fts.a.a.c> GE(long j2) {
        AppMethodBeat.i(112230);
        ArrayList arrayList = new ArrayList();
        if (this.xeN != null && this.xeN.KKx.size() > 0) {
            int i2 = dOF() == 2 ? 26 : 25;
            com.tencent.mm.plugin.fts.a.a.c cVar = new com.tencent.mm.plugin.fts.a.a.c();
            cVar.position = this.wXD + 1;
            cVar.wVZ = this.wXS - j2;
            cVar.dUb = String.valueOf(this.xeN.KKx.get(0).hashCode());
            cVar.dUm = i2;
            cVar.wWb = this.xeN.KKx.get(0).MUT;
            arrayList.add(cVar);
            if (this.xeN.LYI) {
                com.tencent.mm.plugin.fts.a.a.c cVar2 = new com.tencent.mm.plugin.fts.a.a.c();
                cVar2.position = this.wXF;
                cVar2.wVZ = this.wXS - j2;
                cVar2.dUb = String.valueOf(this.xeN.hashCode());
                cVar2.dUm = i2;
                cVar2.wWb = this.xeN.KKx.get(0).MUT;
                arrayList.add(cVar2);
            }
        }
        AppMethodBeat.o(112230);
        return arrayList;
    }
}

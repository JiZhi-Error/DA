package com.tencent.mm.plugin.sns.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.m.c;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.ui.a.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vending.app.a;

public final class a extends com.tencent.mm.vending.app.a implements i {
    String ELj;
    boolean ELk;
    int ELl;
    protected volatile aq.a EQi;
    public volatile b ESq;
    boolean EqY;
    private i.a Fgy;
    String mRa;

    public final void a(i.a aVar) {
        AppMethodBeat.i(100573);
        this.EQi = aj.faE();
        this.Fgy = aVar;
        this.EQi.a(1, ((c.a) y(c.a.class)).mRa, this.Fgy);
        AppMethodBeat.o(100573);
    }

    public final aq.a faE() {
        return this.EQi;
    }

    @Override // com.tencent.mm.vending.app.a
    public final void onCreate() {
        AppMethodBeat.i(100574);
        super.onCreate();
        a(c.b.class, new a.AbstractC2149a<c.b>() {
            /* class com.tencent.mm.plugin.sns.m.a.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.vending.app.a.AbstractC2149a
            public final /* synthetic */ c.b bmp() {
                AppMethodBeat.i(100571);
                Log.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor index %s", c.b.class);
                c.b fln = a.fln();
                AppMethodBeat.o(100571);
                return fln;
            }
        });
        a(c.a.class, new a.AbstractC2149a<c.a>() {
            /* class com.tencent.mm.plugin.sns.m.a.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.vending.app.a.AbstractC2149a
            public final /* synthetic */ c.a bmp() {
                as asVar;
                AppMethodBeat.i(100572);
                Log.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor index %s", c.a.class);
                a aVar = a.this;
                c.a aVar2 = new c.a();
                aVar.ELl = aVar.QYU.getIntExtra("sns_source", 0);
                aVar.mRa = aVar.QYU.getStringExtra("sns_userName");
                if (aVar.mRa == null) {
                    aVar.mRa = "";
                }
                g.aAi();
                aVar.ELk = ((l) g.af(l.class)).aSN().bjG(aVar.mRa);
                aVar.ELj = z.aTY();
                aVar.EqY = Util.isEqual(aVar.ELj, aVar.mRa);
                bv faC = aj.faC();
                String nullAs = Util.nullAs(aVar.QYU.getStringExtra("sns_signature"), "");
                String nullAs2 = Util.nullAs(aVar.QYU.getStringExtra("sns_nickName"), "");
                if (aVar.mRa == null || aVar.mRa.equals("")) {
                    asVar = faC.Kn(aVar.ELj);
                } else {
                    asVar = faC.Kn(aVar.mRa);
                }
                if (asVar != null && ((int) asVar.gMZ) > 0) {
                    nullAs = asVar.signature;
                    nullAs2 = asVar.arI();
                    Log.i("MicroMsg.SnsTimelineInteractor", "contact:user[%s] id[%d] nickname[%s]", asVar.field_username, Integer.valueOf((int) asVar.gMZ), nullAs2);
                }
                aVar2.mRa = aVar.mRa;
                aVar2.ELj = aVar.ELj;
                aVar2.ELk = aVar.ELk;
                aVar2.EqY = aVar.EqY;
                aVar2.ELl = aVar.ELl;
                aVar2.krY = nullAs2;
                aVar2.mSignature = nullAs;
                AppMethodBeat.o(100572);
                return aVar2;
            }
        });
        Log.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onCreate %s", this);
        com.tencent.mm.plugin.sns.model.c faJ = aj.faJ();
        synchronized (faJ.mLock) {
            try {
                faJ.DGH.clear();
            } catch (Throwable th) {
                AppMethodBeat.o(100574);
                throw th;
            }
        }
        aj.faJ();
        AppMethodBeat.o(100574);
    }

    @Override // com.tencent.mm.vending.app.a
    public final void onDestroy() {
        AppMethodBeat.i(100575);
        Log.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onDestroy %s", this);
        g.aAi();
        if (!(!g.aAf().azp() || this.EQi == null || this.Fgy == null)) {
            this.EQi.a(this.Fgy, 1);
        }
        super.onDestroy();
        AppMethodBeat.o(100575);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.tencent.mm.plugin.sns.m.c.b fln() {
        /*
        // Method dump skipped, instructions count: 173
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.m.a.fln():com.tencent.mm.plugin.sns.m.c$b");
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(100577);
        Log.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onSceneEnd  errType %d %d %s %s", Integer.valueOf(i2), Integer.valueOf(i3), str, qVar.toString());
        AppMethodBeat.o(100577);
    }

    public final void g(String str, boolean z, int i2) {
        AppMethodBeat.i(100578);
        this.EQi.a(1, str, z, i2);
        AppMethodBeat.o(100578);
    }

    public final void h(String str, boolean z, int i2) {
        AppMethodBeat.i(100579);
        this.EQi.b(1, str, z, i2);
        AppMethodBeat.o(100579);
    }

    public final void a(String str, int i2, boolean z, int i3, long j2) {
        AppMethodBeat.i(179434);
        this.EQi.a(1, str, i2, z, j2, i3);
        AppMethodBeat.o(179434);
    }
}

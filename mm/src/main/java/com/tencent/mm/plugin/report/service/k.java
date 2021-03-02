package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class k implements bd {
    private static HashMap<Integer, h.b> kvw;
    private r.a kvx;
    private IListener ptp = new IListener<l>() {
        /* class com.tencent.mm.plugin.report.service.k.AnonymousClass2 */

        {
            AppMethodBeat.i(160990);
            this.__eventId = l.class.getName().hashCode();
            AppMethodBeat.o(160990);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(l lVar) {
            AppMethodBeat.i(143931);
            if (lVar.dCi.isActive && !g.aAf().azp()) {
                Log.i("MicroMsg.SubCoreReport", "mOnForegroundListener: account not ready");
            }
            AppMethodBeat.o(143931);
            return false;
        }
    };

    static {
        AppMethodBeat.i(143938);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        kvw = hashMap;
        hashMap.put(Integer.valueOf("DUPLICATEKVLOG_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.report.service.k.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return b.SQL_CREATE;
            }
        });
        AppMethodBeat.o(143938);
    }

    public k() {
        AppMethodBeat.i(143932);
        AppMethodBeat.o(143932);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(143933);
        if (eOK() != null) {
            k eOK = eOK();
            if (eOK.kvx != null) {
                eOK.kvx.uS(eOK.hashCode());
                eOK.kvx = null;
            }
        }
        EventCenter.instance.removeListener(this.ptp);
        AppMethodBeat.o(143933);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(143934);
        long currentTimeMillis = System.currentTimeMillis();
        this.kvx = r.a(hashCode(), g.aAh().cachePath + "CommonOneMicroMsg.db", kvw, false);
        Log.i("MicroMsg.SubCoreReport", "summeranrt onAccountPostReset tid[%d] [%d]ms, stack[%s]", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Util.getStack());
        EventCenter.instance.addListener(this.ptp);
        AppMethodBeat.o(143934);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    public static k eOK() {
        AppMethodBeat.i(143935);
        k kVar = (k) y.at(k.class);
        AppMethodBeat.o(143935);
        return kVar;
    }

    public static void G(long j2, String str) {
        AppMethodBeat.i(143936);
        ln lnVar = new ln();
        lnVar.dQQ.dQR = j2;
        lnVar.dQQ.content = str;
        EventCenter.instance.publish(lnVar);
        AppMethodBeat.o(143936);
    }
}

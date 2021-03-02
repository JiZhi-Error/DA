package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class v implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private t jhA = new t();
    private u jhB = new u();
    private p jhC = null;
    IListener jhD = new IListener<bp>() {
        /* class com.tencent.mm.bb.v.AnonymousClass3 */

        {
            AppMethodBeat.i(161782);
            this.__eventId = bp.class.getName().hashCode();
            AppMethodBeat.o(161782);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bp bpVar) {
            AppMethodBeat.i(150859);
            bp bpVar2 = bpVar;
            if (bpVar2.dEN.dEO == 47 && bpVar2.dEN.subType == 1) {
                Log.i("MicroMsg.SubCorePacakge", "going to update region code.");
                v.a(v.this, bpVar2.dEN.filePath);
            }
            AppMethodBeat.o(150859);
            return false;
        }
    };
    private r jhx;
    private b jhy;
    private s jhz = new s();

    static /* synthetic */ boolean a(v vVar, String str) {
        AppMethodBeat.i(150868);
        boolean Pq = vVar.Pq(str);
        AppMethodBeat.o(150868);
        return Pq;
    }

    public v() {
        AppMethodBeat.i(150861);
        AppMethodBeat.o(150861);
    }

    private static v beu() {
        AppMethodBeat.i(150862);
        v vVar = (v) y.at(v.class);
        AppMethodBeat.o(150862);
        return vVar;
    }

    public static r bev() {
        AppMethodBeat.i(150863);
        g.aAf().azk();
        if (beu().jhx == null) {
            beu().jhx = new r(g.aAh().hqK);
        }
        r rVar = beu().jhx;
        AppMethodBeat.o(150863);
        return rVar;
    }

    public static b bew() {
        AppMethodBeat.i(150864);
        g.aAf().azk();
        if (beu().jhy == null) {
            beu().jhy = new b(g.aAh().hqK);
        }
        b bVar = beu().jhy;
        AppMethodBeat.o(150864);
        return bVar;
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(150865);
        EventCenter.instance.removeListener(this.jhz);
        EventCenter.instance.removeListener(this.jhA);
        EventCenter.instance.removeListener(this.jhB);
        EventCenter.instance.removeListener(this.jhC.jht);
        EventCenter.instance.removeListener(this.jhC.jhu);
        EventCenter.instance.removeListener(this.jhD);
        AppMethodBeat.o(150865);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(150866);
        EventCenter.instance.addListener(this.jhz);
        EventCenter.instance.addListener(this.jhA);
        EventCenter.instance.addListener(this.jhB);
        EventCenter.instance.addListener(this.jhD);
        if (this.jhC != null) {
            this.jhC.jhs.clear();
        } else {
            this.jhC = new p();
        }
        EventCenter.instance.addListener(this.jhC.jht);
        EventCenter.instance.addListener(this.jhC.jhu);
        AppMethodBeat.o(150866);
    }

    static {
        AppMethodBeat.i(150869);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("PACKAGE_INFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.bb.v.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return r.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("CHATTINGBGINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.bb.v.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return b.SQL_CREATE;
            }
        });
        AppMethodBeat.o(150869);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0089 A[SYNTHETIC, Splitter:B:23:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009a A[Catch:{ IOException -> 0x00a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0119 A[SYNTHETIC, Splitter:B:46:0x0119] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x012a A[Catch:{ IOException -> 0x0136 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean Pq(java.lang.String r15) {
        /*
        // Method dump skipped, instructions count: 474
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.bb.v.Pq(java.lang.String):boolean");
    }
}

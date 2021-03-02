package com.tencent.mm.plugin.websearch.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.b.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class b implements c {
    Map<a, CountDownLatch> IGx = new ConcurrentHashMap();
    private l IGy = new l() {
        /* class com.tencent.mm.plugin.websearch.b.a.b.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.fts.a.l
        public final void b(k kVar) {
            AppMethodBeat.i(116554);
            a aVar = (a) kVar.wXa.wVS;
            if (aVar == null) {
                AppMethodBeat.o(116554);
                return;
            }
            CountDownLatch remove = b.this.IGx.remove(aVar);
            switch (kVar.resultCode) {
                case -3:
                case -2:
                case -1:
                    aVar.ih(Collections.emptyList());
                    break;
                case 0:
                    if (kVar.wXb != null && kVar.wXb.size() != 0) {
                        aVar.ih(kVar.wXb);
                        break;
                    } else {
                        Log.i("FTSMatchContact", "local contact search size 0");
                        aVar.ih(Collections.emptyList());
                        remove.countDown();
                        AppMethodBeat.o(116554);
                        return;
                    }
                    break;
            }
            remove.countDown();
            AppMethodBeat.o(116554);
        }
    };
    private l IGz = new l() {
        /* class com.tencent.mm.plugin.websearch.b.a.b.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.fts.a.l
        public final void b(k kVar) {
            AppMethodBeat.i(116555);
            a aVar = (a) kVar.wXa.wVS;
            if (aVar == null) {
                AppMethodBeat.o(116555);
                return;
            }
            c.a remove = b.this.oPn.remove(aVar);
            if (remove == null) {
                AppMethodBeat.o(116555);
                return;
            }
            switch (kVar.resultCode) {
                case -3:
                case -2:
                case -1:
                    aVar.ih(Collections.emptyList());
                    break;
                case 0:
                    if (kVar.wXb != null && kVar.wXb.size() != 0) {
                        aVar.ih(kVar.wXb);
                        break;
                    } else {
                        Log.i("FTSMatchContact", "local contact search size 0");
                        remove.fYI();
                        AppMethodBeat.o(116555);
                        return;
                    }
                    break;
            }
            remove.fYI();
            AppMethodBeat.o(116555);
        }
    };
    Map<a, c.a> oPn = new HashMap();

    public b() {
        AppMethodBeat.i(116556);
        AppMethodBeat.o(116556);
    }

    @Override // com.tencent.mm.plugin.websearch.b.a.c
    public final a aXo(String str) {
        AppMethodBeat.i(116557);
        e eVar = new e(str);
        CountDownLatch countDownLatch = this.IGx.get(eVar);
        if (countDownLatch != null) {
            Log.i("FTSMatchContact", "have a running task ,wait for result, query %s,maxMatch %d", str, Integer.MAX_VALUE);
        } else if (a(eVar, this.IGy)) {
            Log.i("FTSMatchContact", "not have a running task ,start new task, query %s,maxMatch %d", str, Integer.MAX_VALUE);
            countDownLatch = new CountDownLatch(1);
            this.IGx.put(eVar, countDownLatch);
        } else {
            Log.i("FTSMatchContact", "start new task fail, query %s,maxMatch %d", str, Integer.MAX_VALUE);
        }
        if (countDownLatch != null) {
            try {
                countDownLatch.await(2000, TimeUnit.MILLISECONDS);
            } catch (Exception e2) {
                Log.printErrStackTrace("FTSMatchContact", e2, "", new Object[0]);
            }
        }
        this.IGx.remove(eVar);
        AppMethodBeat.o(116557);
        return eVar;
    }

    @Override // com.tencent.mm.plugin.websearch.b.a.c
    public final void a(a aVar, c.a aVar2) {
        AppMethodBeat.i(116558);
        this.oPn.put(aVar, aVar2);
        a(aVar, this.IGz);
        AppMethodBeat.o(116558);
    }

    private static boolean a(a aVar, l lVar) {
        AppMethodBeat.i(116559);
        if (Util.isNullOrNil(aVar.query)) {
            AppMethodBeat.o(116559);
            return false;
        }
        j jVar = new j();
        jVar.query = aVar.query;
        jVar.wWU = new int[]{131072};
        jVar.wWV = new int[]{1, 5};
        jVar.wWW = aVar.IGw;
        jVar.wWY = com.tencent.mm.plugin.fts.a.c.b.wXy;
        jVar.wWX = new HashSet<>();
        jVar.wWZ = lVar;
        jVar.scene = 1;
        ((n) g.ah(n.class)).search(2, jVar).wVS = aVar;
        AppMethodBeat.o(116559);
        return true;
    }
}

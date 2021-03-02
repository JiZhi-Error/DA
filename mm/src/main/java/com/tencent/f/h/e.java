package com.tencent.f.h;

import android.util.Printer;
import com.tencent.f.a;
import com.tencent.f.c.b;
import com.tencent.f.h.f;
import com.tencent.f.i.d;
import com.tencent.f.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class e {
    public final c RUA;
    public final f RUB = new f();
    public final b RUz;

    public e(a aVar) {
        AppMethodBeat.i(183363);
        this.RUz = new b(aVar.RSr, aVar.RSq);
        this.RUA = new c(aVar.RSs);
        AppMethodBeat.o(183363);
    }

    public final <V> d<V> j(k<V> kVar) {
        AppMethodBeat.i(256675);
        d<V> a2 = a(kVar, false, this.RUA);
        AppMethodBeat.o(256675);
        return a2;
    }

    public final <V> d<V> a(k<V> kVar, boolean z) {
        AppMethodBeat.i(183364);
        d<V> a2 = a(kVar, z, k(kVar));
        AppMethodBeat.o(183364);
        return a2;
    }

    public static <V> d<V> a(k<V> kVar, boolean z, d dVar) {
        long delay;
        AppMethodBeat.i(183365);
        kVar.a(dVar);
        if (kVar instanceof com.tencent.f.j.e) {
            com.tencent.f.j.e eVar = (com.tencent.f.j.e) kVar;
            com.tencent.f.j.d dVar2 = eVar.serial.RUS;
            if (z) {
                delay = -2147483648L;
            } else {
                delay = kVar.getDelay(TimeUnit.MILLISECONDS);
            }
            dVar2.a(delay, eVar);
        } else {
            kVar.RUL.g(kVar);
        }
        AppMethodBeat.o(183365);
        return kVar;
    }

    public final Map<String, List<String>> hme() {
        AppMethodBeat.i(183366);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            f.a aVar = this.RUB.RUC;
            LinkedList linkedList = new LinkedList();
            aVar.aDv.dump(new Printer(linkedList) {
                /* class com.tencent.f.h.f.a.AnonymousClass2 */
                final /* synthetic */ List hjk;

                /* renamed from: i  reason: collision with root package name */
                int f123i = 0;

                {
                    this.hjk = r3;
                }

                public final void println(String str) {
                    AppMethodBeat.i(183369);
                    if (this.f123i > 1) {
                        this.hjk.add(str.trim());
                    }
                    this.f123i++;
                    AppMethodBeat.o(183369);
                }
            }, "");
            linkedHashMap.put("UIPool", linkedList);
            linkedHashMap.put("HotPool", this.RUA.hmx());
            linkedHashMap.put("ColdPool", this.RUz.hmx());
            for (com.tencent.f.j.a aVar2 : com.tencent.f.j.a.hmH()) {
                List<String> hmI = aVar2.RUS.hmI();
                if (hmI.size() > 0) {
                    linkedHashMap.put(aVar2.tag, hmI);
                }
            }
        } catch (NullPointerException e2) {
            com.tencent.f.d.RSS.e("PoolAdapter", "[dumpWaitingTask] e=%s", e2);
        }
        AppMethodBeat.o(183366);
        return linkedHashMap;
    }

    private d k(k<?> kVar) {
        AppMethodBeat.i(183367);
        if (b.RTE != null) {
            if (b.RTE.ez(kVar.getKey())) {
                b bVar = this.RUz;
                AppMethodBeat.o(183367);
                return bVar;
            }
            c cVar = this.RUA;
            AppMethodBeat.o(183367);
            return cVar;
        } else if (this.RUA.isBusy()) {
            b bVar2 = this.RUz;
            AppMethodBeat.o(183367);
            return bVar2;
        } else {
            c cVar2 = this.RUA;
            AppMethodBeat.o(183367);
            return cVar2;
        }
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class p {
    private final LinkedHashMap<String, ArrayList<n>> mzB = new LinkedHashMap<>(8, 0.75f);

    p() {
        AppMethodBeat.i(234826);
        AppMethodBeat.o(234826);
    }

    public final synchronized void a(String str, n nVar) {
        AppMethodBeat.i(234827);
        ArrayList<n> arrayList = this.mzB.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.mzB.put(str, arrayList);
            h.log(3, "RequestManager", "add videoRequest:".concat(String.valueOf(nVar)));
        }
        arrayList.add(nVar);
        AppMethodBeat.o(234827);
    }

    public final synchronized void a(n nVar) {
        AppMethodBeat.i(234828);
        ArrayList<n> arrayList = this.mzB.get(nVar.eby);
        if (arrayList != null) {
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                if (nVar.equals(it.next())) {
                    if (a.bJK().cWq) {
                        h.log(3, "RequestManager", "remove videoRequest:".concat(String.valueOf(nVar)));
                    }
                    it.remove();
                }
            }
        }
        AppMethodBeat.o(234828);
    }

    public final synchronized ArrayList<n> bP(String str, int i2) {
        ArrayList<n> arrayList;
        AppMethodBeat.i(234830);
        arrayList = new ArrayList<>();
        for (Map.Entry<String, ArrayList<n>> entry : this.mzB.entrySet()) {
            ArrayList<n> value = entry.getValue();
            if (value.size() > 0) {
                n nVar = value.get(0);
                if (str.equals(nVar.mzw)) {
                    if (i2 == -1) {
                        arrayList.addAll(value);
                    } else if (i2 == nVar.priority) {
                        arrayList.addAll(value);
                    }
                }
            }
        }
        AppMethodBeat.o(234830);
        return arrayList;
    }

    public final synchronized String toString() {
        String str;
        AppMethodBeat.i(234831);
        String str2 = super.toString() + "[";
        for (Map.Entry<String, ArrayList<n>> entry : this.mzB.entrySet()) {
            Iterator<n> it = entry.getValue().iterator();
            while (it.hasNext()) {
                str2 = (str2 + it.next().toString()) + ",\n";
            }
        }
        str = str2 + "]";
        AppMethodBeat.o(234831);
        return str;
    }

    public final void b(String str, n nVar) {
        AppMethodBeat.i(234829);
        ArrayList<n> bP = bP(str, 10);
        ArrayList arrayList = new ArrayList();
        Iterator<n> it = bP.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next.xB(0)) {
                arrayList.add(next);
            }
        }
        String str2 = "VideoProxy/" + nVar.mzr + "/RequestManager";
        h.log(4, str2, "cancelPreloadRequestsSync, videoKey:" + str + ", count:" + arrayList.size());
        if (arrayList.size() > 0) {
            final CountDownLatch countDownLatch = new CountDownLatch(arrayList.size());
            h.log(5, str2, "start auto cancel preload requests, request count=" + countDownLatch.getCount());
            AnonymousClass1 r4 = new o() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.video.b.c.p.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.c.o
                public final void bJY() {
                    AppMethodBeat.i(234825);
                    countDownLatch.countDown();
                    AppMethodBeat.o(234825);
                }
            };
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                n nVar2 = (n) it2.next();
                nVar2.mzp = r4;
                if (nVar2.mzk != null) {
                    if (nVar2.eg(0, 1) && a.bJK().cWq) {
                        h.log(3, nVar2.getLogTag(), "cancel start, seq=" + nVar2.mzr);
                    }
                    nVar2.xA(1);
                    nVar2.mzk.cancel(true);
                }
            }
            try {
                countDownLatch.await(2000, TimeUnit.MILLISECONDS);
                if (bP(str, 10).size() == 0) {
                    h.log(5, str2, "auto cancel preload requests success");
                    AppMethodBeat.o(234829);
                    return;
                }
                h.log(5, str2, new StringBuilder("auto cancel preload requests timeout, max wait time is 2000 seconds").toString());
                AppMethodBeat.o(234829);
                return;
            } catch (InterruptedException e2) {
                h.log(5, str2, "auto cancel preload requests interrupted " + e2.toString());
            }
        }
        AppMethodBeat.o(234829);
    }
}

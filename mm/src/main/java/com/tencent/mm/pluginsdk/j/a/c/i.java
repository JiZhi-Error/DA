package com.tencent.mm.pluginsdk.j.a.c;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.c.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class i implements c {
    private final MMHandler JZQ;
    public final SparseArray<List<d>> JZR = new SparseArray<>();
    public final Object JZS = new Object();

    i(MMHandler mMHandler) {
        AppMethodBeat.i(152018);
        this.JZQ = mMHandler;
        AppMethodBeat.o(152018);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.pluginsdk.j.a.c.c
    public final void a(e eVar, final m mVar) {
        AppMethodBeat.i(152019);
        Log.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchResponse, response = ".concat(String.valueOf(mVar)));
        switch (mVar.status) {
            case 2:
                s beg = q.a.Kan.beg(mVar.JYs);
                if (beg != null) {
                    beg.field_status = 2;
                    q.a.Kan.h(beg);
                }
                Log.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, groupId = " + eVar.avy());
                final List<d> bee = bee(eVar.avy());
                if (Util.isNullOrNil(bee)) {
                    Log.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = null");
                    AppMethodBeat.o(152019);
                    return;
                }
                Log.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = " + bee.size());
                final String gnA = eVar.gnA();
                this.JZQ.post(new Runnable() {
                    /* class com.tencent.mm.pluginsdk.j.a.c.i.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(152016);
                        for (d dVar : bee) {
                            if (Util.nullAsNil(dVar.avy()).equals(mVar.groupId)) {
                                dVar.bdV(gnA);
                            }
                        }
                        AppMethodBeat.o(152016);
                    }
                });
                AppMethodBeat.o(152019);
                return;
            case 3:
                s beg2 = q.a.Kan.beg(mVar.JYs);
                if (beg2 != null) {
                    beg2.field_status = 3;
                    q.a.Kan.h(beg2);
                }
                final List<d> bee2 = bee(eVar.avy());
                if (!Util.isNullOrNil(bee2)) {
                    final String gnA2 = eVar.gnA();
                    this.JZQ.post(new Runnable() {
                        /* class com.tencent.mm.pluginsdk.j.a.c.i.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(152015);
                            for (d dVar : bee2) {
                                if (Util.nullAsNil(dVar.avy()).equals(mVar.groupId)) {
                                    dVar.a(gnA2, mVar);
                                }
                            }
                            AppMethodBeat.o(152015);
                        }
                    });
                    break;
                }
                break;
            case 4:
                s beg3 = q.a.Kan.beg(mVar.JYs);
                if (beg3 != null) {
                    beg3.field_status = 4;
                    q.a.Kan.h(beg3);
                }
                final List<d> bee3 = bee(eVar.avy());
                if (!Util.isNullOrNil(bee3)) {
                    final String gnA3 = eVar.gnA();
                    this.JZQ.post(new Runnable() {
                        /* class com.tencent.mm.pluginsdk.j.a.c.i.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(152017);
                            for (d dVar : bee3) {
                                if (Util.nullAsNil(dVar.avy()).equals(mVar.groupId)) {
                                    dVar.bdW(gnA3);
                                }
                            }
                            AppMethodBeat.o(152017);
                        }
                    });
                }
                AppMethodBeat.o(152019);
                return;
        }
        AppMethodBeat.o(152019);
    }

    @Override // com.tencent.mm.pluginsdk.j.a.c.c
    public final void C(String str, int i2, int i3) {
        AppMethodBeat.i(152020);
        Log.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchRetry, urlKey = %s, max = %d, count = %d", str, Integer.valueOf(i2), Integer.valueOf(i3));
        s beg = q.a.Kan.beg(str);
        if (beg != null) {
            beg.field_maxRetryTimes = i2;
            beg.field_retryTimes = i3;
            q.a.Kan.h(beg);
        }
        AppMethodBeat.o(152020);
    }

    @Override // com.tencent.mm.pluginsdk.j.a.c.c
    public final void a(String str, k kVar) {
    }

    private List<d> bee(String str) {
        List<d> list;
        AppMethodBeat.i(152022);
        int hashCode = str.hashCode();
        synchronized (this.JZS) {
            try {
                list = this.JZR.get(hashCode);
            } finally {
                AppMethodBeat.o(152022);
            }
        }
        return list;
    }

    @Override // com.tencent.mm.pluginsdk.j.a.c.c
    public final void O(String str, long j2) {
        AppMethodBeat.i(152021);
        s beg = q.a.Kan.beg(str);
        if (beg != null) {
            beg.field_contentLength = j2;
            q.a.Kan.h(beg);
        }
        AppMethodBeat.o(152021);
    }
}

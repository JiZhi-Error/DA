package com.tencent.mm.plugin.fav.b.e;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.u;
import com.tencent.mm.protocal.protobuf.amp;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.protocal.protobuf.cpv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxmm.v2helper;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c implements i, u {
    public Map<String, a> tco = new HashMap();

    /* access modifiers changed from: package-private */
    public static class a {
        int retryCount;
        int tbB;
        f tbC;
        long time;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public c() {
        AppMethodBeat.i(101626);
        g.azz().a(v2helper.EMethodSetAgcRxOn, this);
        g.azz().a(401, this);
        AppMethodBeat.o(101626);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        int i4;
        AppMethodBeat.i(101627);
        if (qVar == null) {
            AppMethodBeat.o(101627);
            return;
        }
        Log.i("MicroMsg.Fav.FavEditService", "on edit service scene end, errType=%d errCode=%d, %s, scene type %d", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(qVar.getType()));
        if (qVar.getType() == 401) {
            Log.i("MicroMsg.Fav.FavEditService", "on add fav item scene end, try mod item");
            run();
            AppMethodBeat.o(101627);
            return;
        }
        am amVar = (am) qVar;
        if (amVar.type != 0) {
            if (i2 == 0 && i3 == 0) {
                String D = D(amVar.cVe(), amVar.cVf());
                Log.i("MicroMsg.Fav.FavEditService", "clear job, key %s", D);
                this.tco.remove(D);
                ((af) g.ah(af.class)).getFavEditInfoStorage().y(amVar.cVe(), amVar.cVf());
                com.tencent.mm.plugin.fav.a.g DY = ((af) g.ah(af.class)).getFavItemInfoStorage().DY(amVar.cVe());
                if (DY != null) {
                    long j2 = (long) DY.field_id;
                    int size = DY.field_tagProto.Lyo.size();
                    if (amVar.tbC == null) {
                        i4 = 1;
                    } else {
                        i4 = amVar.tbC.field_scene;
                    }
                    h.i(j2, size, i4);
                }
                AppMethodBeat.o(101627);
                return;
            }
            long cVe = amVar.cVe();
            int cVf = amVar.cVf();
            String D2 = D(cVe, cVf);
            Log.i("MicroMsg.Fav.FavEditService", "retry job, key %s", D2);
            final a aVar = this.tco.get(D2);
            if (aVar == null) {
                Log.w("MicroMsg.Fav.FavEditService", "want to retry mod item, localid %d, type %d", Long.valueOf(cVe), Integer.valueOf(cVf));
                AppMethodBeat.o(101627);
                return;
            }
            g.aAk().postToWorkerDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.fav.b.e.c.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(101624);
                    c.a(aVar, false);
                    AppMethodBeat.o(101624);
                }

                public final String toString() {
                    AppMethodBeat.i(101625);
                    String str = super.toString() + "|retryJob";
                    AppMethodBeat.o(101625);
                    return str;
                }
            }, 3000);
        }
        AppMethodBeat.o(101627);
    }

    public final void run() {
        AppMethodBeat.i(101628);
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.fav.b.e.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(101622);
                List<f> cUO = ((af) g.ah(af.class)).getFavEditInfoStorage().cUO();
                if (cUO == null) {
                    AppMethodBeat.o(101622);
                    return;
                }
                Log.i("MicroMsg.Fav.FavEditService", "infos size %d", Integer.valueOf(cUO.size()));
                for (f fVar : cUO) {
                    String D = c.D(fVar.field_localId, fVar.field_type);
                    a aVar = c.this.tco.get(D);
                    if (aVar == null) {
                        Log.i("MicroMsg.Fav.FavEditService", "not match key %s", D);
                        a aVar2 = new a((byte) 0);
                        aVar2.tbC = fVar;
                        aVar2.retryCount = 3;
                        aVar2.time = SystemClock.elapsedRealtime();
                        c.this.tco.put(D, aVar2);
                        c.a(aVar2, true);
                    } else {
                        Log.i("MicroMsg.Fav.FavEditService", "match key %s, check start", D);
                        c.a(aVar, false);
                    }
                }
                AppMethodBeat.o(101622);
            }

            public final String toString() {
                AppMethodBeat.i(101623);
                String str = super.toString() + "|run";
                AppMethodBeat.o(101623);
                return str;
            }
        });
        AppMethodBeat.o(101628);
    }

    public static String D(long j2, int i2) {
        AppMethodBeat.i(101629);
        String str = j2 + "&&" + i2;
        AppMethodBeat.o(101629);
        return str;
    }

    @Override // com.tencent.mm.plugin.fav.a.u
    public final void a(long j2, LinkedList<cps> linkedList, LinkedList<cpv> linkedList2, int i2) {
        f fVar;
        boolean z;
        AppMethodBeat.i(101630);
        Log.i("MicroMsg.Fav.FavEditService", "addTag %d", Long.valueOf(j2));
        f DX = ((af) g.ah(af.class)).getFavEditInfoStorage().DX(j2);
        if (DX == null) {
            fVar = new f();
            z = true;
        } else {
            fVar = DX;
            z = false;
        }
        fVar.field_localId = j2;
        amp amp = new amp();
        amp.tbE = linkedList;
        amp.LxK = linkedList2;
        fVar.field_modItem = amp;
        fVar.field_time = Util.nowMilliSecond();
        fVar.field_type = 0;
        fVar.field_scene = i2;
        if (z) {
            ((af) g.ah(af.class)).getFavEditInfoStorage().a(fVar);
        } else {
            ((af) g.ah(af.class)).getFavEditInfoStorage().a(fVar, ch.COL_LOCALID);
        }
        run();
        AppMethodBeat.o(101630);
    }

    static /* synthetic */ void a(a aVar, boolean z) {
        AppMethodBeat.i(101631);
        aVar.retryCount--;
        if (aVar.retryCount < 0) {
            if (SystemClock.elapsedRealtime() - aVar.time < 7200000) {
                Log.i("MicroMsg.Fav.FavEditService", "try mod item fail time limit, favid %d, localId %d, edit type %d", Integer.valueOf(aVar.tbB), Long.valueOf(aVar.tbC.field_localId), Integer.valueOf(aVar.tbC.field_type));
                AppMethodBeat.o(101631);
                return;
            }
            aVar.time = SystemClock.elapsedRealtime();
            aVar.retryCount = 3;
        }
        if (aVar.tbB <= 0) {
            com.tencent.mm.plugin.fav.a.g DY = ((af) g.ah(af.class)).getFavItemInfoStorage().DY(aVar.tbC.field_localId);
            if (DY == null || DY.field_id <= 0) {
                Log.w("MicroMsg.Fav.FavEditService", "want to start mod item, but favid is invalid, local id %d", Long.valueOf(aVar.tbC.field_localId));
                AppMethodBeat.o(101631);
                return;
            }
            aVar.tbB = DY.field_id;
            Log.i("MicroMsg.Fav.FavEditService", "want mod item, find id %d by local id %d", Integer.valueOf(aVar.tbB), Long.valueOf(aVar.tbC.field_localId));
        } else if (!z) {
            Log.w("MicroMsg.Fav.FavEditService", "want to mod item, favid %d, it is running, but not enforce, return", Integer.valueOf(aVar.tbB));
            AppMethodBeat.o(101631);
            return;
        }
        Log.i("MicroMsg.Fav.FavEditService", "try mod item, enforce %B, favid %d, edit type %d", Boolean.valueOf(z), Integer.valueOf(aVar.tbB), Integer.valueOf(aVar.tbC.field_type));
        g.azz().a(new am(aVar.tbB, aVar.tbC), 0);
        AppMethodBeat.o(101631);
    }
}

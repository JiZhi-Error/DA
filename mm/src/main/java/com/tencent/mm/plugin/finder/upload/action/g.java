package com.tencent.mm.plugin.finder.upload.action;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.f;
import com.tencent.mm.loader.g.d;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.upload.action.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.p;

public final class g {
    public static final String TAG = TAG;
    private static final g vUm = new g();
    public static final a vUn = new a((byte) 0);
    private d<h> vRJ = new d<>(new f(new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte) 0), 1, "finder_action_follow_post_quene"));
    private final Runnable vRK = new c(this);
    private final ConcurrentLinkedQueue<e> vTW = new ConcurrentLinkedQueue<>();
    public final ConcurrentHashMap<String, f> vTX = new ConcurrentHashMap<>();

    public g() {
        AppMethodBeat.i(253208);
        AppMethodBeat.o(253208);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(253209);
        AppMethodBeat.o(253209);
    }

    /* access modifiers changed from: package-private */
    public static final class c implements Runnable {
        final /* synthetic */ g vUo;

        c(g gVar) {
            this.vUo = gVar;
        }

        public final void run() {
            AppMethodBeat.i(253202);
            this.vUo.dAP();
            AppMethodBeat.o(253202);
        }
    }

    public final boolean asJ(String str) {
        boolean z = false;
        AppMethodBeat.i(253203);
        if (str == null || p.j(str, "")) {
            AppMethodBeat.o(253203);
        } else {
            c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
            boolean asJ = c.a.asJ(str);
            f fVar = this.vTX.get(str);
            if (fVar != null) {
                int i2 = fVar.opType;
                bb.a aVar2 = bb.tve;
                z = i2 == bb.tvb && !fVar.vUk;
            } else {
                z = asJ;
            }
            if (BuildInfo.DEBUG) {
                String str2 = TAG;
                StringBuilder append = new StringBuilder("isFollow test ").append(str).append(" optype:");
                f fVar2 = this.vTX.get(str);
                StringBuilder append2 = append.append(fVar2 != null ? Integer.valueOf(fVar2.opType) : null).append(" followFlag:");
                c.a aVar3 = com.tencent.mm.plugin.finder.api.c.tsp;
                Log.i(str2, append2.append(c.a.asJ(str)).append(" result:").append(z).toString());
            }
            AppMethodBeat.o(253203);
        }
        return z;
    }

    public final boolean asK(String str) {
        boolean z = false;
        AppMethodBeat.i(253204);
        if (str == null || p.j(str, "")) {
            AppMethodBeat.o(253204);
        } else {
            c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
            boolean asK = c.a.asK(str);
            f fVar = this.vTX.get(str);
            if (fVar != null) {
                int i2 = fVar.opType;
                bb.a aVar2 = bb.tve;
                z = i2 == bb.tvb && fVar.vUk;
            } else {
                z = asK;
            }
            if (BuildInfo.DEBUG) {
                String str2 = TAG;
                StringBuilder append = new StringBuilder("isWaiting test ").append(str).append(" optype:");
                f fVar2 = this.vTX.get(str);
                StringBuilder append2 = append.append(fVar2 != null ? Integer.valueOf(fVar2.opType) : null).append(" waitingFlag:");
                c.a aVar3 = com.tencent.mm.plugin.finder.api.c.tsp;
                Log.i(str2, append2.append(c.a.asK(str)).append(" result:").append(z).toString());
            }
            AppMethodBeat.o(253204);
        }
        return z;
    }

    public final void a(f fVar) {
        boolean z;
        AppMethodBeat.i(253205);
        p.h(fVar, NativeProtocol.WEB_DIALOG_ACTION);
        f fVar2 = this.vTX.get(fVar.dNc);
        if (fVar2 != null) {
            if (BuildInfo.DEBUG) {
                String str = TAG;
                StringBuilder append = new StringBuilder("removeFollowCache ").append(fVar).append(" result ");
                if (fVar.vUi >= fVar2.vUi) {
                    z = true;
                } else {
                    z = false;
                }
                Log.i(str, append.append(z).toString());
            }
            if (fVar.vUi >= fVar2.vUi) {
                this.vTX.remove(fVar.dNc);
            }
            AppMethodBeat.o(253205);
            return;
        }
        AppMethodBeat.o(253205);
    }

    public final void dAP() {
        AppMethodBeat.i(253206);
        while (this.vTW.size() > 0) {
            e poll = this.vTW.poll();
            boolean isValid = poll.isValid();
            Log.i(TAG, "tryNext isValid:" + isValid + " action:" + poll + " size:" + this.vTW.size());
            if (isValid) {
                p.g(poll, NativeProtocol.WEB_DIALOG_ACTION);
                a(poll);
                AppMethodBeat.o(253206);
                return;
            }
        }
        AppMethodBeat.o(253206);
    }

    public static final class b implements com.tencent.mm.loader.g.f<h> {
        final /* synthetic */ e vUc;
        final /* synthetic */ g vUo;

        b(g gVar, e eVar) {
            this.vUo = gVar;
            this.vUc = eVar;
        }

        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(h hVar, j jVar) {
            AppMethodBeat.i(253201);
            h hVar2 = hVar;
            p.h(hVar2, "task");
            p.h(jVar, "status");
            a aVar = g.vUn;
            Log.i(g.TAG, "task callback ".concat(String.valueOf(jVar)));
            if (jVar == j.OK) {
                g.a(this.vUo, this.vUc);
                this.vUo.dAP();
                AppMethodBeat.o(253201);
                return;
            }
            if (hVar2.vUd) {
                this.vUo.vTW.add(hVar2.vUe);
            }
            MMHandlerThread.removeRunnable(this.vUo.vRK);
            Runnable runnable = this.vUo.vRK;
            a.C1302a aVar2 = a.vTR;
            MMHandlerThread.postToMainThreadDelayed(runnable, a.qnq);
            AppMethodBeat.o(253201);
        }
    }

    public final void a(e eVar) {
        AppMethodBeat.i(253207);
        this.vRJ.a(new h(eVar), new b(this, eVar));
        AppMethodBeat.o(253207);
    }

    public static final /* synthetic */ void a(g gVar, e eVar) {
        ArrayList<e> arrayList;
        AppMethodBeat.i(253210);
        if (eVar instanceof f) {
            ArrayList arrayList2 = new ArrayList();
            for (T t : gVar.vTW) {
                T t2 = t;
                T t3 = !(t2 instanceof f) ? null : t2;
                if (t3 != null && p.j(t3.dNc, t2.dNc) && eVar.vUi > t2.vUi) {
                    arrayList2.add(t);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            for (e eVar2 : arrayList) {
                Log.i(TAG, "drop action now action " + eVar + ' ' + eVar2);
                gVar.vTW.remove(eVar2);
            }
            AppMethodBeat.o(253210);
            return;
        }
        AppMethodBeat.o(253210);
    }
}

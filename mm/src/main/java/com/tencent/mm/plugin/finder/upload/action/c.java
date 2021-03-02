package com.tencent.mm.plugin.finder.upload.action;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.f;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.loader.g.d;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.p;

public final class c {
    private static final String TAG = TAG;
    private static final c vTZ = new c();
    public static final a vUa = new a((byte) 0);
    private d<d> vRJ = new d<>(new f(new com.tencent.mm.loader.g.a.a(100), new g(1, (byte) 0), 1, "finder_action_fav_post_quene"));
    private final Runnable vRK = new RunnableC1304c(this);
    private final ConcurrentLinkedQueue<e> vTW = new ConcurrentLinkedQueue<>();
    private final ConcurrentHashMap<Long, b> vTX = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Long, b> vTY = new ConcurrentHashMap<>();

    public c() {
        AppMethodBeat.i(253188);
        AppMethodBeat.o(253188);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(253189);
        AppMethodBeat.o(253189);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.finder.upload.action.c$c */
    public static final class RunnableC1304c implements Runnable {
        final /* synthetic */ c vUb;

        RunnableC1304c(c cVar) {
            this.vUb = cVar;
        }

        public final void run() {
            AppMethodBeat.i(253180);
            this.vUb.dAP();
            AppMethodBeat.o(253180);
        }
    }

    public final boolean k(FinderObject finderObject) {
        boolean z = false;
        AppMethodBeat.i(253181);
        p.h(finderObject, "feed");
        if (finderObject.id != 0) {
            if (finderObject.favFlag == 1) {
                z = true;
            }
            b bVar = this.vTX.get(Long.valueOf(finderObject.id));
            if (bVar != null) {
                z = bVar.vTT;
            }
            if (BuildInfo.DEBUG) {
                String str = TAG;
                StringBuilder append = new StringBuilder("isLike test ").append(finderObject.id).append(" isLike:");
                b bVar2 = this.vTX.get(Long.valueOf(finderObject.id));
                Log.i(str, append.append(bVar2 != null ? Boolean.valueOf(bVar2.vTT) : null).append(" favFlag:").append(finderObject.favFlag).append(" result:").append(z).toString());
            }
            AppMethodBeat.o(253181);
            return z;
        } else if (finderObject.favFlag == 1) {
            AppMethodBeat.o(253181);
            return true;
        } else {
            AppMethodBeat.o(253181);
            return false;
        }
    }

    public final int l(FinderObject finderObject) {
        boolean z;
        AppMethodBeat.i(253182);
        p.h(finderObject, "feed");
        if (finderObject.id == 0) {
            int i2 = finderObject.favCount;
            AppMethodBeat.o(253182);
            return i2;
        }
        boolean z2 = finderObject.favFlag == 1;
        b bVar = this.vTX.get(Long.valueOf(finderObject.id));
        if (bVar != null) {
            z = bVar.vTT;
        } else {
            z = z2;
        }
        if (z2 && true != z) {
            int i3 = finderObject.favCount - 1;
            AppMethodBeat.o(253182);
            return i3;
        } else if (z2 || !z) {
            int i4 = finderObject.favCount;
            AppMethodBeat.o(253182);
            return i4;
        } else {
            int i5 = finderObject.favCount + 1;
            AppMethodBeat.o(253182);
            return i5;
        }
    }

    public final void a(b bVar) {
        boolean z;
        AppMethodBeat.i(253183);
        p.h(bVar, NativeProtocol.WEB_DIALOG_ACTION);
        b bVar2 = this.vTX.get(Long.valueOf(bVar.feedId));
        if (bVar2 != null) {
            if (BuildInfo.DEBUG) {
                String str = TAG;
                StringBuilder append = new StringBuilder("removeLikeCache ").append(bVar).append(" result ");
                if (bVar.vUi >= bVar2.vUi) {
                    z = true;
                } else {
                    z = false;
                }
                Log.i(str, append.append(z).toString());
            }
            if (bVar.vUi >= bVar2.vUi) {
                this.vTX.remove(Long.valueOf(bVar.feedId));
            }
            AppMethodBeat.o(253183);
            return;
        }
        AppMethodBeat.o(253183);
    }

    public final void b(b bVar) {
        boolean z;
        AppMethodBeat.i(253184);
        p.h(bVar, NativeProtocol.WEB_DIALOG_ACTION);
        b bVar2 = this.vTY.get(Long.valueOf(bVar.feedId));
        if (bVar2 != null) {
            if (BuildInfo.DEBUG) {
                String str = TAG;
                StringBuilder append = new StringBuilder("removeLikeCache ").append(bVar).append(" result ");
                if (bVar.vUi >= bVar2.vUi) {
                    z = true;
                } else {
                    z = false;
                }
                Log.i(str, append.append(z).toString());
            }
            if (bVar.vUi >= bVar2.vUi) {
                this.vTY.remove(Long.valueOf(bVar.feedId));
            }
            AppMethodBeat.o(253184);
            return;
        }
        AppMethodBeat.o(253184);
    }

    public final void dAP() {
        AppMethodBeat.i(253185);
        while (this.vTW.size() > 0) {
            e poll = this.vTW.poll();
            boolean isValid = poll.isValid();
            Log.i(TAG, "tryNext isValid:" + isValid + " action:" + poll + " size:" + this.vTW.size());
            if (isValid) {
                p.g(poll, NativeProtocol.WEB_DIALOG_ACTION);
                a(poll);
                AppMethodBeat.o(253185);
                return;
            }
        }
        AppMethodBeat.o(253185);
    }

    public static /* synthetic */ void a(c cVar, FinderItem finderItem, boolean z, bbn bbn) {
        AppMethodBeat.i(253186);
        p.h(finderItem, "feed");
        p.h(bbn, "contextObj");
        Log.i(TAG, "dolike " + finderItem.getUserName() + ' ' + z + ", isLongVideo = false");
        long j2 = finderItem.field_id;
        String objectNonceId = finderItem.getObjectNonceId();
        p.g(objectNonceId, "if (isLongVideo) feed.me…\" else feed.objectNonceId");
        b bVar = new b(finderItem, j2, objectNonceId, z, 2, bbn);
        cVar.vTX.put(Long.valueOf(j2), bVar);
        cVar.a((e) bVar);
        AppMethodBeat.o(253186);
    }

    public static final class b implements com.tencent.mm.loader.g.f<d> {
        final /* synthetic */ c vUb;
        final /* synthetic */ e vUc;

        b(c cVar, e eVar) {
            this.vUb = cVar;
            this.vUc = eVar;
        }

        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(d dVar, j jVar) {
            AppMethodBeat.i(253179);
            d dVar2 = dVar;
            p.h(dVar2, "task");
            p.h(jVar, "status");
            a aVar = c.vUa;
            Log.i(c.TAG, "task callback ".concat(String.valueOf(jVar)));
            if (jVar == j.OK) {
                c.a(this.vUb, this.vUc);
                this.vUb.dAP();
                AppMethodBeat.o(253179);
                return;
            }
            if (dVar2.vUd) {
                this.vUb.vTW.add(dVar2.vUe);
            }
            MMHandlerThread.removeRunnable(this.vUb.vRK);
            Runnable runnable = this.vUb.vRK;
            a.C1302a aVar2 = a.vTR;
            MMHandlerThread.postToMainThreadDelayed(runnable, a.qnq);
            AppMethodBeat.o(253179);
        }
    }

    private final void a(e eVar) {
        AppMethodBeat.i(253187);
        this.vRJ.a(new d(eVar), new b(this, eVar));
        AppMethodBeat.o(253187);
    }

    public static final /* synthetic */ void a(c cVar, e eVar) {
        ArrayList<e> arrayList;
        AppMethodBeat.i(253190);
        if (eVar instanceof b) {
            ArrayList arrayList2 = new ArrayList();
            for (T t : cVar.vTW) {
                T t2 = t;
                T t3 = !(t2 instanceof b) ? null : t2;
                if (t3 != null && t3.feedId == t2.feedId && eVar.vUi > t2.vUi) {
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
                cVar.vTW.remove(eVar2);
            }
            AppMethodBeat.o(253190);
            return;
        }
        AppMethodBeat.o(253190);
    }
}

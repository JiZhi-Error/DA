package com.tencent.mm.plugin.setting.model;

import android.database.Cursor;
import com.tencent.f.i.b;
import com.tencent.f.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.g.a.yt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public final class o {
    public boolean CXV;
    public boolean CXW;
    public boolean CXX;
    final CountDownLatch CXY;
    HashSet<String> CXZ = new HashSet<>();
    HashSet<String> CYa = new HashSet<>();
    HashSet<String> CYb = new HashSet<>();
    HashSet<String> CYc = new HashSet<>();
    public a CYd;
    public UnfamiliarContactDetailUI.h CYe;
    public long CYf;
    public b CYg;
    Object mLock = new Object();
    public final MMHandler qmq;

    public o(boolean z, boolean z2, boolean z3, UnfamiliarContactDetailUI.h hVar) {
        AppMethodBeat.i(73799);
        this.CXV = z;
        this.CXW = z2;
        this.CXX = z3;
        int i2 = (this.CXX ? 1 : 0) + (this.CXV ? 1 : 0) + (this.CXW ? 1 : 0);
        Log.i("MicroMsg.UnfamiliarContactEngine", "[UnfamiliarContactEngine] count:%s [%s:%s:%s]", Integer.valueOf(i2), Boolean.valueOf(this.CXW), Boolean.valueOf(this.CXV), Boolean.valueOf(this.CXX));
        this.CXY = new CountDownLatch(i2);
        this.qmq = new MMHandler("UnfamiliarContactEngine");
        this.CYe = hVar;
        AppMethodBeat.o(73799);
    }

    /* access modifiers changed from: package-private */
    public class a implements h, i {
        UnfamiliarContactDetailUI.h CYm;
        q CYn;
        CountDownLatch rDn;
        long start;

        a(UnfamiliarContactDetailUI.h hVar, CountDownLatch countDownLatch) {
            this.CYm = hVar;
            this.rDn = countDownLatch;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(73796);
            if (i2 == 0 && i3 == 0) {
                if (qVar.getType() == 292) {
                    this.CYn = qVar;
                    com.tencent.f.h.RTc.aX(this);
                }
                AppMethodBeat.o(73796);
                return;
            }
            Log.e("MicroMsg.UnfamiliarContactEngine", "[onSceneEnd] errType:%s errCode:%s errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            this.rDn.countDown();
            AppMethodBeat.o(73796);
        }

        public final void run() {
            AppMethodBeat.i(73797);
            yt ytVar = new yt();
            ytVar.eeX.eeZ = this.CYn;
            EventCenter.instance.publish(ytVar);
            int i2 = ytVar.eeY.state;
            List list = ytVar.eeY.efa;
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Boolean.valueOf(list == null);
            objArr[2] = Integer.valueOf(list == null ? 0 : list.size());
            Log.i("MicroMsg.UnfamiliarContactEngine", "[callback] state:%s,tagList is null?%s,tagList size:%s", objArr);
            if (i2 != 1) {
                if (list != null) {
                    o.this.CYc.addAll(list);
                }
                Log.i("MicroMsg.UnfamiliarContactEngine", "[AsyncGetSnsTagInfo] %sms", Long.valueOf(System.currentTimeMillis() - this.start));
                this.rDn.countDown();
                AppMethodBeat.o(73797);
                return;
            }
            if (this.CYm != null) {
                o.this.qmq.postUI(new Runnable() {
                    /* class com.tencent.mm.plugin.setting.model.o.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(73794);
                        a.this.CYm.a(UnfamiliarContactDetailUI.e.OVER_ONE_MIN);
                        AppMethodBeat.o(73794);
                    }
                });
            }
            o.this.qmq.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.setting.model.o.a.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(73795);
                    a.eSH();
                    AppMethodBeat.o(73795);
                }
            }, 30000);
            AppMethodBeat.o(73797);
        }

        static void eSH() {
            AppMethodBeat.i(73798);
            ke keVar = new ke();
            keVar.dPe.dKy = 3;
            EventCenter.instance.publish(keVar);
            AppMethodBeat.o(73798);
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "load_unfamiliar_contact";
        }
    }

    /* access modifiers changed from: package-private */
    public final void i(final LinkedList<String> linkedList, int i2) {
        AppMethodBeat.i(73800);
        final long currentTimeMillis = System.currentTimeMillis();
        final int size = i2 + 10 < linkedList.size() ? i2 + 10 : linkedList.size();
        final List<String> subList = linkedList.subList(i2, size);
        j jVar = new j();
        jVar.kXb = 8;
        jVar.query = Util.listToString(subList, ",");
        jVar.wWZ = new l() {
            /* class com.tencent.mm.plugin.setting.model.o.AnonymousClass4 */
            final int limit = size;

            {
                AppMethodBeat.i(73792);
                AppMethodBeat.o(73792);
            }

            @Override // com.tencent.mm.plugin.fts.a.l
            public final void b(k kVar) {
                String str;
                String str2;
                boolean z;
                char c2;
                Object[] objArr;
                Object[] objArr2;
                boolean z2;
                AppMethodBeat.i(73793);
                List<m> list = kVar.wXb;
                if (list == null || list.size() <= 0) {
                    str = "MicroMsg.UnfamiliarContactEngine";
                    str2 = "[getSameChatInfoTask] list is null? %s ";
                    Object[] objArr3 = new Object[1];
                    if (subList == null) {
                        z = true;
                        c2 = 0;
                        objArr = objArr3;
                        objArr2 = objArr3;
                    } else {
                        z = false;
                        c2 = 0;
                        objArr = objArr3;
                        objArr2 = objArr3;
                    }
                    objArr[c2] = Boolean.valueOf(z);
                    Log.e(str, str2, objArr2);
                } else {
                    m mVar = list.get(0);
                    if (mVar.userData == null || !(mVar.userData instanceof HashMap)) {
                        str = "MicroMsg.UnfamiliarContactEngine";
                        str2 = "[getSameChatInfoTask] is null?%s is instanceof List";
                        Object[] objArr4 = new Object[2];
                        objArr4[0] = Boolean.valueOf(mVar.userData == null);
                        z = mVar.userData instanceof HashMap;
                        c2 = 1;
                        objArr = objArr4;
                        objArr2 = objArr4;
                        objArr[c2] = Boolean.valueOf(z);
                        Log.e(str, str2, objArr2);
                    } else {
                        HashMap hashMap = (HashMap) mVar.userData;
                        synchronized (o.this.mLock) {
                            try {
                                for (String str3 : subList) {
                                    if (!hashMap.containsKey(str3)) {
                                        o.this.CYb.add(str3);
                                    } else {
                                        Iterator it = ((List) hashMap.get(str3)).iterator();
                                        while (true) {
                                            if (it.hasNext()) {
                                                if (((m) it.next()).wXe < 100) {
                                                    z2 = true;
                                                    break;
                                                }
                                            } else {
                                                z2 = false;
                                                break;
                                            }
                                        }
                                        if (!z2) {
                                            o.this.CYb.add(str3);
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                AppMethodBeat.o(73793);
                                throw th;
                            }
                        }
                    }
                }
                if (this.limit >= linkedList.size()) {
                    Log.i("MicroMsg.UnfamiliarContactEngine", "[getSameChatInfoTask] finish all load! userNames.size:%s cost:%sms", Integer.valueOf(linkedList.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    o.this.CXY.countDown();
                    AppMethodBeat.o(73793);
                    return;
                }
                o.this.i(linkedList, this.limit);
                AppMethodBeat.o(73793);
            }
        };
        jVar.handler = this.qmq;
        ((n) g.ah(n.class)).search(2, jVar);
        AppMethodBeat.o(73800);
    }

    static /* synthetic */ void a(o oVar, LinkedList linkedList) {
        AppMethodBeat.i(73801);
        if (oVar.CXW) {
            oVar.CYd = new a(oVar.CYe, oVar.CXY);
            a aVar = oVar.CYd;
            aVar.start = System.currentTimeMillis();
            g.azz().a(com.tencent.mm.plugin.appbrand.jsapi.audio.l.CTRL_INDEX, aVar);
            a.eSH();
        }
        if (oVar.CXV) {
            final HashSet hashSet = new HashSet();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                hashSet.add((String) it.next());
            }
            final long currentTimeMillis = System.currentTimeMillis() - 15552000000L;
            Log.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] timestamp:%s size:%s", Long.valueOf(currentTimeMillis), Integer.valueOf(hashSet.size()));
            final long currentTimeMillis2 = System.currentTimeMillis();
            j jVar = new j();
            jVar.kXb = 9;
            jVar.query = String.valueOf(currentTimeMillis);
            jVar.wWZ = new l() {
                /* class com.tencent.mm.plugin.setting.model.o.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.fts.a.l
                public final void b(k kVar) {
                    AppMethodBeat.i(73791);
                    List<m> list = kVar.wXb;
                    if (list != null) {
                        for (m mVar : list) {
                            hashSet.remove(mVar.wVX);
                            o.this.CYa.add(mVar.wVX);
                        }
                    }
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        int D = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().D(str, currentTimeMillis, System.currentTimeMillis());
                        if (D > 0) {
                            Log.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] talker:%s voipCount:%s", str, Integer.valueOf(D));
                        } else {
                            Cursor a2 = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(str, currentTimeMillis, System.currentTimeMillis(), true);
                            if (a2.getCount() > 0) {
                                Cursor a3 = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(str, currentTimeMillis, System.currentTimeMillis(), false);
                                if (a3.getCount() <= 0) {
                                    o.this.CYa.add(str);
                                }
                                a3.close();
                            } else {
                                o.this.CYa.add(str);
                            }
                            a2.close();
                        }
                    }
                    Log.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] query:%s cost:%sms", Long.valueOf(currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                    o.this.CXY.countDown();
                    AppMethodBeat.o(73791);
                }
            };
            jVar.handler = oVar.qmq;
            ((n) g.ah(n.class)).search(2, jVar);
        }
        if (oVar.CXX) {
            oVar.i(linkedList, 0);
        }
        com.tencent.f.i iVar = com.tencent.f.h.RTc;
        AnonymousClass2 r1 = new b() {
            /* class com.tencent.mm.plugin.setting.model.o.AnonymousClass2 */

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "MicroMsg.UnfamiliarContactEngineAwait";
            }

            public final void run() {
                AppMethodBeat.i(73790);
                try {
                    o.this.CXY.await();
                    long currentTimeMillis = System.currentTimeMillis();
                    o.this.CXZ.clear();
                    o.this.CYa.remove(z.aTY());
                    o.this.CXZ.addAll(o.this.CYa);
                    o.this.CXZ.addAll(o.this.CYb);
                    o.this.CXZ.addAll(o.this.CYc);
                    if (o.this.CXW) {
                        o.this.CXZ.retainAll(o.this.CYc);
                    }
                    if (o.this.CXX) {
                        o.this.CXZ.retainAll(o.this.CYb);
                    }
                    if (o.this.CXV) {
                        o.this.CXZ.retainAll(o.this.CYa);
                    }
                    o.this.CYe.e(o.this.CXZ);
                    Log.i("MicroMsg.UnfamiliarContactEngine", "[onResult] :%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    o.this.qmq.postUI(new Runnable() {
                        /* class com.tencent.mm.plugin.setting.model.o.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(73788);
                            o.this.CYe.onSuccess();
                            AppMethodBeat.o(73788);
                        }
                    });
                    Log.i("MicroMsg.UnfamiliarContactEngine", "all cost:%sms", Long.valueOf(System.currentTimeMillis() - o.this.CYf));
                    AppMethodBeat.o(73790);
                } catch (InterruptedException e2) {
                    Log.printErrStackTrace("MicroMsg.UnfamiliarContactEngine", e2, "", new Object[0]);
                    o.this.qmq.postUI(new Runnable() {
                        /* class com.tencent.mm.plugin.setting.model.o.AnonymousClass2.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(73789);
                            o.this.CYe.onError();
                            AppMethodBeat.o(73789);
                        }
                    });
                    AppMethodBeat.o(73790);
                }
            }
        };
        oVar.CYg = r1;
        iVar.aX(r1);
        AppMethodBeat.o(73801);
    }
}

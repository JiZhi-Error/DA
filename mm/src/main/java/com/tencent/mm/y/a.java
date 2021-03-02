package com.tencent.mm.y;

import android.os.Looper;
import android.os.Message;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.y.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    static a hlO;
    private MMHandler handler = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.y.a.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(150037);
            if (message.what == 0 && (message.obj instanceof b)) {
                b bVar = (b) message.obj;
                if (bVar.hlU != null) {
                    a aVar = a.this;
                    ar.a aVar2 = bVar.hlU;
                    ArrayList arrayList = null;
                    Iterator<WeakReference<AbstractC2176a>> it = aVar.listeners.iterator();
                    while (it.hasNext()) {
                        WeakReference<AbstractC2176a> next = it.next();
                        if (next == null || next.get() == null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(next);
                        } else {
                            next.get().b(aVar2);
                        }
                    }
                    if (arrayList != null) {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            aVar.listeners.remove((WeakReference) it2.next());
                        }
                        arrayList.clear();
                    }
                    AppMethodBeat.o(150037);
                    return;
                }
                a.a(a.this, bVar.hlT, bVar.value);
            }
            AppMethodBeat.o(150037);
        }
    };
    public b hlP = new b();
    private final int hlQ = 0;
    private final int hlR = 1;
    public boolean initialized = false;
    ArrayList<WeakReference<AbstractC2176a>> listeners = new ArrayList<>();

    /* renamed from: com.tencent.mm.y.a$a  reason: collision with other inner class name */
    public interface AbstractC2176a {
        void D(int i2, String str);

        void b(ar.a aVar);
    }

    public a() {
        AppMethodBeat.i(150038);
        AppMethodBeat.o(150038);
    }

    /* access modifiers changed from: package-private */
    public class b {
        int hlT;
        ar.a hlU;
        int type;
        String value;

        public b(int i2, int i3, String str) {
            this.hlT = i2;
            this.type = i3;
            this.value = str;
        }

        public b(ar.a aVar, int i2, String str) {
            this.hlU = aVar;
            this.type = i2;
            this.value = str;
        }
    }

    class c {
        int hlT;
        ar.a hlU;
        int hlV;
        ar.a hlW;

        public c(int i2, int i3) {
            this.hlV = i2;
            this.hlT = i3;
        }

        public c(ar.a aVar, ar.a aVar2) {
            this.hlW = aVar;
            this.hlU = aVar2;
        }

        public c(int i2, ar.a aVar) {
            this.hlV = i2;
            this.hlU = aVar;
        }
    }

    public final void init() {
        AppMethodBeat.i(150039);
        this.initialized = true;
        this.hlP.hmc = g.aAh().azQ();
        AppMethodBeat.o(150039);
    }

    public final void A(int i2, boolean z) {
        AppMethodBeat.i(150040);
        f(i2, 1, !z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1");
        AppMethodBeat.o(150040);
    }

    public final void a(ar.a aVar, boolean z) {
        AppMethodBeat.i(150041);
        a(aVar, 1, !z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1");
        AppMethodBeat.o(150041);
    }

    public final void B(int i2, boolean z) {
        AppMethodBeat.i(150042);
        f(i2, 2, !z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1");
        AppMethodBeat.o(150042);
    }

    public final void b(ar.a aVar, boolean z) {
        AppMethodBeat.i(150043);
        a(aVar, 2, !z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1");
        AppMethodBeat.o(150043);
    }

    private void f(int i2, int i3, String str) {
        AppMethodBeat.i(150044);
        if (!this.initialized) {
            Log.w("MicroMsg.NewBadge", "updateDataSource NewBadge has not initialized");
            AppMethodBeat.o(150044);
            return;
        }
        this.hlP.g(i2, i3, str);
        this.handler.sendMessage(this.handler.obtainMessage(0, new b(i2, i3, str)));
        AppMethodBeat.o(150044);
    }

    private void a(ar.a aVar, int i2, String str) {
        AppMethodBeat.i(150045);
        if (!this.initialized) {
            Log.w("MicroMsg.NewBadge", "updateDataSource NewBadge has not initialized");
            AppMethodBeat.o(150045);
            return;
        }
        this.hlP.b(aVar, i2, str);
        this.handler.sendMessage(this.handler.obtainMessage(0, new b(aVar, i2, str)));
        AppMethodBeat.o(150045);
    }

    public final boolean cO(int i2, int i3) {
        AppMethodBeat.i(150046);
        if (!this.initialized) {
            Log.w("MicroMsg.NewBadge", "hasNew NewBadge has not initialized");
            AppMethodBeat.o(150046);
            return false;
        }
        b.a K = this.hlP.K(i2, i3, 1);
        if (K == null) {
            AppMethodBeat.o(150046);
            return false;
        } else if (parseInt(K.value) == 0) {
            AppMethodBeat.o(150046);
            return false;
        } else {
            AppMethodBeat.o(150046);
            return true;
        }
    }

    public final boolean a(ar.a aVar, ar.a aVar2) {
        AppMethodBeat.i(150047);
        if (!this.initialized) {
            Log.w("MicroMsg.NewBadge", "hasNew NewBadge has not initialized");
            AppMethodBeat.o(150047);
            return false;
        }
        b.a a2 = this.hlP.a(aVar, aVar2, 1);
        if (a2 == null) {
            AppMethodBeat.o(150047);
            return false;
        } else if (parseInt(a2.value) == 0) {
            AppMethodBeat.o(150047);
            return false;
        } else {
            AppMethodBeat.o(150047);
            return true;
        }
    }

    public final boolean cP(int i2, int i3) {
        AppMethodBeat.i(150048);
        if (!this.initialized) {
            Log.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
            AppMethodBeat.o(150048);
            return false;
        }
        b.a K = this.hlP.K(i2, i3, 2);
        if (K == null) {
            AppMethodBeat.o(150048);
            return false;
        } else if (parseInt(K.value) == 0) {
            AppMethodBeat.o(150048);
            return false;
        } else {
            AppMethodBeat.o(150048);
            return true;
        }
    }

    public final boolean b(ar.a aVar, ar.a aVar2) {
        AppMethodBeat.i(150049);
        if (!this.initialized) {
            Log.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
            AppMethodBeat.o(150049);
            return false;
        }
        b.a a2 = this.hlP.a(aVar, aVar2, 2);
        if (a2 == null) {
            AppMethodBeat.o(150049);
            return false;
        } else if (parseInt(a2.value) == 0) {
            AppMethodBeat.o(150049);
            return false;
        } else {
            AppMethodBeat.o(150049);
            return true;
        }
    }

    public final boolean a(ar.a aVar, int i2) {
        b.a aVar2;
        AppMethodBeat.i(150050);
        if (!this.initialized) {
            Log.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
            AppMethodBeat.o(150050);
            return false;
        }
        b bVar = this.hlP;
        Log.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceKey %s, watcherId %d, type %d", aVar, Integer.valueOf(i2), 2);
        b.a f2 = bVar.f(aVar);
        if (f2 == null) {
            Log.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
            aVar2 = null;
        } else if ((f2.type & 2) == 0) {
            Log.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
            aVar2 = null;
        } else {
            b.C2177b pM = bVar.pM(i2);
            if (pM != null) {
                String str = pM.hmg.get(aVar.name());
                if (str == null || !str.equals(f2.dHx)) {
                    if (str == null) {
                        pM.hmg.put(aVar.name(), bVar.axT());
                        bVar.a(pM);
                    }
                    aVar2 = f2;
                } else {
                    aVar2 = null;
                }
            } else {
                Log.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
                aVar2 = null;
            }
        }
        if (aVar2 == null) {
            AppMethodBeat.o(150050);
            return false;
        } else if (parseInt(aVar2.value) == 0) {
            AppMethodBeat.o(150050);
            return false;
        } else {
            AppMethodBeat.o(150050);
            return true;
        }
    }

    public final void cQ(int i2, int i3) {
        AppMethodBeat.i(150051);
        if (!this.initialized) {
            Log.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
            AppMethodBeat.o(150051);
            return;
        }
        b bVar = this.hlP;
        Log.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %d, watcherId %d", Integer.valueOf(i2), Integer.valueOf(i3));
        b.a pL = bVar.pL(i2);
        if (pL == null) {
            Log.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
        } else {
            b.C2177b pM = bVar.pM(i3);
            if (pM == null) {
                Log.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
                pM = bVar.pK(i3);
                bVar.hlZ.put(i3, pM);
            }
            pM.hmf.put(i2, pL.dHx);
            bVar.a(pM);
        }
        this.handler.sendMessage(this.handler.obtainMessage(1, new c(i3, i2)));
        AppMethodBeat.o(150051);
    }

    public final void c(ar.a aVar, ar.a aVar2) {
        AppMethodBeat.i(150052);
        if (!this.initialized) {
            Log.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
            AppMethodBeat.o(150052);
            return;
        }
        this.hlP.d(aVar, aVar2);
        this.handler.sendMessage(this.handler.obtainMessage(1, new c(aVar2, aVar)));
        AppMethodBeat.o(150052);
    }

    public final void b(ar.a aVar, int i2) {
        AppMethodBeat.i(150053);
        if (!this.initialized) {
            Log.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
            AppMethodBeat.o(150053);
            return;
        }
        b bVar = this.hlP;
        Log.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %s, watcherKey %d", aVar, Integer.valueOf(i2));
        b.a f2 = bVar.f(aVar);
        if (f2 == null) {
            Log.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
        } else {
            b.C2177b pM = bVar.pM(i2);
            if (pM == null) {
                Log.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
                pM = bVar.pK(i2);
                bVar.hlZ.put(i2, pM);
            }
            pM.hmg.put(aVar.name(), f2.dHx);
            bVar.a(pM);
        }
        this.handler.sendMessage(this.handler.obtainMessage(1, new c(i2, aVar)));
        AppMethodBeat.o(150053);
    }

    public final boolean axS() {
        AppMethodBeat.i(223517);
        if (!this.initialized) {
            Log.w("MicroMsg.NewBadge", "queryHasDotSourceValue NewBadge has not initialized");
            AppMethodBeat.o(223517);
            return false;
        }
        b.a pL = this.hlP.pL(352280);
        if (pL == null) {
            AppMethodBeat.o(223517);
            return false;
        } else if (parseInt(pL.value) == 0) {
            AppMethodBeat.o(223517);
            return false;
        } else {
            AppMethodBeat.o(223517);
            return true;
        }
    }

    public final boolean a(ar.a aVar) {
        AppMethodBeat.i(150054);
        if (!this.initialized) {
            Log.w("MicroMsg.NewBadge", "queryHasDotSourceValue NewBadge has not initialized");
            AppMethodBeat.o(150054);
            return false;
        }
        b.a f2 = this.hlP.f(aVar);
        if (f2 == null) {
            AppMethodBeat.o(150054);
            return false;
        } else if (parseInt(f2.value) == 0) {
            AppMethodBeat.o(150054);
            return false;
        } else {
            AppMethodBeat.o(150054);
            return true;
        }
    }

    public static int parseInt(String str) {
        AppMethodBeat.i(150055);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(150055);
            return 0;
        }
        int safeParseInt = Util.safeParseInt(str);
        AppMethodBeat.o(150055);
        return safeParseInt;
    }

    public final void a(AbstractC2176a aVar) {
        AppMethodBeat.i(150056);
        if (!this.initialized) {
            Log.w("MicroMsg.NewBadge", "addWatch NewBadge has not initialized");
            AppMethodBeat.o(150056);
            return;
        }
        this.listeners.add(new WeakReference<>(aVar));
        AppMethodBeat.o(150056);
    }

    public final void b(AbstractC2176a aVar) {
        AppMethodBeat.i(150057);
        if (!this.initialized) {
            Log.w("MicroMsg.NewBadge", "removeWatch NewBadge has not initialized");
            AppMethodBeat.o(150057);
            return;
        }
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < this.listeners.size(); i2++) {
            WeakReference<AbstractC2176a> weakReference = this.listeners.get(i2);
            if (weakReference == null || weakReference.get() == null || weakReference.get() == aVar) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(weakReference);
            }
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.listeners.remove((WeakReference) it.next());
            }
            arrayList.clear();
        }
        AppMethodBeat.o(150057);
    }

    static /* synthetic */ void a(a aVar, int i2, String str) {
        AppMethodBeat.i(150058);
        ArrayList arrayList = null;
        Iterator<WeakReference<AbstractC2176a>> it = aVar.listeners.iterator();
        while (it.hasNext()) {
            WeakReference<AbstractC2176a> next = it.next();
            if (next == null || next.get() == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(next);
            } else {
                next.get().D(i2, str);
            }
        }
        if (arrayList != null) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                aVar.listeners.remove((WeakReference) it2.next());
            }
            arrayList.clear();
        }
        AppMethodBeat.o(150058);
    }
}

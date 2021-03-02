package com.tencent.mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskForNative;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public final class c implements i {
    public static String TAG = "MicroMsg.LocationAddr";
    private static c iVc;
    private static final String iVd = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e1q) + "/rgeoc?lnglat=%f,%f");
    private HashMap<String, CopyOnWriteArrayList<WeakReference<a>>> bGH = new HashMap<>();
    private C0453c iVe = null;
    private CopyOnWriteArrayList<C0453c> iVf = new CopyOnWriteArrayList<>();
    private QueueWorkerThread iVg = new QueueWorkerThread(1, "addr_worker");
    private boolean iVh = true;

    public interface a {
        void b(Addr addr);
    }

    static /* synthetic */ void a(c cVar, Addr addr) {
        AppMethodBeat.i(150480);
        cVar.a(addr);
        AppMethodBeat.o(150480);
    }

    static /* synthetic */ Addr b(double d2, double d3, boolean z) {
        AppMethodBeat.i(150479);
        Addr a2 = a(d2, d3, z);
        AppMethodBeat.o(150479);
        return a2;
    }

    static {
        AppMethodBeat.i(223568);
        AppMethodBeat.o(223568);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.modelgeo.c$c  reason: collision with other inner class name */
    public class C0453c {
        double lat;
        double lng;
        Object tag = "";

        public C0453c(double d2, double d3, Object obj) {
            this.lat = d2;
            this.lng = d3;
            this.tag = obj;
        }

        public final String toString() {
            String sb;
            AppMethodBeat.i(150465);
            StringBuilder append = new StringBuilder().append((int) (this.lat * 1000000.0d)).append((int) (this.lng * 1000000.0d));
            if (this.tag == null) {
                sb = "";
            } else if ((this.tag instanceof Integer) || (this.tag instanceof Long) || (this.tag instanceof Double) || (this.tag instanceof Float) || (this.tag instanceof String)) {
                sb = new StringBuilder().append(this.tag).toString();
            } else {
                sb = this.tag.toString();
            }
            String sb2 = append.append(sb).toString();
            AppMethodBeat.o(150465);
            return sb2;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(150466);
            if (obj == null || !(obj instanceof C0453c)) {
                AppMethodBeat.o(150466);
                return false;
            }
            boolean equals = ((C0453c) obj).toString().equals(toString());
            AppMethodBeat.o(150466);
            return equals;
        }
    }

    private c() {
        AppMethodBeat.i(150467);
        AppMethodBeat.o(150467);
    }

    public static c bbX() {
        AppMethodBeat.i(150468);
        if (iVc == null) {
            iVc = new c();
        }
        c cVar = iVc;
        AppMethodBeat.o(150468);
        return cVar;
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(150469);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (String str : this.bGH.keySet()) {
            CopyOnWriteArrayList<WeakReference<a>> copyOnWriteArrayList = this.bGH.get(str);
            b(copyOnWriteArrayList, aVar);
            this.bGH.put(str, copyOnWriteArrayList);
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
                linkedList2.add(str);
            }
        }
        Iterator it = linkedList2.iterator();
        while (it.hasNext()) {
            this.bGH.remove((String) it.next());
        }
        Iterator<C0453c> it2 = this.iVf.iterator();
        while (it2.hasNext()) {
            C0453c next = it2.next();
            CopyOnWriteArrayList<WeakReference<a>> copyOnWriteArrayList2 = this.bGH.get(next.toString());
            if (copyOnWriteArrayList2 == null || copyOnWriteArrayList2.size() == 0) {
                linkedList.add(next);
                this.bGH.remove(next.toString());
            }
        }
        Iterator it3 = linkedList.iterator();
        while (it3.hasNext()) {
            this.iVf.remove((C0453c) it3.next());
        }
        Log.i(TAG, "remove taskLists %d listeners size %d", Integer.valueOf(this.iVf.size()), Integer.valueOf(this.bGH.size()));
        AppMethodBeat.o(150469);
        return true;
    }

    private static boolean a(CopyOnWriteArrayList<WeakReference<a>> copyOnWriteArrayList, a aVar) {
        AppMethodBeat.i(150470);
        Iterator<WeakReference<a>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference<a> next = it.next();
            if (next != null && next.get() != null && next.get().equals(aVar)) {
                AppMethodBeat.o(150470);
                return true;
            }
        }
        AppMethodBeat.o(150470);
        return false;
    }

    private static boolean b(CopyOnWriteArrayList<WeakReference<a>> copyOnWriteArrayList, a aVar) {
        AppMethodBeat.i(150471);
        if (copyOnWriteArrayList == null) {
            AppMethodBeat.o(150471);
            return false;
        }
        Iterator<WeakReference<a>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference<a> next = it.next();
            if (next != null && next.get() != null && next.get().equals(aVar)) {
                copyOnWriteArrayList.remove(next);
                AppMethodBeat.o(150471);
                return true;
            }
        }
        AppMethodBeat.o(150471);
        return false;
    }

    public final boolean a(double d2, double d3, a aVar) {
        AppMethodBeat.i(150473);
        boolean a2 = a(d2, d3, aVar, null);
        AppMethodBeat.o(150473);
        return a2;
    }

    private void bbY() {
        AppMethodBeat.i(150474);
        if (this.iVe == null && this.iVf != null && this.iVf.size() > 0) {
            this.iVe = this.iVf.remove(0);
            bbZ();
        }
        AppMethodBeat.o(150474);
    }

    private void bbZ() {
        AppMethodBeat.i(150475);
        if (Util.isOverseasUser(MMApplicationContext.getContext())) {
            this.iVg.add(new b());
            AppMethodBeat.o(150475);
            return;
        }
        g.azz().a(JsApiAddDownloadTaskForNative.CTRL_INDEX, this);
        g.azz().a(new e(this.iVe.lat, this.iVe.lng), 0);
        AppMethodBeat.o(150475);
    }

    /* access modifiers changed from: package-private */
    public class b implements QueueWorkerThread.ThreadObject {
        private Addr iVi = null;

        public b() {
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean doInBackground() {
            AppMethodBeat.i(150463);
            if (c.this.iVe == null) {
                AppMethodBeat.o(150463);
                return false;
            }
            if (this.iVi == null || this.iVi.iUO == null || this.iVi.iUO.equals("")) {
                this.iVi = c.b(c.this.iVe.lat, c.this.iVe.lng, c.this.iVh);
            }
            AppMethodBeat.o(150463);
            return true;
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean onPostExecute() {
            AppMethodBeat.i(150464);
            c.this.iVh = true;
            c.a(c.this, this.iVi);
            AppMethodBeat.o(150464);
            return true;
        }
    }

    private void a(Addr addr) {
        Object obj;
        AppMethodBeat.i(150476);
        if (this.iVe == null) {
            AppMethodBeat.o(150476);
            return;
        }
        if (addr == null) {
            addr = new Addr();
        }
        if (this.iVe.tag == null) {
            obj = new Object();
        } else {
            obj = this.iVe.tag;
        }
        addr.tag = obj;
        addr.iUY = (float) this.iVe.lat;
        addr.iUZ = (float) this.iVe.lng;
        CopyOnWriteArrayList<WeakReference<a>> copyOnWriteArrayList = this.bGH.get(this.iVe.toString());
        if (copyOnWriteArrayList != null) {
            Iterator<WeakReference<a>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference<a> next = it.next();
                if (!(next == null || next.get() == null)) {
                    next.get().b(addr);
                }
            }
        }
        this.bGH.remove(this.iVe.toString());
        Log.d(TAG, "postexecute2 listeners %d", Integer.valueOf(this.bGH.size()));
        this.iVe = null;
        bbY();
        if (this.iVe == null && this.iVf.size() > 0) {
            g.azz().b(JsApiAddDownloadTaskForNative.CTRL_INDEX, this);
        }
        AppMethodBeat.o(150476);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0084, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0084 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:6:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00a6 A[SYNTHETIC, Splitter:B:17:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x024e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.mm.modelgeo.Addr a(double r14, double r16, boolean r18) {
        /*
        // Method dump skipped, instructions count: 622
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelgeo.c.a(double, double, boolean):com.tencent.mm.modelgeo.Addr");
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(150478);
        if (qVar.getType() == 655) {
            Addr bce = ((e) qVar).bce();
            if (bce == null || bce.iUO == null || bce.iUO.equals("")) {
                this.iVg.add(new b());
                AppMethodBeat.o(150478);
                return;
            }
            a(bce);
        }
        AppMethodBeat.o(150478);
    }

    public final boolean a(double d2, double d3, a aVar, Object obj) {
        AppMethodBeat.i(150472);
        if (obj != null) {
            Iterator<C0453c> it = this.iVf.iterator();
            while (true) {
                if (it.hasNext()) {
                    C0453c next = it.next();
                    if (next != null && next.tag != null && next.tag.equals(obj)) {
                        this.iVf.remove(next);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        C0453c cVar = new C0453c(d2, d3, obj);
        CopyOnWriteArrayList<WeakReference<a>> copyOnWriteArrayList = this.bGH.get(cVar.toString());
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        }
        if (!a(copyOnWriteArrayList, aVar)) {
            copyOnWriteArrayList.add(new WeakReference<>(aVar));
        }
        this.bGH.put(cVar.toString(), copyOnWriteArrayList);
        Iterator<C0453c> it2 = this.iVf.iterator();
        while (it2.hasNext()) {
            if (it2.next().equals(cVar)) {
                bbY();
                AppMethodBeat.o(150472);
                return false;
            }
        }
        if (this.iVe == null || !cVar.equals(this.iVe)) {
            this.iVf.add(cVar);
            Log.i(TAG, "push task size %d listeners %d", Integer.valueOf(this.iVf.size()), Integer.valueOf(this.bGH.size()));
            while (this.iVf.size() > 30) {
                Log.i(TAG, "force remove task");
                C0453c remove = this.iVf.remove(0);
                if (remove != null) {
                    this.bGH.remove(remove.toString());
                }
            }
            bbY();
            AppMethodBeat.o(150472);
            return true;
        }
        AppMethodBeat.o(150472);
        return false;
    }
}

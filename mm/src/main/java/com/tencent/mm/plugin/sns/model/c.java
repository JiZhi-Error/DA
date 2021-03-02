package com.tencent.mm.plugin.sns.model;

import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.n.h;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.data.f;
import com.tencent.mm.plugin.sns.data.n;
import com.tencent.mm.plugin.sns.data.o;
import com.tencent.mm.plugin.sns.data.p;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.a.c;
import com.tencent.mm.plugin.sns.model.a.e;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.xwalk.core.XWalkFeature;

public final class c implements i, c.a {
    static int DGB = 0;
    private static final int DGC = (Build.VERSION.SDK_INT >= 14 ? 100 : 25);
    private long DGD;
    private int DGE;
    private int DGF;
    private LinkedList<p> DGG;
    public HashMap<String, Long> DGH;
    private HashMap<String, String> DGI;
    public boolean DGJ;
    public Set<a> DGK;
    private Map<String, Long> DGL;
    Map<String, f> DGM;
    ConcurrentHashMap<String, AtomicInteger> DGN;
    ConcurrentHashMap<String, String> DGO;
    public ConcurrentHashMap<String, C1718c> DGP;
    public CopyOnWriteArrayList<String> DGQ;
    LinkedList<o> gCs;
    private MMHandler handler;
    Set<b> listeners;
    public final byte[] mLock;

    public interface a {
        void ke(String str, String str2);
    }

    public interface b {
        void aOG(String str);

        void ci(String str, boolean z);

        void cj(String str, boolean z);

        void eZJ();
    }

    static /* synthetic */ boolean a(c cVar) {
        AppMethodBeat.i(95450);
        boolean eZY = cVar.eZY();
        AppMethodBeat.o(95450);
        return eZY;
    }

    public final void aO(int i2, boolean z) {
        String value;
        String str;
        int i3;
        AppMethodBeat.i(95421);
        this.DGF = i2;
        try {
            if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                value = h.aqJ().getValue("SnsImgDownloadConcurrentCountForWifi");
            } else {
                value = h.aqJ().getValue("SnsImgDownloadConcurrentCountForNotWifi");
            }
            if (!Util.isNullOrNil(value) || !CrashReportFactory.hasDebuger()) {
                str = value;
            } else {
                str = "00:00-18:30-1-3;19:30-23:00-1-2;23:00-23:59-1-3;18:30-19:30-3-5;";
            }
            if (!Util.isNullOrNil(str)) {
                String[] split = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
                int safeParseInt = (Util.safeParseInt(split[1]) + (Util.safeParseInt(split[0]) * 60)) - ((((int) r.baU()) - 8) * 60);
                if (safeParseInt < 0) {
                    i3 = safeParseInt + 1440;
                } else if (safeParseInt >= 1440) {
                    i3 = safeParseInt - 1440;
                } else {
                    i3 = safeParseInt;
                }
                String[] split2 = str.split(";");
                for (int i4 = 0; i4 < split2.length; i4++) {
                    if (!Util.isNullOrNil(split2[i4])) {
                        String[] split3 = split2[i4].split("-");
                        if (split3 == null || split3.length < 4) {
                            Log.e("MicroMsg.DownloadManager", "setMaxThread Err i%d :%s", Integer.valueOf(i4), str);
                        } else {
                            String[] split4 = split3[0].split(":");
                            int safeParseInt2 = Util.safeParseInt(split4[1]) + (Util.safeParseInt(split4[0]) * 60);
                            String[] split5 = split3[1].split(":");
                            int safeParseInt3 = Util.safeParseInt(split5[1]) + (Util.safeParseInt(split5[0]) * 60);
                            Log.i("MicroMsg.DownloadManager", "setMaxThread i:%d [%d,%d] now:%d threadcnt:[%s,%s]", Integer.valueOf(i4), Integer.valueOf(safeParseInt2), Integer.valueOf(safeParseInt3), Integer.valueOf(i3), split3[2], split3[3]);
                            if (i3 <= safeParseInt3 && i3 > safeParseInt2) {
                                int safeParseInt4 = Util.safeParseInt(z ? split3[2] : split3[3]);
                                if (safeParseInt4 > 0) {
                                    this.DGF = safeParseInt4;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.DownloadManager", "setMaxThread :%s", Util.stackTraceToString(e2));
        }
        Log.i("MicroMsg.DownloadManager", "setMaxThread Res:%d ", Integer.valueOf(this.DGF));
        AppMethodBeat.o(95421);
    }

    public c() {
        AppMethodBeat.i(95422);
        this.handler = null;
        this.DGD = 0;
        this.DGE = 0;
        this.DGF = 2;
        this.DGG = new LinkedList<>();
        this.DGH = new HashMap<>();
        this.mLock = new byte[0];
        this.DGI = new HashMap<>();
        this.DGJ = true;
        this.listeners = new HashSet();
        this.DGK = new HashSet();
        this.gCs = new LinkedList<>();
        this.DGL = new ConcurrentHashMap();
        this.DGM = new HashMap();
        this.DGN = new ConcurrentHashMap<>();
        this.DGO = new ConcurrentHashMap<>();
        this.DGP = new ConcurrentHashMap<>();
        this.DGQ = new CopyOnWriteArrayList<>();
        this.handler = aj.dRd();
        eZX();
        AppMethodBeat.o(95422);
    }

    private void eZX() {
        AppMethodBeat.i(95423);
        synchronized (this.mLock) {
            try {
                this.gCs.clear();
                this.DGM.clear();
                this.DGL.clear();
                this.DGG.clear();
                this.DGH.clear();
                this.DGN.clear();
                this.DGO.clear();
            } finally {
                AppMethodBeat.o(95423);
            }
        }
    }

    private boolean eZY() {
        AppMethodBeat.i(95424);
        synchronized (this.mLock) {
            try {
                if (this.DGG == null || this.DGG.size() <= 0) {
                    AppMethodBeat.o(95424);
                    return false;
                }
                new ba().y(this.DGG.remove());
                return true;
            } finally {
                AppMethodBeat.o(95424);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements MessageQueue.IdleHandler {
        d() {
        }

        public final boolean queueIdle() {
            AppMethodBeat.i(95420);
            Log.d("MicroMsg.DownloadManager", "I run idleHandler ");
            c.this.DGD = Util.nowSecond();
            boolean a2 = c.a(c.this);
            AppMethodBeat.o(95420);
            return a2;
        }
    }

    public final void a(final b bVar) {
        AppMethodBeat.i(95425);
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(95413);
                c cVar = c.this;
                cVar.listeners.add(bVar);
                int i2 = c.DGB + 1;
                c.DGB = i2;
                if (i2 <= 1) {
                    g.aAi();
                    g.aAg().hqi.a(208, cVar);
                }
                AppMethodBeat.o(95413);
            }
        });
        AppMethodBeat.o(95425);
    }

    public final void b(final b bVar) {
        AppMethodBeat.i(95426);
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.c.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(95414);
                c cVar = c.this;
                cVar.listeners.remove(bVar);
                int i2 = c.DGB - 1;
                c.DGB = i2;
                if (i2 <= 0) {
                    g.aAi();
                    g.aAg().hqi.b(208, cVar);
                }
                AppMethodBeat.o(95414);
            }
        });
        AppMethodBeat.o(95426);
    }

    private boolean a(cnb cnb, int i2, n nVar, bp bpVar, String str, String str2, String str3) {
        int incrementAndGet;
        AppMethodBeat.i(95427);
        if (!r.aOt(aj.getAccPath())) {
            Log.i("MicroMsg.DownloadManager", "isHasSdcard is false accpath %s sdcard: %s", aj.getAccPath(), com.tencent.mm.loader.j.b.aKD());
            AppMethodBeat.o(95427);
            return false;
        } else if (cnb.Id.startsWith("Locall_path") || cnb.Id.startsWith("pre_temp_sns_pic")) {
            Log.d("MicroMsg.DownloadManager", "is a local img not need download");
            AppMethodBeat.o(95427);
            return false;
        } else {
            String cr = r.cr(i2, cnb.Id);
            synchronized (this.mLock) {
                try {
                    if (this.DGM.containsKey(cr)) {
                        Iterator<o> it = this.gCs.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            o next = it.next();
                            if (next.ebR != null && next.ebR.Id.equals(cnb.Id) && next.requestType == i2) {
                                if (this.gCs.remove(next)) {
                                    this.gCs.addLast(next);
                                }
                                Log.v("MicroMsg.DownloadManager", "update the download list.");
                            }
                        }
                    } else {
                        Log.i("MicroMsg.DownloadManager", "add list %s", cnb.Id);
                        this.DGM.put(cr, new f(nVar, i2));
                        this.gCs.add(new o(cnb, i2, cr, bpVar, str, str2));
                        if (!Util.isNullOrNil(str3)) {
                            String aOm = r.aOm(str3);
                            Log.i("MicroMsg.DownloadManager", "snsId: %s, mediaId: %s, batchKey: %s.", str3, cnb.Id, aOm);
                            if (this.DGN.containsKey(aOm)) {
                                AtomicInteger atomicInteger = this.DGN.get(aOm);
                                if (atomicInteger == null) {
                                    atomicInteger = new AtomicInteger(0);
                                }
                                incrementAndGet = atomicInteger.incrementAndGet();
                            } else {
                                AtomicInteger atomicInteger2 = new AtomicInteger(0);
                                incrementAndGet = atomicInteger2.incrementAndGet();
                                this.DGN.put(aOm, atomicInteger2);
                            }
                            Log.i("MicroMsg.DownloadManager", "res: %s.", Integer.valueOf(incrementAndGet));
                            this.DGO.put(cr, aOm);
                        }
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(95427);
                    throw th;
                }
            }
            Log.d("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s", Integer.valueOf(aj.faN().faq()), Integer.valueOf(this.DGL.size()));
            Log.v("MicroMsg.DownloadManager", "lockwaitdownload %s memeryFiles.size() %s", Integer.valueOf(this.DGM.size()), Integer.valueOf(this.DGG.size()));
            if (Looper.myLooper() != null) {
                Looper.myQueue().addIdleHandler(new d());
            } else {
                Log.w("MicroMsg.DownloadManager", "Looper.myLooper() == null");
            }
            eZZ();
            faa();
            if (this.gCs.size() > 0) {
                bck();
            }
            AppMethodBeat.o(95427);
            return true;
        }
    }

    private boolean aOL(String str) {
        AppMethodBeat.i(95428);
        if (!Util.isNullOrNil(str) && this.DGO.containsKey(str)) {
            String remove = this.DGO.remove(str);
            if (!Util.isNullOrNil(remove)) {
                if (this.DGN.containsKey(remove)) {
                    AtomicInteger atomicInteger = this.DGN.get(remove);
                    if (atomicInteger != null) {
                        int decrementAndGet = atomicInteger.decrementAndGet();
                        Log.i("MicroMsg.DownloadManager", "unLockDownLoad, key: %s, v: %s.", remove, Integer.valueOf(decrementAndGet));
                        if (decrementAndGet == 0) {
                            this.DGN.remove(remove);
                        }
                        AppMethodBeat.o(95428);
                        return true;
                    }
                    Log.e("MicroMsg.DownloadManager", "unLockDownLoad, key: %s, value is null.", remove);
                }
                AppMethodBeat.o(95428);
                return false;
            }
        }
        AppMethodBeat.o(95428);
        return false;
    }

    public final boolean a(cnb cnb, int i2, n nVar, bp bpVar) {
        AppMethodBeat.i(95429);
        boolean a2 = a(cnb, i2, nVar, bpVar, (String) null);
        AppMethodBeat.o(95429);
        return a2;
    }

    public final boolean a(cnb cnb, int i2, n nVar, bp bpVar, String str) {
        AppMethodBeat.i(95430);
        if (cnb == null) {
            Log.e("MicroMsg.DownloadManager", "unknow case media is null " + Util.getStack().toString());
            AppMethodBeat.o(95430);
            return false;
        }
        synchronized (this.mLock) {
            try {
                bd.aPt(cnb.Id);
                a(cnb, i2, nVar, bpVar, null, null, str);
            } catch (Throwable th) {
                AppMethodBeat.o(95430);
                throw th;
            }
        }
        AppMethodBeat.o(95430);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0136  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r11, android.util.SparseArray<com.tencent.mm.protocal.protobuf.cnb> r12, android.util.SparseArray<com.tencent.mm.plugin.sns.data.n> r13, com.tencent.mm.storage.bp r14, int r15) {
        /*
        // Method dump skipped, instructions count: 381
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.c.a(java.lang.String, android.util.SparseArray, android.util.SparseArray, com.tencent.mm.storage.bp, int):void");
    }

    public final boolean a(cnb cnb, int i2, n nVar, bp bpVar, String str, String str2) {
        AppMethodBeat.i(202718);
        if (cnb == null) {
            Log.e("MicroMsg.DownloadManager", "unknow case media is null " + Util.getStack().toString());
            AppMethodBeat.o(202718);
            return false;
        }
        synchronized (this.mLock) {
            try {
                bd.aPt(cnb.Id);
                a(cnb, i2, nVar, bpVar, str, str2, null);
            } catch (Throwable th) {
                AppMethodBeat.o(202718);
                throw th;
            }
        }
        AppMethodBeat.o(202718);
        return true;
    }

    public final void a(String str, String str2, String str3, h.a aVar) {
        AppMethodBeat.i(95433);
        com.tencent.mm.i.h hVar = new com.tencent.mm.i.h();
        hVar.taskName = "task_DownloadManager";
        hVar.field_mediaId = str;
        hVar.url = str2;
        hVar.gqU = 1;
        hVar.field_fileType = 100;
        hVar.gqP = 5;
        hVar.concurrentCount = 3;
        hVar.field_fullpath = str3;
        hVar.gre = aVar;
        com.tencent.mm.modelvideo.o.bhk().a(hVar, false);
        synchronized (this.DGI) {
            try {
                this.DGI.put(str, str3);
            } finally {
                AppMethodBeat.o(95433);
            }
        }
    }

    public final void aOM(String str) {
        AppMethodBeat.i(95434);
        com.tencent.mm.modelvideo.o.bhk().m(str, null);
        synchronized (this.DGI) {
            try {
                this.DGI.remove(str);
            } finally {
                AppMethodBeat.o(95434);
            }
        }
    }

    private void eZZ() {
        AppMethodBeat.i(95435);
        if (akM()) {
            this.handler.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.sns.model.c.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(95416);
                    c.a(c.this);
                    AppMethodBeat.o(95416);
                }
            }, 500);
        }
        AppMethodBeat.o(95435);
    }

    private void faa() {
        AppMethodBeat.i(95436);
        LinkedList<String> linkedList = new LinkedList();
        synchronized (this.mLock) {
            try {
                for (Map.Entry<String, Long> entry : this.DGL.entrySet()) {
                    linkedList.add(entry.getKey());
                }
                for (String str : linkedList) {
                    if (this.DGL.containsKey(str) && Util.secondsToNow(this.DGL.get(str).longValue()) * 1000 > 300000) {
                        Log.d("MicroMsg.DownloadManager", "too long to download");
                        this.DGL.remove(str);
                        this.DGM.remove(str);
                        aOL(str);
                    }
                }
            } finally {
                AppMethodBeat.o(95436);
            }
        }
    }

    private boolean akM() {
        AppMethodBeat.i(95437);
        if (Util.secondsToNow(this.DGD) * 1000 > 300000) {
            AppMethodBeat.o(95437);
            return true;
        }
        AppMethodBeat.o(95437);
        return false;
    }

    public final boolean aON(String str) {
        AppMethodBeat.i(95438);
        synchronized (this.mLock) {
            try {
                if (this.DGL.containsKey(r.cr(1, str))) {
                    return true;
                }
                if (this.DGL.containsKey(r.cr(5, str))) {
                    AppMethodBeat.o(95438);
                    return true;
                }
                AppMethodBeat.o(95438);
                return false;
            } finally {
                AppMethodBeat.o(95438);
            }
        }
    }

    public final boolean aOO(String str) {
        AppMethodBeat.i(95439);
        synchronized (this.mLock) {
            try {
                if (this.DGL.containsKey(r.cr(2, str)) || this.DGL.containsKey(r.cr(8, str))) {
                    return true;
                }
                AppMethodBeat.o(95439);
                return false;
            } finally {
                AppMethodBeat.o(95439);
            }
        }
    }

    public final boolean aOP(String str) {
        AppMethodBeat.i(95440);
        synchronized (this.DGI) {
            try {
                if (this.DGI.containsKey(str)) {
                    return true;
                }
                AppMethodBeat.o(95440);
                return false;
            } finally {
                AppMethodBeat.o(95440);
            }
        }
    }

    public final void s(String str, int i2, boolean z) {
        AppMethodBeat.i(95441);
        synchronized (this.mLock) {
            try {
                Log.d("MicroMsg.DownloadManager", "unLockDownLoad the thread id is %s %s %s.", Long.valueOf(Thread.currentThread().getId()), str, Boolean.valueOf(z));
                f fVar = this.DGM.get(str);
                if (fVar != null) {
                    if (9 == fVar.requestType) {
                        n nVar = fVar.DDI.get(i2);
                        if (nVar != null) {
                            aj.faL().a(nVar, str);
                        }
                    } else {
                        n nVar2 = fVar.DDH;
                        if (nVar2 != null) {
                            aj.faL().a(nVar2, str);
                        }
                    }
                }
                if (z) {
                    this.DGM.remove(str);
                    aOL(str);
                }
            } finally {
                AppMethodBeat.o(95441);
            }
        }
    }

    private static boolean aOQ(String str) {
        AppMethodBeat.i(95442);
        if (str == null || str.equals("")) {
            Log.d("MicroMsg.DownloadManager", "url  ".concat(String.valueOf(str)));
            AppMethodBeat.o(95442);
            return false;
        }
        AppMethodBeat.o(95442);
        return true;
    }

    public final void bck() {
        boolean z;
        String str;
        int i2;
        com.tencent.mm.plugin.sns.model.a.a aVar;
        AppMethodBeat.i(95443);
        if (!this.DGJ) {
            AppMethodBeat.o(95443);
        } else if (aj.isInValid()) {
            eZX();
            AppMethodBeat.o(95443);
        } else if (!r.aOt(aj.getAccPath())) {
            AppMethodBeat.o(95443);
        } else {
            int i3 = this.DGF;
            if (ac.jOg > 0) {
                i3 = ac.jOg;
            }
            synchronized (this.mLock) {
                try {
                    if (this.gCs.size() > 0 && aj.faN().faq() + this.DGL.size() <= i3) {
                        Log.i("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s listsize %s max_thread_downloading: %s", Integer.valueOf(aj.faN().faq()), Integer.valueOf(this.DGL.size()), Integer.valueOf(this.gCs.size()), Integer.valueOf(this.DGF));
                        o removeLast = this.gCs.removeLast();
                        if (removeLast != null) {
                            cnb cnb = removeLast.ebR;
                            int i4 = removeLast.requestType;
                            String str2 = removeLast.key;
                            String str3 = removeLast.DEt;
                            String str4 = removeLast.DEu;
                            String str5 = removeLast.dRS;
                            SparseArray<cnb> sparseArray = removeLast.DEw;
                            if (!this.DGM.containsKey(str2) || this.DGM.get(str2) == null) {
                                this.DGM.remove(str2);
                                aOL(str2);
                                AppMethodBeat.o(95443);
                                return;
                            }
                            n nVar = this.DGM.get(str2).DDH;
                            SparseArray<n> sparseArray2 = this.DGM.get(str2).DDI;
                            if (i4 == 1 && cnb.isAd) {
                                i4 = 8;
                            }
                            if (i4 == 1 || i4 == 5 || i4 == 7) {
                                z = true;
                                str = cnb.Msz;
                                if (i4 == 7 && !Util.isNullOrNil(cnb.MsI)) {
                                    str = cnb.MsI;
                                }
                                i2 = cnb.MsA;
                                if (Util.isNullOrNil(str) && cnb.oUv == 2) {
                                    str = cnb.Url;
                                    i2 = cnb.Mcw;
                                }
                            } else if (i4 == 6) {
                                z = false;
                                str = cnb.MsF;
                                i2 = cnb.Mcw;
                            } else if (i4 == 9) {
                                cnb valueAt = sparseArray.valueAt(0);
                                z = true;
                                String str6 = valueAt.Msz;
                                int i5 = valueAt.MsA;
                                if (!Util.isNullOrNil(str6) || valueAt.oUv != 2) {
                                    i2 = i5;
                                } else {
                                    String str7 = valueAt.Url;
                                    i2 = valueAt.Mcw;
                                    str6 = str7;
                                }
                                str = str6;
                            } else {
                                z = false;
                                str = cnb.Url;
                                i2 = cnb.Mcw;
                            }
                            if (!aOQ(str)) {
                                this.DGM.remove(str2);
                                aOL(str2);
                                AppMethodBeat.o(95443);
                                return;
                            } else if (i2 == 2) {
                                if (!aj.faN().isDownloading(str2)) {
                                    Log.d("MicroMsg.DownloadManager", "to downLoad scene " + cnb.Id + "  " + str);
                                    g.aAi();
                                    g.aAg().hqi.a(new q(cnb, cnb.Id, str, cnb.oUv, z, i4, str2), 0);
                                    aj.faN().aPh(str2);
                                }
                            } else if (i2 == 1 || i2 == 0) {
                                if (i2 == 0) {
                                    Log.e("MicroMsg.DownloadManager", "others http: urlType" + i2 + " -- url : " + str + " isThumb :" + z);
                                }
                                if (!this.DGL.containsKey(str2)) {
                                    if (i4 == 9) {
                                        Log.i("MicroMsg.DownloadManager", "batch download, snsId: %s.", str5);
                                    } else {
                                        Log.i("MicroMsg.DownloadManager", "to downLoad cdn " + cnb.Id + "  " + str);
                                    }
                                    if ((cnb != null || (sparseArray != null && sparseArray.size() > 0)) && i4 != 6 && i4 != 8 && this.DGH.containsKey(str2)) {
                                        long longValue = this.DGH.get(str2).longValue();
                                        if (System.currentTimeMillis() - longValue < 300000) {
                                            this.DGM.remove(str2);
                                            aOL(str2);
                                            Log.i("MicroMsg.DownloadManager", "no need download. lastTime: " + longValue + " url: " + str + " id: " + (cnb == null ? str5 : cnb.Id));
                                            AppMethodBeat.o(95443);
                                            return;
                                        }
                                    }
                                    this.DGL.put(str2, Long.valueOf(Util.nowSecond()));
                                    if (i4 == 2 || i4 == 8) {
                                        g.aAi();
                                        int nullAs = Util.nullAs((Integer) g.aAh().azQ().get(68391, (Object) null), 0);
                                        g.aAi();
                                        g.aAh().azQ().set(68391, Integer.valueOf(nullAs + 1));
                                    }
                                    if (i4 == 9) {
                                        aVar = new com.tencent.mm.plugin.sns.model.a.a(str5, sparseArray, sparseArray2, removeLast.size);
                                    } else {
                                        aVar = new com.tencent.mm.plugin.sns.model.a.a(cnb.Id);
                                        aVar.DIq = cnb;
                                        aVar.DDH = nVar;
                                    }
                                    aVar.DPp = removeLast.DEv;
                                    if (i4 == 4) {
                                        aVar.DPn = true;
                                    } else {
                                        aVar.DPn = false;
                                    }
                                    aVar.DPm = z;
                                    aVar.DPo = i4;
                                    aVar.DIp = str2;
                                    aVar.url = str;
                                    aVar.ko(str3, str4);
                                    com.tencent.mm.plugin.sns.model.a.c cVar = null;
                                    if (i4 == 1 || i4 == 5 || i4 == 7 || i4 == 9) {
                                        Log.d("MicroMsg.DownloadManager", "SnsDownloadThumb task create.");
                                        cVar = new com.tencent.mm.plugin.sns.model.a.i(this, aVar);
                                    } else if (i4 == 4) {
                                        Log.w("MicroMsg.DownloadManager", "it can not download sight, may be something warn here.");
                                        com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100438");
                                        boolean z2 = false;
                                        if (Fu.isValid()) {
                                            z2 = Util.getInt(Fu.gzz().get("CDNDownload"), 0) != 0;
                                        }
                                        Log.i("MicroMsg.DownloadManager", "is Ad %s, downloadByCDN %s", Boolean.valueOf(cnb.isAd), Boolean.valueOf(z2));
                                        if (!cnb.isAd || z2) {
                                            cVar = new com.tencent.mm.plugin.sns.model.a.g(this, aVar);
                                        } else {
                                            cVar = new com.tencent.mm.plugin.sns.model.a.h(this, aVar);
                                        }
                                    } else if (i4 == 2 || i4 == 8 || i4 == 3) {
                                        cVar = new e(this, aVar);
                                    } else if (i4 == 6) {
                                        aVar.url = cnb.MsF;
                                        aVar.md5 = cnb.MsH;
                                        cVar = new com.tencent.mm.plugin.sns.model.a.d(this, aVar);
                                    }
                                    cVar.fcb();
                                    cVar.y("");
                                }
                            } else {
                                this.DGM.remove(str2);
                                aOL(str2);
                            }
                        } else {
                            return;
                        }
                    }
                    AppMethodBeat.o(95443);
                } finally {
                    AppMethodBeat.o(95443);
                }
            }
        }
    }

    @Override // com.tencent.mm.plugin.sns.model.a.c.a
    public final void a(int i2, cnb cnb, int i3, boolean z, String str, int i4, int i5, boolean z2) {
        AppMethodBeat.i(95444);
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = cnb == null ? -1 : cnb.Id;
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = Boolean.valueOf(z);
        objArr[4] = str;
        objArr[5] = Integer.valueOf(i4);
        Log.i("MicroMsg.DownloadManager", "state:%d, mediaId:%s, reqDownloadType:%d, isThumb:%b,requestKey:%s, totalSize:%d", objArr);
        if (!aj.isInValid()) {
            g.aAi();
            if (g.aAf().azp()) {
                if (i2 != 2) {
                    this.DGE += i4;
                }
                synchronized (this.mLock) {
                    try {
                        if (this.DGE > 512000 && this.gCs.size() == 0) {
                            Log.d("MicroMsg.DownloadManager", "netSizeAdd %s", Integer.valueOf(this.DGE));
                            ay.a.iDr.dl(this.DGE, 0);
                            this.DGE = 0;
                        }
                        if (9 == i3) {
                            if ((i2 == 1 || i2 == 3) && z2) {
                                this.DGH.put(str, Long.valueOf(System.currentTimeMillis()));
                            }
                        } else if (i2 == 1 || i2 == 3) {
                            this.DGH.put(str, Long.valueOf(System.currentTimeMillis()));
                        }
                    } finally {
                        AppMethodBeat.o(95444);
                    }
                }
                if (!(i2 == 3 || i2 != 1 || i3 == 3 || cnb == null)) {
                    g faL = aj.faL();
                    Log.d("MicroMsg.LazyerImageLoader2", "updateCache " + cnb.Id);
                    com.tencent.mm.memory.n nVar = faL.DGX.get(r.cq(1, cnb.Id));
                    if (r.b(nVar)) {
                        nVar.aSc();
                        Log.d("MicroMsg.LazyerImageLoader2", "force update");
                        aj.faB().execute(new Runnable(cnb) {
                            /* class com.tencent.mm.plugin.sns.model.g.AnonymousClass2 */
                            final /* synthetic */ cnb DyS;

                            {
                                this.DyS = r2;
                            }

                            public final void run() {
                                AppMethodBeat.i(95456);
                                g.a(g.this, 1, this.DyS);
                                AppMethodBeat.o(95456);
                            }
                        });
                    }
                }
                synchronized (this.mLock) {
                    try {
                        Log.d("MicroMsg.DownloadManager", "onDownLoadFinish by cdn %s, taskDone %s.", str, Boolean.valueOf(z2));
                        if (z2) {
                            this.DGL.remove(str);
                        }
                    } finally {
                        AppMethodBeat.o(95444);
                    }
                }
                bck();
                s(str, i5, z2);
                synchronized (this.mLock) {
                    if (cnb != null) {
                        try {
                            C1718c aOS = aOS(cnb.Id);
                            if (aOS != null && aOS.isFinished && aOS.isFinished) {
                                long milliSecondsToNow = Util.milliSecondsToNow(aOS.startTime);
                                Log.d("MicroMsg.DownloadManager", "single download, feed id: %s, startTime: %d, cost: %d, this: %s.", aOS.dRS, Long.valueOf(aOS.startTime), Long.valueOf(milliSecondsToNow), aOS);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1040, 0, milliSecondsToNow);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(XWalkFeature.INTERFACE_SHOW_HIDE, 1);
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(95444);
                            throw th;
                        }
                    }
                }
                for (b bVar : this.listeners) {
                    if (bVar != null) {
                        if (i2 == 2 || cnb == null) {
                            if ((i3 == 2 || i3 == 8) && cnb != null) {
                                bVar.ci(cnb.Id, false);
                            } else if ((i3 == 4 || i3 == 6) && cnb != null) {
                                bVar.cj(cnb.Id, false);
                            }
                        } else if (i3 == 3) {
                            bVar.eZJ();
                        } else if (i3 == 1 || i3 == 9 || i3 == 5 || i3 == 7) {
                            bVar.aOG(cnb.Id);
                        } else if (i3 == 2 || i3 == 8) {
                            bVar.ci(cnb.Id, true);
                        } else if (i3 == 4 || i3 == 6) {
                            bVar.cj(cnb.Id, true);
                        }
                    }
                }
                return;
            }
        }
        eZX();
        AppMethodBeat.o(95444);
    }

    public final void aOR(final String str) {
        AppMethodBeat.i(95445);
        aj.dRd().post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.c.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(95417);
                c.a(c.this, str);
                c.this.s(str, -1, true);
                AppMethodBeat.o(95417);
            }
        });
        AppMethodBeat.o(95445);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(95446);
        Log.i("MicroMsg.DownloadManager", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str + " type = " + qVar.getType() + " @" + hashCode());
        if (qVar.getType() != 208) {
            AppMethodBeat.o(95446);
            return;
        }
        q qVar2 = (q) qVar;
        if (i2 == 0 && i3 == 0) {
            if (qVar.getType() == 208) {
                for (b bVar : this.listeners) {
                    if (bVar != null) {
                        if (qVar2.DIn == 3) {
                            bVar.eZJ();
                        } else if (qVar2.DIn == 1 || qVar2.DIn == 5 || qVar2.DIn == 7) {
                            bVar.aOG(qVar2.mediaId);
                        } else if (qVar2.DIn == 2 || qVar2.DIn == 8) {
                            bVar.ci(qVar2.mediaId, true);
                        }
                    }
                }
            }
            AppMethodBeat.o(95446);
            return;
        }
        if (qVar2.DIn == 2 || qVar2.DIn == 8) {
            for (b bVar2 : this.listeners) {
                if (bVar2 != null) {
                    bVar2.ci(qVar2.mediaId, false);
                }
            }
        }
        AppMethodBeat.o(95446);
    }

    public final void a(String str, C1718c cVar) {
        C1718c cVar2;
        AppMethodBeat.i(95447);
        if (!Util.isNullOrNil(str) && cVar != null && ((cVar2 = this.DGP.get(str)) == null || !cVar2.dRS.equals(cVar.dRS))) {
            this.DGP.put(str, cVar);
        }
        AppMethodBeat.o(95447);
    }

    public final C1718c aOS(String str) {
        AppMethodBeat.i(95448);
        if (!Util.isNullOrNil(str)) {
            C1718c remove = this.DGP.remove(str);
            if (remove != null) {
                remove.fab();
            }
            AppMethodBeat.o(95448);
            return remove;
        }
        AppMethodBeat.o(95448);
        return null;
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.c$c  reason: collision with other inner class name */
    public static class C1718c {
        public boolean DGU;
        final String dRS;
        private int iAC;
        boolean isFinished;
        private final byte[] lock = new byte[0];
        long startTime;

        public C1718c(String str, int i2) {
            AppMethodBeat.i(95418);
            this.dRS = str;
            this.iAC = i2;
            this.startTime = -1;
            this.DGU = false;
            this.isFinished = false;
            Log.d("MicroMsg.DownloadManager", "new reporter, snsId id: %s, picNum: %d, this: %s.", str, Integer.valueOf(i2), this);
            AppMethodBeat.o(95418);
        }

        public final void setStartTime(long j2) {
            AppMethodBeat.i(95419);
            if (!this.DGU) {
                synchronized (this.lock) {
                    try {
                        if (!this.DGU) {
                            this.DGU = true;
                            this.startTime = j2;
                            Log.d("MicroMsg.DownloadManager", "set start time, snsId id: %s, time: %d, this: %s.", this.dRS, Long.valueOf(this.startTime), this);
                        }
                    } finally {
                        AppMethodBeat.o(95419);
                    }
                }
                return;
            }
            AppMethodBeat.o(95419);
        }

        public final void fab() {
            synchronized (this.lock) {
                if (this.iAC > 0) {
                    this.iAC--;
                }
                if (this.iAC == 0) {
                    this.isFinished = true;
                }
            }
        }
    }

    public final void aOT(String str) {
        AppMethodBeat.i(95449);
        this.DGQ.add(str);
        AppMethodBeat.o(95449);
    }

    static /* synthetic */ void a(c cVar, String str) {
        AppMethodBeat.i(95451);
        Log.d("MicroMsg.DownloadManager", "onDownLoadFinish by scene %s", str);
        aj.faN().aPi(str);
        cVar.bck();
        AppMethodBeat.o(95451);
    }
}

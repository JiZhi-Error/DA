package com.tencent.mm.audio.mix.f;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.e;
import com.tencent.mm.audio.mix.b.f;
import com.tencent.mm.audio.mix.g.d;
import com.tencent.mm.audio.mix.i.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c {
    volatile LinkedList<String> dtR = new LinkedList<>();
    protected Object dup = new Object();
    protected AtomicBoolean dvq = new AtomicBoolean(false);
    protected AtomicBoolean dvr = new AtomicBoolean(false);
    public i dwc;
    d dwd;
    protected AtomicBoolean dwe = new AtomicBoolean(false);
    protected volatile HashMap<String, Boolean> dwf = new HashMap<>();
    private volatile LinkedList<String> dwg = new LinkedList<>();
    private volatile HashMap<String, Object> dwh = new HashMap<>();
    public volatile HashMap<String, List<e>> dwi = new HashMap<>();
    private volatile HashMap<String, Boolean> dwj = new HashMap<>();
    public volatile HashMap<String, WeakReference<com.tencent.mm.audio.mix.d.c>> dwk = new HashMap<>();
    private Object dwl = new Object();
    private List<e> dwm = new ArrayList();
    private volatile HashMap<String, Boolean> dwn = new HashMap<>();
    private volatile HashMap<String, Boolean> dwo = new HashMap<>();
    private volatile HashMap<String, Integer> dwp = new HashMap<>();
    private volatile HashMap<String, Long> dwq = new HashMap<>();
    public long dwr = 0;
    private boolean dws = false;
    private com.tencent.f.i.d dwt;
    int dwu = 0;
    long dwv = 0;
    private long dww = 0;
    private long dwx = 0;
    private Runnable dwy = new Runnable() {
        /* class com.tencent.mm.audio.mix.f.c.AnonymousClass1 */

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 139
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
            */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 220
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.audio.mix.f.c.AnonymousClass1.run():void");
        }
    };

    public c(d dVar) {
        AppMethodBeat.i(136837);
        this.dwd = dVar;
        AppMethodBeat.o(136837);
    }

    public final void Zr() {
        AppMethodBeat.i(136838);
        b.i("MicroMsg.Mix.AudioMixController", "prepareMix");
        this.dvr.set(false);
        this.dvq.set(false);
        ZA();
        Zu();
        AppMethodBeat.o(136838);
    }

    public final void Zs() {
        AppMethodBeat.i(136839);
        b.i("MicroMsg.Mix.AudioMixController", "pauseMix");
        this.dvq.set(true);
        if (this.dwu > 0) {
            this.dwr = this.dwv / ((long) this.dwu);
            b.i("MicroMsg.Mix.AudioMixController", "mixAverageTime:%d", Long.valueOf(this.dwr));
        }
        this.dww = 0;
        this.dwu = 0;
        this.dwv = 0;
        this.dwx = 0;
        AppMethodBeat.o(136839);
    }

    public final void Zt() {
        AppMethodBeat.i(136840);
        b.i("MicroMsg.Mix.AudioMixController", "stopMix");
        this.dvr.set(true);
        this.dvq.set(false);
        Zu();
        synchronized (this.dwl) {
            try {
                Zw();
            } catch (Throwable th) {
                AppMethodBeat.o(136840);
                throw th;
            }
        }
        Zz();
        ZB();
        AppMethodBeat.o(136840);
    }

    private void Zu() {
        AppMethodBeat.i(136841);
        synchronized (this.dup) {
            try {
                this.dup.notify();
            } catch (Exception e2) {
                b.printErrStackTrace("MicroMsg.Mix.AudioMixController", e2, "notifyMix", new Object[0]);
            }
            try {
            } catch (Throwable th) {
                AppMethodBeat.o(136841);
                throw th;
            }
        }
        AppMethodBeat.o(136841);
    }

    public final void Zv() {
        AppMethodBeat.i(136842);
        synchronized (this.dup) {
            while (!this.dvr.get() && this.dvq.get()) {
                try {
                    try {
                        b.i("MicroMsg.Mix.AudioMixController", "waitMix");
                        this.dup.wait();
                    } catch (Exception e2) {
                        b.printErrStackTrace("MicroMsg.Mix.AudioMixController", e2, "waitMix", new Object[0]);
                    }
                } finally {
                    AppMethodBeat.o(136842);
                }
            }
        }
    }

    private void Zw() {
        AppMethodBeat.i(136843);
        try {
            this.dwl.notifyAll();
            AppMethodBeat.o(136843);
        } catch (Exception e2) {
            b.printErrStackTrace("MicroMsg.Mix.AudioMixController", e2, "notifySyncPcmData", new Object[0]);
            AppMethodBeat.o(136843);
        }
    }

    public final void gS(String str) {
        AppMethodBeat.i(136846);
        this.dwf.put(str, Boolean.TRUE);
        gU(str);
        if (this.dwg.isEmpty()) {
            b.i("MicroMsg.Mix.AudioMixController", "stopMix isMute");
            this.dwe.set(true);
            this.dwd.Zj();
            AppMethodBeat.o(136846);
            return;
        }
        this.dwe.set(false);
        AppMethodBeat.o(136846);
    }

    public final boolean Zx() {
        AppMethodBeat.i(136847);
        boolean z = this.dwe.get();
        AppMethodBeat.o(136847);
        return z;
    }

    public final boolean gT(String str) {
        boolean z;
        AppMethodBeat.i(136848);
        synchronized (this.dwl) {
            try {
                if (this.dwj.containsKey(str)) {
                    z = this.dwj.get(str).booleanValue();
                } else {
                    z = false;
                    AppMethodBeat.o(136848);
                }
            } finally {
                AppMethodBeat.o(136848);
            }
        }
        return z;
    }

    public final void gU(String str) {
        AppMethodBeat.i(136849);
        synchronized (this.dwl) {
            try {
                if (this.dwg.contains(str)) {
                    this.dwg.remove(str);
                    Object obj = this.dwh.get(str);
                    List<e> remove = this.dwi.remove(str);
                    if (obj != null) {
                        synchronized (obj) {
                            try {
                                O(remove);
                                remove.clear();
                            } catch (Throwable th) {
                                AppMethodBeat.o(136849);
                                throw th;
                            }
                        }
                    } else {
                        O(remove);
                        remove.clear();
                    }
                    this.dwh.remove(str);
                    this.dwj.remove(str);
                    this.dwn.remove(str);
                    this.dwo.remove(str);
                    if (this.dvq.get()) {
                        Zw();
                    }
                    this.dwp.remove(str);
                    this.dwq.remove(str);
                } else {
                    b.e("MicroMsg.Mix.AudioMixController", "The audio of the id is remove");
                }
            } finally {
                AppMethodBeat.o(136849);
            }
        }
    }

    public final boolean c(String str, int i2, boolean z) {
        AppMethodBeat.i(198125);
        if (!this.dwg.contains(str)) {
            AppMethodBeat.o(198125);
            return false;
        } else if (i2 < 0) {
            this.dwp.remove(str);
            AppMethodBeat.o(198125);
            return false;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (i2 == 0) {
                this.dwp.remove(str);
            } else {
                this.dwp.put(str, Integer.valueOf(i2));
            }
            List<e> list = this.dwi.get(str);
            if (list == null || list.size() == 0) {
                this.dwp.remove(str);
                AppMethodBeat.o(198125);
                return false;
            }
            com.tencent.mm.ai.b ha = this.dwd.ha(str);
            if (ha == null) {
                this.dwp.remove(str);
                AppMethodBeat.o(198125);
                return false;
            }
            b.i("MicroMsg.Mix.AudioMixController", "seekTo begin");
            boolean gT = gT(str);
            if (!gT) {
                gR(str);
            }
            int size = list.size();
            com.tencent.mm.audio.mix.a.d gE = f.YL().gE(ha.filePath);
            int size2 = gE.size();
            int i3 = i2 / 20;
            int gV = (int) (gV(str) / 20);
            Object obj = this.dwh.get(str);
            if (obj == null) {
                this.dwp.remove(str);
                AppMethodBeat.o(198125);
                return false;
            }
            if (i3 > gV && i3 <= size2) {
                b.e("MicroMsg.Mix.AudioMixController", "seekTo seekToPos > currentPos");
                int i4 = i3 - gV;
                synchronized (obj) {
                    int i5 = 0;
                    while (i5 < i4 && i5 < size) {
                        try {
                            e remove = list.remove(list.size() - 1);
                            if (remove != null && remove.dub) {
                                com.tencent.mm.audio.mix.b.d.YH().b(remove);
                            }
                            i5++;
                        } catch (Throwable th) {
                            AppMethodBeat.o(198125);
                            throw th;
                        }
                    }
                }
            } else if (i3 < gV && gV <= size2 && !z) {
                b.e("MicroMsg.Mix.AudioMixController", "seekTo seekToPos < currentPos, can't write queue");
                synchronized (obj) {
                    try {
                        O(list);
                        list.clear();
                    } catch (Throwable th2) {
                        AppMethodBeat.o(198125);
                        throw th2;
                    }
                }
            } else if (i3 < gV && gV <= size2) {
                b.e("MicroMsg.Mix.AudioMixController", "seekTo seekToPos < currentPos, can write queue");
                synchronized (obj) {
                    while (gV > i3) {
                        try {
                            e jb = gE.jb(gV);
                            if (jb != null) {
                                list.add(list.size(), jb);
                            }
                            gV--;
                        } catch (Throwable th3) {
                            AppMethodBeat.o(198125);
                            throw th3;
                        }
                    }
                }
            }
            if (!gT) {
                b.i("MicroMsg.Mix.AudioMixController", "is not Pause");
                synchronized (this.dwl) {
                    try {
                        if (this.dwj.containsKey(str)) {
                            this.dwj.put(str, Boolean.FALSE);
                        } else {
                            b.e("MicroMsg.Mix.AudioMixController", "The audio of the id is remove");
                        }
                    } finally {
                        AppMethodBeat.o(198125);
                    }
                }
                synchronized (this.dwl) {
                    try {
                        Zw();
                    } catch (Throwable th4) {
                        throw th4;
                    }
                }
            }
            b.i("MicroMsg.Mix.AudioMixController", "seekTo end, time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(198125);
            return true;
        }
    }

    public final long gV(String str) {
        AppMethodBeat.i(136851);
        synchronized (this.dwl) {
            try {
                if (this.dwq.containsKey(str)) {
                    Long l = this.dwq.get(str);
                    if (l == null) {
                        return -1;
                    }
                    long longValue = l.longValue();
                    AppMethodBeat.o(136851);
                    return longValue;
                }
                AppMethodBeat.o(136851);
                return -1;
            } finally {
                AppMethodBeat.o(136851);
            }
        }
    }

    public final boolean gW(String str) {
        AppMethodBeat.i(136852);
        if (!this.dwg.contains(str)) {
            AppMethodBeat.o(136852);
            return true;
        }
        List<e> list = this.dwi.get(str);
        if (list == null || list.size() == 0) {
            b.i("MicroMsg.Mix.AudioMixController", "queue size is 0");
            AppMethodBeat.o(136852);
            return true;
        }
        AppMethodBeat.o(136852);
        return false;
    }

    public final void m(String str, boolean z) {
        AppMethodBeat.i(136853);
        synchronized (this.dwl) {
            try {
                this.dwn.put(str, Boolean.valueOf(z));
            } finally {
                AppMethodBeat.o(136853);
            }
        }
    }

    private boolean gX(String str) {
        AppMethodBeat.i(136854);
        synchronized (this.dwl) {
            try {
                if (this.dwn.containsKey(str) && this.dwn.get(str).booleanValue()) {
                    return true;
                }
                AppMethodBeat.o(136854);
                return false;
            } finally {
                AppMethodBeat.o(136854);
            }
        }
    }

    private void gY(String str) {
        AppMethodBeat.i(136855);
        this.dwd.q(5, str);
        gU(str);
        AppMethodBeat.o(136855);
    }

    public final boolean YY() {
        AppMethodBeat.i(259518);
        boolean z = this.dvq.get();
        AppMethodBeat.o(259518);
        return z;
    }

    public final boolean YZ() {
        AppMethodBeat.i(259519);
        boolean z = this.dvr.get();
        AppMethodBeat.o(259519);
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d0, code lost:
        r2 = r7.dwl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d2, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r7.dwl.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00e8, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00e9, code lost:
        com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioMixController", r1, "writePcmDataTrack", new java.lang.Object[0]);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.lang.String r8, com.tencent.mm.audio.mix.a.e r9, com.tencent.mm.audio.mix.d.c r10) {
        /*
        // Method dump skipped, instructions count: 254
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.audio.mix.f.c.a(java.lang.String, com.tencent.mm.audio.mix.a.e, com.tencent.mm.audio.mix.d.c):int");
    }

    /* access modifiers changed from: protected */
    public final List<e> Zy() {
        WeakReference<com.tencent.mm.audio.mix.d.c> weakReference;
        com.tencent.mm.audio.mix.d.c cVar;
        AppMethodBeat.i(136858);
        ArrayList arrayList = new ArrayList();
        synchronized (this.dwl) {
            try {
                arrayList.addAll(this.dwg);
            } finally {
                AppMethodBeat.o(136858);
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String str = (String) arrayList.get(i2);
            synchronized (this.dwl) {
                try {
                    if (!this.dwj.containsKey(str) || !this.dwj.get(str).booleanValue()) {
                        List<e> list = this.dwi.get(str);
                        if (list != null && list.size() != 0) {
                            if (!(!this.dwk.containsKey(str) || (weakReference = this.dwk.get(str)) == null || weakReference.get() == null || (cVar = weakReference.get()) == null)) {
                                cVar.jd(list.size());
                            }
                            Object obj = this.dwh.get(str);
                            if (obj != null) {
                                synchronized (obj) {
                                    try {
                                        int size = list.size();
                                        if (size > 0) {
                                            e remove = list.remove(size - 1);
                                            if (!this.dwp.containsKey(str) || ((long) this.dwp.get(str).intValue()) <= remove.dua) {
                                                this.dwq.put(str, Long.valueOf(remove.dua));
                                                com.tencent.mm.ai.b ha = this.dwd.ha(str);
                                                if (ha != null && ha.iJG == 0.0d && !remove.dub) {
                                                    e YI = com.tencent.mm.audio.mix.b.d.YH().YI();
                                                    if (YI != null) {
                                                        if (YI.dtQ == null) {
                                                            YI.dtQ = new byte[3536];
                                                        }
                                                        YI.reset();
                                                        this.dwm.add(YI);
                                                    } else {
                                                        this.dwm.add(remove);
                                                    }
                                                } else if (ha == null || ha.iJG != 0.0d || !remove.dub) {
                                                    this.dwm.add(remove);
                                                } else {
                                                    remove.reset();
                                                    this.dwm.add(remove);
                                                }
                                                this.dtR.add(str);
                                            }
                                        }
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            }
                        } else if (gX(str)) {
                            m(str, false);
                            gY(str);
                        }
                    }
                } finally {
                    AppMethodBeat.o(136858);
                }
            }
        }
        synchronized (this.dwl) {
            try {
                if (this.dwm.size() == 0 && !this.dvr.get()) {
                    try {
                        b.i("MicroMsg.Mix.AudioMixController", "wait read data");
                        this.dwl.wait();
                    } catch (Exception e2) {
                        b.printErrStackTrace("MicroMsg.Mix.AudioMixController", e2, "readMixDataFromPcmTrack", new Object[0]);
                    }
                }
            } catch (Throwable th2) {
                AppMethodBeat.o(136858);
                throw th2;
            }
        }
        List<e> list2 = this.dwm;
        AppMethodBeat.o(136858);
        return list2;
    }

    public final void clearCache() {
        AppMethodBeat.i(136859);
        b.i("MicroMsg.Mix.AudioMixController", "clearCache");
        synchronized (this.dwl) {
            try {
                Zz();
                this.dwh.clear();
            } finally {
                AppMethodBeat.o(136859);
            }
        }
    }

    private void Zz() {
        AppMethodBeat.i(136860);
        for (int i2 = 0; i2 < this.dwg.size(); i2++) {
            this.dwi.get(this.dwg.get(i2)).clear();
        }
        AppMethodBeat.o(136860);
    }

    public final void ZA() {
        AppMethodBeat.i(136861);
        if (this.dwt == null) {
            this.dwt = h.RTc.ba(this.dwy);
        }
        AppMethodBeat.o(136861);
    }

    public final void ZB() {
        if (this.dwt != null) {
            this.dwt = null;
        }
    }

    public final String gZ(String str) {
        com.tencent.mm.audio.mix.d.c cVar;
        AppMethodBeat.i(136862);
        WeakReference<com.tencent.mm.audio.mix.d.c> weakReference = this.dwk.get(str);
        if (weakReference == null || weakReference.get() == null || (cVar = weakReference.get()) == null) {
            AppMethodBeat.o(136862);
            return "";
        }
        String str2 = cVar.dvn;
        AppMethodBeat.o(136862);
        return str2;
    }

    static void O(List<e> list) {
        AppMethodBeat.i(136863);
        for (e eVar : list) {
            if (eVar != null && eVar.dub) {
                com.tencent.mm.audio.mix.b.d.YH().b(eVar);
            }
        }
        AppMethodBeat.o(136863);
    }

    public final void gQ(String str) {
        AppMethodBeat.i(136844);
        if (this.dwr > 0) {
            this.dwr = 0;
        }
        synchronized (this.dwl) {
            try {
                this.dwe.set(false);
                this.dwf.put(str, Boolean.FALSE);
                if (!this.dwg.contains(str)) {
                    this.dwg.add(str);
                    this.dwi.put(str, new ArrayList());
                    this.dwh.put(str, new Object());
                    this.dwn.put(str, Boolean.FALSE);
                } else {
                    b.e("MicroMsg.Mix.AudioMixController", "The audio of the Id is mixing");
                }
                this.dwj.put(str, Boolean.FALSE);
                this.dwo.put(str, Boolean.FALSE);
                if (this.dvq.get()) {
                    this.dvq.set(false);
                } else {
                    this.dwm.size();
                }
                Zu();
                Zw();
            } finally {
                AppMethodBeat.o(136844);
            }
        }
    }

    public final void gR(String str) {
        AppMethodBeat.i(136845);
        synchronized (this.dwl) {
            try {
                if (this.dwj.containsKey(str)) {
                    this.dwj.put(str, Boolean.TRUE);
                } else {
                    b.e("MicroMsg.Mix.AudioMixController", "The audio of the id is remove");
                }
            } finally {
                AppMethodBeat.o(136845);
            }
        }
    }
}

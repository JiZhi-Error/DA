package com.tencent.mm.audio.mix.g;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.audio.mix.a.c;
import com.tencent.mm.audio.mix.b.f;
import com.tencent.mm.audio.mix.d.a;
import com.tencent.mm.audio.mix.d.n;
import com.tencent.mm.g.a.y;
import com.tencent.mm.plugin.appbrand.jsapi.z.r;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d {
    AudioTrack bfn;
    private int channels = 2;
    volatile HashMap<String, b> dvc = new HashMap<>();
    volatile HashMap<String, Boolean> dwo = new HashMap<>();
    private volatile HashMap<String, Integer> dxA = new HashMap<>();
    private volatile HashMap<String, Integer> dxB = new HashMap<>();
    private volatile HashMap<String, Integer> dxC = new HashMap<>();
    private byte[] dxD = new byte[3536];
    byte[] dxE = new byte[2];
    private short dxF = 0;
    volatile boolean dxG = false;
    int dxH = 0;
    private Runnable dxI = new Runnable() {
        /* class com.tencent.mm.audio.mix.g.d.AnonymousClass1 */

        public final void run() {
            int i2;
            c YG;
            boolean z;
            AppMethodBeat.i(136917);
            Process.setThreadPriority(-19);
            if (d.this.dxj.get()) {
                com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "stop and exit");
                AppMethodBeat.o(136917);
                return;
            }
            if (d.this.bfn == null) {
                d.a(d.this);
            }
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "playback start");
            while (true) {
                if (d.this.dxj.get()) {
                    break;
                }
                d dVar = d.this;
                synchronized (dVar.dxl) {
                    while (dVar.dxi.get() && !dVar.dxj.get()) {
                        try {
                            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "waitPlay");
                            try {
                                dVar.dxl.wait();
                            } catch (Exception e2) {
                                com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e2, "waitPlay", new Object[0]);
                            }
                        } finally {
                            AppMethodBeat.o(136917);
                        }
                    }
                }
                if (d.this.dxj.get()) {
                    com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "playback break");
                    break;
                }
                com.tencent.mm.audio.mix.a.b ZO = d.this.ZO();
                if (ZO != null) {
                    byte[] bArr = ZO.dtQ;
                    if (d.this.bfn == null) {
                        d.a(d.this);
                    }
                    if (bArr != null && bArr.length > 0) {
                        if (d.this.bfn != null && (d.this.bfn.getPlayState() == 1 || d.this.bfn.getPlayState() == 2)) {
                            d.this.bfn.play();
                        }
                        d.this.dxH++;
                        d dVar2 = d.this;
                        Iterator<String> it = ZO.dtR.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            synchronized (dVar2.dxm) {
                                try {
                                    if (!TextUtils.isEmpty(next) && (!dVar2.dwo.containsKey(next) || !dVar2.dwo.get(next).booleanValue())) {
                                        if (dVar2.dwo.containsKey(next)) {
                                            dVar2.dwo.put(next, Boolean.TRUE);
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (z) {
                                            dVar2.mHandler.post(new Runnable(next) {
                                                /* class com.tencent.mm.audio.mix.g.d.AnonymousClass2 */
                                                final /* synthetic */ String dxL;

                                                {
                                                    this.dxL = r2;
                                                }

                                                public final void run() {
                                                    AppMethodBeat.i(136918);
                                                    d.this.q(11, this.dxL);
                                                    AppMethodBeat.o(136918);
                                                }
                                            });
                                        }
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        if (d.this.bfn != null) {
                            if (d.this.dxo.Zx()) {
                                com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "isMute");
                                d.this.bfn.setStereoVolume(0.0f, 0.0f);
                            } else {
                                d.this.bfn.setStereoVolume(1.0f, 1.0f);
                            }
                            i2 = d.this.bfn.write(bArr, 0, bArr.length);
                        } else {
                            i2 = 0;
                        }
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 100) {
                            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "write audio track after writeSize:%d, time:%d, writeCount:%d", Integer.valueOf(i2), Long.valueOf(currentTimeMillis2), Integer.valueOf(d.this.dxH));
                        }
                        if (i2 < 0) {
                            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "write audio track buffer failed, Size:%d", Integer.valueOf(i2));
                        }
                        if (d.this.dxk.size() == 0) {
                            d.this.dxE[0] = bArr[bArr.length - 2];
                            d.this.dxE[1] = bArr[bArr.length - 1];
                        }
                        d dVar3 = d.this;
                        if (!(dVar3.dxp == null || !dVar3.dxG || (YG = com.tencent.mm.audio.mix.b.c.YF().YG()) == null)) {
                            if (YG.dtQ == null || YG.dtQ.length < ZO.dtQ.length) {
                                YG.dtQ = new byte[ZO.dtQ.length];
                            }
                            System.arraycopy(ZO.dtQ, 0, YG.dtQ, 0, ZO.dtQ.length);
                            dVar3.mHandler.post(new Runnable(YG) {
                                /* class com.tencent.mm.audio.mix.g.d.AnonymousClass4 */
                                final /* synthetic */ c dxM;

                                {
                                    this.dxM = r2;
                                }

                                public final void run() {
                                }
                            });
                        }
                    }
                    com.tencent.mm.audio.mix.b.b.YD().a(ZO);
                }
            }
            d.this.releaseAudioTrack();
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "release AudioTrack and exit playback thread id:%d", Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(136917);
        }
    };
    ArrayList<String> dxJ = new ArrayList<>();
    public a dxb;
    private int dxg = 4;
    public AtomicBoolean dxh = new AtomicBoolean(false);
    AtomicBoolean dxi = new AtomicBoolean(false);
    public AtomicBoolean dxj = new AtomicBoolean(true);
    public Queue<com.tencent.mm.audio.mix.a.b> dxk = new ArrayDeque();
    public Object dxl = new Object();
    Object dxm = new Object();
    private Thread dxn;
    public com.tencent.mm.audio.mix.f.c dxo = new com.tencent.mm.audio.mix.f.c(this);
    b dxp;
    private n dxq;
    public g dxr;
    volatile HashMap<String, Boolean> dxs = new HashMap<>();
    volatile HashMap<String, Boolean> dxt = new HashMap<>();
    volatile HashMap<String, e<Integer>> dxu = new HashMap<>();
    volatile HashMap<String, com.tencent.mm.ai.d> dxv = new HashMap<>();
    private ArrayList<String> dxw = new ArrayList<>();
    private volatile HashMap<String, Long> dxx = new HashMap<>();
    private volatile HashMap<String, Integer> dxy = new HashMap<>();
    private volatile HashMap<String, Integer> dxz = new HashMap<>();
    Handler mHandler;
    private int sampleRate = 44100;

    public d() {
        AppMethodBeat.i(136920);
        com.tencent.mm.audio.mix.f.c cVar = this.dxo;
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixController", "onInit");
        cVar.ZA();
        cVar.dwi.clear();
        cVar.dwc = new com.tencent.mm.audio.mix.f.d();
        cVar.dwc.init();
        if (this.dxq == null) {
            this.dxq = new n() {
                /* class com.tencent.mm.audio.mix.g.d.AnonymousClass3 */

                @Override // com.tencent.mm.audio.mix.d.n
                public final void a(y yVar) {
                    boolean z;
                    AppMethodBeat.i(136919);
                    int i2 = yVar.dCW.action;
                    if (i2 == 12 || i2 == 11 || i2 == 10 || i2 == 6) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        if (d.this.dxu.containsKey(yVar.dCW.dtX)) {
                            e<Integer> eVar = d.this.dxu.get(yVar.dCW.dtX);
                            if (eVar != null) {
                                if (eVar.f(Integer.valueOf(i2))) {
                                    com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "don't callback again");
                                    AppMethodBeat.o(136919);
                                    return;
                                }
                            }
                            if (eVar != null) {
                                eVar.aU(Integer.valueOf(i2));
                                d.this.dxu.put(yVar.dCW.dtX, eVar);
                            }
                        } else {
                            synchronized (d.this.dxm) {
                                try {
                                    d.this.dxu.put(yVar.dCW.dtX, new e<>(Integer.valueOf(i2)));
                                } catch (Throwable th) {
                                    AppMethodBeat.o(136919);
                                    throw th;
                                }
                            }
                        }
                    }
                    if (d.this.dxp == null) {
                        AppMethodBeat.o(136919);
                        return;
                    }
                    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "onEventChange audioId:%s, state:%s", yVar.dCW.dtX, yVar.dCW.state);
                    if (i2 == 9) {
                        d.this.dxp.b(yVar);
                        AppMethodBeat.o(136919);
                    } else if (i2 == 7) {
                        d.this.dxp.c(yVar);
                        AppMethodBeat.o(136919);
                    } else if (i2 == 0) {
                        d.this.dxp.d(yVar);
                        AppMethodBeat.o(136919);
                    } else if (i2 == 1) {
                        d.this.dxp.d(yVar);
                        AppMethodBeat.o(136919);
                    } else if (i2 == 2) {
                        d.this.dxp.e(yVar);
                        AppMethodBeat.o(136919);
                    } else if (i2 == 3) {
                        d.this.dxt.put(yVar.dCW.dtX, Boolean.FALSE);
                        d.this.dxp.f(yVar);
                        AppMethodBeat.o(136919);
                    } else if (i2 == 5) {
                        d.this.dxt.put(yVar.dCW.dtX, Boolean.FALSE);
                        d.this.dxp.g(yVar);
                        AppMethodBeat.o(136919);
                    } else if (i2 == 4) {
                        d.this.dxt.put(yVar.dCW.dtX, Boolean.FALSE);
                        d.this.dxp.j(yVar);
                        AppMethodBeat.o(136919);
                    } else if (i2 == 10) {
                        d.this.dxp.h(yVar);
                        AppMethodBeat.o(136919);
                    } else if (i2 == 6) {
                        d.this.dxp.i(yVar);
                        AppMethodBeat.o(136919);
                    } else if (i2 == 11) {
                        d.this.dxp.k(yVar);
                        AppMethodBeat.o(136919);
                    } else {
                        if (i2 != 12 && i2 == 13) {
                            d.this.dxp.l(yVar);
                        }
                        AppMethodBeat.o(136919);
                    }
                }
            };
        }
        this.mHandler = new Handler(Looper.myLooper());
        AppMethodBeat.o(136920);
    }

    public final void clearCache() {
        AppMethodBeat.i(136921);
        this.dxo.clearCache();
        this.dvc.clear();
        this.dxs.clear();
        this.dxt.clear();
        synchronized (this.dxm) {
            try {
                this.dxu.clear();
            } catch (Throwable th) {
                AppMethodBeat.o(136921);
                throw th;
            }
        }
        this.dxv.clear();
        this.dwo.clear();
        AppMethodBeat.o(136921);
    }

    public final void ZL() {
        AppMethodBeat.i(136922);
        this.dxh.set(false);
        this.dxj.set(true);
        this.dxi.set(false);
        ZQ();
        ZN();
        AppMethodBeat.o(136922);
    }

    public final b ha(String str) {
        AppMethodBeat.i(136923);
        if (this.dvc.containsKey(str)) {
            b bVar = this.dvc.get(str);
            AppMethodBeat.o(136923);
            return bVar;
        }
        AppMethodBeat.o(136923);
        return null;
    }

    public final void he(String str) {
        AppMethodBeat.i(136924);
        this.dxo.gS(str);
        synchronized (this.dxm) {
            try {
                this.dwo.remove(str);
            } finally {
                AppMethodBeat.o(136924);
            }
        }
        this.dxs.remove(str);
        this.dxt.put(str, Boolean.FALSE);
        if (this.dxb.gN(str)) {
            q(3, str);
        }
    }

    public final boolean gO(String str) {
        AppMethodBeat.i(136925);
        if (this.dxu.containsKey(str)) {
            e<Integer> eVar = this.dxu.get(str);
            if (eVar != null) {
                if (eVar.f(0) && !this.dxo.YY()) {
                    AppMethodBeat.o(136925);
                    return true;
                }
            }
            if (!this.dxo.YY() && !this.dxo.gT(str) && this.dxb.gO(str)) {
                AppMethodBeat.o(136925);
                return true;
            }
        }
        AppMethodBeat.o(136925);
        return false;
    }

    public final int hp(String str) {
        int gP;
        int hj;
        AppMethodBeat.i(136926);
        if (this.dvc.containsKey(str)) {
            b bVar = this.dvc.get(str);
            if (bVar == null) {
                AppMethodBeat.o(136926);
                return 0;
            }
            if (bVar.dtU) {
                gP = (int) this.dxo.gV(str);
            } else {
                gP = (int) this.dxb.gP(str);
            }
            if (gP != -1) {
                bVar.dCS = gP;
            } else {
                gP = bVar.dCS;
            }
            if (gP == -1) {
                hj = 0;
            } else {
                hj = hj(str);
                if (hj <= 0 || gP <= hj) {
                    hj = gP;
                }
            }
            AppMethodBeat.o(136926);
            return hj;
        }
        AppMethodBeat.o(136926);
        return 0;
    }

    public final int hj(String str) {
        AppMethodBeat.i(136927);
        if (this.dvc.containsKey(str)) {
            b bVar = this.dvc.get(str);
            if (bVar == null) {
                AppMethodBeat.o(136927);
                return 0;
            }
            String str2 = bVar.filePath;
            if (TextUtils.isEmpty(str2)) {
                AppMethodBeat.o(136927);
                return 0;
            }
            com.tencent.mm.audio.mix.a.d gE = f.YL().gE(str2);
            if (gE != null) {
                int i2 = (int) gE.duration;
                AppMethodBeat.o(136927);
                return i2;
            }
        }
        AppMethodBeat.o(136927);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final void ZM() {
        AppMethodBeat.i(136928);
        synchronized (this) {
            try {
                if (this.dxn == null) {
                    this.dxn = new Thread(this.dxI, "audio_mix_player");
                    this.dxn.start();
                    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "start playback thread id:%d", Long.valueOf(this.dxn.getId()));
                }
            } finally {
                AppMethodBeat.o(136928);
            }
        }
    }

    private void ZN() {
        AppMethodBeat.i(136929);
        synchronized (this) {
            try {
                if (this.dxn != null) {
                    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "stop playback thread id:%d", Long.valueOf(this.dxn.getId()));
                    this.dxn = null;
                }
            } finally {
                AppMethodBeat.o(136929);
            }
        }
    }

    public final void Zj() {
        AppMethodBeat.i(136930);
        try {
            if (this.bfn != null) {
                this.bfn.setStereoVolume(0.0f, 0.0f);
            }
            AppMethodBeat.o(136930);
        } catch (Exception e2) {
            com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e2, r.NAME, new Object[0]);
            AppMethodBeat.o(136930);
        }
    }

    public final com.tencent.mm.audio.mix.a.b ZO() {
        com.tencent.mm.audio.mix.a.b poll;
        AppMethodBeat.i(136931);
        synchronized (this.dxl) {
            while (true) {
                try {
                    if ((this.dxk.size() == 0 || this.dxi.get()) && !this.dxj.get()) {
                        try {
                            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "wait play");
                            Zj();
                            if (this.bfn != null && this.bfn.getPlayState() == 3) {
                                this.bfn.stop();
                            }
                            this.dxl.wait();
                            this.dxH = 0;
                        } catch (InterruptedException e2) {
                            com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e2, "waitPlay", new Object[0]);
                        }
                    }
                } finally {
                    AppMethodBeat.o(136931);
                }
            }
            poll = this.dxk.poll();
            this.dxl.notifyAll();
        }
        return poll;
    }

    public final void ZP() {
        AppMethodBeat.i(136932);
        this.dxk.clear();
        AppMethodBeat.o(136932);
    }

    public final void ZQ() {
        AppMethodBeat.i(136933);
        synchronized (this.dxl) {
            try {
                com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "sync notify");
                try {
                    this.dxl.notifyAll();
                } catch (Exception e2) {
                    com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e2, "syncNotify", new Object[0]);
                }
            } finally {
                AppMethodBeat.o(136933);
            }
        }
    }

    private synchronized boolean createAudioTrack() {
        boolean z;
        AppMethodBeat.i(136934);
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "createAudioTrack");
        int i2 = this.channels == 1 ? 4 : 12;
        int minBufferSize = AudioTrack.getMinBufferSize(this.sampleRate, i2, 2);
        this.dxg = minBufferSize / 3536;
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "miniBufferSize:%d, channels:%d, sampleRate:%d", Integer.valueOf(minBufferSize), Integer.valueOf(this.channels), Integer.valueOf(this.sampleRate));
        if (this.bfn == null) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "audioTrack is null, new AudioTrack");
            try {
                this.bfn = new AudioTrack(3, this.sampleRate, i2, 2, minBufferSize, 1);
            } catch (IllegalArgumentException e2) {
                com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e2, "AudioTrack create", new Object[0]);
            }
        }
        if (this.bfn == null || this.bfn.getState() != 1) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "audio track not initialized");
            if (this.bfn != null) {
                com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "AudioTrack getState", Integer.valueOf(this.bfn.getState()));
                try {
                    this.bfn.release();
                    this.bfn = null;
                } catch (Exception e3) {
                    com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e3, "AudioTrack release", new Object[0]);
                }
            }
            AppMethodBeat.o(136934);
            z = false;
        } else {
            AppMethodBeat.o(136934);
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void releaseAudioTrack() {
        AppMethodBeat.i(136935);
        try {
            if (this.bfn != null) {
                this.bfn.flush();
                this.bfn.stop();
                this.bfn.release();
                this.bfn = null;
            }
            AppMethodBeat.o(136935);
        } catch (Exception e2) {
            com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", e2, "releaseAudioTrack", new Object[0]);
            AppMethodBeat.o(136935);
        }
    }

    public final int hq(String str) {
        AppMethodBeat.i(136936);
        if (!this.dxu.containsKey(str)) {
            AppMethodBeat.o(136936);
            return -1;
        }
        e<Integer> eVar = this.dxu.get(str);
        if (eVar != null) {
            int intValue = eVar.get().intValue();
            AppMethodBeat.o(136936);
            return intValue;
        }
        AppMethodBeat.o(136936);
        return -1;
    }

    public final void q(int i2, String str) {
        AppMethodBeat.i(136937);
        f(i2, str, this.dxo.gZ(str));
        AppMethodBeat.o(136937);
    }

    public final void f(int i2, String str, String str2) {
        AppMethodBeat.i(136938);
        b bVar = this.dvc.get(str);
        if (bVar == null) {
            AppMethodBeat.o(136938);
            return;
        }
        y yVar = new y();
        yVar.dCW.dtX = str;
        yVar.dCW.action = i2;
        yVar.dCW.appId = bVar.appId;
        if (TextUtils.isEmpty(str2)) {
            str2 = bVar.dvn;
        }
        yVar.dCW.dvn = str2;
        yVar.dCW.state = y.jA(i2);
        if (this.dxq != null) {
            this.dxq.a(yVar);
        }
        AppMethodBeat.o(136938);
    }

    public final void a(int i2, String str, int i3, String str2) {
        AppMethodBeat.i(136939);
        b bVar = this.dvc.get(str);
        if (bVar == null) {
            AppMethodBeat.o(136939);
            return;
        }
        y yVar = new y();
        yVar.dCW.dtX = str;
        yVar.dCW.action = i2;
        yVar.dCW.appId = bVar.appId;
        yVar.dCW.errCode = i3;
        yVar.dCW.errMsg = str2;
        yVar.dCW.state = y.jA(i2);
        if (this.dxq != null) {
            this.dxq.a(yVar);
        }
        AppMethodBeat.o(136939);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0063, code lost:
        if (r0.f(2) != false) goto L_0x0065;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int ZR() {
        /*
        // Method dump skipped, instructions count: 118
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.audio.mix.g.d.ZR():int");
    }

    public final ArrayList<String> ZS() {
        AppMethodBeat.i(136941);
        this.dxw.clear();
        this.dxJ.clear();
        synchronized (this.dxm) {
            try {
                this.dxJ.addAll(this.dxu.keySet());
                Iterator<String> it = this.dxJ.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    e<Integer> eVar = this.dxu.get(next);
                    if (eVar != null) {
                        if (eVar.f(2)) {
                            this.dxw.add(next);
                        }
                    }
                }
            } catch (Throwable th) {
                AppMethodBeat.o(136941);
                throw th;
            }
        }
        ArrayList<String> arrayList = this.dxw;
        AppMethodBeat.o(136941);
        return arrayList;
    }

    static /* synthetic */ void a(d dVar) {
        AppMethodBeat.i(136942);
        if (!dVar.createAudioTrack()) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "onError, errCode:%d", 710);
            AppMethodBeat.o(136942);
            return;
        }
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "create AudioTrack success");
        dVar.bfn.play();
        AppMethodBeat.o(136942);
    }
}

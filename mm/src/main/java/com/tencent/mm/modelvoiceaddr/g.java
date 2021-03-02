package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.model.c.d;
import com.tencent.mm.modelvoiceaddr.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.util.List;

public final class g implements i, b {
    private static int dAR = 5000;
    private static final String jwd = (ar.NSe + "voice_temp.silk");
    public static int jwp = 0;
    public static int jwq = 1;
    public static int jwr = 2;
    public static int jws = 4;
    public static int jwt = 8;
    public static int jwu = 16;
    public static int jwv = 32;
    public static int jww = 64;
    public static int jwx = 128;
    public static int jwy = 256;
    private c dyI;
    private c.a dzv = new c.a() {
        /* class com.tencent.mm.modelvoiceaddr.g.AnonymousClass1 */
        short[] jwD;

        @Override // com.tencent.mm.audio.b.c.a
        public final void w(byte[] bArr, int i2) {
            AppMethodBeat.i(148546);
            Log.d("MicroMsg.SceneVoiceInputAddr", "OnRecPcmDataReady len: %s time: %s", Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()));
            if (this.jwD == null || this.jwD.length < i2 / 2) {
                this.jwD = new short[(i2 / 2)];
            }
            for (int i3 = 0; i3 < i2 / 2; i3++) {
                this.jwD[i3] = (short) ((bArr[i3 * 2] & 255) | (bArr[(i3 * 2) + 1] << 8));
            }
            g.a(g.this, this.jwD, i2 / 2);
            if (g.this.jwB != null) {
                g.this.jwB.e(this.jwD, i2 / 2);
                AppMethodBeat.o(148546);
                return;
            }
            g.this.dD(9, -1);
            Log.e("MicroMsg.SceneVoiceInputAddr", "mVoiceSilentDetectAPI is null");
            AppMethodBeat.o(148546);
        }

        @Override // com.tencent.mm.audio.b.c.a
        public final void cj(int i2, int i3) {
            AppMethodBeat.i(148547);
            Log.e("MicroMsg.SceneVoiceInputAddr", "onRecError state = %s detailState = %s", Integer.valueOf(i2), Integer.valueOf(i3));
            g.this.dD(10, -1);
            AppMethodBeat.o(148547);
        }
    };
    private int jvS = jwq;
    private b jwA = null;
    private com.tencent.mm.modelvoiceaddr.a.c jwB;
    private c.a jwC = new c.a() {
        /* class com.tencent.mm.modelvoiceaddr.g.AnonymousClass2 */
        byte[] jwF;

        @Override // com.tencent.mm.modelvoiceaddr.a.c.a
        public final void b(short[] sArr, int i2) {
            AppMethodBeat.i(148549);
            if (sArr == null) {
                AppMethodBeat.o(148549);
                return;
            }
            if (this.jwF == null || this.jwF.length < i2 * 2) {
                this.jwF = new byte[(i2 * 2)];
            }
            for (int i3 = 0; i3 < i2; i3++) {
                this.jwF[i3 * 2] = (byte) (sArr[i3] & 255);
                this.jwF[(i3 * 2) + 1] = (byte) ((sArr[i3] & 65280) >> 8);
            }
            int a2 = g.this.jwl != null ? g.this.jwl.a(new g.a(this.jwF, i2 * 2), 0, true) : -1;
            if (-1 == a2) {
                g.this.dD(4, -1);
                Log.e("MicroMsg.SceneVoiceInputAddr", "write to file failed");
                AppMethodBeat.o(148549);
                return;
            }
            g.this.jwg = a2 + g.this.jwg;
            if (!g.this.jwz && g.this.jwg > 200 && !g.this.jwh) {
                com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.modelvoiceaddr.g.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(148548);
                        Log.i("MicroMsg.SceneVoiceInputAddr", "run NetSceneNewVoiceInput mWroteBytesCnt %s time %s", Integer.valueOf(g.this.jwg), Long.valueOf(System.currentTimeMillis()));
                        if (g.this.jwz || g.this.jwn == null || g.this.jwg == 0) {
                            Log.w("MicroMsg.SceneVoiceInputAddr", "WorkerThread too busy can not do work");
                            AppMethodBeat.o(148548);
                            return;
                        }
                        com.tencent.mm.kernel.g.azz().a(TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL, g.this);
                        if (!((c) g.this.jwn).bir() || !com.tencent.mm.kernel.g.azz().a(g.this.jwn, 0)) {
                            g.this.dD(13, TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE);
                        }
                        AppMethodBeat.o(148548);
                    }
                });
                g.this.jwh = true;
            }
            AppMethodBeat.o(148549);
        }

        @Override // com.tencent.mm.modelvoiceaddr.a.c.a
        public final void bix() {
            AppMethodBeat.i(148550);
            Log.i("MicroMsg.SceneVoiceInputAddr", "onSpeakToSilent");
            if (g.this.jwn instanceof c) {
                try {
                    ((c) g.this.jwn).ul((int) s.boW(g.jwd));
                    AppMethodBeat.o(148550);
                    return;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e2, "cutShortSentence error", new Object[0]);
                    g.this.dD(6, -1);
                }
            }
            AppMethodBeat.o(148550);
        }

        @Override // com.tencent.mm.modelvoiceaddr.a.c.a
        public final void biy() {
            AppMethodBeat.i(148551);
            Log.i("MicroMsg.SceneVoiceInputAddr", "onSilentToSpeak");
            if (g.this.jwn instanceof c) {
                try {
                    ((c) g.this.jwn).jvN.biC();
                    if (!g.this.jwl.abQ()) {
                        g.this.dD(5, -1);
                        AppMethodBeat.o(148551);
                        return;
                    }
                    AppMethodBeat.o(148551);
                    return;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e2, "createShortSentence error", new Object[0]);
                    g.this.dD(6, -1);
                }
            }
            AppMethodBeat.o(148551);
        }

        @Override // com.tencent.mm.modelvoiceaddr.a.c.a
        public final void Yh() {
            AppMethodBeat.i(148552);
            Log.i("MicroMsg.SceneVoiceInputAddr", "Silent enough to finish time %s", Long.valueOf(System.currentTimeMillis()));
            g.this.stop(false);
            AppMethodBeat.o(148552);
        }
    };
    private int jwf = 0;
    private int jwg = 0;
    private boolean jwh = false;
    private com.tencent.mm.audio.e.a jwl;
    private a jwn = null;
    private boolean jwz = false;
    private int scene = 0;

    public interface b {
        void b(String[] strArr, List<String> list);

        void biv();

        void biz();

        void c(int i2, int i3, int i4, long j2);
    }

    static {
        AppMethodBeat.i(148563);
        AppMethodBeat.o(148563);
    }

    public g() {
        AppMethodBeat.i(148554);
        AppMethodBeat.o(148554);
    }

    @Override // com.tencent.mm.modelvoiceaddr.b
    public final void init(int i2, int i3, b bVar) {
        this.jvS = i2;
        this.jwA = bVar;
        this.scene = i3;
    }

    public g(int i2, int i3, b bVar) {
        AppMethodBeat.i(148555);
        this.jvS = i2;
        this.jwA = bVar;
        this.scene = i3;
        AppMethodBeat.o(148555);
    }

    @Override // com.tencent.mm.modelvoiceaddr.b
    public final void start() {
        AppMethodBeat.i(148556);
        Log.i("MicroMsg.SceneVoiceInputAddr", "start record");
        ThreadPool.post(new a(this, (byte) 0), "SceneVoiceInputAddr_record", 10);
        AppMethodBeat.o(148556);
    }

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(g gVar, byte b2) {
            this();
        }

        public final void run() {
            int i2;
            AppMethodBeat.i(148553);
            synchronized (g.this) {
                try {
                    Log.i("MicroMsg.SceneVoiceInputAddr", "initDeviceInLock time %s", Long.valueOf(System.currentTimeMillis()));
                    long nanoTime = System.nanoTime() & Util.MAX_32BIT_VALUE;
                    if (nanoTime < 0) {
                        nanoTime = Math.abs(nanoTime);
                    }
                    String valueOf = String.valueOf(nanoTime);
                    try {
                        o oVar = new o(g.jwd);
                        if (!oVar.exists()) {
                            oVar.mkdirs();
                        }
                        o oVar2 = new o(g.jwd);
                        if (!oVar2.exists()) {
                            oVar2.createNewFile();
                        }
                        oVar2.delete();
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e2, "delete file failed", new Object[0]);
                    }
                    g.this.dyI = new com.tencent.mm.audio.b.c(16000, 1, 3);
                    g.this.dyI.dzk = -19;
                    g.this.dyI.dc(false);
                    g.this.jwl = new com.tencent.mm.audio.e.c(16000, 23900);
                    if (!g.this.jwl.hz(g.jwd)) {
                        Log.e("MicroMsg.SceneVoiceInputAddr", "init speex writer failed");
                        g.this.jwl.abP();
                        g.this.jwl = null;
                        g.this.dD(5, -1);
                    } else {
                        if (ae.gKE.gGG > 0) {
                            g.this.dyI.x(ae.gKE.gGG, true);
                        } else {
                            g.this.dyI.x(5, false);
                        }
                        g.this.dyI.jk(50);
                        g.this.dyI.dd(false);
                        try {
                            g.this.jwB = new com.tencent.mm.modelvoiceaddr.a.c(true, true);
                            g.this.jwB.jxj = g.this.jwC;
                            com.tencent.mm.storage.c Fu = d.aXu().Fu("100235");
                            if (Fu.isValid()) {
                                i2 = Util.getInt(Fu.gzz().get("MMVoipVadOn"), 0);
                            } else {
                                i2 = 0;
                            }
                            g.this.jwn = new c(g.jwd, valueOf, String.valueOf(i2), g.this.jvS, g.this.scene);
                            g.this.dyI.dzv = g.this.dzv;
                            if (!g.this.dyI.aai()) {
                                Log.e("MicroMsg.SceneVoiceInputAddr", "start record failed");
                                g.this.dD(8, -1);
                            }
                        } catch (Throwable th) {
                            Log.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", th, "init VoiceDetectAPI failed", new Object[0]);
                            g.this.dD(7, -1);
                        }
                    }
                } finally {
                    AppMethodBeat.o(148553);
                }
            }
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(148557);
        String[] bin = ((a) qVar).bin();
        List<String> biq = ((a) qVar).biq();
        Object[] objArr = new Object[6];
        objArr[0] = Long.valueOf(System.currentTimeMillis());
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = Integer.valueOf(bin == null ? -1 : bin.length);
        objArr[4] = Integer.valueOf(qVar.hashCode());
        objArr[5] = Integer.valueOf(this.jwn == null ? -1 : this.jwn.hashCode());
        Log.d("MicroMsg.SceneVoiceInputAddr", "onSceneEnd time %s errType:%s errCode:%s list:%s scene.hashCode():%s,this.hashCode():%s", objArr);
        if (this.jwn == null || qVar.hashCode() != this.jwn.hashCode()) {
            Log.d("MicroMsg.SceneVoiceInputAddr", "onSceneEnd scene.hashCode() != mVoiceRecogScene.hashCode()");
            AppMethodBeat.o(148557);
            return;
        }
        if (this.jwA != null) {
            if (i3 == 0 && i2 == 0) {
                this.jwA.b(bin, biq);
                if ((qVar instanceof c) && this.jwg == 0 && ((c) qVar).jvN.biB()) {
                    this.jwA.biz();
                    cancel(false);
                }
            } else {
                if (str != null && str.equalsIgnoreCase("SecurityCheckError")) {
                    this.jwA.c(13, 132, -1, -1);
                } else if (str == null || !str.equalsIgnoreCase("ReadFileLengthError")) {
                    this.jwA.c(11, i2, i3, (long) ((a) qVar).bip());
                } else {
                    this.jwA.c(13, 133, -1, -1);
                }
                cancel(false);
                AppMethodBeat.o(148557);
                return;
            }
        }
        AppMethodBeat.o(148557);
    }

    public final void dD(int i2, int i3) {
        AppMethodBeat.i(148558);
        Log.i("MicroMsg.SceneVoiceInputAddr", "error localCode = %s,errType = %s,errCode = %s", Integer.valueOf(i2), Integer.valueOf(i3), -1);
        if (this.jwA != null) {
            this.jwA.c(i2, i3, -1, -1);
        }
        n(false, true);
        AppMethodBeat.o(148558);
    }

    @Override // com.tencent.mm.modelvoiceaddr.b
    public final void stop(boolean z) {
        AppMethodBeat.i(148559);
        Log.i("MicroMsg.SceneVoiceInputAddr", "stop fromUI = %s", Boolean.valueOf(z));
        if (!z && this.jwA != null) {
            this.jwA.biv();
        }
        n(true, true);
        AppMethodBeat.o(148559);
    }

    @Override // com.tencent.mm.modelvoiceaddr.b
    public final void cancel(boolean z) {
        AppMethodBeat.i(148560);
        Log.i("MicroMsg.SceneVoiceInputAddr", "cancel fromUI = %s", Boolean.valueOf(z));
        this.jwA = null;
        n(false, z);
        AppMethodBeat.o(148560);
    }

    private void n(boolean z, boolean z2) {
        AppMethodBeat.i(148561);
        Log.i("MicroMsg.SceneVoiceInputAddr", "reset keepNetScene = %s,sendLastScene = %s", Boolean.valueOf(z), Boolean.valueOf(z2));
        synchronized (this) {
            try {
                this.jwz = true;
                if (this.dyI != null) {
                    this.dyI.ZZ();
                    this.dyI = null;
                }
                if (this.jwl != null) {
                    this.jwl.abP();
                    this.jwl = null;
                }
                if (this.jwB != null) {
                    try {
                        this.jwB.release();
                        this.jwB = null;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e2, "mVoiceSilentDetectAPI.release error", new Object[0]);
                    }
                }
                this.jwg = 0;
                if (this.jwn != null && (this.jwn instanceof c)) {
                    this.jwn.bim();
                    try {
                        ((c) this.jwn).ul((int) s.boW(jwd));
                    } catch (Exception e3) {
                        Log.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e3, "reset cutShortSentence error", new Object[0]);
                        dD(6, -1);
                    }
                }
                if (!z && this.jwh) {
                    if (this.jwn != null && (this.jwn instanceof c)) {
                        Log.i("MicroMsg.SceneVoiceInputAddr", "reset call stop() sendLastScene:%s", Boolean.valueOf(z2));
                        if (z2) {
                            ((c) this.jwn).bis();
                        }
                        com.tencent.mm.kernel.g.azz().b(TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL, this);
                    }
                    this.jwn = null;
                    this.jwh = false;
                    AppMethodBeat.o(148561);
                }
            } finally {
                AppMethodBeat.o(148561);
            }
        }
    }

    @Override // com.tencent.mm.modelvoiceaddr.b
    public final int getMaxAmplitudeRate() {
        int i2 = this.jwf;
        this.jwf = 0;
        if (i2 > dAR) {
            dAR = i2;
        }
        return (i2 * 100) / dAR;
    }

    static /* synthetic */ void a(g gVar, short[] sArr, int i2) {
        AppMethodBeat.i(148562);
        for (int i3 = 0; i3 < i2; i3++) {
            short s = sArr[i3];
            if (s > gVar.jwf) {
                gVar.jwf = s;
            }
        }
        Log.d("MicroMsg.SceneVoiceInputAddr", "setCurAmplitude mMaxAmpSinceLastCall = %s", Integer.valueOf(gVar.jwf));
        AppMethodBeat.o(148562);
    }
}

package com.tencent.mm.plugin.shake.d.a;

import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.bg;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.qafpapi.QAFPNative;
import com.tencent.ugc.TXRecordCommon;

public final class a implements i {
    boolean DiA = false;
    int DiB = 0;
    int DiC;
    private boolean DiD = false;
    long DiE;
    int DiF;
    private boolean DiG = false;
    byte[] Dir = new byte[Task.EXTRAS_LIMIT_BYTES];
    int Dis = 0;
    int Dit = 0;
    long Diu = 0;
    int Div = 0;
    boolean Diw = false;
    e Dix = null;
    private AbstractC1691a Diy = null;
    boolean Diz = false;
    Object dBh = new Object();
    c dyI;
    private c.a dzN = new c.a() {
        /* class com.tencent.mm.plugin.shake.d.a.a.AnonymousClass1 */

        @Override // com.tencent.mm.audio.b.c.a
        public final void w(byte[] bArr, int i2) {
            int QAFPProcess;
            int QAFPGetAudioFingerPrint;
            boolean z;
            AppMethodBeat.i(28259);
            f.a aVar = new f.a();
            synchronized (a.this.dBh) {
                try {
                    if (a.this.Div == 408) {
                        Log.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPProcessTV");
                        QAFPProcess = QAFPNative.QAFPProcessTV(bArr, i2);
                    } else {
                        QAFPProcess = QAFPNative.QAFPProcess(bArr, i2);
                    }
                } finally {
                    AppMethodBeat.o(28259);
                }
            }
            long nowMilliSecond = Util.nowMilliSecond() - a.this.DiE;
            Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPProcess clientid:%d pcm:%d ret:%d dur:%d usetime:%d", Integer.valueOf(a.this.DiB), Integer.valueOf(i2), Integer.valueOf(QAFPProcess), Long.valueOf(nowMilliSecond), Long.valueOf(aVar.apr()));
            if (nowMilliSecond > ((long) ((a.this.DiF * 3000) + 4000))) {
                byte[] bArr2 = new byte[Task.EXTRAS_LIMIT_BYTES];
                f.a aVar2 = new f.a();
                if (a.this.Div == 408) {
                    Log.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPGetAudioFingerPrintTV");
                    QAFPGetAudioFingerPrint = QAFPNative.QAFPGetAudioFingerPrintTV(bArr2);
                } else {
                    QAFPGetAudioFingerPrint = QAFPNative.QAFPGetAudioFingerPrint(bArr2);
                }
                Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d outLen:%d time:%d", Integer.valueOf(a.this.DiB), Integer.valueOf(QAFPGetAudioFingerPrint), Long.valueOf(aVar2.apr()));
                if (QAFPGetAudioFingerPrint >= 10240 || QAFPGetAudioFingerPrint <= 0) {
                    Log.e("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d  out ret:%d  !stop record now", Integer.valueOf(a.this.DiB), Integer.valueOf(QAFPGetAudioFingerPrint));
                    a.this.reset();
                    AppMethodBeat.o(28259);
                    return;
                }
                synchronized (a.this.Dir) {
                    try {
                        System.arraycopy(bArr2, 0, a.this.Dir, 0, QAFPGetAudioFingerPrint);
                        a.this.Dis = QAFPGetAudioFingerPrint;
                        a aVar3 = a.this;
                        if (a.this.DiF >= 3) {
                            z = true;
                        } else {
                            z = false;
                        }
                        aVar3.DiA = z;
                        a.this.Dit = (int) (nowMilliSecond / 1000);
                    } catch (Throwable th) {
                        AppMethodBeat.o(28259);
                        throw th;
                    }
                }
                a.this.bck();
                a.this.DiF++;
            }
            if (a.this.DiA) {
                Log.w("MicroMsg.MusicFingerPrintRecorder", "client:%d stop now! duration:%d  ", Integer.valueOf(a.this.DiB), Long.valueOf(nowMilliSecond));
                a.this.reset();
            }
        }

        @Override // com.tencent.mm.audio.b.c.a
        public final void cj(int i2, int i3) {
        }
    };

    /* renamed from: com.tencent.mm.plugin.shake.d.a.a$a  reason: collision with other inner class name */
    public interface AbstractC1691a {
        void b(dpc dpc, long j2, boolean z);
    }

    public a() {
        AppMethodBeat.i(28263);
        AppMethodBeat.o(28263);
    }

    static /* synthetic */ void a(a aVar, dpc dpc, long j2, boolean z) {
        AppMethodBeat.i(28273);
        aVar.a(dpc, j2, z);
        AppMethodBeat.o(28273);
    }

    public final boolean eUM() {
        boolean z = false;
        AppMethodBeat.i(28264);
        synchronized (this.dBh) {
            try {
                if (this.DiD) {
                    Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit already inited");
                } else {
                    int QAFPInit = QAFPNative.QAFPInit();
                    Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit ret:%d", Integer.valueOf(QAFPInit));
                    if (QAFPInit >= 0) {
                        this.DiD = true;
                    }
                    if (QAFPInit >= 0) {
                        z = true;
                    }
                    AppMethodBeat.o(28264);
                }
            } finally {
                AppMethodBeat.o(28264);
            }
        }
        return z;
    }

    public final boolean eUN() {
        boolean z = false;
        AppMethodBeat.i(28265);
        synchronized (this.dBh) {
            try {
                if (!this.DiD) {
                    Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease never inited");
                } else {
                    int QAFPRelease = QAFPNative.QAFPRelease();
                    Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease ret:%d", Integer.valueOf(QAFPRelease));
                    if (QAFPRelease >= 0) {
                        z = true;
                    }
                    AppMethodBeat.o(28265);
                }
            } finally {
                AppMethodBeat.o(28265);
            }
        }
        return z;
    }

    public final boolean ZZ() {
        AppMethodBeat.i(28266);
        Log.d("MicroMsg.MusicFingerPrintRecorder", "stopRecord now clientid:%d", Integer.valueOf(this.DiB));
        bg.azz().b(367, this);
        bg.azz().b(408, this);
        synchronized (this.Dir) {
            try {
                this.Dis = 0;
            } finally {
                AppMethodBeat.o(28266);
            }
        }
        if (this.dyI != null) {
            this.dyI.ZZ();
            this.dyI = null;
        }
        return true;
    }

    public final boolean a(int i2, AbstractC1691a aVar) {
        AppMethodBeat.i(28267);
        ZZ();
        synchronized (this.dBh) {
            try {
                this.DiC = QAFPNative.QAFPGetVersion();
            } finally {
                AppMethodBeat.o(28267);
            }
        }
        eUM();
        this.Div = i2;
        this.Diy = aVar;
        this.DiA = false;
        this.Diz = false;
        this.Diw = false;
        this.DiG = false;
        bg.azz().a(367, this);
        bg.azz().a(408, this);
        this.DiB = (int) Util.nowMilliSecond();
        Log.d("MicroMsg.MusicFingerPrintRecorder", "startRecord now clientid:%d", Integer.valueOf(this.DiB));
        this.dyI = new c(TXRecordCommon.AUDIO_SAMPLERATE_8000, 1, 4);
        this.dyI.dzk = -19;
        this.dyI.dzv = this.dzN;
        if (!this.dyI.aai()) {
            Log.e("MicroMsg.MusicFingerPrintRecorder", "start record failed");
            reset();
            AppMethodBeat.o(28267);
            return false;
        }
        synchronized (this.dBh) {
            try {
                int QAFPReset = QAFPNative.QAFPReset();
                Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPReset ret:%d", Integer.valueOf(QAFPReset));
                if (QAFPReset < 0) {
                    Log.e("MicroMsg.MusicFingerPrintRecorder", "init failed QAFPReset:%d clientid:%d", Integer.valueOf(QAFPReset), Integer.valueOf(this.DiB));
                    reset();
                    return false;
                }
                this.Diu = Util.nowMilliSecond();
                this.DiE = Util.nowMilliSecond();
                this.DiF = 0;
                AppMethodBeat.o(28267);
                return true;
            } finally {
                AppMethodBeat.o(28267);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void reset() {
        AppMethodBeat.i(28268);
        Log.d("MicroMsg.MusicFingerPrintRecorder", "reset recorder clientid:%d", Integer.valueOf(this.DiB));
        if (this.dyI != null) {
            this.dyI.ZZ();
            this.dyI = null;
        }
        uw(false);
        AppMethodBeat.o(28268);
    }

    private void uw(final boolean z) {
        AppMethodBeat.i(28269);
        Log.d("MicroMsg.MusicFingerPrintRecorder", "tryCallBack, directFail = %s", Boolean.FALSE);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.shake.d.a.a.AnonymousClass2 */
            final /* synthetic */ boolean DiI = false;

            public final void run() {
                AppMethodBeat.i(28260);
                if (this.DiI) {
                    a.a(a.this, null, -1, z);
                    AppMethodBeat.o(28260);
                } else if (!a.this.Diw) {
                    Log.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack netscen not return.");
                    AppMethodBeat.o(28260);
                } else if (a.this.dyI != null) {
                    Log.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack device not ready!");
                    AppMethodBeat.o(28260);
                } else if (a.this.Dix != null) {
                    a aVar = a.this;
                    dpc eUP = a.this.Dix.eUP();
                    e eVar = a.this.Dix;
                    long nowMilliSecond = Util.nowMilliSecond();
                    if (eVar.DiM > 0 && eVar.DiM < nowMilliSecond) {
                        nowMilliSecond = eVar.DiM;
                    }
                    a.a(aVar, eUP, nowMilliSecond, z);
                    AppMethodBeat.o(28260);
                } else {
                    a.a(a.this, null, -1, z);
                    AppMethodBeat.o(28260);
                }
            }
        });
        AppMethodBeat.o(28269);
    }

    private synchronized void a(dpc dpc, long j2, boolean z) {
        AppMethodBeat.i(28270);
        if (!this.DiG) {
            this.Diy.b(dpc, j2, z);
            this.DiG = true;
            AppMethodBeat.o(28270);
        } else {
            Log.w("MicroMsg.MusicFingerPrintRecorder", "hy: already call backed to UI");
            AppMethodBeat.o(28270);
        }
    }

    /* access modifiers changed from: package-private */
    public final void bck() {
        AppMethodBeat.i(28271);
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.shake.d.a.a.AnonymousClass3 */

            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0053, code lost:
                r11.DiH.Diz = true;
                r0 = r11.DiH.Div;
                r3 = r11.DiH.Dit;
                r6 = r11.DiH.DiB;
                r7 = r11.DiH.DiA;
                r8 = r11.DiH.DiC;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x006d, code lost:
                if (r0 != 367) goto L_0x0085;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x006f, code lost:
                r1 = new com.tencent.mm.plugin.shake.d.a.f(r2, r3, r4, r6, r7, r8);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0074, code lost:
                com.tencent.mm.model.bg.azz().a(r1, 0);
                com.tencent.matrix.trace.core.AppMethodBeat.o(28261);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0087, code lost:
                if (r0 != 408) goto L_0x008f;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x0089, code lost:
                r1 = new com.tencent.mm.plugin.shake.d.a.g(r2, r3, r4, r6, r7, r8);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x008f, code lost:
                r1 = null;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 145
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.shake.d.a.a.AnonymousClass3.run():void");
            }

            public final String toString() {
                AppMethodBeat.i(28262);
                String str = super.toString() + "|tryStartNetscene";
                AppMethodBeat.o(28262);
                return str;
            }
        });
        AppMethodBeat.o(28271);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(28272);
        if (qVar.getType() == 367 || qVar.getType() == 408) {
            Log.d("MicroMsg.MusicFingerPrintRecorder", "onSceneEnd errType = %s, errCode = %s", Integer.valueOf(i2), Integer.valueOf(i3));
            this.Diz = false;
            if (((e) qVar).eUO()) {
                Log.d("MicroMsg.MusicFingerPrintRecorder", "NetSceneShakeMedia isRecogSuccess stop now ! clientid:%d", Integer.valueOf(this.DiB));
                ZZ();
                this.Dix = (e) qVar;
                this.Diw = true;
                uw(false);
                AppMethodBeat.o(28272);
            } else if (this.Dis != 0 || !this.DiA) {
                Log.d("MicroMsg.MusicFingerPrintRecorder", "NetScene try again clientId:%d", Integer.valueOf(this.DiB));
                bck();
                AppMethodBeat.o(28272);
            } else {
                Log.d("MicroMsg.MusicFingerPrintRecorder", "recog failed . clientid:%d", Integer.valueOf(this.DiB));
                this.Dix = null;
                this.Diw = true;
                if (i2 == 0 && i3 == 0) {
                    uw(false);
                } else {
                    uw(true);
                }
                bg.azz().b(367, this);
                bg.azz().b(408, this);
                AppMethodBeat.o(28272);
            }
        } else {
            AppMethodBeat.o(28272);
        }
    }
}

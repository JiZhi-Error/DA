package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Looper;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.g.a.pc;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.appbrand.media.record.a.b;
import com.tencent.mm.plugin.appbrand.media.record.a.d;
import com.tencent.mm.plugin.appbrand.media.record.j;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;

public final class g {
    private static Object duI = new Object();
    private static g ndF;
    private d dBg = null;
    public boolean dBi = false;
    private long mDuration = 0;
    private String mFilePath;
    private long mStartTime = 0;
    private MMHandler ndA;
    boolean ndB = false;
    boolean ndC = false;
    private a.AbstractC0753a ndD = new a.AbstractC0753a() {
        /* class com.tencent.mm.plugin.appbrand.media.record.g.AnonymousClass6 */

        @Override // com.tencent.mm.plugin.appbrand.media.record.record_imp.a.AbstractC0753a
        public final void w(byte[] bArr, int i2) {
            int i3;
            AppMethodBeat.i(146156);
            if (!(g.this.dBg == null || g.this.nds == null)) {
                g gVar = g.this;
                int i4 = g.this.ndx;
                com.tencent.mm.plugin.appbrand.media.record.record_imp.a aVar = g.this.nds;
                if (aVar.dyI != null) {
                    i3 = aVar.dyI.dzf;
                } else {
                    i3 = 20;
                }
                gVar.ndx = i3 + i4;
                try {
                    if (!g.this.dBg.a(g.this.ndw, bArr, i2)) {
                        Log.e("MicroMsg.Record.AudioRecordMgr", "encode pcm fail!");
                    }
                    AppMethodBeat.o(146156);
                    return;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e2, "onRecPcmDataReady", new Object[0]);
                    if (g.this.ndu != null && "mp3".equalsIgnoreCase(g.this.ndu.lEB)) {
                        j.yz(19);
                        AppMethodBeat.o(146156);
                        return;
                    } else if (g.this.ndu != null && "aac".equalsIgnoreCase(g.this.ndu.lEB)) {
                        j.yz(23);
                    }
                }
            }
            AppMethodBeat.o(146156);
        }

        @Override // com.tencent.mm.plugin.appbrand.media.record.record_imp.a.AbstractC0753a
        public final void cj(int i2, int i3) {
            AppMethodBeat.i(146157);
            Log.i("MicroMsg.Record.AudioRecordMgr", "onRecError state:%d, detailState:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            g.this.onError(1);
            AppMethodBeat.o(146157);
        }
    };
    private d.a ndE = new d.a() {
        /* class com.tencent.mm.plugin.appbrand.media.record.g.AnonymousClass7 */

        @Override // com.tencent.mm.plugin.appbrand.media.record.a.d.a
        public final void c(byte[] bArr, int i2, boolean z) {
            AppMethodBeat.i(146158);
            g gVar = g.this;
            Log.i("MicroMsg.Record.AudioRecordMgr", "onFrameRecorded  buffSize:%d, isLastFrameL:%b", Integer.valueOf(i2), Boolean.valueOf(z));
            pc pcVar = new pc();
            pcVar.dVf.state = "frameRecorded";
            if (gVar.ndu != null) {
                pcVar.dVf.appId = gVar.ndu.appId;
            }
            pcVar.dVf.action = 5;
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            pcVar.dVf.frameBuffer = bArr2;
            pcVar.dVf.dVg = z;
            EventCenter.instance.asyncPublish(pcVar, Looper.getMainLooper());
            AppMethodBeat.o(146158);
        }
    };
    private e ndG = new e() {
        /* class com.tencent.mm.plugin.appbrand.media.record.g.AnonymousClass5 */

        @Override // com.tencent.mm.plugin.appbrand.media.record.e
        public final void bOV() {
            AppMethodBeat.i(146154);
            if (!g.this.ndC) {
                g.this.bPf();
                AppMethodBeat.o(146154);
                return;
            }
            Log.i("MicroMsg.Record.AudioRecordMgr", "is interrupting");
            AppMethodBeat.o(146154);
        }

        @Override // com.tencent.mm.plugin.appbrand.media.record.e
        public final void bOW() {
            AppMethodBeat.i(146155);
            if (g.this.ndC) {
                g gVar = g.this;
                gVar.ndC = false;
                Log.i("MicroMsg.Record.AudioRecordMgr", "onInterruptionEnd");
                pc pcVar = new pc();
                pcVar.dVf.action = 7;
                pcVar.dVf.state = "interruptionEnd";
                if (gVar.ndu != null) {
                    pcVar.dVf.appId = gVar.ndu.appId;
                }
                EventCenter.instance.asyncPublish(pcVar, Looper.getMainLooper());
                AppMethodBeat.o(146155);
                return;
            }
            Log.i("MicroMsg.Record.AudioRecordMgr", "not call onInterruptionEnd");
            AppMethodBeat.o(146155);
        }
    };
    private MTimerHandler ndf = null;
    public com.tencent.mm.plugin.appbrand.media.record.record_imp.a nds = null;
    private Object ndt = new Object();
    public RecordParam ndu;
    a ndv = a.INITIALIZING;
    private boolean ndw = false;
    private int ndx = 0;
    private long ndy = 0;
    private int ndz = 0;

    static /* synthetic */ void i(g gVar) {
        AppMethodBeat.i(146181);
        gVar.bPd();
        AppMethodBeat.o(146181);
    }

    static /* synthetic */ void k(g gVar) {
        AppMethodBeat.i(146183);
        gVar.stopTimer();
        AppMethodBeat.o(146183);
    }

    static {
        AppMethodBeat.i(146184);
        j.a(new j.b() {
            /* class com.tencent.mm.plugin.appbrand.media.record.g.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.media.record.j.b
            public final void yU(long j2) {
                AppMethodBeat.i(146149);
                h.INSTANCE.idkeyStat(689, j2, 1, true);
                AppMethodBeat.o(146149);
            }

            @Override // com.tencent.mm.plugin.appbrand.media.record.j.b
            public final void J(ArrayList<IDKey> arrayList) {
                AppMethodBeat.i(146150);
                h.INSTANCE.b(arrayList, true);
                AppMethodBeat.o(146150);
            }
        });
        AppMethodBeat.o(146184);
    }

    public enum a {
        INITIALIZING,
        START,
        RESUME,
        PAUSE,
        STOP,
        ERROR;

        public static a valueOf(String str) {
            AppMethodBeat.i(146166);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(146166);
            return aVar;
        }

        static {
            AppMethodBeat.i(146167);
            AppMethodBeat.o(146167);
        }
    }

    private void stopTimer() {
        AppMethodBeat.i(146168);
        Log.i("MicroMsg.Record.AudioRecordMgr", "stopTimer");
        if (this.ndf != null) {
            this.ndf.stopTimer();
        }
        this.ndf = null;
        AppMethodBeat.o(146168);
    }

    private g() {
        AppMethodBeat.i(146169);
        AppMethodBeat.o(146169);
    }

    public static g bPa() {
        g gVar;
        AppMethodBeat.i(146170);
        synchronized (duI) {
            try {
                if (ndF == null) {
                    ndF = new g();
                }
                gVar = ndF;
            } finally {
                AppMethodBeat.o(146170);
            }
        }
        return gVar;
    }

    public final boolean YY() {
        return this.ndv == a.PAUSE;
    }

    public final boolean YZ() {
        return this.ndv == a.STOP;
    }

    public final boolean ZZ() {
        AppMethodBeat.i(146171);
        Log.i("MicroMsg.Record.AudioRecordMgr", JsApiStopRecordVoice.NAME);
        if (this.nds == null && this.dBg == null) {
            Log.e("MicroMsg.Record.AudioRecordMgr", "mRecord is null and mAudioEncoder is null, stop fail");
            AppMethodBeat.o(146171);
            return false;
        }
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.media.record.g.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(146163);
                synchronized (g.this.ndt) {
                    try {
                        g.i(g.this);
                    } finally {
                        AppMethodBeat.o(146163);
                    }
                }
            }
        }, "app_brand_stop_record");
        AppMethodBeat.o(146171);
        return true;
    }

    private boolean aaj() {
        boolean z;
        AppMethodBeat.i(146172);
        Log.i("MicroMsg.Record.AudioRecordMgr", "startRecordInternal");
        if (this.nds != null) {
            this.nds.ZZ();
            this.nds = null;
            Log.i("MicroMsg.Record.AudioRecordMgr", "mRecorder is not null, stop it, and not callback stop event");
        }
        if (this.nds == null) {
            this.nds = new com.tencent.mm.plugin.appbrand.media.record.record_imp.a(this.ndu);
            this.nds.neq = this.ndD;
        }
        com.tencent.mm.plugin.appbrand.media.record.record_imp.a aVar = this.nds;
        Log.i("MicroMsg.Record.AppBrandRecorder", JsApiStartRecordVoice.NAME);
        if (aVar.dyI != null) {
            aVar.dyI.ZZ();
            aVar.dyI = null;
        }
        aVar.nep = System.currentTimeMillis();
        Log.i("MicroMsg.Record.AppBrandRecorder", "start time ticket:%d", Long.valueOf(aVar.nep));
        aVar.dyI = new c(aVar.sampleRate, aVar.channelCount, aVar.dzj);
        if ("mp3".equalsIgnoreCase(aVar.neo.lEB)) {
            aVar.dyI.jk(40);
        } else {
            aVar.dyI.jk(20);
        }
        aVar.dyI.dc(false);
        aVar.dyI.dzv = aVar.ner;
        aVar.dyI.setAudioSource(aVar.neo.neu.mFN);
        if (aVar.dyI.aai()) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.Record.AudioRecordMgr", "record start:%b", Boolean.valueOf(z));
        AppMethodBeat.o(146172);
        return z;
    }

    private boolean bPb() {
        boolean z = false;
        AppMethodBeat.i(146173);
        Log.i("MicroMsg.Record.AudioRecordMgr", "initEncode");
        if (this.dBg != null) {
            this.dBg.close();
            this.dBg = null;
        }
        this.mFilePath = h.et(this.ndu.lEB, this.ndu.gLc);
        Log.i("MicroMsg.Record.AudioRecordMgr", "mFilePath:%s", this.mFilePath);
        this.dBg = b.acL(this.ndu.lEB);
        if (this.dBg != null) {
            boolean acI = h.acI(this.mFilePath);
            if (!acI) {
                Log.e("MicroMsg.Record.AudioRecordMgr", "prepare cache file fail");
                AppMethodBeat.o(146173);
                return acI;
            }
            try {
                z = this.dBg.i(this.mFilePath, this.ndu.sampleRate, this.ndu.mFQ, this.ndu.mFR);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e2, "init encoder fail", new Object[0]);
            }
            this.dBg.a(this.ndE);
            AppMethodBeat.o(146173);
            return z;
        }
        AppMethodBeat.o(146173);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void bPc() {
        boolean z;
        AppMethodBeat.i(146174);
        Log.i("MicroMsg.Record.AudioRecordMgr", "pause record in runnable");
        try {
            if (YY()) {
                Log.e("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
                AppMethodBeat.o(146174);
                return;
            }
            if (this.nds != null) {
                z = this.nds.ZZ();
                this.nds = null;
            } else {
                z = false;
            }
            if (!(this.ndu == null || this.ndu.nev == null)) {
                boolean bOX = this.ndu.nev.bOX();
                Log.i("MicroMsg.Record.AudioRecordMgr", "isInterrupted:%b, interrupted:%b", Boolean.valueOf(this.ndC), Boolean.valueOf(bOX));
                if (bOX && !this.ndC) {
                    bPf();
                }
            }
            bPe().post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.media.record.g.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(146152);
                    g.k(g.this);
                    AppMethodBeat.o(146152);
                }
            });
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - this.mStartTime;
            Log.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", Long.valueOf(currentTimeMillis), Long.valueOf(j2), Integer.valueOf(this.ndz));
            this.ndz = (int) (((long) this.ndz) + j2);
            this.ndy = this.mDuration - ((long) this.ndz);
            Log.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", Long.valueOf(this.ndy), Integer.valueOf(this.ndz));
            Log.i("MicroMsg.Record.AudioRecordMgr", "stop:%b", Boolean.valueOf(z));
            if (z) {
                Log.i("MicroMsg.Record.AudioRecordMgr", "onPause");
                this.ndv = a.PAUSE;
                this.dBi = false;
                pc pcVar = new pc();
                pcVar.dVf.action = 3;
                pcVar.dVf.state = "pause";
                if (this.ndu != null) {
                    pcVar.dVf.appId = this.ndu.appId;
                }
                EventCenter.instance.asyncPublish(pcVar, Looper.getMainLooper());
                Log.i("MicroMsg.Record.AudioRecordMgr", "pause record success");
                AppMethodBeat.o(146174);
                return;
            }
            onError(8);
            Log.e("MicroMsg.Record.AudioRecordMgr", "pause record fail");
            AppMethodBeat.o(146174);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e2, "_pause", new Object[0]);
            z = false;
        }
    }

    private void bPd() {
        boolean z;
        AppMethodBeat.i(146175);
        Log.i("MicroMsg.Record.AudioRecordMgr", "stop record in runnable");
        try {
            if (YZ()) {
                Log.e("MicroMsg.Record.AudioRecordMgr", "is stopped, don't stop again");
                AppMethodBeat.o(146175);
                return;
            }
            if (this.nds != null) {
                z = this.nds.ZZ();
                this.nds = null;
            } else {
                Log.e("MicroMsg.Record.AudioRecordMgr", "mRecorder is null, has stop record!");
                z = true;
            }
            this.ndw = true;
            Log.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d", Integer.valueOf(this.ndx));
            if (this.dBg != null) {
                this.dBg.flush();
                this.dBg.close();
                this.dBg = null;
            }
            bPe().post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.media.record.g.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(146153);
                    g.k(g.this);
                    AppMethodBeat.o(146153);
                }
            });
            if (YY()) {
                Log.e("MicroMsg.Record.AudioRecordMgr", "don't calculate time again if it is pause state");
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                long currentTimeMillis2 = System.currentTimeMillis() - this.mStartTime;
                Log.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis2), Integer.valueOf(this.ndz));
                this.ndz = (int) (((long) this.ndz) + currentTimeMillis2);
                this.ndy = this.mDuration - ((long) this.ndz);
                Log.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", Long.valueOf(this.ndy), Integer.valueOf(this.ndz));
            }
            Log.i("MicroMsg.Record.AudioRecordMgr", "stop:%b", Boolean.valueOf(z));
            if (z) {
                Log.i("MicroMsg.Record.AudioRecordMgr", "onStop");
                this.ndv = a.STOP;
                this.dBi = false;
                pc pcVar = new pc();
                pcVar.dVf.action = 2;
                pcVar.dVf.state = "stop";
                if (this.ndu != null) {
                    pcVar.dVf.appId = this.ndu.appId;
                }
                Log.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d, mRealRecordedTime%d", Integer.valueOf(this.ndx), Integer.valueOf(this.ndz));
                pcVar.dVf.duration = Math.min(this.ndx, this.ndz);
                pcVar.dVf.filePath = this.mFilePath;
                pcVar.dVf.fileSize = (int) h.acJ(this.mFilePath);
                EventCenter.instance.asyncPublish(pcVar, Looper.getMainLooper());
                Log.i("MicroMsg.Record.AudioRecordMgr", "stop record success");
            } else {
                onError(9);
                Log.e("MicroMsg.Record.AudioRecordMgr", "stop record fail");
            }
            this.ndu = null;
            d.bOU();
            AppMethodBeat.o(146175);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e2, "_stop", new Object[0]);
            z = false;
        }
    }

    private MMHandler bPe() {
        AppMethodBeat.i(146176);
        if (this.ndA == null) {
            this.ndA = new MMHandler(Looper.getMainLooper());
        }
        MMHandler mMHandler = this.ndA;
        AppMethodBeat.o(146176);
        return mMHandler;
    }

    /* access modifiers changed from: protected */
    public final void onError(int i2) {
        AppMethodBeat.i(146177);
        Log.i("MicroMsg.Record.AudioRecordMgr", "onError errType:%d", Integer.valueOf(i2));
        if (this.ndv != a.ERROR) {
            j.yy(i2);
        }
        this.ndv = a.ERROR;
        this.dBi = false;
        pc pcVar = new pc();
        pcVar.dVf.action = 4;
        pcVar.dVf.state = "error";
        if (this.ndu != null) {
            pcVar.dVf.appId = this.ndu.appId;
        }
        pcVar.dVf.errCode = i2;
        pcVar.dVf.errMsg = i.yw(i2);
        EventCenter.instance.asyncPublish(pcVar, Looper.getMainLooper());
        AppMethodBeat.o(146177);
    }

    /* access modifiers changed from: protected */
    public final void bPf() {
        AppMethodBeat.i(146178);
        this.ndC = true;
        Log.i("MicroMsg.Record.AudioRecordMgr", "onInterruptionBegin");
        pc pcVar = new pc();
        pcVar.dVf.action = 6;
        pcVar.dVf.state = "interruptionBegin";
        if (this.ndu != null) {
            pcVar.dVf.appId = this.ndu.appId;
        }
        EventCenter.instance.asyncPublish(pcVar, Looper.getMainLooper());
        AppMethodBeat.o(146178);
    }

    static /* synthetic */ void g(g gVar) {
        int i2;
        AppMethodBeat.i(146179);
        try {
            Log.i("MicroMsg.Record.AudioRecordMgr", "_start in runnable");
            if (!gVar.bPb()) {
                gVar.onError(2);
                Log.e("MicroMsg.Record.AudioRecordMgr", "init encoder fail");
                AppMethodBeat.o(146179);
                return;
            }
            gVar.ndw = false;
            gVar.ndx = 0;
            if (!gVar.ndB) {
                gVar.ndB = true;
                if (!(gVar.ndu == null || gVar.ndu.nev == null)) {
                    gVar.ndu.nev.a(gVar.ndG);
                    gVar.ndu.nev.bOY();
                }
            }
            if (gVar.aaj()) {
                d dVar = gVar.dBg;
                com.tencent.mm.plugin.appbrand.media.record.record_imp.a aVar = gVar.nds;
                if (aVar.dyI != null) {
                    i2 = aVar.dyI.aah();
                } else {
                    i2 = 0;
                }
                dVar.yA(i2);
                gVar.dBg.r(gVar.ndu.mFS);
                gVar.ndz = 0;
                gVar.mDuration = (long) gVar.ndu.duration;
                gVar.mStartTime = System.currentTimeMillis();
                gVar.ndy = gVar.mDuration;
                Log.i("MicroMsg.Record.AudioRecordMgr", "mDuration:%d, mCurrentTime:%d", Long.valueOf(gVar.mDuration), Long.valueOf(gVar.mStartTime));
                gVar.bPe().post(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.media.record.g.AnonymousClass13 */

                    public final void run() {
                        AppMethodBeat.i(146164);
                        g.a(g.this, g.this.ndy);
                        AppMethodBeat.o(146164);
                    }
                });
                Log.i("MicroMsg.Record.AudioRecordMgr", "onStart");
                gVar.ndv = a.START;
                gVar.dBi = true;
                pc pcVar = new pc();
                pcVar.dVf.action = 0;
                pcVar.dVf.state = "start";
                if (gVar.ndu != null) {
                    pcVar.dVf.appId = gVar.ndu.appId;
                }
                EventCenter.instance.asyncPublish(pcVar, Looper.getMainLooper());
                Log.i("MicroMsg.Record.AudioRecordMgr", "start record success");
                AppMethodBeat.o(146179);
                return;
            }
            gVar.onError(6);
            Log.e("MicroMsg.Record.AudioRecordMgr", "start record fail");
            AppMethodBeat.o(146179);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e2, "_start", new Object[0]);
            gVar.onError(4);
            AppMethodBeat.o(146179);
        }
    }

    static /* synthetic */ void h(g gVar) {
        AppMethodBeat.i(146180);
        try {
            Log.i("MicroMsg.Record.AudioRecordMgr", "_resume in runnable");
            if (gVar.dBg == null) {
                gVar.onError(3);
                Log.e("MicroMsg.Record.AudioRecordMgr", "resume record fail");
                AppMethodBeat.o(146180);
            } else if (gVar.ndy <= 0) {
                gVar.bPd();
                Log.e("MicroMsg.Record.AudioRecordMgr", "resume record fail, record time reach max time, to stop record");
                AppMethodBeat.o(146180);
            } else if (gVar.aaj()) {
                gVar.mStartTime = System.currentTimeMillis();
                Log.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, currentTime:%d", Long.valueOf(gVar.ndy), Long.valueOf(gVar.mStartTime));
                gVar.bPe().post(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.media.record.g.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(146151);
                        g.a(g.this, g.this.ndy);
                        AppMethodBeat.o(146151);
                    }
                });
                Log.i("MicroMsg.Record.AudioRecordMgr", "onResume");
                gVar.ndv = a.RESUME;
                gVar.dBi = true;
                pc pcVar = new pc();
                pcVar.dVf.action = 1;
                pcVar.dVf.state = "resume";
                if (gVar.ndu != null) {
                    pcVar.dVf.appId = gVar.ndu.appId;
                }
                EventCenter.instance.asyncPublish(pcVar, Looper.getMainLooper());
                Log.i("MicroMsg.Record.AudioRecordMgr", "resume record success");
                AppMethodBeat.o(146180);
            } else {
                gVar.onError(7);
                Log.e("MicroMsg.Record.AudioRecordMgr", "resume record fail");
                AppMethodBeat.o(146180);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e2, "_resume", new Object[0]);
            gVar.onError(5);
            AppMethodBeat.o(146180);
        }
    }

    static /* synthetic */ void a(g gVar, long j2) {
        AppMethodBeat.i(146182);
        gVar.stopTimer();
        Log.i("MicroMsg.Record.AudioRecordMgr", "startTimer");
        gVar.ndf = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.appbrand.media.record.g.AnonymousClass8 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(146159);
                Log.i("MicroMsg.Record.AudioRecordMgr", "timer, onTimerExpired to stop record");
                g.this.ZZ();
                AppMethodBeat.o(146159);
                return true;
            }
        }, false);
        gVar.ndf.startTimer(j2);
        AppMethodBeat.o(146182);
    }
}

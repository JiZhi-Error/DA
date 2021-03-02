package com.tencent.mm.audio.b;

import android.media.MediaRecorder;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.bg.d;
import com.tencent.mm.compatible.b.c;
import com.tencent.mm.compatible.i.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.ugc.TXRecordCommon;

public final class b {
    private static Object dyE = new Object();
    private boolean cxw = false;
    private d.a dyA = null;
    private long dyB = 0;
    private long dyC = 0;
    private int dyD = 0;
    private int dyF = 16000;
    private boolean dyG = false;
    public MediaRecorder dyH;
    public c dyI = null;
    public c.a dyJ;
    public EnumC0271b dyK;
    private volatile boolean dyL = false;
    private long dyM = -1;
    private f.a dyN = new f.a();
    private int dyO = 0;
    private int dyP = 0;
    private c.a dyQ = new c.a() {
        /* class com.tencent.mm.audio.b.b.AnonymousClass2 */

        /* JADX WARNING: Code restructure failed: missing block: B:100:0x0370, code lost:
            r9 = x(r9, r10);
            r10 = r9.length;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x0375, code lost:
            y(r9, r10);
            com.tencent.matrix.trace.core.AppMethodBeat.o(148310);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x036e, code lost:
            if (r8.dyR.mSampleRate != 16000) goto L_0x0375;
         */
        @Override // com.tencent.mm.audio.b.c.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void w(byte[] r9, int r10) {
            /*
            // Method dump skipped, instructions count: 896
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.audio.b.b.AnonymousClass2.w(byte[], int):void");
        }

        private static byte[] x(byte[] bArr, int i2) {
            int i3 = i2 % 4;
            if (i3 != 0) {
                i2 -= i3;
            }
            if (i2 <= 0) {
                return null;
            }
            byte[] bArr2 = new byte[(i2 / 2)];
            for (int i4 = 0; i4 < i2 / 2; i4 += 2) {
                bArr2[i4] = bArr[i4 * 2];
                bArr2[i4 + 1] = bArr[(i4 * 2) + 1];
            }
            return bArr2;
        }

        private void y(byte[] bArr, int i2) {
            AppMethodBeat.i(148311);
            for (int i3 = 0; i3 < i2 / 2; i3++) {
                short s = (short) ((bArr[i3 * 2] & 255) | (bArr[(i3 * 2) + 1] << 8));
                if (s > b.this.dyt) {
                    b.this.dyt = s;
                }
            }
            AppMethodBeat.o(148311);
        }

        @Override // com.tencent.mm.audio.b.c.a
        public final void cj(int i2, int i3) {
        }
    };
    private int dyt = 0;
    private String dyu = null;
    private int dyv;
    private final Object dyw = new Object();
    private com.tencent.mm.audio.e.c dyx = null;
    private a dyy;
    private com.tencent.mm.bg.c dyz = null;
    private int mSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_8000;

    public interface a {
        void onError();
    }

    static {
        AppMethodBeat.i(148328);
        AppMethodBeat.o(148328);
    }

    /* renamed from: com.tencent.mm.audio.b.b$b  reason: collision with other inner class name */
    public enum EnumC0271b {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        public static EnumC0271b valueOf(String str) {
            AppMethodBeat.i(148313);
            EnumC0271b bVar = (EnumC0271b) Enum.valueOf(EnumC0271b.class, str);
            AppMethodBeat.o(148313);
            return bVar;
        }

        static {
            AppMethodBeat.i(148314);
            AppMethodBeat.o(148314);
        }
    }

    public b(c.a aVar) {
        AppMethodBeat.i(148315);
        Log.i("MicroMsg.MMAudioRecorder", "MMAudioRecorder recMode: ".concat(String.valueOf(aVar)));
        this.dyJ = aVar;
        if (!g.b.aap()) {
            Log.i("MicroMsg.MMAudioRecorder", "can't use silk encode, force to use amr mode now");
            this.dyJ = c.a.AMR;
        }
        if (this.dyJ == c.a.AMR) {
            this.dyv = 7;
            this.dyH = new e();
        } else {
            aae();
            this.dyv = 1;
        }
        this.dyM = -1;
        this.dyL = false;
        AppMethodBeat.o(148315);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(148316);
        if (this.dyJ == c.a.AMR) {
            if (this.dyH == null) {
                AppMethodBeat.o(148316);
                return;
            }
            this.dyy = aVar;
            this.dyH.setOnErrorListener(new MediaRecorder.OnErrorListener() {
                /* class com.tencent.mm.audio.b.b.AnonymousClass1 */

                public final void onError(MediaRecorder mediaRecorder, int i2, int i3) {
                    AppMethodBeat.i(148307);
                    if (b.this.dyy != null) {
                        b.this.dyy.onError();
                    }
                    try {
                        b.this.dyH.release();
                    } catch (Exception e2) {
                        Log.e("MicroMsg.MMAudioRecorder", e2.getMessage());
                    }
                    b.this.dyK = EnumC0271b.ERROR;
                    AppMethodBeat.o(148307);
                }
            });
            AppMethodBeat.o(148316);
        } else if (this.dyK == EnumC0271b.INITIALIZING) {
            this.dyy = aVar;
            AppMethodBeat.o(148316);
        } else {
            Log.e("MicroMsg.MMAudioRecorder", "setOnErrorListener on wrong state");
            AppMethodBeat.o(148316);
        }
    }

    public final void setOutputFile(String str) {
        AppMethodBeat.i(148317);
        if (this.dyJ != c.a.AMR) {
            if (this.dyK == EnumC0271b.INITIALIZING) {
                this.dyu = str;
                if (this.dyI != null) {
                    this.dyI.dzC = this.dyu;
                    AppMethodBeat.o(148317);
                    return;
                }
            } else {
                Log.e("MicroMsg.MMAudioRecorder", "set output path on wrong state");
                this.dyK = EnumC0271b.ERROR;
            }
            AppMethodBeat.o(148317);
        } else if (this.dyH == null) {
            AppMethodBeat.o(148317);
        } else {
            this.dyH.setOutputFile(str);
            this.dyu = str;
            AppMethodBeat.o(148317);
        }
    }

    public final void setMaxDuration(int i2) {
        AppMethodBeat.i(148318);
        if (this.dyJ == c.a.AMR) {
            if (this.dyH != null) {
                this.dyH.setMaxDuration(i2);
            }
            AppMethodBeat.o(148318);
            return;
        }
        this.dyB = (long) i2;
        AppMethodBeat.o(148318);
    }

    public final void aab() {
        AppMethodBeat.i(148319);
        if (this.dyJ == c.a.AMR) {
            if (this.dyH != null) {
                this.dyH.setAudioEncoder(1);
            }
            AppMethodBeat.o(148319);
            return;
        }
        AppMethodBeat.o(148319);
    }

    public final void aac() {
        AppMethodBeat.i(148320);
        if (this.dyJ != c.a.AMR) {
            AppMethodBeat.o(148320);
        } else if (this.dyH == null) {
            AppMethodBeat.o(148320);
        } else {
            this.dyH.setAudioSource(1);
            AppMethodBeat.o(148320);
        }
    }

    public final void aad() {
        AppMethodBeat.i(148321);
        if (this.dyJ != c.a.AMR) {
            AppMethodBeat.o(148321);
        } else if (this.dyH == null) {
            AppMethodBeat.o(148321);
        } else {
            this.dyH.setOutputFormat(3);
            AppMethodBeat.o(148321);
        }
    }

    public final int getMaxAmplitude() {
        AppMethodBeat.i(148322);
        if (this.dyJ == c.a.AMR) {
            if (this.dyH == null) {
                AppMethodBeat.o(148322);
                return 0;
            }
            int maxAmplitude = this.dyH.getMaxAmplitude();
            AppMethodBeat.o(148322);
            return maxAmplitude;
        } else if (this.dyK == EnumC0271b.RECORDING) {
            int i2 = this.dyt;
            if (this.dyM <= 0 || Util.ticksToNow(this.dyM) > 500) {
                Log.i("MicroMsg.MMAudioRecorder", "mCurAmplitude:%s", Integer.valueOf(this.dyt));
                this.dyM = Util.currentTicks();
            }
            this.dyt = 0;
            AppMethodBeat.o(148322);
            return i2;
        } else {
            AppMethodBeat.o(148322);
            return 0;
        }
    }

    public final void aae() {
        AppMethodBeat.i(148323);
        this.dyA = d.a.bfW();
        if (this.dyA != null) {
            this.dyG = this.dyA.bfV();
        }
        if (this.dyJ == c.a.SILK) {
            String value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("VoiceSamplingRate");
            this.mSampleRate = Util.getInt(value, 16000);
            String value2 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("VoiceRate");
            this.dyF = Util.getInt(value2, 16000);
            Log.i("MicroMsg.MMAudioRecorder", "initMediaRecorder dynamicSample: %s sampleRate: %d dynamicEncoding: %s audioEncoding: %d", value, Integer.valueOf(this.mSampleRate), value2, Integer.valueOf(this.dyF));
        } else {
            if (this.dyG) {
                this.mSampleRate = 16000;
            } else {
                this.mSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_8000;
            }
            com.tencent.mm.kernel.g.aAi();
            int nullAs = Util.nullAs((Integer) com.tencent.mm.kernel.g.aAh().hqB.get(27), 0);
            Log.i("MicroMsg.MMAudioRecorder", "sampleRate: " + this.mSampleRate + " notSupp16K: " + nullAs);
            if (nullAs == 1) {
                this.mSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_8000;
            }
        }
        this.dyt = 0;
        this.dyu = null;
        synchronized (this.dyw) {
            try {
                this.dyz = null;
                this.dyx = null;
            } catch (Throwable th) {
                AppMethodBeat.o(148323);
                throw th;
            }
        }
        this.dyD = 0;
        try {
            synchronized (dyE) {
                try {
                    this.dyI = new c(this.mSampleRate, 1, 0);
                    this.dyI.dc(true);
                    this.dyI.jk(120);
                    this.dyI.dzv = this.dyQ;
                } catch (Throwable th2) {
                    AppMethodBeat.o(148323);
                    throw th2;
                }
            }
            this.dyK = EnumC0271b.INITIALIZING;
            AppMethodBeat.o(148323);
        } catch (Exception e2) {
            if (e2.getMessage() != null) {
                Log.e("MicroMsg.MMAudioRecorder", e2.getMessage());
            } else {
                Log.e("MicroMsg.MMAudioRecorder", "Unknown error occured while initializing recording");
            }
            this.dyK = EnumC0271b.ERROR;
            AppMethodBeat.o(148323);
        }
    }

    public final void start() {
        AppMethodBeat.i(148324);
        if (this.dyJ == c.a.AMR) {
            if (this.dyH != null) {
                this.dyH.start();
            }
            AppMethodBeat.o(148324);
            return;
        }
        Log.i("MicroMsg.MMAudioRecorder", "Start record now state: " + this.dyK + " recMode: " + this.dyJ);
        if (this.dyK == EnumC0271b.READY) {
            this.dyC = System.currentTimeMillis();
            this.dyD = 0;
            this.dyK = EnumC0271b.RECORDING;
            synchronized (dyE) {
                try {
                    this.dyI.aai();
                } catch (Throwable th) {
                    AppMethodBeat.o(148324);
                    throw th;
                }
            }
        } else {
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().hqB.set(27, 1);
            Log.e("MicroMsg.MMAudioRecorder", "start() called on illegal state");
            this.dyK = EnumC0271b.ERROR;
        }
        this.dyL = false;
        AppMethodBeat.o(148324);
    }

    public final void prepare() {
        AppMethodBeat.i(148325);
        if (this.dyJ == c.a.AMR) {
            if (this.dyH != null) {
                this.dyH.prepare();
            }
            AppMethodBeat.o(148325);
        } else if (this.dyK != EnumC0271b.INITIALIZING || this.dyu == null) {
            this.dyK = EnumC0271b.ERROR;
            release();
            AppMethodBeat.o(148325);
        } else {
            this.dyK = EnumC0271b.READY;
            AppMethodBeat.o(148325);
        }
    }

    public final void release() {
        AppMethodBeat.i(148326);
        if (this.dyJ == c.a.AMR) {
            if (this.dyH != null) {
                this.dyH.release();
            }
            AppMethodBeat.o(148326);
            return;
        }
        if (this.dyK == EnumC0271b.RECORDING) {
            Qt();
        } else {
            EnumC0271b bVar = EnumC0271b.READY;
        }
        synchronized (dyE) {
            try {
                if (this.dyI != null) {
                    this.dyI.ZZ();
                    this.dyI.dzv = null;
                    this.dyI = null;
                }
            } finally {
                AppMethodBeat.o(148326);
            }
        }
    }

    public final boolean Qt() {
        AppMethodBeat.i(148327);
        if (this.dyJ == c.a.AMR) {
            Log.i("MicroMsg.MMAudioRecorder", "stop sysMediaRecorder: %s", this.dyH);
            if (this.dyH != null) {
                this.dyH.stop();
                this.dyH.release();
                this.dyH = null;
            }
            AppMethodBeat.o(148327);
            return true;
        }
        f.a aVar = new f.a();
        Log.i("MicroMsg.MMAudioRecorder", "stop now state: " + this.dyK);
        if (this.dyK == EnumC0271b.INITIALIZING) {
            h.INSTANCE.idkeyStat(357, 53, 1, true);
            if (!this.cxw) {
                h.INSTANCE.idkeyStat(357, 54, 1, true);
            }
            this.cxw = true;
        }
        if (this.dyK != EnumC0271b.RECORDING) {
            Log.e("MicroMsg.MMAudioRecorder", "stop() called on illegal state");
            this.dyK = EnumC0271b.ERROR;
            AppMethodBeat.o(148327);
            return true;
        }
        synchronized (dyE) {
            try {
                if (this.dyI != null) {
                    this.dyL = true;
                } else {
                    this.dyL = false;
                }
            } finally {
                AppMethodBeat.o(148327);
            }
        }
        long apr = aVar.apr();
        this.dyK = EnumC0271b.STOPPED;
        long apr2 = aVar.apr();
        if (this.dyL) {
            Log.i("MicroMsg.MMAudioRecorder", "start to wait pcmrecorder stop, markStop: %s", Boolean.valueOf(this.dyL));
            int i2 = 0;
            while (true) {
                if (!this.dyL) {
                    break;
                }
                i2++;
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e2) {
                    Log.printErrStackTrace("MicroMsg.MMAudioRecorder", e2, "", new Object[0]);
                }
                if (i2 >= 25) {
                    synchronized (dyE) {
                        try {
                            Log.i("MicroMsg.MMAudioRecorder", "wait pcmrecorder stop, reach maximum count!, mPcmRecorder: %s", this.dyI);
                            if (this.dyI != null) {
                                try {
                                    this.dyI.ZZ();
                                    this.dyI.dzv = null;
                                    this.dyI = null;
                                } catch (Exception e3) {
                                    Log.printErrStackTrace("MicroMsg.MMAudioRecorder", e3, "", new Object[0]);
                                }
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(148327);
                            throw th;
                        }
                    }
                }
            }
            Log.i("MicroMsg.MMAudioRecorder", "finish to wait pcmrecorder stop, markStop: %s, count: %s", Boolean.valueOf(this.dyL), Integer.valueOf(i2));
        }
        synchronized (this.dyw) {
            try {
                if (this.dyx != null) {
                    this.dyx.abP();
                }
                if (this.dyz != null) {
                    com.tencent.mm.bg.c cVar = this.dyz;
                    Log.i("MicroMsg.SpeexEncoderWorker", "stop ");
                    new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                        /* class com.tencent.mm.bg.c.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(148376);
                            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                                /* class com.tencent.mm.bg.c.AnonymousClass1.AnonymousClass1 */

                                public final boolean queueIdle() {
                                    AppMethodBeat.i(148375);
                                    Log.d("MicroMsg.SpeexEncoderWorker", "queueIdle  ");
                                    e.bfX().b(c.this);
                                    AppMethodBeat.o(148375);
                                    return false;
                                }
                            });
                            AppMethodBeat.o(148376);
                        }
                    });
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        long milliSecondsToNow = Util.milliSecondsToNow(this.dyC);
        Log.i("MicroMsg.MMAudioRecorder", "toNow " + milliSecondsToNow + " startTickCnt: " + this.dyC + " pcmDataReadedCnt: " + this.dyD);
        if (milliSecondsToNow > 2000 && this.dyD == 0) {
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().hqB.set(27, 1);
            Log.i("MicroMsg.MMAudioRecorder", "16k not suppourt");
        }
        Log.i("MicroMsg.MMAudioRecorder", "Wait Stop Time Media:" + apr + " Read:" + apr2 + " Thr:" + aVar.apr());
        AppMethodBeat.o(148327);
        return false;
    }
}

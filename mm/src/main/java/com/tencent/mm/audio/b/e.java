package com.tencent.mm.audio.b;

import android.media.AudioRecord;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantLock;

public final class e extends f {
    int dzH;
    private int dzK = 12800;
    b dzL = new b();
    com.tencent.mm.compatible.b.b dzM = null;
    c.a dzN;
    final Object dzO = new Object();
    final byte[] dzP = new byte[0];
    final Object dzQ = new Object();
    Timer dzR = null;
    boolean dzS = false;
    private boolean dzT = false;
    boolean dzg;
    AudioRecord dzu;
    boolean mIsMute = false;
    int mStatus = 0;

    interface c {
        void finish();
    }

    public e(AudioRecord audioRecord, boolean z, int i2, c.a aVar, boolean z2) {
        AppMethodBeat.i(130002);
        this.dzu = audioRecord;
        this.dzg = z;
        this.dzH = i2;
        this.dzN = aVar;
        this.dzT = z2;
        AppMethodBeat.o(130002);
    }

    @Override // com.tencent.mm.audio.b.f
    public final boolean aai() {
        boolean z;
        boolean z2;
        char c2 = 65535;
        AppMethodBeat.i(130003);
        Log.i("MicroMsg.RecordModeAsyncRead", JsApiStartRecordVoice.NAME);
        synchronized (this.dzQ) {
            try {
                this.mStatus = 1;
            } finally {
                AppMethodBeat.o(130003);
            }
        }
        Log.i("MicroMsg.RecordModeAsyncRead", "[startRecord] dumpRunningTask:%s", h.RTd.hmd());
        h.RTc.aX(this.dzL);
        if (true == this.dzT) {
            this.dzM = new com.tencent.mm.compatible.b.b();
            if (this.dzM == null) {
                Log.e("MicroMsg.RecordModeAsyncRead", "new m_audioBuffer error ");
                z2 = false;
            } else {
                this.dzK = this.dzH * 20;
                Log.i("MicroMsg.RecordModeAsyncRead", "audioBuffer init mAudioBufferSize: " + this.dzK);
                com.tencent.mm.compatible.b.b bVar = this.dzM;
                int i2 = this.dzK;
                if (i2 <= 0) {
                    z = true;
                } else {
                    bVar.gCH = new byte[i2];
                    if (bVar.gCH == null) {
                        z = true;
                    } else {
                        bVar.gCF = i2;
                        if (bVar.gCK) {
                            bVar.gCL = new ReentrantLock();
                        }
                        z = false;
                    }
                }
                if (z) {
                    Log.e("MicroMsg.RecordModeAsyncRead", "audioBuffer init failed, error code = -1");
                    z2 = false;
                } else {
                    z2 = true;
                }
            }
            if (!z2) {
                Log.e("MicroMsg.RecordModeAsyncRead", "initAudioBuffer failed");
                AppMethodBeat.o(130003);
                return false;
            }
            if (this.dzS || this.dzR != null) {
                Log.w("MicroMsg.RecordModeAsyncRead", "Timer has been created or, timer has been started, " + this.dzS);
            } else {
                this.dzR = new Timer();
                if (this.dzR != null) {
                    c2 = 0;
                }
            }
            if (c2 != 0) {
                Log.e("MicroMsg.RecordModeAsyncRead", "InitAudioRecTimer failed, error code = -1");
                AppMethodBeat.o(130003);
                return false;
            }
            this.dzR.scheduleAtFixedRate(new a(), 60, 20);
            this.dzS = true;
        }
        return true;
    }

    @Override // com.tencent.mm.audio.b.f
    public final void stopRecord() {
        AppMethodBeat.i(130004);
        Log.i("MicroMsg.RecordModeAsyncRead", JsApiStopRecordVoice.NAME);
        synchronized (this.dzQ) {
            try {
                this.mStatus = 3;
                this.dzL.dzY = new c() {
                    /* class com.tencent.mm.audio.b.e.AnonymousClass1 */

                    @Override // com.tencent.mm.audio.b.e.c
                    public final void finish() {
                        AppMethodBeat.i(129998);
                        e.this.dzL.dzY = null;
                        Log.i("MicroMsg.RecordModeAsyncRead", "finish stopRecord");
                        if (e.this.dzM != null) {
                            if (e.this.dzR != null) {
                                e.this.dzR.cancel();
                                e.this.dzR = null;
                            }
                            com.tencent.mm.compatible.b.b bVar = e.this.dzM;
                            bVar.gCF = 0;
                            bVar.gCG = 0;
                            bVar.gCI = 0;
                            bVar.gCJ = 0;
                            bVar.gCH = null;
                            synchronized (e.this.dzO) {
                                try {
                                    e.this.dzM = null;
                                    e.this.dzN = null;
                                } finally {
                                    AppMethodBeat.o(129998);
                                }
                            }
                            e.this.dzS = false;
                            e.this.dzM = null;
                        }
                    }
                };
            } finally {
                AppMethodBeat.o(130004);
            }
        }
        synchronized (this.dzP) {
            try {
                this.dzP.notify();
            } finally {
                AppMethodBeat.o(130004);
            }
        }
    }

    public final int aam() {
        synchronized (this.dzO) {
            if (this.dzM == null) {
                return -1;
            }
            return this.dzM.gCF;
        }
    }

    public final int aan() {
        AppMethodBeat.i(130005);
        synchronized (this.dzO) {
            try {
                if (this.dzM != null) {
                    return this.dzM.anD();
                }
                AppMethodBeat.o(130005);
                return -1;
            } finally {
                AppMethodBeat.o(130005);
            }
        }
    }

    public final int z(byte[] bArr, int i2) {
        int i3 = -1;
        AppMethodBeat.i(130006);
        synchronized (this.dzO) {
            try {
                if (this.dzM != null) {
                    com.tencent.mm.compatible.b.b bVar = this.dzM;
                    if (i2 > 0 && i2 <= bVar.anD() && bArr != null && bVar.gCI != bVar.gCJ) {
                        if (bVar.gCK) {
                            bVar.gCL.lock();
                        }
                        if (bVar.gCI < bVar.gCJ) {
                            System.arraycopy(bVar.gCH, bVar.gCI, bArr, 0, i2);
                            bVar.gCI += i2;
                        } else if (i2 <= bVar.gCF - bVar.gCI) {
                            System.arraycopy(bVar.gCH, bVar.gCI, bArr, 0, i2);
                            bVar.gCI += i2;
                        } else {
                            System.arraycopy(bVar.gCH, bVar.gCI, bArr, 0, bVar.gCF - bVar.gCI);
                            System.arraycopy(bVar.gCH, 0, bArr, bVar.gCF - bVar.gCI, i2 - (bVar.gCF - bVar.gCI));
                            bVar.gCI = i2 - (bVar.gCF - bVar.gCI);
                        }
                        if (bVar.gCK) {
                            bVar.gCL.unlock();
                        }
                        i3 = 0;
                    }
                } else {
                    AppMethodBeat.o(130006);
                }
            } finally {
                AppMethodBeat.o(130006);
            }
        }
        return i3;
    }

    @Override // com.tencent.mm.audio.b.f
    public final void de(boolean z) {
        this.mIsMute = z;
    }

    class a extends TimerTask {
        private int dzV = (e.this.dzH * 2);
        private int dzW = e.this.dzH;
        byte[] dzX = new byte[this.dzV];

        a() {
            AppMethodBeat.i(129999);
            AppMethodBeat.o(129999);
        }

        public final void run() {
            AppMethodBeat.i(130000);
            if (!e.this.mIsPause) {
                int aam = (int) (0.8d * ((double) e.this.aam()));
                if (aam < e.this.dzH * 8) {
                    aam = e.this.dzH * 8;
                }
                int i2 = e.this.aan() > aam ? 8 : 1;
                for (int i3 = 0; i3 < i2; i3++) {
                    int z = e.this.z(this.dzX, this.dzW);
                    if (e.this.dzN != null && z == 0) {
                        e.this.dzN.w(this.dzX, this.dzW);
                    }
                }
            }
            AppMethodBeat.o(130000);
        }
    }

    final class b implements com.tencent.f.i.h {
        volatile c dzY;

        b() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x009b, code lost:
            r0 = new byte[r13.dzU.dzH];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x00a5, code lost:
            if (2 != r13.dzU.mStatus) goto L_0x00c0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a7, code lost:
            r1 = r13.dzU.dzP;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x00ab, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b0, code lost:
            if (r13.dzU.mIsPause == false) goto L_0x00dc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            r13.dzU.dzP.wait();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00fe, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0100, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(130001);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0103, code lost:
            throw r0;
         */
        /* JADX WARNING: Removed duplicated region for block: B:121:0x026f  */
        /* JADX WARNING: Removed duplicated region for block: B:136:0x00a1 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00c4  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x017e  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x0185  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x01aa  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 653
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.audio.b.e.b.run():void");
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "RecordModeAsyncRead_record";
        }
    }
}

package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.Log;

public final class f {
    static int qrK = 3;
    int mChannels = 1;
    int mSampleRate = v2protocal.VOICE_SAMPLERATE;
    g qrG;
    public volatile c qrH;
    private e qrI = new e();
    private k qrJ;
    int qrL = 1;
    int qrM = 92;
    private int qrN = 1;
    private final Object qrO = new Object();
    int qrP = 0;
    private int qrQ = 0;
    private int qrR = 1;
    private long qrS = 0;
    boolean qrT = false;
    public boolean qrU = false;
    int qrV = 20;
    c.a qrW = new c.a() {
        /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f.AnonymousClass1 */

        @Override // com.tencent.mm.audio.b.c.a
        public final void w(byte[] bArr, int i2) {
            int i3;
            int i4 = -1;
            AppMethodBeat.i(90789);
            synchronized (f.this.qrO) {
                try {
                    if (f.a(f.this) % 50 == 0) {
                        f.this.qrQ = 0;
                        Log.v("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: syncOnRecPcmDataReady pcm raw length: %d, given len; %d", Integer.valueOf(bArr.length), Integer.valueOf(i2));
                    }
                    if (f.this.qrL == 2 && f.this.qrG.qrZ.isAvailable()) {
                        if (f.this.qrM <= 10) {
                            f.this.qrM = 92;
                        }
                        com.tencent.mm.plugin.voip.model.c cVar = f.this.qrG.qrZ.qrz;
                        if (cVar != null) {
                            i3 = cVar.fFq();
                        } else {
                            i3 = -1;
                        }
                        f.this.qrM = ((i3 + 24) + (f.this.qrM * 3)) / 4;
                        if (f.this.qrN == 1) {
                            com.tencent.mm.plugin.voip.model.c cVar2 = f.this.qrG.qrZ.qrz;
                            if (cVar2 != null) {
                                i4 = cVar2.fFn();
                            }
                            if (i4 >= f.this.qrM) {
                                i4 -= f.this.qrM;
                            }
                            f.this.qrM = i4;
                            f.this.qrN = 0;
                        } else {
                            f.this.qrM = 0;
                        }
                        if (1 == f.this.qrR) {
                            f.this.qrR = 0;
                            f.this.qrS = System.currentTimeMillis();
                            Log.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "amyfwang,first record");
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            long j2 = currentTimeMillis - f.this.qrS;
                            if (j2 > 1000) {
                                Log.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "amyfwang,error,deltaTime:".concat(String.valueOf(j2)));
                            }
                            f.this.qrS = currentTimeMillis;
                        }
                        q qVar = q.INSTANCE;
                        q.G(bArr, bArr.length, f.this.qrM);
                    }
                } finally {
                    AppMethodBeat.o(90789);
                }
            }
        }

        @Override // com.tencent.mm.audio.b.c.a
        public final void cj(int i2, int i3) {
        }
    };

    static /* synthetic */ int a(f fVar) {
        int i2 = fVar.qrQ + 1;
        fVar.qrQ = i2;
        return i2;
    }

    public f(k kVar) {
        AppMethodBeat.i(90791);
        this.qrJ = kVar;
        this.qrG = new g();
        AppMethodBeat.o(90791);
    }

    public final boolean aai() {
        boolean z = true;
        AppMethodBeat.i(90792);
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: trigger start play");
        if (this.qrL != 2) {
            Log.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: not init when start listen!");
        }
        synchronized (this.qrO) {
            try {
                if (!this.qrH.aai()) {
                    if (this.qrH.dyZ != 13) {
                        this.qrP = 1;
                    }
                    z = false;
                } else {
                    q.INSTANCE.kM(true);
                    Log.d("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "VoipDeivceHandler.m_iAudioDevErr:" + this.qrP);
                    AppMethodBeat.o(90792);
                }
            } finally {
                AppMethodBeat.o(90792);
            }
        }
        return z;
    }
}

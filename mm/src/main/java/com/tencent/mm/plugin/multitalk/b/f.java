package com.tencent.mm.plugin.multitalk.b;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.p.u;
import com.tencent.mm.plugin.appbrand.jsapi.p.v;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.multitalk.b.a.a;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.wxmm.v2helper;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.g.b.p;

public final class f {
    private static int qrK = 3;
    private int mChannels = 1;
    private int mSampleRate = v2protocal.VOICE_SAMPLERATE;
    volatile c qrH;
    private int qrL = 1;
    private int qrM = 92;
    private int qrN = 1;
    private final Object qrO = new Object();
    private int qrP = 0;
    private int qrQ = 0;
    private int qrR = 1;
    private long qrS = 0;
    private boolean qrT = false;
    private int qrV = 20;
    private c.a qrW = new c.a() {
        /* class com.tencent.mm.plugin.multitalk.b.f.AnonymousClass1 */

        @Override // com.tencent.mm.audio.b.c.a
        public final void w(byte[] bArr, int i2) {
            int i3;
            int i4 = -1;
            boolean z = false;
            AppMethodBeat.i(239013);
            synchronized (f.this.qrO) {
                try {
                    if (f.a(f.this) % 50 == 0) {
                        f.this.qrQ = 0;
                        Log.v("MicroMsg.Multitalk.ILinkAudioMgr", "hy: syncOnRecPcmDataReady pcm raw length: %d, given len; %d", Integer.valueOf(bArr.length), Integer.valueOf(i2));
                    }
                    if (f.this.qrL == 2) {
                        if (f.this.zHq.zHu.qrz != null) {
                            z = true;
                        }
                        if (z) {
                            if (f.this.qrM <= 10) {
                                f.this.qrM = 92;
                            }
                            com.tencent.mm.plugin.voip.model.c cVar = f.this.zHq.zHu.qrz;
                            if (cVar != null) {
                                i3 = cVar.fFq();
                            } else {
                                i3 = -1;
                            }
                            f.this.qrM = ((i3 + 24) + (f.this.qrM * 3)) / 4;
                            if (f.this.qrN == 1) {
                                com.tencent.mm.plugin.voip.model.c cVar2 = f.this.zHq.zHu.qrz;
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
                                Log.i("MicroMsg.Multitalk.ILinkAudioMgr", "amyfwang,first record");
                            } else {
                                long currentTimeMillis = System.currentTimeMillis();
                                long j2 = currentTimeMillis - f.this.qrS;
                                if (j2 > 1000) {
                                    Log.i("MicroMsg.Multitalk.ILinkAudioMgr", "amyfwang,error,deltaTime:".concat(String.valueOf(j2)));
                                }
                                f.this.qrS = currentTimeMillis;
                            }
                            p pVar = p.INSTANCE;
                            p.G(bArr, bArr.length, f.this.qrM);
                        }
                    }
                } finally {
                    AppMethodBeat.o(239013);
                }
            }
        }

        @Override // com.tencent.mm.audio.b.c.a
        public final void cj(int i2, int i3) {
        }
    };
    public g zHq;
    private e zHr = new e();
    private k zHs;

    static /* synthetic */ int a(f fVar) {
        int i2 = fVar.qrQ + 1;
        fVar.qrQ = i2;
        return i2;
    }

    public f(k kVar) {
        AppMethodBeat.i(239015);
        this.zHs = kVar;
        this.zHq = new g();
        AppMethodBeat.o(239015);
    }

    public final boolean czm() {
        AppMethodBeat.i(239016);
        if (this.qrL != 2 || this.zHq == null) {
            Log.e("MicroMsg.Multitalk.ILinkAudioMgr", "hy: error not init when startplay, devStatus:" + this.qrL);
            AppMethodBeat.o(239016);
            return false;
        } else if (this.zHq.a(new b() {
            /* class com.tencent.mm.plugin.multitalk.b.f.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.voip.model.b
            public final int Q(byte[] bArr, int i2) {
                AppMethodBeat.i(239014);
                if (f.this.qrL != 2) {
                    AppMethodBeat.o(239014);
                    return -1;
                }
                p pVar = p.INSTANCE;
                int S = p.S(bArr, i2);
                if (f.this.qrT) {
                    AppMethodBeat.o(239014);
                    return -10086;
                } else if (S < 0) {
                    AppMethodBeat.o(239014);
                    return -1;
                } else {
                    AppMethodBeat.o(239014);
                    return 0;
                }
            }
        }, this.mSampleRate, this.mChannels, this.qrV) <= 0) {
            this.qrP = 1;
            AppMethodBeat.o(239016);
            return false;
        } else {
            ac.eol().emK();
            AppMethodBeat.o(239016);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(acs acs) {
        if (acs != null) {
            this.mSampleRate = acs.Lnx.LqF;
            this.mChannels = acs.Lnx.channels;
            this.qrV = acs.Lnx.LqG;
        }
    }

    public final boolean aai() {
        AppMethodBeat.i(239017);
        Log.i("MicroMsg.Multitalk.ILinkAudioMgr", "hy: trigger startrecord");
        if (this.qrL != 2 || this.qrH == null) {
            Log.e("MicroMsg.Multitalk.ILinkAudioMgr", "hy: not init when startrecord! devStatus:" + this.qrL);
            AppMethodBeat.o(239017);
            return false;
        }
        synchronized (this.qrO) {
            try {
                if (!this.qrH.aai()) {
                    if (this.qrH.dyZ != 13) {
                        this.qrP = 1;
                    }
                    return false;
                }
                Log.d("MicroMsg.Multitalk.ILinkAudioMgr", "VoipDeivceHandler.m_iAudioDevErr:" + this.qrP);
                AppMethodBeat.o(239017);
                return true;
            } finally {
                AppMethodBeat.o(239017);
            }
        }
    }

    public final int elD() {
        if (this.qrH == null) {
            return 0;
        }
        return this.qrH.dyZ;
    }

    public final int elE() {
        AppMethodBeat.i(239018);
        if (this.zHq == null) {
            AppMethodBeat.o(239018);
            return 0;
        }
        com.tencent.mm.plugin.voip.model.c cVar = this.zHq.zHu.qrz;
        if (cVar != null) {
            int fFs = cVar.fFs();
            AppMethodBeat.o(239018);
            return fFs;
        }
        AppMethodBeat.o(239018);
        return 0;
    }

    public final void init() {
        AppMethodBeat.i(239019);
        if (this.qrL == 2) {
            Log.e("MicroMsg.Multitalk.ILinkAudioMgr", "dev start already...");
            AppMethodBeat.o(239019);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.multitalk.b.g.AnonymousClass1 */

            public final void run() {
                int b2;
                AppMethodBeat.i(239021);
                if (g.this.zHu != null) {
                    a aVar = g.this.zHu;
                    Log.i("MicroMsg.ILinkAudioManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b %s", Boolean.valueOf(a.AY(3)), Boolean.valueOf(a.AY(4)), Integer.valueOf(aVar.hashCode()));
                    aVar.jvG.requestFocus();
                    if (a.cdZ()) {
                        ac.eom().rx(false);
                        if (a.AY(4) && (b2 = aVar.b("openvoice", (Integer) 4)) != 0) {
                            Log.e("MicroMsg.ILinkAudioManager", "hy: start bluetooth failed %d", Integer.valueOf(b2));
                            aVar.agq("openvoice");
                        }
                        ac.eol().rz(false);
                        ac.eol().ry(true);
                        AppMethodBeat.o(239021);
                        return;
                    }
                    q eom = ac.eom();
                    p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
                    if (eom.mkd) {
                        aVar.b("openvoice", (Integer) 1);
                        aVar.qry &= aVar.kJ(true);
                    } else {
                        aVar.b("openvoice", (Integer) 2);
                    }
                    ac.eol().rz(true);
                    ac.eol().ry(false);
                }
                AppMethodBeat.o(239021);
            }
        });
        Log.i("MicroMsg.Multitalk.ILinkAudioMgr", "start device......");
        this.qrL = 2;
        ae.gKu.dump();
        byte[] bArr = {0};
        byte[] bArr2 = new byte[2];
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "hy: audio info dump begin");
        ae.gKu.dump();
        if (ae.gKu.gEo >= 0) {
            bArr2[0] = (byte) ae.gKu.gEo;
            p pVar = p.INSTANCE;
            p.f(406, bArr2, 1);
        } else if (ae.gKu.gEo == -2) {
            p pVar2 = p.INSTANCE;
            p.f(407, bArr, 1);
        }
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt_agc_params, -1);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x_agc_paras = %d", Integer.valueOf(a2));
        if (a2 > 0) {
            byte b2 = (byte) (a2 & 1);
            Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, agc_switch = %d", Byte.valueOf(b2));
            if (b2 > 0) {
                byte[] bArr3 = {(byte) ((a2 >> 1) & 31), (byte) ((a2 >> 6) & 31), (byte) ((a2 >> 11) & 3), (byte) ((a2 >> 13) & 3), (byte) ((a2 >> 15) & 1), (byte) ((a2 >> 16) & 7), (byte) ((a2 >> 19) & 15)};
                Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, agc para: %d, %d, %d, %d, %d, %d, %d", Byte.valueOf(bArr3[0]), Byte.valueOf(bArr3[1]), Byte.valueOf(bArr3[2]), Byte.valueOf(bArr3[3]), Byte.valueOf(bArr3[4]), Byte.valueOf(bArr3[5]), Byte.valueOf(bArr3[6]));
                p pVar3 = p.INSTANCE;
                p.f(404, bArr3, 7);
            } else {
                p pVar4 = p.INSTANCE;
                p.f(405, bArr, 1);
            }
        }
        if (ae.gKu.gEt >= 0) {
            byte[] bArr4 = new byte[7];
            if (ae.gKu.gEu >= 0 && ae.gKu.gEv >= 0) {
                bArr4[0] = (byte) ae.gKu.gEu;
                bArr4[1] = (byte) ae.gKu.gEv;
                if (ae.gKu.gEw >= 0) {
                    bArr4[2] = (byte) ae.gKu.gEw;
                    bArr4[3] = (byte) ae.gKu.gEt;
                    bArr4[4] = (byte) ae.gKu.gEx;
                    bArr4[5] = (byte) ae.gKu.gEy;
                    bArr4[6] = (byte) ae.gKu.gEz;
                    p pVar5 = p.INSTANCE;
                    p.f(404, bArr4, 7);
                } else {
                    p pVar6 = p.INSTANCE;
                    p.f(404, bArr4, 2);
                }
            }
        } else if (ae.gKu.gEt == -2) {
            p pVar7 = p.INSTANCE;
            p.f(405, bArr, 1);
        }
        long a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt_wave_agc, -1L);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x-expt settings, wave_agc_paras: %d", Long.valueOf(a3));
        if (a3 > -1) {
            byte[] bArr5 = new byte[11];
            bArr5[0] = (byte) ((int) (3 & a3));
            Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x-expt settings, wave agc mode: %d", Byte.valueOf(bArr5[0]));
            if (bArr5[0] == 1) {
                bArr5[1] = (byte) ((int) ((a3 >> 2) & 31));
                bArr5[2] = (byte) ((int) ((a3 >> 7) & 31));
                bArr5[3] = (byte) ((int) ((a3 >> 12) & 31));
                bArr5[4] = (byte) ((int) ((a3 >> 17) & 31));
                bArr5[5] = (byte) ((int) ((a3 >> 22) & 15));
                bArr5[6] = (byte) ((int) ((a3 >> 26) & 15));
                bArr5[7] = (byte) ((int) ((a3 >> 30) & 1));
                bArr5[8] = (byte) ((int) ((a3 >> 31) & 31));
                bArr5[9] = (byte) ((int) ((a3 >> 36) & 31));
                bArr5[10] = (byte) ((int) ((a3 >> 41) & 31));
                p pVar8 = p.INSTANCE;
                p.f(461, bArr5, 11);
                Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x-expt settings, wave agc paras: %d, %d, %d, %d, %d, %d, %d, %d, %d, %d", Byte.valueOf(bArr5[1]), Byte.valueOf(bArr5[2]), Byte.valueOf(bArr5[3]), Byte.valueOf(bArr5[4]), Byte.valueOf(bArr5[5]), Byte.valueOf(bArr5[6]), Byte.valueOf(bArr5[7]), Byte.valueOf(bArr5[8]), Byte.valueOf(bArr5[9]), Byte.valueOf(bArr5[10]));
            } else if (bArr5[0] == 2) {
                bArr5[1] = (byte) ((int) ((a3 >> 2) & 31));
                bArr5[2] = (byte) ((int) ((a3 >> 7) & 31));
                bArr5[3] = (byte) ((int) ((a3 >> 12) & 31));
                bArr5[4] = (byte) ((int) ((a3 >> 17) & 31));
                bArr5[5] = (byte) ((int) ((a3 >> 22) & 15));
                bArr5[6] = (byte) ((int) ((a3 >> 26) & 15));
                p pVar9 = p.INSTANCE;
                p.f(461, bArr5, 7);
                Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x-expt settings, wave agc paras: %d, %d, %d, %d, %d, %d", Byte.valueOf(bArr5[1]), Byte.valueOf(bArr5[2]), Byte.valueOf(bArr5[3]), Byte.valueOf(bArr5[4]), Byte.valueOf(bArr5[5]), Byte.valueOf(bArr5[6]));
            } else if (bArr5[0] == 0) {
                p pVar10 = p.INSTANCE;
                p.f(462, bArr5, 1);
            }
        }
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, device-model config, SrvDeviceInfo.mAudioInfo.waveAgcMode: %d", Integer.valueOf(ae.gKu.gEA));
        if (ae.gKu.gEA >= 0) {
            byte[] bArr6 = new byte[11];
            bArr6[0] = (byte) ae.gKu.gEA;
            if (bArr6[0] == 1) {
                bArr6[1] = (byte) ae.gKu.gEH;
                bArr6[2] = (byte) ae.gKu.gEI;
                bArr6[3] = (byte) ae.gKu.gEJ;
                bArr6[4] = (byte) ae.gKu.gEE;
                bArr6[5] = (byte) ae.gKu.gEF;
                bArr6[6] = (byte) ae.gKu.gEG;
                bArr6[7] = (byte) ae.gKu.gEK;
                bArr6[8] = (byte) ae.gKu.gEB;
                bArr6[9] = (byte) ae.gKu.gEC;
                bArr6[10] = (byte) ae.gKu.gED;
                p pVar11 = p.INSTANCE;
                p.f(461, bArr6, 11);
                Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, device-model config, wave agc paras: %d, %d, %d, %d, %d, %d, %d, %d, %d, %d", Byte.valueOf(bArr6[1]), Byte.valueOf(bArr6[2]), Byte.valueOf(bArr6[3]), Byte.valueOf(bArr6[4]), Byte.valueOf(bArr6[5]), Byte.valueOf(bArr6[6]), Byte.valueOf(bArr6[7]), Byte.valueOf(bArr6[8]), Byte.valueOf(bArr6[9]), Byte.valueOf(bArr6[10]));
            } else if (bArr6[0] == 2) {
                bArr6[1] = (byte) ae.gKu.gEB;
                bArr6[2] = (byte) ae.gKu.gEC;
                bArr6[3] = (byte) ae.gKu.gED;
                bArr6[4] = (byte) ae.gKu.gEE;
                bArr6[5] = (byte) ae.gKu.gEF;
                bArr6[6] = (byte) ae.gKu.gEG;
                p pVar12 = p.INSTANCE;
                p.f(461, bArr6, 7);
                Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, device-model config, wave agc paras: %d, %d, %d, %d, %d, %d", Byte.valueOf(bArr6[1]), Byte.valueOf(bArr6[2]), Byte.valueOf(bArr6[3]), Byte.valueOf(bArr6[4]), Byte.valueOf(bArr6[5]), Byte.valueOf(bArr6[6]));
            } else if (bArr6[0] == 0) {
                p pVar13 = p.INSTANCE;
                p.f(462, bArr6, 1);
            }
        }
        int a4 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multiparty_rnn_value, 1002);
        if (a4 > 0) {
            byte[] bArr7 = {(byte) (a4 & 255), (byte) ((a4 >> 8) & 255), (byte) ((a4 >> 16) & 255), (byte) ((a4 >> 24) & 255)};
            p pVar14 = p.INSTANCE;
            p.f(408, bArr7, 4);
        } else if (a4 == 0) {
            bArr[0] = (byte) (a4 & 255);
            p pVar15 = p.INSTANCE;
            p.f(409, bArr, 1);
        }
        int i2 = ae.gKu.gEq;
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang SrvDeviceInfo.mAudioInfo.nsModeNewMulti %d", Integer.valueOf(i2));
        if (ae.gKu.gEq >= 0) {
            if (i2 > 0) {
                int floor = ((int) Math.floor(((double) i2) / 1000.0d)) % 100;
                Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang SrvDeviceInfo.mAudioInfo.iflag %d", Integer.valueOf(floor));
                if (floor > 0) {
                    byte[] bArr8 = {(byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255)};
                    p pVar16 = p.INSTANCE;
                    p.f(408, bArr8, 4);
                }
            } else if (i2 == 0) {
                bArr[0] = (byte) (i2 & 255);
                p pVar17 = p.INSTANCE;
                p.f(409, bArr, 1);
            }
        } else if (ae.gKu.gEq == -2) {
            bArr[0] = (byte) (i2 & 255);
            p pVar18 = p.INSTANCE;
            p.f(409, bArr, 1);
        }
        if (ae.gKu.gEP[0] > 0 || ae.gKu.gEP[1] > 0) {
            bArr2[0] = 0;
            bArr2[1] = 0;
            if (ae.gKu.gEP[0] > 0 && ae.gKu.gEP[0] < 10000) {
                bArr2[0] = (byte) ae.gKu.gEP[0];
            }
            if (ae.gKu.gEP[1] > 0 && ae.gKu.gEP[1] < 10000) {
                bArr2[1] = (byte) ae.gKu.gEP[1];
            }
            p pVar19 = p.INSTANCE;
            p.f(v2helper.EMethodSetNgStrength, bArr2, 2);
        }
        if (ae.gKu.gDN >= 0 || ae.gKu.gDP >= 0) {
            bArr2[0] = -1;
            bArr2[1] = -1;
            if (ae.gKu.gDN >= 0) {
                bArr2[0] = (byte) ae.gKu.gDN;
            }
            if (ae.gKu.gDP >= 0) {
                bArr2[1] = (byte) ae.gKu.gDP;
            }
            p pVar20 = p.INSTANCE;
            p.f(414, bArr2, 2);
        }
        if (ae.gKu.gDO >= 0 || ae.gKu.gDQ >= 0) {
            bArr2[0] = -1;
            bArr2[1] = -1;
            if (ae.gKu.gDO >= 0) {
                bArr2[0] = (byte) ae.gKu.gDO;
            }
            if (ae.gKu.gDQ >= 0) {
                bArr2[1] = (byte) ae.gKu.gDQ;
            }
            p pVar21 = p.INSTANCE;
            p.f(415, bArr2, 2);
        }
        if (ae.gKu.gDR >= 0 || ae.gKu.gDS >= 0) {
            bArr2[0] = -1;
            bArr2[1] = -1;
            if (ae.gKu.gDR >= 0) {
                bArr2[0] = (byte) ae.gKu.gDR;
            }
            if (ae.gKu.gDS >= 0) {
                bArr2[1] = (byte) ae.gKu.gDS;
            }
            p pVar22 = p.INSTANCE;
            p.f(v2helper.EMethodOutputVolumeGainEnable, bArr2, 2);
        }
        if (ae.gKu.gDX >= 0) {
            bArr2[0] = (byte) ae.gKu.gDX;
            p pVar23 = p.INSTANCE;
            p.f(416, bArr2, 1);
        }
        if (ae.gKu.gDY >= 0 && ae.gKu.gDY != 5) {
            bArr2[0] = (byte) ae.gKu.gDY;
            p pVar24 = p.INSTANCE;
            p.f(417, bArr2, 1);
        }
        if (ae.gKu.gDZ >= 0 && ae.gKu.gDZ != 5) {
            bArr2[0] = (byte) ae.gKu.gDZ;
            p pVar25 = p.INSTANCE;
            p.f(418, bArr2, 1);
        }
        if (ae.gKu.gEa >= 0) {
            bArr2[0] = (byte) ae.gKu.gEa;
            p pVar26 = p.INSTANCE;
            p.f(419, bArr2, 1);
        }
        if (1 == ae.gKu.gEN) {
            byte[] bArr9 = new byte[30];
            for (int i3 = 0; i3 < 15; i3++) {
                bArr9[i3 * 2] = (byte) (ae.gKu.gEO[i3] & 255);
                bArr9[(i3 * 2) + 1] = (byte) ((ae.gKu.gEO[i3] >> 8) & 255);
            }
            p pVar27 = p.INSTANCE;
            p.f(v2helper.EMethodSetPlayerPreCorrectCofOn, bArr9, 30);
        }
        if (ae.gKu.gEN == 0) {
            p pVar28 = p.INSTANCE;
            p.f(v2helper.EMethodSetPlayerPreCorrectCofOff, bArr, 1);
        }
        if (ae.gKu.gER > 0) {
            bArr2[0] = (byte) ae.gKu.gER;
            p pVar29 = p.INSTANCE;
            p.f(v2helper.EMethodSetSpkEnhance, bArr2, 1);
        }
        if (ae.gKu.gEb > 0) {
            bArr2[0] = (byte) ae.gKu.gEb;
            p pVar30 = p.INSTANCE;
            p.f(431, bArr2, 4);
        }
        int a5 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mt_agcrx_params, -1);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x_agcrx_paras: %d", Integer.valueOf(a5));
        if (a5 > 0) {
            byte b3 = (byte) (a5 & 1);
            Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, agcrx_switch: %d", Byte.valueOf(b3));
            if (b3 > 0) {
                byte[] bArr10 = {(byte) ((a5 >> 1) & 3), (byte) ((a5 >> 3) & 31), (byte) ((a5 >> 8) & 31), (byte) ((a5 >> 13) & 1)};
                p pVar31 = p.INSTANCE;
                p.f(v2helper.EMethodSetAgcRxOn, bArr10, 4);
                Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, agc rx para: %d, %d, %d, %d", Byte.valueOf(bArr10[0]), Byte.valueOf(bArr10[1]), Byte.valueOf(bArr10[2]), Byte.valueOf(bArr10[3]));
            }
        }
        if (ae.gKu.gEZ >= 0) {
            byte[] bArr11 = {(byte) ae.gKu.gEZ, (byte) ae.gKu.gFa, (byte) ae.gKu.gFb, (byte) ae.gKu.gFc};
            p pVar32 = p.INSTANCE;
            p.f(v2helper.EMethodSetAgcRxOn, bArr11, 4);
        }
        int a6 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_play_fadeinfadeout_switch, -1);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang, multi_play_fadeinfadeout_switch = %d", Integer.valueOf(a6));
        byte[] bArr12 = {0};
        if (a6 > 0) {
            bArr12[0] = (byte) a6;
        }
        p pVar33 = p.INSTANCE;
        p.f(451, bArr12, 1);
        int a7 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_play_fadeinfadeout_thresh, -1);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang, multi_play_fadeinfadeout_thresh = %d", Integer.valueOf(a7));
        bArr12[0] = 0;
        if (a7 > 0) {
            bArr12[0] = (byte) a7;
        }
        p pVar34 = p.INSTANCE;
        p.f(452, bArr12, 1);
        long[] jArr = {((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_activerangecnt, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange1, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange2, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange3, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange4, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange5, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange6, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange7, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange8, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange9, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange10, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange11, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange12, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange13, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange14, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange15, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange16, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange17, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange18, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange19, -1L), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multi_lossrange20, -1L)};
        ByteBuffer order = ByteBuffer.allocate(168).order(ByteOrder.LITTLE_ENDIAN);
        order.asLongBuffer().put(jArr);
        byte[] array = order.array();
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang, multi_loss_control[0] %d,multi_loss_control[1] %d multi_loss_control[2] %d", Long.valueOf(jArr[0]), Long.valueOf(jArr[1]), Long.valueOf(jArr[2]));
        p pVar35 = p.INSTANCE;
        p.f(u.CTRL_INDEX, array, array.length);
        int a8 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_rcnnvadctr, -1);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang, rcnnvad_switch = %d", Integer.valueOf(a8));
        if (a8 > 0) {
            byte[] bArr13 = {(byte) a8};
            p pVar36 = p.INSTANCE;
            p.f(v.CTRL_INDEX, bArr13, 1);
        }
        int a9 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_aec_value, 0);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "dennyliang, voip aec_value = %d", Integer.valueOf(a9));
        if (a9 > 0) {
            byte[] bArr14 = {(byte) (a9 & 255), (byte) ((a9 >> 8) & 255), (byte) ((a9 >> 16) & 255), (byte) ((a9 >> 24) & 255)};
            p pVar37 = p.INSTANCE;
            p.f(460, bArr14, 4);
        }
        int a10 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_frz_sta_peroid, -1);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, iLink updateAudioAdaption, frz_sta_p_x = %d", Integer.valueOf(a10));
        if (a10 > 0) {
            byte[] bArr15 = {(byte) (a10 & 255), (byte) ((a10 >> 8) & 255), (byte) ((a10 >> 16) & 255), (byte) ((a10 >> 24) & 255)};
            p pVar38 = p.INSTANCE;
            p.f(com.tencent.mm.plugin.appbrand.jsapi.share.u.CTRL_INDEX, bArr15, 4);
        }
        int a11 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_engine_get_data_config, -1);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, updateAudioAdaption, switch_flag_x = %d", Integer.valueOf(a11));
        byte[] bArr16 = {0};
        if (a11 > 0) {
            bArr16[0] = 1;
        }
        p pVar39 = p.INSTANCE;
        p.f(450, bArr16, 1);
        if (this.qrM <= 10) {
            if (this.qrM <= 0) {
                this.qrP = 1;
            }
            this.qrM = 92;
        }
        this.qrH = new c(this.mSampleRate, this.mChannels, 1);
        this.qrH.jk(this.qrV);
        this.qrH.dd(true);
        this.qrH.aag();
        this.qrH.dzk = -19;
        this.qrH.x(1, false);
        this.qrH.dc(true);
        this.qrH.dzv = this.qrW;
        AppMethodBeat.o(239019);
    }

    public final void release() {
        AppMethodBeat.i(239020);
        if (this.zHq != null) {
            g gVar = this.zHq;
            synchronized (gVar.qrY) {
                try {
                    Log.i("MicroMsg.Multitalk.ILinkAudioPlayer", "stopPlay, isStart: %s %s", Boolean.valueOf(gVar.isStart), Integer.valueOf(gVar.hashCode()));
                    if (gVar.isStart) {
                        a aVar = gVar.zHu;
                        com.tencent.mm.plugin.voip.model.c cVar = aVar.qrz;
                        if (cVar != null) {
                            cVar.fFr();
                            cVar.fFo();
                            aVar.qrz = null;
                        }
                        gVar.qsa.gLm = SystemClock.elapsedRealtime();
                        Log.i("MicroMsg.Multitalk.ILinkAudioPlayer", "stopPlaying cost: " + gVar.qsa.apr());
                        gVar.isStart = false;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(239020);
                    throw th;
                }
            }
        }
        ac.eol().emL();
        this.qrT = false;
        if (this.qrH != null) {
            this.qrH.ZZ();
            this.qrH = null;
            Log.i("MicroMsg.Multitalk.ILinkAudioMgr", "finish pauseRecord");
        }
        this.qrL = qrK;
        if (this.zHq != null) {
            a aVar2 = this.zHq.zHu;
            aVar2.cdV();
            aVar2.agq("openvoice");
            aVar2.jvG.apm();
            a.unInit();
        }
        ac.eol().emL();
        AppMethodBeat.o(239020);
    }
}

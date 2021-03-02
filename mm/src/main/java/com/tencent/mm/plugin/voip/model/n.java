package com.tencent.mm.plugin.voip.model;

import com.tencent.f.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.video.render.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class n {
    public static int GTO = 60;
    public static int GWS = 0;
    public static int GWT = 0;
    public static int qrK = 3;
    l GSZ = null;
    volatile c GWB = null;
    private long GWC = 0;
    private long GWD = 0;
    private int GWE = 1;
    private int GWF = 0;
    private long GWG = 0;
    private int GWH = 0;
    private int GWI = 0;
    final Object GWJ = new Object();
    public boolean GWK = false;
    public boolean GWL = false;
    public int GWM = 0;
    private int GWN = 1;
    private long GWO = 0;
    public MMHandler GWP;
    long GWQ = 0;
    private int GWR = 0;
    a GWU;
    private ByteBuffer GWV;
    volatile c qrH = null;
    public int qrL = 1;
    int qrM = 92;
    private int qrN = 1;
    public int qrP = 0;
    private int qrR = 1;
    private long qrS = 0;
    private c.a qrW = new c.a() {
        /* class com.tencent.mm.plugin.voip.model.n.AnonymousClass1 */

        @Override // com.tencent.mm.audio.b.c.a
        public final void w(byte[] bArr, int i2) {
            AppMethodBeat.i(114941);
            synchronized (n.this.GWJ) {
                try {
                    if (com.tencent.mm.plugin.audio.c.a.cea().audioManager.isMusicActive()) {
                        com.tencent.mm.audio.c.b.a.ju(1);
                    }
                    com.tencent.mm.audio.c.b.a.e(i2, bArr);
                    if (n.this.qrL == 2 && n.this.GWB != null) {
                        if (n.this.GWE == 1) {
                            n.this.GWC = System.currentTimeMillis();
                            n.this.GWD = n.this.GWC;
                            n.this.GWE = 0;
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            n.this.GWF = (int) ((currentTimeMillis - n.this.GWD) - ((long) (n.GWT * 20)));
                            n.this.GWC = currentTimeMillis;
                        }
                        if (n.this.qrM <= 10) {
                            n.this.qrM = 92;
                        }
                        n.this.qrM = ((n.this.GWB.fFq() + 24) + (n.this.qrM * 3)) / 4;
                        if (n.this.qrN == 1) {
                            n.this.GWH = n.this.GWB.fFn();
                            if (n.this.GWH >= n.this.qrM) {
                                n.this.GWH -= n.this.qrM;
                            }
                            n.this.qrM = n.this.GWH;
                            n.this.qrN = 0;
                        } else {
                            n.this.qrM = 0;
                        }
                        if (1 == n.this.qrR) {
                            n.this.qrR = 0;
                            n.this.qrS = System.currentTimeMillis();
                            e.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,first record");
                        } else {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            long j2 = currentTimeMillis2 - n.this.qrS;
                            if (j2 > 1000) {
                                e.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,error,record deltaTime:".concat(String.valueOf(j2)));
                            }
                            n.this.qrS = currentTimeMillis2;
                        }
                        if (n.this.qrH != null) {
                            n.this.GSZ.GVV.Hba = n.this.qrH.aah();
                            n.this.GSZ.GVV.recordCallback(bArr, i2, n.this.qrM);
                            n.GWT++;
                        }
                    }
                } finally {
                    AppMethodBeat.o(114941);
                }
            }
        }

        @Override // com.tencent.mm.audio.b.c.a
        public final void cj(int i2, int i3) {
        }
    };

    public n(l lVar) {
        AppMethodBeat.i(114946);
        this.GSZ = lVar;
        if (this.GWP == null || this.GWP.isQuit()) {
            this.GWP = new MMHandler("VoipDeviceHandler_stopDev");
        }
        AppMethodBeat.o(114946);
    }

    public final int fGN() {
        if (this.qrH == null || this.GSZ.GVV.Hcw.GXm != 1) {
            return 0;
        }
        return this.qrH.dyZ;
    }

    public final int fFs() {
        AppMethodBeat.i(114947);
        if (this.GWB == null || this.GSZ.GVV.Hcw.GXm != 1) {
            AppMethodBeat.o(114947);
            return 0;
        }
        int fFs = this.GWB.fFs();
        AppMethodBeat.o(114947);
        return fFs;
    }

    public final synchronized void fGO() {
        int i2;
        int i3;
        int i4 = 0;
        synchronized (this) {
            AppMethodBeat.i(114948);
            Log.i("MicroMsg.Voip.VoipDeviceHandler", "stopDev, recorder: %s", this.qrH);
            if (this.qrL == qrK) {
                e.Loge("MicroMsg.Voip.VoipDeviceHandler", "devcie stoped already.");
                fGP();
                AppMethodBeat.o(114948);
            } else {
                e.Logi("MicroMsg.Voip.VoipDeviceHandler", "stop device..");
                this.qrL = qrK;
                if (this.GWU != null) {
                    e.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
                    this.GWU.GWY = true;
                    this.GWU.cancel();
                    this.GWU = null;
                }
                this.qrN = 1;
                this.GWH = 0;
                this.qrR = 1;
                this.GWN = 1;
                this.qrS = 0;
                this.GWO = 0;
                this.qrM = 92;
                this.GWC = 0;
                this.GWD = 0;
                this.GWE = 1;
                this.GWF = 0;
                this.qrP = 0;
                this.GSZ.GVV.HaM = fGN();
                this.GSZ.GVV.HaN = fFs();
                v2protocal v2protocal = this.GSZ.GVV;
                if (this.qrH == null || this.GSZ.GVV.Hcw.GXm != 1) {
                    i2 = -2;
                } else {
                    i2 = this.qrH.aal();
                }
                v2protocal.HaQ = i2;
                v2protocal v2protocal2 = this.GSZ.GVV;
                if (this.GWB == null || this.GSZ.GVV.Hcw.GXm != 1) {
                    i3 = 0;
                } else {
                    c cVar = this.GWB;
                    Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer  mAudioPlayNum:" + cVar.GTF);
                    i3 = cVar.GTF;
                }
                v2protocal2.HaR = i3;
                v2protocal v2protocal3 = this.GSZ.GVV;
                if (this.GWB != null && this.GSZ.GVV.Hcw.GXm == 1) {
                    i4 = this.GWB.bhV();
                }
                v2protocal3.HaY = (int) ((((float) com.tencent.mm.plugin.audio.c.a.getStreamVolume(i4)) / ((float) com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(i4))) * 100.0f);
                fGP();
                AppMethodBeat.o(114948);
            }
        }
    }

    public final void fGP() {
        AppMethodBeat.i(114949);
        Log.printInfoStack("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord, recorder %s", this.qrH);
        if (this.GWP != null) {
            synchronized (this.GWJ) {
                try {
                    if (!(this.GWB == null && this.qrH == null)) {
                        Log.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord process post runnable");
                        if (this.GWP != null) {
                            this.GWP.removeCallbacksAndMessages(null);
                            this.GWP.post(new Runnable() {
                                /* class com.tencent.mm.plugin.voip.model.n.AnonymousClass4 */

                                public final void run() {
                                    AppMethodBeat.i(114944);
                                    Log.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord process post success and wait running");
                                    if (n.this.GWB != null) {
                                        n.this.GWB.fFr();
                                        n.this.GWB.fFo();
                                        n.this.GWB = null;
                                        Log.i("MicroMsg.Voip.VoipDeviceHandler", "finish stopRecord and release player");
                                    }
                                    Log.i("MicroMsg.Voip.VoipDeviceHandler", "do stopRecord");
                                    if (n.this.qrH != null) {
                                        n.this.qrH.ZZ();
                                        n.this.qrH = null;
                                        Log.i("MicroMsg.Voip.VoipDeviceHandler", "finish stopRecord and release recorder");
                                    }
                                    Log.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord process post success and quitSafely");
                                    AppMethodBeat.o(114944);
                                }
                            });
                        }
                    }
                } finally {
                    AppMethodBeat.o(114949);
                }
            }
            return;
        }
        Log.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord failed but mDevHandler is null");
        AppMethodBeat.o(114949);
    }

    private void fGQ() {
        AppMethodBeat.i(114951);
        Log.i("MicroMsg.Voip.VoipDeviceHandler", "steve: StopHWEnc!!!");
        this.GSZ.GVV.qtK = false;
        this.GWK = false;
        this.GWL = false;
        AppMethodBeat.o(114951);
    }

    public final int b(byte[] bArr, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(114952);
        if (this.qrL != 2) {
            AppMethodBeat.o(114952);
            return 0;
        } else if (!this.GSZ.fGz()) {
            AppMethodBeat.o(114952);
            return 0;
        } else {
            if (bArr.length < ((i4 * i5) * 3) / 2) {
                Log.e("MicroMsg.Voip.VoipDeviceHandler", "buffer length = %d, w = %d, h = %d\n", Integer.valueOf(bArr.length), Integer.valueOf(i4), Integer.valueOf(i5));
            }
            this.GSZ.GVV.Hcg++;
            if (this.GWL) {
                fGQ();
                if (this.GSZ.GWi) {
                    this.GSZ.adg(1);
                }
                this.GSZ.c(8, true, false, true);
                t tVar = t.GYO;
                t.fHI();
            }
            boolean z = this.GWK;
            if (!this.GSZ.GVV.qtK || this.GSZ.GVV.Hcz == null) {
                this.GWK = false;
            } else {
                this.GSZ.GVV.Hcz.DoQosSvrCtrl();
                boolean equalsIgnoreCase = this.GSZ.GVV.Hcz.ENCODING.equalsIgnoreCase("video/avc");
                if (this.GSZ.GVV.Hcz.ENCODING.equalsIgnoreCase(TPDecoderType.TP_CODEC_MIMETYPE_HEVC) || (equalsIgnoreCase && 1 == (this.GSZ.GVV.Hcz.GTN.cRsvd1 & 1) && this.GSZ.GVV.Hcz.GTN.cResolution >= 6)) {
                    this.GWK = true;
                } else {
                    this.GWK = false;
                }
            }
            if (z && !this.GWK) {
                t tVar2 = t.GYO;
                t.fHI();
            } else if (!z && this.GWK && this.GSZ.GVV.Hcz != null) {
                t tVar3 = t.GYO;
                t.fHH();
            }
            Log.d("MicroMsg.Voip.VoipDeviceHandler", "steve: put video capture in, time:" + System.currentTimeMillis() + ", len:" + i2 + ", cnt:" + this.GSZ.GVV.Hcg + ", mIsHWEncEnable:" + this.GSZ.GVV.qtK + ", mIsHWEncUsing:" + this.GWK);
            int i6 = 0;
            if (!this.GWK || this.GSZ.GVV.Hcz == null) {
                if ((this.GWM >> 8) != 0) {
                    this.GWM &= -257;
                    this.GSZ.GVW.setHWDecMode(this.GWM);
                }
                long currentTimeMillis = System.currentTimeMillis();
                i6 = this.GSZ.GVV.videoEncodeToSend(bArr, i2, i4, i5, i3);
                long currentTimeMillis2 = System.currentTimeMillis();
                i iVar = i.HnR;
                i.aO(1, currentTimeMillis2 - currentTimeMillis);
            } else {
                if (1 != (this.GWM >> 8)) {
                    this.GWM |= 256;
                    this.GSZ.GVW.setHWDecMode(this.GWM);
                }
                if (this.GSZ.GVV.Hcz != null) {
                    if (this.GSZ.GVV.Hcz.GTN.cSkipFlag == 0 || this.GWR > 10) {
                        this.GWR = 0;
                        long currentTimeMillis3 = System.currentTimeMillis();
                        int b2 = this.GSZ.GVV.Hcz.b(bArr, i4, i5, i3);
                        long currentTimeMillis4 = System.currentTimeMillis();
                        i iVar2 = i.HnR;
                        i.aO(2, currentTimeMillis4 - currentTimeMillis3);
                        if (b2 >= 0) {
                            i6 = 1;
                        } else {
                            Log.i("MicroMsg.Voip.VoipDeviceHandler", "StopHWEnc!! hw encoder error: " + b2 + "old:" + this.GSZ.GWi);
                            if (this.GSZ.GWi) {
                                this.GSZ.adg(1);
                            }
                            fGQ();
                            t tVar4 = t.GYO;
                            t.fHI();
                            this.GSZ.c(8, true, false, true);
                        }
                    } else {
                        this.GWR++;
                    }
                }
            }
            AppMethodBeat.o(114952);
            return i6;
        }
    }

    public final int b(ByteBuffer byteBuffer, int i2, int i3, int i4, int i5, int i6) {
        ByteBuffer byteBuffer2;
        int videoEncodeToSend2;
        int a2;
        AppMethodBeat.i(235611);
        if (this.qrL != 2) {
            AppMethodBeat.o(235611);
            return 0;
        } else if (!this.GSZ.fGz()) {
            AppMethodBeat.o(235611);
            return 0;
        } else {
            this.GSZ.GVV.Hcg++;
            if (this.GWL) {
                fGQ();
                if (this.GSZ.GWi) {
                    this.GSZ.adg(1);
                }
                this.GSZ.c(8, true, false, true);
                t tVar = t.GYO;
                t.fHI();
            }
            boolean z = this.GWK;
            if (!this.GSZ.GVV.qtK || this.GSZ.GVV.Hcz == null) {
                this.GWK = false;
            } else {
                this.GSZ.GVV.Hcz.DoQosSvrCtrl();
                boolean equalsIgnoreCase = this.GSZ.GVV.Hcz.ENCODING.equalsIgnoreCase("video/avc");
                if (this.GSZ.GVV.Hcz.ENCODING.equalsIgnoreCase(TPDecoderType.TP_CODEC_MIMETYPE_HEVC) || (equalsIgnoreCase && 1 == (this.GSZ.GVV.Hcz.GTN.cRsvd1 & 1) && this.GSZ.GVV.Hcz.GTN.cResolution >= 6)) {
                    this.GWK = true;
                } else {
                    this.GWK = false;
                }
            }
            if (this.GSZ.GVV.Hcz != null) {
                com.tencent.mm.plugin.voip.b.c cVar = com.tencent.mm.plugin.voip.b.c.HgQ;
                com.tencent.mm.plugin.voip.b.c.xr(!this.GWK);
            }
            if (z && !this.GWK) {
                t tVar2 = t.GYO;
                t.fHI();
            } else if (!z && this.GWK && this.GSZ.GVV.Hcz != null) {
                t tVar3 = t.GYO;
                t.fHH();
            }
            Log.d("MicroMsg.Voip.VoipDeviceHandler", "steve: put video capture in, time:" + System.currentTimeMillis() + ", len:" + i2 + ", cnt:" + this.GSZ.GVV.Hcg + ", mIsHWEncEnable:" + this.GSZ.GVV.qtK + ", mIsHWEncUsing:" + this.GWK);
            if (!this.GWK || this.GSZ.GVV.Hcz == null) {
                if ((this.GWM >> 8) != 0) {
                    this.GWM &= -257;
                    this.GSZ.GVW.setHWDecMode(this.GWM);
                }
                long currentTicks = Util.currentTicks();
                if (i6 == 2) {
                    if (this.GWV == null || this.GWV.capacity() < byteBuffer.capacity()) {
                        this.GWV = ByteBuffer.allocateDirect(byteBuffer.capacity());
                    }
                    this.GWV.clear();
                    byteBuffer.clear();
                    this.GWV.put(byteBuffer).rewind();
                    byteBuffer2 = this.GWV;
                } else {
                    byteBuffer2 = byteBuffer;
                }
                videoEncodeToSend2 = this.GSZ.GVV.videoEncodeToSend2(byteBuffer2, i2, i4, i5, i3);
                i iVar = i.HnR;
                i.aO(1, Util.ticksToNow(currentTicks));
            } else {
                if (1 != (this.GWM >> 8)) {
                    this.GWM |= 256;
                    this.GSZ.GVW.setHWDecMode(this.GWM);
                }
                if (this.GSZ.GVV.Hcz != null) {
                    long currentTicks2 = Util.currentTicks();
                    if (i6 == 1) {
                        a2 = this.GSZ.GVV.Hcz.a(byteBuffer, i4, i5, i3, false);
                    } else if (i6 == 2) {
                        a2 = 0;
                    } else {
                        a2 = this.GSZ.GVV.Hcz.a(byteBuffer, i4, i5, i3, true);
                    }
                    i iVar2 = i.HnR;
                    i.aO(2, Util.ticksToNow(currentTicks2));
                    this.GWV = null;
                    if (a2 >= 0) {
                        videoEncodeToSend2 = 1;
                    } else {
                        Log.i("MicroMsg.Voip.VoipDeviceHandler", "StopHWEnc!! hw encoder error: " + a2 + "old:" + this.GSZ.GWi);
                        if (this.GSZ.GWi) {
                            this.GSZ.adg(1);
                        }
                        fGQ();
                        t tVar4 = t.GYO;
                        t.fHI();
                        this.GSZ.c(8, true, false, true);
                        videoEncodeToSend2 = 0;
                    }
                } else {
                    videoEncodeToSend2 = 0;
                }
            }
            AppMethodBeat.o(235611);
            return videoEncodeToSend2;
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends b {
        boolean GWX = false;
        boolean GWY = false;
        byte[] GWZ = null;
        ByteBuffer GXa = null;
        int GXb = 0;

        a() {
        }

        public final void run() {
            AppMethodBeat.i(114945);
            while (n.this.qrL == 2 && !this.GWY) {
                long currentTimeMillis = System.currentTimeMillis();
                if (n.this.GSZ.fGA()) {
                    if (this.GXa == null) {
                        this.GXa = ByteBuffer.allocateDirect((n.this.GSZ.GVV.defaultWidth + 64) * (n.this.GSZ.GVV.defaultHeight + 64) * 4).order(ByteOrder.nativeOrder());
                        this.GXa.position(0);
                        this.GWZ = new byte[this.GXa.remaining()];
                        Log.i("MicroMsg.Voip.VoipDeviceHandler", "init remoteImageByteBuffer, defaultWidth:%s, defaultHeight:%s", Integer.valueOf(n.this.GSZ.GVV.defaultWidth), Integer.valueOf(n.this.GSZ.GVV.defaultHeight));
                    }
                    int i2 = 0;
                    if (this.GXa != null) {
                        this.GXa.clear();
                        i2 = n.this.GSZ.GVV.videoDecodeBB(this.GXa);
                    }
                    if (i2 == 1) {
                        this.GXb++;
                        int i3 = n.this.GSZ.GVV.field_remoteImgWidth;
                        int i4 = n.this.GSZ.GVV.field_remoteImgHeight;
                        boolean z = i3 == 0 && i4 < 3;
                        if (this.GXb % 200 == 10) {
                            Log.i("MicroMsg.Voip.VoipDeviceHandler", "steve: dec statistics: total:%d, soft:%d, size:%dx%d, HW:%b", Integer.valueOf(this.GXb), Integer.valueOf(n.this.GSZ.GVV.Hck), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z));
                        }
                        boolean z2 = false;
                        if (z) {
                            if (!this.GWX) {
                                n.this.GWM |= 1;
                                n.this.GSZ.GVW.setHWDecMode(n.this.GWM);
                                z2 = true;
                                Log.i("MicroMsg.Voip.VoipDeviceHandler", "steve: change to HW dec, restart decoder!");
                                t tVar = t.GYO;
                                t.fHF();
                            }
                            if (v2protocal.HcA != null) {
                                try {
                                    int i5 = n.this.GSZ.GVV.field_remoteImgLength;
                                    Log.d("MicroMsg.Voip.VoipDeviceHandler", "steve:video decode successfully!..len=".concat(String.valueOf(i5)));
                                    int i6 = n.this.GSZ.GVV.field_remoteImgHeight;
                                    byte[] bArr = new byte[i5];
                                    System.arraycopy(this.GXa.array(), this.GXa.arrayOffset(), bArr, 0, i5);
                                    v2protocal.HcA.f(bArr, i6, z2);
                                    Log.d("MicroMsg.Voip.VoipDeviceHandler", "steve: fill in AvcDecoder take time = " + (System.currentTimeMillis() - currentTimeMillis) + ", startTime = " + currentTimeMillis);
                                } catch (Exception e2) {
                                    Log.e("EncodeDecode", "interrupted while waiting");
                                    Log.e("MicroMsg.Voip.VoipDeviceHandler", " error:" + e2.toString());
                                }
                            }
                        } else {
                            if (this.GWX) {
                                n.this.GWM &= -2;
                                if (v2protocal.HcA != null) {
                                    v2protocal.HcA.zLw = false;
                                }
                                n.this.GSZ.GVW.setHWDecMode(n.this.GWM);
                                Log.i("MicroMsg.Voip.VoipDeviceHandler", "steve: change to SW dec");
                                t tVar2 = t.GYO;
                                t.fHG();
                            }
                            int i7 = n.this.GSZ.GVV.field_remoteImgLength;
                            if (i7 > 0 && n.this.GSZ.GVW != null) {
                                n.this.GSZ.GVV.Hck++;
                                System.arraycopy(this.GXa.array(), this.GXa.arrayOffset(), this.GWZ, 0, ((i3 * i4) * 3) / 2);
                                n.this.GSZ.GVW.e(i3, i4, this.GWZ);
                                if (n.this.GSZ.GVV.Hck % 100 == 0) {
                                    byte[] bArr2 = new byte[5];
                                    int i8 = (i3 * 33) + 33;
                                    int i9 = (i3 * 34) - 34;
                                    int i10 = ((i3 * i4) / 2) + (i3 / 2);
                                    int i11 = ((i4 - 34) * i3) + 33;
                                    int i12 = (((i4 - 34) * i3) + i3) - 34;
                                    if (this.GWZ == null || i12 >= this.GWZ.length) {
                                        Log.i("MicroMsg.Voip.VoipDeviceHandler", "steve: dec null pointer or out of memory! size:%dx%d, idx:%d,%d,%d,%d,%d, len:%d ", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(this.GWZ.length));
                                    } else {
                                        bArr2[0] = this.GWZ[i8];
                                        bArr2[1] = this.GWZ[i9];
                                        bArr2[2] = this.GWZ[i10];
                                        bArr2[3] = this.GWZ[i11];
                                        bArr2[4] = this.GWZ[i12];
                                        Log.i("MicroMsg.Voip.VoipDeviceHandler", "steve: SW dec to render: cnt:%d, size:%dx%d, outlen:%d, samples:%d,%d,%d,%d,%d", Integer.valueOf(n.this.GSZ.GVV.Hck), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i7), Byte.valueOf(bArr2[0]), Byte.valueOf(bArr2[1]), Byte.valueOf(bArr2[2]), Byte.valueOf(bArr2[3]), Byte.valueOf(bArr2[4]));
                                        Log.i("MicroMsg.Voip.VoipDeviceHandler", "steve: first 5 samples:%d,%d,%d,%d,%d", Byte.valueOf(this.GWZ[0]), Byte.valueOf(this.GWZ[1]), Byte.valueOf(this.GWZ[2]), Byte.valueOf(this.GWZ[3]), Byte.valueOf(this.GWZ[4]));
                                        int i13 = 0;
                                        for (int i14 = 0; i14 < 5; i14++) {
                                            if (bArr2[i14] == 0) {
                                                i13++;
                                            }
                                        }
                                        if (i13 >= 5) {
                                            t tVar3 = t.GYO;
                                            t.fHN();
                                        }
                                    }
                                }
                            }
                        }
                        this.GWX = z;
                    }
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e3) {
                    Log.printErrStackTrace("MicroMsg.Voip.VoipDeviceHandler", e3, "", new Object[0]);
                }
            }
            AppMethodBeat.o(114945);
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "stop_video_decode_runnable";
        }
    }

    static /* synthetic */ void o(n nVar) {
        AppMethodBeat.i(114953);
        a aVar = new a();
        e.Logi("MicroMsg.Voip.VoipDeviceHandler", "  VoipDeivceHandler.GetAudioDeviceFmt, record samplerate:" + aVar.Bry + ", framelen: " + aVar.GSV + ", ret:" + nVar.GSZ.GVV.a(aVar));
        nVar.qrH = new c(aVar.Bry, aVar.channels, 1);
        nVar.qrH.jk(aVar.GSV);
        nVar.qrH.dzC = String.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH);
        nVar.qrH.dd(true);
        nVar.qrH.aag();
        nVar.qrH.dzk = -19;
        nVar.qrH.x(1, false);
        nVar.qrH.dc(true);
        nVar.qrH.dzv = nVar.qrW;
        if (!nVar.qrH.aai() && nVar.qrH.dyZ != 13) {
            nVar.qrP = 1;
        }
        e.Logd("MicroMsg.Voip.VoipDeviceHandler", "  VoipDeivceHandler.m_iAudioDevErr:" + nVar.qrP);
        nVar.GSZ.adb(nVar.qrP);
        nVar.GSZ.GVV.Hcw.GXm = 1;
        AppMethodBeat.o(114953);
    }
}

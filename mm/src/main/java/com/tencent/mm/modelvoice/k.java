package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.os.Process;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.d;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tav.core.AssetExtension;
import java.io.InputStream;

public final class k implements d {
    private static Object juH = new Object();
    private static int juI = -1;
    private static int juJ;
    private static int juQ = 100;
    public int dzz;
    private b juA;
    private d.a juB;
    private d.b juC;
    private int juD;
    private volatile boolean juE;
    private String juF;
    private String juG;
    private int juK;
    private int juL;
    private com.tencent.mm.audio.e.b juM;
    private com.tencent.mm.audio.c.a.a juN;
    private int juO;
    private boolean juP;
    private h juR;
    private MediaPlayer.OnCompletionListener juS;
    private MediaPlayer.OnErrorListener juT;
    private a juz;
    private AudioTrack mAudioTrack;
    private String mFileName;
    public int mSampleRate;
    private volatile int mStatus;

    static /* synthetic */ void a(k kVar, String str) {
        AppMethodBeat.i(130068);
        kVar.Ra(str);
        AppMethodBeat.o(130068);
    }

    static /* synthetic */ int j(k kVar) {
        int i2 = kVar.juD;
        kVar.juD = i2 + 1;
        return i2;
    }

    static /* synthetic */ int p(k kVar) {
        int i2 = kVar.juL;
        kVar.juL = i2 + 1;
        return i2;
    }

    static {
        AppMethodBeat.i(130069);
        AppMethodBeat.o(130069);
    }

    @Override // com.tencent.mm.modelvoice.d
    public final int getStatus() {
        return this.mStatus;
    }

    public k() {
        AppMethodBeat.i(130050);
        this.juB = null;
        this.juC = null;
        this.dzz = 2;
        this.mSampleRate = 16000;
        this.mFileName = "";
        this.mStatus = 0;
        this.juD = 0;
        this.juE = false;
        this.juF = "";
        this.juG = "";
        this.juL = 0;
        this.juM = null;
        this.juO = 8;
        this.juP = true;
        this.juS = new MediaPlayer.OnCompletionListener() {
            /* class com.tencent.mm.modelvoice.k.AnonymousClass1 */

            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(130046);
                if (k.this.juA != null && k.this.juP) {
                    Log.i("MicroMsg.SilkPlayer", "silkPlayer play onCompletion abandonFocus");
                    k.this.juA.apm();
                }
                try {
                    k.this.mStatus = 0;
                    if (k.this.mAudioTrack != null) {
                        Log.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
                        k.this.mAudioTrack.stop();
                        k.this.mAudioTrack.release();
                        k.this.mAudioTrack = null;
                    }
                    AppMethodBeat.o(130046);
                } catch (Exception e2) {
                    Log.e("MicroMsg.SilkPlayer", "exception:%s", Util.stackTraceToString(e2));
                    Log.e("MicroMsg.SilkPlayer", "setCompletion File[" + k.this.mFileName + "] ErrMsg[" + e2.getStackTrace() + "]");
                    AppMethodBeat.o(130046);
                }
            }
        };
        this.juT = new MediaPlayer.OnErrorListener() {
            /* class com.tencent.mm.modelvoice.k.AnonymousClass2 */

            public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                AppMethodBeat.i(130047);
                Log.i("MicroMsg.SilkPlayer", "onError");
                if (k.this.juA != null && k.this.juP) {
                    k.this.juA.apm();
                }
                if (k.this.juC != null) {
                    k.this.juC.onError();
                }
                try {
                    k.this.mStatus = -1;
                    if (k.this.mAudioTrack != null) {
                        Log.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
                        k.this.mAudioTrack.stop();
                        k.this.mAudioTrack.release();
                        k.this.mAudioTrack = null;
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.SilkPlayer", "setErrorListener File[" + k.this.mFileName + "] ErrMsg[" + e2.getStackTrace() + "]");
                }
                AppMethodBeat.o(130047);
                return false;
            }
        };
        juI++;
        this.juK = juI;
        Log.i("MicroMsg.SilkPlayer", "[%d] new Instance", Integer.valueOf(this.juK));
        AppMethodBeat.o(130050);
    }

    public k(Context context) {
        this();
        AppMethodBeat.i(130051);
        this.juA = new b(context);
        AppMethodBeat.o(130051);
    }

    @Override // com.tencent.mm.modelvoice.d
    public final void a(d.a aVar) {
        this.juB = aVar;
    }

    @Override // com.tencent.mm.modelvoice.d
    public final void a(d.b bVar) {
        this.juC = bVar;
    }

    @Override // com.tencent.mm.modelvoice.d
    public final void cU(boolean z) {
        AppMethodBeat.i(130052);
        Log.d("MicroMsg.SilkPlayer", "setSpeakerOn: %b", Boolean.valueOf(z));
        this.juE = true;
        this.dzz = 2;
        fT(z);
        try {
            this.mAudioTrack.play();
        } catch (Exception e2) {
            h.INSTANCE.idkeyStat(161, 0, 1, false);
            h.INSTANCE.idkeyStat(161, 3, 1, false);
            Log.e("MicroMsg.SilkPlayer", "audioTrack error:%s", e2.getMessage());
        }
        this.juE = false;
        AppMethodBeat.o(130052);
    }

    private void fT(boolean z) {
        AppMethodBeat.i(130053);
        if (this.mAudioTrack != null) {
            Log.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
            try {
                this.mAudioTrack.stop();
                this.mAudioTrack.release();
            } catch (Exception e2) {
                Log.e("MicroMsg.SilkPlayer", "mAudioTrack.stop() error: %s", e2.getMessage());
            }
            this.mAudioTrack = null;
        }
        this.mAudioTrack = com.tencent.mm.audio.c.a.a(z, this.mSampleRate, this.dzz, this.juO);
        if (this.mAudioTrack == null || this.mAudioTrack.getState() == 0) {
            h.INSTANCE.idkeyStat(161, 0, 1, false);
            h.INSTANCE.idkeyStat(161, 2, 1, false);
            try {
                if (this.mAudioTrack != null) {
                    this.mAudioTrack.release();
                    this.mAudioTrack = null;
                }
                AppMethodBeat.o(130053);
                return;
            } catch (Exception e3) {
            }
        }
        AppMethodBeat.o(130053);
    }

    @Override // com.tencent.mm.modelvoice.d
    public final boolean c(String str, boolean z, int i2) {
        AppMethodBeat.i(130055);
        boolean X = X(str, z);
        AppMethodBeat.o(130055);
        return X;
    }

    private boolean X(String str, boolean z) {
        boolean fU;
        int i2;
        int i3 = 2;
        AppMethodBeat.i(130056);
        if (this.mStatus != 0) {
            Log.e("MicroMsg.SilkPlayer", "startPlay error status:" + this.mStatus);
            AppMethodBeat.o(130056);
            return false;
        }
        if (ac.jPi) {
            bD(str, g.dAb);
        }
        Log.i("MicroMsg.SilkPlayer", "startPlay");
        this.mStatus = 1;
        this.mFileName = str;
        synchronized (juH) {
            try {
                Ra(str);
            } catch (Throwable th) {
                AppMethodBeat.o(130056);
                throw th;
            }
        }
        if (ac.jPi) {
            String str2 = g.dAa;
            if (this.dzz == 2) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            this.juM = new com.tencent.mm.audio.e.b(str2, i2, this.mSampleRate);
        }
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.mSampleRate);
        if (this.dzz == 2) {
            i3 = 1;
        }
        objArr[1] = Integer.valueOf(i3);
        Log.d("MicroMsg.SilkPlayer", "startPlay, sampleRate: %d, channelCnt: %d ", objArr);
        try {
            fU = fU(z);
        } catch (Exception e2) {
            try {
                fU = fU(true);
            } catch (Exception e3) {
                Log.e("MicroMsg.SilkPlayer", "startPlay File[" + this.mFileName + "] failed");
                Log.e("MicroMsg.SilkPlayer", "exception:%s", Util.stackTraceToString(e2));
                this.mStatus = -1;
                AppMethodBeat.o(130056);
                return false;
            }
        }
        AppMethodBeat.o(130056);
        return fU;
    }

    private void Ra(String str) {
        int a2;
        AppMethodBeat.i(130057);
        juJ = this.juK;
        Log.i("MicroMsg.SilkPlayer", "[%d] SilkDecInit", Integer.valueOf(this.juK));
        try {
            InputStream openRead = s.openRead(str);
            int available = openRead.available();
            Log.d("MicroMsg.SilkPlayer", "SilkDecInit streamlen:%d", Integer.valueOf(available));
            int minBufferSize = AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2) * 2;
            if (!com.tencent.mm.plugin.audio.c.a.ceb() || available >= minBufferSize) {
                this.juO = 8;
            } else {
                this.juO = 1;
            }
            byte[] bArr = new byte[available];
            openRead.read(bArr, 0, available);
            this.mSampleRate = MediaRecorder.SilkGetEncSampleRate(new byte[]{bArr[0]}, MediaRecorder.juf);
            if (this.juR != null) {
                Log.i("MicroMsg.SilkPlayer", "silkdec uninit success: %d".concat(String.valueOf(MediaRecorder.SilkDecUnInit(this.juR.decodeHandle))));
            }
            this.juR = new h(this.mSampleRate, bArr, available);
            int i2 = -1;
            c Fu = com.tencent.mm.model.c.d.aXu().Fu("100268");
            if (Fu.isValid()) {
                i2 = Util.getInt(Fu.gzz().get("SilkAudioPlayerAgcOn"), 0);
            }
            if (1 == i2 || i2 == 0) {
                MediaRecorder.SetVoiceSilkDecControl(juQ, new byte[]{(byte) i2}, 1, this.juR.decodeHandle);
            }
            openRead.close();
        } catch (Exception e2) {
            h.INSTANCE.idkeyStat(161, 0, 1, false);
            h.INSTANCE.idkeyStat(161, 1, 1, false);
            Log.e("MicroMsg.SilkPlayer", "exception:%s", Util.stackTraceToString(e2));
        }
        Log.d("MicroMsg.SilkPlayer", "[%d] skip %d frames", Integer.valueOf(this.juK), Integer.valueOf(this.juL));
        byte[] bArr2 = new byte[(AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2) * 2)];
        short s = (short) ((this.mSampleRate * 20) / 1000);
        for (int i3 = 0; i3 < this.juL; i3++) {
            if (this.juR != null && (a2 = this.juR.a(bArr2, s)) <= 0) {
                Log.e("MicroMsg.SilkPlayer", "[%d], skip frame failed: %d", Integer.valueOf(this.juK), Integer.valueOf(a2));
                AppMethodBeat.o(130057);
                return;
            }
        }
        AppMethodBeat.o(130057);
    }

    private boolean fU(boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(130058);
        if (!s.YS(this.mFileName)) {
            AppMethodBeat.o(130058);
        } else {
            try {
                fT(z);
                this.juN = new com.tencent.mm.audio.c.a.a();
                if (this.mAudioTrack != null) {
                    if (this.juA != null && this.juP) {
                        this.juA.requestFocus();
                    }
                    z2 = bhU();
                    AppMethodBeat.o(130058);
                }
            } catch (Exception e2) {
                if (this.juA != null && this.juP) {
                    this.juA.apm();
                }
                Log.e("MicroMsg.SilkPlayer", "playImp : fail, exception = " + e2.getMessage());
                Log.e("MicroMsg.SilkPlayer", "exception:%s", Util.stackTraceToString(e2));
            }
            AppMethodBeat.o(130058);
        }
        return z2;
    }

    private boolean bhU() {
        AppMethodBeat.i(130059);
        if (this.mAudioTrack != null) {
            try {
                Log.i("MicroMsg.SilkPlayer", AssetExtension.SCENE_PLAY);
                this.mAudioTrack.play();
                this.juz = new a(this, (byte) 0);
                com.tencent.f.h.RTc.aX(this.juz);
                AppMethodBeat.o(130059);
                return true;
            } catch (Exception e2) {
                Log.e("MicroMsg.SilkPlayer", "audioTrack error:%s", e2.getMessage());
                h.INSTANCE.idkeyStat(161, 0, 1, false);
                h.INSTANCE.idkeyStat(161, 3, 1, false);
                AppMethodBeat.o(130059);
                return false;
            }
        } else {
            AppMethodBeat.o(130059);
            return false;
        }
    }

    public final int bhV() {
        AppMethodBeat.i(130060);
        if (this.mAudioTrack != null) {
            int streamType = this.mAudioTrack.getStreamType();
            AppMethodBeat.o(130060);
            return streamType;
        }
        AppMethodBeat.o(130060);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public class a extends com.tencent.f.i.b {
        private a() {
        }

        /* synthetic */ a(k kVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(130049);
            try {
                Process.setThreadPriority(-16);
                int minBufferSize = AudioTrack.getMinBufferSize(k.this.mSampleRate, 2, 2) * 2;
                byte[] bArr = new byte[minBufferSize];
                short s = (short) ((k.this.mSampleRate * 20) / 1000);
                Log.d("MicroMsg.SilkPlayer", "frameLen: %d, playBufferSize: %d", Short.valueOf(s), Integer.valueOf(minBufferSize));
                Log.i("MicroMsg.SilkPlayer", "Thread start");
                while (true) {
                    if (k.this.mStatus != 1 && k.this.mStatus != 2) {
                        break;
                    }
                    synchronized (k.juH) {
                        try {
                            if (k.juJ != k.this.juK) {
                                Log.i("MicroMsg.SilkPlayer", "[%d] diff id, useDeocder: %d", Integer.valueOf(k.this.juK), Integer.valueOf(k.juJ));
                                k.j(k.this);
                                if (k.this.juD > 3) {
                                    h.INSTANCE.idkeyStat(161, 17, 1, false);
                                }
                                k.a(k.this, k.this.mFileName);
                            }
                        } finally {
                            AppMethodBeat.o(130049);
                        }
                    }
                    while (k.this.juE) {
                        Log.d("MicroMsg.SilkPlayer", "waitting for switching complete");
                        Thread.sleep(20);
                    }
                    if (k.this.juR != null) {
                        if (k.this.juN != null) {
                            k.this.juN.e(s, bArr);
                            k.this.juN.ck(0, (com.tencent.mm.plugin.audio.c.a.cea().audioManager.getStreamVolume(k.this.bhV()) * 100) / com.tencent.mm.plugin.audio.c.a.cea().audioManager.getStreamMaxVolume(k.this.bhV()));
                        }
                        int a2 = k.this.juR.a(bArr, s);
                        if (a2 < 0) {
                            k.this.mStatus = 0;
                            h.INSTANCE.idkeyStat(161, 0, 1, false);
                            h.INSTANCE.idkeyStat(161, 4, 1, false);
                            Log.e("MicroMsg.SilkPlayer", "[%d] SilkDoDec failed: %d", Integer.valueOf(k.this.juK), Integer.valueOf(a2));
                            if (k.this.juM != null && ac.jPi) {
                                k.this.juM.closeFile();
                            }
                        } else {
                            if (ac.jPi && k.this.juM != null) {
                                k.this.juM.A(bArr, s * 2);
                            }
                            try {
                                k.this.mAudioTrack.write(bArr, 0, s * 2);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.SilkPlayer", "write audio track failed: %s", e2.getMessage());
                                h.INSTANCE.idkeyStat(161, 0, 1, false);
                                h.INSTANCE.idkeyStat(161, 5, 1, false);
                            }
                            k.p(k.this);
                            if (a2 == 0) {
                                k.this.mStatus = 0;
                                Log.i("MicroMsg.SilkPlayer", "[%d] play completed", Integer.valueOf(k.this.juK));
                                if (k.this.juM != null && ac.jPi) {
                                    k.this.juM.closeFile();
                                    MMHandlerThread.postToMainThread(new Runnable() {
                                        /* class com.tencent.mm.modelvoice.k.a.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(130048);
                                            Toast.makeText(MMApplicationContext.getContext(), "Save to: " + k.this.juM.mFilePath, 1).show();
                                            AppMethodBeat.o(130048);
                                        }
                                    });
                                }
                            } else if (k.this.mStatus == 2) {
                                synchronized (k.this.juG) {
                                    try {
                                        Log.i("MicroMsg.SilkPlayer", "before mOk.notify");
                                        k.this.juG.notifyAll();
                                        Log.i("MicroMsg.SilkPlayer", "after mOk.notify");
                                    } catch (Exception e3) {
                                        Log.e("MicroMsg.SilkPlayer", "exception:%s", Util.stackTraceToString(e3));
                                    }
                                    try {
                                    } finally {
                                        AppMethodBeat.o(130049);
                                    }
                                }
                                synchronized (k.this.juF) {
                                    try {
                                        Log.i("MicroMsg.SilkPlayer", "before mpause.wait");
                                        k.this.juF.wait();
                                        Log.i("MicroMsg.SilkPlayer", "after mpause.wait");
                                    } catch (Exception e4) {
                                        Log.e("MicroMsg.SilkPlayer", "exception:%s", Util.stackTraceToString(e4));
                                    }
                                    try {
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            } else {
                                synchronized (k.this.juG) {
                                    try {
                                        k.this.juG.notifyAll();
                                    } catch (Exception e5) {
                                        Log.e("MicroMsg.SilkPlayer", "exception:%s", Util.stackTraceToString(e5));
                                    }
                                    try {
                                    } catch (Throwable th2) {
                                        AppMethodBeat.o(130049);
                                        throw th2;
                                    }
                                }
                            }
                        }
                    } else {
                        k.this.mStatus = 0;
                        Log.e("MicroMsg.SilkPlayer", "[%d] SilkDoDec failed. data == null ", Integer.valueOf(k.this.juK));
                        if (k.this.juM != null && ac.jPi) {
                            k.this.juM.closeFile();
                        }
                    }
                }
                if (k.this.mStatus != 3 && k.this.mAudioTrack.getPlayState() == 3) {
                    Thread.sleep(1000);
                }
            } catch (Exception e6) {
                h.INSTANCE.idkeyStat(161, 0, 1, false);
                Log.e("MicroMsg.SilkPlayer", "exception:%s", Util.stackTraceToString(e6));
                if (k.this.juT != null) {
                    k.this.juT.onError(null, 0, 0);
                }
                k.this.mStatus = 0;
            }
            synchronized (k.juH) {
                try {
                    if (k.juJ == k.this.juK && k.this.juR != null) {
                        MediaRecorder.SilkDecUnInit(k.this.juR.decodeHandle);
                        Log.i("MicroMsg.SilkPlayer", "[%d] SilkDecUnInit", Integer.valueOf(k.this.juK));
                        int unused = k.juJ = -1;
                        k.this.juD = 0;
                    }
                } finally {
                    AppMethodBeat.o(130049);
                }
            }
            if (k.this.mStatus != 3) {
                if (k.this.juB != null) {
                    k.this.juB.onCompletion();
                }
                if (k.this.juS != null) {
                    k.this.juS.onCompletion(null);
                }
            } else if (k.this.mAudioTrack != null) {
                Log.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
                try {
                    k.this.mAudioTrack.stop();
                    k.this.mAudioTrack.release();
                    k.this.mAudioTrack = null;
                } catch (Exception e7) {
                    Log.e("MicroMsg.SilkPlayer", "mAudioTrack.stop() error: %s", e7.getMessage());
                }
            }
            if (k.this.juN != null) {
                k.this.juN.b(0, k.this.mFileName, k.this.bhV());
                k.this.juN.jm(0);
                k.this.juN.jn(0);
                k.this.juN.jo(0);
            }
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            AppMethodBeat.i(200987);
            String str = "SilkPlayer_play_" + k.this.juK;
            AppMethodBeat.o(200987);
            return str;
        }
    }

    @Override // com.tencent.mm.modelvoice.d
    public final boolean da(boolean z) {
        AppMethodBeat.i(130061);
        if (this.mStatus != 1) {
            AppMethodBeat.o(130061);
            return false;
        }
        this.mStatus = 2;
        synchronized (this.juG) {
            try {
                Log.i("MicroMsg.SilkPlayer", "before mOk.wait");
                long currentTimeMillis = System.currentTimeMillis();
                this.juG.wait(1000);
                Log.i("MicroMsg.SilkPlayer", "after mOk.wait time:" + (System.currentTimeMillis() - currentTimeMillis));
                try {
                } finally {
                    AppMethodBeat.o(130061);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.SilkPlayer", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(130061);
                return false;
            }
        }
        if (this.juA != null && z) {
            this.juA.apm();
        }
        return true;
    }

    @Override // com.tencent.mm.modelvoice.d
    public final boolean resume() {
        AppMethodBeat.i(130062);
        if (this.mStatus != 2) {
            AppMethodBeat.o(130062);
            return false;
        }
        this.mStatus = 1;
        synchronized (this.juF) {
            try {
                Log.i("MicroMsg.SilkPlayer", "before mpause.notify");
                this.juF.notifyAll();
                Log.i("MicroMsg.SilkPlayer", "after mpause.notify");
                try {
                } finally {
                    AppMethodBeat.o(130062);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.SilkPlayer", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(130062);
                return false;
            }
        }
        if (this.juA != null && this.juP) {
            this.juA.requestFocus();
        }
        return true;
    }

    @Override // com.tencent.mm.modelvoice.d
    public final boolean isPlaying() {
        boolean z;
        AppMethodBeat.i(200988);
        Object[] objArr = new Object[3];
        if (this.mStatus == 1) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = this.juz;
        objArr[2] = Boolean.valueOf(this.juz == null || this.juz.isDone());
        Log.i("MicroMsg.SilkPlayer", "isPlaying %s and mPlayRunnable is %s && mPlayRunnable is done %s", objArr);
        if (this.mStatus == 1 || !(this.mStatus == 1 || this.juz == null || this.juz.isDone())) {
            AppMethodBeat.o(200988);
            return true;
        }
        AppMethodBeat.o(200988);
        return false;
    }

    @Override // com.tencent.mm.modelvoice.d
    public final boolean Qt() {
        AppMethodBeat.i(130063);
        Log.i("MicroMsg.SilkPlayer", "stop  status:" + this.mStatus);
        if (this.mStatus == 1 || this.mStatus == 2) {
            this.mStatus = 3;
            synchronized (this.juF) {
                try {
                    this.juF.notifyAll();
                    try {
                        if (this.juA != null && this.juP) {
                            this.juA.apm();
                        }
                    } finally {
                        AppMethodBeat.o(130063);
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.SilkPlayer", "exception:%s", Util.stackTraceToString(e2));
                    if (this.juA != null && this.juP) {
                        this.juA.apm();
                    }
                    AppMethodBeat.o(130063);
                    return false;
                } catch (Throwable th) {
                    if (this.juA != null && this.juP) {
                        this.juA.apm();
                    }
                    AppMethodBeat.o(130063);
                    throw th;
                }
            }
            return true;
        }
        Log.e("MicroMsg.SilkPlayer", "stop  error status:" + this.mStatus);
        AppMethodBeat.o(130063);
        return false;
    }

    @Override // com.tencent.mm.modelvoice.d
    public final double ZY() {
        return 0.0d;
    }

    @Override // com.tencent.mm.modelvoice.d
    public final void c(b.a aVar) {
        AppMethodBeat.i(130064);
        if (!(aVar == null || this.juA == null)) {
            this.juA.a(aVar);
        }
        AppMethodBeat.o(130064);
    }

    @Override // com.tencent.mm.modelvoice.d
    public final void bhQ() {
        this.juP = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x00a1 A[SYNTHETIC, Splitter:B:14:0x00a1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String bD(java.lang.String r12, java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 183
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.k.bD(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x009d A[SYNTHETIC, Splitter:B:19:0x009d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.lang.String r13, com.tencent.mm.modelvoice.h r14) {
        /*
        // Method dump skipped, instructions count: 321
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.k.a(java.lang.String, com.tencent.mm.modelvoice.h):java.lang.String");
    }

    private static boolean Rb(String str) {
        AppMethodBeat.i(130067);
        if (str == null) {
            AppMethodBeat.o(130067);
            return false;
        }
        try {
            int lastIndexOf = str.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP);
            if (lastIndexOf == -1) {
                Log.w("MicroMsg.SilkPlayer", "ensureFileFloder end == -1");
                AppMethodBeat.o(130067);
                return false;
            }
            String substring = str.substring(0, lastIndexOf + 1);
            o oVar = new o(substring);
            if (!oVar.exists()) {
                Log.i("MicroMsg.SilkPlayer", "ensureFileFloder mkdir:%s,sucess:%s", substring, Boolean.valueOf(oVar.mkdirs() || oVar.isDirectory()));
            }
            AppMethodBeat.o(130067);
            return true;
        } catch (Exception e2) {
            Log.w("MicroMsg.SilkPlayer", "ensureFileFloder Exception:", e2.getMessage());
            AppMethodBeat.o(130067);
            return false;
        }
    }
}

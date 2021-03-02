package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.c;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.a.f;
import com.tencent.mm.plugin.mmsight.model.c;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.s;
import com.tencent.rtmp.TXLiveConstants;
import java.io.ByteArrayOutputStream;

public final class o implements d {
    protected int bufId;
    protected boolean htU = false;
    protected Point ilV = null;
    protected boolean iqo = false;
    protected float irA = 0.0f;
    private int irB = -1;
    private float irC = -1.0f;
    protected c irD;
    protected int irF = 480;
    protected int irG = 640;
    protected int irH = 1600000;
    protected int irI = 480;
    protected int irJ = 640;
    protected t irK;
    protected int irL;
    protected String irN = null;
    protected boolean irO = false;
    protected String irP = null;
    protected boolean irQ = false;
    protected c irR = new c("yuvRecorderWriteData");
    protected c irS = new c("frameCountCallback");
    protected VideoTransPara irT;
    protected n irU;
    protected boolean irV = false;
    protected int irW = 0;
    protected d.a irX;
    protected Runnable irY = null;
    protected boolean irZ = false;
    private final Object irx = new Object();
    protected String iry = "";
    protected int irz = 0;
    protected boolean isQ = false;
    protected boolean isa = true;
    protected boolean isb = false;
    protected g iss = new g() {
        /* class com.tencent.mm.plugin.mmsight.model.a.o.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.mmsight.model.g
        public final boolean ai(byte[] bArr) {
            AppMethodBeat.i(89541);
            if (bArr == null || bArr.length <= 0) {
                Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preview callback data is null");
                AppMethodBeat.o(89541);
                return false;
            } else if (o.this.irK.zwJ == d.c.Start || o.this.irK.zwJ == d.c.PrepareStop) {
                if (o.this.irK.zwJ == d.c.PrepareStop) {
                    o.this.irK.zwJ = d.c.WaitStop;
                    Log.v("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "forward one more frame");
                }
                o.this.irS.Hi(1);
                if (o.this.irD != null) {
                    o.this.irD.ejW();
                }
                o.this.bI(bArr);
                AppMethodBeat.o(89541);
                return true;
            } else {
                AppMethodBeat.o(89541);
                return false;
            }
        }
    };
    protected String mFileName;
    protected String md5 = "";
    protected String thumbPath = null;
    protected volatile r zwp;
    protected HandlerThread zwq;
    protected MMHandler zwr;
    protected int zws = 0;

    public o(VideoTransPara videoTransPara) {
        AppMethodBeat.i(89551);
        this.irT = videoTransPara;
        this.irF = videoTransPara.width;
        this.irG = videoTransPara.height;
        this.irH = videoTransPara.videoBitrate;
        l.ekc();
        int eke = l.eke();
        if (eke == -1) {
            this.irH = videoTransPara.videoBitrate;
        } else {
            this.irH = eke;
        }
        this.irK = new t();
        Log.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "create MMSightMediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s", Integer.valueOf(this.irF), Integer.valueOf(this.irG), Integer.valueOf(this.irH));
        AppMethodBeat.o(89551);
    }

    private boolean rB(int i2) {
        AppMethodBeat.i(89552);
        long currentTicks = Util.currentTicks();
        this.isQ = k.zuy.isQ;
        this.bufId = SightVideoJNI.initDataBufferForMMSightLock(this.irI, this.irJ, i2, this.irF, this.irG, (float) this.irT.fps, this.irH, this.irT.iSV, 8, this.irT.iSU, 23.0f, false, false, this.irT.duration, false);
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init, bufId: %s", Integer.valueOf(this.bufId));
        if (this.bufId < 0) {
            Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init failed!");
            l.ejL();
            AppMethodBeat.o(89552);
            return false;
        }
        this.irL = i2;
        this.zwp = new r(this.irI, this.irJ, this.irF, this.irG, this.irH, this.irT.iiH, this.irT.fps, this.isQ);
        int ha = this.zwp.ha(this.bufId, i2);
        int i3 = 0;
        if (!this.isb) {
            int i4 = -1;
            if (CaptureMMProxy.getInstance() != null) {
                i4 = CaptureMMProxy.getInstance().getInt(ar.a.USERINFO_LOCAL_SIGHT_AUDIO_RECORDER_TYPE_INT_SYNC, -1);
            }
            if (i4 < 0) {
                this.irD = new g(this.irT.audioSampleRate, this.irT.audioBitrate, this.irT.audioChannelCount, b.ak(false, this.irT.iTs == 1));
                this.irD.rc(this.irZ);
                int H = this.irD.H(this.bufId, e.aNv(this.iry));
                if (ha < 0 || H < 0) {
                    Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", Integer.valueOf(ha), Integer.valueOf(H));
                    if (H < 0 && ha >= 0) {
                        Log.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac init error, try mediarecorder now");
                        this.irD.clear();
                        this.irD = new i(this.irT.audioSampleRate, this.irT.audioBitrate, this.irT.audioChannelCount);
                        this.irD.rc(this.irZ);
                        int H2 = this.irD.H(this.bufId, e.aNv(this.iry));
                        Log.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "MMSightAACMediaRecorder init ret: %s", Integer.valueOf(H2));
                        if (H2 >= 0) {
                            AppMethodBeat.o(89552);
                            return true;
                        }
                    }
                    SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
                    l.ejL();
                    AppMethodBeat.o(89552);
                    return false;
                }
            } else {
                if (i4 == 1) {
                    this.irD = new g(this.irT.audioSampleRate, this.irT.audioBitrate, this.irT.audioChannelCount, b.ak(false, this.irT.iTs == 1));
                    this.irD.rc(this.irZ);
                    i3 = this.irD.H(this.bufId, e.aNv(this.iry));
                } else if (i4 == 2) {
                    this.irD = new i(this.irT.audioSampleRate, this.irT.audioBitrate, this.irT.audioChannelCount);
                    this.irD.rc(this.irZ);
                    i3 = this.irD.H(this.bufId, e.aNv(this.iry));
                }
                if (ha < 0 || i3 < 0) {
                    Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", Integer.valueOf(ha), Integer.valueOf(i3));
                    SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
                    l.ejL();
                    AppMethodBeat.o(89552);
                    return false;
                }
            }
        } else if (ha < 0) {
            Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mute init yuv recorder error!! %d %d", Integer.valueOf(ha), 0);
            SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
            l.ejL();
            AppMethodBeat.o(89552);
            return false;
        }
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(89552);
        return true;
    }

    /* access modifiers changed from: protected */
    public final void bI(byte[] bArr) {
        AppMethodBeat.i(89553);
        if (this.zwp != null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = bArr;
            if (this.zwr != null) {
                this.zwr.sendMessage(obtain);
            }
        }
        AppMethodBeat.o(89553);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final boolean rC(int i2) {
        AppMethodBeat.i(89554);
        if (!this.htU) {
            Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preInit, cameraOrientation");
            boolean rB = rB(i2);
            this.htU = true;
            Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl result: %s", Boolean.valueOf(rB));
            AppMethodBeat.o(89554);
            return rB;
        }
        AppMethodBeat.o(89554);
        return true;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final int b(int i2, boolean z, int i3) {
        int i4 = -1;
        AppMethodBeat.i(89555);
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3));
        this.irR.reset();
        this.irz = 0;
        this.irS.reset();
        this.irO = false;
        this.iqo = z;
        this.irW = i3;
        this.irK.a(d.c.WaitStart);
        if (Util.isNullOrNil(this.iry)) {
            Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start error, mCurRecordPath is null!!");
            AppMethodBeat.o(89555);
        } else {
            try {
                this.mFileName = s.bpb(this.iry);
                String boZ = s.boZ(this.iry);
                if (!boZ.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                    boZ = boZ + FilePathGenerator.ANDROID_DIR_SEP;
                }
                this.irN = boZ + "tempRotate.mp4";
            } catch (Exception e2) {
                Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "retrieve file name error: %s", e2.getMessage());
            }
            Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", this.iry, this.irN);
            this.irL = i2;
            this.zwq = com.tencent.f.c.d.hB("BigSightMediaCodecMP4MuxRecorder_writeYuvData_" + hashCode(), -1);
            this.zwq.start();
            this.zwr = new MMHandler(this.zwq.getLooper()) {
                /* class com.tencent.mm.plugin.mmsight.model.a.o.AnonymousClass2 */

                @Override // com.tencent.mm.sdk.platformtools.MMHandler
                public final void handleMessage(Message message) {
                    byte[] bArr;
                    AppMethodBeat.i(89542);
                    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "carson：writeYuvData ");
                    if (!(message.what != 1 || (bArr = (byte[]) message.obj) == null || o.this.zwp == null)) {
                        o.a(o.this, bArr);
                    }
                    AppMethodBeat.o(89542);
                }
            };
            if (!this.htU) {
                rB(i2);
                this.htU = true;
            }
            if (this.isb || this.irZ) {
                Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start yuvRecorder with mute");
                this.zwp.start();
                this.irK.a(d.c.Start);
                this.irV = false;
                l.ejJ();
                l.aNB();
                i4 = 0;
            } else {
                i4 = this.irD.a(new c.a() {
                    /* class com.tencent.mm.plugin.mmsight.model.a.o.AnonymousClass3 */

                    @Override // com.tencent.mm.plugin.mmsight.model.a.c.a
                    public final void aQY() {
                        AppMethodBeat.i(89543);
                        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "onPcmReady");
                        if (o.this.aQN() != d.c.Initialized) {
                            Log.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
                            AppMethodBeat.o(89543);
                            return;
                        }
                        o.this.zwp.start();
                        o.this.irK.a(d.c.Start);
                        AppMethodBeat.o(89543);
                    }
                });
                Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start aacRecorder ret: %s", Integer.valueOf(i4));
                this.irV = false;
                if (i4 != 0) {
                    this.irK.a(d.c.Error);
                } else {
                    this.irK.a(d.c.Initialized);
                }
                l.ejJ();
                l.aNB();
            }
            AppMethodBeat.o(89555);
        }
        return i4;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void E(Runnable runnable) {
        AppMethodBeat.i(89556);
        this.irY = runnable;
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", runnable);
        if (this.zwp == null || (this.irD == null && !this.isb)) {
            Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
            if (runnable != null) {
                MMHandlerThread.postToMainThread(runnable);
            }
            AppMethodBeat.o(89556);
        } else if (this.irK == null || this.irK.zwJ != d.c.Stop) {
            this.iss = null;
            this.irz = (int) this.zwp.aMm();
            if (this.irK != null) {
                this.irK.a(d.c.PrepareStop);
            }
            if (this.zwp != null) {
                this.zwp.a(new f.a() {
                    /* class com.tencent.mm.plugin.mmsight.model.a.o.AnonymousClass4 */

                    @Override // com.tencent.mm.plugin.mmsight.model.a.f.a
                    public final void ejZ() {
                        AppMethodBeat.i(89544);
                        ThreadPool.post(new Runnable() {
                            /* class com.tencent.mm.plugin.mmsight.model.a.o.AnonymousClass6 */

                            public final void run() {
                                AppMethodBeat.i(89547);
                                boolean aQI = o.this.aQI();
                                Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stopImpl result: %s", Boolean.valueOf(aQI));
                                if (!aQI) {
                                    SightVideoJNI.releaseBigSightDataBufferLock(o.this.bufId);
                                    if (o.this.irX != null) {
                                        MMHandlerThread.postToMainThread(new Runnable() {
                                            /* class com.tencent.mm.plugin.mmsight.model.a.o.AnonymousClass6.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(89546);
                                                o.this.irX.bqP();
                                                AppMethodBeat.o(89546);
                                            }
                                        });
                                    }
                                } else if (o.this.irY != null) {
                                    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "call stopCallback");
                                    MMHandlerThread.postToMainThread(o.this.irY);
                                    AppMethodBeat.o(89547);
                                    return;
                                }
                                AppMethodBeat.o(89547);
                            }
                        }, "MMSightMediaCodecMP4MuxRecorder_stop");
                        AppMethodBeat.o(89544);
                    }
                });
            }
            if (this.irD != null) {
                this.irD.a(new c.b() {
                    /* class com.tencent.mm.plugin.mmsight.model.a.o.AnonymousClass5 */

                    @Override // com.tencent.mm.plugin.mmsight.model.a.c.b
                    public final void aQX() {
                        AppMethodBeat.i(89545);
                        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac stop finish");
                        AppMethodBeat.o(89545);
                    }
                });
            }
            AppMethodBeat.o(89556);
        } else {
            Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, already in stop status");
            if (this.irD != null) {
                this.irD.clear();
            }
            if (this.zwp != null) {
                this.zwp.clear();
            }
            if (runnable != null) {
                MMHandlerThread.postToMainThread(runnable);
            }
            AppMethodBeat.o(89556);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean aQI() {
        int i2;
        AppMethodBeat.i(89557);
        long currentTicks = Util.currentTicks();
        if (!(this.zwq == null || this.zwr == null)) {
            if (com.tencent.mm.compatible.util.d.oD(18)) {
                this.zwq.quitSafely();
            } else {
                this.zwq.quit();
            }
            this.zwr = null;
        }
        int i3 = this.zwp.frameCount;
        this.irA = (((float) i3) * 1000.0f) / ((float) this.irz);
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", Integer.valueOf(i3), Float.valueOf(this.irA), Integer.valueOf(this.irz), this.iry, Long.valueOf(Util.ticksToNow(currentTicks)), Integer.valueOf(this.irB), Float.valueOf(this.irC));
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "frameCountCallback %s", this.irS.getValue());
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "yuvRecorderWriteDataCallback %s", this.irR.getValue());
        String str = null;
        if (CaptureMMProxy.getInstance() != null) {
            str = CaptureMMProxy.getInstance().getAccVideoPath();
        } else if (!Util.isNullOrNil(this.iry)) {
            str = aa.z(new com.tencent.mm.vfs.o(this.iry).heq().her());
        }
        String aFk = !Util.isNullOrNil(str) ? com.tencent.mm.plugin.mmsight.d.aFk(str) : this.iry;
        int i4 = this.irz;
        if (this.irB > 0) {
            i4 = this.irB;
        }
        float f2 = this.irA;
        if (this.irC > 0.0f) {
            f2 = this.irC;
        }
        this.irU = new n(this.bufId, aFk, f2, this.irH, i4, this.irT.audioSampleRate, this.isb, false, false);
        long currentTicks2 = Util.currentTicks();
        boolean ejY = this.irU.ejY();
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux used %sms, success: %s", Long.valueOf(Util.ticksToNow(currentTicks2)), Boolean.valueOf(ejY));
        if (!ejY) {
            Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux failed!");
            l.ejM();
            AppMethodBeat.o(89557);
            return false;
        }
        if ((this.iqo && this.isQ) || ((!this.isQ && !this.iqo) || ((this.iqo && Math.abs(this.irL - this.irW) == 0) || this.irW == 180))) {
            long currentTicks3 = Util.currentTicks();
            if (this.isQ || this.iqo) {
                i2 = this.isQ ? this.irW : 180;
            } else {
                i2 = this.irL;
            }
            if (this.irW == 180 && !this.isQ && (i2 = i2 + TXLiveConstants.RENDER_ROTATION_180) > 360) {
                i2 -= 360;
            }
            if (i2 > 0) {
                SightVideoJNI.tagRotateVideoVFS(aFk, this.irN, i2);
                this.irQ = true;
                Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", Long.valueOf(Util.ticksToNow(currentTicks3)), Integer.valueOf(this.irL), Boolean.valueOf(this.iqo), Integer.valueOf(this.irW), Integer.valueOf(i2));
                long currentTicks4 = Util.currentTicks();
                try {
                    s.deleteFile(aFk);
                    s.nx(this.irN, aFk);
                    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "copyFile cost %s", Long.valueOf(Util.ticksToNow(currentTicks4)));
                    final String str2 = this.irN;
                    ThreadPool.post(new Runnable() {
                        /* class com.tencent.mm.plugin.mmsight.model.a.o.AnonymousClass7 */

                        public final void run() {
                            AppMethodBeat.i(89548);
                            try {
                                s.deleteFile(str2);
                                AppMethodBeat.o(89548);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, delete old file error: %s", e2.getMessage());
                                AppMethodBeat.o(89548);
                            }
                        }
                    }, "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
                } catch (Exception e2) {
                    Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, copy file error");
                    AppMethodBeat.o(89557);
                    return false;
                }
            }
        }
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        this.irK.a(d.c.Stop);
        this.md5 = s.bhK(aFk);
        if (!Util.isNullOrNil(aFk) && !aFk.equals(this.iry)) {
            s.nx(aFk, this.iry);
            s.deleteFile(aFk);
        }
        AppMethodBeat.o(89557);
        return true;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final String getMd5() {
        AppMethodBeat.i(89558);
        String nullAs = Util.nullAs(this.md5, "");
        AppMethodBeat.o(89558);
        return nullAs;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void cancel() {
        AppMethodBeat.i(89559);
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "cancel record");
        if (this.zwp == null || (this.irD == null && !this.isb)) {
            Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
            AppMethodBeat.o(89559);
            return;
        }
        this.irK.a(d.c.WaitStop);
        this.zwp.a((f.a) null);
        if (this.irD != null) {
            this.irD.a(new c.b() {
                /* class com.tencent.mm.plugin.mmsight.model.a.o.AnonymousClass8 */

                @Override // com.tencent.mm.plugin.mmsight.model.a.c.b
                public final void aQX() {
                    AppMethodBeat.i(89549);
                    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac stop finish");
                    AppMethodBeat.o(89549);
                }
            });
        }
        if (!(this.zwq == null || this.zwr == null)) {
            this.zwr.removeMessages(0);
            this.zwq.quit();
            this.zwr = null;
        }
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        this.irK.a(d.c.Stop);
        reset();
        AppMethodBeat.o(89559);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void clear() {
        AppMethodBeat.i(89560);
        try {
            Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "clear");
            if (this.irD != null) {
                this.irD.clear();
            }
            if (this.zwp != null) {
                this.zwp.clear();
            }
            AppMethodBeat.o(89560);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMSightMediaCodecMP4MuxRecorder", e2, "clear error: %s", e2.getMessage());
            AppMethodBeat.o(89560);
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void setFilePath(String str) {
        this.iry = str;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void HA(String str) {
        this.thumbPath = str;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void HB(String str) {
        this.irP = str;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final String aQK() {
        return this.irP;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final String getFilePath() {
        return this.iry;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final String getFileName() {
        return this.mFileName;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final float aQL() {
        return this.irA;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void reset() {
        AppMethodBeat.i(89561);
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", this.zwp, this.irD, this.irU);
        synchronized (this.irx) {
            try {
                this.zwp = null;
            } catch (Throwable th) {
                AppMethodBeat.o(89561);
                throw th;
            }
        }
        this.irD = null;
        this.irU = null;
        this.htU = false;
        this.irV = false;
        AppMethodBeat.o(89561);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final long aQM() {
        AppMethodBeat.i(89562);
        if (this.zwp != null) {
            long aMm = this.zwp.aMm();
            AppMethodBeat.o(89562);
            return aMm;
        }
        AppMethodBeat.o(89562);
        return 0;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final g getFrameDataCallback() {
        return this.iss;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void s(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(89563);
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", Integer.valueOf(i4), Integer.valueOf(i5));
        this.irF = i4;
        this.irG = i5;
        this.irI = i2;
        this.irJ = i3;
        if (k.zwi.h(Integer.valueOf(((i2 * i3) * 3) / 2)) == null) {
            Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", Integer.valueOf(i2), Integer.valueOf(i3), 3);
            long currentTicks = Util.currentTicks();
            for (int i6 = 0; i6 < 3; i6++) {
                k.zwi.k(new byte[(((i2 * i3) * 3) / 2)]);
            }
            Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        }
        AppMethodBeat.o(89563);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final String aQn() {
        return this.thumbPath;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final d.c aQN() {
        return this.irK.zwJ;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final int aQO() {
        AppMethodBeat.i(89564);
        int round = Math.round(((float) this.irz) / 1000.0f);
        AppMethodBeat.o(89564);
        return round;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final Point aQP() {
        AppMethodBeat.i(89565);
        Point point = new Point(this.irI, this.irJ);
        AppMethodBeat.o(89565);
        return point;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final int aQQ() {
        return this.irL;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void setMirror(boolean z) {
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void pause() {
        AppMethodBeat.i(89566);
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "pause");
        if (this.irK != null && this.irK.zwJ == d.c.Start) {
            this.irK.a(d.c.Pause);
        }
        AppMethodBeat.o(89566);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void M(int i2, int i3, int i4) {
        AppMethodBeat.i(89567);
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "resume, cameraOrientation: %s", Integer.valueOf(i2));
        if (this.irK != null && this.irK.zwJ == d.c.Pause) {
            if (this.zwp != null) {
                r rVar = this.zwp;
                rVar.zwC = i2;
                rVar.zwD = i3;
                rVar.zwE = i4;
                Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "resume, newRotation: %s, newFrameWidth: %s, newFrameHeight: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            }
            this.irK.a(d.c.Start);
        }
        AppMethodBeat.o(89567);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final boolean aQR() {
        return this.irV;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void a(d.a aVar) {
        this.irX = aVar;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final boolean isLandscape() {
        return this.iqo;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void fk(boolean z) {
        this.irZ = z;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final c.a aQS() {
        AppMethodBeat.i(89568);
        if (this.irD != null) {
            c.a ejX = this.irD.ejX();
            AppMethodBeat.o(89568);
            return ejX;
        }
        AppMethodBeat.o(89568);
        return null;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void aQT() {
        this.isa = false;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void setMute(boolean z) {
        this.isb = z;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void rD(int i2) {
        AppMethodBeat.i(89569);
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideDurationMs: %s", Integer.valueOf(i2));
        this.irB = i2;
        AppMethodBeat.o(89569);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void av(float f2) {
        AppMethodBeat.i(89570);
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideFps: %s", Float.valueOf(f2));
        this.irC = f2;
        AppMethodBeat.o(89570);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x008a A[Catch:{ all -> 0x01f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0091 A[Catch:{ all -> 0x01f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009a A[Catch:{ all -> 0x01f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0123 A[Catch:{ all -> 0x01f7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.plugin.mmsight.model.a.o r19, byte[] r20) {
        /*
        // Method dump skipped, instructions count: 515
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.model.a.o.a(com.tencent.mm.plugin.mmsight.model.a.o, byte[]):void");
    }

    static /* synthetic */ void b(o oVar, byte[] bArr) {
        Bitmap bitmap;
        int i2;
        int i3;
        AppMethodBeat.i(89572);
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    if (Util.isNullOrNil(oVar.thumbPath)) {
                        Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumbImpl, thumbpath is null");
                        oVar.irO = false;
                        AppMethodBeat.o(89572);
                        return;
                    }
                    int i4 = (oVar.irL == 0 || oVar.irL == 180) ? oVar.irI : oVar.irJ;
                    int i5 = (oVar.irL == 0 || oVar.irL == 180) ? oVar.irJ : oVar.irI;
                    YuvImage yuvImage = new YuvImage(bArr, 17, i4, i5, null);
                    Rect rect = new Rect(0, 0, i4, i5);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    yuvImage.compressToJpeg(rect, 100, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    if (oVar.irT != null && Math.min(decodeByteArray.getWidth(), decodeByteArray.getHeight()) > oVar.irT.iTf) {
                        int width = decodeByteArray.getWidth();
                        int height = decodeByteArray.getHeight();
                        int i6 = oVar.irT.iTf > 0 ? oVar.irT.iTf : oVar.irT.width;
                        if (width < height) {
                            i3 = (int) (((float) height) / ((((float) width) * 1.0f) / ((float) i6)));
                            i2 = i6;
                        } else {
                            i2 = (int) (((float) width) / ((((float) height) * 1.0f) / ((float) i6)));
                            i3 = i6;
                        }
                        decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, i2, i3, true);
                    }
                    if (!oVar.iqo || oVar.irW == 180) {
                        int i7 = oVar.irL;
                        if (oVar.irW == 180 && (i7 = i7 + TXLiveConstants.RENDER_ROTATION_180) > 360) {
                            i7 -= 360;
                        }
                        bitmap = BitmapUtil.rotate(decodeByteArray, (float) i7);
                    } else if (Math.abs(oVar.irL - oVar.irW) == 0) {
                        bitmap = BitmapUtil.rotate(decodeByteArray, 180.0f);
                        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "bitmap recycle %s", decodeByteArray.toString());
                        decodeByteArray.recycle();
                    } else {
                        bitmap = decodeByteArray;
                    }
                    BitmapUtil.saveBitmapToImage(bitmap, 60, Bitmap.CompressFormat.JPEG, oVar.thumbPath, true);
                    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s %s", oVar.thumbPath, Integer.valueOf(oVar.irL), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Long.valueOf(s.boW(oVar.thumbPath)));
                    AppMethodBeat.o(89572);
                    return;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumb error: %s", e2.getMessage());
                oVar.irO = false;
                AppMethodBeat.o(89572);
                return;
            }
        }
        Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumbImpl, data is null");
        oVar.irO = false;
        AppMethodBeat.o(89572);
    }
}

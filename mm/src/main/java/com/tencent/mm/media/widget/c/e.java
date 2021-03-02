package com.tencent.mm.media.widget.c;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import com.tencent.f.h;
import com.tencent.f.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.c;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.a.n;
import com.tencent.mm.plugin.mmsight.model.a.q;
import com.tencent.mm.plugin.mmsight.model.a.t;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.s;
import com.tencent.rtmp.TXLiveConstants;
import java.io.ByteArrayOutputStream;

public final class e implements b {
    private boolean htU = false;
    boolean iqo = false;
    private float irA = 0.0f;
    int irB = -1;
    float irC = -1.0f;
    private int irF = 480;
    private int irG = 640;
    int irH = 1600000;
    int irI = 480;
    int irJ = 640;
    t irK;
    int irL = 0;
    String irN = null;
    boolean irO = false;
    private String irP = null;
    private boolean irQ = false;
    VideoTransPara irT;
    boolean irV = false;
    int irW = 0;
    d.a irX;
    String iry = "";
    private int irz = 0;
    c isI;
    q isJ;
    private a isK = null;
    com.tencent.mm.plugin.mmsight.model.a.e isL;
    private HandlerThread isM = null;
    MMHandler isN = null;
    int isO = -1;
    int isP = -1;
    boolean isQ = false;
    private boolean isR = false;
    private int isS = -1;
    private boolean isT = false;
    private boolean isU = false;
    private long isV = 0;
    boolean isa = true;
    boolean isb = false;
    private long isl = 0;
    private boolean ism = false;
    private g iss = new g() {
        /* class com.tencent.mm.media.widget.c.e.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.mmsight.model.g
        public final boolean ai(byte[] bArr) {
            AppMethodBeat.i(93431);
            if (bArr == null || bArr.length <= 0) {
                AppMethodBeat.o(93431);
                return false;
            } else if (e.this.irK.zwJ == d.c.Start) {
                e eVar = e.this;
                if (!eVar.irO && eVar.isa) {
                    eVar.irO = true;
                    byte[] bArr2 = new byte[bArr.length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    h.RTc.aX(new com.tencent.f.i.h(bArr2) {
                        /* class com.tencent.mm.media.widget.c.e.AnonymousClass8 */
                        final /* synthetic */ byte[] isX;

                        {
                            this.isX = r2;
                        }

                        @Override // com.tencent.f.i.h, com.tencent.f.i.g
                        public final String getKey() {
                            return "BigSightMediaCodecMP4MuxRecorder_saveThumb";
                        }

                        public final void run() {
                            Bitmap bitmap;
                            int i2;
                            int i3;
                            AppMethodBeat.i(93438);
                            e eVar = e.this;
                            byte[] bArr = this.isX;
                            if (bArr != null) {
                                try {
                                    if (bArr.length != 0) {
                                        if (Util.isNullOrNil(eVar.thumbPath)) {
                                            Log.e("MicroMsg.X264YUVMP4MuxRecorder", "saveVideoThumbImpl, thumbpath is null");
                                            eVar.irO = false;
                                            AppMethodBeat.o(93438);
                                            return;
                                        }
                                        int i4 = (eVar.irL == 90 || eVar.irL == 270) ? eVar.irI : eVar.irJ;
                                        int i5 = (eVar.irL == 90 || eVar.irL == 270) ? eVar.irJ : eVar.irI;
                                        YuvImage yuvImage = new YuvImage(bArr, 17, i4, i5, null);
                                        Rect rect = new Rect(0, 0, i4, i5);
                                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                        yuvImage.compressToJpeg(rect, 100, byteArrayOutputStream);
                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                        Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                                        if (eVar.irT != null && Math.min(decodeByteArray.getWidth(), decodeByteArray.getHeight()) > eVar.irT.iTf) {
                                            int width = decodeByteArray.getWidth();
                                            int height = decodeByteArray.getHeight();
                                            int i6 = eVar.irT.iTf > 0 ? eVar.irT.iTf : eVar.irT.width;
                                            if (width < height) {
                                                i3 = (int) (((float) height) / ((((float) width) * 1.0f) / ((float) i6)));
                                                i2 = i6;
                                            } else {
                                                i2 = (int) (((float) width) / ((((float) height) * 1.0f) / ((float) i6)));
                                                i3 = i6;
                                            }
                                            decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, i2, i3, true);
                                        }
                                        if (!eVar.iqo || eVar.irW == 180) {
                                            int i7 = eVar.irL;
                                            if (eVar.irW == 180 && (i7 = i7 + TXLiveConstants.RENDER_ROTATION_180) > 360) {
                                                i7 -= 360;
                                            }
                                            bitmap = BitmapUtil.rotate(decodeByteArray, (float) i7);
                                        } else if (Math.abs(eVar.irL - eVar.irW) == 0) {
                                            bitmap = BitmapUtil.rotate(decodeByteArray, 180.0f);
                                            Log.i("MicroMsg.X264YUVMP4MuxRecorder", "bitmap recycle %s", decodeByteArray.toString());
                                            decodeByteArray.recycle();
                                        } else {
                                            bitmap = decodeByteArray;
                                        }
                                        BitmapUtil.saveBitmapToImage(bitmap, 60, Bitmap.CompressFormat.JPEG, eVar.thumbPath, true);
                                        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s", eVar.thumbPath, Integer.valueOf(eVar.irL), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                                        AppMethodBeat.o(93438);
                                        return;
                                    }
                                } catch (Exception e2) {
                                    Log.e("MicroMsg.X264YUVMP4MuxRecorder", "saveVideoThumb error: %s", e2.getMessage());
                                    eVar.irO = false;
                                    AppMethodBeat.o(93438);
                                    return;
                                }
                            }
                            Log.e("MicroMsg.X264YUVMP4MuxRecorder", "saveVideoThumbImpl, data is null");
                            eVar.irO = false;
                            AppMethodBeat.o(93438);
                        }
                    });
                }
                if (e.this.isN != null) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = bArr;
                    e.this.isN.sendMessage(obtain);
                }
                AppMethodBeat.o(93431);
                return true;
            } else {
                AppMethodBeat.o(93431);
                return false;
            }
        }
    };
    private String mFileName;
    private String md5 = "";
    String thumbPath = null;

    public e(VideoTransPara videoTransPara) {
        AppMethodBeat.i(93444);
        this.irT = videoTransPara;
        this.irF = videoTransPara.width;
        this.irG = videoTransPara.height;
        this.irH = videoTransPara.videoBitrate;
        this.irK = new t();
        this.htU = false;
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "create X264YUVMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s, enableHevc:%s", Integer.valueOf(this.irF), Integer.valueOf(this.irG), Integer.valueOf(this.irH), Integer.valueOf(videoTransPara.iTs));
        com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aNt();
        if (videoTransPara.iTs == 1) {
            com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aOt();
        }
        AppMethodBeat.o(93444);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void setMirror(boolean z) {
        this.isR = z;
        if (this.isJ != null) {
            this.isJ.isR = z;
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void s(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(93445);
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        this.irI = i2;
        this.irJ = i3;
        if (k.zwi.h(Integer.valueOf(((i2 * i3) * 3) / 2)) == null) {
            Log.i("MicroMsg.X264YUVMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", Integer.valueOf(i2), Integer.valueOf(i3), 3);
            long currentTicks = Util.currentTicks();
            for (int i6 = 0; i6 < 3; i6++) {
                k.zwi.k(new byte[(((i2 * i3) * 3) / 2)]);
            }
            Log.i("MicroMsg.X264YUVMP4MuxRecorder", "preloadCameraData used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        }
        AppMethodBeat.o(93445);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final String aQn() {
        return this.thumbPath;
    }

    private boolean rE(int i2) {
        AppMethodBeat.i(93446);
        if (this.isK == null || this.isK.itd) {
            AppMethodBeat.o(93446);
            return false;
        }
        if (!this.isK.ita) {
            this.isK.callback = null;
            this.isK.itc = true;
            this.isK.itb = true;
            this.isK.cancel();
        }
        synchronized (this.isK.ite) {
            try {
                SightVideoJNI.releaseBigSightDataBufferLock(i2);
                if (this.isK.isY != i2) {
                    SightVideoJNI.releaseBigSightDataBufferLock(this.isK.isY);
                }
            } finally {
                AppMethodBeat.o(93446);
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void aRa() {
        boolean z = true;
        AppMethodBeat.i(218971);
        int i2 = -1;
        if (this.isJ != null) {
            i2 = this.isJ.zwA;
            if (i2 < 0) {
                Log.v("MicroMsg.X264YUVMP4MuxRecorder", "call clear, but bufID error");
                AppMethodBeat.o(218971);
                return;
            }
            this.isJ.stop();
        }
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Boolean.valueOf(this.isK == null);
        if (this.isK == null || !this.isK.itc) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B", objArr);
        if (i2 >= 0 && !rE(i2)) {
            SightVideoJNI.releaseRecorderBufferRefLock("clear");
            SightVideoJNI.releaseBigSightDataBufferLock(i2);
        }
        if (this.isI != null) {
            this.isI.a((c.b) null);
        }
        if (this.isM != null) {
            this.isM.quit();
        }
        AppMethodBeat.o(218971);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void clear() {
        AppMethodBeat.i(93447);
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "clear, hasWriteCameraData:%s", Boolean.valueOf(this.irV));
        if (this.irV) {
            h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.media.widget.c.e.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(93432);
                    e.this.aRa();
                    AppMethodBeat.o(93432);
                }
            });
        } else {
            aRa();
        }
        this.isl = 0;
        this.isV = 0;
        AppMethodBeat.o(93447);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void cancel() {
        AppMethodBeat.i(93448);
        Log.printInfoStack("MicroMsg.X264YUVMP4MuxRecorder", "cancel", new Object[0]);
        this.irK.a(d.c.WaitStop);
        if (this.isN != null) {
            this.isN.removeMessages(1);
        }
        clear();
        this.irK.a(d.c.Stop);
        AppMethodBeat.o(93448);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void E(final Runnable runnable) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(93449);
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.isK == null);
        if (this.isK == null || !this.isK.ita) {
            z = false;
        } else {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        if (this.isK == null || !this.isK.itb) {
            z2 = false;
        } else {
            z2 = true;
        }
        objArr[2] = Boolean.valueOf(z2);
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "stop, encodeThread null ? %B, has trigger finish ? %B, has finish callback ? %B", objArr);
        if (this.isK == null || !this.isK.ita) {
            Log.i("MicroMsg.X264YUVMP4MuxRecorder", "stopOnCameraDataThread: %s, writeCameraDataHandler: %s", Boolean.valueOf(this.isU), this.isN);
            if (!this.isU || this.isN == null) {
                h.RTc.aX(new com.tencent.f.i.h() {
                    /* class com.tencent.mm.media.widget.c.e.AnonymousClass4 */

                    @Override // com.tencent.f.i.h, com.tencent.f.i.g
                    public final String getKey() {
                        return "MMSightFFMpegRecorder_stop";
                    }

                    public final void run() {
                        AppMethodBeat.i(93434);
                        e.a(e.this, runnable);
                        AppMethodBeat.o(93434);
                    }
                });
                AppMethodBeat.o(93449);
                return;
            }
            this.isN.post(new Runnable() {
                /* class com.tencent.mm.media.widget.c.e.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(93433);
                    e.a(e.this, runnable);
                    AppMethodBeat.o(93433);
                }
            });
            AppMethodBeat.o(93449);
            return;
        }
        synchronized (this.isK.ite) {
            try {
                reset();
                MMHandlerThread.postToMainThread(runnable);
            } finally {
                AppMethodBeat.o(93449);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void aQX() {
        if (this.isK != null) {
            this.isK.itb = true;
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final String getMd5() {
        AppMethodBeat.i(93450);
        String nullAs = Util.nullAs(this.md5, "");
        AppMethodBeat.o(93450);
        return nullAs;
    }

    @Override // com.tencent.mm.media.widget.c.b
    public final void aQG() {
    }

    /* access modifiers changed from: package-private */
    public class a extends b {
        float cKu;
        Runnable callback = null;
        int duration;
        volatile int ifA = 0;
        int isY;
        volatile boolean isZ = true;
        boolean ita = false;
        boolean itb = false;
        boolean itc = false;
        boolean itd = false;
        final Object ite = new Object();

        public a() {
            AppMethodBeat.i(93442);
            synchronized (this.ite) {
                try {
                    String boZ = s.boZ(e.this.iry);
                    e.this.irN = (!boZ.endsWith(FilePathGenerator.ANDROID_DIR_SEP) ? boZ + FilePathGenerator.ANDROID_DIR_SEP : boZ) + "tempRotate.mp4";
                } catch (Exception e2) {
                    Log.e("MicroMsg.X264YUVMP4MuxRecorder", "retrieve file name error: %s", e2.getMessage());
                }
                try {
                } catch (Throwable th) {
                    AppMethodBeat.o(93442);
                    throw th;
                }
            }
            AppMethodBeat.o(93442);
        }

        public final void run() {
            int i2;
            boolean z = true;
            AppMethodBeat.i(93443);
            if (e.this.isP == -1) {
                e.this.isP = Process.myTid();
                Process.setThreadPriority(Process.myTid(), -2);
                Log.i("MicroMsg.X264YUVMP4MuxRecorder", "encodeTid: %s", Integer.valueOf(e.this.isP));
            }
            synchronized (this.ite) {
                while (!this.itb) {
                    try {
                        long currentTicks = Util.currentTicks();
                        int triggerEncode = SightVideoJNI.triggerEncode(this.isY, Math.max(0, this.ifA), false);
                        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", Long.valueOf(Util.ticksToNow(currentTicks)), Integer.valueOf(this.ifA), Integer.valueOf(triggerEncode), Long.valueOf(Thread.currentThread().getId()));
                        if (Math.abs(triggerEncode - this.ifA) <= 5) {
                            try {
                                Thread.sleep(100);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.X264YUVMP4MuxRecorder", "thread sleep error");
                            }
                        }
                        this.ifA = triggerEncode;
                    } finally {
                        AppMethodBeat.o(93443);
                    }
                }
                long currentTicks2 = Util.currentTicks();
                if (!this.itc) {
                    this.ifA = SightVideoJNI.triggerEncode(this.isY, this.ifA, true);
                }
                Log.i("MicroMsg.X264YUVMP4MuxRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", Long.valueOf(Util.ticksToNow(currentTicks2)), Integer.valueOf(this.ifA), Boolean.valueOf(this.itc), Long.valueOf(Thread.currentThread().getId()));
                if (!this.itc) {
                    int max = Math.max(1000, this.duration);
                    if (e.this.irB > 0) {
                        max = e.this.irB;
                    }
                    float f2 = this.cKu;
                    if (e.this.irC > 0.0f) {
                        f2 = e.this.irC;
                    }
                    e eVar = e.this;
                    int i3 = this.isY;
                    String str = e.this.iry;
                    int i4 = e.this.irH;
                    int i5 = e.this.irT.audioSampleRate;
                    boolean z2 = e.this.isb;
                    if (e.this.irT.iTs != 1) {
                        z = false;
                    }
                    eVar.isL = new n(i3, str, f2, i4, max, i5, z2, true, z);
                    long currentTicks3 = Util.currentTicks();
                    boolean ejY = e.this.isL.ejY();
                    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "mux used %sms, success: %s", Long.valueOf(Util.ticksToNow(currentTicks3)), Boolean.valueOf(ejY));
                    if (!ejY) {
                        Log.e("MicroMsg.X264YUVMP4MuxRecorder", "mux failed!");
                        SightVideoJNI.releaseBigSightDataBufferLock(this.isY);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.media.widget.c.e.a.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(93439);
                                if (e.this.irX != null) {
                                    e.this.irX.bqP();
                                }
                                AppMethodBeat.o(93439);
                            }
                        });
                        com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
                        com.tencent.mm.media.k.e.aNz();
                        return;
                    }
                    com.tencent.mm.media.k.e eVar3 = com.tencent.mm.media.k.e.ilC;
                    com.tencent.mm.media.k.e.aNA();
                    if ((e.this.iqo && e.this.isQ) || ((!e.this.isQ && !e.this.iqo) || ((e.this.iqo && Math.abs(e.this.irL - e.this.irW) == 0) || e.this.irW == 180))) {
                        long currentTicks4 = Util.currentTicks();
                        if (!e.this.isQ && !e.this.iqo) {
                            i2 = e.this.irL;
                        } else if (e.this.isQ) {
                            i2 = e.this.irW;
                        } else {
                            i2 = TXLiveConstants.RENDER_ROTATION_180;
                        }
                        if (e.this.irW == 180 && !e.this.isQ && (i2 = i2 + TXLiveConstants.RENDER_ROTATION_180) > 360) {
                            i2 -= 360;
                        }
                        if (i2 > 0) {
                            SightVideoJNI.tagRotateVideoVFS(e.this.iry, e.this.irN, i2);
                            Log.i("MicroMsg.X264YUVMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", Long.valueOf(Util.ticksToNow(currentTicks4)), Integer.valueOf(e.this.irL), Boolean.valueOf(e.this.iqo), Integer.valueOf(e.this.irW), Integer.valueOf(i2));
                            final String str2 = e.this.irN;
                            try {
                                s.nw(e.this.irN, e.this.iry);
                                h.RTc.aX(new com.tencent.f.i.h() {
                                    /* class com.tencent.mm.media.widget.c.e.a.AnonymousClass3 */

                                    @Override // com.tencent.f.i.h, com.tencent.f.i.g
                                    public final String getKey() {
                                        return "BigSightFFMpegRecorder_tagRotate_after_process";
                                    }

                                    public final void run() {
                                        AppMethodBeat.i(93441);
                                        try {
                                            s.deleteFile(str2);
                                            AppMethodBeat.o(93441);
                                        } catch (Exception e2) {
                                            Log.e("MicroMsg.X264YUVMP4MuxRecorder", "stop, delete old file error: %s", e2.getMessage());
                                            AppMethodBeat.o(93441);
                                        }
                                    }
                                });
                                Log.i("MicroMsg.X264YUVMP4MuxRecorder", "tag rotate used %sms", Long.valueOf(Util.ticksToNow(currentTicks4)));
                                try {
                                    com.tencent.mm.plugin.sight.base.a aNx = com.tencent.mm.plugin.sight.base.e.aNx(e.this.iry);
                                    if (aNx != null) {
                                        com.tencent.mm.media.k.e eVar4 = com.tencent.mm.media.k.e.ilC;
                                        com.tencent.mm.media.k.e.dd(aNx.videoBitrate, aNx.frameRate);
                                    }
                                } catch (Exception e3) {
                                }
                            } catch (Exception e4) {
                                Log.e("MicroMsg.X264YUVMP4MuxRecorder", "stop, copy file error");
                                SightVideoJNI.releaseBigSightDataBufferLock(this.isY);
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.media.widget.c.e.a.AnonymousClass2 */

                                    public final void run() {
                                        AppMethodBeat.i(93440);
                                        if (e.this.irX != null) {
                                            e.this.irX.bqP();
                                        }
                                        AppMethodBeat.o(93440);
                                    }
                                });
                                AppMethodBeat.o(93443);
                                return;
                            }
                        }
                    }
                }
                SightVideoJNI.releaseBigSightDataBufferLock(this.isY);
                Log.i("MicroMsg.X264YUVMP4MuxRecorder", "all finish, callback: %s", this.callback);
                e.this.reset();
                MMHandlerThread.postToMainThread(this.callback);
                this.itd = true;
                e.this.isP = -1;
                e.this.isO = -1;
                AppMethodBeat.o(93443);
            }
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "SightCustomAsyncMediaRecorder_encode";
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final d.c aQN() {
        return this.irK.zwJ;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final long aQM() {
        AppMethodBeat.i(93451);
        long aMm = this.isJ.aMm();
        AppMethodBeat.o(93451);
        return aMm;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final g getFrameDataCallback() {
        return this.iss;
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
    public final void reset() {
        AppMethodBeat.i(93452);
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "reset");
        this.irK.zwJ = d.c.Stop;
        if (this.isN != null) {
            this.isN.removeMessages(1);
        }
        if (this.isI != null) {
            this.isI.clear();
        }
        if (this.isJ != null) {
            this.isJ.clear();
        }
        clear();
        this.irV = false;
        AppMethodBeat.o(93452);
    }

    private boolean rB(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        boolean z2;
        AppMethodBeat.i(93453);
        long currentTicks = Util.currentTicks();
        if (com.tencent.mm.plugin.mmsight.model.k.zuy != null) {
            this.isQ = com.tencent.mm.plugin.mmsight.model.k.zuy.isQ;
        }
        this.irL = i2;
        if (!this.isQ) {
            int i8 = (i2 == 90 || i2 == 270) ? this.irI : this.irJ;
            i3 = (i2 == 90 || i2 == 270) ? this.irJ : this.irI;
            i4 = (i2 == 90 || i2 == 270) ? this.irG : this.irF;
            i5 = (i2 == 90 || i2 == 270) ? this.irF : this.irG;
            i6 = i8;
        } else {
            int i9 = (i2 == 90 || i2 == 270) ? this.irI : this.irJ;
            i3 = (i2 == 90 || i2 == 270) ? this.irJ : this.irI;
            i4 = (i2 == 90 || i2 == 270) ? this.irF : this.irG;
            i5 = (i2 == 90 || i2 == 270) ? this.irG : this.irF;
            i6 = i9;
        }
        int i10 = this.irH;
        if (i4 % 2 != 0) {
            i4++;
        }
        if (i5 % 2 != 0) {
            i7 = i5 + 1;
        } else {
            i7 = i5;
        }
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "real width:%d, height:%d", Integer.valueOf(i4), Integer.valueOf(i7));
        float f2 = (float) this.irT.fps;
        int i11 = this.irT.iSV;
        int i12 = this.irT.iSU;
        boolean z3 = this.isQ;
        int i13 = this.irT.duration;
        if (this.irT.iTs == 1) {
            z = true;
        } else {
            z = false;
        }
        if (this.irT.iTs == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        int initDataBufferForMMSightLock = SightVideoJNI.initDataBufferForMMSightLock(i6, i3, i2, i4, i7, f2, i10, i11, 8, i12, 23.0f, z3, true, i13, false, z, com.tencent.mm.plugin.sight.base.b.ak(true, z2));
        if (initDataBufferForMMSightLock < 0) {
            Log.e("MicroMsg.X264YUVMP4MuxRecorder", "init failed!");
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aNu();
            AppMethodBeat.o(93453);
            return false;
        }
        this.isS = initDataBufferForMMSightLock;
        this.isJ = new q(this.isQ, i2, i4, i7, this.isR);
        this.isJ.QO(initDataBufferForMMSightLock);
        if (CaptureMMProxy.getInstance() != null) {
            CaptureMMProxy.getInstance().getInt(ar.a.USERINFO_LOCAL_SIGHT_AUDIO_RECORDER_TYPE_INT_SYNC, -1);
        }
        if (!this.isb) {
            this.isI = new a(this.irT.audioSampleRate, this.irT.audioBitrate, this.irT.audioChannelCount, com.tencent.mm.plugin.sight.base.b.ak(true, this.irT.iTs == 1));
            this.isI.rc(this.isT);
            if (this.isI.H(initDataBufferForMMSightLock, com.tencent.mm.plugin.sight.base.e.aNv(this.iry)) < 0) {
                com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aNw();
            }
        }
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "initImpl used %sms, bufferId:%s", Long.valueOf(Util.ticksToNow(currentTicks)), Integer.valueOf(initDataBufferForMMSightLock));
        AppMethodBeat.o(93453);
        return true;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final boolean rC(int i2) {
        AppMethodBeat.i(93454);
        if (!this.htU) {
            Log.i("MicroMsg.X264YUVMP4MuxRecorder", "preInit, cameraOrientation: %s", Integer.valueOf(i2));
            boolean rB = rB(i2);
            this.htU = true;
            Log.i("MicroMsg.X264YUVMP4MuxRecorder", "initImpl result: %s", Boolean.valueOf(rB));
            AppMethodBeat.o(93454);
            return rB;
        }
        AppMethodBeat.o(93454);
        return true;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final int b(int i2, boolean z, int i3) {
        boolean z2;
        int i4;
        AppMethodBeat.i(93455);
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s, bufId:%S", this.irK.zwJ, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(this.isS));
        this.iqo = z;
        this.isl = 0;
        this.isV = 0;
        this.irz = 0;
        this.irW = i3;
        this.irK.a(d.c.WaitStart);
        Object[] objArr = new Object[3];
        objArr[0] = this.iry;
        objArr[1] = Boolean.valueOf(this.isK == null);
        if (this.isK == null || this.isK.itd) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[2] = Boolean.valueOf(z2);
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]", objArr);
        if (this.isK != null && !this.isK.itd) {
            Log.w("MicroMsg.X264YUVMP4MuxRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
            AppMethodBeat.o(93455);
            return -1;
        } else if (Util.isNullOrNil(this.iry)) {
            Log.e("MicroMsg.X264YUVMP4MuxRecorder", "start error, mCurRecordPath is null!!");
            AppMethodBeat.o(93455);
            return -1;
        } else {
            this.mFileName = s.bpb(this.iry);
            Log.i("MicroMsg.X264YUVMP4MuxRecorder", "mCurRecordPath: %s", this.iry);
            this.irL = i2;
            Log.i("MicroMsg.X264YUVMP4MuxRecorder", "start, cameraOrientation: %s, mute:%s", Integer.valueOf(this.irL), Boolean.valueOf(this.isb));
            if (!this.htU) {
                rB(i2);
                this.htU = true;
            }
            this.isJ.start();
            if (this.isT || this.isI == null) {
                i4 = 0;
            } else {
                i4 = this.isI.a(new c.a() {
                    /* class com.tencent.mm.media.widget.c.e.AnonymousClass6 */

                    @Override // com.tencent.mm.plugin.mmsight.model.a.c.a
                    public final void aQY() {
                        AppMethodBeat.i(93436);
                        e.this.aQY();
                        AppMethodBeat.o(93436);
                    }
                });
            }
            Log.i("MicroMsg.X264YUVMP4MuxRecorder", "start aac recorder ret: %d", Integer.valueOf(i4));
            this.isM = com.tencent.f.c.d.hA("BigSightWriteCameraData", 5);
            this.isM.start();
            this.isN = new MMHandler(this.isM.getLooper()) {
                /* class com.tencent.mm.media.widget.c.e.AnonymousClass7 */

                @Override // com.tencent.mm.sdk.platformtools.MMHandler
                public final void handleMessage(Message message) {
                    q qVar;
                    int length;
                    int i2;
                    int i3;
                    byte[] bArr;
                    AppMethodBeat.i(93437);
                    if (e.this.isO == -1) {
                        e.this.isO = Process.myTid();
                        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "writeCameraTid: %s", Integer.valueOf(e.this.isO));
                    }
                    if (message.what == 1) {
                        if (e.this.isI != null) {
                            e.this.isI.ejW();
                        }
                        e eVar = e.this;
                        byte[] bArr2 = (byte[]) message.obj;
                        if (eVar.isQ) {
                            qVar = eVar.isJ;
                            length = bArr2.length;
                            i3 = eVar.irI;
                            i2 = eVar.irJ;
                            bArr = bArr2;
                        } else {
                            qVar = eVar.isJ;
                            length = bArr2.length;
                            int i4 = (eVar.irL == 90 || eVar.irL == 270) ? eVar.irI : eVar.irJ;
                            if (eVar.irL == 90 || eVar.irL == 270) {
                                i2 = eVar.irJ;
                                i3 = i4;
                                bArr = bArr2;
                            } else {
                                i2 = eVar.irI;
                                i3 = i4;
                                bArr = bArr2;
                            }
                        }
                        qVar.f(bArr, length, i3, i2);
                        k.zwi.k(bArr2);
                        eVar.irV = true;
                    }
                    AppMethodBeat.o(93437);
                }
            };
            this.irV = false;
            if (i4 != 0) {
                this.irK.a(d.c.Error);
            } else {
                this.irK.a(d.c.Initialized);
            }
            if (this.isT || this.isb) {
                aQY();
            }
            AppMethodBeat.o(93455);
            return i4;
        }
    }

    /* access modifiers changed from: package-private */
    public final void aQY() {
        AppMethodBeat.i(93456);
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::pcm ready");
        if (this.isK != null && !this.isK.itd) {
            Log.e("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", this.isK);
            synchronized (this.isK.ite) {
                try {
                    rE(this.isK.isY);
                } catch (Throwable th) {
                    AppMethodBeat.o(93456);
                    throw th;
                }
            }
        }
        if (this.irK.zwJ != d.c.Initialized) {
            Log.w("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
            AppMethodBeat.o(93456);
            return;
        }
        this.irK.a(d.c.Start);
        this.isK = new a();
        this.isK.isY = this.isS;
        h.RTc.aX(this.isK);
        AppMethodBeat.o(93456);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final int aQO() {
        AppMethodBeat.i(93457);
        int round = Math.round(((float) this.irz) / 1000.0f);
        AppMethodBeat.o(93457);
        return round;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final Point aQP() {
        AppMethodBeat.i(93458);
        Point point = new Point(this.irI, this.irJ);
        AppMethodBeat.o(93458);
        return point;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final int aQQ() {
        return this.irL;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void pause() {
        AppMethodBeat.i(93459);
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "pause");
        if (this.irK != null && this.irK.zwJ == d.c.Start) {
            this.irK.a(d.c.Pause);
            this.isV = System.currentTimeMillis();
        }
        AppMethodBeat.o(93459);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void M(int i2, int i3, int i4) {
        AppMethodBeat.i(93460);
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "resume, cameraOrientation: %s, lastPauseTimeMs:%s", Integer.valueOf(i2), Long.valueOf(this.isV));
        if (this.irK != null && this.irK.zwJ == d.c.Pause) {
            if (this.isJ != null) {
                this.isJ.M(i2, i3, i4);
            }
            this.irK.a(d.c.Start);
            if (this.isV > 0) {
                this.isl += System.currentTimeMillis() - this.isV;
            }
        }
        AppMethodBeat.o(93460);
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
        this.isT = z;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final c.a aQS() {
        AppMethodBeat.i(93461);
        if (this.isI != null) {
            c.a ejX = this.isI.ejX();
            AppMethodBeat.o(93461);
            return ejX;
        }
        AppMethodBeat.o(93461);
        return null;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void aQT() {
        this.isa = false;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void setMute(boolean z) {
        AppMethodBeat.i(218972);
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "setMute:%s", Boolean.valueOf(z));
        this.isb = z;
        AppMethodBeat.o(218972);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void rD(int i2) {
        AppMethodBeat.i(93462);
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "overrideDurationMs: %s", Integer.valueOf(i2));
        this.irB = i2;
        AppMethodBeat.o(93462);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void av(float f2) {
        AppMethodBeat.i(93463);
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "overrideFps: %s", Float.valueOf(f2));
        this.irC = f2;
        AppMethodBeat.o(93463);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final float aQL() {
        return this.irA;
    }

    public final com.tencent.mm.plugin.mmsight.model.a.c aQW() {
        return this.isI;
    }

    public final void a(com.tencent.mm.plugin.mmsight.model.a.c cVar) {
        AppMethodBeat.i(93464);
        if (cVar != null) {
            this.ism = true;
            cVar.rA(this.isS);
        }
        AppMethodBeat.o(93464);
    }

    static /* synthetic */ void a(e eVar, Runnable runnable) {
        AppMethodBeat.i(218973);
        eVar.irK.a(d.c.WaitStop);
        if (eVar.isJ != null) {
            int i2 = eVar.isJ.zwA;
            float aMm = (((float) eVar.isJ.frameCount) * 1000.0f) / ((float) eVar.isJ.aMm());
            Log.i("MicroMsg.X264YUVMP4MuxRecorder", "stop, bufID %d, frameCount %d, duration %dms, %.6ffps", Integer.valueOf(i2), Integer.valueOf(eVar.isJ.frameCount), Long.valueOf(eVar.isJ.aMm()), Float.valueOf(aMm));
            Log.i("MicroMsg.X264YUVMP4MuxRecorder", "stop, accumulatePauseTime:%s", Long.valueOf(eVar.isl));
            eVar.irz = (int) eVar.isJ.aMm();
            if (eVar.isl > 0) {
                eVar.irz = (int) (((long) eVar.irz) - eVar.isl);
            }
            eVar.irA = aMm;
            eVar.isJ.stop();
            if (eVar.isK != null) {
                eVar.isK.cKu = aMm;
                eVar.isK.duration = eVar.irz;
                eVar.isK.callback = runnable;
                eVar.isK.ita = true;
                eVar.isK.cancel();
            }
        }
        if (eVar.isI != null && !eVar.isT) {
            eVar.isI.a(new c.b() {
                /* class com.tencent.mm.media.widget.c.e.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.mmsight.model.a.c.b
                public final void aQX() {
                    AppMethodBeat.i(93435);
                    e.this.aQX();
                    AppMethodBeat.o(93435);
                }
            });
        } else if (eVar.isb) {
            eVar.aQX();
        }
        eVar.irK.a(d.c.Stop);
        eVar.md5 = com.tencent.mm.d.g.getMD5(eVar.iry);
        if (eVar.isK == null) {
            Log.e("MicroMsg.X264YUVMP4MuxRecorder", "encodeRunnable is null!, directly call stopcallback");
            eVar.reset();
            MMHandlerThread.postToMainThread(runnable);
        }
        if (eVar.isT) {
            eVar.aQX();
        }
        AppMethodBeat.o(218973);
    }
}

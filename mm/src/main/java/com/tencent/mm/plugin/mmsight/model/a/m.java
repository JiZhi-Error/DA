package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import com.tencent.f.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.c;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.s;
import com.tencent.rtmp.TXLiveConstants;
import java.io.ByteArrayOutputStream;

public final class m implements d {
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
    e isL;
    private HandlerThread isM = null;
    MMHandler isN = null;
    int isO = -1;
    int isP = -1;
    boolean isQ = false;
    private boolean isR = false;
    private int isS = -1;
    private boolean isT = false;
    public boolean isU = false;
    boolean isa = true;
    private g iss = new g() {
        /* class com.tencent.mm.plugin.mmsight.model.a.m.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.mmsight.model.g
        public final boolean ai(byte[] bArr) {
            AppMethodBeat.i(89506);
            if (bArr == null || bArr.length <= 0) {
                AppMethodBeat.o(89506);
                return false;
            } else if (m.this.irK.zwJ == d.c.Start) {
                m mVar = m.this;
                if (!mVar.irO && mVar.isa) {
                    mVar.irO = true;
                    byte[] bArr2 = new byte[bArr.length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    ThreadPool.post(new Runnable(bArr2) {
                        /* class com.tencent.mm.plugin.mmsight.model.a.m.AnonymousClass7 */
                        final /* synthetic */ byte[] isX;

                        {
                            this.isX = r2;
                        }

                        public final void run() {
                            Bitmap bitmap;
                            int i2;
                            int i3;
                            AppMethodBeat.i(89512);
                            m mVar = m.this;
                            byte[] bArr = this.isX;
                            if (bArr != null) {
                                try {
                                    if (bArr.length != 0) {
                                        if (Util.isNullOrNil(mVar.thumbPath)) {
                                            Log.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumbImpl, thumbpath is null");
                                            mVar.irO = false;
                                            AppMethodBeat.o(89512);
                                            return;
                                        }
                                        int i4 = (mVar.irL == 0 || mVar.irL == 180) ? mVar.irI : mVar.irJ;
                                        int i5 = (mVar.irL == 0 || mVar.irL == 180) ? mVar.irJ : mVar.irI;
                                        YuvImage yuvImage = new YuvImage(bArr, 17, i4, i5, null);
                                        Rect rect = new Rect(0, 0, i4, i5);
                                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                        yuvImage.compressToJpeg(rect, 100, byteArrayOutputStream);
                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                        Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                                        if (mVar.irT != null && Math.min(decodeByteArray.getWidth(), decodeByteArray.getHeight()) > mVar.irT.iTf) {
                                            int width = decodeByteArray.getWidth();
                                            int height = decodeByteArray.getHeight();
                                            int i6 = mVar.irT.iTf > 0 ? mVar.irT.iTf : mVar.irT.width;
                                            if (width < height) {
                                                i3 = (int) (((float) height) / ((((float) width) * 1.0f) / ((float) i6)));
                                                i2 = i6;
                                            } else {
                                                i2 = (int) (((float) width) / ((((float) height) * 1.0f) / ((float) i6)));
                                                i3 = i6;
                                            }
                                            decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, i2, i3, true);
                                        }
                                        if (!mVar.iqo || mVar.irW == 180) {
                                            int i7 = mVar.irL;
                                            if (mVar.irW == 180 && (i7 = i7 + TXLiveConstants.RENDER_ROTATION_180) > 360) {
                                                i7 -= 360;
                                            }
                                            bitmap = BitmapUtil.rotate(decodeByteArray, (float) i7);
                                        } else if (Math.abs(mVar.irL - mVar.irW) == 0) {
                                            bitmap = BitmapUtil.rotate(decodeByteArray, 180.0f);
                                            Log.i("MicroMsg.MMSightFFMpegRecorder", "bitmap recycle %s", decodeByteArray.toString());
                                            decodeByteArray.recycle();
                                        } else {
                                            bitmap = decodeByteArray;
                                        }
                                        BitmapUtil.saveBitmapToImage(bitmap, 60, Bitmap.CompressFormat.JPEG, mVar.thumbPath, true);
                                        Log.i("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s", mVar.thumbPath, Integer.valueOf(mVar.irL), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                                        AppMethodBeat.o(89512);
                                        return;
                                    }
                                } catch (Exception e2) {
                                    Log.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumb error: %s", e2.getMessage());
                                    mVar.irO = false;
                                    AppMethodBeat.o(89512);
                                    return;
                                }
                            }
                            Log.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumbImpl, data is null");
                            mVar.irO = false;
                            AppMethodBeat.o(89512);
                        }
                    }, "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                }
                if (m.this.isN != null) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = bArr;
                    m.this.isN.sendMessage(obtain);
                }
                AppMethodBeat.o(89506);
                return true;
            } else {
                AppMethodBeat.o(89506);
                return false;
            }
        }
    };
    private String mFileName;
    private String md5 = "";
    String thumbPath = null;
    private a zwl = null;

    public m(VideoTransPara videoTransPara) {
        AppMethodBeat.i(89518);
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
        this.htU = false;
        Log.d("MicroMsg.MMSightFFMpegRecorder", "create MMSightFFMpegRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s,  defaultRate: %s", Integer.valueOf(this.irF), Integer.valueOf(this.irG), Integer.valueOf(this.irH), Integer.valueOf(eke));
        AppMethodBeat.o(89518);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void s(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(89519);
        Log.i("MicroMsg.MMSightFFMpegRecorder", "setSize, width: %s, height: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.irF = i4;
        this.irG = i5;
        this.irI = i2;
        this.irJ = i3;
        if (k.zwi.h(Integer.valueOf(((i2 * i3) * 3) / 2)) == null) {
            Log.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData, width: %s, height: %s, count: %s", Integer.valueOf(i2), Integer.valueOf(i3), 3);
            long currentTicks = Util.currentTicks();
            for (int i6 = 0; i6 < 3; i6++) {
                k.zwi.k(new byte[(((i2 * i3) * 3) / 2)]);
            }
            Log.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        }
        AppMethodBeat.o(89519);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final String aQn() {
        return this.thumbPath;
    }

    private boolean rE(int i2) {
        AppMethodBeat.i(89520);
        if (this.zwl == null || this.zwl.itd) {
            AppMethodBeat.o(89520);
            return false;
        }
        if (!this.zwl.ita) {
            this.zwl.callback = null;
            this.zwl.itc = true;
            this.zwl.itb = true;
            this.zwl.cancel();
        }
        synchronized (this.zwl.ite) {
            try {
                SightVideoJNI.releaseBigSightDataBufferLock(i2);
                if (this.zwl.isY != i2) {
                    SightVideoJNI.releaseBigSightDataBufferLock(this.zwl.isY);
                }
            } finally {
                AppMethodBeat.o(89520);
            }
        }
        return true;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void clear() {
        boolean z = true;
        AppMethodBeat.i(89521);
        int i2 = -1;
        if (this.isJ != null) {
            i2 = this.isJ.zwA;
            if (i2 < 0) {
                Log.v("MicroMsg.MMSightFFMpegRecorder", "call clear, but bufID error");
                AppMethodBeat.o(89521);
                return;
            }
            this.isJ.stop();
        }
        if (this.isI != null) {
            this.isI.a((c.b) null);
        }
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Boolean.valueOf(this.zwl == null);
        if (this.zwl == null || !this.zwl.itc) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        Log.v("MicroMsg.MMSightFFMpegRecorder", "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B", objArr);
        if (i2 >= 0 && !rE(i2)) {
            SightVideoJNI.releaseRecorderBufferRef("clear");
            SightVideoJNI.releaseBigSightDataBufferLock(i2);
        }
        if (this.isM != null) {
            this.isM.quit();
        }
        AppMethodBeat.o(89521);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void cancel() {
        AppMethodBeat.i(89522);
        Log.i("MicroMsg.MMSightFFMpegRecorder", "cancel");
        this.irK.a(d.c.WaitStop);
        clear();
        this.irK.a(d.c.Stop);
        AppMethodBeat.o(89522);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void E(final Runnable runnable) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(89523);
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.zwl == null);
        if (this.zwl == null || !this.zwl.ita) {
            z = false;
        } else {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        if (this.zwl == null || !this.zwl.itb) {
            z2 = false;
        } else {
            z2 = true;
        }
        objArr[2] = Boolean.valueOf(z2);
        Log.i("MicroMsg.MMSightFFMpegRecorder", "stop, encodeThread null ? %B, has trigger finish ? %B, has finish callback ? %B", objArr);
        if (this.zwl == null || !this.zwl.ita) {
            Log.i("MicroMsg.MMSightFFMpegRecorder", "stopOnCameraDataThread: %s, writeCameraDataHandler: %s", Boolean.valueOf(this.isU), this.isN);
            if (!this.isU || this.isN == null) {
                ThreadPool.post(new Runnable() {
                    /* class com.tencent.mm.plugin.mmsight.model.a.m.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(89508);
                        m.a(m.this, runnable);
                        AppMethodBeat.o(89508);
                    }
                }, "MMSightFFMpegRecorder_stop");
                AppMethodBeat.o(89523);
                return;
            }
            this.isN.post(new Runnable() {
                /* class com.tencent.mm.plugin.mmsight.model.a.m.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(89507);
                    m.a(m.this, runnable);
                    AppMethodBeat.o(89507);
                }
            });
            AppMethodBeat.o(89523);
            return;
        }
        synchronized (this.zwl.ite) {
            try {
                reset();
                MMHandlerThread.postToMainThread(runnable);
            } finally {
                AppMethodBeat.o(89523);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void aQX() {
        if (this.zwl != null) {
            this.zwl.itb = true;
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final String getMd5() {
        AppMethodBeat.i(89524);
        String nullAs = Util.nullAs(this.md5, "");
        AppMethodBeat.o(89524);
        return nullAs;
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
            AppMethodBeat.i(89516);
            synchronized (this.ite) {
                try {
                    String boZ = s.boZ(m.this.iry);
                    m.this.irN = (!boZ.endsWith(FilePathGenerator.ANDROID_DIR_SEP) ? boZ + FilePathGenerator.ANDROID_DIR_SEP : boZ) + "tempRotate.mp4";
                } catch (Exception e2) {
                    Log.e("MicroMsg.MMSightFFMpegRecorder", "retrieve file name error: %s", e2.getMessage());
                }
                try {
                } catch (Throwable th) {
                    AppMethodBeat.o(89516);
                    throw th;
                }
            }
            AppMethodBeat.o(89516);
        }

        public final void run() {
            int i2;
            AppMethodBeat.i(89517);
            if (m.this.isP == -1) {
                m.this.isP = Process.myTid();
                Process.setThreadPriority(Process.myTid(), -2);
                Log.i("MicroMsg.MMSightFFMpegRecorder", "encodeTid: %s", Integer.valueOf(m.this.isP));
            }
            synchronized (this.ite) {
                while (!this.itb) {
                    try {
                        long currentTicks = Util.currentTicks();
                        int triggerEncode = SightVideoJNI.triggerEncode(this.isY, Math.max(0, this.ifA), false);
                        Log.i("MicroMsg.MMSightFFMpegRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", Long.valueOf(Util.ticksToNow(currentTicks)), Integer.valueOf(this.ifA), Integer.valueOf(triggerEncode), Long.valueOf(Thread.currentThread().getId()));
                        if (Math.abs(triggerEncode - this.ifA) <= 5) {
                            try {
                                Thread.sleep(100);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.MMSightFFMpegRecorder", "thread sleep error");
                            }
                        }
                        this.ifA = triggerEncode;
                    } finally {
                        AppMethodBeat.o(89517);
                    }
                }
                long currentTicks2 = Util.currentTicks();
                if (!this.itc) {
                    this.ifA = SightVideoJNI.triggerEncode(this.isY, this.ifA, true);
                }
                Log.i("MicroMsg.MMSightFFMpegRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", Long.valueOf(Util.ticksToNow(currentTicks2)), Integer.valueOf(this.ifA), Boolean.valueOf(this.itc), Long.valueOf(Thread.currentThread().getId()));
                if (!this.itc) {
                    int max = Math.max(1000, this.duration);
                    if (m.this.irB > 0) {
                        max = m.this.irB;
                    }
                    float f2 = this.cKu;
                    if (m.this.irC > 0.0f) {
                        f2 = m.this.irC;
                    }
                    m.this.isL = new n(this.isY, m.this.iry, f2, m.this.irH, max, m.this.irT.audioSampleRate, false, true, false);
                    long currentTicks3 = Util.currentTicks();
                    boolean ejY = m.this.isL.ejY();
                    Log.i("MicroMsg.MMSightFFMpegRecorder", "mux used %sms, success: %s", Long.valueOf(Util.ticksToNow(currentTicks3)), Boolean.valueOf(ejY));
                    if (!ejY) {
                        Log.e("MicroMsg.MMSightFFMpegRecorder", "mux failed!");
                        SightVideoJNI.releaseBigSightDataBufferLock(this.isY);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.mmsight.model.a.m.a.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(89513);
                                if (m.this.irX != null) {
                                    m.this.irX.bqP();
                                }
                                AppMethodBeat.o(89513);
                            }
                        });
                        Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCaptureMuxError");
                        h.INSTANCE.idkeyStat(440, 30, 1, false);
                        return;
                    } else if ((m.this.iqo && m.this.isQ) || ((!m.this.isQ && !m.this.iqo) || ((m.this.iqo && Math.abs(m.this.irL - m.this.irW) == 0) || m.this.irW == 180))) {
                        long currentTicks4 = Util.currentTicks();
                        if (!m.this.isQ && !m.this.iqo) {
                            i2 = m.this.irL;
                        } else if (m.this.isQ) {
                            i2 = m.this.irW;
                        } else {
                            i2 = TXLiveConstants.RENDER_ROTATION_180;
                        }
                        if (m.this.irW == 180 && !m.this.isQ && (i2 = i2 + TXLiveConstants.RENDER_ROTATION_180) > 360) {
                            i2 -= 360;
                        }
                        if (i2 > 0) {
                            SightVideoJNI.tagRotateVideoVFS(m.this.iry, m.this.irN, i2);
                            Log.i("MicroMsg.MMSightFFMpegRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", Long.valueOf(Util.ticksToNow(currentTicks4)), Integer.valueOf(m.this.irL), Boolean.valueOf(m.this.iqo), Integer.valueOf(m.this.irW), Integer.valueOf(i2));
                            final String str = m.this.irN;
                            try {
                                s.nw(m.this.irN, m.this.iry);
                                ThreadPool.post(new Runnable() {
                                    /* class com.tencent.mm.plugin.mmsight.model.a.m.a.AnonymousClass3 */

                                    public final void run() {
                                        AppMethodBeat.i(89515);
                                        try {
                                            s.deleteFile(str);
                                            AppMethodBeat.o(89515);
                                        } catch (Exception e2) {
                                            Log.e("MicroMsg.MMSightFFMpegRecorder", "stop, delete old file error: %s", e2.getMessage());
                                            AppMethodBeat.o(89515);
                                        }
                                    }
                                }, "BigSightFFMpegRecorder_tagRotate_after_process");
                                Log.i("MicroMsg.MMSightFFMpegRecorder", "tag rotate used %sms", Long.valueOf(Util.ticksToNow(currentTicks4)));
                            } catch (Exception e3) {
                                Log.e("MicroMsg.MMSightFFMpegRecorder", "stop, copy file error");
                                SightVideoJNI.releaseBigSightDataBufferLock(this.isY);
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.mmsight.model.a.m.a.AnonymousClass2 */

                                    public final void run() {
                                        AppMethodBeat.i(89514);
                                        if (m.this.irX != null) {
                                            m.this.irX.bqP();
                                        }
                                        AppMethodBeat.o(89514);
                                    }
                                });
                                AppMethodBeat.o(89517);
                                return;
                            }
                        }
                    }
                }
                SightVideoJNI.releaseBigSightDataBufferLock(this.isY);
                Log.i("MicroMsg.MMSightFFMpegRecorder", "all finish, callback: %s", this.callback);
                m.this.reset();
                MMHandlerThread.postToMainThread(this.callback);
                this.itd = true;
                m.this.isP = -1;
                m.this.isO = -1;
                AppMethodBeat.o(89517);
            }
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "MicroMsg.MMSightFFMpegRecorder";
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final d.c aQN() {
        return this.irK.zwJ;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final long aQM() {
        AppMethodBeat.i(89525);
        long aMm = this.isJ.aMm();
        AppMethodBeat.o(89525);
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
        AppMethodBeat.i(89526);
        Log.i("MicroMsg.MMSightFFMpegRecorder", "reset");
        this.irK.zwJ = d.c.Stop;
        this.irV = false;
        if (this.isI != null) {
            this.isI.clear();
        }
        if (this.isJ != null) {
            this.isJ.clear();
        }
        clear();
        AppMethodBeat.o(89526);
    }

    private boolean rB(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        AppMethodBeat.i(89527);
        long currentTicks = Util.currentTicks();
        this.isQ = k.zuy.isQ;
        this.irL = i2;
        if (!this.isQ) {
            int i7 = (i2 == 0 || i2 == 180) ? this.irI : this.irJ;
            i4 = (i2 == 0 || i2 == 180) ? this.irJ : this.irI;
            i5 = this.irF;
            i6 = this.irG;
            i3 = i7;
        } else {
            i3 = (i2 == 0 || i2 == 180) ? this.irI : this.irJ;
            i4 = (i2 == 0 || i2 == 180) ? this.irJ : this.irI;
            i5 = (i2 == 0 || i2 == 180) ? this.irF : this.irG;
            if (i2 == 0 || i2 == 180) {
                i6 = this.irG;
            } else {
                i6 = this.irF;
            }
        }
        int initDataBufferForMMSightLock = SightVideoJNI.initDataBufferForMMSightLock(i3, i4, i2, i5, i6, (float) this.irT.fps, this.irH, this.irT.iSV, 8, this.irT.iSU, 23.0f, this.isQ, true, this.irT.duration, false);
        if (initDataBufferForMMSightLock < 0) {
            Log.e("MicroMsg.MMSightFFMpegRecorder", "init failed!");
            l.ejK();
            AppMethodBeat.o(89527);
            return false;
        }
        this.isS = initDataBufferForMMSightLock;
        this.isJ = new q(this.isQ, i2, i5, i6, this.isR);
        int QO = this.isJ.QO(initDataBufferForMMSightLock);
        int i8 = 0;
        int i9 = -1;
        if (CaptureMMProxy.getInstance() != null) {
            i9 = CaptureMMProxy.getInstance().getInt(ar.a.USERINFO_LOCAL_SIGHT_AUDIO_RECORDER_TYPE_INT_SYNC, -1);
        }
        if (i9 < 0) {
            this.isI = new g(this.irT.audioSampleRate, this.irT.audioBitrate, this.irT.audioChannelCount, com.tencent.mm.plugin.sight.base.b.ak(true, this.irT.iTs == 1));
            this.isI.rc(this.isT);
            int H = this.isI.H(initDataBufferForMMSightLock, e.aNv(this.iry));
            if (QO < 0 || H < 0) {
                Log.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", Integer.valueOf(QO), Integer.valueOf(H));
                if (H < 0 && QO >= 0) {
                    Log.w("MicroMsg.MMSightFFMpegRecorder", "aac init error, try mediarecorder now");
                    this.isI.clear();
                    this.isI = new i(this.irT.audioSampleRate, this.irT.audioBitrate, this.irT.audioChannelCount);
                    this.isI.rc(this.isT);
                    int H2 = this.isI.H(initDataBufferForMMSightLock, e.aNv(this.iry));
                    Log.w("MicroMsg.MMSightFFMpegRecorder", "MMSightAACMediaRecorder init ret: %s", Integer.valueOf(H2));
                    if (H2 >= 0) {
                        AppMethodBeat.o(89527);
                        return true;
                    }
                }
                SightVideoJNI.releaseBigSightDataBufferLock(initDataBufferForMMSightLock);
                l.ejK();
                AppMethodBeat.o(89527);
                return false;
            }
        } else {
            if (i9 == 1) {
                this.isI = new g(this.irT.audioSampleRate, this.irT.audioBitrate, this.irT.audioChannelCount, com.tencent.mm.plugin.sight.base.b.ak(true, this.irT.iTs == 1));
                this.isI.rc(this.isT);
                i8 = this.isI.H(initDataBufferForMMSightLock, e.aNv(this.iry));
            } else if (i9 == 2) {
                this.isI = new i(this.irT.audioSampleRate, this.irT.audioBitrate, this.irT.audioChannelCount);
                this.isI.rc(this.isT);
                i8 = this.isI.H(initDataBufferForMMSightLock, e.aNv(this.iry));
            }
            if (QO < 0 || i8 < 0) {
                Log.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", Integer.valueOf(QO), Integer.valueOf(i8));
                SightVideoJNI.releaseBigSightDataBufferLock(initDataBufferForMMSightLock);
                l.ejK();
                AppMethodBeat.o(89527);
                return false;
            }
        }
        Log.i("MicroMsg.MMSightFFMpegRecorder", "initImpl used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(89527);
        return true;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final boolean rC(int i2) {
        AppMethodBeat.i(89528);
        if (!this.htU) {
            Log.i("MicroMsg.MMSightFFMpegRecorder", "preInit, cameraOrientation: %s", Integer.valueOf(i2));
            boolean rB = rB(i2);
            this.htU = true;
            Log.i("MicroMsg.MMSightFFMpegRecorder", "initImpl result: %s", Boolean.valueOf(rB));
            AppMethodBeat.o(89528);
            return rB;
        }
        AppMethodBeat.o(89528);
        return true;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void setMirror(boolean z) {
        this.isR = z;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final int b(int i2, boolean z, int i3) {
        boolean z2;
        int i4;
        AppMethodBeat.i(89529);
        Log.i("MicroMsg.MMSightFFMpegRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s", this.irK.zwJ, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3));
        this.iqo = z;
        this.irz = 0;
        this.irW = i3;
        this.irK.a(d.c.WaitStart);
        Object[] objArr = new Object[3];
        objArr[0] = this.iry;
        objArr[1] = Boolean.valueOf(this.zwl == null);
        if (this.zwl == null || this.zwl.itd) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[2] = Boolean.valueOf(z2);
        Log.i("MicroMsg.MMSightFFMpegRecorder", "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]", objArr);
        if (this.zwl != null && !this.zwl.itd) {
            Log.w("MicroMsg.MMSightFFMpegRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
            AppMethodBeat.o(89529);
            return -1;
        } else if (Util.isNullOrNil(this.iry)) {
            Log.e("MicroMsg.MMSightFFMpegRecorder", "start error, mCurRecordPath is null!!");
            AppMethodBeat.o(89529);
            return -1;
        } else {
            this.mFileName = s.bpb(this.iry);
            Log.i("MicroMsg.MMSightFFMpegRecorder", "mCurRecordPath: %s", this.iry);
            this.irL = i2;
            Log.i("MicroMsg.MMSightFFMpegRecorder", "start, cameraOrientation: %s", Integer.valueOf(this.irL));
            if (!this.htU) {
                rB(i2);
                this.htU = true;
            }
            this.isJ.start();
            if (!this.isT) {
                i4 = this.isI.a(new c.a() {
                    /* class com.tencent.mm.plugin.mmsight.model.a.m.AnonymousClass5 */

                    @Override // com.tencent.mm.plugin.mmsight.model.a.c.a
                    public final void aQY() {
                        AppMethodBeat.i(89510);
                        m.this.aQY();
                        AppMethodBeat.o(89510);
                    }
                });
            } else {
                i4 = 0;
            }
            Log.i("MicroMsg.MMSightFFMpegRecorder", "start aac recorder ret: %d", Integer.valueOf(i4));
            this.isM = com.tencent.f.c.d.hA("BigSightWriteCameraData", 0);
            this.isM.start();
            this.isN = new MMHandler(this.isM.getLooper()) {
                /* class com.tencent.mm.plugin.mmsight.model.a.m.AnonymousClass6 */

                @Override // com.tencent.mm.sdk.platformtools.MMHandler
                public final void handleMessage(Message message) {
                    q qVar;
                    int length;
                    int i2;
                    int i3;
                    byte[] bArr;
                    AppMethodBeat.i(89511);
                    if (m.this.isO == -1) {
                        m.this.isO = Process.myTid();
                        Log.i("MicroMsg.MMSightFFMpegRecorder", "writeCameraTid: %s", Integer.valueOf(m.this.isO));
                    }
                    if (message.what == 1) {
                        m.this.isI.ejW();
                        m mVar = m.this;
                        byte[] bArr2 = (byte[]) message.obj;
                        if (mVar.isQ) {
                            qVar = mVar.isJ;
                            length = bArr2.length;
                            i3 = mVar.irI;
                            i2 = mVar.irJ;
                            bArr = bArr2;
                        } else {
                            qVar = mVar.isJ;
                            length = bArr2.length;
                            int i4 = (mVar.irL == 0 || mVar.irL == 180) ? mVar.irI : mVar.irJ;
                            if (mVar.irL == 0 || mVar.irL == 180) {
                                i2 = mVar.irJ;
                                i3 = i4;
                                bArr = bArr2;
                            } else {
                                i2 = mVar.irI;
                                i3 = i4;
                                bArr = bArr2;
                            }
                        }
                        qVar.f(bArr, length, i3, i2);
                        k.zwi.k(bArr2);
                        mVar.irV = true;
                    }
                    AppMethodBeat.o(89511);
                }
            };
            this.irV = false;
            if (i4 != 0) {
                this.irK.a(d.c.Error);
            } else {
                this.irK.a(d.c.Initialized);
            }
            l.ejJ();
            Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCapture");
            h.INSTANCE.idkeyStat(440, 1, 1, false);
            if (this.isT) {
                aQY();
            }
            AppMethodBeat.o(89529);
            return i4;
        }
    }

    /* access modifiers changed from: package-private */
    public final void aQY() {
        AppMethodBeat.i(89530);
        Log.i("MicroMsg.MMSightFFMpegRecorder", "ashutest::pcm ready");
        if (this.zwl != null && !this.zwl.itd) {
            Log.e("MicroMsg.MMSightFFMpegRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", this.zwl);
            synchronized (this.zwl.ite) {
                try {
                    rE(this.zwl.isY);
                } catch (Throwable th) {
                    AppMethodBeat.o(89530);
                    throw th;
                }
            }
        }
        if (this.irK.zwJ != d.c.Initialized) {
            Log.w("MicroMsg.MMSightFFMpegRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
            AppMethodBeat.o(89530);
            return;
        }
        this.irK.a(d.c.Start);
        this.zwl = new a();
        this.zwl.isY = this.isS;
        ThreadPool.post(this.zwl, "SightCustomAsyncMediaRecorder_encode_" + Util.currentTicks(), 5);
        AppMethodBeat.o(89530);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final int aQO() {
        AppMethodBeat.i(89531);
        int round = Math.round(((float) this.irz) / 1000.0f);
        AppMethodBeat.o(89531);
        return round;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final Point aQP() {
        AppMethodBeat.i(89532);
        Point point = new Point(this.irI, this.irJ);
        AppMethodBeat.o(89532);
        return point;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final int aQQ() {
        return this.irL;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void pause() {
        AppMethodBeat.i(89533);
        Log.i("MicroMsg.MMSightFFMpegRecorder", "pause");
        if (this.irK != null && this.irK.zwJ == d.c.Start) {
            this.irK.a(d.c.Pause);
        }
        AppMethodBeat.o(89533);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void M(int i2, int i3, int i4) {
        AppMethodBeat.i(89534);
        Log.i("MicroMsg.MMSightFFMpegRecorder", "resume, cameraOrientation: %s", Integer.valueOf(i2));
        if (this.irK != null && this.irK.zwJ == d.c.Pause) {
            if (this.isJ != null) {
                this.isJ.M(i2, i3, i4);
            }
            this.irK.a(d.c.Start);
        }
        AppMethodBeat.o(89534);
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
        AppMethodBeat.i(89535);
        if (this.isI != null) {
            c.a ejX = this.isI.ejX();
            AppMethodBeat.o(89535);
            return ejX;
        }
        AppMethodBeat.o(89535);
        return null;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void aQT() {
        this.isa = false;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void setMute(boolean z) {
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void rD(int i2) {
        AppMethodBeat.i(89536);
        Log.i("MicroMsg.MMSightFFMpegRecorder", "overrideDurationMs: %s", Integer.valueOf(i2));
        this.irB = i2;
        AppMethodBeat.o(89536);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void av(float f2) {
        AppMethodBeat.i(89537);
        Log.i("MicroMsg.MMSightFFMpegRecorder", "overrideFps: %s", Float.valueOf(f2));
        this.irC = f2;
        AppMethodBeat.o(89537);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final float aQL() {
        return this.irA;
    }

    static /* synthetic */ void a(m mVar, Runnable runnable) {
        AppMethodBeat.i(89538);
        mVar.irK.a(d.c.WaitStop);
        if (mVar.isJ != null) {
            int i2 = mVar.isJ.zwA;
            float aMm = (((float) mVar.isJ.frameCount) * 1000.0f) / ((float) mVar.isJ.aMm());
            Log.i("MicroMsg.MMSightFFMpegRecorder", "stop, bufID %d, frameCount %d, duration %dms, %.6ffps", Integer.valueOf(i2), Integer.valueOf(mVar.isJ.frameCount), Long.valueOf(mVar.isJ.aMm()), Float.valueOf(aMm));
            mVar.irz = (int) mVar.isJ.aMm();
            mVar.irA = aMm;
            mVar.isJ.stop();
            if (mVar.zwl != null) {
                mVar.zwl.cKu = aMm;
                mVar.zwl.duration = mVar.irz;
                mVar.zwl.callback = runnable;
                mVar.zwl.ita = true;
                mVar.zwl.cancel();
            }
        }
        if (mVar.isI != null && !mVar.isT) {
            mVar.isI.a(new c.b() {
                /* class com.tencent.mm.plugin.mmsight.model.a.m.AnonymousClass4 */

                @Override // com.tencent.mm.plugin.mmsight.model.a.c.b
                public final void aQX() {
                    AppMethodBeat.i(89509);
                    m.this.aQX();
                    AppMethodBeat.o(89509);
                }
            });
        }
        mVar.irK.a(d.c.Stop);
        mVar.md5 = s.bhK(mVar.iry);
        if (mVar.zwl == null) {
            Log.e("MicroMsg.MMSightFFMpegRecorder", "encodeRunnable is null!, directly call stopcallback");
            mVar.reset();
            MMHandlerThread.postToMainThread(runnable);
        }
        if (mVar.isT) {
            mVar.aQX();
        }
        AppMethodBeat.o(89538);
    }
}

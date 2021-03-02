package com.tencent.mm.media.widget.c;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.media.e.g;
import com.tencent.mm.media.i.a;
import com.tencent.mm.media.j.a;
import com.tencent.mm.media.k.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.c;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.a.n;
import com.tencent.mm.plugin.mmsight.model.a.t;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.x;

public final class d implements b {
    protected int bufId;
    protected boolean htU;
    private EGLContext ilv;
    private boolean ipv;
    protected boolean iqo;
    protected float irA;
    private int irB;
    private float irC;
    protected c irD;
    protected int irF;
    protected int irG;
    protected int irH;
    protected int irI;
    protected int irJ;
    protected t irK;
    protected int irL;
    protected String irN;
    protected boolean irO;
    protected String irP;
    protected boolean irQ;
    protected com.tencent.mm.plugin.mmsight.model.c irR;
    protected com.tencent.mm.plugin.mmsight.model.c irS;
    protected VideoTransPara irT;
    protected n irU;
    protected boolean irV;
    protected int irW;
    protected d.a irX;
    protected Runnable irY;
    protected boolean irZ;
    final Object irx;
    protected String iry;
    protected int irz;
    protected g isB;
    a isC;
    public b isD;
    protected boolean isa;
    protected boolean isb;
    com.tencent.mm.media.i.a ise;
    protected com.tencent.mm.plugin.mmsight.model.g iss;
    protected String mFileName;
    protected String md5;
    protected String thumbPath;

    private d(VideoTransPara videoTransPara) {
        AppMethodBeat.i(93409);
        this.irx = new Object();
        this.iry = "";
        this.irz = 0;
        this.irA = 0.0f;
        this.irB = -1;
        this.irC = -1.0f;
        this.irF = 480;
        this.irG = 640;
        this.irH = 1600000;
        this.irI = 480;
        this.irJ = 640;
        this.bufId = -1;
        this.irN = null;
        this.irO = false;
        this.thumbPath = null;
        this.irP = null;
        this.irQ = false;
        this.irR = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
        this.irS = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
        this.htU = false;
        this.irV = false;
        this.md5 = "";
        this.iqo = false;
        this.irW = 0;
        this.irY = null;
        this.irZ = false;
        this.isa = true;
        this.isb = false;
        this.ipv = false;
        this.ise = null;
        this.ilv = null;
        this.isC = null;
        this.iss = new com.tencent.mm.plugin.mmsight.model.g() {
            /* class com.tencent.mm.media.widget.c.d.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.mmsight.model.g
            public final boolean ai(byte[] bArr) {
                AppMethodBeat.i(93399);
                if (bArr == null || bArr.length <= 0) {
                    Log.e("MicroMsg.Media.X264MP4MuxRecorder", "preview callback data is null");
                    AppMethodBeat.o(93399);
                    return false;
                } else if (d.this.irK.zwJ == d.c.Start || d.this.irK.zwJ == d.c.PrepareStop) {
                    if (d.this.irK.zwJ == d.c.PrepareStop) {
                        d.this.irK.zwJ = d.c.WaitStop;
                        Log.v("MicroMsg.Media.X264MP4MuxRecorder", "forward one more frame");
                    }
                    d.this.irS.Hi(1);
                    if (d.this.irD != null) {
                        d.this.irD.ejW();
                    }
                    d.this.ise.a(bArr, System.nanoTime(), new b<byte[], x>() {
                        /* class com.tencent.mm.media.widget.c.d.AnonymousClass1.AnonymousClass1 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // kotlin.g.a.b
                        public final /* synthetic */ x invoke(byte[] bArr) {
                            AppMethodBeat.i(93398);
                            k.zwi.k(bArr);
                            AppMethodBeat.o(93398);
                            return null;
                        }
                    });
                    d.this.irR.Hi(1);
                    AppMethodBeat.o(93399);
                    return true;
                } else {
                    AppMethodBeat.o(93399);
                    return false;
                }
            }
        };
        this.isD = new b<Integer, x>() {
            /* class com.tencent.mm.media.widget.c.d.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Integer num) {
                AppMethodBeat.i(93400);
                Integer num2 = num;
                if (d.this.irK.zwJ == d.c.Start || d.this.irK.zwJ == d.c.PrepareStop) {
                    if (d.this.irK.zwJ == d.c.PrepareStop) {
                        d.this.irK.zwJ = d.c.WaitStop;
                        Log.v("MicroMsg.Media.X264MP4MuxRecorder", "forward one more frame");
                    }
                    d.this.irS.Hi(1);
                    if (d.this.irD != null) {
                        d.this.irD.ejW();
                    }
                    d.this.ise.x(num2.intValue(), System.nanoTime());
                    d.this.irR.Hi(1);
                }
                AppMethodBeat.o(93400);
                return null;
            }
        };
        this.irT = videoTransPara;
        this.irF = videoTransPara.width;
        this.irG = videoTransPara.height;
        this.irK = new t();
        Log.d("MicroMsg.Media.X264MP4MuxRecorder", "create X264MP4MuxRecorder, targetWidth: %s, targetHeight: %s", Integer.valueOf(this.irF), Integer.valueOf(this.irG));
        AppMethodBeat.o(93409);
    }

    public d(VideoTransPara videoTransPara, a aVar) {
        this(videoTransPara);
        AppMethodBeat.i(93410);
        this.ilv = null;
        this.isC = aVar;
        this.ise = new com.tencent.mm.media.i.a(aVar);
        e eVar = e.ilC;
        e.aNt();
        AppMethodBeat.o(93410);
    }

    private boolean rB(int i2) {
        AppMethodBeat.i(93411);
        long currentTicks = Util.currentTicks();
        this.irH = this.irT.videoBitrate;
        if (this.irF % 2 != 0) {
            this.irF++;
        }
        if (this.irG % 2 != 0) {
            this.irG++;
        }
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "real width:%d, height:%d", Integer.valueOf(this.irF), Integer.valueOf(this.irG));
        this.bufId = SightVideoJNI.initDataBufferForMMSightLock(this.irI, this.irJ, i2, this.irF, this.irG, (float) this.irT.fps, this.irH, this.irT.iSV, 8, this.irT.iSU, 23.0f, false, true, this.irT.duration, false);
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "init, bufId: %s", Integer.valueOf(this.bufId));
        if (this.bufId < 0) {
            Log.e("MicroMsg.Media.X264MP4MuxRecorder", "init failed!");
            AppMethodBeat.o(93411);
            return false;
        }
        this.irL = i2;
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "mTargetRate " + this.irH + "  videoParams.fps: " + this.irT.fps + " mTargetHeight:" + this.irG + " mTargetWidth:" + this.irF);
        this.isB = new g(this.bufId, this.irF, this.irG);
        com.tencent.mm.media.i.a aVar = this.ise;
        EGLContext eGLContext = this.ilv;
        int i3 = this.irF;
        int i4 = this.irG;
        AnonymousClass3 r7 = new b<Boolean, x>() {
            /* class com.tencent.mm.media.widget.c.d.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(93401);
                e eVar = e.ilC;
                e.aNv();
                AppMethodBeat.o(93401);
                return null;
            }
        };
        Log.i(aVar.TAG, aVar.hashCode() + " initWithSize, eglContext: " + eGLContext + ", callback: false, width:" + i3 + ", height:" + i4);
        aVar.k(new a.c(aVar, eGLContext, i3, i4, r7));
        this.ise.ihb = new b<Boolean, x>() {
            /* class com.tencent.mm.media.widget.c.d.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(93404);
                x aQZ = aQZ();
                AppMethodBeat.o(93404);
                return aQZ;
            }

            private x aQZ() {
                IntBuffer intBuffer;
                AppMethodBeat.i(93403);
                synchronized (d.this.irx) {
                    try {
                        if (d.this.isB != null) {
                            com.tencent.mm.media.j.b.a aVar = d.this.isC.ijo;
                            if (aVar != null) {
                                ByteBuffer byteBuffer = aVar.ijF;
                                if (byteBuffer != null) {
                                    intBuffer = byteBuffer.asIntBuffer();
                                } else {
                                    intBuffer = null;
                                }
                            } else {
                                intBuffer = null;
                            }
                            if (intBuffer != null) {
                                intBuffer.position(0);
                                int[] iArr = new int[intBuffer.remaining()];
                                intBuffer.get(iArr);
                                g gVar = d.this.isB;
                                int i2 = d.this.irF;
                                int i3 = d.this.irG;
                                p.h(iArr, "data");
                                if (gVar.bufId < 0) {
                                    Log.e("MicroMsg.X264TransEncoder", "writeRGBData error, buffId error");
                                } else {
                                    synchronized (gVar.stopLock) {
                                        try {
                                            gVar.ify.postToWorker(new g.c(gVar, i2, i3, iArr));
                                        } catch (Throwable th) {
                                            AppMethodBeat.o(93403);
                                            throw th;
                                        }
                                    }
                                }
                            }
                        }
                        if (d.this.isB != null && d.this.irK.zwJ == d.c.WaitStop) {
                            d.this.isB.stop(false);
                            if (d.this.irD != null) {
                                d.this.irD.a(new c.b() {
                                    /* class com.tencent.mm.media.widget.c.d.AnonymousClass4.AnonymousClass1 */

                                    @Override // com.tencent.mm.plugin.mmsight.model.a.c.b
                                    public final void aQX() {
                                        AppMethodBeat.i(93402);
                                        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "aac stop finish");
                                        AppMethodBeat.o(93402);
                                    }
                                });
                            }
                            d.this.ise.release();
                            d dVar = d.this;
                            Log.printInfoStack("MicroMsg.Media.X264MP4MuxRecorder", "stopImpl", new Object[0]);
                            ThreadPool.post(new Runnable() {
                                /* class com.tencent.mm.media.widget.c.d.AnonymousClass6 */

                                public final void run() {
                                    AppMethodBeat.i(93407);
                                    synchronized (d.this.irx) {
                                        try {
                                            boolean a2 = d.a(d.this);
                                            Log.i("MicroMsg.Media.X264MP4MuxRecorder", "stopImpl result: %s", Boolean.valueOf(a2));
                                            if (a2) {
                                                e eVar = e.ilC;
                                                e.aNA();
                                                d.a(d.this, com.tencent.mm.plugin.mmsight.d.PF(d.this.iry));
                                                try {
                                                    com.tencent.mm.plugin.sight.base.a aNx = com.tencent.mm.plugin.sight.base.e.aNx(d.this.iry);
                                                    if (aNx != null) {
                                                        e eVar2 = e.ilC;
                                                        e.dd(aNx.videoBitrate, aNx.frameRate);
                                                    }
                                                } catch (Exception e2) {
                                                }
                                                if (d.this.irY != null) {
                                                    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "call stopCallback");
                                                    MMHandlerThread.postToMainThread(d.this.irY);
                                                }
                                            } else {
                                                e eVar3 = e.ilC;
                                                e.aNz();
                                                SightVideoJNI.releaseBigSightDataBufferLock(d.this.bufId);
                                                if (d.this.irX != null) {
                                                    MMHandlerThread.postToMainThread(new Runnable() {
                                                        /* class com.tencent.mm.media.widget.c.d.AnonymousClass6.AnonymousClass1 */

                                                        public final void run() {
                                                            AppMethodBeat.i(93406);
                                                            d.this.irX.bqP();
                                                            AppMethodBeat.o(93406);
                                                        }
                                                    });
                                                }
                                            }
                                            e eVar4 = e.ilC;
                                            e.aNy();
                                        } finally {
                                            AppMethodBeat.o(93407);
                                        }
                                    }
                                }
                            }, "X264MP4MuxRecorder_stop");
                            if (d.this.irK != null) {
                                d.this.irK.a(d.c.Stop);
                            }
                        }
                    } finally {
                        AppMethodBeat.o(93403);
                    }
                }
                return null;
            }
        };
        aQH();
        this.irD = new a(this.irT.audioSampleRate, this.irT.audioBitrate, this.irT.audioChannelCount, com.tencent.mm.plugin.sight.base.b.ak(true, this.irT.iTs == 1));
        this.irD.rc(this.irZ);
        int H = this.irD.H(this.bufId, com.tencent.mm.plugin.sight.base.e.aNv(this.iry));
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "initImpl used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        if (H != 0) {
            e eVar = e.ilC;
            e.aNw();
            AppMethodBeat.o(93411);
            return false;
        }
        AppMethodBeat.o(93411);
        return true;
    }

    private void aQH() {
        AppMethodBeat.i(93412);
        int i2 = this.irF;
        int i3 = this.irG;
        this.ise.cX(i2, i3);
        this.ise.qx(this.irL);
        this.ise.cZ(this.irI, this.irJ);
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "outputWidth: %s, outputHeight: %s, cameraPreviewWidth: %s, cameraPreviewHeight: %s, getDataRotate: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.irI), Integer.valueOf(this.irJ), Integer.valueOf(this.irL));
        AppMethodBeat.o(93412);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final boolean rC(int i2) {
        AppMethodBeat.i(93413);
        if (!this.htU) {
            Log.i("MicroMsg.Media.X264MP4MuxRecorder", "preInit, cameraOrientation");
            boolean rB = rB(i2);
            this.htU = true;
            Log.i("MicroMsg.Media.X264MP4MuxRecorder", "initImpl result: %s", Boolean.valueOf(rB));
            AppMethodBeat.o(93413);
            return rB;
        }
        e eVar = e.ilC;
        e.aNu();
        AppMethodBeat.o(93413);
        return true;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final int b(int i2, boolean z, int i3) {
        int i4;
        AppMethodBeat.i(93414);
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3));
        this.irR.reset();
        this.irz = 0;
        this.irS.reset();
        this.irO = false;
        this.iqo = z;
        this.irW = i3;
        this.irK.a(d.c.WaitStart);
        if (Util.isNullOrNil(this.iry)) {
            Log.e("MicroMsg.Media.X264MP4MuxRecorder", "start error, mCurRecordPath is null!!");
            AppMethodBeat.o(93414);
            return -1;
        }
        try {
            this.mFileName = s.bpb(this.iry);
            String boZ = s.boZ(this.iry);
            if (!boZ.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                boZ = boZ + FilePathGenerator.ANDROID_DIR_SEP;
            }
            this.irN = boZ + "tempRotate.mp4";
        } catch (Exception e2) {
            Log.e("MicroMsg.Media.X264MP4MuxRecorder", "retrieve file name error: %s", e2.getMessage());
        }
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", this.iry, this.irN);
        this.irL = i2;
        if (!this.htU) {
            rB(i2);
            this.htU = true;
        }
        synchronized (this.irx) {
            try {
                this.isB.start();
            } finally {
                AppMethodBeat.o(93414);
            }
        }
        if (this.isb || this.irZ) {
            Log.i("MicroMsg.Media.X264MP4MuxRecorder", "start yuvRecorder with mute");
            this.irK.a(d.c.Start);
            this.irV = false;
            i4 = 0;
        } else {
            i4 = this.irD.a(new c.a() {
                /* class com.tencent.mm.media.widget.c.d.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.mmsight.model.a.c.a
                public final void aQY() {
                    AppMethodBeat.i(93405);
                    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "onPcmReady");
                    if (d.this.aQN() != d.c.Initialized) {
                        Log.w("MicroMsg.Media.X264MP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
                        AppMethodBeat.o(93405);
                        return;
                    }
                    d.this.irK.a(d.c.Start);
                    AppMethodBeat.o(93405);
                }
            });
            Log.i("MicroMsg.Media.X264MP4MuxRecorder", "start aacRecorder ret: %s", Integer.valueOf(i4));
            this.irV = false;
            if (i4 != 0) {
                this.irK.a(d.c.Error);
            } else {
                this.irK.a(d.c.Initialized);
            }
        }
        return i4;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void E(Runnable runnable) {
        AppMethodBeat.i(93415);
        synchronized (this.irx) {
            try {
                this.irY = runnable;
                Log.i("MicroMsg.Media.X264MP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", runnable);
                if (this.isB == null || (this.irD == null && !this.isb)) {
                    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
                    if (runnable != null) {
                        MMHandlerThread.postToMainThread(runnable);
                    }
                } else if (this.irK == null || this.irK.zwJ != d.c.Stop) {
                    this.iss = null;
                    this.irz = (int) Util.ticksToNow(this.isB.startTime);
                    if (this.irK != null) {
                        e eVar = e.ilC;
                        e.aNx();
                        this.irK.a(d.c.PrepareStop);
                    }
                    AppMethodBeat.o(93415);
                } else {
                    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "stop, already in stop videoRecordStatus");
                    if (this.irD != null) {
                        this.irD.clear();
                    }
                    if (runnable != null) {
                        MMHandlerThread.postToMainThread(runnable);
                    }
                    AppMethodBeat.o(93415);
                }
            } finally {
                AppMethodBeat.o(93415);
            }
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final String getMd5() {
        AppMethodBeat.i(93416);
        String nullAs = Util.nullAs(this.md5, "");
        AppMethodBeat.o(93416);
        return nullAs;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void cancel() {
        AppMethodBeat.i(93417);
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "cancel record");
        synchronized (this.irx) {
            try {
                if (this.isB == null || (this.irD == null && !this.isb)) {
                    Log.e("MicroMsg.Media.X264MP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
                    return;
                }
                this.irK.a(d.c.WaitStop);
                this.isB.stop(true);
                if (this.irD != null) {
                    this.irD.a(new c.b() {
                        /* class com.tencent.mm.media.widget.c.d.AnonymousClass7 */

                        @Override // com.tencent.mm.plugin.mmsight.model.a.c.b
                        public final void aQX() {
                            AppMethodBeat.i(93408);
                            Log.i("MicroMsg.Media.X264MP4MuxRecorder", "aac stop finish");
                            AppMethodBeat.o(93408);
                        }
                    });
                }
                if (this.bufId >= 0) {
                    SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
                } else {
                    Log.e("MicroMsg.Media.X264MP4MuxRecorder", "why buf id < 0 ? %d", Integer.valueOf(this.bufId));
                }
                this.irK.a(d.c.Stop);
                reset();
                AppMethodBeat.o(93417);
            } finally {
                AppMethodBeat.o(93417);
            }
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void clear() {
        AppMethodBeat.i(93418);
        try {
            Log.i("MicroMsg.Media.X264MP4MuxRecorder", "clear");
            if (this.irD != null) {
                this.irD.clear();
            }
            if (this.ise != null) {
                this.ise.release();
            }
            if (this.bufId >= 0) {
                SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
            }
            AppMethodBeat.o(93418);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Media.X264MP4MuxRecorder", e2, "clear error: %s", e2.getMessage());
            AppMethodBeat.o(93418);
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
        AppMethodBeat.i(93419);
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", this.isB, this.irD, this.irU);
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s", this.isB, this.irD);
        synchronized (this.irx) {
            try {
                this.isB = null;
            } catch (Throwable th) {
                AppMethodBeat.o(93419);
                throw th;
            }
        }
        this.irD = null;
        this.irU = null;
        this.htU = false;
        this.irV = false;
        AppMethodBeat.o(93419);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final long aQM() {
        AppMethodBeat.i(93420);
        synchronized (this.irx) {
            try {
                if (this.isB != null) {
                    return Util.ticksToNow(this.isB.startTime);
                }
                AppMethodBeat.o(93420);
                return 0;
            } finally {
                AppMethodBeat.o(93420);
            }
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final com.tencent.mm.plugin.mmsight.model.g getFrameDataCallback() {
        return this.iss;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void s(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(93421);
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        if (i4 % 16 != 0) {
            i4 = com.tencent.mm.plugin.mmsight.d.QH(i4);
        }
        if (i5 % 16 != 0) {
            i5 = com.tencent.mm.plugin.mmsight.d.QH(i5);
        }
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", Integer.valueOf(i4), Integer.valueOf(i5));
        this.irI = i2;
        this.irJ = i3;
        if (k.zwi.h(Integer.valueOf(((i2 * i3) * 3) / 2)) == null) {
            Log.i("MicroMsg.Media.X264MP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", Integer.valueOf(i2), Integer.valueOf(i3), 3);
            long currentTicks = Util.currentTicks();
            for (int i6 = 0; i6 < 3; i6++) {
                k.zwi.k(new byte[(((i2 * i3) * 3) / 2)]);
            }
            Log.i("MicroMsg.Media.X264MP4MuxRecorder", "preloadCameraData used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        }
        AppMethodBeat.o(93421);
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
        AppMethodBeat.i(93422);
        int round = Math.round(((float) this.irz) / 1000.0f);
        AppMethodBeat.o(93422);
        return round;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final Point aQP() {
        AppMethodBeat.i(93423);
        Point point = new Point(this.irI, this.irJ);
        AppMethodBeat.o(93423);
        return point;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final int aQQ() {
        return this.irL;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void pause() {
        AppMethodBeat.i(93424);
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "pause");
        if (this.irK != null && this.irK.zwJ == d.c.Start) {
            this.irK.a(d.c.Pause);
        }
        AppMethodBeat.o(93424);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void M(int i2, int i3, int i4) {
        AppMethodBeat.i(93425);
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "resume, cameraOrientation: %s", Integer.valueOf(i2));
        this.irL = i2;
        this.irI = i3;
        this.irJ = i4;
        this.ise.qx(this.irL);
        aQH();
        if (this.irK != null && this.irK.zwJ == d.c.Pause) {
            this.irK.a(d.c.Start);
        }
        AppMethodBeat.o(93425);
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
        AppMethodBeat.i(93426);
        if (this.irD != null) {
            c.a ejX = this.irD.ejX();
            AppMethodBeat.o(93426);
            return ejX;
        }
        AppMethodBeat.o(93426);
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
    public final void setMirror(boolean z) {
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void rD(int i2) {
        AppMethodBeat.i(93427);
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "overrideDurationMs: %s", Integer.valueOf(i2));
        this.irB = i2;
        AppMethodBeat.o(93427);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void av(float f2) {
        AppMethodBeat.i(93428);
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "overrideFps: %s", Float.valueOf(f2));
        this.irC = f2;
        AppMethodBeat.o(93428);
    }

    @Override // com.tencent.mm.media.widget.c.b
    public final void aQG() {
    }

    static /* synthetic */ boolean a(d dVar) {
        AppMethodBeat.i(93429);
        long currentTicks = Util.currentTicks();
        if (dVar.isB == null) {
            AppMethodBeat.o(93429);
            return false;
        }
        int i2 = dVar.isB.frameCount;
        dVar.irA = (((float) i2) * 1000.0f) / ((float) dVar.irz);
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", Integer.valueOf(i2), Float.valueOf(dVar.irA), Integer.valueOf(dVar.irz), dVar.iry, Long.valueOf(Util.ticksToNow(currentTicks)), Integer.valueOf(dVar.irB), Float.valueOf(dVar.irC));
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "frameCountCallback %s", dVar.irS.getValue());
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "yuvRecorderWriteDataCallback %s", dVar.irR.getValue());
        String str = null;
        if (CaptureMMProxy.getInstance() != null) {
            str = CaptureMMProxy.getInstance().getAccVideoPath();
        } else if (!Util.isNullOrNil(dVar.iry)) {
            str = aa.z(new o(dVar.iry).heq().her());
        }
        String aFk = !Util.isNullOrNil(str) ? com.tencent.mm.plugin.mmsight.d.aFk(str) : dVar.iry;
        int i3 = dVar.irz;
        if (dVar.irB > 0) {
            i3 = dVar.irB;
        }
        float f2 = dVar.irA;
        if (dVar.irC > 0.0f) {
            f2 = dVar.irC;
        }
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "muxResultPath : ".concat(String.valueOf(aFk)));
        n nVar = new n(dVar.bufId, aFk, f2, dVar.irH, i3, dVar.irT.audioSampleRate, dVar.isb, true, dVar.irT.iTs == 1);
        long currentTicks2 = Util.currentTicks();
        boolean ejY = nVar.ejY();
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "mux used %sms, success: %s", Long.valueOf(Util.ticksToNow(currentTicks2)), Boolean.valueOf(ejY));
        if (!ejY) {
            Log.e("MicroMsg.Media.X264MP4MuxRecorder", "mux failed!");
            l.ejM();
            AppMethodBeat.o(93429);
            return false;
        }
        SightVideoJNI.releaseBigSightDataBufferLock(dVar.bufId);
        dVar.irK.a(d.c.Stop);
        dVar.md5 = s.bhK(aFk);
        if (!Util.isNullOrNil(aFk) && !aFk.equals(dVar.iry)) {
            s.nx(aFk, dVar.iry);
            s.deleteFile(aFk);
        }
        AppMethodBeat.o(93429);
        return true;
    }

    static /* synthetic */ void a(d dVar, Bitmap bitmap) {
        AppMethodBeat.i(93430);
        if (bitmap == null) {
            Log.e("MicroMsg.Media.X264MP4MuxRecorder", "saveVideoThumbImpl with null bitmap");
            AppMethodBeat.o(93430);
            return;
        }
        try {
            BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.JPEG, dVar.thumbPath, true);
            Log.i("MicroMsg.Media.X264MP4MuxRecorder", "saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s %s", dVar.thumbPath, Integer.valueOf(dVar.irL), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Long.valueOf(s.boW(dVar.thumbPath)));
            AppMethodBeat.o(93430);
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.Media.X264MP4MuxRecorder", e2, "", new Object[0]);
            AppMethodBeat.o(93430);
        }
    }
}

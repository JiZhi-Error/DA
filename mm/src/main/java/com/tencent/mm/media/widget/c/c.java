package com.tencent.mm.media.widget.c;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.opengl.EGLContext;
import android.util.Pair;
import android.view.Surface;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.media.e.b;
import com.tencent.mm.media.i.a;
import com.tencent.mm.media.k.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.c;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.a.n;
import com.tencent.mm.plugin.mmsight.model.a.t;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.x;

public final class c implements b {
    private static final Object isn = new Object();
    protected int bufId;
    private int dtsCount;
    protected boolean htU;
    private EGLContext ilv;
    private boolean ipv;
    protected boolean iqo;
    protected float irA;
    private int irB;
    private float irC;
    protected com.tencent.mm.plugin.mmsight.model.a.c irD;
    protected b irE;
    protected int irF;
    protected int irG;
    protected int irH;
    protected int irI;
    protected int irJ;
    protected t irK;
    protected int irL;
    protected boolean irM;
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
    private final Object irx;
    protected String iry;
    protected int irz;
    protected boolean isa;
    protected boolean isb;
    private long isc;
    private a isd;
    private com.tencent.mm.media.i.a ise;
    private long isf;
    private long isg;
    public boolean ish;
    private double isi;
    private long isj;
    private long isk;
    private long isl;
    private boolean ism;
    private LinkedList<Long> iso;
    private long isp;
    private int isq;
    private Runnable isr;
    protected g iss;
    protected String mFileName;
    protected String md5;
    private boolean released;
    private SurfaceTexture surfaceTexture;
    private int textureId;
    protected String thumbPath;

    public interface a {
        void zV(long j2);
    }

    static /* synthetic */ long b(c cVar) {
        long j2 = cVar.isc;
        cVar.isc = 1 + j2;
        return j2;
    }

    static /* synthetic */ int e(c cVar) {
        int i2 = cVar.isq;
        cVar.isq = i2 + 1;
        return i2;
    }

    static /* synthetic */ boolean g(c cVar) {
        AppMethodBeat.i(218969);
        boolean aQI = cVar.aQI();
        AppMethodBeat.o(218969);
        return aQI;
    }

    static {
        AppMethodBeat.i(93397);
        AppMethodBeat.o(93397);
    }

    public c(VideoTransPara videoTransPara, com.tencent.mm.media.j.a aVar) {
        this(videoTransPara, aVar, null, -1, null);
    }

    public c(VideoTransPara videoTransPara, com.tencent.mm.media.j.a aVar, EGLContext eGLContext, int i2, a aVar2) {
        AppMethodBeat.i(93366);
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
        this.irM = false;
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
        this.isc = 0;
        this.isd = null;
        this.ise = null;
        this.ilv = null;
        this.textureId = -1;
        this.isf = 0;
        this.isg = 0;
        this.ish = false;
        this.isi = 0.0d;
        this.isj = 0;
        this.isk = 0;
        this.isl = 0;
        this.ism = false;
        this.iso = new LinkedList<>();
        this.isp = -1;
        this.dtsCount = 0;
        this.isq = 0;
        this.released = false;
        this.isr = new Runnable() {
            /* class com.tencent.mm.media.widget.c.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(218954);
                Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "frame to stop timeout");
                c.this.irK.zwJ = d.c.WaitStop;
                com.tencent.mm.media.i.a aVar = c.this.ise;
                AnonymousClass1 r2 = new kotlin.g.a.a<x>() {
                    /* class com.tencent.mm.media.widget.c.c.AnonymousClass1.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(218953);
                        if (c.this.irE != null) {
                            Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] final frame draw");
                            c.this.irE.aMi();
                            if (c.this.irD != null) {
                                c.this.irD.a(new c.b() {
                                    /* class com.tencent.mm.media.widget.c.c.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                    @Override // com.tencent.mm.plugin.mmsight.model.a.c.b
                                    public final void aQX() {
                                        AppMethodBeat.i(218952);
                                        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] aac stop finish");
                                        AppMethodBeat.o(218952);
                                    }
                                });
                            }
                            c.this.ise.release();
                        }
                        AppMethodBeat.o(218953);
                        return null;
                    }
                };
                p.h(r2, "callback");
                aVar.k(new a.j(r2));
                AppMethodBeat.o(218954);
            }
        };
        this.iss = new g() {
            /* class com.tencent.mm.media.widget.c.c.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.mmsight.model.g
            public final boolean ai(byte[] bArr) {
                AppMethodBeat.i(218956);
                c.a(c.this, bArr);
                AppMethodBeat.o(218956);
                return false;
            }
        };
        a(videoTransPara);
        this.isd = aVar2;
        this.ilv = eGLContext;
        this.ise = new com.tencent.mm.media.i.a(aVar);
        this.textureId = i2;
        Log.printInfoStack("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureId : " + i2, new Object[0]);
        AppMethodBeat.o(93366);
    }

    public c(VideoTransPara videoTransPara, com.tencent.mm.media.j.a aVar, EGLContext eGLContext, int i2) {
        AppMethodBeat.i(93367);
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
        this.irM = false;
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
        this.isc = 0;
        this.isd = null;
        this.ise = null;
        this.ilv = null;
        this.textureId = -1;
        this.isf = 0;
        this.isg = 0;
        this.ish = false;
        this.isi = 0.0d;
        this.isj = 0;
        this.isk = 0;
        this.isl = 0;
        this.ism = false;
        this.iso = new LinkedList<>();
        this.isp = -1;
        this.dtsCount = 0;
        this.isq = 0;
        this.released = false;
        this.isr = new Runnable() {
            /* class com.tencent.mm.media.widget.c.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(218954);
                Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "frame to stop timeout");
                c.this.irK.zwJ = d.c.WaitStop;
                com.tencent.mm.media.i.a aVar = c.this.ise;
                AnonymousClass1 r2 = new kotlin.g.a.a<x>() {
                    /* class com.tencent.mm.media.widget.c.c.AnonymousClass1.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(218953);
                        if (c.this.irE != null) {
                            Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] final frame draw");
                            c.this.irE.aMi();
                            if (c.this.irD != null) {
                                c.this.irD.a(new c.b() {
                                    /* class com.tencent.mm.media.widget.c.c.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                    @Override // com.tencent.mm.plugin.mmsight.model.a.c.b
                                    public final void aQX() {
                                        AppMethodBeat.i(218952);
                                        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] aac stop finish");
                                        AppMethodBeat.o(218952);
                                    }
                                });
                            }
                            c.this.ise.release();
                        }
                        AppMethodBeat.o(218953);
                        return null;
                    }
                };
                p.h(r2, "callback");
                aVar.k(new a.j(r2));
                AppMethodBeat.o(218954);
            }
        };
        this.iss = new g() {
            /* class com.tencent.mm.media.widget.c.c.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.mmsight.model.g
            public final boolean ai(byte[] bArr) {
                AppMethodBeat.i(218956);
                c.a(c.this, bArr);
                AppMethodBeat.o(218956);
                return false;
            }
        };
        a(videoTransPara);
        this.ilv = eGLContext;
        this.ise = new com.tencent.mm.media.i.a(aVar);
        this.textureId = i2;
        Log.printInfoStack("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureId : " + i2, new Object[0]);
        AppMethodBeat.o(93367);
    }

    private void a(VideoTransPara videoTransPara) {
        AppMethodBeat.i(93368);
        this.isc = 0;
        this.irT = videoTransPara;
        this.irF = videoTransPara.width;
        this.irG = videoTransPara.height;
        this.irK = new t();
        e eVar = e.ilC;
        e.aNB();
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] create MediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s", Integer.valueOf(this.irF), Integer.valueOf(this.irG));
        AppMethodBeat.o(93368);
    }

    private boolean rB(int i2) {
        boolean z;
        AppMethodBeat.i(93369);
        this.released = false;
        long currentTicks = Util.currentTicks();
        this.irH = this.irT.videoBitrate;
        if (this.irT.iTr == 1) {
            z = true;
        } else {
            z = false;
        }
        com.tencent.mm.media.b.d dVar = new com.tencent.mm.media.b.d(z);
        if (dVar.idC) {
            Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] encodeConfig  InitError");
            e eVar = e.ilC;
            e.aNJ();
            AppMethodBeat.o(93369);
            return false;
        }
        this.irM = p.j(dVar.mimeType, TPDecoderType.TP_CODEC_MIMETYPE_HEVC);
        this.bufId = SightVideoJNI.initDataBufferForMMSightLock(this.irI, this.irJ, i2, this.irF, this.irG, (float) this.irT.fps, this.irH, this.irT.iSV, 8, this.irT.iSU, 23.0f, false, false, this.irT.duration, false, this.irM, com.tencent.mm.plugin.sight.base.b.ak(false, this.irM));
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] init, bufId: %s", Integer.valueOf(this.bufId));
        if (this.bufId < 0) {
            Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] init failed!");
            e eVar2 = e.ilC;
            e.aNC();
            AppMethodBeat.o(93369);
            return false;
        }
        this.irL = i2;
        this.irG = com.tencent.mm.plugin.mmsight.d.QH(this.irG);
        this.irF = com.tencent.mm.plugin.mmsight.d.QH(this.irF);
        if (this.irM && dVar.mimeType.equals(TPDecoderType.TP_CODEC_MIMETYPE_HEVC)) {
            e eVar3 = e.ilC;
            e.aOs();
        }
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mTargetRate " + this.irH + "  videoParams.fps: " + this.irT.fps + " mTargetHeight:" + this.irG + " mTargetWidth:" + this.irF + ", minQP:" + this.irT.idF + ", maxQP:" + this.irT.idG);
        dVar.bitrate = this.irH;
        dVar.frameRate = this.irT.fps;
        dVar.targetHeight = this.irG;
        dVar.targetWidth = this.irF;
        dVar.idG = this.irT.idG;
        dVar.idF = this.irT.idF;
        try {
            final long j2 = (long) (1000 / this.irT.fps);
            this.irE = new com.tencent.mm.media.e.e(dVar, new kotlin.g.a.b<b, x>() {
                /* class com.tencent.mm.media.widget.c.c.AnonymousClass4 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(b bVar) {
                    AppMethodBeat.i(93358);
                    b bVar2 = bVar;
                    e eVar = e.ilC;
                    e.aOi();
                    bVar2.ifb = new m<ByteBuffer, MediaCodec.BufferInfo, x>() {
                        /* class com.tencent.mm.media.widget.c.c.AnonymousClass4.AnonymousClass1 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                        @Override // kotlin.g.a.m
                        public final /* synthetic */ x invoke(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
                            AppMethodBeat.i(218957);
                            ByteBuffer byteBuffer2 = byteBuffer;
                            MediaCodec.BufferInfo bufferInfo2 = bufferInfo;
                            byteBuffer2.position(0);
                            if (byteBuffer2.remaining() >= bufferInfo2.size && c.this.irE != null) {
                                Log.d("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] writeH264Data  ,bufferInfo.size : " + bufferInfo2.size + ",presentationTimeUs:" + bufferInfo2.presentationTimeUs + ",flags:" + bufferInfo2.flags + ",keyFrame:" + ((bufferInfo2.flags & 1) > 0 ? "yes" : "no") + ", frameCnt:[" + c.this.isc + " " + ((long) c.this.irE.frameNum) + "], pts:" + (c.b(c.this) * j2));
                                if ((bufferInfo2.flags & 1) > 0 && c.this.isd != null) {
                                    c.this.isd.zV(bufferInfo2.presentationTimeUs);
                                }
                                if (c.this.irK.zwJ == d.c.Stop) {
                                    Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] writeH264Data, already stop");
                                } else {
                                    SightVideoJNI.writeH264DataLock(c.this.bufId, byteBuffer2, bufferInfo2.size, bufferInfo2.presentationTimeUs);
                                    c.e(c.this);
                                }
                            }
                            AppMethodBeat.o(218957);
                            return null;
                        }
                    };
                    bVar2.ifc = new kotlin.g.a.a<x>() {
                        /* class com.tencent.mm.media.widget.c.c.AnonymousClass4.AnonymousClass2 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(218958);
                            c.f(c.this);
                            AppMethodBeat.o(218958);
                            return null;
                        }
                    };
                    AppMethodBeat.o(93358);
                    return null;
                }
            });
            com.tencent.mm.media.i.a aVar = this.ise;
            Surface inputSurface = this.irE.getInputSurface();
            EGLContext eGLContext = this.ilv;
            AnonymousClass5 r6 = new kotlin.g.a.b<Boolean, x>() {
                /* class com.tencent.mm.media.widget.c.c.AnonymousClass5 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(Boolean bool) {
                    AppMethodBeat.i(93360);
                    x d2 = d(bool);
                    AppMethodBeat.o(93360);
                    return d2;
                }

                private x d(Boolean bool) {
                    AppMethodBeat.i(218959);
                    if (!bool.booleanValue()) {
                        e eVar = e.ilC;
                        e.aND();
                    }
                    synchronized (c.isn) {
                        try {
                            c.isn.notifyAll();
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", e2, "[" + hashCode() + "] initSurfaceLock notify error", new Object[0]);
                        }
                        try {
                        } catch (Throwable th) {
                            AppMethodBeat.o(218959);
                            throw th;
                        }
                    }
                    AppMethodBeat.o(218959);
                    return null;
                }
            };
            p.h(inputSurface, "surface");
            aVar.surface = inputSurface;
            Log.i(aVar.TAG, aVar.hashCode() + " initWithSurface, eglContext:" + eGLContext + ", surface:" + inputSurface + ", waitNewFrame:false, callback:false");
            aVar.k(new a.d(aVar, eGLContext, inputSurface, r6));
            synchronized (isn) {
                try {
                    isn.wait(500);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", e2, "[" + hashCode() + "] initSurfaceLock wait error", new Object[0]);
                }
                try {
                } catch (Throwable th) {
                    AppMethodBeat.o(93369);
                    throw th;
                }
            }
            this.ise.ihb = new kotlin.g.a.b<Boolean, x>() {
                /* class com.tencent.mm.media.widget.c.c.AnonymousClass6 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(Boolean bool) {
                    AppMethodBeat.i(218961);
                    if (c.this.irE != null) {
                        c.this.irE.aMl();
                    }
                    if (c.this.irE != null && c.this.irK.zwJ == d.c.WaitStop) {
                        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] final frame draw");
                        h.RTc.bqo("record_stop_timeout");
                        c.this.irE.aMi();
                        if (c.this.irD != null) {
                            c.this.irD.a(new c.b() {
                                /* class com.tencent.mm.media.widget.c.c.AnonymousClass6.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.mmsight.model.a.c.b
                                public final void aQX() {
                                    AppMethodBeat.i(218960);
                                    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] aac stop finish");
                                    AppMethodBeat.o(218960);
                                }
                            });
                        }
                        c.this.ise.release();
                    }
                    AppMethodBeat.o(218961);
                    return null;
                }
            };
            aQH();
            this.irD = new a(this.irT.audioSampleRate, this.irT.audioBitrate, this.irT.audioChannelCount, com.tencent.mm.plugin.sight.base.b.ak(false, this.irM));
            this.irD.rc(this.irZ);
            int H = this.irD.H(this.bufId, com.tencent.mm.plugin.sight.base.e.aNv(this.iry));
            Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] initImpl used %sms, ret:%s", Long.valueOf(Util.ticksToNow(currentTicks)), Integer.valueOf(H));
            if (H != 0) {
                e eVar4 = e.ilC;
                e.aNE();
                AppMethodBeat.o(93369);
                return false;
            }
            AppMethodBeat.o(93369);
            return true;
        } catch (Exception e3) {
            release();
            Log.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", e3, "[" + hashCode() + "] init encoder error", new Object[0]);
            MultiProcessMMKV.getSingleDefault().putBoolean("mediacodec_create_error", true);
            e eVar5 = e.ilC;
            e.aNC();
            AppMethodBeat.o(93369);
            return false;
        }
    }

    private void aQH() {
        AppMethodBeat.i(93370);
        int i2 = this.irF;
        int i3 = this.irG;
        this.ise.cX(i2, i3);
        this.ise.qx(this.irL);
        this.ise.cZ(this.irI, this.irJ);
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] outputWidth: %s, outputHeight: %s, cameraPreviewWidth: %s, cameraPreviewHeight: %s, getDataRotate: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.irI), Integer.valueOf(this.irJ), Integer.valueOf(this.irL));
        AppMethodBeat.o(93370);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final boolean rC(int i2) {
        AppMethodBeat.i(93371);
        if (!this.htU) {
            Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preInit, cameraOrientation %d", Integer.valueOf(i2));
            boolean rB = rB(i2);
            this.htU = true;
            Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] initImpl result: %s", Boolean.valueOf(rB));
            AppMethodBeat.o(93371);
            return rB;
        }
        AppMethodBeat.o(93371);
        return true;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final int b(int i2, boolean z, int i3) {
        int i4;
        AppMethodBeat.i(93372);
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start, cameraOrientation: %s, isLandscape: %s, degree: %s", Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3));
        this.irR.reset();
        this.irz = 0;
        this.isf = 0;
        this.irS.reset();
        this.irO = false;
        this.iqo = z;
        this.irW = i3;
        aQJ();
        this.isi = (double) (1000.0f / ((float) this.irT.fps));
        this.irK.a(d.c.WaitStart);
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start, checkDropFrameByPts: %s, perFrmaeDuration:%s", Boolean.valueOf(this.ish), Double.valueOf(this.isi));
        if (Util.isNullOrNil(this.iry)) {
            Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start error, mCurRecordPath is null!!");
            AppMethodBeat.o(93372);
            return -1;
        }
        try {
            this.mFileName = s.bpb(this.iry);
            String boZ = s.boZ(this.iry);
            if (!boZ.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                boZ = boZ + FilePathGenerator.ANDROID_DIR_SEP;
            }
            this.irN = boZ + hashCode() + "tempRotate.mp4";
            Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] tempRotateFilePath:" + this.irN);
        } catch (Exception e2) {
            Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] retrieve file name error: %s", e2.getMessage());
        }
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mCurRecordPath: %s, tempRotateFilePath: %s", this.iry, this.irN);
        this.irL = i2;
        aQH();
        if (!this.htU) {
            rB(i2);
            this.htU = true;
        }
        aQH();
        if (this.isb || this.irZ || this.irD == null) {
            Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start yuvRecorder with mute");
            this.irK.a(d.c.Start);
            this.irV = false;
            i4 = 0;
        } else {
            i4 = this.irD.a(new c.a() {
                /* class com.tencent.mm.media.widget.c.c.AnonymousClass7 */

                @Override // com.tencent.mm.plugin.mmsight.model.a.c.a
                public final void aQY() {
                    AppMethodBeat.i(218962);
                    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] onPcmReady");
                    if (c.this.aQN() != d.c.Initialized) {
                        Log.w("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] not MediaStatus.Initialized, maybe canceled by user");
                        AppMethodBeat.o(218962);
                        return;
                    }
                    c.this.irK.a(d.c.Start);
                    AppMethodBeat.o(218962);
                }
            });
            Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start aacRecorder ret: %s", Integer.valueOf(i4));
            this.irV = false;
            if (i4 != 0) {
                this.irK.a(d.c.Error);
            } else {
                this.irK.a(d.c.Initialized);
            }
        }
        AppMethodBeat.o(93372);
        return i4;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void E(Runnable runnable) {
        AppMethodBeat.i(93373);
        this.irY = runnable;
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] !!!!!stop, stopCallback: %s !!!", runnable);
        if (this.irE == null || (this.irD == null && !this.isb)) {
            Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] error, yuvRecorder or aacRecorder is null");
            if (runnable != null) {
                MMHandlerThread.postToMainThread(runnable);
            }
            AppMethodBeat.o(93373);
        } else if (this.irK == null || this.irK.zwJ != d.c.Stop) {
            e eVar = e.ilC;
            e.aNF();
            if (this.irK != null) {
                h.RTc.b(this.isr, 1500, "record_stop_timeout");
                this.irK.a(d.c.PrepareStop);
            }
            if (this.isk > 0) {
                this.isl = (long) ((((float) (System.nanoTime() - this.isk)) / 1000000.0f) + ((float) this.isl));
            }
            this.irz = (int) this.irE.aMm();
            Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, mDurationMS:%s, accumulatePauseTime:%s", Integer.valueOf(this.irz), Long.valueOf(this.isl));
            if (this.isl > 0) {
                this.irz = (int) (((long) this.irz) - this.isl);
            }
            AppMethodBeat.o(93373);
        } else {
            Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, already in stop videoRecordStatus");
            if (this.irD != null) {
                this.irD.clear();
            }
            if (runnable != null) {
                MMHandlerThread.postToMainThread(runnable);
            }
            AppMethodBeat.o(93373);
        }
    }

    private boolean aQI() {
        AppMethodBeat.i(93374);
        long currentTicks = Util.currentTicks();
        if (this.irE == null) {
            Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxTask, videoEncoder is null");
            AppMethodBeat.o(93374);
            return false;
        }
        int i2 = this.irE.frameNum;
        if (this.irz <= 0) {
            Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxTask, mDurationMS error %s", Integer.valueOf(this.irz));
            AppMethodBeat.o(93374);
            return false;
        }
        this.irA = (((float) i2) * 1000.0f) / ((float) this.irz);
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", Integer.valueOf(i2), Float.valueOf(this.irA), Integer.valueOf(this.irz), this.iry, Long.valueOf(Util.ticksToNow(currentTicks)), Integer.valueOf(this.irB), Float.valueOf(this.irC));
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] frameCountCallback %s", this.irS.getValue());
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] yuvRecorderWriteDataCallback %s", this.irR.getValue());
        String str = null;
        if (CaptureMMProxy.getInstance() != null) {
            str = CaptureMMProxy.getInstance().getAccVideoPath();
        } else if (!Util.isNullOrNil(this.iry)) {
            str = aa.z(new o(this.iry).heq().her());
        }
        String eK = !Util.isNullOrNil(str) ? com.tencent.mm.plugin.mmsight.d.eK(str, hashCode()) : this.iry;
        int i3 = this.irz;
        if (this.irB > 0) {
            i3 = this.irB;
        }
        float f2 = this.irA;
        if (this.irC > 0.0f) {
            f2 = this.irC;
        }
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxResultPath : " + eK);
        n nVar = new n(this.bufId, eK, f2, this.irH, i3, this.irT.audioSampleRate, this.isb && !this.ism, false, this.irM);
        long currentTicks2 = Util.currentTicks();
        boolean ejY = nVar.ejY();
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mux used %sms, success: %s", Long.valueOf(Util.ticksToNow(currentTicks2)), Boolean.valueOf(ejY));
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "mux finish, dtsCount:%d, ptsCount:%d", Integer.valueOf(this.dtsCount), Integer.valueOf(this.isq));
        if (!ejY) {
            Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mux failed!");
            l.ejM();
            AppMethodBeat.o(93374);
            return false;
        }
        if (this.iqo) {
            long currentTicks3 = Util.currentTicks();
            int i4 = this.irW == 270 ? 270 : 90;
            SightVideoJNI.tagRotateVideoVFS(eK, this.irN, i4);
            this.irQ = true;
            Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", Long.valueOf(Util.ticksToNow(currentTicks3)), Integer.valueOf(this.irL), Boolean.valueOf(this.iqo), Integer.valueOf(this.irW), Integer.valueOf(i4));
            long currentTicks4 = Util.currentTicks();
            try {
                s.deleteFile(eK);
                s.nx(this.irN, eK);
                Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] copyFile cost %s", Long.valueOf(Util.ticksToNow(currentTicks4)));
                final String str2 = this.irN;
                h.RTc.b(new Runnable() {
                    /* class com.tencent.mm.media.widget.c.c.AnonymousClass9 */

                    public final void run() {
                        AppMethodBeat.i(218964);
                        try {
                            s.deleteFile(str2);
                            AppMethodBeat.o(218964);
                        } catch (Exception e2) {
                            Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, delete old file error: %s", e2.getMessage());
                            AppMethodBeat.o(218964);
                        }
                    }
                }, "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
            } catch (Exception e2) {
                Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, copy file error");
                AppMethodBeat.o(93374);
                return false;
            }
        }
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        this.irK.a(d.c.Stop);
        this.md5 = s.bhK(eK);
        if (!Util.isNullOrNil(eK) && !eK.equals(this.iry)) {
            s.nx(eK, this.iry);
            s.deleteFile(eK);
        }
        AppMethodBeat.o(93374);
        return true;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final String getMd5() {
        AppMethodBeat.i(93375);
        String nullAs = Util.nullAs(this.md5, "");
        AppMethodBeat.o(93375);
        return nullAs;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void cancel() {
        AppMethodBeat.i(93376);
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] cancel");
        release();
        AppMethodBeat.o(93376);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void reset() {
        AppMethodBeat.i(93377);
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] reset");
        release();
        AppMethodBeat.o(93377);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void clear() {
        AppMethodBeat.i(93378);
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] clear");
        release();
        AppMethodBeat.o(93378);
    }

    private void release() {
        AppMethodBeat.i(93379);
        if (this.released) {
            AppMethodBeat.o(93379);
            return;
        }
        this.released = true;
        try {
            Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start release recorder");
            this.irK.a(d.c.WaitStop);
            synchronized (this.irx) {
                try {
                    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start release videoEncoder");
                    if (this.irE != null) {
                        this.irE.aMi();
                        this.irE.aMj();
                        this.irE = null;
                        e eVar = e.ilC;
                        e.aOj();
                    }
                    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] end release videoEncoder");
                } catch (Throwable th) {
                    AppMethodBeat.o(93379);
                    throw th;
                }
            }
            if (this.irD != null) {
                this.irD.a(new c.b() {
                    /* class com.tencent.mm.media.widget.c.c.AnonymousClass10 */

                    @Override // com.tencent.mm.plugin.mmsight.model.a.c.b
                    public final void aQX() {
                        AppMethodBeat.i(218965);
                        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] aac stop finish");
                        AppMethodBeat.o(218965);
                    }
                });
                this.irD.clear();
                this.irD = null;
            }
            Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] release buf-id ? %d", Integer.valueOf(this.bufId));
            if (this.bufId >= 0) {
                SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
            }
            this.irK.a(d.c.Stop);
            if (this.ise != null) {
                this.ise.release();
            }
            aQJ();
            this.ish = false;
            this.irV = false;
            this.irU = null;
            this.htU = false;
            AppMethodBeat.o(93379);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", e2, "[" + hashCode() + "] clear error: %s", e2.getMessage());
            AppMethodBeat.o(93379);
        }
    }

    private void aQJ() {
        this.isf = 0;
        this.isg = 0;
        this.isi = 0.0d;
        this.isj = 0;
        this.isk = 0;
        this.isl = 0;
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
    public final long aQM() {
        AppMethodBeat.i(93380);
        if (this.irE != null) {
            long aMm = this.irE.aMm();
            AppMethodBeat.o(93380);
            return aMm;
        }
        AppMethodBeat.o(93380);
        return 0;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final g getFrameDataCallback() {
        return this.iss;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void s(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(93381);
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        if (i4 % 16 != 0) {
            i4 = com.tencent.mm.plugin.mmsight.d.QH(i4);
        }
        if (i5 % 16 != 0) {
            i5 = com.tencent.mm.plugin.mmsight.d.QH(i5);
        }
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] setSize, after align, targetWidth: %d, targetHeight: %d", Integer.valueOf(i4), Integer.valueOf(i5));
        this.irI = i2;
        this.irJ = i3;
        if (k.zwi.h(Integer.valueOf(((i2 * i3) * 3) / 2)) == null) {
            dj(i2, i3);
        }
        AppMethodBeat.o(93381);
    }

    private void dj(int i2, int i3) {
        AppMethodBeat.i(177314);
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preloadCameraData, width: %s, height: %s, count: %s", Integer.valueOf(i2), Integer.valueOf(i3), 3);
        long currentTicks = Util.currentTicks();
        for (int i4 = 0; i4 < 3; i4++) {
            k.zwi.k(new byte[(((i2 * i3) * 3) / 2)]);
        }
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preloadCameraData used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(177314);
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
        AppMethodBeat.i(93382);
        int round = Math.round(((float) this.irz) / 1000.0f);
        AppMethodBeat.o(93382);
        return round;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final Point aQP() {
        AppMethodBeat.i(93383);
        Point point = new Point(this.irI, this.irJ);
        AppMethodBeat.o(93383);
        return point;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final int aQQ() {
        return this.irL;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void pause() {
        AppMethodBeat.i(93384);
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] pause");
        if (this.irK != null && this.irK.zwJ == d.c.Start) {
            this.irK.a(d.c.Pause);
            if (this.irD != null) {
                this.irD.pause();
            }
            this.isk = System.nanoTime();
        }
        AppMethodBeat.o(93384);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void M(int i2, int i3, int i4) {
        AppMethodBeat.i(93385);
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] resume, cameraOrientation: %s, cameraPreviewWidth:%s, cameraPreviewHeight:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        this.irL = i2;
        this.irI = i3;
        this.irJ = i4;
        this.ise.qx(i2);
        aQH();
        if (this.irK != null && this.irK.zwJ == d.c.Pause) {
            this.irK.a(d.c.Start);
            if (this.irD != null) {
                this.irD.resume();
            }
        }
        AppMethodBeat.o(93385);
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
        AppMethodBeat.i(93386);
        if (this.irD != null) {
            c.a ejX = this.irD.ejX();
            AppMethodBeat.o(93386);
            return ejX;
        }
        AppMethodBeat.o(93386);
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
        AppMethodBeat.i(93387);
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] overrideDurationMs: %s", Integer.valueOf(i2));
        this.irB = i2;
        AppMethodBeat.o(93387);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void setMirror(boolean z) {
        AppMethodBeat.i(93388);
        this.ise.ihs.eD(z);
        AppMethodBeat.o(93388);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d
    public final void av(float f2) {
        AppMethodBeat.i(93389);
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] overrideFps: %s", Float.valueOf(f2));
        this.irC = f2;
        AppMethodBeat.o(93389);
    }

    private boolean aQU() {
        AppMethodBeat.i(93391);
        if (this.irK.zwJ == d.c.Start || this.irK.zwJ == d.c.PrepareStop) {
            if (this.irK.zwJ == d.c.PrepareStop) {
                this.irK.zwJ = d.c.WaitStop;
                Log.printInfoStack("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] forward one more frame", new Object[0]);
            }
            if (this.irD != null) {
                this.irD.ejW();
            }
            this.irS.Hi(1);
            this.irR.Hi(1);
            AppMethodBeat.o(93391);
            return true;
        }
        AppMethodBeat.o(93391);
        return false;
    }

    private Pair<Long, Boolean> aQV() {
        AppMethodBeat.i(218966);
        long j2 = 0;
        boolean z = false;
        if (this.isk > 0) {
            long nanoTime = System.nanoTime() - this.isk;
            this.isj += nanoTime;
            this.isl = (long) (((float) this.isl) + (((float) nanoTime) / 1000000.0f));
            this.isk = 0;
        }
        Log.d("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] updateCurrentFrameDts, lastPausePtsDiff:%s", Long.valueOf(this.isj));
        if (this.isg > 0) {
            j2 = ((System.nanoTime() - this.isg) + this.isf) - this.isj;
            this.isj = 0;
        }
        if (!this.ish) {
            this.isf = j2;
            this.isg = System.nanoTime();
            z = true;
        } else if (this.irK.zwJ == d.c.WaitStop || this.isf == 0 || ((double) (j2 - this.isf)) >= this.isi * 1000000.0d) {
            this.isf = j2;
            this.isg = System.nanoTime();
            z = true;
        }
        long j3 = j2 / 1000;
        if (j3 == 0) {
            this.dtsCount++;
            SightVideoJNI.writeDtsDataLock(this.bufId, ((long) (Math.round(1000.0f / ((float) this.irT.fps)) * -1)) * 1000);
        }
        this.dtsCount++;
        SightVideoJNI.writeDtsDataLock(this.bufId, j3);
        Log.d("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] updateCurrentFrameDts ptsNs:%s, dtsMs:%s, lastTexturePts:%s, lastTextureNanoTime:%s, accumulatePauseTime:%s, needDrawFrame:%s", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(this.isf), Long.valueOf(this.isg), Long.valueOf(this.isl), Boolean.valueOf(z));
        Pair<Long, Boolean> pair = new Pair<>(Long.valueOf(j2), Boolean.valueOf(z));
        AppMethodBeat.o(218966);
        return pair;
    }

    public final com.tencent.mm.plugin.mmsight.model.a.c aQW() {
        return this.irD;
    }

    public final void a(com.tencent.mm.plugin.mmsight.model.a.c cVar) {
        AppMethodBeat.i(93392);
        if (cVar != null) {
            this.ism = true;
            cVar.rA(this.bufId);
        }
        AppMethodBeat.o(93392);
    }

    @Override // com.tencent.mm.media.widget.c.b
    public final void aQG() {
        AppMethodBeat.i(93390);
        if (this.textureId >= 0 && aQU()) {
            Pair<Long, Boolean> aQV = aQV();
            if (((Boolean) aQV.second).booleanValue()) {
                this.ise.x(this.textureId, ((Long) aQV.first).longValue());
            }
        }
        if (this.surfaceTexture == null || !aQU()) {
            AppMethodBeat.o(93390);
            return;
        }
        com.tencent.mm.media.i.a aVar = this.ise;
        SurfaceTexture surfaceTexture2 = this.surfaceTexture;
        p.h(surfaceTexture2, "surfaceTexture");
        aVar.k(new a.i(aVar, surfaceTexture2));
        AppMethodBeat.o(93390);
    }

    static /* synthetic */ void a(c cVar, byte[] bArr) {
        AppMethodBeat.i(218967);
        if (!cVar.aQU() || bArr == null || bArr.length == 0) {
            AppMethodBeat.o(218967);
            return;
        }
        cVar.ise.a(bArr, ((Long) cVar.aQV().first).longValue(), new kotlin.g.a.b<byte[], x>() {
            /* class com.tencent.mm.media.widget.c.c.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(byte[] bArr) {
                AppMethodBeat.i(218955);
                k.zwi.k(bArr);
                AppMethodBeat.o(218955);
                return null;
            }
        });
        AppMethodBeat.o(218967);
    }

    static /* synthetic */ void f(c cVar) {
        AppMethodBeat.i(218968);
        h.RTc.aX(new com.tencent.f.i.h() {
            /* class com.tencent.mm.media.widget.c.c.AnonymousClass8 */

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "MMSightMediaCodecMP4MuxRecorder_stop";
            }

            public final void run() {
                AppMethodBeat.i(93364);
                Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stopImpl status:%s", c.this.irK.zwJ);
                if (c.this.irK.zwJ == d.c.Stop) {
                    Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stopImp, already stop");
                    if (c.this.irD != null) {
                        c.this.irD.clear();
                    }
                    AppMethodBeat.o(93364);
                    return;
                }
                boolean g2 = c.g(c.this);
                Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stopImpl result: %s", Boolean.valueOf(g2));
                if (g2) {
                    e eVar = e.ilC;
                    e.aNI();
                    c.a(c.this, com.tencent.mm.plugin.mmsight.d.PF(c.this.iry));
                    if (c.this.irT.iTh == 2) {
                        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] steve:[hardcoder] hwenc qp add metadata flag, switch:%s", Integer.valueOf(c.this.irT.iTh));
                        SightVideoJNI.addReportMetadata(c.this.iry, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0, c.this.irT.iTh);
                    }
                    try {
                        com.tencent.mm.plugin.sight.base.a aNx = com.tencent.mm.plugin.sight.base.e.aNx(c.this.iry);
                        if (aNx != null) {
                            e eVar2 = e.ilC;
                            e.de(aNx.videoBitrate, aNx.frameRate);
                        }
                    } catch (Exception e2) {
                        Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] SightUtil.getMedia error !");
                    }
                    if (c.this.irY != null) {
                        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] call stopCallback");
                        MMHandlerThread.postToMainThread(c.this.irY);
                    }
                } else {
                    e eVar3 = e.ilC;
                    e.aNH();
                    SightVideoJNI.releaseBigSightDataBufferLock(c.this.bufId);
                    if (c.this.irX != null) {
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.media.widget.c.c.AnonymousClass8.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(218963);
                                c.this.irX.bqP();
                                AppMethodBeat.o(218963);
                            }
                        });
                    }
                }
                e eVar4 = e.ilC;
                e.aNG();
                AppMethodBeat.o(93364);
            }
        });
        AppMethodBeat.o(218968);
    }

    static /* synthetic */ void a(c cVar, Bitmap bitmap) {
        AppMethodBeat.i(218970);
        if (bitmap == null) {
            Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + cVar.hashCode() + "] saveVideoThumbImpl with null bitmap");
            AppMethodBeat.o(218970);
        } else if (Util.isNullOrNil(cVar.thumbPath)) {
            Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + cVar.hashCode() + "] saveVideoThumbImpl, thumbpath is null");
            AppMethodBeat.o(218970);
        } else {
            Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + cVar.hashCode() + "] prepare to save bitmap : $s  to  $s", Integer.valueOf(bitmap.hashCode()), cVar.thumbPath);
            Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + cVar.hashCode() + "] thumb parent path : %s", s.boZ(cVar.thumbPath));
            try {
                BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.JPEG, cVar.thumbPath, true);
                Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + cVar.hashCode() + "] saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s %s", cVar.thumbPath, Integer.valueOf(cVar.irL), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Long.valueOf(s.boW(cVar.thumbPath)));
                AppMethodBeat.o(218970);
            } catch (IOException e2) {
                Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + cVar.hashCode() + "] saveVideoThumbImpl error");
                Log.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", e2, "[" + cVar.hashCode() + "] saveVideoThumbImpl error! %s", e2.getMessage());
                AppMethodBeat.o(218970);
            }
        }
    }
}

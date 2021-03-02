package com.tencent.mm.media.e;

import android.media.Image;
import android.media.ImageReader;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 92\u00020\u0001:\u00019B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J\b\u0010'\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020\u0003H\u0016J\b\u0010)\u001a\u00020%H\u0002J \u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.H\u0002J\u000e\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020\u0019J(\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0003H\u0002J&\u00106\u001a\u00020%2\u0006\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0003J\u0006\u00107\u001a\u00020%J\u0006\u00108\u001a\u00020%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, hxF = {"Lcom/tencent/mm/media/encoder/X264TransImageReaderEncoder;", "Lcom/tencent/mm/media/encoder/ITransEncoder;", "bufId", "", "videoWidth", "videoHeight", "(III)V", "copyTmpBuffer", "Ljava/nio/ByteBuffer;", "curEncodeIndex", "encodePipeline", "Lcom/tencent/threadpool/internal/PipelineEx;", "encodeRGB2YuvHandler", "Landroid/os/Handler;", "encodeRGB2YuvHandlerThread", "Landroid/os/HandlerThread;", "encodeRGB2YuvImageReader", "Landroid/media/ImageReader;", "inputTexId", "isStopped", "", "renderYuvCount", "rgb2yuvEGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "startEncodeTick", "", "stopLock", "Ljava/lang/Object;", "writeDataWaitEncodeLock", "writeYuvCount", "writeYuvDataEncodeLock", "writeYuvRenderWaitLock", "yuvHeight", "yuvRenderProc", "Lcom/tencent/mm/media/render/proc/RGB2YUVPortraitRenderProc;", "yuvWidth", "checkStartEncodeLoop", "", "encodeLoop", "finishEncode", "getFrameCount", "notifyToEncode", "processImageYUVBufferToWriteYUVData", "width", "height", "plane", "Landroid/media/Image$Plane;", "requestEncode", "timestampMs", "setupImageReader", "videoDataRenderEnvironment", "texId", "texWidth", "texHeight", "start", "stop", "waitWriteYuv", "Companion", "plugin-mediaeditor_release"})
public final class h {
    public static final a ifX = new a((byte) 0);
    private final int bufId;
    public volatile int ifA;
    private ByteBuffer ifH;
    public ImageReader ifI;
    public Handler ifJ;
    public HandlerThread ifK;
    private com.tencent.mm.media.j.b.h ifL;
    private c.b ifM;
    public int ifN;
    public int ifO;
    public volatile boolean ifP;
    public long ifQ;
    private final Object ifR = new Object();
    public final Object ifS = new Object();
    public final Object ifT = new Object();
    private volatile int ifU;
    public volatile int ifV;
    public int ifW;
    public com.tencent.f.e.f<?> ifx;
    private final Object stopLock = new Object();
    public final int videoHeight;
    public final int videoWidth;

    static {
        AppMethodBeat.i(218742);
        AppMethodBeat.o(218742);
    }

    public h(int i2, int i3, int i4) {
        AppMethodBeat.i(218741);
        this.bufId = i2;
        this.videoWidth = i3;
        this.videoHeight = i4;
        HandlerThread hz = com.tencent.f.c.d.hz("X264TransImageReaderEncoder_rgb2yuv_thread", -4);
        p.g(hz, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
        this.ifK = hz;
        Log.i("MicroMsg.X264TransImageReaderEncoder", "create X264TransImageReaderEncoder, width:" + this.videoWidth + ", height:" + this.videoHeight);
        AppMethodBeat.o(218741);
    }

    public static final /* synthetic */ boolean a(h hVar, int i2, int i3, Image.Plane plane) {
        AppMethodBeat.i(218743);
        boolean a2 = hVar.a(i2, i3, plane);
        AppMethodBeat.o(218743);
        return a2;
    }

    public static final /* synthetic */ void c(h hVar) {
        AppMethodBeat.i(218744);
        hVar.aMo();
        AppMethodBeat.o(218744);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "reader", "Landroid/media/ImageReader;", "kotlin.jvm.PlatformType", "onImageAvailable", "com/tencent/mm/media/encoder/X264TransImageReaderEncoder$setupImageReader$1$1"})
    public static final class e implements ImageReader.OnImageAvailableListener {
        final /* synthetic */ h ifY;
        final /* synthetic */ c.b igb;
        final /* synthetic */ int igc;
        final /* synthetic */ int igd;
        final /* synthetic */ int ige;

        public e(h hVar, c.b bVar, int i2, int i3, int i4) {
            this.ifY = hVar;
            this.igb = bVar;
            this.igc = i2;
            this.igd = i3;
            this.ige = i4;
        }

        public final void onImageAvailable(ImageReader imageReader) {
            AppMethodBeat.i(218736);
            Image acquireNextImage = imageReader.acquireNextImage();
            if (acquireNextImage != null) {
                try {
                    StringBuilder append = new StringBuilder("nextYUVImage, size:[").append(acquireNextImage.getWidth()).append('x').append(acquireNextImage.getHeight()).append("], format:").append(acquireNextImage.getFormat()).append(", planes.size:").append(acquireNextImage.getPlanes().length).append(", timestamp:").append(acquireNextImage.getTimestamp()).append(", rowStride:");
                    Image.Plane plane = acquireNextImage.getPlanes()[0];
                    p.g(plane, "image.planes[0]");
                    StringBuilder append2 = append.append(plane.getRowStride()).append(", pixelStride:");
                    Image.Plane plane2 = acquireNextImage.getPlanes()[0];
                    p.g(plane2, "image.planes[0]");
                    StringBuilder append3 = append2.append(plane2.getPixelStride()).append(',').append("buffer.capacity:");
                    Image.Plane plane3 = acquireNextImage.getPlanes()[0];
                    p.g(plane3, "image.planes[0]");
                    Log.i("MicroMsg.X264TransImageReaderEncoder", append3.append(plane3.getBuffer().capacity()).toString());
                    h hVar = this.ifY;
                    int width = acquireNextImage.getWidth();
                    int height = acquireNextImage.getHeight();
                    Image.Plane plane4 = acquireNextImage.getPlanes()[0];
                    p.g(plane4, "image.planes[0]");
                    h.a(hVar, width, height, plane4);
                    this.ifY.ifV++;
                    Log.i("MicroMsg.X264TransImageReaderEncoder", "end processImageYUVBufferToWriteYUVData, writeYuvCount:" + this.ifY.ifV + ", renderYuvCount:" + this.ifY.ifU);
                    if (this.ifY.ifV % 10 == 0) {
                        h.c(this.ifY);
                    }
                    synchronized (this.ifY.ifS) {
                        try {
                            this.ifY.ifS.notifyAll();
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.X264TransImageReaderEncoder", e2, "notifyAll writeYuvRenderWaitLock error", new Object[0]);
                        }
                        try {
                            x xVar = x.SXb;
                        } catch (Throwable th) {
                            AppMethodBeat.o(218736);
                            throw th;
                        }
                    }
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.X264TransImageReaderEncoder", e3, "acquireNextImage error", new Object[0]);
                } finally {
                    acquireNextImage.close();
                    AppMethodBeat.o(218736);
                }
            } else {
                AppMethodBeat.o(218736);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/media/encoder/X264TransImageReaderEncoder$setupImageReader$1$2"})
    public static final class f implements Runnable {
        final /* synthetic */ h ifY;
        final /* synthetic */ c.b igb;
        final /* synthetic */ int igc;
        final /* synthetic */ int igd;
        final /* synthetic */ int ige;
        final /* synthetic */ ImageReader igf;

        public f(ImageReader imageReader, h hVar, c.b bVar, int i2, int i3, int i4) {
            this.igf = imageReader;
            this.ifY = hVar;
            this.igb = bVar;
            this.igc = i2;
            this.igd = i3;
            this.ige = i4;
        }

        public final void run() {
            AppMethodBeat.i(218737);
            this.ifY.ifM = c.a.a(com.tencent.mm.media.k.c.ilt, this.igf.getSurface(), 0, 0, this.igb.ilv, 14);
            this.ifY.ifL = new com.tencent.mm.media.j.b.h(1, 15);
            com.tencent.mm.media.j.b.h hVar = this.ifY.ifL;
            if (hVar != null) {
                hVar.cY(this.ifY.ifN, this.ifY.ifO);
            }
            com.tencent.mm.media.j.b.h hVar2 = this.ifY.ifL;
            if (hVar2 != null) {
                hVar2.ikZ = this.igc;
            }
            com.tencent.mm.media.j.b.h hVar3 = this.ifY.ifL;
            if (hVar3 != null) {
                hVar3.cZ(this.igd, this.ige);
            }
            Log.i("MicroMsg.X264TransImageReaderEncoder", "create rgb2yuvEGLEnvironment:" + this.ifY.ifM + ", shareEGLContext:" + this.igb.ilv + ", texId:" + this.igc + ", texSize:[" + this.igd + ", " + this.ige + ']');
            AppMethodBeat.o(218737);
        }
    }

    private final boolean a(int i2, int i3, Image.Plane plane) {
        AppMethodBeat.i(218738);
        synchronized (this.stopLock) {
            try {
                if (this.bufId >= 0) {
                    long currentTicks = Util.currentTicks();
                    Log.i("MicroMsg.X264TransImageReaderEncoder", "processImageYUVBufferToWriteYUVData, width:" + i2 + ", height:" + i3 + ", videoWidth:" + this.videoWidth + ", videoHeight:" + this.videoHeight);
                    int rowStride = plane.getRowStride();
                    int pixelStride = plane.getPixelStride();
                    if (this.ifH == null) {
                        this.ifH = ByteBuffer.allocateDirect(this.ifN * this.ifO * pixelStride);
                    }
                    ByteBuffer byteBuffer = this.ifH;
                    if (byteBuffer != null) {
                        byteBuffer.position(0);
                    }
                    ByteBuffer buffer = plane.getBuffer();
                    buffer.position(0);
                    SightVideoJNI.nativeBufferCopy(buffer, this.ifH, this.ifN * pixelStride, this.ifO, rowStride - (pixelStride * this.ifN));
                    SightVideoJNI.writeYuvDataForMMSightWithBuffer(this.bufId, this.ifH, this.videoWidth, this.videoHeight, false, false, this.videoWidth, this.videoHeight);
                    Log.i("MicroMsg.X264TransImageReaderEncoder", "end processImageYUVBufferToWriteYUVData, cost:" + Util.ticksToNow(currentTicks));
                }
            } catch (Throwable th) {
                AppMethodBeat.o(218738);
                throw th;
            }
        }
        AppMethodBeat.o(218738);
        return false;
    }

    private final void aMo() {
        AppMethodBeat.i(218739);
        synchronized (this.ifR) {
            try {
                Log.i("MicroMsg.X264TransImageReaderEncoder", "notify to encode");
                this.ifR.notifyAll();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.X264TransImageReaderEncoder", e2, "", new Object[0]);
            }
            try {
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(218739);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ h ifY;
        final /* synthetic */ long iga;

        public d(h hVar, long j2) {
            this.ifY = hVar;
            this.iga = j2;
        }

        public final void run() {
            EGLDisplay eGLDisplay;
            EGLSurface eGLSurface;
            EGLDisplay eGLDisplay2;
            EGLSurface eGLSurface2 = null;
            AppMethodBeat.i(218735);
            Log.i("MicroMsg.X264TransImageReaderEncoder", "render gpu rgb2yuv, timestamp:" + this.iga);
            com.tencent.mm.media.j.b.h hVar = this.ifY.ifL;
            if (hVar != null) {
                hVar.aED();
            }
            c.b bVar = this.ifY.ifM;
            if (bVar != null) {
                eGLDisplay = bVar.ilu;
            } else {
                eGLDisplay = null;
            }
            c.b bVar2 = this.ifY.ifM;
            if (bVar2 != null) {
                eGLSurface = bVar2.eglSurface;
            } else {
                eGLSurface = null;
            }
            EGLExt.eglPresentationTimeANDROID(eGLDisplay, eGLSurface, this.iga);
            c.a aVar = com.tencent.mm.media.k.c.ilt;
            c.b bVar3 = this.ifY.ifM;
            if (bVar3 != null) {
                eGLDisplay2 = bVar3.ilu;
            } else {
                eGLDisplay2 = null;
            }
            c.b bVar4 = this.ifY.ifM;
            if (bVar4 != null) {
                eGLSurface2 = bVar4.eglSurface;
            }
            c.a.a(eGLDisplay2, eGLSurface2);
            this.ifY.ifU++;
            AppMethodBeat.o(218735);
        }
    }

    public final void stop() {
        Handler handler;
        AppMethodBeat.i(218740);
        Log.i("MicroMsg.X264TransImageReaderEncoder", "stop");
        synchronized (this.stopLock) {
            try {
                Log.i("MicroMsg.X264TransImageReaderEncoder", "finishEncode, encodePipeline:" + this.ifx + ", renderYuvCount:" + this.ifU + ", writeYuvCount:" + this.ifV);
                this.ifP = true;
                aMo();
                ImageReader imageReader = this.ifI;
                if (imageReader != null) {
                    imageReader.close();
                }
                c.b bVar = this.ifM;
                if (!(bVar == null || (handler = this.ifJ) == null)) {
                    handler.post(new c(bVar, this));
                }
                this.ifK.quitSafely();
                com.tencent.f.e.f<?> fVar = this.ifx;
                if (fVar != null) {
                    fVar.take();
                }
                this.ifI = null;
                this.ifM = null;
                this.ifx = null;
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(218740);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/media/encoder/X264TransImageReaderEncoder$finishEncode$1$1$1", "com/tencent/mm/media/encoder/X264TransImageReaderEncoder$$special$$inlined$let$lambda$1"})
    static final class c implements Runnable {
        final /* synthetic */ h ifY;
        final /* synthetic */ c.b ifZ;

        c(c.b bVar, h hVar) {
            this.ifZ = bVar;
            this.ifY = hVar;
        }

        public final void run() {
            AppMethodBeat.i(218734);
            com.tencent.mm.media.j.b.h hVar = this.ifY.ifL;
            if (hVar != null) {
                hVar.release();
            }
            c.a aVar = com.tencent.mm.media.k.c.ilt;
            c.a.a(this.ifZ);
            AppMethodBeat.o(218734);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/media/encoder/X264TransImageReaderEncoder$Companion;", "", "()V", "CacheEncodeYuvExceedFrameLimit", "", "TAG", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/threadpool/internal/Pipeline$NIL;", "kotlin.jvm.PlatformType", "input"})
    public static final class b<I, O> implements com.tencent.f.e.a<E, R> {
        final /* synthetic */ h ifY;

        public b(h hVar) {
            this.ifY = hVar;
        }

        @Override // com.tencent.f.e.a
        public final /* synthetic */ Object bT(Object obj) {
            AppMethodBeat.i(218733);
            h.i(this.ifY);
            x xVar = x.SXb;
            AppMethodBeat.o(218733);
            return xVar;
        }
    }

    public static final /* synthetic */ void i(h hVar) {
        AppMethodBeat.i(218745);
        long currentTicks = Util.currentTicks();
        while (!hVar.ifP) {
            Log.i("MicroMsg.X264TransImageReaderEncoder", "start trigger encode, curEncodeIndex:" + hVar.ifA + ", writeYuvCount:" + hVar.ifV);
            long currentTicks2 = Util.currentTicks();
            int triggerEncode = SightVideoJNI.triggerEncode(hVar.bufId, Math.max(0, hVar.ifA), false);
            StringBuilder append = new StringBuilder("trigger encode use ").append(Util.ticksToNow(currentTicks2)).append("ms, curEncodeIndex:").append(hVar.ifA).append(", newEncodeIndex:").append(triggerEncode).append(", threadId:");
            Thread currentThread = Thread.currentThread();
            p.g(currentThread, "Thread.currentThread()");
            Log.i("MicroMsg.X264TransImageReaderEncoder", append.append(currentThread.getId()).toString());
            hVar.ifA = triggerEncode;
            if (hVar.ifA >= hVar.ifV && !hVar.ifP) {
                synchronized (hVar.ifT) {
                    try {
                        Log.i("MicroMsg.X264TransImageReaderEncoder", "notify to continue render");
                        hVar.ifT.notifyAll();
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.X264TransImageReaderEncoder", e2, "", new Object[0]);
                    }
                    try {
                        x xVar = x.SXb;
                    } catch (Throwable th) {
                        AppMethodBeat.o(218745);
                        throw th;
                    }
                }
            }
            if (!hVar.ifP) {
                synchronized (hVar.ifR) {
                    try {
                        hVar.ifR.wait();
                    } catch (Exception e3) {
                        Log.printErrStackTrace("MicroMsg.X264TransImageReaderEncoder", e3, "", new Object[0]);
                    }
                    try {
                        x xVar2 = x.SXb;
                    } catch (Throwable th2) {
                        AppMethodBeat.o(218745);
                        throw th2;
                    }
                }
            }
        }
        Log.i("MicroMsg.X264TransImageReaderEncoder", "trigger end encode now, isStopped:" + hVar.ifP);
        long currentTicks3 = Util.currentTicks();
        boolean z = !hVar.ifP;
        if (!z) {
            hVar.ifA = SightVideoJNI.triggerEncode(hVar.bufId, hVar.ifA, true);
        }
        StringBuilder append2 = new StringBuilder("trigger end encode use ").append(Util.ticksToNow(currentTicks3)).append("ms, curEncodeIndex:").append(hVar.ifA).append(", isCancel:").append(z).append(", threadId:");
        Thread currentThread2 = Thread.currentThread();
        p.g(currentThread2, "Thread.currentThread()");
        Log.i("MicroMsg.X264TransImageReaderEncoder", append2.append(currentThread2.getId()).toString());
        Log.i("MicroMsg.X264TransImageReaderEncoder", "totally encode cost:" + Util.ticksToNow(hVar.ifQ) + "ms, encodeLoop cost:" + Util.ticksToNow(currentTicks) + LocaleUtil.MALAY);
        Log.i("MicroMsg.X264TransImageReaderEncoder", "renderYuvCount:" + hVar.ifU + ", writeYuvCount:" + hVar.ifV);
        AppMethodBeat.o(218745);
    }
}

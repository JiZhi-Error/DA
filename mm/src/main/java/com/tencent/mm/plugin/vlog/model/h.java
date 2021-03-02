package com.tencent.mm.plugin.vlog.model;

import android.media.Image;
import android.media.ImageReader;
import android.media.MediaFormat;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.TAVKitMuxer;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.AssetWriterVideoEncoder;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ]2\u00020\u0001:\u0001]B\u0005¢\u0006\u0002\u0010\u0002J\b\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u000205H\u0002J\n\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u000205H\u0002J\b\u0010:\u001a\u000205H\u0002J\b\u0010;\u001a\u00020$H\u0016J\b\u0010<\u001a\u00020\u001dH\u0016J\b\u0010=\u001a\u00020*H\u0016J\u0018\u0010>\u001a\u0002052\u0006\u0010+\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004H\u0002J\u0018\u0010?\u001a\u0002052\u0006\u0010+\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004H\u0002J\u0012\u0010@\u001a\u0002052\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020\u0014H\u0016J\b\u0010D\u001a\u00020\u0014H\u0016J\b\u0010E\u001a\u000205H\u0002J\b\u0010F\u001a\u000205H\u0002J\u001c\u0010G\u001a\u00020\u00142\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J \u0010J\u001a\u00020\u00142\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020NH\u0002J \u0010O\u001a\u00020\u00142\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020NH\u0002J\b\u0010P\u001a\u000205H\u0016J\u0010\u0010Q\u001a\u0002052\u0006\u0010R\u001a\u00020\u001dH\u0002J\u0012\u0010S\u001a\u0002052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010T\u001a\u0002052\b\u0010U\u001a\u0004\u0018\u00010(H\u0016J\b\u0010V\u001a\u000205H\u0016J\b\u0010W\u001a\u00020\u0014H\u0016J\b\u0010X\u001a\u000205H\u0016J\u001a\u0010Y\u001a\u00020\u00142\b\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006^"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/CompositionSoftwareEncoder;", "Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;", "()V", "bufId", "", "copyTmpBuffer", "Ljava/nio/ByteBuffer;", "curEncodeIndex", "encodePipeline", "Lcom/tencent/threadpool/internal/PipelineEx;", "encodeRGB2YuvHandler", "Landroid/os/Handler;", "encodeRGB2YuvHandlerThread", "Landroid/os/HandlerThread;", "encodeRGB2YuvImageReader", "Landroid/media/ImageReader;", "encodeSurfaceHandler", "encodeSurfaceHandlerThread", "encodeSurfaceImageReader", "isInputEndOfStream", "", "isStopped", "muxer", "Lcom/tencent/tav/decoder/muxer/IMediaMuxer;", "renderYuvCount", "rgb2yuvEGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "rgbAvailableCount", "sampleTimeUs", "", "startEncodeTick", "stopLock", "Ljava/lang/Object;", "useGpuRgb2Yuv", "videoBitrate", "videoFormat", "Landroid/media/MediaFormat;", "videoFps", "videoHeight", "videoSampleRenderContext", "Lcom/tencent/tav/decoder/RenderContext;", "videoSize", "Lcom/tencent/tav/coremedia/CGSize;", "videoWidth", "writeDataWaitEncodeLock", "writeRGBCount", "writeYuvCount", "writeYuvDataEncodeLock", "yuvHeight", "yuvRenderProc", "Lcom/tencent/mm/media/render/proc/RGB2YUVPortraitRenderProc;", "yuvWidth", "checkInitBufId", "", "checkStartEncodeLoop", "createInputSurface", "Landroid/view/Surface;", "encodeLoop", "finishEncode", "getEncodeFormat", "getEncodePresentationTimeUs", "getEncodeSize", "initEncodeSurfaceImageReader", "initRgb2YuvImageReader", "inputVideoTexture", "sampleBufferRenderOutputTexture", "Lcom/tencent/tav/coremedia/TextureInfo;", "isEncodeToEndOfStream", "isNeedVideoOutputTexture", "notifyToEncode", "onInputEndOfStream", "prepare", "outputConfig", "Lcom/tencent/tav/core/ExportConfig;", "processImageRGBABufferToWriteRGBAData", "width", "height", "plane", "Landroid/media/Image$Plane;", "processImageYUVBufferToWriteYUVData", "release", "requestConvertGpuRgb2YuvRender", AppMeasurement.Param.TIMESTAMP, "setMediaMuxer", "setVideoSampleRenderContext", "renderContext", "signalEndOfInputStream", "start", "stop", "writeVideoSample", "sampleBuffer", "Lcom/tencent/tav/coremedia/CMSampleBuffer;", "isEndOfStream", "Companion", "plugin-vlog_release"})
public final class h implements AssetWriterVideoEncoder {
    public static final a GxK = new a((byte) 0);
    private RenderContext GxC;
    private volatile boolean GxD;
    private ImageReader GxE;
    private Handler GxF;
    private HandlerThread GxG;
    private boolean GxH = true;
    private int GxI;
    private int GxJ;
    private volatile long bqM;
    private int bufId = -1;
    private volatile int ifA;
    private ByteBuffer ifH;
    private ImageReader ifI;
    private Handler ifJ;
    private HandlerThread ifK;
    private com.tencent.mm.media.j.b.h ifL;
    private c.b ifM;
    private int ifN;
    private int ifO;
    private volatile boolean ifP;
    private long ifQ;
    private final Object ifR = new Object();
    private final Object ifT = new Object();
    private volatile int ifU;
    private volatile int ifV;
    private com.tencent.f.e.f<?> ifx;
    private IMediaMuxer muxer;
    private final Object stopLock = new Object();
    private int videoBitrate;
    private MediaFormat videoFormat;
    private int videoFps;
    private int videoHeight;
    private CGSize videoSize;
    private int videoWidth;

    static {
        AppMethodBeat.i(190537);
        AppMethodBeat.o(190537);
    }

    public h() {
        AppMethodBeat.i(190536);
        HandlerThread hz = com.tencent.f.c.d.hz("finder_soft_encode_process_data_thread", 0);
        p.g(hz, "SpecialThreadFactory.cre….THREAD_PRIORITY_DEFAULT)");
        this.GxG = hz;
        HandlerThread hz2 = com.tencent.f.c.d.hz("finder_soft_encode_rgb2yuv_thread", -4);
        p.g(hz2, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
        this.ifK = hz2;
        AppMethodBeat.o(190536);
    }

    public static final /* synthetic */ boolean a(h hVar, int i2, int i3, Image.Plane plane) {
        AppMethodBeat.i(190538);
        boolean b2 = hVar.b(i2, i3, plane);
        AppMethodBeat.o(190538);
        return b2;
    }

    public static final /* synthetic */ boolean b(h hVar, int i2, int i3, Image.Plane plane) {
        AppMethodBeat.i(190540);
        boolean a2 = hVar.a(i2, i3, plane);
        AppMethodBeat.o(190540);
        return a2;
    }

    public static final /* synthetic */ void e(h hVar) {
        AppMethodBeat.i(190539);
        hVar.fAR();
        AppMethodBeat.o(190539);
    }

    public static final /* synthetic */ void i(h hVar) {
        AppMethodBeat.i(190541);
        hVar.aMo();
        AppMethodBeat.o(190541);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/CompositionSoftwareEncoder$Companion;", "", "()V", "CacheEncodeYuvExceedFrameLimit", "", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public final boolean prepare(ExportConfig exportConfig, MediaFormat mediaFormat) {
        AppMethodBeat.i(190517);
        Log.i("MicroMsg.CompositionSoftwareEncoder", "prepare, outputConfig:" + exportConfig + ", videoFormat:" + mediaFormat);
        if (exportConfig != null) {
            this.videoWidth = exportConfig.getOutputWidth();
            this.videoHeight = exportConfig.getOutputHeight();
            this.videoFps = exportConfig.getVideoFrameRate();
            this.videoBitrate = exportConfig.getVideoBitRate();
            this.videoSize = new CGSize((float) this.videoWidth, (float) this.videoHeight);
            this.videoFormat = mediaFormat;
            this.GxE = ImageReader.newInstance(this.videoWidth, this.videoHeight, 1, 1);
            if (!this.GxH) {
                this.GxG.start();
                this.GxF = new Handler(this.GxG.getLooper());
                ImageReader imageReader = this.GxE;
                if (imageReader != null) {
                    imageReader.setOnImageAvailableListener(new d(this), this.GxF);
                }
            }
            AppMethodBeat.o(190517);
            return true;
        }
        AppMethodBeat.o(190517);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "reader", "Landroid/media/ImageReader;", "kotlin.jvm.PlatformType", "onImageAvailable", "com/tencent/mm/plugin/vlog/model/CompositionSoftwareEncoder$initEncodeSurfaceImageReader$1$1"})
    static final class d implements ImageReader.OnImageAvailableListener {
        final /* synthetic */ h GxL;

        d(h hVar) {
            this.GxL = hVar;
        }

        public final void onImageAvailable(ImageReader imageReader) {
            boolean z = true;
            AppMethodBeat.i(190513);
            this.GxL.GxJ++;
            Image acquireNextImage = imageReader.acquireNextImage();
            if (acquireNextImage != null) {
                try {
                    Image.Plane[] planes = acquireNextImage.getPlanes();
                    p.g(planes, "image.planes");
                    if (planes.length == 0) {
                        z = false;
                    }
                    if (z && !this.GxL.ifP && !this.GxL.GxH) {
                        StringBuilder append = new StringBuilder("nextRGBImage, size:[").append(acquireNextImage.getWidth()).append('x').append(acquireNextImage.getHeight()).append("], format:").append(acquireNextImage.getFormat()).append(", planes.size:").append(acquireNextImage.getPlanes().length).append(", timestamp:").append(acquireNextImage.getTimestamp()).append(", rowStride:");
                        Image.Plane plane = acquireNextImage.getPlanes()[0];
                        p.g(plane, "image.planes[0]");
                        StringBuilder append2 = append.append(plane.getRowStride()).append(", pixelStride:");
                        Image.Plane plane2 = acquireNextImage.getPlanes()[0];
                        p.g(plane2, "image.planes[0]");
                        StringBuilder append3 = append2.append(plane2.getPixelStride()).append(',').append("buffer.capacity:");
                        Image.Plane plane3 = acquireNextImage.getPlanes()[0];
                        p.g(plane3, "image.planes[0]");
                        Log.i("MicroMsg.CompositionSoftwareEncoder", append3.append(plane3.getBuffer().capacity()).toString());
                        h hVar = this.GxL;
                        int width = acquireNextImage.getWidth();
                        int height = acquireNextImage.getHeight();
                        Image.Plane plane4 = acquireNextImage.getPlanes()[0];
                        p.g(plane4, "image.planes[0]");
                        if (h.a(hVar, width, height, plane4)) {
                            h.e(this.GxL);
                        }
                        this.GxL.bqM = acquireNextImage.getTimestamp() / 1000;
                        if (this.GxL.GxD) {
                            this.GxL.bqM = -1;
                        }
                        Log.i("MicroMsg.CompositionSoftwareEncoder", "update sampleTimeUs:" + this.GxL.bqM + ", isInputEndOfStream:" + this.GxL.GxD);
                    } else if (this.GxL.ifP) {
                        Log.i("MicroMsg.CompositionSoftwareEncoder", "nextImage but already stop");
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.CompositionSoftwareEncoder", e2, "acquireNextImage error", new Object[0]);
                } finally {
                    acquireNextImage.close();
                    AppMethodBeat.o(190513);
                }
            } else {
                AppMethodBeat.o(190513);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "reader", "Landroid/media/ImageReader;", "kotlin.jvm.PlatformType", "onImageAvailable", "com/tencent/mm/plugin/vlog/model/CompositionSoftwareEncoder$initRgb2YuvImageReader$1$1"})
    static final class e implements ImageReader.OnImageAvailableListener {
        final /* synthetic */ h GxL;

        e(h hVar) {
            this.GxL = hVar;
        }

        public final void onImageAvailable(ImageReader imageReader) {
            AppMethodBeat.i(190514);
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
                    Log.i("MicroMsg.CompositionSoftwareEncoder", append3.append(plane3.getBuffer().capacity()).toString());
                    h hVar = this.GxL;
                    int width = acquireNextImage.getWidth();
                    int height = acquireNextImage.getHeight();
                    Image.Plane plane4 = acquireNextImage.getPlanes()[0];
                    p.g(plane4, "image.planes[0]");
                    h.b(hVar, width, height, plane4);
                    this.GxL.ifV++;
                    if (this.GxL.ifV % 10 == 0) {
                        h.i(this.GxL);
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.CompositionSoftwareEncoder", e2, "acquireNextImage error", new Object[0]);
                } finally {
                    acquireNextImage.close();
                    AppMethodBeat.o(190514);
                }
            } else {
                AppMethodBeat.o(190514);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/vlog/model/CompositionSoftwareEncoder$initRgb2YuvImageReader$1$2"})
    static final class f implements Runnable {
        final /* synthetic */ h GxL;
        final /* synthetic */ ImageReader igf;

        f(ImageReader imageReader, h hVar) {
            this.igf = imageReader;
            this.GxL = hVar;
        }

        public final void run() {
            EGLContext eGLContext = null;
            AppMethodBeat.i(190515);
            Surface surface = this.igf.getSurface();
            p.g(surface, "it.surface");
            if (surface.isValid()) {
                h hVar = this.GxL;
                c.a aVar = com.tencent.mm.media.k.c.ilt;
                Surface surface2 = this.igf.getSurface();
                RenderContext renderContext = this.GxL.GxC;
                hVar.ifM = c.a.a(aVar, surface2, 0, 0, renderContext != null ? renderContext.eglContext() : null, 14);
                this.GxL.ifL = new com.tencent.mm.media.j.b.h(1, 15);
                com.tencent.mm.media.j.b.h hVar2 = this.GxL.ifL;
                if (hVar2 != null) {
                    hVar2.cY(this.GxL.ifN, this.GxL.ifO);
                }
                StringBuilder append = new StringBuilder("create rgb2yuvEGLEnvironment:").append(this.GxL.ifM).append(", shareEGLContext:");
                RenderContext renderContext2 = this.GxL.GxC;
                if (renderContext2 != null) {
                    eGLContext = renderContext2.eglContext();
                }
                Log.i("MicroMsg.CompositionSoftwareEncoder", append.append(eGLContext).toString());
                AppMethodBeat.o(190515);
                return;
            }
            Log.e("MicroMsg.CompositionSoftwareEncoder", "create rgb2yuvEGLEnvironment error surface invalid");
            this.GxL.GxH = false;
            AppMethodBeat.o(190515);
        }
    }

    private final void aMo() {
        AppMethodBeat.i(190518);
        synchronized (this.ifR) {
            try {
                Log.i("MicroMsg.CompositionSoftwareEncoder", "notify to encode");
                this.ifR.notifyAll();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.CompositionSoftwareEncoder", e2, "", new Object[0]);
            }
            try {
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(190518);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class g implements Runnable {
        final /* synthetic */ h GxL;
        final /* synthetic */ long kPc;

        g(h hVar, long j2) {
            this.GxL = hVar;
            this.kPc = j2;
        }

        public final void run() {
            EGLDisplay eGLDisplay;
            EGLSurface eGLSurface;
            EGLDisplay eGLDisplay2;
            EGLSurface eGLSurface2 = null;
            AppMethodBeat.i(190516);
            Log.i("MicroMsg.CompositionSoftwareEncoder", "render gpu rgb2yuv, timestamp:" + this.kPc);
            com.tencent.mm.media.j.b.h hVar = this.GxL.ifL;
            if (hVar != null) {
                hVar.aED();
            }
            c.b bVar = this.GxL.ifM;
            if (bVar != null) {
                eGLDisplay = bVar.ilu;
            } else {
                eGLDisplay = null;
            }
            c.b bVar2 = this.GxL.ifM;
            if (bVar2 != null) {
                eGLSurface = bVar2.eglSurface;
            } else {
                eGLSurface = null;
            }
            EGLExt.eglPresentationTimeANDROID(eGLDisplay, eGLSurface, this.kPc * 1000);
            c.a aVar = com.tencent.mm.media.k.c.ilt;
            c.b bVar3 = this.GxL.ifM;
            if (bVar3 != null) {
                eGLDisplay2 = bVar3.ilu;
            } else {
                eGLDisplay2 = null;
            }
            c.b bVar4 = this.GxL.ifM;
            if (bVar4 != null) {
                eGLSurface2 = bVar4.eglSurface;
            }
            c.a.a(eGLDisplay2, eGLSurface2);
            this.GxL.ifU++;
            AppMethodBeat.o(190516);
        }
    }

    private final boolean b(int i2, int i3, Image.Plane plane) {
        AppMethodBeat.i(190519);
        synchronized (this.stopLock) {
            try {
                checkInitBufId();
                if (this.bufId < 0) {
                    return false;
                }
                long currentTicks = Util.currentTicks();
                Log.i("MicroMsg.CompositionSoftwareEncoder", "processImageRGBABufferToWriteRGBAData, width:" + i2 + ", height:" + i3);
                int rowStride = plane.getRowStride();
                int pixelStride = plane.getPixelStride();
                if (this.ifH == null) {
                    this.ifH = ByteBuffer.allocateDirect(i2 * i3 * pixelStride);
                }
                ByteBuffer byteBuffer = this.ifH;
                if (byteBuffer != null) {
                    byteBuffer.position(0);
                }
                ByteBuffer buffer = plane.getBuffer();
                buffer.position(0);
                SightVideoJNI.nativeBufferCopy(buffer, this.ifH, i2 * pixelStride, i3, rowStride - (pixelStride * i2));
                SightVideoJNI.writeRGBDataForMMSight(this.bufId, this.ifH, i2, i3, false, false, i2, i3);
                Log.i("MicroMsg.CompositionSoftwareEncoder", "end processImageRGBABufferToWriteRGBAData, cost:" + Util.ticksToNow(currentTicks));
                this.GxI++;
                AppMethodBeat.o(190519);
                return true;
            } finally {
                AppMethodBeat.o(190519);
            }
        }
    }

    private final boolean a(int i2, int i3, Image.Plane plane) {
        AppMethodBeat.i(190520);
        synchronized (this.stopLock) {
            try {
                checkInitBufId();
                if (this.bufId >= 0) {
                    long currentTicks = Util.currentTicks();
                    Log.i("MicroMsg.CompositionSoftwareEncoder", "processImageYUVBufferToWriteYUVData, width:" + i2 + ", height:" + i3 + ", videoWidth:" + this.videoWidth + ", videoHeight:" + this.videoHeight);
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
                    Log.i("MicroMsg.CompositionSoftwareEncoder", "end processImageYUVBufferToWriteYUVData, cost:" + Util.ticksToNow(currentTicks));
                }
            } catch (Throwable th) {
                AppMethodBeat.o(190520);
                throw th;
            }
        }
        AppMethodBeat.o(190520);
        return false;
    }

    private final void checkInitBufId() {
        AppMethodBeat.i(190521);
        if (this.bufId < 0 && (this.muxer instanceof TAVKitMuxer.SightVideoJNIMediaMuxer)) {
            IMediaMuxer iMediaMuxer = this.muxer;
            if (iMediaMuxer == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.TAVKitMuxer.SightVideoJNIMediaMuxer");
                AppMethodBeat.o(190521);
                throw tVar;
            } else if (((TAVKitMuxer.SightVideoJNIMediaMuxer) iMediaMuxer).getBufId() >= 0) {
                IMediaMuxer iMediaMuxer2 = this.muxer;
                if (iMediaMuxer2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.TAVKitMuxer.SightVideoJNIMediaMuxer");
                    AppMethodBeat.o(190521);
                    throw tVar2;
                }
                this.bufId = ((TAVKitMuxer.SightVideoJNIMediaMuxer) iMediaMuxer2).getBufId();
                Log.i("MicroMsg.CompositionSoftwareEncoder", "set bufId:" + this.bufId);
            }
        }
        AppMethodBeat.o(190521);
    }

    /* JADX DEBUG: Type inference failed for r0v5. Raw type applied. Possible types: com.tencent.f.e.f<R>, com.tencent.f.e.f<?> */
    private final void fAR() {
        AppMethodBeat.i(190522);
        if (this.ifx == null) {
            Log.i("MicroMsg.CompositionSoftwareEncoder", "do start encode loop");
            this.ifx = (com.tencent.f.e.f<R>) com.tencent.f.e.f.hmn().hms().c(new b(this));
            com.tencent.f.e.f<?> fVar = this.ifx;
            if (fVar != null) {
                fVar.begin();
                AppMethodBeat.o(190522);
                return;
            }
        }
        AppMethodBeat.o(190522);
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public final MediaFormat getEncodeFormat() {
        AppMethodBeat.i(190523);
        MediaFormat mediaFormat = this.videoFormat;
        if (mediaFormat == null) {
            p.hyc();
        }
        AppMethodBeat.o(190523);
        return mediaFormat;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public final void setVideoSampleRenderContext(RenderContext renderContext) {
        AppMethodBeat.i(190524);
        this.GxC = renderContext;
        if (this.GxC != null && this.GxH && this.ifM == null) {
            int i2 = this.videoWidth;
            int i3 = this.videoHeight;
            this.ifN = i2 / 4;
            this.ifO = (i3 * 3) / 2;
            this.ifI = ImageReader.newInstance(this.ifN, this.ifO, 1, 1);
            ImageReader imageReader = this.ifI;
            if (imageReader != null) {
                this.ifK.start();
                this.ifJ = new Handler(this.ifK.getLooper());
                imageReader.setOnImageAvailableListener(new e(this), this.ifJ);
                Handler handler = this.ifJ;
                if (handler != null) {
                    handler.post(new f(imageReader, this));
                }
            }
            Log.i("MicroMsg.CompositionSoftwareEncoder", "initRgb2YuvImageReader, yuv size:[" + this.ifN + 'x' + this.ifO + ']');
        }
        AppMethodBeat.o(190524);
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public final long getEncodePresentationTimeUs() {
        return this.bqM;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public final void signalEndOfInputStream() {
        AppMethodBeat.i(190525);
        Log.i("MicroMsg.CompositionSoftwareEncoder", "signalEndOfInputStream");
        fAS();
        AppMethodBeat.o(190525);
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public final Surface createInputSurface() {
        AppMethodBeat.i(190526);
        Log.i("MicroMsg.CompositionSoftwareEncoder", "createInputSurface");
        ImageReader imageReader = this.GxE;
        if (imageReader != null) {
            Surface surface = imageReader.getSurface();
            AppMethodBeat.o(190526);
            return surface;
        }
        AppMethodBeat.o(190526);
        return null;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public final boolean start() {
        AppMethodBeat.i(190527);
        Log.i("MicroMsg.CompositionSoftwareEncoder", "start");
        this.ifQ = Util.currentTicks();
        AppMethodBeat.o(190527);
        return true;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public final void setMediaMuxer(IMediaMuxer iMediaMuxer) {
        AppMethodBeat.i(190528);
        this.muxer = iMediaMuxer;
        Log.i("MicroMsg.CompositionSoftwareEncoder", "setMediaMuxer: ".concat(String.valueOf(iMediaMuxer)));
        if (iMediaMuxer instanceof TAVKitMuxer.SightVideoJNIMediaMuxer) {
            ((TAVKitMuxer.SightVideoJNIMediaMuxer) iMediaMuxer).configMuxerToSoftEncode(true);
        }
        AppMethodBeat.o(190528);
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public final void stop() {
        AppMethodBeat.i(190529);
        Log.i("MicroMsg.CompositionSoftwareEncoder", "stop");
        aMi();
        AppMethodBeat.o(190529);
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public final CGSize getEncodeSize() {
        AppMethodBeat.i(190530);
        CGSize cGSize = this.videoSize;
        if (cGSize == null) {
            cGSize = CGSize.CGSizeZero;
            p.g(cGSize, "CGSize.CGSizeZero");
        }
        AppMethodBeat.o(190530);
        return cGSize;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public final boolean isEncodeToEndOfStream() {
        return this.GxD;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public final void release() {
        AppMethodBeat.i(190531);
        Log.i("MicroMsg.CompositionSoftwareEncoder", "release");
        aMi();
        AppMethodBeat.o(190531);
    }

    private final void aMi() {
        Handler handler;
        AppMethodBeat.i(190532);
        synchronized (this.stopLock) {
            try {
                Log.i("MicroMsg.CompositionSoftwareEncoder", "finishEncode, imageReader:" + this.GxE + ", encodePipeline:" + this.ifx + ", isInputEndOfStream:" + this.GxD);
                this.ifP = true;
                ImageReader imageReader = this.GxE;
                if (imageReader != null) {
                    imageReader.close();
                }
                this.GxG.quitSafely();
                if (this.GxH) {
                    aMo();
                }
                ImageReader imageReader2 = this.ifI;
                if (imageReader2 != null) {
                    imageReader2.close();
                }
                c.b bVar = this.ifM;
                if (!(bVar == null || (handler = this.ifJ) == null)) {
                    handler.post(new c(bVar, this));
                }
                this.ifK.quitSafely();
                this.ifI = null;
                this.ifM = null;
                com.tencent.f.e.f<?> fVar = this.ifx;
                if (fVar != null) {
                    fVar.take();
                }
                this.GxE = null;
                this.ifx = null;
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(190532);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/vlog/model/CompositionSoftwareEncoder$finishEncode$1$1$1", "com/tencent/mm/plugin/vlog/model/CompositionSoftwareEncoder$$special$$inlined$let$lambda$1"})
    public static final class c implements Runnable {
        final /* synthetic */ h GxL;
        final /* synthetic */ c.b ifZ;

        c(c.b bVar, h hVar) {
            this.ifZ = bVar;
            this.GxL = hVar;
        }

        public final void run() {
            AppMethodBeat.i(190512);
            com.tencent.mm.media.j.b.h hVar = this.GxL.ifL;
            if (hVar != null) {
                hVar.release();
            }
            c.a aVar = com.tencent.mm.media.k.c.ilt;
            c.a.a(this.ifZ);
            AppMethodBeat.o(190512);
        }
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public final boolean isNeedVideoOutputTexture() {
        return this.GxH;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public final void inputVideoTexture(TextureInfo textureInfo) {
        AppMethodBeat.i(190533);
        IMediaMuxer iMediaMuxer = this.muxer;
        if (!(iMediaMuxer == null || !iMediaMuxer.isMuxerStarted() || textureInfo == null)) {
            Log.i("MicroMsg.CompositionSoftwareEncoder", "input sample buffer render texture:" + textureInfo + ", sampleTime:" + this.bqM);
            com.tencent.mm.media.j.b.h hVar = this.ifL;
            if (hVar != null) {
                hVar.ikZ = textureInfo.textureID;
            }
            com.tencent.mm.media.j.b.h hVar2 = this.ifL;
            if (hVar2 != null) {
                hVar2.cZ(textureInfo.width, textureInfo.height);
            }
        }
        if (this.ifP || this.ifV - this.ifA < 10) {
            AppMethodBeat.o(190533);
            return;
        }
        Log.i("MicroMsg.CompositionSoftwareEncoder", "writeYuvCount:" + this.ifV + ", curEncodeIndex:" + this.ifA + ", need to wait encode");
        synchronized (this.ifT) {
            try {
                this.ifT.wait(500);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.CompositionSoftwareEncoder", e2, "", new Object[0]);
            }
            try {
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(190533);
            }
        }
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public final boolean writeVideoSample(CMSampleBuffer cMSampleBuffer, boolean z) {
        IMediaMuxer iMediaMuxer;
        AppMethodBeat.i(190534);
        boolean z2 = (cMSampleBuffer == null || (iMediaMuxer = this.muxer) == null || !iMediaMuxer.isMuxerStarted()) ? false : true;
        if (cMSampleBuffer != null) {
            StringBuilder sb = new StringBuilder("writeVideoSample sampleTimeUs:");
            CMTime time = cMSampleBuffer.getTime();
            p.g(time, "sampleBuffer.time");
            Log.i("MicroMsg.CompositionSoftwareEncoder", sb.append(time.getTimeUs()).toString());
            if (this.ifM != null && this.GxH) {
                CMTime time2 = cMSampleBuffer.getTime();
                p.g(time2, "sampleBuffer.time");
                this.bqM = time2.getTimeUs();
                if (this.GxD) {
                    this.bqM = -1;
                }
                if (this.ifM != null && this.GxH) {
                    long j2 = this.bqM;
                    Handler handler = this.ifJ;
                    if (handler != null) {
                        handler.post(new g(this, j2));
                    }
                    fAR();
                }
            }
        }
        if (z) {
            Log.i("MicroMsg.CompositionSoftwareEncoder", "writeVideoSample endOfStream, sampleBuffer:".concat(String.valueOf(cMSampleBuffer)));
            fAS();
        }
        AppMethodBeat.o(190534);
        return z2;
    }

    private final void fAS() {
        AppMethodBeat.i(190535);
        this.GxD = true;
        this.bqM = -1;
        Log.i("MicroMsg.CompositionSoftwareEncoder", "onInputEndOfStream, renderYuvCount:" + this.ifU + ", writeYuvCount:" + this.ifV + ", writeRGBCount:" + this.GxI + ", rgbAvailableCount:" + this.GxJ);
        AppMethodBeat.o(190535);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/threadpool/internal/Pipeline$NIL;", "kotlin.jvm.PlatformType", "input"})
    public static final class b<I, O> implements com.tencent.f.e.a<E, R> {
        final /* synthetic */ h GxL;

        b(h hVar) {
            this.GxL = hVar;
        }

        @Override // com.tencent.f.e.a
        public final /* synthetic */ Object bT(Object obj) {
            AppMethodBeat.i(190511);
            h.p(this.GxL);
            x xVar = x.SXb;
            AppMethodBeat.o(190511);
            return xVar;
        }
    }

    public static final /* synthetic */ void p(h hVar) {
        AppMethodBeat.i(190542);
        long currentTicks = Util.currentTicks();
        while (!hVar.ifP) {
            long currentTicks2 = Util.currentTicks();
            int triggerEncode = SightVideoJNI.triggerEncode(hVar.bufId, Math.max(0, hVar.ifA), false);
            StringBuilder append = new StringBuilder("trigger encode use ").append(Util.ticksToNow(currentTicks2)).append("ms, curEncodeIndex:").append(hVar.ifA).append(", newEncodeIndex:").append(triggerEncode).append(", threadId:");
            Thread currentThread = Thread.currentThread();
            p.g(currentThread, "Thread.currentThread()");
            Log.i("MicroMsg.CompositionSoftwareEncoder", append.append(currentThread.getId()).toString());
            hVar.ifA = triggerEncode;
            if (hVar.GxH && hVar.ifA >= hVar.ifV && !hVar.ifP && !hVar.GxD) {
                synchronized (hVar.ifT) {
                    try {
                        Log.i("MicroMsg.CompositionSoftwareEncoder", "notify to continue render");
                        hVar.ifT.notifyAll();
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.CompositionSoftwareEncoder", e2, "", new Object[0]);
                    }
                    try {
                        x xVar = x.SXb;
                    } catch (Throwable th) {
                        AppMethodBeat.o(190542);
                        throw th;
                    }
                }
            }
            if (hVar.GxH) {
                synchronized (hVar.ifR) {
                    try {
                        hVar.ifR.wait();
                    } catch (Exception e3) {
                        Log.printErrStackTrace("MicroMsg.CompositionSoftwareEncoder", e3, "", new Object[0]);
                    }
                    try {
                        x xVar2 = x.SXb;
                    } catch (Throwable th2) {
                        AppMethodBeat.o(190542);
                        throw th2;
                    }
                }
            } else if (Math.abs(triggerEncode - hVar.ifA) <= 5) {
                try {
                    Thread.sleep(300);
                } catch (Exception e4) {
                    Log.e("MicroMsg.CompositionSoftwareEncoder", "thread sleep error");
                }
            }
        }
        Log.i("MicroMsg.CompositionSoftwareEncoder", "trigger end encode now, isInputEndOfStream:" + hVar.GxD);
        long currentTicks3 = Util.currentTicks();
        boolean z = !hVar.GxD;
        if (!z) {
            hVar.ifA = SightVideoJNI.triggerEncode(hVar.bufId, hVar.ifA, true);
        }
        StringBuilder append2 = new StringBuilder("trigger end encode use ").append(Util.ticksToNow(currentTicks3)).append("ms, curEncodeIndex:").append(hVar.ifA).append(", isCancel:").append(z).append(", threadId:");
        Thread currentThread2 = Thread.currentThread();
        p.g(currentThread2, "Thread.currentThread()");
        Log.i("MicroMsg.CompositionSoftwareEncoder", append2.append(currentThread2.getId()).toString());
        Log.i("MicroMsg.CompositionSoftwareEncoder", "totally encode cost:" + Util.ticksToNow(hVar.ifQ) + "ms, encodeLoop cost:" + Util.ticksToNow(currentTicks) + LocaleUtil.MALAY);
        Log.i("MicroMsg.CompositionSoftwareEncoder", "renderYuvCount:" + hVar.ifU + ", writeYuvCount:" + hVar.ifV + ", writeRGBCount:" + hVar.GxI + ", rgbAvailableCount:" + hVar.GxJ);
        AppMethodBeat.o(190542);
    }
}

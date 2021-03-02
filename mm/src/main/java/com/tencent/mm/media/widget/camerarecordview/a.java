package com.tencent.mm.media.widget.camerarecordview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.IntBuffer;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.r;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010@\u001a\u00020\u0013H\u0002J\u0006\u0010A\u001a\u00020\u0013J\u000e\u0010B\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\u000eJ\u0016\u0010D\u001a\u00020\u00132\u0006\u0010E\u001a\u00020F2\u0006\u0010\u001e\u001a\u00020\tJ+\u0010G\u001a\u00020\u00132#\u0010H\u001a\u001f\u0012\u0013\u0012\u00110I¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(J\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001fJ\b\u0010K\u001a\u00020\u000eH\u0002J\u0006\u0010L\u001a\u00020\u000eJ\u0006\u0010M\u001a\u00020\tJ\u0010\u0010N\u001a\u00020O2\b\b\u0002\u0010P\u001a\u00020\u000eJ\u0006\u0010Q\u001a\u00020\tJ\u0006\u0010R\u001a\u00020FJ\u0006\u0010S\u001a\u00020FJ\b\u0010T\u001a\u00020\u0013H\u0002J\u0006\u0010U\u001a\u00020\u001bJ\u0006\u0010V\u001a\u000206J\b\u0010W\u001a\u0004\u0018\u00010XJ\u0010\u0010Y\u001a\u00020\u00132\u0006\u0010Z\u001a\u00020[H\u0002J\u0006\u0010\\\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010]\u001a\u00020\u000eJ.\u0010^\u001a\u00020\u00132\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020\t2\u0006\u0010c\u001a\u00020\t2\u0006\u0010d\u001a\u00020\u001bJ\u000e\u0010e\u001a\u00020\u00132\u0006\u0010f\u001a\u00020\tJ\u0006\u0010g\u001a\u00020\u0013J\u0006\u0010h\u001a\u00020\u0013J\u0006\u0010i\u001a\u00020\u0013J\u000e\u0010j\u001a\u00020\u00132\u0006\u0010k\u001a\u00020\u000eJ\u0010\u0010l\u001a\u00020\u00132\b\u0010m\u001a\u0004\u0018\u00010nJ\u000e\u0010o\u001a\u00020\u00132\u0006\u0010p\u001a\u00020\tJ\u000e\u0010q\u001a\u00020\u00132\u0006\u0010r\u001a\u00020`J\u000e\u0010s\u001a\u00020\u00132\u0006\u0010t\u001a\u00020\u000eJ\u000e\u0010u\u001a\u00020\u00132\u0006\u0010v\u001a\u00020\u001bJ\b\u0010w\u001a\u00020\u0013H\u0002J\u0018\u0010x\u001a\u00020\u00132\u0006\u0010y\u001a\u00020F2\u0006\u0010\u001e\u001a\u00020\u0001H\u0002JA\u0010z\u001a\u00020\u00132\b\b\u0002\u0010?\u001a\u00020\u000e2\b\b\u0002\u0010{\u001a\u00020`2%\b\u0002\u0010H\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(|\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001fJ\u001a\u0010}\u001a\u00020\u000e2\b\b\u0002\u0010~\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u00020\tJ\u0007\u0010\u0001\u001a\u00020\u0013J0\u0010\u0001\u001a\u00020\u000e2'\b\u0002\u0010H\u001a!\u0012\u0015\u0012\u00130\u0001¢\u0006\r\b \u0012\t\b!\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001fJ\u0012\u0010\u0001\u001a\u00020\u000e2\t\b\u0002\u0010\u0001\u001a\u00020\u000eJ\u0018\u0010\u0001\u001a\u00020\u00132\u0006\u0010E\u001a\u00020F2\u0007\u0010\u0001\u001a\u00020\u000eJ.\u0010\u0001\u001a\u00020\u00132%\u0010H\u001a!\u0012\u0017\u0012\u0015\u0018\u00010\u0001¢\u0006\r\b \u0012\t\b!\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u00020\u00130\u001fJ\"\u0010\u0001\u001a\u00020\u00132\u0007\u0010\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R^\u0010#\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001f2#\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010\u0004R\u000e\u0010-\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020>X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "(Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;)V", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "cameraPreviewInfo", "Lkotlin/Triple;", "", "context", "Landroid/content/Context;", "currentState", "customOrientation", "", "daemonRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "frameRenderCallback", "Lkotlin/Function0;", "", "getFrameRenderCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameRenderCallback", "(Lkotlin/jvm/functions/Function0;)V", "initRecorderRet", "isRecording", "lastFlipCameraStamp", "", "mediaRecorder", "needResumeRecorder", "value", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "onHDRCheckerResult", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "orientationFit", "Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit;", "getProcess", "()Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "setProcess", "recordFinish", "recordMiniTime", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "reportJSON", "Lcom/tencent/mm/json/JSONObject;", "startPreviewStamp", "startRecordTimeStamp", "getStartRecordTimeStamp", "()J", "setStartRecordTimeStamp", "(J)V", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "useBackGroundCamera", "afterStartPreview", "cancelRecord", "checkFlashStatus", "openFlash", "configVendorTagValue", "tag", "", "createImageReaderCallback", "callback", "", "data", "createRecorder", "enableSwitchCamera", "getCameraOrientaion", "getCameraPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "getFlashMode", "getMD5", "getRecordFilePath", "getRecordMuxerType", "getRecordTime", "getReportJSON", "getSupportZoomRatios", "", "initRecorder", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "isPreviewing", "isUseBackGroundCamera", "postFocusOnTouch", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "prepareCameraZoom", "baseTopLocation", "release", "removeFocusOnTouch", "resetRecord", "setCustomOrientationEnable", "enable", "setDisplayScreenSize", "screenSize", "Landroid/util/Size;", "setFlashMode", "flash", "setForceZoomTargetRatio", "ratio", "setMute", "mute", "setRecordMiniTime", "time", "setRender", "setValueToReport", "key", "startPreview", "displayRatio", "success", JsApiStartRecordVoice.NAME, "isLandscape", "deviceDegree", "stopPreview", JsApiStopRecordVoice.NAME, "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "capture", "switchCamera", "ignoreFlipCheck", "switchVendorTag", "isChecked", "takePicture", "Landroid/graphics/Bitmap;", "bitmap", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "Companion", "plugin-mediaeditor_release"})
public final class a {
    public static final C0430a ipI = new C0430a((byte) 0);
    private Context context;
    public int currentState = 1;
    private final MMHandler hAk = new MMHandler(Looper.getMainLooper());
    public final com.tencent.mm.media.widget.a.d hAt;
    com.tencent.mm.media.j.a ihs;
    public kotlin.g.a.b<? super Boolean, x> imw;
    private long ipA = 2000;
    public com.tencent.mm.media.widget.camerarecordview.c.a ipB;
    private volatile boolean ipC;
    public boolean ipD;
    kotlin.g.a.a<x> ipE;
    private long ipF;
    public com.tencent.mm.ab.i ipG = new com.tencent.mm.ab.i();
    public com.tencent.mm.media.widget.camerarecordview.d.a ipH;
    public com.tencent.mm.media.widget.c.b ipr;
    private com.tencent.mm.media.widget.c.b ips;
    public boolean ipt = true;
    public long ipu;
    private boolean ipv;
    private volatile boolean ipw;
    private volatile r<Integer, Integer, Integer> ipx = new r<>(0, 0, 0);
    private long ipy;
    private boolean ipz;

    static {
        AppMethodBeat.i(94250);
        AppMethodBeat.o(94250);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/SurfaceTexture;", "invoke"})
    public static final class e extends q implements kotlin.g.a.b<SurfaceTexture, x> {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ a ipJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(a aVar, kotlin.g.a.b bVar) {
            super(1);
            this.ipJ = aVar;
            this.gWe = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(94218);
            final SurfaceTexture surfaceTexture2 = surfaceTexture;
            this.ipJ.hAk.post(new Runnable(this) {
                /* class com.tencent.mm.media.widget.camerarecordview.a.e.AnonymousClass1 */
                final /* synthetic */ e ipK;

                {
                    this.ipK = r1;
                }

                public final void run() {
                    AppMethodBeat.i(94217);
                    this.ipK.ipJ.ipF = Util.currentTicks();
                    a.a(this.ipK.ipJ, "StartPreviewTimeStamp", Long.valueOf(this.ipK.ipJ.ipF));
                    this.ipK.ipJ.hAt.a(surfaceTexture2, this.ipK.ipJ.ipH.aQw(), this.ipK.ipJ.ipH.getResolutionLimit());
                    if (!this.ipK.ipJ.hAt.aPc() && !this.ipK.ipJ.ipH.aQw()) {
                        com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
                        com.tencent.mm.media.k.e.aNp();
                    }
                    kotlin.g.a.b bVar = this.ipK.gWe;
                    if (bVar != null) {
                        bVar.invoke(Boolean.valueOf(this.ipK.ipJ.hAt.aPc()));
                    }
                    a.n(this.ipK.ipJ);
                    AppMethodBeat.o(94217);
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(94218);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/nio/IntBuffer;", "invoke", "com/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer$takePicture$2$1"})
    static final class i extends q implements kotlin.g.a.b<IntBuffer, x> {
        final /* synthetic */ long imG;
        final /* synthetic */ a ipJ;
        final /* synthetic */ kotlin.g.a.b ipQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(a aVar, kotlin.g.a.b bVar, long j2) {
            super(1);
            this.ipJ = aVar;
            this.ipQ = bVar;
            this.imG = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IntBuffer intBuffer) {
            int i2;
            AppMethodBeat.i(94222);
            IntBuffer intBuffer2 = intBuffer;
            p.h(intBuffer2, LocaleUtil.ITALIAN);
            intBuffer2.position(0);
            com.tencent.mm.media.j.a aVar = this.ipJ.ihs;
            int aMM = aVar != null ? aVar.aMM() : 0;
            com.tencent.mm.media.j.a aVar2 = this.ipJ.ihs;
            if (aVar2 != null) {
                i2 = aVar2.aMN();
            } else {
                i2 = 0;
            }
            if (i2 == 0 || i2 == 0) {
                this.ipQ.invoke(null);
            } else {
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(aMM, i2, Bitmap.Config.ARGB_8888);
                    createBitmap.copyPixelsFromBuffer(intBuffer2);
                    Log.i("MicroMsg.CameraPreviewContainer", "take photo cost1 " + Util.ticksToNow(this.imG));
                    this.ipQ.invoke(createBitmap);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.CameraPreviewContainer", e2, "", new Object[0]);
                    this.ipQ.invoke(null);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(94222);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/Bitmap;", "invoke"})
    static final class j extends q implements kotlin.g.a.b<Bitmap, x> {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ a ipJ;
        final /* synthetic */ long ipR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(a aVar, long j2, kotlin.g.a.b bVar) {
            super(1);
            this.ipJ = aVar;
            this.ipR = j2;
            this.gWe = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Bitmap bitmap) {
            AppMethodBeat.i(94223);
            Bitmap bitmap2 = bitmap;
            p.h(bitmap2, LocaleUtil.ITALIAN);
            if (this.ipJ.hAt.aPu() == 0) {
                com.tencent.mm.media.widget.d.a aVar = com.tencent.mm.media.widget.d.a.itg;
                com.tencent.mm.media.widget.d.a.zX(Util.ticksToNow(this.ipR));
            } else {
                com.tencent.mm.media.widget.d.a aVar2 = com.tencent.mm.media.widget.d.a.itg;
                com.tencent.mm.media.widget.d.a.zW(Util.ticksToNow(this.ipR));
            }
            Log.i("MicroMsg.CameraPreviewContainer", "take photo use image frame cost1 " + Util.ticksToNow(this.ipR));
            this.gWe.invoke(bitmap2);
            x xVar = x.SXb;
            AppMethodBeat.o(94223);
            return xVar;
        }
    }

    public a(com.tencent.mm.media.widget.camerarecordview.d.a aVar) {
        p.h(aVar, "process");
        AppMethodBeat.i(94249);
        this.ipH = aVar;
        Log.printInfoStack("MicroMsg.CameraPreviewContainer", this.ipH.toString(), new Object[0]);
        com.tencent.mm.media.widget.camerarecordview.preview.e cameraPreviewView = this.ipH.getCameraPreviewView();
        if (this.ipH.getPreviewRenderer() != null) {
            this.ihs = this.ipH.getPreviewRenderer();
            com.tencent.mm.media.j.a previewRenderer = this.ipH.getPreviewRenderer();
            if (previewRenderer == null) {
                p.hyc();
            }
            cameraPreviewView.a(previewRenderer, this.ipH.aQw());
        } else {
            d dVar = new d(this);
            this.ihs = dVar;
            cameraPreviewView.a(dVar, this.ipH.aQw());
        }
        if (!com.tencent.mm.media.widget.d.b.rG(this.ipH.getRecordScene()) || this.ipH.aQw()) {
            this.hAt = new com.tencent.mm.media.widget.a.c(this.ipH.getContext());
            k("isUseCamera2", Boolean.FALSE);
        } else {
            this.hAt = new com.tencent.mm.media.widget.b.c(this.ipH.getContext());
            if (com.tencent.mm.media.widget.d.b.rH(this.ipH.getRecordScene())) {
                this.hAt.aPd();
            }
            k("isUseCamera2", Boolean.TRUE);
        }
        this.ipy = Util.currentTicks();
        this.context = this.ipH.getContext();
        this.ipB = new com.tencent.mm.media.widget.camerarecordview.c.a(this.context, this.ipH);
        AppMethodBeat.o(94249);
    }

    public static final /* synthetic */ void a(a aVar, String str, Object obj) {
        AppMethodBeat.i(218876);
        aVar.k(str, obj);
        AppMethodBeat.o(218876);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer$Companion;", "", "()V", "REPORT_CAMERA_FIRST_FRAME_COST", "", "REPORT_CAMERA_IS_CAMERA2", "REPORT_CAMERA_OPEN_COST", "REPORT_HIGH_RECORD_TIME", "REPORT_LOW_RECORD_TIME", "REPORT_OPEN_CAMERA_TIME_STAMP", "REPORT_PREVIEW_SUCCESS_TIME_STAMP", "REPORT_RECORD_MUXER_TYPE", "REPORT_START_PREVIEW_TIME_STAMP", "STATE_IN_PAUSE", "", "STATE_IN_PREVIEW", "SWITCH_BLOCK_TIME", "TAG", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.a$a  reason: collision with other inner class name */
    public static final class C0430a {
        private C0430a() {
        }

        public /* synthetic */ C0430a(byte b2) {
            this();
        }
    }

    public static /* synthetic */ boolean a(a aVar) {
        AppMethodBeat.i(94225);
        boolean j2 = aVar.j(false, 0);
        AppMethodBeat.o(94225);
        return j2;
    }

    public final boolean j(boolean z, int i2) {
        Integer num = null;
        AppMethodBeat.i(94224);
        Log.printInfoStack("MicroMsg.CameraPreviewContainer", JsApiStartRecordVoice.NAME, new Object[0]);
        if (this.hAt.aPr() == null || this.ipr == null) {
            Log.printInfoStack("MicroMsg.CameraPreviewContainer", "cameraConfig is null", new Object[0]);
            AppMethodBeat.o(94224);
            return false;
        } else if (!this.ipz) {
            Log.i("MicroMsg.CameraPreviewContainer", "startRecord, initRecorder failed");
            AppMethodBeat.o(94224);
            return false;
        } else {
            com.tencent.mm.media.widget.c.b bVar = this.ipr;
            Integer valueOf = bVar != null ? Integer.valueOf(bVar.b(com.tencent.mm.media.widget.a.b.aPk(), z, i2)) : null;
            Log.i("MicroMsg.CameraPreviewContainer", "start record ret:".concat(String.valueOf(valueOf)));
            if (this.ipH.aQy()) {
                com.tencent.mm.media.widget.c.b bVar2 = this.ips;
                if (bVar2 != null) {
                    num = Integer.valueOf(bVar2.b(com.tencent.mm.media.widget.a.b.aPk(), z, i2));
                }
            } else {
                num = -1;
            }
            if ((valueOf != null && valueOf.intValue() == 0) || (num != null && num.intValue() == 0)) {
                Log.i("MicroMsg.CameraPreviewContainer", "start record base ret:" + valueOf + " daemon ret:" + num + " ,use daemon record:" + this.ipH.aQy());
                this.ipu = Util.currentTicks();
                this.ipv = true;
                this.ipC = false;
                com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aOb();
                AppMethodBeat.o(94224);
                return true;
            }
            AppMethodBeat.o(94224);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class h implements Runnable {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ a ipJ;
        final /* synthetic */ z.f ipN;

        h(a aVar, z.f fVar, kotlin.g.a.b bVar) {
            this.ipJ = aVar;
            this.ipN = fVar;
            this.gWe = bVar;
        }

        public final void run() {
            AppMethodBeat.i(94221);
            if (!this.ipN.SYG.aQp()) {
                com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aOf();
                com.tencent.mm.media.widget.c.b bVar = this.ipJ.ipr;
                if (bVar != null) {
                    bVar.cancel();
                }
            }
            if (!this.ipN.SYG.aQo()) {
                com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aOg();
                com.tencent.mm.media.widget.c.b bVar2 = this.ipJ.ips;
                if (bVar2 != null) {
                    bVar2.cancel();
                }
            }
            this.ipJ.ipC = true;
            kotlin.g.a.b bVar3 = this.gWe;
            if (bVar3 != null) {
                bVar3.invoke(this.ipN.SYG);
                AppMethodBeat.o(94221);
                return;
            }
            AppMethodBeat.o(94221);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ a ipJ;
        final /* synthetic */ z.f ipL;
        final /* synthetic */ com.tencent.mm.media.k.a ipM;
        final /* synthetic */ z.f ipN;
        final /* synthetic */ z.d ipO;
        final /* synthetic */ z.f ipP;

        f(a aVar, z.f fVar, com.tencent.mm.media.k.a aVar2, z.f fVar2, z.d dVar, z.f fVar3, kotlin.g.a.b bVar) {
            this.ipJ = aVar;
            this.ipL = fVar;
            this.ipM = aVar2;
            this.ipN = fVar2;
            this.ipO = dVar;
            this.ipP = fVar3;
            this.gWe = bVar;
        }

        public final void run() {
            String str;
            com.tencent.mm.plugin.sight.base.a aNx;
            String str2 = null;
            AppMethodBeat.i(94219);
            if (this.ipJ.ipC) {
                AppMethodBeat.o(94219);
                return;
            }
            StringBuilder sb = new StringBuilder("stopRecord ");
            T t = this.ipL.SYG;
            StringBuilder append = sb.append(t != null ? t.getFilePath() : null).append(' ');
            T t2 = this.ipL.SYG;
            Log.printInfoStack("MicroMsg.CameraPreviewContainer", append.append(t2 != null ? t2.aQn() : null).toString(), new Object[0]);
            this.ipM.aBw();
            a.a(this.ipJ, "HighRecordStopWaitTime", Long.valueOf(this.ipM.hvh.apr()));
            T t3 = this.ipL.SYG;
            if (t3 != null) {
                str = t3.getFilePath();
            } else {
                str = null;
            }
            T t4 = this.ipL.SYG;
            if (t4 != null) {
                str2 = t4.aQn();
            }
            if (str == null || str2 == null || (aNx = com.tencent.mm.plugin.sight.base.e.aNx(str)) == null) {
                AppMethodBeat.o(94219);
                return;
            }
            this.ipN.SYG.iqf = true;
            this.ipN.SYG.Hw(str);
            this.ipN.SYG.Hx(str2);
            this.ipN.SYG.dvv = 0;
            this.ipN.SYG.iqg = aNx.videoDuration;
            this.ipO.SYE++;
            Log.i("MicroMsg.CameraPreviewContainer", "record video info main: ".concat(String.valueOf(aNx)));
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aOq();
            com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.zN((long) aNx.videoBitrate);
            com.tencent.mm.media.k.e eVar3 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.zO((long) aNx.frameRate);
            if ((!this.ipJ.ipH.aQy() || this.ipO.SYE != 2) && this.ipJ.ipH.aQy()) {
                MMHandlerThread.postToMainThreadDelayed(this.ipP.SYG, 3000);
                AppMethodBeat.o(94219);
                return;
            }
            if (this.ipJ.ipH.aQy() && this.ipO.SYE == 2) {
                com.tencent.mm.media.k.e eVar4 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aOe();
            }
            MMHandlerThread.removeRunnable(this.ipP.SYG);
            this.ipJ.ipC = true;
            kotlin.g.a.b bVar = this.gWe;
            if (bVar != null) {
                bVar.invoke(this.ipN.SYG);
                AppMethodBeat.o(94219);
                return;
            }
            AppMethodBeat.o(94219);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class g implements Runnable {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ a ipJ;
        final /* synthetic */ com.tencent.mm.media.k.a ipM;
        final /* synthetic */ z.f ipN;
        final /* synthetic */ z.d ipO;
        final /* synthetic */ z.f ipP;

        g(a aVar, com.tencent.mm.media.k.a aVar2, z.f fVar, z.d dVar, z.f fVar2, kotlin.g.a.b bVar) {
            this.ipJ = aVar;
            this.ipM = aVar2;
            this.ipN = fVar;
            this.ipO = dVar;
            this.ipP = fVar2;
            this.gWe = bVar;
        }

        public final void run() {
            String str;
            com.tencent.mm.plugin.sight.base.a aNx;
            String str2 = null;
            AppMethodBeat.i(94220);
            if (this.ipJ.ipC) {
                AppMethodBeat.o(94220);
                return;
            }
            StringBuilder sb = new StringBuilder("stop daemonRecorder ");
            com.tencent.mm.media.widget.c.b bVar = this.ipJ.ips;
            StringBuilder append = sb.append(bVar != null ? bVar.getFilePath() : null).append(' ');
            com.tencent.mm.media.widget.c.b bVar2 = this.ipJ.ips;
            Log.printInfoStack("MicroMsg.CameraPreviewContainer", append.append(bVar2 != null ? bVar2.aQn() : null).toString(), new Object[0]);
            this.ipM.aBw();
            a.a(this.ipJ, "LowRecordStopWaitTime", Long.valueOf(this.ipM.hvh.apr()));
            com.tencent.mm.media.widget.c.b bVar3 = this.ipJ.ips;
            if (bVar3 != null) {
                str = bVar3.getFilePath();
            } else {
                str = null;
            }
            com.tencent.mm.media.widget.c.b bVar4 = this.ipJ.ips;
            if (bVar4 != null) {
                str2 = bVar4.aQn();
            }
            if (str == null || str2 == null || (aNx = com.tencent.mm.plugin.sight.base.e.aNx(str)) == null) {
                AppMethodBeat.o(94220);
                return;
            }
            this.ipN.SYG.iqf = true;
            p.h(str, "<set-?>");
            this.ipN.SYG.iqh = str;
            p.h(str2, "<set-?>");
            this.ipN.SYG.iqi = str2;
            this.ipN.SYG.iqj = 0;
            this.ipN.SYG.iqk = aNx.videoDuration;
            this.ipO.SYE++;
            Log.i("MicroMsg.CameraPreviewContainer", "record video info daemon: ".concat(String.valueOf(aNx)));
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aOr();
            com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.zP((long) aNx.videoBitrate);
            com.tencent.mm.media.k.e eVar3 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.zQ((long) aNx.frameRate);
            if (this.ipO.SYE == 2) {
                com.tencent.mm.media.k.e eVar4 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aOe();
                MMHandlerThread.removeRunnable(this.ipP.SYG);
                this.ipJ.ipC = true;
                kotlin.g.a.b bVar5 = this.gWe;
                if (bVar5 != null) {
                    bVar5.invoke(this.ipN.SYG);
                    AppMethodBeat.o(94220);
                    return;
                }
                AppMethodBeat.o(94220);
                return;
            }
            MMHandlerThread.postToMainThreadDelayed(this.ipP.SYG, 3000);
            AppMethodBeat.o(94220);
        }
    }

    public final void b(float f2, float f3, int i2, int i3) {
        AppMethodBeat.i(94228);
        if (this.currentState == 0) {
            this.hAt.b(f2, f3, i2, i3);
        }
        AppMethodBeat.o(94228);
    }

    public final void aPq() {
        AppMethodBeat.i(94229);
        if (this.currentState == 0) {
            this.hAt.aPq();
        }
        AppMethodBeat.o(94229);
    }

    public final void rz(int i2) {
        AppMethodBeat.i(94230);
        if (this.currentState == 0) {
            this.hAt.rw(i2);
        }
        AppMethodBeat.o(94230);
    }

    public final void i(boolean z, int i2) {
        AppMethodBeat.i(94231);
        if (this.currentState == 0) {
            this.hAt.i(z, i2);
        }
        AppMethodBeat.o(94231);
    }

    public final void zU(long j2) {
        AppMethodBeat.i(94232);
        Log.i("MicroMsg.CameraPreviewContainer", "setRecordMiniTime:".concat(String.valueOf(j2)));
        this.ipA = j2;
        AppMethodBeat.o(94232);
    }

    public static /* synthetic */ boolean b(a aVar) {
        AppMethodBeat.i(94234);
        boolean fh = aVar.fh(false);
        AppMethodBeat.o(94234);
        return fh;
    }

    public final boolean fh(boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(94233);
        if (!com.tencent.mm.media.widget.d.b.aQg()) {
            Log.i("MicroMsg.CameraPreviewContainer", "only one camera,forbid switch");
            if (!com.tencent.mm.media.widget.d.b.aRJ()) {
                AppMethodBeat.o(94233);
                return true;
            }
            AppMethodBeat.o(94233);
            return false;
        }
        Log.i("MicroMsg.CameraPreviewContainer", "flipCamera time space:" + Util.ticksToNow(this.ipy));
        if (z || Util.ticksToNow(this.ipy) >= 1000) {
            this.ipy = Util.currentTicks();
            if (this.ipv) {
                com.tencent.mm.media.widget.c.b bVar = this.ipr;
                if (bVar != null) {
                    bVar.pause();
                }
                com.tencent.mm.media.widget.c.b bVar2 = this.ips;
                if (bVar2 != null) {
                    bVar2.pause();
                }
            }
            this.ipH.getCameraPreviewView().aEy();
            this.ipt = this.hAt.aPb();
            com.tencent.mm.media.widget.a.b aPr = this.hAt.aPr();
            if (!this.ipD) {
                com.tencent.mm.media.widget.camerarecordview.c.a aVar = this.ipB;
                if (!this.ipt && this.ipH.aQx()) {
                    z2 = true;
                }
                aVar.a(z2, aPr);
            }
            if (aPr != null) {
                this.ipH.getCameraPreviewView().a(aPr);
                c cVar = c.ipU;
                com.tencent.mm.media.j.a renderer = c.getRenderer();
                if (renderer != null) {
                    renderer.cZ(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
                }
                c cVar2 = c.ipU;
                com.tencent.mm.media.j.a renderer2 = c.getRenderer();
                if (renderer2 != null) {
                    renderer2.qx(com.tencent.mm.media.widget.a.b.aPk());
                }
                c cVar3 = c.ipU;
                com.tencent.mm.media.j.a renderer3 = c.getRenderer();
                if (renderer3 != null) {
                    renderer3.eD(com.tencent.mm.media.widget.a.b.aPn());
                }
                com.tencent.mm.media.widget.c.b bVar3 = this.ipr;
                if (bVar3 != null) {
                    bVar3.setMirror(com.tencent.mm.media.widget.a.b.aPn());
                }
                com.tencent.mm.media.widget.c.b bVar4 = this.ips;
                if (bVar4 != null) {
                    bVar4.setMirror(com.tencent.mm.media.widget.a.b.aPn());
                }
                com.tencent.mm.media.widget.c.b bVar5 = this.ipr;
                if (bVar5 != null) {
                    bVar5.s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.aPl(), com.tencent.mm.media.widget.a.b.aPm());
                }
                com.tencent.mm.media.widget.c.b bVar6 = this.ips;
                if (bVar6 != null) {
                    bVar6.s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.aPl(), com.tencent.mm.media.widget.a.b.aPm());
                }
                if (this.ipv) {
                    this.ipx = new r<>(Integer.valueOf(com.tencent.mm.media.widget.a.b.aPk()), Integer.valueOf(com.tencent.mm.media.widget.a.b.getPreviewWidth()), Integer.valueOf(com.tencent.mm.media.widget.a.b.getPreviewHeight()));
                    this.ipw = true;
                }
            }
            boolean z3 = this.ipt;
            AppMethodBeat.o(94233);
            return z3;
        }
        boolean z4 = this.ipt;
        AppMethodBeat.o(94233);
        return z4;
    }

    public static boolean aQg() {
        AppMethodBeat.i(94235);
        boolean aQg = com.tencent.mm.media.widget.d.b.aQg();
        AppMethodBeat.o(94235);
        return aQg;
    }

    public final int aQh() {
        AppMethodBeat.i(94236);
        int aPv = this.hAt.aPv();
        AppMethodBeat.o(94236);
        return aPv;
    }

    public final void release() {
        AppMethodBeat.i(94237);
        try {
            Log.i("MicroMsg.CameraPreviewContainer", "release");
            this.hAt.onDestroy();
            this.hAt.release();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CameraPreviewContainer", e2, "camera release error:" + e2.getMessage(), new Object[0]);
        }
        com.tencent.mm.media.widget.camerarecordview.c.a aVar = this.ipB;
        aVar.iqs.disable();
        aVar.context = null;
        c cVar = c.ipU;
        c.aQk();
        this.ipH.getCameraPreviewView().release();
        com.tencent.mm.media.widget.c.b bVar = this.ipr;
        if (bVar != null) {
            bVar.cancel();
        }
        com.tencent.mm.media.widget.c.b bVar2 = this.ipr;
        if (bVar2 != null) {
            bVar2.clear();
        }
        com.tencent.mm.media.widget.c.b bVar3 = this.ips;
        if (bVar3 != null) {
            bVar3.cancel();
        }
        com.tencent.mm.media.widget.c.b bVar4 = this.ips;
        if (bVar4 != null) {
            bVar4.clear();
        }
        com.tencent.mm.media.j.a aVar2 = this.ihs;
        if (aVar2 != null) {
            aVar2.release(true);
        }
        this.ihs = null;
        AppMethodBeat.o(94237);
    }

    private final boolean aQi() {
        com.tencent.mm.media.widget.c.b a2;
        boolean ak;
        AppMethodBeat.i(94238);
        com.tencent.mm.media.widget.c.b recorder = this.ipH.getRecorder();
        Log.i("MicroMsg.CameraPreviewContainer", "createRecorder: " + this.ipr + ", useCpuCrop:" + this.ipH.aQw() + ", process.getRecorder():" + recorder + ", mute:" + this.ipH.Zx());
        com.tencent.mm.media.widget.c.b bVar = this.ipr;
        if (bVar != null) {
            bVar.cancel();
            bVar.clear();
        }
        com.tencent.mm.media.widget.c.b bVar2 = this.ips;
        if (bVar2 != null) {
            bVar2.cancel();
            bVar2.clear();
        }
        com.tencent.mm.media.widget.camerarecordview.b.a encodeConfig = this.ipH.getEncodeConfig();
        if (recorder != null) {
            this.ipr = recorder;
        } else {
            if (this.ipH.aQw()) {
                com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aNo();
                c cVar = c.ipU;
                a2 = c.a(encodeConfig.aQm(), this.ipH.getVideoTransPara(), this.hAt, this.ipH.getRecordRenderer());
            } else {
                com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aNn();
                if (this.ipH.getCameraPreviewView().getEGLContext() == null) {
                    Log.e("MicroMsg.CameraPreviewContainer", "gpu crop, preview view egl context is null!!!");
                    com.tencent.mm.media.k.e eVar3 = com.tencent.mm.media.k.e.ilC;
                    com.tencent.mm.media.k.e.aNp();
                    AppMethodBeat.o(94238);
                    return false;
                }
                c cVar2 = c.ipU;
                int aQm = encodeConfig.aQm();
                VideoTransPara videoTransPara = this.ipH.getVideoTransPara();
                com.tencent.mm.media.widget.a.d dVar = this.hAt;
                EGLContext eGLContext = this.ipH.getCameraPreviewView().getEGLContext();
                if (eGLContext == null) {
                    p.hyc();
                }
                a2 = c.a(aQm, videoTransPara, dVar, eGLContext, this.ipH.getCameraPreviewView(), this.ipH.aQw(), this.ipH.getRecordRenderer());
            }
            this.ipr = a2;
            if (this.ipH.getEncodeConfig().aQm() == 2) {
                ak = com.tencent.mm.plugin.sight.base.b.ak(false, this.ipH.getVideoTransPara().iTr == 1);
            } else {
                ak = com.tencent.mm.plugin.sight.base.b.ak(true, this.ipH.getVideoTransPara().iTs == 1);
            }
            k("RecordMuxerType", Boolean.valueOf(ak));
            if (this.ipH.aQy()) {
                com.tencent.mm.media.k.e eVar4 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aNn();
                if (this.ipH.getCameraPreviewView().getEGLContext() == null) {
                    Log.e("MicroMsg.CameraPreviewContainer", "gpu crop, preview view egl context is null!!!");
                    com.tencent.mm.media.k.e eVar5 = com.tencent.mm.media.k.e.ilC;
                    com.tencent.mm.media.k.e.aNp();
                    AppMethodBeat.o(94238);
                    return false;
                }
                c cVar3 = c.ipU;
                int aQm2 = encodeConfig.aQm();
                VideoTransPara daemonVideoTransPara = this.ipH.getDaemonVideoTransPara();
                com.tencent.mm.media.widget.a.d dVar2 = this.hAt;
                EGLContext eGLContext2 = this.ipH.getCameraPreviewView().getEGLContext();
                if (eGLContext2 == null) {
                    p.hyc();
                }
                this.ips = c.a(aQm2, daemonVideoTransPara, dVar2, eGLContext2, this.ipH.getCameraPreviewView(), this.ipH.aQw(), this.ipH.getRecordRenderer());
            }
        }
        com.tencent.mm.media.widget.c.b bVar3 = this.ipr;
        if (bVar3 != null) {
            bVar3.setMute(this.ipH.Zx());
        }
        com.tencent.mm.media.widget.c.b bVar4 = this.ips;
        if (bVar4 != null) {
            bVar4.setMute(true);
        }
        this.ipH.getCameraPreviewView().setOnDrawListener(new c(this));
        Log.i("MicroMsg.CameraPreviewContainer", "create recorder finish");
        AppMethodBeat.o(94238);
        return true;
    }

    public final void setMute(boolean z) {
        AppMethodBeat.i(218874);
        com.tencent.mm.media.widget.c.b bVar = this.ipr;
        if (bVar != null) {
            bVar.setMute(z);
            AppMethodBeat.o(218874);
            return;
        }
        AppMethodBeat.o(218874);
    }

    public final void q(kotlin.g.a.b<? super byte[], x> bVar) {
        AppMethodBeat.i(94239);
        p.h(bVar, "callback");
        this.hAt.aPe();
        this.hAt.a(new b(bVar));
        AppMethodBeat.o(94239);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "onFrameData"})
    static final class b implements com.tencent.mm.plugin.mmsight.model.g {
        final /* synthetic */ kotlin.g.a.b gWe;

        b(kotlin.g.a.b bVar) {
            this.gWe = bVar;
        }

        @Override // com.tencent.mm.plugin.mmsight.model.g
        public final boolean ai(byte[] bArr) {
            AppMethodBeat.i(94214);
            kotlin.g.a.b bVar = this.gWe;
            p.g(bArr, LocaleUtil.ITALIAN);
            bVar.invoke(bArr);
            AppMethodBeat.o(94214);
            return true;
        }
    }

    private final void aQj() {
        String str;
        boolean z;
        boolean z2;
        String str2 = null;
        AppMethodBeat.i(94240);
        com.tencent.mm.media.widget.c.b bVar = this.ipr;
        if (bVar != null) {
            bVar.s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.aPl(), com.tencent.mm.media.widget.a.b.aPm());
        }
        if (bVar != null) {
            bVar.setFilePath(this.ipH.getEncodeConfig().getFilePath());
        }
        if (bVar != null) {
            bVar.HA(this.ipH.getEncodeConfig().aQn());
        }
        Log.printInfoStack("MicroMsg.CameraPreviewContainer", "filePath : " + (bVar != null ? bVar.getFilePath() : null) + "   thumbPath : " + (bVar != null ? bVar.aQn() : null), new Object[0]);
        com.tencent.mm.media.widget.c.b bVar2 = this.ips;
        if (bVar2 != null) {
            bVar2.s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.aPl(), com.tencent.mm.media.widget.a.b.aPm());
        }
        if (bVar2 != null) {
            bVar2.setFilePath(this.ipH.getEncodeConfig().getFilePath() + "_daemon");
        }
        if (bVar2 != null) {
            bVar2.HA(this.ipH.getEncodeConfig().aQn() + "_daemon");
        }
        StringBuilder sb = new StringBuilder("filePath : ");
        if (bVar2 != null) {
            str = bVar2.getFilePath();
        } else {
            str = null;
        }
        StringBuilder append = sb.append(str).append("   thumbPath : ");
        if (bVar2 != null) {
            str2 = bVar2.aQn();
        }
        Log.printInfoStack("MicroMsg.CameraPreviewContainer", append.append(str2).toString(), new Object[0]);
        com.tencent.mm.media.widget.c.b bVar3 = this.ipr;
        if (bVar3 != null) {
            z = bVar3.rC(com.tencent.mm.media.widget.a.b.aPk());
        } else {
            z = false;
        }
        com.tencent.mm.media.widget.c.b bVar4 = this.ips;
        if (bVar4 != null) {
            z2 = bVar4.rC(com.tencent.mm.media.widget.a.b.aPk());
        } else {
            z2 = false;
        }
        if ((this.ips instanceof com.tencent.mm.media.widget.c.c) && (this.ipr instanceof com.tencent.mm.media.widget.c.c)) {
            com.tencent.mm.media.widget.c.b bVar5 = this.ips;
            if (bVar5 == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.MediaCodecMP4MuxRecorder");
                AppMethodBeat.o(94240);
                throw tVar;
            }
            com.tencent.mm.media.widget.c.c cVar = (com.tencent.mm.media.widget.c.c) bVar5;
            com.tencent.mm.media.widget.c.b bVar6 = this.ipr;
            if (bVar6 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.MediaCodecMP4MuxRecorder");
                AppMethodBeat.o(94240);
                throw tVar2;
            }
            cVar.a(((com.tencent.mm.media.widget.c.c) bVar6).aQW());
        }
        if ((this.ips instanceof com.tencent.mm.media.widget.c.e) && (this.ipr instanceof com.tencent.mm.media.widget.c.e)) {
            com.tencent.mm.media.widget.c.b bVar7 = this.ips;
            if (bVar7 == null) {
                t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.X264YUVMP4MuxRecorder");
                AppMethodBeat.o(94240);
                throw tVar3;
            }
            com.tencent.mm.media.widget.c.e eVar = (com.tencent.mm.media.widget.c.e) bVar7;
            com.tencent.mm.media.widget.c.b bVar8 = this.ipr;
            if (bVar8 == null) {
                t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.X264YUVMP4MuxRecorder");
                AppMethodBeat.o(94240);
                throw tVar4;
            }
            eVar.a(((com.tencent.mm.media.widget.c.e) bVar8).aQW());
        }
        Log.printInfoStack("MicroMsg.CameraPreviewContainer", "init recorder ret:" + z + "  daemonRet:" + z2, new Object[0]);
        this.ipz = z;
        AppMethodBeat.o(94240);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, hxF = {"com/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer$setRender$curRenderer$1", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
    public static final class d extends com.tencent.mm.media.j.d {
        final /* synthetic */ a ipJ;

        /* JADX WARN: Incorrect types in method signature: (I)V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar) {
            super(1);
            this.ipJ = aVar;
        }

        @Override // com.tencent.mm.media.j.a
        public final com.tencent.mm.media.j.b.a aEC() {
            AppMethodBeat.i(94216);
            if (this.ipJ.ipH.aQw()) {
                com.tencent.mm.media.j.b.f fVar = new com.tencent.mm.media.j.b.f(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
                AppMethodBeat.o(94216);
                return fVar;
            }
            com.tencent.mm.media.j.b.c cVar = new com.tencent.mm.media.j.b.c(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
            AppMethodBeat.o(94216);
            return cVar;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.media.widget.camerarecordview.a */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(a aVar, boolean z, kotlin.g.a.b bVar, int i2) {
        AppMethodBeat.i(94242);
        if ((i2 & 1) != 0) {
            z = aVar.ipt;
        }
        if ((i2 & 4) != 0) {
            bVar = null;
        }
        aVar.a(z, bVar);
        AppMethodBeat.o(94242);
    }

    public final void a(boolean z, kotlin.g.a.b<? super Boolean, x> bVar) {
        AppMethodBeat.i(94241);
        long currentTicks = Util.currentTicks();
        k("OpenCameraTimeStamp", Long.valueOf(currentTicks));
        if (this.currentState == 0) {
            Log.e("MicroMsg.CameraPreviewContainer", "startPreview, already in preview state");
            AppMethodBeat.o(94241);
            return;
        }
        this.currentState = 0;
        Log.printInfoStack("MicroMsg.CameraPreviewContainer", "startPreview process.useCpuCrop():" + this.ipH.aQw(), new Object[0]);
        this.ipt = z;
        if (!this.ipt && !com.tencent.mm.media.widget.d.b.aRJ()) {
            this.ipt = true;
            Log.i("MicroMsg.CameraPreviewContainer", "force useBackGroundCamera");
        }
        if (this.ipt && !com.tencent.mm.media.widget.d.b.aRK()) {
            this.ipt = false;
            Log.i("MicroMsg.CameraPreviewContainer", "force useFrontGroundCamera");
        }
        this.hAt.v(this.ipH.getContext(), this.ipt);
        if (this.ipH.aQw()) {
            this.hAt.a(this.ipH.getCameraPreviewView().getFrameDataCallback());
        }
        k("CameraOpenCost", Long.valueOf(Util.ticksToNow(currentTicks)));
        this.ipH.getCameraPreviewView().d(new e(this, bVar));
        AppMethodBeat.o(94241);
    }

    public static /* synthetic */ Point c(a aVar) {
        AppMethodBeat.i(94244);
        Point fi = aVar.fi(false);
        AppMethodBeat.o(94244);
        return fi;
    }

    public final Point fi(boolean z) {
        AppMethodBeat.i(94243);
        Point fa = this.hAt.fa(z);
        AppMethodBeat.o(94243);
        return fa;
    }

    public final void stopPreview() {
        AppMethodBeat.i(94245);
        if (this.currentState == 1) {
            AppMethodBeat.o(94245);
            return;
        }
        this.currentState = 1;
        Log.printInfoStack("MicroMsg.CameraPreviewContainer", "stopPreview", new Object[0]);
        try {
            this.hAt.release();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CameraPreviewContainer", e2, "camera relase error:" + e2.getMessage(), new Object[0]);
        }
        this.hAt.b(this.ipH.getCameraPreviewView().getFrameDataCallback());
        this.ipH.getCameraPreviewView().aEx();
        if (!this.ipD) {
            this.ipB.a(false, (com.tencent.mm.media.widget.a.b) null);
        }
        AppMethodBeat.o(94245);
    }

    public final void r(kotlin.g.a.b<? super Bitmap, x> bVar) {
        AppMethodBeat.i(94246);
        p.h(bVar, "callback");
        if (!this.hAt.aPc()) {
            Log.e("MicroMsg.CameraPreviewContainer", "camera.isCameraPreviewing : false");
            bVar.invoke(null);
            AppMethodBeat.o(94246);
        } else if (!com.tencent.mm.media.widget.d.b.a(this.ipH) || com.tencent.mm.media.widget.d.b.rH(this.ipH.getRecordScene())) {
            long currentTicks = Util.currentTicks();
            com.tencent.mm.media.j.a aVar = this.ihs;
            if (aVar != null) {
                aVar.m(new i(this, bVar, currentTicks));
                aVar.aML();
                AppMethodBeat.o(94246);
                return;
            }
            AppMethodBeat.o(94246);
        } else {
            this.hAt.n(new j(this, Util.currentTicks(), bVar));
            AppMethodBeat.o(94246);
        }
    }

    public final void B(String str, boolean z) {
        AppMethodBeat.i(94247);
        p.h(str, "tag");
        this.hAt.B(str, z);
        AppMethodBeat.o(94247);
    }

    public final void fj(boolean z) {
        AppMethodBeat.i(94248);
        this.hAt.fb(z);
        AppMethodBeat.o(94248);
    }

    private final void k(String str, Object obj) {
        AppMethodBeat.i(218875);
        this.ipG.h(str, obj);
        AppMethodBeat.o(218875);
    }

    public final void aQf() {
        AppMethodBeat.i(94226);
        try {
            Log.i("MicroMsg.CameraPreviewContainer", "cancelRecord");
            com.tencent.mm.media.widget.c.b bVar = this.ipr;
            if (bVar != null) {
                bVar.cancel();
            }
            com.tencent.mm.media.widget.c.b bVar2 = this.ipr;
            if (bVar2 != null) {
                bVar2.clear();
            }
            com.tencent.mm.media.widget.c.b bVar3 = this.ips;
            if (bVar3 != null) {
                bVar3.cancel();
            }
            com.tencent.mm.media.widget.c.b bVar4 = this.ips;
            if (bVar4 != null) {
                bVar4.clear();
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CameraPreviewContainer", e2, "cancel record error", new Object[0]);
        }
        if (this.hAt.aPc()) {
            aQi();
            if (this.hAt.aPr() != null) {
                aQj();
            }
        }
        AppMethodBeat.o(94226);
    }

    public final boolean p(kotlin.g.a.b<? super com.tencent.mm.media.widget.camerarecordview.b.b, x> bVar) {
        AppMethodBeat.i(94227);
        if (!this.ipv) {
            AppMethodBeat.o(94227);
            return true;
        }
        this.ipv = false;
        if (Util.ticksToNow(this.ipu) < this.ipA) {
            Log.printInfoStack("MicroMsg.CameraPreviewContainer", "stopRecord " + Util.ticksToNow(this.ipu), new Object[0]);
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aOc();
            aQf();
            AppMethodBeat.o(94227);
            return false;
        }
        Log.printInfoStack("MicroMsg.CameraPreviewContainer", "stopRecord start", new Object[0]);
        com.tencent.mm.media.k.a aVar = new com.tencent.mm.media.k.a(JsApiStopRecordVoice.NAME);
        z.d dVar = new z.d();
        dVar.SYE = 0;
        z.f fVar = new z.f();
        fVar.SYG = (T) new com.tencent.mm.media.widget.camerarecordview.b.b(null, null, false, null, null, null, null, null, null, 65535);
        z.f fVar2 = new z.f();
        fVar2.SYG = (T) new h(this, fVar, bVar);
        if (this.ipH.aQy()) {
            com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aOd();
        }
        z.f fVar3 = new z.f();
        fVar3.SYG = (T) this.ipr;
        com.tencent.mm.media.widget.c.b bVar2 = this.ipr;
        if (bVar2 != null) {
            bVar2.E(new f(this, fVar3, aVar, fVar, dVar, fVar2, bVar));
        }
        com.tencent.mm.media.widget.c.b bVar3 = this.ips;
        if (bVar3 != null) {
            bVar3.E(new g(this, aVar, fVar, dVar, fVar2, bVar));
        }
        AppMethodBeat.o(94227);
        return true;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/media/globject/GLTextureObject;", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<com.tencent.mm.media.g.d, x> {
        final /* synthetic */ a ipJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(1);
            this.ipJ = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.media.g.d dVar) {
            AppMethodBeat.i(94215);
            if (this.ipJ.ipw) {
                com.tencent.mm.media.widget.c.b bVar = this.ipJ.ipr;
                if (bVar != null) {
                    bVar.M(this.ipJ.ipx.first.intValue(), this.ipJ.ipx.second.intValue(), this.ipJ.ipx.SWY.intValue());
                }
                com.tencent.mm.media.widget.c.b bVar2 = this.ipJ.ips;
                if (bVar2 != null) {
                    bVar2.M(this.ipJ.ipx.first.intValue(), this.ipJ.ipx.second.intValue(), this.ipJ.ipx.SWY.intValue());
                }
                this.ipJ.ipw = false;
            }
            com.tencent.mm.media.widget.c.b bVar3 = this.ipJ.ipr;
            if (bVar3 != null) {
                bVar3.aQG();
            }
            com.tencent.mm.media.widget.c.b bVar4 = this.ipJ.ips;
            if (bVar4 != null) {
                bVar4.aQG();
            }
            kotlin.g.a.a<x> aVar = this.ipJ.ipE;
            if (aVar != null) {
                aVar.invoke();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(94215);
            return xVar;
        }
    }

    public static final /* synthetic */ void n(a aVar) {
        boolean z;
        AppMethodBeat.i(94251);
        long currentTicks = Util.currentTicks();
        aVar.k("PreviewSuccessTImeStamp", Long.valueOf(currentTicks));
        aVar.k("CameraFirstFrameCost", Long.valueOf(currentTicks - aVar.ipF));
        com.tencent.mm.media.widget.a.b aPr = aVar.hAt.aPr();
        Log.i("MicroMsg.CameraPreviewContainer", "afterStartPreview, cameraConfig:".concat(String.valueOf(aPr)));
        if (aPr != null) {
            aVar.ipH.getCameraPreviewView().a(aPr);
            aVar.aQi();
            aVar.aQj();
            if (!aVar.ipD) {
                com.tencent.mm.media.widget.camerarecordview.c.a aVar2 = aVar.ipB;
                if (aVar.ipt || !aVar.ipH.aQx()) {
                    z = false;
                } else {
                    z = true;
                }
                aVar2.a(z, aPr);
            }
        }
        AppMethodBeat.o(94251);
    }
}

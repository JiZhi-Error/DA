package com.tencent.mm.plugin.voip.video.render;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.voip.b.h;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.render.f;
import com.tencent.mm.plugin.voip.video.render.g;
import com.tencent.mm.plugin.voip.video.render.m;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tavkit.component.TAVExporter;
import java.nio.ByteBuffer;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¯\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0015\n\u0002\b\b*\u0001\b\u0018\u0000 \u00012\u00020\u0001:\u0004\u0001\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010S\u001a\u00020(2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u000bJ\u0016\u0010S\u001a\u00020(2\u0006\u0010T\u001a\u00020W2\u0006\u0010V\u001a\u00020\u000bJ\u0016\u0010X\u001a\u00020(2\u0006\u0010Y\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020\u000bJ\u001a\u0010[\u001a\u00020(2\u0006\u0010\\\u001a\u00020]2\b\b\u0002\u0010^\u001a\u00020\u0005H\u0002J\u001a\u0010_\u001a\u00020(2\u0006\u0010`\u001a\u00020a2\b\b\u0002\u0010b\u001a\u00020\u0005H\u0002J\b\u0010c\u001a\u00020dH\u0002J\u0006\u0010e\u001a\u00020(J\u0010\u0010f\u001a\u0004\u0018\u00010+2\u0006\u0010g\u001a\u00020\u000bJ\b\u0010h\u001a\u0004\u0018\u00010BJ\b\u0010i\u001a\u00020(H\u0002J\u0006\u0010j\u001a\u00020\u0005J\b\u0010k\u001a\u00020(H\u0002J\u000e\u0010l\u001a\u00020(2\u0006\u0010m\u001a\u00020\u0005J\u000e\u0010n\u001a\u00020(2\u0006\u0010o\u001a\u00020\u000bJ\u0006\u0010p\u001a\u00020(J\u0006\u0010q\u001a\u00020(J\u0006\u0010r\u001a\u00020(J\u0006\u0010s\u001a\u00020(J\u0006\u0010t\u001a\u00020(J\u0010\u0010u\u001a\u00020(2\b\u0010T\u001a\u0004\u0018\u00010UJ\u0010\u0010u\u001a\u00020(2\b\u0010T\u001a\u0004\u0018\u00010WJ\"\u0010v\u001a\u00020(2\b\u0010w\u001a\u0004\u0018\u00010#2\u0006\u0010Y\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020\u000bH\u0002J\u000e\u0010x\u001a\u00020(2\u0006\u0010b\u001a\u00020\u0005J\u0006\u0010y\u001a\u00020(J \u0010z\u001a\u00020(2\u0006\u0010{\u001a\u00020d2\u0006\u0010|\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u0005H\u0002J\u000e\u0010~\u001a\u00020(2\u0006\u0010\u001a\u00020\u000bJ\u0010\u0010\u0001\u001a\u00020(2\u0007\u0010\u0001\u001a\u00020\u000bJ\u000f\u0010\u0001\u001a\u00020(2\u0006\u0010|\u001a\u00020\u000bJ\u001b\u0010\u0001\u001a\u00020(2\u0007\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u0005H\u0002J \u0010\u0001\u001a\u00020(2\u0006\u0010Y\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020#J!\u0010\u0001\u001a\u00020(2\u0006\u0010Y\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020\u000b2\b\u0010\u0001\u001a\u00030\u0001J\u000f\u0010\u0001\u001a\u00020(2\u0006\u0010o\u001a\u00020\u000bJ\u0010\u0010\u0001\u001a\u00020(2\u0007\u0010\u0001\u001a\u00020\u000bJ\u0010\u0010\u0001\u001a\u00020(2\u0007\u0010\u0001\u001a\u00020\u000bJ\t\u0010\u0001\u001a\u00020(H\u0002R\u0010\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R4\u0010&\u001a(\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020(\u0018\u00010'j\u0004\u0018\u0001`)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010,\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010:\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010;\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010<\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R4\u0010?\u001a(\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020(\u0018\u00010'j\u0004\u0018\u0001`@X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u000e\u0010K\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010L\u001a\u00020MX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u000e\u0010R\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr;", "", "renderEventListener", "Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "mIsOutCall", "", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;Z)V", "captureDataCallback", "com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1;", "captureFrameCount", "", "captureRenderer", "Lcom/tencent/mm/plugin/voip/video/camera/common/BaseCaptureRenderer;", "decMode", "deviceOrientation", "drawHeight", "drawWidth", "encodePixelFormat", "encodeVoipHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getEncodeVoipHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setEncodeVoipHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "faceBeautyDataType", "faceBeautyH", "faceBeautyW", "isAddViewStart", "isCameraStausChange", "isHasBeenReported", "isRemoteSizeInit", "lastSendFilterBuffer", "Ljava/nio/ByteBuffer;", "lastSendFilterData", "", "mBatteryUtils", "Lcom/tencent/mm/plugin/voip/util/BatteryUtils;", "mFaceBeautyDataCallback", "Lkotlin/Function4;", "", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "mFaceBeautyDataTemp", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData;", "mFlag", "mIsCameraAttach", "getMIsOutCall", "()Z", "setMIsOutCall", "(Z)V", "mIsSmallViewShowSelf", "mIsStarted", "mLastBeautyCmd", "mLastEncHeight", "mLastEncWidth", "mLastHWDecH", "mLastHWDecW", "mLastSTFilterCmd", "mLocalIsMirror", "mLocalRotateAngle", "mPauseTransVideo", "mSTDenosingPreProcess", "Lcom/tencent/mm/video/videoprocessing/SpatiotemproalDenosingPreProcess;", "mSTFilterDataCallback", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/STFilterDataCallback;", "mSTFilterDataTemp", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/SpatioTemporalFilterData;", "mUpdateTimes", "mUseLastBeautyCnt", "mVoipWindowsSurfaceRenderer", "Lcom/tencent/mm/plugin/voip/video/render/VoipWindowsSurfaceRenderer;", "getRenderEventListener", "()Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "setRenderEventListener", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;)V", "screenRotation", "tick", "", "getTick", "()J", "setTick", "(J)V", "use720pCapture", "addRenderView", "view", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView;", "remoteMode", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "adjustHWViewAspectRatio", "w", "h", "bindCameraCallback", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "bFaceFirst", "bindCameraRenderer", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "isFace", "choiceCameraPboViewSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "focusOnFace", "getFaceBeautyData", "fbType", "getSpatioTemporalFilterData", "initRendererEnvironment", "isLocalUseFaceBeauty", "onFrameDataReady", "onHWDecModeSet", "isSmallViewShowSelf", "onOrientationChange", "rotation", "onRenderModeChanged", "onSwitchCamera", "reattachCameraCauseAutoFloatCamera", "reattachCameraCauseResume", "release", "removeRenderView", "sampleCheckSendData", "sendData", "setCameraCaptureBind", "setCameraPermissionFailed", "setCameraPreviewSize", "size", "rotateDegree", "mirror", com.tencent.luggage.game.d.c.NAME, "degree", "setHWDecMode", "mode", "setLocalRenderOrientation", "setLocalVideoSize", "isVoipBeautySupported", "isSTFilterSupport", "setRemoteVideoData", "outData", "", "setScreenRotation", "setSpatiotemporalDenosing", "cmd", "setVoipBeauty", "unInitCaptureRender", "Companion", "RendererViewEvent", "plugin-voip_release"})
public final class j {
    public static final a Hop = new a((byte) 0);
    public int GUC;
    public int GUD;
    private int GUK;
    private int GUL;
    boolean GUf;
    public boolean GUq;
    public int GUr;
    public boolean GYb;
    private byte[] GYd;
    private ByteBuffer GYe;
    private int GYf;
    public boolean GYg = true;
    private int GYi;
    private com.tencent.mm.plugin.voip.b.a GYl;
    MMHandler GYm;
    public boolean HdG;
    public int HdK;
    public int Hir;
    private com.tencent.mm.cm.a.k HkU;
    public com.tencent.mm.plugin.voip.video.camera.a.a HnU;
    private boolean HnV;
    public boolean HnW;
    public m HnX;
    private com.tencent.mm.plugin.voip.video.b.a HnY = new com.tencent.mm.plugin.voip.video.b.a();
    private com.tencent.mm.plugin.voip.video.d.b HnZ = new com.tencent.mm.plugin.voip.video.d.b();
    private boolean Hoa;
    private int Hob = -1;
    private int Hoc = -1;
    public boolean Hod;
    private int Hoe = 3;
    private boolean Hof;
    private final int Hog;
    public boolean Hoh;
    private g Hoi;
    private int Hoj;
    private int Hok;
    private int Hol;
    private r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> Hom;
    private r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> Hon;
    c Hoo;
    private int hEp;
    private int hEq;
    public int kyf;
    public boolean mIsStarted = true;
    long tick;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0003H&J \u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "", "onViewCreated", "", "remoteMode", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onViewDestroy", "onViewRenderReset", "onViewSizeChanged", "w", "h", "plugin-voip_release"})
    public interface b {
        void a(int i2, Surface surface, SurfaceTexture surfaceTexture);

        void aG(int i2, int i3, int i4);

        void aed(int i2);

        void fLY();
    }

    static {
        AppMethodBeat.i(236291);
        AppMethodBeat.o(236291);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
    public static final class h extends q implements r<ByteBuffer, Integer, Integer, Integer, x> {
        final /* synthetic */ int HoD;
        final /* synthetic */ j Hoq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(j jVar, int i2) {
            super(4);
            this.Hoq = jVar;
            this.HoD = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(ByteBuffer byteBuffer, Integer num, Integer num2, Integer num3) {
            int i2 = 0;
            AppMethodBeat.i(236270);
            ByteBuffer byteBuffer2 = byteBuffer;
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            int intValue3 = num3.intValue();
            p.h(byteBuffer2, "buffer");
            byteBuffer2.position(0);
            com.tencent.mm.plugin.voip.video.b.a aVar = this.Hoq.HnY;
            m mVar = this.Hoq.HnX;
            if (mVar != null) {
                i2 = mVar.fMd();
            }
            aVar.Hlc = i2;
            this.Hoq.HnY.width = intValue;
            this.Hoq.HnY.height = intValue2;
            this.Hoq.HnY.a(intValue, intValue2, this.HoD, byteBuffer2, intValue3);
            x xVar = x.SXb;
            AppMethodBeat.o(236270);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
    public static final class i extends q implements r<ByteBuffer, Integer, Integer, Integer, x> {
        final /* synthetic */ j Hoq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(j jVar) {
            super(4);
            this.Hoq = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(ByteBuffer byteBuffer, Integer num, Integer num2, Integer num3) {
            AppMethodBeat.i(236271);
            ByteBuffer byteBuffer2 = byteBuffer;
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            int intValue3 = num3.intValue();
            p.h(byteBuffer2, "buffer");
            byteBuffer2.position(0);
            this.Hoq.HnZ.width = intValue;
            this.Hoq.HnZ.height = intValue2;
            com.tencent.mm.plugin.voip.video.d.b bVar = this.Hoq.HnZ;
            bVar.width = intValue;
            bVar.height = intValue2;
            bVar.HpD = byteBuffer2;
            bVar.dataType = intValue3;
            x xVar = x.SXb;
            AppMethodBeat.o(236271);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.voip.video.render.j$j  reason: collision with other inner class name */
    static final class C1898j extends q implements kotlin.g.a.b<g, x> {
        final /* synthetic */ j Hoq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1898j(j jVar) {
            super(1);
            this.Hoq = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(g gVar) {
            boolean z = true;
            AppMethodBeat.i(236272);
            g gVar2 = gVar;
            p.h(gVar2, LocaleUtil.ITALIAN);
            if (ae.gKt.gFB == 0 || this.Hoq.GUf) {
                if (this.Hoq.HnU != null) {
                    com.tencent.mm.plugin.voip.video.camera.a.a aVar = this.Hoq.HnU;
                    if (!(aVar != null ? aVar.fKY() : true)) {
                        z = false;
                    }
                }
                j.a(this.Hoq, gVar2, z);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236272);
            return xVar;
        }
    }

    public j(c cVar, boolean z) {
        int i2;
        m mVar;
        p.h(cVar, "renderEventListener");
        AppMethodBeat.i(236290);
        this.Hoo = cVar;
        this.GUf = z;
        com.tencent.mm.plugin.voip.b.g gVar = com.tencent.mm.plugin.voip.b.g.HgZ;
        if (com.tencent.mm.plugin.voip.b.g.fKi()) {
            com.tencent.mm.plugin.voip.b.g gVar2 = com.tencent.mm.plugin.voip.b.g.HgZ;
            if (com.tencent.mm.plugin.voip.b.g.fKj()) {
                i2 = 33;
            } else {
                i2 = 39;
            }
        } else {
            i2 = 4;
        }
        this.Hog = i2;
        this.GYm = new MMHandler("encodeVoipHandler");
        this.GYl = new com.tencent.mm.plugin.voip.b.a();
        this.GYl.Z(true, (this.HdK & 1) != 0 ? 1 : 0);
        this.GYl.fJK();
        ac fLX = fLX();
        this.HnX = new m();
        m mVar2 = this.HnX;
        if (mVar2 != null) {
            mVar2.Hpj = new g(fLX.width, fLX.height);
            mVar2.Hpk = new n(true);
            mVar2.Hpl = new n(false);
        }
        m mVar3 = this.HnX;
        if (mVar3 != null) {
            mVar3.aF(com.tencent.mm.plugin.voip.b.c.HgN, com.tencent.mm.plugin.voip.b.c.HgO, com.tencent.mm.plugin.voip.b.c.HgP);
        }
        m mVar4 = this.HnX;
        if (mVar4 != null) {
            C1898j jVar = new C1898j(this);
            z.e eVar = new z.e();
            eVar.SYF = -1;
            g gVar3 = mVar4.Hpj;
            if (gVar3 != null) {
                m.b bVar = new m.b(mVar4, jVar);
                if (gVar3.ilw != null || gVar3.Hny) {
                    bVar.invoke(gVar3);
                }
                gVar3.k(new g.b(gVar3, bVar));
            }
            g gVar4 = mVar4.Hpj;
            if (gVar4 != null) {
                gVar4.Hnd = new m.c(mVar4, eVar);
            }
            n nVar = mVar4.Hpk;
            if (nVar != null) {
                nVar.Hnd = new m.d(mVar4, eVar);
            }
            g gVar5 = mVar4.Hpj;
            if (gVar5 != null) {
                Log.i("MicroMsg.PboSurfaceRender", "start");
                gVar5.k(new g.n(gVar5));
            }
        }
        if (com.tencent.mm.plugin.voip.b.g.fKg() && (mVar = this.HnX) != null) {
            k kVar = new k(this);
            g gVar6 = mVar.Hpj;
            if (gVar6 != null) {
                gVar6.HnE = kVar;
            }
        }
        m mVar5 = this.HnX;
        if (mVar5 != null) {
            mVar5.Hpm = this.Hoo;
        }
        i iVar = i.HnR;
        i.reset();
        com.tencent.mm.plugin.voip.b.c cVar2 = com.tencent.mm.plugin.voip.b.c.HgQ;
        com.tencent.mm.plugin.voip.b.c.clear();
        this.Hoi = new g(this);
        AppMethodBeat.o(236290);
    }

    public static final /* synthetic */ void a(j jVar, g gVar, boolean z) {
        AppMethodBeat.i(236292);
        jVar.d(gVar, z);
        AppMethodBeat.o(236292);
    }

    public static final /* synthetic */ void a(j jVar, boolean z, boolean z2) {
        AppMethodBeat.i(236294);
        jVar.aR(z, z2);
        AppMethodBeat.o(236294);
    }

    public final void d(g gVar, boolean z) {
        AppMethodBeat.i(236276);
        xc(z);
        SurfaceTexture surfaceTexture = gVar.surfaceTexture;
        if (surfaceTexture == null) {
            p.hyc();
        }
        b(surfaceTexture, z);
        AppMethodBeat.o(236276);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void aR(boolean r13, boolean r14) {
        /*
        // Method dump skipped, instructions count: 449
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.video.render.j.aR(boolean, boolean):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016JB\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, hxF = {"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$captureDataCallback$1", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "onCameraError", "", "onCameraPreviewApply", "width", "", "height", "onFrameDataReady", "pBuffer", "", "lBufferSize", "", "w", "h", "cameraFrameFormat", FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "dblSampleTime", "", "plugin-voip_release"})
    public static final class g implements com.tencent.mm.plugin.voip.video.camera.a.b {
        final /* synthetic */ j Hoq;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(j jVar) {
            this.Hoq = jVar;
        }

        @Override // com.tencent.mm.plugin.voip.video.camera.a.b
        public final void a(byte[] bArr, long j2, int i2, int i3, int i4, int i5) {
            boolean z;
            int i6;
            boolean z2;
            int i7;
            int i8;
            ByteBuffer byteBuffer;
            int i9;
            int i10;
            int i11;
            com.tencent.mm.plugin.voip.video.camera.a.a aVar;
            AppMethodBeat.i(236267);
            if (this.Hoq.GYb) {
                AppMethodBeat.o(236267);
            } else if (this.Hoq.HnU == null) {
                Log.e("MicroMsg.VoIPRenderMgr", "onFrameDataReady on previewCallback, captureRender is null!");
                AppMethodBeat.o(236267);
            } else {
                com.tencent.mm.plugin.voip.video.camera.a.a aVar2 = this.Hoq.HnU;
                int i12 = (aVar2 == null || !aVar2.fKY()) ? 0 : OpenGlRender.FLAG_Mirror;
                com.tencent.mm.plugin.voip.video.camera.a.a aVar3 = this.Hoq.HnU;
                int i13 = (aVar3 == null || !aVar3.fKZ()) ? OpenGlRender.FLAG_Angle90 : OpenGlRender.FLAG_Angle270;
                int i14 = i4 + i5;
                byte[] bArr2 = null;
                ByteBuffer byteBuffer2 = null;
                boolean z3 = OpenGlRender.getGLVersion() == 2 && this.Hoq.GUC != 0;
                boolean z4 = (this.Hoq.GUC & 8) != 0;
                boolean z5 = OpenGlRender.getGLVersion() == 2 && this.Hoq.GUD != 0;
                z.d dVar = new z.d();
                dVar.SYE = 0;
                if (!z3) {
                    z = z3;
                    i6 = 0;
                } else if (!z4 && this.Hoq.aec(2) != null) {
                    this.Hoq.GYf = 0;
                    z = z3;
                    i6 = 1;
                } else if (z4 && this.Hoq.aec(1) != null) {
                    this.Hoq.GYf = 0;
                    z = z3;
                    i6 = 2;
                } else if (this.Hoq.GYd == null || this.Hoq.GYf > 10) {
                    z = false;
                    i6 = 0;
                } else {
                    this.Hoq.GYf++;
                    z = z3;
                    i6 = 3;
                }
                if (!z5 || this.Hoq.fJk() != null) {
                    z2 = z5;
                } else {
                    z2 = false;
                }
                if (z2 && this.Hoq.HkU == null) {
                    this.Hoq.HkU = new com.tencent.mm.cm.a.k();
                }
                if (z2) {
                    com.tencent.mm.cm.a.k kVar = this.Hoq.HkU;
                    if (kVar == null) {
                        p.hyc();
                    }
                    int R = kVar.R(bArr, i2, i3);
                    com.tencent.mm.cm.a.k kVar2 = this.Hoq.HkU;
                    if (kVar2 == null) {
                        p.hyc();
                    }
                    float hff = kVar2.hff();
                    m mVar = this.Hoq.HnX;
                    if (mVar != null) {
                        mVar.x(R, hff);
                    }
                }
                com.tencent.mm.plugin.voip.video.camera.a.a aVar4 = this.Hoq.HnU;
                if (((aVar4 == null || !aVar4.fKY()) && ((aVar = this.Hoq.HnU) == null || aVar.fKY() || !this.Hoq.Hof)) || ((!z || i6 == 0) && (!z2 || i6 != 0))) {
                    i14 = i4 + i5;
                    i7 = i3;
                    i8 = i2;
                    byteBuffer = null;
                    bArr2 = bArr;
                } else {
                    if (i6 == 0 && z2) {
                        com.tencent.mm.plugin.voip.video.d.b fJk = this.Hoq.fJk();
                        if ((fJk != null ? fJk.HpD : null) != null) {
                            byteBuffer2 = fJk.HpD;
                            dVar.SYE = fJk.dataType;
                            switch (dVar.SYE) {
                                case 1:
                                    i14 = 10;
                                    break;
                                case 2:
                                    i14 = 1;
                                    break;
                                default:
                                    i14 = this.Hoq.Hog;
                                    break;
                            }
                            if (byteBuffer2 == null) {
                                p.hyc();
                            }
                            j2 = (long) byteBuffer2.capacity();
                            int i15 = fJk.width;
                            int i16 = fJk.height;
                            this.Hoq.GYe = byteBuffer2;
                            i9 = i16;
                            i10 = i15;
                        }
                        i9 = i3;
                        i10 = i2;
                    } else if (i6 == 1) {
                        com.tencent.mm.plugin.voip.video.b.a aec = this.Hoq.aec(2);
                        if ((aec != null ? aec.iEK : null) != null) {
                            byteBuffer2 = aec.iEK;
                            dVar.SYE = aec.dataType;
                            switch (dVar.SYE) {
                                case 1:
                                    i14 = 10;
                                    break;
                                case 2:
                                    i14 = 1;
                                    break;
                                default:
                                    i14 = this.Hoq.Hog;
                                    break;
                            }
                            if (byteBuffer2 == null) {
                                p.hyc();
                            }
                            j2 = (long) byteBuffer2.capacity();
                            int i17 = aec.width;
                            int i18 = aec.height;
                            this.Hoq.GYe = byteBuffer2;
                            i9 = i18;
                            i10 = i17;
                        }
                        i9 = i3;
                        i10 = i2;
                    } else if (i6 == 2) {
                        com.tencent.mm.plugin.voip.video.b.a aec2 = this.Hoq.aec(1);
                        if ((aec2 != null ? aec2.iEK : null) != null) {
                            byteBuffer2 = aec2.iEK;
                            dVar.SYE = aec2.dataType;
                            switch (dVar.SYE) {
                                case 1:
                                    i14 = 10;
                                    break;
                                case 2:
                                    i14 = 1;
                                    break;
                                default:
                                    i14 = this.Hoq.Hog;
                                    break;
                            }
                            if (byteBuffer2 == null) {
                                p.hyc();
                            }
                            j2 = (long) byteBuffer2.capacity();
                            int i19 = aec2.width;
                            int i20 = aec2.height;
                            this.Hoq.GYe = byteBuffer2;
                            i9 = i20;
                            i10 = i19;
                        }
                        i9 = i3;
                        i10 = i2;
                    } else {
                        if (i6 == 3 && this.Hoq.GYd != null) {
                            byteBuffer2 = this.Hoq.GYe;
                            switch (this.Hoq.Hol) {
                                case 1:
                                    i11 = 10;
                                    break;
                                case 2:
                                    i11 = 1;
                                    break;
                                default:
                                    i11 = this.Hoq.Hog;
                                    break;
                            }
                            Object[] objArr = null;
                            p.hyc();
                            j2 = (long) objArr.length;
                            int i21 = this.Hoq.Hoj;
                            i9 = this.Hoq.Hok;
                            dVar.SYE = this.Hoq.Hol;
                            this.Hoq.GYe = byteBuffer2;
                            i10 = i21;
                            i14 = i11;
                        }
                        i9 = i3;
                        i10 = i2;
                    }
                    this.Hoq.Hok = i9;
                    this.Hoq.Hoj = i10;
                    this.Hoq.Hol = dVar.SYE;
                    i7 = i9;
                    i8 = i10;
                    byteBuffer = byteBuffer2;
                }
                if (bArr2 == null && byteBuffer == null) {
                    Log.e("MicroMsg.VoIPRenderMgr", "send data is null and should not allowed to send");
                    h.a aVar5 = com.tencent.mm.plugin.voip.b.h.Hhl;
                    h.a.adL(0);
                    AppMethodBeat.o(236267);
                    return;
                }
                Log.d("MicroMsg.VoIPRenderMgr", "jcchen capture data: w=" + i2 + "h=" + i3 + ", vw=" + i8 + "vh=" + i7 + ", bm=" + i6 + "format is " + i14 + "rotate is " + i5);
                z.d dVar2 = new z.d();
                dVar2.SYE = 0;
                j.a(this.Hoq, z, z2);
                int i22 = (int) j2;
                MMHandler mMHandler = this.Hoq.GYm;
                if (mMHandler != null) {
                    mMHandler.post(new a(this, byteBuffer, dVar2, i22, i14, i8, i7, dVar, bArr2));
                }
                this.Hoq.Hoo.aB(dVar2.SYE, i2, i3);
                j.a(this.Hoq, bArr2, i2, i3);
                this.Hoq.GYi++;
                this.Hoq.GUq = i12 == OpenGlRender.FLAG_Mirror;
                this.Hoq.GUr = i13 == OpenGlRender.FLAG_Angle270 ? 270 : 90;
                AppMethodBeat.o(236267);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ int HoA;
            final /* synthetic */ z.d HoB;
            final /* synthetic */ byte[] HoC;
            final /* synthetic */ g Hov;
            final /* synthetic */ ByteBuffer How;
            final /* synthetic */ int Hox;
            final /* synthetic */ int Hoy;
            final /* synthetic */ int Hoz;
            final /* synthetic */ z.d vRW;

            a(g gVar, ByteBuffer byteBuffer, z.d dVar, int i2, int i3, int i4, int i5, z.d dVar2, byte[] bArr) {
                this.Hov = gVar;
                this.How = byteBuffer;
                this.vRW = dVar;
                this.Hox = i2;
                this.Hoy = i3;
                this.Hoz = i4;
                this.HoA = i5;
                this.HoB = dVar2;
                this.HoC = bArr;
            }

            public final void run() {
                AppMethodBeat.i(236266);
                if (this.How != null) {
                    Log.i("MicroMsg.VoIPRenderMgr", "encode tick " + Util.ticksToNow(this.Hov.Hoq.tick));
                    this.Hov.Hoq.tick = Util.currentTicks();
                    this.vRW.SYE = com.tencent.mm.plugin.voip.c.fFg().c(this.How, this.Hox, this.Hoy, this.Hoz, this.HoA, this.HoB.SYE);
                    AppMethodBeat.o(236266);
                    return;
                }
                if (this.HoC != null) {
                    z.d dVar = this.vRW;
                    u fFg = com.tencent.mm.plugin.voip.c.fFg();
                    byte[] bArr = this.HoC;
                    int i2 = this.Hox;
                    int i3 = this.Hoy;
                    int i4 = this.Hoz;
                    int i5 = this.HoA;
                    new Point(0, 0);
                    dVar.SYE = fFg.c(bArr, i2, i3, i4, i5);
                }
                AppMethodBeat.o(236266);
            }
        }

        @Override // com.tencent.mm.plugin.voip.video.camera.a.b
        public final void cza() {
            AppMethodBeat.i(236268);
            this.Hoq.Hoo.fFE();
            AppMethodBeat.o(236268);
        }

        @Override // com.tencent.mm.plugin.voip.video.camera.a.b
        public final void fs(int i2, int i3) {
            AppMethodBeat.i(236269);
            Log.i("MicroMsg.VoIPRenderMgr", "camera preview size applye is " + i2 + " and " + i3);
            com.tencent.mm.plugin.voip.b.j jVar = com.tencent.mm.plugin.voip.b.j.Hhp;
            com.tencent.mm.plugin.voip.b.j.LE((long) i2);
            com.tencent.mm.plugin.voip.b.j jVar2 = com.tencent.mm.plugin.voip.b.j.Hhp;
            com.tencent.mm.plugin.voip.b.j.LF((long) i3);
            m mVar = this.Hoq.HnX;
            if (mVar != null) {
                if (mVar.fMe() || com.tencent.mm.plugin.voip.b.g.fKg()) {
                    g gVar = mVar.Hpj;
                    if (gVar != null) {
                        gVar.width = i2;
                    }
                    g gVar2 = mVar.Hpj;
                    if (gVar2 != null) {
                        gVar2.height = i3;
                        AppMethodBeat.o(236269);
                        return;
                    }
                }
                AppMethodBeat.o(236269);
                return;
            }
            AppMethodBeat.o(236269);
        }
    }

    private final void fLV() {
        AppMethodBeat.i(236278);
        Log.printDebugStack("MicroMsg.VoIPRenderMgr", "uninitCaptureRender", new Object[0]);
        if (this.HnU != null) {
            try {
                com.tencent.mm.plugin.voip.video.camera.a.a aVar = this.HnU;
                if (aVar != null) {
                    aVar.eoc();
                }
            } catch (Exception e2) {
                Log.d("MicroMsg.VoIPRenderMgr", "stop capture error:".concat(String.valueOf(e2)));
            }
            this.HnU = null;
        }
        AppMethodBeat.o(236278);
    }

    private final void b(SurfaceTexture surfaceTexture, boolean z) {
        int i2;
        boolean z2 = true;
        AppMethodBeat.i(236279);
        if (this.HnU != null) {
            com.tencent.mm.plugin.voip.video.camera.a.a aVar = this.HnU;
            this.GYg = aVar != null && aVar.a(this.Hoi, z) == 1;
            if (this.GYg) {
                com.tencent.mm.plugin.voip.video.camera.a.a aVar2 = this.HnU;
                if (aVar2 != null) {
                    aVar2.q(surfaceTexture);
                }
                u fFg = com.tencent.mm.plugin.voip.c.fFg();
                com.tencent.mm.plugin.voip.video.camera.a.a aVar3 = this.HnU;
                if (aVar3 != null) {
                    i2 = aVar3.fLa();
                } else {
                    i2 = 0;
                }
                fFg.adn(i2);
                Log.d("MicroMsg.VoIPRenderMgr", "mCaptureRender == " + this.HnU);
                if (this.HnU != null) {
                    com.tencent.mm.plugin.voip.video.camera.a.a aVar4 = this.HnU;
                    if (aVar4 == null) {
                        p.hyc();
                    }
                    if (aVar4.fLc() != null) {
                        com.tencent.mm.plugin.voip.video.camera.a.a aVar5 = this.HnU;
                        if (aVar5 != null) {
                            aVar5.onOrientationChange(this.kyf);
                        }
                        com.tencent.mm.plugin.voip.video.camera.a.a aVar6 = this.HnU;
                        if (aVar6 != null) {
                            aVar6.fLb();
                        }
                        this.GYi = 0;
                        this.HnV = true;
                        com.tencent.mm.plugin.voip.video.camera.a.a aVar7 = this.HnU;
                        if (aVar7 == null) {
                            p.hyc();
                        }
                        ac fLc = aVar7.fLc();
                        if (fLc == null) {
                            p.hyc();
                        }
                        com.tencent.mm.plugin.voip.video.camera.a.a aVar8 = this.HnU;
                        if (aVar8 == null) {
                            p.hyc();
                        }
                        int fLe = aVar8.fLe();
                        com.tencent.mm.plugin.voip.video.camera.a.a aVar9 = this.HnU;
                        if (aVar9 == null) {
                            p.hyc();
                        }
                        if (aVar9.fLf()) {
                            z2 = false;
                        }
                        a(fLc, fLe, z2);
                        aeb(this.Hir);
                    }
                }
            }
        }
        AppMethodBeat.o(236279);
    }

    private void xc(boolean z) {
        int i2;
        AppMethodBeat.i(236280);
        if (!this.HnV) {
            Log.i("MicroMsg.VoIPRenderMgr", "setCameraCaptureBind,  isFace: %s", Boolean.valueOf(z));
            int i3 = 640;
            if (v2protocal.Har) {
                Log.i("MicroMsg.VoIPRenderMgr", "jcchen: 1280 capture!");
                i3 = TAVExporter.VIDEO_EXPORT_HEIGHT;
                i2 = 720;
            } else {
                i2 = 480;
            }
            if (this.HnU == null) {
                if (com.tencent.mm.plugin.voip.b.g.fKh()) {
                    this.HnU = new com.tencent.mm.plugin.voip.video.camera.b.a(this.Hoo.getContext(), i3, i2);
                    AppMethodBeat.o(236280);
                    return;
                }
                this.HnU = new com.tencent.mm.plugin.voip.video.camera.prev.c(i3, i2);
            }
        }
        AppMethodBeat.o(236280);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void fLW() {
        /*
        // Method dump skipped, instructions count: 118
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.video.render.j.fLW():void");
    }

    public final void a(ac acVar, int i2, boolean z) {
        AppMethodBeat.i(236282);
        m mVar = this.HnX;
        if (mVar != null) {
            mVar.a(acVar, i2, z);
            AppMethodBeat.o(236282);
            return;
        }
        AppMethodBeat.o(236282);
    }

    public final void aeb(int i2) {
        Integer num;
        int i3;
        Integer num2 = null;
        boolean z = false;
        AppMethodBeat.i(236283);
        com.tencent.mm.plugin.voip.video.camera.a.a aVar = this.HnU;
        if (aVar != null) {
            aVar.fLg();
        }
        this.Hir = i2;
        StringBuilder append = new StringBuilder("set rotate degress ").append(i2).append(" and capture render is ");
        com.tencent.mm.plugin.voip.video.camera.a.a aVar2 = this.HnU;
        if (aVar2 != null) {
            num = Integer.valueOf(aVar2.fLe());
        } else {
            num = null;
        }
        StringBuilder append2 = append.append(num).append("  and camera is ");
        com.tencent.mm.plugin.voip.video.camera.a.a aVar3 = this.HnU;
        if (aVar3 != null) {
            num2 = Integer.valueOf(aVar3.fLh());
        }
        StringBuilder append3 = append2.append(num2).append(",and ");
        com.tencent.mm.plugin.voip.video.camera.a.a aVar4 = this.HnU;
        Log.printInfoStack("MicroMsg.VoIPRenderMgr", append3.append(aVar4 != null ? aVar4.fLf() : false).toString(), new Object[0]);
        m mVar = this.HnX;
        if (mVar != null) {
            com.tencent.mm.plugin.voip.video.camera.a.a aVar5 = this.HnU;
            if (aVar5 != null) {
                i3 = aVar5.fLh();
            } else {
                i3 = 0;
            }
            mVar.aee(i3);
        }
        m mVar2 = this.HnX;
        if (mVar2 != null) {
            com.tencent.mm.plugin.voip.video.camera.a.a aVar6 = this.HnU;
            if (aVar6 != null) {
                z = aVar6.fLf();
            }
            mVar2.HhF = z;
        }
        m mVar3 = this.HnX;
        if (mVar3 != null) {
            mVar3.aeb(i2);
            AppMethodBeat.o(236283);
            return;
        }
        AppMethodBeat.o(236283);
    }

    private static ac fLX() {
        AppMethodBeat.i(236284);
        int i2 = 640;
        int i3 = 480;
        if (v2protocal.Har) {
            Log.i("MicroMsg.VoIPRenderMgr", "hseasun: 1280 capture!");
            i2 = TAVExporter.VIDEO_EXPORT_HEIGHT;
            i3 = TAVExporter.VIDEO_EXPORT_WIDTH;
        }
        h.a aVar = com.tencent.mm.plugin.voip.b.h.Hhl;
        h.a.aA((long) i2, (long) i3);
        ac acVar = new ac(i3, i2);
        AppMethodBeat.o(236284);
        return acVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J \u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, hxF = {"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$addRenderView$2", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "renderGLSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "getRenderGLSurface", "()Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "setRenderGLSurface", "(Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;)V", "onViewCreated", "", "remoteMode", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onViewDestroy", "onViewRenderReset", "onViewSizeChanged", "w", "h", "plugin-voip_release"})
    public static final class d implements b {
        final /* synthetic */ j Hoq;
        private f Hor;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "invoke"})
        static final class a extends q implements kotlin.g.a.b<f, x> {
            final /* synthetic */ d Hos;
            final /* synthetic */ int Hot;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, int i2) {
                super(1);
                this.Hos = dVar;
                this.Hot = i2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(f fVar) {
                AppMethodBeat.i(236255);
                f fVar2 = fVar;
                m mVar = this.Hos.Hoq.HnX;
                if (mVar != null) {
                    mVar.b(fVar2, this.Hot);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(236255);
                return xVar;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d(j jVar) {
            this.Hoq = jVar;
        }

        @Override // com.tencent.mm.plugin.voip.video.render.j.b
        public final void fLY() {
            AppMethodBeat.i(236256);
            m mVar = this.Hoq.HnX;
            if (mVar != null) {
                mVar.fLT();
                AppMethodBeat.o(236256);
                return;
            }
            AppMethodBeat.o(236256);
        }

        @Override // com.tencent.mm.plugin.voip.video.render.j.b
        public final void a(int i2, Surface surface, SurfaceTexture surfaceTexture) {
            f fVar;
            AppMethodBeat.i(236257);
            if (!(surface == null && surfaceTexture == null)) {
                if (surface != null) {
                    fVar = new f(surface, (byte) 0);
                } else {
                    if (surfaceTexture == null) {
                        p.hyc();
                    }
                    fVar = new f(surfaceTexture, (byte) 0);
                }
                this.Hor = fVar;
                m mVar = this.Hoq.HnX;
                if (mVar != null) {
                    f fVar2 = this.Hor;
                    if (fVar2 == null) {
                        p.hyc();
                    }
                    mVar.a(fVar2, new a(this, i2));
                    AppMethodBeat.o(236257);
                    return;
                }
            }
            AppMethodBeat.o(236257);
        }

        @Override // com.tencent.mm.plugin.voip.video.render.j.b
        public final void aed(int i2) {
            AppMethodBeat.i(236258);
            m mVar = this.Hoq.HnX;
            if (mVar != null) {
                mVar.c(this.Hor, i2);
            }
            m mVar2 = this.Hoq.HnX;
            if (mVar2 != null) {
                mVar2.a(this.Hor);
            }
            this.Hor = null;
            AppMethodBeat.o(236258);
        }

        @Override // com.tencent.mm.plugin.voip.video.render.j.b
        public final void aG(int i2, int i3, int i4) {
            f.b bVar;
            f.b bVar2;
            f.b bVar3;
            f.b bVar4;
            AppMethodBeat.i(236259);
            f fVar = this.Hor;
            if (!(fVar == null || (bVar4 = fVar.Hnv) == null)) {
                bVar4.x = 0;
            }
            f fVar2 = this.Hor;
            if (!(fVar2 == null || (bVar3 = fVar2.Hnv) == null)) {
                bVar3.y = 0;
            }
            f fVar3 = this.Hor;
            if (!(fVar3 == null || (bVar2 = fVar3.Hnv) == null)) {
                bVar2.width = i2;
            }
            f fVar4 = this.Hor;
            if (!(fVar4 == null || (bVar = fVar4.Hnv) == null)) {
                bVar.height = i3;
            }
            m mVar = this.Hoq.HnX;
            if (mVar != null) {
                mVar.a(this.Hor, i4);
            }
            m mVar2 = this.Hoq.HnX;
            if (mVar2 != null) {
                mVar2.fLR();
                AppMethodBeat.o(236259);
                return;
            }
            AppMethodBeat.o(236259);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J \u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, hxF = {"com/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$addRenderView$4", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "renderGLSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "getRenderGLSurface", "()Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "setRenderGLSurface", "(Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;)V", "onViewCreated", "", "remoteMode", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onViewDestroy", "onViewRenderReset", "onViewSizeChanged", "w", "h", "plugin-voip_release"})
    public static final class f implements b {
        final /* synthetic */ j Hoq;
        private f Hor;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "invoke"})
        static final class a extends q implements kotlin.g.a.b<f, x> {
            final /* synthetic */ int Hot;
            final /* synthetic */ f Hou;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(f fVar, int i2) {
                super(1);
                this.Hou = fVar;
                this.Hot = i2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(f fVar) {
                AppMethodBeat.i(236261);
                f fVar2 = fVar;
                m mVar = this.Hou.Hoq.HnX;
                if (mVar != null) {
                    mVar.b(fVar2, this.Hot);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(236261);
                return xVar;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public f(j jVar) {
            this.Hoq = jVar;
        }

        @Override // com.tencent.mm.plugin.voip.video.render.j.b
        public final void fLY() {
            AppMethodBeat.i(236262);
            m mVar = this.Hoq.HnX;
            if (mVar != null) {
                mVar.fLT();
                AppMethodBeat.o(236262);
                return;
            }
            AppMethodBeat.o(236262);
        }

        @Override // com.tencent.mm.plugin.voip.video.render.j.b
        public final void a(int i2, Surface surface, SurfaceTexture surfaceTexture) {
            f fVar;
            AppMethodBeat.i(236263);
            if (!(surface == null && surfaceTexture == null)) {
                if (surface != null) {
                    fVar = new f(surface, (byte) 0);
                } else {
                    if (surfaceTexture == null) {
                        p.hyc();
                    }
                    fVar = new f(surfaceTexture, (byte) 0);
                }
                this.Hor = fVar;
                m mVar = this.Hoq.HnX;
                if (mVar != null) {
                    f fVar2 = this.Hor;
                    if (fVar2 == null) {
                        p.hyc();
                    }
                    mVar.a(fVar2, new a(this, i2));
                    AppMethodBeat.o(236263);
                    return;
                }
            }
            AppMethodBeat.o(236263);
        }

        @Override // com.tencent.mm.plugin.voip.video.render.j.b
        public final void aed(int i2) {
            AppMethodBeat.i(236264);
            m mVar = this.Hoq.HnX;
            if (mVar != null) {
                mVar.c(this.Hor, i2);
            }
            m mVar2 = this.Hoq.HnX;
            if (mVar2 != null) {
                mVar2.a(this.Hor);
            }
            this.Hor = null;
            AppMethodBeat.o(236264);
        }

        @Override // com.tencent.mm.plugin.voip.video.render.j.b
        public final void aG(int i2, int i3, int i4) {
            f.b bVar;
            f.b bVar2;
            f.b bVar3;
            f.b bVar4;
            AppMethodBeat.i(236265);
            f fVar = this.Hor;
            if (!(fVar == null || (bVar4 = fVar.Hnv) == null)) {
                bVar4.x = 0;
            }
            f fVar2 = this.Hor;
            if (!(fVar2 == null || (bVar3 = fVar2.Hnv) == null)) {
                bVar3.y = 0;
            }
            f fVar3 = this.Hor;
            if (!(fVar3 == null || (bVar2 = fVar3.Hnv) == null)) {
                bVar2.width = i2;
            }
            f fVar4 = this.Hor;
            if (!(fVar4 == null || (bVar = fVar4.Hnv) == null)) {
                bVar.height = i3;
            }
            m mVar = this.Hoq.HnX;
            if (mVar != null) {
                mVar.a(this.Hor, i4);
            }
            m mVar2 = this.Hoq.HnX;
            if (mVar2 != null) {
                mVar2.fLR();
                AppMethodBeat.o(236265);
                return;
            }
            AppMethodBeat.o(236265);
        }
    }

    public final void setHWDecMode(int i2) {
        AppMethodBeat.i(236285);
        Log.i("MicroMsg.VoIPRenderMgr", "setHWDecMode, hwdec: %d, before changeSurfaceRender :%d", Integer.valueOf(i2), Integer.valueOf(this.HdK));
        if (this.HdK != i2) {
            this.HdK = i2;
            this.GYl.Z(true, (this.HdK & 1) != 0 ? 1 : 0);
            this.GYl.fJK();
        }
        if ((this.HdK & 1) != 0) {
            m mVar = this.HnX;
            if (mVar != null) {
                mVar.setShowMode(1);
                AppMethodBeat.o(236285);
                return;
            }
            AppMethodBeat.o(236285);
            return;
        }
        m mVar2 = this.HnX;
        if (mVar2 != null) {
            mVar2.setShowMode(0);
            AppMethodBeat.o(236285);
            return;
        }
        AppMethodBeat.o(236285);
    }

    public final void jA(int i2, int i3) {
        AppMethodBeat.i(236286);
        Log.printInfoStack("MicroMsg.VoIPRenderMgr", "adjustHWViewAspectRatio, mIsStarted:%b, HWDec size:%dx%d", Boolean.valueOf(this.mIsStarted), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 || i3 == 0) {
            AppMethodBeat.o(236286);
        } else if (this.Hoa) {
            AppMethodBeat.o(236286);
        } else {
            this.GUK = i3;
            this.GUL = i2;
            if (this.mIsStarted && this.HnX != null) {
                this.Hoa = true;
                onOrientationChange(this.kyf);
                m mVar = this.HnX;
                if (mVar != null) {
                    mVar.a(new ac(i3, i2), (Integer) 270);
                }
                aeb(this.Hir);
            }
            AppMethodBeat.o(236286);
        }
    }

    public final com.tencent.mm.plugin.voip.video.b.a aec(int i2) {
        AppMethodBeat.i(236287);
        if (this.Hom == null) {
            this.Hom = new h(this, i2);
            m mVar = this.HnX;
            if (mVar != null) {
                mVar.i(this.Hom);
            }
        }
        com.tencent.mm.plugin.voip.video.b.a aVar = this.HnY;
        AppMethodBeat.o(236287);
        return aVar;
    }

    public final com.tencent.mm.plugin.voip.video.d.b fJk() {
        AppMethodBeat.i(236288);
        if (this.Hon == null) {
            this.Hon = new i(this);
            m mVar = this.HnX;
            if (mVar != null) {
                mVar.i(this.Hon);
            }
        }
        com.tencent.mm.plugin.voip.video.d.b bVar = this.HnZ;
        AppMethodBeat.o(236288);
        return bVar;
    }

    public final void release() {
        int i2;
        AppMethodBeat.i(236289);
        i iVar = i.HnR;
        i.report();
        com.tencent.mm.plugin.voip.b.c cVar = com.tencent.mm.plugin.voip.b.c.HgQ;
        com.tencent.mm.plugin.voip.b.c.clear();
        MMHandler mMHandler = this.GYm;
        if (mMHandler != null) {
            mMHandler.removeCallbacksAndMessages(null);
        }
        this.GYm = null;
        fLV();
        m mVar = this.HnX;
        if (mVar != null) {
            mVar.release();
        }
        com.tencent.mm.plugin.voip.b.a aVar = this.GYl;
        if ((this.HdK & 1) != 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        aVar.Z(true, i2);
        this.GYl.fJL();
        this.GYd = null;
        this.GYf = 0;
        AppMethodBeat.o(236289);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$Companion;", "", "()V", "RenderLocal", "", "RenderRemote", "TAG", "", "plugin-voip_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class k extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ j Hoq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(j jVar) {
            super(0);
            this.Hoq = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(236274);
            MMHandler mMHandler = this.Hoq.GYm;
            if (mMHandler != null) {
                mMHandler.post(new Runnable(this) {
                    /* class com.tencent.mm.plugin.voip.video.render.j.k.AnonymousClass1 */
                    final /* synthetic */ k HoE;

                    {
                        this.HoE = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(236273);
                        j.a(this.HoE.Hoq);
                        AppMethodBeat.o(236273);
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236274);
            return xVar;
        }
    }

    public final void onOrientationChange(int i2) {
        AppMethodBeat.i(236275);
        this.kyf = i2;
        com.tencent.mm.plugin.voip.video.camera.a.a aVar = this.HnU;
        if (aVar != null) {
            aVar.onOrientationChange(i2);
            AppMethodBeat.o(236275);
            return;
        }
        AppMethodBeat.o(236275);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ j Hoq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(j jVar) {
            super(0);
            this.Hoq = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(236254);
            if (!this.Hoq.HnW) {
                this.Hoq.HnW = true;
                m mVar = this.Hoq.HnX;
                if (mVar != null) {
                    mVar.ad(null);
                }
                this.Hoq.Hoo.ag(0, 3);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236254);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ j Hoq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(j jVar) {
            super(0);
            this.Hoq = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(236260);
            if (!this.Hoq.HnW) {
                this.Hoq.HnW = true;
                m mVar = this.Hoq.HnX;
                if (mVar != null) {
                    mVar.ad(null);
                }
                this.Hoq.Hoo.ag(0, 3);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236260);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(j jVar) {
        boolean z;
        int i2;
        boolean z2;
        int i3;
        ByteBuffer byteBuffer;
        int i4;
        int i5;
        int i6;
        AppMethodBeat.i(236293);
        if (!jVar.GYb) {
            if (jVar.HnU == null) {
                Log.e("MicroMsg.VoIPRenderMgr", "onFrameDataReady on onFrameAvailable remove preview callback, captureRender is null!");
                AppMethodBeat.o(236293);
                return;
            }
            com.tencent.mm.plugin.voip.video.camera.a.a aVar = jVar.HnU;
            int i7 = (aVar == null || !aVar.fKY()) ? 0 : OpenGlRender.FLAG_Mirror;
            com.tencent.mm.plugin.voip.video.camera.a.a aVar2 = jVar.HnU;
            int i8 = (aVar2 == null || !aVar2.fKZ()) ? OpenGlRender.FLAG_Angle90 : OpenGlRender.FLAG_Angle270;
            int i9 = 0;
            ByteBuffer byteBuffer2 = null;
            int i10 = 0;
            int i11 = 0;
            long j2 = 0;
            boolean z3 = OpenGlRender.getGLVersion() == 2 && jVar.GUC != 0;
            boolean z4 = (jVar.GUC & 8) != 0;
            boolean z5 = OpenGlRender.getGLVersion() == 2 && jVar.GUD != 0;
            if (!z3) {
                z = z3;
                i2 = 0;
            } else if (!z4 && jVar.aec(2) != null) {
                jVar.GYf = 0;
                z = z3;
                i2 = 1;
            } else if (z4 && jVar.aec(1) != null) {
                jVar.GYf = 0;
                z = z3;
                i2 = 2;
            } else if (jVar.GYd == null || jVar.GYf > 10) {
                z = false;
                i2 = 0;
            } else {
                jVar.GYf++;
                z = z3;
                i2 = 3;
            }
            if (!z5 || jVar.fJk() != null) {
                z2 = z5;
            } else {
                z2 = false;
            }
            if (z2 && jVar.HkU == null) {
                jVar.HkU = new com.tencent.mm.cm.a.k();
            }
            com.tencent.mm.plugin.voip.video.camera.a.a aVar3 = jVar.HnU;
            if (aVar3 == null || !aVar3.fKY() || ((!z || i2 == 0) && (!z2 || i2 != 0))) {
                com.tencent.mm.plugin.voip.video.b.a aec = jVar.aec(0);
                if ((aec != null ? aec.iEK : null) != null) {
                    ByteBuffer byteBuffer3 = aec.iEK;
                    i3 = aec.dataType;
                    switch (jVar.Hol) {
                        case 1:
                            i9 = 10;
                            break;
                        case 2:
                            i9 = 1;
                            break;
                        default:
                            i9 = jVar.Hog;
                            break;
                    }
                    if (byteBuffer3 == null) {
                        p.hyc();
                    }
                    j2 = (long) byteBuffer3.capacity();
                    i10 = aec.width;
                    i11 = aec.height;
                    jVar.Hok = i11;
                    jVar.Hoj = i10;
                    jVar.GYe = byteBuffer3;
                    byteBuffer = byteBuffer3;
                } else if (jVar.GYe != null) {
                    ByteBuffer byteBuffer4 = jVar.GYe;
                    switch (jVar.Hol) {
                        case 1:
                            i9 = 10;
                            break;
                        case 2:
                            i9 = 1;
                            break;
                        default:
                            i9 = jVar.Hog;
                            break;
                    }
                    if (byteBuffer4 == null) {
                        p.hyc();
                    }
                    j2 = (long) byteBuffer4.capacity();
                    i10 = jVar.Hoj;
                    i11 = jVar.Hok;
                    i3 = jVar.Hol;
                    jVar.GYe = byteBuffer4;
                    byteBuffer = byteBuffer4;
                } else {
                    i3 = 0;
                    byteBuffer = null;
                }
            } else {
                if (i2 == 0 && z2) {
                    com.tencent.mm.plugin.voip.video.d.b fJk = jVar.fJk();
                    if ((fJk != null ? fJk.HpD : null) != null) {
                        ByteBuffer byteBuffer5 = fJk.HpD;
                        i5 = fJk.dataType;
                        switch (i5) {
                            case 1:
                                i6 = 10;
                                break;
                            case 2:
                                i6 = 1;
                                break;
                            default:
                                i6 = jVar.Hog;
                                break;
                        }
                        if (byteBuffer5 == null) {
                            p.hyc();
                        }
                        i10 = fJk.width;
                        int i12 = fJk.height;
                        jVar.GYe = byteBuffer5;
                        j2 = (long) byteBuffer5.capacity();
                        i11 = i12;
                        byteBuffer2 = byteBuffer5;
                    }
                    i5 = 0;
                    i6 = 0;
                } else if (i2 == 1) {
                    com.tencent.mm.plugin.voip.video.b.a aec2 = jVar.aec(2);
                    if ((aec2 != null ? aec2.iEK : null) != null) {
                        ByteBuffer byteBuffer6 = aec2.iEK;
                        i5 = aec2.dataType;
                        switch (i5) {
                            case 1:
                                i6 = 10;
                                break;
                            case 2:
                                i6 = 1;
                                break;
                            default:
                                i6 = jVar.Hog;
                                break;
                        }
                        if (byteBuffer6 == null) {
                            p.hyc();
                        }
                        i10 = aec2.width;
                        int i13 = aec2.height;
                        jVar.GYe = byteBuffer6;
                        j2 = (long) byteBuffer6.capacity();
                        i11 = i13;
                        byteBuffer2 = byteBuffer6;
                    }
                    i5 = 0;
                    i6 = 0;
                } else if (i2 == 2) {
                    com.tencent.mm.plugin.voip.video.b.a aec3 = jVar.aec(1);
                    if ((aec3 != null ? aec3.iEK : null) != null) {
                        ByteBuffer byteBuffer7 = aec3.iEK;
                        i5 = aec3.dataType;
                        switch (i5) {
                            case 1:
                                i6 = 10;
                                break;
                            case 2:
                                i6 = 1;
                                break;
                            default:
                                i6 = jVar.Hog;
                                break;
                        }
                        if (byteBuffer7 == null) {
                            p.hyc();
                        }
                        i10 = aec3.width;
                        int i14 = aec3.height;
                        jVar.GYe = byteBuffer7;
                        j2 = (long) byteBuffer7.capacity();
                        i11 = i14;
                        byteBuffer2 = byteBuffer7;
                    }
                    i5 = 0;
                    i6 = 0;
                } else {
                    if (i2 == 3 && jVar.GYd != null) {
                        ByteBuffer byteBuffer8 = jVar.GYe;
                        switch (jVar.Hol) {
                            case 1:
                                i6 = 10;
                                break;
                            case 2:
                                i6 = 1;
                                break;
                            default:
                                i6 = jVar.Hog;
                                break;
                        }
                        if (byteBuffer8 == null) {
                            p.hyc();
                        }
                        long capacity = (long) byteBuffer8.capacity();
                        i10 = jVar.Hoj;
                        int i15 = jVar.Hok;
                        i5 = jVar.Hol;
                        jVar.GYe = byteBuffer8;
                        j2 = capacity;
                        i11 = i15;
                        byteBuffer2 = byteBuffer8;
                    }
                    i5 = 0;
                    i6 = 0;
                }
                jVar.Hok = i11;
                jVar.Hoj = i10;
                i3 = i5;
                byteBuffer = byteBuffer2;
                i9 = i6;
            }
            jVar.Hol = i3;
            if (byteBuffer == null) {
                Log.e("MicroMsg.VoIPRenderMgr", "send data is null and should not allowed to send");
                h.a aVar4 = com.tencent.mm.plugin.voip.b.h.Hhl;
                h.a.adL(0);
                AppMethodBeat.o(236293);
                return;
            }
            if (z2) {
                com.tencent.mm.cm.a.k kVar = jVar.HkU;
                if (kVar == null) {
                    p.hyc();
                }
                int b2 = kVar.b(byteBuffer, i10, i11);
                com.tencent.mm.cm.a.k kVar2 = jVar.HkU;
                if (kVar2 == null) {
                    p.hyc();
                }
                float hff = kVar2.hff();
                m mVar = jVar.HnX;
                if (mVar != null) {
                    mVar.x(b2, hff);
                }
            }
            jVar.aR(z, z2);
            Log.d("MicroMsg.VoIPRenderMgr", "jcchen capture data:  vw=" + i10 + "vh=" + i11 + ", bm=" + i2 + "and format is " + i9 + " and data is " + i3);
            Log.i("MicroMsg.VoIPRenderMgr", "encode tick " + Util.ticksToNow(jVar.tick));
            jVar.tick = Util.currentTicks();
            jVar.Hoo.aB(com.tencent.mm.plugin.voip.c.fFg().c(byteBuffer, (int) j2, i9, i10, i11, i3), i10, i11);
            jVar.GYi++;
            jVar.GUq = i7 == OpenGlRender.FLAG_Mirror;
            if (i8 == OpenGlRender.FLAG_Angle270) {
                i4 = 270;
            } else {
                i4 = 90;
            }
            jVar.GUr = i4;
        }
        AppMethodBeat.o(236293);
    }

    public static final /* synthetic */ void a(j jVar, byte[] bArr, int i2, int i3) {
        boolean z = true;
        AppMethodBeat.i(236295);
        if (jVar.GYi % 100 == 0) {
            if (bArr != null) {
                try {
                    if (bArr.length == 0) {
                        z = false;
                    }
                    if (z) {
                        byte[] bArr2 = new byte[5];
                        int i4 = (i2 * 33) + 33;
                        int i5 = (i2 * 34) - 34;
                        int i6 = ((i2 * i3) / 2) + (i2 / 2);
                        int i7 = ((i3 - 34) * i2) + 33;
                        int i8 = (((i3 - 34) * i2) + i2) - 34;
                        if (i8 < bArr.length) {
                            bArr2[0] = bArr[i4];
                            bArr2[1] = bArr[i5];
                            bArr2[2] = bArr[i6];
                            bArr2[3] = bArr[i7];
                            bArr2[4] = bArr[i8];
                            Log.i("MicroMsg.VoIPRenderMgr", "onFrameDataReady, sample sendData:[%s, %s, %s, %s, %s], captureFrameCount:%s", Byte.valueOf(bArr2[0]), Byte.valueOf(bArr2[1]), Byte.valueOf(bArr2[2]), Byte.valueOf(bArr2[3]), Byte.valueOf(bArr2[4]), Integer.valueOf(jVar.GYi));
                            int i9 = 0;
                            for (int i10 = 0; i10 < 5; i10++) {
                                if (bArr2[i10] == 0) {
                                    i9++;
                                }
                            }
                            if (i9 >= 5) {
                                t tVar = t.GYO;
                                t.fHO();
                                h.a aVar = com.tencent.mm.plugin.voip.b.h.Hhl;
                                h.a.adL(1);
                                AppMethodBeat.o(236295);
                                return;
                            }
                        } else {
                            Log.i("MicroMsg.VoIPRenderMgr", "sample check sendData error! %s", Integer.valueOf(bArr.length));
                            AppMethodBeat.o(236295);
                            return;
                        }
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.VoIPRenderMgr", e2, "sampleCheckSendData error", new Object[0]);
                }
            }
            Log.i("MicroMsg.VoIPRenderMgr", "sample check sendData error is null or empty");
            AppMethodBeat.o(236295);
            return;
        }
        AppMethodBeat.o(236295);
    }
}

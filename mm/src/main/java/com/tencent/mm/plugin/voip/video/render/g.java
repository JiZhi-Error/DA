package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES30;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.wxmm.v2helper;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.a.r;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J \u0010R\u001a\u00020\u000b2\u0018\b\u0002\u0010S\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018J6\u0010T\u001a\u00020\u000b2.\b\u0002\u0010S\u001a(\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tj\u0004\u0018\u0001`\rJ\u0018\u0010U\u001a\u00020\u000b2\b\u0010D\u001a\u0004\u0018\u00010)2\u0006\u0010V\u001a\u00020\u0003J\u001c\u0010W\u001a\u00020\u000b2\u0014\u0010S\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018J\u000e\u0010X\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u001fJ\b\u0010Y\u001a\u00020\u000bH\u0002J(\u0010Z\u001a\u00020\u000b2\u0006\u0010[\u001a\u00020)2\u0018\b\u0002\u0010S\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010)\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018J\u0006\u0010\\\u001a\u00020\u000bJ\u0006\u0010]\u001a\u00020\u0003J\b\u0010^\u001a\u0004\u0018\u00010_J\b\u0010`\u001a\u0004\u0018\u00010\u0011J\u0006\u0010a\u001a\u00020\u0003J\b\u0010b\u001a\u00020\u000bH\u0002J\b\u0010c\u001a\u00020\u000bH\u0002J\u0014\u0010d\u001a\u00020\u000b2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u000b0,J\u0018\u0010e\u001a\u00020\u000b2\b\u0010D\u001a\u0004\u0018\u00010)2\u0006\u0010V\u001a\u00020\u0003J\b\u0010f\u001a\u00020\u000bH\u0002J\u000e\u0010g\u001a\u00020\u000b2\u0006\u0010h\u001a\u00020\u001fJ\u000e\u0010i\u001a\u00020\u000b2\u0006\u0010j\u001a\u00020\u0003J\u0016\u0010k\u001a\u00020\u000b2\u0006\u0010l\u001a\u00020\u00032\u0006\u0010m\u001a\u00020\u0003J\u0016\u0010n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u0016\u0010o\u001a\u00020\u000b2\u0006\u0010p\u001a\u00020\u00032\u0006\u0010q\u001a\u00020rJ\u0016\u0010s\u001a\u00020\u000b2\u0006\u0010t\u001a\u00020\u00032\u0006\u0010u\u001a\u00020\u001fJ\u000e\u0010v\u001a\u00020\u000b2\u0006\u0010t\u001a\u00020\u0003J\u0006\u0010w\u001a\u00020\u000bJ\u0006\u0010x\u001a\u00020\u000bJ\u0006\u0010y\u001a\u00020\u000bJ\u0018\u0010z\u001a\u00020\u000b2\b\u0010{\u001a\u0004\u0018\u00010)2\u0006\u0010V\u001a\u00020\u0003J\u001e\u0010|\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u00032\u0006\u0010~\u001a\u00020\u00032\u0006\u0010\u001a\u00020\u0003J!\u0010\u0001\u001a\u00020\u000b2\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010l\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u001fR\u000e\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R^\u0010\u0007\u001aR\u0012\"\u0012 \u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\t0\bj*\u0012&\u0012$\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\tj\u0002`\r`\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R>\u0010\u0017\u001a2\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00180\bj\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0018`\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001c\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R$\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R9\u00101\u001a!\u0012\u0013\u0012\u00110%¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u00109\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010.\"\u0004\b;\u00100R\u000e\u0010<\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010D\u001a\u0004\u0018\u00010EX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u0010J\u001a\u0004\u0018\u00010KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0014\"\u0004\bQ\u0010\u0016¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "", "width", "", "height", "(II)V", "beautyParam", "dataCallbackList", "Ljava/util/ArrayList;", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "", "Lkotlin/collections/ArrayList;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "externalTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "faceBeautyAlgorithm", "getFaceBeautyAlgorithm", "()I", "setFaceBeautyAlgorithm", "(I)V", "fboCallbackList", "Lkotlin/Function1;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHeight", "setHeight", "initCallback", "isRelease", "", "logFrameAvailable", "mCameraOrientation", "getMCameraOrientation", "setMCameraOrientation", "mDrawPerFrameStartTimes", "", "mIsMirror", "mIsRenderLocal", "mLocalRenderSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "mRemoteRenderSurface", "onDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "getOnDrawProcEndAfterViewAddCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDrawProcEndAfterViewAddCallback", "(Lkotlin/jvm/functions/Function0;)V", "onDrawProcPerFrameCost", "Lkotlin/ParameterName;", "name", "cost", "getOnDrawProcPerFrameCost", "()Lkotlin/jvm/functions/Function1;", "setOnDrawProcPerFrameCost", "(Lkotlin/jvm/functions/Function1;)V", "onFrameDataAvailableCallback", "getOnFrameDataAvailableCallback", "setOnFrameDataAvailableCallback", "pauseRender", "postInit", "renderProc", "Lcom/tencent/mm/plugin/voip/video/render/VoipRenderProcExternalTexture;", "renderThread", "Landroid/os/HandlerThread;", "rendering", "spatiotemporalDenosingAllow", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getWidth", "setWidth", "addFBOAvailableCallback", "callback", "addFrameDataCallback", "addRenderSurface", "renderSide", "checkInit", "choiceRenderSurface", "createContext", "createSurface", "glSurface", "destroy", "getFaceBeautyType", "getGLContext", "Landroid/opengl/EGLContext;", "getOutputExternalTexture", "getUseSTFilter", "onPreviewTextureFrameAvailable", "onRendererFrameAvailable", "queue", "removeSurface", "renderImpl", "setCameraIsMirror", "mirror", "setCameraOrientation", "orientation", "setLocalRenderOrientation", "rotateDegree", "cameraOrientation", "setLocalVideoSize", "setSTFilterMotionNoiseData", "motion", "noise", "", "setSpatiotemporalDenosing", "cmd", "skipFilter", "setVoIPBeauty", "start", "stop", "switchRenderSurface", "updateDrawViewSize", "outputSurface", "updateEncodeResType", "encWidth", "encHeight", "encoderType", "updatePboAndWindowsSize", "cameraSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "Companion", "plugin-voip_release"})
public final class g {
    public static final a HnH = new a((byte) 0);
    boolean HhF;
    private int HiD;
    private long HiP;
    private kotlin.g.a.b<? super g, x> HnA;
    private ArrayList<r<ByteBuffer, Integer, Integer, Integer, x>> HnB;
    ArrayList<kotlin.g.a.b<com.tencent.mm.media.g.d, x>> HnC;
    private boolean HnD;
    kotlin.g.a.a<x> HnE;
    int HnF;
    private int HnG;
    kotlin.g.a.a<x> Hnc;
    kotlin.g.a.b<? super Long, x> Hnd;
    private boolean Hnf;
    private f Hnh;
    private f Hni;
    private boolean Hnn;
    k Hnx;
    boolean Hny;
    private boolean Hnz;
    private MMHandler handler;
    int height;
    private boolean ife;
    private final HandlerThread igZ;
    c.b ilw;
    int sUv;
    Surface surface;
    SurfaceTexture surfaceTexture;
    int width;
    private com.tencent.mm.media.g.d zLQ;

    static {
        AppMethodBeat.i(236247);
        AppMethodBeat.o(236247);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "dataBuffer", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
    public static final class e extends kotlin.g.b.q implements r<ByteBuffer, Integer, Integer, Integer, x> {
        final /* synthetic */ g HnI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(g gVar) {
            super(4);
            this.HnI = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(ByteBuffer byteBuffer, Integer num, Integer num2, Integer num3) {
            boolean z;
            AppMethodBeat.i(236217);
            ByteBuffer byteBuffer2 = byteBuffer;
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            int intValue3 = num3.intValue();
            kotlin.g.b.p.h(byteBuffer2, "dataBuffer");
            if (!this.HnI.HnB.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                byteBuffer2.position(0);
                Iterator it = this.HnI.HnB.iterator();
                while (it.hasNext()) {
                    ((r) it.next()).invoke(byteBuffer2, Integer.valueOf(intValue), Integer.valueOf(intValue2), Integer.valueOf(intValue3));
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236217);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "dataBuffer", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
    public static final class f extends kotlin.g.b.q implements r<ByteBuffer, Integer, Integer, Integer, x> {
        final /* synthetic */ g HnI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(g gVar) {
            super(4);
            this.HnI = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(ByteBuffer byteBuffer, Integer num, Integer num2, Integer num3) {
            boolean z;
            AppMethodBeat.i(236218);
            ByteBuffer byteBuffer2 = byteBuffer;
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            int intValue3 = num3.intValue();
            kotlin.g.b.p.h(byteBuffer2, "dataBuffer");
            if (!this.HnI.HnB.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                byteBuffer2.position(0);
                Iterator it = this.HnI.HnB.iterator();
                while (it.hasNext()) {
                    ((r) it.next()).invoke(byteBuffer2, Integer.valueOf(intValue), Integer.valueOf(intValue2), Integer.valueOf(intValue3));
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236218);
            return xVar;
        }
    }

    public g(int i2, int i3) {
        AppMethodBeat.i(236246);
        this.width = i2;
        this.height = i3;
        HandlerThread hC = com.tencent.f.c.d.hC("PboSurfaceRender_renderThread_" + hashCode(), 5);
        kotlin.g.b.p.g(hC, "SpecialThreadFactory.cre…}\", Thread.NORM_PRIORITY)");
        this.igZ = hC;
        this.HnB = new ArrayList<>();
        this.HnC = new ArrayList<>();
        this.HiP = -1;
        this.Hnn = true;
        this.igZ.start();
        this.handler = new MMHandler(this.igZ.getLooper());
        this.Hnf = false;
        this.ife = false;
        AppMethodBeat.o(236246);
    }

    public static final /* synthetic */ void f(g gVar) {
        AppMethodBeat.i(236249);
        gVar.aMV();
        AppMethodBeat.o(236249);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender$Companion;", "", "()V", "TAG", "", "plugin-voip_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private /* synthetic */ g() {
        this(0, 0);
    }

    private final void aMV() {
        f fVar;
        EGLDisplay eGLDisplay;
        EGLContext eGLContext;
        EGLDisplay eGLDisplay2;
        AppMethodBeat.i(236231);
        SurfaceTexture surfaceTexture2 = this.surfaceTexture;
        if (surfaceTexture2 == null) {
            AppMethodBeat.o(236231);
        } else if (this.Hnz) {
            AppMethodBeat.o(236231);
        } else {
            try {
                surfaceTexture2.updateTexImage();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.PboSurfaceRender", e2, "updateTexImage error", new Object[0]);
            }
            if (com.tencent.mm.plugin.voip.b.g.fKg()) {
                this.HiP = Util.currentTicks();
                k kVar = this.Hnx;
                if (kVar != null) {
                    kVar.aED();
                }
                kotlin.g.a.b<? super Long, x> bVar = this.Hnd;
                if (bVar != null) {
                    bVar.invoke(Long.valueOf(Util.ticksToNow(this.HiP)));
                }
                kotlin.g.a.a<x> aVar = this.HnE;
                if (aVar != null) {
                    aVar.invoke();
                    AppMethodBeat.o(236231);
                    return;
                }
                AppMethodBeat.o(236231);
            } else if (this.HnF == 0) {
                if (this.Hnn) {
                    fVar = this.Hnh;
                } else {
                    fVar = this.Hni;
                }
                if (fVar == null || !this.Hnf) {
                    AppMethodBeat.o(236231);
                    return;
                }
                this.HiP = Util.currentTicks();
                k kVar2 = this.Hnx;
                if (kVar2 != null) {
                    kVar2.cY(fVar.Hnv.width, fVar.Hnv.height);
                }
                k kVar3 = this.Hnx;
                if (kVar3 != null) {
                    kVar3.aED();
                }
                c.b bVar2 = this.ilw;
                if (bVar2 != null) {
                    eGLDisplay = bVar2.ilu;
                } else {
                    eGLDisplay = null;
                }
                EGLSurface fLS = fVar.fLS();
                EGLSurface fLS2 = fVar.fLS();
                c.b bVar3 = this.ilw;
                if (bVar3 != null) {
                    eGLContext = bVar3.ilv;
                } else {
                    eGLContext = null;
                }
                EGL14.eglMakeCurrent(eGLDisplay, fLS, fLS2, eGLContext);
                c.a aVar2 = com.tencent.mm.media.k.c.ilt;
                c.b bVar4 = this.ilw;
                if (bVar4 != null) {
                    eGLDisplay2 = bVar4.ilu;
                } else {
                    eGLDisplay2 = null;
                }
                c.a.a(eGLDisplay2, fVar.fLS());
                if (this.Hnc != null) {
                    GLES30.glFinish();
                    kotlin.g.a.a<x> aVar3 = this.Hnc;
                    if (aVar3 != null) {
                        aVar3.invoke();
                    }
                    this.Hnc = null;
                    AppMethodBeat.o(236231);
                    return;
                }
                GLES30.glFinish();
                kotlin.g.a.b<? super Long, x> bVar5 = this.Hnd;
                if (bVar5 != null) {
                    bVar5.invoke(Long.valueOf(Util.ticksToNow(this.HiP)));
                    AppMethodBeat.o(236231);
                    return;
                }
                AppMethodBeat.o(236231);
            } else {
                this.HiP = Util.currentTicks();
                k kVar4 = this.Hnx;
                if (kVar4 != null) {
                    kVar4.aED();
                }
                kotlin.g.a.b<? super Long, x> bVar6 = this.Hnd;
                if (bVar6 != null) {
                    bVar6.invoke(Long.valueOf(Util.ticksToNow(this.HiP)));
                    AppMethodBeat.o(236231);
                    return;
                }
                AppMethodBeat.o(236231);
            }
        }
    }

    public final void adZ(int i2) {
        int i3 = 1;
        AppMethodBeat.i(236232);
        Log.printInfoStack("MicroMsg.PboSurfaceRender", "setVoIPBeauty, isON:%d", Integer.valueOf(i2));
        this.HiD = i2;
        boolean z = (this.HiD & 8) != 0;
        if (this.HiD != 0 && !z) {
            Log.i("MicroMsg.PboSurfaceRender", "render YT face-beauty algorithm");
            i3 = 2;
        } else if (!z || (this.HiD & 8) == 0) {
            i3 = 0;
        } else {
            Log.i("MicroMsg.PboSurfaceRender", "render WC face-beauty algorithm");
        }
        this.HnF = i3;
        k(new m(this, i2));
        AppMethodBeat.o(236232);
    }

    public final void aea(int i2) {
        AppMethodBeat.i(236233);
        Log.i("MicroMsg.PboSurfaceRender", "setSpatiotemporalDenosing, isON:%d", Integer.valueOf(i2));
        this.HnG = i2;
        if ((this.HnF == 0 || this.HnF == 3) && this.HnG == 1) {
            this.HnF = 3;
        }
        k(new l(this, i2, false));
        AppMethodBeat.o(236233);
    }

    public final void aF(int i2, int i3, int i4) {
        AppMethodBeat.i(236234);
        k(new q(this, i2, i3, i4));
        AppMethodBeat.o(236234);
    }

    public final void x(int i2, float f2) {
        AppMethodBeat.i(236235);
        k(new k(this, i2, f2));
        AppMethodBeat.o(236235);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/voip/video/render/PboSurfaceRender$createContext$3$1"})
    public static final class d implements SurfaceTexture.OnFrameAvailableListener {
        final /* synthetic */ g HnI;

        d(g gVar) {
            this.HnI = gVar;
        }

        public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(236216);
            g.h(this.HnI);
            if (com.tencent.mm.plugin.voip.b.g.fKg()) {
                g.i(this.HnI);
                AppMethodBeat.o(236216);
                return;
            }
            if (this.HnI.HnF != 0) {
                g.i(this.HnI);
            }
            AppMethodBeat.o(236216);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.voip.video.render.g$g  reason: collision with other inner class name */
    public static final class RunnableC1897g implements Runnable {
        final /* synthetic */ g HnI;

        RunnableC1897g(g gVar) {
            this.HnI = gVar;
        }

        public final void run() {
            AppMethodBeat.i(236219);
            kotlin.g.a.b bVar = this.HnI.HnA;
            if (bVar != null) {
                bVar.invoke(this.HnI);
                AppMethodBeat.o(236219);
                return;
            }
            AppMethodBeat.o(236219);
        }
    }

    public final void stop() {
        AppMethodBeat.i(236236);
        Log.i("MicroMsg.PboSurfaceRender", "stop");
        MMHandler mMHandler = this.handler;
        if (mMHandler != null) {
            mMHandler.removeCallbacksAndMessages(null);
        }
        k(new o(this));
        AppMethodBeat.o(236236);
    }

    public final void destroy() {
        AppMethodBeat.i(236237);
        Log.i("MicroMsg.PboSurfaceRender", "destroy");
        MMHandler mMHandler = this.handler;
        if (mMHandler != null) {
            mMHandler.removeCallbacksAndMessages(null);
        }
        this.HnB.clear();
        this.HnC.clear();
        k(new h(this));
        AppMethodBeat.o(236237);
    }

    public final void k(kotlin.g.a.a<x> aVar) {
        MMHandler mMHandler;
        AppMethodBeat.i(236238);
        kotlin.g.b.p.h(aVar, "callback");
        if (!this.igZ.isAlive() || (mMHandler = this.handler) == null) {
            AppMethodBeat.o(236238);
            return;
        }
        mMHandler.post(new h(aVar));
        AppMethodBeat.o(236238);
    }

    public final void h(r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> rVar) {
        AppMethodBeat.i(236239);
        if (rVar != null && !this.HnB.contains(rVar)) {
            this.HnB.add(rVar);
        }
        AppMethodBeat.o(236239);
    }

    public final void jN(int i2, int i3) {
        AppMethodBeat.i(236240);
        Log.i("MicroMsg.PboSurfaceRender", "setLocalRenderOrientation " + i2 + ',' + i3 + ",$");
        if (com.tencent.mm.plugin.voip.b.g.fKg() || this.HnF != 0) {
            if (this.HhF) {
                if (i2 == 180 || i2 == 0) {
                    k kVar = this.Hnx;
                    if (kVar != null) {
                        kVar.qx((i3 + TXLiveConstants.RENDER_ROTATION_180) % v2helper.VOIP_ENC_HEIGHT_LV1);
                    }
                    k kVar2 = this.Hnx;
                    if (kVar2 != null) {
                        kVar2.HoZ = (i3 - i2) % v2helper.VOIP_ENC_HEIGHT_LV1;
                    }
                } else {
                    k kVar3 = this.Hnx;
                    if (kVar3 != null) {
                        kVar3.qx(((i2 - i3) + TXLiveConstants.RENDER_ROTATION_180) % v2helper.VOIP_ENC_HEIGHT_LV1);
                    }
                    k kVar4 = this.Hnx;
                    if (kVar4 != null) {
                        kVar4.HoZ = (i2 - i3) % v2helper.VOIP_ENC_HEIGHT_LV1;
                    }
                }
                k kVar5 = this.Hnx;
                if (kVar5 != null) {
                    kVar5.Hpb = true;
                }
            } else if (i2 == 180 || i2 == 0) {
                k kVar6 = this.Hnx;
                if (kVar6 != null) {
                    kVar6.qx(i3);
                }
                k kVar7 = this.Hnx;
                if (kVar7 != null) {
                    kVar7.HoZ = i3 - i2;
                }
                k kVar8 = this.Hnx;
                if (kVar8 != null) {
                    kVar8.Hpb = true;
                }
            } else {
                k kVar9 = this.Hnx;
                if (kVar9 != null) {
                    kVar9.qx((i2 - i3) % v2helper.VOIP_ENC_HEIGHT_LV1);
                }
                k kVar10 = this.Hnx;
                if (kVar10 != null) {
                    kVar10.HoZ = (i2 - i3) % v2helper.VOIP_ENC_HEIGHT_LV1;
                }
                k kVar11 = this.Hnx;
                if (kVar11 != null) {
                    kVar11.Hpb = true;
                }
            }
            k kVar12 = this.Hnx;
            if (kVar12 != null) {
                kVar12.iju = false;
                AppMethodBeat.o(236240);
                return;
            }
            AppMethodBeat.o(236240);
            return;
        }
        if (this.HnF == 0) {
            if (!this.HhF) {
                if (i2 == 180 || i2 == 0) {
                    k kVar13 = this.Hnx;
                    if (kVar13 != null) {
                        kVar13.qx((i3 + TXLiveConstants.RENDER_ROTATION_180) % v2helper.VOIP_ENC_HEIGHT_LV1);
                    }
                } else {
                    k kVar14 = this.Hnx;
                    if (kVar14 != null) {
                        kVar14.qx(i3 % v2helper.VOIP_ENC_HEIGHT_LV1);
                    }
                }
                k kVar15 = this.Hnx;
                if (kVar15 != null) {
                    kVar15.iju = false;
                    AppMethodBeat.o(236240);
                    return;
                }
                AppMethodBeat.o(236240);
                return;
            }
            if (i2 == 180 || i2 == 0) {
                k kVar16 = this.Hnx;
                if (kVar16 != null) {
                    kVar16.qx(i3);
                }
            } else {
                k kVar17 = this.Hnx;
                if (kVar17 != null) {
                    kVar17.qx((i3 + TXLiveConstants.RENDER_ROTATION_180) % v2helper.VOIP_ENC_HEIGHT_LV1);
                }
            }
            k kVar18 = this.Hnx;
            if (kVar18 != null) {
                kVar18.iju = true;
                AppMethodBeat.o(236240);
                return;
            }
        }
        AppMethodBeat.o(236240);
    }

    public final void fLQ() {
        AppMethodBeat.i(236241);
        Log.printInfoStack("MicroMsg.PboSurfaceRender", "switchRenderSurface", new Object[0]);
        k(new p(this));
        AppMethodBeat.o(236241);
    }

    public final void fLT() {
        AppMethodBeat.i(236242);
        k(new c(this, true));
        AppMethodBeat.o(236242);
    }

    public final void c(f fVar, int i2) {
        EGLDisplay eGLDisplay;
        EGLDisplay eGLDisplay2;
        AppMethodBeat.i(236243);
        if (fVar != null) {
            Log.i("MicroMsg.PboSurfaceRender", "remove render surface :".concat(String.valueOf(fVar)));
            c.b bVar = this.ilw;
            if (bVar != null) {
                eGLDisplay = bVar.ilu;
            } else {
                eGLDisplay = null;
            }
            if (eGLDisplay != null && (!kotlin.g.b.p.j(fVar.fLS(), EGL14.EGL_NO_SURFACE))) {
                c.b bVar2 = this.ilw;
                if (bVar2 != null) {
                    eGLDisplay2 = bVar2.ilu;
                } else {
                    eGLDisplay2 = null;
                }
                EGL14.eglDestroySurface(eGLDisplay2, fVar.fLS());
            }
            if (i2 == 0) {
                this.Hnh = null;
                AppMethodBeat.o(236243);
                return;
            }
            this.Hni = null;
            AppMethodBeat.o(236243);
            return;
        }
        Log.e("MicroMsg.PboSurfaceRender", "remove a null surface");
        AppMethodBeat.o(236243);
    }

    public final void a(f fVar, int i2) {
        if (i2 == 0) {
            this.Hnh = fVar;
        } else {
            this.Hni = fVar;
        }
    }

    public final void b(f fVar, int i2) {
        AppMethodBeat.i(236244);
        if (fVar != null) {
            Log.printInfoStack("MicroMsg.PboSurfaceRender", "add render surface renderSide " + i2 + " and :" + fVar, new Object[0]);
            if (i2 == 0) {
                this.Hnh = fVar;
                AppMethodBeat.o(236244);
                return;
            }
            this.Hni = fVar;
            AppMethodBeat.o(236244);
            return;
        }
        Log.e("MicroMsg.PboSurfaceRender", "add a null surface");
        AppMethodBeat.o(236244);
    }

    public final void a(f fVar, kotlin.g.a.b<? super f, x> bVar) {
        AppMethodBeat.i(236245);
        kotlin.g.b.p.h(fVar, "glSurface");
        c.a aVar = com.tencent.mm.media.k.c.ilt;
        c.b bVar2 = this.ilw;
        if (bVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        EGLSurface a2 = c.a.a(bVar2.ilu, fVar.Hnu);
        kotlin.g.b.p.h(a2, "eglSurface");
        fVar.eglSurface = a2;
        if (bVar != null) {
            bVar.invoke(fVar);
            AppMethodBeat.o(236245);
            return;
        }
        AppMethodBeat.o(236245);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ g HnI;
        final /* synthetic */ kotlin.g.a.b gWe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(g gVar, kotlin.g.a.b bVar) {
            super(0);
            this.HnI = gVar;
            this.gWe = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(236214);
            this.HnI.Hny = true;
            this.HnI.HnA = this.gWe;
            g.c(this.HnI);
            this.HnI.Hnz = false;
            x xVar = x.SXb;
            AppMethodBeat.o(236214);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class m extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ g HnI;
        final /* synthetic */ int HnL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(g gVar, int i2) {
            super(0);
            this.HnI = gVar;
            this.HnL = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            EGLDisplay eGLDisplay;
            EGLContext eGLContext = null;
            AppMethodBeat.i(236226);
            k kVar = this.HnI.Hnx;
            if (kVar != null) {
                kVar.jO(this.HnL, this.HnI.HnF);
            }
            k kVar2 = this.HnI.Hnx;
            if (kVar2 != null && kVar2.HoV) {
                c.b bVar = this.HnI.ilw;
                if (bVar != null) {
                    eGLDisplay = bVar.ilu;
                } else {
                    eGLDisplay = null;
                }
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                c.b bVar2 = this.HnI.ilw;
                if (bVar2 != null) {
                    eGLContext = bVar2.ilv;
                }
                EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
                if (com.tencent.mm.plugin.voip.b.g.fKg()) {
                    k kVar3 = this.HnI.Hnx;
                    if (kVar3 != null) {
                        kVar3.cY(this.HnI.height, this.HnI.width);
                    }
                } else {
                    k kVar4 = this.HnI.Hnx;
                    if (kVar4 != null) {
                        kVar4.cY(this.HnI.width, this.HnI.height);
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236226);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class l extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ g HnI;
        final /* synthetic */ int HnL;
        final /* synthetic */ boolean HnM = false;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(g gVar, int i2, boolean z) {
            super(0);
            this.HnI = gVar;
            this.HnL = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0136, code lost:
            if (r0.intValue() == r2) goto L_0x00f6;
         */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke() {
            /*
            // Method dump skipped, instructions count: 338
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.video.render.g.l.invoke():java.lang.Object");
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ g HnI;
        final /* synthetic */ int cKE;
        final /* synthetic */ int cKF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(g gVar, int i2, int i3) {
            super(0);
            this.HnI = gVar;
            this.cKE = i2;
            this.cKF = i3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(236223);
            k kVar = this.HnI.Hnx;
            if (kVar != null) {
                kVar.cY(this.cKE, this.cKF);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236223);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class q extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ g HnI;
        final /* synthetic */ int HnN;
        final /* synthetic */ int HnO;
        final /* synthetic */ int HnP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(g gVar, int i2, int i3, int i4) {
            super(0);
            this.HnI = gVar;
            this.HnN = i2;
            this.HnO = i3;
            this.HnP = i4;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            a aVar;
            a aVar2;
            a aVar3;
            a aVar4;
            AppMethodBeat.i(236230);
            k kVar = this.HnI.Hnx;
            if (kVar != null) {
                int i2 = this.HnN;
                int i3 = this.HnO;
                int i4 = this.HnP;
                switch (kVar.HoX) {
                    case 1:
                        com.tencent.mm.plugin.voip.video.c.b bVar = kVar.HoO;
                        if (!(bVar == null || !bVar.Hmt || (aVar2 = bVar.Hms) == null)) {
                            aVar2.aF(i2, i3, i4);
                            break;
                        }
                    case 2:
                        com.tencent.mm.plugin.voip.video.c.g gVar = kVar.HoP;
                        if (!(gVar == null || !gVar.Hmt || (aVar3 = gVar.Hms) == null)) {
                            aVar3.aF(i2, i3, i4);
                            break;
                        }
                    case 3:
                        com.tencent.mm.plugin.voip.video.c.e eVar = kVar.HoQ;
                        if (!(eVar == null || !eVar.Hmt || (aVar = eVar.Hms) == null)) {
                            aVar.aF(i2, i3, i4);
                            break;
                        }
                    default:
                        com.tencent.mm.plugin.voip.video.c.c cVar = kVar.HoN;
                        if (!(cVar == null || !cVar.Hmt || (aVar4 = cVar.Hms) == null)) {
                            aVar4.aF(i2, i3, i4);
                            break;
                        }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236230);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ g HnI;
        final /* synthetic */ int HnJ;
        final /* synthetic */ float HnK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(g gVar, int i2, float f2) {
            super(0);
            this.HnI = gVar;
            this.HnJ = i2;
            this.HnK = f2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            kotlin.g.a.m<? super Integer, ? super Float, x> mVar;
            AppMethodBeat.i(236224);
            k kVar = this.HnI.Hnx;
            if (!(kVar == null || (mVar = kVar.Hpf) == null)) {
                mVar.invoke(Integer.valueOf(this.HnJ), Float.valueOf(this.HnK));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236224);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class i extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ g HnI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(g gVar) {
            super(0);
            this.HnI = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(236221);
            g.f(this.HnI);
            x xVar = x.SXb;
            AppMethodBeat.o(236221);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class o extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ g HnI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(g gVar) {
            super(0);
            this.HnI = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(236228);
            this.HnI.Hnf = false;
            Log.i("MicroMsg.PboSurfaceRender", "stop set pauseRender");
            this.HnI.Hnz = true;
            x xVar = x.SXb;
            AppMethodBeat.o(236228);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ g HnI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(g gVar) {
            super(0);
            this.HnI = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(236227);
            Log.i("MicroMsg.PboSurfaceRender", "start set pauseRender");
            this.HnI.Hnf = true;
            this.HnI.Hnz = false;
            x xVar = x.SXb;
            AppMethodBeat.o(236227);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ g HnI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(g gVar) {
            super(0);
            this.HnI = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(236220);
            k kVar = this.HnI.Hnx;
            if (kVar != null) {
                kVar.release();
            }
            this.HnI.Hnz = true;
            Surface surface = this.HnI.surface;
            if (surface != null) {
                surface.release();
            }
            SurfaceTexture surfaceTexture = this.HnI.surfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
            }
            com.tencent.mm.media.g.d dVar = this.HnI.zLQ;
            if (dVar != null) {
                dVar.close();
            }
            c.b bVar = this.HnI.ilw;
            if (bVar != null) {
                c.a aVar = com.tencent.mm.media.k.c.ilt;
                c.a.a(bVar);
            }
            this.HnI.igZ.quitSafely();
            Log.i("MicroMsg.PboSurfaceRender", "destroy finish");
            x xVar = x.SXb;
            AppMethodBeat.o(236220);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class p extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ g HnI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(g gVar) {
            super(0);
            this.HnI = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            EGLDisplay eGLDisplay;
            boolean z;
            EGLContext eGLContext = null;
            AppMethodBeat.i(236229);
            this.HnI.Hnf = false;
            c.b bVar = this.HnI.ilw;
            if (bVar != null) {
                eGLDisplay = bVar.ilu;
            } else {
                eGLDisplay = null;
            }
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            c.b bVar2 = this.HnI.ilw;
            if (bVar2 != null) {
                eGLContext = bVar2.ilv;
            }
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
            g gVar = this.HnI;
            if (!this.HnI.Hnn) {
                z = true;
            } else {
                z = false;
            }
            gVar.Hnn = z;
            this.HnI.Hnf = true;
            x xVar = x.SXb;
            AppMethodBeat.o(236229);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ g HnI;
        final /* synthetic */ boolean Hnq = true;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(g gVar, boolean z) {
            super(0);
            this.HnI = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(236215);
            if (this.Hnq != this.HnI.Hnn) {
                this.HnI.fLQ();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236215);
            return xVar;
        }
    }

    public static final /* synthetic */ void c(g gVar) {
        AppMethodBeat.i(236248);
        gVar.ilw = c.a.a(com.tencent.mm.media.k.c.ilt, null, gVar.width, gVar.height, null, 16);
        gVar.Hnx = new k(gVar.width, gVar.height, gVar.width, gVar.height);
        gVar.adZ(gVar.HiD);
        gVar.aea(gVar.HnG);
        k kVar = gVar.Hnx;
        if (kVar != null) {
            kVar.HoS = new e(gVar);
        }
        k kVar2 = gVar.Hnx;
        if (kVar2 != null) {
            kVar2.HoT = new f(gVar);
        }
        gVar.zLQ = new com.tencent.mm.media.g.d(false, 14);
        com.tencent.mm.media.g.d dVar = gVar.zLQ;
        if (dVar != null) {
            k kVar3 = gVar.Hnx;
            if (kVar3 != null) {
                kVar3.ikx = dVar.igv;
            }
            k kVar4 = gVar.Hnx;
            if (kVar4 != null) {
                kotlin.g.b.p.h(dVar, "texture");
                kVar4.HoR = dVar;
            }
            gVar.surfaceTexture = new SurfaceTexture(dVar.igv);
            gVar.surface = new Surface(gVar.surfaceTexture);
            SurfaceTexture surfaceTexture2 = gVar.surfaceTexture;
            if (surfaceTexture2 != null) {
                surfaceTexture2.setOnFrameAvailableListener(new d(gVar));
            }
        }
        MMHandlerThread.postToMainThread(new RunnableC1897g(gVar));
        Log.i("MicroMsg.PboSurfaceRender", "init create PboSurfaceRender, width:" + gVar.width + ", height:" + gVar.height);
        AppMethodBeat.o(236248);
    }

    public static final /* synthetic */ void h(g gVar) {
        AppMethodBeat.i(236250);
        if (!gVar.HnD) {
            Log.i("MicroMsg.PboSurfaceRender", "onPreviewTextureFrameAvailable, looper:" + Looper.myLooper());
            gVar.HnD = true;
        }
        Looper myLooper = Looper.myLooper();
        MMHandler mMHandler = gVar.handler;
        if (kotlin.g.b.p.j(myLooper, mMHandler != null ? mMHandler.getLooper() : null)) {
            gVar.aMV();
            AppMethodBeat.o(236250);
            return;
        }
        gVar.k(new i(gVar));
        AppMethodBeat.o(236250);
    }

    public static final /* synthetic */ void i(g gVar) {
        com.tencent.mm.media.g.d dVar;
        AppMethodBeat.i(236251);
        Iterator<kotlin.g.a.b<com.tencent.mm.media.g.d, x>> it = gVar.HnC.iterator();
        while (it.hasNext()) {
            kotlin.g.a.b<com.tencent.mm.media.g.d, x> next = it.next();
            k kVar = gVar.Hnx;
            if (kVar == null) {
                dVar = null;
            } else if (kVar.Hpc != null) {
                dVar = kVar.Hpc;
            } else {
                dVar = kVar.ijD;
            }
            next.invoke(dVar);
        }
        AppMethodBeat.o(236251);
    }
}

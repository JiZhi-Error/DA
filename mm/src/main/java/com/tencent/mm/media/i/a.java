package com.tencent.mm.media.i;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.EGLContext;
import android.opengl.EGLExt;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.tav.coremedia.TimeUtil;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 s2\u00020\u0001:\u0001sB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010=\u001a\u00020\u000bJ\b\u0010>\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010?\u001a\u000206J]\u0010@\u001a\u00020\u00132\b\u00105\u001a\u0004\u0018\u0001062\u0006\u0010A\u001a\u00020\u00122\b\b\u0002\u0010B\u001a\u00020\u000f2\b\b\u0002\u0010C\u001a\u00020\u000f2\b\b\u0002\u0010D\u001a\u00020\u000b2%\b\u0002\u0010E\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\bF\u0012\b\bG\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020\u0013\u0018\u00010\nJ\b\u0010I\u001a\u00020\u0013H\u0002JM\u0010J\u001a\u00020\u00132\n\b\u0002\u0010K\u001a\u0004\u0018\u00010L2\b\b\u0002\u0010B\u001a\u00020\u000f2\b\b\u0002\u0010C\u001a\u00020\u000f2#\u0010E\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\bF\u0012\b\bG\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020\u0013\u0018\u00010\nH\u0016JK\u0010M\u001a\u00020\u00132\u0006\u00105\u001a\u0002062\n\b\u0002\u0010K\u001a\u0004\u0018\u00010L2\b\b\u0002\u0010N\u001a\u00020\u00122%\b\u0002\u0010E\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\bF\u0012\b\bG\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020\u0013\u0018\u00010\nJ\u0006\u0010O\u001a\u00020\u0012J\u0016\u0010P\u001a\u00020\u00132\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010)J\u0018\u0010Q\u001a\u00020\u00132\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010)H\u0002J\u0006\u0010R\u001a\u00020\u0013J\u000e\u0010S\u001a\u00020\u00132\u0006\u0010;\u001a\u00020<J9\u0010S\u001a\u00020\u00132\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u000b2!\u0010W\u001a\u001d\u0012\u0013\u0012\u00110U¢\u0006\f\bF\u0012\b\bG\u0012\u0004\b\b(T\u0012\u0004\u0012\u00020\u00130\nJ\u0016\u0010S\u001a\u00020\u00132\u0006\u0010X\u001a\u00020\u000f2\u0006\u0010V\u001a\u00020\u000bJ.\u0010S\u001a\u00020\u00132\u0006\u0010V\u001a\u00020\u000b2\b\u0010Y\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010Z\u001a\u00020\u00122\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\bJ$\u0010\\\u001a\u00020\u00132\u0006\u0010V\u001a\u00020\u000b2\b\u0010Y\u001a\u0004\u0018\u00010\b2\b\u0010[\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010]\u001a\u00020\u00132\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00130)J\u0012\u0010^\u001a\u00020\u00132\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bJ \u0010_\u001a\u00020\u00132\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\nJ \u0010`\u001a\u00020\u00132\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\nJ\u000e\u0010a\u001a\u00020\u00132\u0006\u0010b\u001a\u00020\u0012J\b\u0010c\u001a\u00020\u0013H\u0002J\u000e\u0010d\u001a\u00020\u00132\u0006\u0010e\u001a\u00020\u0012J\u0018\u0010f\u001a\u00020\u00132\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010)J\b\u0010g\u001a\u00020\u0013H\u0002J\u0010\u0010h\u001a\u00020\u00132\u0006\u0010i\u001a\u00020\u000bH\u0004J\u000e\u0010j\u001a\u00020\u00132\u0006\u0010k\u001a\u00020\u000fJ\u000e\u0010l\u001a\u00020\u00132\u0006\u0010m\u001a\u00020\u000fJ\u0016\u0010n\u001a\u00020\u00132\u0006\u0010B\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\u000fJ\u0016\u0010o\u001a\u00020\u00132\u0006\u0010B\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\u000fJ\u000e\u0010p\u001a\u00020\u00132\u0006\u0010q\u001a\u00020rJ\b\u0010N\u001a\u00020\u0013H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\n 0*\u0004\u0018\u00010/0/X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u0010\u0004R\u000e\u00104\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000¨\u0006t"}, hxF = {"Lcom/tencent/mm/media/remuxer/CodecInputSurface;", "", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "TAG", "", "blendBitmap", "Landroid/graphics/Bitmap;", "blendBitmapProvider", "Lkotlin/Function1;", "", "blurBgBitmapProvider", "blurBgdBitmap", "continueZeroPtsFrameCount", "", "currentRenderPtsNs", "drawCallback", "", "", "getDrawCallback", "()Lkotlin/jvm/functions/Function1;", "setDrawCallback", "(Lkotlin/jvm/functions/Function1;)V", "drawInOnFrameAvailable", "drawInOnFrameAvailableLock", "Ljava/lang/Object;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEglEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEglEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "firstFrame", "isFirstFrameAvailable", "isReleased", "lastFrameTimestamp", "lastPts", "newFrameAvailable", "newFrameLock", "onDrawFrameOnFrameAvailableFailed", "Lkotlin/Function0;", "ptsStepUs", "remuxStartTime", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "setUpEnvWithShareContext", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getCurrentRenderPtsNs", "getEGLEnvironment", "getOutputSurface", "initForRemuxer", "canUseDrawInFrameAvailable", "width", "height", "startTime", "callback", "Lkotlin/ParameterName;", "name", "success", "initSurfaceTexture", "initWithSize", "eglContext", "Landroid/opengl/EGLContext;", "initWithSurface", "waitNewFrame", "isDrawInOnFrameAvailable", "queue", "queueFirst", "release", "requestDraw", "data", "", "pts", "inputCallback", "textureId", "bitmap", "waitFistFrameAvailable", "blurBg", "requestDrawInGLThread", "runInGlesThread", "setDrawBlendBitmap", "setDrawBlendBitmapProvider", "setDrawBlurBgBitmapProvider", "setDrawInOnFrameAvailable", "draw", "setFirstFrameAvailable", "setMirror", "mirror", "setOnDrawFrameOnFrameAvailableFailed", "setOnFrameAvailable", "setPresentationTime", "nsecs", "setRotate", "degree", "setVideoFps", "fps", "updateDrawSize", "updateTextureSize", "updateTextureSizeByMediaFormat", "mediaFormat", "Landroid/media/MediaFormat;", "Companion", "plugin-mediaeditor_release"})
public final class a {
    public static final C0417a iht = new C0417a((byte) 0);
    public final String TAG = "MicroMsg.CodecInputSurface";
    c.b hDs;
    private long idR;
    private final HandlerThread igZ = com.tencent.f.c.d.hC("CodecInputSurface_renderThread", 5);
    private MMHandler iha;
    public kotlin.g.a.b<? super Boolean, x> ihb;
    private final Object ihc = new Object();
    private boolean ihd;
    private volatile boolean ihe;
    private kotlin.g.a.b<? super Long, Bitmap> ihf;
    Bitmap ihg;
    private kotlin.g.a.b<? super Long, Bitmap> ihh;
    private Bitmap ihi;
    private volatile boolean ihj;
    private final Object ihk = new Object();
    kotlin.g.a.a<x> ihl;
    int ihm = 33000000;
    private int ihn;
    private long iho;
    volatile long ihp;
    private boolean ihq;
    private long ihr;
    public com.tencent.mm.media.j.a ihs;
    private volatile boolean isReleased;
    public Surface surface;
    private SurfaceTexture surfaceTexture;

    static {
        AppMethodBeat.i(93759);
        AppMethodBeat.o(93759);
    }

    public a(com.tencent.mm.media.j.a aVar) {
        p.h(aVar, "renderer");
        AppMethodBeat.i(93758);
        this.ihs = aVar;
        this.igZ.start();
        HandlerThread handlerThread = this.igZ;
        p.g(handlerThread, "renderThread");
        this.iha = new MMHandler(handlerThread.getLooper());
        this.ihq = true;
        AppMethodBeat.o(93758);
    }

    public static final /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(93760);
        aVar.aMF();
        AppMethodBeat.o(93760);
    }

    public final void a(Surface surface2, boolean z, int i2, int i3, long j2, kotlin.g.a.b<? super Boolean, x> bVar) {
        AppMethodBeat.i(218750);
        this.surface = surface2;
        eW(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_remuxer_with_surface_timestamp, 0) == 1);
        Log.i(this.TAG, hashCode() + " initForRemuxer, surface:" + surface2 + ", callback:false, drawInOnFrameAvailable:" + this.ihj);
        if (WeChatEnvironment.hasDebugger()) {
            Log.i(this.TAG, "in debug environment, set drawInOnFrameAvailable to true");
            eW(true);
        }
        if (!z) {
            Log.i(this.TAG, "cannot use drawInFrameAvailable!");
            eW(false);
        }
        this.ihn = 0;
        this.iho = j2;
        k(new b(this, surface2, i2, i3, bVar));
        AppMethodBeat.o(218750);
    }

    public final void i(kotlin.g.a.b<? super Long, Bitmap> bVar) {
        AppMethodBeat.i(93742);
        Log.i(this.TAG, "setDrawBlendBitmapProvider:" + (bVar != null ? bVar.hashCode() : 0));
        this.ihf = bVar;
        AppMethodBeat.o(93742);
    }

    public final void j(kotlin.g.a.b<? super Long, Bitmap> bVar) {
        AppMethodBeat.i(93743);
        Log.i(this.TAG, "setDrawBlurBgBitmapProvider:" + (bVar != null ? bVar.hashCode() : 0));
        this.ihh = bVar;
        AppMethodBeat.o(93743);
    }

    public static /* synthetic */ void a(a aVar, long j2, Bitmap bitmap) {
        AppMethodBeat.i(93745);
        aVar.a(j2, bitmap, (Bitmap) null);
        AppMethodBeat.o(93745);
    }

    public final void a(long j2, Bitmap bitmap, Bitmap bitmap2) {
        AppMethodBeat.i(93744);
        k(new f(this, true, j2, bitmap, bitmap2));
        AppMethodBeat.o(93744);
    }

    public final void a(byte[] bArr, long j2, kotlin.g.a.b<? super byte[], x> bVar) {
        AppMethodBeat.i(93746);
        p.h(bArr, "data");
        p.h(bVar, "inputCallback");
        Log.d(this.TAG, "ByteArray length : " + bArr.length);
        k(new g(this, bArr, j2, bVar));
        AppMethodBeat.o(93746);
    }

    public final void x(int i2, long j2) {
        AppMethodBeat.i(93747);
        k(new h(this, i2, j2));
        AppMethodBeat.o(93747);
    }

    public final Surface aME() {
        AppMethodBeat.i(93748);
        if (this.surfaceTexture == null) {
            aMF();
        }
        Surface surface2 = new Surface(this.surfaceTexture);
        AppMethodBeat.o(93748);
        return surface2;
    }

    public final void cX(int i2, int i3) {
        AppMethodBeat.i(93749);
        this.ihs.cY(i2, i3);
        AppMethodBeat.o(93749);
    }

    public final void cZ(int i2, int i3) {
        AppMethodBeat.i(93750);
        this.ihs.cZ(i2, i3);
        AppMethodBeat.o(93750);
    }

    public final void e(MediaFormat mediaFormat) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(93751);
        p.h(mediaFormat, "mediaFormat");
        com.tencent.mm.media.j.a aVar = this.ihs;
        p.h(mediaFormat, "format");
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_handle_media_format_change, true)) {
            if (mediaFormat.containsKey("width") && mediaFormat.containsKey("height")) {
                aVar.hDn = mediaFormat.getInteger("width");
                aVar.hDo = mediaFormat.getInteger("height");
                com.tencent.mm.media.j.b.a aVar2 = aVar.ijo;
                if (aVar2 != null) {
                    aVar2.cZ(aVar.hDn, aVar.hDo);
                }
            }
            int i4 = aVar.hDo;
            int i5 = aVar.hDn;
            if (mediaFormat.containsKey("crop-left")) {
                i2 = mediaFormat.getInteger("crop-left");
            } else {
                i2 = 0;
            }
            if (mediaFormat.containsKey("crop-top")) {
                i3 = mediaFormat.getInteger("crop-top");
            }
            if (mediaFormat.containsKey("crop-right")) {
                i5 = mediaFormat.getInteger("crop-right") + 1;
            }
            if (mediaFormat.containsKey("crop-bottom")) {
                i4 = mediaFormat.getInteger("crop-bottom") + 1;
            }
            Log.i("MicroMsg.Media.AbsSurfaceRenderer", "updateTextureSizeByMediaFormat:textureWidth->" + aVar.hDn + " textureHeight->" + aVar.hDo + " validLeft->" + i2 + " validTop->" + i4 + " validRight->" + i5 + "  validBottom -> " + i3);
            com.tencent.mm.media.j.b.a aVar3 = aVar.ijo;
            if (aVar3 != null) {
                Point point = new Point(i2, i4 + 1);
                Point point2 = new Point(i5 + 1, i3);
                p.h(point, "leftTop");
                p.h(point2, "rightBottom");
                aVar3.ijS = point;
                aVar3.ijT = point2;
                AppMethodBeat.o(93751);
                return;
            }
        }
        AppMethodBeat.o(93751);
    }

    public final void qx(int i2) {
        AppMethodBeat.i(93752);
        this.ihs.qx(i2);
        AppMethodBeat.o(93752);
    }

    public final void k(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(93753);
        HandlerThread handlerThread = this.igZ;
        p.g(handlerThread, "renderThread");
        if (!handlerThread.isAlive() || this.isReleased) {
            Log.e(this.TAG, hashCode() + " queue already release");
            AppMethodBeat.o(93753);
            return;
        }
        this.iha.post(new b(aVar));
        AppMethodBeat.o(93753);
    }

    private final void aMF() {
        AppMethodBeat.i(93754);
        this.surfaceTexture = this.ihs.getTexture();
        AppMethodBeat.o(93754);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable"})
    public static final class k implements SurfaceTexture.OnFrameAvailableListener {
        final /* synthetic */ a ihu;

        k(a aVar) {
            this.ihu = aVar;
        }

        public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Long l;
            a aVar;
            long j2;
            Bitmap bitmap;
            Bitmap bitmap2;
            AppMethodBeat.i(93740);
            String str = this.ihu.TAG;
            StringBuilder append = new StringBuilder("onFrameAvailable, thread:").append(Thread.currentThread()).append(", surface timestamp:");
            SurfaceTexture surfaceTexture2 = this.ihu.surfaceTexture;
            if (surfaceTexture2 != null) {
                l = Long.valueOf(surfaceTexture2.getTimestamp());
            } else {
                l = null;
            }
            Log.i(str, append.append(l).append(", drawInOnFrameAvailable:").append(this.ihu.ihj).toString());
            SurfaceTexture surfaceTexture3 = this.ihu.surfaceTexture;
            if (surfaceTexture3 != null) {
                if (surfaceTexture3.getTimestamp() <= 0) {
                    this.ihu.ihn++;
                } else {
                    this.ihu.ihn = 0;
                }
                if (!this.ihu.ihe || surfaceTexture3.getTimestamp() > 0) {
                    this.ihu.idR = surfaceTexture3.getTimestamp();
                } else {
                    Log.i(this.ihu.TAG, "first frame available and new timestamp still zero!!");
                    if (this.ihu.ihn >= 3) {
                        Log.i(this.ihu.TAG, "continue 3 frames pts is zero!!!");
                        this.ihu.ihj = false;
                        kotlin.g.a.a aVar2 = this.ihu.ihl;
                        if (aVar2 != null) {
                            aVar2.invoke();
                            AppMethodBeat.o(93740);
                            return;
                        }
                        AppMethodBeat.o(93740);
                        return;
                    }
                }
                if (!this.ihu.ihe) {
                    this.ihu.ihe = true;
                }
                if (this.ihu.ihj) {
                    if (this.ihu.ihg != null) {
                        a aVar3 = this.ihu;
                        j2 = this.ihu.idR;
                        bitmap = this.ihu.ihg;
                        bitmap2 = this.ihu.ihi;
                        aVar = aVar3;
                    } else {
                        aVar = this.ihu;
                        j2 = this.ihu.idR;
                        kotlin.g.a.b bVar = this.ihu.ihf;
                        bitmap = bVar != null ? (Bitmap) bVar.invoke(Long.valueOf(surfaceTexture3.getTimestamp() / 1000)) : null;
                        kotlin.g.a.b bVar2 = this.ihu.ihh;
                        bitmap2 = bVar2 != null ? (Bitmap) bVar2.invoke(Long.valueOf(surfaceTexture3.getTimestamp() / 1000)) : null;
                    }
                    a.a(aVar, j2, bitmap, bitmap2);
                }
                AppMethodBeat.o(93740);
                return;
            }
            AppMethodBeat.o(93740);
        }
    }

    private void eW(boolean z) {
        AppMethodBeat.i(93755);
        synchronized (this.ihk) {
            try {
                this.ihj = z;
                Log.i(this.TAG, "setDrawInOnFrameAvailable:".concat(String.valueOf(z)));
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(93755);
            }
        }
    }

    public final void release() {
        AppMethodBeat.i(93756);
        Log.i(this.TAG, hashCode() + " release resources");
        e eVar = new e(this);
        HandlerThread handlerThread = this.igZ;
        p.g(handlerThread, "renderThread");
        if (!handlerThread.isAlive() || this.isReleased) {
            Log.e(this.TAG, hashCode() + " queueFirst already release");
        } else {
            this.iha.removeCallbacksAndMessages(null);
            this.iha.post(new b(eVar));
        }
        this.isReleased = true;
        AppMethodBeat.o(93756);
    }

    /* access modifiers changed from: protected */
    public final void setPresentationTime(long j2) {
        AppMethodBeat.i(93757);
        c.b bVar = this.hDs;
        if (bVar != null) {
            EGLExt.eglPresentationTimeANDROID(bVar.ilu, bVar.eglSurface, j2);
        }
        this.ihp = j2;
        c.a aVar = com.tencent.mm.media.k.c.ilt;
        c.a.Hq("eglPresentationTimeANDROID");
        AppMethodBeat.o(93757);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/media/remuxer/CodecInputSurface$Companion;", "", "()V", "TIME_COST_TAG", "", "ZERO_FRAME_FAILED_THRESHOLD", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.i.a$a  reason: collision with other inner class name */
    public static final class C0417a {
        private C0417a() {
        }

        public /* synthetic */ C0417a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ a ihu;
        final /* synthetic */ Surface ihv;
        final /* synthetic */ EGLContext ihw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar, EGLContext eGLContext, Surface surface, kotlin.g.a.b bVar) {
            super(0);
            this.ihu = aVar;
            this.ihw = eGLContext;
            this.ihv = surface;
            this.gWe = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(93733);
            try {
                if (this.ihw == null) {
                    this.ihu.ihd = false;
                    this.ihu.hDs = c.a.a(com.tencent.mm.media.k.c.ilt, this.ihv, 0, 0, null, 30);
                    this.ihu.ihs.eY(true);
                    a.a(this.ihu);
                } else {
                    this.ihu.ihd = true;
                    a aVar = this.ihu;
                    c.a aVar2 = com.tencent.mm.media.k.c.ilt;
                    aVar.hDs = c.a.a(this.ihw, this.ihv, 0, 0);
                    this.ihu.ihs.eY(false);
                }
                kotlin.g.a.b bVar = this.gWe;
                if (bVar != null) {
                    bVar.invoke(Boolean.TRUE);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace(this.ihu.TAG, e2, "initWithSurface failed", new Object[0]);
                kotlin.g.a.b bVar2 = this.gWe;
                if (bVar2 != null) {
                    bVar2.invoke(Boolean.FALSE);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(93733);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int cKE;
        final /* synthetic */ int cKF;
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ a ihu;
        final /* synthetic */ Surface ihv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar, Surface surface, int i2, int i3, kotlin.g.a.b bVar) {
            super(0);
            this.ihu = aVar;
            this.ihv = surface;
            this.cKE = i2;
            this.cKF = i3;
            this.gWe = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(93731);
            try {
                this.ihu.ihd = false;
                this.ihu.hDs = c.a.a(com.tencent.mm.media.k.c.ilt, this.ihv, this.cKE, this.cKF, null, 18);
                this.ihu.ihs.eY(true);
                a.a(this.ihu);
                a.c(this.ihu);
                kotlin.g.a.b bVar = this.gWe;
                if (bVar != null) {
                    bVar.invoke(Boolean.TRUE);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace(this.ihu.TAG, e2, "initWithSurface failed", new Object[0]);
                kotlin.g.a.b bVar2 = this.gWe;
                if (bVar2 != null) {
                    bVar2.invoke(Boolean.FALSE);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(93731);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int cKE;
        final /* synthetic */ int cKF;
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ a ihu;
        final /* synthetic */ EGLContext ihw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar, EGLContext eGLContext, int i2, int i3, kotlin.g.a.b bVar) {
            super(0);
            this.ihu = aVar;
            this.ihw = eGLContext;
            this.cKE = i2;
            this.cKF = i3;
            this.gWe = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(93732);
            try {
                if (this.ihw == null) {
                    this.ihu.ihd = false;
                    this.ihu.hDs = c.a.a(com.tencent.mm.media.k.c.ilt, null, this.cKE, this.cKF, null, 16);
                    this.ihu.ihs.eY(true);
                    a.a(this.ihu);
                } else {
                    this.ihu.ihd = true;
                    a aVar = this.ihu;
                    c.a aVar2 = com.tencent.mm.media.k.c.ilt;
                    aVar.hDs = c.a.a(this.ihw, (Object) null, this.cKE, this.cKF);
                    this.ihu.ihs.eY(false);
                }
                Log.i(this.ihu.TAG, this.ihu.hashCode() + " initWithSize finish");
                kotlin.g.a.b bVar = this.gWe;
                if (bVar != null) {
                    bVar.invoke(Boolean.TRUE);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace(this.ihu.TAG, e2, "initWithSize error!", new Object[0]);
                kotlin.g.a.b bVar2 = this.gWe;
                if (bVar2 != null) {
                    bVar2.invoke(Boolean.FALSE);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(93732);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Bitmap cKG;
        final /* synthetic */ a ihu;
        final /* synthetic */ boolean ihx = true;
        final /* synthetic */ long ihy;
        final /* synthetic */ Bitmap ihz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(a aVar, boolean z, long j2, Bitmap bitmap, Bitmap bitmap2) {
            super(0);
            this.ihu = aVar;
            this.ihy = j2;
            this.cKG = bitmap;
            this.ihz = bitmap2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(93735);
            if (!this.ihx || this.ihu.ihe) {
                try {
                    Log.d(this.ihu.TAG, "render pts:" + this.ihy);
                    long currentTicks = Util.currentTicks();
                    if (this.ihu.ihs instanceof com.tencent.mm.media.j.c) {
                        com.tencent.mm.media.j.a aVar = this.ihu.ihs;
                        if (aVar == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.media.render.MixRenderer");
                            AppMethodBeat.o(93735);
                            throw tVar;
                        }
                        ((com.tencent.mm.media.j.c) aVar).a(this.cKG, this.ihz);
                    }
                    Log.d(this.ihu.TAG, "render cost " + Util.ticksToNow(currentTicks));
                    long currentTicks2 = Util.currentTicks();
                    if (this.ihu.surface != null) {
                        this.ihu.setPresentationTime(this.ihy);
                        c.b bVar = this.ihu.hDs;
                        if (bVar != null) {
                            c.a aVar2 = com.tencent.mm.media.k.c.ilt;
                            c.a.a(bVar.ilu, bVar.eglSurface);
                        }
                        Log.d(this.ihu.TAG, "swap buffer cost " + Util.ticksToNow(currentTicks2));
                    }
                    kotlin.g.a.b<? super Boolean, x> bVar2 = this.ihu.ihb;
                    if (bVar2 != null) {
                        bVar2.invoke(Boolean.TRUE);
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace(this.ihu.TAG, e2, "", new Object[0]);
                    kotlin.g.a.b<? super Boolean, x> bVar3 = this.ihu.ihb;
                    if (bVar3 != null) {
                        bVar3.invoke(Boolean.FALSE);
                    }
                }
            } else {
                Log.i(this.ihu.TAG, "waitFistFrameAvailable and not firstFrameAvailable now, ignore");
                kotlin.g.a.b<? super Boolean, x> bVar4 = this.ihu.ihb;
                if (bVar4 != null) {
                    bVar4.invoke(Boolean.TRUE);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(93735);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ byte[] ihA;
        final /* synthetic */ kotlin.g.a.b ihB;
        final /* synthetic */ a ihu;
        final /* synthetic */ long ihy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(a aVar, byte[] bArr, long j2, kotlin.g.a.b bVar) {
            super(0);
            this.ihu = aVar;
            this.ihA = bArr;
            this.ihy = j2;
            this.ihB = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(93736);
            try {
                com.tencent.mm.media.j.a.a(this.ihu.ihs, this.ihA);
                this.ihu.ihs.aED();
                if (this.ihu.surface != null) {
                    this.ihu.setPresentationTime(this.ihy);
                    c.b bVar = this.ihu.hDs;
                    if (bVar != null) {
                        c.a aVar = com.tencent.mm.media.k.c.ilt;
                        c.a.a(bVar.ilu, bVar.eglSurface);
                    }
                }
                kotlin.g.a.b<? super Boolean, x> bVar2 = this.ihu.ihb;
                if (bVar2 != null) {
                    bVar2.invoke(Boolean.TRUE);
                }
                this.ihB.invoke(this.ihA);
            } catch (Exception e2) {
                com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aNK();
                Log.printErrStackTrace(this.ihu.TAG, e2, "", new Object[0]);
                kotlin.g.a.b<? super Boolean, x> bVar3 = this.ihu.ihb;
                if (bVar3 != null) {
                    bVar3.invoke(Boolean.FALSE);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(93736);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int ihC;
        final /* synthetic */ a ihu;
        final /* synthetic */ long ihy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(a aVar, int i2, long j2) {
            super(0);
            this.ihu = aVar;
            this.ihC = i2;
            this.ihy = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(93737);
            try {
                this.ihu.ihs.input(this.ihC);
                this.ihu.ihs.aED();
                if (this.ihu.surface != null) {
                    this.ihu.setPresentationTime(this.ihy);
                    c.b bVar = this.ihu.hDs;
                    if (bVar != null) {
                        c.a aVar = com.tencent.mm.media.k.c.ilt;
                        c.a.a(bVar.ilu, bVar.eglSurface);
                    }
                }
                kotlin.g.a.b<? super Boolean, x> bVar2 = this.ihu.ihb;
                if (bVar2 != null) {
                    bVar2.invoke(Boolean.TRUE);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace(this.ihu.TAG, e2, "", new Object[0]);
                kotlin.g.a.b<? super Boolean, x> bVar3 = this.ihu.ihb;
                if (bVar3 != null) {
                    bVar3.invoke(Boolean.FALSE);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(93737);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ SurfaceTexture ihD;
        final /* synthetic */ a ihu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(a aVar, SurfaceTexture surfaceTexture) {
            super(0);
            this.ihu = aVar;
            this.ihD = surfaceTexture;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            int i2;
            int i3 = -1;
            AppMethodBeat.i(93738);
            try {
                SurfaceTexture surfaceTexture = this.ihD;
                com.tencent.mm.media.g.d dVar = this.ihu.ihs.ijq;
                if (dVar != null) {
                    i2 = dVar.igv;
                } else {
                    i2 = -1;
                }
                surfaceTexture.attachToGLContext(i2);
                this.ihD.updateTexImage();
                com.tencent.mm.media.j.a aVar = this.ihu.ihs;
                com.tencent.mm.media.g.d dVar2 = this.ihu.ihs.ijq;
                if (dVar2 != null) {
                    i3 = dVar2.igv;
                }
                aVar.input(i3);
                this.ihu.ihs.aED();
                if (this.ihu.surface != null) {
                    this.ihu.setPresentationTime(System.nanoTime());
                    c.b bVar = this.ihu.hDs;
                    if (bVar != null) {
                        c.a aVar2 = com.tencent.mm.media.k.c.ilt;
                        c.a.a(bVar.ilu, bVar.eglSurface);
                    }
                }
                this.ihD.detachFromGLContext();
                kotlin.g.a.b<? super Boolean, x> bVar2 = this.ihu.ihb;
                if (bVar2 != null) {
                    bVar2.invoke(Boolean.TRUE);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace(this.ihu.TAG, e2, "", new Object[0]);
                kotlin.g.a.b<? super Boolean, x> bVar3 = this.ihu.ihb;
                if (bVar3 != null) {
                    bVar3.invoke(Boolean.FALSE);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(93738);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a ihu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(a aVar) {
            super(0);
            this.ihu = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(93734);
            Log.i(this.ihu.TAG, this.ihu.hashCode() + " do release resources");
            this.ihu.ihs.release(true);
            c.b bVar = this.ihu.hDs;
            if (bVar != null) {
                c.a aVar = com.tencent.mm.media.k.c.ilt;
                c.a.a(bVar);
            }
            Surface surface = this.ihu.surface;
            if (surface != null) {
                surface.release();
            }
            this.ihu.iha.removeCallbacksAndMessages(null);
            this.ihu.igZ.quitSafely();
            x xVar = x.SXb;
            AppMethodBeat.o(93734);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class j extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ kotlin.g.a.a ihE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(kotlin.g.a.a aVar) {
            super(0);
            this.ihE = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            AppMethodBeat.i(218749);
            this.ihE.invoke();
            x xVar = x.SXb;
            AppMethodBeat.o(218749);
            return xVar;
        }
    }

    public static final /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(93761);
        SurfaceTexture surfaceTexture2 = aVar.surfaceTexture;
        if (surfaceTexture2 != null) {
            surfaceTexture2.setOnFrameAvailableListener(new k(aVar));
            AppMethodBeat.o(93761);
            return;
        }
        AppMethodBeat.o(93761);
    }

    public static final /* synthetic */ void a(a aVar, long j2, Bitmap bitmap, Bitmap bitmap2) {
        c.b bVar;
        AppMethodBeat.i(93762);
        try {
            Log.i(aVar.TAG, "render pts:".concat(String.valueOf(j2)));
            long currentTicks = Util.currentTicks();
            if (aVar.ihs instanceof com.tencent.mm.media.j.c) {
                com.tencent.mm.media.j.a aVar2 = aVar.ihs;
                if (aVar2 == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.media.render.MixRenderer");
                    AppMethodBeat.o(93762);
                    throw tVar;
                }
                ((com.tencent.mm.media.j.c) aVar2).a(bitmap, bitmap2);
            }
            String str = aVar.TAG;
            StringBuilder append = new StringBuilder("render cost ").append(Util.ticksToNow(currentTicks)).append(", surface timestamp:");
            SurfaceTexture surfaceTexture2 = aVar.surfaceTexture;
            Log.d(str, append.append(surfaceTexture2 != null ? Long.valueOf(surfaceTexture2.getTimestamp()) : null).append(", lastFrameTimestamp:").append(aVar.ihr).toString());
            if (aVar.surfaceTexture != null && aVar.ihe) {
                long j3 = aVar.ihr;
                SurfaceTexture surfaceTexture3 = aVar.surfaceTexture;
                Long valueOf = surfaceTexture3 != null ? Long.valueOf(surfaceTexture3.getTimestamp()) : null;
                if (valueOf == null) {
                    p.hyc();
                }
                if (j3 > valueOf.longValue()) {
                    Log.e(aVar.TAG, "not stickily monotonic increase timestamp");
                    aVar.ihj = false;
                    kotlin.g.a.a<x> aVar3 = aVar.ihl;
                    if (aVar3 != null) {
                        aVar3.invoke();
                        AppMethodBeat.o(93762);
                        return;
                    }
                    AppMethodBeat.o(93762);
                    return;
                }
            }
            SurfaceTexture surfaceTexture4 = aVar.surfaceTexture;
            aVar.ihp = surfaceTexture4 != null ? surfaceTexture4.getTimestamp() : 0;
            long currentTicks2 = Util.currentTicks();
            if (aVar.surfaceTexture != null) {
                SurfaceTexture surfaceTexture5 = aVar.surfaceTexture;
                Long valueOf2 = surfaceTexture5 != null ? Long.valueOf(surfaceTexture5.getTimestamp()) : null;
                if (valueOf2 == null) {
                    p.hyc();
                }
                long longValue = valueOf2.longValue();
                long j4 = aVar.ihr;
                SurfaceTexture surfaceTexture6 = aVar.surfaceTexture;
                if (surfaceTexture6 != null && j4 == surfaceTexture6.getTimestamp()) {
                    Log.i(aVar.TAG, "same frame timestamp!!");
                    longValue = j2;
                }
                aVar.ihr = longValue;
                if (aVar.surface != null) {
                    if (aVar.iho > 0) {
                        longValue -= aVar.iho * TimeUtil.SECOND_TO_US;
                    }
                    aVar.setPresentationTime(longValue);
                }
            } else if (aVar.surface != null) {
                if (aVar.iho > 0) {
                    j2 -= aVar.iho * TimeUtil.SECOND_TO_US;
                }
                aVar.setPresentationTime(j2);
            }
            if (!(aVar.surface == null || (bVar = aVar.hDs) == null)) {
                c.a aVar4 = com.tencent.mm.media.k.c.ilt;
                c.a.a(bVar.ilu, bVar.eglSurface);
            }
            Log.d(aVar.TAG, "swap buffer cost " + Util.ticksToNow(currentTicks2));
            kotlin.g.a.b<? super Boolean, x> bVar2 = aVar.ihb;
            if (bVar2 != null) {
                bVar2.invoke(Boolean.TRUE);
                AppMethodBeat.o(93762);
                return;
            }
            AppMethodBeat.o(93762);
        } catch (Exception e2) {
            Log.printErrStackTrace(aVar.TAG, e2, "", new Object[0]);
            kotlin.g.a.b<? super Boolean, x> bVar3 = aVar.ihb;
            if (bVar3 != null) {
                bVar3.invoke(Boolean.FALSE);
                AppMethodBeat.o(93762);
                return;
            }
            AppMethodBeat.o(93762);
        }
    }
}

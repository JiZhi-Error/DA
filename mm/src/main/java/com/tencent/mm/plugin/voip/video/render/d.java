package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES30;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.media.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 }2\u00020\u0001:\u0001}B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010Y\u001a\u0002032\b\u0010M\u001a\u0004\u0018\u00010&2\u0006\u0010G\u001a\u00020\u0005J6\u0010Z\u001a\u0002032\u0016\b\u0002\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u000203\u0018\u00010/2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]2\b\b\u0002\u0010^\u001a\u00020\u0003H&J\u000e\u0010_\u001a\u0002032\u0006\u0010\u0002\u001a\u00020\u0003J\u0012\u0010`\u001a\u0002032\b\b\u0002\u0010a\u001a\u00020\u0003H&J(\u0010b\u001a\u0002032\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\u00052\u0006\u0010f\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\u0005H&J*\u0010b\u001a\u0002032\b\u0010c\u001a\u0004\u0018\u00010h2\u0006\u0010e\u001a\u00020\u00052\u0006\u0010f\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\u0005H&J\u0014\u0010i\u001a\u0002032\f\u0010[\u001a\b\u0012\u0004\u0012\u00020309J\u0006\u0010j\u001a\u000203J\u0018\u0010k\u001a\u0002032\b\u0010M\u001a\u0004\u0018\u00010&2\u0006\u0010G\u001a\u00020\u0005J\b\u0010l\u001a\u000203H\u0002J\u000e\u0010m\u001a\u0002032\u0006\u0010n\u001a\u00020\u0019J\u0010\u0010o\u001a\u0002032\b\u0010n\u001a\u0004\u0018\u00010\u0019J\u000e\u0010p\u001a\u0002032\u0006\u0010q\u001a\u00020\u0005J\u0006\u0010r\u001a\u000203J\u0012\u0010s\u001a\u0002032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010&J\u0006\u0010t\u001a\u000203J\u0018\u0010u\u001a\u0002032\b\u0010v\u001a\u0004\u0018\u00010&2\u0006\u0010G\u001a\u00020\u0005J9\u0010w\u001a\u0002032\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010x\u001a\u00020y2\n\b\u0002\u0010z\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010{\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010|R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0015\"\u0004\b*\u0010\u0017R\u001a\u0010+\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R9\u0010.\u001a!\u0012\u0013\u0012\u00110 ¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0006\u0012\u0004\u0018\u000103\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u00108\u001a\f\u0012\u0006\u0012\u0004\u0018\u000103\u0018\u000109X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R9\u0010>\u001a!\u0012\u0013\u0012\u00110 ¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0006\u0012\u0004\u0018\u000103\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00105\"\u0004\b@\u00107R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0015\"\u0004\bI\u0010\u0017R\u000e\u0010J\u001a\u00020KX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010M\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001c\u0010S\u001a\u0004\u0018\u00010TX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010X¨\u0006~"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "", "mIsRenderLocal", "", "hashCode", "", "(ZI)V", "canRender", "getCanRender", "()Z", "setCanRender", "(Z)V", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEGLEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEGLEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHashCode", "()I", "setHashCode", "(I)V", "inputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getInputTexture", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setInputTexture", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "isRelease", "mDrawPerFrameStartTimes", "", "getMDrawPerFrameStartTimes", "()J", "setMDrawPerFrameStartTimes", "(J)V", "mLocalRenderSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "mRemoteRenderSurface", "mShareHeight", "getMShareHeight", "setMShareHeight", "mShareWidth", "getMShareWidth", "setMShareWidth", "onDrawPrcoEndYUVCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cost", "", "getOnDrawPrcoEndYUVCallback", "()Lkotlin/jvm/functions/Function1;", "setOnDrawPrcoEndYUVCallback", "(Lkotlin/jvm/functions/Function1;)V", "onDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "getOnDrawProcEndAfterViewAddCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDrawProcEndAfterViewAddCallback", "(Lkotlin/jvm/functions/Function0;)V", "onDrawProcPerFrameCost", "getOnDrawProcPerFrameCost", "setOnDrawProcPerFrameCost", "renderProc", "Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;", "getRenderProc", "()Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;", "setRenderProc", "(Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;)V", "renderSide", "getRenderSide", "setRenderSide", "renderThread", "Landroid/os/HandlerThread;", "rendering", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "addRenderSurface", "checkInit", "callback", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "needRefresh", "choiceRenderSurface", "createEGLContext", "isUseShareContext", "drawFrame", "pBuff", "", "w", "h", "flag", "", "queue", "release", "removeSurface", "render", "requestRender", "texture", "setInputExternalTexture", "setShowMode", "mode", "startRender", "stopRender", "switchRenderSurface", "updateDrawViewSize", "outputSurface", "updateRendererSize", "renderSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "rotateDegree", "mIsMirror", "(Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;Lcom/tencent/mm/compatible/deviceinfo/Size;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "Companion", "plugin-voip_release"})
public abstract class d {
    public static final a Hno = new a((byte) 0);
    long HiP = -1;
    public com.tencent.mm.media.g.d Hko;
    kotlin.g.a.a<x> Hnc;
    kotlin.g.a.b<? super Long, x> Hnd;
    kotlin.g.a.b<? super Long, x> Hne;
    private boolean Hnf;
    boolean Hng;
    private f Hnh;
    private f Hni;
    public l Hnj;
    int Hnk;
    int Hnl;
    int Hnm;
    private boolean Hnn;
    private int aHK;
    private MMHandler handler;
    private boolean ife;
    private final HandlerThread igZ;
    c.b ilw;
    Surface surface;
    SurfaceTexture surfaceTexture;

    public abstract void a(g gVar, ac acVar, Integer num, Boolean bool);

    public abstract void a(kotlin.g.a.b<? super d, x> bVar, g gVar, boolean z);

    public abstract void xz(boolean z);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer$Companion;", "", "()V", "TAG", "", "plugin-voip_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public d(boolean z, int i2) {
        int i3 = 0;
        this.Hnn = z;
        this.aHK = i2;
        HandlerThread hC = com.tencent.f.c.d.hC("WindowSurfaceRenderer_renderThread_" + this.aHK, 5);
        p.g(hC, "SpecialThreadFactory.cre…e\", Thread.NORM_PRIORITY)");
        this.igZ = hC;
        this.igZ.start();
        this.handler = new MMHandler(this.igZ.getLooper());
        this.Hnf = false;
        this.ife = false;
        this.Hnm = !this.Hnn ? 1 : i3;
    }

    public final void fLQ() {
        Log.printInfoStack("MicroMsg.WindowSurfaceRenderer", "switchRenderSurface", new Object[0]);
        k(new i(this));
    }

    public final void xA(boolean z) {
        k(new b(this, z));
    }

    public final void a(f fVar, int i2) {
        if (i2 == 0) {
            this.Hnh = fVar;
        } else {
            this.Hni = fVar;
        }
    }

    public final void a(com.tencent.mm.media.g.d dVar) {
        if (dVar != null) {
            k(new f(this, dVar));
        }
    }

    public final void b(f fVar, int i2) {
        if (fVar != null) {
            Log.printInfoStack("MicroMsg.WindowSurfaceRenderer", "add render surface renderSide " + i2 + " and :" + fVar, new Object[0]);
            if (i2 == 0) {
                this.Hnh = fVar;
            } else {
                this.Hni = fVar;
            }
        } else {
            Log.e("MicroMsg.WindowSurfaceRenderer", "add a null surface");
        }
    }

    public final void c(f fVar, int i2) {
        k(new C1896d(this, fVar, i2));
    }

    public final void fLR() {
        k(new g(this));
    }

    public final void k(kotlin.g.a.a<x> aVar) {
        MMHandler mMHandler;
        p.h(aVar, "callback");
        if (this.igZ.isAlive() && (mMHandler = this.handler) != null) {
            mMHandler.post(new e(aVar));
        }
    }

    public final void a(f fVar) {
        if (p.j(fVar, this.Hnh) || p.j(fVar, this.Hni) || fVar == null) {
            k(new h(this));
        }
    }

    public final void b(com.tencent.mm.media.g.d dVar) {
        p.h(dVar, "texture");
        if (this.Hnf) {
            l lVar = this.Hnj;
            if (lVar != null) {
                lVar.hDl = dVar.igv;
            }
            k(new e(this));
        }
    }

    public final void setShowMode(int i2) {
        l lVar = this.Hnj;
        if (lVar != null) {
            lVar.hEi = i2;
        }
    }

    public final void release() {
        Log.i("MicroMsg.WindowSurfaceRenderer", "onSurfaceTextureDestroyed");
        MMHandler mMHandler = this.handler;
        if (mMHandler != null) {
            mMHandler.removeCallbacksAndMessages(null);
        }
        k(new c(this));
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d Hnp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(d dVar) {
            super(0);
            this.Hnp = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            EGLDisplay eGLDisplay;
            boolean z;
            EGLContext eGLContext = null;
            AppMethodBeat.i(236207);
            this.Hnp.Hnf = false;
            c.b bVar = this.Hnp.ilw;
            if (bVar != null) {
                eGLDisplay = bVar.ilu;
            } else {
                eGLDisplay = null;
            }
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            c.b bVar2 = this.Hnp.ilw;
            if (bVar2 != null) {
                eGLContext = bVar2.ilv;
            }
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
            d dVar = this.Hnp;
            if (!this.Hnp.Hnn) {
                z = true;
            } else {
                z = false;
            }
            dVar.Hnn = z;
            this.Hnp.Hnf = true;
            x xVar = x.SXb;
            AppMethodBeat.o(236207);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d Hnp;
        final /* synthetic */ boolean Hnq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d dVar, boolean z) {
            super(0);
            this.Hnp = dVar;
            this.Hnq = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(236199);
            if (this.Hnq != this.Hnp.Hnn) {
                this.Hnp.fLQ();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236199);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d Hnp;
        final /* synthetic */ com.tencent.mm.media.g.d Hnt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(d dVar, com.tencent.mm.media.g.d dVar2) {
            super(0);
            this.Hnp = dVar;
            this.Hnt = dVar2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(236204);
            if (this.Hnp.Hnj != null) {
                l lVar = this.Hnp.Hnj;
                if (lVar != null) {
                    lVar.hDl = this.Hnt.igv;
                }
                l lVar2 = this.Hnp.Hnj;
                if (lVar2 != null) {
                    lVar2.cZ(this.Hnp.Hnk, this.Hnp.Hnl);
                }
                this.Hnp.Hng = true;
            } else {
                this.Hnp.Hko = this.Hnt;
                this.Hnp.Hng = false;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236204);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.voip.video.render.d$d  reason: collision with other inner class name */
    public static final class C1896d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d Hnp;
        final /* synthetic */ f Hnr;
        final /* synthetic */ int Hns;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1896d(d dVar, f fVar, int i2) {
            super(0);
            this.Hnp = dVar;
            this.Hnr = fVar;
            this.Hns = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            EGLDisplay eGLDisplay;
            EGLSurface eGLSurface;
            EGLDisplay eGLDisplay2;
            EGLSurface eGLSurface2 = null;
            EGLDisplay eGLDisplay3 = null;
            AppMethodBeat.i(236201);
            if (this.Hnr != null) {
                Log.i("MicroMsg.WindowSurfaceRenderer", "remove render surface :" + this.Hnr);
                c.b bVar = this.Hnp.ilw;
                if (bVar != null) {
                    eGLDisplay = bVar.ilu;
                } else {
                    eGLDisplay = null;
                }
                if (eGLDisplay != null) {
                    if (!p.j(this.Hnr.fLS(), EGL14.EGL_NO_SURFACE)) {
                        c.b bVar2 = this.Hnp.ilw;
                        if (bVar2 != null) {
                            eGLDisplay3 = bVar2.ilu;
                        }
                        EGL14.eglDestroySurface(eGLDisplay3, this.Hnr.fLS());
                    } else {
                        c.b bVar3 = this.Hnp.ilw;
                        if (bVar3 != null) {
                            eGLSurface = bVar3.eglSurface;
                        } else {
                            eGLSurface = null;
                        }
                        if (!p.j(eGLSurface, EGL14.EGL_NO_SURFACE)) {
                            c.b bVar4 = this.Hnp.ilw;
                            if (bVar4 != null) {
                                eGLDisplay2 = bVar4.ilu;
                            } else {
                                eGLDisplay2 = null;
                            }
                            c.b bVar5 = this.Hnp.ilw;
                            if (bVar5 != null) {
                                eGLSurface2 = bVar5.eglSurface;
                            }
                            EGL14.eglDestroySurface(eGLDisplay2, eGLSurface2);
                        }
                    }
                }
                if (this.Hns == 0) {
                    this.Hnp.Hnh = null;
                } else {
                    this.Hnp.Hni = null;
                }
            } else {
                Log.e("MicroMsg.WindowSurfaceRenderer", "remove a null surface");
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236201);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d Hnp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(d dVar) {
            super(0);
            this.Hnp = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(236205);
            this.Hnp.Hnf = true;
            x xVar = x.SXb;
            AppMethodBeat.o(236205);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d Hnp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(d dVar) {
            super(0);
            this.Hnp = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(236206);
            this.Hnp.Hnf = false;
            x xVar = x.SXb;
            AppMethodBeat.o(236206);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d Hnp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(d dVar) {
            super(0);
            this.Hnp = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            f fVar;
            EGLDisplay eGLDisplay;
            EGLContext eGLContext;
            EGLDisplay eGLDisplay2;
            AppMethodBeat.i(236202);
            if (this.Hnp.Hnn) {
                fVar = this.Hnp.Hnh;
            } else {
                fVar = this.Hnp.Hni;
            }
            if (fVar != null) {
                this.Hnp.HiP = Util.currentTicks();
                l lVar = this.Hnp.Hnj;
                if (lVar != null) {
                    lVar.cY(fVar.Hnv.width, fVar.Hnv.height);
                }
                l lVar2 = this.Hnp.Hnj;
                if (lVar2 != null) {
                    lVar2.aED();
                }
                c.b bVar = this.Hnp.ilw;
                if (bVar != null) {
                    eGLDisplay = bVar.ilu;
                } else {
                    eGLDisplay = null;
                }
                EGLSurface fLS = fVar.fLS();
                EGLSurface fLS2 = fVar.fLS();
                c.b bVar2 = this.Hnp.ilw;
                if (bVar2 != null) {
                    eGLContext = bVar2.ilv;
                } else {
                    eGLContext = null;
                }
                EGL14.eglMakeCurrent(eGLDisplay, fLS, fLS2, eGLContext);
                c.a aVar = com.tencent.mm.media.k.c.ilt;
                c.b bVar3 = this.Hnp.ilw;
                if (bVar3 != null) {
                    eGLDisplay2 = bVar3.ilu;
                } else {
                    eGLDisplay2 = null;
                }
                c.a.a(eGLDisplay2, fVar.fLS());
                if (this.Hnp.Hnc != null) {
                    GLES30.glFinish();
                    kotlin.g.a.a<x> aVar2 = this.Hnp.Hnc;
                    if (aVar2 != null) {
                        aVar2.invoke();
                    }
                    this.Hnp.Hnc = null;
                } else {
                    l lVar3 = this.Hnp.Hnj;
                    if (lVar3 == null || lVar3.hEi != 1) {
                        GLES30.glFinish();
                        kotlin.g.a.b<? super Long, x> bVar4 = this.Hnp.Hne;
                        if (bVar4 != null) {
                            bVar4.invoke(Long.valueOf(Util.ticksToNow(this.Hnp.HiP)));
                        }
                    } else {
                        GLES30.glFinish();
                        kotlin.g.a.b<? super Long, x> bVar5 = this.Hnp.Hnd;
                        if (bVar5 != null) {
                            bVar5.invoke(Long.valueOf(Util.ticksToNow(this.Hnp.HiP)));
                        }
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236202);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d Hnp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(d dVar) {
            super(0);
            this.Hnp = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(236200);
            this.Hnp.Hne = null;
            this.Hnp.Hnc = null;
            this.Hnp.Hnd = null;
            this.Hnp.c(this.Hnp.Hnh, 0);
            this.Hnp.c(this.Hnp.Hni, 1);
            Surface surface = this.Hnp.surface;
            if (surface != null) {
                surface.release();
            }
            SurfaceTexture surfaceTexture = this.Hnp.surfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
            }
            com.tencent.mm.media.g.d dVar = this.Hnp.Hko;
            if (dVar != null) {
                dVar.close();
            }
            this.Hnp.ife = true;
            l lVar = this.Hnp.Hnj;
            if (lVar != null) {
                lVar.release();
            }
            if (this.Hnp.ilw != null) {
                c.a aVar = com.tencent.mm.media.k.c.ilt;
                c.b bVar = this.Hnp.ilw;
                if (bVar == null) {
                    p.hyc();
                }
                c.a.a(bVar);
                this.Hnp.Hni = null;
                this.Hnp.Hnh = null;
            }
            this.Hnp.igZ.quitSafely();
            x xVar = x.SXb;
            AppMethodBeat.o(236200);
            return xVar;
        }
    }
}

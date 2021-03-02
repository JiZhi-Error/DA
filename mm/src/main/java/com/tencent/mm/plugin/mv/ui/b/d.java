package com.tencent.mm.plugin.mv.ui.b;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES30;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.xlabeffect.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.xeffect.VLogDirector;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010)\u001a\u00020\u001cH\u0002J\b\u0010*\u001a\u00020\u001cH\u0002J\b\u0010+\u001a\u00020\u001cH\u0002J\b\u0010,\u001a\u00020\u001cH\u0002J\u0014\u0010-\u001a\u00020\u001c2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001c0/J\u0006\u00100\u001a\u00020\u001cJ\u0010\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u001bH\u0002J\u000e\u00103\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u0013J \u00104\u001a\u00020\u001c2\u0018\u00105\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u0019J\u001a\u00106\u001a\u00020\u001c2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001c0#J\u0016\u00108\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u001bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001c\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000f\"\u0004\b(\u0010\u0011¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/thumb/TPTrackThumbRenderer;", "", "width", "", "height", "(II)V", "TAG", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eGLHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "eGLThread", "Landroid/os/HandlerThread;", "getHeight", "()I", "setHeight", "(I)V", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "outputSizeChanged", "", "outputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "renderFrameCallback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "", "", "renderSurface", "Landroid/view/Surface;", "renderSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "renderTexture", "surfaceCallback", "Lkotlin/Function1;", "vLogDirector", "Lcom/tencent/mm/xeffect/VLogDirector;", "waitNextVideoFrameTimeMs", "getWidth", "setWidth", "createEGLEnvironment", "createEGLThread", "createVideoTexture", "initVLogDirector", "queue", "call", "Lkotlin/Function0;", "release", "renderFrame", "timestampNs", "setMediaInfo", "setRenderFrameCallback", "callback", "setup", "afterSurfaceCreated", "updateSize", "waitNextVideoFrame", "timeMs", "Companion", "plugin-mv_release"})
public final class d {
    public static final a AsM = new a((byte) 0);
    com.tencent.mm.plugin.thumbplayer.d.a AsA;
    HandlerThread AsC;
    MMHandler AsD;
    kotlin.g.a.b<? super Surface, x> AsE;
    private Surface AsF;
    private SurfaceTexture AsG;
    private com.tencent.mm.media.g.d AsH;
    private VLogDirector AsI = new VLogDirector();
    boolean AsJ;
    m<? super Bitmap, ? super Long, x> AsK;
    volatile long AsL;
    final String TAG = ("MicroMsg.TPTrackThumbRenderer@" + hashCode());
    private com.tencent.mm.media.g.d hDm;
    int height;
    private c.b ilw;
    int width;

    public d(int i2, int i3) {
        AppMethodBeat.i(257078);
        this.width = i2;
        this.height = i3;
        AppMethodBeat.o(257078);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/thumb/TPTrackThumbRenderer$Companion;", "", "()V", "FrameTimeErrorThreshold", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(257079);
        b.a aVar = com.tencent.mm.plugin.xlabeffect.b.JRv;
        b.a.tryLoadLibrary();
        AppMethodBeat.o(257079);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d AsN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(d dVar) {
            super(0);
            this.AsN = dVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/mv/ui/thumb/TPTrackThumbRenderer$createVideoTexture$1$1$1"})
        static final class a implements SurfaceTexture.OnFrameAvailableListener {
            final /* synthetic */ c AsO;

            a(c cVar) {
                this.AsO = cVar;
            }

            public final void onFrameAvailable(final SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(257071);
                Looper myLooper = Looper.myLooper();
                HandlerThread handlerThread = this.AsO.AsN.AsC;
                if (p.j(myLooper, handlerThread != null ? handlerThread.getLooper() : null)) {
                    surfaceTexture.updateTexImage();
                    d dVar = this.AsO.AsN;
                    p.g(surfaceTexture, LocaleUtil.ITALIAN);
                    d.a(dVar, surfaceTexture.getTimestamp());
                    AppMethodBeat.o(257071);
                    return;
                }
                this.AsO.AsN.k(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.mv.ui.b.d.c.a.AnonymousClass1 */
                    final /* synthetic */ a AsP;

                    {
                        this.AsP = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(257070);
                        surfaceTexture.updateTexImage();
                        d dVar = this.AsP.AsO.AsN;
                        SurfaceTexture surfaceTexture = surfaceTexture;
                        p.g(surfaceTexture, LocaleUtil.ITALIAN);
                        d.a(dVar, surfaceTexture.getTimestamp());
                        x xVar = x.SXb;
                        AppMethodBeat.o(257070);
                        return xVar;
                    }
                });
                AppMethodBeat.o(257071);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(257072);
            d dVar = this.AsN;
            com.tencent.mm.media.g.d dVar2 = new com.tencent.mm.media.g.d(false, 15);
            this.AsN.AsG = new SurfaceTexture(dVar2.igv);
            this.AsN.AsF = new Surface(this.AsN.AsG);
            SurfaceTexture surfaceTexture = this.AsN.AsG;
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(new a(this));
            }
            Log.i(this.AsN.TAG, "createVideoTexture finished texId:" + dVar2.igv);
            dVar.AsH = dVar2;
            x xVar = x.SXb;
            AppMethodBeat.o(257072);
            return xVar;
        }
    }

    public final void k(kotlin.g.a.a<x> aVar) {
        MMHandler mMHandler;
        AppMethodBeat.i(257077);
        p.h(aVar, "call");
        HandlerThread handlerThread = this.AsC;
        if (handlerThread == null) {
            AppMethodBeat.o(257077);
        } else if (!handlerThread.isAlive() || (mMHandler = this.AsD) == null) {
            AppMethodBeat.o(257077);
        } else {
            mMHandler.post(new e(aVar));
            AppMethodBeat.o(257077);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d AsN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(d dVar) {
            super(0);
            this.AsN = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(257076);
            kotlin.g.a.b bVar = this.AsN.AsE;
            if (bVar != null) {
                Surface surface = this.AsN.AsF;
                if (surface == null) {
                    p.hyc();
                }
                bVar.invoke(surface);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(257076);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d AsN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d dVar) {
            super(0);
            this.AsN = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(257069);
            this.AsN.ilw = c.a.a(com.tencent.mm.media.k.c.ilt, null, this.AsN.width, this.AsN.height, null, 16);
            x xVar = x.SXb;
            AppMethodBeat.o(257069);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.mv.ui.b.d$d  reason: collision with other inner class name */
    static final class C1554d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d AsN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1554d(d dVar) {
            super(0);
            this.AsN = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(257073);
            this.AsN.AsI = new VLogDirector();
            this.AsN.AsI.init();
            this.AsN.AsI.setSize(this.AsN.width, this.AsN.height);
            this.AsN.AsI.mm(this.AsN.width, this.AsN.height);
            this.AsN.AsI.setOutputSize(this.AsN.width, this.AsN.height);
            d dVar = this.AsN;
            com.tencent.mm.media.g.d dVar2 = new com.tencent.mm.media.g.d(true, 15);
            GLES30.glBindTexture(3553, dVar2.igv);
            GLES30.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, this.AsN.width, this.AsN.height, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            GLES30.glBindTexture(3553, 0);
            dVar.hDm = dVar2;
            Log.i(this.AsN.TAG, "initVLogDirector finished size:[" + this.AsN.width + ',' + this.AsN.height + ']');
            x xVar = x.SXb;
            AppMethodBeat.o(257073);
            return xVar;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0073 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(com.tencent.mm.plugin.mv.ui.b.d r17, long r18) {
        /*
        // Method dump skipped, instructions count: 372
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.ui.b.d.a(com.tencent.mm.plugin.mv.ui.b.d, long):void");
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d AsN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(d dVar) {
            super(0);
            this.AsN = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(257074);
            Log.i(this.AsN.TAG, "release");
            com.tencent.mm.media.g.d dVar = this.AsN.AsH;
            if (dVar != null) {
                dVar.close();
            }
            Surface surface = this.AsN.AsF;
            if (surface != null) {
                surface.release();
            }
            this.AsN.AsI.destroy();
            com.tencent.mm.media.g.d dVar2 = this.AsN.hDm;
            if (dVar2 != null) {
                dVar2.close();
            }
            c.b bVar = this.AsN.ilw;
            if (bVar != null) {
                c.a aVar = com.tencent.mm.media.k.c.ilt;
                c.a.a(bVar);
            }
            HandlerThread handlerThread = this.AsN.AsC;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            this.AsN.AsC = null;
            this.AsN.AsD = null;
            x xVar = x.SXb;
            AppMethodBeat.o(257074);
            return xVar;
        }
    }
}

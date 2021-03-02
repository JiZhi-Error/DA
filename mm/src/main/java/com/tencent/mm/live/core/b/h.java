package com.tencent.mm.live.core.b;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020!H\u0002J$\u0010$\u001a\u00020!2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0016\u0010'\u001a\u00020!2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010)J\u0006\u0010*\u001a\u00020!J\u0010\u0010+\u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0002J\u0012\u0010,\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010\u0013H\u0016J\u0006\u0010.\u001a\u00020!J\u0016\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006J\u000e\u00102\u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u0006R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u00064"}, hxF = {"Lcom/tencent/mm/live/core/render/LiveVisitorRenderSurface;", "Lcom/tencent/trtc/TRTCCloudListener$TRTCVideoRenderListener;", "Lcom/tencent/mm/live/core/render/LiveRenderSurface;", "userId", "", "streamType", "", "(Ljava/lang/String;I)V", "eGLSurface", "Landroid/opengl/EGLSurface;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglThread", "Landroid/os/HandlerThread;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "noSurface", "", "outputSurface", "", "outputSurfaceChange", "renderMode", "renderer", "Lcom/tencent/mm/live/core/render/LiveVisitorRenderer;", "getStreamType", "()I", "setStreamType", "(I)V", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "initRenderer", "", "makeEGLEnvironment", "makeOutputSurface", "onRenderVideoFrame", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "queue", "callback", "Lkotlin/Function0;", "release", "renderFrame", "setOutputSurface", "surface", "unsetOutputSurface", "updateDrawSize", "width", "height", "updateRenderMode", "Companion", "plugin-core_release"})
public final class h implements TRTCCloudListener.TRTCVideoRenderListener {
    public static final a hEj = new a((byte) 0);
    private final HandlerThread hDq;
    private c.b hDs;
    private Object hDv;
    private EGLSurface hEe;
    private boolean hEf;
    private j hEg;
    private boolean hEh;
    private int hEi;
    private MMHandler handler;
    public int streamType = 0;
    public String userId;

    static {
        AppMethodBeat.i(196684);
        AppMethodBeat.o(196684);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/live/core/render/LiveVisitorRenderSurface$Companion;", "", "()V", "RENDER_MSG", "", "TAG", "", "plugin-core_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public h(String str) {
        p.h(str, "userId");
        AppMethodBeat.i(196683);
        this.userId = str;
        HandlerThread hA = com.tencent.f.c.d.hA("MicroMsg.LiveCoreVisitor_render", 10);
        p.g(hA, "SpecialThreadFactory.cre…er\", Thread.MAX_PRIORITY)");
        this.hDq = hA;
        this.hEh = true;
        this.hEi = 2;
        this.hDq.start();
        this.handler = new MMHandler(this.hDq.getLooper(), new MMHandler.Callback(this) {
            /* class com.tencent.mm.live.core.b.h.AnonymousClass1 */
            final /* synthetic */ h hEk;

            {
                this.hEk = r1;
            }

            public final boolean handleMessage(Message message) {
                AppMethodBeat.i(196667);
                if (message.what == 1024) {
                    h hVar = this.hEk;
                    Object obj = message.obj;
                    if (obj == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame");
                        AppMethodBeat.o(196667);
                        throw tVar;
                    }
                    h.a(hVar, (TRTCCloudDef.TRTCVideoFrame) obj);
                }
                AppMethodBeat.o(196667);
                return true;
            }
        });
        k(new c(this));
        k(new b(this));
        AppMethodBeat.o(196683);
    }

    private void k(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(196676);
        this.handler.post(new i(aVar));
        AppMethodBeat.o(196676);
    }

    public final void bO(Object obj) {
        AppMethodBeat.i(196677);
        Log.i("MicroMsg.LiveCoreVisitor", "setOutputSurface:".concat(String.valueOf(obj)));
        k(new e(this, obj));
        AppMethodBeat.o(196677);
    }

    public final void aEG() {
        AppMethodBeat.i(196678);
        k(new f(this));
        AppMethodBeat.o(196678);
    }

    @Override // com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener
    public final void onRenderVideoFrame(String str, int i2, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        AppMethodBeat.i(196679);
        if ((!p.j(str, this.userId)) || i2 != this.streamType) {
            AppMethodBeat.o(196679);
            return;
        }
        this.handler.obtainMessage(1024, tRTCVideoFrame).sendToTarget();
        AppMethodBeat.o(196679);
    }

    public final void qy(int i2) {
        AppMethodBeat.i(196680);
        k(new C0379h(this, i2));
        AppMethodBeat.o(196680);
    }

    public final void cX(int i2, int i3) {
        AppMethodBeat.i(196681);
        k(new g(this, i2, i3));
        AppMethodBeat.o(196681);
    }

    public final void release() {
        AppMethodBeat.i(196682);
        k(new d(this));
        AppMethodBeat.o(196682);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ h hEk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(h hVar) {
            super(0);
            this.hEk = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(196669);
            this.hEk.hDs = c.a.a(com.tencent.mm.media.k.c.ilt, null, 1, 1, null, 16);
            x xVar = x.SXb;
            AppMethodBeat.o(196669);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ h hEk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(h hVar) {
            super(0);
            this.hEk = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(196668);
            this.hEk.hEg = new j(this.hEk.userId, this.hEk.streamType);
            x xVar = x.SXb;
            AppMethodBeat.o(196668);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Object cPi;
        final /* synthetic */ h hEk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(h hVar, Object obj) {
            super(0);
            this.hEk = hVar;
            this.cPi = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(196672);
            if (this.cPi != null && (!p.j(this.cPi, this.hEk.hDv))) {
                this.hEk.hDv = this.cPi;
                this.hEk.hEf = true;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(196672);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ h hEk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(h hVar) {
            super(0);
            this.hEk = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(196673);
            Log.i("MicroMsg.LiveCoreVisitor", "unsetOutputSurface");
            this.hEk.hDv = null;
            this.hEk.hEe = EGL14.EGL_NO_SURFACE;
            this.hEk.hEh = true;
            x xVar = x.SXb;
            AppMethodBeat.o(196673);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(h hVar, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        Object obj;
        AppMethodBeat.i(196685);
        c.b bVar = hVar.hDs;
        if (!(bVar == null || !hVar.hEf || (obj = hVar.hDv) == null)) {
            Log.i("MicroMsg.LiveCoreVisitor", "makeOutputSurface");
            c.a aVar = com.tencent.mm.media.k.c.ilt;
            hVar.hEe = c.a.a(bVar.ilu, obj);
            bVar.eglSurface = hVar.hEe;
            EGL14.eglMakeCurrent(bVar.ilu, hVar.hEe, hVar.hEe, bVar.ilv);
            hVar.hEf = false;
            hVar.hEh = false;
        }
        if (!hVar.hEh) {
            j jVar = hVar.hEg;
            if (jVar != null) {
                p.h(tRTCVideoFrame, "frame");
                if (tRTCVideoFrame.bufferType == 3) {
                    jVar.hEm = 0;
                } else if (tRTCVideoFrame.pixelFormat == 1 && tRTCVideoFrame.bufferType == 2) {
                    jVar.hEm = 1;
                } else {
                    Log.w("MicroMsg.LiveCoreVisitor", "error video frame type");
                }
                int i2 = tRTCVideoFrame.width;
                int i3 = tRTCVideoFrame.height;
                if (jVar.hEm == 0) {
                    if (jVar.hEn == null) {
                        jVar.hEn = new com.tencent.mm.media.j.b.e(i2, i3, jVar.hEp, jVar.hEq, 0, jVar.hEi, 16);
                    } else {
                        com.tencent.mm.media.j.b.d dVar = jVar.hEo;
                        if (dVar != null) {
                            dVar.rm(jVar.hEi);
                        }
                    }
                    com.tencent.mm.media.j.b.e eVar = jVar.hEn;
                    if (eVar != null) {
                        eVar.cZ(i2, i3);
                    }
                    com.tencent.mm.media.j.b.e eVar2 = jVar.hEn;
                    if (eVar2 != null) {
                        eVar2.cY(jVar.hEp, jVar.hEq);
                    }
                    com.tencent.mm.media.j.b.e eVar3 = jVar.hEn;
                    if (eVar3 != null) {
                        eVar3.qx(tRTCVideoFrame.rotation);
                    }
                    com.tencent.mm.media.j.b.e eVar4 = jVar.hEn;
                    if (eVar4 != null) {
                        eVar4.hDl = tRTCVideoFrame.texture.textureId;
                    }
                    com.tencent.mm.media.j.b.e eVar5 = jVar.hEn;
                    if (eVar5 != null) {
                        eVar5.aED();
                    }
                } else if (jVar.hEm == 1) {
                    jVar.hEs = Util.currentTicks();
                    if (jVar.hEo == null) {
                        jVar.hEo = new com.tencent.mm.media.j.b.d(i2, i3, jVar.hEp, jVar.hEq, jVar.hEi, (byte) 0);
                        jVar.hEr.startTimer(1000);
                    } else {
                        com.tencent.mm.media.j.b.d dVar2 = jVar.hEo;
                        if (dVar2 != null) {
                            dVar2.rm(jVar.hEi);
                        }
                    }
                    com.tencent.mm.media.j.b.d dVar3 = jVar.hEo;
                    if (dVar3 != null) {
                        dVar3.cZ(i2, i3);
                    }
                    com.tencent.mm.media.j.b.d dVar4 = jVar.hEo;
                    if (dVar4 != null) {
                        dVar4.cY(jVar.hEp, jVar.hEq);
                    }
                    com.tencent.mm.media.j.b.d dVar5 = jVar.hEo;
                    if (dVar5 != null) {
                        dVar5.qx(tRTCVideoFrame.rotation);
                    }
                    com.tencent.mm.media.j.b.d dVar6 = jVar.hEo;
                    if (dVar6 != null) {
                        byte[] bArr = tRTCVideoFrame.data;
                        p.g(bArr, "frame.data");
                        dVar6.ag(bArr);
                    }
                    com.tencent.mm.media.j.b.d dVar7 = jVar.hEo;
                    if (dVar7 != null) {
                        dVar7.aED();
                    }
                    jVar.hDX++;
                    com.tencent.mm.live.core.c.c.zw(Util.ticksToNow(jVar.hEs));
                }
            }
            c.b bVar2 = hVar.hDs;
            if (bVar2 != null) {
                EGL14.eglSwapBuffers(bVar2.ilu, bVar2.eglSurface);
                AppMethodBeat.o(196685);
                return;
            }
        }
        AppMethodBeat.o(196685);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.live.core.b.h$h  reason: collision with other inner class name */
    public static final class C0379h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ h hEk;
        final /* synthetic */ int hEl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0379h(h hVar, int i2) {
            super(0);
            this.hEk = hVar;
            this.hEl = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(196675);
            j jVar = this.hEk.hEg;
            if (jVar != null) {
                jVar.hEi = this.hEl;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(196675);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int cKE;
        final /* synthetic */ int cKF;
        final /* synthetic */ h hEk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(h hVar, int i2, int i3) {
            super(0);
            this.hEk = hVar;
            this.cKE = i2;
            this.cKF = i3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(196674);
            j jVar = this.hEk.hEg;
            if (jVar != null) {
                int i2 = this.cKE;
                int i3 = this.cKF;
                Log.i("MicroMsg.LiveCoreVisitor", "updateDrawSize: [" + i2 + ',' + i3 + ']');
                jVar.hEp = i2;
                jVar.hEq = i3;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(196674);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ h hEk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(h hVar) {
            super(0);
            this.hEk = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(196670);
            j jVar = this.hEk.hEg;
            if (jVar != null) {
                Log.i("MicroMsg.LiveCoreVisitor", "queue release");
                com.tencent.mm.media.j.b.e eVar = jVar.hEn;
                if (eVar != null) {
                    eVar.release();
                }
                com.tencent.mm.media.j.b.d dVar = jVar.hEo;
                if (dVar != null) {
                    dVar.release();
                }
                jVar.hEr.stopTimer();
            }
            c.b bVar = this.hEk.hDs;
            if (bVar != null) {
                c.a aVar = com.tencent.mm.media.k.c.ilt;
                c.a.a(bVar);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(196670);
            return xVar;
        }
    }
}

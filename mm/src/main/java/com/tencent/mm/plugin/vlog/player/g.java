package com.tencent.mm.plugin.vlog.player;

import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0016\u0018\u0000 22\u00020\u0001:\u00012B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J2\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010&\u001a\u00020\u001eH\u0016J\b\u0010'\u001a\u00020\u001eH\u0002J\u0016\u0010(\u001a\u00020\u001e2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001e0*H\u0016J\b\u0010+\u001a\u00020\u001eH\u0016J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020.H\u0016J\b\u00101\u001a\u00020\u001eH\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface;", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "width", "", "height", "textureWidth", "textureHeight", "(IIII)V", "(II)V", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEglEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEglEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "ht", "Landroid/os/HandlerThread;", "getHt", "()Landroid/os/HandlerThread;", "setHt", "(Landroid/os/HandlerThread;)V", "remuxEGLSurface", "Landroid/opengl/EGLSurface;", "attachConsumer", "", "surface", "Landroid/view/Surface;", "bindPreloadConsumer", "eglContext", "Landroid/opengl/EGLContext;", "eglDisplay", "Landroid/opengl/EGLDisplay;", "clearTask", "initGLEnvironment", "queueEvent", "task", "Lkotlin/Function0;", "release", "setPresentationTime", "nsecs", "", "submitProduction", "ptsMS", "unbindPreloadConsumer", "Companion", "plugin-vlog_release"})
public final class g extends k {
    public static final a GBN = new a((byte) 0);
    private EGLSurface GBM;
    private int hDn;
    private int hDo;
    public c.b hDs;
    private MMHandler handler;
    HandlerThread wpM;

    static {
        AppMethodBeat.i(190872);
        AppMethodBeat.o(190872);
    }

    public g(int i2, int i3) {
        super(i2, i3);
        AppMethodBeat.i(190870);
        HandlerThread hz = com.tencent.f.c.d.hz("VLogRemuxSurface_EncodeThread", -4);
        p.g(hz, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
        this.wpM = hz;
        AppMethodBeat.o(190870);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public g(int i2, int i3, int i4, int i5) {
        this(i2, i3);
        AppMethodBeat.i(190871);
        this.hDn = i4;
        this.hDo = i5;
        Log.i("MicroMsg.VLog.VLogRemuxSurface", "create VLogRemuxSurface, surface:[" + i2 + ", " + i3 + "], texture:[" + i4 + ", " + i5 + ']');
        AppMethodBeat.o(190871);
    }

    @Override // com.tencent.mm.plugin.vlog.player.k
    public final void a(EGLContext eGLContext, EGLDisplay eGLDisplay, Surface surface, int i2, int i3) {
        EGLContext eGLContext2;
        AppMethodBeat.i(190864);
        p.h(eGLContext, "eglContext");
        p.h(eGLDisplay, "eglDisplay");
        StringBuilder append = new StringBuilder("[OpenGL] bind surface before, surface: ").append(surface).append(", eglEnv: ");
        c.b bVar = this.hDs;
        if (bVar != null) {
            eGLContext2 = bVar.ilv;
        } else {
            eGLContext2 = null;
        }
        Log.i("MicroMsg.VLog.VLogRemuxSurface", append.append(eGLContext2).toString());
        j(new b(this, eGLContext, eGLDisplay, surface, i2, i3));
        AppMethodBeat.o(190864);
    }

    @Override // com.tencent.mm.plugin.vlog.player.k
    public final void fCo() {
        AppMethodBeat.i(190865);
        j(new e(this));
        AppMethodBeat.o(190865);
    }

    @Override // com.tencent.mm.plugin.vlog.player.k
    public final void j(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(190866);
        p.h(aVar, "task");
        MMHandler mMHandler = this.handler;
        if (mMHandler != null) {
            mMHandler.post(new h(aVar));
            AppMethodBeat.o(190866);
            return;
        }
        AppMethodBeat.o(190866);
    }

    @Override // com.tencent.mm.plugin.vlog.player.k
    public final void clearTask() {
        AppMethodBeat.i(190867);
        MMHandler mMHandler = this.handler;
        if (mMHandler != null) {
            mMHandler.removeCallbacksAndMessages(null);
            AppMethodBeat.o(190867);
            return;
        }
        AppMethodBeat.o(190867);
    }

    @Override // com.tencent.mm.plugin.vlog.player.k
    public final void KY(long j2) {
        AppMethodBeat.i(190868);
        long j3 = j2 * 1000 * 1000;
        c.b bVar = this.hDs;
        if (bVar != null) {
            EGLExt.eglPresentationTimeANDROID(bVar.ilu, bVar.eglSurface, j3);
        }
        c.a aVar = com.tencent.mm.media.k.c.ilt;
        c.a.Hq("eglPresentationTimeANDROID");
        c.b bVar2 = this.hDs;
        if (bVar2 != null) {
            c.a aVar2 = com.tencent.mm.media.k.c.ilt;
            c.a.a(bVar2.ilu, bVar2.eglSurface);
            AppMethodBeat.o(190868);
            return;
        }
        AppMethodBeat.o(190868);
    }

    @Override // com.tencent.mm.plugin.vlog.player.k
    public final void release() {
        EGLContext eGLContext;
        AppMethodBeat.i(190869);
        StringBuilder append = new StringBuilder("[OpenGL] VLogRelease release egl environment, surface: ").append(this.GCh).append(", eglEnv: ");
        c.b bVar = this.hDs;
        if (bVar != null) {
            eGLContext = bVar.ilv;
        } else {
            eGLContext = null;
        }
        Log.printInfoStack("MicroMsg.VLog.VLogRemuxSurface", append.append(eGLContext).toString(), new Object[0]);
        j(new d(this));
        AppMethodBeat.o(190869);
    }

    @Override // com.tencent.mm.plugin.vlog.player.k
    public final void k(Surface surface) {
        EGLContext eGLContext;
        AppMethodBeat.i(190863);
        this.GCh = surface;
        StringBuilder append = new StringBuilder("[OpenGL] init egl environment before, surface: ").append(surface).append(", eglEnv: ");
        c.b bVar = this.hDs;
        if (bVar != null) {
            eGLContext = bVar.ilv;
        } else {
            eGLContext = null;
        }
        Log.i("MicroMsg.VLog.VLogRemuxSurface", append.append(eGLContext).toString());
        Log.i("MicroMsg.VLog.VLogRemuxSurface", "initGL");
        this.wpM.start();
        this.handler = new MMHandler(this.wpM.getLooper());
        j(new c(this));
        AppMethodBeat.o(190863);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g GBO;
        final /* synthetic */ EGLDisplay GBP;
        final /* synthetic */ int cKE;
        final /* synthetic */ int cKF;
        final /* synthetic */ Surface ihv;
        final /* synthetic */ EGLContext ihw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(g gVar, EGLContext eGLContext, EGLDisplay eGLDisplay, Surface surface, int i2, int i3) {
            super(0);
            this.GBO = gVar;
            this.ihw = eGLContext;
            this.GBP = eGLDisplay;
            this.ihv = surface;
            this.cKE = i2;
            this.cKF = i3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            EGLContext eGLContext;
            AppMethodBeat.i(190858);
            Log.i("MicroMsg.VLog.VLogRemuxSurface", "bindPreloadConsumer, eglContext:" + this.ihw + ", eglDisplay:" + this.GBP + ", surface:" + this.ihv + ", width:" + this.cKE + ", height:" + this.cKF);
            Surface surface = this.ihv;
            if (surface != null) {
                g gVar = this.GBO;
                c.a aVar = com.tencent.mm.media.k.c.ilt;
                gVar.hDs = c.a.a(this.ihw, this.GBP, surface);
                StringBuilder append = new StringBuilder("[OpenGL] bind surface after, surface: ").append(this.ihv).append(", eglEnv: ");
                c.b bVar = this.GBO.hDs;
                if (bVar != null) {
                    eGLContext = bVar.ilv;
                } else {
                    eGLContext = null;
                }
                Log.i("MicroMsg.VLog.VLogRemuxSurface", append.append(eGLContext).toString());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(190858);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g GBO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(g gVar) {
            super(0);
            this.GBO = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(190862);
            EGLSurface eGLSurface = this.GBO.GBM;
            if (eGLSurface != null) {
                Log.i("MicroMsg.VLog.VLogRemuxSurface", "unbindPreloadConsumer, remuxEGLSurface:".concat(String.valueOf(eGLSurface)));
                c.a aVar = com.tencent.mm.media.k.c.ilt;
                c.a.a(this.GBO.hDs, eGLSurface);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(190862);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g GBO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(g gVar) {
            super(0);
            this.GBO = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            c.b a2;
            EGLSurface eGLSurface;
            EGLContext eGLContext = null;
            AppMethodBeat.i(190859);
            g gVar = this.GBO;
            if (this.GBO.GCh == null) {
                a2 = c.a.a(com.tencent.mm.media.k.c.ilt, this.GBO.GCh, this.GBO.width, this.GBO.height, null, 18);
            } else {
                a2 = c.a.a(com.tencent.mm.media.k.c.ilt, this.GBO.GCh, 0, 0, null, 30);
            }
            gVar.hDs = a2;
            Log.i("MicroMsg.VLog.VLogRemuxSurface", "initGL succ");
            g gVar2 = this.GBO;
            com.tencent.mm.media.g.d a3 = com.tencent.mm.media.g.c.a(true, 9);
            if (this.GBO.hDn <= 0 || this.GBO.hDo <= 0) {
                Log.i("MicroMsg.VLog.VLogRemuxSurface", "[OpenGL] init productionTexObj, width:" + this.GBO.width + ", height:" + this.GBO.height);
                com.tencent.mm.media.g.d.a(a3, this.GBO.width, this.GBO.height, 0, null, 0, 0, 60);
            } else {
                Log.i("MicroMsg.VLog.VLogRemuxSurface", "[OpenGL] init productionTexObj, width:" + this.GBO.hDn + ", height:" + this.GBO.hDo);
                com.tencent.mm.media.g.d.a(a3, this.GBO.hDn, this.GBO.hDo, 0, null, 0, 0, 60);
            }
            gVar2.GCg = a3;
            g gVar3 = this.GBO;
            c.b bVar = this.GBO.hDs;
            if (bVar != null) {
                eGLSurface = bVar.eglSurface;
            } else {
                eGLSurface = null;
            }
            gVar3.GBM = eGLSurface;
            StringBuilder append = new StringBuilder("[OpenGL] init egl environment after, surface: ").append(this.GBO.GCh).append(", eglEnv: ");
            c.b bVar2 = this.GBO.hDs;
            if (bVar2 != null) {
                eGLContext = bVar2.ilv;
            }
            Log.i("MicroMsg.VLog.VLogRemuxSurface", append.append(eGLContext).toString());
            x xVar = x.SXb;
            AppMethodBeat.o(190859);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g GBO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(g gVar) {
            super(0);
            this.GBO = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(190860);
            c.b bVar = this.GBO.hDs;
            if (bVar != null) {
                Log.d("MicroMsg.VLog.VLogRemuxSurface", "VLogRelease into eglEnvironment?.let");
                c.a aVar = com.tencent.mm.media.k.c.ilt;
                c.a.a(bVar);
            }
            this.GBO.clearTask();
            this.GBO.wpM.quitSafely();
            x xVar = x.SXb;
            AppMethodBeat.o(190860);
            return xVar;
        }
    }
}

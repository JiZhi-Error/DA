package com.tencent.mm.live.core.b;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.media.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0001XB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\fH\u0016J\u000e\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\fJ\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\n\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020\fH\u0002J\b\u0010)\u001a\u00020\fH\u0002J\u0006\u0010*\u001a\u00020\u001eJ\u0016\u0010+\u001a\u00020\f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010-\u001a\u00020\fH\u0016J\b\u0010.\u001a\u00020\fH\u0016J\u0006\u0010/\u001a\u00020\fJ\u001e\u00100\u001a\u00020\f2\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u000102J/\u00103\u001a\u00020\f2%\u00104\u001a!\u0012\u0015\u0012\u0013\u0018\u00010%¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\f\u0018\u000102H\u0016J\u0012\u00108\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010:\u001a\u00020\f2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\f02J\u0018\u0010;\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0016J\u000e\u0010?\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010@\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020BJ \u0010C\u001a\u00020\f2\u0016\u0010D\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010E\u0012\u0004\u0012\u00020\f\u0018\u000102H\u0016J\b\u0010F\u001a\u00020\fH\u0016J\u0010\u0010G\u001a\u00020\f2\b\u0010H\u001a\u0004\u0018\u00010IJ\u0010\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020LH\u0016J\u0016\u0010M\u001a\u00020\f2\u0006\u0010N\u001a\u00020\u001e2\u0006\u0010O\u001a\u00020\u001eJ\u0010\u0010P\u001a\u00020\f2\b\u0010Q\u001a\u0004\u0018\u00010RJ\u000e\u0010S\u001a\u00020\f2\u0006\u0010T\u001a\u00020>J\u000e\u0010U\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u001eJ\u000e\u0010V\u001a\u00020\f2\u0006\u0010W\u001a\u00020\u001eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, hxF = {"Lcom/tencent/mm/live/core/render/LiveRenderManager;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "Lcom/tencent/mm/live/core/render/LiveRenderSurface;", "()V", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "eglThread", "Landroid/os/HandlerThread;", "initializeCallback", "Lkotlin/Function0;", "", "getInitializeCallback", "()Lkotlin/jvm/functions/Function0;", "setInitializeCallback", "(Lkotlin/jvm/functions/Function0;)V", "model", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "outputEglSurface", "Landroid/opengl/EGLSurface;", "outputSurface", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderer", "Lcom/tencent/mm/live/core/render/LiveTexEditRenderer;", "clearFrame", "endScaleAnimation", "time", "", "exchangeSurface", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getRendererTextureSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "makeEGLEnvironment", "makeOutputSurface", "mirrorMode", "queueEvent", "r", "release", "requestRender", "reset", "setFpsCallbackListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "setOnDrawListener", "frameAvailableListener", "Lkotlin/ParameterName;", "name", "texture", "setOutputSurface", "surface", "setPerFrameRendererCostCallbackListener", "setPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "cpuCrop", "", "setup", "startScaleAnimation", "scale", "", "tryCameraPreview", "callback", "Landroid/graphics/SurfaceTexture;", "tryStopCameraPreview", "updateBeautyConfig", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "updateDrawSize", "width", "height", "updateFilterConfig", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "updateMirror", "isMirror", "updateMirrorMode", "updateScene", "scene", "Companion", "plugin-core_release"})
public final class d implements com.tencent.mm.media.widget.camerarecordview.preview.e {
    public static final a hDy = new a((byte) 0);
    public com.tencent.mm.live.core.core.b.f hAy;
    private final HandlerThread hDq;
    private MMHandler hDr = new MMHandler(this.hDq.getLooper());
    private c.b hDs;
    private com.tencent.mm.media.widget.camerarecordview.preview.a.a hDt;
    private EGLSurface hDu;
    private Object hDv;
    public g hDw;
    kotlin.g.a.a<x> hDx;

    static {
        AppMethodBeat.i(196648);
        AppMethodBeat.o(196648);
    }

    public d() {
        AppMethodBeat.i(196647);
        HandlerThread hA = com.tencent.f.c.d.hA("MicroMsg.LiveCoreRender", 10);
        p.g(hA, "SpecialThreadFactory.cre…TAG, Thread.MAX_PRIORITY)");
        this.hDq = hA;
        this.hDq.start();
        this.hDr.post(new c(this));
        AppMethodBeat.o(196647);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/core/render/LiveRenderManager$Companion;", "", "()V", "TAG", "", "plugin-core_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ d hDz;

        c(d dVar) {
            this.hDz = dVar;
        }

        public final void run() {
            boolean z;
            com.tencent.mm.live.core.core.b.d dVar;
            AppMethodBeat.i(196621);
            final int jn = com.tencent.mm.cb.a.jn(MMApplicationContext.getContext());
            final int jo = com.tencent.mm.cb.a.jo(MMApplicationContext.getContext());
            this.hDz.hDs = c.a.a(com.tencent.mm.media.k.c.ilt, null, 1, 1, null, 16);
            com.tencent.mm.live.core.core.b.f fVar = this.hDz.hAy;
            if (fVar == null || (dVar = fVar.hzt) == null) {
                z = false;
            } else {
                z = dVar.hzi;
            }
            this.hDz.hDw = new g(z);
            d dVar2 = this.hDz;
            g gVar = this.hDz.hDw;
            if (gVar == null) {
                p.hyc();
            }
            dVar2.a(gVar, z);
            com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDz.hDt;
            if (aVar != null) {
                aVar.onSurfaceCreated(null, null);
            }
            com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar2 = this.hDz.hDt;
            if (aVar2 != null) {
                aVar2.a(0, new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.live.core.b.d.c.AnonymousClass1 */
                    final /* synthetic */ c hDA;

                    {
                        this.hDA = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        com.tencent.mm.media.g.d aQu;
                        AppMethodBeat.i(196620);
                        Log.i("MicroMsg.LiveCoreRender", "width:" + jn + " height:" + jo);
                        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDA.hDz.hDt;
                        if (aVar != null) {
                            aVar.onSurfaceChanged(null, jn, jo);
                        }
                        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar2 = this.hDA.hDz.hDt;
                        if (!(aVar2 == null || (aQu = aVar2.aQu()) == null)) {
                            aQu.setSize(jn, jo);
                        }
                        kotlin.g.a.a<x> aVar3 = this.hDA.hDz.hDx;
                        if (aVar3 != null) {
                            aVar3.invoke();
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(196620);
                        return xVar;
                    }
                });
                AppMethodBeat.o(196621);
                return;
            }
            AppMethodBeat.o(196621);
        }
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final void a(com.tencent.mm.media.j.a aVar, boolean z) {
        com.tencent.mm.media.widget.camerarecordview.preview.a.c cVar;
        AppMethodBeat.i(196630);
        p.h(aVar, "renderer");
        Log.printInfoStack("MicroMsg.LiveCoreRender", "setPreviewRenderer cpuCrop:".concat(String.valueOf(z)), new Object[0]);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar2 = this.hDt;
        if (aVar2 != null) {
            aVar2.release();
        }
        if (z) {
            cVar = new com.tencent.mm.media.widget.camerarecordview.preview.a.b(this);
        } else {
            cVar = new com.tencent.mm.media.widget.camerarecordview.preview.a.c(this);
        }
        this.hDt = cVar;
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar3 = this.hDt;
        if (aVar3 != null) {
            aVar3.b(aVar);
            AppMethodBeat.o(196630);
            return;
        }
        AppMethodBeat.o(196630);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(196631);
        j(new g(this, aVar));
        AppMethodBeat.o(196631);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(196632);
        j(new h(this, bVar));
        AppMethodBeat.o(196632);
    }

    public final void cX(int i2, int i3) {
        AppMethodBeat.i(196633);
        if (i2 <= 0 || i3 <= 0) {
            int jn = com.tencent.mm.cb.a.jn(MMApplicationContext.getContext());
            int jo = com.tencent.mm.cb.a.jo(MMApplicationContext.getContext());
            com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
            com.tencent.mm.live.core.debug.a.GA("updateDrawSize:" + jn + " x " + jo);
            com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar2 = this.hDt;
            if (aVar2 != null) {
                aVar2.onSurfaceChanged(null, jn, jo);
                AppMethodBeat.o(196633);
                return;
            }
            AppMethodBeat.o(196633);
            return;
        }
        com.tencent.mm.live.core.debug.a aVar3 = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.GA("updateDrawSize:" + i2 + " x " + i3);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar4 = this.hDt;
        if (aVar4 != null) {
            aVar4.onSurfaceChanged(null, i2, i3);
            AppMethodBeat.o(196633);
            return;
        }
        AppMethodBeat.o(196633);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final void a(com.tencent.mm.media.widget.a.b bVar) {
        AppMethodBeat.i(196634);
        p.h(bVar, "cameraConfig");
        Log.printInfoStack("MicroMsg.LiveCoreRender", "updateCameraConfig:".concat(String.valueOf(bVar)), new Object[0]);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if (aVar != null) {
            aVar.a(bVar);
            AppMethodBeat.o(196634);
            return;
        }
        AppMethodBeat.o(196634);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final void d(kotlin.g.a.b<? super SurfaceTexture, x> bVar) {
        SurfaceTexture surfaceTexture;
        SurfaceTexture surfaceTexture2 = null;
        AppMethodBeat.i(196635);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if ((aVar != null ? aVar.getSurfaceTexture() : null) == null) {
            this.hDx = new f(this, bVar);
            AppMethodBeat.o(196635);
            return;
        }
        if (bVar != null) {
            com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar2 = this.hDt;
            if (aVar2 != null) {
                surfaceTexture = aVar2.getSurfaceTexture();
            } else {
                surfaceTexture = null;
            }
            bVar.invoke(surfaceTexture);
        }
        StringBuilder sb = new StringBuilder("tryCameraPreview  ");
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar3 = this.hDt;
        if (aVar3 != null) {
            surfaceTexture2 = aVar3.getSurfaceTexture();
        }
        Log.printInfoStack("MicroMsg.LiveCoreRender", sb.append(surfaceTexture2).toString(), new Object[0]);
        AppMethodBeat.o(196635);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final void aEx() {
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final EGLContext getEGLContext() {
        c.b bVar = this.hDs;
        if (bVar != null) {
            return bVar.ilv;
        }
        return null;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final void setOnDrawListener(kotlin.g.a.b<? super com.tencent.mm.media.g.d, x> bVar) {
        AppMethodBeat.i(196636);
        Log.printInfoStack("MicroMsg.LiveCoreRender", "setOnDrawListener", new Object[0]);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if (aVar != null) {
            aVar.iqL = bVar;
            AppMethodBeat.o(196636);
            return;
        }
        AppMethodBeat.o(196636);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final com.tencent.mm.media.g.d getPreviewTexture() {
        AppMethodBeat.i(196637);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if (aVar != null) {
            com.tencent.mm.media.g.d aQu = aVar.aQu();
            AppMethodBeat.o(196637);
            return aQu;
        }
        AppMethodBeat.o(196637);
        return null;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final com.tencent.mm.plugin.mmsight.model.g getFrameDataCallback() {
        AppMethodBeat.i(196638);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if (aVar != null) {
            com.tencent.mm.plugin.mmsight.model.g frameDataCallback = aVar.getFrameDataCallback();
            AppMethodBeat.o(196638);
            return frameDataCallback;
        }
        AppMethodBeat.o(196638);
        return null;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final void aEy() {
        AppMethodBeat.i(196639);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if (aVar != null) {
            aVar.aEy();
            AppMethodBeat.o(196639);
            return;
        }
        AppMethodBeat.o(196639);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final void release() {
        AppMethodBeat.i(196640);
        Log.i("MicroMsg.LiveCoreRender", "release live render manager");
        j(new C0378d(this));
        AppMethodBeat.o(196640);
    }

    public final void aEz() {
        AppMethodBeat.i(196641);
        j(new b(this));
        AppMethodBeat.o(196641);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.f
    public final void requestRender() {
        AppMethodBeat.i(196642);
        j(new e(this));
        AppMethodBeat.o(196642);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.f
    public final void j(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(196643);
        p.h(aVar, "r");
        this.hDr.post(new e(aVar));
        AppMethodBeat.o(196643);
    }

    public final void bO(Object obj) {
        if (obj != null) {
            this.hDu = null;
            this.hDv = obj;
        }
    }

    public final void e(kotlin.g.a.b<? super Integer, x> bVar) {
        AppMethodBeat.i(196644);
        g gVar = this.hDw;
        if (gVar != null) {
            gVar.g(bVar);
            AppMethodBeat.o(196644);
            return;
        }
        AppMethodBeat.o(196644);
    }

    public final void f(kotlin.g.a.b<? super Integer, x> bVar) {
        AppMethodBeat.i(196645);
        p.h(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        g gVar = this.hDw;
        if (gVar != null) {
            gVar.hDZ = bVar;
            AppMethodBeat.o(196645);
            return;
        }
        AppMethodBeat.o(196645);
    }

    public final ac aEA() {
        int i2;
        com.tencent.mm.media.g.d aQu;
        com.tencent.mm.media.g.d aQu2;
        int i3 = 0;
        AppMethodBeat.i(196646);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if (aVar == null || (aQu2 = aVar.aQu()) == null) {
            i2 = 0;
        } else {
            i2 = aQu2.width;
        }
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar2 = this.hDt;
        if (!(aVar2 == null || (aQu = aVar2.aQu()) == null)) {
            i3 = aQu.height;
        }
        ac acVar = new ac(i2, i3);
        AppMethodBeat.o(196646);
        return acVar;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a hDB;
        final /* synthetic */ d hDz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(d dVar, a aVar) {
            super(0);
            this.hDz = dVar;
            this.hDB = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            a aVar;
            c cVar;
            AppMethodBeat.i(196626);
            g gVar = this.hDz.hDw;
            if (gVar != null) {
                a aVar2 = this.hDB;
                Log.i("MicroMsg.LiveTexEditRenderer", "updateBeautyConfig beautyConfig:" + (aVar2 != null ? aVar2.toString() : null));
                if (aVar2 != null) {
                    gVar.hDV = aVar2;
                    k kVar = gVar.hDS;
                    if (!(kVar == null || (aVar = gVar.hDV) == null || (cVar = kVar.hEw) == null)) {
                        p.h(aVar, "beautyConfig");
                        boolean aEr = aVar.aEr();
                        boolean aEs = aVar.aEs();
                        boolean aEt = aVar.aEt();
                        boolean aEu = aVar.aEu();
                        Log.i(c.TAG, "updateBeautyConfig, needSkin:" + aEr + ", needShape:" + aEs + ", needRosy:" + aEu + " [" + aVar.aEl() + ", " + aVar.aEm() + ", " + aVar.aEn() + ", " + aVar.aEo() + ", " + aVar.aEp() + ", " + aVar.aEq() + ']');
                        com.tencent.mm.plugin.xlabeffect.b bVar = cVar.hiH;
                        if (bVar == null) {
                            p.hyc();
                        }
                        bVar.l(aVar.aEl(), aVar.aEm(), aVar.aEn(), aVar.aEo(), aVar.aEp());
                        if (aEr) {
                            com.tencent.mm.plugin.xlabeffect.b bVar2 = cVar.hiH;
                            if (bVar2 == null) {
                                p.hyc();
                            }
                            bVar2.gli();
                        }
                        if (aEs) {
                            com.tencent.mm.plugin.xlabeffect.b bVar3 = cVar.hiH;
                            if (bVar3 == null) {
                                p.hyc();
                            }
                            bVar3.glk();
                        }
                        if (aEt) {
                            com.tencent.mm.plugin.xlabeffect.b bVar4 = cVar.hiH;
                            if (bVar4 == null) {
                                p.hyc();
                            }
                            com.tencent.mm.plugin.xlabeffect.b.a(bVar4);
                        }
                        if (aEu) {
                            com.tencent.mm.plugin.xlabeffect.b bVar5 = cVar.hiH;
                            if (bVar5 == null) {
                                p.hyc();
                            }
                            bVar5.ahu(aVar.aEq());
                            com.tencent.mm.plugin.xlabeffect.b bVar6 = cVar.hiH;
                            if (bVar6 == null) {
                                p.hyc();
                            }
                            bVar6.glm();
                        }
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(196626);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b hDC;
        final /* synthetic */ d hDz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(d dVar, b bVar) {
            super(0);
            this.hDz = dVar;
            this.hDC = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            b bVar;
            c cVar;
            AppMethodBeat.i(196627);
            g gVar = this.hDz.hDw;
            if (gVar != null) {
                b bVar2 = this.hDC;
                Log.i("MicroMsg.LiveTexEditRenderer", "updateFilterConfig filterConfig:" + (bVar2 != null ? bVar2.toString() : null));
                if (bVar2 != null) {
                    gVar.hDW = bVar2;
                    k kVar = gVar.hDS;
                    if (!(kVar == null || (bVar = gVar.hDW) == null || (cVar = kVar.hEw) == null)) {
                        p.h(bVar, "filterParam");
                        boolean aEv = bVar.aEv();
                        Log.i(c.TAG, "updateFilterConfig, needFilter:" + aEv + ", [" + bVar.hDk + ", " + bVar.hDj + ']');
                        if (aEv) {
                            com.tencent.mm.plugin.xlabeffect.b bVar3 = cVar.hiH;
                            if (bVar3 == null) {
                                p.hyc();
                            }
                            com.tencent.mm.plugin.xlabeffect.b.b(bVar3);
                            com.tencent.mm.plugin.xlabeffect.b bVar4 = cVar.hiH;
                            if (bVar4 == null) {
                                p.hyc();
                            }
                            bVar4.m(bVar.hDj, ((float) bVar.hDk) / 100.0f);
                        } else {
                            com.tencent.mm.plugin.xlabeffect.b bVar5 = cVar.hiH;
                            if (bVar5 == null) {
                                p.hyc();
                            }
                            com.tencent.mm.plugin.xlabeffect.b.b(bVar5);
                        }
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(196627);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ d hDz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(d dVar, kotlin.g.a.b bVar) {
            super(0);
            this.hDz = dVar;
            this.gWe = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            SurfaceTexture surfaceTexture = null;
            AppMethodBeat.i(196625);
            kotlin.g.a.b bVar = this.gWe;
            if (bVar != null) {
                com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDz.hDt;
                bVar.invoke(aVar != null ? aVar.getSurfaceTexture() : null);
            }
            StringBuilder sb = new StringBuilder("tryCameraPreview  ");
            com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar2 = this.hDz.hDt;
            if (aVar2 != null) {
                surfaceTexture = aVar2.getSurfaceTexture();
            }
            Log.printInfoStack("MicroMsg.LiveCoreRender", sb.append(surfaceTexture).toString(), new Object[0]);
            x xVar = x.SXb;
            AppMethodBeat.o(196625);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.live.core.b.d$d  reason: collision with other inner class name */
    public static final class C0378d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d hDz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0378d(d dVar) {
            super(0);
            this.hDz = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            EGLDisplay eGLDisplay;
            AppMethodBeat.i(196622);
            EGLSurface eGLSurface = this.hDz.hDu;
            if (eGLSurface != null) {
                c.b bVar = this.hDz.hDs;
                if (bVar != null) {
                    eGLDisplay = bVar.ilu;
                } else {
                    eGLDisplay = null;
                }
                EGL14.eglDestroySurface(eGLDisplay, eGLSurface);
            }
            g gVar = this.hDz.hDw;
            if (gVar != null) {
                gVar.release(true);
            }
            com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDz.hDt;
            if (aVar != null) {
                aVar.release();
            }
            c.b bVar2 = this.hDz.hDs;
            if (bVar2 != null) {
                c.a aVar2 = com.tencent.mm.media.k.c.ilt;
                c.a.a(bVar2);
            }
            this.hDz.hDr.removeCallbacksAndMessages(null);
            this.hDz.hDq.quitSafely();
            x xVar = x.SXb;
            AppMethodBeat.o(196622);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d hDz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d dVar) {
            super(0);
            this.hDz = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            EGLDisplay eGLDisplay;
            EGLContext eGLContext;
            EGLDisplay eGLDisplay2;
            EGLDisplay eGLDisplay3 = null;
            AppMethodBeat.i(196619);
            c.b bVar = this.hDz.hDs;
            if (bVar != null) {
                eGLDisplay = bVar.ilu;
            } else {
                eGLDisplay = null;
            }
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            c.b bVar2 = this.hDz.hDs;
            if (bVar2 != null) {
                eGLContext = bVar2.ilv;
            } else {
                eGLContext = null;
            }
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
            if (this.hDz.hDu != null) {
                c.b bVar3 = this.hDz.hDs;
                if (bVar3 != null) {
                    eGLDisplay2 = bVar3.ilu;
                } else {
                    eGLDisplay2 = null;
                }
                if (eGLDisplay2 != null) {
                    c.b bVar4 = this.hDz.hDs;
                    if (bVar4 != null) {
                        eGLDisplay3 = bVar4.ilu;
                    }
                    EGL14.eglDestroySurface(eGLDisplay3, this.hDz.hDu);
                    this.hDz.hDu = null;
                    this.hDz.hDv = null;
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(196619);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d hDz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(d dVar) {
            super(0);
            this.hDz = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            SurfaceTexture surfaceTexture;
            AppMethodBeat.i(196623);
            com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDz.hDt;
            if (!(aVar == null || (surfaceTexture = aVar.getSurfaceTexture()) == null)) {
                surfaceTexture.updateTexImage();
            }
            if (this.hDz.hDv != null) {
                d.k(this.hDz);
                com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar2 = this.hDz.hDt;
                if (aVar2 != null) {
                    aVar2.onDrawFrame(null);
                }
                c.b bVar = this.hDz.hDs;
                if (bVar != null) {
                    EGLDisplay eGLDisplay = bVar.ilu;
                    EGLSurface eGLSurface = this.hDz.hDu;
                    if (eGLSurface == null) {
                        eGLSurface = bVar.eglSurface;
                    }
                    EGL14.eglSwapBuffers(eGLDisplay, eGLSurface);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(196623);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ boolean hDD;
        final /* synthetic */ d hDz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(d dVar, boolean z) {
            super(0);
            this.hDz = dVar;
            this.hDD = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(196628);
            g gVar = this.hDz.hDw;
            if (gVar != null) {
                gVar.eD(this.hDD);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(196628);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class j extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int hDE;
        final /* synthetic */ d hDz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(d dVar, int i2) {
            super(0);
            this.hDz = dVar;
            this.hDE = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(196629);
            g gVar = this.hDz.hDw;
            if (gVar != null) {
                int i2 = this.hDE;
                Log.i("MicroMsg.LiveTexEditRenderer", "updateMirrorMode mirrorMode:" + i2 + " mirror:" + gVar.iju);
                gVar.hEb = i2;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(196629);
            return xVar;
        }
    }

    public static final /* synthetic */ void k(d dVar) {
        Object obj;
        EGLDisplay eGLDisplay;
        EGLContext eGLContext = null;
        AppMethodBeat.i(196649);
        if (dVar.hDu != null || (obj = dVar.hDv) == null) {
            AppMethodBeat.o(196649);
        } else if (!(obj instanceof Surface) || ((Surface) obj).isValid()) {
            if (obj instanceof SurfaceHolder) {
                Surface surface = ((SurfaceHolder) obj).getSurface();
                p.g(surface, "this.surface");
                if (!surface.isValid()) {
                    dVar.hDu = null;
                    AppMethodBeat.o(196649);
                    return;
                }
            }
            Log.i("MicroMsg.LiveCoreRender", "makeOutputSurface");
            c.a aVar = com.tencent.mm.media.k.c.ilt;
            c.b bVar = dVar.hDs;
            if (bVar == null) {
                p.hyc();
            }
            dVar.hDu = c.a.a(bVar.ilu, obj);
            c.b bVar2 = dVar.hDs;
            if (bVar2 != null) {
                eGLDisplay = bVar2.ilu;
            } else {
                eGLDisplay = null;
            }
            EGLSurface eGLSurface = dVar.hDu;
            EGLSurface eGLSurface2 = dVar.hDu;
            c.b bVar3 = dVar.hDs;
            if (bVar3 != null) {
                eGLContext = bVar3.ilv;
            }
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
            AppMethodBeat.o(196649);
        } else {
            dVar.hDu = null;
            AppMethodBeat.o(196649);
        }
    }
}

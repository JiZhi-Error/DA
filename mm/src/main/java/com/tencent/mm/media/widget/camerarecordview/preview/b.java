package com.tencent.mm.media.widget.camerarecordview.preview;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLExt;
import android.os.HandlerThread;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\"\u001a\u00020\u000bH\u0016J\n\u0010#\u001a\u0004\u0018\u00010$H\u0016J\n\u0010%\u001a\u0004\u0018\u00010&H\u0016J\n\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u000bH\u0002J\"\u0010*\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010\n2\u0006\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u001fH\u0016J\u0012\u0010.\u001a\u00020\u00052\b\u0010/\u001a\u0004\u0018\u00010\nH\u0016J\"\u00100\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010\n2\u0006\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u001fH\u0016J\u0012\u00101\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u00010\nH\u0016J\u0016\u00102\u001a\u00020\u000b2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0016J\b\u00104\u001a\u00020\u000bH\u0002J\b\u00105\u001a\u00020\u000bH\u0016J\b\u00106\u001a\u00020\u000bH\u0016J/\u00107\u001a\u00020\u000b2%\u00108\u001a!\u0012\u0015\u0012\u0013\u0018\u00010(¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH\u0016J\u0018\u0010;\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010<\u001a\u00020\u0005H\u0016J \u0010=\u001a\u00020\u000b2\u0016\u0010>\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH\u0016J\b\u0010?\u001a\u00020\u000bH\u0016J\u0010\u0010@\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020BH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0018\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001a0\u0019j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001a`\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureRender;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "()V", "canPreview", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "runnableArray", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "surface", "Landroid/view/Surface;", "surfaceHeight", "", "surfaceWidth", "texture", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "initHandlerThread", "onSurfaceTextureAvailable", "surfaceTexture", "width", "height", "onSurfaceTextureDestroyed", "p0", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "queueEvent", "r", "quitHandlerThread", "release", "requestRender", "setOnDrawListener", "frameDrawCallback", "Lkotlin/ParameterName;", "name", "setPreviewRenderer", "cpuCrop", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "Companion", "plugin-mediaeditor_release"})
public final class b implements TextureView.SurfaceTextureListener, e {
    public static final a iqF = new a((byte) 0);
    private com.tencent.mm.media.widget.camerarecordview.preview.a.a hDt;
    private HandlerThread igZ;
    private MMHandler iha;
    com.tencent.mm.media.j.a ihs;
    private c.b ilw;
    private SurfaceTexture ipT;
    private ArrayList<kotlin.g.a.a<x>> iqE = new ArrayList<>();
    private kotlin.g.a.b<? super SurfaceTexture, x> iqw;
    private boolean iqy;
    private Surface surface;
    private int surfaceHeight;
    private int surfaceWidth;

    static {
        AppMethodBeat.i(94332);
        AppMethodBeat.o(94332);
    }

    public b() {
        AppMethodBeat.i(94331);
        aQt();
        AppMethodBeat.o(94331);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureRender$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final void a(com.tencent.mm.media.widget.a.b bVar) {
        AppMethodBeat.i(94317);
        p.h(bVar, "cameraConfig");
        Log.i("MicroMsg.CameraPreviewGLTextureRender", "updateCameraConfig: ".concat(String.valueOf(bVar)));
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if (aVar != null) {
            aVar.a(bVar);
            AppMethodBeat.o(94317);
            return;
        }
        AppMethodBeat.o(94317);
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(94318);
        Log.i("MicroMsg.CameraPreviewGLTextureRender", "onSurfaceTextureSizeChanged, surfaceTexture:" + surfaceTexture + ", width:" + i2 + ", height:" + i3);
        j(new d(this, i2, i3));
        AppMethodBeat.o(94318);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(94319);
        Log.printInfoStack("MicroMsg.CameraPreviewGLTextureRender", "onSurfaceTextureDestroyed", new Object[0]);
        this.iqy = false;
        j(new c(this));
        AppMethodBeat.o(94319);
        return false;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final void release() {
        AppMethodBeat.i(94320);
        j(new e(this));
        AppMethodBeat.o(94320);
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(94321);
        Log.i("MicroMsg.CameraPreviewGLTextureRender", "onSurfaceTextureAvailable, surfaceTexture:" + surfaceTexture + ", width:" + i2 + ", height:" + i3 + ", handler: " + this.iha);
        if (this.iha == null) {
            aQt();
        }
        if (surfaceTexture != null) {
            j(new C0439b(surfaceTexture, this, i2, i3));
            AppMethodBeat.o(94321);
            return;
        }
        AppMethodBeat.o(94321);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final void d(kotlin.g.a.b<? super SurfaceTexture, x> bVar) {
        AppMethodBeat.i(94322);
        Log.printInfoStack("MicroMsg.CameraPreviewGLTextureRender", "tryCameraPreview canPreview:" + this.iqy, new Object[0]);
        if (!this.iqy) {
            this.iqw = bVar;
            AppMethodBeat.o(94322);
        } else if (bVar != null) {
            com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
            bVar.invoke(aVar != null ? aVar.getSurfaceTexture() : null);
            AppMethodBeat.o(94322);
        } else {
            AppMethodBeat.o(94322);
        }
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final void aEx() {
        AppMethodBeat.i(94323);
        Log.printInfoStack("MicroMsg.CameraPreviewGLTextureRender", "tryStopCameraPreview", new Object[0]);
        this.iqw = null;
        AppMethodBeat.o(94323);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final EGLContext getEGLContext() {
        c.b bVar = this.ilw;
        if (bVar != null) {
            return bVar.ilv;
        }
        return null;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final void setOnDrawListener(kotlin.g.a.b<? super com.tencent.mm.media.g.d, x> bVar) {
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if (aVar != null) {
            aVar.iqL = bVar;
        }
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final com.tencent.mm.media.g.d getPreviewTexture() {
        com.tencent.mm.media.j.a aVar = this.ihs;
        if (aVar != null) {
            return aVar.ijq;
        }
        return null;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final void a(com.tencent.mm.media.j.a aVar, boolean z) {
        com.tencent.mm.media.widget.camerarecordview.preview.a.c cVar;
        AppMethodBeat.i(94325);
        p.h(aVar, "renderer");
        Log.i("MicroMsg.CameraPreviewGLTextureRender", "setRenderer:" + aVar.hashCode() + "  cpuCrop:" + z);
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
        }
        this.ihs = aVar;
        AppMethodBeat.o(94325);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.f
    public final void requestRender() {
        AppMethodBeat.i(94326);
        j(new f(this));
        AppMethodBeat.o(94326);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.f
    public final void j(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(94327);
        p.h(aVar, "r");
        if (this.iha != null) {
            MMHandler mMHandler = this.iha;
            if (mMHandler != null) {
                mMHandler.post(new c(aVar));
                AppMethodBeat.o(94327);
                return;
            }
            AppMethodBeat.o(94327);
            return;
        }
        this.iqE.add(aVar);
        AppMethodBeat.o(94327);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final g getFrameDataCallback() {
        AppMethodBeat.i(94328);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if (aVar != null) {
            g frameDataCallback = aVar.getFrameDataCallback();
            AppMethodBeat.o(94328);
            return frameDataCallback;
        }
        AppMethodBeat.o(94328);
        return null;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final void aEy() {
        AppMethodBeat.i(94329);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if (aVar != null) {
            aVar.aEy();
            AppMethodBeat.o(94329);
            return;
        }
        AppMethodBeat.o(94329);
    }

    private final void aQt() {
        AppMethodBeat.i(94330);
        HandlerThread hC = com.tencent.f.c.d.hC("CameraPreviewTextureView_renderThread", -2);
        hC.start();
        this.iha = new MMHandler(hC.getLooper());
        ArrayList<kotlin.g.a.a<x>> arrayList = new ArrayList();
        arrayList.addAll(this.iqE);
        this.iqE.clear();
        for (kotlin.g.a.a<x> aVar : arrayList) {
            j(aVar);
        }
        this.igZ = hC;
        AppMethodBeat.o(94330);
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int cKE;
        final /* synthetic */ int cKF;
        final /* synthetic */ b iqG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar, int i2, int i3) {
            super(0);
            this.iqG = bVar;
            this.cKE = i2;
            this.cKF = i3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(94313);
            this.iqG.surfaceWidth = this.cKE;
            this.iqG.surfaceHeight = this.cKF;
            com.tencent.mm.media.j.a aVar = this.iqG.ihs;
            if (aVar != null) {
                aVar.cY(this.iqG.surfaceWidth, this.iqG.surfaceHeight);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(94313);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b iqG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar) {
            super(0);
            this.iqG = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(94312);
            com.tencent.mm.media.j.a aVar = this.iqG.ihs;
            if (aVar != null) {
                aVar.release(true);
            }
            this.iqG.ihs = null;
            c.b bVar = this.iqG.ilw;
            if (bVar != null) {
                EGL14.eglDestroyContext(bVar.ilu, bVar.ilv);
                EGL14.eglDestroySurface(bVar.ilu, bVar.eglSurface);
                bVar.eglSurface = EGL14.EGL_NO_SURFACE;
                EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
                p.g(eGLContext, "EGL14.EGL_NO_CONTEXT");
                bVar.a(eGLContext);
                b.d(this.iqG);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(94312);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b iqG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(b bVar) {
            super(0);
            this.iqG = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(94314);
            com.tencent.mm.media.j.a aVar = this.iqG.ihs;
            if (aVar != null) {
                aVar.release(true);
            }
            this.iqG.ihs = null;
            x xVar = x.SXb;
            AppMethodBeat.o(94314);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureRender$onSurfaceTextureAvailable$1$1"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.preview.b$b  reason: collision with other inner class name */
    static final class C0439b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ SurfaceTexture hAH;
        final /* synthetic */ int ifE;
        final /* synthetic */ int ifF;
        final /* synthetic */ b iqG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0439b(SurfaceTexture surfaceTexture, b bVar, int i2, int i3) {
            super(0);
            this.hAH = surfaceTexture;
            this.iqG = bVar;
            this.ifE = i2;
            this.ifF = i3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            SurfaceTexture surfaceTexture = null;
            AppMethodBeat.i(94311);
            this.iqG.ipT = this.hAH;
            this.iqG.surfaceWidth = this.ifE;
            this.iqG.surfaceHeight = this.ifF;
            this.iqG.surface = new Surface(this.iqG.ipT);
            this.iqG.ilw = c.a.a(com.tencent.mm.media.k.c.ilt, this.iqG.surface, 0, 0, null, 30);
            com.tencent.mm.media.j.a aVar = this.iqG.ihs;
            if (aVar != null) {
                aVar.onSurfaceCreated(null, null);
            }
            com.tencent.mm.media.j.a aVar2 = this.iqG.ihs;
            if (aVar2 != null) {
                aVar2.cY(this.ifE, this.ifF);
            }
            com.tencent.mm.media.j.a aVar3 = this.iqG.ihs;
            if (aVar3 != null) {
                aVar3.eY(true);
            }
            this.iqG.iqy = true;
            Log.i("MicroMsg.CameraPreviewGLTextureRender", "previewCallback?.invoke");
            kotlin.g.a.b bVar = this.iqG.iqw;
            if (bVar != null) {
                com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar4 = this.iqG.hDt;
                if (aVar4 != null) {
                    surfaceTexture = aVar4.getSurfaceTexture();
                }
                bVar.invoke(surfaceTexture);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(94311);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b iqG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(b bVar) {
            super(0);
            this.iqG = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            SurfaceTexture surfaceTexture;
            AppMethodBeat.i(94315);
            com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.iqG.hDt;
            if (!(aVar == null || (surfaceTexture = aVar.getSurfaceTexture()) == null)) {
                surfaceTexture.updateTexImage();
            }
            com.tencent.mm.media.j.a aVar2 = this.iqG.ihs;
            if (aVar2 != null) {
                aVar2.onDrawFrame(null);
            }
            c.b bVar = this.iqG.ilw;
            if (bVar != null) {
                EGLExt.eglPresentationTimeANDROID(bVar.ilu, bVar.eglSurface, System.nanoTime());
                EGL14.eglSwapBuffers(bVar.ilu, bVar.eglSurface);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(94315);
            return xVar;
        }
    }

    public static final /* synthetic */ void d(b bVar) {
        AppMethodBeat.i(94333);
        HandlerThread handlerThread = bVar.igZ;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        bVar.igZ = null;
        bVar.iha = null;
        AppMethodBeat.o(94333);
    }
}

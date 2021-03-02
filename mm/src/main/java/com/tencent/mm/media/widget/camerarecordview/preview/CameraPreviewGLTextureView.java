package com.tencent.mm.media.widget.camerarecordview.preview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLExt;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 J2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001JB#\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u001b\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bB\u0011\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\b\u0010*\u001a\u00020\u0014H\u0016J\n\u0010+\u001a\u0004\u0018\u00010,H\u0016J\n\u0010-\u001a\u0004\u0018\u00010.H\u0016J\n\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\u0014H\u0002J\"\u00102\u001a\u00020\u00142\b\u00103\u001a\u0004\u0018\u00010\u00132\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tH\u0016J\u0012\u00106\u001a\u00020\u000e2\b\u00107\u001a\u0004\u0018\u00010\u0013H\u0016J\"\u00108\u001a\u00020\u00142\b\u00103\u001a\u0004\u0018\u00010\u00132\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tH\u0016J\u0016\u00109\u001a\u00020\u00142\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00140#H\u0016J\b\u0010;\u001a\u00020\u0014H\u0002J\b\u0010<\u001a\u00020\u0014H\u0016J\b\u0010=\u001a\u00020\u0014H\u0016J/\u0010>\u001a\u00020\u00142%\u0010?\u001a!\u0012\u0015\u0012\u0013\u0018\u000100¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0016J\u0018\u0010B\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020\u000eH\u0016J \u0010D\u001a\u00020\u00142\u0016\u0010E\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0016J\b\u0010F\u001a\u00020\u0014H\u0016J\u0010\u0010G\u001a\u00020\u00142\u0006\u0010H\u001a\u00020IH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010!\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140#0\"j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140#`$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView;", "Lcom/tencent/mm/plugin/video/ObservableTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "canPreview", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "runnableArray", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "surface", "Landroid/view/Surface;", "surfaceHeight", "surfaceWidth", "texture", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "initHandlerThread", "onSurfaceTextureAvailable", "surfaceTexture", "width", "height", "onSurfaceTextureDestroyed", "p0", "onSurfaceTextureSizeChanged", "queueEvent", "r", "quitHandlerThread", "release", "requestRender", "setOnDrawListener", "frameDrawCallback", "Lkotlin/ParameterName;", "name", "setPreviewRenderer", "cpuCrop", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "Companion", "plugin-mediaeditor_release"})
public class CameraPreviewGLTextureView extends ObservableTextureView implements TextureView.SurfaceTextureListener, e {
    public static final a iqH = new a((byte) 0);
    private com.tencent.mm.media.widget.camerarecordview.preview.a.a hDt;
    private HandlerThread igZ;
    private MMHandler iha;
    private com.tencent.mm.media.j.a ihs;
    private c.b ilw;
    private SurfaceTexture ipT;
    private ArrayList<kotlin.g.a.a<x>> iqE = new ArrayList<>();
    private kotlin.g.a.b<? super SurfaceTexture, x> iqw;
    private boolean iqy;
    private Surface surface;
    private int surfaceHeight;
    private int surfaceWidth;

    static {
        AppMethodBeat.i(94356);
        AppMethodBeat.o(94356);
    }

    public static final /* synthetic */ void a(CameraPreviewGLTextureView cameraPreviewGLTextureView, SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(94358);
        super.onSurfaceTextureAvailable(surfaceTexture, i2, i3);
        AppMethodBeat.o(94358);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public CameraPreviewGLTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(94353);
        setSurfaceTextureListener(this);
        aQt();
        AppMethodBeat.o(94353);
    }

    public CameraPreviewGLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(94354);
        setSurfaceTextureListener(this);
        aQt();
        AppMethodBeat.o(94354);
    }

    public CameraPreviewGLTextureView(Context context) {
        super(context);
        AppMethodBeat.i(94355);
        setSurfaceTextureListener(this);
        aQt();
        AppMethodBeat.o(94355);
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.media.j.a getRenderer() {
        return this.ihs;
    }

    /* access modifiers changed from: protected */
    public final void setRenderer(com.tencent.mm.media.j.a aVar) {
        this.ihs = aVar;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final void a(com.tencent.mm.media.widget.a.b bVar) {
        AppMethodBeat.i(94339);
        p.h(bVar, "cameraConfig");
        Log.i("MicroMsg.CameraPreviewGLTextureView", "updateCameraConfig: ".concat(String.valueOf(bVar)));
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if (aVar != null) {
            aVar.a(bVar);
            AppMethodBeat.o(94339);
            return;
        }
        AppMethodBeat.o(94339);
    }

    @Override // com.tencent.mm.plugin.video.ObservableTextureView
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(94340);
        super.onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        Log.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureSizeChanged, surfaceTexture:" + surfaceTexture + ", width:" + i2 + ", height:" + i3);
        j(new d(this, i2, i3));
        AppMethodBeat.o(94340);
    }

    @Override // com.tencent.mm.plugin.video.ObservableTextureView
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(94341);
        super.onSurfaceTextureDestroyed(surfaceTexture);
        Log.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureDestroyed");
        this.iqy = false;
        j(new c(this));
        AppMethodBeat.o(94341);
        return false;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final void release() {
        AppMethodBeat.i(94342);
        com.tencent.mm.media.j.a aVar = this.ihs;
        if (aVar != null) {
            aVar.release(true);
        }
        this.ihs = null;
        setSurfaceTextureListener(null);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar2 = this.hDt;
        if (aVar2 != null) {
            aVar2.release();
            AppMethodBeat.o(94342);
            return;
        }
        AppMethodBeat.o(94342);
    }

    @Override // com.tencent.mm.plugin.video.ObservableTextureView
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(94343);
        Log.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureAvailable, surfaceTexture:" + surfaceTexture + ", width:" + i2 + ", height:" + i3 + ", handler: " + this.iha);
        if (this.iha == null) {
            aQt();
        }
        if (surfaceTexture != null) {
            j(new b(surfaceTexture, this, i2, i3, surfaceTexture));
            AppMethodBeat.o(94343);
            return;
        }
        AppMethodBeat.o(94343);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final void d(kotlin.g.a.b<? super SurfaceTexture, x> bVar) {
        AppMethodBeat.i(94344);
        Log.printInfoStack("MicroMsg.CameraPreviewGLTextureView", "tryCameraPreview canPreview:" + this.iqy, new Object[0]);
        if (!this.iqy) {
            this.iqw = bVar;
            AppMethodBeat.o(94344);
        } else if (bVar != null) {
            com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
            bVar.invoke(aVar != null ? aVar.getSurfaceTexture() : null);
            AppMethodBeat.o(94344);
        } else {
            AppMethodBeat.o(94344);
        }
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final void aEx() {
        AppMethodBeat.i(94345);
        Log.printInfoStack("MicroMsg.CameraPreviewGLTextureView", "tryStopCameraPreview", new Object[0]);
        this.iqw = null;
        AppMethodBeat.o(94345);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public EGLContext getEGLContext() {
        c.b bVar = this.ilw;
        if (bVar != null) {
            return bVar.ilv;
        }
        return null;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public void setOnDrawListener(kotlin.g.a.b<? super com.tencent.mm.media.g.d, x> bVar) {
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if (aVar != null) {
            aVar.iqL = bVar;
        }
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public com.tencent.mm.media.g.d getPreviewTexture() {
        com.tencent.mm.media.j.a aVar = this.ihs;
        if (aVar != null) {
            return aVar.ijq;
        }
        return null;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final void a(com.tencent.mm.media.j.a aVar, boolean z) {
        com.tencent.mm.media.widget.camerarecordview.preview.a.c cVar;
        AppMethodBeat.i(94347);
        p.h(aVar, "renderer");
        Log.i("MicroMsg.CameraPreviewGLTextureView", "setRenderer:" + aVar.hashCode() + "  cpuCrop:" + z);
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
        AppMethodBeat.o(94347);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.f
    public void requestRender() {
        AppMethodBeat.i(94348);
        j(new e(this));
        AppMethodBeat.o(94348);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.f
    public final void j(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(94349);
        p.h(aVar, "r");
        if (this.iha != null) {
            MMHandler mMHandler = this.iha;
            if (mMHandler != null) {
                mMHandler.post(new d(aVar));
                AppMethodBeat.o(94349);
                return;
            }
            AppMethodBeat.o(94349);
            return;
        }
        this.iqE.add(aVar);
        AppMethodBeat.o(94349);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public g getFrameDataCallback() {
        AppMethodBeat.i(94350);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if (aVar != null) {
            g frameDataCallback = aVar.getFrameDataCallback();
            AppMethodBeat.o(94350);
            return frameDataCallback;
        }
        AppMethodBeat.o(94350);
        return null;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public final void aEy() {
        AppMethodBeat.i(94351);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if (aVar != null) {
            aVar.aEy();
            AppMethodBeat.o(94351);
            return;
        }
        AppMethodBeat.o(94351);
    }

    private final void aQt() {
        AppMethodBeat.i(94352);
        HandlerThread hz = com.tencent.f.c.d.hz("CameraPreviewTextureView_renderThread", -2);
        hz.start();
        this.iha = new MMHandler(hz.getLooper());
        ArrayList<kotlin.g.a.a<x>> arrayList = new ArrayList();
        arrayList.addAll(this.iqE);
        this.iqE.clear();
        for (kotlin.g.a.a<x> aVar : arrayList) {
            j(aVar);
        }
        this.igZ = hz;
        AppMethodBeat.o(94352);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int cKE;
        final /* synthetic */ int cKF;
        final /* synthetic */ CameraPreviewGLTextureView iqI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(CameraPreviewGLTextureView cameraPreviewGLTextureView, int i2, int i3) {
            super(0);
            this.iqI = cameraPreviewGLTextureView;
            this.cKE = i2;
            this.cKF = i3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(94336);
            this.iqI.surfaceWidth = this.cKE;
            this.iqI.surfaceHeight = this.cKF;
            com.tencent.mm.media.j.a renderer = this.iqI.getRenderer();
            if (renderer != null) {
                renderer.cY(this.iqI.surfaceWidth, this.iqI.surfaceHeight);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(94336);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ CameraPreviewGLTextureView iqI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(CameraPreviewGLTextureView cameraPreviewGLTextureView) {
            super(0);
            this.iqI = cameraPreviewGLTextureView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(94335);
            com.tencent.mm.media.j.a renderer = this.iqI.getRenderer();
            if (renderer != null) {
                renderer.release(true);
            }
            c.b bVar = this.iqI.ilw;
            if (bVar != null) {
                EGL14.eglDestroyContext(bVar.ilu, bVar.ilv);
                EGL14.eglDestroySurface(bVar.ilu, bVar.eglSurface);
                Surface surface = this.iqI.surface;
                if (surface != null) {
                    surface.release();
                }
                SurfaceTexture surfaceTexture = this.iqI.ipT;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                }
                CameraPreviewGLTextureView.f(this.iqI);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(94335);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView$onSurfaceTextureAvailable$1$1"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ SurfaceTexture hAH;
        final /* synthetic */ int ifE;
        final /* synthetic */ int ifF;
        final /* synthetic */ CameraPreviewGLTextureView iqI;
        final /* synthetic */ SurfaceTexture iqJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(SurfaceTexture surfaceTexture, CameraPreviewGLTextureView cameraPreviewGLTextureView, int i2, int i3, SurfaceTexture surfaceTexture2) {
            super(0);
            this.hAH = surfaceTexture;
            this.iqI = cameraPreviewGLTextureView;
            this.ifE = i2;
            this.ifF = i3;
            this.iqJ = surfaceTexture2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            SurfaceTexture surfaceTexture = null;
            AppMethodBeat.i(94334);
            this.iqI.ipT = this.hAH;
            this.iqI.surfaceWidth = this.ifE;
            this.iqI.surfaceHeight = this.ifF;
            this.iqI.surface = new Surface(this.iqI.ipT);
            this.iqI.ilw = c.a.a(com.tencent.mm.media.k.c.ilt, this.iqI.surface, 0, 0, null, 16);
            com.tencent.mm.media.j.a renderer = this.iqI.getRenderer();
            if (renderer != null) {
                renderer.onSurfaceCreated(null, null);
            }
            com.tencent.mm.media.j.a renderer2 = this.iqI.getRenderer();
            if (renderer2 != null) {
                renderer2.cY(this.ifE, this.ifF);
            }
            com.tencent.mm.media.j.a renderer3 = this.iqI.getRenderer();
            if (renderer3 != null) {
                renderer3.eY(true);
            }
            CameraPreviewGLTextureView.a(this.iqI, this.iqJ, this.ifE, this.ifF);
            this.iqI.iqy = true;
            Log.i("MicroMsg.CameraPreviewGLTextureView", "previewCallback?.invoke");
            kotlin.g.a.b bVar = this.iqI.iqw;
            if (bVar != null) {
                com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.iqI.hDt;
                if (aVar != null) {
                    surfaceTexture = aVar.getSurfaceTexture();
                }
                bVar.invoke(surfaceTexture);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(94334);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ CameraPreviewGLTextureView iqI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(CameraPreviewGLTextureView cameraPreviewGLTextureView) {
            super(0);
            this.iqI = cameraPreviewGLTextureView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            SurfaceTexture surfaceTexture;
            AppMethodBeat.i(94337);
            com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.iqI.hDt;
            if (!(aVar == null || (surfaceTexture = aVar.getSurfaceTexture()) == null)) {
                surfaceTexture.updateTexImage();
            }
            com.tencent.mm.media.j.a renderer = this.iqI.getRenderer();
            if (renderer != null) {
                renderer.onDrawFrame(null);
            }
            c.b bVar = this.iqI.ilw;
            if (bVar != null) {
                EGLExt.eglPresentationTimeANDROID(bVar.ilu, bVar.eglSurface, System.nanoTime());
                EGL14.eglSwapBuffers(bVar.ilu, bVar.eglSurface);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(94337);
            return xVar;
        }
    }

    public static final /* synthetic */ void f(CameraPreviewGLTextureView cameraPreviewGLTextureView) {
        AppMethodBeat.i(94357);
        HandlerThread handlerThread = cameraPreviewGLTextureView.igZ;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        cameraPreviewGLTextureView.igZ = null;
        cameraPreviewGLTextureView.iha = null;
        AppMethodBeat.o(94357);
    }
}

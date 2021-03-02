package com.tencent.mm.media.widget.camerarecordview.preview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.widget.camerarecordview.preview.a.c;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J)\u0010\u0016\u001a\u00020\u00102!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00100\u000eJ\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010\f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\tH\u0016J\u0016\u0010!\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100#H\u0016J\b\u0010$\u001a\u00020\u0010H\u0016J/\u0010%\u001a\u00020\u00102%\u0010&\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u001f¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eH\u0016J\u0018\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\tH\u0016J*\u0010,\u001a\u00020\u00102\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000bH\u0016J\u0012\u00102\u001a\u00020\u00102\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0012\u00103\u001a\u00020\u00102\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J \u00104\u001a\u00020\u00102\u0016\u0010\u0017\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eH\u0016J\b\u00105\u001a\u00020\u0010H\u0016J\u0010\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u000208H\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "Landroid/opengl/GLSurfaceView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "canPreview", "", "frameRotate", "", "ignoreRender", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getEGLSurface", "callback", "Landroid/opengl/EGLSurface;", "Lkotlin/ParameterName;", "name", "eglSurface", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "ignore", "queueEvent", "r", "Lkotlin/Function0;", "release", "setOnDrawListener", "frameAvailableListener", "texture", "setPreviewRenderer", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "cpuCrop", "surfaceChanged", "holder", "Landroid/view/SurfaceHolder;", "format", "w", "h", "surfaceCreated", "surfaceDestroyed", "tryCameraPreview", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "Companion", "plugin-mediaeditor_release"})
public class CameraPreviewGLSurfaceView extends GLSurfaceView implements e {
    public static final a iqA = new a((byte) 0);
    private com.tencent.mm.media.widget.camerarecordview.preview.a.a hDt;
    private b<? super SurfaceTexture, x> iqw;
    private int iqx;
    private boolean iqy;
    private boolean iqz;

    static {
        AppMethodBeat.i(94310);
        AppMethodBeat.o(94310);
    }

    public CameraPreviewGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(94309);
        getHolder().addCallback(this);
        try {
            getHolder().setType(2);
        } catch (Exception e2) {
            try {
                getHolder().setType(1);
            } catch (Exception e3) {
                try {
                    getHolder().setType(0);
                } catch (Exception e4) {
                }
            }
        }
        setEGLContextFactory(new com.tencent.mm.media.j.a.b());
        setEGLContextClientVersion(MultiProcessMMKV.getMMKV("mmkv_gl_key").decodeInt("support_egl_context_client_version", 3));
        setEGLConfigChooser(new com.tencent.mm.media.j.a.a());
        setPreserveEGLContextOnPause(false);
        setRenderer(new GLSurfaceView.Renderer(this) {
            /* class com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView.AnonymousClass1 */
            final /* synthetic */ CameraPreviewGLSurfaceView iqB;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.iqB = r1;
            }

            public final void onDrawFrame(GL10 gl10) {
                com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar;
                AppMethodBeat.i(94292);
                if (this.iqB.iqz || (aVar = this.iqB.hDt) == null) {
                    AppMethodBeat.o(94292);
                    return;
                }
                aVar.onDrawFrame(gl10);
                AppMethodBeat.o(94292);
            }

            public final void onSurfaceChanged(GL10 gl10, int i2, int i3) {
                AppMethodBeat.i(94293);
                Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "onSurfaceChanged width:" + i2 + " height:" + i3, new Object[0]);
                com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.iqB.hDt;
                if (aVar != null) {
                    aVar.a(this.iqB.iqx, new a(this, gl10, i2, i3));
                    AppMethodBeat.o(94293);
                    return;
                }
                AppMethodBeat.o(94293);
            }

            public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
                AppMethodBeat.i(94294);
                Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "onSurfaceCreated", new Object[0]);
                com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.iqB.hDt;
                if (aVar != null) {
                    aVar.onSurfaceCreated(gl10, eGLConfig);
                    AppMethodBeat.o(94294);
                    return;
                }
                AppMethodBeat.o(94294);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
            /* renamed from: com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView$1$a */
            static final class a extends q implements kotlin.g.a.a<x> {
                final /* synthetic */ int cKE;
                final /* synthetic */ int cKF;
                final /* synthetic */ AnonymousClass1 iqC;
                final /* synthetic */ GL10 iqD;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                a(AnonymousClass1 r2, GL10 gl10, int i2, int i3) {
                    super(0);
                    this.iqC = r2;
                    this.iqD = gl10;
                    this.cKE = i2;
                    this.cKF = i3;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    SurfaceTexture surfaceTexture;
                    d aQu;
                    SurfaceTexture surfaceTexture2 = null;
                    AppMethodBeat.i(94291);
                    Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "previewController initRender  " + (this.iqC.iqB.iqw == null), new Object[0]);
                    com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.iqC.iqB.hDt;
                    if (aVar != null) {
                        aVar.onSurfaceChanged(this.iqD, this.cKE, this.cKF);
                    }
                    com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar2 = this.iqC.iqB.hDt;
                    if (!(aVar2 == null || (aQu = aVar2.aQu()) == null)) {
                        aQu.setSize(this.cKE, this.cKF);
                    }
                    this.iqC.iqB.iqy = true;
                    if (this.iqC.iqB.iqw != null) {
                        StringBuilder sb = new StringBuilder("callback.invoke  ");
                        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar3 = this.iqC.iqB.hDt;
                        if (aVar3 != null) {
                            surfaceTexture = aVar3.getSurfaceTexture();
                        } else {
                            surfaceTexture = null;
                        }
                        Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", sb.append(surfaceTexture).toString(), new Object[0]);
                        b bVar = this.iqC.iqB.iqw;
                        if (bVar != null) {
                            com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar4 = this.iqC.iqB.hDt;
                            if (aVar4 != null) {
                                surfaceTexture2 = aVar4.getSurfaceTexture();
                            }
                            bVar.invoke(surfaceTexture2);
                        }
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(94291);
                    return xVar;
                }
            }
        });
        setRenderMode(0);
        Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "init create CameraPreviewGLSurfaceView", new Object[0]);
        AppMethodBeat.o(94309);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public void a(com.tencent.mm.media.j.a aVar, boolean z) {
        c cVar;
        AppMethodBeat.i(94296);
        p.h(aVar, "renderer");
        Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "setPreviewRenderer cpuCrop:".concat(String.valueOf(z)), new Object[0]);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar2 = this.hDt;
        if (aVar2 != null) {
            aVar2.release();
        }
        if (z) {
            cVar = new com.tencent.mm.media.widget.camerarecordview.preview.a.b(this);
        } else {
            cVar = new c(this);
        }
        this.hDt = cVar;
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar3 = this.hDt;
        if (aVar3 != null) {
            aVar3.b(aVar);
            AppMethodBeat.o(94296);
            return;
        }
        AppMethodBeat.o(94296);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public void a(com.tencent.mm.media.widget.a.b bVar) {
        AppMethodBeat.i(94297);
        p.h(bVar, "cameraConfig");
        Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "updateCameraConfig:".concat(String.valueOf(bVar)), new Object[0]);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if (aVar != null) {
            aVar.a(bVar);
            AppMethodBeat.o(94297);
            return;
        }
        AppMethodBeat.o(94297);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public void d(b<? super SurfaceTexture, x> bVar) {
        SurfaceTexture surfaceTexture = null;
        AppMethodBeat.i(94298);
        Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "tryCameraPreview  canPreview:" + this.iqy, new Object[0]);
        if (this.iqy) {
            StringBuilder sb = new StringBuilder("callback.invoke  ");
            com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
            Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", sb.append(aVar != null ? aVar.getSurfaceTexture() : null).toString(), new Object[0]);
            if (bVar != null) {
                com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar2 = this.hDt;
                if (aVar2 != null) {
                    surfaceTexture = aVar2.getSurfaceTexture();
                }
                bVar.invoke(surfaceTexture);
                AppMethodBeat.o(94298);
                return;
            }
            AppMethodBeat.o(94298);
            return;
        }
        this.iqw = bVar;
        AppMethodBeat.o(94298);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public void aEx() {
        AppMethodBeat.i(94299);
        Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "tryStopCameraPreview", new Object[0]);
        this.iqw = null;
        AppMethodBeat.o(94299);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public void setOnDrawListener(b<? super d, x> bVar) {
        AppMethodBeat.i(94300);
        Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "setOnDrawListener", new Object[0]);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if (aVar != null) {
            aVar.iqL = bVar;
            AppMethodBeat.o(94300);
            return;
        }
        AppMethodBeat.o(94300);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public d getPreviewTexture() {
        AppMethodBeat.i(218885);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if (aVar != null) {
            d aQu = aVar.aQu();
            AppMethodBeat.o(218885);
            return aQu;
        }
        AppMethodBeat.o(218885);
        return null;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public EGLContext getEGLContext() {
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if (aVar != null) {
            return aVar.ilv;
        }
        return null;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public void release() {
        AppMethodBeat.i(94302);
        getHolder().removeCallback(this);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if (aVar != null) {
            aVar.release();
        }
        this.iqy = false;
        AppMethodBeat.o(94302);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public void aEy() {
        AppMethodBeat.i(94303);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if (aVar != null) {
            aVar.aEy();
            AppMethodBeat.o(94303);
            return;
        }
        AppMethodBeat.o(94303);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e
    public g getFrameDataCallback() {
        AppMethodBeat.i(94304);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if (aVar != null) {
            g frameDataCallback = aVar.getFrameDataCallback();
            AppMethodBeat.o(94304);
            return frameDataCallback;
        }
        AppMethodBeat.o(94304);
        return null;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.f
    public void j(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(94305);
        p.h(aVar, "r");
        queueEvent(new a(aVar));
        AppMethodBeat.o(94305);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        AppMethodBeat.i(94306);
        Log.i("MicroMsg.CameraPreviewGLSurfaceView", "surfaceChanged:" + (surfaceHolder != null ? surfaceHolder.getSurface() : null) + ", format:" + i2 + ", w:" + i3 + ", h:" + i4);
        super.surfaceChanged(surfaceHolder, i2, i3, i4);
        AppMethodBeat.o(94306);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(94307);
        Log.i("MicroMsg.CameraPreviewGLSurfaceView", "surfaceDestroyed: " + (surfaceHolder != null ? surfaceHolder.getSurface() : null));
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.hDt;
        if (aVar != null) {
            aVar.release();
        }
        this.iqy = false;
        super.surfaceDestroyed(surfaceHolder);
        AppMethodBeat.o(94307);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(94308);
        Log.i("MicroMsg.CameraPreviewGLSurfaceView", "surfaceCreated: " + (surfaceHolder != null ? surfaceHolder.getSurface() : null));
        super.surfaceCreated(surfaceHolder);
        AppMethodBeat.o(94308);
    }
}

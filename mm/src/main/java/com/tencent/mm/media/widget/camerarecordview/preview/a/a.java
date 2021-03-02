package com.tencent.mm.media.widget.camerarecordview.preview.a;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Display;
import android.view.WindowManager;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.widget.camerarecordview.preview.f;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.wxmm.v2helper;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'H\u0002J\u0006\u0010(\u001a\u00020\u0011J\u0012\u0010)\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u0004\u0018\u00010\nJ)\u0010-\u001a\u00020\u00112!\u0010.\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00110\u000eJ\n\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u0004\u0018\u000102J\b\u00103\u001a\u0004\u0018\u00010\u0013J(\u00104\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u00020\u00062\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u000108J\u000e\u00109\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010:\u001a\u00020\u00112\b\u0010;\u001a\u0004\u0018\u00010<J \u0010=\u001a\u00020\u00112\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010>\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u0006J\u001a\u0010@\u001a\u00020\u00112\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010A\u001a\u0004\u0018\u00010BJ\u0006\u0010C\u001a\u00020\u0011J/\u0010D\u001a\u00020\u00112%\u0010E\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eH\u0016J\u0010\u0010F\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0017J)\u0010\u001d\u001a\u00020\u00112!\u0010.\u001a\u001d\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00110\u000eJ\u0010\u0010G\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'H\u0016J\u0006\u0010H\u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R+\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R-\u0010\u0012\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R+\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010\u0004¨\u0006I"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;)V", "ROTATION_FIX", "", "drawHeight", "drawWidth", "eglContext", "Landroid/opengl/EGLContext;", "eglSurface", "Landroid/opengl/EGLSurface;", "eglSurfaceCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "frameDrawCallback", "Lcom/tencent/mm/media/globject/GLTextureObject;", "texture", "renderOutputBuffer", "Ljava/nio/IntBuffer;", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "takePicture", "", "takePictureCallback", "Landroid/graphics/Bitmap;", "bitmap", "getView", "()Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "setView", "actualRenderRotation", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "clearFrame", "drawFrame", "data", "", "getEGLContext", "getEGLSurface", "callback", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "getTextureObject", "initRender", "createSurfaceTexture", "frameRotate", "afterInitRender", "Lkotlin/Function0;", "input", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "setOnDrawListener", "frameAvailableListener", "setRender", "updateCameraConfig", "updateImageTexture", "plugin-mediaeditor_release"})
public abstract class a {
    private EGLSurface eglSurface;
    private int hEp;
    private int hEq;
    com.tencent.mm.media.j.a ihs;
    public EGLContext ilv;
    private kotlin.g.a.b<? super EGLSurface, x> iqK;
    public kotlin.g.a.b<? super d, x> iqL;
    private IntBuffer iqM;
    private boolean iqN;
    private kotlin.g.a.b<? super Bitmap, x> iqO;
    private final int iqP = v2helper.VOIP_ENC_HEIGHT_LV1;
    f iqQ;

    public a(f fVar) {
        p.h(fVar, "view");
        this.iqQ = fVar;
    }

    public g getFrameDataCallback() {
        return null;
    }

    public void b(com.tencent.mm.media.j.a aVar) {
        p.h(aVar, "renderer");
        this.ihs = aVar;
        com.tencent.mm.media.j.a aVar2 = this.ihs;
        if (aVar2 != null) {
            aVar2.ijw = new c(this, aVar);
        }
    }

    public final void onDrawFrame(GL10 gl10) {
        com.tencent.mm.media.j.a aVar = this.ihs;
        if (aVar != null) {
            aVar.onDrawFrame(gl10);
        }
        if (this.iqN) {
            this.iqN = false;
            this.iqM = IntBuffer.allocate(this.hEq * this.hEp);
            IntBuffer intBuffer = this.iqM;
            if (intBuffer == null) {
                p.hyc();
            }
            intBuffer.position(0);
            GLES20.glReadPixels(0, 0, this.hEp, this.hEq, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.iqM);
            Bitmap createBitmap = Bitmap.createBitmap(this.hEp, this.hEq, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(this.iqM);
            Matrix matrix = new Matrix();
            matrix.preScale(-1.0f, 1.0f);
            matrix.preRotate(180.0f);
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, this.hEp, this.hEq, matrix, false);
            createBitmap.recycle();
            kotlin.g.a.b<? super Bitmap, x> bVar = this.iqO;
            if (bVar != null) {
                p.g(createBitmap2, "bmp");
                bVar.invoke(createBitmap2);
            }
        }
    }

    public final void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        this.hEp = i2;
        this.hEq = i3;
        com.tencent.mm.media.j.a aVar = this.ihs;
        if (aVar != null) {
            aVar.onSurfaceChanged(gl10, i2, i3);
        }
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.ilv = EGL14.eglGetCurrentContext();
        this.eglSurface = EGL14.eglGetCurrentSurface(12377);
        kotlin.g.a.b<? super EGLSurface, x> bVar = this.iqK;
        if (bVar != null) {
            EGLSurface eGLSurface = this.eglSurface;
            if (eGLSurface == null) {
                p.hyc();
            }
            bVar.invoke(eGLSurface);
        }
        this.iqK = null;
        com.tencent.mm.media.j.a aVar = this.ihs;
        if (aVar != null) {
            aVar.onSurfaceCreated(gl10, eGLConfig);
        }
    }

    public final void a(int i2, kotlin.g.a.a<x> aVar) {
        this.iqQ.j(new C0438a(this, aVar, i2));
    }

    public final void a(com.tencent.mm.media.widget.a.b bVar) {
        p.h(bVar, "cameraConfig");
        Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "updateCameraConfig: ".concat(String.valueOf(bVar)), new Object[0]);
        Point aPo = com.tencent.mm.media.widget.a.b.aPo();
        com.tencent.mm.media.j.a aVar = this.ihs;
        if (aVar != null) {
            aVar.cZ(aPo.x, aPo.y);
        }
        com.tencent.mm.media.j.a aVar2 = this.ihs;
        if (aVar2 != null) {
            aVar2.qx(aQv());
        }
        com.tencent.mm.media.j.a aVar3 = this.ihs;
        if (aVar3 != null) {
            aVar3.eD(com.tencent.mm.media.widget.a.b.aPn());
        }
    }

    public final SurfaceTexture getSurfaceTexture() {
        com.tencent.mm.media.j.a aVar = this.ihs;
        if (aVar != null) {
            return aVar.getTexture();
        }
        return null;
    }

    public final d aQu() {
        com.tencent.mm.media.j.a aVar = this.ihs;
        if (aVar != null) {
            return aVar.ijq;
        }
        return null;
    }

    public final void aEy() {
        com.tencent.mm.media.j.a aVar = this.ihs;
        if (aVar != null) {
            aVar.ijr = true;
        }
    }

    public final void release() {
        this.iqQ.j(new b(this));
    }

    private final int aQv() {
        int i2;
        Object systemService = MMApplicationContext.getContext().getSystemService("window");
        if (systemService == null) {
            throw new t("null cannot be cast to non-null type android.view.WindowManager");
        }
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        p.g(defaultDisplay, "(MMApplicationContext.ge…owManager).defaultDisplay");
        switch (defaultDisplay.getRotation()) {
            case 0:
                i2 = 0;
                break;
            case 1:
                i2 = 90;
                break;
            case 2:
                i2 = TXLiveConstants.RENDER_ROTATION_180;
                break;
            case 3:
                i2 = 270;
                break;
            default:
                i2 = 0;
                break;
        }
        return ((com.tencent.mm.media.widget.a.b.aPk() - i2) + this.iqP) % this.iqP;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a iqR;
        final /* synthetic */ com.tencent.mm.media.j.a iqV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar, com.tencent.mm.media.j.a aVar2) {
            super(0);
            this.iqR = aVar;
            this.iqV = aVar2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(94361);
            kotlin.g.a.b<? super d, x> bVar = this.iqR.iqL;
            if (bVar != null) {
                bVar.invoke(this.iqV.aEE());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(94361);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.preview.a.a$a  reason: collision with other inner class name */
    static final class C0438a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a iqR;
        final /* synthetic */ kotlin.g.a.a iqS;
        final /* synthetic */ boolean iqT = true;
        final /* synthetic */ int iqU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0438a(a aVar, kotlin.g.a.a aVar2, int i2) {
            super(0);
            this.iqR = aVar;
            this.iqS = aVar2;
            this.iqU = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(94359);
            com.tencent.mm.media.j.a aVar = this.iqR.ihs;
            if (aVar == null || !aVar.ijx) {
                com.tencent.mm.media.j.a aVar2 = this.iqR.ihs;
                if (aVar2 != null) {
                    aVar2.release(true);
                }
                Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "initRender, generateExternalTexture: " + this.iqT, new Object[0]);
                com.tencent.mm.media.j.a aVar3 = this.iqR.ihs;
                if (aVar3 != null) {
                    aVar3.eY(this.iqT);
                }
                com.tencent.mm.media.j.a aVar4 = this.iqR.ihs;
                if (aVar4 != null) {
                    aVar4.ijt = this.iqU;
                }
                this.iqR.ilv = EGL14.eglGetCurrentContext();
                kotlin.g.a.a aVar5 = this.iqS;
                if (aVar5 != null) {
                    aVar5.invoke();
                }
            } else {
                kotlin.g.a.a aVar6 = this.iqS;
                if (aVar6 != null) {
                    aVar6.invoke();
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(94359);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a iqR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar) {
            super(0);
            this.iqR = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(94360);
            Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "release", new Object[0]);
            com.tencent.mm.media.j.a aVar = this.iqR.ihs;
            if (aVar != null) {
                aVar.release(true);
            }
            this.iqR.ilv = null;
            x xVar = x.SXb;
            AppMethodBeat.o(94360);
            return xVar;
        }
    }
}

package com.tencent.mm.media.widget.camerarecordview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.media.widget.camerarecordview.preview.e;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\n\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0016\u0010%\u001a\u00020\u001e2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e0'H\u0016J\b\u0010(\u001a\u00020\u001eH\u0016J\b\u0010)\u001a\u00020\u001eH\u0016J/\u0010*\u001a\u00020\u001e2%\u0010+\u001a!\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u001e\u0018\u00010,H\u0016J\u0018\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0016J \u00104\u001a\u00020\u001e2\u0016\u00105\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u001e\u0018\u00010,H\u0016J\b\u00106\u001a\u00020\u001eH\u0016J\u0010\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u000209H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewRenderView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "mContext", "Landroid/content/Context;", "texture", "Landroid/graphics/SurfaceTexture;", "mWidth", "", "mHeight", "(Landroid/content/Context;Landroid/graphics/SurfaceTexture;II)V", "TAG", "", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "getMHeight", "()I", "setMHeight", "(I)V", "getMWidth", "setMWidth", "getTexture", "()Landroid/graphics/SurfaceTexture;", "setTexture", "(Landroid/graphics/SurfaceTexture;)V", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureRender;", "clearFrame", "", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "queueEvent", "r", "Lkotlin/Function0;", "release", "requestRender", "setOnDrawListener", "frameAvailableListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "setPreviewRenderer", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "cpuCrop", "", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "plugin-mediaeditor_release"})
public final class b extends CameraPreviewGLSurfaceView implements e {
    private String TAG = "MicroMsg.CameraPreviewSurfaceRenderView";
    private com.tencent.mm.media.widget.camerarecordview.preview.b ipS = new com.tencent.mm.media.widget.camerarecordview.preview.b();
    private SurfaceTexture ipT;
    private Context mContext;
    private int mHeight;
    private int mWidth;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, SurfaceTexture surfaceTexture, int i2, int i3) {
        super(context, null);
        p.h(context, "mContext");
        p.h(surfaceTexture, "texture");
        AppMethodBeat.i(94266);
        this.mContext = context;
        this.ipT = surfaceTexture;
        this.mWidth = i2;
        this.mHeight = i3;
        AppMethodBeat.o(94266);
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public final int getMHeight() {
        return this.mHeight;
    }

    public final int getMWidth() {
        return this.mWidth;
    }

    public final SurfaceTexture getTexture() {
        return this.ipT;
    }

    public final void setMContext(Context context) {
        AppMethodBeat.i(94264);
        p.h(context, "<set-?>");
        this.mContext = context;
        AppMethodBeat.o(94264);
    }

    public final void setMHeight(int i2) {
        this.mHeight = i2;
    }

    public final void setMWidth(int i2) {
        this.mWidth = i2;
    }

    public final void setTexture(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(94265);
        p.h(surfaceTexture, "<set-?>");
        this.ipT = surfaceTexture;
        AppMethodBeat.o(94265);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.f, com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView
    public final void j(a<x> aVar) {
        AppMethodBeat.i(94252);
        p.h(aVar, "r");
        com.tencent.mm.media.widget.camerarecordview.preview.b bVar = this.ipS;
        if (bVar != null) {
            bVar.j(aVar);
            AppMethodBeat.o(94252);
            return;
        }
        AppMethodBeat.o(94252);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e, com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView
    public final void a(com.tencent.mm.media.widget.a.b bVar) {
        AppMethodBeat.i(94253);
        p.h(bVar, "cameraConfig");
        Log.printInfoStack(this.TAG, "updateCameraConfig:".concat(String.valueOf(bVar)), new Object[0]);
        com.tencent.mm.media.widget.camerarecordview.preview.b bVar2 = this.ipS;
        if (bVar2 != null) {
            bVar2.a(bVar);
            AppMethodBeat.o(94253);
            return;
        }
        AppMethodBeat.o(94253);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e, com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView
    public final void d(kotlin.g.a.b<? super SurfaceTexture, x> bVar) {
        AppMethodBeat.i(94254);
        com.tencent.mm.media.widget.camerarecordview.preview.b bVar2 = this.ipS;
        if (bVar2 != null) {
            bVar2.d(bVar);
            AppMethodBeat.o(94254);
            return;
        }
        AppMethodBeat.o(94254);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e, com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView
    public final void aEx() {
        AppMethodBeat.i(94255);
        Log.printInfoStack(this.TAG, "tryStopCameraPreview", new Object[0]);
        com.tencent.mm.media.widget.camerarecordview.preview.b bVar = this.ipS;
        if (bVar != null) {
            bVar.aEx();
            AppMethodBeat.o(94255);
            return;
        }
        AppMethodBeat.o(94255);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e, com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView
    public final void a(com.tencent.mm.media.j.a aVar, boolean z) {
        AppMethodBeat.i(94256);
        p.h(aVar, "renderer");
        com.tencent.mm.media.widget.camerarecordview.preview.b bVar = this.ipS;
        if (bVar != null) {
            bVar.a(aVar, false);
        }
        com.tencent.mm.media.widget.camerarecordview.preview.b bVar2 = this.ipS;
        if (bVar2 != null) {
            bVar2.onSurfaceTextureAvailable(this.ipT, this.mWidth, this.mHeight);
        }
        com.tencent.mm.media.widget.camerarecordview.preview.b bVar3 = this.ipS;
        if (bVar3 != null) {
            bVar3.onSurfaceTextureSizeChanged(this.ipT, this.mWidth, this.mHeight);
        }
        com.tencent.mm.media.widget.camerarecordview.preview.b bVar4 = this.ipS;
        if (bVar4 != null) {
            bVar4.onSurfaceTextureUpdated(this.ipT);
            AppMethodBeat.o(94256);
            return;
        }
        AppMethodBeat.o(94256);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e, com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView
    public final EGLContext getEGLContext() {
        AppMethodBeat.i(94257);
        com.tencent.mm.media.widget.camerarecordview.preview.b bVar = this.ipS;
        if (bVar != null) {
            EGLContext eGLContext = bVar.getEGLContext();
            AppMethodBeat.o(94257);
            return eGLContext;
        }
        AppMethodBeat.o(94257);
        return null;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e, com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView
    public final void setOnDrawListener(kotlin.g.a.b<? super d, x> bVar) {
        AppMethodBeat.i(94258);
        Log.printInfoStack(this.TAG, "setOnDrawListener", new Object[0]);
        com.tencent.mm.media.widget.camerarecordview.preview.b bVar2 = this.ipS;
        if (bVar2 != null) {
            bVar2.setOnDrawListener(bVar);
            AppMethodBeat.o(94258);
            return;
        }
        AppMethodBeat.o(94258);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e, com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView
    public final d getPreviewTexture() {
        AppMethodBeat.i(218877);
        com.tencent.mm.media.widget.camerarecordview.preview.b bVar = this.ipS;
        if (bVar != null) {
            d previewTexture = bVar.getPreviewTexture();
            AppMethodBeat.o(218877);
            return previewTexture;
        }
        AppMethodBeat.o(218877);
        return null;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e, com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView
    public final g getFrameDataCallback() {
        AppMethodBeat.i(94260);
        com.tencent.mm.media.widget.camerarecordview.preview.b bVar = this.ipS;
        if (bVar != null) {
            g frameDataCallback = bVar.getFrameDataCallback();
            AppMethodBeat.o(94260);
            return frameDataCallback;
        }
        AppMethodBeat.o(94260);
        return null;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e, com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView
    public final void aEy() {
        AppMethodBeat.i(94261);
        com.tencent.mm.media.widget.camerarecordview.preview.b bVar = this.ipS;
        if (bVar != null) {
            bVar.aEy();
            AppMethodBeat.o(94261);
            return;
        }
        AppMethodBeat.o(94261);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e, com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView
    public final void release() {
        AppMethodBeat.i(94262);
        com.tencent.mm.media.widget.camerarecordview.preview.b bVar = this.ipS;
        if (bVar != null) {
            bVar.onSurfaceTextureDestroyed(this.ipT);
        }
        com.tencent.mm.media.widget.camerarecordview.preview.b bVar2 = this.ipS;
        if (bVar2 != null) {
            bVar2.release();
        }
        this.ipS = null;
        AppMethodBeat.o(94262);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.f
    public final void requestRender() {
        AppMethodBeat.i(94263);
        com.tencent.mm.media.widget.camerarecordview.preview.b bVar = this.ipS;
        if (bVar != null) {
            bVar.requestRender();
            AppMethodBeat.o(94263);
            return;
        }
        AppMethodBeat.o(94263);
    }
}

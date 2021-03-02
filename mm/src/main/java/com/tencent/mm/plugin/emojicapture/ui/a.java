package com.tencent.mm.plugin.emojicapture.ui;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLExt;
import android.os.HandlerThread;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiWriteCommData;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.b.i;
import com.tencent.mm.plugin.emojicapture.ui.b.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010&\u001a\u00020\rH\u0002J\"\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u00142\u0006\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020#H\u0016J\u0012\u0010+\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u0014H\u0016J\"\u0010,\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u00142\u0006\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020#H\u0016J\u0012\u0010-\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u0014H\u0016J\u0014\u0010.\u001a\u00020\r2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\b\u00100\u001a\u00020\rH\u0002J\u000e\u00101\u001a\u00020\r2\u0006\u00102\u001a\u000203J\u0016\u00104\u001a\u00020\r2\u0006\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020#R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0012\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\r\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R*\u0010\u001d\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u001ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f`\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u00065"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureRenderSurface;", "Landroid/view/TextureView$SurfaceTextureListener;", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureRender;", "(Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureRender;)V", "TAG", "", "canPreview", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "onDrawCallback", "Lkotlin/Function0;", "", "getOnDrawCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDrawCallback", "(Lkotlin/jvm/functions/Function0;)V", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "getPreviewCallback", "()Lkotlin/jvm/functions/Function1;", "setPreviewCallback", "(Lkotlin/jvm/functions/Function1;)V", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "runnableArray", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "surface", "Landroid/view/Surface;", "surfaceHeight", "", "surfaceWidth", "texture", "initHandlerThread", "onSurfaceTextureAvailable", "surfaceTexture", "width", "height", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "queueEvent", "r", "quitHandlerThread", "requestRender", "pts", "", "updateTextureSize", "plugin-emojicapture_release"})
public final class a implements TextureView.SurfaceTextureListener {
    private final String TAG = "MicroMsg.EmojiCaptureRenderSurface";
    private HandlerThread igZ;
    private MMHandler iha;
    private c.b ilw;
    private SurfaceTexture ipT;
    private ArrayList<kotlin.g.a.a<x>> iqE = new ArrayList<>();
    kotlin.g.a.b<? super SurfaceTexture, x> iqw;
    private boolean iqy;
    kotlin.g.a.a<x> rrO;
    final h rrP;
    private Surface surface;
    private int surfaceHeight;
    private int surfaceWidth;

    public a(h hVar) {
        p.h(hVar, "renderer");
        AppMethodBeat.i(447);
        this.rrP = hVar;
        aQt();
        this.rrP.ijv = new kotlin.g.a.b<SurfaceTexture, x>(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.a.AnonymousClass1 */
            final /* synthetic */ a rrQ;

            {
                this.rrQ = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(i.CTRL_INDEX);
                SurfaceTexture surfaceTexture2 = surfaceTexture;
                p.h(surfaceTexture2, LocaleUtil.ITALIAN);
                Log.i(this.rrQ.TAG, "onFrameAvailable: ".concat(String.valueOf(surfaceTexture2)));
                a aVar = this.rrQ;
                aVar.j(new d(aVar, surfaceTexture2.getTimestamp()));
                x xVar = x.SXb;
                AppMethodBeat.o(i.CTRL_INDEX);
                return xVar;
            }
        };
        AppMethodBeat.o(447);
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(JsApiInstallDownloadTask.CTRL_INDEX);
        Log.i(this.TAG, "onSurfaceTextureSizeChanged: ");
        j(new c(this, i2, i3));
        AppMethodBeat.o(JsApiInstallDownloadTask.CTRL_INDEX);
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(JsApiPauseDownloadTask.CTRL_INDEX);
        Log.i(this.TAG, "onSurfaceTextureDestroyed: ");
        j(new b(this));
        AppMethodBeat.o(JsApiPauseDownloadTask.CTRL_INDEX);
        return true;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(JsApiResumeDownloadTask.CTRL_INDEX);
        Log.i(this.TAG, "onSurfaceTextureAvailable: ");
        if (this.iha == null) {
            aQt();
        }
        if (surfaceTexture != null) {
            j(new C0980a(surfaceTexture, this, i2, i3));
            AppMethodBeat.o(JsApiResumeDownloadTask.CTRL_INDEX);
            return;
        }
        AppMethodBeat.o(JsApiResumeDownloadTask.CTRL_INDEX);
    }

    public final void j(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(JsApiWriteCommData.CTRL_INDEX);
        p.h(aVar, "r");
        if (this.iha != null) {
            MMHandler mMHandler = this.iha;
            if (mMHandler != null) {
                mMHandler.post(new b(aVar));
                AppMethodBeat.o(JsApiWriteCommData.CTRL_INDEX);
                return;
            }
            AppMethodBeat.o(JsApiWriteCommData.CTRL_INDEX);
            return;
        }
        this.iqE.add(aVar);
        AppMethodBeat.o(JsApiWriteCommData.CTRL_INDEX);
    }

    private final void aQt() {
        AppMethodBeat.i(446);
        HandlerThread hz = com.tencent.f.c.d.hz("EmojiCaptureRenderSurface_renderThread", -2);
        hz.start();
        this.iha = new MMHandler(hz.getLooper());
        ArrayList<kotlin.g.a.a<x>> arrayList = new ArrayList();
        arrayList.addAll(this.iqE);
        this.iqE.clear();
        for (kotlin.g.a.a<x> aVar : arrayList) {
            j(aVar);
        }
        this.igZ = hz;
        AppMethodBeat.o(446);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int cKE;
        final /* synthetic */ int cKF;
        final /* synthetic */ a rrQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar, int i2, int i3) {
            super(0);
            this.rrQ = aVar;
            this.cKE = i2;
            this.cKF = i3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(JsApiGetInstallState.CTRL_INDEX);
            this.rrQ.surfaceWidth = this.cKE;
            this.rrQ.surfaceHeight = this.cKF;
            this.rrQ.rrP.cY(this.rrQ.surfaceWidth, this.rrQ.surfaceHeight);
            x xVar = x.SXb;
            AppMethodBeat.o(JsApiGetInstallState.CTRL_INDEX);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a rrQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar) {
            super(0);
            this.rrQ = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(438);
            this.rrQ.rrP.release(true);
            c.b bVar = this.rrQ.ilw;
            if (bVar != null) {
                EGL14.eglDestroyContext(bVar.ilu, bVar.ilv);
                EGL14.eglDestroySurface(bVar.ilu, bVar.eglSurface);
                SurfaceTexture surfaceTexture = this.rrQ.ipT;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                }
                a.f(this.rrQ);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(438);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureRenderSurface$onSurfaceTextureAvailable$1$1"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.a$a  reason: collision with other inner class name */
    static final class C0980a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ SurfaceTexture hAH;
        final /* synthetic */ int ifE;
        final /* synthetic */ int ifF;
        final /* synthetic */ a rrQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0980a(SurfaceTexture surfaceTexture, a aVar, int i2, int i3) {
            super(0);
            this.hAH = surfaceTexture;
            this.rrQ = aVar;
            this.ifE = i2;
            this.ifF = i3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(437);
            this.rrQ.ipT = this.hAH;
            this.rrQ.surfaceWidth = this.ifE;
            this.rrQ.surfaceHeight = this.ifF;
            this.rrQ.surface = new Surface(this.rrQ.ipT);
            this.rrQ.ilw = c.a.a(com.tencent.mm.media.k.c.ilt, this.rrQ.surface, 0, 0, null, 30);
            this.rrQ.rrP.onSurfaceCreated(null, null);
            this.rrQ.rrP.cY(this.ifE, this.ifF);
            this.rrQ.rrP.eY(true);
            this.rrQ.iqy = true;
            Log.i("MicroMsg.CameraPreviewGLTextureView", "previewCallback?.invoke");
            kotlin.g.a.b<? super SurfaceTexture, x> bVar = this.rrQ.iqw;
            if (bVar != null) {
                bVar.invoke(this.rrQ.rrP.getTexture());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(437);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ long ihy;
        final /* synthetic */ a rrQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar, long j2) {
            super(0);
            this.rrQ = aVar;
            this.ihy = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(JsApiAddDownloadTaskStraight.CTRL_INDEX);
            SurfaceTexture texture = this.rrQ.rrP.getTexture();
            if (texture != null) {
                texture.updateTexImage();
            }
            this.rrQ.rrP.onDrawFrame(null);
            c.b bVar = this.rrQ.ilw;
            if (bVar != null) {
                EGLExt.eglPresentationTimeANDROID(bVar.ilu, bVar.eglSurface, this.ihy);
                EGL14.eglSwapBuffers(bVar.ilu, bVar.eglSurface);
            }
            kotlin.g.a.a<x> aVar = this.rrQ.rrO;
            if (aVar != null) {
                aVar.invoke();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(JsApiAddDownloadTaskStraight.CTRL_INDEX);
            return xVar;
        }
    }

    public static final /* synthetic */ void f(a aVar) {
        AppMethodBeat.i(FileUtils.S_IRWXU);
        HandlerThread handlerThread = aVar.igZ;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        aVar.igZ = null;
        aVar.iha = null;
        AppMethodBeat.o(FileUtils.S_IRWXU);
    }
}

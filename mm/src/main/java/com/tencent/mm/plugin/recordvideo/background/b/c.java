package com.tencent.mm.plugin.recordvideo.background.b;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLExt;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.blur.e;

public final class c {
    public h BLp;
    boolean BLq = false;
    MMHandler handler;
    c.b hiD;
    Surface mSurface;
    SurfaceTexture mSurfaceTexture;
    private int viewportHeight;
    private int viewportWidth;
    HandlerThread wpM;

    public c(SurfaceTexture surfaceTexture, h hVar) {
        this.mSurfaceTexture = surfaceTexture;
        this.BLp = hVar;
    }

    public c(Surface surface, h hVar) {
        this.mSurface = surface;
        this.BLp = hVar;
    }

    public final void start() {
        AppMethodBeat.i(75006);
        this.wpM = d.hz("CameraPreviewTextureView_renderThread" + hashCode(), -2);
        this.wpM.start();
        this.handler = new MMHandler(this.wpM.getLooper());
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.recordvideo.background.b.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(75003);
                c cVar = c.this;
                Log.i("MicroMsg.Story.GLThread", "initGL");
                c.a aVar = com.tencent.mm.media.k.c.ilt;
                cVar.hiD = c.a.a(cVar.mSurface, cVar.mSurfaceTexture, 0, 0, EGL14.EGL_NO_CONTEXT);
                if (cVar.BLp != null) {
                    h hVar = cVar.BLp;
                    Log.i(h.TAG, "initGL");
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                    hVar.BMi.BLP = hVar.BMk;
                    g gVar = hVar.BMi;
                    gVar.BLN.eJi();
                    GLES20.glEnable(3042);
                    GLES20.glBlendFunc(770, 771);
                    e eVar = gVar.BLO;
                    if (eVar != null) {
                        eVar.destroy();
                    }
                    gVar.BLO = new e(MMApplicationContext.getContext());
                    hVar.eJp();
                    hVar.BMj.eJi();
                }
                Log.i("MicroMsg.Story.GLThread", "initGL succ");
                AppMethodBeat.o(75003);
            }
        });
        AppMethodBeat.o(75006);
    }

    public final void ax(Runnable runnable) {
        AppMethodBeat.i(75007);
        Log.i("MicroMsg.Story.GLThread", "postJob");
        if (this.handler == null) {
            Log.i("MicroMsg.Story.GLThread", "postJob but handler is null");
            AppMethodBeat.o(75007);
            return;
        }
        this.handler.post(runnable);
        AppMethodBeat.o(75007);
    }

    public final void setFrameRate(int i2) {
        this.BLp.BMh = (long) (1000 / i2);
    }

    public final void requestRender() {
        AppMethodBeat.i(75008);
        Log.i("MicroMsg.Story.GLThread", "requestRender");
        if (this.handler == null) {
            Log.i("MicroMsg.Story.GLThread", "requestRender but handler is null");
            AppMethodBeat.o(75008);
            return;
        }
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.recordvideo.background.b.c.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(75004);
                c cVar = c.this;
                Log.i("MicroMsg.Story.GLThread", "draw");
                if (cVar.BLp != null) {
                    cVar.BLp.onDrawFrame();
                }
                cVar.eJk();
                AppMethodBeat.o(75004);
            }
        });
        AppMethodBeat.o(75008);
    }

    public final void stop() {
        AppMethodBeat.i(75009);
        if (this.handler == null) {
            Log.i("MicroMsg.Story.GLThread", "stop but handler is null");
            AppMethodBeat.o(75009);
            return;
        }
        this.handler.removeCallbacksAndMessages(null);
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.recordvideo.background.b.c.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(75005);
                c cVar = c.this;
                Log.i("MicroMsg.Story.GLThread", "destoryGL");
                c.a aVar = com.tencent.mm.media.k.c.ilt;
                c.a.a(cVar.hiD);
                cVar.wpM.quit();
                cVar.BLp.eJp();
                AppMethodBeat.o(75005);
            }
        });
        AppMethodBeat.o(75009);
    }

    public final void dL(int i2, int i3) {
        this.viewportWidth = i2;
        this.viewportHeight = i3;
        h hVar = this.BLp;
        hVar.mWidth = i2;
        hVar.mHeight = i3;
    }

    public final void eJk() {
        AppMethodBeat.i(75010);
        c.a aVar = com.tencent.mm.media.k.c.ilt;
        c.a.a(this.hiD.ilu, this.hiD.eglSurface);
        AppMethodBeat.o(75010);
    }

    public final void setPresentationTime(long j2) {
        AppMethodBeat.i(237198);
        if (this.hiD != null) {
            EGLExt.eglPresentationTimeANDROID(this.hiD.ilu, this.hiD.eglSurface, j2);
        }
        AppMethodBeat.o(237198);
    }
}

package com.tencent.mm.plugin.appbrand.game.f.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLExt;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.f.c.d;
import com.tencent.luggage.a.e;
import com.tencent.magicbrush.ui.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.appbrand.game.f.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.a.b;
import kotlin.x;

public abstract class a extends h implements d {
    private com.tencent.mm.media.widget.camerarecordview.preview.a.a hDt;
    private HandlerThread igZ = d.hz("GameTextureView_renderThread", -2);
    private MMHandler iha;
    private com.tencent.mm.media.j.a ihs;
    private SurfaceTexture ltm;
    private c.b ltn;
    private AtomicBoolean lto = new AtomicBoolean(false);
    private d.a ltp;
    private int surfaceHeight;
    private int surfaceWidth;

    public a(Context context) {
        super(context);
        this.igZ.start();
        this.iha = new MMHandler(this.igZ.getLooper());
    }

    private void queueEvent(Runnable runnable) {
        if (Thread.currentThread().getId() == this.igZ.getId()) {
            runnable.run();
        } else {
            this.iha.post(runnable);
        }
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.f
    public final void j(final kotlin.g.a.a<x> aVar) {
        if (Thread.currentThread().getId() == this.igZ.getId()) {
            aVar.invoke();
        } else {
            this.iha.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.game.f.a.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(45193);
                    aVar.invoke();
                    AppMethodBeat.o(45193);
                }
            });
        }
    }

    @Override // com.tencent.magicbrush.ui.h
    public void onSurfaceTextureAvailable(final SurfaceTexture surfaceTexture, final int i2, final int i3) {
        Log.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureAvailable, surfaceTexture:%s, width:%d, height:%d", surfaceTexture, Integer.valueOf(i2), Integer.valueOf(i3));
        queueEvent(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.game.f.a.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(45194);
                a.this.surfaceWidth = i2;
                a.this.surfaceHeight = i3;
                a.this.ltm = surfaceTexture;
                a aVar = a.this;
                c.a aVar2 = c.ilt;
                aVar.ltn = c.a.a(new Surface(surfaceTexture), null, 0, 0, EGL14.EGL_NO_CONTEXT);
                if (a.this.ihs != null) {
                    a.this.ihs.onSurfaceCreated(null, null);
                    a.this.ihs.cY(i2, i3);
                    a.this.ihs.cZ(i2, i3);
                    a.this.ihs.eY(true);
                }
                a.super.onSurfaceTextureAvailable(a.this.hDt.getSurfaceTexture(), i2, i3);
                a.this.lto.getAndSet(true);
                if (a.this.ltp != null) {
                    d.a unused = a.this.ltp;
                    com.tencent.mm.media.widget.camerarecordview.preview.a.a unused2 = a.this.hDt;
                }
                AppMethodBeat.o(45194);
            }
        });
    }

    @Override // com.tencent.magicbrush.ui.h
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i2, final int i3) {
        Log.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureSizeChanged, surfaceTexture:%s, width:%d, height:%d", surfaceTexture, Integer.valueOf(i2), Integer.valueOf(i3));
        queueEvent(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.game.f.a.a.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(45195);
                a.super.onSurfaceTextureSizeChanged(a.this.hDt.getSurfaceTexture(), i2, i3);
                a.this.surfaceWidth = i2;
                a.this.surfaceHeight = i3;
                a.this.ihs.cY(a.this.surfaceWidth, a.this.surfaceHeight);
                AppMethodBeat.o(45195);
            }
        });
    }

    @Override // com.tencent.magicbrush.ui.h
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Log.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureDestroyed");
        queueEvent(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.game.f.a.a.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(45198);
                Log.i("MicroMsg.CameraPreviewGLTextureView", "hy: onSurfaceTextureDestroyed in thread! can preview: %b", Boolean.valueOf(a.this.lto.get()));
                try {
                    if (a.this.lto.get()) {
                        boolean onSurfaceTextureDestroyed = a.super.onSurfaceTextureDestroyed(a.this.hDt.getSurfaceTexture());
                        a.this.lto.getAndSet(false);
                        if (a.this.ihs != null) {
                            a.this.ihs.release(onSurfaceTextureDestroyed);
                        } else {
                            Log.w("MicroMsg.CameraPreviewGLTextureView", "hy: no renderer!");
                        }
                        if (a.this.ltn != null) {
                            EGL14.eglDestroyContext(a.this.ltn.ilu, a.this.ltn.ilv);
                            EGL14.eglDestroySurface(a.this.ltn.ilu, a.this.ltn.eglSurface);
                            a.this.ltm.release();
                        }
                    }
                    AppMethodBeat.o(45198);
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.CameraPreviewGLTextureView", th, "hy: error in surface destroy!!", new Object[0]);
                    AppMethodBeat.o(45198);
                }
            }
        });
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
    public void setOnSurfaceTextureAvailableDelegate(d.a aVar) {
        this.ltp = aVar;
        this.lto.get();
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
    public void setOnTextureDrawFinishDelegate(b<com.tencent.mm.media.g.d, x> bVar) {
        this.hDt.iqL = bVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
    public void setPreviewRenderer(final com.tencent.mm.media.j.a aVar) {
        Log.i("MicroMsg.CameraPreviewGLTextureView", "setRenderer: %d", Integer.valueOf(aVar.hashCode()));
        if (this.hDt != null) {
            this.hDt.release();
            this.hDt = new com.tencent.mm.media.widget.camerarecordview.preview.a.c(this);
        }
        this.hDt = new com.tencent.mm.media.widget.camerarecordview.preview.a.c(this);
        this.hDt.b(aVar);
        queueEvent(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.game.f.a.a.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(45196);
                a.this.ihs = aVar;
                AppMethodBeat.o(45196);
            }
        });
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.f
    public void requestRender() {
        queueEvent(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.game.f.a.a.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(45197);
                try {
                    if (a.this.ihs.ijx) {
                        ((SurfaceTexture) Objects.requireNonNull(a.this.hDt.getSurfaceTexture())).updateTexImage();
                        a.this.ihs.onDrawFrame(null);
                    } else {
                        Log.w("MicroMsg.CameraPreviewGLTextureView", "hy: renderer already released!");
                    }
                    if (!a.this.lto.get()) {
                        Log.w("MicroMsg.CameraPreviewGLTextureView", "hy: can not render because already destroyed");
                    } else if (a.this.ltn != null) {
                        EGLExt.eglPresentationTimeANDROID(a.this.ltn.ilu, a.this.ltn.eglSurface, System.nanoTime());
                        EGL14.eglSwapBuffers(a.this.ltn.ilu, a.this.ltn.eglSurface);
                        AppMethodBeat.o(45197);
                        return;
                    }
                    AppMethodBeat.o(45197);
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.CameraPreviewGLTextureView", th, "hy: encounter exception! gl get error: %d", Integer.valueOf(EGL14.eglGetError()));
                    ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(808, 2, 1, true);
                    AppMethodBeat.o(45197);
                }
            }
        });
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
    public EGLContext getEGLContext() {
        if (this.ltn == null) {
            return null;
        }
        return this.ltn.ilv;
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
    public int getPreviewTextureId() {
        if (this.hDt == null || this.hDt.aQu() == null) {
            return -1;
        }
        return this.hDt.aQu().igv;
    }
}

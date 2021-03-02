package com.tencent.mm.plugin.appbrand.game.f.a;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLExt;
import android.os.HandlerThread;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.luggage.a.e;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ui.a;
import com.tencent.magicbrush.ui.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.appbrand.game.a.r;
import com.tencent.mm.plugin.appbrand.game.a.t;
import com.tencent.mm.plugin.appbrand.game.f.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.x;

public final class b extends g implements d {
    private SurfaceHolder gQc = null;
    private AbstractC0586b ltu = new a(this, (byte) 0);
    private boolean ltv = false;
    private int ltw = 0;
    private int mSurfaceHeight = 0;
    private int mSurfaceWidth = 0;

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.appbrand.game.f.a.b$b  reason: collision with other inner class name */
    public interface AbstractC0586b extends d {
        void a(SurfaceHolder surfaceHolder, int i2, int i3, int i4, c cVar);

        void a(SurfaceHolder surfaceHolder, c cVar);

        void a(SurfaceHolder surfaceHolder, c cVar, boolean z);

        boolean bDr();

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
        com.tencent.mm.media.j.a getAbsSurfaceRenderer();

        SurfaceTexture getSurfaceTexture();

        void init();
    }

    /* access modifiers changed from: package-private */
    public interface c {
        void onDone();
    }

    static /* synthetic */ SurfaceTexture a(b bVar) {
        AppMethodBeat.i(45263);
        SurfaceTexture surfaceTexture = super.getSurfaceTexture();
        AppMethodBeat.o(45263);
        return surfaceTexture;
    }

    static /* synthetic */ void a(b bVar, SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(45259);
        super.surfaceCreated(surfaceHolder);
        AppMethodBeat.o(45259);
    }

    static /* synthetic */ void a(b bVar, SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        AppMethodBeat.i(45261);
        super.surfaceChanged(surfaceHolder, i2, i3, i4);
        AppMethodBeat.o(45261);
    }

    static /* synthetic */ void a(b bVar, SurfaceHolder surfaceHolder, boolean z) {
        AppMethodBeat.i(226628);
        super.a(surfaceHolder, z);
        AppMethodBeat.o(226628);
    }

    static /* synthetic */ void b(b bVar, SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(226629);
        super.surfaceCreated(surfaceHolder);
        AppMethodBeat.o(226629);
    }

    static /* synthetic */ void b(b bVar, SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        AppMethodBeat.i(226630);
        super.surfaceChanged(surfaceHolder, i2, i3, i4);
        AppMethodBeat.o(226630);
    }

    static /* synthetic */ void c(b bVar, SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(226631);
        super.surfaceDestroyed(surfaceHolder);
        AppMethodBeat.o(226631);
    }

    class a implements AbstractC0586b {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.b.AbstractC0586b
        public final void init() {
            AppMethodBeat.i(45204);
            Log.i("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: init. switch to support node js");
            AppMethodBeat.o(45204);
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.b.AbstractC0586b
        public final boolean bDr() {
            return false;
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.b.AbstractC0586b
        public final void a(SurfaceHolder surfaceHolder, c cVar) {
            AppMethodBeat.i(45205);
            b.a(b.this, surfaceHolder);
            b.a(b.this, cVar);
            AppMethodBeat.o(45205);
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.b.AbstractC0586b
        public final void a(SurfaceHolder surfaceHolder, int i2, int i3, int i4, c cVar) {
            AppMethodBeat.i(45206);
            b.a(b.this, surfaceHolder, i2, i3, i4);
            b.a(b.this, cVar);
            AppMethodBeat.o(45206);
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.b.AbstractC0586b
        public final void a(SurfaceHolder surfaceHolder, c cVar, boolean z) {
            AppMethodBeat.i(226625);
            b.a(b.this, surfaceHolder, z);
            b.a(b.this, cVar);
            AppMethodBeat.o(226625);
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.b.AbstractC0586b
        public final SurfaceTexture getSurfaceTexture() {
            AppMethodBeat.i(45208);
            SurfaceTexture a2 = b.a(b.this);
            AppMethodBeat.o(45208);
            return a2;
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.d, com.tencent.mm.plugin.appbrand.game.f.a.b.AbstractC0586b
        public final com.tencent.mm.media.j.a getAbsSurfaceRenderer() {
            AppMethodBeat.i(45209);
            Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy queueEvent");
            AppMethodBeat.o(45209);
            return null;
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
        public final void setOnSurfaceTextureAvailableDelegate(d.a aVar) {
            AppMethodBeat.i(45210);
            Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy setOnSurfaceTextureAvailableDelegate");
            AppMethodBeat.o(45210);
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
        public final EGLContext getEGLContext() {
            AppMethodBeat.i(45211);
            Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy getEGLContext");
            AppMethodBeat.o(45211);
            return null;
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
        public final void setOnTextureDrawFinishDelegate(kotlin.g.a.b<com.tencent.mm.media.g.d, x> bVar) {
            AppMethodBeat.i(45212);
            Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy setOnTextureDrawFinishDelegate");
            AppMethodBeat.o(45212);
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
        public final void setPreviewRenderer(com.tencent.mm.media.j.a aVar) {
            AppMethodBeat.i(45213);
            Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy setPreviewRenderer");
            AppMethodBeat.o(45213);
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
        public final int getPreviewTextureId() {
            AppMethodBeat.i(45214);
            Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy getPreviewTextureId");
            AppMethodBeat.o(45214);
            return 0;
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
        public final int getSurfaceWidth() {
            AppMethodBeat.i(45215);
            int i2 = b.this.mSurfaceWidth;
            AppMethodBeat.o(45215);
            return i2;
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
        public final int getSurfaceHeight() {
            AppMethodBeat.i(45216);
            int i2 = b.this.mSurfaceHeight;
            AppMethodBeat.o(45216);
            return i2;
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
        public final boolean isAvailable() {
            AppMethodBeat.i(45217);
            boolean z = b.this.ltv;
            AppMethodBeat.o(45217);
            return z;
        }

        @Override // com.tencent.mm.media.widget.camerarecordview.preview.f
        public final void requestRender() {
            AppMethodBeat.i(45218);
            Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy requestRender");
            AppMethodBeat.o(45218);
        }

        @Override // com.tencent.mm.media.widget.camerarecordview.preview.f
        public final void j(kotlin.g.a.a<x> aVar) {
            AppMethodBeat.i(45219);
            Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy requestRender");
            AppMethodBeat.o(45219);
        }
    }

    class d implements AbstractC0586b {
        com.tencent.mm.media.widget.camerarecordview.preview.a.a hDt;
        private HandlerThread igZ;
        private MMHandler iha;
        com.tencent.mm.media.j.a ihs;
        private com.tencent.mm.media.j.a ltH;
        volatile boolean ltI;
        c.b ltn;
        AtomicBoolean lto;
        private d.a ltp;
        Surface surface;

        private d() {
            AppMethodBeat.i(45228);
            this.lto = new AtomicBoolean(false);
            this.ltH = null;
            this.ltI = false;
            AppMethodBeat.o(45228);
        }

        /* synthetic */ d(b bVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.b.AbstractC0586b
        public final void init() {
            AppMethodBeat.i(45229);
            this.igZ = com.tencent.f.c.d.hC("GameTextureView_renderThread", -2);
            this.igZ.start();
            this.iha = new MMHandler(this.igZ.getLooper());
            AppMethodBeat.o(45229);
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.b.AbstractC0586b
        public final boolean bDr() {
            return this.ltI;
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.b.AbstractC0586b
        public final void a(final SurfaceHolder surfaceHolder, final c cVar) {
            AppMethodBeat.i(45230);
            try {
                this.ltH = new com.tencent.mm.media.j.d() {
                    /* class com.tencent.mm.plugin.appbrand.game.f.a.b.d.AnonymousClass1 */

                    @Override // com.tencent.mm.media.j.a
                    public final com.tencent.mm.media.j.b.a aEC() {
                        AppMethodBeat.i(45220);
                        com.tencent.mm.media.j.b.c cVar = new com.tencent.mm.media.j.b.c(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
                        AppMethodBeat.o(45220);
                        return cVar;
                    }
                };
                setPreviewRenderer(new com.tencent.mm.media.j.d() {
                    /* class com.tencent.mm.plugin.appbrand.game.f.a.b.d.AnonymousClass2 */

                    @Override // com.tencent.mm.media.j.a
                    public final com.tencent.mm.media.j.b.a aEC() {
                        AppMethodBeat.i(45221);
                        com.tencent.mm.media.j.b.c cVar = new com.tencent.mm.media.j.b.c(0, 0, 0, 0, 1, 1);
                        AppMethodBeat.o(45221);
                        return cVar;
                    }
                });
                queueEvent(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.game.f.a.b.d.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(45222);
                        d.this.surface = surfaceHolder.getSurface();
                        if (d.this.surface != null && d.this.surface.isValid()) {
                            Log.w("MicroMsg.GameRecordableSurfaceView.RecordableImp", "surface switch to record!");
                            d.this.ltI = true;
                            d dVar = d.this;
                            c.a aVar = com.tencent.mm.media.k.c.ilt;
                            dVar.ltn = c.a.a(d.this.surface, null, 0, 0, EGL14.EGL_NO_CONTEXT);
                            if (d.this.ihs != null) {
                                d.this.ihs.onSurfaceCreated(null, null);
                                Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
                                d.this.ihs.cY(surfaceFrame.width(), surfaceFrame.height());
                                d.this.ihs.cZ(surfaceFrame.width(), surfaceFrame.height());
                                d.this.ihs.eY(true);
                            } else {
                                Log.w("MicroMsg.GameRecordableSurfaceView.RecordableImp", "renderer is null!");
                            }
                        } else if (d.this.surface == null) {
                            Log.w("MicroMsg.GameRecordableSurfaceView.RecordableImp", "surface is null!");
                        } else if (!d.this.surface.isValid()) {
                            Log.w("MicroMsg.GameRecordableSurfaceView.RecordableImp", "surface is disable!");
                        }
                        b.b(b.this, surfaceHolder);
                        b.a(b.this, cVar);
                        AppMethodBeat.o(45222);
                    }
                });
                AppMethodBeat.o(45230);
            } catch (Exception e2) {
                Log.e("MicroMsg.GameRecordableSurfaceView.RecordableImp", "hy: onSurfaceTextureAvailable, error:" + e2.getMessage());
                b.a(b.this, cVar);
                AppMethodBeat.o(45230);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.b.AbstractC0586b
        public final void a(final SurfaceHolder surfaceHolder, final int i2, final int i3, final int i4, final c cVar) {
            AppMethodBeat.i(45231);
            queueEvent(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.game.f.a.b.d.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(45223);
                    if (d.this.ihs != null) {
                        d.this.ihs.cY(i3, i4);
                        d.this.ihs.cZ(i3, i4);
                    }
                    d.this.lto.getAndSet(true);
                    b.b(b.this, surfaceHolder, i2, i3, i4);
                    b.a(b.this, cVar);
                    AppMethodBeat.o(45223);
                }
            });
            AppMethodBeat.o(45231);
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.b.AbstractC0586b
        public final void a(SurfaceHolder surfaceHolder, final c cVar, boolean z) {
            AppMethodBeat.i(226626);
            if (this.ltH != null) {
                this.ltH.release(false);
            }
            queueEvent(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.game.f.a.b.d.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(45224);
                    Log.i("MicroMsg.GameRecordableSurfaceView.RecordableImp", "hy: onSurfaceTextureDestroyed in thread! can preview: %b", Boolean.valueOf(d.this.lto.get()));
                    try {
                        if (d.this.lto.get()) {
                            d.this.lto.getAndSet(false);
                            if (d.this.ihs != null) {
                                d.this.ihs.release(true);
                            } else {
                                Log.w("MicroMsg.GameRecordableSurfaceView.RecordableImp", "hy: no renderer!");
                            }
                            if (d.this.ltn != null) {
                                EGL14.eglDestroyContext(d.this.ltn.ilu, d.this.ltn.ilv);
                                EGL14.eglDestroySurface(d.this.ltn.ilu, d.this.ltn.eglSurface);
                                b.c(b.this, b.this.gQc);
                            }
                        }
                    } catch (Throwable th) {
                        Log.printErrStackTrace("MicroMsg.GameRecordableSurfaceView.RecordableImp", th, "hy: error in surface destroy!!", new Object[0]);
                    } finally {
                        b.a(b.this, cVar);
                        AppMethodBeat.o(45224);
                    }
                }
            });
            AppMethodBeat.o(226626);
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.b.AbstractC0586b
        public final SurfaceTexture getSurfaceTexture() {
            AppMethodBeat.i(45233);
            SurfaceTexture surfaceTexture = this.hDt.getSurfaceTexture();
            AppMethodBeat.o(45233);
            return surfaceTexture;
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.d, com.tencent.mm.plugin.appbrand.game.f.a.b.AbstractC0586b
        public final com.tencent.mm.media.j.a getAbsSurfaceRenderer() {
            return this.ltH;
        }

        private void queueEvent(Runnable runnable) {
            AppMethodBeat.i(45234);
            if (Thread.currentThread().getId() == this.igZ.getId()) {
                runnable.run();
                AppMethodBeat.o(45234);
                return;
            }
            this.iha.post(runnable);
            AppMethodBeat.o(45234);
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
        public final void setOnSurfaceTextureAvailableDelegate(d.a aVar) {
            AppMethodBeat.i(45235);
            this.ltp = aVar;
            this.lto.get();
            AppMethodBeat.o(45235);
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
        public final EGLContext getEGLContext() {
            AppMethodBeat.i(45236);
            Log.i("MicroMsg.GameRecordableSurfaceView.RecordableImp", "getEGLContext environment:" + this.ltn);
            if (this.ltn == null) {
                AppMethodBeat.o(45236);
                return null;
            }
            EGLContext eGLContext = this.ltn.ilv;
            AppMethodBeat.o(45236);
            return eGLContext;
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
        public final void setOnTextureDrawFinishDelegate(kotlin.g.a.b<com.tencent.mm.media.g.d, x> bVar) {
            AppMethodBeat.i(45237);
            Log.i("MicroMsg.GameRecordableSurfaceView.RecordableImp", "setOnTextureDrawFinishDelegate:");
            this.hDt.iqL = bVar;
            AppMethodBeat.o(45237);
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
        public final void setPreviewRenderer(final com.tencent.mm.media.j.a aVar) {
            AppMethodBeat.i(45238);
            Log.i("MicroMsg.GameRecordableSurfaceView.RecordableImp", "setRenderer: %d", Integer.valueOf(aVar.hashCode()));
            if (this.hDt != null) {
                this.hDt.release();
                this.hDt = new com.tencent.mm.media.widget.camerarecordview.preview.a.c(this);
            }
            this.hDt = new com.tencent.mm.media.widget.camerarecordview.preview.a.c(this);
            this.hDt.b(aVar);
            queueEvent(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.game.f.a.b.d.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(45225);
                    d.this.ihs = aVar;
                    AppMethodBeat.o(45225);
                }
            });
            AppMethodBeat.o(45238);
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
        public final int getPreviewTextureId() {
            AppMethodBeat.i(45239);
            Log.i("MicroMsg.GameRecordableSurfaceView.RecordableImp", "getPreviewTextureId previewController:" + this.hDt.aQu());
            if (this.hDt == null || this.hDt.aQu() == null) {
                AppMethodBeat.o(45239);
                return -1;
            }
            int i2 = this.hDt.aQu().igv;
            AppMethodBeat.o(45239);
            return i2;
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
        public final int getSurfaceWidth() {
            AppMethodBeat.i(45240);
            int i2 = b.this.mSurfaceWidth;
            AppMethodBeat.o(45240);
            return i2;
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
        public final int getSurfaceHeight() {
            AppMethodBeat.i(45241);
            int i2 = b.this.mSurfaceHeight;
            AppMethodBeat.o(45241);
            return i2;
        }

        @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
        public final boolean isAvailable() {
            AppMethodBeat.i(45242);
            boolean z = b.this.ltv;
            AppMethodBeat.o(45242);
            return z;
        }

        @Override // com.tencent.mm.media.widget.camerarecordview.preview.f
        public final void requestRender() {
            AppMethodBeat.i(45243);
            queueEvent(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.game.f.a.b.d.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(45226);
                    try {
                        if (d.this.ihs.ijx) {
                            ((SurfaceTexture) Objects.requireNonNull(d.this.hDt.getSurfaceTexture())).updateTexImage();
                            d.this.ihs.onDrawFrame(null);
                        } else {
                            Log.w("MicroMsg.GameRecordableSurfaceView.RecordableImp", "hy: renderer already released!");
                        }
                        if (!d.this.lto.get()) {
                            Log.w("MicroMsg.GameRecordableSurfaceView.RecordableImp", "hy: can not render because already destroyed");
                        } else if (d.this.ltn != null) {
                            EGLExt.eglPresentationTimeANDROID(d.this.ltn.ilu, d.this.ltn.eglSurface, System.nanoTime());
                            EGL14.eglSwapBuffers(d.this.ltn.ilu, d.this.ltn.eglSurface);
                            AppMethodBeat.o(45226);
                            return;
                        }
                        AppMethodBeat.o(45226);
                    } catch (Throwable th) {
                        Log.printErrStackTrace("MicroMsg.GameRecordableSurfaceView.RecordableImp", th, "hy: encounter exception! gl get error: %d", Integer.valueOf(EGL14.eglGetError()));
                        ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(808, 2, 1, true);
                        AppMethodBeat.o(45226);
                    }
                }
            });
            AppMethodBeat.o(45243);
        }

        @Override // com.tencent.mm.media.widget.camerarecordview.preview.f
        public final void j(final kotlin.g.a.a<x> aVar) {
            AppMethodBeat.i(45244);
            queueEvent(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.game.f.a.b.d.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(45227);
                    aVar.invoke();
                    AppMethodBeat.o(45227);
                }
            });
            AppMethodBeat.o(45244);
        }
    }

    public b(Context context) {
        super(context);
        AppMethodBeat.i(45245);
        this.ltu.init();
        AppMethodBeat.o(45245);
    }

    @Override // com.tencent.magicbrush.ui.g, com.tencent.magicbrush.ui.MagicBrushView.b
    public final void a(final boolean z, final boolean z2, final kotlin.g.a.b<? super Boolean, Void> bVar, final MBRuntime mBRuntime) {
        AppMethodBeat.i(226627);
        post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.game.f.a.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(45203);
                Log.i("MicroMsg.GameGLSurfaceView", "hy: request switch to recordable %b", Boolean.valueOf(z2));
                if (!z && z2 == b.this.ltu.bDr()) {
                    Log.i("MicroMsg.GameGLSurfaceView", "hy: support status not changed!");
                    bVar.invoke(Boolean.TRUE);
                    AppMethodBeat.o(45203);
                } else if (mBRuntime.isDestroyed() || b.this.gQc == null) {
                    Log.w("MicroMsg.GameGLSurfaceView", "hy: runtime  destroyed!");
                    bVar.invoke(Boolean.FALSE);
                    AppMethodBeat.o(45203);
                } else if (!(mBRuntime instanceof com.tencent.magicbrush.e)) {
                    Log.w("MicroMsg.GameGLSurfaceView", "hy: runtime is not magic brush!");
                    bVar.invoke(Boolean.FALSE);
                    AppMethodBeat.o(45203);
                } else {
                    final com.tencent.magicbrush.e eVar = (com.tencent.magicbrush.e) mBRuntime;
                    b.this.ltu.a(b.this.gQc, new c() {
                        /* class com.tencent.mm.plugin.appbrand.game.f.a.b.AnonymousClass2.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.appbrand.game.f.a.b.c
                        public final void onDone() {
                            AppMethodBeat.i(45202);
                            if (z2) {
                                b.this.ltu = new d(b.this, (byte) 0);
                            } else {
                                b.this.ltu = new a(b.this, (byte) 0);
                            }
                            b.this.ltu.init();
                            b.this.ltu.a(b.this.gQc, new c() {
                                /* class com.tencent.mm.plugin.appbrand.game.f.a.b.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.appbrand.game.f.a.b.c
                                public final void onDone() {
                                    AppMethodBeat.i(45201);
                                    if (!b.this.ltu.bDr()) {
                                        Log.i("MicroMsg.GameGLSurfaceView", "switch record not support!");
                                        bVar.invoke(Boolean.FALSE);
                                    } else {
                                        bVar.invoke(Boolean.TRUE);
                                    }
                                    b.this.ltu.a(b.this.gQc, b.this.ltw, b.this.mSurfaceWidth, b.this.mSurfaceHeight, new c() {
                                        /* class com.tencent.mm.plugin.appbrand.game.f.a.b.AnonymousClass2.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                        @Override // com.tencent.mm.plugin.appbrand.game.f.a.b.c
                                        public final void onDone() {
                                            AppMethodBeat.i(45200);
                                            if (!z2) {
                                                eVar.a(a.b.EglSurfaceSwapLocker);
                                                AppMethodBeat.o(45200);
                                            } else if (((Boolean) r.lrS.aLT()).booleanValue()) {
                                                Log.i("MicroMsg.GameGLSurfaceView", "hy: use main thread choreographer");
                                                if (((Boolean) t.lrU.aLT()).booleanValue()) {
                                                    eVar.a(a.b.NativeLocker);
                                                    AppMethodBeat.o(45200);
                                                    return;
                                                }
                                                eVar.a(a.b.ChoreographerInMainThread);
                                                AppMethodBeat.o(45200);
                                            } else {
                                                Log.i("MicroMsg.GameGLSurfaceView", "hy: use js thread choreographer");
                                                eVar.a(a.b.ChoreographerInJsThread);
                                                AppMethodBeat.o(45200);
                                            }
                                        }
                                    });
                                    AppMethodBeat.o(45201);
                                }
                            });
                            AppMethodBeat.o(45202);
                        }
                    }, true);
                    AppMethodBeat.o(45203);
                }
            }
        });
        AppMethodBeat.o(226627);
    }

    @Override // com.tencent.magicbrush.ui.g
    public final SurfaceTexture getSurfaceTexture() {
        AppMethodBeat.i(45247);
        SurfaceTexture surfaceTexture = this.ltu.getSurfaceTexture();
        AppMethodBeat.o(45247);
        return surfaceTexture;
    }

    @Override // com.tencent.magicbrush.ui.g
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(45248);
        Log.i("MicroMsg.GameGLSurfaceView", "surfaceCreated ");
        synchronized (this) {
            try {
                this.gQc = surfaceHolder;
            } finally {
                AppMethodBeat.o(45248);
            }
        }
        this.ltu.a(surfaceHolder, null);
        synchronized (this) {
            try {
                this.ltv = true;
            } finally {
                AppMethodBeat.o(45248);
            }
        }
    }

    @Override // com.tencent.magicbrush.ui.g
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        AppMethodBeat.i(45249);
        Log.i("MicroMsg.GameGLSurfaceView", "surfaceChanged ");
        synchronized (this) {
            try {
                this.ltw = i2;
                this.mSurfaceWidth = i3;
                this.mSurfaceHeight = i4;
                this.gQc = surfaceHolder;
            } catch (Throwable th) {
                AppMethodBeat.o(45249);
                throw th;
            }
        }
        this.ltu.a(surfaceHolder, i2, i3, i4, null);
        AppMethodBeat.o(45249);
    }

    @Override // com.tencent.magicbrush.ui.g
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(45250);
        Log.i("MicroMsg.GameGLSurfaceView", "surfaceDestroyed, holder:".concat(String.valueOf(surfaceHolder)));
        synchronized (this) {
            try {
                this.gQc = surfaceHolder;
            } finally {
                AppMethodBeat.o(45250);
            }
        }
        this.ltu.a(surfaceHolder, null, false);
        synchronized (this) {
            try {
                this.ltv = false;
            } finally {
                AppMethodBeat.o(45250);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
    public final void setOnSurfaceTextureAvailableDelegate(d.a aVar) {
        AppMethodBeat.i(45251);
        Log.i("MicroMsg.GameGLSurfaceView", "setOnSurfaceTextureAvailableDelegate:");
        this.ltu.setOnSurfaceTextureAvailableDelegate(aVar);
        AppMethodBeat.o(45251);
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
    public final EGLContext getEGLContext() {
        AppMethodBeat.i(45252);
        EGLContext eGLContext = this.ltu.getEGLContext();
        AppMethodBeat.o(45252);
        return eGLContext;
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
    public final void setOnTextureDrawFinishDelegate(kotlin.g.a.b<com.tencent.mm.media.g.d, x> bVar) {
        AppMethodBeat.i(45253);
        this.ltu.setOnTextureDrawFinishDelegate(bVar);
        AppMethodBeat.o(45253);
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
    public final void setPreviewRenderer(com.tencent.mm.media.j.a aVar) {
        AppMethodBeat.i(45254);
        this.ltu.setPreviewRenderer(aVar);
        AppMethodBeat.o(45254);
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
    public final int getPreviewTextureId() {
        AppMethodBeat.i(45255);
        int previewTextureId = this.ltu.getPreviewTextureId();
        AppMethodBeat.o(45255);
        return previewTextureId;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.f
    public final void requestRender() {
        AppMethodBeat.i(45256);
        this.ltu.requestRender();
        AppMethodBeat.o(45256);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.f
    public final void j(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(45257);
        this.ltu.j(aVar);
        AppMethodBeat.o(45257);
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
    public final int getSurfaceWidth() {
        return this.mSurfaceWidth;
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
    public final int getSurfaceHeight() {
        return this.mSurfaceHeight;
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
    public final boolean isAvailable() {
        return this.ltv;
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
    public final com.tencent.mm.media.j.a getAbsSurfaceRenderer() {
        AppMethodBeat.i(45258);
        com.tencent.mm.media.j.a absSurfaceRenderer = this.ltu.getAbsSurfaceRenderer();
        AppMethodBeat.o(45258);
        return absSurfaceRenderer;
    }

    static /* synthetic */ void a(b bVar, final c cVar) {
        AppMethodBeat.i(45260);
        if (cVar != null) {
            bVar.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.game.f.a.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(45199);
                    cVar.onDone();
                    AppMethodBeat.o(45199);
                }
            });
        }
        AppMethodBeat.o(45260);
    }
}

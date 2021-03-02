package com.tencent.magicbrush;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Keep;
import android.view.Surface;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.api.IImageDecodeService;
import com.tencent.magicbrush.a.c;
import com.tencent.magicbrush.b;
import com.tencent.magicbrush.handler.JsTouchEventHandler;
import com.tencent.magicbrush.handler.b;
import com.tencent.magicbrush.handler.c;
import com.tencent.magicbrush.handler.fs.IMBFileSystem;
import com.tencent.magicbrush.handler.glfont.IMBFontHandler;
import com.tencent.magicbrush.handler.glfont.i;
import com.tencent.magicbrush.internal.EventDispatcher;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.a;
import com.tencent.magicbrush.utils.e;
import com.tencent.magicbrush.utils.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;

public abstract class MBRuntime {
    protected MBParams cLb;
    private a cLc = null;
    protected IMBFileSystem cLd = null;
    protected BaseImageDecodeService cLe = null;
    protected IMBFontHandler cLf = null;
    private b cLg = null;
    protected c cLh = null;
    public volatile c cLi;
    protected com.tencent.magicbrush.ui.a cLj;
    private int cLk = 0;
    public d cxx = new d(this);
    protected volatile long mNativeInst;

    @Keep
    public static class MBParams {
        public boolean adjust_thread_priority = true;
        public boolean allow_antialias_ = false;
        public boolean allow_opengl3 = true;
        public a.b animationFrameHandlerStrategy = a.b.ChoreographerInJsThread;
        AssetManager asset_manager;
        public int cmd_pool_type = 1;
        public float device_pixel_ratio_ = -1.0f;
        public boolean enable_2d = true;
        public boolean enable_font_batch = false;
        public boolean enable_gfx = true;
        public boolean enable_request_animation_frame = true;
        public boolean enable_window_attributes_alpha = false;
        public boolean enable_wxbindcanvastexture = false;
        public IMBFileSystem file_system_ = null;
        public boolean force_run_v8_microtasks = false;
        public float gc_factor = 0.0f;
        public boolean is_game = false;
        public boolean perf_crazy_mode = false;
        public String render_thread_name;
        public boolean render_thread_profiler = false;
        public boolean revert_cpu_optimizer_test = false;
        public int screen_height_ = -1;
        public int screen_width_ = -1;
        public String sdcard_path;
        public boolean support_client_vertex_buffer = false;
        public int support_gfximage_share_texture = 1;
        public boolean support_hardware_decode = true;
        public boolean support_hardware_encode = true;
        public boolean sync_surface_destroy = true;
        public boolean use_command_buffer = true;
    }

    interface a {
        void beforeSwap(boolean z);
    }

    private native int[] nativeGetCanvasSize(long j2, int i2);

    private native int nativeGetGLThreadTid(long j2);

    private native int nativeGetJsThreadTid(long j2);

    private native void nativeMarkNeedCallbackBeforeSwapThisFrame(long j2);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native void nativeRunOnJsThread(long j2, int i2);

    private native void nativeSetIsCpuProfiling(long j2, boolean z);

    /* access modifiers changed from: package-private */
    public abstract b Ri();

    /* access modifiers changed from: package-private */
    public abstract MBViewManager Rj();

    /* access modifiers changed from: protected */
    public native void nativeBindTo(long j2, long j3, long j4, long j5);

    /* access modifiers changed from: protected */
    public native Bitmap nativeCaptureCanvas(long j2, int i2);

    /* access modifiers changed from: protected */
    public native Bitmap nativeCaptureScreen(long j2, int i2);

    /* access modifiers changed from: protected */
    public native long nativeCreate(MBParams mBParams);

    /* access modifiers changed from: package-private */
    public native int nativeCreateExternalTexture(long j2, int i2);

    /* access modifiers changed from: protected */
    public native void nativeDebug(long j2, int i2);

    /* access modifiers changed from: protected */
    public native void nativeDestroy(long j2);

    /* access modifiers changed from: package-private */
    public native void nativeDestroyExternalTexture(long j2, int i2);

    /* access modifiers changed from: package-private */
    public native float[] nativeGetCurrentFps(long j2);

    /* access modifiers changed from: package-private */
    public native float nativeGetCurrentFpsVariance(long j2);

    /* access modifiers changed from: package-private */
    public native int nativeGetDrawCalls(long j2);

    /* access modifiers changed from: package-private */
    public native int nativeGetFrameCounter(long j2);

    /* access modifiers changed from: protected */
    public native boolean nativeGetIsMali(long j2);

    /* access modifiers changed from: package-private */
    public native int nativeGetTriangles(long j2);

    /* access modifiers changed from: package-private */
    public native int nativeGetVertexes(long j2);

    /* access modifiers changed from: protected */
    public native void nativeInit(long j2);

    /* access modifiers changed from: protected */
    public native void nativeLazyLoadBox2D(long j2, String str);

    /* access modifiers changed from: protected */
    public native void nativeLazyLoadPhysx(long j2, String str);

    /* access modifiers changed from: protected */
    public native void nativeNotifyAnimationFrame(long j2, double d2);

    /* access modifiers changed from: protected */
    public native void nativeNotifyAnimationFrameLooper(long j2);

    /* access modifiers changed from: protected */
    public native void nativeNotifyExternalSurfaceAvailable(long j2, SurfaceTexture surfaceTexture, int i2);

    /* access modifiers changed from: protected */
    public native void nativeNotifyImageDecoded(long j2, String str, Object obj, ImageDecodeConfig imageDecodeConfig);

    /* access modifiers changed from: protected */
    public native void nativeNotifyTouchEvent(long j2, int i2, long j3);

    /* access modifiers changed from: protected */
    public native void nativeNotifyWindowAvailable(long j2, int i2, SurfaceTexture surfaceTexture, int i3, int i4, boolean z);

    /* access modifiers changed from: protected */
    public native void nativeNotifyWindowAvailableForSurface(long j2, int i2, Surface surface, int i3, int i4);

    /* access modifiers changed from: protected */
    public native void nativeNotifyWindowChanged(long j2, int i2, SurfaceTexture surfaceTexture, int i3, int i4);

    /* access modifiers changed from: protected */
    public native void nativeNotifyWindowChangedForSurface(long j2, int i2, Surface surface, int i3, int i4);

    /* access modifiers changed from: protected */
    public native void nativeNotifyWindowDestroyed(long j2, int i2);

    /* access modifiers changed from: protected */
    public native void nativePause(long j2);

    /* access modifiers changed from: protected */
    public native void nativeResume(long j2);

    /* access modifiers changed from: package-private */
    public native void nativeSetEnableInspectFpsVariance(long j2, boolean z);

    /* access modifiers changed from: protected */
    public native void nativeSetEventListener(long j2, EventDispatcher eventDispatcher);

    /* access modifiers changed from: protected */
    public native void nativeSetFontHandler(long j2, IMBFontHandler iMBFontHandler);

    /* access modifiers changed from: protected */
    public native void nativeSetImageHandler(long j2, IImageDecodeService iImageDecodeService);

    /* access modifiers changed from: protected */
    public native void nativeSetJsThreadHandler(long j2, long j3);

    /* access modifiers changed from: protected */
    public native void nativeSetUserPreferredFps(long j2, double d2);

    /* access modifiers changed from: protected */
    public native void nativeStopAnimationFrameLooper(long j2);

    static {
        c.C0193c.i("MicroMsg.MagicBrush.MBRuntime", "enter static block", new Object[0]);
        com.tencent.magicbrush.a.b.loadLibraries();
    }

    public static void Ra() {
        c.C0193c.i("MicroMsg.MagicBrush.MBRuntime", "trigger load lib", new Object[0]);
    }

    protected MBRuntime() {
    }

    public final synchronized boolean isDestroyed() {
        return this.mNativeInst == 0;
    }

    /* access modifiers changed from: protected */
    public final void Rb() {
        if (this.cLb.enable_request_animation_frame) {
            this.cLj = com.tencent.magicbrush.ui.a.a(this, this.cLi, this.cLb.animationFrameHandlerStrategy);
        }
        if (this.cLf == null) {
            this.cLf = new i();
            nativeSetFontHandler(this.mNativeInst, this.cLf);
        }
        if (this.cLi == null) {
            throw new IllegalStateException("[MBRuntime] JsThreadHandler not registered.");
        } else if (this.cLe == null) {
            throw new IllegalStateException("[MBRuntime] ImageHandler not registered.");
        } else if (this.cLf == null) {
            throw new IllegalStateException("[MBRuntime] FontHandler not registered.");
        } else if (this.mNativeInst == 0) {
            c.C0193c.i("MicroMsg.MagicBrush.MBRuntime", "init. mNativeInst == 0", new Object[0]);
        } else {
            m(new Runnable() {
                /* class com.tencent.magicbrush.MBRuntime.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(139940);
                    MBRuntime.this.nativeInit(MBRuntime.this.mNativeInst);
                    AppMethodBeat.o(139940);
                }
            });
        }
    }

    public final void Rc() {
        c.C0193c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.resume ", new Object[0]);
        d dVar = this.cxx;
        if (dVar.handler == null) {
            dVar.handler = new Handler(Looper.getMainLooper());
            dVar.handler.post(dVar.cKN);
        }
        n(new Runnable() {
            /* class com.tencent.magicbrush.MBRuntime.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(139946);
                MBRuntime.this.nativeResume(MBRuntime.this.mNativeInst);
                if (MBRuntime.this.cLb.enable_request_animation_frame) {
                    MBRuntime.this.cLj.resume();
                }
                AppMethodBeat.o(139946);
            }
        });
    }

    public final void Rd() {
        c.C0193c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.pause ", new Object[0]);
        this.cxx.QO();
        n(new Runnable() {
            /* class com.tencent.magicbrush.MBRuntime.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(139947);
                if (MBRuntime.this.cLb.enable_request_animation_frame) {
                    MBRuntime.this.cLj.pause();
                }
                MBRuntime.this.nativePause(MBRuntime.this.mNativeInst);
                AppMethodBeat.o(139947);
            }
        });
    }

    public final void h(double d2) {
        if (this.mNativeInst != 0) {
            nativeNotifyAnimationFrame(this.mNativeInst, d2);
        }
    }

    public final void Re() {
        if (this.mNativeInst != 0) {
            nativeNotifyAnimationFrameLooper(this.mNativeInst);
        }
    }

    public final void Rf() {
        if (this.mNativeInst != 0) {
            nativeStopAnimationFrameLooper(this.mNativeInst);
        }
    }

    public final void a(final int i2, final SurfaceTexture surfaceTexture, final int i3, final int i4, final boolean z) {
        c.C0193c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowAvailable windowId:%d %s", Integer.valueOf(i2), surfaceTexture);
        if (i2 < 0) {
            throw new IllegalArgumentException("windowId < 0");
        }
        n(new Runnable() {
            /* class com.tencent.magicbrush.MBRuntime.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(139948);
                if (surfaceTexture == null) {
                    c.C0193c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", new RuntimeException("Stub here!"), "hy: text is null, do not notifyWindowAvailable. maybe released by other module", new Object[0]);
                    AppMethodBeat.o(139948);
                    return;
                }
                MBRuntime.this.nativeNotifyWindowAvailable(MBRuntime.this.mNativeInst, i2, surfaceTexture, i3, i4, z);
                AppMethodBeat.o(139948);
            }
        });
    }

    /* access modifiers changed from: protected */
    public final boolean m(final Runnable runnable) {
        com.tencent.magicbrush.handler.c cVar;
        if (this.mNativeInst == 0 || (cVar = this.cLi) == null) {
            return false;
        }
        cVar.a(new Runnable() {
            /* class com.tencent.magicbrush.MBRuntime.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(139949);
                if (MBRuntime.this.mNativeInst == 0) {
                    AppMethodBeat.o(139949);
                    return;
                }
                runnable.run();
                AppMethodBeat.o(139949);
            }
        }, false);
        return true;
    }

    private boolean n(final Runnable runnable) {
        com.tencent.magicbrush.handler.c cVar;
        if (this.mNativeInst == 0 || (cVar = this.cLi) == null) {
            return false;
        }
        cVar.a(new Runnable() {
            /* class com.tencent.magicbrush.MBRuntime.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(139950);
                if (MBRuntime.this.mNativeInst == 0) {
                    AppMethodBeat.o(139950);
                    return;
                }
                runnable.run();
                AppMethodBeat.o(139950);
            }
        }, true);
        return true;
    }

    private boolean o(Runnable runnable) {
        e eVar = new e(runnable);
        if (!n(eVar)) {
            return false;
        }
        eVar.aZ(3000);
        return eVar.cPv.isDone();
    }

    private static void ij(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("windowId < 0");
        }
    }

    public final void a(final int i2, final Surface surface, final int i3, final int i4) {
        c.C0193c.i("MicroMsg.MagicBrush.MBRuntime", "hy: notifyWindowAvailable: %d, %d, %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (surface == null) {
            throw new RuntimeException("surface == null");
        }
        n(new Runnable() {
            /* class com.tencent.magicbrush.MBRuntime.AnonymousClass13 */

            public final void run() {
                AppMethodBeat.i(139951);
                MBRuntime.this.nativeNotifyWindowAvailableForSurface(MBRuntime.this.mNativeInst, i2, surface, i3, i4);
                AppMethodBeat.o(139951);
            }
        });
    }

    public final void a(final int i2, final SurfaceTexture surfaceTexture, final int i3, final int i4) {
        c.C0193c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowChanged ", new Object[0]);
        ij(i2);
        n(new Runnable() {
            /* class com.tencent.magicbrush.MBRuntime.AnonymousClass14 */

            public final void run() {
                AppMethodBeat.i(139952);
                if (surfaceTexture == null) {
                    c.C0193c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", new RuntimeException("Stub here!"), "hy: text is null, do not notifyWindowChanged. maybe released by other module", new Object[0]);
                    AppMethodBeat.o(139952);
                    return;
                }
                MBRuntime.this.nativeNotifyWindowChanged(MBRuntime.this.mNativeInst, i2, surfaceTexture, i3, i4);
                AppMethodBeat.o(139952);
            }
        });
    }

    public final void b(final int i2, final Surface surface, final int i3, final int i4) {
        c.C0193c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowChanged Surface[%s] %d, %d", surface, Integer.valueOf(i3), Integer.valueOf(i4));
        ij(i2);
        n(new Runnable() {
            /* class com.tencent.magicbrush.MBRuntime.AnonymousClass15 */

            public final void run() {
                AppMethodBeat.i(139953);
                if (surface == null) {
                    c.C0193c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", new RuntimeException("Stub here!"), "hy: text is null, do not notifyWindowChanged. maybe released by other module", new Object[0]);
                    AppMethodBeat.o(139953);
                    return;
                }
                MBRuntime.this.nativeNotifyWindowChangedForSurface(MBRuntime.this.mNativeInst, i2, surface, i3, i4);
                AppMethodBeat.o(139953);
            }
        });
    }

    public final void a(final int i2, final SurfaceTexture surfaceTexture) {
        c.C0193c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowDestroyed shouldDestroySync: %b", Boolean.TRUE);
        if (this.mNativeInst != 0) {
            ij(i2);
            AnonymousClass2 r0 = new Runnable() {
                /* class com.tencent.magicbrush.MBRuntime.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(139941);
                    if (MBRuntime.this.mNativeInst == 0) {
                        AppMethodBeat.o(139941);
                        return;
                    }
                    MBRuntime.this.nativeNotifyWindowDestroyed(MBRuntime.this.mNativeInst, i2);
                    if (surfaceTexture == null) {
                        c.C0193c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", new RuntimeException("Stub here!"), "hy: text is null, do not release. maybe released by other module", new Object[0]);
                        AppMethodBeat.o(139941);
                        return;
                    }
                    surfaceTexture.release();
                    AppMethodBeat.o(139941);
                }
            };
            boolean z = this.cLb.sync_surface_destroy;
            c.C0193c.i("MicroMsg.MagicBrush.MBRuntime", "[surface] destroy window(surfacetexture) param:true windowId:%d sync?%b %s", Integer.valueOf(i2), Boolean.valueOf(z), surfaceTexture);
            if (z) {
                o(r0);
            } else {
                n(r0);
            }
            c.C0193c.i("MicroMsg.MagicBrush.MBRuntime", "[surface] destroy window(surfacetexture) done. windowId:%d", Integer.valueOf(i2));
        }
    }

    public final void w(final int i2, boolean z) {
        c.C0193c.i("MicroMsg.MagicBrush.MBRuntime", "hy: notifyWindowDestroyed: %d", Integer.valueOf(i2));
        ij(i2);
        boolean z2 = this.cLb.sync_surface_destroy || z;
        AnonymousClass3 r3 = new Runnable() {
            /* class com.tencent.magicbrush.MBRuntime.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(139942);
                MBRuntime.this.nativeNotifyWindowDestroyed(MBRuntime.this.mNativeInst, i2);
                AppMethodBeat.o(139942);
            }
        };
        c.C0193c.i("MicroMsg.MagicBrush.MBRuntime", "[surface] destroy window(surface) windowId:%d sync?%b", Integer.valueOf(i2), Boolean.valueOf(z2));
        if (!z2) {
            n(r3);
        } else if (!o(r3)) {
            c.C0193c.e("MicroMsg.MagicBrush.MBRuntime", "notifyWindowDestroyed, but await fail. [deadlock]:    %s", this.cLi.LP());
        }
    }

    /* access modifiers changed from: package-private */
    public final Bitmap l(int i2, int i3, boolean z) {
        if (this.mNativeInst == 0) {
            return null;
        }
        if (z) {
            return nativeCaptureScreen(this.mNativeInst, i2);
        }
        return nativeCaptureCanvas(this.mNativeInst, i3);
    }

    public final void cn(boolean z) {
        if (this.mNativeInst != 0) {
            nativeSetIsCpuProfiling(this.mNativeInst, z);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar) {
        this.cLc = aVar;
        nativeMarkNeedCallbackBeforeSwapThisFrame(this.mNativeInst);
    }

    public void destroy() {
        c.C0193c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.destroy", new Object[0]);
        this.cxx.QO();
        if (this.mNativeInst == 0) {
            c.C0193c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.destroy skip outside", new Object[0]);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cLh != null) {
            this.cLh.destroy();
            this.cLh = null;
        }
        synchronized (this) {
            if (this.mNativeInst == 0) {
                c.C0193c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.destroy skip inside, lock [%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return;
            }
            if (this.cLb.enable_request_animation_frame) {
                this.cLj.destroy();
            }
            nativeDestroy(this.mNativeInst);
            this.cLi = null;
            this.cLe = null;
            this.cLf = null;
            this.mNativeInst = 0;
        }
    }

    public final void a(BaseImageDecodeService baseImageDecodeService) {
        this.cLe = baseImageDecodeService;
        nativeSetImageHandler(this.mNativeInst, baseImageDecodeService);
    }

    public final BaseImageDecodeService Rg() {
        return this.cLe;
    }

    public final void a(IMBFontHandler iMBFontHandler) {
        this.cLf = iMBFontHandler;
        nativeSetFontHandler(this.mNativeInst, iMBFontHandler);
    }

    public final IMBFontHandler Rh() {
        return this.cLf;
    }

    public final MBParams Rk() {
        return this.cLb;
    }

    public final void a(final int i2, final long j2, final JsTouchEventHandler.a aVar) {
        if (this.mNativeInst == 0) {
            aVar.aY(j2);
            return;
        }
        com.tencent.magicbrush.handler.c cVar = this.cLi;
        if (cVar == null) {
            aVar.aY(j2);
        } else {
            cVar.a(new Runnable() {
                /* class com.tencent.magicbrush.MBRuntime.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(139943);
                    if (MBRuntime.this.mNativeInst == 0) {
                        aVar.aY(j2);
                        AppMethodBeat.o(139943);
                        return;
                    }
                    MBRuntime.this.nativeNotifyTouchEvent(MBRuntime.this.mNativeInst, i2, j2);
                    AppMethodBeat.o(139943);
                }
            }, false);
        }
    }

    public final void b(final String str, final Object obj, final IImageDecodeService.c cVar, final ImageDecodeConfig imageDecodeConfig) {
        if (this.mNativeInst == 0) {
            cVar.ad(obj);
            return;
        }
        com.tencent.magicbrush.handler.c cVar2 = this.cLi;
        if (cVar2 == null) {
            cVar.ad(obj);
        } else {
            cVar2.a(new Runnable() {
                /* class com.tencent.magicbrush.MBRuntime.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(139944);
                    if (MBRuntime.this.mNativeInst == 0) {
                        cVar.ad(obj);
                        AppMethodBeat.o(139944);
                        return;
                    }
                    MBRuntime.this.nativeNotifyImageDecoded(MBRuntime.this.mNativeInst, str, obj, imageDecodeConfig);
                    AppMethodBeat.o(139944);
                }
            }, false);
        }
    }

    public final void a(com.tencent.magicbrush.handler.a aVar) {
        c.C0193c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.set_jsthread_handler ", new Object[0]);
        if (this.cLi != null) {
            c.C0193c.e("MicroMsg.MagicBrush.MBRuntime", "Why you set_jsthread_handler twice, unexpected behaviour.", new Object[0]);
            return;
        }
        long j2 = this.mNativeInst;
        this.cLi = new com.tencent.magicbrush.handler.c(aVar);
    }

    public final com.tencent.magicbrush.handler.c Rl() {
        return this.cLi;
    }

    /* access modifiers changed from: protected */
    @Keep
    public void touchJava() {
        this.cLk++;
    }

    /* access modifiers changed from: protected */
    @Keep
    public void beforeSwap(boolean z) {
        c.C0193c.i("MicroMsg.MagicBrush.MBRuntime", "hy: beforeSwap! %b", Boolean.valueOf(z));
        if (this.cLc != null) {
            this.cLc.beforeSwap(z);
        }
    }

    /* access modifiers changed from: protected */
    @Keep
    public Bitmap captureScreen(int i2, int i3, int i4, Bitmap bitmap) {
        b Ri = Ri();
        if (!(i3 > 0 && i4 > 0)) {
            String format = String.format("captureScreenCanvas of [%d] [%d, %d]", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}, 3));
            p.g(format, "java.lang.String.format(this, *args)");
            throw new IllegalStateException(format.toString());
        }
        MagicBrushView ih = Ri.ih(i2);
        if (ih == null) {
            return null;
        }
        f fVar = f.cPx;
        return (Bitmap) f.f(new b.d(ih, i3, i4, bitmap));
    }

    /* access modifiers changed from: protected */
    @Keep
    public void applyWindowAttributes(final int i2, final boolean z) {
        f.runOnUiThread(new Runnable() {
            /* class com.tencent.magicbrush.MBRuntime.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(139945);
                MagicBrushView findOrNull = MBRuntime.this.Rj().findOrNull(i2);
                if (findOrNull != null) {
                    findOrNull.setOpaque(!z);
                }
                AppMethodBeat.o(139945);
            }
        });
    }

    /* access modifiers changed from: protected */
    @Keep
    public void switchToJsThread(final int i2) {
        c.C0193c.i("MicroMsg.MagicBrush.MBRuntime", "switchToJsThread taskId: ".concat(String.valueOf(i2)), new Object[0]);
        if (this.cLi != null) {
            try {
                this.cLi.p(new Runnable() {
                    /* class com.tencent.magicbrush.MBRuntime.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(175885);
                        c.C0193c.i("MicroMsg.MagicBrush.MBRuntime", "switchToJsThread Runnable taskId: " + i2, new Object[0]);
                        MBRuntime.this.nativeRunOnJsThread(MBRuntime.this.mNativeInst, i2);
                        AppMethodBeat.o(175885);
                    }
                });
            } catch (Throwable th) {
                c.C0193c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", th, "hy: switchToJsThread crash!", new Object[0]);
                throw th;
            }
        } else {
            c.C0193c.e("MicroMsg.MagicBrush.MBRuntime", "hy: switchToJsThread no js thread handler", new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    @Keep
    public void resumeLoopTasks() {
        if (this.cLi != null) {
            this.cLi.resumeLoopTasks();
        }
    }

    /* access modifiers changed from: protected */
    @Keep
    public boolean doInnerLoopTask() {
        if (this.cLi != null) {
            return this.cLi.doInnerLoopTask();
        }
        return true;
    }

    public final a QP() {
        return this.cxx.QP();
    }
}

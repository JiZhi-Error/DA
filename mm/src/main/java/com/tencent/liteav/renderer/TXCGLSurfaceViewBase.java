package com.tencent.liteav.renderer;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

public class TXCGLSurfaceViewBase extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    private static final j f1031a = new j();

    /* renamed from: b  reason: collision with root package name */
    protected boolean f1032b = false;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f1033c = false;

    /* renamed from: d  reason: collision with root package name */
    protected final WeakReference<TXCGLSurfaceViewBase> f1034d = new WeakReference<>(this);

    /* renamed from: e  reason: collision with root package name */
    protected boolean f1035e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f1036f;

    /* renamed from: g  reason: collision with root package name */
    private i f1037g;

    /* renamed from: h  reason: collision with root package name */
    private GLSurfaceView.Renderer f1038h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1039i;

    /* renamed from: j  reason: collision with root package name */
    private e f1040j;
    private f k;
    private g l;
    private k m;
    private int n;
    private int o;
    private boolean p;

    public interface e {
        EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    public interface f {
        EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    public interface g {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    public interface k {
        GL a(GL gl);
    }

    public TXCGLSurfaceViewBase(Context context) {
        super(context);
        AppMethodBeat.i(16866);
        a();
        AppMethodBeat.o(16866);
    }

    public TXCGLSurfaceViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(16867);
        a();
        AppMethodBeat.o(16867);
    }

    /* access modifiers changed from: protected */
    public int c() {
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        AppMethodBeat.i(16868);
        try {
            if (this.f1037g != null) {
                this.f1037g.h();
            }
        } finally {
            super.finalize();
            AppMethodBeat.o(16868);
        }
    }

    private void a() {
        AppMethodBeat.i(16869);
        getHolder().addCallback(this);
        AppMethodBeat.o(16869);
    }

    public void setGLWrapper(k kVar) {
        this.m = kVar;
    }

    public void setDebugFlags(int i2) {
        this.n = i2;
    }

    public int getDebugFlags() {
        return this.n;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.p = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.p;
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        AppMethodBeat.i(16870);
        g();
        if (this.f1040j == null) {
            this.f1040j = new m(true);
        }
        if (this.k == null) {
            this.k = new c();
        }
        if (this.l == null) {
            this.l = new d();
        }
        this.f1038h = renderer;
        this.f1037g = new i(this.f1034d);
        this.f1037g.start();
        TXCLog.i("TXCGLSurfaceViewBase", "setRenderer-->mGLThread.start");
        AppMethodBeat.o(16870);
    }

    public void setEGLContextFactory(f fVar) {
        AppMethodBeat.i(16871);
        g();
        this.k = fVar;
        AppMethodBeat.o(16871);
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        AppMethodBeat.i(16872);
        g();
        this.l = gVar;
        AppMethodBeat.o(16872);
    }

    public void setEGLConfigChooser(e eVar) {
        AppMethodBeat.i(16873);
        g();
        this.f1040j = eVar;
        AppMethodBeat.o(16873);
    }

    public void setEGLConfigChooser(boolean z) {
        AppMethodBeat.i(16874);
        setEGLConfigChooser(new m(z));
        AppMethodBeat.o(16874);
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7) {
        AppMethodBeat.i(16875);
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
        AppMethodBeat.o(16875);
    }

    public void setEGLContextClientVersion(int i2) {
        AppMethodBeat.i(16876);
        g();
        this.o = i2;
        AppMethodBeat.o(16876);
    }

    public void setRenderMode(int i2) {
        AppMethodBeat.i(16877);
        this.f1037g.a(i2);
        AppMethodBeat.o(16877);
    }

    public int getRenderMode() {
        AppMethodBeat.i(16878);
        int e2 = this.f1037g.e();
        AppMethodBeat.o(16878);
        return e2;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(16879);
        this.f1037g.f();
        setRunInBackground(false);
        AppMethodBeat.o(16879);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(16880);
        setRunInBackground(true);
        if (!this.f1032b) {
            this.f1037g.a(new Runnable() {
                /* class com.tencent.liteav.renderer.TXCGLSurfaceViewBase.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(16751);
                    TXCGLSurfaceViewBase.this.b();
                    AppMethodBeat.o(16751);
                }
            });
            this.f1037g.g();
        }
        AppMethodBeat.o(16880);
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        AppMethodBeat.i(16881);
        this.f1037g.a(i3, i4);
        AppMethodBeat.o(16881);
    }

    public void b(boolean z) {
        AppMethodBeat.i(16882);
        this.f1032b = z;
        if (!this.f1032b && this.f1033c && this.f1037g != null) {
            TXCLog.w("TXCGLSurfaceViewBase", "background capture destroy surface when not enable background run");
            this.f1037g.a(new Runnable() {
                /* class com.tencent.liteav.renderer.TXCGLSurfaceViewBase.AnonymousClass2 */

                public void run() {
                    AppMethodBeat.i(16781);
                    TXCGLSurfaceViewBase.this.b();
                    AppMethodBeat.o(16781);
                }
            });
            this.f1037g.g();
        }
        AppMethodBeat.o(16882);
    }

    /* access modifiers changed from: protected */
    public void setRunInBackground(boolean z) {
        this.f1033c = z;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        int i2;
        AppMethodBeat.i(16883);
        super.onAttachedToWindow();
        if (this.f1039i && this.f1038h != null) {
            if (this.f1037g != null) {
                i2 = this.f1037g.e();
            } else {
                i2 = 1;
            }
            this.f1037g = new i(this.f1034d);
            if (i2 != 1) {
                this.f1037g.a(i2);
            }
            this.f1037g.start();
        }
        this.f1039i = false;
        AppMethodBeat.o(16883);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(16884);
        if (this.f1032b && this.f1037g != null) {
            TXCLog.w("TXCGLSurfaceViewBase", "background capture destroy surface when onDetachedFromWindow");
            this.f1037g.a(new Runnable() {
                /* class com.tencent.liteav.renderer.TXCGLSurfaceViewBase.AnonymousClass3 */

                public void run() {
                    AppMethodBeat.i(16754);
                    TXCGLSurfaceViewBase.this.b();
                    AppMethodBeat.o(16754);
                }
            });
            this.f1037g.g();
        }
        if (this.f1037g != null) {
            this.f1037g.h();
        }
        this.f1039i = true;
        super.onDetachedFromWindow();
        AppMethodBeat.o(16884);
    }

    /* access modifiers changed from: package-private */
    public static class i extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private boolean f1062a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f1063b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1064c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1065d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1066e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f1067f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f1068g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f1069h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f1070i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f1071j;
        private boolean k;
        private int l = 0;
        private int m = 0;
        private int n = 1;
        private boolean o = true;
        private boolean p;
        private ArrayList<Runnable> q = new ArrayList<>();
        private boolean r = true;
        private h s;
        private WeakReference<TXCGLSurfaceViewBase> t;

        i(WeakReference<TXCGLSurfaceViewBase> weakReference) {
            AppMethodBeat.i(16824);
            this.t = weakReference;
            AppMethodBeat.o(16824);
        }

        public void run() {
            AppMethodBeat.i(16825);
            setName("GLThread " + getId());
            try {
                j();
            } catch (InterruptedException e2) {
            } finally {
                TXCGLSurfaceViewBase.f1031a.a(this);
                AppMethodBeat.o(16825);
            }
        }

        public boolean a() {
            AppMethodBeat.i(182246);
            boolean c2 = this.s.c();
            AppMethodBeat.o(182246);
            return c2;
        }

        public int b() {
            AppMethodBeat.i(182247);
            int d2 = this.s.d();
            AppMethodBeat.o(182247);
            return d2;
        }

        public h c() {
            return this.s;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:106:0x01e8, code lost:
            if (r3 == false) goto L_0x0208;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x01f2, code lost:
            if (r17.s.b() == false) goto L_0x0295;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x01f4, code lost:
            r3 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f1031a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:110:0x01f8, code lost:
            monitor-enter(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:?, code lost:
            r17.f1071j = true;
            com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f1031a.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x0205, code lost:
            monitor-exit(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x0206, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x0208, code lost:
            if (r11 == false) goto L_0x02c8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x020a, code lost:
            r1 = (javax.microedition.khronos.opengles.GL10) r17.s.e();
            com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f1031a.a(r1);
            r11 = false;
            r13 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:0x021d, code lost:
            if (r12 == false) goto L_0x0239;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x021f, code lost:
            r1 = r17.t.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x0229, code lost:
            if (r1 == null) goto L_0x0238;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:121:0x022b, code lost:
            r1.f1038h.onSurfaceCreated(r13, r17.s.f1059d);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x0238, code lost:
            r12 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x0239, code lost:
            if (r9 == false) goto L_0x024f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x023b, code lost:
            r1 = r17.t.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x0245, code lost:
            if (r1 == null) goto L_0x024e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x0247, code lost:
            r1.f1038h.onSurfaceChanged(r13, r6, r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x024e, code lost:
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x024f, code lost:
            r1 = r17.t.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:129:0x025b, code lost:
            if (r1 == null) goto L_0x02d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:0x025d, code lost:
            r1.f1038h.onDrawFrame(r13);
            r1 = r1.c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x0268, code lost:
            switch(r1) {
                case 12288: goto L_0x0286;
                case 12302: goto L_0x02b6;
                default: goto L_0x026b;
            };
         */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x026b, code lost:
            com.tencent.liteav.renderer.TXCGLSurfaceViewBase.h.a("GLThread", "eglSwapBuffers", r1);
            r14 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f1031a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x0278, code lost:
            monitor-enter(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
            r17.f1067f = true;
            com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f1031a.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x0285, code lost:
            monitor-exit(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:138:0x0286, code lost:
            if (r8 == false) goto L_0x02d1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:139:0x0288, code lost:
            r1 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:0x0289, code lost:
            r2 = r1;
            r14 = r13;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x028d, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x028f, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(16828);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:144:0x0294, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x0295, code lost:
            r13 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f1031a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x0299, code lost:
            monitor-enter(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:?, code lost:
            r17.f1071j = true;
            r17.f1067f = true;
            com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f1031a.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:150:0x02ab, code lost:
            monitor-exit(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:0x02ae, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x02b0, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(16828);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:155:0x02b5, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:156:0x02b6, code lost:
            r10 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:157:0x02b8, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x02bf, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x02c8, code lost:
            r13 = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:168:0x02d1, code lost:
            r1 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x02d3, code lost:
            r1 = 12288;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
            if (r4 == null) goto L_0x01e8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0068, code lost:
            r4.run();
            r4 = null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void j() {
            /*
            // Method dump skipped, instructions count: 736
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.TXCGLSurfaceViewBase.i.j():void");
        }

        private void k() {
            AppMethodBeat.i(16829);
            if (this.f1070i) {
                this.f1070i = false;
                this.s.g();
            }
            AppMethodBeat.o(16829);
        }

        private void l() {
            AppMethodBeat.i(182248);
            if (this.f1069h) {
                this.s.h();
                this.f1069h = false;
                TXCGLSurfaceViewBase tXCGLSurfaceViewBase = this.t.get();
                if (tXCGLSurfaceViewBase != null) {
                    tXCGLSurfaceViewBase.f1036f = false;
                }
                TXCGLSurfaceViewBase.f1031a.c(this);
            }
            AppMethodBeat.o(182248);
        }

        public boolean d() {
            AppMethodBeat.i(182249);
            if (!this.f1069h || !this.f1070i || !m()) {
                AppMethodBeat.o(182249);
                return false;
            }
            AppMethodBeat.o(182249);
            return true;
        }

        private boolean m() {
            return !this.f1065d && this.f1066e && !this.f1067f && this.l > 0 && this.m > 0 && (this.o || this.n == 1);
        }

        public void a(int i2) {
            AppMethodBeat.i(16831);
            if (i2 < 0 || i2 > 1) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("renderMode");
                AppMethodBeat.o(16831);
                throw illegalArgumentException;
            }
            synchronized (TXCGLSurfaceViewBase.f1031a) {
                try {
                    this.n = i2;
                    TXCGLSurfaceViewBase.f1031a.notifyAll();
                } finally {
                    AppMethodBeat.o(16831);
                }
            }
        }

        public int e() {
            int i2;
            AppMethodBeat.i(182250);
            synchronized (TXCGLSurfaceViewBase.f1031a) {
                try {
                    i2 = this.n;
                } finally {
                    AppMethodBeat.o(182250);
                }
            }
            return i2;
        }

        public void f() {
            AppMethodBeat.i(16834);
            synchronized (TXCGLSurfaceViewBase.f1031a) {
                try {
                    this.f1066e = true;
                    this.f1071j = false;
                    TXCGLSurfaceViewBase.f1031a.notifyAll();
                    while (this.f1068g && !this.f1071j && !this.f1063b) {
                        try {
                            TXCGLSurfaceViewBase.f1031a.wait();
                        } catch (InterruptedException e2) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } finally {
                    AppMethodBeat.o(16834);
                }
            }
        }

        public void g() {
            AppMethodBeat.i(16836);
            synchronized (TXCGLSurfaceViewBase.f1031a) {
                try {
                    this.f1066e = false;
                    TXCGLSurfaceViewBase.f1031a.notifyAll();
                    while (!this.f1068g && !this.f1063b) {
                        try {
                            TXCGLSurfaceViewBase.f1031a.wait();
                        } catch (InterruptedException e2) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } finally {
                    AppMethodBeat.o(16836);
                }
            }
        }

        public void a(int i2, int i3) {
            AppMethodBeat.i(16835);
            synchronized (TXCGLSurfaceViewBase.f1031a) {
                try {
                    this.l = i2;
                    this.m = i3;
                    this.r = true;
                    this.o = true;
                    this.p = false;
                    TXCGLSurfaceViewBase.f1031a.notifyAll();
                    while (!this.f1063b && !this.f1065d && !this.p && d()) {
                        try {
                            TXCGLSurfaceViewBase.f1031a.wait();
                        } catch (InterruptedException e2) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } finally {
                    AppMethodBeat.o(16835);
                }
            }
        }

        public void h() {
            AppMethodBeat.i(16837);
            synchronized (TXCGLSurfaceViewBase.f1031a) {
                try {
                    this.f1062a = true;
                    TXCGLSurfaceViewBase.f1031a.notifyAll();
                    while (!this.f1063b) {
                        try {
                            TXCGLSurfaceViewBase.f1031a.wait();
                        } catch (InterruptedException e2) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } finally {
                    AppMethodBeat.o(16837);
                }
            }
        }

        public void i() {
            AppMethodBeat.i(16827);
            this.k = true;
            TXCGLSurfaceViewBase.f1031a.notifyAll();
            AppMethodBeat.o(16827);
        }

        public void a(Runnable runnable) {
            AppMethodBeat.i(16838);
            if (runnable == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("r must not be null");
                AppMethodBeat.o(16838);
                throw illegalArgumentException;
            }
            synchronized (TXCGLSurfaceViewBase.f1031a) {
                try {
                    this.q.add(runnable);
                    TXCGLSurfaceViewBase.f1031a.notifyAll();
                } finally {
                    AppMethodBeat.o(16838);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class l extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private StringBuilder f1079a = new StringBuilder();

        l() {
            AppMethodBeat.i(16842);
            AppMethodBeat.o(16842);
        }

        @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
        public void close() {
            AppMethodBeat.i(16843);
            a();
            AppMethodBeat.o(16843);
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            AppMethodBeat.i(16844);
            a();
            AppMethodBeat.o(16844);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) {
            AppMethodBeat.i(16845);
            for (int i4 = 0; i4 < i3; i4++) {
                char c2 = cArr[i2 + i4];
                if (c2 == '\n') {
                    a();
                } else {
                    this.f1079a.append(c2);
                }
            }
            AppMethodBeat.o(16845);
        }

        private void a() {
            AppMethodBeat.i(16846);
            if (this.f1079a.length() > 0) {
                TXCLog.v("TXCGLSurfaceViewBase", this.f1079a.toString());
                this.f1079a.delete(0, this.f1079a.length());
            }
            AppMethodBeat.o(16846);
        }
    }

    private void g() {
        AppMethodBeat.i(182251);
        if (this.f1037g != null) {
            IllegalStateException illegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
            AppMethodBeat.o(182251);
            throw illegalStateException;
        }
        AppMethodBeat.o(182251);
    }

    /* access modifiers changed from: package-private */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        private static String f1072a = "GLThreadManager";

        /* renamed from: b  reason: collision with root package name */
        private boolean f1073b;

        /* renamed from: c  reason: collision with root package name */
        private int f1074c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1075d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1076e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f1077f;

        /* renamed from: g  reason: collision with root package name */
        private i f1078g;

        private j() {
        }

        public synchronized void a(i iVar) {
            AppMethodBeat.i(16933);
            iVar.f1063b = true;
            if (this.f1078g == iVar) {
                this.f1078g = null;
            }
            notifyAll();
            AppMethodBeat.o(16933);
        }

        public boolean b(i iVar) {
            AppMethodBeat.i(16934);
            if (this.f1078g == iVar || this.f1078g == null) {
                this.f1078g = iVar;
                notifyAll();
                AppMethodBeat.o(16934);
                return true;
            }
            c();
            if (this.f1076e) {
                AppMethodBeat.o(16934);
                return true;
            }
            if (this.f1078g != null) {
                this.f1078g.i();
            }
            AppMethodBeat.o(16934);
            return false;
        }

        public void c(i iVar) {
            AppMethodBeat.i(16935);
            if (this.f1078g == iVar) {
                this.f1078g = null;
            }
            notifyAll();
            AppMethodBeat.o(16935);
        }

        public synchronized boolean a() {
            return this.f1077f;
        }

        public synchronized boolean b() {
            boolean z;
            AppMethodBeat.i(16936);
            c();
            if (!this.f1076e) {
                z = true;
                AppMethodBeat.o(16936);
            } else {
                z = false;
                AppMethodBeat.o(16936);
            }
            return z;
        }

        public synchronized void a(GL10 gl10) {
            boolean z = true;
            synchronized (this) {
                AppMethodBeat.i(16937);
                if (!this.f1075d) {
                    c();
                    String glGetString = gl10.glGetString(7937);
                    if (this.f1074c < 131072) {
                        this.f1076e = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    if (this.f1076e) {
                        z = false;
                    }
                    this.f1077f = z;
                    this.f1075d = true;
                }
                AppMethodBeat.o(16937);
            }
        }

        private void c() {
            this.f1074c = 131072;
            this.f1076e = true;
            this.f1073b = true;
        }
    }

    public static class h {

        /* renamed from: a  reason: collision with root package name */
        EGL10 f1056a;

        /* renamed from: b  reason: collision with root package name */
        EGLDisplay f1057b;

        /* renamed from: c  reason: collision with root package name */
        EGLSurface f1058c;

        /* renamed from: d  reason: collision with root package name */
        EGLConfig f1059d;

        /* renamed from: e  reason: collision with root package name */
        EGLContext f1060e;

        /* renamed from: f  reason: collision with root package name */
        private WeakReference<TXCGLSurfaceViewBase> f1061f;

        public h(WeakReference<TXCGLSurfaceViewBase> weakReference) {
            this.f1061f = weakReference;
        }

        public void a() {
            AppMethodBeat.i(16921);
            this.f1056a = (EGL10) EGLContext.getEGL();
            this.f1057b = this.f1056a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.f1057b == EGL10.EGL_NO_DISPLAY) {
                RuntimeException runtimeException = new RuntimeException("eglGetDisplay failed");
                AppMethodBeat.o(16921);
                throw runtimeException;
            }
            if (!this.f1056a.eglInitialize(this.f1057b, new int[2])) {
                RuntimeException runtimeException2 = new RuntimeException("eglInitialize failed");
                AppMethodBeat.o(16921);
                throw runtimeException2;
            }
            TXCGLSurfaceViewBase tXCGLSurfaceViewBase = this.f1061f.get();
            if (tXCGLSurfaceViewBase == null) {
                this.f1059d = null;
                this.f1060e = null;
                TXCLog.w("TXCGLSurfaceViewBase", "start() error when view is null ");
            } else {
                this.f1059d = tXCGLSurfaceViewBase.f1040j.a(this.f1056a, this.f1057b);
                this.f1060e = tXCGLSurfaceViewBase.k.a(this.f1056a, this.f1057b, this.f1059d);
            }
            if (this.f1060e == null || this.f1060e == EGL10.EGL_NO_CONTEXT) {
                this.f1060e = null;
                a("createContext");
            }
            if (tXCGLSurfaceViewBase != null) {
                tXCGLSurfaceViewBase.f1036f = true;
            }
            this.f1058c = null;
            AppMethodBeat.o(16921);
        }

        public boolean b() {
            AppMethodBeat.i(16922);
            if (this.f1056a == null) {
                RuntimeException runtimeException = new RuntimeException("egl not initialized");
                AppMethodBeat.o(16922);
                throw runtimeException;
            } else if (this.f1057b == null) {
                RuntimeException runtimeException2 = new RuntimeException("eglDisplay not initialized");
                AppMethodBeat.o(16922);
                throw runtimeException2;
            } else if (this.f1059d == null) {
                RuntimeException runtimeException3 = new RuntimeException("mEglConfig not initialized");
                AppMethodBeat.o(16922);
                throw runtimeException3;
            } else {
                i();
                TXCGLSurfaceViewBase tXCGLSurfaceViewBase = this.f1061f.get();
                if (tXCGLSurfaceViewBase != null) {
                    this.f1058c = tXCGLSurfaceViewBase.l.a(this.f1056a, this.f1057b, this.f1059d, tXCGLSurfaceViewBase.getHolder());
                } else {
                    this.f1058c = null;
                }
                if (this.f1058c == null || this.f1058c == EGL10.EGL_NO_SURFACE) {
                    if (this.f1056a.eglGetError() == 12299) {
                        TXCLog.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    AppMethodBeat.o(16922);
                    return false;
                } else if (!this.f1056a.eglMakeCurrent(this.f1057b, this.f1058c, this.f1058c, this.f1060e)) {
                    a("EGLHelper", "eglMakeCurrent", this.f1056a.eglGetError());
                    AppMethodBeat.o(16922);
                    return false;
                } else {
                    if (tXCGLSurfaceViewBase != null) {
                        tXCGLSurfaceViewBase.f1035e = true;
                    }
                    AppMethodBeat.o(16922);
                    return true;
                }
            }
        }

        public boolean c() {
            AppMethodBeat.i(182255);
            if (!this.f1056a.eglMakeCurrent(this.f1057b, this.f1058c, this.f1058c, this.f1060e)) {
                a("EGLHelper", "eglMakeCurrent", this.f1056a.eglGetError());
                AppMethodBeat.o(182255);
                return false;
            }
            AppMethodBeat.o(182255);
            return true;
        }

        public int d() {
            AppMethodBeat.i(182256);
            int f2 = f();
            AppMethodBeat.o(182256);
            return f2;
        }

        /* access modifiers changed from: package-private */
        public GL e() {
            l lVar;
            AppMethodBeat.i(182257);
            GL gl = this.f1060e.getGL();
            TXCGLSurfaceViewBase tXCGLSurfaceViewBase = this.f1061f.get();
            if (tXCGLSurfaceViewBase != null) {
                if (tXCGLSurfaceViewBase.m != null) {
                    gl = tXCGLSurfaceViewBase.m.a(gl);
                }
                if ((tXCGLSurfaceViewBase.n & 3) != 0) {
                    int i2 = 0;
                    if ((tXCGLSurfaceViewBase.n & 1) != 0) {
                        i2 = 1;
                    }
                    if ((tXCGLSurfaceViewBase.n & 2) != 0) {
                        lVar = new l();
                    } else {
                        lVar = null;
                    }
                    gl = GLDebugHelper.wrap(gl, i2, lVar);
                }
            }
            AppMethodBeat.o(182257);
            return gl;
        }

        public int f() {
            AppMethodBeat.i(182258);
            if (!this.f1056a.eglSwapBuffers(this.f1057b, this.f1058c)) {
                int eglGetError = this.f1056a.eglGetError();
                AppMethodBeat.o(182258);
                return eglGetError;
            }
            AppMethodBeat.o(182258);
            return 12288;
        }

        public void g() {
            AppMethodBeat.i(16928);
            i();
            AppMethodBeat.o(16928);
        }

        private void i() {
            AppMethodBeat.i(182259);
            if (!(this.f1058c == null || this.f1058c == EGL10.EGL_NO_SURFACE)) {
                EGL10 egl10 = this.f1056a;
                EGLDisplay eGLDisplay = this.f1057b;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                TXCGLSurfaceViewBase tXCGLSurfaceViewBase = this.f1061f.get();
                if (tXCGLSurfaceViewBase != null) {
                    tXCGLSurfaceViewBase.l.a(this.f1056a, this.f1057b, this.f1058c);
                    tXCGLSurfaceViewBase.f1035e = false;
                }
                this.f1058c = null;
            }
            AppMethodBeat.o(182259);
        }

        public void h() {
            AppMethodBeat.i(16927);
            if (this.f1060e != null) {
                TXCGLSurfaceViewBase tXCGLSurfaceViewBase = this.f1061f.get();
                if (tXCGLSurfaceViewBase != null) {
                    tXCGLSurfaceViewBase.k.a(this.f1056a, this.f1057b, this.f1060e);
                }
                this.f1060e = null;
            }
            if (this.f1057b != null) {
                this.f1056a.eglTerminate(this.f1057b);
                this.f1057b = null;
            }
            AppMethodBeat.o(16927);
        }

        private void a(String str) {
            AppMethodBeat.i(16929);
            a(str, this.f1056a.eglGetError());
            AppMethodBeat.o(16929);
        }

        public static void a(String str, int i2) {
            AppMethodBeat.i(16930);
            RuntimeException runtimeException = new RuntimeException(b(str, i2));
            AppMethodBeat.o(16930);
            throw runtimeException;
        }

        public static void a(String str, String str2, int i2) {
            AppMethodBeat.i(16931);
            TXCLog.w(str, b(str2, i2));
            AppMethodBeat.o(16931);
        }

        public static String b(String str, int i2) {
            AppMethodBeat.i(16932);
            String str2 = str + " failed: " + i2;
            AppMethodBeat.o(16932);
            return str2;
        }
    }

    class b extends a {

        /* renamed from: c  reason: collision with root package name */
        protected int f1046c;

        /* renamed from: d  reason: collision with root package name */
        protected int f1047d;

        /* renamed from: e  reason: collision with root package name */
        protected int f1048e;

        /* renamed from: f  reason: collision with root package name */
        protected int f1049f;

        /* renamed from: g  reason: collision with root package name */
        protected int f1050g;

        /* renamed from: h  reason: collision with root package name */
        protected int f1051h;

        /* renamed from: j  reason: collision with root package name */
        private int[] f1053j = new int[1];

        public b(int i2, int i3, int i4, int i5, int i6, int i7) {
            super(new int[]{12324, i2, 12323, i3, 12322, i4, 12321, i5, 12325, i6, 12326, i7, 12344});
            AppMethodBeat.i(16903);
            this.f1046c = i2;
            this.f1047d = i3;
            this.f1048e = i4;
            this.f1049f = i5;
            this.f1050g = i6;
            this.f1051h = i7;
            AppMethodBeat.o(16903);
        }

        @Override // com.tencent.liteav.renderer.TXCGLSurfaceViewBase.a
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            AppMethodBeat.i(16904);
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int a3 = a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (a2 >= this.f1050g && a3 >= this.f1051h) {
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int a7 = a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a4 == this.f1046c && a5 == this.f1047d && a6 == this.f1048e && a7 == this.f1049f) {
                        AppMethodBeat.o(16904);
                        return eGLConfig;
                    }
                }
            }
            AppMethodBeat.o(16904);
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, int i3) {
            AppMethodBeat.i(16905);
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.f1053j)) {
                int i4 = this.f1053j[0];
                AppMethodBeat.o(16905);
                return i4;
            }
            AppMethodBeat.o(16905);
            return i3;
        }
    }

    class m extends b {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public m(boolean r11) {
            /*
                r9 = this;
                r8 = 16919(0x4217, float:2.3709E-41)
                r2 = 8
                r5 = 0
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase.this = r10
                if (r11 == 0) goto L_0x001a
                r6 = 16
            L_0x000b:
                r0 = r9
                r1 = r10
                r3 = r2
                r4 = r2
                r7 = r5
                r0.<init>(r2, r3, r4, r5, r6, r7)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r8)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
                return
            L_0x001a:
                r6 = r5
                goto L_0x000b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.TXCGLSurfaceViewBase.m.<init>(com.tencent.liteav.renderer.TXCGLSurfaceViewBase, boolean):void");
        }
    }

    class c implements f {

        /* renamed from: b  reason: collision with root package name */
        private int f1055b;

        private c() {
            this.f1055b = 12440;
        }

        @Override // com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f
        public EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            AppMethodBeat.i(16779);
            int[] iArr = {this.f1055b, TXCGLSurfaceViewBase.this.o, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (TXCGLSurfaceViewBase.this.o == 0) {
                iArr = null;
            }
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
            AppMethodBeat.o(16779);
            return eglCreateContext;
        }

        @Override // com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            AppMethodBeat.i(16780);
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                TXCLog.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.a("eglDestroyContex", egl10.eglGetError());
            }
            AppMethodBeat.o(16780);
        }
    }

    static class d implements g {
        private d() {
        }

        @Override // com.tencent.liteav.renderer.TXCGLSurfaceViewBase.g
        public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            EGLSurface eGLSurface = null;
            AppMethodBeat.i(16752);
            try {
                eGLSurface = egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e2) {
                TXCLog.e("TXCGLSurfaceViewBase", "eglCreateWindowSurface");
                TXCLog.e("TXCGLSurfaceViewBase", e2.toString());
            }
            AppMethodBeat.o(16752);
            return eGLSurface;
        }

        @Override // com.tencent.liteav.renderer.TXCGLSurfaceViewBase.g
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            AppMethodBeat.i(16753);
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
            AppMethodBeat.o(16753);
        }
    }

    abstract class a implements e {

        /* renamed from: a  reason: collision with root package name */
        protected int[] f1044a;

        /* access modifiers changed from: package-private */
        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.f1044a = a(iArr);
        }

        @Override // com.tencent.liteav.renderer.TXCGLSurfaceViewBase.e
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f1044a, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i2 = iArr[0];
            if (i2 <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i2];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f1044a, eGLConfigArr, i2, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig a2 = a(egl10, eGLDisplay, eGLConfigArr);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException("No config chosen");
        }

        private int[] a(int[] iArr) {
            if (TXCGLSurfaceViewBase.this.o != 2) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[(length + 2)];
            System.arraycopy(iArr, 0, iArr2, 0, length - 1);
            iArr2[length - 1] = 12352;
            iArr2[length] = 4;
            iArr2[length + 1] = 12344;
            return iArr2;
        }
    }

    public boolean d() {
        AppMethodBeat.i(182252);
        boolean a2 = this.f1037g.a();
        AppMethodBeat.o(182252);
        return a2;
    }

    public int e() {
        AppMethodBeat.i(182253);
        int b2 = this.f1037g.b();
        AppMethodBeat.o(182253);
        return b2;
    }

    public h getEGLHelper() {
        AppMethodBeat.i(16887);
        h c2 = this.f1037g.c();
        AppMethodBeat.o(16887);
        return c2;
    }

    static {
        AppMethodBeat.i(16888);
        AppMethodBeat.o(16888);
    }
}

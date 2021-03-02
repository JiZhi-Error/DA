package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener {
    private static final j HhH = new j((byte) 0);
    private static final String TAG = GLTextureView.class.getSimpleName();
    private int Ejj;
    private int Ejk;
    private boolean Ejl;
    private List<TextureView.SurfaceTextureListener> Ejm = new ArrayList();
    public i HhI;
    private m HhJ;
    private e HhK;
    private f HhL;
    private g HhM;
    private k HhN;
    private boolean detached;
    private final WeakReference<GLTextureView> gRZ = new WeakReference<>(this);

    public interface e {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    public interface f {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    public interface g {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    public interface k {
        GL auh();
    }

    public interface m {
        void onDrawFrame(GL10 gl10);

        void onSurfaceChanged(GL10 gl10, int i2, int i3);

        void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);
    }

    static {
        AppMethodBeat.i(115636);
        AppMethodBeat.o(115636);
    }

    public GLTextureView(Context context) {
        super(context);
        AppMethodBeat.i(235820);
        setSurfaceTextureListener(this);
        AppMethodBeat.o(235820);
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(115614);
        setSurfaceTextureListener(this);
        AppMethodBeat.o(115614);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        AppMethodBeat.i(115615);
        try {
            if (this.HhI != null) {
                this.HhI.feo();
            }
        } finally {
            super.finalize();
            AppMethodBeat.o(115615);
        }
    }

    public void setGLWrapper(k kVar) {
        this.HhN = kVar;
    }

    public void setDebugFlags(int i2) {
        this.Ejj = i2;
    }

    public int getDebugFlags() {
        return this.Ejj;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.Ejl = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.Ejl;
    }

    public void setRenderer(m mVar) {
        AppMethodBeat.i(115616);
        atX();
        if (this.HhK == null) {
            this.HhK = new n(true);
        }
        if (this.HhL == null) {
            this.HhL = new c(this, (byte) 0);
        }
        if (this.HhM == null) {
            this.HhM = new d((byte) 0);
        }
        this.HhJ = mVar;
        this.HhI = new i(this.gRZ);
        this.HhI.start();
        AppMethodBeat.o(115616);
    }

    public void setEGLContextFactory(f fVar) {
        AppMethodBeat.i(115617);
        atX();
        this.HhL = fVar;
        AppMethodBeat.o(115617);
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        AppMethodBeat.i(115618);
        atX();
        this.HhM = gVar;
        AppMethodBeat.o(115618);
    }

    public void setEGLConfigChooser(e eVar) {
        AppMethodBeat.i(115619);
        atX();
        this.HhK = eVar;
        AppMethodBeat.o(115619);
    }

    public void setEGLConfigChooser(boolean z) {
        AppMethodBeat.i(115620);
        setEGLConfigChooser(new n(z));
        AppMethodBeat.o(115620);
    }

    public void setEGLContextClientVersion(int i2) {
        AppMethodBeat.i(115621);
        atX();
        this.Ejk = i2;
        AppMethodBeat.o(115621);
    }

    public void setRenderMode(int i2) {
        AppMethodBeat.i(115622);
        this.HhI.setRenderMode(i2);
        AppMethodBeat.o(115622);
    }

    public int getRenderMode() {
        AppMethodBeat.i(115623);
        int renderMode = this.HhI.getRenderMode();
        AppMethodBeat.o(115623);
        return renderMode;
    }

    public void o(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(115624);
        i iVar = this.HhI;
        synchronized (HhH) {
            try {
                new StringBuilder("surfaceCreated tid=").append(iVar.getId());
                iVar.Ejy = true;
                HhH.notifyAll();
                while (iVar.EjA && !iVar.Ejw) {
                    try {
                        HhH.wait();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
            } finally {
                AppMethodBeat.o(115624);
            }
        }
    }

    public void p(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(115625);
        i iVar = this.HhI;
        synchronized (HhH) {
            try {
                new StringBuilder("surfaceDestroyed tid=").append(iVar.getId());
                iVar.Ejy = false;
                HhH.notifyAll();
                while (!iVar.EjA && !iVar.Ejw) {
                    try {
                        HhH.wait();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
            } finally {
                AppMethodBeat.o(115625);
            }
        }
    }

    public void a(SurfaceTexture surfaceTexture, int i2, int i3, int i4) {
        boolean z;
        AppMethodBeat.i(115626);
        i iVar = this.HhI;
        synchronized (HhH) {
            try {
                iVar.width = i3;
                iVar.height = i4;
                iVar.EjG = true;
                iVar.EjE = true;
                iVar.EjF = false;
                HhH.notifyAll();
                while (!iVar.Ejw && !iVar.tN && !iVar.EjF) {
                    if (!iVar.EjB || !iVar.EjC || !iVar.aue()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        break;
                    }
                    new StringBuilder("onWindowResize waiting for render complete from tid=").append(iVar.getId());
                    try {
                        HhH.wait();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
            } finally {
                AppMethodBeat.o(115626);
            }
        }
    }

    public final void queueEvent(Runnable runnable) {
        AppMethodBeat.i(115627);
        this.HhI.queueEvent(runnable);
        AppMethodBeat.o(115627);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        int i2;
        AppMethodBeat.i(115628);
        super.onAttachedToWindow();
        new StringBuilder("onAttachedToWindow reattach =").append(this.detached);
        if (this.detached && this.HhJ != null) {
            if (this.HhI != null) {
                i2 = this.HhI.getRenderMode();
            } else {
                i2 = 1;
            }
            this.HhI = new i(this.gRZ);
            if (i2 != 1) {
                this.HhI.setRenderMode(i2);
            }
            this.HhI.start();
        }
        this.detached = false;
        AppMethodBeat.o(115628);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(115629);
        p(getSurfaceTexture());
        if (this.HhI != null) {
            this.HhI.feo();
        }
        this.detached = true;
        super.onDetachedFromWindow();
        AppMethodBeat.o(115629);
    }

    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        AppMethodBeat.i(115630);
        a(getSurfaceTexture(), 0, i4 - i2, i5 - i3);
        AppMethodBeat.o(115630);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(115631);
        o(surfaceTexture);
        a(surfaceTexture, 0, i2, i3);
        for (TextureView.SurfaceTextureListener surfaceTextureListener : this.Ejm) {
            surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, i2, i3);
        }
        AppMethodBeat.o(115631);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(115632);
        a(surfaceTexture, 0, i2, i3);
        for (TextureView.SurfaceTextureListener surfaceTextureListener : this.Ejm) {
            surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        }
        AppMethodBeat.o(115632);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(115633);
        for (TextureView.SurfaceTextureListener surfaceTextureListener : this.Ejm) {
            surfaceTextureListener.onSurfaceTextureDestroyed(surfaceTexture);
        }
        AppMethodBeat.o(115633);
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(115634);
        for (TextureView.SurfaceTextureListener surfaceTextureListener : this.Ejm) {
            surfaceTextureListener.onSurfaceTextureUpdated(surfaceTexture);
        }
        AppMethodBeat.o(115634);
    }

    /* access modifiers changed from: package-private */
    public class c implements f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        /* synthetic */ c(GLTextureView gLTextureView, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.voip.video.GLTextureView.f
        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            AppMethodBeat.i(115587);
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, GLTextureView.this.Ejk, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.Ejk == 0) {
                iArr = null;
            }
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
            AppMethodBeat.o(115587);
            return eglCreateContext;
        }

        @Override // com.tencent.mm.plugin.voip.video.GLTextureView.f
        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            AppMethodBeat.i(115588);
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                new StringBuilder("display:").append(eGLDisplay).append(" context: ").append(eGLContext);
                new StringBuilder("tid=").append(Thread.currentThread().getId());
            }
            AppMethodBeat.o(115588);
        }
    }

    /* access modifiers changed from: package-private */
    public static class d implements g {
        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.voip.video.GLTextureView.g
        public final EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            EGLSurface eGLSurface = null;
            AppMethodBeat.i(115589);
            try {
                eGLSurface = egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e2) {
                String unused = GLTextureView.TAG;
            }
            AppMethodBeat.o(115589);
            return eGLSurface;
        }

        @Override // com.tencent.mm.plugin.voip.video.GLTextureView.g
        public final void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            AppMethodBeat.i(115590);
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
            AppMethodBeat.o(115590);
        }
    }

    abstract class a implements e {
        protected int[] gSk;

        /* access modifiers changed from: package-private */
        public abstract EGLConfig b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            if (GLTextureView.this.Ejk == 2) {
                int[] iArr2 = new int[15];
                System.arraycopy(iArr, 0, iArr2, 0, 12);
                iArr2[12] = 12352;
                iArr2[13] = 4;
                iArr2[14] = 12344;
                iArr = iArr2;
            }
            this.gSk = iArr;
        }

        @Override // com.tencent.mm.plugin.voip.video.GLTextureView.e
        public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.gSk, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i2 = iArr[0];
            if (i2 <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i2];
            if (!egl10.eglChooseConfig(eGLDisplay, this.gSk, eGLConfigArr, i2, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig b2 = b(egl10, eGLDisplay, eGLConfigArr);
            if (b2 != null) {
                return b2;
            }
            throw new IllegalArgumentException("No config chosen");
        }
    }

    class b extends a {
        protected int Ejo = 8;
        protected int Ejp = 8;
        protected int Ejq = 8;
        protected int Ejr = 0;
        protected int Ejs;
        protected int Ejt;
        private int[] value = new int[1];

        public b(int i2) {
            super(new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, i2, 12326, 0, 12344});
            AppMethodBeat.i(115584);
            this.Ejs = i2;
            this.Ejt = 0;
            AppMethodBeat.o(115584);
        }

        @Override // com.tencent.mm.plugin.voip.video.GLTextureView.a
        public final EGLConfig b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            AppMethodBeat.i(115585);
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12325);
                int a3 = a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a2 >= this.Ejs && a3 >= this.Ejt) {
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12324);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a7 = a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a4 == this.Ejo && a5 == this.Ejp && a6 == this.Ejq && a7 == this.Ejr) {
                        AppMethodBeat.o(115585);
                        return eGLConfig;
                    }
                }
            }
            AppMethodBeat.o(115585);
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2) {
            AppMethodBeat.i(115586);
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.value)) {
                int i3 = this.value[0];
                AppMethodBeat.o(115586);
                return i3;
            }
            AppMethodBeat.o(115586);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public class n extends b {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(boolean z) {
            super(z ? 16 : 0);
            AppMethodBeat.i(115613);
            AppMethodBeat.o(115613);
        }
    }

    /* access modifiers changed from: package-private */
    public static class h {
        WeakReference<GLTextureView> Eju;
        EGL10 egl;
        EGLConfig eglConfig;
        EGLContext eglContext;
        EGLDisplay eglDisplay;
        EGLSurface eglSurface;

        public h(WeakReference<GLTextureView> weakReference) {
            this.Eju = weakReference;
        }

        /* access modifiers changed from: package-private */
        public final void atZ() {
            AppMethodBeat.i(115591);
            if (!(this.eglSurface == null || this.eglSurface == EGL10.EGL_NO_SURFACE)) {
                EGL10 egl10 = this.egl;
                EGLDisplay eGLDisplay = this.eglDisplay;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                GLTextureView gLTextureView = this.Eju.get();
                if (gLTextureView != null) {
                    gLTextureView.HhM.destroySurface(this.egl, this.eglDisplay, this.eglSurface);
                }
                this.eglSurface = null;
            }
            AppMethodBeat.o(115591);
        }

        public final void finish() {
            AppMethodBeat.i(115592);
            new StringBuilder("finish() tid=").append(Thread.currentThread().getId());
            if (this.eglContext != null) {
                GLTextureView gLTextureView = this.Eju.get();
                if (gLTextureView != null) {
                    gLTextureView.HhL.destroyContext(this.egl, this.eglDisplay, this.eglContext);
                }
                this.eglContext = null;
            }
            if (this.eglDisplay != null) {
                this.egl.eglTerminate(this.eglDisplay);
                this.eglDisplay = null;
            }
            AppMethodBeat.o(115592);
        }

        public static String Q(String str, int i2) {
            AppMethodBeat.i(115594);
            String str2 = str + " failed: " + i2;
            AppMethodBeat.o(115594);
            return str2;
        }
    }

    public static class i extends Thread {
        boolean EjA;
        boolean EjB;
        boolean EjC;
        private boolean EjD;
        boolean EjE = true;
        boolean EjF;
        boolean EjG = true;
        private WeakReference<GLTextureView> Eju;
        private boolean Ejv;
        boolean Ejw;
        private boolean Ejx;
        boolean Ejy;
        private boolean Ejz;
        private h HhP;
        private int hEi = 1;
        int height = 0;
        private ArrayList<Runnable> hgk = new ArrayList<>();
        boolean tN;
        int width = 0;

        i(WeakReference<GLTextureView> weakReference) {
            AppMethodBeat.i(115595);
            this.Eju = weakReference;
            AppMethodBeat.o(115595);
        }

        public final void run() {
            AppMethodBeat.i(115596);
            setName("GLThread " + getId());
            new StringBuilder("starting tid=").append(getId());
            try {
                auc();
            } catch (InterruptedException | RuntimeException e2) {
            } finally {
                GLTextureView.HhH.b(this);
                AppMethodBeat.o(115596);
            }
        }

        private void aua() {
            AppMethodBeat.i(115597);
            if (this.EjC) {
                this.EjC = false;
                h hVar = this.HhP;
                new StringBuilder("destroySurface()  tid=").append(Thread.currentThread().getId());
                hVar.atZ();
            }
            AppMethodBeat.o(115597);
        }

        private void aub() {
            AppMethodBeat.i(115598);
            if (this.EjB) {
                this.HhP.finish();
                this.EjB = false;
                GLTextureView.HhH.c(this);
            }
            AppMethodBeat.o(115598);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:135:0x03e8, code lost:
            if (r6 == false) goto L_0x061e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:0x03ea, code lost:
            r7 = r22.HhP;
            new java.lang.StringBuilder("createSurface()  tid=").append(java.lang.Thread.currentThread().getId());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x0407, code lost:
            if (r7.egl != null) goto L_0x0418;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:138:0x0409, code lost:
            r4 = new java.lang.RuntimeException("egl not initialized");
            com.tencent.matrix.trace.core.AppMethodBeat.o(115599);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:139:0x0417, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x041a, code lost:
            if (r7.eglDisplay != null) goto L_0x042b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x041c, code lost:
            r4 = new java.lang.RuntimeException("eglDisplay not initialized");
            com.tencent.matrix.trace.core.AppMethodBeat.o(115599);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x042a, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x042d, code lost:
            if (r7.eglConfig != null) goto L_0x043e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x042f, code lost:
            r4 = new java.lang.RuntimeException("eglConfig not initialized");
            com.tencent.matrix.trace.core.AppMethodBeat.o(115599);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:147:0x043d, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x043e, code lost:
            r7.atZ();
            r4 = r7.Eju.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x0449, code lost:
            if (r4 == null) goto L_0x04a4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:151:0x044f, code lost:
            if (r4.getSurfaceTexture() == null) goto L_0x04a4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:0x0451, code lost:
            r7.eglSurface = r4.HhM.createWindowSurface(r7.egl, r7.eglDisplay, r7.eglConfig, r4.getSurfaceTexture());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x0475, code lost:
            if (r7.eglSurface == null) goto L_0x047f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:156:0x047d, code lost:
            if (r7.eglSurface != javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) goto L_0x04a8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:157:0x047f, code lost:
            r7.egl.eglGetError();
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:158:0x0485, code lost:
            if (r4 != false) goto L_0x04d8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x0487, code lost:
            r7 = com.tencent.mm.plugin.voip.video.GLTextureView.HhH;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x048b, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:?, code lost:
            r22.Ejz = true;
            com.tencent.mm.plugin.voip.video.GLTextureView.HhH.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:0x0498, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x049b, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x04a3, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:170:0x04a4, code lost:
            r7.eglSurface = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:172:0x04c6, code lost:
            if (r7.egl.eglMakeCurrent(r7.eglDisplay, r7.eglSurface, r7.eglSurface, r7.eglContext) != false) goto L_0x04d6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:173:0x04c8, code lost:
            com.tencent.mm.plugin.voip.video.GLTextureView.h.Q("eglMakeCurrent", r7.egl.eglGetError());
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:174:0x04d6, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:0x04d8, code lost:
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:0x04da, code lost:
            if (r15 == false) goto L_0x061a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:0x04dc, code lost:
            r4 = r22.HhP;
            r6 = r4.eglContext.getGL();
            r4 = r4.Eju.get();
            r6 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x04ee, code lost:
            if (r4 == null) goto L_0x0617;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:180:0x04f4, code lost:
            if (r4.HhN == null) goto L_0x04fe;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:181:0x04f6, code lost:
            r6 = r4.HhN.auh();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:182:0x04fe, code lost:
            r6 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:183:0x0504, code lost:
            if ((r4.Ejj & 3) == 0) goto L_0x0617;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:184:0x0506, code lost:
            r17 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:185:0x050f, code lost:
            if ((r4.Ejj & 1) == 0) goto L_0x0513;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:186:0x0511, code lost:
            r17 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:188:0x0519, code lost:
            if ((r4.Ejj & 2) == 0) goto L_0x062e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x051b, code lost:
            r4 = new com.tencent.mm.plugin.voip.video.GLTextureView.l();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:190:0x0520, code lost:
            r4 = android.opengl.GLDebugHelper.wrap(r6, r17, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:191:0x0527, code lost:
            r4 = (javax.microedition.khronos.opengles.GL10) r4;
            com.tencent.mm.plugin.voip.video.GLTextureView.HhH.b(r4);
            r15 = false;
            r17 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:192:0x0533, code lost:
            if (r16 == false) goto L_0x0552;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:193:0x0535, code lost:
            r4 = r22.Eju.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:194:0x053f, code lost:
            if (r4 == null) goto L_0x0550;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:195:0x0541, code lost:
            r4.HhJ.onSurfaceCreated(r17, r22.HhP.eglConfig);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:196:0x0550, code lost:
            r16 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:197:0x0552, code lost:
            if (r13 == false) goto L_0x0587;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:198:0x0554, code lost:
            new java.lang.StringBuilder("onSurfaceChanged(").append(r10).append(", ").append(r9).append(")");
            r4 = r22.Eju.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:199:0x057b, code lost:
            if (r4 == null) goto L_0x0586;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:200:0x057d, code lost:
            r4.HhJ.onSurfaceChanged(r17, r10, r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:201:0x0586, code lost:
            r13 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:202:0x0587, code lost:
            new java.lang.StringBuilder("onDrawFrame tid=").append(getId());
            r4 = r22.Eju.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:203:0x05a2, code lost:
            if (r4 == null) goto L_0x05ad;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:204:0x05a4, code lost:
            r4.HhJ.onDrawFrame(r17);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:205:0x05ad, code lost:
            r4 = r22.HhP;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:206:0x05c3, code lost:
            if (r4.egl.eglSwapBuffers(r4.eglDisplay, r4.eglSurface) != false) goto L_0x05ef;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:207:0x05c5, code lost:
            r4 = r4.egl.eglGetError();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:208:0x05cb, code lost:
            switch(r4) {
                case 12288: goto L_0x05e6;
                case 12302: goto L_0x05f2;
                default: goto L_0x05ce;
            };
         */
        /* JADX WARNING: Code restructure failed: missing block: B:209:0x05ce, code lost:
            com.tencent.mm.plugin.voip.video.GLTextureView.h.Q("eglSwapBuffers", r4);
            r6 = com.tencent.mm.plugin.voip.video.GLTextureView.HhH;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:210:0x05d8, code lost:
            monitor-enter(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:213:?, code lost:
            r22.Ejz = true;
            com.tencent.mm.plugin.voip.video.GLTextureView.HhH.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:214:0x05e5, code lost:
            monitor-exit(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:215:0x05e6, code lost:
            if (r12 == false) goto L_0x062c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:216:0x05e8, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:217:0x05e9, code lost:
            r5 = r4;
            r6 = r7;
            r18 = r17;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:218:0x05ef, code lost:
            r4 = 12288;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:219:0x05f2, code lost:
            new java.lang.StringBuilder("egl context lost tid=").append(getId());
            r14 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:220:0x0605, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:222:0x0607, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(115599);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:223:0x060d, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:228:0x0617, code lost:
            r4 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:229:0x061a, code lost:
            r17 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:230:0x061e, code lost:
            r7 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:234:0x062c, code lost:
            r4 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:235:0x062e, code lost:
            r4 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x006d, code lost:
            if (r8 == null) goto L_0x03e8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x006f, code lost:
            r8.run();
            r8 = null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void auc() {
            /*
            // Method dump skipped, instructions count: 1596
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.video.GLTextureView.i.auc():void");
        }

        /* access modifiers changed from: package-private */
        public final boolean aue() {
            return !this.tN && this.Ejy && !this.Ejz && this.width > 0 && this.height > 0 && (this.EjE || this.hEi == 1);
        }

        public final void setRenderMode(int i2) {
            AppMethodBeat.i(115600);
            if (i2 < 0 || i2 > 1) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("renderMode");
                AppMethodBeat.o(115600);
                throw illegalArgumentException;
            }
            synchronized (GLTextureView.HhH) {
                try {
                    this.hEi = i2;
                    GLTextureView.HhH.notifyAll();
                } finally {
                    AppMethodBeat.o(115600);
                }
            }
        }

        public final int getRenderMode() {
            int i2;
            AppMethodBeat.i(115601);
            synchronized (GLTextureView.HhH) {
                try {
                    i2 = this.hEi;
                } finally {
                    AppMethodBeat.o(115601);
                }
            }
            return i2;
        }

        public final void requestRender() {
            AppMethodBeat.i(115602);
            synchronized (GLTextureView.HhH) {
                try {
                    this.EjE = true;
                    GLTextureView.HhH.notifyAll();
                } finally {
                    AppMethodBeat.o(115602);
                }
            }
        }

        public final void feo() {
            AppMethodBeat.i(115603);
            synchronized (GLTextureView.HhH) {
                try {
                    this.Ejv = true;
                    GLTextureView.HhH.notifyAll();
                    while (!this.Ejw) {
                        try {
                            GLTextureView.HhH.wait();
                        } catch (InterruptedException e2) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } finally {
                    AppMethodBeat.o(115603);
                }
            }
        }

        public final void queueEvent(Runnable runnable) {
            AppMethodBeat.i(235819);
            if (runnable == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("r must not be null");
                AppMethodBeat.o(235819);
                throw illegalArgumentException;
            }
            synchronized (GLTextureView.HhH) {
                try {
                    this.hgk.add(runnable);
                    GLTextureView.HhH.notifyAll();
                } finally {
                    AppMethodBeat.o(235819);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class l extends Writer {
        private StringBuilder EjO = new StringBuilder();

        l() {
            AppMethodBeat.i(115608);
            AppMethodBeat.o(115608);
        }

        @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
        public final void close() {
            AppMethodBeat.i(115609);
            fw();
            AppMethodBeat.o(115609);
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
            AppMethodBeat.i(115610);
            fw();
            AppMethodBeat.o(115610);
        }

        @Override // java.io.Writer
        public final void write(char[] cArr, int i2, int i3) {
            AppMethodBeat.i(115611);
            for (int i4 = 0; i4 < i3; i4++) {
                char c2 = cArr[i2 + i4];
                if (c2 == '\n') {
                    fw();
                } else {
                    this.EjO.append(c2);
                }
            }
            AppMethodBeat.o(115611);
        }

        private void fw() {
            AppMethodBeat.i(115612);
            if (this.EjO.length() > 0) {
                this.EjO.delete(0, this.EjO.length());
            }
            AppMethodBeat.o(115612);
        }
    }

    private void atX() {
        AppMethodBeat.i(115635);
        if (this.HhI != null) {
            IllegalStateException illegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
            AppMethodBeat.o(115635);
            throw illegalStateException;
        }
        AppMethodBeat.o(115635);
    }

    /* access modifiers changed from: package-private */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean EjI;
        private int EjJ;
        private boolean EjK;
        boolean EjL;
        private boolean EjM;
        i HhQ;

        private j() {
        }

        /* synthetic */ j(byte b2) {
            this();
        }

        public final synchronized void b(i iVar) {
            AppMethodBeat.i(115604);
            new StringBuilder("exiting tid=").append(iVar.getId());
            iVar.Ejw = true;
            if (this.HhQ == iVar) {
                this.HhQ = null;
            }
            notifyAll();
            AppMethodBeat.o(115604);
        }

        public final void c(i iVar) {
            AppMethodBeat.i(115605);
            if (this.HhQ == iVar) {
                this.HhQ = null;
            }
            notifyAll();
            AppMethodBeat.o(115605);
        }

        public final synchronized boolean fep() {
            return this.EjM;
        }

        public final synchronized boolean feq() {
            boolean z;
            AppMethodBeat.i(115606);
            fer();
            if (!this.EjL) {
                z = true;
                AppMethodBeat.o(115606);
            } else {
                z = false;
                AppMethodBeat.o(115606);
            }
            return z;
        }

        public final synchronized void b(GL10 gl10) {
            boolean z = true;
            synchronized (this) {
                AppMethodBeat.i(115607);
                if (!this.EjK) {
                    fer();
                    String glGetString = gl10.glGetString(7937);
                    if (this.EjJ < 131072) {
                        this.EjL = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    if (this.EjL) {
                        z = false;
                    }
                    this.EjM = z;
                    new StringBuilder("checkGLDriver renderer = \"").append(glGetString).append("\" multipleContextsAllowed = ").append(this.EjL).append(" limitedGLESContexts = ").append(this.EjM);
                    this.EjK = true;
                }
                AppMethodBeat.o(115607);
            }
        }

        /* access modifiers changed from: package-private */
        public final void fer() {
            if (!this.EjI) {
                this.EjI = true;
            }
        }
    }
}

package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

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
    private static final j Ejc = new j((byte) 0);
    private static final String TAG = GLTextureView.class.getSimpleName();
    public i Ejd;
    private m Eje;
    private e Ejf;
    private f Ejg;
    private g Ejh;
    private k Eji;
    private int Ejj;
    private int Ejk;
    private boolean Ejl;
    List<TextureView.SurfaceTextureListener> Ejm = new ArrayList();
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
        void fes();

        void fet();

        void iF(int i2, int i3);
    }

    static {
        AppMethodBeat.i(97230);
        AppMethodBeat.o(97230);
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(97210);
        setSurfaceTextureListener(this);
        AppMethodBeat.o(97210);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        AppMethodBeat.i(97211);
        try {
            if (this.Ejd != null) {
                this.Ejd.feo();
            }
        } finally {
            super.finalize();
            AppMethodBeat.o(97211);
        }
    }

    public void setGLWrapper(k kVar) {
        this.Eji = kVar;
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
        AppMethodBeat.i(97212);
        atX();
        if (this.Ejf == null) {
            this.Ejf = new n(true);
        }
        if (this.Ejg == null) {
            this.Ejg = new c(this, (byte) 0);
        }
        if (this.Ejh == null) {
            this.Ejh = new d((byte) 0);
        }
        this.Eje = mVar;
        this.Ejd = new i(this.gRZ);
        this.Ejd.start();
        AppMethodBeat.o(97212);
    }

    public void setEGLContextFactory(f fVar) {
        AppMethodBeat.i(97213);
        atX();
        this.Ejg = fVar;
        AppMethodBeat.o(97213);
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        AppMethodBeat.i(97214);
        atX();
        this.Ejh = gVar;
        AppMethodBeat.o(97214);
    }

    public void setEGLConfigChooser(e eVar) {
        AppMethodBeat.i(97215);
        atX();
        this.Ejf = eVar;
        AppMethodBeat.o(97215);
    }

    public void setEGLConfigChooser(boolean z) {
        AppMethodBeat.i(97216);
        setEGLConfigChooser(new n(z));
        AppMethodBeat.o(97216);
    }

    public void setEGLContextClientVersion(int i2) {
        AppMethodBeat.i(97217);
        atX();
        this.Ejk = i2;
        AppMethodBeat.o(97217);
    }

    public void setRenderMode(int i2) {
        AppMethodBeat.i(97218);
        this.Ejd.setRenderMode(i2);
        AppMethodBeat.o(97218);
    }

    public int getRenderMode() {
        AppMethodBeat.i(97219);
        int renderMode = this.Ejd.getRenderMode();
        AppMethodBeat.o(97219);
        return renderMode;
    }

    private void iE(int i2, int i3) {
        boolean z;
        AppMethodBeat.i(97220);
        i iVar = this.Ejd;
        synchronized (Ejc) {
            try {
                iVar.width = i2;
                iVar.height = i3;
                iVar.EjG = true;
                iVar.EjE = true;
                iVar.EjF = false;
                Ejc.notifyAll();
                while (!iVar.Ejw && !iVar.tN && !iVar.EjF) {
                    if (!iVar.EjB || !iVar.EjC || !iVar.aue()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        break;
                    }
                    try {
                        Ejc.wait();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
            } finally {
                AppMethodBeat.o(97220);
            }
        }
    }

    public final void queueEvent(Runnable runnable) {
        AppMethodBeat.i(97221);
        i iVar = this.Ejd;
        if (runnable == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("r must not be null");
            AppMethodBeat.o(97221);
            throw illegalArgumentException;
        }
        synchronized (Ejc) {
            try {
                iVar.hgk.add(runnable);
                Ejc.notifyAll();
            } finally {
                AppMethodBeat.o(97221);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        int i2;
        AppMethodBeat.i(97222);
        super.onAttachedToWindow();
        if (this.detached && this.Eje != null) {
            if (this.Ejd != null) {
                i2 = this.Ejd.getRenderMode();
            } else {
                i2 = 1;
            }
            this.Ejd = new i(this.gRZ);
            if (i2 != 1) {
                this.Ejd.setRenderMode(i2);
            }
            this.Ejd.start();
        }
        this.detached = false;
        AppMethodBeat.o(97222);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(97223);
        if (this.Ejd != null) {
            this.Ejd.feo();
        }
        this.detached = true;
        super.onDetachedFromWindow();
        AppMethodBeat.o(97223);
    }

    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        AppMethodBeat.i(97224);
        getSurfaceTexture();
        iE(i4 - i2, i5 - i3);
        AppMethodBeat.o(97224);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(97226);
        iE(i2, i3);
        for (TextureView.SurfaceTextureListener surfaceTextureListener : this.Ejm) {
            surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        }
        AppMethodBeat.o(97226);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(97228);
        for (TextureView.SurfaceTextureListener surfaceTextureListener : this.Ejm) {
            surfaceTextureListener.onSurfaceTextureUpdated(surfaceTexture);
        }
        AppMethodBeat.o(97228);
    }

    class c implements f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        /* synthetic */ c(GLTextureView gLTextureView, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.f
        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            AppMethodBeat.i(97183);
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, GLTextureView.this.Ejk, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.Ejk == 0) {
                iArr = null;
            }
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
            AppMethodBeat.o(97183);
            return eglCreateContext;
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.f
        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            AppMethodBeat.i(97184);
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                new StringBuilder("display:").append(eGLDisplay).append(" context: ").append(eGLContext);
                h.P("eglDestroyContex", egl10.eglGetError());
            }
            AppMethodBeat.o(97184);
        }
    }

    static class d implements g {
        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.g
        public final EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            EGLSurface eGLSurface = null;
            AppMethodBeat.i(97185);
            try {
                eGLSurface = egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e2) {
                String unused = GLTextureView.TAG;
            }
            AppMethodBeat.o(97185);
            return eGLSurface;
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.g
        public final void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            AppMethodBeat.i(97186);
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
            AppMethodBeat.o(97186);
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

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.e
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
            AppMethodBeat.i(97180);
            this.Ejs = i2;
            this.Ejt = 0;
            AppMethodBeat.o(97180);
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.a
        public final EGLConfig b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            AppMethodBeat.i(97181);
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12325);
                int a3 = a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a2 >= this.Ejs && a3 >= this.Ejt) {
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12324);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a7 = a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a4 == this.Ejo && a5 == this.Ejp && a6 == this.Ejq && a7 == this.Ejr) {
                        AppMethodBeat.o(97181);
                        return eGLConfig;
                    }
                }
            }
            AppMethodBeat.o(97181);
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2) {
            AppMethodBeat.i(97182);
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.value)) {
                int i3 = this.value[0];
                AppMethodBeat.o(97182);
                return i3;
            }
            AppMethodBeat.o(97182);
            return 0;
        }
    }

    class n extends b {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(boolean z) {
            super(z ? 16 : 0);
            AppMethodBeat.i(97209);
            AppMethodBeat.o(97209);
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
            AppMethodBeat.i(97187);
            if (!(this.eglSurface == null || this.eglSurface == EGL10.EGL_NO_SURFACE)) {
                EGL10 egl10 = this.egl;
                EGLDisplay eGLDisplay = this.eglDisplay;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                GLTextureView gLTextureView = this.Eju.get();
                if (gLTextureView != null) {
                    gLTextureView.Ejh.destroySurface(this.egl, this.eglDisplay, this.eglSurface);
                }
                this.eglSurface = null;
            }
            AppMethodBeat.o(97187);
        }

        public final void finish() {
            AppMethodBeat.i(97188);
            if (this.eglContext != null) {
                GLTextureView gLTextureView = this.Eju.get();
                if (gLTextureView != null) {
                    gLTextureView.Ejg.destroyContext(this.egl, this.eglDisplay, this.eglContext);
                }
                this.eglContext = null;
            }
            if (this.eglDisplay != null) {
                this.egl.eglTerminate(this.eglDisplay);
                this.eglDisplay = null;
            }
            AppMethodBeat.o(97188);
        }

        public static void P(String str, int i2) {
            AppMethodBeat.i(97189);
            RuntimeException runtimeException = new RuntimeException(Q(str, i2));
            AppMethodBeat.o(97189);
            throw runtimeException;
        }

        public static String Q(String str, int i2) {
            AppMethodBeat.i(97190);
            String str2 = str + " failed: " + i2;
            AppMethodBeat.o(97190);
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
        private h EjH;
        private WeakReference<GLTextureView> Eju;
        private boolean Ejv;
        boolean Ejw;
        private boolean Ejx;
        boolean Ejy;
        private boolean Ejz;
        private int hEi = 1;
        int height = 0;
        ArrayList<Runnable> hgk = new ArrayList<>();
        boolean tN;
        int width = 0;

        i(WeakReference<GLTextureView> weakReference) {
            AppMethodBeat.i(97191);
            this.Eju = weakReference;
            AppMethodBeat.o(97191);
        }

        public final void run() {
            AppMethodBeat.i(97192);
            setName("GLThread " + getId());
            try {
                auc();
            } catch (InterruptedException e2) {
            } finally {
                GLTextureView.Ejc.b(this);
                AppMethodBeat.o(97192);
            }
        }

        private void aua() {
            AppMethodBeat.i(97193);
            if (this.EjC) {
                this.EjC = false;
                this.EjH.atZ();
            }
            AppMethodBeat.o(97193);
        }

        private void aub() {
            AppMethodBeat.i(97194);
            if (this.EjB) {
                this.EjH.finish();
                this.EjB = false;
                GLTextureView.Ejc.c(this);
            }
            AppMethodBeat.o(97194);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:137:0x02c1, code lost:
            if (r8 == false) goto L_0x04ad;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:138:0x02c3, code lost:
            r9 = r20.EjH;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:139:0x02c9, code lost:
            if (r9.egl != null) goto L_0x02da;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:0x02cb, code lost:
            r2 = new java.lang.RuntimeException("egl not initialized");
            com.tencent.matrix.trace.core.AppMethodBeat.o(97195);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x02d9, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x02dc, code lost:
            if (r9.eglDisplay != null) goto L_0x02ed;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:144:0x02de, code lost:
            r2 = new java.lang.RuntimeException("eglDisplay not initialized");
            com.tencent.matrix.trace.core.AppMethodBeat.o(97195);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x02ec, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:147:0x02ef, code lost:
            if (r9.eglConfig != null) goto L_0x0300;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x02f1, code lost:
            r2 = new java.lang.RuntimeException("eglConfig not initialized");
            com.tencent.matrix.trace.core.AppMethodBeat.o(97195);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x02ff, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:150:0x0300, code lost:
            r9.atZ();
            r2 = r9.Eju.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:151:0x030b, code lost:
            if (r2 == null) goto L_0x034e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:0x030d, code lost:
            r9.eglSurface = r2.Ejh.createWindowSurface(r9.egl, r9.eglDisplay, r9.eglConfig, r2.getSurfaceTexture());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x0327, code lost:
            if (r9.eglSurface == null) goto L_0x032f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:156:0x032d, code lost:
            if (r9.eglSurface != javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) goto L_0x0352;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:157:0x032f, code lost:
            r9.egl.eglGetError();
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:158:0x0335, code lost:
            if (r2 != false) goto L_0x037f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x0337, code lost:
            r9 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.Ejc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x033b, code lost:
            monitor-enter(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:?, code lost:
            r20.Ejz = true;
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.Ejc.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:0x0348, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x0349, code lost:
            r15 = r3;
            r14 = r4;
            r9 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x034e, code lost:
            r9.eglSurface = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:168:0x0364, code lost:
            if (r9.egl.eglMakeCurrent(r9.eglDisplay, r9.eglSurface, r9.eglSurface, r9.eglContext) != false) goto L_0x0374;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x0366, code lost:
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.h.Q("eglMakeCurrent", r9.egl.eglGetError());
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:170:0x0374, code lost:
            r2 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x0376, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:174:0x037e, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:0x037f, code lost:
            r10 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:0x0381, code lost:
            if (r7 == false) goto L_0x03d4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:0x0383, code lost:
            r2 = r20.EjH;
            r7 = r2.eglContext.getGL();
            r2 = r2.Eju.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x0395, code lost:
            if (r2 == null) goto L_0x0490;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:180:0x039b, code lost:
            if (r2.Eji == null) goto L_0x03a5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:181:0x039d, code lost:
            r7 = r2.Eji.auh();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:183:0x03ab, code lost:
            if ((r2.Ejj & 3) == 0) goto L_0x0490;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:184:0x03ad, code lost:
            r9 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:185:0x03b5, code lost:
            if ((r2.Ejj & 1) == 0) goto L_0x03b8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:186:0x03b7, code lost:
            r9 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:188:0x03be, code lost:
            if ((r2.Ejj & 2) == 0) goto L_0x048d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x03c0, code lost:
            r2 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.l();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:190:0x03c5, code lost:
            r2 = android.opengl.GLDebugHelper.wrap(r7, r9, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:191:0x03c9, code lost:
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.Ejc.b((javax.microedition.khronos.opengles.GL10) r2);
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:192:0x03d4, code lost:
            if (r6 == false) goto L_0x03eb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:193:0x03d6, code lost:
            r2 = r20.Eju.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:194:0x03e0, code lost:
            if (r2 == null) goto L_0x03e9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:195:0x03e2, code lost:
            r2.Eje.fes();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:196:0x03e9, code lost:
            r6 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:197:0x03eb, code lost:
            if (r5 == false) goto L_0x0402;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:198:0x03ed, code lost:
            r2 = r20.Eju.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:199:0x03f7, code lost:
            if (r2 == null) goto L_0x0400;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:200:0x03f9, code lost:
            r2.Eje.iF(r12, r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:201:0x0400, code lost:
            r5 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:202:0x0402, code lost:
            r2 = r20.Eju.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:203:0x040c, code lost:
            if (r2 == null) goto L_0x0415;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:204:0x040e, code lost:
            r2.Eje.fet();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:205:0x0415, code lost:
            r8 = java.lang.System.currentTimeMillis();
            r2 = r20.EjH;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:206:0x0429, code lost:
            if (r2.egl.eglSwapBuffers(r2.eglDisplay, r2.eglSurface) != false) goto L_0x0473;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:207:0x042b, code lost:
            r2 = r2.egl.eglGetError();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:208:0x0431, code lost:
            new java.lang.StringBuilder("swap cost ").append(java.lang.System.currentTimeMillis() - r8).append(com.tencent.mm.sdk.platformtools.LocaleUtil.MALAY);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:209:0x044f, code lost:
            switch(r2) {
                case 12288: goto L_0x046a;
                case 12302: goto L_0x0476;
                default: goto L_0x0452;
            };
         */
        /* JADX WARNING: Code restructure failed: missing block: B:210:0x0452, code lost:
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.h.Q("eglSwapBuffers", r2);
            r8 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.Ejc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:211:0x045c, code lost:
            monitor-enter(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:214:?, code lost:
            r20.Ejz = true;
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.Ejc.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:215:0x0469, code lost:
            monitor-exit(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:216:0x046a, code lost:
            if (r13 == false) goto L_0x048b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:217:0x046c, code lost:
            r2 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:218:0x046d, code lost:
            r15 = r2;
            r14 = r4;
            r8 = r10;
            r9 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:219:0x0473, code lost:
            r2 = 12288;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:220:0x0476, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:221:0x0479, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:223:0x047b, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(97195);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:224:0x0481, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:229:0x048b, code lost:
            r2 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:230:0x048d, code lost:
            r2 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:231:0x0490, code lost:
            r2 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:239:0x04ad, code lost:
            r10 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0072, code lost:
            if (r18 == null) goto L_0x02c1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0074, code lost:
            r18.run();
            r18 = null;
            r15 = r3;
            r14 = r4;
            r9 = r6;
         */
        /* JADX WARNING: Removed duplicated region for block: B:135:0x02af  */
        /* JADX WARNING: Removed duplicated region for block: B:251:0x0176 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void auc() {
            /*
            // Method dump skipped, instructions count: 1210
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.i.auc():void");
        }

        /* access modifiers changed from: package-private */
        public final boolean aue() {
            return !this.tN && this.Ejy && !this.Ejz && this.width > 0 && this.height > 0 && (this.EjE || this.hEi == 1);
        }

        public final void setRenderMode(int i2) {
            AppMethodBeat.i(97196);
            if (i2 < 0 || i2 > 1) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("renderMode");
                AppMethodBeat.o(97196);
                throw illegalArgumentException;
            }
            synchronized (GLTextureView.Ejc) {
                try {
                    this.hEi = i2;
                    GLTextureView.Ejc.notifyAll();
                } finally {
                    AppMethodBeat.o(97196);
                }
            }
        }

        public final int getRenderMode() {
            int i2;
            AppMethodBeat.i(97197);
            synchronized (GLTextureView.Ejc) {
                try {
                    i2 = this.hEi;
                } finally {
                    AppMethodBeat.o(97197);
                }
            }
            return i2;
        }

        public final void requestRender() {
            AppMethodBeat.i(97198);
            synchronized (GLTextureView.Ejc) {
                try {
                    this.EjE = true;
                    GLTextureView.Ejc.notifyAll();
                } finally {
                    AppMethodBeat.o(97198);
                }
            }
        }

        public final void feo() {
            AppMethodBeat.i(97199);
            synchronized (GLTextureView.Ejc) {
                try {
                    this.Ejv = true;
                    GLTextureView.Ejc.notifyAll();
                    while (!this.Ejw) {
                        try {
                            GLTextureView.Ejc.wait();
                        } catch (InterruptedException e2) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } finally {
                    AppMethodBeat.o(97199);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class l extends Writer {
        private StringBuilder EjO = new StringBuilder();

        l() {
            AppMethodBeat.i(97204);
            AppMethodBeat.o(97204);
        }

        @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
        public final void close() {
            AppMethodBeat.i(97205);
            fw();
            AppMethodBeat.o(97205);
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
            AppMethodBeat.i(97206);
            fw();
            AppMethodBeat.o(97206);
        }

        @Override // java.io.Writer
        public final void write(char[] cArr, int i2, int i3) {
            AppMethodBeat.i(97207);
            for (int i4 = 0; i4 < i3; i4++) {
                char c2 = cArr[i2 + i4];
                if (c2 == '\n') {
                    fw();
                } else {
                    this.EjO.append(c2);
                }
            }
            AppMethodBeat.o(97207);
        }

        private void fw() {
            AppMethodBeat.i(97208);
            if (this.EjO.length() > 0) {
                this.EjO.delete(0, this.EjO.length());
            }
            AppMethodBeat.o(97208);
        }
    }

    private void atX() {
        AppMethodBeat.i(97229);
        if (this.Ejd != null) {
            IllegalStateException illegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
            AppMethodBeat.o(97229);
            throw illegalStateException;
        }
        AppMethodBeat.o(97229);
    }

    /* access modifiers changed from: package-private */
    public static class j {
        private static String TAG = "GLThreadManager";
        private boolean EjI;
        private int EjJ;
        private boolean EjK;
        boolean EjL;
        private boolean EjM;
        i EjN;

        private j() {
        }

        /* synthetic */ j(byte b2) {
            this();
        }

        public final synchronized void b(i iVar) {
            AppMethodBeat.i(97200);
            iVar.Ejw = true;
            if (this.EjN == iVar) {
                this.EjN = null;
            }
            notifyAll();
            AppMethodBeat.o(97200);
        }

        public final void c(i iVar) {
            AppMethodBeat.i(97201);
            if (this.EjN == iVar) {
                this.EjN = null;
            }
            notifyAll();
            AppMethodBeat.o(97201);
        }

        public final synchronized boolean fep() {
            return this.EjM;
        }

        public final synchronized boolean feq() {
            boolean z;
            AppMethodBeat.i(97202);
            fer();
            if (!this.EjL) {
                z = true;
                AppMethodBeat.o(97202);
            } else {
                z = false;
                AppMethodBeat.o(97202);
            }
            return z;
        }

        public final synchronized void b(GL10 gl10) {
            boolean z = true;
            synchronized (this) {
                AppMethodBeat.i(97203);
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
                    this.EjK = true;
                }
                AppMethodBeat.o(97203);
            }
        }

        /* access modifiers changed from: package-private */
        public final void fer() {
            if (!this.EjI) {
                this.EjI = true;
            }
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(97225);
        i iVar = this.Ejd;
        synchronized (Ejc) {
            try {
                iVar.Ejy = true;
                Ejc.notifyAll();
                while (iVar.EjA && !iVar.Ejw) {
                    try {
                        Ejc.wait();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
            } finally {
                AppMethodBeat.o(97225);
            }
        }
        iE(i2, i3);
        for (TextureView.SurfaceTextureListener surfaceTextureListener : this.Ejm) {
            surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, i2, i3);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(97227);
        i iVar = this.Ejd;
        synchronized (Ejc) {
            try {
                iVar.Ejy = false;
                Ejc.notifyAll();
                while (!iVar.EjA && !iVar.Ejw) {
                    try {
                        Ejc.wait();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
            } catch (Throwable th) {
                AppMethodBeat.o(97227);
                throw th;
            }
        }
        for (TextureView.SurfaceTextureListener surfaceTextureListener : this.Ejm) {
            surfaceTextureListener.onSurfaceTextureDestroyed(surfaceTexture);
        }
        AppMethodBeat.o(97227);
        return true;
    }
}

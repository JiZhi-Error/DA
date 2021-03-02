package com.tencent.mm.dynamicbackground.view;

import android.content.Context;
import android.opengl.GLException;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.io.IOException;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

public class GameGLSurfaceView extends SurfaceView implements SurfaceHolder.Callback2 {
    private static final k gRY = new k((byte) 0);
    private final WeakReference<GameGLSurfaceView> gRZ = new WeakReference<>(this);
    private j gSa;
    private n gSb;
    private e gSc;
    private f gSd;
    private h gSe;
    private l gSf;
    private boolean gSg = false;
    private int gSh;
    private int gSi;
    private boolean gSj;
    private boolean mDetached;

    public interface e {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    public interface f {
        EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    public interface h {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    public interface l {
        GL auh();
    }

    public interface n {
        void atP();

        void atQ();

        void atS();

        void atT();

        void cx(int i2, int i3);

        void onDestroy();

        void onPause();

        void onResume();
    }

    public GameGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(103053);
        getHolder().addCallback(this);
        AppMethodBeat.o(103053);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        AppMethodBeat.i(103054);
        try {
            if (this.gSa != null) {
                this.gSa.aug();
            }
        } finally {
            super.finalize();
            AppMethodBeat.o(103054);
        }
    }

    public void setFps(int i2) {
    }

    public void setGLWrapper(l lVar) {
        this.gSf = lVar;
    }

    public void setDebugFlags(int i2) {
        this.gSh = i2;
    }

    public int getDebugFlags() {
        return this.gSh;
    }

    public void setSwapNow(boolean z) {
        this.gSg = z;
    }

    public boolean getIsSwapNow() {
        return this.gSg;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.gSj = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.gSj;
    }

    public void setRenderer(n nVar) {
        AppMethodBeat.i(103055);
        atX();
        if (this.gSc == null) {
            this.gSc = new o();
        }
        if (this.gSd == null) {
            this.gSd = new c(this, (byte) 0);
        }
        if (this.gSe == null) {
            this.gSe = new d((byte) 0);
        }
        this.gSb = nVar;
        this.gSa = new j(this.gRZ);
        this.gSa.start();
        AppMethodBeat.o(103055);
    }

    public void setEGLContextFactory(f fVar) {
        AppMethodBeat.i(103056);
        atX();
        this.gSd = fVar;
        AppMethodBeat.o(103056);
    }

    public void setEGLWindowSurfaceFactory(h hVar) {
        AppMethodBeat.i(103057);
        atX();
        this.gSe = hVar;
        AppMethodBeat.o(103057);
    }

    public void setEGLConfigChooser(e eVar) {
        AppMethodBeat.i(103058);
        atX();
        this.gSc = eVar;
        AppMethodBeat.o(103058);
    }

    public void setEGLConfigChooser(boolean z) {
        AppMethodBeat.i(103059);
        setEGLConfigChooser(new o());
        AppMethodBeat.o(103059);
    }

    public final void atW() {
        AppMethodBeat.i(103060);
        setEGLConfigChooser(new b());
        AppMethodBeat.o(103060);
    }

    public void setEGLContextClientVersion(int i2) {
        AppMethodBeat.i(103061);
        atX();
        this.gSi = i2;
        AppMethodBeat.o(103061);
    }

    public void setRenderMode(int i2) {
        AppMethodBeat.i(103062);
        this.gSa.setRenderMode(i2);
        AppMethodBeat.o(103062);
    }

    public int getRenderMode() {
        AppMethodBeat.i(103063);
        int renderMode = this.gSa.getRenderMode();
        AppMethodBeat.o(103063);
        return renderMode;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(103064);
        com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.GameGLSurfaceView", "alvinluo GameGLSurfaceView surfaceCreated", new Object[0]);
        j jVar = this.gSa;
        synchronized (gRY) {
            try {
                com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.GLThread", "surfaceCreated tid=" + jVar.getId(), new Object[0]);
                jVar.gSL = true;
                jVar.gSQ = false;
                jVar.gSJ = true;
                gRY.notifyAll();
                while (jVar.gSN && !jVar.gSQ && !jVar.gSG) {
                    try {
                        gRY.wait();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
            } finally {
                AppMethodBeat.o(103064);
            }
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(103065);
        j jVar = this.gSa;
        synchronized (gRY) {
            try {
                com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.GLThread", "surfaceDestroyed tid=" + jVar.getId(), new Object[0]);
                jVar.gSL = false;
                jVar.gSJ = true;
                gRY.notifyAll();
                while (!jVar.gSN && !jVar.gSG) {
                    try {
                        gRY.wait();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
            } finally {
                AppMethodBeat.o(103065);
            }
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        boolean z;
        AppMethodBeat.i(103066);
        j jVar = this.gSa;
        synchronized (gRY) {
            try {
                if (jVar.mWidth != i3 || jVar.mHeight != i4) {
                    jVar.mWidth = i3;
                    jVar.mHeight = i4;
                    jVar.gSV = true;
                    jVar.gPZ = true;
                    jVar.gST = false;
                    jVar.gSJ = true;
                    if (Thread.currentThread() == jVar) {
                        AppMethodBeat.o(103066);
                        return;
                    }
                    gRY.notifyAll();
                    while (!jVar.gSG && !jVar.CA && !jVar.gST) {
                        if (!jVar.gSO || !jVar.gSP || !jVar.aue()) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            break;
                        }
                        com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.GLThread", "onWindowResize waiting for render complete from tid=" + jVar.getId(), new Object[0]);
                        try {
                            gRY.wait();
                        } catch (InterruptedException e2) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    AppMethodBeat.o(103066);
                }
            } finally {
                AppMethodBeat.o(103066);
            }
        }
    }

    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(103067);
        if (this.gSa != null) {
            j jVar = this.gSa;
            synchronized (gRY) {
                try {
                    jVar.gPZ = true;
                    gRY.notifyAll();
                } finally {
                    AppMethodBeat.o(103067);
                }
            }
            return;
        }
        AppMethodBeat.o(103067);
    }

    public final void onPause() {
        AppMethodBeat.i(103068);
        j jVar = this.gSa;
        synchronized (gRY) {
            try {
                com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.GLThread", "onPause tid=" + jVar.getId(), new Object[0]);
                jVar.gSI = true;
                gRY.notifyAll();
                while (!jVar.gSG && !jVar.CA) {
                    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.GLThread", "onPause waiting for mPaused.", new Object[0]);
                    try {
                        gRY.wait();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
            } finally {
                AppMethodBeat.o(103068);
            }
        }
    }

    public void onResume() {
        AppMethodBeat.i(103069);
        com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.GameGLSurfaceView", "onResume", new Object[0]);
        j jVar = this.gSa;
        synchronized (gRY) {
            try {
                com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.GLThread", "onResume tid=" + jVar.getId(), new Object[0]);
                jVar.gSI = false;
                jVar.gSK = false;
                jVar.gPZ = true;
                jVar.gST = false;
                gRY.notifyAll();
                while (!jVar.gSG && jVar.CA && !jVar.gST) {
                    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.GLThread", "onResume waiting for !mPaused.", new Object[0]);
                    try {
                        gRY.wait();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
            } finally {
                AppMethodBeat.o(103069);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        int i2;
        AppMethodBeat.i(103070);
        super.onAttachedToWindow();
        com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.GameGLSurfaceView", "onAttachedToWindow reattach =" + this.mDetached, new Object[0]);
        if (this.mDetached && this.gSb != null) {
            if (this.gSa != null) {
                i2 = this.gSa.getRenderMode();
            } else {
                i2 = 1;
            }
            this.gSa = new j(this.gRZ);
            if (i2 != 1) {
                this.gSa.setRenderMode(i2);
            }
            this.gSa.start();
        }
        this.mDetached = false;
        AppMethodBeat.o(103070);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(103071);
        com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.GameGLSurfaceView", "onDetachedFromWindow", new Object[0]);
        if (this.gSa != null) {
            this.gSa.aug();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
        AppMethodBeat.o(103071);
    }

    class c implements f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        /* synthetic */ c(GameGLSurfaceView gameGLSurfaceView, byte b2) {
            this();
        }

        @Override // com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.f
        public final EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext) {
            AppMethodBeat.i(102981);
            com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.GLThread", "createContext", new Object[0]);
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, GameGLSurfaceView.this.gSi, 12344};
            if (GameGLSurfaceView.this.gSi == 0) {
                iArr = null;
            }
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
            AppMethodBeat.o(102981);
            return eglCreateContext;
        }

        @Override // com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.f
        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            AppMethodBeat.i(102982);
            com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.GLThread", " destroyContext tid=" + Thread.currentThread().getId(), new Object[0]);
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.GLThread", "display:" + eGLDisplay + " context: " + eGLContext, new Object[0]);
                i.P("eglDestroyContex", egl10.eglGetError());
            }
            AppMethodBeat.o(102982);
        }
    }

    static class d implements h {
        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        @Override // com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.h
        public final EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            EGLSurface eGLSurface = null;
            AppMethodBeat.i(102983);
            try {
                eGLSurface = egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e2) {
                com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.GameGLSurfaceView", "eglCreateWindowSurface", e2);
            }
            AppMethodBeat.o(102983);
            return eGLSurface;
        }

        @Override // com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.h
        public final void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            AppMethodBeat.i(102984);
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
            AppMethodBeat.o(102984);
        }
    }

    abstract class a implements e {
        protected int[] gSk;

        /* access modifiers changed from: package-private */
        public abstract EGLConfig b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            if (GameGLSurfaceView.this.gSi == 2 || GameGLSurfaceView.this.gSi == 3) {
                int[] iArr2 = new int[15];
                System.arraycopy(iArr, 0, iArr2, 0, 12);
                iArr2[12] = 12352;
                if (GameGLSurfaceView.this.gSi == 2) {
                    iArr2[13] = 4;
                } else {
                    iArr2[13] = 64;
                }
                iArr2[14] = 12344;
                iArr = iArr2;
            }
            this.gSk = iArr;
        }

        @Override // com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.e
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
        private int[] gSm = new int[1];
        protected int gSn = 8;
        protected int gSo = 8;
        protected int gSp = 8;
        protected int gSq = 8;
        protected int gSr = 16;
        protected int gSs = 8;

        public b() {
            super(new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 8, 12344});
            AppMethodBeat.i(102978);
            AppMethodBeat.o(102978);
        }

        @Override // com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.a
        public final EGLConfig b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            AppMethodBeat.i(102979);
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12325);
                int a3 = a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a2 >= this.gSr && a3 >= this.gSs) {
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12324);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a7 = a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a4 == this.gSn && a5 == this.gSo && a6 == this.gSp && a7 == this.gSq) {
                        AppMethodBeat.o(102979);
                        return eGLConfig;
                    }
                }
            }
            AppMethodBeat.o(102979);
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2) {
            AppMethodBeat.i(102980);
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.gSm)) {
                int i3 = this.gSm[0];
                AppMethodBeat.o(102980);
                return i3;
            }
            AppMethodBeat.o(102980);
            return 0;
        }
    }

    class o extends b {
        public o() {
            super();
        }
    }

    /* access modifiers changed from: package-private */
    public static class i {
        EGLDisplay gSA;
        EGLSurface gSB;
        EGLConfig gSC;
        EGLContext gSD;
        EGLSurface gSE;
        WeakReference<GameGLSurfaceView> gSy;
        EGL10 gSz;

        public i(WeakReference<GameGLSurfaceView> weakReference) {
            this.gSy = weakReference;
        }

        public final void start() {
            AppMethodBeat.i(103032);
            com.tencent.mm.dynamicbackground.a.c.w("MicroMsg.GLThread", "start() tid=" + Thread.currentThread().getId(), new Object[0]);
            this.gSz = (EGL10) EGLContext.getEGL();
            this.gSA = this.gSz.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.gSA == EGL10.EGL_NO_DISPLAY) {
                RuntimeException runtimeException = new RuntimeException("eglGetDisplay failed");
                AppMethodBeat.o(103032);
                throw runtimeException;
            }
            if (!this.gSz.eglInitialize(this.gSA, new int[2])) {
                RuntimeException runtimeException2 = new RuntimeException("eglInitialize failed");
                AppMethodBeat.o(103032);
                throw runtimeException2;
            }
            GameGLSurfaceView gameGLSurfaceView = this.gSy.get();
            if (gameGLSurfaceView == null) {
                this.gSC = null;
                this.gSD = null;
                com.tencent.mm.dynamicbackground.a.c.w("MicroMsg.GameGLSurfaceView", "alvinluo EglHelper start but view is null and set mEglConfig = null, mEglContext = null", new Object[0]);
            } else {
                this.gSC = gameGLSurfaceView.gSc.chooseConfig(this.gSz, this.gSA);
                com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.GameGLSurfaceView", "alvinluo EglHelper start chooseConfig end config: %s, display: %s", Integer.valueOf(this.gSC.hashCode()), Integer.valueOf(this.gSA.hashCode()));
                this.gSD = gameGLSurfaceView.gSd.a(this.gSz, this.gSA, this.gSC, EGL10.EGL_NO_CONTEXT);
                com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.GameGLSurfaceView", "alvinluo EglHelper start createContext end", new Object[0]);
            }
            if (this.gSD == null || this.gSD == EGL10.EGL_NO_CONTEXT) {
                this.gSD = null;
                P("createContext", this.gSz.eglGetError());
            }
            com.tencent.mm.dynamicbackground.a.c.w("MicroMsg.GLThread", "createContext " + this.gSD + " tid=" + Thread.currentThread().getId(), new Object[0]);
            this.gSE = this.gSz.eglCreatePbufferSurface(this.gSA, this.gSC, new int[]{12375, 16, 12374, 16, 12344});
            this.gSz.eglMakeCurrent(this.gSA, this.gSE, this.gSE, this.gSD);
            this.gSB = null;
            AppMethodBeat.o(103032);
        }

        /* access modifiers changed from: package-private */
        public final void atZ() {
            AppMethodBeat.i(103033);
            if (!(this.gSB == null || this.gSB == EGL10.EGL_NO_SURFACE)) {
                EGL10 egl10 = this.gSz;
                EGLDisplay eGLDisplay = this.gSA;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                GameGLSurfaceView gameGLSurfaceView = this.gSy.get();
                if (gameGLSurfaceView != null) {
                    gameGLSurfaceView.gSe.destroySurface(this.gSz, this.gSA, this.gSB);
                }
                this.gSB = null;
            }
            AppMethodBeat.o(103033);
        }

        public static void P(String str, int i2) {
            AppMethodBeat.i(103034);
            String Q = Q(str, i2);
            com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.GLThread", "throwEglException tid=" + Thread.currentThread().getId() + " " + Q, new Object[0]);
            RuntimeException runtimeException = new RuntimeException(Q);
            AppMethodBeat.o(103034);
            throw runtimeException;
        }

        public static void g(String str, String str2, int i2) {
            AppMethodBeat.i(103035);
            com.tencent.mm.dynamicbackground.a.c.w(str, Q(str2, i2), new Object[0]);
            AppMethodBeat.o(103035);
        }

        private static String Q(String str, int i2) {
            AppMethodBeat.i(103036);
            String str2 = str + " failed: " + g.getErrorString(i2);
            AppMethodBeat.o(103036);
            return str2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class j extends Thread {
        boolean CA;
        boolean gPZ;
        private boolean gSF;
        boolean gSG;
        private boolean gSH;
        boolean gSI;
        boolean gSJ;
        boolean gSK;
        boolean gSL;
        private boolean gSM;
        boolean gSN;
        boolean gSO;
        boolean gSP;
        boolean gSQ;
        private boolean gSR;
        private boolean gSS;
        boolean gST;
        private LinkedList<Runnable> gSU = new LinkedList<>();
        boolean gSV = true;
        private i gSW;
        private WeakReference<GameGLSurfaceView> gSy;
        int mHeight;
        private int mRenderMode;
        int mWidth;

        static /* synthetic */ void c(j jVar) {
            AppMethodBeat.i(103045);
            jVar.aua();
            AppMethodBeat.o(103045);
        }

        static /* synthetic */ void d(j jVar) {
            AppMethodBeat.i(103046);
            jVar.aub();
            AppMethodBeat.o(103046);
        }

        j(WeakReference<GameGLSurfaceView> weakReference) {
            AppMethodBeat.i(103037);
            try {
                setPriority(10);
            } catch (Exception e2) {
            }
            this.mWidth = 0;
            this.mHeight = 0;
            this.gPZ = true;
            this.mRenderMode = 1;
            this.gSS = false;
            this.gSy = weakReference;
            AppMethodBeat.o(103037);
        }

        public final void run() {
            AppMethodBeat.i(103038);
            setName("MicroMsg.GLThread" + getId());
            com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.GLThread", "starting tid=" + getId(), new Object[0]);
            try {
                auc();
            } catch (InterruptedException e2) {
                com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.GLThread", e2, "InterruptedException", new Object[0]);
            } catch (Throwable th) {
                com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.GLThread", "alvinluo GLThread#run() stack = [%s]", Log.getStackTraceString(th));
                GameGLSurfaceView gameGLSurfaceView = this.gSy.get();
                if (gameGLSurfaceView != null) {
                    gameGLSurfaceView.gSb.atT();
                }
            } finally {
                GameGLSurfaceView.gRY.f(this);
                AppMethodBeat.o(103038);
            }
        }

        private void aua() {
            if (this.gSP) {
                this.gSP = false;
                this.gSQ = false;
            }
        }

        private void aub() {
            AppMethodBeat.i(103039);
            if (this.gSO) {
                this.gSO = false;
                GameGLSurfaceView.gRY.notifyAll();
            }
            AppMethodBeat.o(103039);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:131:0x03c8, code lost:
            if (r9 == false) goto L_0x071b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x03ca, code lost:
            com.tencent.mm.dynamicbackground.a.c.w("MicroMsg.GLThread", "egl createSurface", new java.lang.Object[0]);
            r10 = r22.gSW;
            com.tencent.mm.dynamicbackground.a.c.w("MicroMsg.GLThread", "createSurface()  tid=" + java.lang.Thread.currentThread().getId(), new java.lang.Object[0]);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x0408, code lost:
            if (r10.gSz != null) goto L_0x0421;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x040a, code lost:
            r4 = new java.lang.RuntimeException("egl not initialized");
            com.tencent.matrix.trace.core.AppMethodBeat.o(103040);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:135:0x0418, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:0x0423, code lost:
            if (r10.gSA != null) goto L_0x0434;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x0425, code lost:
            r4 = new java.lang.RuntimeException("eglDisplay not initialized");
            com.tencent.matrix.trace.core.AppMethodBeat.o(103040);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x0433, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:144:0x0436, code lost:
            if (r10.gSC != null) goto L_0x0447;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x0438, code lost:
            r4 = new java.lang.RuntimeException("mEglConfig not initialized");
            com.tencent.matrix.trace.core.AppMethodBeat.o(103040);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x0446, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:147:0x0447, code lost:
            r10.atZ();
            r4 = r10.gSy.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x0452, code lost:
            if (r4 == null) goto L_0x0556;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x0454, code lost:
            r10.gSB = r4.gSe.createWindowSurface(r10.gSz, r10.gSA, r10.gSC, r4.getHolder());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:151:0x0476, code lost:
            if (r10.gSB == null) goto L_0x047e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x047c, code lost:
            if (r10.gSB != javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) goto L_0x055b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:155:0x0486, code lost:
            if (r10.gSz.eglGetError() != 12299) goto L_0x0494;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:156:0x0488, code lost:
            com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.GLThread", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.", new java.lang.Object[0]);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:157:0x0494, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:158:0x0495, code lost:
            if (r4 == false) goto L_0x05a9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x0497, code lost:
            r9 = com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.gRY;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x049b, code lost:
            monitor-enter(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:?, code lost:
            r22.gSQ = true;
            com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.gRY.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:0x04a8, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x04a9, code lost:
            if (r17 != false) goto L_0x04ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x04ab, code lost:
            com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.GLThread", "notifyOnEglSurfaceChanged", new java.lang.Object[0]);
            r4 = r22.gSy.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:0x04c1, code lost:
            if (r4 == null) goto L_0x04ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:168:0x04c3, code lost:
            r4.gSb.atQ();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x04ca, code lost:
            r11 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:170:0x04cc, code lost:
            if (r16 == false) goto L_0x0525;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x04ce, code lost:
            com.tencent.mm.dynamicbackground.a.c.w("MicroMsg.GLThread", "createGLInterface", new java.lang.Object[0]);
            r4 = r22.gSW;
            r9 = r4.gSD.getGL();
            r4 = r4.gSy.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:172:0x04ec, code lost:
            if (r4 == null) goto L_0x0523;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:174:0x04f2, code lost:
            if (r4.gSf == null) goto L_0x04fc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:0x04f4, code lost:
            r9 = r4.gSf.auh();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:0x0502, code lost:
            if ((r4.gSh & 3) == 0) goto L_0x0523;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x0504, code lost:
            r16 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:179:0x050d, code lost:
            if ((r4.gSh & 1) == 0) goto L_0x0511;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:180:0x050f, code lost:
            r16 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:182:0x0517, code lost:
            if ((r4.gSh & 2) == 0) goto L_0x072a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:183:0x0519, code lost:
            r4 = new com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.m();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:184:0x051e, code lost:
            android.opengl.GLDebugHelper.wrap(r9, r16, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:185:0x0523, code lost:
            r16 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:186:0x0525, code lost:
            if (r17 == false) goto L_0x052e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:187:0x0527, code lost:
            r22.gSy.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:188:0x052e, code lost:
            if (r17 == false) goto L_0x05e7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x0530, code lost:
            com.tencent.mm.dynamicbackground.a.c.w("MicroMsg.GLThread", "createEglContext", new java.lang.Object[0]);
            r4 = r22.gSy.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:190:0x0546, code lost:
            if (r4 == null) goto L_0x05d9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:191:0x0548, code lost:
            r4.gSb.atP();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:192:0x054f, code lost:
            r17 = false;
            r18 = r5;
            r9 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:193:0x0556, code lost:
            r10.gSB = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:195:0x0575, code lost:
            if (r10.gSz.eglMakeCurrent(r10.gSA, r10.gSB, r10.gSB, r10.gSD) != false) goto L_0x0589;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:196:0x0577, code lost:
            com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.i.g("EGLHelper", "eglMakeCurrent", r10.gSz.eglGetError());
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:198:0x058b, code lost:
            if (r10.gSE == null) goto L_0x059d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:199:0x058d, code lost:
            r10.gSz.eglDestroySurface(r10.gSA, r10.gSE);
            r10.gSE = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:200:0x059d, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:201:0x05a0, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:203:0x05a2, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(103040);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:204:0x05a8, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:205:0x05a9, code lost:
            com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.GLThread", "egl createSurface error", new java.lang.Object[0]);
            r10 = com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.gRY;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:206:0x05b9, code lost:
            monitor-enter(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:209:?, code lost:
            r22.gSQ = true;
            r22.gSM = true;
            com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.gRY.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:210:0x05cb, code lost:
            monitor-exit(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:211:0x05cc, code lost:
            r18 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:212:0x05d0, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:214:0x05d2, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(103040);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:215:0x05d8, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:216:0x05d9, code lost:
            com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.GLThread", "alvinluo GLSurfaceView null", new java.lang.Object[0]);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:217:0x05e7, code lost:
            if (r5 == false) goto L_0x0718;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:218:0x05e9, code lost:
            com.tencent.mm.dynamicbackground.a.c.w("MicroMsg.GLThread", "onSurfaceChanged(" + r14 + ", " + r13 + ")", new java.lang.Object[0]);
            r4 = r22.gSy.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:219:0x061e, code lost:
            if (r4 == null) goto L_0x0633;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:221:?, code lost:
            r4.gSb.cx(r14, r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:222:0x0627, code lost:
            com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.GLThread", "GLThread#sizeChanged out synchronized", new java.lang.Object[0]);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:223:0x0633, code lost:
            r10 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:224:0x0635, code lost:
            r4 = r22.gSy.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:225:0x063f, code lost:
            if (r4 == null) goto L_0x0648;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:226:0x0641, code lost:
            r4.gSb.atS();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:227:0x0648, code lost:
            r22.gSy.get();
            r5 = 12288;
            r9 = true;
            r4 = r22.gSy.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:228:0x065c, code lost:
            if (r4 == null) goto L_0x0662;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:229:0x065e, code lost:
            r9 = r4.getIsSwapNow();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:230:0x0662, code lost:
            if (r9 == false) goto L_0x06a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:231:0x0664, code lost:
            r9 = r22.gSW;
            r5 = 12288;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:232:0x066e, code lost:
            if (r9.gSA == null) goto L_0x06a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:234:0x067a, code lost:
            if (r9.gSA == javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY) goto L_0x06a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:236:0x0680, code lost:
            if (r9.gSB == null) goto L_0x06a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:238:0x068c, code lost:
            if (r9.gSB == javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) goto L_0x06a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:240:0x069e, code lost:
            if (r9.gSz.eglSwapBuffers(r9.gSA, r9.gSB) != false) goto L_0x06a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:241:0x06a0, code lost:
            r5 = r9.gSz.eglGetError();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:242:0x06a6, code lost:
            if (r4 == null) goto L_0x06ac;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:243:0x06a8, code lost:
            r4.setSwapNow(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:244:0x06ac, code lost:
            switch(r5) {
                case 12288: goto L_0x06ca;
                case 12302: goto L_0x06ec;
                default: goto L_0x06af;
            };
         */
        /* JADX WARNING: Code restructure failed: missing block: B:245:0x06af, code lost:
            com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.i.g("GLThread", "eglSwapBuffers", r5);
            r5 = com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.gRY;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:246:0x06bc, code lost:
            monitor-enter(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:249:?, code lost:
            r22.gSM = true;
            com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.gRY.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:250:0x06c9, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:251:0x06ca, code lost:
            if (r7 == false) goto L_0x0715;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:252:0x06cc, code lost:
            r4 = true;
            r5 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:253:0x06ce, code lost:
            aud();
            r6 = r4;
            r7 = r5;
            r18 = r10;
            r9 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:254:0x06d8, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:255:0x06d9, code lost:
            com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.GLThread", "GLThread#sizeChanged out synchronized", new java.lang.Object[0]);
            com.tencent.matrix.trace.core.AppMethodBeat.o(103040);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:256:0x06eb, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:257:0x06ec, code lost:
            com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.GLThread", "egl context lost tid=" + getId(), new java.lang.Object[0]);
            r8 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:258:0x070c, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:261:0x0714, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:262:0x0715, code lost:
            r4 = r6;
            r5 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:263:0x0718, code lost:
            r10 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:264:0x071b, code lost:
            r11 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:268:0x072a, code lost:
            r4 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x007a, code lost:
            if (r12 == null) goto L_0x03c8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x007c, code lost:
            r12.run();
            r12 = null;
            r18 = r5;
         */
        /* JADX WARNING: Removed duplicated region for block: B:126:0x038e  */
        /* JADX WARNING: Removed duplicated region for block: B:278:0x0318 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void auc() {
            /*
            // Method dump skipped, instructions count: 1848
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.j.auc():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
            if (r2 == null) goto L_0x0051;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0046, code lost:
            r2.run();
            r0 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
            r0 = r7.gSy.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0059, code lost:
            if (r0 == null) goto L_0x0087;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            r0.gSb.atS();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0062, code lost:
            r0 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0064, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0065, code lost:
            com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.GLThread", android.util.Log.getStackTraceString(r0) + " readyToPauseAlsoDoDraw while() ", new java.lang.Object[0]);
            r0 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0087, code lost:
            r1 = com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.gRY;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x008b, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            r7.gSF = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x008f, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0094, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0096, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(103041);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0099, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void aud() {
            /*
            // Method dump skipped, instructions count: 156
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.j.aud():void");
        }

        /* access modifiers changed from: package-private */
        public final boolean aue() {
            return !this.CA && this.gSL && !this.gSM && this.mWidth > 0 && this.mHeight > 0 && (this.gPZ || this.mRenderMode == 1);
        }

        private boolean auf() {
            return this.CA && this.gSK && this.mWidth > 0 && this.mHeight > 0 && (!this.gPZ || this.mRenderMode == 1);
        }

        public final void setRenderMode(int i2) {
            AppMethodBeat.i(103042);
            if (i2 < 0 || i2 > 1) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("renderMode");
                AppMethodBeat.o(103042);
                throw illegalArgumentException;
            }
            synchronized (GameGLSurfaceView.gRY) {
                try {
                    this.mRenderMode = i2;
                    GameGLSurfaceView.gRY.notifyAll();
                } finally {
                    AppMethodBeat.o(103042);
                }
            }
        }

        public final int getRenderMode() {
            int i2;
            AppMethodBeat.i(103043);
            synchronized (GameGLSurfaceView.gRY) {
                try {
                    i2 = this.mRenderMode;
                } finally {
                    AppMethodBeat.o(103043);
                }
            }
            return i2;
        }

        public final void aug() {
            AppMethodBeat.i(103044);
            synchronized (GameGLSurfaceView.gRY) {
                try {
                    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.GLThread", "requestExitAndWaitForDestory tid=" + getId(), new Object[0]);
                    this.gSF = true;
                    this.gSH = true;
                    this.gSJ = true;
                    GameGLSurfaceView.gRY.notifyAll();
                    while (!this.gSG) {
                        try {
                            GameGLSurfaceView.gRY.wait();
                        } catch (InterruptedException e2) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } finally {
                    AppMethodBeat.o(103044);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class m extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        m() {
            AppMethodBeat.i(103048);
            AppMethodBeat.o(103048);
        }

        @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
        public final void close() {
            AppMethodBeat.i(103049);
            fw();
            AppMethodBeat.o(103049);
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
            AppMethodBeat.i(103050);
            fw();
            AppMethodBeat.o(103050);
        }

        @Override // java.io.Writer
        public final void write(char[] cArr, int i2, int i3) {
            AppMethodBeat.i(103051);
            for (int i4 = 0; i4 < i3; i4++) {
                char c2 = cArr[i2 + i4];
                if (c2 == '\n') {
                    fw();
                } else {
                    this.mBuilder.append(c2);
                }
            }
            AppMethodBeat.o(103051);
        }

        private void fw() {
            AppMethodBeat.i(103052);
            if (this.mBuilder.length() > 0) {
                com.tencent.mm.dynamicbackground.a.c.v("GLSurfaceView", this.mBuilder.toString(), new Object[0]);
                this.mBuilder.delete(0, this.mBuilder.length());
            }
            AppMethodBeat.o(103052);
        }
    }

    private void atX() {
        AppMethodBeat.i(103072);
        if (this.gSa != null) {
            IllegalStateException illegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
            AppMethodBeat.o(103072);
            throw illegalStateException;
        }
        AppMethodBeat.o(103072);
    }

    /* access modifiers changed from: package-private */
    public static class k {
        private static String TAG = "GLThreadManager";

        private k() {
        }

        /* synthetic */ k(byte b2) {
            this();
        }

        public final synchronized void f(j jVar) {
            AppMethodBeat.i(103047);
            com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.GLThread", "exiting tid=" + jVar.getId(), new Object[0]);
            GameGLSurfaceView gameGLSurfaceView = (GameGLSurfaceView) jVar.gSy.get();
            if (gameGLSurfaceView != null) {
                gameGLSurfaceView.gSb.onDestroy();
            } else {
                com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.GLThread", "onFinalize:view = null", new Object[0]);
            }
            i iVar = jVar.gSW;
            com.tencent.mm.dynamicbackground.a.c.w("MicroMsg.GLThread", "destroySurface()  tid=" + Thread.currentThread().getId(), new Object[0]);
            iVar.atZ();
            j.c(jVar);
            j.d(jVar);
            try {
                i iVar2 = jVar.gSW;
                com.tencent.mm.dynamicbackground.a.c.w("MicroMsg.GLThread", "finish() tid=" + Thread.currentThread().getId(), new Object[0]);
                if (iVar2.gSD != null) {
                    GameGLSurfaceView gameGLSurfaceView2 = iVar2.gSy.get();
                    if (gameGLSurfaceView2 != null) {
                        gameGLSurfaceView2.gSd.destroyContext(iVar2.gSz, iVar2.gSA, iVar2.gSD);
                    }
                    iVar2.gSD = null;
                }
                if (iVar2.gSA != null) {
                    iVar2.gSz.eglTerminate(iVar2.gSA);
                    iVar2.gSA = null;
                }
            } catch (Throwable th) {
                com.tencent.mm.dynamicbackground.a.c.e(TAG, "alvinluo GLThread#threadExiting finish stack = [%s]", Log.getStackTraceString(th));
                if (gameGLSurfaceView != null) {
                    gameGLSurfaceView.gSb.atT();
                }
            }
            jVar.gSG = true;
            notifyAll();
            AppMethodBeat.o(103047);
        }
    }

    static {
        AppMethodBeat.i(103073);
        AppMethodBeat.o(103073);
    }

    public static class g implements EGL11 {
        private EGL10 gSt;
        Writer gSu;
        boolean gSv;
        boolean gSw;
        private int gSx;

        public final boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i2, int[] iArr2) {
            AppMethodBeat.i(102985);
            EL("eglChooseConfig");
            a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            a("attrib_list", iArr);
            O("config_size", i2);
            end();
            boolean eglChooseConfig = this.gSt.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i2, iArr2);
            j("configs", eGLConfigArr);
            a("num_config", iArr2);
            dK(eglChooseConfig);
            checkError();
            AppMethodBeat.o(102985);
            return eglChooseConfig;
        }

        public final boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
            AppMethodBeat.i(102986);
            EL("eglCopyBuffers");
            a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            a("surface", eGLSurface);
            e("native_pixmap", obj);
            end();
            boolean eglCopyBuffers = this.gSt.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
            dK(eglCopyBuffers);
            checkError();
            AppMethodBeat.o(102986);
            return eglCopyBuffers;
        }

        public final EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
            AppMethodBeat.i(102987);
            EL("eglCreateContext");
            a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            e("config", eGLConfig);
            a("share_context", eGLContext);
            a("attrib_list", iArr);
            end();
            EGLContext eglCreateContext = this.gSt.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
            aX(eglCreateContext);
            checkError();
            AppMethodBeat.o(102987);
            return eglCreateContext;
        }

        public final EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
            AppMethodBeat.i(102988);
            EL("eglCreatePbufferSurface");
            a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            e("config", eGLConfig);
            a("attrib_list", iArr);
            end();
            EGLSurface eglCreatePbufferSurface = this.gSt.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
            aX(eglCreatePbufferSurface);
            checkError();
            AppMethodBeat.o(102988);
            return eglCreatePbufferSurface;
        }

        public final EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
            AppMethodBeat.i(102989);
            EL("eglCreatePixmapSurface");
            a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            e("config", eGLConfig);
            e("native_pixmap", obj);
            a("attrib_list", iArr);
            end();
            EGLSurface eglCreatePixmapSurface = this.gSt.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
            aX(eglCreatePixmapSurface);
            checkError();
            AppMethodBeat.o(102989);
            return eglCreatePixmapSurface;
        }

        public final EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
            AppMethodBeat.i(102990);
            EL("eglCreateWindowSurface");
            a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            e("config", eGLConfig);
            e("native_window", obj);
            a("attrib_list", iArr);
            end();
            EGLSurface eglCreateWindowSurface = this.gSt.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
            aX(eglCreateWindowSurface);
            checkError();
            AppMethodBeat.o(102990);
            return eglCreateWindowSurface;
        }

        public final boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
            AppMethodBeat.i(102991);
            EL("eglDestroyContext");
            a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            a("context", eGLContext);
            end();
            boolean eglDestroyContext = this.gSt.eglDestroyContext(eGLDisplay, eGLContext);
            dK(eglDestroyContext);
            checkError();
            AppMethodBeat.o(102991);
            return eglDestroyContext;
        }

        public final boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            AppMethodBeat.i(102992);
            EL("eglDestroySurface");
            a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            a("surface", eGLSurface);
            end();
            boolean eglDestroySurface = this.gSt.eglDestroySurface(eGLDisplay, eGLSurface);
            dK(eglDestroySurface);
            checkError();
            AppMethodBeat.o(102992);
            return eglDestroySurface;
        }

        public final boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, int[] iArr) {
            AppMethodBeat.i(102993);
            EL("eglGetConfigAttrib");
            a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            e("config", eGLConfig);
            O("attribute", i2);
            end();
            boolean eglGetConfigAttrib = this.gSt.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, iArr);
            a("value", iArr);
            dK(eglGetConfigAttrib);
            checkError();
            AppMethodBeat.o(102993);
            return false;
        }

        public final boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i2, int[] iArr) {
            AppMethodBeat.i(102994);
            EL("eglGetConfigs");
            a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            O("config_size", i2);
            end();
            boolean eglGetConfigs = this.gSt.eglGetConfigs(eGLDisplay, eGLConfigArr, i2, iArr);
            j("configs", eGLConfigArr);
            a("num_config", iArr);
            dK(eglGetConfigs);
            checkError();
            AppMethodBeat.o(102994);
            return eglGetConfigs;
        }

        public final EGLContext eglGetCurrentContext() {
            AppMethodBeat.i(102995);
            EL("eglGetCurrentContext");
            end();
            EGLContext eglGetCurrentContext = this.gSt.eglGetCurrentContext();
            aX(eglGetCurrentContext);
            checkError();
            AppMethodBeat.o(102995);
            return eglGetCurrentContext;
        }

        public final EGLDisplay eglGetCurrentDisplay() {
            AppMethodBeat.i(102996);
            EL("eglGetCurrentDisplay");
            end();
            EGLDisplay eglGetCurrentDisplay = this.gSt.eglGetCurrentDisplay();
            aX(eglGetCurrentDisplay);
            checkError();
            AppMethodBeat.o(102996);
            return eglGetCurrentDisplay;
        }

        public final EGLSurface eglGetCurrentSurface(int i2) {
            AppMethodBeat.i(102997);
            EL("eglGetCurrentSurface");
            O("readdraw", i2);
            end();
            EGLSurface eglGetCurrentSurface = this.gSt.eglGetCurrentSurface(i2);
            aX(eglGetCurrentSurface);
            checkError();
            AppMethodBeat.o(102997);
            return eglGetCurrentSurface;
        }

        public final EGLDisplay eglGetDisplay(Object obj) {
            AppMethodBeat.i(102998);
            EL("eglGetDisplay");
            e("native_display", obj);
            end();
            EGLDisplay eglGetDisplay = this.gSt.eglGetDisplay(obj);
            aX(eglGetDisplay);
            checkError();
            AppMethodBeat.o(102998);
            return eglGetDisplay;
        }

        public final int eglGetError() {
            AppMethodBeat.i(102999);
            EL("eglGetError");
            end();
            int eglGetError = this.gSt.eglGetError();
            EM(getErrorString(eglGetError));
            AppMethodBeat.o(102999);
            return eglGetError;
        }

        public final boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
            AppMethodBeat.i(103000);
            EL("eglInitialize");
            a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            end();
            boolean eglInitialize = this.gSt.eglInitialize(eGLDisplay, iArr);
            dK(eglInitialize);
            a("major_minor", iArr);
            checkError();
            AppMethodBeat.o(103000);
            return eglInitialize;
        }

        public final boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
            AppMethodBeat.i(103001);
            EL("eglMakeCurrent");
            a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            a("draw", eGLSurface);
            a("read", eGLSurface2);
            a("context", eGLContext);
            end();
            boolean eglMakeCurrent = this.gSt.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
            dK(eglMakeCurrent);
            checkError();
            AppMethodBeat.o(103001);
            return eglMakeCurrent;
        }

        public final boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i2, int[] iArr) {
            AppMethodBeat.i(103002);
            EL("eglQueryContext");
            a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            a("context", eGLContext);
            O("attribute", i2);
            end();
            boolean eglQueryContext = this.gSt.eglQueryContext(eGLDisplay, eGLContext, i2, iArr);
            pc(iArr[0]);
            dK(eglQueryContext);
            checkError();
            AppMethodBeat.o(103002);
            return eglQueryContext;
        }

        public final String eglQueryString(EGLDisplay eGLDisplay, int i2) {
            AppMethodBeat.i(103003);
            EL("eglQueryString");
            a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            O("name", i2);
            end();
            String eglQueryString = this.gSt.eglQueryString(eGLDisplay, i2);
            EM(eglQueryString);
            checkError();
            AppMethodBeat.o(103003);
            return eglQueryString;
        }

        public final boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i2, int[] iArr) {
            AppMethodBeat.i(103004);
            EL("eglQuerySurface");
            a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            a("surface", eGLSurface);
            O("attribute", i2);
            end();
            boolean eglQuerySurface = this.gSt.eglQuerySurface(eGLDisplay, eGLSurface, i2, iArr);
            pc(iArr[0]);
            dK(eglQuerySurface);
            checkError();
            AppMethodBeat.o(103004);
            return eglQuerySurface;
        }

        public final boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            AppMethodBeat.i(103005);
            EL("eglSwapBuffers");
            a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            a("surface", eGLSurface);
            end();
            boolean eglSwapBuffers = this.gSt.eglSwapBuffers(eGLDisplay, eGLSurface);
            dK(eglSwapBuffers);
            checkError();
            AppMethodBeat.o(103005);
            return eglSwapBuffers;
        }

        public final boolean eglTerminate(EGLDisplay eGLDisplay) {
            AppMethodBeat.i(103006);
            EL("eglTerminate");
            a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            end();
            boolean eglTerminate = this.gSt.eglTerminate(eGLDisplay);
            dK(eglTerminate);
            checkError();
            AppMethodBeat.o(103006);
            return eglTerminate;
        }

        public final boolean eglWaitGL() {
            AppMethodBeat.i(103007);
            EL("eglWaitGL");
            end();
            boolean eglWaitGL = this.gSt.eglWaitGL();
            dK(eglWaitGL);
            checkError();
            AppMethodBeat.o(103007);
            return eglWaitGL;
        }

        public final boolean eglWaitNative(int i2, Object obj) {
            AppMethodBeat.i(103008);
            EL("eglWaitNative");
            O("engine", i2);
            e("bindTarget", obj);
            end();
            boolean eglWaitNative = this.gSt.eglWaitNative(i2, obj);
            dK(eglWaitNative);
            checkError();
            AppMethodBeat.o(103008);
            return eglWaitNative;
        }

        private void checkError() {
            AppMethodBeat.i(103009);
            int eglGetError = this.gSt.eglGetError();
            if (eglGetError != 12288) {
                String str = "eglError: " + getErrorString(eglGetError);
                EK(str);
                if (this.gSw) {
                    GLException gLException = new GLException(eglGetError, str);
                    AppMethodBeat.o(103009);
                    throw gLException;
                }
            }
            AppMethodBeat.o(103009);
        }

        private void EK(String str) {
            AppMethodBeat.i(103010);
            log(str + '\n');
            AppMethodBeat.o(103010);
        }

        private void log(String str) {
            AppMethodBeat.i(103011);
            try {
                this.gSu.write(str);
                AppMethodBeat.o(103011);
            } catch (IOException e2) {
                AppMethodBeat.o(103011);
            }
        }

        private void EL(String str) {
            AppMethodBeat.i(103012);
            log(str + '(');
            this.gSx = 0;
            AppMethodBeat.o(103012);
        }

        private void an(String str, String str2) {
            AppMethodBeat.i(103013);
            int i2 = this.gSx;
            this.gSx = i2 + 1;
            if (i2 > 0) {
                log(", ");
            }
            if (this.gSv) {
                log(str + "=");
            }
            log(str2);
            AppMethodBeat.o(103013);
        }

        private void end() {
            AppMethodBeat.i(103014);
            log(");\n");
            flush();
            AppMethodBeat.o(103014);
        }

        private void flush() {
            AppMethodBeat.i(103015);
            try {
                this.gSu.flush();
                AppMethodBeat.o(103015);
            } catch (IOException e2) {
                this.gSu = null;
                AppMethodBeat.o(103015);
            }
        }

        private void O(String str, int i2) {
            AppMethodBeat.i(103016);
            an(str, Integer.toString(i2));
            AppMethodBeat.o(103016);
        }

        private void e(String str, Object obj) {
            AppMethodBeat.i(103017);
            an(str, toString(obj));
            AppMethodBeat.o(103017);
        }

        private void a(String str, EGLDisplay eGLDisplay) {
            AppMethodBeat.i(103018);
            if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
                an(str, "EGL10.EGL_DEFAULT_DISPLAY");
                AppMethodBeat.o(103018);
            } else if (eGLDisplay == EGL_NO_DISPLAY) {
                an(str, "EGL10.EGL_NO_DISPLAY");
                AppMethodBeat.o(103018);
            } else {
                an(str, toString(eGLDisplay));
                AppMethodBeat.o(103018);
            }
        }

        private void a(String str, EGLContext eGLContext) {
            AppMethodBeat.i(103019);
            if (eGLContext == EGL10.EGL_NO_CONTEXT) {
                an(str, "EGL10.EGL_NO_CONTEXT");
                AppMethodBeat.o(103019);
                return;
            }
            an(str, toString(eGLContext));
            AppMethodBeat.o(103019);
        }

        private void a(String str, EGLSurface eGLSurface) {
            AppMethodBeat.i(103020);
            if (eGLSurface == EGL10.EGL_NO_SURFACE) {
                an(str, "EGL10.EGL_NO_SURFACE");
                AppMethodBeat.o(103020);
                return;
            }
            an(str, toString(eGLSurface));
            AppMethodBeat.o(103020);
        }

        private void EM(String str) {
            AppMethodBeat.i(103021);
            log(" returns " + str + ";\n");
            flush();
            AppMethodBeat.o(103021);
        }

        private void pc(int i2) {
            AppMethodBeat.i(103022);
            EM(Integer.toString(i2));
            AppMethodBeat.o(103022);
        }

        private void dK(boolean z) {
            AppMethodBeat.i(103023);
            EM(Boolean.toString(z));
            AppMethodBeat.o(103023);
        }

        private void aX(Object obj) {
            AppMethodBeat.i(103024);
            EM(toString(obj));
            AppMethodBeat.o(103024);
        }

        private static String toString(Object obj) {
            AppMethodBeat.i(103025);
            if (obj == null) {
                AppMethodBeat.o(103025);
                return BuildConfig.COMMAND;
            }
            String obj2 = obj.toString();
            AppMethodBeat.o(103025);
            return obj2;
        }

        private void a(String str, int[] iArr) {
            AppMethodBeat.i(103026);
            if (iArr == null) {
                an(str, BuildConfig.COMMAND);
                AppMethodBeat.o(103026);
                return;
            }
            an(str, c(iArr.length, iArr));
            AppMethodBeat.o(103026);
        }

        private void j(String str, Object[] objArr) {
            AppMethodBeat.i(103027);
            if (objArr == null) {
                an(str, BuildConfig.COMMAND);
                AppMethodBeat.o(103027);
                return;
            }
            an(str, d(objArr.length, objArr));
            AppMethodBeat.o(103027);
        }

        private static String c(int i2, int[] iArr) {
            AppMethodBeat.i(103028);
            StringBuilder sb = new StringBuilder();
            sb.append("{\n");
            int length = iArr.length;
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = i3 + 0;
                sb.append(" [" + i4 + "] = ");
                if (i4 < 0 || i4 >= length) {
                    sb.append("out of bounds");
                } else {
                    sb.append(iArr[i4]);
                }
                sb.append('\n');
            }
            sb.append("}");
            String sb2 = sb.toString();
            AppMethodBeat.o(103028);
            return sb2;
        }

        private static String d(int i2, Object[] objArr) {
            AppMethodBeat.i(103029);
            StringBuilder sb = new StringBuilder();
            sb.append("{\n");
            int length = objArr.length;
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = i3 + 0;
                sb.append(" [" + i4 + "] = ");
                if (i4 < 0 || i4 >= length) {
                    sb.append("out of bounds");
                } else {
                    sb.append(objArr[i4]);
                }
                sb.append('\n');
            }
            sb.append("}");
            String sb2 = sb.toString();
            AppMethodBeat.o(103029);
            return sb2;
        }

        private static String pd(int i2) {
            AppMethodBeat.i(103030);
            String str = "0x" + Integer.toHexString(i2);
            AppMethodBeat.o(103030);
            return str;
        }

        public static String getErrorString(int i2) {
            AppMethodBeat.i(103031);
            switch (i2) {
                case 12288:
                    AppMethodBeat.o(103031);
                    return "EGL_SUCCESS";
                case 12289:
                    AppMethodBeat.o(103031);
                    return "EGL_NOT_INITIALIZED";
                case 12290:
                    AppMethodBeat.o(103031);
                    return "EGL_BAD_ACCESS";
                case 12291:
                    AppMethodBeat.o(103031);
                    return "EGL_BAD_ALLOC";
                case 12292:
                    AppMethodBeat.o(103031);
                    return "EGL_BAD_ATTRIBUTE";
                case 12293:
                    AppMethodBeat.o(103031);
                    return "EGL_BAD_CONFIG";
                case 12294:
                    AppMethodBeat.o(103031);
                    return "EGL_BAD_CONTEXT";
                case 12295:
                    AppMethodBeat.o(103031);
                    return "EGL_BAD_CURRENT_SURFACE";
                case 12296:
                    AppMethodBeat.o(103031);
                    return "EGL_BAD_DISPLAY";
                case 12297:
                    AppMethodBeat.o(103031);
                    return "EGL_BAD_MATCH";
                case 12298:
                    AppMethodBeat.o(103031);
                    return "EGL_BAD_NATIVE_PIXMAP";
                case 12299:
                    AppMethodBeat.o(103031);
                    return "EGL_BAD_NATIVE_WINDOW";
                case 12300:
                    AppMethodBeat.o(103031);
                    return "EGL_BAD_PARAMETER";
                case 12301:
                    AppMethodBeat.o(103031);
                    return "EGL_BAD_SURFACE";
                case 12302:
                    AppMethodBeat.o(103031);
                    return "EGL_CONTEXT_LOST";
                default:
                    String pd = pd(i2);
                    AppMethodBeat.o(103031);
                    return pd;
            }
        }
    }
}

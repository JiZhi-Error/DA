package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public class MMSightCameraGLSurfaceView extends GLSurfaceView {
    private EGLContext ilv;
    int iqx;
    int kxW;
    int kxX;
    a kyg = null;
    private int kyh = 0;
    private c kyi;

    public interface c {
        void enable();
    }

    public MMSightCameraGLSurfaceView(Context context) {
        super(context);
        AppMethodBeat.i(89201);
        init();
        AppMethodBeat.o(89201);
    }

    public MMSightCameraGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(89202);
        init();
        AppMethodBeat.o(89202);
    }

    private void init() {
        AppMethodBeat.i(89203);
        getHolder().addCallback(this);
        try {
            getHolder().setType(2);
        } catch (Exception e2) {
            try {
                getHolder().setType(1);
            } catch (Exception e3) {
                try {
                    getHolder().setType(0);
                } catch (Exception e4) {
                }
            }
        }
        setEGLContextFactory(new b());
        setEGLConfigChooser(new a());
        this.kyg = new a();
        setRenderer(this.kyg);
        setRenderMode(0);
        AppMethodBeat.o(89203);
    }

    public int getFrameWidth() {
        return this.kxW;
    }

    public int getFrameHeight() {
        return this.kxX;
    }

    public int getFrameRotate() {
        return this.iqx;
    }

    public void setOnEglEnableListener(c cVar) {
        this.kyi = cVar;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(89204);
        super.surfaceCreated(surfaceHolder);
        Log.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceCreated: %s this: %s %s", surfaceHolder, this, Integer.valueOf(getId()));
        this.ilv = EGL14.eglGetCurrentContext();
        if (this.kyi != null) {
            this.kyi.enable();
        }
        AppMethodBeat.o(89204);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(89205);
        super.surfaceDestroyed(surfaceHolder);
        Log.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceDestroyed: %s this: %s", surfaceHolder, this);
        AppMethodBeat.o(89205);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        AppMethodBeat.i(89206);
        super.surfaceChanged(surfaceHolder, i2, i3, i4);
        Log.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceChanged, format: %s, w: %s, h: %s this: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), this);
        AppMethodBeat.o(89206);
    }

    /* access modifiers changed from: package-private */
    public class b implements GLSurfaceView.EGLContextFactory {
        private int EGL_CONTEXT_CLIENT_VERSION = 12440;

        b() {
        }

        public final javax.microedition.khronos.egl.EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            AppMethodBeat.i(89199);
            Log.w("MicroMsg.MMSightCameraGLSurfaceView", "creating OpenGL ES 2.0 context");
            javax.microedition.khronos.egl.EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{this.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
            AppMethodBeat.o(89199);
            return eglCreateContext;
        }

        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLContext eGLContext) {
            AppMethodBeat.i(89200);
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
            AppMethodBeat.o(89200);
        }
    }

    public EGLContext getEglContext() {
        return this.ilv;
    }

    /* access modifiers changed from: package-private */
    public class a implements GLSurfaceView.EGLConfigChooser {
        private int EGL_OPENGL_ES2_BIT = 4;
        private int[] gSm = new int[1];
        protected int gSn = 5;
        protected int gSo = 6;
        protected int gSp = 5;
        protected int gSq = 0;
        protected int gSr = 0;
        protected int gSs = 0;
        private int[] ijB = {12324, 4, 12323, 4, 12322, 4, 12352, this.EGL_OPENGL_ES2_BIT, 12344};

        public a() {
            AppMethodBeat.i(89194);
            AppMethodBeat.o(89194);
        }

        public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            AppMethodBeat.i(89195);
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, this.ijB, null, 0, iArr);
            int i2 = iArr[0];
            if (i2 <= 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No configs match configSpec");
                AppMethodBeat.o(89195);
                throw illegalArgumentException;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i2];
            egl10.eglChooseConfig(eGLDisplay, this.ijB, eGLConfigArr, i2, iArr);
            c(egl10, eGLDisplay, eGLConfigArr);
            EGLConfig b2 = b(egl10, eGLDisplay, eGLConfigArr);
            AppMethodBeat.o(89195);
            return b2;
        }

        private EGLConfig b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            AppMethodBeat.i(89196);
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12325);
                int a3 = a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a2 >= this.gSr && a3 >= this.gSs) {
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12324);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a7 = a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a4 == this.gSn && a5 == this.gSo && a6 == this.gSp && a7 == this.gSq) {
                        AppMethodBeat.o(89196);
                        return eGLConfig;
                    }
                }
            }
            AppMethodBeat.o(89196);
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2) {
            AppMethodBeat.i(89197);
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.gSm)) {
                int i3 = this.gSm[0];
                AppMethodBeat.o(89197);
                return i3;
            }
            AppMethodBeat.o(89197);
            return 0;
        }

        private static void c(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            AppMethodBeat.i(89198);
            int length = eGLConfigArr.length;
            Log.i("GLConfigChooser", String.format("%d configurations", Integer.valueOf(length)));
            for (int i2 = 0; i2 < length; i2++) {
                Log.i("GLConfigChooser", String.format("Configuration %d:\n", Integer.valueOf(i2)));
                EGLConfig eGLConfig = eGLConfigArr[i2];
                int[] iArr = {12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, 12345, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354};
                String[] strArr = {"EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT"};
                int[] iArr2 = new int[1];
                for (int i3 = 0; i3 < 33; i3++) {
                    egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, iArr[i3], iArr2);
                }
            }
            AppMethodBeat.o(89198);
        }
    }
}

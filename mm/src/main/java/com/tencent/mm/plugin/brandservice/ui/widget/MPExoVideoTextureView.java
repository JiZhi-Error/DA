package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.AttributeSet;
import android.view.Surface;
import android.widget.RelativeLayout;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.tools.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMTextureView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class MPExoVideoTextureView extends MMTextureView {
    private int mVideoHeight;
    private int mVideoWidth;
    private w pMX;

    public MPExoVideoTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MPExoVideoTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(6261);
        this.pMX = new w();
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        AppMethodBeat.o(6261);
    }

    public final void stop() {
        AppMethodBeat.i(6262);
        cro();
        this.pMX.reset();
        AppMethodBeat.o(6262);
    }

    public final void setVideoSize(int i2, int i3) {
        this.mVideoWidth = i2;
        this.mVideoHeight = i3;
    }

    public final void crn() {
        AppMethodBeat.i(6263);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        layoutParams.addRule(13);
        setLayoutParams(layoutParams);
        AppMethodBeat.o(6263);
    }

    public void setScaleType(i.e eVar) {
        AppMethodBeat.i(6264);
        this.pMX.a(eVar);
        requestLayout();
        AppMethodBeat.o(6264);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(6265);
        if (this.mVideoWidth == 0 || this.mVideoHeight == 0) {
            setMeasuredDimension(1, 1);
            AppMethodBeat.o(6265);
            return;
        }
        this.pMX.y(getDefaultSize(1, i2), getDefaultSize(1, i3), this.mVideoWidth, this.mVideoHeight);
        setMeasuredDimension(this.pMX.mEZ, this.pMX.mFa);
        AppMethodBeat.o(6265);
    }

    public final void cro() {
        AppMethodBeat.i(6266);
        try {
            SurfaceTexture surfaceTexture = getSurfaceTexture();
            if (surfaceTexture != null) {
                Log.i("MicroMsg.MPExoVideoTextureView", "%d releaseSurface", Integer.valueOf(hashCode()));
                h(surfaceTexture);
            }
            AppMethodBeat.o(6266);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MPExoVideoTextureView", e2, "release surface", new Object[0]);
            AppMethodBeat.o(6266);
        }
    }

    private static void h(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(6267);
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, null);
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344}, eGLConfigArr, 1, new int[1]);
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        EGLSurface eglCreateWindowSurface = egl10.eglCreateWindowSurface(eglGetDisplay, eGLConfig, surfaceTexture, new int[]{12344});
        egl10.eglMakeCurrent(eglGetDisplay, eglCreateWindowSurface, eglCreateWindowSurface, eglCreateContext);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        egl10.eglSwapBuffers(eglGetDisplay, eglCreateWindowSurface);
        egl10.eglDestroySurface(eglGetDisplay, eglCreateWindowSurface);
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eglGetDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
        egl10.eglTerminate(eglGetDisplay);
        AppMethodBeat.o(6267);
    }

    public final void h(final Surface surface) {
        AppMethodBeat.i(6268);
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoTextureView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(6260);
                try {
                    if (surface != null && surface.isValid()) {
                        Log.i("MicroMsg.MPExoVideoTextureView", "%d release surface [%d]", Integer.valueOf(hashCode()), Integer.valueOf(surface.hashCode()));
                        surface.release();
                    }
                    AppMethodBeat.o(6260);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.MPExoVideoTextureView", e2, "release Surface error", new Object[0]);
                    AppMethodBeat.o(6260);
                }
            }
        });
        AppMethodBeat.o(6268);
    }
}

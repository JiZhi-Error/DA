package com.tencent.xweb.skia_canvas.external_texture;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class SurfaceTextureRender {
    private static final String LOG_TAG = "SurfaceTextureRender";
    private EGL10 egl;
    private EGLConfig eglConfig;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface;
    private int mHeight;
    private boolean mInited;
    private int mWidth;
    private SurfaceTexture surfaceTexture;

    SurfaceTextureRender(SurfaceTexture surfaceTexture2) {
        this.surfaceTexture = surfaceTexture2;
    }

    /* access modifiers changed from: package-private */
    public void init(EGL10 egl10, EGLContext eGLContext, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        AppMethodBeat.i(4330);
        if (!this.mInited) {
            this.egl = egl10;
            this.eglContext = eGLContext;
            this.eglDisplay = eGLDisplay;
            this.eglConfig = eGLConfig;
            initEGLSurface();
            this.mInited = true;
        }
        AppMethodBeat.o(4330);
    }

    /* access modifiers changed from: package-private */
    public void makeCurrent() {
        AppMethodBeat.i(4331);
        this.egl.eglMakeCurrent(this.eglDisplay, this.eglSurface, this.eglSurface, this.eglContext);
        AppMethodBeat.o(4331);
    }

    public SurfaceTexture getSurface() {
        return this.surfaceTexture;
    }

    /* access modifiers changed from: package-private */
    public void adjustViewPort() {
        AppMethodBeat.i(4332);
        GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
        AppMethodBeat.o(4332);
    }

    /* access modifiers changed from: package-private */
    public void swapBuffer() {
        AppMethodBeat.i(4333);
        this.egl.eglSwapBuffers(this.eglDisplay, this.eglSurface);
        AppMethodBeat.o(4333);
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    private void initEGLSurface() {
        AppMethodBeat.i(4334);
        this.eglSurface = this.egl.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, this.surfaceTexture, null);
        if (this.eglSurface == null || this.eglSurface == EGL10.EGL_NO_SURFACE) {
            RuntimeException runtimeException = new RuntimeException("GL Error: " + GLUtils.getEGLErrorString(this.egl.eglGetError()) + " with surface " + this.surfaceTexture);
            AppMethodBeat.o(4334);
            throw runtimeException;
        } else if (!this.egl.eglMakeCurrent(this.eglDisplay, this.eglSurface, this.eglSurface, this.eglContext)) {
            RuntimeException runtimeException2 = new RuntimeException("GL Make current error: " + GLUtils.getEGLErrorString(this.egl.eglGetError()));
            AppMethodBeat.o(4334);
            throw runtimeException2;
        } else {
            int[] iArr = new int[1];
            this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, iArr);
            this.mWidth = iArr[0];
            this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, iArr);
            this.mHeight = iArr[0];
            new StringBuilder("query w/h is ").append(this.mWidth).append(" / ").append(this.mHeight).append(" from ").append(this.surfaceTexture);
            AppMethodBeat.o(4334);
        }
    }

    /* access modifiers changed from: package-private */
    public void deinitGL() {
        AppMethodBeat.i(4335);
        if (this.mInited) {
            EGL10 egl10 = this.egl;
            EGLDisplay eGLDisplay = this.eglDisplay;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.egl.eglDestroySurface(this.eglDisplay, this.eglSurface);
        }
        AppMethodBeat.o(4335);
    }
}

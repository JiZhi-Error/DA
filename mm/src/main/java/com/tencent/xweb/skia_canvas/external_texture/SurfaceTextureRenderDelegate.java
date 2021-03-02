package com.tencent.xweb.skia_canvas.external_texture;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class SurfaceTextureRenderDelegate implements SurfaceTexture.OnFrameAvailableListener, Runnable {
    private static final String LOG_TAG = "STRenderDelegate";
    private static final short[] drawOrder = {0, 1, 2, 0, 2, 3};
    private static final String fragmentShaderCode = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;uniform samplerExternalOES texture;varying vec2 v_TexCoordinate;void main () {    vec4 color = texture2D(texture, v_TexCoordinate);    gl_FragColor = color;}";
    private static final float[] squareCoords = {-squareSize, squareSize, 0.0f, -squareSize, -squareSize, 0.0f, squareSize, -squareSize, 0.0f, squareSize, squareSize, 0.0f};
    private static float squareSize = 1.0f;
    private static final String vertexShaderCode = "attribute vec4 vPosition;attribute vec4 vTexCoordinate;uniform mat4 textureTransform;varying vec2 v_TexCoordinate;void main() {   v_TexCoordinate = (textureTransform * vTexCoordinate).xy;   gl_Position = vPosition;}";
    private ShortBuffer drawListBuffer;
    private EGL10 egl;
    private EGLConfig eglConfig;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface fakeEglSurface;
    private volatile boolean frameAvailable;
    private List<SurfaceTextureRender> mDownStreamSurfaceTextureRenderList;
    private List<SurfaceTexture> mPendingRemoveSurfaceTextureList;
    private List<Runnable> mReleaseRunnableList;
    private volatile boolean mShouldRun;
    private SurfaceTexture mUpstreamSurfaceTexture;
    private boolean mUseFakeSurface;
    private Thread mWorkThread;
    private int shaderProgram;
    private FloatBuffer textureBuffer;
    private final float[] textureCoords;
    private int[] textures;
    private FloatBuffer vertexBuffer;
    private float[] videoTextureTransform;

    public SurfaceTextureRenderDelegate(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(4336);
        this.textureCoords = new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};
        this.textures = new int[1];
        this.videoTextureTransform = new float[16];
        this.mUpstreamSurfaceTexture = surfaceTexture;
        this.mUpstreamSurfaceTexture.setOnFrameAvailableListener(this);
        this.mReleaseRunnableList = new ArrayList();
        this.mDownStreamSurfaceTextureRenderList = new ArrayList();
        this.mPendingRemoveSurfaceTextureList = new ArrayList();
        this.mShouldRun = true;
        this.mWorkThread = new Thread(this);
        this.mWorkThread.start();
        AppMethodBeat.o(4336);
    }

    public SurfaceTextureRenderDelegate(SurfaceTexture surfaceTexture, SurfaceTexture surfaceTexture2) {
        this(surfaceTexture);
        AppMethodBeat.i(4337);
        addDownStreamSurfaceTexture(surfaceTexture2);
        AppMethodBeat.o(4337);
    }

    public void destroy() {
        this.mShouldRun = false;
    }

    public void addReleaseCallback(Runnable runnable) {
        AppMethodBeat.i(4338);
        this.mReleaseRunnableList.add(runnable);
        AppMethodBeat.o(4338);
    }

    public synchronized void addDownStreamSurfaceTexture(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(4339);
        this.mDownStreamSurfaceTextureRenderList.add(new SurfaceTextureRender(surfaceTexture));
        new StringBuilder("mDownStreamSurfaceTextureRenderList size is ").append(this.mDownStreamSurfaceTextureRenderList.size());
        AppMethodBeat.o(4339);
    }

    public synchronized void removeDownStreamSurfaceTexture(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(4340);
        this.mPendingRemoveSurfaceTextureList.add(surfaceTexture);
        AppMethodBeat.o(4340);
    }

    public synchronized int getAvailableDownStreamCount() {
        int size;
        AppMethodBeat.i(4341);
        size = this.mDownStreamSurfaceTextureRenderList.size() - this.mPendingRemoveSurfaceTextureList.size();
        AppMethodBeat.o(4341);
        return size;
    }

    private void transferToDownStream(List<SurfaceTextureRender> list) {
        AppMethodBeat.i(4342);
        for (SurfaceTextureRender surfaceTextureRender : list) {
            surfaceTextureRender.init(this.egl, this.eglContext, this.eglDisplay, this.eglConfig);
            surfaceTextureRender.makeCurrent();
            surfaceTextureRender.adjustViewPort();
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
            GLES20.glUseProgram(this.shaderProgram);
            int glGetUniformLocation = GLES20.glGetUniformLocation(this.shaderProgram, "texture");
            int glGetAttribLocation = GLES20.glGetAttribLocation(this.shaderProgram, "vTexCoordinate");
            checkGlError("glGetAttribLocation");
            int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.shaderProgram, "vPosition");
            int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.shaderProgram, "textureTransform");
            GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
            GLES20.glVertexAttribPointer(glGetAttribLocation2, 3, 5126, false, 12, (Buffer) this.vertexBuffer);
            GLES20.glBindTexture(36197, this.textures[0]);
            GLES20.glActiveTexture(33984);
            GLES20.glUniform1i(glGetUniformLocation, 0);
            GLES20.glEnableVertexAttribArray(glGetAttribLocation);
            GLES20.glVertexAttribPointer(glGetAttribLocation, 4, 5126, false, 0, (Buffer) this.textureBuffer);
            GLES20.glUniformMatrix4fv(glGetUniformLocation2, 1, false, this.videoTextureTransform, 0);
            GLES20.glDrawElements(4, drawOrder.length, 5123, this.drawListBuffer);
            GLES20.glDisableVertexAttribArray(glGetAttribLocation2);
            GLES20.glDisableVertexAttribArray(glGetAttribLocation);
            surfaceTextureRender.swapBuffer();
        }
        AppMethodBeat.o(4342);
    }

    public void run() {
        AppMethodBeat.i(4343);
        initOffScreenGL();
        while (this.mShouldRun) {
            long uptimeMillis = SystemClock.uptimeMillis();
            eglMakeCurrentContextWithoutSurface(this.egl, this.eglDisplay, this.eglContext, this.eglConfig);
            synchronized (this) {
                try {
                    ArrayList arrayList = new ArrayList();
                    for (SurfaceTextureRender surfaceTextureRender : this.mDownStreamSurfaceTextureRenderList) {
                        if (this.mPendingRemoveSurfaceTextureList.contains(surfaceTextureRender.getSurface())) {
                            arrayList.add(surfaceTextureRender);
                        }
                    }
                    this.mDownStreamSurfaceTextureRenderList.removeAll(arrayList);
                    this.mPendingRemoveSurfaceTextureList.clear();
                    if (this.frameAvailable) {
                        this.mUpstreamSurfaceTexture.updateTexImage();
                        this.mUpstreamSurfaceTexture.getTransformMatrix(this.videoTextureTransform);
                        this.frameAvailable = false;
                        transferToDownStream(new ArrayList(this.mDownStreamSurfaceTextureRenderList));
                        try {
                            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                            Thread.sleep(uptimeMillis2 > 16 ? 0 : 16 - uptimeMillis2);
                        } catch (InterruptedException e2) {
                        }
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(4343);
                    throw th;
                }
            }
        }
        deinitGL();
        for (Runnable runnable : this.mReleaseRunnableList) {
            runnable.run();
        }
        AppMethodBeat.o(4343);
    }

    private void initOffScreenGL() {
        AppMethodBeat.i(4344);
        if (this.egl == null) {
            initGL();
            setupVertexBuffer();
            setupTexture();
            loadShaders();
        }
        AppMethodBeat.o(4344);
    }

    private void loadShaders() {
        AppMethodBeat.i(4345);
        int glCreateShader = GLES20.glCreateShader(35633);
        GLES20.glShaderSource(glCreateShader, vertexShaderCode);
        GLES20.glCompileShader(glCreateShader);
        checkGlError("Vertex shader compile");
        int glCreateShader2 = GLES20.glCreateShader(35632);
        GLES20.glShaderSource(glCreateShader2, fragmentShaderCode);
        GLES20.glCompileShader(glCreateShader2);
        checkGlError("Pixel shader compile");
        this.shaderProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(this.shaderProgram, glCreateShader);
        GLES20.glAttachShader(this.shaderProgram, glCreateShader2);
        GLES20.glLinkProgram(this.shaderProgram);
        checkGlError("Shader program compile");
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(this.shaderProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            GLES20.glGetProgramInfoLog(this.shaderProgram);
        }
        AppMethodBeat.o(4345);
    }

    private void setupVertexBuffer() {
        AppMethodBeat.i(4346);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(drawOrder.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.drawListBuffer = allocateDirect.asShortBuffer();
        this.drawListBuffer.put(drawOrder);
        this.drawListBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(squareCoords.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.vertexBuffer = allocateDirect2.asFloatBuffer();
        this.vertexBuffer.put(squareCoords);
        this.vertexBuffer.position(0);
        AppMethodBeat.o(4346);
    }

    public void checkGlError(String str) {
        AppMethodBeat.i(4347);
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                new StringBuilder().append(str).append(": glError ").append(GLUtils.getEGLErrorString(glGetError));
            } else {
                AppMethodBeat.o(4347);
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000f, code lost:
        if (r4.eglMakeCurrent(r5, r0, r0, r6) == false) goto L_0x0011;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void eglMakeCurrentContextWithoutSurface(javax.microedition.khronos.egl.EGL10 r4, javax.microedition.khronos.egl.EGLDisplay r5, javax.microedition.khronos.egl.EGLContext r6, javax.microedition.khronos.egl.EGLConfig r7) {
        /*
            r3 = this;
            r2 = 4348(0x10fc, float:6.093E-42)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            boolean r0 = r3.mUseFakeSurface
            if (r0 != 0) goto L_0x0011
            javax.microedition.khronos.egl.EGLSurface r0 = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE
            boolean r0 = r4.eglMakeCurrent(r5, r0, r0, r6)
            if (r0 != 0) goto L_0x0052
        L_0x0011:
            boolean r0 = r3.mUseFakeSurface
            if (r0 != 0) goto L_0x0024
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "egl makeCurrent with no surface "
            r0.<init>(r1)
            int r1 = r4.eglGetError()
            r0.append(r1)
        L_0x0024:
            javax.microedition.khronos.egl.EGLSurface r0 = r3.fakeEglSurface
            javax.microedition.khronos.egl.EGLSurface r1 = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE
            if (r0 != r1) goto L_0x0039
            r0 = 5
            int[] r0 = new int[r0]
            r0 = {x0056: FILL_ARRAY_DATA  , data: [12375, 1, 12374, 1, 12344} // fill-array
            javax.microedition.khronos.egl.EGLSurface r0 = r4.eglCreatePbufferSurface(r5, r7, r0)
            r3.fakeEglSurface = r0
            r0 = 1
            r3.mUseFakeSurface = r0
        L_0x0039:
            javax.microedition.khronos.egl.EGLSurface r0 = r3.fakeEglSurface
            javax.microedition.khronos.egl.EGLSurface r1 = r3.fakeEglSurface
            boolean r0 = r4.eglMakeCurrent(r5, r0, r1, r6)
            if (r0 != 0) goto L_0x0052
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "egl makeCurrent with fake surface "
            r0.<init>(r1)
            int r1 = r4.eglGetError()
            r0.append(r1)
        L_0x0052:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
            fill-array 0x0056: FILL_ARRAY_DATA  , data: [12375, 1, 12374, 1, 12344]
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.skia_canvas.external_texture.SurfaceTextureRenderDelegate.eglMakeCurrentContextWithoutSurface(javax.microedition.khronos.egl.EGL10, javax.microedition.khronos.egl.EGLDisplay, javax.microedition.khronos.egl.EGLContext, javax.microedition.khronos.egl.EGLConfig):void");
    }

    private void setupTexture() {
        AppMethodBeat.i(4349);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.textureCoords.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.textureBuffer = allocateDirect.asFloatBuffer();
        this.textureBuffer.put(this.textureCoords);
        this.textureBuffer.position(0);
        GLES20.glActiveTexture(33984);
        GLES20.glGenTextures(1, this.textures, 0);
        checkGlError("Texture generate");
        GLES20.glBindTexture(36197, this.textures[0]);
        checkGlError("Texture bind");
        this.mUpstreamSurfaceTexture.attachToGLContext(this.textures[0]);
        AppMethodBeat.o(4349);
    }

    private void initGL() {
        AppMethodBeat.i(4350);
        this.egl = (EGL10) EGLContext.getEGL();
        this.eglDisplay = this.egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.fakeEglSurface = EGL10.EGL_NO_SURFACE;
        this.egl.eglInitialize(this.eglDisplay, new int[2]);
        this.eglConfig = chooseEglConfig();
        this.eglContext = createContext(this.egl, this.eglDisplay, this.eglConfig);
        eglMakeCurrentContextWithoutSurface(this.egl, this.eglDisplay, this.eglContext, this.eglConfig);
        AppMethodBeat.o(4350);
    }

    private void deinitGL() {
        AppMethodBeat.i(4351);
        if (this.fakeEglSurface != EGL10.EGL_NO_SURFACE) {
            this.egl.eglDestroySurface(this.eglDisplay, this.fakeEglSurface);
        }
        EGL10 egl10 = this.egl;
        EGLDisplay eGLDisplay = this.eglDisplay;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        synchronized (this) {
            try {
                for (SurfaceTextureRender surfaceTextureRender : this.mDownStreamSurfaceTextureRenderList) {
                    surfaceTextureRender.deinitGL();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(4351);
                throw th;
            }
        }
        this.egl.eglDestroyContext(this.eglDisplay, this.eglContext);
        this.egl.eglTerminate(this.eglDisplay);
        AppMethodBeat.o(4351);
    }

    private EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        AppMethodBeat.i(4352);
        EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        AppMethodBeat.o(4352);
        return eglCreateContext;
    }

    private EGLConfig chooseEglConfig() {
        AppMethodBeat.i(4353);
        int[] iArr = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!this.egl.eglChooseConfig(this.eglDisplay, getConfig(), eGLConfigArr, 1, iArr)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed to choose config: " + GLUtils.getEGLErrorString(this.egl.eglGetError()));
            AppMethodBeat.o(4353);
            throw illegalArgumentException;
        } else if (iArr[0] > 0) {
            EGLConfig eGLConfig = eGLConfigArr[0];
            AppMethodBeat.o(4353);
            return eGLConfig;
        } else {
            AppMethodBeat.o(4353);
            return null;
        }
    }

    private int[] getConfig() {
        return new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
    }

    public synchronized void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.frameAvailable = true;
    }
}

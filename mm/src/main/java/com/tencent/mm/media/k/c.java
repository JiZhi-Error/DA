package com.tencent.mm.media.k;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.rtmp.TXLiveConstants;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/media/util/GLEnvironmentUtil;", "", "()V", "Companion", "EGLEnvironment", "plugin-mediaeditor_release"})
public final class c {
    public static final float[] ilm = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] iln = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] ilo = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final int[] ilp = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344};
    private static final int[] ilq = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12338, 1, 12337, 4, 12352, 4, 12610, 1, 12344};
    private static final int[] ilr = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344};
    private static final int[] ils = {12320, 32, 12321, 8, 12322, 8, 12323, 8, 12324, 8, 12352, 4, 12339, 4, 12344};
    public static final a ilt = new a((byte) 0);

    public static final void aMY() {
        AppMethodBeat.i(93891);
        a.aMY();
        AppMethodBeat.o(93891);
    }

    public static final void e(int i2, float[] fArr) {
        AppMethodBeat.i(218795);
        a.e(i2, fArr);
        AppMethodBeat.o(218795);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u0006J*\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006J(\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0007J\u001e\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\t2\b\b\u0002\u0010+\u001a\u00020\tJ\u0010\u0010,\u001a\u00020!2\u0006\u0010*\u001a\u00020\tH\u0002JB\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\b\b\u0002\u00107\u001a\u00020)J:\u00108\u001a\u0004\u0018\u0001092\u0006\u00101\u001a\u00020:2\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\b\b\u0002\u00107\u001a\u00020)J\b\u0010;\u001a\u00020!H\u0007J\u000e\u0010<\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0006J\u000e\u0010=\u001a\u00020!2\u0006\u0010$\u001a\u00020\u0006J\u000e\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020\u0013J\u0016\u0010@\u001a\u00020!2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010A\u001a\u00020BJ \u0010C\u001a\u00020\u001a2\u0006\u0010D\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020:2\b\u0010F\u001a\u0004\u0018\u00010\u0001J\u0018\u0010G\u001a\u00020H2\u0006\u0010E\u001a\u00020:2\b\u0010F\u001a\u0004\u0018\u00010\u0001J\u000e\u0010I\u001a\u00020\u001a2\u0006\u0010J\u001a\u00020\u001cJ<\u0010K\u001a\u00020\u001a2\b\u0010F\u001a\u0004\u0018\u00010L2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010N2\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u00062\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u001cJ\u0012\u0010P\u001a\u00020\u001a2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u001cJ\u0018\u0010Q\u001a\u00020!2\b\u0010R\u001a\u0004\u0018\u00010\u001a2\u0006\u0010S\u001a\u00020HJ\b\u0010T\u001a\u00020\u0006H\u0007J\u0006\u0010U\u001a\u00020\u0006J\b\u0010V\u001a\u00020\u0006H\u0007J\b\u0010W\u001a\u00020\u0006H\u0007J\u0016\u0010X\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\u0006J\u0016\u0010[\u001a\u00020\u00062\u0006\u0010\\\u001a\u00020\t2\u0006\u0010]\u001a\u00020\tJ \u0010^\u001a\u00020!2\u0006\u0010_\u001a\u00020H2\u0006\u0010`\u001a\u00020:2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u000e\u0010^\u001a\u00020!2\u0006\u0010R\u001a\u00020\u001aJ\u0010\u0010a\u001a\u00020!2\u0006\u0010b\u001a\u00020\u0004H\u0007J\u0018\u0010c\u001a\u00020!2\u0006\u0010d\u001a\u00020\u00062\u0006\u0010b\u001a\u00020\u0004H\u0007J\u001e\u0010e\u001a\u00020B2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006J\u0016\u0010f\u001a\u00020B2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006J\u001e\u0010g\u001a\u00020B2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006J\u001e\u0010h\u001a\u00020B2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006J\u000e\u0010i\u001a\u00020!2\u0006\u0010j\u001a\u00020kJ\u001e\u0010l\u001a\u00020!2\u0006\u0010b\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u00062\u0006\u0010n\u001a\u00020\u0006J\u001a\u0010o\u001a\u00020)2\b\u00101\u001a\u0004\u0018\u00010:2\b\u0010_\u001a\u0004\u0018\u00010HJ\u0016\u0010p\u001a\u00020!2\u0006\u0010A\u001a\u00020B2\u0006\u0010q\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006r"}, hxF = {"Lcom/tencent/mm/media/util/GLEnvironmentUtil$Companion;", "", "()V", "CUBE_PROTRAIT", "", "DEFAULT_EGL_CONTEXT_CLIENT_VERSION", "", "EGL_RECORDABLE_ANDROID", "HAS_REPORTED_EGL_VERSION", "", "MMKV_GL_KEY", "ROTATION_180", "ROTATION_270", "ROTATION_90", "SUPPORT_EGL_CONTEXT_CLIENT_VERSION", "TAG", "TEXTURE_COORD", "TEXTURE_COORD_VERTICAL_FLIP", "commonEGLAttributeList", "", "commonEGLAttributeListWithMSAA", "commonEGLAttributeListWithoutRecordable", "shareEGLSurfaceTypeAttributeList", "getShareEGLSurfaceTypeAttributeList", "()[I", "bindContextAndSurface", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglContext", "Landroid/opengl/EGLContext;", "surface", "width", "height", "bindFrameBuffer", "", "fbo", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "texture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "bindRenderBuffer", "buffer", "checkEglError", "", "msg", "tag", "checkGLError", "chooseConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "eGL", "Ljavax/microedition/khronos/egl/EGL10;", "eGLDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "redSize", "greenSize", "blueSize", "alphaSize", "withSample", "chooseConfigEGL14", "Landroid/opengl/EGLConfig;", "Landroid/opengl/EGLDisplay;", "clearGL", "deleteFrameBuffer", "deleteTexture", "deleteTextures", "textures", "drawBitmapToTexture", "bitmap", "Landroid/graphics/Bitmap;", "eglBindSurface", "mEGLContext", "mEGLDisplay", "mSurface", "eglCreateSurface", "Landroid/opengl/EGLSurface;", "eglSetupByShareGLContext", "mShareGLContext", "eglSetupBySurface", "Landroid/view/Surface;", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "shareEGLContext", "eglSetupWithoutSurface", "eglUnbindSurface", "eglEnvironment", "backupSurface", "genFrameBuffer", "genRenderBuffer", "genTexture", "genTextureExternal", "loadShader", "shaderSource", "type", "loadShaderProgram", "vertexShaderSource", "fragmentShaderSource", "release", "eglSurface", "eglDisplay", "resolveMirror", "textureCoords", "resolveRotate", "rotation", "saveExternalTexture", "saveGLPixels", "saveTexture", "saveTextureExternal", "setupDeviceSupportGLVersion", "context", "Landroid/content/Context;", "swap", "prevIndex", "afterIndex", "swapBuffers", "uploadBitmapTexture", "texName", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static int aMZ() {
            AppMethodBeat.i(164119);
            int[] iArr = new int[1];
            GLES30.glGenTextures(1, iArr, 0);
            GLES30.glBindTexture(3553, iArr[0]);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, Task.EXTRAS_LIMIT_BYTES, 9728);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glBindTexture(3553, 0);
            Hr("genTexture");
            int i2 = iArr[0];
            AppMethodBeat.o(164119);
            return i2;
        }

        public static void c(Bitmap bitmap, int i2) {
            AppMethodBeat.i(164120);
            p.h(bitmap, "bitmap");
            GLES30.glBindTexture(3553, i2);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
            GLES30.glBindTexture(3553, 0);
            AppMethodBeat.o(164120);
        }

        private static int ac(String str, int i2) {
            AppMethodBeat.i(93874);
            p.h(str, "shaderSource");
            int[] iArr = new int[1];
            int glCreateShader = GLES30.glCreateShader(i2);
            GLES30.glShaderSource(glCreateShader, str);
            GLES30.glCompileShader(glCreateShader);
            GLES30.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                Log.e("MicroMsg.GLEnvironmentUtil", "loadShader error, infoLog: " + GLES30.glGetShaderInfoLog(glCreateShader));
                AppMethodBeat.o(93874);
                return 0;
            }
            AppMethodBeat.o(93874);
            return glCreateShader;
        }

        public static int aB(String str, String str2) {
            AppMethodBeat.i(93875);
            p.h(str, "vertexShaderSource");
            p.h(str2, "fragmentShaderSource");
            int[] iArr = new int[1];
            int ac = ac(str, 35633);
            if (ac == 0) {
                Log.e("MicroMsg.GLEnvironmentUtil", "load vertex shader failed");
                AppMethodBeat.o(93875);
                return 0;
            }
            int ac2 = ac(str2, 35632);
            if (ac2 == 0) {
                Log.e("MicroMsg.GLEnvironmentUtil", "load fragment shader failed");
                AppMethodBeat.o(93875);
                return 0;
            }
            int glCreateProgram = GLES30.glCreateProgram();
            GLES30.glAttachShader(glCreateProgram, ac);
            GLES30.glAttachShader(glCreateProgram, ac2);
            GLES30.glLinkProgram(glCreateProgram);
            GLES30.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] <= 0) {
                Log.e("MicroMsg.GLEnvironmentUtil", "link program failed");
                AppMethodBeat.o(93875);
                return 0;
            }
            GLES30.glDeleteShader(ac);
            GLES30.glDeleteShader(ac2);
            AppMethodBeat.o(93875);
            return glCreateProgram;
        }

        public static void aMY() {
            AppMethodBeat.i(93876);
            GLES30.glClear(16640);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glBindFramebuffer(36160, 0);
            AppMethodBeat.o(93876);
        }

        public static void a(com.tencent.mm.media.g.a aVar, d dVar, int i2, int i3) {
            AppMethodBeat.i(93877);
            if (aVar == null) {
                Log.e("MicroMsg.GLEnvironmentUtil", "fbo is null !");
                AppMethodBeat.o(93877);
            } else if (dVar == null) {
                Log.e("MicroMsg.GLEnvironmentUtil", "texture is null");
                AppMethodBeat.o(93877);
            } else {
                GLES30.glBindFramebuffer(36160, aVar.igo);
                if (i2 > 0 && i3 > 0) {
                    d.a(dVar, i2, i3, 0, null, 0, 0, 60);
                }
                GLES30.glFramebufferTexture2D(36160, 36064, 3553, dVar.igv, 0);
                GLES30.glBindTexture(3553, 0);
                AppMethodBeat.o(93877);
            }
        }

        public static b a(EGLContext eGLContext, EGLDisplay eGLDisplay, Object obj) {
            AppMethodBeat.i(218786);
            p.h(eGLContext, "mEGLContext");
            p.h(eGLDisplay, "mEGLDisplay");
            Log.i("MicroMsg.GLEnvironmentUtil", "eglBind Surface");
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            EGL14.eglChooseConfig(eGLDisplay, c.ilp, 0, eGLConfigArr, 0, 1, new int[1], 0);
            EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(eGLDisplay, eGLConfigArr[0], obj, new int[]{12344}, 0);
            Hq("eglCreateWindowSurface");
            EGL14.eglMakeCurrent(eGLDisplay, eglCreateWindowSurface, eglCreateWindowSurface, eGLContext);
            Hq("eglMakeCurrent");
            b bVar = new b(eGLDisplay, eglCreateWindowSurface, eGLContext);
            AppMethodBeat.o(218786);
            return bVar;
        }

        public static void a(b bVar, EGLSurface eGLSurface) {
            AppMethodBeat.i(218787);
            p.h(eGLSurface, "backupSurface");
            if (bVar != null) {
                Log.i("MicroMsg.GLEnvironmentUtil", "eglUnbindSurface");
                EGL14.eglDestroySurface(bVar.ilu, bVar.eglSurface);
                EGL14.eglMakeCurrent(bVar.ilu, eGLSurface, eGLSurface, bVar.ilv);
            }
            AppMethodBeat.o(218787);
        }

        public static /* synthetic */ b a(a aVar, Surface surface, int i2, int i3, EGLContext eGLContext, int i4) {
            AppMethodBeat.i(218789);
            if ((i4 & 4) != 0) {
                i2 = 0;
            }
            if ((i4 & 8) != 0) {
                i3 = 0;
            }
            if ((i4 & 16) != 0) {
                eGLContext = EGL14.EGL_NO_CONTEXT;
            }
            b a2 = a(surface, null, i2, i3, eGLContext);
            AppMethodBeat.o(218789);
            return a2;
        }

        public static b a(Surface surface, SurfaceTexture surfaceTexture, int i2, int i3, EGLContext eGLContext) {
            EGLSurface eglCreatePbufferSurface;
            AppMethodBeat.i(218788);
            Log.i("MicroMsg.GLEnvironmentUtil", "eglSetupBySurface, surface:" + surface + ", surfaceTexture:" + surfaceTexture + ", width:" + i2 + ", height:" + i3);
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
                RuntimeException runtimeException = new RuntimeException("unable to get EGL14 display");
                AppMethodBeat.o(218788);
                throw runtimeException;
            }
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                RuntimeException runtimeException2 = new RuntimeException("unable to initialize EGL14");
                AppMethodBeat.o(218788);
                throw runtimeException2;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr2 = new int[1];
            if (surface == null && surfaceTexture == null) {
                EGL14.eglChooseConfig(eglGetDisplay, c.ilp, 0, eGLConfigArr, 0, 1, iArr2, 0);
            } else {
                EGL14.eglChooseConfig(eglGetDisplay, c.ilp, 0, eGLConfigArr, 0, 1, iArr2, 0);
            }
            Hq("eglCreateContext RGB888+recordable ES2");
            EGLContext eglCreateContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfigArr[0], eGLContext, new int[]{12440, MultiProcessMMKV.getMMKV("mmkv_gl_key").decodeInt("support_egl_context_client_version", 3), 12344}, 0);
            Hq("eglCreateContext");
            int[] iArr3 = (i2 <= 0 || i3 <= 0) ? new int[]{12344} : new int[]{12375, i2, 12374, i3, 12344};
            if (surface != null) {
                eglCreatePbufferSurface = EGL14.eglCreateWindowSurface(eglGetDisplay, eGLConfigArr[0], surface, iArr3, 0);
            } else if (surfaceTexture != null) {
                eglCreatePbufferSurface = EGL14.eglCreateWindowSurface(eglGetDisplay, eGLConfigArr[0], surfaceTexture, iArr3, 0);
            } else {
                eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eglGetDisplay, eGLConfigArr[0], iArr3, 0);
            }
            if (surface != null) {
                Hq("eglCreateWindowSurface");
            } else {
                Hq("eglCreatePbufferSurface");
            }
            if (eglCreatePbufferSurface != null) {
                EGL14.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext);
                Hq("eglMakeCurrent");
            }
            p.g(eglGetDisplay, "mEGLDisplay");
            p.g(eglCreateContext, "mEGLContext");
            b bVar = new b(eglGetDisplay, eglCreatePbufferSurface, eglCreateContext);
            AppMethodBeat.o(218788);
            return bVar;
        }

        public static /* synthetic */ b aNa() {
            AppMethodBeat.i(218790);
            EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
            Log.i("MicroMsg.GLEnvironmentUtil", "eglSetupWithoutSurface");
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
                RuntimeException runtimeException = new RuntimeException("unable to get EGL14 display");
                AppMethodBeat.o(218790);
                throw runtimeException;
            }
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                RuntimeException runtimeException2 = new RuntimeException("unable to initialize EGL14");
                AppMethodBeat.o(218790);
                throw runtimeException2;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            EGL14.eglChooseConfig(eglGetDisplay, c.ilr, 0, eGLConfigArr, 0, 1, new int[1], 0);
            Hq("eglCreateContext RGB888+recordable ES2");
            EGLContext eglCreateContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfigArr[0], eGLContext, new int[]{12440, MultiProcessMMKV.getMMKV("mmkv_gl_key").decodeInt("support_egl_context_client_version", 3), 12344}, 0);
            Hq("eglCreateContext");
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eglGetDisplay, eGLSurface, eGLSurface, eglCreateContext);
            Hq("eglMakeCurrent");
            p.g(eglGetDisplay, "mEGLDisplay");
            EGLSurface eGLSurface2 = EGL14.EGL_NO_SURFACE;
            p.g(eglCreateContext, "mEGLContext");
            b bVar = new b(eglGetDisplay, eGLSurface2, eglCreateContext);
            AppMethodBeat.o(218790);
            return bVar;
        }

        public static boolean a(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            AppMethodBeat.i(93880);
            if (eGLDisplay == null || eGLSurface == null) {
                AppMethodBeat.o(93880);
                return false;
            }
            boolean eglSwapBuffers = EGL14.eglSwapBuffers(eGLDisplay, eGLSurface);
            Hq("eglSwapBuffers");
            AppMethodBeat.o(93880);
            return eglSwapBuffers;
        }

        public static Bitmap L(int i2, int i3, int i4) {
            AppMethodBeat.i(218791);
            int[] iArr = new int[1];
            GLES30.glGenFramebuffers(1, iArr, 0);
            GLES30.glBindFramebuffer(36160, iArr[0]);
            GLES30.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
            ByteBuffer allocate = ByteBuffer.allocate(i3 * i4 * 4);
            GLES30.glReadPixels(0, 0, i3, i4, (int) NativeBitmapStruct.GLFormat.GL_RGBA, (int) NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocate);
            Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(allocate);
            GLES30.glBindFramebuffer(36160, 0);
            GLES30.glDeleteFramebuffers(1, iArr, 0);
            p.g(createBitmap, "bitmap");
            AppMethodBeat.o(218791);
            return createBitmap;
        }

        public static /* synthetic */ boolean Hq(String str) {
            AppMethodBeat.i(93883);
            boolean aC = aC(str, "MicroMsg.GLEnvironmentUtil");
            AppMethodBeat.o(93883);
            return aC;
        }

        private static boolean aC(String str, String str2) {
            AppMethodBeat.i(93882);
            p.h(str, "msg");
            p.h(str2, "tag");
            int eglGetError = EGL14.eglGetError();
            if (eglGetError != 12288) {
                Log.printInfoStack(str2, str + ": EGL error: 0x" + Integer.toHexString(eglGetError), new Object[0]);
                AppMethodBeat.o(93882);
                return true;
            }
            AppMethodBeat.o(93882);
            return false;
        }

        public static void Hr(String str) {
            AppMethodBeat.i(93884);
            int glGetError = GLES30.glGetError();
            if (glGetError != 0) {
                Log.printInfoStack("MicroMsg.GLEnvironmentUtil", str + ": GL error: 0x" + Integer.toHexString(glGetError), new Object[0]);
            }
            AppMethodBeat.o(93884);
        }

        public static EGLSurface a(EGLDisplay eGLDisplay, Object obj) {
            AppMethodBeat.i(218792);
            p.h(eGLDisplay, "mEGLDisplay");
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            EGL14.eglChooseConfig(eGLDisplay, c.ilp, 0, eGLConfigArr, 0, 1, new int[1], 0);
            EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(eGLDisplay, eGLConfigArr[0], obj, new int[]{12344}, 0);
            p.g(eglCreateWindowSurface, "EGL14.eglCreateWindowSur…rayOf(EGL14.EGL_NONE), 0)");
            AppMethodBeat.o(218792);
            return eglCreateWindowSurface;
        }

        public static b a(EGLContext eGLContext, Object obj, int i2, int i3) {
            EGLSurface eglCreatePbufferSurface;
            AppMethodBeat.i(93885);
            p.h(eGLContext, "eglContext");
            Log.i("MicroMsg.GLEnvironmentUtil", "bindContextAndSurface");
            if (obj == null || (obj instanceof Surface) || (obj instanceof SurfaceHolder)) {
                EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
                    RuntimeException runtimeException = new RuntimeException("unable to get EGL14 display");
                    AppMethodBeat.o(93885);
                    throw runtimeException;
                }
                int[] iArr = new int[2];
                if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    RuntimeException runtimeException2 = new RuntimeException("eglInitialize failed");
                    AppMethodBeat.o(93885);
                    throw runtimeException2;
                }
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                EGL14.eglChooseConfig(eglGetDisplay, c.ilp, 0, eGLConfigArr, 0, 1, new int[1], 0);
                if (eGLConfigArr[0] == null) {
                    RuntimeException runtimeException3 = new RuntimeException("chooseConfig failed");
                    AppMethodBeat.o(93885);
                    throw runtimeException3;
                }
                EGLContext eglCreateContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfigArr[0], eGLContext, new int[]{12440, MultiProcessMMKV.getMMKV("mmkv_gl_key").decodeInt("support_egl_context_client_version", 3), 12344}, 0);
                if (p.j(eglCreateContext, EGL14.EGL_NO_CONTEXT)) {
                    RuntimeException runtimeException4 = new RuntimeException("EGL error " + EGL14.eglGetError());
                    AppMethodBeat.o(93885);
                    throw runtimeException4;
                }
                Hq("eglCreateContext");
                int[] iArr2 = (i2 <= 0 || i3 <= 0) ? new int[]{12344} : new int[]{12375, i2, 12374, i3, 12344};
                if (obj != null) {
                    try {
                        eglCreatePbufferSurface = EGL14.eglCreateWindowSurface(eglGetDisplay, eGLConfigArr[0], obj, iArr2, 0);
                    } catch (IllegalArgumentException e2) {
                        Log.e("MicroMsg.GLEnvironmentUtil", "eglCreateWindowSurface", e2);
                        eglCreatePbufferSurface = null;
                    }
                } else {
                    eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eglGetDisplay, eGLConfigArr[0], iArr2, 0);
                }
                if (obj != null) {
                    Hq("eglCreateWindowSurface");
                } else {
                    Hq("eglCreatePbufferSurface");
                }
                if ((eglCreatePbufferSurface == null || eglCreatePbufferSurface == EGL14.EGL_NO_SURFACE) && EGL14.eglGetError() == 12299) {
                    Log.e("MicroMsg.GLEnvironmentUtil", "makeMyEGLCurrentSurface:returned EGL_BAD_NATIVE_WINDOW.");
                }
                if (eglCreatePbufferSurface != null) {
                    EGL14.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext);
                    Hq("eglMakeCurrent");
                }
                p.g(eglGetDisplay, "eglDisplay");
                if (eglCreatePbufferSurface == null) {
                    p.hyc();
                }
                p.g(eglCreateContext, "outputEGLContext");
                b bVar = new b(eglGetDisplay, eglCreatePbufferSurface, eglCreateContext);
                AppMethodBeat.o(93885);
                return bVar;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unsupported surface");
            AppMethodBeat.o(93885);
            throw illegalArgumentException;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public static void e(int i2, float[] fArr) {
            AppMethodBeat.i(218793);
            p.h(fArr, "textureCoords");
            switch (i2) {
                case 90:
                    float f2 = fArr[0];
                    float f3 = fArr[1];
                    fArr[0] = fArr[4];
                    fArr[1] = fArr[5];
                    fArr[4] = fArr[6];
                    fArr[5] = fArr[7];
                    fArr[6] = fArr[2];
                    fArr[7] = fArr[3];
                    fArr[2] = f2;
                    fArr[3] = f3;
                    AppMethodBeat.o(218793);
                    return;
                case TXLiveConstants.RENDER_ROTATION_180 /*{ENCODED_INT: 180}*/:
                    swap(fArr, 0, 6);
                    swap(fArr, 1, 7);
                    swap(fArr, 2, 4);
                    swap(fArr, 3, 5);
                    AppMethodBeat.o(218793);
                    return;
                case 270:
                    float f4 = fArr[0];
                    float f5 = fArr[1];
                    fArr[0] = fArr[2];
                    fArr[1] = fArr[3];
                    fArr[2] = fArr[6];
                    fArr[3] = fArr[7];
                    fArr[6] = fArr[4];
                    fArr[7] = fArr[5];
                    fArr[4] = f4;
                    fArr[5] = f5;
                    break;
            }
            AppMethodBeat.o(218793);
        }

        private static void swap(float[] fArr, int i2, int i3) {
            AppMethodBeat.i(218794);
            p.h(fArr, "textureCoords");
            float f2 = fArr[i2];
            fArr[i2] = fArr[i3];
            fArr[i3] = f2;
            AppMethodBeat.o(218794);
        }

        public static void a(b bVar) {
            AppMethodBeat.i(93881);
            p.h(bVar, "eglEnvironment");
            if (bVar.eglSurface != EGL14.EGL_NO_DISPLAY) {
                EGLDisplay eGLDisplay = bVar.ilu;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroySurface(bVar.ilu, bVar.eglSurface);
                EGL14.eglDestroyContext(bVar.ilu, bVar.ilv);
                EGL14.eglReleaseThread();
                EGL14.eglTerminate(bVar.ilu);
            }
            EGLDisplay eGLDisplay2 = EGL14.EGL_NO_DISPLAY;
            p.g(eGLDisplay2, "EGL14.EGL_NO_DISPLAY");
            bVar.a(eGLDisplay2);
            EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
            p.g(eGLContext, "EGL14.EGL_NO_CONTEXT");
            bVar.a(eGLContext);
            bVar.eglSurface = EGL14.EGL_NO_SURFACE;
            AppMethodBeat.o(93881);
        }
    }

    static {
        AppMethodBeat.i(93890);
        AppMethodBeat.o(93890);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "", "disPlay", "Landroid/opengl/EGLDisplay;", "eglSurface", "Landroid/opengl/EGLSurface;", "eglContext", "Landroid/opengl/EGLContext;", "(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)V", "getDisPlay", "()Landroid/opengl/EGLDisplay;", "setDisPlay", "(Landroid/opengl/EGLDisplay;)V", "getEglContext", "()Landroid/opengl/EGLContext;", "setEglContext", "(Landroid/opengl/EGLContext;)V", "getEglSurface", "()Landroid/opengl/EGLSurface;", "setEglSurface", "(Landroid/opengl/EGLSurface;)V", "plugin-mediaeditor_release"})
    public static final class b {
        public EGLSurface eglSurface;
        public EGLDisplay ilu;
        public EGLContext ilv;

        public b(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLContext eGLContext) {
            p.h(eGLDisplay, "disPlay");
            p.h(eGLContext, "eglContext");
            AppMethodBeat.i(93889);
            this.ilu = eGLDisplay;
            this.eglSurface = eGLSurface;
            this.ilv = eGLContext;
            AppMethodBeat.o(93889);
        }

        public final void a(EGLContext eGLContext) {
            AppMethodBeat.i(93888);
            p.h(eGLContext, "<set-?>");
            this.ilv = eGLContext;
            AppMethodBeat.o(93888);
        }

        public final void a(EGLDisplay eGLDisplay) {
            AppMethodBeat.i(93886);
            p.h(eGLDisplay, "<set-?>");
            this.ilu = eGLDisplay;
            AppMethodBeat.o(93886);
        }
    }
}

package com.tencent.mm.plugin.emojicapture.ui.b;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureGLUtil;", "", "()V", "Companion", "plugin-emojicapture_release"})
public final class b {
    public static final float[] ilm = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] iln = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] ilo = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final a rvS = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJ(\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0007J\u001e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJB\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ:\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0017\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\"\u001a\u00020\nJ\u0006\u0010#\u001a\u00020\fJ\u0006\u0010$\u001a\u00020\fJ\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020&J\u0016\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\fJ\u0016\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureGLUtil$Companion;", "", "()V", "CUBE_PROTRAIT", "", "TAG", "", "TEXTURE_COORD", "TEXTURE_COORD_VERTICAL_FLIP", "allocTexutreMem", "", "texture", "", "width", "height", "bindFrameBuffer", "fbo", "bindRenderBuffer", "buffer", "chooseConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "eGL", "Ljavax/microedition/khronos/egl/EGL10;", "eGLDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "redSize", "greenSize", "blueSize", "alphaSize", "withSample", "", "chooseConfigEGL14", "Landroid/opengl/EGLConfig;", "Landroid/opengl/EGLDisplay;", "clearGL", "genFrameBuffer", "genRenderBuffer", "genTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "genTextureExternal", "loadShader", "shaderSource", "type", "loadShaderProgram", "vertexShaderSource", "fragmentShaderSource", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        private static int ac(String str, int i2) {
            AppMethodBeat.i(831);
            p.h(str, "shaderSource");
            int[] iArr = new int[1];
            int glCreateShader = GLES20.glCreateShader(i2);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                Log.e("MicroMsg.EmojiCaptureGLUtil", "loadShader error, infoLog: %s", GLES20.glGetShaderInfoLog(glCreateShader));
                AppMethodBeat.o(831);
                return 0;
            }
            AppMethodBeat.o(831);
            return glCreateShader;
        }

        public static int aB(String str, String str2) {
            AppMethodBeat.i(832);
            p.h(str, "vertexShaderSource");
            p.h(str2, "fragmentShaderSource");
            int[] iArr = new int[1];
            int ac = ac(str, 35633);
            if (ac == 0) {
                Log.e("MicroMsg.EmojiCaptureGLUtil", "load vertex shader failed");
                AppMethodBeat.o(832);
                return 0;
            }
            int ac2 = ac(str2, 35632);
            if (ac2 == 0) {
                Log.e("MicroMsg.EmojiCaptureGLUtil", "load fragment shader failed");
                AppMethodBeat.o(832);
                return 0;
            }
            int glCreateProgram = GLES20.glCreateProgram();
            GLES20.glAttachShader(glCreateProgram, ac);
            GLES20.glAttachShader(glCreateProgram, ac2);
            GLES20.glLinkProgram(glCreateProgram);
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] <= 0) {
                Log.e("MicroMsg.EmojiCaptureGLUtil", "link program failed");
                AppMethodBeat.o(832);
                return 0;
            }
            GLES20.glDeleteShader(ac);
            GLES20.glDeleteShader(ac2);
            AppMethodBeat.o(832);
            return glCreateProgram;
        }

        public static int cJU() {
            AppMethodBeat.i(833);
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            if (iArr[0] == 0) {
                Log.e("MicroMsg.EmojiCaptureGLUtil", "gen frame buffer error");
                AppMethodBeat.o(833);
                return 0;
            }
            int i2 = iArr[0];
            AppMethodBeat.o(833);
            return i2;
        }

        public static void aMY() {
            AppMethodBeat.i(834);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16640);
            GLES20.glBindFramebuffer(36160, 0);
            AppMethodBeat.o(834);
        }

        public static void ab(int i2, int i3, int i4) {
            AppMethodBeat.i(835);
            GLES20.glBindTexture(3553, i2);
            GLES20.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, i3, i4, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            GLES20.glBindTexture(3553, 0);
            AppMethodBeat.o(835);
        }
    }

    static {
        AppMethodBeat.i(836);
        AppMethodBeat.o(836);
    }
}

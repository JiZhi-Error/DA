package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLES20;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    public static int aMZ() {
        AppMethodBeat.i(89207);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, Task.EXTRAS_LIMIT_BYTES, 9728);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        int i2 = iArr[0];
        AppMethodBeat.o(89207);
        return i2;
    }

    private static int ac(String str, int i2) {
        AppMethodBeat.i(89208);
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i2);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("loadShader error, infoLog: %s", GLES20.glGetShaderInfoLog(glCreateShader));
            AppMethodBeat.o(89208);
            return 0;
        }
        AppMethodBeat.o(89208);
        return glCreateShader;
    }

    public static int aB(String str, String str2) {
        AppMethodBeat.i(89209);
        int[] iArr = new int[1];
        int ac = ac(str, 35633);
        if (ac == 0) {
            Log.e("MicroMsg.MMSightCameraGLUtil", "load vertex shader failed");
            AppMethodBeat.o(89209);
            return 0;
        }
        int ac2 = ac(str2, 35632);
        if (ac2 == 0) {
            Log.e("MicroMsg.MMSightCameraGLUtil", "load fragment shader failed");
            AppMethodBeat.o(89209);
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, ac);
        GLES20.glAttachShader(glCreateProgram, ac2);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] <= 0) {
            Log.e("MicroMsg.MMSightCameraGLUtil", "link program failed");
            AppMethodBeat.o(89209);
            return 0;
        }
        GLES20.glDeleteShader(ac);
        GLES20.glDeleteShader(ac2);
        AppMethodBeat.o(89209);
        return glCreateProgram;
    }
}

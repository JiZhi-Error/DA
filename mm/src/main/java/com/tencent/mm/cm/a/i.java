package com.tencent.mm.cm.a;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i {
    int[] RfU;

    public static int aO(Bitmap bitmap) {
        AppMethodBeat.i(190268);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        int i2 = iArr[0];
        AppMethodBeat.o(190268);
        return i2;
    }

    public static int ac(String str, int i2) {
        AppMethodBeat.i(190269);
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i2);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            new StringBuilder("Compilation\n").append(GLES20.glGetShaderInfoLog(glCreateShader));
            AppMethodBeat.o(190269);
            return 0;
        }
        AppMethodBeat.o(190269);
        return glCreateShader;
    }
}

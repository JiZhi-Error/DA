package com.tencent.mm.plugin.voip.video.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.a;
import com.tencent.mm.media.g.c;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class f {
    private static volatile int HlZ = 0;

    public static int createProgram(String str, String str2) {
        int i2 = 0;
        AppMethodBeat.i(115740);
        int loadShader = loadShader(35633, str);
        if (loadShader == 0) {
            AppMethodBeat.o(115740);
        } else {
            int loadShader2 = loadShader(35632, str2);
            if (loadShader2 == 0) {
                AppMethodBeat.o(115740);
            } else {
                int glCreateProgram = GLES20.glCreateProgram();
                if (glCreateProgram == 0) {
                    Log.e("MicroMsg.VoipRenderUtils", "Could not create program");
                }
                GLES20.glAttachShader(glCreateProgram, loadShader);
                GLES20.glAttachShader(glCreateProgram, loadShader2);
                GLES20.glLinkProgram(glCreateProgram);
                int[] iArr = new int[1];
                GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
                if (iArr[0] != 1) {
                    Log.e("MicroMsg.VoipRenderUtils", "Could not link program: ");
                    Log.e("MicroMsg.VoipRenderUtils", GLES20.glGetProgramInfoLog(glCreateProgram));
                    GLES20.glDeleteProgram(glCreateProgram);
                } else {
                    i2 = glCreateProgram;
                }
                AppMethodBeat.o(115740);
            }
        }
        return i2;
    }

    private static int loadShader(int i2, String str) {
        int i3 = 0;
        AppMethodBeat.i(115741);
        int glCreateShader = GLES20.glCreateShader(i2);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("MicroMsg.VoipRenderUtils", "Could not compile shader %s and shader info is %s", Integer.valueOf(i2), GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
        } else {
            i3 = glCreateShader;
        }
        AppMethodBeat.o(115741);
        return i3;
    }

    public static d fLz() {
        AppMethodBeat.i(115742);
        d a2 = c.a(true, 14);
        AppMethodBeat.o(115742);
        return a2;
    }

    static a fLA() {
        AppMethodBeat.i(115743);
        c cVar = c.igu;
        a zI = c.zI(14);
        AppMethodBeat.o(115743);
        return zI;
    }
}

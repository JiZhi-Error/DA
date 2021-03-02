package com.tencent.tav.decoder;

import android.opengl.EGL14;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.TraeAudioManager;
import com.tencent.tav.decoder.logger.Logger;

public class Program {
    private static final String TAG = "Program";

    public static synchronized int createProgram(String str, String str2) {
        int createProgram;
        synchronized (Program.class) {
            AppMethodBeat.i(218256);
            createProgram = createProgram(str, str2, null);
            AppMethodBeat.o(218256);
        }
        return createProgram;
    }

    public static synchronized int createProgram(String str, String str2, int[] iArr) {
        int i2 = 0;
        synchronized (Program.class) {
            AppMethodBeat.i(218257);
            GLES20.glEnable(3042);
            GLES20.glBlendEquationSeparate(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_GETDEVICELIST, TraeAudioManager.TraeAudioManagerLooper.MESSAGE_GETDEVICELIST);
            GLES20.glBlendFuncSeparate(770, 771, 1, 771);
            int loadShader = loadShader(35633, str);
            if (loadShader == 0) {
                AppMethodBeat.o(218257);
            } else {
                int loadShader2 = loadShader(35632, str2);
                if (loadShader2 == 0) {
                    AppMethodBeat.o(218257);
                } else {
                    if (iArr != null && iArr.length >= 2) {
                        iArr[0] = loadShader;
                        iArr[1] = loadShader2;
                    }
                    int glCreateProgram = GLES20.glCreateProgram();
                    checkEglError("glCreateProgram");
                    if (glCreateProgram == 0) {
                        Logger.e(TAG, "Could not create program");
                    }
                    GLES20.glAttachShader(glCreateProgram, loadShader);
                    checkEglError("glAttachShader");
                    GLES20.glAttachShader(glCreateProgram, loadShader2);
                    checkEglError("glAttachShader");
                    GLES20.glLinkProgram(glCreateProgram);
                    int[] iArr2 = new int[1];
                    GLES20.glGetProgramiv(glCreateProgram, 35714, iArr2, 0);
                    if (iArr2[0] != 1) {
                        Logger.e(TAG, "Could not link program: ");
                        Logger.e(TAG, GLES20.glGetProgramInfoLog(glCreateProgram));
                        GLES20.glDeleteProgram(glCreateProgram);
                    } else {
                        i2 = glCreateProgram;
                    }
                    AppMethodBeat.o(218257);
                }
            }
        }
        return i2;
    }

    private static synchronized int loadShader(int i2, String str) {
        int i3 = 0;
        synchronized (Program.class) {
            AppMethodBeat.i(218258);
            int glCreateShader = GLES20.glCreateShader(i2);
            checkEglError("glCreateShader type=".concat(String.valueOf(i2)));
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                Logger.e(TAG, "Could not compile shader " + i2 + ":");
                Logger.e(TAG, " " + GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
            } else {
                i3 = glCreateShader;
            }
            AppMethodBeat.o(218258);
        }
        return i3;
    }

    public static void checkEglError(String str) {
        AppMethodBeat.i(218259);
        boolean z = false;
        StringBuilder sb = new StringBuilder("");
        while (true) {
            int eglGetError = EGL14.eglGetError();
            if (eglGetError == 12288) {
                break;
            }
            Logger.e(TAG, str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            sb.append(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            z = true;
        }
        if (z) {
            new RuntimeException("EGL error encountered (see log): " + sb.toString());
        }
        AppMethodBeat.o(218259);
    }
}

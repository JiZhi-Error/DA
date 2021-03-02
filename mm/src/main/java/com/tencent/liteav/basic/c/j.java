package com.tencent.liteav.basic.c;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.google.android.gms.gcm.Task;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public static FloatBuffer f325a = a(f330f);

    /* renamed from: b  reason: collision with root package name */
    public static FloatBuffer f326b = a(f331g);

    /* renamed from: c  reason: collision with root package name */
    public static FloatBuffer f327c = a(f332h);

    /* renamed from: d  reason: collision with root package name */
    public static FloatBuffer f328d = a(f333i);

    /* renamed from: e  reason: collision with root package name */
    public static FloatBuffer f329e = a(f334j);

    /* renamed from: f  reason: collision with root package name */
    private static float[] f330f = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: g  reason: collision with root package name */
    private static float[] f331g = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: h  reason: collision with root package name */
    private static float[] f332h = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: i  reason: collision with root package name */
    private static float[] f333i = {1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: j  reason: collision with root package name */
    private static float[] f334j = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    private static int k = 2;

    public interface a {
    }

    static {
        AppMethodBeat.i(222203);
        AppMethodBeat.o(222203);
    }

    public static void a(int i2) {
        k = i2;
    }

    public static final int a() {
        return k;
    }

    public static int a(int i2, int i3, int i4, int i5, int[] iArr) {
        AppMethodBeat.i(222193);
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, Task.EXTRAS_LIMIT_BYTES, 9729);
        GLES20.glTexImage2D(3553, 0, i4, i2, i3, 0, i5, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        int i6 = iArr[0];
        AppMethodBeat.o(222193);
        return i6;
    }

    public static FloatBuffer a(float[] fArr) {
        AppMethodBeat.i(222194);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        AppMethodBeat.o(222194);
        return asFloatBuffer;
    }

    public static int a(int i2, int i3, int i4, int i5, IntBuffer intBuffer) {
        AppMethodBeat.i(222195);
        int c2 = c();
        GLES20.glBindTexture(3553, c2);
        GLES20.glTexImage2D(3553, 0, i4, i2, i3, 0, i5, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, intBuffer);
        GLES20.glBindTexture(3553, 0);
        AppMethodBeat.o(222195);
        return c2;
    }

    public static int a(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(222196);
        int a2 = a(i2, i3, i4, i5, (IntBuffer) null);
        AppMethodBeat.o(222196);
        return a2;
    }

    public static int a(Bitmap bitmap, int i2, boolean z) {
        AppMethodBeat.i(222197);
        int[] iArr = new int[1];
        if (i2 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        } else {
            GLES20.glBindTexture(3553, i2);
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            iArr[0] = i2;
        }
        if (z) {
            bitmap.recycle();
        }
        int i3 = iArr[0];
        AppMethodBeat.o(222197);
        return i3;
    }

    public static int a(int i2, int i3, int[] iArr) {
        AppMethodBeat.i(222198);
        GLES30.glGenBuffers(1, iArr, 0);
        GLES30.glBindBuffer(35051, iArr[0]);
        GLES30.glBufferData(35051, i2 * i3 * 4, null, 35049);
        GLES30.glBindBuffer(35051, 0);
        int i4 = iArr[0];
        AppMethodBeat.o(222198);
        return i4;
    }

    public static int b() {
        AppMethodBeat.i(222199);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        int i2 = iArr[0];
        AppMethodBeat.o(222199);
        return i2;
    }

    public static int c() {
        AppMethodBeat.i(222200);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glBindTexture(3553, 0);
        int i2 = iArr[0];
        AppMethodBeat.o(222200);
        return i2;
    }

    public static int a(String str, int i2) {
        AppMethodBeat.i(222201);
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i2);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            TXCLog.w("Load Shader Failed", "Compilation\n" + GLES20.glGetShaderInfoLog(glCreateShader));
            AppMethodBeat.o(222201);
            return 0;
        }
        AppMethodBeat.o(222201);
        return glCreateShader;
    }

    public static int a(String str, String str2) {
        AppMethodBeat.i(222202);
        int[] iArr = new int[1];
        int a2 = a(str, 35633);
        if (a2 == 0) {
            TXCLog.w("Load Program", "Vertex Shader Failed");
            AppMethodBeat.o(222202);
            return 0;
        }
        int a3 = a(str2, 35632);
        if (a3 == 0) {
            TXCLog.w("Load Program", "Fragment Shader Failed");
            AppMethodBeat.o(222202);
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, a2);
        GLES20.glAttachShader(glCreateProgram, a3);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] <= 0) {
            TXCLog.w("Load Program", "Linking Failed");
            AppMethodBeat.o(222202);
            return 0;
        }
        GLES20.glDeleteShader(a2);
        GLES20.glDeleteShader(a3);
        AppMethodBeat.o(222202);
        return glCreateProgram;
    }
}

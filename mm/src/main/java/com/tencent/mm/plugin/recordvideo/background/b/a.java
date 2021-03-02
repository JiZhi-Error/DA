package com.tencent.mm.plugin.recordvideo.background.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a {
    protected int BLb;

    public final void eJh() {
        GLES20.glUseProgram(this.BLb);
    }

    public static int h(Bitmap bitmap, int i2) {
        return i2 > 0 ? i2 : i(bitmap, i2);
    }

    public static int i(Bitmap bitmap, int i2) {
        Log.i("MicroMsg.Story.AbsShader", "loadTexture");
        if (bitmap != null) {
            if (i2 > 0) {
                Vy(i2);
            }
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            int i3 = iArr[0];
            GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameteri(3553, 10242, 10497);
            GLES20.glTexParameteri(3553, 10243, 10497);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
            return i3;
        }
        Log.i("MicroMsg.Story.AbsShader", "loadTexture bitmap null");
        return i2;
    }

    private static void Vy(int i2) {
        GLES20.glDeleteTextures(1, new int[]{i2}, 0);
    }

    protected static int loadShader(int i2, String str) {
        Log.i("MicroMsg.Story.AbsShader", "loadShader");
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i2);
        if (glCreateShader == 0) {
            return 0;
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Log.e("MicroMsg.Story.AbsShader", GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    /* renamed from: com.tencent.mm.plugin.recordvideo.background.b.a$a  reason: collision with other inner class name */
    public enum EnumC1641a {
        Default,
        CenterCrop,
        CenterInside;

        public static EnumC1641a valueOf(String str) {
            AppMethodBeat.i(74993);
            EnumC1641a aVar = (EnumC1641a) Enum.valueOf(EnumC1641a.class, str);
            AppMethodBeat.o(74993);
            return aVar;
        }

        static {
            AppMethodBeat.i(74994);
            AppMethodBeat.o(74994);
        }
    }
}

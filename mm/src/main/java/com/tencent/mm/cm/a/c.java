package com.tencent.mm.cm.a;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    int Gxi = -1;
    int Rfu = -1;

    public final void lU(int i2, int i3) {
        AppMethodBeat.i(190234);
        int[] iArr = {1};
        GLES20.glGenFramebuffers(1, iArr, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenTextures(1, iArr2, 0);
        GLES20.glBindTexture(3553, iArr2[0]);
        GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        this.Gxi = iArr2[0];
        GLES20.glBindTexture(3553, this.Gxi);
        GLES20.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, i2, i3, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.Gxi, 0);
        GLES20.glCheckFramebufferStatus(36160);
        GLES20.glBindTexture(3553, 0);
        this.Rfu = iArr[0];
        AppMethodBeat.o(190234);
    }
}

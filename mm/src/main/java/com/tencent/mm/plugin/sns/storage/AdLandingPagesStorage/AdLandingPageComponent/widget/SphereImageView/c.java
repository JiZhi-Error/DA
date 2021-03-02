package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class c {
    public static int aA(Bitmap bitmap) {
        AppMethodBeat.i(97278);
        if (bitmap == null) {
            Log.i("SphereImageView.Utils", "initTexture, bmp==null");
            AppMethodBeat.o(97278);
            return 0;
        }
        Log.i("SphereImageView.Utils", "initTexture, bmp.w=" + bitmap.getWidth() + ", bmp.h=" + bitmap.getHeight());
        try {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i2 = iArr[0];
            GLES20.glBindTexture(3553, i2);
            GLES20.glTexParameterf(3553, 10241, 9728.0f);
            GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9728.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
            AppMethodBeat.o(97278);
            return i2;
        } catch (Throwable th) {
            Log.e("SphereImageView.Utils", "initTexture exp:" + th.toString());
            AppMethodBeat.o(97278);
            return 0;
        }
    }
}

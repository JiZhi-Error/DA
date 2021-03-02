package com.tencent.tav.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.tav.decoder.logger.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Scanner;

public class TAVGLUtils {
    private static final String TAG = "TAVGLUtils";

    public static String loadShaderCode(Context context, String str) {
        AppMethodBeat.i(218700);
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            String convertStreamToString = convertStreamToString(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.o(218700);
            return convertStreamToString;
        } catch (Exception e3) {
            Logger.e(TAG, "loadShaderCode", e3);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
            AppMethodBeat.o(218700);
            return "";
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.o(218700);
            throw th;
        }
    }

    public static String convertStreamToString(InputStream inputStream) {
        AppMethodBeat.i(218701);
        Scanner useDelimiter = new Scanner(inputStream, MimeTypeUtil.ContentType.DEFAULT_CHARSET).useDelimiter("\\A");
        if (useDelimiter.hasNext()) {
            String next = useDelimiter.next();
            AppMethodBeat.o(218701);
            return next;
        }
        AppMethodBeat.o(218701);
        return "";
    }

    public static float lerp(float f2, float f3, float f4) {
        return ((1.0f - f4) * f2) + (f3 * f4);
    }

    public static Bitmap saveBitmap(int i2, int i3, int i4) {
        AppMethodBeat.i(218702);
        int[] iArr = new int[1];
        GLES20.glBindTexture(3553, i2);
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i3 * i4 * 4);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        allocateDirect.rewind();
        GLES20.glReadPixels(0, 0, i3, i4, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocateDirect);
        Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_4444);
        allocateDirect.rewind();
        createBitmap.copyPixelsFromBuffer(allocateDirect);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        GLES20.glBindTexture(3553, 0);
        AppMethodBeat.o(218702);
        return createBitmap;
    }
}

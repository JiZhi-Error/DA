package com.tencent.thumbplayer.b;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class a {
    public static Bitmap k(byte[] bArr, int i2, int i3, int i4) {
        AppMethodBeat.i(189086);
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
        createBitmap.copyPixelsFromBuffer(wrap);
        if (i4 != 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate((float) i4);
            createBitmap = Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix, true);
        }
        AppMethodBeat.o(189086);
        return createBitmap;
    }
}

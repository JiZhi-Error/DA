package org.libpag;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class ImageCodec {
    private static int[] GetSizeFromPath(String str) {
        int i2;
        int i3;
        AppMethodBeat.i(236852);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
            i2 = options.outWidth;
            try {
                i3 = options.outHeight;
            } catch (Exception e2) {
                i3 = 0;
                int[] iArr = {i2, i3};
                AppMethodBeat.o(236852);
                return iArr;
            }
        } catch (Exception e3) {
            i2 = 0;
            i3 = 0;
            int[] iArr2 = {i2, i3};
            AppMethodBeat.o(236852);
            return iArr2;
        }
        int[] iArr22 = {i2, i3};
        AppMethodBeat.o(236852);
        return iArr22;
    }

    private static int[] GetSizeFromBytes(byte[] bArr) {
        int i2;
        int i3;
        AppMethodBeat.i(236853);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            i2 = options.outWidth;
            try {
                i3 = options.outHeight;
            } catch (Exception e2) {
                i3 = 0;
                int[] iArr = {i2, i3};
                AppMethodBeat.o(236853);
                return iArr;
            }
        } catch (Exception e3) {
            i2 = 0;
            i3 = 0;
            int[] iArr2 = {i2, i3};
            AppMethodBeat.o(236853);
            return iArr2;
        }
        int[] iArr22 = {i2, i3};
        AppMethodBeat.o(236853);
        return iArr22;
    }

    private static boolean ReadPixelsFromPath(String str, ByteBuffer byteBuffer) {
        AppMethodBeat.i(236854);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        if (decodeFile == null || decodeFile.getConfig() != Bitmap.Config.ARGB_8888) {
            AppMethodBeat.o(236854);
            return false;
        }
        decodeFile.copyPixelsToBuffer(byteBuffer);
        AppMethodBeat.o(236854);
        return true;
    }

    private static boolean ReadPixelsFromBytes(byte[] bArr, ByteBuffer byteBuffer) {
        AppMethodBeat.i(236855);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (decodeByteArray == null || decodeByteArray.getConfig() != Bitmap.Config.ARGB_8888) {
            AppMethodBeat.o(236855);
            return false;
        }
        decodeByteArray.copyPixelsToBuffer(byteBuffer);
        AppMethodBeat.o(236855);
        return true;
    }
}

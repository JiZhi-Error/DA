package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public class ImageOptimLib {
    public static final int MAX_DECODE_PICTURE_SIZE = 2764800;

    public static boolean convertToProgressive(String str, String str2, int i2) {
        AppMethodBeat.i(215362);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || !s.YS(str)) {
            AppMethodBeat.o(215362);
            return false;
        } else if (MMJpegOptim.convertToProgressive(q.k(str, false), q.k(str2, false), i2) == 0) {
            AppMethodBeat.o(215362);
            return true;
        } else {
            AppMethodBeat.o(215362);
            return false;
        }
    }

    public static int compressByQualityOptim(Bitmap bitmap, int i2, boolean z, String str) {
        AppMethodBeat.i(215363);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(215363);
            return -1;
        }
        int compressByQualityOptim = MMJpegOptim.compressByQualityOptim(bitmap, i2, z, q.k(str, false));
        AppMethodBeat.o(215363);
        return compressByQualityOptim;
    }

    public static boolean checkIntegrity(String str) {
        AppMethodBeat.i(215364);
        if (Util.isNullOrNil(str) || !s.YS(str)) {
            AppMethodBeat.o(215364);
            return false;
        }
        boolean checkIntegrity = MMJpegOptim.checkIntegrity(q.k(str, false));
        AppMethodBeat.o(215364);
        return checkIntegrity;
    }

    public static Bitmap extractThumbNailBeta(String str) {
        AppMethodBeat.i(215365);
        if (Util.isNullOrNil(str) || !new o(str).exists()) {
            AppMethodBeat.o(215365);
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options);
        if (decodeFile != null) {
            Log.i("ImageOptimLib", "recycle bitmap:%s", decodeFile.toString());
            decodeFile.recycle();
        }
        if (options.inSampleSize <= 1) {
            options.inSampleSize = 1;
        }
        if (((options.outHeight * options.outWidth) / options.inSampleSize) / options.inSampleSize > 2764800) {
            options.inSampleSize++;
        }
        short[] sArr = {1, 1, 2, 2, 4, 4, 4, 4, 8, 8, 8, 8, 8, 8, 8, 8};
        if (options.inSampleSize < 0 || options.inSampleSize > 15) {
            options.inSampleSize = 1;
        } else {
            options.inSampleSize = sArr[options.inSampleSize];
        }
        Bitmap createBitmap = Bitmap.createBitmap(((options.outWidth + options.inSampleSize) - 1) / options.inSampleSize, ((options.outHeight + options.inSampleSize) - 1) / options.inSampleSize, Bitmap.Config.ARGB_8888);
        if (MMJpegOptim.decodeToBitmap(str, createBitmap, options.inSampleSize) == 1) {
            AppMethodBeat.o(215365);
            return createBitmap;
        }
        AppMethodBeat.o(215365);
        return null;
    }
}

package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class LongBitmapHandler {
    private static final long IDKEY_LONG_BITMAP = 853;
    public static final double SCALE_THRESHOLD = 2.0d;
    private static final String TAG = "MicroMsg.LongBitmapHandler";
    private static final double THRES_CROP_SCALE = 2.5d;
    public static final int THUMB_MAX_LIMIT_SIZE_IN_DP = 144;
    public static final int THUMB_MIN_LIMITE_SIZE_IN_DP = 56;
    public static final int TYPE_HW = 2;
    public static final int TYPE_WH = 1;

    public static boolean isLongVertical(int i2, int i3) {
        return ((double) i3) > ((double) i2) * 2.0d;
    }

    public static boolean isLongHorizontal(int i2, int i3) {
        return ((double) i2) > ((double) i3) * 2.0d;
    }

    public static int isLongPicture(String str) {
        Bitmap bitmap = null;
        AppMethodBeat.i(156189);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            InputStream openRead = s.openRead(str);
            bitmap = MMBitmapFactory.decodeStream(openRead, null, options);
            openRead.close();
        } catch (FileNotFoundException | IOException e2) {
        }
        if (bitmap != null) {
            Log.i(TAG, "isLongPicture bitmap recycle. %s", bitmap);
            bitmap.recycle();
        }
        float f2 = ((float) options.outWidth) / ((float) options.outHeight);
        float f3 = ((float) options.outHeight) / ((float) options.outWidth);
        if (f2 >= 2.0f) {
            AppMethodBeat.o(156189);
            return 1;
        } else if (f3 >= 2.0f) {
            AppMethodBeat.o(156189);
            return 2;
        } else {
            AppMethodBeat.o(156189);
            return -1;
        }
    }

    public static int isLongPicture(Bitmap bitmap) {
        AppMethodBeat.i(215369);
        float width = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
        float height = ((float) bitmap.getHeight()) / ((float) bitmap.getWidth());
        if (width >= 2.0f) {
            AppMethodBeat.o(215369);
            return 1;
        } else if (height >= 2.0f) {
            AppMethodBeat.o(215369);
            return 2;
        } else {
            AppMethodBeat.o(215369);
            return -1;
        }
    }

    public static Bitmap createLongPictureBitmap(String str, int i2, int i3) {
        AppMethodBeat.i(215370);
        Bitmap createLongPictureBitmap = createLongPictureBitmap(str, i2, 56, 144, THRES_CROP_SCALE, i3);
        AppMethodBeat.o(215370);
        return createLongPictureBitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:70:0x01eb A[SYNTHETIC, Splitter:B:70:0x01eb] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01fb A[SYNTHETIC, Splitter:B:76:0x01fb] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap createLongPictureBitmap(java.lang.String r14, int r15, int r16, int r17, double r18, int r20) {
        /*
        // Method dump skipped, instructions count: 673
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.LongBitmapHandler.createLongPictureBitmap(java.lang.String, int, int, int, double, int):android.graphics.Bitmap");
    }

    public static boolean createLongPictureThumbNail(String str, Bitmap.CompressFormat compressFormat, int i2, String str2, int i3, int i4, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(215372);
        Bitmap createLongPictureBitmap = createLongPictureBitmap(str, i3, i4);
        try {
            pInt.value = createLongPictureBitmap.getWidth();
            pInt2.value = createLongPictureBitmap.getHeight();
            BitmapUtil.saveBitmapToImage(createLongPictureBitmap, i2, compressFormat, str2, true);
            AppMethodBeat.o(215372);
            return true;
        } catch (IOException e2) {
            Log.e(TAG, "create thumbnail from orig failed: ".concat(String.valueOf(str2)));
            AppMethodBeat.o(215372);
            return false;
        }
    }

    public static boolean createLongPictureThumbNail(String str, Bitmap.CompressFormat compressFormat, int i2, String str2, int i3) {
        AppMethodBeat.i(215373);
        boolean createLongPictureThumbNail = createLongPictureThumbNail(str, compressFormat, i2, str2, i3, 0, new PInt(), new PInt());
        AppMethodBeat.o(215373);
        return createLongPictureThumbNail;
    }
}

package com.tencent.mm.plugin.gallery.model;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.provider.MediaStore;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.gallery.a.a;
import com.tencent.mm.plugin.gallery.model.s;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LongBitmapHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.at;

public final class n {
    private static int thumbWidth = 0;
    private static final int xjh;
    private static final int xji;

    static {
        int i2;
        int i3 = 960;
        AppMethodBeat.i(111344);
        Display defaultDisplay = ((WindowManager) MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
        int[] iArr = {defaultDisplay.getWidth(), defaultDisplay.getHeight()};
        if (iArr[0] > 960) {
            i2 = iArr[0];
        } else {
            i2 = 960;
        }
        xjh = i2;
        if (iArr[1] > 960) {
            i3 = iArr[1];
        }
        xji = i3;
        AppMethodBeat.o(111344);
    }

    public static Bitmap a(long j2, int i2, String str, String str2) {
        Bitmap bitmap = null;
        AppMethodBeat.i(111338);
        if (e.dQK() == null) {
            AppMethodBeat.o(111338);
        } else {
            switch (i2) {
                case 1:
                    bitmap = m(str, a.dZ(str, dRn()));
                    if (bitmap == null || bitmap.isRecycled()) {
                        Log.d("MicroMsg.MediaManager", "get bitmap from file failed.");
                        bitmap = aw(str, j2);
                    } else {
                        Log.d("MicroMsg.MediaManager", "get bitmap from file.");
                    }
                    if (bitmap == null) {
                        Log.e("MicroMsg.MediaManager", "get thumb from content resolver failed: [%s], [%s]", str, str2);
                        break;
                    }
                    break;
                case 2:
                    bitmap = u(j2, str2);
                    break;
            }
            AppMethodBeat.o(111338);
        }
        return bitmap;
    }

    public static Bitmap a(String str, s.e eVar) {
        Bitmap bitmap = null;
        AppMethodBeat.i(111339);
        if (Util.isNullOrNil(str) || eVar == null || eVar.xjV == 0) {
            Log.i("MicroMsg.MediaManager", "getPortraitBitmap err, filePath: %s.", str);
            AppMethodBeat.o(111339);
            return null;
        }
        Log.i("MicroMsg.MediaManager", "getPortraitBitmap, filePath: %s, cropArea: %f, %f, %f, %f.", str, Double.valueOf(eVar.pKw), Double.valueOf(eVar.pKx), Double.valueOf(eVar.pKy), Double.valueOf(eVar.pKz));
        Rect rect = new Rect();
        switch (eVar.xjV) {
            case 1:
                try {
                    BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
                    rect.set((int) ((eVar.pKw * ((double) imageOptions.outWidth)) + 0.5d), (int) ((eVar.pKx * ((double) imageOptions.outHeight)) + 0.5d), (int) ((eVar.pKy * ((double) imageOptions.outWidth)) + 0.5d), (int) ((eVar.pKz * ((double) imageOptions.outHeight)) + 0.5d));
                    break;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.MediaManager", e2, "getPortraitBitmap, trans crop rel error.", new Object[0]);
                    break;
                }
            case 2:
                rect.set((int) (eVar.pKw + 0.5d), (int) (eVar.pKx + 0.5d), (int) (eVar.pKy + 0.5d), (int) (eVar.pKz + 0.5d));
                break;
        }
        try {
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(com.tencent.mm.vfs.s.openRead(str), false);
            if (newInstance != null && !newInstance.isRecycled()) {
                bitmap = newInstance.decodeRegion(rect, null);
            }
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.MediaManager", e3, "getPortraitBitmap fail.", new Object[0]);
        }
        Bitmap m = m(str, ad(bitmap));
        AppMethodBeat.o(111339);
        return m;
    }

    private static Bitmap ad(Bitmap bitmap) {
        Bitmap bitmap2 = null;
        AppMethodBeat.i(173738);
        if (bitmap != null) {
            try {
                if (bitmap.getWidth() >= bitmap.getHeight()) {
                    bitmap2 = Bitmap.createBitmap(bitmap, (bitmap.getWidth() / 2) - (bitmap.getHeight() / 2), 0, bitmap.getHeight(), bitmap.getHeight());
                } else {
                    bitmap2 = Bitmap.createBitmap(bitmap, 0, (bitmap.getHeight() / 2) - (bitmap.getWidth() / 2), bitmap.getWidth(), bitmap.getWidth());
                }
            } catch (OutOfMemoryError e2) {
                Log.printErrStackTrace("MicroMsg.MediaManager", e2, "cropCenter err!!!", new Object[0]);
                AppMethodBeat.o(173738);
            }
        }
        AppMethodBeat.o(173738);
        return bitmap2;
    }

    private static int dRn() {
        AppMethodBeat.i(164766);
        if (thumbWidth > 0) {
            int i2 = thumbWidth;
            AppMethodBeat.o(164766);
            return i2;
        }
        int fromDPToPix = at.fromDPToPix(MMApplicationContext.getContext(), 100);
        thumbWidth = fromDPToPix;
        AppMethodBeat.o(164766);
        return fromDPToPix;
    }

    public static Bitmap aw(String str, long j2) {
        int height;
        Bitmap bitmap = null;
        AppMethodBeat.i(257730);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.MediaManager", "filePath is null or nil");
            AppMethodBeat.o(257730);
        } else {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                bitmap = MediaStore.Images.Thumbnails.getThumbnail(MMApplicationContext.getContext().getContentResolver(), j2, 1, null);
                Object[] objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = "MINI_KIND";
                objArr[2] = Integer.valueOf(bitmap == null ? 0 : bitmap.getWidth());
                if (bitmap == null) {
                    height = 0;
                } else {
                    height = bitmap.getHeight();
                }
                objArr[3] = Integer.valueOf(height);
                objArr[4] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                Log.v("MicroMsg.MediaManager", "getImageThumb[%s]FromContentResolver type[%s], bmp size[%d, %d]: total time:[%dms]", objArr);
            } catch (Exception | OutOfMemoryError e2) {
                Log.e("MicroMsg.MediaManager", "get thumb from content resolver failed: [%s]", e2.toString());
                Log.printErrStackTrace("MicroMsg.MediaManager", e2, "", new Object[0]);
            }
            AppMethodBeat.o(257730);
        }
        return bitmap;
    }

    public static Bitmap hB(String str, String str2) {
        int width;
        Bitmap bitmap;
        int width2;
        int i2 = 0;
        AppMethodBeat.i(164767);
        Log.d("MicroMsg.MediaManager", "current thread %s", Thread.currentThread().getName());
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.MediaManager", "filePath is null or nil");
            AppMethodBeat.o(164767);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap extractThumbNail = BitmapUtil.extractThumbNail(str, dRn(), dRn(), false);
        Object[] objArr = new Object[4];
        objArr[0] = str;
        if (extractThumbNail == null) {
            width = 0;
        } else {
            width = extractThumbNail.getWidth();
        }
        objArr[1] = Integer.valueOf(width);
        objArr[2] = Integer.valueOf(extractThumbNail == null ? 0 : extractThumbNail.getHeight());
        objArr[3] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        Log.v("MicroMsg.MediaManager", "getImageThumb[%s]FromThumbFilePath, bmp size[%d, %d]: total time:[%dms]", objArr);
        if (extractThumbNail == null) {
            Log.w("MicroMsg.MediaManager", "get bitmap from thumb failed, try to get thumb from orig image:[%s]", str2);
            if (!Util.isNullOrNil(str2)) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Bitmap extractThumbNail2 = BitmapUtil.extractThumbNail(str2, dRn(), dRn(), false);
                Object[] objArr2 = new Object[5];
                objArr2[0] = str;
                objArr2[1] = str2;
                if (extractThumbNail2 == null) {
                    width2 = 0;
                } else {
                    width2 = extractThumbNail2.getWidth();
                }
                objArr2[2] = Integer.valueOf(width2);
                if (extractThumbNail2 != null) {
                    i2 = extractThumbNail2.getHeight();
                }
                objArr2[3] = Integer.valueOf(i2);
                objArr2[4] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis2);
                Log.v("MicroMsg.MediaManager", "getImageThumb[%s]FromOrigFilePath[%s], bmp size[%d, %d]:total time:[%dms]", objArr2);
                bitmap = extractThumbNail2;
                Bitmap m = m(str2, bitmap);
                AppMethodBeat.o(164767);
                return m;
            }
            Log.e("MicroMsg.MediaManager", "get bit from orig image faield:[%s]", str2);
        }
        bitmap = extractThumbNail;
        Bitmap m2 = m(str2, bitmap);
        AppMethodBeat.o(164767);
        return m2;
    }

    private static Bitmap m(String str, Bitmap bitmap) {
        AppMethodBeat.i(111341);
        if (bitmap != null) {
            long currentTimeMillis = System.currentTimeMillis();
            int exifOrientation = BackwardSupportUtil.ExifHelper.getExifOrientation(str);
            Bitmap rotate = BitmapUtil.rotate(bitmap, (float) exifOrientation);
            Log.d("MicroMsg.MediaManager", "do rotate finish, width[%d] height[%d] rotate[%d] use[%dms]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(exifOrientation), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (rotate != null) {
                AppMethodBeat.o(111341);
                return rotate;
            }
        }
        AppMethodBeat.o(111341);
        return null;
    }

    public static Bitmap ayT(String str) {
        int i2;
        int i3;
        boolean z = true;
        AppMethodBeat.i(111342);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.MediaManager", "filepath is null or nil");
            AppMethodBeat.o(111342);
            return null;
        }
        try {
            if (!com.tencent.mm.vfs.s.YS(str)) {
                Log.e("MicroMsg.MediaManager", "getSuitableBmp fail, file does not exist, filePath = ".concat(String.valueOf(str)));
                AppMethodBeat.o(111342);
                return null;
            }
            int i4 = xjh;
            int i5 = xji;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options);
            if (decodeFile != null) {
                Log.i("MicroMsg.MediaManager", "bitmap recycle %s", decodeFile.toString());
                decodeFile.recycle();
            }
            if (options.outWidth <= 0 || options.outHeight <= 0) {
                Log.d("MicroMsg.MediaManager", "get bitmap fail, file is not a image file = ".concat(String.valueOf(str)));
                AppMethodBeat.o(111342);
                return null;
            }
            boolean z2 = LongBitmapHandler.isLongHorizontal(options.outWidth, options.outHeight) && options.outWidth > 480;
            if (!LongBitmapHandler.isLongVertical(options.outWidth, options.outHeight) || options.outHeight <= 480) {
                z = false;
            }
            if (z2 || z) {
                i5 = options.outHeight;
                i4 = options.outWidth;
            }
            int exifOrientation = BackwardSupportUtil.ExifHelper.getExifOrientation(str);
            if (exifOrientation == 90 || exifOrientation == 270) {
                i3 = i4;
                i2 = i5;
            } else {
                i3 = i5;
                i2 = i4;
            }
            Bitmap extractThumbNail = BitmapUtil.extractThumbNail(str, i3, i2, false);
            if (extractThumbNail == null) {
                Log.e("MicroMsg.MediaManager", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(str)));
                AppMethodBeat.o(111342);
                return null;
            }
            Bitmap rotate = BitmapUtil.rotate(extractThumbNail, (float) exifOrientation);
            Log.d("MicroMsg.MediaManager", "bmp height = " + rotate.getHeight() + ",bmp width = " + rotate.getWidth());
            AppMethodBeat.o(111342);
            return rotate;
        } catch (Exception e2) {
            Log.e("MicroMsg.MediaManager", "decode bitmap err: " + e2.getMessage());
            AppMethodBeat.o(111342);
            return null;
        }
    }

    @TargetApi(8)
    private static Bitmap u(long j2, String str) {
        Bitmap bitmap;
        AppMethodBeat.i(111343);
        try {
            bitmap = MediaStore.Video.Thumbnails.getThumbnail(MMApplicationContext.getContext().getContentResolver(), j2, 1, null);
        } catch (Exception e2) {
            Log.e("MicroMsg.MediaManager", "exception: %s", Util.stackTraceToString(e2));
            bitmap = null;
        }
        if (bitmap == null) {
            Log.e("MicroMsg.MediaManager", "get video thumb failed : [%d] [%s]", Long.valueOf(j2), str);
            bitmap = BitmapUtil.createVideoThumbnail(str, 1);
            if (bitmap == null && !Util.isNullOrNil(str)) {
                Log.e("MicroMsg.MediaManager", "get video thumb failed : [%d], call media scanner : [%s]", Long.valueOf(j2), str);
                AndroidMediaUtil.refreshMediaScanner(str, MMApplicationContext.getContext());
            }
        }
        AppMethodBeat.o(111343);
        return bitmap;
    }
}

package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.b;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.vfs.s;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

public class BitmapUtil {
    private static final int ANDROID_API_LEVEL_11 = 11;
    private static final int DEFAULT_DECODE_MARK_SIZE = 8388608;
    private static final int DEFAULT_TARGET_WIDTH = 2500;
    public static final int MAX_DECODE_PICTURE_SIZE = 2764800;
    public static final double SCALE_HORIZONTAL = 1.2d;
    private static final String TAG = "MicroMsg.BitmapUtil";
    public static boolean hasNoInNativeField;
    private static DisplayMetrics metrics = null;

    public static BitmapFactory.Options getImageOptions(InputStream inputStream, boolean z) {
        AppMethodBeat.i(169229);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        bindlowMemeryOption(options);
        if (inputStream == null) {
            Log.e(TAG, "getImageOptions decode stream is null!!");
            AppMethodBeat.o(169229);
            return options;
        }
        if (!z) {
            if (!inputStream.markSupported()) {
                if (inputStream instanceof FileInputStream) {
                    inputStream = new FileSeekingInputStream((FileInputStream) inputStream);
                } else {
                    inputStream = new BufferedInputStream(inputStream);
                }
            }
            inputStream.mark(8388608);
        }
        try {
            Bitmap decodeStream = MMBitmapFactory.decodeStream(inputStream, null, options);
            if (decodeStream != null) {
                Log.i(TAG, "getImageOptions bitmap recycle. %s", decodeStream);
                decodeStream.recycle();
            }
            if (z) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    Log.printErrStackTrace(TAG, e2, "hy: stream close failed ", new Object[0]);
                }
            } else {
                Log.w(TAG, "hy: not auto close. reset for invoker");
                try {
                    inputStream.reset();
                } catch (Exception e3) {
                    Log.printErrStackTrace(TAG, e3, "hy: stream reset failed", new Object[0]);
                }
            }
        } catch (OutOfMemoryError e4) {
            Log.printErrStackTrace(TAG, e4, "Decode bitmap failed.", new Object[0]);
            if (z) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    Log.printErrStackTrace(TAG, e5, "hy: stream close failed ", new Object[0]);
                }
            } else {
                Log.w(TAG, "hy: not auto close. reset for invoker");
                try {
                    inputStream.reset();
                } catch (Exception e6) {
                    Log.printErrStackTrace(TAG, e6, "hy: stream reset failed", new Object[0]);
                }
            }
        } catch (Throwable th) {
            if (z) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                    Log.printErrStackTrace(TAG, e7, "hy: stream close failed ", new Object[0]);
                }
            } else {
                Log.w(TAG, "hy: not auto close. reset for invoker");
                try {
                    inputStream.reset();
                } catch (Exception e8) {
                    Log.printErrStackTrace(TAG, e8, "hy: stream reset failed", new Object[0]);
                }
            }
            AppMethodBeat.o(169229);
            throw th;
        }
        AppMethodBeat.o(169229);
        return options;
    }

    public static BitmapFactory.Options getImageOptions(String str) {
        AppMethodBeat.i(156099);
        if (Util.isNullOrNil(str)) {
            Log.e(TAG, "getImageOptions invalid path");
            AppMethodBeat.o(156099);
            return null;
        }
        try {
            BitmapFactory.Options imageOptions = getImageOptions(s.openRead(str), true);
            AppMethodBeat.o(156099);
            return imageOptions;
        } catch (FileNotFoundException e2) {
            Log.printErrStackTrace(TAG, e2, "Decode bitmap failed.", new Object[0]);
            BitmapFactory.Options options = new BitmapFactory.Options();
            AppMethodBeat.o(156099);
            return options;
        }
    }

    public static Bitmap createColorBitmap(int i2, int i3, int i4) {
        AppMethodBeat.i(156100);
        try {
            Bitmap createBitmap = createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawColor(i2);
            Bitmap trace = BitmapTracer.trace(createBitmap);
            AppMethodBeat.o(156100);
            return trace;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(156100);
            return null;
        }
    }

    public static boolean createThumbNail(String str, int i2, int i3, Bitmap.CompressFormat compressFormat, int i4, String str2, String str3, boolean z, boolean z2) {
        AppMethodBeat.i(215298);
        boolean createThumbNail = createThumbNail(false, str, i2, i3, compressFormat, i4, str2 + str3, z, new PInt(), new PInt(), z2, null, 0);
        AppMethodBeat.o(215298);
        return createThumbNail;
    }

    public static boolean createThumbNail(String str, int i2, int i3, Bitmap.CompressFormat compressFormat, int i4, String str2, String str3, boolean z) {
        AppMethodBeat.i(215299);
        boolean createThumbNail = createThumbNail(false, str, i2, i3, compressFormat, i4, str2 + str3, z);
        AppMethodBeat.o(215299);
        return createThumbNail;
    }

    public static boolean createThumbNail(String str, int i2, int i3, Bitmap.CompressFormat compressFormat, int i4, String str2, String str3) {
        AppMethodBeat.i(156101);
        boolean createThumbNail = createThumbNail(str, i2, i3, compressFormat, i4, str2, str3, false);
        AppMethodBeat.o(156101);
        return createThumbNail;
    }

    public static boolean createThumbNail(String str, int i2, int i3, Bitmap.CompressFormat compressFormat, int i4, String str2) {
        AppMethodBeat.i(156102);
        boolean createThumbNail = createThumbNail(false, str, i2, i3, compressFormat, i4, str2, false);
        AppMethodBeat.o(156102);
        return createThumbNail;
    }

    public static boolean createThumbNail(boolean z, String str, int i2, int i3, Bitmap.CompressFormat compressFormat, int i4, String str2) {
        AppMethodBeat.i(215300);
        boolean createThumbNail = createThumbNail(z, str, i2, i3, compressFormat, i4, str2, false);
        AppMethodBeat.o(215300);
        return createThumbNail;
    }

    public static int calculateInSampleSize(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(156103);
        int i6 = 1;
        if (i2 > i5 || i3 > i4) {
            if (i3 > i2) {
                i6 = Math.round((((float) i2) / ((float) i5)) + 0.5f);
            } else {
                i6 = Math.round((((float) i3) / ((float) i4)) + 0.5f);
            }
            while (((float) (i3 * i2)) / ((float) (i6 * i6)) > ((float) (i4 * i5 * 2))) {
                i6++;
            }
        }
        AppMethodBeat.o(156103);
        return i6;
    }

    public static Point getPictureSize(String str) {
        AppMethodBeat.i(156104);
        BitmapFactory.Options imageOptions = getImageOptions(str);
        if (imageOptions != null) {
            Point point = new Point(imageOptions.outWidth, imageOptions.outHeight);
            AppMethodBeat.o(156104);
            return point;
        }
        AppMethodBeat.o(156104);
        return null;
    }

    public static boolean createThumbNail(boolean z, String str, int i2, int i3, Bitmap.CompressFormat compressFormat, int i4, String str2, boolean z2) {
        AppMethodBeat.i(215301);
        boolean createThumbNail = createThumbNail(z, str, i2, i3, compressFormat, i4, str2, z2, new PInt(), new PInt());
        AppMethodBeat.o(215301);
        return createThumbNail;
    }

    public static boolean createThumbNail(String str, int i2, int i3, Bitmap.CompressFormat compressFormat, int i4, String str2, boolean z) {
        AppMethodBeat.i(215302);
        boolean createThumbNail = createThumbNail(false, str, i2, i3, compressFormat, i4, str2, z, new PInt(), new PInt());
        AppMethodBeat.o(215302);
        return createThumbNail;
    }

    public static boolean createThumbNail(boolean z, String str, int i2, int i3, Bitmap.CompressFormat compressFormat, int i4, String str2, boolean z2, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(215303);
        boolean createThumbNail = createThumbNail(z, str, i2, i3, compressFormat, i4, str2, z2, pInt, pInt2, false, null, 0);
        AppMethodBeat.o(215303);
        return createThumbNail;
    }

    public static boolean createThumbNail(String str, int i2, int i3, Bitmap.CompressFormat compressFormat, int i4, String str2, boolean z, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(215304);
        boolean createThumbNail = createThumbNail(false, str, i2, i3, compressFormat, i4, str2, z, pInt, pInt2, false, null, 0);
        AppMethodBeat.o(215304);
        return createThumbNail;
    }

    public static boolean createThumbNail(String str, int i2, int i3, Bitmap.CompressFormat compressFormat, int i4, String str2, boolean z, PInt pInt, PInt pInt2, boolean z2) {
        AppMethodBeat.i(215305);
        boolean createThumbNail = createThumbNail(false, str, i2, i3, compressFormat, i4, str2, z, pInt, pInt2, z2, null, 0);
        AppMethodBeat.o(215305);
        return createThumbNail;
    }

    public static boolean createThumbNail(String str, int i2, int i3, Bitmap.CompressFormat compressFormat, int i4, String str2, boolean z, PInt pInt, PInt pInt2, boolean z2, int i5) {
        AppMethodBeat.i(215306);
        boolean createThumbNail = createThumbNail(false, str, i2, i3, compressFormat, i4, str2, z, pInt, pInt2, z2, null, i5);
        AppMethodBeat.o(215306);
        return createThumbNail;
    }

    public static boolean createThumbNail(boolean z, String str, int i2, int i3, Bitmap.CompressFormat compressFormat, int i4, String str2, boolean z2, PInt pInt, PInt pInt2, boolean z3, b bVar, int i5) {
        AppMethodBeat.i(215307);
        try {
            Bitmap extractThumbNail = extractThumbNail(str, i2, i3, z3);
            if (extractThumbNail == null) {
                AppMethodBeat.o(215307);
                return false;
            }
            if (z2) {
                extractThumbNail = rotate(extractThumbNail, (float) Exif.fromFile(str).getOrientationInDegree());
            }
            if (bVar != null) {
                bVar.Ur();
            }
            pInt.value = extractThumbNail.getWidth();
            pInt2.value = extractThumbNail.getHeight();
            Bitmap drawBackgroundInNeed = drawBackgroundInNeed(extractThumbNail, str, i5);
            if (z) {
                int compressByQualityOptim = ImageOptimLib.compressByQualityOptim(drawBackgroundInNeed, i4, false, str2);
                Log.i(TAG, "dkimgopt compressByQualityOptim ret:%d  [%d,%d,%d] path:%s", Integer.valueOf(compressByQualityOptim), Integer.valueOf(i4), Integer.valueOf(drawBackgroundInNeed.getWidth()), Integer.valueOf(drawBackgroundInNeed.getHeight()), str2);
                if (compressByQualityOptim == 1) {
                    AppMethodBeat.o(215307);
                    return true;
                }
                AppMethodBeat.o(215307);
                return false;
            }
            saveBitmapToImage(drawBackgroundInNeed, i4, compressFormat, str2, true);
            AppMethodBeat.o(215307);
            return true;
        } catch (Throwable th) {
            Log.e(TAG, "create thumbnail from orig failed: ".concat(String.valueOf(str2)));
            AppMethodBeat.o(215307);
            return false;
        }
    }

    public static Bitmap handleDegree(int i2, Bitmap bitmap) {
        AppMethodBeat.i(169230);
        Bitmap rotate = rotate(bitmap, (float) i2);
        AppMethodBeat.o(169230);
        return rotate;
    }

    public static int checkDegree(String str) {
        AppMethodBeat.i(169231);
        int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
        AppMethodBeat.o(169231);
        return orientationInDegree;
    }

    public static int createThumbNailMayUseOpt(boolean z, String str, int i2, int i3, Bitmap.CompressFormat compressFormat, int i4, String str2, b bVar, int i5) {
        AppMethodBeat.i(215308);
        Bitmap extractThumbNail = extractThumbNail(str, i2, i3, false);
        if (extractThumbNail == null) {
            AppMethodBeat.o(215308);
            return -1;
        }
        Bitmap rotate = rotate(extractThumbNail, (float) Exif.fromFile(str).getOrientationInDegree());
        if (bVar != null) {
            bVar.Ur();
        }
        Bitmap drawBackgroundInNeed = drawBackgroundInNeed(rotate, str, i5);
        if (z) {
            try {
                int compressByQualityOptim = ImageOptimLib.compressByQualityOptim(drawBackgroundInNeed, i4, false, str2);
                Log.i(TAG, "dkimgopt compressByQualityOptim ret:%d  [%d,%d,%d] path:%s", Integer.valueOf(compressByQualityOptim), Integer.valueOf(i4), Integer.valueOf(drawBackgroundInNeed.getWidth()), Integer.valueOf(drawBackgroundInNeed.getHeight()), str2);
                AppMethodBeat.o(215308);
                return compressByQualityOptim;
            } catch (IOException e2) {
                Log.e(TAG, "create thumbnail from orig failed: ".concat(String.valueOf(str2)));
                AppMethodBeat.o(215308);
                return -2;
            }
        } else {
            saveBitmapToImage(drawBackgroundInNeed, i4, compressFormat, str2, true);
            AppMethodBeat.o(215308);
            return 1;
        }
    }

    public static Bitmap createThumbBitmap(String str, int i2, int i3, boolean z, boolean z2) {
        AppMethodBeat.i(215309);
        Bitmap createThumbBitmap = createThumbBitmap(str, i2, i3, z, z2, 0);
        AppMethodBeat.o(215309);
        return createThumbBitmap;
    }

    public static Bitmap createThumbBitmap(String str, int i2, int i3, boolean z, boolean z2, int i4) {
        AppMethodBeat.i(215310);
        Bitmap extractThumbNail = extractThumbNail(str, i2, i3, z2);
        if (extractThumbNail == null) {
            AppMethodBeat.o(215310);
            return null;
        }
        Bitmap drawBackgroundInNeed = drawBackgroundInNeed(extractThumbNail, str, i4);
        if (z) {
            int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
            Log.d(TAG, "degress:%d", Integer.valueOf(orientationInDegree));
            drawBackgroundInNeed = rotate(drawBackgroundInNeed, (float) orientationInDegree);
        }
        AppMethodBeat.o(215310);
        return drawBackgroundInNeed;
    }

    public static Bitmap createThumbCropBitmap(String str, int i2, int i3, boolean z) {
        AppMethodBeat.i(215311);
        Bitmap decodeFile = decodeFile(str);
        if (decodeFile == null) {
            AppMethodBeat.o(215311);
            return null;
        }
        if (z) {
            int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
            Log.d(TAG, "degress:%d", Integer.valueOf(orientationInDegree));
            decodeFile = rotate(decodeFile, (float) orientationInDegree);
        }
        Bitmap extractThumbNail = extractThumbNail(decodeFile, i3, i2, true, true);
        AppMethodBeat.o(215311);
        return extractThumbNail;
    }

    public static boolean createThumbNail(String str, int i2, int i3, Bitmap.CompressFormat compressFormat, int i4, String str2, boolean z, PInt pInt, PInt pInt2, boolean z2, boolean z3, int i5) {
        Bitmap bitmap;
        AppMethodBeat.i(215312);
        if (Util.isNullOrNil(str)) {
            Log.w(TAG, "file path is null.");
            AppMethodBeat.o(215312);
            return false;
        } else if (!s.YS(str)) {
            Log.w(TAG, "file did not exists.");
            AppMethodBeat.o(215312);
            return false;
        } else {
            int i6 = 0;
            if (z) {
                i6 = Exif.fromFile(str).getOrientationInDegree();
                Log.d(TAG, "degress:%d", Integer.valueOf(i6));
            }
            if (i6 == 90 || i6 == 270) {
                bitmap = extractThumbNail(str, i3, i2, z2);
                if (z) {
                    bitmap = rotate(bitmap, (float) i6);
                }
            } else {
                bitmap = extractThumbNail(str, i2, i3, z2);
                if (z) {
                    bitmap = rotate(bitmap, (float) i6);
                }
            }
            if (bitmap == null) {
                AppMethodBeat.o(215312);
                return false;
            }
            Bitmap drawBackgroundInNeed = drawBackgroundInNeed(bitmap, str, i5);
            try {
                pInt.value = drawBackgroundInNeed.getWidth();
                pInt2.value = drawBackgroundInNeed.getHeight();
                saveBitmapToImage(drawBackgroundInNeed, i4, compressFormat, str2, true);
                AppMethodBeat.o(215312);
                return true;
            } catch (IOException e2) {
                Log.e(TAG, "create thumbnail from orig failed: ".concat(String.valueOf(str2)));
                AppMethodBeat.o(215312);
                return false;
            }
        }
    }

    public static Bitmap extractThumeNail(Bitmap bitmap, int i2, int i3, boolean z) {
        int i4;
        int i5;
        Bitmap bitmap2;
        float f2 = 2.5f;
        AppMethodBeat.i(215313);
        if (bitmap.getHeight() >= bitmap.getWidth()) {
            float height = ((float) bitmap.getHeight()) / ((float) bitmap.getWidth());
            if (height <= 2.0f) {
                i4 = (int) (((((double) i2) * 1.0d) * ((double) bitmap.getWidth())) / ((double) bitmap.getHeight()));
                i5 = i2;
            } else {
                if (((double) height) > 2.5d) {
                    bitmap = Bitmap.createBitmap(bitmap, 0, (bitmap.getHeight() - ((int) (((float) bitmap.getWidth()) * 2.5f))) / 2, bitmap.getWidth(), (int) (((float) bitmap.getWidth()) * 2.5f));
                } else {
                    f2 = height;
                }
                i5 = (int) (f2 * 56.0f);
                i4 = 56;
            }
        } else {
            float width = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
            if (width <= 2.0f) {
                i4 = i3;
                i5 = (int) (((((double) i3) * 1.0d) * ((double) bitmap.getHeight())) / ((double) bitmap.getWidth()));
            } else {
                if (((double) width) > 2.5d) {
                    bitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - ((int) (((float) bitmap.getHeight()) * 2.5f))) / 2, 0, (int) (((float) bitmap.getHeight()) * 2.5f), bitmap.getHeight());
                } else {
                    f2 = width;
                }
                i4 = (int) (f2 * 56.0f);
                i5 = 56;
            }
        }
        Log.d(TAG, "bitmap decoded size=" + bitmap.getWidth() + "x" + bitmap.getHeight());
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i4, i5, true);
        if (createScaledBitmap == null || bitmap == createScaledBitmap) {
            createScaledBitmap = bitmap;
        } else {
            Log.i(TAG, "extractThumeNail bitmap recycle. %s", bitmap);
            bitmap.recycle();
        }
        if (z) {
            bitmap2 = Bitmap.createBitmap(createScaledBitmap, (createScaledBitmap.getWidth() - i3) >> 1, (createScaledBitmap.getHeight() - i2) >> 1, i3, i2);
            if (bitmap2 == null) {
                AppMethodBeat.o(215313);
                return createScaledBitmap;
            }
            if (createScaledBitmap != bitmap2) {
                Log.i(TAG, "extractThumeNail bitmap recycle 2. %s", createScaledBitmap);
                createScaledBitmap.recycle();
            }
            Log.d(TAG, "bitmap croped size=" + bitmap2.getWidth() + "x" + bitmap2.getHeight());
        } else {
            bitmap2 = createScaledBitmap;
        }
        AppMethodBeat.o(215313);
        return bitmap2;
    }

    public static Bitmap getBitmapNative(String str) {
        AppMethodBeat.i(156114);
        Bitmap bitmapNative = getBitmapNative(str, 0, 0, 0.0f);
        AppMethodBeat.o(156114);
        return bitmapNative;
    }

    public static Bitmap getBitmapNative(InputStream inputStream) {
        AppMethodBeat.i(156115);
        Bitmap bitmapNative = getBitmapNative(0, null, null, null, inputStream, false, 0.0f, 0, 0);
        AppMethodBeat.o(156115);
        return bitmapNative;
    }

    public static Bitmap getBitmapNative(int i2) {
        AppMethodBeat.i(156116);
        Bitmap bitmapNative = getBitmapNative(i2, null, null, null, false, 0.0f, 0, 0);
        AppMethodBeat.o(156116);
        return bitmapNative;
    }

    public static Bitmap getBitmapNative(int i2, float f2) {
        AppMethodBeat.i(156117);
        Bitmap bitmapNative = getBitmapNative(i2, null, null, null, false, f2, 0, 0);
        AppMethodBeat.o(156117);
        return bitmapNative;
    }

    public static Bitmap getBitmapNative(int i2, int i3, int i4) {
        AppMethodBeat.i(156118);
        Bitmap bitmapNative = getBitmapNative(i2, null, null, null, false, 0.0f, i3, i4);
        AppMethodBeat.o(156118);
        return bitmapNative;
    }

    public static Bitmap getBitmapNativeDisplayMetrics(int i2) {
        AppMethodBeat.i(215314);
        DisplayMetrics defaultDisplayMetrics = getDefaultDisplayMetrics();
        Bitmap bitmapNative = getBitmapNative(i2, null, null, null, false, 0.0f, defaultDisplayMetrics.widthPixels, defaultDisplayMetrics.heightPixels);
        AppMethodBeat.o(215314);
        return bitmapNative;
    }

    public static Bitmap getBitmapNative(String str, float f2) {
        AppMethodBeat.i(156119);
        Bitmap bitmapNative = getBitmapNative(str, 0, 0, f2);
        AppMethodBeat.o(156119);
        return bitmapNative;
    }

    public static Bitmap getBitmapNative(String str, int i2, int i3) {
        AppMethodBeat.i(156120);
        Bitmap bitmapNative = getBitmapNative(str, i2, i3, 0.0f);
        AppMethodBeat.o(156120);
        return bitmapNative;
    }

    public static Bitmap getBitmapNative(InputStream inputStream, int i2, int i3) {
        AppMethodBeat.i(156121);
        Bitmap bitmapNative = getBitmapNative(0, null, null, null, inputStream, false, 0.0f, i2, i3);
        AppMethodBeat.o(156121);
        return bitmapNative;
    }

    public static Bitmap getBitmapNative(String str, int i2, int i3, float f2) {
        AppMethodBeat.i(156122);
        Bitmap bitmapNative = getBitmapNative(0, str, null, null, false, f2, i2, i3);
        AppMethodBeat.o(156122);
        return bitmapNative;
    }

    public static Bitmap getBitmapNative(Uri uri, int i2, int i3, float f2) {
        AppMethodBeat.i(215315);
        Bitmap bitmapNative = getBitmapNative(0, null, null, uri, false, f2, i2, i3);
        AppMethodBeat.o(215315);
        return bitmapNative;
    }

    public static Bitmap getBitmapNative(Uri uri, float f2) {
        AppMethodBeat.i(215316);
        Bitmap bitmapNative = getBitmapNative(0, null, null, uri, false, f2, 0, 0);
        AppMethodBeat.o(215316);
        return bitmapNative;
    }

    public static Bitmap getBitmapNative(Uri uri, int i2, int i3) {
        AppMethodBeat.i(215317);
        Bitmap bitmapNative = getBitmapNative(uri, i2, i3, 0.0f);
        AppMethodBeat.o(215317);
        return bitmapNative;
    }

    public static Bitmap getBitmapNative(Uri uri) {
        AppMethodBeat.i(156123);
        Bitmap bitmapNative = getBitmapNative(uri, 0, 0);
        AppMethodBeat.o(156123);
        return bitmapNative;
    }

    public static Bitmap getBitmapNativeDisplayMetrics(String str) {
        AppMethodBeat.i(215318);
        DisplayMetrics defaultDisplayMetrics = getDefaultDisplayMetrics();
        Bitmap bitmapNative = getBitmapNative(str, defaultDisplayMetrics.widthPixels, defaultDisplayMetrics.heightPixels);
        AppMethodBeat.o(215318);
        return bitmapNative;
    }

    public static Bitmap createBitmap(int i2, int i3, Bitmap.Config config, boolean z) {
        Bitmap bitmap = null;
        AppMethodBeat.i(156124);
        try {
            bitmap = Bitmap.createBitmap(i2, i3, config);
        } catch (Throwable th) {
        }
        setBitmapDensity(bitmap);
        Bitmap trace = BitmapTracer.trace(bitmap);
        AppMethodBeat.o(156124);
        return trace;
    }

    public static Bitmap createBitmap(int i2, int i3, Bitmap.Config config) {
        AppMethodBeat.i(186110);
        Bitmap createBitmap = createBitmap(i2, i3, config, false);
        AppMethodBeat.o(186110);
        return createBitmap;
    }

    public static Bitmap cropBitmap(Bitmap bitmap, int i2, int i3, int i4, int i5, boolean z) {
        AppMethodBeat.i(215319);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, i2, i3, Math.min(i4, bitmap.getWidth() - i2), Math.min(i5, bitmap.getHeight() - i3));
            if (bitmap != createBitmap && z) {
                bitmap.recycle();
            }
            AppMethodBeat.o(215319);
            return createBitmap;
        } catch (Throwable th) {
            if (z && bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            AppMethodBeat.o(215319);
            return null;
        }
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(156126);
        if (Util.isNullOrNil(bArr)) {
            Log.w(TAG, "error input: data is null");
            AppMethodBeat.o(156126);
            return null;
        } else if (i2 < 0 || i3 < 0) {
            Log.w(TAG, "error input: targetWidth %d, targetHeight %d", Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(156126);
            return null;
        } else {
            Bitmap bitmapNative = getBitmapNative(0, null, bArr, null, false, 0.0f, i2, i3);
            AppMethodBeat.o(156126);
            return bitmapNative;
        }
    }

    public static Bitmap decodeByteArray(byte[] bArr) {
        AppMethodBeat.i(156127);
        Bitmap decodeByteArray = decodeByteArray(bArr, 0, 0);
        AppMethodBeat.o(156127);
        return decodeByteArray;
    }

    @Deprecated
    public static Bitmap decodeFile(String str) {
        AppMethodBeat.i(186111);
        Bitmap decodeFile = decodeFile(str, null);
        AppMethodBeat.o(186111);
        return decodeFile;
    }

    public static Bitmap decodeFileWithSample(String str) {
        AppMethodBeat.i(156129);
        Bitmap decodeFileWithSample = decodeFileWithSample(str, DEFAULT_TARGET_WIDTH, DEFAULT_TARGET_WIDTH);
        AppMethodBeat.o(156129);
        return decodeFileWithSample;
    }

    public static Bitmap decodeFileWithSample(String str, int i2, int i3) {
        AppMethodBeat.i(215320);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(options.outWidth, options.outHeight, i2, i3);
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = decodeFile(str, options);
        AppMethodBeat.o(215320);
        return decodeFile;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003d A[SYNTHETIC, Splitter:B:18:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0048 A[SYNTHETIC, Splitter:B:24:0x0048] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap decodeFile(java.lang.String r8, android.graphics.BitmapFactory.Options r9) {
        /*
            r0 = 0
            r7 = 156130(0x261e2, float:2.18785E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
            if (r9 != 0) goto L_0x000e
            android.graphics.BitmapFactory$Options r9 = new android.graphics.BitmapFactory$Options
            r9.<init>()
        L_0x000e:
            java.io.InputStream r2 = com.tencent.mm.vfs.s.openRead(r8)     // Catch:{ IOException -> 0x0023, all -> 0x0044 }
            bindlowMemeryOption(r9)     // Catch:{ IOException -> 0x0058 }
            r1 = 0
            android.graphics.Bitmap r0 = com.tencent.mm.graphics.MMBitmapFactory.decodeStream(r2, r1, r9)     // Catch:{ IOException -> 0x0058 }
            if (r2 == 0) goto L_0x001f
            r2.close()     // Catch:{ IOException -> 0x004f }
        L_0x001f:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
        L_0x0022:
            return r0
        L_0x0023:
            r1 = move-exception
            r2 = r0
        L_0x0025:
            java.lang.String r3 = "MicroMsg.BitmapUtil"
            java.lang.String r4 = "Cannot decode file '%s': %s"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0055 }
            r6 = 0
            r5[r6] = r8     // Catch:{ all -> 0x0055 }
            r6 = 1
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0055 }
            r5[r6] = r1     // Catch:{ all -> 0x0055 }
            com.tencent.mm.sdk.platformtools.Log.e(r3, r4, r5)     // Catch:{ all -> 0x0055 }
            if (r2 == 0) goto L_0x0040
            r2.close()     // Catch:{ IOException -> 0x0051 }
        L_0x0040:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            goto L_0x0022
        L_0x0044:
            r1 = move-exception
            r2 = r0
        L_0x0046:
            if (r2 == 0) goto L_0x004b
            r2.close()     // Catch:{ IOException -> 0x0053 }
        L_0x004b:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            throw r1
        L_0x004f:
            r1 = move-exception
            goto L_0x001f
        L_0x0051:
            r1 = move-exception
            goto L_0x0040
        L_0x0053:
            r0 = move-exception
            goto L_0x004b
        L_0x0055:
            r0 = move-exception
            r1 = r0
            goto L_0x0046
        L_0x0058:
            r1 = move-exception
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.BitmapUtil.decodeFile(java.lang.String, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    public static Bitmap decodeStream(InputStream inputStream, float f2, int i2, int i3) {
        Bitmap bitmap;
        int i4;
        int i5;
        AppMethodBeat.i(156131);
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (f2 != 0.0f) {
            options.inDensity = (int) (160.0f * f2);
        }
        if (!(i2 == 0 && i3 == 0)) {
            if (i2 == 0) {
                i2 = Integer.MAX_VALUE;
            }
            if (i3 == 0) {
                i3 = Integer.MAX_VALUE;
            }
            if (inputStream instanceof FileInputStream) {
                inputStream = new FileSeekingInputStream((FileInputStream) inputStream);
            } else if (!inputStream.markSupported()) {
                inputStream = new BufferedInputStream(inputStream, 65536);
            }
            inputStream.mark(25165824);
            options.inJustDecodeBounds = true;
            MMBitmapFactory.decodeStream(inputStream, null, options);
            int i6 = options.outWidth;
            int i7 = options.outHeight;
            if ((i2 <= i3 || i6 >= i7) && (i2 >= i3 || i6 <= i7)) {
                i5 = i7;
                i4 = i6;
            } else {
                i5 = i6;
                i4 = i7;
            }
            if (i4 > i2 || i5 > i3) {
                options.inSampleSize = (int) Math.max(((float) i4) / ((float) i2), ((float) i5) / ((float) i3));
            }
            options.inJustDecodeBounds = false;
            try {
                inputStream.reset();
            } catch (IOException e2) {
                Log.printErrStackTrace(TAG, e2, "Failed seeking InputStream.", new Object[0]);
            }
        }
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        bindlowMemeryOption(options);
        try {
            bitmap = MMBitmapFactory.decodeStream(inputStream, null, options);
        } catch (OutOfMemoryError e3) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            bindlowMemeryOption(options);
            try {
                bitmap = MMBitmapFactory.decodeStream(inputStream, null, options);
            } catch (OutOfMemoryError e4) {
                Log.e(TAG, "decodeStream OutOfMemoryError return null");
                bitmap = null;
            }
        }
        AppMethodBeat.o(156131);
        return bitmap;
    }

    public static Bitmap decodeStream(InputStream inputStream, float f2) {
        AppMethodBeat.i(156132);
        Bitmap decodeStream = decodeStream(inputStream, f2, 0, 0);
        AppMethodBeat.o(156132);
        return decodeStream;
    }

    public static Bitmap decodeStream(InputStream inputStream) {
        AppMethodBeat.i(156133);
        Bitmap decodeStream = decodeStream(inputStream, 0.0f, 0, 0);
        AppMethodBeat.o(156133);
        return decodeStream;
    }

    public static DisplayMetrics getDefaultDisplayMetrics() {
        AppMethodBeat.i(156134);
        if (metrics == null) {
            metrics = MMApplicationContext.getContext().getResources().getDisplayMetrics();
        }
        DisplayMetrics displayMetrics = metrics;
        AppMethodBeat.o(156134);
        return displayMetrics;
    }

    private static Bitmap getBitmapNative(int i2, String str, byte[] bArr, Uri uri, boolean z, float f2, int i3, int i4) {
        AppMethodBeat.i(156135);
        Bitmap bitmapNative = getBitmapNative(i2, str, bArr, uri, null, z, f2, i3, i4);
        AppMethodBeat.o(156135);
        return bitmapNative;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003f A[Catch:{ Throwable -> 0x010c }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0048 A[Catch:{ Throwable -> 0x010c }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d3 A[Catch:{ all -> 0x0101 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap getBitmapNative(int r12, java.lang.String r13, byte[] r14, android.net.Uri r15, java.io.InputStream r16, boolean r17, float r18, int r19, int r20) {
        /*
        // Method dump skipped, instructions count: 279
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.BitmapUtil.getBitmapNative(int, java.lang.String, byte[], android.net.Uri, java.io.InputStream, boolean, float, int, int):android.graphics.Bitmap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0092 A[SYNTHETIC, Splitter:B:39:0x0092] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap decodeBitmap(android.graphics.BitmapFactory.Options r4, byte[] r5, java.lang.String r6, android.net.Uri r7, java.io.InputStream r8, boolean r9, int r10) {
        /*
        // Method dump skipped, instructions count: 168
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.BitmapUtil.decodeBitmap(android.graphics.BitmapFactory$Options, byte[], java.lang.String, android.net.Uri, java.io.InputStream, boolean, int):android.graphics.Bitmap");
    }

    public static void bindlowMemeryOption(BitmapFactory.Options options) {
    }

    public static Bitmap decodeByteArrayDisplayMetrics(byte[] bArr) {
        AppMethodBeat.i(215321);
        DisplayMetrics defaultDisplayMetrics = getDefaultDisplayMetrics();
        Bitmap decodeByteArray = decodeByteArray(bArr, defaultDisplayMetrics.widthPixels, defaultDisplayMetrics.heightPixels);
        AppMethodBeat.o(215321);
        return decodeByteArray;
    }

    @TargetApi(11)
    public static Bitmap extractThumbNailFromStream(InputStream inputStream, BitmapFactory.Options options, int i2, int i3, int i4, int i5, boolean z) {
        double d2;
        int ceil;
        int i6;
        int i7;
        AppMethodBeat.i(215322);
        if (i4 <= 0 || i5 <= 0) {
            Log.e(TAG, "extractThumbNail height:" + i5 + " width:" + i4);
            AppMethodBeat.o(215322);
            return null;
        } else if (i2 <= 0 || i3 <= 0) {
            Log.e(TAG, "decode[%s] error, outHeight[%d] outWidth[%d]", inputStream, Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(215322);
            return null;
        } else {
            try {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                if (Build.VERSION.SDK_INT > 26 && options != null && (options.outColorSpace == ColorSpace.get(ColorSpace.Named.DCI_P3) || options.outColorSpace == ColorSpace.get(ColorSpace.Named.DISPLAY_P3))) {
                    options2.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                }
                Log.i(TAG, "extractThumbNail: round=" + i4 + "x" + i5 + ", crop=" + z);
                double d3 = (((double) i3) * 1.0d) / ((double) i5);
                double d4 = (((double) i2) * 1.0d) / ((double) i4);
                Log.d(TAG, "extractThumbNail: extract beX = " + d4 + ", beY = " + d3);
                if (z) {
                    d2 = d3 > d4 ? d4 : d3;
                } else {
                    d2 = d3 < d4 ? d4 : d3;
                }
                options2.inSampleSize = (int) d2;
                if (options2.inSampleSize <= 1) {
                    options2.inSampleSize = 1;
                }
                while (((i3 * i2) / options2.inSampleSize) / options2.inSampleSize > 2764800) {
                    options2.inSampleSize++;
                }
                if (z) {
                    if (d3 > d4) {
                        i6 = (int) Math.ceil(((((double) i4) * 1.0d) * ((double) i3)) / ((double) i2));
                        ceil = i4;
                    } else {
                        ceil = (int) Math.ceil(((((double) i5) * 1.0d) * ((double) i2)) / ((double) i3));
                        i6 = i5;
                    }
                } else if (d3 < d4) {
                    i6 = (int) Math.ceil(((((double) i4) * 1.0d) * ((double) i3)) / ((double) i2));
                    ceil = i4;
                } else {
                    ceil = (int) Math.ceil(((((double) i5) * 1.0d) * ((double) i2)) / ((double) i3));
                    i6 = i5;
                }
                int i8 = i6 > 0 ? i6 : 1;
                if (ceil > 0) {
                    i7 = ceil;
                } else {
                    i7 = 1;
                }
                if (Build.VERSION.SDK_INT >= 11) {
                    options2.inMutable = true;
                }
                Log.i(TAG, "bitmap required size=" + i7 + "x" + i8 + ", orig=" + i2 + "x" + i3 + ", sample=" + options2.inSampleSize);
                bindlowMemeryOption(options2);
                Bitmap decodeStream = MMBitmapFactory.decodeStream(inputStream, null, options2);
                if (decodeStream == null) {
                    Log.e(TAG, "bitmap decode failed");
                    AppMethodBeat.o(215322);
                    return null;
                }
                Log.d(TAG, "bitmap decoded size=" + decodeStream.getWidth() + "x" + decodeStream.getHeight());
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, i7, i8, true);
                if (decodeStream == createScaledBitmap || createScaledBitmap == null) {
                    createScaledBitmap = decodeStream;
                } else {
                    Log.i(TAG, "extractThumbNail bitmap recycle adsfad. %s", decodeStream);
                    decodeStream.recycle();
                }
                if (z) {
                    if (createScaledBitmap.getWidth() < i4) {
                        Log.e(TAG, "bmw < width %d %d", Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(i4));
                        i4 = createScaledBitmap.getWidth();
                    }
                    if (createScaledBitmap.getHeight() < i5) {
                        Log.e(TAG, "bmh < height %d %d", Integer.valueOf(createScaledBitmap.getHeight()), Integer.valueOf(i5));
                        i5 = createScaledBitmap.getHeight();
                    }
                    int width = (createScaledBitmap.getWidth() - i4) >> 1;
                    int height = (createScaledBitmap.getHeight() - i5) >> 1;
                    if (width < 0 || height < 0) {
                        Log.e(TAG, "fix crop image error %d %d %d %d", Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(createScaledBitmap.getHeight()), Integer.valueOf(i4), Integer.valueOf(i5));
                        if (width < 0) {
                            width = 0;
                        }
                        if (height < 0) {
                            height = 0;
                        }
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap, width, height, i4, i5);
                    if (createBitmap == null) {
                        AppMethodBeat.o(215322);
                        return createScaledBitmap;
                    }
                    if (createBitmap != createScaledBitmap) {
                        Log.i(TAG, "extractThumbNail bitmap recycle adsfaasdfad. %s", createScaledBitmap);
                        createScaledBitmap.recycle();
                        createScaledBitmap = createBitmap;
                    }
                    Log.d(TAG, "bitmap croped size=" + createScaledBitmap.getWidth() + "x" + createScaledBitmap.getHeight());
                }
                setBitmapDensity(createScaledBitmap);
                Bitmap trace = BitmapTracer.trace(createScaledBitmap);
                AppMethodBeat.o(215322);
                return trace;
            } catch (OutOfMemoryError e2) {
                Log.e(TAG, "decode bitmap failed: " + e2.getMessage());
                AppMethodBeat.o(215322);
                return null;
            }
        }
    }

    @TargetApi(11)
    public static Bitmap extractThumbNailFromStream(InputStream inputStream, int i2, int i3, boolean z) {
        double d2;
        int ceil;
        int i4;
        int i5;
        AppMethodBeat.i(215323);
        if (i3 <= 0 || i2 <= 0) {
            Log.e(TAG, "extractThumbNail height:" + i3 + " width:" + i2);
            AppMethodBeat.o(215323);
            return null;
        }
        if (!inputStream.markSupported()) {
            if (inputStream instanceof FileInputStream) {
                inputStream = new FileSeekingInputStream((FileInputStream) inputStream);
            } else if (!inputStream.markSupported()) {
                inputStream = new BufferedInputStream(inputStream);
            }
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {
            options.inJustDecodeBounds = true;
            inputStream.mark(8388608);
            Bitmap decodeStream = MMBitmapFactory.decodeStream(inputStream, null, options);
            inputStream.reset();
            if (decodeStream != null) {
                Log.i(TAG, "extractThumeNail bitmap recycle, adsf. %s", decodeStream);
                decodeStream.recycle();
            }
            if (options.outHeight <= 0 || options.outWidth <= 0) {
                Log.e(TAG, "decode[%s] error, outHeight[%d] outWidth[%d]", inputStream, Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
                AppMethodBeat.o(215323);
                return null;
            }
            Log.i(TAG, "extractThumbNail: round=" + i2 + "x" + i3 + ", crop=" + z);
            double d3 = (((double) options.outHeight) * 1.0d) / ((double) i3);
            double d4 = (((double) options.outWidth) * 1.0d) / ((double) i2);
            Log.d(TAG, "extractThumbNail: extract beX = " + d4 + ", beY = " + d3);
            if (z) {
                d2 = d3 > d4 ? d4 : d3;
            } else {
                d2 = d3 < d4 ? d4 : d3;
            }
            options.inSampleSize = (int) d2;
            if (options.inSampleSize <= 1) {
                options.inSampleSize = 1;
            }
            while (((options.outHeight * options.outWidth) / options.inSampleSize) / options.inSampleSize > 2764800) {
                options.inSampleSize++;
            }
            if (z) {
                if (d3 > d4) {
                    i4 = (int) Math.ceil(((((double) i2) * 1.0d) * ((double) options.outHeight)) / ((double) options.outWidth));
                    ceil = i2;
                } else {
                    ceil = (int) Math.ceil(((((double) i3) * 1.0d) * ((double) options.outWidth)) / ((double) options.outHeight));
                    i4 = i3;
                }
            } else if (d3 < d4) {
                i4 = (int) Math.ceil(((((double) i2) * 1.0d) * ((double) options.outHeight)) / ((double) options.outWidth));
                ceil = i2;
            } else {
                ceil = (int) Math.ceil(((((double) i3) * 1.0d) * ((double) options.outWidth)) / ((double) options.outHeight));
                i4 = i3;
            }
            int i6 = i4 > 0 ? i4 : 1;
            if (ceil > 0) {
                i5 = ceil;
            } else {
                i5 = 1;
            }
            options.inJustDecodeBounds = false;
            if (Build.VERSION.SDK_INT >= 11) {
                options.inMutable = true;
            }
            Log.i(TAG, "bitmap required size=" + i5 + "x" + i6 + ", orig=" + options.outWidth + "x" + options.outHeight + ", sample=" + options.inSampleSize);
            bindlowMemeryOption(options);
            Bitmap decodeStream2 = MMBitmapFactory.decodeStream(inputStream, null, options);
            if (decodeStream2 == null) {
                Log.e(TAG, "bitmap decode failed");
                AppMethodBeat.o(215323);
                return null;
            }
            Log.d(TAG, "bitmap decoded size=" + decodeStream2.getWidth() + "x" + decodeStream2.getHeight());
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream2, i5, i6, true);
            if (decodeStream2 == createScaledBitmap || createScaledBitmap == null) {
                createScaledBitmap = decodeStream2;
            } else {
                Log.i(TAG, "extractThumbNail bitmap recycle adsfad. %s", decodeStream2);
                decodeStream2.recycle();
            }
            if (z) {
                if (createScaledBitmap.getWidth() < i2) {
                    Log.e(TAG, "bmw < width %d %d", Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(i2));
                    i2 = createScaledBitmap.getWidth();
                }
                if (createScaledBitmap.getHeight() < i3) {
                    Log.e(TAG, "bmh < height %d %d", Integer.valueOf(createScaledBitmap.getHeight()), Integer.valueOf(i3));
                    i3 = createScaledBitmap.getHeight();
                }
                int width = (createScaledBitmap.getWidth() - i2) >> 1;
                int height = (createScaledBitmap.getHeight() - i3) >> 1;
                if (width < 0 || height < 0) {
                    Log.e(TAG, "fix crop image error %d %d %d %d", Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(createScaledBitmap.getHeight()), Integer.valueOf(i2), Integer.valueOf(i3));
                    if (width < 0) {
                        width = 0;
                    }
                    if (height < 0) {
                        height = 0;
                    }
                }
                Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap, width, height, i2, i3);
                if (createBitmap == null) {
                    AppMethodBeat.o(215323);
                    return createScaledBitmap;
                }
                if (createBitmap != createScaledBitmap) {
                    Log.i(TAG, "extractThumbNail bitmap recycle adsfaasdfad. %s", createScaledBitmap);
                    createScaledBitmap.recycle();
                    createScaledBitmap = createBitmap;
                }
                Log.d(TAG, "bitmap croped size=" + createScaledBitmap.getWidth() + "x" + createScaledBitmap.getHeight());
            }
            setBitmapDensity(createScaledBitmap);
            Bitmap trace = BitmapTracer.trace(createScaledBitmap);
            AppMethodBeat.o(215323);
            return trace;
        } catch (OutOfMemoryError e2) {
            Log.e(TAG, "decode bitmap failed: " + e2.getMessage());
            AppMethodBeat.o(215323);
            return null;
        } catch (IOException e3) {
            Log.printErrStackTrace(TAG, e3, "Failed decode bitmap", new Object[0]);
            AppMethodBeat.o(215323);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049 A[SYNTHETIC, Splitter:B:17:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056 A[SYNTHETIC, Splitter:B:23:0x0056] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap extractThumbNail(java.lang.String r9, int r10, int r11, boolean r12) {
        /*
        // Method dump skipped, instructions count: 108
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.BitmapUtil.extractThumbNail(java.lang.String, int, int, boolean):android.graphics.Bitmap");
    }

    public static Bitmap extractThumbNail(Bitmap bitmap, int i2, int i3, boolean z, boolean z2) {
        Throwable th;
        double d2;
        int ceil;
        int i4;
        Bitmap bitmap2;
        AppMethodBeat.i(156140);
        if (bitmap == null) {
            Log.e(TAG, "extractThumbNail bitmap is null.");
            AppMethodBeat.o(156140);
            return null;
        } else if (i2 <= 0 || i3 <= 0) {
            try {
                Log.e(TAG, "extractThumbNail height:" + i2 + " width:" + i3);
                setBitmapDensity(bitmap);
                AppMethodBeat.o(156140);
                return null;
            } catch (Throwable th2) {
                th = th2;
                setBitmapDensity(bitmap);
                AppMethodBeat.o(156140);
                throw th;
            }
        } else {
            BitmapFactory.Options options = new BitmapFactory.Options();
            bindlowMemeryOption(options);
            options.outHeight = bitmap.getHeight();
            options.outWidth = bitmap.getWidth();
            Log.i(TAG, "extractThumbNail: round=" + i3 + "x" + i2 + ", crop=" + z + ", recycle=" + z2);
            double d3 = (((double) options.outHeight) * 1.0d) / ((double) i2);
            double d4 = (((double) options.outWidth) * 1.0d) / ((double) i3);
            Log.d(TAG, "extractThumbNail: extract beX = " + d4 + ", beY = " + d3);
            if (z) {
                d2 = d3 > d4 ? d4 : d3;
            } else {
                d2 = d3 < d4 ? d4 : d3;
            }
            options.inSampleSize = (int) d2;
            if (options.inSampleSize <= 1) {
                options.inSampleSize = 1;
            }
            while (((options.outHeight * options.outWidth) / options.inSampleSize) / options.inSampleSize > 2764800) {
                options.inSampleSize++;
            }
            if (z) {
                if (d3 > d4) {
                    i4 = (int) Math.ceil(((((double) i3) * 1.0d) * ((double) options.outHeight)) / ((double) options.outWidth));
                    ceil = i3;
                } else {
                    ceil = (int) Math.ceil(((((double) i2) * 1.0d) * ((double) options.outWidth)) / ((double) options.outHeight));
                    i4 = i2;
                }
            } else if (d3 < d4) {
                i4 = (int) Math.ceil(((((double) i3) * 1.0d) * ((double) options.outHeight)) / ((double) options.outWidth));
                ceil = i3;
            } else {
                ceil = (int) Math.ceil(((((double) i2) * 1.0d) * ((double) options.outWidth)) / ((double) options.outHeight));
                i4 = i2;
            }
            options.inJustDecodeBounds = false;
            Log.i(TAG, "bitmap required size=" + ceil + "x" + i4 + ", orig=" + options.outWidth + "x" + options.outHeight + ", sample=" + options.inSampleSize);
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, ceil, i4, true);
            if (createScaledBitmap == null) {
                createScaledBitmap = bitmap;
            } else if (z2 && bitmap != createScaledBitmap) {
                Log.i(TAG, "extractThumbNail bitmap recycle asdfjasjdfja asdfasd. %s", bitmap);
                bitmap.recycle();
            }
            if (z) {
                try {
                    if (createScaledBitmap.getWidth() < i3) {
                        Log.e(TAG, "bmw < width %d %d", Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(i3));
                        i3 = createScaledBitmap.getWidth();
                    }
                    if (createScaledBitmap.getHeight() < i2) {
                        Log.e(TAG, "bmh < height %d %d", Integer.valueOf(createScaledBitmap.getHeight()), Integer.valueOf(i2));
                        i2 = createScaledBitmap.getHeight();
                    }
                    bitmap2 = Bitmap.createBitmap(createScaledBitmap, (createScaledBitmap.getWidth() - i3) >> 1, (createScaledBitmap.getHeight() - i2) >> 1, i3, i2);
                    if (bitmap2 == null) {
                        setBitmapDensity(createScaledBitmap);
                        AppMethodBeat.o(156140);
                        return createScaledBitmap;
                    }
                    if (z2 && createScaledBitmap != bitmap2) {
                        Log.i(TAG, "extractThumbNail bitmap recycle ajdfjajsdfjdsajjfsad. %s", createScaledBitmap);
                        createScaledBitmap.recycle();
                    }
                    try {
                        Log.d(TAG, "bitmap croped size=" + bitmap2.getWidth() + "x" + bitmap2.getHeight());
                    } catch (Throwable th3) {
                        th = th3;
                        bitmap = bitmap2;
                        setBitmapDensity(bitmap);
                        AppMethodBeat.o(156140);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bitmap = createScaledBitmap;
                    setBitmapDensity(bitmap);
                    AppMethodBeat.o(156140);
                    throw th;
                }
            } else {
                bitmap2 = createScaledBitmap;
            }
            setBitmapDensity(bitmap2);
            AppMethodBeat.o(156140);
            return bitmap2;
        }
    }

    public static Bitmap extractThumbNailAssets(String str, int i2, int i3) {
        AppMethodBeat.i(156141);
        Bitmap bitmapNative = getBitmapNative(0, str, null, null, true, 0.0f, i2, i3);
        AppMethodBeat.o(156141);
        return bitmapNative;
    }

    public static Bitmap extractThumbNailAssets(InputStream inputStream, int i2, int i3) {
        AppMethodBeat.i(215324);
        Bitmap bitmapNative = getBitmapNative(0, null, null, null, inputStream, true, 0.0f, i2, i3);
        AppMethodBeat.o(215324);
        return bitmapNative;
    }

    public static Bitmap rotateAndScale(Bitmap bitmap, float f2, float f3, float f4) {
        AppMethodBeat.i(156142);
        if (bitmap == null) {
            AppMethodBeat.o(156142);
            return null;
        } else if (f2 != 0.0f || ((double) f3) <= 0.999d || ((double) f3) >= 1.001d || ((double) f4) <= 0.999d || ((double) f4) >= 1.001d) {
            Matrix matrix = new Matrix();
            matrix.reset();
            if (f2 != 0.0f) {
                matrix.setRotate(f2, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
            }
            if (((double) f3) < 0.999d || ((double) f3) > 1.001d || ((double) f4) < 0.999d || ((double) f4) > 1.001d) {
                matrix.postScale(f3, f4);
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            setBitmapDensity(createBitmap);
            Log.d(TAG, "resultBmp is null: " + (createBitmap == null) + "  degree:" + f2);
            if (bitmap != createBitmap) {
                Log.i(TAG, "rotateAndScale bitmap recycle asdfasdjfjasdfjsadfjdsa. %s", bitmap);
                bitmap.recycle();
            }
            Bitmap trace = BitmapTracer.trace(createBitmap);
            AppMethodBeat.o(156142);
            return trace;
        } else {
            AppMethodBeat.o(156142);
            return bitmap;
        }
    }

    public static Bitmap rotate(Bitmap bitmap, float f2) {
        Throwable th;
        boolean z;
        AppMethodBeat.i(156143);
        if (bitmap == null || f2 % 360.0f == 0.0f) {
            AppMethodBeat.o(156143);
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(f2, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            try {
                setBitmapDensity(createBitmap);
                StringBuilder sb = new StringBuilder("resultBmp is null: ");
                if (createBitmap == null) {
                    z = true;
                } else {
                    z = false;
                }
                Log.d(TAG, sb.append(z).append("  degree:").append(f2).toString());
                if (bitmap != createBitmap) {
                    Log.i(TAG, "rotate bitmap recycle ajsdfasdf adsf. %s", bitmap);
                    bitmap.recycle();
                }
                Bitmap trace = BitmapTracer.trace(createBitmap);
                AppMethodBeat.o(156143);
                return trace;
            } catch (Throwable th2) {
                th = th2;
                bitmap = createBitmap;
                Log.d(TAG, "createBitmap failed : %s ", Util.stackTraceToString(th));
                AppMethodBeat.o(156143);
                return bitmap;
            }
        } catch (Throwable th3) {
            th = th3;
            Log.d(TAG, "createBitmap failed : %s ", Util.stackTraceToString(th));
            AppMethodBeat.o(156143);
            return bitmap;
        }
    }

    public static boolean rotate(String str, int i2, Bitmap.CompressFormat compressFormat, int i3, String str2) {
        AppMethodBeat.i(156144);
        Bitmap bitmapNative = getBitmapNative(str);
        if (bitmapNative == null) {
            Log.e(TAG, "rotate: create bitmap fialed");
            AppMethodBeat.o(156144);
            return false;
        }
        float width = (float) bitmapNative.getWidth();
        float height = (float) bitmapNative.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i2, width / 2.0f, height / 2.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmapNative, 0, 0, (int) width, (int) height, matrix, true);
        if (bitmapNative != createBitmap) {
            Log.i(TAG, "rotate bitmap recycle adjfjads fadsj fsadjf dsa. %s", bitmapNative.toString());
            bitmapNative.recycle();
        }
        try {
            saveBitmapToImage(createBitmap, i3, compressFormat, str2, true);
            AppMethodBeat.o(156144);
            return true;
        } catch (IOException e2) {
            Log.printErrStackTrace(TAG, e2, "create %s from orig failed: ".concat(String.valueOf(str2)), new Object[0]);
            AppMethodBeat.o(156144);
            return false;
        }
    }

    public static Bitmap rotate(Bitmap bitmap, float f2, boolean z) {
        Throwable th;
        boolean z2;
        AppMethodBeat.i(215325);
        if (bitmap == null || f2 % 360.0f == 0.0f) {
            AppMethodBeat.o(215325);
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(f2, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            try {
                setBitmapDensity(createBitmap);
                StringBuilder sb = new StringBuilder("resultBmp is null: ");
                if (createBitmap == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Log.d(TAG, sb.append(z2).append("  degree:").append(f2).toString());
                if (z && bitmap != createBitmap) {
                    Log.i(TAG, "rotate bitmap recycle ajsdfasdf adsf. %s", bitmap);
                    bitmap.recycle();
                }
                Bitmap trace = BitmapTracer.trace(createBitmap);
                AppMethodBeat.o(215325);
                return trace;
            } catch (Throwable th2) {
                th = th2;
                bitmap = createBitmap;
                Log.d(TAG, "createBitmap failed : %s ", Util.stackTraceToString(th));
                AppMethodBeat.o(215325);
                return bitmap;
            }
        } catch (Throwable th3) {
            th = th3;
            Log.d(TAG, "createBitmap failed : %s ", Util.stackTraceToString(th));
            AppMethodBeat.o(215325);
            return bitmap;
        }
    }

    public static boolean rotate(String str, int i2, Bitmap.CompressFormat compressFormat, int i3, String str2, String str3) {
        AppMethodBeat.i(215326);
        boolean rotate = rotate(str, i2, compressFormat, i3, str2 + str3);
        AppMethodBeat.o(215326);
        return rotate;
    }

    public static boolean saveBitmapToStream(Bitmap bitmap, int i2, Bitmap.CompressFormat compressFormat, OutputStream outputStream, boolean z) {
        AppMethodBeat.i(169235);
        boolean compress = compress(bitmap, compressFormat, i2, outputStream);
        if (z) {
            Log.i(TAG, "saveBitmapToStream bitmap recycle. %s", bitmap);
            bitmap.recycle();
        }
        AppMethodBeat.o(169235);
        return compress;
    }

    public static boolean saveBitmapToImage(Bitmap bitmap, int i2, Bitmap.CompressFormat compressFormat, String str, boolean z) {
        AppMethodBeat.i(169236);
        if (Util.isNullOrNil(str)) {
            IOException iOException = new IOException("saveBitmapToImage pathName null or nil");
            AppMethodBeat.o(169236);
            throw iOException;
        }
        Log.i(TAG, "saving to ".concat(String.valueOf(str)));
        OutputStream outputStream = null;
        s.boN(s.boZ(str));
        try {
            outputStream = s.dw(str, false);
            boolean saveBitmapToStream = saveBitmapToStream(bitmap, i2, compressFormat, outputStream, z);
            if (z) {
                Log.i(TAG, "bitmap recycle %s", bitmap.toString());
                bitmap.recycle();
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.o(169236);
            return saveBitmapToStream;
        } catch (Exception e3) {
            Log.printErrStackTrace(TAG, e3, "saveBitmapToImage failed: %s", str);
            IOException iOException2 = new IOException(e3);
            AppMethodBeat.o(169236);
            throw iOException2;
        } catch (Throwable th) {
            if (z) {
                Log.i(TAG, "bitmap recycle %s", bitmap.toString());
                bitmap.recycle();
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                }
            }
            AppMethodBeat.o(169236);
            throw th;
        }
    }

    public static Bitmap getBitmapFromRect(Bitmap bitmap, Rect rect, boolean z) {
        AppMethodBeat.i(215327);
        if (bitmap == null) {
            AppMethodBeat.o(215327);
            return null;
        }
        setBitmapDensity(bitmap);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, rect.width(), rect.height(), (Matrix) null, false);
            if (z) {
                Log.i(TAG, "getBitmapFromRect bitmap recycle %s", bitmap);
                bitmap.recycle();
            }
            setBitmapDensity(createBitmap);
            Bitmap trace = BitmapTracer.trace(createBitmap);
            AppMethodBeat.o(215327);
            return trace;
        } catch (Throwable th) {
            Log.printErrStackTrace(TAG, th, "getBitmapFromRect exception", new Object[0]);
            AppMethodBeat.o(215327);
            return null;
        }
    }

    public static Bitmap getBitmapFromRectFixed(Bitmap bitmap, Rect rect, boolean z) {
        AppMethodBeat.i(261882);
        if (bitmap == null) {
            AppMethodBeat.o(261882);
            return null;
        }
        setBitmapDensity(bitmap);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height(), (Matrix) null, false);
            if (z) {
                Log.i(TAG, "getBitmapFromRect bitmap recycle %s", bitmap);
                bitmap.recycle();
            }
            setBitmapDensity(createBitmap);
            Bitmap trace = BitmapTracer.trace(createBitmap);
            AppMethodBeat.o(261882);
            return trace;
        } catch (Throwable th) {
            Log.printErrStackTrace(TAG, th, "getBitmapFromRect exception", new Object[0]);
            AppMethodBeat.o(261882);
            return null;
        }
    }

    public static Bitmap getCenterCropBitmap(Bitmap bitmap, int i2, int i3, boolean z) {
        Bitmap createBitmap;
        AppMethodBeat.i(156148);
        if (bitmap == null) {
            AppMethodBeat.o(156148);
            return null;
        }
        setBitmapDensity(bitmap);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float max = Math.max(((float) i2) / ((float) width), ((float) i3) / ((float) height));
        float f2 = ((float) width) * max;
        float f3 = ((float) height) * max;
        float f4 = (((float) i2) - f2) / 2.0f;
        float f5 = (((float) i3) - f3) / 2.0f;
        RectF rectF = new RectF(f4, f5, f2 + f4, f3 + f5);
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            Log.w(TAG, "get center crop bitmap, config is null");
            config = Bitmap.Config.ARGB_8888;
        }
        try {
            createBitmap = Bitmap.createBitmap(i2, i3, config);
        } catch (Throwable th) {
            Log.e(TAG, "BitmapUtil decode getCenterCropBitmap fail");
            AppMethodBeat.o(156148);
            return bitmap;
        }
        new Canvas(createBitmap).drawBitmap(bitmap, (Rect) null, rectF, (Paint) null);
        if (z) {
            Log.i(TAG, "getCenterCropBitmap bitmap recycle %s", bitmap);
            bitmap.recycle();
        }
        setBitmapDensity(createBitmap);
        Bitmap trace = BitmapTracer.trace(createBitmap);
        AppMethodBeat.o(156148);
        return trace;
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, boolean z, float f2, boolean z2) {
        AppMethodBeat.i(156149);
        Bitmap roundedCornerBitmap = getRoundedCornerBitmap(bitmap, z, f2, z2, null);
        AppMethodBeat.o(156149);
        return roundedCornerBitmap;
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, boolean z, float f2, boolean z2, int[] iArr) {
        AppMethodBeat.i(215328);
        if (bitmap == null || bitmap.isRecycled()) {
            Log.e(TAG, "getRoundedCornerBitmap in bitmap is null");
            AppMethodBeat.o(215328);
            return null;
        }
        setBitmapDensity(bitmap);
        if (iArr == null) {
            iArr = new int[]{bitmap.getWidth(), bitmap.getHeight()};
        }
        Bitmap createBitmap = createBitmap(iArr[0], iArr[1], Bitmap.Config.ARGB_8888, z2);
        if (createBitmap == null) {
            AppMethodBeat.o(215328);
            return null;
        }
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Rect rect2 = new Rect(0, 0, createBitmap.getWidth(), createBitmap.getHeight());
        RectF rectF = new RectF(rect2);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-4144960);
        canvas.drawRoundRect(rectF, f2, f2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        if (z) {
            Log.i(TAG, "getRoundedCornerBitmap bitmap recycle %s", bitmap);
            bitmap.recycle();
        }
        setBitmapDensity(createBitmap);
        Bitmap trace = BitmapTracer.trace(createBitmap);
        AppMethodBeat.o(215328);
        return trace;
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, boolean z, float f2) {
        AppMethodBeat.i(156150);
        Bitmap roundedCornerBitmap = getRoundedCornerBitmap(bitmap, z, f2, false, null);
        AppMethodBeat.o(156150);
        return roundedCornerBitmap;
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, boolean z, float f2, int[] iArr) {
        AppMethodBeat.i(215329);
        Bitmap roundedCornerBitmap = getRoundedCornerBitmap(bitmap, z, f2, false, iArr);
        AppMethodBeat.o(215329);
        return roundedCornerBitmap;
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, boolean z, float[] fArr, boolean z2) {
        AppMethodBeat.i(215330);
        if (bitmap == null || bitmap.isRecycled()) {
            Log.e(TAG, "getRoundedCornerBitmap in bitmap is null");
            AppMethodBeat.o(215330);
            return null;
        } else if (fArr == null || fArr.length != 4) {
            Log.e(TAG, "getRoundedCornerBitmap roundPxArray invalid");
            AppMethodBeat.o(215330);
            return null;
        } else {
            setBitmapDensity(bitmap);
            Bitmap createBitmap = createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888, z2);
            if (createBitmap == null) {
                AppMethodBeat.o(215330);
                return null;
            }
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            RectF rectF = new RectF(rect);
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setFilterBitmap(true);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-4144960);
            canvas.drawPath(createRoundedRectPath(rectF, fArr[0], fArr[1], fArr[2], fArr[3]), paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
            if (z) {
                Log.i(TAG, "getRoundedCornerBitmap bitmap recycle %s", bitmap);
                bitmap.recycle();
            }
            setBitmapDensity(createBitmap);
            Bitmap trace = BitmapTracer.trace(createBitmap);
            AppMethodBeat.o(215330);
            return trace;
        }
    }

    public static Path createRoundedRectPath(RectF rectF, float f2, float f3, float f4, float f5) {
        AppMethodBeat.i(215331);
        Path path = new Path();
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        path.moveTo(rectF.left + f2, rectF.top);
        path.lineTo(rectF.right - f3, rectF.top);
        path.quadTo(rectF.right, rectF.top, rectF.right, rectF.top + f3);
        path.lineTo(rectF.right, rectF.bottom - f4);
        path.quadTo(rectF.right, rectF.bottom, rectF.right - f4, rectF.bottom);
        path.lineTo(rectF.left + f5, rectF.bottom);
        path.quadTo(rectF.left, rectF.bottom, rectF.left, rectF.bottom - f5);
        path.lineTo(rectF.left, rectF.top + f2);
        path.quadTo(rectF.left, rectF.top, rectF.left + f2, rectF.top);
        path.close();
        AppMethodBeat.o(215331);
        return path;
    }

    public static Bitmap transformDrawableToBitmap(Drawable drawable) {
        AppMethodBeat.i(156152);
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            AppMethodBeat.o(156152);
            return bitmap;
        }
        Bitmap createBitmap = createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        setBitmapDensity(createBitmap);
        Bitmap trace = BitmapTracer.trace(createBitmap);
        AppMethodBeat.o(156152);
        return trace;
    }

    public static Bitmap extractDrawableThumbNail(Drawable drawable, int i2, int i3, boolean z, boolean z2) {
        AppMethodBeat.i(215332);
        Bitmap extractThumbNail = extractThumbNail(transformDrawableToBitmap(drawable), i2, i3, z, z2);
        AppMethodBeat.o(215332);
        return extractThumbNail;
    }

    public static byte[] Bitmap2Bytes(Bitmap bitmap) {
        AppMethodBeat.i(156153);
        byte[] Bitmap2Bytes = Bitmap2Bytes(bitmap, 100);
        AppMethodBeat.o(156153);
        return Bitmap2Bytes;
    }

    public static byte[] Bitmap2Bytes(Bitmap bitmap, int i2) {
        AppMethodBeat.i(156154);
        if (bitmap == null || bitmap.isRecycled()) {
            byte[] bArr = new byte[0];
            AppMethodBeat.o(156154);
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        compress(bitmap, Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        AppMethodBeat.o(156154);
        return byteArray;
    }

    public static byte[] Bitmap2PngBytes(Bitmap bitmap) {
        AppMethodBeat.i(156155);
        if (bitmap == null || bitmap.isRecycled()) {
            byte[] bArr = new byte[0];
            AppMethodBeat.o(156155);
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        compress(bitmap, Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        AppMethodBeat.o(156155);
        return byteArray;
    }

    public static void setAllDrawingCacheEnable(View view, boolean z) {
        AppMethodBeat.i(215333);
        if (view == null) {
            AppMethodBeat.o(215333);
            return;
        }
        view.setDrawingCacheEnabled(z);
        if (view instanceof ViewGroup) {
            int childCount = ((ViewGroup) view).getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                setAllDrawingCacheEnable(((ViewGroup) view).getChildAt(i2), z);
            }
        }
        AppMethodBeat.o(215333);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050 A[SYNTHETIC, Splitter:B:18:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0066 A[SYNTHETIC, Splitter:B:25:0x0066] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void getRent(java.lang.String r9, com.tencent.mm.pointers.PInt r10, com.tencent.mm.pointers.PInt r11) {
        /*
        // Method dump skipped, instructions count: 128
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.BitmapUtil.getRent(java.lang.String, com.tencent.mm.pointers.PInt, com.tencent.mm.pointers.PInt):void");
    }

    public static Bitmap getBitmapFromView(View view) {
        AppMethodBeat.i(156157);
        if (view == null) {
            AppMethodBeat.o(156157);
            return null;
        } else if (view.getWidth() == 0 || view.getHeight() == 0) {
            AppMethodBeat.o(156157);
            return null;
        } else {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Drawable background = view.getBackground();
            if (background != null) {
                background.draw(canvas);
            }
            view.draw(canvas);
            setBitmapDensity(createBitmap);
            Bitmap trace = BitmapTracer.trace(createBitmap);
            AppMethodBeat.o(156157);
            return trace;
        }
    }

    public static Bitmap createChattingImage(Bitmap bitmap, int i2) {
        AppMethodBeat.i(156161);
        Log.d(TAG, "begin createChattingImage");
        long currentTimeMillis = System.currentTimeMillis();
        if (bitmap == null) {
            Log.w(TAG, "sourceBitmap is null .");
            AppMethodBeat.o(156161);
            return null;
        }
        setBitmapDensity(bitmap);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            Log.w(TAG, "sourceBitmap width or height is 0.");
            AppMethodBeat.o(156161);
            return null;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        try {
            Bitmap createBitmap = createBitmap(width, height, Bitmap.Config.ARGB_8888);
            NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) MMApplicationContext.getContext().getResources().getDrawable(i2);
            ninePatchDrawable.setBounds(0, 0, width, height);
            ninePatchDrawable.draw(new Canvas(createBitmap));
            Log.d(TAG, "create nine patch bitmap " + (System.currentTimeMillis() - currentTimeMillis2));
            if (createBitmap == null) {
                Log.e(TAG, "[createChattingImage] maskBitmap is null.");
                AppMethodBeat.o(156161);
                return null;
            }
            int width2 = createBitmap.getWidth();
            int height2 = createBitmap.getHeight();
            if (width2 <= 0 || height2 <= 0) {
                Log.w(TAG, "maskBitmap width or height is 0.");
                AppMethodBeat.o(156161);
                return null;
            } else if (height2 == height && width2 == width) {
                int[] iArr = new int[(width * height)];
                int[] iArr2 = new int[(width2 * height2)];
                bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
                createBitmap.getPixels(iArr2, 0, width, 0, 0, width, height);
                long currentTimeMillis3 = System.currentTimeMillis();
                for (int i3 = 0; i3 < iArr2.length; i3++) {
                    try {
                        if (iArr2[i3] != -16777216) {
                            if (iArr2[i3] == 0) {
                                iArr[i3] = 0;
                            } else if (iArr2[i3] != -1) {
                                iArr[i3] = iArr[i3] & iArr2[i3];
                            }
                        }
                    } catch (Exception e2) {
                        Log.e(TAG, e2.toString());
                    }
                }
                Log.d(TAG, "meger pixels  " + (System.currentTimeMillis() - currentTimeMillis3));
                long currentTimeMillis4 = System.currentTimeMillis();
                createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
                Log.d(TAG, "setPixels " + (System.currentTimeMillis() - currentTimeMillis4));
                Log.d(TAG, "createTime" + (System.currentTimeMillis() - currentTimeMillis));
                setBitmapDensity(createBitmap);
                Bitmap trace = BitmapTracer.trace(createBitmap);
                AppMethodBeat.o(156161);
                return trace;
            } else {
                Log.e(TAG, "maskHeiht maskWidth != height width.");
                AppMethodBeat.o(156161);
                return null;
            }
        } catch (Exception e3) {
            Log.e(TAG, "[createChattingImage] create nine pathc bitmap faild.");
            AppMethodBeat.o(156161);
            return null;
        }
    }

    private static void megerPixels(int[] iArr, int[] iArr2, int i2) {
        AppMethodBeat.i(215334);
        try {
            if (iArr[i2] != -16777216) {
                if (iArr[i2] == 0) {
                    iArr2[i2] = 0;
                    AppMethodBeat.o(215334);
                    return;
                } else if (iArr[i2] != -1) {
                    iArr2[i2] = iArr2[i2] & iArr[i2];
                    iArr2[i2] = iArr2[i2] & iArr[i2];
                }
            }
            AppMethodBeat.o(215334);
        } catch (Exception e2) {
            Log.e(TAG, "megerPixels:%s", e2.toString());
            AppMethodBeat.o(215334);
        }
    }

    public static Bitmap createLocation(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(215335);
        if (i2 < 0 || i3 < 0 || i4 < 0 || i5 < 0) {
            Log.w(TAG, "createLocation fail. srcResId or maskResId is null,or width/height <0");
            AppMethodBeat.o(215335);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap trace = BitmapTracer.trace(createBitmap(i4, i5, Bitmap.Config.ARGB_8888));
        setBitmapDensity(trace);
        NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) MMApplicationContext.getContext().getResources().getDrawable(i2);
        ninePatchDrawable.setBounds(0, 0, i4, i5);
        ninePatchDrawable.draw(new Canvas(trace));
        Log.d(TAG, "create nine patch bitmap " + (System.currentTimeMillis() - currentTimeMillis));
        Bitmap createChattingImage = createChattingImage(trace, i3);
        AppMethodBeat.o(215335);
        return createChattingImage;
    }

    public static Bitmap createLocation(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(156163);
        if (str == null || str.equals("") || i2 < 0 || i3 < 0 || i4 < 0) {
            Log.w(TAG, "createLocation fail. srcResId or maskResId is null,or width/height <0");
            AppMethodBeat.o(156163);
            return null;
        }
        Bitmap trace = BitmapTracer.trace(decodeByteArray(s.aW(str, 0, -1)), str);
        if (trace == null || trace.isRecycled()) {
            AppMethodBeat.o(156163);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap trace2 = BitmapTracer.trace(createBitmap(i3, i4, Bitmap.Config.ARGB_8888));
        setBitmapDensity(trace2);
        Canvas canvas = new Canvas(trace2);
        Log.d(TAG, "bm size w %d h %d target w %d h %d", Integer.valueOf(trace.getWidth()), Integer.valueOf(trace.getHeight()), Integer.valueOf(i3), Integer.valueOf(i4));
        canvas.drawBitmap(trace, (Rect) null, new Rect(0, 0, i3, i4), new Paint());
        Log.d(TAG, "create nine patch bitmap " + (System.currentTimeMillis() - currentTimeMillis));
        Bitmap createChattingImage = createChattingImage(trace2, i2);
        AppMethodBeat.o(156163);
        return createChattingImage;
    }

    public static Bitmap createMaskImage(Bitmap bitmap, int i2, int i3, int i4) {
        AppMethodBeat.i(156164);
        if (bitmap == null || i2 < 0 || i3 < 0 || i4 < 0) {
            AppMethodBeat.o(156164);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap trace = BitmapTracer.trace(createBitmap(i3, i4, Bitmap.Config.ARGB_8888));
        Canvas canvas = new Canvas(trace);
        Log.d(TAG, "bm size w %d h %d target w %d h %d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(i3), Integer.valueOf(i4));
        canvas.drawBitmap(bitmap, (Rect) null, new Rect(0, 0, i3, i4), new Paint());
        Log.d(TAG, "create nine patch bitmap " + (System.currentTimeMillis() - currentTimeMillis));
        Bitmap createChattingImage = createChattingImage(trace, i2);
        AppMethodBeat.o(156164);
        return createChattingImage;
    }

    public static Bitmap createLayerBitmap(Bitmap bitmap, Bitmap bitmap2, boolean z) {
        int i2 = 0;
        AppMethodBeat.i(215336);
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(bitmap == null ? 0 : bitmap.getWidth());
        objArr[1] = Integer.valueOf(bitmap == null ? 0 : bitmap.getHeight());
        objArr[2] = Integer.valueOf(bitmap2 == null ? 0 : bitmap2.getWidth());
        if (bitmap2 != null) {
            i2 = bitmap2.getHeight();
        }
        objArr[3] = Integer.valueOf(i2);
        Log.i(TAG, "src(%d,%d) background(%d,%d)", objArr);
        if (bitmap == null || bitmap2 == null) {
            AppMethodBeat.o(215336);
            return null;
        }
        int max = Math.max(bitmap.getWidth(), bitmap2.getWidth());
        int max2 = Math.max(bitmap.getHeight(), bitmap2.getHeight());
        Bitmap trace = BitmapTracer.trace(createBitmap(max, max2, Bitmap.Config.ARGB_8888));
        Canvas canvas = new Canvas(trace);
        canvas.drawBitmap(bitmap2, ((float) (max - bitmap2.getWidth())) / 2.0f, ((float) (max2 - bitmap2.getHeight())) / 2.0f, new Paint());
        canvas.drawBitmap(bitmap, ((float) (max - bitmap.getWidth())) / 2.0f, ((float) (max2 - bitmap.getHeight())) / 2.0f, new Paint());
        if (z) {
            bitmap2.recycle();
            bitmap.recycle();
        }
        AppMethodBeat.o(215336);
        return trace;
    }

    public static Bitmap createShareAppImage(int i2, int i3) {
        AppMethodBeat.i(215337);
        if (i2 < 0 || i3 < 0) {
            Log.w(TAG, "createShareAppImage fail. srcResId or maskResId is null");
            AppMethodBeat.o(215337);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap trace = BitmapTracer.trace(getBitmapNative(i2));
        Log.d(TAG, "create nine patch bitmap " + (System.currentTimeMillis() - currentTimeMillis));
        Bitmap createChattingImage = createChattingImage(trace, i3);
        AppMethodBeat.o(215337);
        return createChattingImage;
    }

    public static Bitmap createBitmapByPixels(int[] iArr, int i2, int i3, Bitmap.Config config) {
        AppMethodBeat.i(156165);
        Bitmap createBitmap = createBitmap(i2, i3, config);
        if (createBitmap != null) {
            if (i2 == createBitmap.getWidth() && i3 == createBitmap.getHeight()) {
                createBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i3);
            } else {
                AppMethodBeat.o(156165);
                return null;
            }
        }
        setBitmapDensity(createBitmap);
        Bitmap trace = BitmapTracer.trace(createBitmap);
        AppMethodBeat.o(156165);
        return trace;
    }

    public static Bitmap fastblur(Bitmap bitmap, int i2) {
        AppMethodBeat.i(156166);
        if (bitmap == null) {
            Log.w(TAG, "fastblur: but sentBitmap is null");
            AppMethodBeat.o(156166);
            return null;
        }
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        if (i2 <= 0) {
            AppMethodBeat.o(156166);
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int[] iArr = new int[(width * height)];
        Log.e("pix", width + " " + height + " " + iArr.length);
        copy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i3 = width - 1;
        int i4 = height - 1;
        int i5 = width * height;
        int i6 = i2 + i2 + 1;
        int[] iArr2 = new int[i5];
        int[] iArr3 = new int[i5];
        int[] iArr4 = new int[i5];
        int[] iArr5 = new int[Math.max(width, height)];
        int i7 = (i6 + 1) >> 1;
        int i8 = i7 * i7;
        int[] iArr6 = new int[(i8 * 256)];
        for (int i9 = 0; i9 < i8 * 256; i9++) {
            iArr6[i9] = i9 / i8;
        }
        int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, i6, 3);
        int i10 = i2 + 1;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < height) {
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            for (int i23 = -i2; i23 <= i2; i23++) {
                int i24 = iArr[Math.min(i3, Math.max(i23, 0)) + i13];
                int[] iArr8 = iArr7[i23 + i2];
                iArr8[0] = (16711680 & i24) >> 16;
                iArr8[1] = (65280 & i24) >> 8;
                iArr8[2] = i24 & 255;
                int abs = i10 - Math.abs(i23);
                i22 += iArr8[0] * abs;
                i20 += iArr8[1] * abs;
                i21 += abs * iArr8[2];
                if (i23 > 0) {
                    i14 += iArr8[0];
                    i15 += iArr8[1];
                    i16 += iArr8[2];
                } else {
                    i17 += iArr8[0];
                    i18 += iArr8[1];
                    i19 += iArr8[2];
                }
            }
            int i25 = 0;
            int i26 = i14;
            int i27 = i15;
            int i28 = i16;
            int i29 = i17;
            int i30 = i18;
            int i31 = i19;
            int i32 = i2;
            while (i25 < width) {
                iArr2[i13] = iArr6[i22];
                iArr3[i13] = iArr6[i20];
                iArr4[i13] = iArr6[i21];
                int i33 = i22 - i29;
                int i34 = i20 - i30;
                int i35 = i21 - i31;
                int[] iArr9 = iArr7[((i32 - i2) + i6) % i6];
                int i36 = i29 - iArr9[0];
                int i37 = i30 - iArr9[1];
                int i38 = i31 - iArr9[2];
                if (i11 == 0) {
                    iArr5[i25] = Math.min(i25 + i2 + 1, i3);
                }
                int i39 = iArr[iArr5[i25] + i12];
                iArr9[0] = (16711680 & i39) >> 16;
                iArr9[1] = (65280 & i39) >> 8;
                iArr9[2] = i39 & 255;
                int i40 = i26 + iArr9[0];
                int i41 = i27 + iArr9[1];
                int i42 = iArr9[2] + i28;
                i22 = i33 + i40;
                i20 = i34 + i41;
                i21 = i35 + i42;
                i32 = (i32 + 1) % i6;
                int[] iArr10 = iArr7[i32 % i6];
                int i43 = i36 + iArr10[0];
                int i44 = i37 + iArr10[1];
                i31 = i38 + iArr10[2];
                int i45 = i42 - iArr10[2];
                i13++;
                i25++;
                i26 = i40 - iArr10[0];
                i27 = i41 - iArr10[1];
                i28 = i45;
                i29 = i43;
                i30 = i44;
            }
            i11++;
            i12 += width;
        }
        for (int i46 = 0; i46 < width; i46++) {
            int i47 = (-i2) * width;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            int i55 = 0;
            int i56 = 0;
            for (int i57 = -i2; i57 <= i2; i57++) {
                int max = Math.max(0, i47) + i46;
                int[] iArr11 = iArr7[i57 + i2];
                iArr11[0] = iArr2[max];
                iArr11[1] = iArr3[max];
                iArr11[2] = iArr4[max];
                int abs2 = i10 - Math.abs(i57);
                i56 += iArr2[max] * abs2;
                i54 += iArr3[max] * abs2;
                i55 += iArr4[max] * abs2;
                if (i57 > 0) {
                    i48 += iArr11[0];
                    i49 += iArr11[1];
                    i50 += iArr11[2];
                } else {
                    i51 += iArr11[0];
                    i52 += iArr11[1];
                    i53 += iArr11[2];
                }
                if (i57 < i4) {
                    i47 += width;
                }
            }
            int i58 = 0;
            int i59 = i48;
            int i60 = i46;
            int i61 = i2;
            while (i58 < height) {
                iArr[i60] = (-16777216 & iArr[i60]) | (iArr6[i56] << 16) | (iArr6[i54] << 8) | iArr6[i55];
                int i62 = i56 - i51;
                int i63 = i54 - i52;
                int i64 = i55 - i53;
                int[] iArr12 = iArr7[((i61 - i2) + i6) % i6];
                int i65 = i51 - iArr12[0];
                int i66 = i52 - iArr12[1];
                int i67 = i53 - iArr12[2];
                if (i46 == 0) {
                    iArr5[i58] = Math.min(i58 + i10, i4) * width;
                }
                int i68 = iArr5[i58] + i46;
                iArr12[0] = iArr2[i68];
                iArr12[1] = iArr3[i68];
                iArr12[2] = iArr4[i68];
                int i69 = i59 + iArr12[0];
                int i70 = i49 + iArr12[1];
                int i71 = i50 + iArr12[2];
                i56 = i62 + i69;
                i54 = i63 + i70;
                i55 = i64 + i71;
                i61 = (i61 + 1) % i6;
                int[] iArr13 = iArr7[i61];
                i51 = i65 + iArr13[0];
                i52 = i66 + iArr13[1];
                i53 = i67 + iArr13[2];
                i59 = i69 - iArr13[0];
                int i72 = i70 - iArr13[1];
                i50 = i71 - iArr13[2];
                i60 += width;
                i58++;
                i49 = i72;
            }
        }
        Log.e("pix", width + " " + height + " " + i5);
        copy.setPixels(iArr, 0, width, 0, 0, width, height);
        setBitmapDensity(copy);
        Bitmap trace = BitmapTracer.trace(copy);
        AppMethodBeat.o(156166);
        return trace;
    }

    public static Bitmap fastBlurBitmap(Bitmap bitmap, float f2, int i2) {
        AppMethodBeat.i(215338);
        Bitmap fastBlurBitmap = fastBlurBitmap(bitmap, f2, i2, false, -1);
        AppMethodBeat.o(215338);
        return fastBlurBitmap;
    }

    public static Bitmap fastBlurBitmap(Bitmap bitmap, float f2, int i2, boolean z, long j2) {
        AppMethodBeat.i(215339);
        long currentTimeMillis = System.currentTimeMillis();
        int round = Math.round(((float) bitmap.getWidth()) * f2);
        int round2 = Math.round(((float) bitmap.getHeight()) * f2);
        if (round <= 10 || round2 <= 10) {
            round = bitmap.getWidth();
            round2 = bitmap.getHeight();
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, round, round2, false);
        Bitmap copy = createScaledBitmap.copy(createScaledBitmap.getConfig(), true);
        if (i2 <= 0) {
            AppMethodBeat.o(215339);
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int[] iArr = new int[(width * height)];
        Log.d(TAG, "alvinluo fastBlurBitmap w: %d, h: %d, length: %d", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(iArr.length));
        copy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i3 = width - 1;
        int i4 = height - 1;
        if (i3 <= 0 || i4 <= 0) {
            AppMethodBeat.o(215339);
            return null;
        }
        int i5 = width * height;
        int i6 = i2 + i2 + 1;
        int[] iArr2 = new int[i5];
        int[] iArr3 = new int[i5];
        int[] iArr4 = new int[i5];
        int[] iArr5 = new int[Math.max(width, height)];
        int i7 = (i6 + 1) >> 1;
        int i8 = i7 * i7;
        int[] iArr6 = new int[(i8 * 256)];
        for (int i9 = 0; i9 < i8 * 256; i9++) {
            iArr6[i9] = i9 / i8;
        }
        int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, i6, 3);
        int i10 = i2 + 1;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < height) {
            if (!z || !checkTimeout(currentTimeMillis, j2)) {
                int i14 = 0;
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                int i18 = 0;
                int i19 = 0;
                int i20 = 0;
                int i21 = 0;
                int i22 = 0;
                for (int i23 = -i2; i23 <= i2; i23++) {
                    int i24 = iArr[Math.min(i3, Math.max(i23, 0)) + i13];
                    int[] iArr8 = iArr7[i23 + i2];
                    iArr8[0] = (16711680 & i24) >> 16;
                    iArr8[1] = (65280 & i24) >> 8;
                    iArr8[2] = i24 & 255;
                    int abs = i10 - Math.abs(i23);
                    i22 += iArr8[0] * abs;
                    i20 += iArr8[1] * abs;
                    i21 += abs * iArr8[2];
                    if (i23 > 0) {
                        i14 += iArr8[0];
                        i15 += iArr8[1];
                        i16 += iArr8[2];
                    } else {
                        i17 += iArr8[0];
                        i18 += iArr8[1];
                        i19 += iArr8[2];
                    }
                }
                if (!z || !checkTimeout(currentTimeMillis, j2)) {
                    int i25 = 0;
                    int i26 = i14;
                    int i27 = i15;
                    int i28 = i16;
                    int i29 = i17;
                    int i30 = i18;
                    int i31 = i19;
                    int i32 = i2;
                    while (i25 < width) {
                        iArr2[i13] = iArr6[i22];
                        iArr3[i13] = iArr6[i20];
                        iArr4[i13] = iArr6[i21];
                        int i33 = i22 - i29;
                        int i34 = i20 - i30;
                        int i35 = i21 - i31;
                        int[] iArr9 = iArr7[((i32 - i2) + i6) % i6];
                        int i36 = i29 - iArr9[0];
                        int i37 = i30 - iArr9[1];
                        int i38 = i31 - iArr9[2];
                        if (i11 == 0) {
                            iArr5[i25] = Math.min(i25 + i2 + 1, i3);
                        }
                        int i39 = iArr[iArr5[i25] + i12];
                        iArr9[0] = (16711680 & i39) >> 16;
                        iArr9[1] = (65280 & i39) >> 8;
                        iArr9[2] = i39 & 255;
                        int i40 = i26 + iArr9[0];
                        int i41 = i27 + iArr9[1];
                        int i42 = iArr9[2] + i28;
                        i22 = i33 + i40;
                        i20 = i34 + i41;
                        i21 = i35 + i42;
                        i32 = (i32 + 1) % i6;
                        int[] iArr10 = iArr7[i32 % i6];
                        int i43 = i36 + iArr10[0];
                        int i44 = i37 + iArr10[1];
                        i31 = i38 + iArr10[2];
                        int i45 = i42 - iArr10[2];
                        i13++;
                        i25++;
                        i26 = i40 - iArr10[0];
                        i27 = i41 - iArr10[1];
                        i28 = i45;
                        i29 = i43;
                        i30 = i44;
                    }
                    i11++;
                    i12 += width;
                } else {
                    Log.e(TAG, "alvinluo fastBlurBitmap timeOut and return null");
                    AppMethodBeat.o(215339);
                    return null;
                }
            } else {
                Log.e(TAG, "alvinluo fastBlurBitmap timeOut and return null");
                AppMethodBeat.o(215339);
                return null;
            }
        }
        for (int i46 = 0; i46 < width; i46++) {
            int i47 = (-i2) * width;
            if (!z || !checkTimeout(currentTimeMillis, j2)) {
                int i48 = 0;
                int i49 = 0;
                int i50 = 0;
                int i51 = 0;
                int i52 = 0;
                int i53 = 0;
                int i54 = 0;
                int i55 = 0;
                int i56 = 0;
                for (int i57 = -i2; i57 <= i2; i57++) {
                    int max = Math.max(0, i47) + i46;
                    int[] iArr11 = iArr7[i57 + i2];
                    iArr11[0] = iArr2[max];
                    iArr11[1] = iArr3[max];
                    iArr11[2] = iArr4[max];
                    int abs2 = i10 - Math.abs(i57);
                    i56 += iArr2[max] * abs2;
                    i54 += iArr3[max] * abs2;
                    i55 += iArr4[max] * abs2;
                    if (i57 > 0) {
                        i48 += iArr11[0];
                        i49 += iArr11[1];
                        i50 += iArr11[2];
                    } else {
                        i51 += iArr11[0];
                        i52 += iArr11[1];
                        i53 += iArr11[2];
                    }
                    if (i57 < i4) {
                        i47 += width;
                    }
                }
                if (!z || !checkTimeout(currentTimeMillis, j2)) {
                    int i58 = 0;
                    int i59 = i48;
                    int i60 = i46;
                    int i61 = i2;
                    while (i58 < height) {
                        iArr[i60] = (-16777216 & iArr[i60]) | (iArr6[i56] << 16) | (iArr6[i54] << 8) | iArr6[i55];
                        int i62 = i56 - i51;
                        int i63 = i54 - i52;
                        int i64 = i55 - i53;
                        int[] iArr12 = iArr7[((i61 - i2) + i6) % i6];
                        int i65 = i51 - iArr12[0];
                        int i66 = i52 - iArr12[1];
                        int i67 = i53 - iArr12[2];
                        if (i46 == 0) {
                            iArr5[i58] = Math.min(i58 + i10, i4) * width;
                        }
                        int i68 = iArr5[i58] + i46;
                        iArr12[0] = iArr2[i68];
                        iArr12[1] = iArr3[i68];
                        iArr12[2] = iArr4[i68];
                        int i69 = i59 + iArr12[0];
                        int i70 = i49 + iArr12[1];
                        int i71 = i50 + iArr12[2];
                        i56 = i62 + i69;
                        i54 = i63 + i70;
                        i55 = i64 + i71;
                        i61 = (i61 + 1) % i6;
                        int[] iArr13 = iArr7[i61];
                        i51 = i65 + iArr13[0];
                        i52 = i66 + iArr13[1];
                        i53 = i67 + iArr13[2];
                        i59 = i69 - iArr13[0];
                        int i72 = i70 - iArr13[1];
                        i50 = i71 - iArr13[2];
                        i60 += width;
                        i58++;
                        i49 = i72;
                    }
                } else {
                    Log.e(TAG, "alvinluo fastBlurBitmap timeOut and return null");
                    AppMethodBeat.o(215339);
                    return null;
                }
            } else {
                Log.e(TAG, "alvinluo fastBlurBitmap timeOut and return null");
                AppMethodBeat.o(215339);
                return null;
            }
        }
        copy.setPixels(iArr, 0, width, 0, 0, width, height);
        AppMethodBeat.o(215339);
        return copy;
    }

    private static boolean checkTimeout(long j2, long j3) {
        AppMethodBeat.i(215340);
        if (j3 == -1) {
            AppMethodBeat.o(215340);
            return false;
        } else if (System.currentTimeMillis() - j2 > j3) {
            AppMethodBeat.o(215340);
            return true;
        } else {
            AppMethodBeat.o(215340);
            return false;
        }
    }

    public static Bitmap setAlpha(Bitmap bitmap, float f2) {
        AppMethodBeat.i(156169);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint();
        paint.setAlpha((int) (255.0f * f2));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        setBitmapDensity(createBitmap);
        Bitmap trace = BitmapTracer.trace(createBitmap);
        AppMethodBeat.o(156169);
        return trace;
    }

    public static Bitmap setGrayscale(Bitmap bitmap) {
        AppMethodBeat.i(156170);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        setBitmapDensity(createBitmap);
        Bitmap trace = BitmapTracer.trace(createBitmap);
        AppMethodBeat.o(156170);
        return trace;
    }

    public static Bitmap setContrast(Bitmap bitmap, float f2) {
        AppMethodBeat.i(215341);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(new float[]{f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        setBitmapDensity(createBitmap);
        Bitmap trace = BitmapTracer.trace(createBitmap);
        AppMethodBeat.o(215341);
        return trace;
    }

    public static String getYUVType(byte[] bArr) {
        AppMethodBeat.i(156172);
        int i2 = 0;
        while (true) {
            if (i2 >= bArr.length - 1) {
                break;
            }
            if ((bArr[i2] & 255) == 255) {
                byte b2 = bArr[i2 + 1];
                if ((b2 & 255) >= 192 && (b2 & 255) <= 207) {
                    Log.d(TAG, "match 0xff-" + Integer.toHexString(b2 & 255) + "  at:" + i2);
                    if (i2 + 1 + 17 >= bArr.length) {
                        Log.d(TAG, "not engouht len at ".concat(String.valueOf(i2)));
                        break;
                    }
                    int i3 = i2 + 2;
                    if (bArr[i3 + 7] != 3) {
                        Log.d(TAG, "num != 3 at ".concat(String.valueOf(i2)));
                    } else {
                        byte b3 = bArr[i3 + 8];
                        byte b4 = bArr[i3 + 11];
                        byte b5 = bArr[i3 + 14];
                        if (b3 == 1 || b4 == 2 || b5 == 3) {
                            byte b6 = bArr[i3 + 9];
                            byte b7 = bArr[i3 + 12];
                            byte b8 = bArr[i3 + 15];
                            if (!(b6 == 0 || b7 == 0 || b8 == 0)) {
                                if (b6 == b7 && b6 == b8) {
                                    AppMethodBeat.o(156172);
                                    return "YUV444";
                                }
                                int i4 = ((b6 & 255) >> 4) & 15;
                                int i5 = b6 & 15;
                                int i6 = ((b7 & 255) >> 4) & 15;
                                int i7 = b7 & 15;
                                int i8 = ((b8 & 255) >> 4) & 15;
                                int i9 = b8 & 15;
                                if (!(i6 == 0 || i8 == 0 || i7 == 0 || i9 == 0 || i4 / i6 != 2 || i4 / i8 != 2)) {
                                    if (i5 / i7 == 2 && i5 / i9 == 2) {
                                        AppMethodBeat.o(156172);
                                        return "YUV420";
                                    } else if (i5 == i7 && i5 == i9) {
                                        AppMethodBeat.o(156172);
                                        return "YUV422";
                                    }
                                }
                            }
                        } else {
                            Log.d(TAG, "Y/Cb/Cr Tag is not right at ".concat(String.valueOf(i2)));
                        }
                    }
                }
            }
            i2++;
        }
        AppMethodBeat.o(156172);
        return null;
    }

    public static boolean compress(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i2, OutputStream outputStream) {
        AppMethodBeat.i(156173);
        if (bitmap == null) {
            Log.e(TAG, "bitmap error %s", bitmap);
            AppMethodBeat.o(156173);
            return false;
        }
        boolean compress = bitmap.compress(compressFormat, i2, outputStream);
        if (!compress) {
            Log.e(TAG, "compress error %s", Util.getStack().toString());
        }
        AppMethodBeat.o(156173);
        return compress;
    }

    public static Bitmap blendBitmap(Bitmap bitmap, Bitmap bitmap2, RectF rectF) {
        AppMethodBeat.i(215342);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, (Rect) null, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), (Paint) null);
        Rect rect = new Rect();
        rectF.round(rect);
        canvas.drawBitmap(bitmap2, rect, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), (Paint) null);
        AppMethodBeat.o(215342);
        return createBitmap;
    }

    public static void setBitmapDensity(Bitmap bitmap) {
        AppMethodBeat.i(156174);
        if (bitmap != null) {
            bitmap.setDensity(MMApplicationContext.getContext().getResources().getDisplayMetrics().densityDpi);
            try {
                Method declaredMethod = Bitmap.class.getDeclaredMethod("setDefaultDensity", Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, Integer.valueOf(MMApplicationContext.getContext().getResources().getDisplayMetrics().densityDpi));
                AppMethodBeat.o(156174);
                return;
            } catch (Exception e2) {
                Log.e(TAG, "Exception:%s", e2);
            }
        }
        AppMethodBeat.o(156174);
    }

    public static Bitmap createVideoThumbnail(String str, int i2) {
        Bitmap bitmap;
        AppMethodBeat.i(156175);
        d dVar = new d();
        try {
            dVar.setDataSource(str);
            bitmap = dVar.getFrameAtTime(-1);
            try {
                dVar.release();
            } catch (RuntimeException e2) {
            }
        } catch (IllegalArgumentException e3) {
            try {
                dVar.release();
                bitmap = null;
            } catch (RuntimeException e4) {
                bitmap = null;
            }
        } catch (RuntimeException e5) {
            try {
                dVar.release();
                bitmap = null;
            } catch (RuntimeException e6) {
                bitmap = null;
            }
        } catch (Throwable th) {
            try {
                dVar.release();
            } catch (RuntimeException e7) {
            }
            AppMethodBeat.o(156175);
            throw th;
        }
        if (bitmap == null) {
            AppMethodBeat.o(156175);
            return null;
        }
        if (i2 == 1) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int max = Math.max(width, height);
            if (max > 512) {
                float f2 = 512.0f / ((float) max);
                bitmap = Bitmap.createScaledBitmap(bitmap, Math.round(((float) width) * f2), Math.round(((float) height) * f2), true);
            }
        } else if (i2 == 3) {
            bitmap = ThumbnailUtils.extractThumbnail(bitmap, 96, 96, 2);
        }
        AppMethodBeat.o(156175);
        return bitmap;
    }

    public static Bitmap drawBackgroundInNeed(Bitmap bitmap, String str, int i2) {
        AppMethodBeat.i(215343);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(215343);
        } else if (Color.alpha(i2) == 0) {
            AppMethodBeat.o(215343);
        } else if (!".png".equals(ImgUtil.identifyImgType(str))) {
            AppMethodBeat.o(215343);
        } else {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawColor(i2);
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                bitmap.recycle();
                bitmap = BitmapTracer.trace(createBitmap);
                AppMethodBeat.o(215343);
            } catch (OutOfMemoryError e2) {
                AppMethodBeat.o(215343);
            }
        }
        return bitmap;
    }
}

package com.tencent.youtu.ytcommon.tools;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class YTUtils {
    private static final String TAG = "ToolUtils";
    private static Map<String, String> mLoadedLibrary = new HashMap();

    static {
        AppMethodBeat.i(73408);
        AppMethodBeat.o(73408);
    }

    public static void prepareMatrix(Matrix matrix, boolean z, int i2, int i3, int i4) {
        float f2;
        AppMethodBeat.i(73402);
        YTLogger.e(TAG, "prepareMatrix viewWidth=" + i3 + ",viewHeight=" + i4 + ",displayOrientation=" + i2);
        if (z) {
            f2 = -1.0f;
        } else {
            f2 = 1.0f;
        }
        matrix.setScale(f2, 1.0f);
        matrix.postRotate((float) i2);
        matrix.postScale(((float) i3) / 2000.0f, ((float) i4) / 2000.0f);
        matrix.postTranslate(((float) i3) / 2.0f, ((float) i4) / 2.0f);
        AppMethodBeat.o(73402);
    }

    public static int dip2px(Context context, float f2) {
        AppMethodBeat.i(73403);
        int i2 = (int) ((context.getResources().getDisplayMetrics().density * f2) + 0.5f);
        AppMethodBeat.o(73403);
        return i2;
    }

    public static Rect trans2ScreenRect(Context context, int i2, int i3, Rect rect) {
        int i4;
        int i5;
        int i6;
        float f2;
        AppMethodBeat.i(73404);
        long currentTimeMillis = System.currentTimeMillis();
        YTLogger.e(TAG, "trans2ScreenRect srcRect=" + rect.toString());
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        YTLogger.e(TAG, "trans2ScreenRect dm.widthPixels=" + displayMetrics.widthPixels);
        YTLogger.e(TAG, "trans2ScreenRect dm.heightPixels=" + displayMetrics.heightPixels);
        YTLogger.e(TAG, "trans2ScreenRect previewWidth=".concat(String.valueOf(i2)));
        YTLogger.e(TAG, "trans2ScreenRect previewHeight=".concat(String.valueOf(i3)));
        int i7 = displayMetrics.widthPixels;
        int i8 = displayMetrics.heightPixels;
        double d2 = (double) ((((float) i2) * 1.0f) / ((float) i3));
        boolean z = i7 > i8;
        if (z) {
            i4 = i7;
        } else {
            i4 = i8;
        }
        if (!z) {
            i8 = i7;
        }
        if (((double) i4) < ((double) i8) * d2) {
            i4 = (int) (((double) i8) * d2);
        } else {
            i8 = (int) (((double) i4) / d2);
        }
        if (z) {
            i5 = i8;
            i6 = i4;
        } else {
            i5 = i4;
            i6 = i8;
        }
        YTLogger.d(TAG, "trans2ScreenRect aspectRatio=".concat(String.valueOf(d2)));
        YTLogger.d(TAG, "trans2ScreenRect widthLonger=".concat(String.valueOf(z)));
        YTLogger.e(TAG, "trans2ScreenRect screenWidth=".concat(String.valueOf(i6)));
        YTLogger.e(TAG, "trans2ScreenRect screenHeight=".concat(String.valueOf(i5)));
        float f3 = 0.0f;
        float f4 = 0.0f;
        if (i3 * i5 > i6 * i2) {
            f2 = (((float) i5) * 1.0f) / ((float) i2);
            f3 = (((float) i6) - (((float) i3) * f2)) * 0.5f;
        } else {
            f2 = (((float) i6) * 1.0f) / ((float) i3);
            f4 = (((float) i5) - (((float) i2) * f2)) * 0.5f;
        }
        Rect rect2 = new Rect();
        rect2.set((int) ((((float) rect.left) * f2) - f3), (int) ((((float) rect.top) * f2) - f4), (int) (((float) rect.right) * f2), (int) (((float) rect.bottom) * f2));
        YTLogger.d(TAG, "scale=".concat(String.valueOf(f2)));
        YTLogger.d(TAG, "dx=".concat(String.valueOf(f3)));
        YTLogger.d(TAG, "dy=".concat(String.valueOf(f4)));
        YTLogger.d(TAG, "screenWidth=".concat(String.valueOf(i6)));
        YTLogger.d(TAG, "screenHeight=".concat(String.valueOf(i5)));
        YTLogger.d(TAG, "dWidth=".concat(String.valueOf(i3)));
        YTLogger.d(TAG, "dHeight=".concat(String.valueOf(i2)));
        YTLogger.d(TAG, "dst=" + rect2.toString());
        int i9 = (i6 - displayMetrics.widthPixels) / 2;
        int i10 = (i5 - displayMetrics.heightPixels) / 2;
        rect.set((int) ((((float) rect.left) * f2) - ((float) i9)), (int) ((((float) rect.top) * f2) - ((float) i10)), (int) ((((float) rect.right) * f2) - ((float) i9)), (int) ((f2 * ((float) rect.bottom)) - ((float) i10)));
        YTLogger.d(TAG, "target=" + rect.toString() + ",time=" + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(73404);
        return rect;
    }

    public static Rect trans2ScreenRectForYT(Context context, int i2, int i3, Rect rect) {
        AppMethodBeat.i(73405);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        YTLogger.e(TAG, "trans2ScreenRectForYT dm.widthPixels=" + displayMetrics.widthPixels);
        YTLogger.e(TAG, "trans2ScreenRectForYT dm.heightPixels=" + displayMetrics.heightPixels);
        YTLogger.e(TAG, "trans2ScreenRectForYT previewHeight=".concat(String.valueOf(i3)));
        float f2 = (((float) displayMetrics.widthPixels) * 1.0f) / ((float) i3);
        rect.set((int) (((float) rect.left) * f2), (int) (((float) rect.top) * f2), (int) (((float) (rect.left + rect.width())) * f2), (int) (f2 * ((float) (rect.top + rect.height()))));
        AppMethodBeat.o(73405);
        return rect;
    }

    public static Rect translateToMeteringAreaCoordinate(int i2, int i3, Rect rect) {
        AppMethodBeat.i(73406);
        Rect rect2 = new Rect();
        Matrix matrix = new Matrix();
        prepareMatrix(matrix, true, 90, i2, i3);
        matrix.postRotate(0.0f);
        RectF rectF = new RectF(((float) rect.left) * 1.0f, ((float) rect.top) * 1.0f, ((float) rect.right) * 1.0f, ((float) rect.bottom) * 1.0f);
        YTLogger.e(TAG, "translationToMeteringAreaCoordinate old rectF.left=" + rectF.left + ",rectF.top=" + rectF.top + ",rectF.right=" + rectF.right + ",rectF.bottom=" + rectF.bottom);
        Matrix matrix2 = new Matrix();
        matrix.invert(matrix2);
        matrix2.mapRect(rectF);
        YTLogger.e(TAG, "translationToMeteringAreaCoordinate new rectF.left=" + rectF.left + ",rectF.top=" + rectF.top + ",rectF.right=" + rectF.right + ",rectF.bottom=" + rectF.bottom);
        rect2.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        AppMethodBeat.o(73406);
        return rect2;
    }

    public static void loadLibrary(String str) {
        AppMethodBeat.i(73407);
        if (mLoadedLibrary.get(str) == null) {
            YTLogger.i(TAG, "[YTUtils.loadLibrary] " + System.getProperty("java.library.path"));
            System.loadLibrary(str);
            mLoadedLibrary.put(str, "loaded");
        }
        AppMethodBeat.o(73407);
    }
}

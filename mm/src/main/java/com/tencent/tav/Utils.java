package com.tencent.tav;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Utils {
    public static Bitmap flipYBitmap(Bitmap bitmap) {
        AppMethodBeat.i(217628);
        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, -1.0f, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        AppMethodBeat.o(217628);
        return createBitmap;
    }

    public static String getPhoneName() {
        AppMethodBeat.i(217629);
        String str = Build.MANUFACTURER.toUpperCase() + " " + Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(217629);
            return "";
        }
        String replace = str.replace(" ", "_").replace("+", "").replace("(t)", "");
        AppMethodBeat.o(217629);
        return replace;
    }
}

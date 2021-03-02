package com.tencent.mm.cq;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.s;

public final class b {
    public static boolean adl(String str) {
        AppMethodBeat.i(152885);
        if (hiq()) {
            AppMethodBeat.o(152885);
            return false;
        }
        BitmapFactory.Options bmT = bmT(str);
        int i2 = bmT.outWidth;
        int i3 = bmT.outHeight;
        Log.i("MicroMsg.BigImageJudge", "alvinluo checkUseBigImgOpt ignore abTestFlag, widthFactor: %f, heightFactor: %f, width: %d, height: %d", Float.valueOf(1.0f), Float.valueOf(1.0f), Integer.valueOf(i2), Integer.valueOf(i3));
        if (a.ml(i2, i3)) {
            Log.i("MicroMsg.BigImageJudge", "alvinluo checkUseBigImageOpt filter image");
            AppMethodBeat.o(152885);
            return false;
        }
        Log.i("MicroMsg.BigImageJudge", "alvinluo checkUseBigImageOpt not filter");
        int screenWidth = getScreenWidth(MMApplicationContext.getContext());
        int screenHeight = getScreenHeight(MMApplicationContext.getContext());
        Log.d("MicroMsg.BigImageJudge", "alvinluo checkUseBigImageOpt width: %d, height: %d, screenWidth: %d, screenHeight: %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(screenWidth), Integer.valueOf(screenHeight));
        if (((float) i2) >= ((float) screenWidth) * 1.0f) {
            AppMethodBeat.o(152885);
            return true;
        } else if (((float) i3) >= ((float) screenHeight) * 1.0f) {
            AppMethodBeat.o(152885);
            return true;
        } else {
            AppMethodBeat.o(152885);
            return false;
        }
    }

    private static boolean hiq() {
        String str;
        AppMethodBeat.i(152886);
        if (Build.VERSION.SDK_INT != 27 || (str = af.get("ro.mediatek.platform")) == null || (!str.startsWith("mt6765") && !str.startsWith("MT6765"))) {
            if (l.apy()) {
                Log.i("MicroMsg.BigImageJudge", "alvinluo checkUseBigImageOpt is MTK platform");
                if (Build.VERSION.SDK_INT == 24 || Build.VERSION.SDK_INT == 25 || Build.VERSION.SDK_INT == 27) {
                    Log.i("MicroMsg.BigImageJudge", "alvinluo checkUseBigImgOpt is MTK platform, android api: %d, cannot use BigImgOpt", Integer.valueOf(Build.VERSION.SDK_INT));
                    c.aqp(Build.VERSION.SDK_INT);
                    AppMethodBeat.o(152886);
                    return true;
                }
            }
            AppMethodBeat.o(152886);
            return false;
        }
        AppMethodBeat.o(152886);
        return false;
    }

    private static int getScreenWidth(Context context) {
        AppMethodBeat.i(152887);
        if (context == null) {
            AppMethodBeat.o(152887);
            return 0;
        }
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        AppMethodBeat.o(152887);
        return i2;
    }

    private static int getScreenHeight(Context context) {
        AppMethodBeat.i(152888);
        if (context == null) {
            AppMethodBeat.o(152888);
            return 0;
        }
        int i2 = context.getResources().getDisplayMetrics().heightPixels;
        AppMethodBeat.o(152888);
        return i2;
    }

    private static BitmapFactory.Options bmT(String str) {
        AppMethodBeat.i(152889);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(s.k(str, false), options);
        if (decodeFile != null) {
            decodeFile.recycle();
        }
        AppMethodBeat.o(152889);
        return options;
    }
}

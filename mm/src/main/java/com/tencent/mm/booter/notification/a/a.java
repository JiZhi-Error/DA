package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class a {
    public Bitmap got;

    public static Bitmap a(Context context, Bitmap bitmap) {
        AppMethodBeat.i(20036);
        if (context == null || bitmap == null) {
            AppMethodBeat.o(20036);
            return null;
        } else if (Build.VERSION.SDK_INT >= 11) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(17104902) - context.getResources().getDimensionPixelSize(R.dimen.acv);
            Bitmap roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(BitmapUtil.extractThumbNail(bitmap, dimensionPixelSize, dimensionPixelSize, false, false), false, (float) context.getResources().getDimensionPixelSize(R.dimen.acu));
            AppMethodBeat.o(20036);
            return roundedCornerBitmap;
        } else {
            AppMethodBeat.o(20036);
            return bitmap;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00af A[SYNTHETIC, Splitter:B:25:0x00af] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap V(java.lang.String r14, java.lang.String r15) {
        /*
        // Method dump skipped, instructions count: 395
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.booter.notification.a.a.V(java.lang.String, java.lang.String):android.graphics.Bitmap");
    }
}

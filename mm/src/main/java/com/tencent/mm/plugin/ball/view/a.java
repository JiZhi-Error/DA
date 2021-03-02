package com.tencent.mm.plugin.ball.view;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class a implements b.h {
    public static final a oZc = new a();

    @Override // com.tencent.mm.modelappbrand.a.b.h
    public final Bitmap J(Bitmap bitmap) {
        AppMethodBeat.i(106374);
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            AppMethodBeat.o(106374);
            return bitmap;
        }
        Bitmap roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(bitmap, false, (float) (bitmap.getWidth() / 2), false);
        AppMethodBeat.o(106374);
        return roundedCornerBitmap;
    }

    @Override // com.tencent.mm.modelappbrand.a.c
    public final String Lb() {
        return "FloatBallIcon";
    }

    static {
        AppMethodBeat.i(106375);
        AppMethodBeat.o(106375);
    }
}

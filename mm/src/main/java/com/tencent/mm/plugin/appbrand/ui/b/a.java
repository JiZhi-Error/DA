package com.tencent.mm.plugin.appbrand.ui.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class a implements b.h {
    private final int obn;

    public a(int i2) {
        this.obn = i2;
    }

    @Override // com.tencent.mm.modelappbrand.a.c
    public final String Lb() {
        return "AppBrandProfileLikeImageTransformation";
    }

    @Override // com.tencent.mm.modelappbrand.a.b.h
    public final Bitmap J(Bitmap bitmap) {
        AppMethodBeat.i(49043);
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            AppMethodBeat.o(49043);
            return bitmap;
        }
        Bitmap roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(bitmap, false, (float) this.obn, false);
        if (roundedCornerBitmap != null) {
            AppMethodBeat.o(49043);
            return roundedCornerBitmap;
        }
        AppMethodBeat.o(49043);
        return bitmap;
    }
}

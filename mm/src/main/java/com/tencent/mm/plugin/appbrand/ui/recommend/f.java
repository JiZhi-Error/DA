package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class f implements b.h {
    public static final f ofj = new f();
    public int iLd = 0;
    public int ofi = 0;

    @Override // com.tencent.mm.modelappbrand.a.b.h
    public final Bitmap J(Bitmap bitmap) {
        Bitmap roundedCornerBitmap;
        AppMethodBeat.i(49295);
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            AppMethodBeat.o(49295);
            return bitmap;
        }
        if (bitmap.getWidth() == bitmap.getHeight()) {
            float f2 = (float) this.ofi;
            if (this.iLd > 0 && this.ofi > 0) {
                f2 = (float) ((this.ofi * bitmap.getWidth()) / this.iLd);
            }
            roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(bitmap, false, f2);
        } else {
            int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
            if (min <= 0) {
                min = Math.max(bitmap.getWidth(), bitmap.getHeight());
            }
            Bitmap centerCropBitmap = BitmapUtil.getCenterCropBitmap(bitmap, min, min, true);
            float f3 = (float) this.ofi;
            if (this.iLd > 0 && this.ofi > 0) {
                f3 = (float) ((this.ofi * centerCropBitmap.getWidth()) / this.iLd);
            }
            roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(centerCropBitmap, false, f3);
        }
        AppMethodBeat.o(49295);
        return roundedCornerBitmap;
    }

    @Override // com.tencent.mm.modelappbrand.a.c
    public final String Lb() {
        return "WxaRecommendIcon";
    }

    static {
        AppMethodBeat.i(49296);
        AppMethodBeat.o(49296);
    }
}

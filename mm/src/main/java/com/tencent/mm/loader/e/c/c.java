package com.tencent.mm.loader.e.c;

import android.graphics.Bitmap;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.h.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class c extends b<Bitmap> {
    private boolean iaT;
    private float iaU;

    public c(float f2) {
        this.iaT = true;
        this.iaU = f2;
    }

    public c() {
        this.iaT = true;
        this.iaU = 0.1f;
    }

    @Override // com.tencent.mm.loader.d.f
    public final String Hi(String str) {
        return String.format("_round_%.2f_", Float.valueOf(this.iaU));
    }

    @Override // com.tencent.mm.loader.d.f
    public final e<? extends Bitmap> a(g<?> gVar, f<?, Bitmap> fVar, e<Bitmap> eVar) {
        T t = eVar.value;
        if (this.iaT) {
            if (this.iaU == 0.0f && t.getWidth() != t.getHeight()) {
                int min = Math.min(t.getWidth(), t.getHeight());
                if (min <= 0) {
                    min = Math.max(t.getWidth(), t.getHeight());
                }
                t = BitmapUtil.getCenterCropBitmap(t, min, min, true);
            }
            t = BitmapUtil.getRoundedCornerBitmap(t, false, ((float) t.getWidth()) * this.iaU);
        }
        return new e<>(t);
    }
}

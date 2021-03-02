package com.tencent.mm.modelappbrand.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f extends BitmapDrawable {
    public f(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(131404);
        if (getBitmap() != null && !getBitmap().isRecycled()) {
            super.draw(canvas);
        }
        AppMethodBeat.o(131404);
    }
}

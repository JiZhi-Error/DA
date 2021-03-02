package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class e implements b.h {
    @Override // com.tencent.mm.modelappbrand.a.b.h
    public Bitmap J(Bitmap bitmap) {
        AppMethodBeat.i(176005);
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            AppMethodBeat.o(176005);
            return bitmap;
        }
        android.support.v4.graphics.drawable.b a2 = d.a(MMApplicationContext.getResources(), bitmap);
        a2.eD();
        Bitmap drawableToBitmap = drawableToBitmap(a2);
        if (drawableToBitmap != bitmap) {
            bitmap.recycle();
        }
        AppMethodBeat.o(176005);
        return drawableToBitmap;
    }

    @Override // com.tencent.mm.modelappbrand.a.c
    public String Lb() {
        return "RoundedBitmap";
    }

    private static Bitmap drawableToBitmap(Drawable drawable) {
        AppMethodBeat.i(176006);
        if (drawable == null) {
            AppMethodBeat.o(176006);
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            AppMethodBeat.o(176006);
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            AppMethodBeat.o(176006);
            return createBitmap;
        } catch (OutOfMemoryError e2) {
            AppMethodBeat.o(176006);
            return null;
        }
    }
}

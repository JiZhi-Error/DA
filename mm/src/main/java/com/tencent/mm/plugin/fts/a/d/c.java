package com.tencent.mm.plugin.fts.a.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface c {
    String a(ImageView imageView, String str, String str2, boolean z, int i2, int i3);

    void a(Context context, ImageView imageView, String str, String str2, boolean z, int i2, int i3);

    Bitmap b(String str, String str2, boolean z, int i2, int i3);

    void dOk();

    void dOl();

    boolean dOm();

    void dOn();

    void dOo();

    void dOp();

    public static class a extends BitmapDrawable {
        public static void a(Resources resources, Bitmap bitmap, ImageView imageView) {
            AppMethodBeat.i(131732);
            imageView.setImageDrawable(new a(resources, bitmap));
            imageView.postInvalidate();
            AppMethodBeat.o(131732);
        }

        private a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        public final void draw(Canvas canvas) {
            AppMethodBeat.i(131733);
            if (getBitmap() != null && !getBitmap().isRecycled()) {
                super.draw(canvas);
            }
            AppMethodBeat.o(131733);
        }
    }
}

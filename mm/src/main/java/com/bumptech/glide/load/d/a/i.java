package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.a.f;
import com.bumptech.glide.load.b.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;

final class i {
    private static final e aLl = new f() {
        /* class com.bumptech.glide.load.d.a.i.AnonymousClass1 */

        @Override // com.bumptech.glide.load.b.a.f, com.bumptech.glide.load.b.a.e
        public final void g(Bitmap bitmap) {
        }
    };

    static {
        AppMethodBeat.i(77403);
        AppMethodBeat.o(77403);
    }

    static v<Bitmap> a(e eVar, Drawable drawable, int i2, int i3) {
        boolean z;
        AppMethodBeat.i(77401);
        Drawable current = drawable.getCurrent();
        Bitmap bitmap = null;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
            z = false;
        } else if (!(current instanceof Animatable)) {
            Bitmap b2 = b(eVar, current, i2, i3);
            z = true;
            bitmap = b2;
        } else {
            z = false;
        }
        if (!z) {
            eVar = aLl;
        }
        d a2 = d.a(bitmap, eVar);
        AppMethodBeat.o(77401);
        return a2;
    }

    private static Bitmap b(e eVar, Drawable drawable, int i2, int i3) {
        Bitmap bitmap = null;
        AppMethodBeat.i(77402);
        if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                new StringBuilder("Unable to draw ").append(drawable).append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            AppMethodBeat.o(77402);
        } else if (i3 != Integer.MIN_VALUE || drawable.getIntrinsicHeight() > 0) {
            if (drawable.getIntrinsicWidth() > 0) {
                i2 = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i3 = drawable.getIntrinsicHeight();
            }
            Lock pI = q.pI();
            pI.lock();
            bitmap = eVar.b(i2, i3, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, i2, i3);
                drawable.draw(canvas);
                canvas.setBitmap(null);
            } finally {
                pI.unlock();
                AppMethodBeat.o(77402);
            }
        } else {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                new StringBuilder("Unable to draw ").append(drawable).append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            AppMethodBeat.o(77402);
        }
        return bitmap;
    }
}

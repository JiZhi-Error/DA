package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;

public final class d {

    static class a extends b {
        a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        /* access modifiers changed from: package-private */
        @Override // android.support.v4.graphics.drawable.b
        public final void a(int i2, int i3, int i4, Rect rect, Rect rect2) {
            android.support.v4.view.d.apply(i2, i3, i4, rect, rect2, 0);
        }
    }

    public static b a(Resources resources, Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new c(resources, bitmap);
        }
        return new a(resources, bitmap);
    }
}

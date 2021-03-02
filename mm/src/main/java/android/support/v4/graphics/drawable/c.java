package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;

final class c extends b {
    protected c(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    public final void getOutline(Outline outline) {
        eC();
        outline.setRoundRect(this.Ky, this.Kx);
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.v4.graphics.drawable.b
    public final void a(int i2, int i3, int i4, Rect rect, Rect rect2) {
        Gravity.apply(i2, i3, i4, rect, rect2, 0);
    }
}

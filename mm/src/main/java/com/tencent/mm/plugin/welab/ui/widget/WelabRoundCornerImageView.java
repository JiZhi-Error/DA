package com.tencent.mm.plugin.welab.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.b;
import android.support.v4.graphics.drawable.d;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WelabRoundCornerImageView extends ImageView {
    private float JGA;

    public WelabRoundCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WelabRoundCornerImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setCornerRadiusPercent(float f2) {
        this.JGA = f2;
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(146296);
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() < 0 || bitmap.getHeight() < 0) {
            super.setImageBitmap(bitmap);
            AppMethodBeat.o(146296);
        } else if (this.JGA <= 0.0f) {
            super.setImageBitmap(bitmap);
            AppMethodBeat.o(146296);
        } else {
            b a2 = d.a(getResources(), bitmap);
            a2.setCornerRadius(Math.min(((float) bitmap.getWidth()) * this.JGA, ((float) bitmap.getHeight()) * this.JGA));
            super.setImageDrawable(a2);
            AppMethodBeat.o(146296);
        }
    }

    public Bitmap getDisplayingBitmap() {
        AppMethodBeat.i(146297);
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof b)) {
            AppMethodBeat.o(146297);
            return null;
        }
        Bitmap bitmap = ((b) drawable).mBitmap;
        AppMethodBeat.o(146297);
        return bitmap;
    }
}

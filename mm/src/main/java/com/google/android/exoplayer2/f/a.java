package com.google.android.exoplayer2.f;

import android.graphics.Bitmap;
import android.text.Layout;
import com.tencent.smtt.sdk.WebView;

public class a {
    public final Layout.Alignment bAb;
    public final float bAc;
    public final int bAd;
    public final float bAe;
    public final int bAf;
    public final float bAg;
    public final boolean bAh;
    public final Bitmap bitmap;
    public final int lineType;
    public final float size;
    public final CharSequence text;
    public final int windowColor;

    public a(Bitmap bitmap2, float f2, float f3, float f4, float f5) {
        this(null, null, bitmap2, f3, 0, 0, f2, 0, f4, f5, false, WebView.NIGHT_MODE_COLOR);
    }

    public a(CharSequence charSequence) {
        this(charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public a(CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4) {
        this(charSequence, alignment, f2, i2, i3, f3, i4, f4, false, WebView.NIGHT_MODE_COLOR);
    }

    public a(CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4, boolean z, int i5) {
        this(charSequence, alignment, null, f2, i2, i3, f3, i4, f4, Float.MIN_VALUE, z, i5);
    }

    private a(CharSequence charSequence, Layout.Alignment alignment, Bitmap bitmap2, float f2, int i2, int i3, float f3, int i4, float f4, float f5, boolean z, int i5) {
        this.text = charSequence;
        this.bAb = alignment;
        this.bitmap = bitmap2;
        this.bAc = f2;
        this.lineType = i2;
        this.bAd = i3;
        this.bAe = f3;
        this.bAf = i4;
        this.size = f4;
        this.bAg = f5;
        this.bAh = z;
        this.windowColor = i5;
    }
}

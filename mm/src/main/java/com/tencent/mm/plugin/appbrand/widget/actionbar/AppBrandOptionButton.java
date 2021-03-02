package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class AppBrandOptionButton extends FrameLayout {
    private ImageButton omr;

    public AppBrandOptionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(135460);
        init(context);
        AppMethodBeat.o(135460);
    }

    public AppBrandOptionButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(135461);
        init(context);
        AppMethodBeat.o(135461);
    }

    private int getActionBarHeight() {
        AppMethodBeat.i(135462);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.b7);
        AppMethodBeat.o(135462);
        return dimensionPixelSize;
    }

    private void init(Context context) {
        AppMethodBeat.i(135463);
        this.omr = new ImageButton(context);
        this.omr.setClickable(false);
        this.omr.setBackground(null);
        addView(this.omr, new FrameLayout.LayoutParams(getActionBarHeight(), -1, 17));
        setAccessibilityLabel(getDefaultAccessibilityLabel());
        AppMethodBeat.o(135463);
    }

    public final void setAccessibilityLabel(String str) {
        AppMethodBeat.i(135464);
        if (this.omr != null && this.omr.getVisibility() == 0) {
            this.omr.setContentDescription(str);
        }
        AppMethodBeat.o(135464);
    }

    public void setIcon(Bitmap bitmap) {
        AppMethodBeat.i(135465);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(135465);
            return;
        }
        this.omr.setImageDrawable(new BitmapDrawable(getResources(), bitmap));
        this.omr.setVisibility(0);
        AppMethodBeat.o(135465);
    }

    public void setColor(int i2) {
        AppMethodBeat.i(135466);
        this.omr.setImageDrawable(getDefaultImageDrawable());
        this.omr.setColorFilter(i2, PorterDuff.Mode.SRC_ATOP);
        this.omr.setBackground(getBackground());
        if (this.omr.getBackground() != null) {
            this.omr.getBackground().setColorFilter(i2, PorterDuff.Mode.SRC_ATOP);
        }
        AppMethodBeat.o(135466);
    }

    public final void reset() {
        AppMethodBeat.i(135467);
        this.omr.setVisibility(0);
        this.omr.setAlpha(1.0f);
        this.omr.setImageDrawable(getDefaultImageDrawable());
        AppMethodBeat.o(135467);
    }

    /* access modifiers changed from: protected */
    public Drawable getDefaultImageDrawable() {
        AppMethodBeat.i(135468);
        Drawable l = b.l(getContext(), R.drawable.bxk);
        AppMethodBeat.o(135468);
        return l;
    }

    /* access modifiers changed from: protected */
    public String getDefaultAccessibilityLabel() {
        AppMethodBeat.i(219627);
        String string = getContext().getString(R.string.ho);
        AppMethodBeat.o(219627);
        return string;
    }

    public ImageView getButtonImage() {
        return this.omr;
    }
}

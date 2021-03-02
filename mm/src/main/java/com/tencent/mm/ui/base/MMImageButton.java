package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;

public class MMImageButton extends FrameLayout {
    private TextView BaI;
    private ImageView dPk;

    public MMImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142026);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.dPk = new ImageView(context);
        this.dPk.setLayoutParams(layoutParams);
        addView(this.dPk);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.BaI = new TextView(context);
        this.BaI.setLayoutParams(layoutParams2);
        this.BaI.setClickable(false);
        this.BaI.setFocusable(false);
        this.BaI.setFocusableInTouchMode(false);
        this.BaI.setTextColor(a.m(context, R.color.a0o));
        addView(this.BaI);
        AppMethodBeat.o(142026);
    }

    public void setImageRsource(int i2) {
        AppMethodBeat.i(142027);
        setImageDrawable(a.l(getContext(), i2));
        AppMethodBeat.o(142027);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(142028);
        this.dPk.setImageDrawable(drawable);
        this.dPk.setVisibility(0);
        this.BaI.setVisibility(8);
        AppMethodBeat.o(142028);
    }

    public void setText(String str) {
        AppMethodBeat.i(142029);
        this.BaI.setText(str);
        this.BaI.setVisibility(0);
        this.dPk.setVisibility(8);
        AppMethodBeat.o(142029);
    }

    public void setText(int i2) {
        AppMethodBeat.i(142030);
        this.BaI.setText(i2);
        this.BaI.setVisibility(0);
        this.dPk.setVisibility(8);
        AppMethodBeat.o(142030);
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.i(142031);
        super.setEnabled(z);
        this.BaI.setEnabled(z);
        this.dPk.setEnabled(z);
        AppMethodBeat.o(142031);
    }
}

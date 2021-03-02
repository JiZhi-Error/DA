package com.tencent.mm.ui.widget.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ck.a;

public class WeImageButton extends AppCompatImageButton {
    private int Kxl;
    private int QRf;
    private float QRg = 1.0f;
    private int QRh = 255;
    private boolean QRi = true;
    private int mAlpha = 255;

    public WeImageButton(Context context) {
        super(context, null);
        AppMethodBeat.i(159405);
        init(context, null);
        AppMethodBeat.o(159405);
    }

    public WeImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(159406);
        init(context, attributeSet);
        AppMethodBeat.o(159406);
    }

    public WeImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(159407);
        init(context, attributeSet);
        AppMethodBeat.o(159407);
    }

    public void setIconColor(int i2) {
        AppMethodBeat.i(159408);
        this.Kxl = i2;
        this.QRi = true;
        invalidate();
        AppMethodBeat.o(159408);
    }

    private void init(Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(159409);
        this.QRf = context.getResources().getColor(R.color.FG_0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0296a.WeImageBtn);
            this.Kxl = obtainStyledAttributes.getColor(1, this.QRf);
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(159409);
            return;
        }
        this.Kxl = this.QRf;
        AppMethodBeat.o(159409);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(159410);
        super.onDraw(canvas);
        if (getDrawable() != null && this.QRi) {
            getDrawable().setColorFilter(new PorterDuffColorFilter(this.Kxl, PorterDuff.Mode.SRC_ATOP));
            this.QRi = false;
        }
        AppMethodBeat.o(159410);
    }
}

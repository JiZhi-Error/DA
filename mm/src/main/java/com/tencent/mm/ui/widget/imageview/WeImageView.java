package com.tencent.mm.ui.widget.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ck.a;
import com.tencent.smtt.sdk.WebView;
import com.tencent.thumbplayer.api.TPOptionalID;

public class WeImageView extends AppCompatImageView {
    private int Kxl;
    private int QRf;
    private float QRg = 1.0f;
    private int QRh = 255;
    private boolean QRi = true;
    private boolean QRj = false;
    private boolean QRk = true;
    private int mAlpha = 255;

    public WeImageView(Context context) {
        super(context);
        AppMethodBeat.i(159411);
        init(context, null);
        AppMethodBeat.o(159411);
    }

    public WeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(159412);
        init(context, attributeSet);
        AppMethodBeat.o(159412);
    }

    public WeImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(159413);
        init(context, attributeSet);
        AppMethodBeat.o(159413);
    }

    public void setIconColor(int i2) {
        AppMethodBeat.i(159414);
        this.Kxl = i2;
        this.QRi = true;
        invalidate();
        AppMethodBeat.o(159414);
    }

    public void setClearColorFilter(boolean z) {
        AppMethodBeat.i(198349);
        this.QRj = z;
        this.QRi = true;
        invalidate();
        AppMethodBeat.o(198349);
    }

    public void setEnableColorFilter(boolean z) {
        AppMethodBeat.i(198350);
        if (this.QRk != z) {
            this.QRk = z;
            this.QRi = true;
            invalidate();
        }
        AppMethodBeat.o(198350);
    }

    public final void C(int i2, float f2) {
        AppMethodBeat.i(186015);
        this.Kxl = i2;
        this.QRg = f2;
        this.QRi = true;
        invalidate();
        AppMethodBeat.o(186015);
    }

    private void init(Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(159415);
        this.QRf = context.getResources().getColor(R.color.FG_0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0296a.WeImageView);
            this.Kxl = obtainStyledAttributes.getColor(1, this.QRf);
            this.QRg = obtainStyledAttributes.getFloat(0, 1.0f);
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(159415);
            return;
        }
        this.Kxl = this.QRf;
        AppMethodBeat.o(159415);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(159416);
        super.onDraw(canvas);
        if (this.QRj && this.QRi) {
            getDrawable().mutate().clearColorFilter();
            this.QRj = false;
            this.QRi = false;
            AppMethodBeat.o(159416);
        } else if (this.QRk || getDrawable() == null || !this.QRi) {
            if (this.QRk && getDrawable() != null && this.QRi) {
                int i2 = this.Kxl;
                if (this.Kxl != 0) {
                    i2 = (this.Kxl & 16777215) | WebView.NIGHT_MODE_COLOR;
                }
                int alpha = Color.alpha(this.Kxl);
                if (this.QRg != 1.0f) {
                    alpha = (int) (255.0f * this.QRg);
                }
                getDrawable().mutate().setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_ATOP));
                if (this.Kxl != 0) {
                    this.mAlpha = alpha;
                    getDrawable().setAlpha(alpha);
                }
                this.QRi = false;
            }
            AppMethodBeat.o(159416);
        } else {
            getDrawable().mutate().clearColorFilter();
            this.QRi = false;
            AppMethodBeat.o(159416);
        }
    }

    @Override // android.support.v7.widget.AppCompatImageView
    public void drawableStateChanged() {
        AppMethodBeat.i(198351);
        super.drawableStateChanged();
        int i2 = this.mAlpha;
        if (isPressed()) {
            i2 = TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
        } else if (isEnabled()) {
            i2 = this.mAlpha;
        }
        if (!isEnabled() || !isFocusable()) {
            i2 = 255;
        }
        if (i2 != this.QRh) {
            this.QRh = i2;
            if (getDrawable() != null) {
                getDrawable().setAlpha(i2);
            }
        }
        AppMethodBeat.o(198351);
    }
}

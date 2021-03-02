package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMTruncTextView extends TextView {
    private boolean Qvi = false;
    private boolean Qvj = false;

    public MMTruncTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public MMTruncTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(143192);
        super.onLayout(z, i2, i3, i4, i5);
        if (!this.Qvi) {
            AppMethodBeat.o(143192);
            return;
        }
        CharSequence text = getText();
        if (!(text instanceof Spanned)) {
            AppMethodBeat.o(143192);
            return;
        }
        this.Qvj = true;
        setText(TextUtils.ellipsize(text, getPaint(), (float) ((getWidth() - getCompoundPaddingRight()) - getCompoundPaddingLeft()), TextUtils.TruncateAt.END));
        this.Qvj = false;
        AppMethodBeat.o(143192);
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        AppMethodBeat.i(143193);
        super.onTextChanged(charSequence, i2, i3, i4);
        this.Qvi = !this.Qvj;
        AppMethodBeat.o(143193);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(143194);
        try {
            super.onMeasure(i2, i3);
            AppMethodBeat.o(143194);
        } catch (Throwable th) {
            AppMethodBeat.o(143194);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(143195);
        try {
            super.onDraw(canvas);
            AppMethodBeat.o(143195);
        } catch (Throwable th) {
            AppMethodBeat.o(143195);
        }
    }

    public int getBaseline() {
        AppMethodBeat.i(143196);
        try {
            int baseline = super.getBaseline();
            AppMethodBeat.o(143196);
            return baseline;
        } catch (Throwable th) {
            AppMethodBeat.o(143196);
            return -1;
        }
    }

    public boolean onPreDraw() {
        AppMethodBeat.i(143197);
        try {
            boolean onPreDraw = super.onPreDraw();
            AppMethodBeat.o(143197);
            return onPreDraw;
        } catch (Throwable th) {
            AppMethodBeat.o(143197);
            return true;
        }
    }
}

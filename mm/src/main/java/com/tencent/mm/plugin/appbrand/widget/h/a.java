package com.tencent.mm.plugin.appbrand.widget.h;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements LineHeightSpan {
    private final int gravity;
    public int height;

    public final boolean aX(float f2) {
        AppMethodBeat.i(138150);
        if (this.height != Math.round(f2)) {
            AppMethodBeat.o(138150);
            return true;
        }
        AppMethodBeat.o(138150);
        return false;
    }

    public a(float f2, int i2) {
        AppMethodBeat.i(193743);
        this.gravity = i2 & 112;
        setHeight(f2);
        AppMethodBeat.o(193743);
    }

    public final void chooseHeight(CharSequence charSequence, int i2, int i3, int i4, int i5, Paint.FontMetricsInt fontMetricsInt) {
        AppMethodBeat.i(138152);
        if ((-fontMetricsInt.ascent) > this.height) {
            int i6 = -this.height;
            fontMetricsInt.ascent = i6;
            fontMetricsInt.top = i6;
            fontMetricsInt.descent = 0;
            fontMetricsInt.bottom = 0;
            AppMethodBeat.o(138152);
        } else if ((-fontMetricsInt.ascent) + fontMetricsInt.descent > this.height) {
            fontMetricsInt.descent = fontMetricsInt.bottom;
            int i7 = fontMetricsInt.descent - this.height;
            fontMetricsInt.ascent = i7;
            fontMetricsInt.top = i7;
            AppMethodBeat.o(138152);
        } else if ((-fontMetricsInt.ascent) + fontMetricsInt.bottom > this.height) {
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = fontMetricsInt.ascent + this.height;
            AppMethodBeat.o(138152);
        } else if ((-fontMetricsInt.top) + fontMetricsInt.bottom > this.height) {
            fontMetricsInt.top = fontMetricsInt.bottom - this.height;
            AppMethodBeat.o(138152);
        } else {
            int i8 = this.height - ((-fontMetricsInt.ascent) + fontMetricsInt.descent);
            if (this.gravity == 48) {
                fontMetricsInt.descent += i8;
                fontMetricsInt.bottom = i8 + fontMetricsInt.bottom;
                AppMethodBeat.o(138152);
            } else if (this.gravity == 80) {
                fontMetricsInt.top -= i8;
                fontMetricsInt.ascent -= i8;
                AppMethodBeat.o(138152);
            } else {
                if (this.gravity == 16) {
                    int round = Math.round(((float) i8) / 2.0f);
                    fontMetricsInt.top -= round;
                    fontMetricsInt.ascent -= round;
                    fontMetricsInt.bottom += round;
                    fontMetricsInt.descent = round + fontMetricsInt.descent;
                }
                AppMethodBeat.o(138152);
            }
        }
    }

    public final void setHeight(float f2) {
        AppMethodBeat.i(138153);
        this.height = Math.round(f2);
        AppMethodBeat.o(138153);
    }
}

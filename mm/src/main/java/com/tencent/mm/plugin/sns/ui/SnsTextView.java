package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableStringBuilder;
import android.text.style.MetricAffectingSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class SnsTextView extends TextView {
    private char EKj = 0;
    private String yJu = "";

    public SnsTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onTextContextMenuItem(int i2) {
        AppMethodBeat.i(99216);
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i2);
        AppMethodBeat.o(99216);
        return onTextContextMenuItem;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(99217);
        super.onLayout(z, i2, i3, i4, i5);
        AppMethodBeat.o(99217);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(99218);
        if (ae.gKE.gGS == 1 || ae.gKE.gGS == -1) {
            try {
                super.onMeasure(i2, i3);
                this.EKj = 0;
                AppMethodBeat.o(99218);
            } catch (IndexOutOfBoundsException e2) {
                if (this.EKj < 3) {
                    try {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getText());
                        MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MetricAffectingSpan.class);
                        if (metricAffectingSpanArr == null || metricAffectingSpanArr.length <= 0) {
                            this.EKj = 'd';
                        } else {
                            spannableStringBuilder.insert(spannableStringBuilder.getSpanStart(metricAffectingSpanArr[0]) - 1, (CharSequence) " ");
                            this.EKj = (char) (this.EKj + 1);
                        }
                        setText(spannableStringBuilder);
                        onMeasure(i2, i3);
                        AppMethodBeat.o(99218);
                    } catch (IndexOutOfBoundsException e3) {
                        Log.i("MicroMsg.SnsTextView", "tryToFix error set origintext " + Util.isNullOrNil(this.yJu));
                        setText(this.yJu);
                        onMeasure(i2, i3);
                        this.EKj = (char) (this.EKj + 1);
                        AppMethodBeat.o(99218);
                    }
                } else if (this.EKj == 3) {
                    Log.i("MicroMsg.SnsTextView", "fix error set origintext " + Util.isNullOrNil(this.yJu));
                    setText(this.yJu);
                    onMeasure(i2, i3);
                    this.EKj = (char) (this.EKj + 1);
                    AppMethodBeat.o(99218);
                } else {
                    AppMethodBeat.o(99218);
                    throw e2;
                }
            }
        } else {
            super.onMeasure(i2, i3);
            AppMethodBeat.o(99218);
        }
    }

    public void setOriginText(String str) {
        this.yJu = str;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(99219);
        try {
            super.onDraw(canvas);
            AppMethodBeat.o(99219);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.SnsTextView", th, "", new Object[0]);
            AppMethodBeat.o(99219);
        }
    }

    public int getBaseline() {
        AppMethodBeat.i(99220);
        try {
            int baseline = super.getBaseline();
            AppMethodBeat.o(99220);
            return baseline;
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.SnsTextView", th, "", new Object[0]);
            AppMethodBeat.o(99220);
            return -1;
        }
    }

    public boolean onPreDraw() {
        AppMethodBeat.i(99221);
        try {
            boolean onPreDraw = super.onPreDraw();
            AppMethodBeat.o(99221);
            return onPreDraw;
        } catch (Throwable th) {
            AppMethodBeat.o(99221);
            return true;
        }
    }
}

package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.NoCopySpan;
import android.text.Spannable;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ai {
    static a[] h(TextView textView) {
        AppMethodBeat.i(131517);
        a[] aVarArr = null;
        if (textView != null && (textView.getText() instanceof Spannable)) {
            Spannable spannable = (Spannable) textView.getText();
            aVarArr = (a[]) spannable.getSpans(0, spannable.length(), a.class);
            for (a aVar : aVarArr) {
                spannable.removeSpan(aVar);
            }
        }
        AppMethodBeat.o(131517);
        return aVarArr;
    }

    static class a implements NoCopySpan {
        public boolean awK;
        public float mX;
        public float mY;
        public int ovp;
        public int ovq;
        public boolean ovr;
        public boolean ovs;
        @Deprecated
        public boolean ovt;

        public a(float f2, float f3, int i2, int i3) {
            this.mX = f2;
            this.mY = f3;
            this.ovp = i2;
            this.ovq = i3;
        }
    }
}

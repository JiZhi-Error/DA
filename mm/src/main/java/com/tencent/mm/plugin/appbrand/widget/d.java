package com.tencent.mm.plugin.appbrand.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Spannable;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.c;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.widget.h.a;

@SuppressLint({"AppCompatCustomView"})
public class d extends TextView implements c.a, f {
    private a lSQ;
    private boolean nak;

    public d(Context context) {
        super(context);
        AppMethodBeat.i(137936);
        super.setIncludeFontPadding(false);
        super.setLineSpacing(0.0f, 1.0f);
        super.setSpannableFactory(new Spannable.Factory() {
            /* class com.tencent.mm.plugin.appbrand.widget.d.AnonymousClass1 */

            public final Spannable newSpannable(CharSequence charSequence) {
                AppMethodBeat.i(137935);
                Spannable newSpannable = super.newSpannable(charSequence);
                if (d.this.lSQ != null && !TextUtils.isEmpty(newSpannable)) {
                    newSpannable.setSpan(d.this.lSQ, 0, newSpannable.length(), 18);
                }
                AppMethodBeat.o(137935);
                return newSpannable;
            }
        });
        AppMethodBeat.o(137936);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ac.c.a
    public void setLineHeight(int i2) {
        AppMethodBeat.i(137937);
        if (this.lSQ == null) {
            this.lSQ = new a((float) i2, 17);
        }
        if (!this.lSQ.aX((float) i2)) {
            AppMethodBeat.o(137937);
            return;
        }
        invalidate();
        AppMethodBeat.o(137937);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        AppMethodBeat.i(137938);
        if (bufferType == TextView.BufferType.NORMAL) {
            bufferType = TextView.BufferType.SPANNABLE;
        }
        super.setText(charSequence, bufferType);
        AppMethodBeat.o(137938);
    }

    public void setInterceptEvent(boolean z) {
        this.nak = z;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.f
    public final boolean bEY() {
        return this.nak;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ac.c.a
    public void setFakeBoldText(boolean z) {
        AppMethodBeat.i(193732);
        getPaint().setFakeBoldText(z);
        AppMethodBeat.o(193732);
    }
}

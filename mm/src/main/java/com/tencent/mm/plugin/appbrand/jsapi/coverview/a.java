package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.d;
import com.tencent.mm.plugin.appbrand.jsapi.ac.c;
import java.util.Objects;

final class a implements c.a {
    private static final ThreadLocal<TextPaint> lSO = new ThreadLocal<TextPaint>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.coverview.a.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.lang.ThreadLocal
        public final /* synthetic */ TextPaint get() {
            AppMethodBeat.i(193649);
            TextPaint textPaint = new TextPaint(1);
            AppMethodBeat.o(193649);
            return textPaint;
        }
    };
    private final TextPaint Ol;
    final d lSP;
    private com.tencent.mm.plugin.appbrand.widget.h.a lSQ;
    private final Resources mResources;
    private CharSequence mText = "";

    static {
        AppMethodBeat.i(193660);
        AppMethodBeat.o(193660);
    }

    public a(Resources resources, int i2) {
        AppMethodBeat.i(193650);
        this.mResources = resources;
        this.Ol = (TextPaint) Objects.requireNonNull(lSO.get());
        this.mText = "";
        this.lSP = d.a(this.mText, this.Ol, i2);
        AppMethodBeat.o(193650);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ac.c.a
    public final void setTextColor(int i2) {
        AppMethodBeat.i(193651);
        this.Ol.setColor(i2);
        AppMethodBeat.o(193651);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ac.c.a
    public final void setTextSize(int i2, float f2) {
        AppMethodBeat.i(193652);
        this.Ol.setTextSize(TypedValue.applyDimension(i2, f2, this.mResources.getDisplayMetrics()));
        AppMethodBeat.o(193652);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ac.c.a
    public final void setGravity(int i2) {
        this.lSP.gravity = i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ac.c.a
    public final void setFakeBoldText(boolean z) {
        AppMethodBeat.i(193653);
        this.Ol.setFakeBoldText(z);
        AppMethodBeat.o(193653);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ac.c.a
    public final void setEllipsize(TextUtils.TruncateAt truncateAt) {
        AppMethodBeat.i(193654);
        this.lSP.a(truncateAt);
        AppMethodBeat.o(193654);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ac.c.a
    public final void setSingleLine(boolean z) {
        AppMethodBeat.i(193655);
        if (z) {
            this.lSP.qi(1);
            AppMethodBeat.o(193655);
            return;
        }
        this.lSP.qi(Integer.MAX_VALUE);
        AppMethodBeat.o(193655);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ac.c.a
    public final void setText(CharSequence charSequence) {
        AppMethodBeat.i(193656);
        if (charSequence == null) {
            charSequence = "";
        }
        if (!charSequence.equals(this.mText)) {
            this.mText = charSequence;
            bGi();
        }
        AppMethodBeat.o(193656);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ac.c.a
    public final float getTextSize() {
        AppMethodBeat.i(193657);
        float textSize = this.Ol.getTextSize();
        AppMethodBeat.o(193657);
        return textSize;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ac.c.a
    public final void setLineHeight(int i2) {
        AppMethodBeat.i(193658);
        if (this.lSQ == null || this.lSQ.aX((float) i2)) {
            this.lSQ = new com.tencent.mm.plugin.appbrand.widget.h.a((float) i2, 16);
            bGi();
        }
        AppMethodBeat.o(193658);
    }

    private void bGi() {
        AppMethodBeat.i(193659);
        if (this.lSQ == null) {
            this.lSP.C(this.mText);
            AppMethodBeat.o(193659);
            return;
        }
        SpannableString spannableString = new SpannableString(this.mText);
        spannableString.setSpan(this.lSQ, 0, spannableString.length(), 18);
        this.lSP.C(spannableString);
        AppMethodBeat.o(193659);
    }
}

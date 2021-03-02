package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Editable;
import android.text.style.StyleSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.Iterator;

public final class b extends e<Boolean, BoldSpan> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText, java.lang.Object] */
    @Override // com.tencent.mm.plugin.wenote.model.nativenote.spans.e, com.tencent.mm.plugin.wenote.model.nativenote.spans.t
    public final /* synthetic */ void a(WXRTEditText wXRTEditText, Boolean bool) {
        AppMethodBeat.i(30628);
        Boolean bool2 = bool;
        e r = r(wXRTEditText);
        int i2 = r.isEmpty() ? 18 : 34;
        Editable text = wXRTEditText.getText();
        Iterator<Object> it = a(text, r, s.SPAN_FLAGS).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean equals = BoldSpan.cEt().equals(bool2);
            int spanStart = text.getSpanStart(next);
            if (spanStart < r.avh) {
                if (equals) {
                    r.kt(r.avh - spanStart, 0);
                    i2 = 34;
                } else {
                    BoldSpan.cEt();
                    text.setSpan(new BoldSpan(), spanStart, r.avh, 33);
                }
            }
            int spanEnd = text.getSpanEnd(next);
            if (spanEnd > r.Pc) {
                if (equals) {
                    r.kt(0, spanEnd - r.Pc);
                } else {
                    BoldSpan.cEt();
                    text.setSpan(new BoldSpan(), r.Pc, spanEnd, 34);
                }
            }
            text.removeSpan(next);
        }
        if (bool2 != null && bool2.booleanValue()) {
            text.setSpan(new BoldSpan(), r.avh, r.Pc, i2);
        }
        AppMethodBeat.o(30628);
    }

    @Override // com.tencent.mm.plugin.wenote.model.nativenote.spans.e
    public final boolean dd(Object obj) {
        AppMethodBeat.i(30625);
        if ((obj instanceof BoldSpan) || ((obj instanceof StyleSpan) && ((StyleSpan) obj).getStyle() == 1)) {
            AppMethodBeat.o(30625);
            return true;
        }
        AppMethodBeat.o(30625);
        return false;
    }

    @Override // com.tencent.mm.plugin.wenote.model.nativenote.spans.t
    public final int cEq() {
        return 0;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.wenote.model.nativenote.spans.g' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wenote.model.nativenote.spans.e
    public final /* synthetic */ g<Boolean> gjY() {
        AppMethodBeat.i(30626);
        BoldSpan boldSpan = new BoldSpan();
        AppMethodBeat.o(30626);
        return boldSpan;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wenote.model.nativenote.spans.e
    public final /* synthetic */ Boolean cEs() {
        AppMethodBeat.i(30627);
        Boolean cEt = BoldSpan.cEt();
        AppMethodBeat.o(30627);
        return cEt;
    }
}

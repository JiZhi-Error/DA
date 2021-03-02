package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.Editable;
import android.text.style.StyleSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.g;
import java.util.Iterator;

public final class b extends e<Boolean, BoldSpan> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText, java.lang.Object] */
    @Override // com.tencent.mm.plugin.editor.model.nativenote.spans.t, com.tencent.mm.plugin.editor.model.nativenote.spans.e
    public final /* synthetic */ void a(WXRTEditText wXRTEditText, Boolean bool) {
        AppMethodBeat.i(181929);
        Boolean bool2 = bool;
        g r = r(wXRTEditText);
        int i2 = r.isEmpty() ? 18 : 34;
        Editable text = wXRTEditText.getText();
        Iterator<Object> it = a(text, r, q.SPAN_FLAGS).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean equals = BoldSpan.cEt().equals(bool2);
            int spanStart = text.getSpanStart(next);
            if (spanStart < r.avh) {
                if (equals) {
                    r.fy(r.avh - spanStart, 0);
                    i2 = 34;
                } else {
                    BoldSpan.cEt();
                    text.setSpan(new BoldSpan(), spanStart, r.avh, 33);
                }
            }
            int spanEnd = text.getSpanEnd(next);
            if (spanEnd > r.Pc) {
                if (equals) {
                    r.fy(0, spanEnd - r.Pc);
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
        AppMethodBeat.o(181929);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.spans.e
    public final boolean dd(Object obj) {
        AppMethodBeat.i(181926);
        if ((obj instanceof BoldSpan) || ((obj instanceof StyleSpan) && ((StyleSpan) obj).getStyle() == 1)) {
            AppMethodBeat.o(181926);
            return true;
        }
        AppMethodBeat.o(181926);
        return false;
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.spans.t
    public final int cEq() {
        return 0;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.editor.model.nativenote.spans.h' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.editor.model.nativenote.spans.e
    public final /* synthetic */ h<Boolean> cEr() {
        AppMethodBeat.i(181927);
        BoldSpan boldSpan = new BoldSpan();
        AppMethodBeat.o(181927);
        return boldSpan;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.editor.model.nativenote.spans.e
    public final /* synthetic */ Boolean cEs() {
        AppMethodBeat.i(181928);
        Boolean cEt = BoldSpan.cEt();
        AppMethodBeat.o(181928);
        return cEt;
    }
}

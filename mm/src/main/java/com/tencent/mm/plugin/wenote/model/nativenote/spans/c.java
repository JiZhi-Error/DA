package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.ArrayList;

public final class c extends o<Boolean, d> {
    private p JIV = new p();

    public c() {
        AppMethodBeat.i(30629);
        AppMethodBeat.o(30629);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText, com.tencent.mm.plugin.wenote.model.nativenote.manager.e, java.lang.Object] */
    @Override // com.tencent.mm.plugin.wenote.model.nativenote.spans.o
    public final /* synthetic */ void a(WXRTEditText wXRTEditText, e eVar, Boolean bool) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(30630);
        Boolean bool2 = bool;
        Spannable text = wXRTEditText.getText();
        if (bool2 == null) {
            bool2 = Boolean.FALSE;
        }
        this.JIV.qTl.clear();
        ArrayList<n> paragraphs = wXRTEditText.getParagraphs();
        int size = paragraphs.size();
        for (int i2 = 0; i2 < size; i2++) {
            n nVar = paragraphs.get(i2);
            ArrayList<Object> a2 = a(text, nVar, s.SPAN_FLAGS);
            this.JIV.a(a2, nVar);
            boolean z3 = !a2.isEmpty();
            if (nVar.a(eVar)) {
                z = bool2.booleanValue();
            } else {
                z = z3;
            }
            if (i2 > 0 && nVar.getLen() == 1 && paragraphs.get(i2 - 1).getLen() == 1 && !bool2.booleanValue()) {
                z2 = false;
            } else {
                z2 = z;
            }
            if (z2) {
                this.JIV.b(new d(b.cDE(), nVar.isEmpty(), nVar.qTj, nVar.qTk), nVar);
                u.JJk.a(text, nVar, this.JIV);
                u.JJi.a(text, nVar, this.JIV);
            }
        }
        this.JIV.c(text);
        AppMethodBeat.o(30630);
    }

    @Override // com.tencent.mm.plugin.wenote.model.nativenote.spans.t
    public final int cEq() {
        return 1;
    }
}

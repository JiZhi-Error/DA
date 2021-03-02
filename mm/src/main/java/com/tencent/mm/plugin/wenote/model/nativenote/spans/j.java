package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.ArrayList;
import java.util.Iterator;

public final class j extends o<Boolean, k> {
    private p JIV = new p();

    public j() {
        AppMethodBeat.i(30639);
        AppMethodBeat.o(30639);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText, com.tencent.mm.plugin.wenote.model.nativenote.manager.e, java.lang.Object] */
    @Override // com.tencent.mm.plugin.wenote.model.nativenote.spans.o
    public final /* synthetic */ void a(WXRTEditText wXRTEditText, e eVar, Boolean bool) {
        k kVar;
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(30640);
        Boolean bool2 = bool;
        Spannable text = wXRTEditText.getText();
        if (bool2 == null) {
            bool2 = Boolean.FALSE;
        }
        this.JIV.qTl.clear();
        ArrayList<n> paragraphs = wXRTEditText.getParagraphs();
        int size = paragraphs.size();
        int i2 = 0;
        k kVar2 = null;
        while (i2 < size) {
            n nVar = paragraphs.get(i2);
            ArrayList<Object> a2 = a(text, nVar, s.SPAN_FLAGS);
            this.JIV.a(a2, nVar);
            if (a2.isEmpty() || !(a2.get(0) instanceof k)) {
                kVar = null;
            } else {
                kVar = (k) a2.get(0);
            }
            boolean z4 = kVar != null && kVar.qTF;
            if (kVar2 != null && kVar2 == kVar && z4) {
                z4 = false;
            }
            boolean z5 = !a2.isEmpty();
            if (nVar.a(eVar)) {
                z = bool2.booleanValue();
            } else {
                z = z5;
            }
            if (i2 <= 0 || nVar.getLen() != 1 || paragraphs.get(i2 - 1).getLen() != 1 || bool2.booleanValue()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                z3 = false;
            } else {
                z3 = z;
            }
            if (z3) {
                this.JIV.b(new k(z4, b.cDE(), nVar.isEmpty(), nVar.qTj, nVar.qTk), nVar);
                u.JJk.a(text, nVar, this.JIV);
                u.JJj.a(text, nVar, this.JIV);
            }
            if (!z3 && z5) {
                Iterator<Object> it = a2.iterator();
                while (it.hasNext()) {
                    text.removeSpan(it.next());
                }
            }
            i2++;
            kVar2 = kVar;
        }
        this.JIV.c(text);
        AppMethodBeat.o(30640);
    }

    @Override // com.tencent.mm.plugin.wenote.model.nativenote.spans.t
    public final int cEq() {
        return 3;
    }
}

package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.ArrayList;

public final class l extends o<Boolean, m> {
    private p JIV = new p();

    public l() {
        AppMethodBeat.i(30646);
        AppMethodBeat.o(30646);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText, com.tencent.mm.plugin.wenote.model.nativenote.manager.e, java.lang.Object] */
    @Override // com.tencent.mm.plugin.wenote.model.nativenote.spans.o
    public final /* synthetic */ void a(WXRTEditText wXRTEditText, e eVar, Boolean bool) {
        int i2;
        boolean z;
        boolean z2;
        int i3;
        AppMethodBeat.i(30647);
        Boolean bool2 = bool;
        Spannable text = wXRTEditText.getText();
        if (bool2 == null) {
            bool2 = Boolean.FALSE;
        }
        this.JIV.qTl.clear();
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        ArrayList<n> paragraphs = wXRTEditText.getParagraphs();
        int size = paragraphs.size();
        int i4 = 0;
        int i5 = 1;
        while (i4 < size) {
            n nVar = paragraphs.get(i4);
            int i6 = 0;
            ArrayList<Object> a2 = u.JJl.a(text, nVar, s.EXACT);
            if (!a2.isEmpty()) {
                for (Object obj : a2) {
                    if (obj instanceof g) {
                        i6 = ((Integer) ((g) obj).getValue()).intValue() + i6;
                    } else {
                        i6 = i6;
                    }
                }
                i2 = i6;
            } else {
                i2 = 0;
            }
            sparseIntArray.put(i5, i2);
            ArrayList<Object> a3 = a(text, nVar, s.SPAN_FLAGS);
            this.JIV.a(a3, nVar);
            boolean z3 = !a3.isEmpty();
            if (nVar.a(eVar)) {
                z = bool2.booleanValue();
            } else {
                z = z3;
            }
            if (i4 > 0 && nVar.getLen() == 1 && paragraphs.get(i4 - 1).getLen() == 1 && !bool2.booleanValue()) {
                z2 = false;
            } else {
                z2 = z;
            }
            if (z2) {
                int i7 = 1;
                for (int i8 = 1; i8 < i5; i8++) {
                    int i9 = sparseIntArray.get(i8);
                    int i10 = sparseIntArray2.get(i8);
                    if (i9 < i2) {
                        i3 = 1;
                    } else if (i9 == i2) {
                        i3 = i10 == 0 ? 1 : i10 + 1;
                    }
                    i7 = i3;
                }
                sparseIntArray2.put(i5, i7);
                this.JIV.b(new m(i7, b.cDE(), nVar.isEmpty(), nVar.qTj, nVar.qTk), nVar);
                u.JJj.a(text, nVar, this.JIV);
                u.JJi.a(text, nVar, this.JIV);
            }
            i4++;
            i5++;
        }
        this.JIV.c(text);
        AppMethodBeat.o(30647);
    }

    @Override // com.tencent.mm.plugin.wenote.model.nativenote.spans.t
    public final int cEq() {
        return 2;
    }
}

package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.f;
import com.tencent.mm.plugin.editor.model.nativenote.manager.g;
import java.util.ArrayList;
import java.util.Iterator;

public final class r extends m<Boolean, s> {
    private n qTb = new n();

    public r() {
        AppMethodBeat.i(181961);
        AppMethodBeat.o(181961);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText, com.tencent.mm.plugin.editor.model.nativenote.manager.g, java.lang.Object] */
    @Override // com.tencent.mm.plugin.editor.model.nativenote.spans.m
    public final /* synthetic */ void a(WXRTEditText wXRTEditText, g gVar, Boolean bool) {
        s sVar;
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(181962);
        Boolean bool2 = bool;
        Spannable text = wXRTEditText.getText();
        if (bool2 == null) {
            bool2 = Boolean.FALSE;
        }
        this.qTb.qTl.clear();
        ArrayList<l> paragraphs = wXRTEditText.getParagraphs();
        int size = paragraphs.size();
        int i2 = 0;
        s sVar2 = null;
        while (i2 < size) {
            l lVar = paragraphs.get(i2);
            ArrayList<Object> a2 = a(text, lVar, q.SPAN_FLAGS);
            this.qTb.a(a2, lVar);
            if (a2.isEmpty() || !(a2.get(0) instanceof s)) {
                sVar = null;
            } else {
                sVar = (s) a2.get(0);
            }
            boolean z4 = sVar != null && sVar.qTF;
            if (sVar2 != null && sVar2 == sVar && z4) {
                z4 = false;
            }
            boolean z5 = !a2.isEmpty();
            if (lVar.a(gVar)) {
                z = bool2.booleanValue();
            } else {
                z = z5;
            }
            if (i2 <= 0 || lVar.getLen() != 1 || paragraphs.get(i2 - 1).getLen() != 1 || bool2.booleanValue()) {
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
                this.qTb.b(new s(z4, f.cDE(), lVar.isEmpty(), lVar.qTj, lVar.qTk), lVar);
                u.qTK.a(text, lVar, this.qTb);
                u.qTJ.a(text, lVar, this.qTb);
            }
            if (!z3 && z5) {
                Iterator<Object> it = a2.iterator();
                while (it.hasNext()) {
                    text.removeSpan(it.next());
                }
            }
            i2++;
            sVar2 = sVar;
        }
        this.qTb.c(text);
        AppMethodBeat.o(181962);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.spans.t
    public final int cEq() {
        return 3;
    }
}

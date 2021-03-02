package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.f;
import com.tencent.mm.plugin.editor.model.nativenote.manager.g;
import java.util.ArrayList;

public final class c extends m<Boolean, d> {
    private n qTb = new n();

    public c() {
        AppMethodBeat.i(181930);
        AppMethodBeat.o(181930);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText, com.tencent.mm.plugin.editor.model.nativenote.manager.g, java.lang.Object] */
    @Override // com.tencent.mm.plugin.editor.model.nativenote.spans.m
    public final /* synthetic */ void a(WXRTEditText wXRTEditText, g gVar, Boolean bool) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(181931);
        Boolean bool2 = bool;
        Spannable text = wXRTEditText.getText();
        if (bool2 == null) {
            bool2 = Boolean.FALSE;
        }
        this.qTb.qTl.clear();
        ArrayList<l> paragraphs = wXRTEditText.getParagraphs();
        int size = paragraphs.size();
        for (int i2 = 0; i2 < size; i2++) {
            l lVar = paragraphs.get(i2);
            ArrayList<Object> a2 = a(text, lVar, q.SPAN_FLAGS);
            this.qTb.a(a2, lVar);
            boolean z3 = !a2.isEmpty();
            if (lVar.a(gVar)) {
                z = bool2.booleanValue();
            } else {
                z = z3;
            }
            if (i2 > 0 && lVar.getLen() == 1 && paragraphs.get(i2 - 1).getLen() == 1 && !bool2.booleanValue()) {
                z2 = false;
            } else {
                z2 = z;
            }
            if (z2) {
                this.qTb.b(new d(f.cDE(), lVar.isEmpty(), lVar.qTj, lVar.qTk), lVar);
                u.qTK.a(text, lVar, this.qTb);
                u.qTI.a(text, lVar, this.qTb);
            }
        }
        this.qTb.c(text);
        AppMethodBeat.o(181931);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.spans.t
    public final int cEq() {
        return 1;
    }
}

package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.Spannable;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.f;
import com.tencent.mm.plugin.editor.model.nativenote.manager.g;
import java.util.ArrayList;

public final class j extends m<Boolean, k> {
    private n qTb = new n();

    public j() {
        AppMethodBeat.i(181940);
        AppMethodBeat.o(181940);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText, com.tencent.mm.plugin.editor.model.nativenote.manager.g, java.lang.Object] */
    @Override // com.tencent.mm.plugin.editor.model.nativenote.spans.m
    public final /* synthetic */ void a(WXRTEditText wXRTEditText, g gVar, Boolean bool) {
        int i2;
        boolean z;
        boolean z2;
        int i3;
        AppMethodBeat.i(181941);
        Boolean bool2 = bool;
        Spannable text = wXRTEditText.getText();
        if (bool2 == null) {
            bool2 = Boolean.FALSE;
        }
        this.qTb.qTl.clear();
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        ArrayList<l> paragraphs = wXRTEditText.getParagraphs();
        int size = paragraphs.size();
        int i4 = 0;
        int i5 = 1;
        while (i4 < size) {
            l lVar = paragraphs.get(i4);
            int i6 = 0;
            ArrayList<Object> a2 = u.qTL.a(text, lVar, q.EXACT);
            if (!a2.isEmpty()) {
                for (Object obj : a2) {
                    if (obj instanceof h) {
                        i6 = ((Integer) ((h) obj).getValue()).intValue() + i6;
                    } else {
                        i6 = i6;
                    }
                }
                i2 = i6;
            } else {
                i2 = 0;
            }
            sparseIntArray.put(i5, i2);
            ArrayList<Object> a3 = a(text, lVar, q.SPAN_FLAGS);
            this.qTb.a(a3, lVar);
            boolean z3 = !a3.isEmpty();
            if (lVar.a(gVar)) {
                z = bool2.booleanValue();
            } else {
                z = z3;
            }
            if (i4 > 0 && lVar.getLen() == 1 && paragraphs.get(i4 - 1).getLen() == 1 && !bool2.booleanValue()) {
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
                this.qTb.b(new k(i7, f.cDE(), lVar.isEmpty(), lVar.qTj, lVar.qTk), lVar);
                u.qTJ.a(text, lVar, this.qTb);
                u.qTI.a(text, lVar, this.qTb);
            }
            i4++;
            i5++;
        }
        this.qTb.c(text);
        AppMethodBeat.o(181941);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.spans.t
    public final int cEq() {
        return 2;
    }
}

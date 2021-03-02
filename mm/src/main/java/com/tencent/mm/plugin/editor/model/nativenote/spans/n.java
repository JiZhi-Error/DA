package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class n {
    final ArrayList<a> qTl = new ArrayList<>();

    public n() {
        AppMethodBeat.i(181949);
        AppMethodBeat.o(181949);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        final g qTm;
        final l qTn;
        final boolean qTo;

        a(Object obj, l lVar, boolean z) {
            AppMethodBeat.i(181948);
            this.qTm = (g) obj;
            this.qTn = lVar;
            this.qTo = z;
            AppMethodBeat.o(181948);
        }
    }

    public final void a(ArrayList<Object> arrayList, l lVar) {
        AppMethodBeat.i(181950);
        Iterator<Object> it = arrayList.iterator();
        while (it.hasNext()) {
            a(it.next(), lVar);
        }
        AppMethodBeat.o(181950);
    }

    private void a(Object obj, l lVar) {
        AppMethodBeat.i(181951);
        if (obj instanceof g) {
            this.qTl.add(new a(obj, lVar, true));
        }
        AppMethodBeat.o(181951);
    }

    public final void b(Object obj, l lVar) {
        AppMethodBeat.i(181952);
        this.qTl.add(new a(obj, lVar, false));
        AppMethodBeat.o(181952);
    }

    public final void c(Spannable spannable) {
        int i2;
        AppMethodBeat.i(181953);
        Iterator<a> it = this.qTl.iterator();
        while (it.hasNext()) {
            a next = it.next();
            g gVar = next.qTm;
            int i3 = next.qTn.avh;
            if (next.qTo) {
                int spanStart = spannable.getSpanStart(gVar);
                if (spanStart >= 0 && spanStart < i3) {
                    spannable.setSpan(gVar.cEu(), spanStart, i3, 34);
                }
                spannable.removeSpan(gVar);
            } else {
                l lVar = next.qTn;
                int i4 = next.qTn.Pc;
                if (lVar.qTk && lVar.isEmpty()) {
                    i2 = 34;
                } else if (!lVar.qTk || !lVar.qTj) {
                    i2 = lVar.qTk ? 34 : 33;
                } else {
                    i2 = 18;
                }
                if (i4 > spannable.length()) {
                    i4 = spannable.length();
                }
                spannable.setSpan(gVar, i3, i4, i2);
            }
        }
        AppMethodBeat.o(181953);
    }
}

package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class p {
    final ArrayList<a> qTl = new ArrayList<>();

    public p() {
        AppMethodBeat.i(30655);
        AppMethodBeat.o(30655);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        final f JIX;
        final n JIY;
        final boolean qTo;

        a(Object obj, n nVar, boolean z) {
            AppMethodBeat.i(30654);
            this.JIX = (f) obj;
            this.JIY = nVar;
            this.qTo = z;
            AppMethodBeat.o(30654);
        }
    }

    public final void a(ArrayList<Object> arrayList, n nVar) {
        AppMethodBeat.i(30656);
        Iterator<Object> it = arrayList.iterator();
        while (it.hasNext()) {
            a(it.next(), nVar);
        }
        AppMethodBeat.o(30656);
    }

    private void a(Object obj, n nVar) {
        AppMethodBeat.i(30657);
        if (obj instanceof f) {
            this.qTl.add(new a(obj, nVar, true));
        }
        AppMethodBeat.o(30657);
    }

    public final void b(Object obj, n nVar) {
        AppMethodBeat.i(30658);
        this.qTl.add(new a(obj, nVar, false));
        AppMethodBeat.o(30658);
    }

    public final void c(Spannable spannable) {
        int i2;
        AppMethodBeat.i(30659);
        Iterator<a> it = this.qTl.iterator();
        while (it.hasNext()) {
            a next = it.next();
            f fVar = next.JIX;
            int i3 = next.JIY.avh;
            if (next.qTo) {
                int spanStart = spannable.getSpanStart(fVar);
                if (spanStart >= 0 && spanStart < i3) {
                    spannable.setSpan(fVar.gjZ(), spanStart, i3, 34);
                }
                spannable.removeSpan(fVar);
            } else {
                n nVar = next.JIY;
                int i4 = next.JIY.Pc;
                if (nVar.qTk && nVar.isEmpty()) {
                    i2 = 34;
                } else if (!nVar.qTk || !nVar.qTj) {
                    i2 = nVar.qTk ? 34 : 33;
                } else {
                    i2 = 18;
                }
                if (i4 > spannable.length()) {
                    i4 = spannable.length();
                }
                spannable.setSpan(fVar, i3, i4, i2);
            }
        }
        AppMethodBeat.o(30659);
    }
}

package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.Editable;
import android.text.Spannable;
import android.text.style.CharacterStyle;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.g;
import com.tencent.mm.plugin.editor.model.nativenote.spans.h;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class e<V, C extends h<V>> extends t<V, C> {
    /* access modifiers changed from: protected */
    public abstract h<V> cEr();

    /* access modifiers changed from: protected */
    public abstract V cEs();

    public abstract boolean dd(Object obj);

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.editor.model.nativenote.spans.t
    public final g r(WXRTEditText wXRTEditText) {
        return new g(wXRTEditText);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.spans.t
    public void a(WXRTEditText wXRTEditText, V v) {
        g r = r(wXRTEditText);
        int i2 = r.isEmpty() ? 18 : 34;
        Editable text = wXRTEditText.getText();
        Iterator<Object> it = a(text, r, q.SPAN_FLAGS).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean equals = cEs().equals(v);
            int spanStart = text.getSpanStart(next);
            if (spanStart < r.avh) {
                if (equals) {
                    r.fy(r.avh - spanStart, 0);
                    i2 = 34;
                } else {
                    cEs();
                    text.setSpan(cEr(), spanStart, r.avh, 33);
                }
            }
            int spanEnd = text.getSpanEnd(next);
            if (spanEnd > r.Pc) {
                if (equals) {
                    r.fy(0, spanEnd - r.Pc);
                } else {
                    cEs();
                    text.setSpan(cEr(), r.Pc, spanEnd, 34);
                }
            }
            text.removeSpan(next);
        }
        if (v != null) {
            text.setSpan(cEr(), r.avh, r.Pc, i2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.editor.model.nativenote.spans.t
    public final ArrayList<Object> a(Spannable spannable, g gVar, q qVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        Object[] spans = spannable.getSpans(Math.max(0, gVar.avh - 1), Math.min(spannable.length(), gVar.Pc + 1), CharacterStyle.class);
        for (Object obj : spans) {
            if (dd(obj) && a(spannable, gVar, obj, qVar)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private static boolean a(Spannable spannable, g gVar, Object obj, q qVar) {
        int spanStart = spannable.getSpanStart(obj);
        int spanEnd = spannable.getSpanEnd(obj);
        int i2 = gVar.avh;
        int i3 = gVar.Pc;
        int max = Math.max(spanStart, i2);
        int min = Math.min(spanEnd, i3);
        if (max > min) {
            return false;
        }
        if (max < min) {
            return true;
        }
        if ((spanStart > i2 && spanEnd < i3) || (i2 > spanStart && i3 < spanEnd)) {
            return true;
        }
        if (qVar == q.EXACT) {
            return false;
        }
        int spanFlags = spannable.getSpanFlags(obj) & 51;
        if (spanEnd == i2) {
            return e(spanFlags, 34, 18);
        }
        return e(spanFlags, 17, 18);
    }
}

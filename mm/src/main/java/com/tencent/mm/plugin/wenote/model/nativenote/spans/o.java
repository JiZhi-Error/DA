package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.g;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class o<V, C extends g<V>> extends t<V, C> {
    public abstract void a(WXRTEditText wXRTEditText, e eVar, V v);

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wenote.model.nativenote.spans.t
    public final e r(WXRTEditText wXRTEditText) {
        return wXRTEditText.getParagraphsInSelection();
    }

    @Override // com.tencent.mm.plugin.wenote.model.nativenote.spans.t
    public final void a(WXRTEditText wXRTEditText, V v) {
        e paragraphsInSelection = wXRTEditText.getParagraphsInSelection();
        if (wXRTEditText.qRq && wXRTEditText.getSelection().avh == paragraphsInSelection.avh && paragraphsInSelection.avh > 1) {
            ArrayList<Object> a2 = a(wXRTEditText.getText(), paragraphsInSelection, s.SPAN_FLAGS);
            if (!a2.isEmpty() && wXRTEditText.getLayout().getPrimaryHorizontal(wXRTEditText.getSelection().avh) == ((float) b.cDE())) {
                Iterator<Object> it = a2.iterator();
                while (it.hasNext()) {
                    wXRTEditText.getText().removeSpan(it.next());
                }
                wXRTEditText.getText().insert(paragraphsInSelection.avh - 1, "\n");
            }
        }
        a(wXRTEditText, paragraphsInSelection, v);
        u.a(wXRTEditText, this);
    }

    /* access modifiers changed from: protected */
    public final void a(Spannable spannable, n nVar, p pVar) {
        pVar.a(a(spannable, nVar, s.EXACT), nVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wenote.model.nativenote.spans.t
    public final ArrayList<Object> a(Spannable spannable, e eVar, s sVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        Type[] actualTypeArguments = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
        if (actualTypeArguments == null) {
            return null;
        }
        Object[] spans = spannable.getSpans(eVar.avh, eVar.Pc, (Class) actualTypeArguments[actualTypeArguments.length - 1]);
        for (Object obj : spans) {
            if (a(spannable, eVar, obj, sVar)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private static boolean a(Spannable spannable, e eVar, Object obj, s sVar) {
        int spanStart = spannable.getSpanStart(obj);
        int spanEnd = spannable.getSpanEnd(obj);
        int i2 = eVar.avh;
        int i3 = eVar.Pc;
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
        if (sVar == s.EXACT) {
            return spanStart == i2 && spanEnd == i3 && i2 == i3;
        }
        int spanFlags = spannable.getSpanFlags(obj) & 51;
        if (spanEnd == i2) {
            return e(spanFlags, 34, 18);
        }
        return e(spanFlags, 17, 18);
    }
}

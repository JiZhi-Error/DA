package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.f;
import com.tencent.mm.plugin.editor.model.nativenote.manager.g;
import com.tencent.mm.plugin.editor.model.nativenote.spans.h;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class m<V, C extends h<V>> extends t<V, C> {
    public abstract void a(WXRTEditText wXRTEditText, g gVar, V v);

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.editor.model.nativenote.spans.t
    public final g r(WXRTEditText wXRTEditText) {
        return wXRTEditText.getParagraphsInSelection();
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.spans.t
    public final void a(WXRTEditText wXRTEditText, V v) {
        g paragraphsInSelection = wXRTEditText.getParagraphsInSelection();
        if (wXRTEditText.qRq && wXRTEditText.getSelection().avh == paragraphsInSelection.avh && paragraphsInSelection.avh > 1) {
            ArrayList<Object> a2 = a(wXRTEditText.getText(), paragraphsInSelection, q.SPAN_FLAGS);
            if (!a2.isEmpty() && wXRTEditText.getLayout().getPrimaryHorizontal(wXRTEditText.getSelection().avh) == ((float) f.cDE())) {
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
    public final void a(Spannable spannable, l lVar, n nVar) {
        nVar.a(a(spannable, lVar, q.EXACT), lVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.editor.model.nativenote.spans.t
    public final ArrayList<Object> a(Spannable spannable, g gVar, q qVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        Type[] actualTypeArguments = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
        if (actualTypeArguments == null) {
            return null;
        }
        Object[] spans = spannable.getSpans(gVar.avh, gVar.Pc, (Class) actualTypeArguments[actualTypeArguments.length - 1]);
        for (Object obj : spans) {
            if (a(spannable, gVar, obj, qVar)) {
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
            return spanStart == i2 && spanEnd == i3 && i2 == i3;
        }
        int spanFlags = spannable.getSpanFlags(obj) & 51;
        if (spanEnd == i2) {
            return e(spanFlags, 34, 18);
        }
        return e(spanFlags, 17, 18);
    }
}

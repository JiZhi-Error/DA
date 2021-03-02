package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.g;
import com.tencent.mm.plugin.editor.model.nativenote.spans.h;
import java.util.ArrayList;

public abstract class t<V, C extends h<V>> {
    /* access modifiers changed from: protected */
    public abstract ArrayList<Object> a(Spannable spannable, g gVar, q qVar);

    public abstract void a(WXRTEditText wXRTEditText, V v);

    public abstract int cEq();

    /* access modifiers changed from: protected */
    public abstract g r(WXRTEditText wXRTEditText);

    public final boolean s(WXRTEditText wXRTEditText) {
        return !a(wXRTEditText.getText(), r(wXRTEditText), q.SPAN_FLAGS).isEmpty();
    }

    protected static boolean e(int i2, int... iArr) {
        for (int i3 = 0; i3 < 2; i3++) {
            int i4 = iArr[i3];
            if ((i2 & i4) == i4) {
                return true;
            }
        }
        return false;
    }
}

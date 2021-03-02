package com.tencent.neattextview.textview.layout;

import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

public final class e<E> {
    private final Class<? extends E> RBJ;
    public int RBK = 0;
    public E[] RBL;
    public int[] RBM;
    public int[] RBN;
    public int[] RBO;

    e(Class<? extends E> cls) {
        this.RBJ = cls;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: E[] */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Spanned spanned, int i2) {
        AppMethodBeat.i(39760);
        Object[] spans = spanned.getSpans(0, i2, this.RBJ);
        int length = spans.length;
        if (length > 0 && (this.RBL == null || this.RBL.length < length)) {
            this.RBL = (E[]) ((Object[]) Array.newInstance(this.RBJ, length));
            this.RBM = new int[length];
            this.RBN = new int[length];
            this.RBO = new int[length];
        }
        this.RBK = 0;
        for (Object obj : spans) {
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (spanStart != spanEnd) {
                int spanFlags = spanned.getSpanFlags(obj);
                this.RBL[this.RBK] = obj;
                this.RBM[this.RBK] = spanStart;
                this.RBN[this.RBK] = spanEnd;
                this.RBO[this.RBK] = spanFlags;
                this.RBK++;
            }
        }
        AppMethodBeat.o(39760);
    }

    public final E mp(int i2, int i3) {
        for (int i4 = 0; i4 < this.RBK; i4++) {
            if (this.RBM[i4] < i3 && this.RBN[i4] > i2) {
                return this.RBL[i4];
            }
        }
        return null;
    }
}

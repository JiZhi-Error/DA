package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

public final class a extends SpannableString {
    private int apM;
    private Object[] qQl;
    private int[] qQm;

    public a(CharSequence charSequence) {
        super(charSequence.toString());
        AppMethodBeat.i(30401);
        h(charSequence, charSequence.length());
        AppMethodBeat.o(30401);
    }

    private void h(CharSequence charSequence, int i2) {
        AppMethodBeat.i(30402);
        this.qQl = new Object[20];
        this.qQm = new int[60];
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            Object[] spans = spanned.getSpans(0, i2, Object.class);
            for (Object obj : spans) {
                if ((obj instanceof CharacterStyle) || (obj instanceof ParagraphStyle)) {
                    int spanStart = spanned.getSpanStart(obj);
                    int spanEnd = spanned.getSpanEnd(obj);
                    int spanFlags = spanned.getSpanFlags(obj);
                    if (spanStart < 0) {
                        spanStart = 0;
                    }
                    if (spanEnd > i2) {
                        spanEnd = i2;
                    }
                    setSpan(obj, spanStart + 0, spanEnd + 0, spanFlags);
                }
            }
        }
        AppMethodBeat.o(30402);
    }

    public final void setSpan(Object obj, int i2, int i3, int i4) {
        AppMethodBeat.i(30403);
        if (this.apM + 1 >= this.qQl.length) {
            int i5 = this.apM + 10;
            Object[] objArr = new Object[i5];
            int[] iArr = new int[(i5 * 3)];
            System.arraycopy(this.qQl, 0, objArr, 0, this.apM);
            System.arraycopy(this.qQm, 0, iArr, 0, this.apM * 3);
            this.qQl = objArr;
            this.qQm = iArr;
        }
        this.qQl[this.apM] = obj;
        this.qQm[(this.apM * 3) + 0] = i2;
        this.qQm[(this.apM * 3) + 1] = i3;
        this.qQm[(this.apM * 3) + 2] = i4;
        this.apM++;
        AppMethodBeat.o(30403);
    }

    public final void removeSpan(Object obj) {
        AppMethodBeat.i(30404);
        int i2 = this.apM;
        Object[] objArr = this.qQl;
        int[] iArr = this.qQm;
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (objArr[i3] == obj) {
                int i4 = i2 - (i3 + 1);
                System.arraycopy(objArr, i3 + 1, objArr, i3, i4);
                System.arraycopy(iArr, (i3 + 1) * 3, iArr, i3 * 3, i4 * 3);
                this.apM--;
                AppMethodBeat.o(30404);
                return;
            }
        }
        AppMethodBeat.o(30404);
    }

    public final int getSpanStart(Object obj) {
        int i2 = this.apM;
        Object[] objArr = this.qQl;
        int[] iArr = this.qQm;
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (objArr[i3] == obj) {
                return iArr[(i3 * 3) + 0];
            }
        }
        return -1;
    }

    public final int getSpanEnd(Object obj) {
        int i2 = this.apM;
        Object[] objArr = this.qQl;
        int[] iArr = this.qQm;
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (objArr[i3] == obj) {
                return iArr[(i3 * 3) + 1];
            }
        }
        return -1;
    }

    public final int getSpanFlags(Object obj) {
        int i2 = this.apM;
        Object[] objArr = this.qQl;
        int[] iArr = this.qQm;
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (objArr[i3] == obj) {
                return iArr[(i3 * 3) + 2];
            }
        }
        return 0;
    }

    @Override // android.text.Spanned, android.text.SpannableString
    public final <T> T[] getSpans(int i2, int i3, Class<T> cls) {
        AppMethodBeat.i(30405);
        int i4 = 0;
        int i5 = this.apM;
        Object[] objArr = this.qQl;
        int[] iArr = this.qQm;
        Object[] objArr2 = null;
        Object obj = null;
        for (int i6 = 0; i6 < i5; i6++) {
            if (cls == null || cls.isInstance(objArr[i6])) {
                int i7 = iArr[(i6 * 3) + 0];
                int i8 = iArr[(i6 * 3) + 1];
                if (i7 <= i3 && i8 >= i2 && (i7 == i8 || i2 == i3 || !(i7 == i3 || i8 == i2))) {
                    if (i4 == 0) {
                        obj = objArr[i6];
                        i4++;
                    } else {
                        if (i4 == 1) {
                            objArr2 = (Object[]) Array.newInstance((Class<?>) cls, (i5 - i6) + 1);
                            objArr2[0] = obj;
                        }
                        int i9 = 16711680 & iArr[(i6 * 3) + 2];
                        if (i9 != 0) {
                            int i10 = 0;
                            while (i10 < i4 && i9 <= (getSpanFlags(objArr2[i10]) & 16711680)) {
                                i10++;
                            }
                            System.arraycopy(objArr2, i10, objArr2, i10 + 1, i4 - i10);
                            objArr2[i10] = objArr[i6];
                            i4++;
                        } else {
                            objArr2[i4] = objArr[i6];
                            i4++;
                        }
                    }
                }
            }
        }
        if (i4 == 0) {
            T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, 0));
            AppMethodBeat.o(30405);
            return tArr;
        } else if (i4 == 1) {
            Object[] objArr3 = (Object[]) Array.newInstance((Class<?>) cls, 1);
            objArr3[0] = obj;
            T[] tArr2 = (T[]) objArr3;
            AppMethodBeat.o(30405);
            return tArr2;
        } else if (i4 == objArr2.length) {
            T[] tArr3 = (T[]) objArr2;
            AppMethodBeat.o(30405);
            return tArr3;
        } else {
            Object[] objArr4 = (Object[]) Array.newInstance((Class<?>) cls, i4);
            System.arraycopy(objArr2, 0, objArr4, 0, i4);
            T[] tArr4 = (T[]) objArr4;
            AppMethodBeat.o(30405);
            return tArr4;
        }
    }

    public final int nextSpanTransition(int i2, int i3, Class cls) {
        AppMethodBeat.i(30406);
        int i4 = this.apM;
        Object[] objArr = this.qQl;
        int[] iArr = this.qQm;
        if (cls == null) {
            cls = Object.class;
        }
        int i5 = 0;
        int i6 = i3;
        while (i5 < i4) {
            int i7 = iArr[(i5 * 3) + 0];
            int i8 = iArr[(i5 * 3) + 1];
            if (i7 <= i2 || i7 >= i6 || !cls.isInstance(objArr[i5])) {
                i7 = i6;
            }
            if (i8 <= i2 || i8 >= i7 || !cls.isInstance(objArr[i5])) {
                i8 = i7;
            }
            i5++;
            i6 = i8;
        }
        AppMethodBeat.o(30406);
        return i6;
    }
}

package com.tencent.mm.pluginsdk.ui.span;

import android.text.GetChars;
import android.text.Spannable;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m implements GetChars, Spannable, CharSequence {
    private SpannableString Krh;

    public m() {
        AppMethodBeat.i(152310);
        this.Krh = null;
        this.Krh = new SpannableString("");
        AppMethodBeat.o(152310);
    }

    public m(CharSequence charSequence) {
        AppMethodBeat.i(152311);
        this.Krh = null;
        this.Krh = new SpannableString(charSequence);
        AppMethodBeat.o(152311);
    }

    public m(String str) {
        AppMethodBeat.i(152312);
        this.Krh = null;
        this.Krh = new SpannableString(str);
        AppMethodBeat.o(152312);
    }

    public m(SpannableString spannableString) {
        this.Krh = null;
        this.Krh = spannableString;
    }

    public final void a(Object obj, CharSequence charSequence, int i2) {
        AppMethodBeat.i(223866);
        a(obj, i2, charSequence.length() + i2, 33);
        AppMethodBeat.o(223866);
    }

    public final void a(Object obj, CharSequence charSequence) {
        AppMethodBeat.i(263525);
        a(obj, charSequence, 0);
        AppMethodBeat.o(263525);
    }

    public final void setSpan(Object obj, int i2, int i3, int i4) {
        AppMethodBeat.i(152315);
        a(obj, i2, i3, i4);
        AppMethodBeat.o(152315);
    }

    private void a(Object obj, int i2, int i3, int i4) {
        AppMethodBeat.i(152316);
        if (i2 >= 0 && i3 <= this.Krh.length()) {
            this.Krh.setSpan(obj, i2, i3, i4);
        }
        AppMethodBeat.o(152316);
    }

    @Override // android.text.Spanned
    public final <T> T[] getSpans(int i2, int i3, Class<T> cls) {
        AppMethodBeat.i(152317);
        T[] tArr = (T[]) this.Krh.getSpans(i2, i3, cls);
        AppMethodBeat.o(152317);
        return tArr;
    }

    public final int getSpanStart(Object obj) {
        AppMethodBeat.i(152318);
        int spanStart = this.Krh.getSpanStart(obj);
        AppMethodBeat.o(152318);
        return spanStart;
    }

    public final int getSpanEnd(Object obj) {
        AppMethodBeat.i(152319);
        int spanEnd = this.Krh.getSpanEnd(obj);
        AppMethodBeat.o(152319);
        return spanEnd;
    }

    public final int getSpanFlags(Object obj) {
        AppMethodBeat.i(152320);
        int spanFlags = this.Krh.getSpanFlags(obj);
        AppMethodBeat.o(152320);
        return spanFlags;
    }

    public final int nextSpanTransition(int i2, int i3, Class cls) {
        AppMethodBeat.i(152321);
        int nextSpanTransition = this.Krh.nextSpanTransition(i2, i3, cls);
        AppMethodBeat.o(152321);
        return nextSpanTransition;
    }

    public final int length() {
        AppMethodBeat.i(152322);
        int length = this.Krh.length();
        AppMethodBeat.o(152322);
        return length;
    }

    public final char charAt(int i2) {
        AppMethodBeat.i(152323);
        char charAt = this.Krh.charAt(i2);
        AppMethodBeat.o(152323);
        return charAt;
    }

    public final CharSequence subSequence(int i2, int i3) {
        AppMethodBeat.i(152324);
        CharSequence subSequence = this.Krh.subSequence(i2, i3);
        AppMethodBeat.o(152324);
        return subSequence;
    }

    public final void removeSpan(Object obj) {
        AppMethodBeat.i(152325);
        this.Krh.removeSpan(obj);
        AppMethodBeat.o(152325);
    }

    public final void getChars(int i2, int i3, char[] cArr, int i4) {
        AppMethodBeat.i(152326);
        this.Krh.getChars(i2, i3, cArr, i4);
        AppMethodBeat.o(152326);
    }

    public final String toString() {
        AppMethodBeat.i(152327);
        String spannableString = this.Krh.toString();
        AppMethodBeat.o(152327);
        return spannableString;
    }
}

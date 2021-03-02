package com.tencent.mm.ui.widget.cedit.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.BreakIterator;
import java.util.Locale;

public final class b {
    private int Pc;
    private CharSequence QLR;
    public final BreakIterator QLS;
    private int avh;

    public b() {
        this(Locale.getDefault());
        AppMethodBeat.i(206143);
        AppMethodBeat.o(206143);
    }

    public b(Locale locale) {
        AppMethodBeat.i(206144);
        this.QLS = BreakIterator.getWordInstance(locale);
        AppMethodBeat.o(206144);
    }

    public final void i(CharSequence charSequence, int i2, int i3) {
        AppMethodBeat.i(206145);
        if (i2 < 0 || i3 > charSequence.length()) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("input indexes are outside the CharSequence");
            AppMethodBeat.o(206145);
            throw indexOutOfBoundsException;
        }
        this.QLR = charSequence;
        this.avh = Math.max(0, i2 - 50);
        this.Pc = Math.min(charSequence.length(), i3 + 50);
        this.QLS.setText(new a(charSequence, this.avh, this.Pc));
        AppMethodBeat.o(206145);
    }

    public final int aoD(int i2) {
        AppMethodBeat.i(206146);
        aoK(i2);
        int following = this.QLS.following(i2);
        AppMethodBeat.o(206146);
        return following;
    }

    public final int aoE(int i2) {
        AppMethodBeat.i(206147);
        aoK(i2);
        int preceding = this.QLS.preceding(i2);
        AppMethodBeat.o(206147);
        return preceding;
    }

    public final int bR(int i2, boolean z) {
        AppMethodBeat.i(206148);
        aoK(i2);
        try {
            if (!aoJ(i2)) {
                if (aoI(i2)) {
                    int preceding = this.QLS.preceding(i2);
                    AppMethodBeat.o(206148);
                    return preceding;
                }
                AppMethodBeat.o(206148);
                return -1;
            } else if (!this.QLS.isBoundary(i2) || (aoI(i2) && z)) {
                int preceding2 = this.QLS.preceding(i2);
                AppMethodBeat.o(206148);
                return preceding2;
            } else {
                AppMethodBeat.o(206148);
                return i2;
            }
        } catch (Throwable th) {
        }
    }

    public final int bS(int i2, boolean z) {
        AppMethodBeat.i(206149);
        aoK(i2);
        if (aoI(i2)) {
            if (!this.QLS.isBoundary(i2) || (aoJ(i2) && z)) {
                int following = this.QLS.following(i2);
                AppMethodBeat.o(206149);
                return following;
            }
            AppMethodBeat.o(206149);
            return i2;
        } else if (aoJ(i2)) {
            int following2 = this.QLS.following(i2);
            AppMethodBeat.o(206149);
            return following2;
        } else {
            AppMethodBeat.o(206149);
            return -1;
        }
    }

    public final boolean aoF(int i2) {
        AppMethodBeat.i(206150);
        if (this.avh >= i2 || i2 > this.Pc) {
            AppMethodBeat.o(206150);
            return false;
        }
        boolean aoH = aoH(Character.codePointBefore(this.QLR, i2));
        AppMethodBeat.o(206150);
        return aoH;
    }

    public final boolean aoG(int i2) {
        AppMethodBeat.i(206151);
        if (this.avh > i2 || i2 >= this.Pc) {
            AppMethodBeat.o(206151);
            return false;
        }
        boolean aoH = aoH(Character.codePointAt(this.QLR, i2));
        AppMethodBeat.o(206151);
        return aoH;
    }

    private static boolean aoH(int i2) {
        AppMethodBeat.i(206152);
        int type = Character.getType(i2);
        if (type == 23 || type == 20 || type == 22 || type == 30 || type == 29 || type == 24 || type == 21) {
            AppMethodBeat.o(206152);
            return true;
        }
        AppMethodBeat.o(206152);
        return false;
    }

    private boolean aoI(int i2) {
        AppMethodBeat.i(206153);
        if (this.avh >= i2 || i2 > this.Pc || !Character.isLetterOrDigit(Character.codePointBefore(this.QLR, i2))) {
            AppMethodBeat.o(206153);
            return false;
        }
        AppMethodBeat.o(206153);
        return true;
    }

    private boolean aoJ(int i2) {
        AppMethodBeat.i(206154);
        if (this.avh > i2 || i2 >= this.Pc || !Character.isLetterOrDigit(Character.codePointAt(this.QLR, i2))) {
            AppMethodBeat.o(206154);
            return false;
        }
        AppMethodBeat.o(206154);
        return true;
    }

    public final void aoK(int i2) {
        AppMethodBeat.i(206155);
        if (this.avh > i2 || i2 > this.Pc) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid offset: " + i2 + ". Valid range is [" + this.avh + ", " + this.Pc + "]");
            AppMethodBeat.o(206155);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(206155);
    }
}

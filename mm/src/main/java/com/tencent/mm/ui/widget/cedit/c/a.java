package com.tencent.mm.ui.widget.cedit.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.CharacterIterator;

public final class a implements CharacterIterator {
    private final int QLQ;
    private final CharSequence QLR;
    private int mIndex;
    private final int rnu;

    public a(CharSequence charSequence, int i2, int i3) {
        AppMethodBeat.i(206135);
        this.QLR = charSequence;
        this.mIndex = i2;
        this.QLQ = i2;
        this.rnu = i3;
        AppMethodBeat.o(206135);
    }

    public final char first() {
        AppMethodBeat.i(206136);
        this.mIndex = this.QLQ;
        char current = current();
        AppMethodBeat.o(206136);
        return current;
    }

    public final char last() {
        AppMethodBeat.i(206137);
        if (this.QLQ == this.rnu) {
            this.mIndex = this.rnu;
            AppMethodBeat.o(206137);
            return 65535;
        }
        this.mIndex = this.rnu - 1;
        char charAt = this.QLR.charAt(this.mIndex);
        AppMethodBeat.o(206137);
        return charAt;
    }

    public final char current() {
        AppMethodBeat.i(206138);
        if (this.mIndex == this.rnu) {
            AppMethodBeat.o(206138);
            return 65535;
        }
        char charAt = this.QLR.charAt(this.mIndex);
        AppMethodBeat.o(206138);
        return charAt;
    }

    public final char next() {
        AppMethodBeat.i(206139);
        this.mIndex++;
        if (this.mIndex >= this.rnu) {
            this.mIndex = this.rnu;
            AppMethodBeat.o(206139);
            return 65535;
        }
        char charAt = this.QLR.charAt(this.mIndex);
        AppMethodBeat.o(206139);
        return charAt;
    }

    public final char previous() {
        AppMethodBeat.i(206140);
        if (this.mIndex <= this.QLQ) {
            AppMethodBeat.o(206140);
            return 65535;
        }
        this.mIndex--;
        char charAt = this.QLR.charAt(this.mIndex);
        AppMethodBeat.o(206140);
        return charAt;
    }

    public final char setIndex(int i2) {
        AppMethodBeat.i(206141);
        if (this.QLQ > i2 || i2 > this.rnu) {
            char current = current();
            AppMethodBeat.o(206141);
            return current;
        }
        this.mIndex = i2;
        char current2 = current();
        AppMethodBeat.o(206141);
        return current2;
    }

    public final int getBeginIndex() {
        return this.QLQ;
    }

    public final int getEndIndex() {
        return this.rnu;
    }

    public final int getIndex() {
        return this.mIndex;
    }

    @Override // java.lang.Object
    public final Object clone() {
        AppMethodBeat.i(206142);
        try {
            Object clone = super.clone();
            AppMethodBeat.o(206142);
            return clone;
        } catch (CloneNotSupportedException e2) {
            InternalError internalError = new InternalError();
            AppMethodBeat.o(206142);
            throw internalError;
        }
    }
}

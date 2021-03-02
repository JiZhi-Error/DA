package org.apache.commons.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements Cloneable {
    private String Uhk;
    protected char[] aZS;
    protected int size;

    public a() {
        this(32);
    }

    public a(int i2) {
        AppMethodBeat.i(40757);
        this.aZS = new char[(i2 <= 0 ? 32 : i2)];
        AppMethodBeat.o(40757);
    }

    public final int length() {
        return this.size;
    }

    public final a hPP() {
        AppMethodBeat.i(40758);
        if (this.size > 0) {
            this.size = 0;
        } else if (this.size < 0) {
            awl(0);
            this.size = 0;
            for (int i2 = this.size; i2 < 0; i2++) {
                this.aZS[i2] = 0;
            }
        }
        AppMethodBeat.o(40758);
        return this;
    }

    private a awl(int i2) {
        AppMethodBeat.i(40759);
        if (i2 > this.aZS.length) {
            char[] cArr = this.aZS;
            this.aZS = new char[(i2 * 2)];
            System.arraycopy(cArr, 0, this.aZS, 0, this.size);
        }
        AppMethodBeat.o(40759);
        return this;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    private a hPQ() {
        AppMethodBeat.i(40760);
        if (this.Uhk == null) {
            AppMethodBeat.o(40760);
            return this;
        }
        a bvo = bvo(this.Uhk);
        AppMethodBeat.o(40760);
        return bvo;
    }

    public final a gF(Object obj) {
        AppMethodBeat.i(40761);
        if (obj == null) {
            a hPQ = hPQ();
            AppMethodBeat.o(40761);
            return hPQ;
        }
        a bvo = bvo(obj.toString());
        AppMethodBeat.o(40761);
        return bvo;
    }

    public final a bvo(String str) {
        AppMethodBeat.i(40762);
        if (str == null) {
            a hPQ = hPQ();
            AppMethodBeat.o(40762);
            return hPQ;
        }
        int length = str.length();
        if (length > 0) {
            int i2 = this.size;
            awl(i2 + length);
            str.getChars(0, length, this.aZS, i2);
            this.size = length + this.size;
        }
        AppMethodBeat.o(40762);
        return this;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this != aVar) {
            if (this.size != aVar.size) {
                return false;
            }
            char[] cArr = this.aZS;
            char[] cArr2 = aVar.aZS;
            for (int i2 = this.size - 1; i2 >= 0; i2--) {
                if (cArr[i2] != cArr2[i2]) {
                    return false;
                }
            }
        }
        return true;
    }

    public final int hashCode() {
        char[] cArr = this.aZS;
        int i2 = 0;
        for (int i3 = this.size - 1; i3 >= 0; i3--) {
            i2 = (i2 * 31) + cArr[i3];
        }
        return i2;
    }

    public final String toString() {
        AppMethodBeat.i(40764);
        String str = new String(this.aZS, 0, this.size);
        AppMethodBeat.o(40764);
        return str;
    }

    @Override // java.lang.Object
    public final Object clone() {
        AppMethodBeat.i(40765);
        a aVar = (a) super.clone();
        aVar.aZS = new char[this.aZS.length];
        System.arraycopy(this.aZS, 0, aVar.aZS, 0, this.aZS.length);
        AppMethodBeat.o(40765);
        return aVar;
    }

    public final a J(char c2) {
        AppMethodBeat.i(40763);
        awl(this.size + 1);
        char[] cArr = this.aZS;
        int i2 = this.size;
        this.size = i2 + 1;
        cArr[i2] = c2;
        AppMethodBeat.o(40763);
        return this;
    }
}

package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

/* access modifiers changed from: package-private */
public class i {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] aZZ = {'\\', '\"'};
    private static final char[] baa = {'\\', '\\'};
    private static final char[] bab = {'\\', 'n'};
    private static final char[] bac = {'\\', 'r'};
    private static final char[] bad = {'\\', 't'};
    private static final char[] bae = {'\\', 'u', '2', '0', '2', '8'};
    private static final char[] baf = {'\\', 'u', '2', '0', '2', '9'};
    protected final Writer bag;

    i(Writer writer) {
        this.bag = writer;
    }

    /* access modifiers changed from: protected */
    public final void aX(String str) {
        AppMethodBeat.i(74771);
        this.bag.write(str);
        AppMethodBeat.o(74771);
    }

    /* access modifiers changed from: protected */
    public final void aY(String str) {
        AppMethodBeat.i(74772);
        this.bag.write(str);
        AppMethodBeat.o(74772);
    }

    /* access modifiers changed from: protected */
    public final void writeString(String str) {
        AppMethodBeat.i(74773);
        this.bag.write(34);
        ba(str);
        this.bag.write(34);
        AppMethodBeat.o(74773);
    }

    /* access modifiers changed from: protected */
    public void sH() {
        AppMethodBeat.i(74774);
        this.bag.write(91);
        AppMethodBeat.o(74774);
    }

    /* access modifiers changed from: protected */
    public void sI() {
        AppMethodBeat.i(74775);
        this.bag.write(93);
        AppMethodBeat.o(74775);
    }

    /* access modifiers changed from: protected */
    public void sJ() {
        AppMethodBeat.i(74776);
        this.bag.write(44);
        AppMethodBeat.o(74776);
    }

    /* access modifiers changed from: protected */
    public void sK() {
        AppMethodBeat.i(74777);
        this.bag.write(123);
        AppMethodBeat.o(74777);
    }

    /* access modifiers changed from: protected */
    public void sL() {
        AppMethodBeat.i(74778);
        this.bag.write(125);
        AppMethodBeat.o(74778);
    }

    /* access modifiers changed from: protected */
    public final void aZ(String str) {
        AppMethodBeat.i(74779);
        this.bag.write(34);
        ba(str);
        this.bag.write(34);
        AppMethodBeat.o(74779);
    }

    /* access modifiers changed from: protected */
    public void sM() {
        AppMethodBeat.i(74780);
        this.bag.write(58);
        AppMethodBeat.o(74780);
    }

    /* access modifiers changed from: protected */
    public void sN() {
        AppMethodBeat.i(74781);
        this.bag.write(44);
        AppMethodBeat.o(74781);
    }

    private void ba(String str) {
        AppMethodBeat.i(74782);
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char[] f2 = f(str.charAt(i3));
            if (f2 != null) {
                this.bag.write(str, i2, i3 - i2);
                this.bag.write(f2);
                i2 = i3 + 1;
            }
        }
        this.bag.write(str, i2, length - i2);
        AppMethodBeat.o(74782);
    }

    private static char[] f(char c2) {
        if (c2 > '\\') {
            if (c2 < 8232 || c2 > 8233) {
                return null;
            }
            return c2 == 8232 ? bae : baf;
        } else if (c2 == '\\') {
            return baa;
        } else {
            if (c2 > '\"') {
                return null;
            }
            if (c2 == '\"') {
                return aZZ;
            }
            if (c2 > 31) {
                return null;
            }
            if (c2 == '\n') {
                return bab;
            }
            if (c2 == '\r') {
                return bac;
            }
            if (c2 == '\t') {
                return bad;
            }
            return new char[]{'\\', 'u', '0', '0', HEX_DIGITS[(c2 >> 4) & 15], HEX_DIGITS[c2 & 15]};
        }
    }
}

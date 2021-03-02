package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

/* access modifiers changed from: package-private */
public final class m extends Writer {
    private final char[] aZS;
    private int aZU = 0;
    private final Writer bag;

    m(Writer writer) {
        AppMethodBeat.i(74795);
        this.bag = writer;
        this.aZS = new char[128];
        AppMethodBeat.o(74795);
    }

    @Override // java.io.Writer
    public final void write(int i2) {
        AppMethodBeat.i(74796);
        if (this.aZU > this.aZS.length - 1) {
            flush();
        }
        char[] cArr = this.aZS;
        int i3 = this.aZU;
        this.aZU = i3 + 1;
        cArr[i3] = (char) i2;
        AppMethodBeat.o(74796);
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i2, int i3) {
        AppMethodBeat.i(74797);
        if (this.aZU > this.aZS.length - i3) {
            flush();
            if (i3 > this.aZS.length) {
                this.bag.write(cArr, i2, i3);
                AppMethodBeat.o(74797);
                return;
            }
        }
        System.arraycopy(cArr, i2, this.aZS, this.aZU, i3);
        this.aZU += i3;
        AppMethodBeat.o(74797);
    }

    @Override // java.io.Writer
    public final void write(String str, int i2, int i3) {
        AppMethodBeat.i(74798);
        if (this.aZU > this.aZS.length - i3) {
            flush();
            if (i3 > this.aZS.length) {
                this.bag.write(str, i2, i3);
                AppMethodBeat.o(74798);
                return;
            }
        }
        str.getChars(i2, i2 + i3, this.aZS, this.aZU);
        this.aZU += i3;
        AppMethodBeat.o(74798);
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        AppMethodBeat.i(74799);
        this.bag.write(this.aZS, 0, this.aZU);
        this.aZU = 0;
        AppMethodBeat.o(74799);
    }

    @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
    public final void close() {
    }
}

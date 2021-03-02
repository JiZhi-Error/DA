package org.apache.commons.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.io.Writer;

public final class b extends Writer implements Serializable {
    private final StringBuilder EjO;

    public b() {
        AppMethodBeat.i(10311);
        this.EjO = new StringBuilder();
        AppMethodBeat.o(10311);
    }

    public b(byte b2) {
        AppMethodBeat.i(10312);
        this.EjO = new StringBuilder(4);
        AppMethodBeat.o(10312);
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    public final Writer append(char c2) {
        AppMethodBeat.i(10313);
        this.EjO.append(c2);
        AppMethodBeat.o(10313);
        return this;
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    public final Writer append(CharSequence charSequence) {
        AppMethodBeat.i(10314);
        this.EjO.append(charSequence);
        AppMethodBeat.o(10314);
        return this;
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    public final Writer append(CharSequence charSequence, int i2, int i3) {
        AppMethodBeat.i(10315);
        this.EjO.append(charSequence, i2, i3);
        AppMethodBeat.o(10315);
        return this;
    }

    @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
    }

    @Override // java.io.Writer
    public final void write(String str) {
        AppMethodBeat.i(10316);
        if (str != null) {
            this.EjO.append(str);
        }
        AppMethodBeat.o(10316);
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i2, int i3) {
        AppMethodBeat.i(10317);
        if (cArr != null) {
            this.EjO.append(cArr, i2, i3);
        }
        AppMethodBeat.o(10317);
    }

    public final String toString() {
        AppMethodBeat.i(10318);
        String sb = this.EjO.toString();
        AppMethodBeat.o(10318);
        return sb;
    }
}

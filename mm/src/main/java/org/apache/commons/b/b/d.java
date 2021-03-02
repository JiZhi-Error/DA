package org.apache.commons.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.io.PrintWriter;

public class d extends RuntimeException implements b {
    protected c Uhy = new c(this);
    private Throwable cause = null;

    public d() {
        AppMethodBeat.i(40724);
        AppMethodBeat.o(40724);
    }

    public d(Throwable th) {
        AppMethodBeat.i(40725);
        this.cause = th;
        AppMethodBeat.o(40725);
    }

    public d(String str, Throwable th) {
        super(str);
        AppMethodBeat.i(40726);
        this.cause = th;
        AppMethodBeat.o(40726);
    }

    @Override // org.apache.commons.b.b.b
    public Throwable getCause() {
        return this.cause;
    }

    public String getMessage() {
        AppMethodBeat.i(40727);
        if (super.getMessage() != null) {
            String message = super.getMessage();
            AppMethodBeat.o(40727);
            return message;
        } else if (this.cause != null) {
            String th = this.cause.toString();
            AppMethodBeat.o(40727);
            return th;
        } else {
            AppMethodBeat.o(40727);
            return null;
        }
    }

    public void printStackTrace() {
        AppMethodBeat.i(40728);
        this.Uhy.printStackTrace(System.err);
        AppMethodBeat.o(40728);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        AppMethodBeat.i(40729);
        this.Uhy.printStackTrace(printStream);
        AppMethodBeat.o(40729);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        AppMethodBeat.i(40730);
        this.Uhy.printStackTrace(printWriter);
        AppMethodBeat.o(40730);
    }

    @Override // org.apache.commons.b.b.b
    public final void a(PrintWriter printWriter) {
        AppMethodBeat.i(40731);
        super.printStackTrace(printWriter);
        AppMethodBeat.o(40731);
    }
}

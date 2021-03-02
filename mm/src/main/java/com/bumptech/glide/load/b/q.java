package com.bumptech.glide.load.b;

import com.bumptech.glide.load.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class q extends Exception {
    private static final StackTraceElement[] aHO = new StackTraceElement[0];
    private g aFH;
    private com.bumptech.glide.load.a aGD;
    private Class<?> aGU;
    private final List<Throwable> aHP;
    private String aHQ;
    public Exception exception;

    public q(String str) {
        this(str, Collections.emptyList());
        AppMethodBeat.i(77017);
        AppMethodBeat.o(77017);
    }

    public q(String str, Throwable th) {
        this(str, Collections.singletonList(th));
        AppMethodBeat.i(77018);
        AppMethodBeat.o(77018);
    }

    public q(String str, List<Throwable> list) {
        AppMethodBeat.i(77019);
        this.aHQ = str;
        setStackTrace(aHO);
        this.aHP = list;
        AppMethodBeat.o(77019);
    }

    /* access modifiers changed from: package-private */
    public final void a(g gVar, com.bumptech.glide.load.a aVar, Class<?> cls) {
        this.aFH = gVar;
        this.aGD = aVar;
        this.aGU = cls;
    }

    public final Throwable fillInStackTrace() {
        return this;
    }

    private List<Throwable> oW() {
        AppMethodBeat.i(77020);
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        AppMethodBeat.o(77020);
        return arrayList;
    }

    public final void oX() {
        AppMethodBeat.i(77021);
        List<Throwable> oW = oW();
        int size = oW.size();
        for (int i2 = 0; i2 < size; i2++) {
            new StringBuilder("Root cause (").append(i2 + 1).append(" of ").append(size).append(")");
            oW.get(i2);
        }
        AppMethodBeat.o(77021);
    }

    private void a(Throwable th, List<Throwable> list) {
        AppMethodBeat.i(77022);
        if (th instanceof q) {
            for (Throwable th2 : ((q) th).aHP) {
                a(th2, list);
            }
            AppMethodBeat.o(77022);
            return;
        }
        list.add(th);
        AppMethodBeat.o(77022);
    }

    public final void printStackTrace() {
        AppMethodBeat.i(77023);
        printStackTrace(System.err);
        AppMethodBeat.o(77023);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintStream printStream) {
        AppMethodBeat.i(77024);
        a(printStream);
        AppMethodBeat.o(77024);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintWriter printWriter) {
        AppMethodBeat.i(77025);
        a(printWriter);
        AppMethodBeat.o(77025);
    }

    private void a(Appendable appendable) {
        AppMethodBeat.i(77026);
        a(this, appendable);
        a(this.aHP, new a(appendable));
        AppMethodBeat.o(77026);
    }

    public final String getMessage() {
        AppMethodBeat.i(77027);
        StringBuilder append = new StringBuilder(71).append(this.aHQ).append(this.aGU != null ? ", " + this.aGU : "").append(this.aGD != null ? ", " + this.aGD : "").append(this.aFH != null ? ", " + this.aFH : "");
        List<Throwable> oW = oW();
        if (oW.isEmpty()) {
            String sb = append.toString();
            AppMethodBeat.o(77027);
            return sb;
        }
        if (oW.size() == 1) {
            append.append("\nThere was 1 cause:");
        } else {
            append.append("\nThere were ").append(oW.size()).append(" causes:");
        }
        for (Throwable th : oW) {
            append.append('\n').append(th.getClass().getName()).append('(').append(th.getMessage()).append(')');
        }
        append.append("\n call GlideException#logRootCauses(String) for more detail");
        String sb2 = append.toString();
        AppMethodBeat.o(77027);
        return sb2;
    }

    private static void a(Throwable th, Appendable appendable) {
        AppMethodBeat.i(77028);
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
            AppMethodBeat.o(77028);
        } catch (IOException e2) {
            RuntimeException runtimeException = new RuntimeException(th);
            AppMethodBeat.o(77028);
            throw runtimeException;
        }
    }

    private static void a(List<Throwable> list, Appendable appendable) {
        AppMethodBeat.i(77029);
        try {
            b(list, appendable);
            AppMethodBeat.o(77029);
        } catch (IOException e2) {
            RuntimeException runtimeException = new RuntimeException(e2);
            AppMethodBeat.o(77029);
            throw runtimeException;
        }
    }

    private static void b(List<Throwable> list, Appendable appendable) {
        AppMethodBeat.i(77030);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            appendable.append("Cause (").append(String.valueOf(i2 + 1)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i2);
            if (th instanceof q) {
                ((q) th).a(appendable);
            } else {
                a(th, appendable);
            }
        }
        AppMethodBeat.o(77030);
    }

    /* access modifiers changed from: package-private */
    public static final class a implements Appendable {
        private final Appendable aHR;
        private boolean aHS = true;

        a(Appendable appendable) {
            this.aHR = appendable;
        }

        @Override // java.lang.Appendable
        public final Appendable append(char c2) {
            boolean z = false;
            AppMethodBeat.i(77014);
            if (this.aHS) {
                this.aHS = false;
                this.aHR.append("  ");
            }
            if (c2 == '\n') {
                z = true;
            }
            this.aHS = z;
            this.aHR.append(c2);
            AppMethodBeat.o(77014);
            return this;
        }

        @Override // java.lang.Appendable
        public final Appendable append(CharSequence charSequence) {
            AppMethodBeat.i(77015);
            CharSequence s = s(charSequence);
            Appendable append = append(s, 0, s.length());
            AppMethodBeat.o(77015);
            return append;
        }

        @Override // java.lang.Appendable
        public final Appendable append(CharSequence charSequence, int i2, int i3) {
            boolean z = false;
            AppMethodBeat.i(77016);
            CharSequence s = s(charSequence);
            if (this.aHS) {
                this.aHS = false;
                this.aHR.append("  ");
            }
            if (s.length() > 0 && s.charAt(i3 - 1) == '\n') {
                z = true;
            }
            this.aHS = z;
            this.aHR.append(s, i2, i3);
            AppMethodBeat.o(77016);
            return this;
        }

        private static CharSequence s(CharSequence charSequence) {
            if (charSequence == null) {
                return "";
            }
            return charSequence;
        }
    }
}

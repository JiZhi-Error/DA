package rx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public final class a extends RuntimeException {
    private final List<Throwable> aKp;
    private Throwable cause;
    private final String message;

    @Deprecated
    private a(Collection<? extends Throwable> collection) {
        AppMethodBeat.i(90036);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            for (Throwable th : collection) {
                if (th instanceof a) {
                    linkedHashSet.addAll(((a) th).aKp);
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        this.aKp = Collections.unmodifiableList(arrayList);
        this.message = this.aKp.size() + " exceptions occurred. ";
        AppMethodBeat.o(90036);
    }

    public a(Collection<? extends Throwable> collection, byte b2) {
        this(collection);
    }

    public final String getMessage() {
        return this.message;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x003a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Throwable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.Throwable getCause() {
        /*
        // Method dump skipped, instructions count: 116
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.a.a.getCause():java.lang.Throwable");
    }

    public final void printStackTrace() {
        AppMethodBeat.i(90038);
        printStackTrace(System.err);
        AppMethodBeat.o(90038);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintStream printStream) {
        AppMethodBeat.i(90039);
        a(new c(printStream));
        AppMethodBeat.o(90039);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintWriter printWriter) {
        AppMethodBeat.i(90040);
        a(new d(printWriter));
        AppMethodBeat.o(90040);
    }

    private void a(b bVar) {
        AppMethodBeat.i(90041);
        StringBuilder sb = new StringBuilder(128);
        sb.append(this).append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ").append(stackTraceElement).append('\n');
        }
        int i2 = 1;
        for (Throwable th : this.aKp) {
            sb.append("  ComposedException ").append(i2).append(" :\n");
            a(sb, th, "\t");
            i2++;
        }
        synchronized (bVar.hQC()) {
            try {
                bVar.println(sb.toString());
            } finally {
                AppMethodBeat.o(90041);
            }
        }
    }

    private static void a(StringBuilder sb, Throwable th, String str) {
        AppMethodBeat.i(90042);
        while (true) {
            sb.append(str).append(th).append('\n');
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                sb.append("\t\tat ").append(stackTraceElement).append('\n');
            }
            if (th.getCause() != null) {
                sb.append("\tCaused by: ");
                th = th.getCause();
                str = "";
            } else {
                AppMethodBeat.o(90042);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class b {
        /* access modifiers changed from: package-private */
        public abstract Object hQC();

        /* access modifiers changed from: package-private */
        public abstract void println(Object obj);

        b() {
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c extends b {
        private final PrintStream Ukk;

        c(PrintStream printStream) {
            this.Ukk = printStream;
        }

        /* access modifiers changed from: package-private */
        @Override // rx.a.a.b
        public final Object hQC() {
            return this.Ukk;
        }

        /* access modifiers changed from: package-private */
        @Override // rx.a.a.b
        public final void println(Object obj) {
            AppMethodBeat.i(90034);
            this.Ukk.println(obj);
            AppMethodBeat.o(90034);
        }
    }

    static final class d extends b {
        private final PrintWriter Ukl;

        d(PrintWriter printWriter) {
            this.Ukl = printWriter;
        }

        /* access modifiers changed from: package-private */
        @Override // rx.a.a.b
        public final Object hQC() {
            return this.Ukl;
        }

        /* access modifiers changed from: package-private */
        @Override // rx.a.a.b
        public final void println(Object obj) {
            AppMethodBeat.i(90035);
            this.Ukl.println(obj);
            AppMethodBeat.o(90035);
        }
    }

    /* renamed from: rx.a.a$a  reason: collision with other inner class name */
    static final class C2388a extends RuntimeException {
        C2388a() {
        }

        public final String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    private static List<Throwable> L(Throwable th) {
        AppMethodBeat.i(90043);
        ArrayList arrayList = new ArrayList();
        Throwable cause2 = th.getCause();
        if (cause2 == null || cause2 == th) {
            AppMethodBeat.o(90043);
            return arrayList;
        }
        while (true) {
            arrayList.add(cause2);
            Throwable cause3 = cause2.getCause();
            if (cause3 == null || cause3 == cause2) {
                AppMethodBeat.o(90043);
            } else {
                cause2 = cause2.getCause();
            }
        }
        AppMethodBeat.o(90043);
        return arrayList;
    }

    private static Throwable M(Throwable th) {
        AppMethodBeat.i(90044);
        Throwable cause2 = th.getCause();
        if (cause2 == null || cause2 == th) {
            AppMethodBeat.o(90044);
            return th;
        }
        while (true) {
            Throwable cause3 = cause2.getCause();
            if (cause3 == null || cause3 == cause2) {
                AppMethodBeat.o(90044);
            } else {
                cause2 = cause2.getCause();
            }
        }
        AppMethodBeat.o(90044);
        return cause2;
    }
}

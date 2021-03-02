package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.n.n;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public abstract class p extends Enum<p> {
    public static final p THj;
    public static final p THk;
    private static final /* synthetic */ p[] THl;

    static {
        b bVar = new b("PLAIN");
        THj = bVar;
        a aVar = new a("HTML");
        THk = aVar;
        THl = new p[]{bVar, aVar};
    }

    public static p valueOf(String str) {
        return (p) Enum.valueOf(p.class, str);
    }

    public static p[] values() {
        return (p[]) THl.clone();
    }

    public abstract String Fl(String str);

    static final class b extends p {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(String str) {
            super(str, 0, (byte) 0);
        }

        @Override // kotlin.l.b.a.b.i.p
        public final String Fl(String str) {
            AppMethodBeat.i(59868);
            kotlin.g.b.p.h(str, "string");
            AppMethodBeat.o(59868);
            return str;
        }
    }

    private p(String str, int i2) {
    }

    public /* synthetic */ p(String str, int i2, byte b2) {
        this(str, i2);
    }

    static final class a extends p {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(String str) {
            super(str, 1, (byte) 0);
        }

        @Override // kotlin.l.b.a.b.i.p
        public final String Fl(String str) {
            AppMethodBeat.i(59867);
            kotlin.g.b.p.h(str, "string");
            String j2 = n.j(n.j(str, "<", "&lt;", false), ">", "&gt;", false);
            AppMethodBeat.o(59867);
            return j2;
        }
    }
}

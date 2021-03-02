package kotlin.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

public abstract class c {
    public final boolean isSuccess;

    public static final class b extends c {
        private final String error;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(false, (byte) 0);
            p.h(str, "error");
            AppMethodBeat.i(61280);
            this.error = str;
            AppMethodBeat.o(61280);
        }
    }

    private c(boolean z) {
        this.isSuccess = z;
    }

    public /* synthetic */ c(boolean z, byte b2) {
        this(z);
    }

    public static final class a extends c {
        public static final a TQf = new a();

        static {
            AppMethodBeat.i(61279);
            AppMethodBeat.o(61279);
        }

        private a() {
            super(false, (byte) 0);
        }
    }

    /* renamed from: kotlin.l.b.a.b.n.c$c  reason: collision with other inner class name */
    public static final class C2364c extends c {
        public static final C2364c TQg = new C2364c();

        static {
            AppMethodBeat.i(61281);
            AppMethodBeat.o(61281);
        }

        private C2364c() {
            super(true, (byte) 0);
        }
    }
}

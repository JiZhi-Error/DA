package kotlin.l.b.a.b.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;

public final class a extends kotlin.l.b.a.b.e.b.a {
    public static final a TAA = new a(new int[0]);
    public static final C2300a TAB = new C2300a((byte) 0);
    public static final a TAz = new a(1, 0, 7);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(int... iArr) {
        super(Arrays.copyOf(iArr, iArr.length));
        p.h(iArr, "numbers");
        AppMethodBeat.i(59047);
        AppMethodBeat.o(59047);
    }

    public final boolean hIi() {
        AppMethodBeat.i(59046);
        boolean a2 = a(TAz);
        AppMethodBeat.o(59046);
        return a2;
    }

    /* renamed from: kotlin.l.b.a.b.e.a.a$a  reason: collision with other inner class name */
    public static final class C2300a {
        private C2300a() {
        }

        public /* synthetic */ C2300a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(59048);
        AppMethodBeat.o(59048);
    }
}

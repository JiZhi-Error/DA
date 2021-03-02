package kotlin.l.b.a.b.e.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;

public final class c extends kotlin.l.b.a.b.e.b.a {
    public static final a TCA = new a((byte) 0);
    public static final c TCy = new c(1, 0, 3);
    public static final c TCz = new c(new int[0]);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(int... iArr) {
        super(Arrays.copyOf(iArr, iArr.length));
        p.h(iArr, "numbers");
        AppMethodBeat.i(59230);
        AppMethodBeat.o(59230);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(59231);
        AppMethodBeat.o(59231);
    }
}

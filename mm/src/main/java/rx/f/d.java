package rx.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.j;

public final class d {
    private static final a UoM = new a();

    static {
        AppMethodBeat.i(90455);
        AppMethodBeat.o(90455);
    }

    public static j hRm() {
        AppMethodBeat.i(90453);
        a hRk = a.hRk();
        AppMethodBeat.o(90453);
        return hRk;
    }

    public static j hRn() {
        return UoM;
    }

    public static j e(rx.b.a aVar) {
        AppMethodBeat.i(90454);
        a d2 = a.d(aVar);
        AppMethodBeat.o(90454);
        return d2;
    }

    /* access modifiers changed from: package-private */
    public static final class a implements j {
        a() {
        }

        @Override // rx.j
        public final void hQA() {
        }

        @Override // rx.j
        public final boolean hQB() {
            return true;
        }
    }
}

package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import rx.f.d;
import rx.g;
import rx.j;

public final class f extends g {
    public static final f Umk = new f();

    static {
        AppMethodBeat.i(90384);
        AppMethodBeat.o(90384);
    }

    private f() {
    }

    @Override // rx.g
    public final g.a createWorker() {
        AppMethodBeat.i(90383);
        a aVar = new a(this, (byte) 0);
        AppMethodBeat.o(90383);
        return aVar;
    }

    class a extends g.a implements j {
        final rx.f.a Uml;

        private a() {
            AppMethodBeat.i(90378);
            this.Uml = new rx.f.a();
            AppMethodBeat.o(90378);
        }

        /* synthetic */ a(f fVar, byte b2) {
            this();
        }

        @Override // rx.g.a
        public final j a(rx.b.a aVar, long j2, TimeUnit timeUnit) {
            AppMethodBeat.i(90379);
            j a2 = a(new l(aVar, this, f.this.now() + timeUnit.toMillis(j2)));
            AppMethodBeat.o(90379);
            return a2;
        }

        @Override // rx.g.a
        public final j a(rx.b.a aVar) {
            AppMethodBeat.i(90380);
            aVar.call();
            j hRn = d.hRn();
            AppMethodBeat.o(90380);
            return hRn;
        }

        @Override // rx.j
        public final void hQA() {
            AppMethodBeat.i(90381);
            this.Uml.hQA();
            AppMethodBeat.o(90381);
        }

        @Override // rx.j
        public final boolean hQB() {
            AppMethodBeat.i(90382);
            boolean hQB = this.Uml.hQB();
            AppMethodBeat.o(90382);
            return hQB;
        }
    }
}

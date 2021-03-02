package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.b.e;
import rx.d;
import rx.f;
import rx.g;
import rx.internal.c.i;
import rx.j;

public final class h<T> extends d<T> {
    static final boolean Uns = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    final T Unr;

    static {
        AppMethodBeat.i(90227);
        AppMethodBeat.o(90227);
    }

    public final d<T> b(final g gVar) {
        e r0;
        AppMethodBeat.i(90226);
        if (gVar instanceof rx.internal.c.b) {
            final rx.internal.c.b bVar = (rx.internal.c.b) gVar;
            r0 = new e<rx.b.a, j>() {
                /* class rx.internal.util.h.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // rx.b.e
                public final /* synthetic */ j call(rx.b.a aVar) {
                    AppMethodBeat.i(90219);
                    i b2 = bVar.UlB.get().hQK().b(aVar, -1, TimeUnit.NANOSECONDS);
                    AppMethodBeat.o(90219);
                    return b2;
                }
            };
        } else {
            r0 = new e<rx.b.a, j>() {
                /* class rx.internal.util.h.AnonymousClass2 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // rx.b.e
                public final /* synthetic */ j call(rx.b.a aVar) {
                    AppMethodBeat.i(90221);
                    final rx.b.a aVar2 = aVar;
                    final g.a createWorker = gVar.createWorker();
                    createWorker.a(new rx.b.a() {
                        /* class rx.internal.util.h.AnonymousClass2.AnonymousClass1 */

                        @Override // rx.b.a
                        public final void call() {
                            AppMethodBeat.i(90220);
                            try {
                                aVar2.call();
                            } finally {
                                createWorker.hQA();
                                AppMethodBeat.o(90220);
                            }
                        }
                    });
                    AppMethodBeat.o(90221);
                    return createWorker;
                }
            };
        }
        d<T> a2 = a((d.a) new a(this.Unr, r0));
        AppMethodBeat.o(90226);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public static final class a<T> implements d.a<T> {
        final e<rx.b.a, j> Unz;
        final T value;

        @Override // rx.b.b
        public final /* synthetic */ void cA(Object obj) {
            AppMethodBeat.i(90222);
            rx.i iVar = (rx.i) obj;
            iVar.a(new b(iVar, this.value, this.Unz));
            AppMethodBeat.o(90222);
        }

        a(T t, e<rx.b.a, j> eVar) {
            this.value = t;
            this.Unz = eVar;
        }
    }

    static final class b<T> extends AtomicBoolean implements rx.b.a, f {
        final rx.i<? super T> UkG;
        final e<rx.b.a, j> Unz;
        final T value;

        public b(rx.i<? super T> iVar, T t, e<rx.b.a, j> eVar) {
            this.UkG = iVar;
            this.value = t;
            this.Unz = eVar;
        }

        @Override // rx.f
        public final void Pw(long j2) {
            AppMethodBeat.i(90223);
            if (j2 < 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("n >= 0 required but it was ".concat(String.valueOf(j2)));
                AppMethodBeat.o(90223);
                throw illegalArgumentException;
            }
            if (j2 != 0 && compareAndSet(false, true)) {
                this.UkG.b(this.Unz.call(this));
            }
            AppMethodBeat.o(90223);
        }

        @Override // rx.b.a
        public final void call() {
            AppMethodBeat.i(90224);
            rx.i<? super T> iVar = this.UkG;
            if (iVar.Ukg.UnB) {
                AppMethodBeat.o(90224);
                return;
            }
            T t = this.value;
            try {
                iVar.gL(t);
                if (iVar.Ukg.UnB) {
                    AppMethodBeat.o(90224);
                    return;
                }
                iVar.hQw();
                AppMethodBeat.o(90224);
            } catch (Throwable th) {
                rx.a.b.a(th, iVar, t);
                AppMethodBeat.o(90224);
            }
        }

        public final String toString() {
            AppMethodBeat.i(90225);
            String str = "ScalarAsyncProducer[" + ((Object) this.value) + ", " + get() + "]";
            AppMethodBeat.o(90225);
            return str;
        }
    }
}

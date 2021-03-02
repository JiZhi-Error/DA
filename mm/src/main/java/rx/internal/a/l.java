package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.b.a;
import rx.d;
import rx.f;
import rx.g;
import rx.i;

public final class l<T> implements d.a<T> {
    final d<T> UkE;
    final g UkJ;

    @Override // rx.b.b
    public final /* synthetic */ void cA(Object obj) {
        AppMethodBeat.i(90298);
        final i iVar = (i) obj;
        final g.a createWorker = this.UkJ.createWorker();
        iVar.b(createWorker);
        createWorker.a(new a() {
            /* class rx.internal.a.l.AnonymousClass1 */

            @Override // rx.b.a
            public final void call() {
                AppMethodBeat.i(90297);
                final Thread currentThread = Thread.currentThread();
                l.this.UkE.a(new i<T>(iVar) {
                    /* class rx.internal.a.l.AnonymousClass1.AnonymousClass1 */

                    @Override // rx.e
                    public final void gL(T t) {
                        AppMethodBeat.i(90293);
                        iVar.gL(t);
                        AppMethodBeat.o(90293);
                    }

                    @Override // rx.e
                    public final void onError(Throwable th) {
                        AppMethodBeat.i(90294);
                        try {
                            iVar.onError(th);
                        } finally {
                            createWorker.hQA();
                            AppMethodBeat.o(90294);
                        }
                    }

                    @Override // rx.e
                    public final void hQw() {
                        AppMethodBeat.i(90295);
                        try {
                            iVar.hQw();
                        } finally {
                            createWorker.hQA();
                            AppMethodBeat.o(90295);
                        }
                    }

                    @Override // rx.i
                    public final void a(final f fVar) {
                        AppMethodBeat.i(90296);
                        iVar.a(new f() {
                            /* class rx.internal.a.l.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                            @Override // rx.f
                            public final void Pw(final long j2) {
                                AppMethodBeat.i(90292);
                                if (currentThread == Thread.currentThread()) {
                                    fVar.Pw(j2);
                                    AppMethodBeat.o(90292);
                                    return;
                                }
                                createWorker.a(new a() {
                                    /* class rx.internal.a.l.AnonymousClass1.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                    @Override // rx.b.a
                                    public final void call() {
                                        AppMethodBeat.i(90291);
                                        fVar.Pw(j2);
                                        AppMethodBeat.o(90291);
                                    }
                                });
                                AppMethodBeat.o(90292);
                            }
                        });
                        AppMethodBeat.o(90296);
                    }
                });
                AppMethodBeat.o(90297);
            }
        });
        AppMethodBeat.o(90298);
    }

    public l(d<T> dVar, g gVar) {
        this.UkJ = gVar;
        this.UkE = dVar;
    }
}

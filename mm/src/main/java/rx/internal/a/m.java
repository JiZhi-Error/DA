package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLong;
import rx.d;
import rx.f;
import rx.i;

public final class m<T> implements d.b<T, T> {
    final int limit = 10;

    @Override // rx.b.e
    public final /* synthetic */ Object call(Object obj) {
        AppMethodBeat.i(90306);
        i<? super T> b2 = b((i) obj);
        AppMethodBeat.o(90306);
        return b2;
    }

    private i<? super T> b(final i<? super T> iVar) {
        AppMethodBeat.i(90305);
        AnonymousClass1 r0 = new i<T>() {
            /* class rx.internal.a.m.AnonymousClass1 */
            boolean completed;
            int count;

            @Override // rx.e
            public final void hQw() {
                AppMethodBeat.i(90301);
                if (!this.completed) {
                    this.completed = true;
                    iVar.hQw();
                }
                AppMethodBeat.o(90301);
            }

            @Override // rx.e
            public final void onError(Throwable th) {
                AppMethodBeat.i(90302);
                if (!this.completed) {
                    this.completed = true;
                    try {
                        iVar.onError(th);
                    } finally {
                        this.Ukg.hQA();
                        AppMethodBeat.o(90302);
                    }
                } else {
                    AppMethodBeat.o(90302);
                }
            }

            @Override // rx.i
            public final void a(final f fVar) {
                AppMethodBeat.i(90304);
                iVar.a(new f() {
                    /* class rx.internal.a.m.AnonymousClass1.AnonymousClass1 */
                    final AtomicLong Ula = new AtomicLong(0);

                    {
                        AppMethodBeat.i(90299);
                        AppMethodBeat.o(90299);
                    }

                    @Override // rx.f
                    public final void Pw(long j2) {
                        long j3;
                        long min;
                        AppMethodBeat.i(90300);
                        if (j2 > 0 && !AnonymousClass1.this.completed) {
                            do {
                                j3 = this.Ula.get();
                                min = Math.min(j2, ((long) m.this.limit) - j3);
                                if (min != 0) {
                                }
                            } while (!this.Ula.compareAndSet(j3, j3 + min));
                            fVar.Pw(min);
                            AppMethodBeat.o(90300);
                            return;
                        }
                        AppMethodBeat.o(90300);
                    }
                });
                AppMethodBeat.o(90304);
            }

            @Override // rx.e
            public final void gL(T t) {
                AppMethodBeat.i(90303);
                if (!this.Ukg.UnB) {
                    int i2 = this.count;
                    this.count = i2 + 1;
                    if (i2 < m.this.limit) {
                        boolean z = this.count == m.this.limit;
                        iVar.gL(t);
                        if (z && !this.completed) {
                            this.completed = true;
                            try {
                                iVar.hQw();
                                return;
                            } finally {
                                this.Ukg.hQA();
                                AppMethodBeat.o(90303);
                            }
                        }
                    }
                }
                AppMethodBeat.o(90303);
            }
        };
        if (this.limit == 0) {
            iVar.hQw();
            r0.Ukg.hQA();
        }
        iVar.b(r0);
        AppMethodBeat.o(90305);
        return r0;
    }
}

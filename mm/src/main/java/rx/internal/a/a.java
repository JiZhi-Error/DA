package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
import rx.e;
import rx.i;

public final class a<T> extends rx.e.b<T, T> {
    static final e Ukq = new e() {
        /* class rx.internal.a.a.AnonymousClass1 */

        @Override // rx.e
        public final void hQw() {
        }

        @Override // rx.e
        public final void onError(Throwable th) {
        }

        @Override // rx.e
        public final void gL(Object obj) {
        }
    };
    final b<T> Uko;
    private boolean Ukp;

    public static <T> a<T> hQE() {
        AppMethodBeat.i(90238);
        a<T> aVar = new a<>(new b());
        AppMethodBeat.o(90238);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public static final class b<T> extends AtomicReference<e<? super T>> {
        final Object Uks = new Object();
        boolean Ukt;
        final ConcurrentLinkedQueue<Object> Uku = new ConcurrentLinkedQueue<>();
        final c<T> Ukv = c.hQG();

        b() {
            AppMethodBeat.i(90235);
            AppMethodBeat.o(90235);
        }
    }

    /* renamed from: rx.internal.a.a$a  reason: collision with other inner class name */
    static final class C2391a<T> implements d.a<T> {
        final b<T> Uko;

        @Override // rx.b.b
        public final /* synthetic */ void cA(Object obj) {
            boolean z = true;
            AppMethodBeat.i(90237);
            i iVar = (i) obj;
            if (this.Uko.compareAndSet(null, iVar)) {
                iVar.b(rx.f.d.e(new rx.b.a() {
                    /* class rx.internal.a.a.C2391a.AnonymousClass1 */

                    @Override // rx.b.a
                    public final void call() {
                        AppMethodBeat.i(90236);
                        C2391a.this.Uko.set(a.Ukq);
                        AppMethodBeat.o(90236);
                    }
                }));
                synchronized (this.Uko.Uks) {
                    try {
                        if (!this.Uko.Ukt) {
                            this.Uko.Ukt = true;
                        } else {
                            z = false;
                        }
                    } finally {
                        AppMethodBeat.o(90237);
                    }
                }
                if (z) {
                    c.hQG();
                    while (true) {
                        Object poll = this.Uko.Uku.poll();
                        if (poll != null) {
                            c.a((e) this.Uko.get(), poll);
                        } else {
                            synchronized (this.Uko.Uks) {
                                try {
                                    if (this.Uko.Uku.isEmpty()) {
                                        this.Uko.Ukt = false;
                                        return;
                                    }
                                } finally {
                                    AppMethodBeat.o(90237);
                                }
                            }
                        }
                    }
                } else {
                    AppMethodBeat.o(90237);
                }
            } else {
                iVar.onError(new IllegalStateException("Only one subscriber allowed!"));
                AppMethodBeat.o(90237);
            }
        }

        public C2391a(b<T> bVar) {
            this.Uko = bVar;
        }
    }

    private a(b<T> bVar) {
        super(new C2391a(bVar));
        AppMethodBeat.i(90239);
        this.Uko = bVar;
        AppMethodBeat.o(90239);
    }

    private void gM(Object obj) {
        AppMethodBeat.i(90240);
        synchronized (this.Uko.Uks) {
            try {
                this.Uko.Uku.add(obj);
                if (this.Uko.get() != null && !this.Uko.Ukt) {
                    this.Ukp = true;
                    this.Uko.Ukt = true;
                }
            } finally {
                AppMethodBeat.o(90240);
            }
        }
        if (this.Ukp) {
            while (true) {
                Object poll = this.Uko.Uku.poll();
                if (poll == null) {
                    break;
                }
                c.a((e) this.Uko.get(), poll);
            }
        }
    }

    @Override // rx.e
    public final void hQw() {
        AppMethodBeat.i(90241);
        if (this.Ukp) {
            ((e) this.Uko.get()).hQw();
            AppMethodBeat.o(90241);
            return;
        }
        gM(c.hQH());
        AppMethodBeat.o(90241);
    }

    @Override // rx.e
    public final void onError(Throwable th) {
        AppMethodBeat.i(90242);
        if (this.Ukp) {
            ((e) this.Uko.get()).onError(th);
            AppMethodBeat.o(90242);
            return;
        }
        gM(c.P(th));
        AppMethodBeat.o(90242);
    }

    @Override // rx.e
    public final void gL(T t) {
        AppMethodBeat.i(90243);
        if (this.Ukp) {
            ((e) this.Uko.get()).gL(t);
            AppMethodBeat.o(90243);
            return;
        }
        gM(c.gN(t));
        AppMethodBeat.o(90243);
    }

    static {
        AppMethodBeat.i(90244);
        AppMethodBeat.o(90244);
    }
}

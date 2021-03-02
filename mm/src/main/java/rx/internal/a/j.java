package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.d;
import rx.g;
import rx.i;
import rx.internal.c.f;
import rx.internal.c.m;
import rx.internal.util.a.c;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class j<T> implements d.b<T, T> {
    private final g UkJ;
    private final boolean UkW = false;
    private final int bufferSize;

    @Override // rx.b.e
    public final /* synthetic */ Object call(Object obj) {
        AppMethodBeat.i(90277);
        i iVar = (i) obj;
        if (this.UkJ instanceof f) {
            AppMethodBeat.o(90277);
            return iVar;
        } else if (this.UkJ instanceof m) {
            AppMethodBeat.o(90277);
            return iVar;
        } else {
            a aVar = new a(this.UkJ, iVar, this.UkW, this.bufferSize);
            i<? super T> iVar2 = aVar.UkX;
            iVar2.a(new rx.f() {
                /* class rx.internal.a.j.a.AnonymousClass1 */

                @Override // rx.f
                public final void Pw(long j2) {
                    long j3;
                    long j4;
                    AppMethodBeat.i(90268);
                    if (j2 > 0) {
                        AtomicLong atomicLong = a.this.Ula;
                        do {
                            j3 = atomicLong.get();
                            j4 = j3 + j2;
                            if (j4 < 0) {
                                j4 = MAlarmHandler.NEXT_FIRE_INTERVAL;
                            }
                        } while (!atomicLong.compareAndSet(j3, j4));
                        a.this.schedule();
                    }
                    AppMethodBeat.o(90268);
                }
            });
            iVar2.b(aVar.UkY);
            iVar2.b(aVar);
            AppMethodBeat.o(90277);
            return aVar;
        }
    }

    public j(g gVar, int i2) {
        AppMethodBeat.i(90276);
        this.UkJ = gVar;
        this.bufferSize = i2 <= 0 ? rx.internal.util.f.SIZE : i2;
        AppMethodBeat.o(90276);
    }

    static final class a<T> extends i<T> implements rx.b.a {
        final boolean UkW;
        final i<? super T> UkX;
        final g.a UkY;
        final c<T> UkZ;
        final AtomicLong Ula = new AtomicLong();
        final AtomicLong Ulb = new AtomicLong();
        Throwable Ulc;
        long Uld;
        volatile boolean chA;
        final Queue<Object> dxk;
        final int limit;

        public a(g gVar, i<? super T> iVar, boolean z, int i2) {
            AppMethodBeat.i(90269);
            this.UkX = iVar;
            this.UkY = gVar.createWorker();
            this.UkW = z;
            this.UkZ = c.hQG();
            i2 = i2 <= 0 ? rx.internal.util.f.SIZE : i2;
            this.limit = i2 - (i2 >> 2);
            if (UnsafeAccess.isUnsafeAvailable()) {
                this.dxk = new SpscArrayQueue(i2);
            } else {
                this.dxk = new c(i2);
            }
            Pw((long) i2);
            AppMethodBeat.o(90269);
        }

        /* access modifiers changed from: protected */
        public final void schedule() {
            AppMethodBeat.i(90273);
            if (this.Ulb.getAndIncrement() == 0) {
                this.UkY.a(this);
            }
            AppMethodBeat.o(90273);
        }

        @Override // rx.b.a
        public final void call() {
            long j2;
            long j3;
            AppMethodBeat.i(90274);
            long j4 = 1;
            long j5 = this.Uld;
            Queue<Object> queue = this.dxk;
            i<? super T> iVar = this.UkX;
            do {
                long j6 = this.Ula.get();
                while (j6 != j5) {
                    boolean z = this.chA;
                    Object poll = queue.poll();
                    boolean z2 = poll == null;
                    if (!a(z, z2, iVar, queue)) {
                        if (z2) {
                            break;
                        }
                        iVar.gL((Object) c.getValue(poll));
                        long j7 = j5 + 1;
                        if (j7 == ((long) this.limit)) {
                            AtomicLong atomicLong = this.Ula;
                            while (true) {
                                long j8 = atomicLong.get();
                                if (j8 != MAlarmHandler.NEXT_FIRE_INTERVAL) {
                                    j3 = j8 - j7;
                                    if (j3 >= 0) {
                                        if (atomicLong.compareAndSet(j8, j3)) {
                                            break;
                                        }
                                    } else {
                                        IllegalStateException illegalStateException = new IllegalStateException("More produced than requested: ".concat(String.valueOf(j3)));
                                        AppMethodBeat.o(90274);
                                        throw illegalStateException;
                                    }
                                } else {
                                    j3 = MAlarmHandler.NEXT_FIRE_INTERVAL;
                                    break;
                                }
                            }
                            Pw(j7);
                            j2 = j3;
                            j7 = 0;
                        } else {
                            j2 = j6;
                        }
                        j6 = j2;
                        j5 = j7;
                    } else {
                        AppMethodBeat.o(90274);
                        return;
                    }
                }
                if (j6 != j5 || !a(this.chA, queue.isEmpty(), iVar, queue)) {
                    this.Uld = j5;
                    j4 = this.Ulb.addAndGet(-j4);
                } else {
                    AppMethodBeat.o(90274);
                    return;
                }
            } while (j4 != 0);
            AppMethodBeat.o(90274);
        }

        @Override // rx.e
        public final void gL(T t) {
            AppMethodBeat.i(90270);
            if (this.Ukg.UnB || this.chA) {
                AppMethodBeat.o(90270);
            } else if (!this.dxk.offer(c.gN(t))) {
                onError(new rx.a.c());
                AppMethodBeat.o(90270);
            } else {
                schedule();
                AppMethodBeat.o(90270);
            }
        }

        @Override // rx.e
        public final void hQw() {
            AppMethodBeat.i(90271);
            if (this.Ukg.UnB || this.chA) {
                AppMethodBeat.o(90271);
                return;
            }
            this.chA = true;
            schedule();
            AppMethodBeat.o(90271);
        }

        @Override // rx.e
        public final void onError(Throwable th) {
            AppMethodBeat.i(90272);
            if (this.Ukg.UnB || this.chA) {
                rx.d.c.onError(th);
                AppMethodBeat.o(90272);
                return;
            }
            this.Ulc = th;
            this.chA = true;
            schedule();
            AppMethodBeat.o(90272);
        }

        private boolean a(boolean z, boolean z2, i<? super T> iVar, Queue<Object> queue) {
            AppMethodBeat.i(90275);
            if (iVar.Ukg.UnB) {
                queue.clear();
                AppMethodBeat.o(90275);
                return true;
            }
            if (z) {
                if (!this.UkW) {
                    Throwable th = this.Ulc;
                    if (th != null) {
                        queue.clear();
                        try {
                            iVar.onError(th);
                            return true;
                        } finally {
                            this.UkY.hQA();
                            AppMethodBeat.o(90275);
                        }
                    } else if (z2) {
                        try {
                            iVar.hQw();
                            return true;
                        } finally {
                            this.UkY.hQA();
                            AppMethodBeat.o(90275);
                        }
                    }
                } else if (z2) {
                    Throwable th2 = this.Ulc;
                    if (th2 != null) {
                        try {
                            iVar.onError(th2);
                        } catch (Throwable th3) {
                            this.UkY.hQA();
                            AppMethodBeat.o(90275);
                            throw th3;
                        }
                    } else {
                        iVar.hQw();
                    }
                    this.UkY.hQA();
                }
            }
            AppMethodBeat.o(90275);
            return false;
        }
    }
}

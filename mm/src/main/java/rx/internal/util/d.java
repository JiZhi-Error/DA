package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.d.c;
import rx.internal.c.j;
import rx.internal.util.unsafe.MpmcArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public abstract class d<T> implements j {
    private final long Unh;
    private final AtomicReference<Future<?>> Uni;
    Queue<T> aIT;
    final int jhr;
    final int maxSize;

    /* access modifiers changed from: protected */
    public abstract T hQQ();

    public d() {
        this((byte) 0);
    }

    private d(byte b2) {
        this.jhr = 0;
        this.maxSize = 0;
        this.Unh = 67;
        this.Uni = new AtomicReference<>();
        if (UnsafeAccess.isUnsafeAvailable()) {
            this.aIT = new MpmcArrayQueue(Math.max(this.maxSize, 1024));
        } else {
            this.aIT = new ConcurrentLinkedQueue();
        }
        start();
    }

    @Override // rx.internal.c.j
    public final void shutdown() {
        Future<?> andSet = this.Uni.getAndSet(null);
        if (andSet != null) {
            andSet.cancel(false);
        }
    }

    @Override // rx.internal.c.j
    public final void start() {
        while (this.Uni.get() == null) {
            try {
                ScheduledFuture<?> scheduleAtFixedRate = rx.internal.c.d.hQL().scheduleAtFixedRate(new Runnable() {
                    /* class rx.internal.util.d.AnonymousClass1 */

                    /* JADX DEBUG: Multi-variable search result rejected for r2v11, resolved type: java.util.Queue<T> */
                    /* JADX WARN: Multi-variable type inference failed */
                    public final void run() {
                        int i2 = 0;
                        AppMethodBeat.i(90198);
                        int size = d.this.aIT.size();
                        if (size < d.this.jhr) {
                            int i3 = d.this.maxSize - size;
                            while (i2 < i3) {
                                d.this.aIT.add(d.this.hQQ());
                                i2++;
                            }
                            AppMethodBeat.o(90198);
                            return;
                        }
                        if (size > d.this.maxSize) {
                            int i4 = size - d.this.maxSize;
                            while (i2 < i4) {
                                d.this.aIT.poll();
                                i2++;
                            }
                        }
                        AppMethodBeat.o(90198);
                    }
                }, this.Unh, this.Unh, TimeUnit.SECONDS);
                if (!this.Uni.compareAndSet(null, scheduleAtFixedRate)) {
                    scheduleAtFixedRate.cancel(false);
                } else {
                    return;
                }
            } catch (RejectedExecutionException e2) {
                c.onError(e2);
                return;
            }
        }
    }
}

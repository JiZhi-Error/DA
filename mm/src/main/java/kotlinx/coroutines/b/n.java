package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.l;
import kotlinx.coroutines.an;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\b\u0000\u0018\u00002\u00020*B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J!\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\r*\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u001e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%¨\u0006)"}, hxF = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", "add", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "addLast", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "pollBuffer", "queue", "pollTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "victim", "", "tryStealBlockingFrom", "(Lkotlinx/coroutines/scheduling/WorkQueue;)J", "tryStealFrom", "blockingOnly", "tryStealLastScheduled", "(Lkotlinx/coroutines/scheduling/WorkQueue;Z)J", "decrementIfBlocking", "(Lkotlinx/coroutines/scheduling/Task;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "", "getBufferSize$kotlinx_coroutines_core", "()I", "bufferSize", "getSize$kotlinx_coroutines_core", "size", "kotlinx-coroutines-core", ""})
public final class n {
    private static final AtomicReferenceFieldUpdater TXg = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask");
    private static final AtomicIntegerFieldUpdater TXh = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex");
    private static final AtomicIntegerFieldUpdater TXi = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex");
    private static final AtomicIntegerFieldUpdater TXj = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer");
    private final AtomicReferenceArray<i> TXf = new AtomicReferenceArray<>(128);
    private volatile int blockingTasksInBuffer = 0;
    private volatile int consumerIndex = 0;
    private volatile Object lastScheduledTask = null;
    private volatile int producerIndex = 0;

    static {
        AppMethodBeat.i(117989);
        AppMethodBeat.o(117989);
    }

    public n() {
        AppMethodBeat.i(117988);
        AppMethodBeat.o(117988);
    }

    private int hOg() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int hOh() {
        AppMethodBeat.i(192353);
        if (this.lastScheduledTask != null) {
            int hOg = hOg() + 1;
            AppMethodBeat.o(192353);
            return hOg;
        }
        int hOg2 = hOg();
        AppMethodBeat.o(192353);
        return hOg2;
    }

    public final i hOi() {
        AppMethodBeat.i(117979);
        i iVar = (i) TXg.getAndSet(this, null);
        if (iVar == null) {
            iVar = hOj();
        }
        AppMethodBeat.o(117979);
        return iVar;
    }

    private static /* synthetic */ i a(n nVar, i iVar) {
        AppMethodBeat.i(192355);
        i a2 = nVar.a(iVar, false);
        AppMethodBeat.o(192355);
        return a2;
    }

    public final i a(i iVar, boolean z) {
        AppMethodBeat.i(192354);
        if (z) {
            i b2 = b(iVar);
            AppMethodBeat.o(192354);
            return b2;
        }
        i iVar2 = (i) TXg.getAndSet(this, iVar);
        if (iVar2 == null) {
            AppMethodBeat.o(192354);
            return null;
        }
        i b3 = b(iVar2);
        AppMethodBeat.o(192354);
        return b3;
    }

    public final long a(n nVar) {
        boolean z = true;
        AppMethodBeat.i(192357);
        if (an.hMK()) {
            if (!(hOg() == 0)) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(192357);
                throw assertionError;
            }
        }
        i hOj = nVar.hOj();
        if (hOj != null) {
            i a2 = a(this, hOj);
            if (an.hMK()) {
                if (a2 != null) {
                    z = false;
                }
                if (!z) {
                    AssertionError assertionError2 = new AssertionError();
                    AppMethodBeat.o(192357);
                    throw assertionError2;
                }
            }
            AppMethodBeat.o(192357);
            return -1;
        }
        long a3 = a(nVar, false);
        AppMethodBeat.o(192357);
        return a3;
    }

    public final long b(n nVar) {
        AppMethodBeat.i(192358);
        if (an.hMK()) {
            if (!(hOg() == 0)) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(192358);
                throw assertionError;
            }
        }
        int i2 = nVar.consumerIndex;
        int i3 = nVar.producerIndex;
        AtomicReferenceArray<i> atomicReferenceArray = nVar.TXf;
        for (int i4 = i2; i4 != i3; i4++) {
            int i5 = i4 & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
            if (nVar.blockingTasksInBuffer == 0) {
                break;
            }
            i iVar = atomicReferenceArray.get(i5);
            if (iVar != null) {
                if ((iVar.TXa.hOf() == 1) && atomicReferenceArray.compareAndSet(i5, iVar, null)) {
                    TXj.decrementAndGet(nVar);
                    a(this, iVar);
                    AppMethodBeat.o(192358);
                    return -1;
                }
            }
        }
        long a2 = a(nVar, true);
        AppMethodBeat.o(192358);
        return a2;
    }

    public final void a(e eVar) {
        boolean z;
        AppMethodBeat.i(192359);
        i iVar = (i) TXg.getAndSet(this, null);
        if (iVar != null) {
            eVar.gg(iVar);
        }
        do {
            i hOj = hOj();
            if (hOj == null) {
                z = false;
                continue;
            } else {
                eVar.gg(hOj);
                z = true;
                continue;
            }
        } while (z);
        AppMethodBeat.o(192359);
    }

    private final long a(n nVar, boolean z) {
        i iVar;
        boolean z2;
        AppMethodBeat.i(192360);
        do {
            iVar = (i) nVar.lastScheduledTask;
            if (iVar == null) {
                AppMethodBeat.o(192360);
                return -2;
            }
            if (z) {
                if (iVar.TXa.hOf() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    AppMethodBeat.o(192360);
                    return -2;
                }
            }
            long nanoTime = l.TXe.nanoTime() - iVar.TWZ;
            if (nanoTime < l.TXb) {
                long j2 = l.TXb - nanoTime;
                AppMethodBeat.o(192360);
                return j2;
            }
        } while (!TXg.compareAndSet(nVar, iVar, null));
        a(iVar, false);
        AppMethodBeat.o(192360);
        return -1;
    }

    private final i hOj() {
        i andSet;
        AppMethodBeat.i(192361);
        while (true) {
            int i2 = this.consumerIndex;
            if (i2 - this.producerIndex == 0) {
                AppMethodBeat.o(192361);
                return null;
            }
            int i3 = i2 & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
            if (TXi.compareAndSet(this, i2, i2 + 1) && (andSet = this.TXf.getAndSet(i3, null)) != null) {
                c(andSet);
                AppMethodBeat.o(192361);
                return andSet;
            }
        }
    }

    private final void c(i iVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(192362);
        if (iVar != null) {
            if (iVar.TXa.hOf() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                int decrementAndGet = TXj.decrementAndGet(this);
                if (an.hMK()) {
                    if (decrementAndGet < 0) {
                        z2 = false;
                    }
                    if (!z2) {
                        AssertionError assertionError = new AssertionError();
                        AppMethodBeat.o(192362);
                        throw assertionError;
                    }
                }
            }
        }
        AppMethodBeat.o(192362);
    }

    private final i b(i iVar) {
        boolean z = true;
        AppMethodBeat.i(192356);
        if (iVar.TXa.hOf() != 1) {
            z = false;
        }
        if (z) {
            TXj.incrementAndGet(this);
        }
        if (hOg() == 127) {
            AppMethodBeat.o(192356);
            return iVar;
        }
        int i2 = this.producerIndex & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
        while (this.TXf.get(i2) != null) {
            Thread.yield();
        }
        this.TXf.lazySet(i2, iVar);
        TXh.incrementAndGet(this);
        AppMethodBeat.o(192356);
        return null;
    }
}

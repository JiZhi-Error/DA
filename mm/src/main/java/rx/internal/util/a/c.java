package rx.internal.util.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class c<E> extends a<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    final AtomicLong UnE = new AtomicLong();
    final AtomicLong UnF = new AtomicLong();
    final int lookAheadStep;
    long producerLookAhead;

    @Override // rx.internal.util.a.a
    public final /* bridge */ /* synthetic */ void clear() {
        AppMethodBeat.i(90191);
        super.clear();
        AppMethodBeat.o(90191);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.a.a, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Iterator iterator() {
        AppMethodBeat.i(90192);
        Iterator<E> it = super.iterator();
        AppMethodBeat.o(90192);
        return it;
    }

    static {
        AppMethodBeat.i(90193);
        AppMethodBeat.o(90193);
    }

    public c(int i2) {
        super(i2);
        AppMethodBeat.i(90185);
        this.lookAheadStep = Math.min(i2 / 4, MAX_LOOK_AHEAD_STEP.intValue());
        AppMethodBeat.o(90185);
    }

    @Override // java.util.Queue
    public final boolean offer(E e2) {
        AppMethodBeat.i(90186);
        if (e2 == null) {
            NullPointerException nullPointerException = new NullPointerException("Null is not a valid element");
            AppMethodBeat.o(90186);
            throw nullPointerException;
        }
        AtomicReferenceArray atomicReferenceArray = this.TXf;
        int i2 = this.mask;
        long j2 = this.UnE.get();
        int i3 = ((int) j2) & i2;
        if (j2 >= this.producerLookAhead) {
            int i4 = this.lookAheadStep;
            if (atomicReferenceArray.get(i2 & ((int) (((long) i4) + j2))) == null) {
                this.producerLookAhead = ((long) i4) + j2;
            } else if (atomicReferenceArray.get(i3) != null) {
                AppMethodBeat.o(90186);
                return false;
            }
        }
        atomicReferenceArray.lazySet(i3, e2);
        this.UnE.lazySet(1 + j2);
        AppMethodBeat.o(90186);
        return true;
    }

    @Override // java.util.Queue
    public final E poll() {
        AppMethodBeat.i(90187);
        long j2 = this.UnF.get();
        int Px = Px(j2);
        AtomicReferenceArray atomicReferenceArray = this.TXf;
        E e2 = (E) atomicReferenceArray.get(Px);
        if (e2 == null) {
            AppMethodBeat.o(90187);
            return null;
        }
        atomicReferenceArray.lazySet(Px, null);
        this.UnF.lazySet(j2 + 1);
        AppMethodBeat.o(90187);
        return e2;
    }

    @Override // java.util.Queue
    public final E peek() {
        AppMethodBeat.i(90188);
        E awp = awp(Px(this.UnF.get()));
        AppMethodBeat.o(90188);
        return awp;
    }

    public final int size() {
        AppMethodBeat.i(90189);
        long j2 = this.UnF.get();
        while (true) {
            long j3 = this.UnE.get();
            long j4 = this.UnF.get();
            if (j2 == j4) {
                int i2 = (int) (j3 - j4);
                AppMethodBeat.o(90189);
                return i2;
            }
            j2 = j4;
        }
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(90190);
        if (this.UnE.get() == this.UnF.get()) {
            AppMethodBeat.o(90190);
            return true;
        }
        AppMethodBeat.o(90190);
        return false;
    }
}

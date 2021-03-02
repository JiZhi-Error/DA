package rx.internal.util.unsafe;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SpmcArrayQueue<E> extends SpmcArrayQueueL3Pad<E> {
    public SpmcArrayQueue(int i2) {
        super(i2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: rx.internal.util.unsafe.SpmcArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.internal.util.unsafe.MessagePassingQueue, java.util.Queue
    public final boolean offer(E e2) {
        AppMethodBeat.i(90153);
        if (e2 == null) {
            NullPointerException nullPointerException = new NullPointerException("Null is not a valid element");
            AppMethodBeat.o(90153);
            throw nullPointerException;
        }
        Object[] objArr = this.buffer;
        long j2 = this.mask;
        long lvProducerIndex = lvProducerIndex();
        long calcElementOffset = calcElementOffset(lvProducerIndex);
        if (lvElement(objArr, calcElementOffset) == null) {
            spElement(objArr, calcElementOffset, e2);
            soTail(1 + lvProducerIndex);
            AppMethodBeat.o(90153);
        } else if (lvProducerIndex - lvConsumerIndex() > j2) {
            AppMethodBeat.o(90153);
            return false;
        } else {
            do {
            } while (lvElement(objArr, calcElementOffset) != null);
        }
        spElement(objArr, calcElementOffset, e2);
        soTail(1 + lvProducerIndex);
        AppMethodBeat.o(90153);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: rx.internal.util.unsafe.SpmcArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.internal.util.unsafe.MessagePassingQueue, java.util.Queue
    public final E poll() {
        long lvConsumerIndex;
        AppMethodBeat.i(90154);
        long lvProducerIndexCache = lvProducerIndexCache();
        do {
            lvConsumerIndex = lvConsumerIndex();
            if (lvConsumerIndex >= lvProducerIndexCache) {
                long lvProducerIndex = lvProducerIndex();
                if (lvConsumerIndex >= lvProducerIndex) {
                    AppMethodBeat.o(90154);
                    return null;
                }
                svProducerIndexCache(lvProducerIndex);
            }
        } while (!casHead(lvConsumerIndex, 1 + lvConsumerIndex));
        long calcElementOffset = calcElementOffset(lvConsumerIndex);
        Object[] objArr = this.buffer;
        E e2 = (E) lpElement(objArr, calcElementOffset);
        soElement(objArr, calcElementOffset, null);
        AppMethodBeat.o(90154);
        return e2;
    }

    @Override // rx.internal.util.unsafe.MessagePassingQueue, java.util.Queue
    public final E peek() {
        E lvElement;
        AppMethodBeat.i(90155);
        long lvProducerIndexCache = lvProducerIndexCache();
        do {
            long lvConsumerIndex = lvConsumerIndex();
            if (lvConsumerIndex >= lvProducerIndexCache) {
                long lvProducerIndex = lvProducerIndex();
                if (lvConsumerIndex >= lvProducerIndex) {
                    AppMethodBeat.o(90155);
                    return null;
                }
                svProducerIndexCache(lvProducerIndex);
            }
            lvElement = lvElement(calcElementOffset(lvConsumerIndex));
        } while (lvElement == null);
        AppMethodBeat.o(90155);
        return lvElement;
    }

    @Override // rx.internal.util.unsafe.MessagePassingQueue
    public final int size() {
        AppMethodBeat.i(90156);
        long lvConsumerIndex = lvConsumerIndex();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long lvConsumerIndex2 = lvConsumerIndex();
            if (lvConsumerIndex == lvConsumerIndex2) {
                int i2 = (int) (lvProducerIndex - lvConsumerIndex2);
                AppMethodBeat.o(90156);
                return i2;
            }
            lvConsumerIndex = lvConsumerIndex2;
        }
    }

    @Override // rx.internal.util.unsafe.MessagePassingQueue
    public final boolean isEmpty() {
        AppMethodBeat.i(90157);
        if (lvConsumerIndex() == lvProducerIndex()) {
            AppMethodBeat.o(90157);
            return true;
        }
        AppMethodBeat.o(90157);
        return false;
    }
}

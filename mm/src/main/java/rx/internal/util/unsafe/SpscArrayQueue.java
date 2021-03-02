package rx.internal.util.unsafe;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SpscArrayQueue<E> extends SpscArrayQueueL3Pad<E> {
    public SpscArrayQueue(int i2) {
        super(i2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: rx.internal.util.unsafe.SpscArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.internal.util.unsafe.MessagePassingQueue, java.util.Queue
    public final boolean offer(E e2) {
        AppMethodBeat.i(90131);
        if (e2 == null) {
            NullPointerException nullPointerException = new NullPointerException("null elements not allowed");
            AppMethodBeat.o(90131);
            throw nullPointerException;
        }
        Object[] objArr = this.buffer;
        long j2 = this.producerIndex;
        long calcElementOffset = calcElementOffset(j2);
        if (lvElement(objArr, calcElementOffset) != null) {
            AppMethodBeat.o(90131);
            return false;
        }
        soElement(objArr, calcElementOffset, e2);
        soProducerIndex(1 + j2);
        AppMethodBeat.o(90131);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: rx.internal.util.unsafe.SpscArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.internal.util.unsafe.MessagePassingQueue, java.util.Queue
    public final E poll() {
        AppMethodBeat.i(90132);
        long j2 = this.consumerIndex;
        long calcElementOffset = calcElementOffset(j2);
        Object[] objArr = this.buffer;
        E e2 = (E) lvElement(objArr, calcElementOffset);
        if (e2 == null) {
            AppMethodBeat.o(90132);
            return null;
        }
        soElement(objArr, calcElementOffset, null);
        soConsumerIndex(j2 + 1);
        AppMethodBeat.o(90132);
        return e2;
    }

    @Override // rx.internal.util.unsafe.MessagePassingQueue, java.util.Queue
    public final E peek() {
        AppMethodBeat.i(90133);
        E lvElement = lvElement(calcElementOffset(this.consumerIndex));
        AppMethodBeat.o(90133);
        return lvElement;
    }

    @Override // rx.internal.util.unsafe.MessagePassingQueue
    public final int size() {
        AppMethodBeat.i(90134);
        long lvConsumerIndex = lvConsumerIndex();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long lvConsumerIndex2 = lvConsumerIndex();
            if (lvConsumerIndex == lvConsumerIndex2) {
                int i2 = (int) (lvProducerIndex - lvConsumerIndex2);
                AppMethodBeat.o(90134);
                return i2;
            }
            lvConsumerIndex = lvConsumerIndex2;
        }
    }

    @Override // rx.internal.util.unsafe.MessagePassingQueue
    public final boolean isEmpty() {
        AppMethodBeat.i(90135);
        if (lvProducerIndex() == lvConsumerIndex()) {
            AppMethodBeat.o(90135);
            return true;
        }
        AppMethodBeat.o(90135);
        return false;
    }

    private void soProducerIndex(long j2) {
        AppMethodBeat.i(90136);
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, j2);
        AppMethodBeat.o(90136);
    }

    private void soConsumerIndex(long j2) {
        AppMethodBeat.i(90137);
        UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, j2);
        AppMethodBeat.o(90137);
    }

    private long lvProducerIndex() {
        AppMethodBeat.i(90138);
        long longVolatile = UnsafeAccess.UNSAFE.getLongVolatile(this, P_INDEX_OFFSET);
        AppMethodBeat.o(90138);
        return longVolatile;
    }

    private long lvConsumerIndex() {
        AppMethodBeat.i(90139);
        long longVolatile = UnsafeAccess.UNSAFE.getLongVolatile(this, C_INDEX_OFFSET);
        AppMethodBeat.o(90139);
        return longVolatile;
    }
}

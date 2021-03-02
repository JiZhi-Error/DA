package rx.internal.util.unsafe;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public class SpscUnboundedArrayQueue<E> extends SpscUnboundedArrayQueueConsumerField<E> implements QueueProgressIndicators {
    private static final long C_INDEX_OFFSET;
    private static final Object HAS_NEXT = new Object();
    static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final long P_INDEX_OFFSET;
    private static final long REF_ARRAY_BASE = ((long) UnsafeAccess.UNSAFE.arrayBaseOffset(Object[].class));
    private static final int REF_ELEMENT_SHIFT;

    static {
        AppMethodBeat.i(90184);
        int arrayIndexScale = UnsafeAccess.UNSAFE.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            REF_ELEMENT_SHIFT = 2;
        } else if (8 == arrayIndexScale) {
            REF_ELEMENT_SHIFT = 3;
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Unknown pointer size");
            AppMethodBeat.o(90184);
            throw illegalStateException;
        }
        try {
            P_INDEX_OFFSET = UnsafeAccess.UNSAFE.objectFieldOffset(SpscUnboundedArrayQueueProducerFields.class.getDeclaredField("producerIndex"));
            try {
                C_INDEX_OFFSET = UnsafeAccess.UNSAFE.objectFieldOffset(SpscUnboundedArrayQueueConsumerField.class.getDeclaredField("consumerIndex"));
                AppMethodBeat.o(90184);
            } catch (NoSuchFieldException e2) {
                InternalError internalError = new InternalError();
                internalError.initCause(e2);
                AppMethodBeat.o(90184);
                throw internalError;
            }
        } catch (NoSuchFieldException e3) {
            InternalError internalError2 = new InternalError();
            internalError2.initCause(e3);
            AppMethodBeat.o(90184);
            throw internalError2;
        }
    }

    public SpscUnboundedArrayQueue(int i2) {
        AppMethodBeat.i(90162);
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i2);
        long j2 = (long) (roundToPowerOfTwo - 1);
        Object[] objArr = new Object[(roundToPowerOfTwo + 1)];
        this.producerBuffer = objArr;
        this.producerMask = j2;
        adjustLookAheadStep(roundToPowerOfTwo);
        this.consumerBuffer = objArr;
        this.consumerMask = j2;
        this.producerLookAhead = j2 - 1;
        soProducerIndex(0);
        AppMethodBeat.o(90162);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        AppMethodBeat.i(90163);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(90163);
        throw unsupportedOperationException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r19v0, resolved type: rx.internal.util.unsafe.SpscUnboundedArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue
    public final boolean offer(E e2) {
        AppMethodBeat.i(90164);
        if (e2 == null) {
            NullPointerException nullPointerException = new NullPointerException("Null is not a valid element");
            AppMethodBeat.o(90164);
            throw nullPointerException;
        }
        Object[] objArr = this.producerBuffer;
        long j2 = this.producerIndex;
        long j3 = this.producerMask;
        long calcWrappedOffset = calcWrappedOffset(j2, j3);
        if (j2 < this.producerLookAhead) {
            boolean writeToQueue = writeToQueue(objArr, e2, j2, calcWrappedOffset);
            AppMethodBeat.o(90164);
            return writeToQueue;
        }
        int i2 = this.producerLookAheadStep;
        if (lvElement(objArr, calcWrappedOffset(((long) i2) + j2, j3)) == null) {
            this.producerLookAhead = (((long) i2) + j2) - 1;
            boolean writeToQueue2 = writeToQueue(objArr, e2, j2, calcWrappedOffset);
            AppMethodBeat.o(90164);
            return writeToQueue2;
        } else if (lvElement(objArr, calcWrappedOffset(1 + j2, j3)) != null) {
            boolean writeToQueue3 = writeToQueue(objArr, e2, j2, calcWrappedOffset);
            AppMethodBeat.o(90164);
            return writeToQueue3;
        } else {
            resize(objArr, j2, calcWrappedOffset, e2, j3);
            AppMethodBeat.o(90164);
            return true;
        }
    }

    private boolean writeToQueue(E[] eArr, E e2, long j2, long j3) {
        AppMethodBeat.i(90165);
        soElement(eArr, j3, e2);
        soProducerIndex(1 + j2);
        AppMethodBeat.o(90165);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: rx.internal.util.unsafe.SpscUnboundedArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    private void resize(E[] eArr, long j2, long j3, E e2, long j4) {
        AppMethodBeat.i(90166);
        Object[] objArr = new Object[eArr.length];
        this.producerBuffer = objArr;
        this.producerLookAhead = (j2 + j4) - 1;
        soElement(objArr, j3, e2);
        soNext(eArr, objArr);
        soElement(eArr, j3, HAS_NEXT);
        soProducerIndex(1 + j2);
        AppMethodBeat.o(90166);
    }

    private void soNext(E[] eArr, E[] eArr2) {
        AppMethodBeat.i(90167);
        soElement(eArr, calcDirectOffset((long) (eArr.length - 1)), eArr2);
        AppMethodBeat.o(90167);
    }

    private E[] lvNext(E[] eArr) {
        AppMethodBeat.i(90168);
        E[] eArr2 = (E[]) ((Object[]) lvElement(eArr, calcDirectOffset((long) (eArr.length - 1))));
        AppMethodBeat.o(90168);
        return eArr2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: rx.internal.util.unsafe.SpscUnboundedArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue
    public final E poll() {
        AppMethodBeat.i(90169);
        Object[] objArr = this.consumerBuffer;
        long j2 = this.consumerIndex;
        long j3 = this.consumerMask;
        long calcWrappedOffset = calcWrappedOffset(j2, j3);
        E e2 = (E) lvElement(objArr, calcWrappedOffset);
        boolean z = e2 == HAS_NEXT;
        if (e2 != null && !z) {
            soElement(objArr, calcWrappedOffset, null);
            soConsumerIndex(j2 + 1);
            AppMethodBeat.o(90169);
            return e2;
        } else if (z) {
            E e3 = (E) newBufferPoll(lvNext(objArr), j2, j3);
            AppMethodBeat.o(90169);
            return e3;
        } else {
            AppMethodBeat.o(90169);
            return null;
        }
    }

    private E newBufferPoll(E[] eArr, long j2, long j3) {
        AppMethodBeat.i(90170);
        this.consumerBuffer = eArr;
        long calcWrappedOffset = calcWrappedOffset(j2, j3);
        E e2 = (E) lvElement(eArr, calcWrappedOffset);
        if (e2 == null) {
            AppMethodBeat.o(90170);
            return null;
        }
        soElement(eArr, calcWrappedOffset, null);
        soConsumerIndex(1 + j2);
        AppMethodBeat.o(90170);
        return e2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: rx.internal.util.unsafe.SpscUnboundedArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue
    public final E peek() {
        AppMethodBeat.i(90171);
        Object[] objArr = this.consumerBuffer;
        long j2 = this.consumerIndex;
        long j3 = this.consumerMask;
        E e2 = (E) lvElement(objArr, calcWrappedOffset(j2, j3));
        if (e2 == HAS_NEXT) {
            E e3 = (E) newBufferPeek(lvNext(objArr), j2, j3);
            AppMethodBeat.o(90171);
            return e3;
        }
        AppMethodBeat.o(90171);
        return e2;
    }

    private E newBufferPeek(E[] eArr, long j2, long j3) {
        AppMethodBeat.i(90172);
        this.consumerBuffer = eArr;
        E e2 = (E) lvElement(eArr, calcWrappedOffset(j2, j3));
        AppMethodBeat.o(90172);
        return e2;
    }

    public final int size() {
        AppMethodBeat.i(90173);
        long lvConsumerIndex = lvConsumerIndex();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long lvConsumerIndex2 = lvConsumerIndex();
            if (lvConsumerIndex == lvConsumerIndex2) {
                int i2 = (int) (lvProducerIndex - lvConsumerIndex2);
                AppMethodBeat.o(90173);
                return i2;
            }
            lvConsumerIndex = lvConsumerIndex2;
        }
    }

    private void adjustLookAheadStep(int i2) {
        AppMethodBeat.i(90174);
        this.producerLookAheadStep = Math.min(i2 / 4, MAX_LOOK_AHEAD_STEP);
        AppMethodBeat.o(90174);
    }

    private long lvProducerIndex() {
        AppMethodBeat.i(90175);
        long longVolatile = UnsafeAccess.UNSAFE.getLongVolatile(this, P_INDEX_OFFSET);
        AppMethodBeat.o(90175);
        return longVolatile;
    }

    private long lvConsumerIndex() {
        AppMethodBeat.i(90176);
        long longVolatile = UnsafeAccess.UNSAFE.getLongVolatile(this, C_INDEX_OFFSET);
        AppMethodBeat.o(90176);
        return longVolatile;
    }

    private void soProducerIndex(long j2) {
        AppMethodBeat.i(90177);
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, j2);
        AppMethodBeat.o(90177);
    }

    private void soConsumerIndex(long j2) {
        AppMethodBeat.i(90178);
        UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, j2);
        AppMethodBeat.o(90178);
    }

    private static long calcWrappedOffset(long j2, long j3) {
        AppMethodBeat.i(90179);
        long calcDirectOffset = calcDirectOffset(j2 & j3);
        AppMethodBeat.o(90179);
        return calcDirectOffset;
    }

    private static long calcDirectOffset(long j2) {
        return REF_ARRAY_BASE + (j2 << REF_ELEMENT_SHIFT);
    }

    private static void soElement(Object[] objArr, long j2, Object obj) {
        AppMethodBeat.i(90180);
        UnsafeAccess.UNSAFE.putOrderedObject(objArr, j2, obj);
        AppMethodBeat.o(90180);
    }

    private static <E> Object lvElement(E[] eArr, long j2) {
        AppMethodBeat.i(90181);
        Object objectVolatile = UnsafeAccess.UNSAFE.getObjectVolatile(eArr, j2);
        AppMethodBeat.o(90181);
        return objectVolatile;
    }

    @Override // rx.internal.util.unsafe.QueueProgressIndicators
    public long currentProducerIndex() {
        AppMethodBeat.i(90182);
        long lvProducerIndex = lvProducerIndex();
        AppMethodBeat.o(90182);
        return lvProducerIndex;
    }

    @Override // rx.internal.util.unsafe.QueueProgressIndicators
    public long currentConsumerIndex() {
        AppMethodBeat.i(90183);
        long lvConsumerIndex = lvConsumerIndex();
        AppMethodBeat.o(90183);
        return lvConsumerIndex;
    }
}

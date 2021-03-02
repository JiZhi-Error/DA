package rx.internal.util.unsafe;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;

public class MpmcArrayQueue<E> extends MpmcArrayQueueConsumerField<E> {
    long p30;
    long p31;
    long p32;
    long p33;
    long p34;
    long p35;
    long p36;
    long p37;
    long p40;
    long p41;
    long p42;
    long p43;
    long p44;
    long p45;
    long p46;

    public MpmcArrayQueue(int i2) {
        super(Math.max(2, i2));
        AppMethodBeat.i(90140);
        AppMethodBeat.o(90140);
    }

    @Override // rx.internal.util.unsafe.MessagePassingQueue, java.util.Queue
    public boolean offer(E e2) {
        AppMethodBeat.i(90141);
        if (e2 == null) {
            NullPointerException nullPointerException = new NullPointerException("Null is not a valid element");
            AppMethodBeat.o(90141);
            throw nullPointerException;
        }
        long j2 = this.mask + 1;
        long[] jArr = this.sequenceBuffer;
        long j3 = MAlarmHandler.NEXT_FIRE_INTERVAL;
        while (true) {
            long j4 = j3;
            long lvProducerIndex = lvProducerIndex();
            long calcSequenceOffset = calcSequenceOffset(lvProducerIndex);
            long lvSequence = lvSequence(jArr, calcSequenceOffset) - lvProducerIndex;
            if (lvSequence == 0) {
                if (casProducerIndex(lvProducerIndex, 1 + lvProducerIndex)) {
                    spElement(calcElementOffset(lvProducerIndex), e2);
                    soSequence(jArr, calcSequenceOffset, 1 + lvProducerIndex);
                    AppMethodBeat.o(90141);
                    return true;
                }
            } else if (lvSequence < 0 && lvProducerIndex - j2 <= j4) {
                j4 = lvConsumerIndex();
                if (lvProducerIndex - j2 <= j4) {
                    AppMethodBeat.o(90141);
                    return false;
                }
            }
            j3 = j4;
        }
    }

    @Override // rx.internal.util.unsafe.MessagePassingQueue, java.util.Queue
    public E poll() {
        AppMethodBeat.i(90142);
        long[] jArr = this.sequenceBuffer;
        long j2 = -1;
        while (true) {
            long j3 = j2;
            long lvConsumerIndex = lvConsumerIndex();
            long calcSequenceOffset = calcSequenceOffset(lvConsumerIndex);
            long lvSequence = lvSequence(jArr, calcSequenceOffset) - (1 + lvConsumerIndex);
            if (lvSequence == 0) {
                if (casConsumerIndex(lvConsumerIndex, 1 + lvConsumerIndex)) {
                    long calcElementOffset = calcElementOffset(lvConsumerIndex);
                    E lpElement = lpElement(calcElementOffset);
                    spElement(calcElementOffset, null);
                    soSequence(jArr, calcSequenceOffset, this.mask + lvConsumerIndex + 1);
                    AppMethodBeat.o(90142);
                    return lpElement;
                }
            } else if (lvSequence < 0 && lvConsumerIndex >= j3) {
                j3 = lvProducerIndex();
                if (lvConsumerIndex == j3) {
                    AppMethodBeat.o(90142);
                    return null;
                }
            }
            j2 = j3;
        }
    }

    @Override // rx.internal.util.unsafe.MessagePassingQueue, java.util.Queue
    public E peek() {
        long lvConsumerIndex;
        E lpElement;
        AppMethodBeat.i(90143);
        do {
            lvConsumerIndex = lvConsumerIndex();
            lpElement = lpElement(calcElementOffset(lvConsumerIndex));
            if (lpElement != null) {
                break;
            }
        } while (lvConsumerIndex != lvProducerIndex());
        AppMethodBeat.o(90143);
        return lpElement;
    }

    @Override // rx.internal.util.unsafe.MessagePassingQueue
    public int size() {
        AppMethodBeat.i(90144);
        long lvConsumerIndex = lvConsumerIndex();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long lvConsumerIndex2 = lvConsumerIndex();
            if (lvConsumerIndex == lvConsumerIndex2) {
                int i2 = (int) (lvProducerIndex - lvConsumerIndex2);
                AppMethodBeat.o(90144);
                return i2;
            }
            lvConsumerIndex = lvConsumerIndex2;
        }
    }

    @Override // rx.internal.util.unsafe.MessagePassingQueue
    public boolean isEmpty() {
        AppMethodBeat.i(90145);
        if (lvConsumerIndex() == lvProducerIndex()) {
            AppMethodBeat.o(90145);
            return true;
        }
        AppMethodBeat.o(90145);
        return false;
    }
}
